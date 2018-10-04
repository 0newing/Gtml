/*
 *
 * 文件名: GtmlReader.java
 * 描述: 读取Gtml文件的对象
 * 创建人: 0newing
 * 时间: 2018/10/4  14:47
 *
 */
package cn.curatorjin.gtml.parser;

import cn.curatorjin.gtml.utils.GStringUtil;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public class GtmlReader
{

    /**
     * 文件读取对象
     */
    private static SAXReader READER;

    /**
     * 封装元素
     */
    private GElement element;

    static
    {
        READER = new SAXReader();
    }

    /**
     * 读取文件的构造方式
     *
     * @param filePath gtml文件路径
     */
    public GtmlReader(String filePath)
    {

        URL url = GtmlReader.class.getClassLoader().getResource(filePath);
        if (url == null)
        {
            return;
        }
        try
        {
            Document document = READER.read(url);
            Element rootElement = document.getRootElement();
            Element frameNode = (Element)rootElement.node(1);
            element = getGElements(frameNode);
        }
        catch (DocumentException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 递归获取所有GElement
     *
     * @param rootElement 根节点
     * @return 根节点包含的所有元素
     */
    private GElement getGElements(Element rootElement)
    {
        String eleName = rootElement.getName();
        String fullName = GStringUtil.getPackageName(eleName);
        GElement element = null;
        try
        {
            Class clazz = Class.forName(fullName);
            element = (GElement)clazz.newInstance();

            Iterator attributeIterator = rootElement.attributeIterator();
            while (attributeIterator.hasNext())
            {
                Attribute attribute = (Attribute)attributeIterator.next();
                element.putAttribute(attribute);
            }

            Iterator insideElements = rootElement.elementIterator();
            while (insideElements.hasNext())
            {
                Element inEle = (Element)insideElements.next();
                element.addInsideElement(getGElements(inEle));
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return element;
    }

}

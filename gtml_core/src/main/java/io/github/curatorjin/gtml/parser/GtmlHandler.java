/*
 *
 * 文件名: GtmlHandler.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2019/1/30  23:42
 *
 */
package io.github.curatorjin.gtml.parser;

import io.github.curatorjin.gtml.beans.Gframe;
import io.github.curatorjin.gtml.beans.Glabel;
import io.github.curatorjin.gtml.beans.Gpanel;
import io.github.curatorjin.gtml.utils.GtmlConstant;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public class GtmlHandler extends DefaultHandler
{

    /**
     * 解析结果
     */
    private GElement result;

    /**
     * 节点元素处理链
     */
    private LinkedList<GElement> handlerChain = new LinkedList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
        GElement curElement;
        switch (qName)
        {
            case GtmlConstant.FRAME:
                curElement = new Gframe();
                curElement.setAttributes(getAttributes(attributes));
                handlerChain.add(curElement);
                break;
            case GtmlConstant.PANEL:
                curElement = new Gpanel();
                curElement.setAttributes(getAttributes(attributes));
                handlerChain.add(curElement);
                break;
            case GtmlConstant.LABEL:
                curElement = new Glabel();
                curElement.setAttributes(getAttributes(attributes));
                handlerChain.add(curElement);
                break;
            default:
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
    {
        if (handlerChain.size() > 0)
        {
            GElement curNode = handlerChain.removeLast();
            if (handlerChain.size() >0)
            {
                GElement preNode = handlerChain.getLast();
                preNode.addInsideElement(curNode);
            }
            else
            {
                System.out.println(curNode);
            }
        }
    }

    /**
     * 获取属性列表
     *
     * @param attributes 属性集合
     * @return 属性列表
     */
    private Map<String, String> getAttributes(Attributes attributes)
    {
        Map<String, String> map = new HashMap<>();
        int size = attributes.getLength();
        for (int i = 0; i < size; i++)
        {
            map.put(attributes.getQName(i), attributes.getValue(i));
        }
        return map;
    }

}

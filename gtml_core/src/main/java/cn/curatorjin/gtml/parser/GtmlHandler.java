/*
 *
 * 文件名: GtmlHandler.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2019/1/30  23:42
 *
 */
package cn.curatorjin.gtml.parser;

import cn.curatorjin.gtml.utils.GtmlConstant;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public class GtmlHandler extends DefaultHandler
{

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
        switch (qName)
        {
            case GtmlConstant
                .FRAME:
                break;
            default:
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
    {
        System.out.println(uri);
        System.out.println(localName);
        System.out.println(qName);
    }
}

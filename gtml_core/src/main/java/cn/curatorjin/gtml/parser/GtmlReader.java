/*
 *
 * 文件名: GtmlReader.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2019/2/5  12:58
 *
 */
package cn.curatorjin.gtml.parser;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


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
    private static XMLReader READER;

    static
    {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        try
        {
            saxParser = saxParserFactory.newSAXParser();
            READER = saxParser.getXMLReader();
            READER.setContentHandler(new GtmlHandler());
        }
        catch (SAXException | ParserConfigurationException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 递归获取所有GElement
     *
     * @param fileUrl 文件的URL
     */
    public void getGElements(URL fileUrl)
    {
        InputSource inputSource;
        try
        {
            InputStream inputStream = new BufferedInputStream(
                new FileInputStream(new File(fileUrl.getFile())));
            inputSource = new InputSource(inputStream);
            READER.parse(inputSource);
        }
        catch (IOException | SAXException e)
        {
            e.printStackTrace();
        }
    }

}

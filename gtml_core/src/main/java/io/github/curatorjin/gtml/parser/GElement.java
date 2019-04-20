/*
 *
 * 文件名: GElement.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/10/4  14:55
 *
 */
package io.github.curatorjin.gtml.parser;

import org.dom4j.Attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public abstract class GElement
{

    /**
     * 内部元素
     */
    private List<GElement> insideElements = new ArrayList<>();

    /**
     * 属性
     */
    private Map<String, String> attributes = new HashMap<>();

    /**
     * 内容
     */
    private String content;

    /**
     * 获取属性值
     *
     * @param attrName 属性名
     * @return 属性值
     */
    public String getAttribute(String attrName)
    {
        if (attributes == null)
        {
            attributes = new HashMap<>();
        }
        return attributes.get(attrName);
    }

    /**
     * 添加属性
     *
     * @param attribute 属性对象
     */
    void putAttribute(Attribute attribute)
    {
        attributes.put(attribute.getName(), attribute.getValue());
    }

    void setAttributes(Map<String, String> attributes)
    {
        this.attributes = attributes;
    }

    /**
     * 添加内部元素
     * @param element 需添加的元素
     */
    void addInsideElement(GElement element)
    {
        insideElements.add(element);
    }

    /**
     * 展示
     */
    public abstract void show();

    @Override
    public String toString()
    {
        return "GElement{" +
               "insideElements=" + insideElements.toString() +
               ", attributes=" + attributes +
               '}';
    }


}

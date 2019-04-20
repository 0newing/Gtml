/*
 *
 * 文件名: Glabel.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/10/4  15:05
 *
 */
package io.github.curatorjin.gtml.beans;

import io.github.curatorjin.gtml.parser.GElement;

import javax.swing.JLabel;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : ${VERSION}
 */
public class Glabel extends GElement
{

    /**
     * 封装JLabel
     */
    private JLabel packedLable;

    public JLabel getPackedLable()
    {
        return packedLable;
    }

    public void setPackedLable(JLabel packedLable)
    {
        this.packedLable = packedLable;
    }

    @Override
    public void show()
    {

    }
}

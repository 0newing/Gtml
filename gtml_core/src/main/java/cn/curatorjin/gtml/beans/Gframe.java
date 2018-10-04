/*
 *
 * 文件名: Gframe.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/10/4  14:54
 *
 */
package cn.curatorjin.gtml.beans;

import cn.curatorjin.gtml.parser.GElement;

import javax.swing.JFrame;

/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public class Gframe extends GElement
{

    /**
     * 封装JFrame
     */
    private JFrame packedFrame;

    public JFrame getPackedFrame()
    {
        return packedFrame;
    }

    public void setPackedFrame(JFrame packedFrame)
    {
        this.packedFrame = packedFrame;
    }

}

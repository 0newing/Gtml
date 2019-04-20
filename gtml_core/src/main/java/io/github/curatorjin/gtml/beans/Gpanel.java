/*
 *
 * 文件名: Gpanel.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/10/4  15:05
 *
 */
package io.github.curatorjin.gtml.beans;

import io.github.curatorjin.gtml.parser.GElement;

import javax.swing.JPanel;


/**
 * GPanel元素
 *
 * @author : 0newing
 * @version : 1.0
 */
public class Gpanel extends GElement
{

    /**
     * 封装JPanel
     */
    private JPanel packedPanel;

    public JPanel getPackedPanel()
    {
        return packedPanel;
    }

    public void setPackedPanel(JPanel packedPanel)
    {
        this.packedPanel = packedPanel;
    }

    @Override
    public void show()
    {

    }
}

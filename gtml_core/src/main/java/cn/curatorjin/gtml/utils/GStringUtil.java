/*
 *
 * 文件名: GStringUtil.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/10/4  15:14
 *
 */
package cn.curatorjin.gtml.utils;

/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public final class GStringUtil
{
    private GStringUtil(){}

    /**
     * 获取类名
     * @param name 节点名
     * @return 类的全类名
     */
    public static String getPackageName(String name)
    {
        String sb = "cn.curatorjin.gtml.beans.G";
        return sb + name;
    }
}

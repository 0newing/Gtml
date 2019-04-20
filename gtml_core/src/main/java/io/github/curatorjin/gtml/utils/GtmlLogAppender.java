/*
 *
 * 文件名: GtmlLogAppender.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/9/28  21:23
 *
 */
package io.github.curatorjin.gtml.utils;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;


/**
 * 重写日志输出的方式，只输出指定级别
 *
 * @author : 0newing
 * @version : 1.0
 */
public final class GtmlLogAppender extends DailyRollingFileAppender
{

    @Override
    public boolean isAsSevereAsThreshold(Priority priority)
    {
        return this.getThreshold().equals(priority);
    }
}

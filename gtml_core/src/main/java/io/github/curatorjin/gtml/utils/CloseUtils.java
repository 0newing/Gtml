/*
 *
 * 文件名: CloseUtils.java
 * 描述: 用于关闭对象
 * 创建人: 0newing
 * 时间: 2018/9/28  19:57
 *
 */
package io.github.curatorjin.gtml.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;


/**
 * For closing Closable
 *
 * @author : 0newing
 * @version : 1.0
 */
public final class CloseUtils
{

    /**
     * 日志输出
     */
    private static Logger LOGGER = LoggerFactory.getLogger("CloseUtil");

    private CloseUtils()
    {
    }

    /**
     * 用于关闭需要关闭的对象
     *
     * @param closeable 需要关闭的对象
     */
    public static void closeObject(Closeable closeable)
    {
        if (closeable != null)
        {
            String message = "close complete";
            try
            {
                closeable.close();
            }
            catch (IOException e)
            {
                LOGGER.error("close failed, {}",e.getMessage());
            }

            LOGGER.info(message);
        }
        else
        {
            LOGGER.info("No need to close");
        }
    }
}

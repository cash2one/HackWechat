package org.xwalk.core;

import com.tencent.xweb.util.b;

public class Log {
    private static b m_log_callback = null;

    public static void SetLogCallBack(b bVar) {
        m_log_callback = bVar;
    }

    public static void f(String str, String str2) {
        if (m_log_callback != null) {
            m_log_callback.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (m_log_callback != null) {
            m_log_callback.e(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (m_log_callback != null) {
            m_log_callback.e(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (m_log_callback != null) {
            m_log_callback.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (m_log_callback != null) {
            m_log_callback.w(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (m_log_callback != null) {
            m_log_callback.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (m_log_callback != null) {
            m_log_callback.d(str, str2);
        }
    }

    public static void v(String str, String str2) {
        if (m_log_callback != null) {
            m_log_callback.v(str, str2);
        }
    }
}

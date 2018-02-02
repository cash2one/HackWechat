package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;

public class TXLog {
    public static void d(String str, String str2) {
        wrietLogMessage(1, str, str2);
    }

    public static void i(String str, String str2) {
        wrietLogMessage(2, str, str2);
    }

    public static void w(String str, String str2) {
        wrietLogMessage(3, str, str2);
    }

    public static void e(String str, String str2) {
        wrietLogMessage(4, str, str2);
    }

    private static void wrietLogMessage(int i, String str, String str2) {
        TXCLog.log(i, str, "thread ID:" + Thread.currentThread().getId() + "|line:-1|" + str2);
    }
}

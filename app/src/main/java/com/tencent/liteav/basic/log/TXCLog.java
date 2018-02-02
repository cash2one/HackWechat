package com.tencent.liteav.basic.log;

import android.os.Environment;
import com.tencent.liteav.basic.util.a;

public class TXCLog {
    public static final int LOG_ASYNC = 0;
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 4;
    public static final int LOG_FATAL = 5;
    public static final int LOG_INFO = 2;
    public static final int LOG_NONE = 6;
    public static final int LOG_SYNC = 1;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARNING = 3;
    private static boolean mHasInit = false;
    private static a mListener = null;
    private static final Object mLogLock = new Object();

    private static native void nativeLog(int i, String str, String str2, int i2, String str3, String str4);

    private static native void nativeLogClose();

    private static native void nativeLogInit();

    private static native void nativeLogOpen(int i, String str, String str2);

    private static native void nativeLogSetConsole(boolean z);

    private static native void nativeLogSetLevel(int i);

    static {
        a.d();
    }

    public static void init() {
        synchronized (mLogLock) {
            if (!mHasInit) {
                String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/log/tencent/liteav";
                nativeLogInit();
                nativeLogSetLevel(0);
                nativeLogSetConsole(true);
                nativeLogOpen(0, str, "LiteAV");
                mHasInit = true;
            }
        }
    }

    public static void log(int i, String str, String str2) {
        init();
        nativeLog(i, str, "", 0, "", str2);
        log_callback(i, str, str2);
    }

    public static void setLevel(int i) {
        init();
        nativeLogSetLevel(i);
    }

    public static void setConsoleEnabled(boolean z) {
        init();
        nativeLogSetConsole(z);
    }

    public static void setListener(a aVar) {
        mListener = aVar;
    }

    public static void v(String str, String str2) {
        log(0, str, str2);
    }

    public static void d(String str, String str2) {
        log(1, str, str2);
    }

    public static void i(String str, String str2) {
        log(2, str, str2);
    }

    public static void w(String str, String str2) {
        log(3, str, str2);
    }

    public static void e(String str, String str2) {
        log(4, str, str2);
    }

    private static void log_callback(int i, String str, String str2) {
        if (mListener != null) {
            mListener.a(i, str, str2);
        }
    }
}

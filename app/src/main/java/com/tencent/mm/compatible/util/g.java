package com.tencent.mm.compatible.util;

import android.os.SystemClock;

public final class g {

    public static class a {
        public long gHJ = SystemClock.elapsedRealtime();

        public final long zi() {
            return SystemClock.elapsedRealtime() - this.gHJ;
        }
    }

    public static int getLine() {
        return new Throwable().getStackTrace()[1].getLineNumber();
    }

    public static String zg() {
        return new Throwable().getStackTrace()[1].toString();
    }

    public static String zh() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return stackTraceElement.getMethodName().substring(stackTraceElement.getMethodName().lastIndexOf(46) + 1) + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }
}

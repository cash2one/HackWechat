package com.tencent.liteav.basic.util;

public class TXCTimeUtil {
    private static native long nativeGetTimeTick();

    private static native long nativeGetUtcTimeTick();

    public static long getTimeTick() {
        return nativeGetTimeTick();
    }

    public static long getUtcTimeTick() {
        return nativeGetUtcTimeTick();
    }

    static {
        a.d();
    }
}

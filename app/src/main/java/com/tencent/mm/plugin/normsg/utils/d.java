package com.tencent.mm.plugin.normsg.utils;

import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static boolean oTz;

    static {
        oTz = false;
        long nanoTime = System.nanoTime();
        try {
            oTz = NativeLogic.bgh();
            x.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[]{Boolean.valueOf(oTz), Long.valueOf(System.nanoTime() - nanoTime)});
        } catch (Throwable th) {
            x.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[]{Boolean.valueOf(oTz), Long.valueOf(System.nanoTime() - nanoTime)});
        }
    }
}

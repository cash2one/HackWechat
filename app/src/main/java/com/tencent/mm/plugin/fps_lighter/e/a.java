package com.tencent.mm.plugin.fps_lighter.e;

import java.util.concurrent.TimeUnit;

public final class a {
    public static int b(long j, float f) {
        long convert = TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS);
        if (((float) convert) > f) {
            return (int) Math.floor((double) (((float) convert) / f));
        }
        return 0;
    }

    public static a pP(int i) {
        a aVar = a.mBN;
        if (i >= 16) {
            return a.mBL;
        }
        if (i >= 8) {
            return a.mBM;
        }
        if (i >= 4) {
            return a.mBK;
        }
        if (i > 1) {
            return a.mBJ;
        }
        return aVar;
    }
}

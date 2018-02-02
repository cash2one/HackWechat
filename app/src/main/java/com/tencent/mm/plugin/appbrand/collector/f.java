package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class f {
    private static final AtomicInteger iLN = new AtomicInteger();
    private static final AtomicLong iLO = new AtomicLong();
    private static boolean iLP;

    public static void bE(long j) {
        if (iLP && j > 0) {
            x.v("MicroMsg.FPSCollector", "collect(cost : %s)", Long.valueOf(j));
            iLO.addAndGet(j);
            iLN.getAndIncrement();
        }
    }

    public static void reset() {
        iLN.set(0);
        iLO.set(0);
    }

    public static void ct(boolean z) {
        iLP = z;
    }

    public static boolean abr() {
        return iLP;
    }

    public static String abs() {
        float f = 0.0f;
        int i = iLN.get();
        long j = iLO.get();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("fps : ");
        int i2 = iLN.get();
        long j2 = iLO.get();
        float f2 = (!iLP || j2 <= 0) ? 0.0f : (((float) i2) * 1000.0f) / ((float) j2);
        append.append(f2);
        stringBuilder.append("\ncount : ").append(i);
        StringBuilder append2 = stringBuilder.append("\naverage cost : ");
        if (i > 0) {
            f = (1.0f * ((float) j)) / ((float) i);
        }
        append2.append(f);
        return stringBuilder.toString();
    }
}

package com.tencent.mm.wallet_core.c;

import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class n {
    private static long kNw = 0;
    private static String sMr = "";
    private static String zHB = "";

    public static void setTimeStamp(String str) {
        sMr = str;
        kNw = System.currentTimeMillis() / 1000;
        zHB = bh.cgy().toString();
    }

    public static boolean cBq() {
        long by = bh.by(kNw);
        x.d("MicroMsg.TimeStampHelper", "pass time " + by);
        return by > 300;
    }

    public static String cBr() {
        if (bh.ov(sMr) || b.ceK()) {
            x.i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", new Object[]{zHB, Boolean.valueOf(cBq()), Long.valueOf(kNw)});
        }
        return sMr;
    }
}

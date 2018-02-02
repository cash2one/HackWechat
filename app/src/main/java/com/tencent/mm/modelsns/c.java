package com.tencent.mm.modelsns;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static int hOQ = 0;
    public static c hOR = new c();

    public static void Sy() {
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100024");
        x.i("MicroMsg.StatisticsOplogAbTest", "test " + fn.field_rawXML + " " + fn.isValid());
        if (fn.isValid()) {
            hOQ = bh.VI((String) fn.chI().get("Switch"));
            x.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + hOQ);
        }
    }
}

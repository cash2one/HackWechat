package com.tencent.mm.plugin.wenote.b;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.c.c;

public final class a {
    public static boolean bXD() {
        int i;
        String str = (String) c.IF().fn("100352").chI().get("Close");
        if (bh.ov(str)) {
            i = 0;
        } else {
            i = bh.getInt(str, 0);
        }
        return i == 0;
    }
}

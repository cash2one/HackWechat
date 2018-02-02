package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class e {
    public static void KO(String str) {
        x.i("MicroMsg.SnsABTestStrategy", "dump id " + str);
        c fn = com.tencent.mm.z.c.c.IF().fn(str);
        if (!fn.isValid()) {
            x.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
        }
        if (fn.chI() != null) {
            x.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + fn.field_rawXML);
        }
    }
}

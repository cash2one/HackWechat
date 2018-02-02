package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public class a extends ak {
    private static int lyq = 0;
    private static a lyr;
    private static q lys;
    private static e lyt = new 1();

    public static final a aBJ() {
        if (lyr == null) {
            synchronized (a.class) {
                if (lyr == null) {
                    lyr = new a();
                }
            }
        } else {
            lyr.TG();
        }
        return lyr;
    }

    public static void aBK() {
        lyq = 0;
        lys = new q("com.tencent.xin.emoticon.tusiji", 1);
        ar.CG().a(lys, 0);
        ar.CG().a(413, lyt);
        x.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
    }

    public final void aBL() {
        TG();
        i.aBG().f(com.tencent.mm.plugin.emoji.h.a.aDB(), 3, lyq, "");
        aBM();
    }

    public static void aBM() {
        if (lys != null) {
            ar.CG().c(lys);
        }
        ar.CG().b(413, lyt);
        x.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
    }

    private a() {
        super(new a(), true);
    }
}

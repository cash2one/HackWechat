package com.tencent.mm.booter;

import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ac;
import com.tencent.mm.z.ad;
import java.util.ArrayList;
import java.util.List;

public class a implements ac {
    private static volatile a gxK;
    private aq gxI = new aq();
    private com.tencent.mm.sdk.platformtools.aq.a gxJ = new 1(this);
    private List<ad> gxL = new ArrayList();
    private c gxM;

    private a() {
        this.gxI.a(this.gxJ);
        this.gxI.eV(com.tencent.mm.sdk.platformtools.ac.getContext());
        if (this.gxM == null) {
            this.gxM = new 2(this);
        }
        com.tencent.mm.sdk.b.a.xef.b(this.gxM);
    }

    public static a wz() {
        if (gxK == null) {
            synchronized (a.class) {
                if (gxK == null) {
                    gxK = new a();
                }
            }
        }
        return gxK;
    }

    public final void a(ad adVar) {
        if (adVar != null) {
            x.d("MicroMsg.BackgroundPlayer", "add callback : %s", adVar.toString());
            this.gxL.add(adVar);
        }
    }

    public final void b(ad adVar) {
        if (adVar != null) {
            this.gxL.remove(adVar);
        }
    }

    public final void wA() {
        if (this.gxL != null) {
            for (ad GO : this.gxL) {
                GO.GO();
            }
        }
    }

    public final void wB() {
        if (this.gxL != null) {
            for (ad GP : this.gxL) {
                GP.GP();
            }
        }
    }
}

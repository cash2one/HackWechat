package com.tencent.mm.ag;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.LinkedList;

public final class k {
    private a gyF;
    int hpN;
    private c hpO;
    private int hpP;
    int hpQ;
    boolean hpR;
    b hpS;
    String userName;

    protected k() {
        this.userName = null;
        this.hpN = 0;
        this.hpP = 2;
        this.hpQ = 10;
        this.hpR = false;
        this.hpS = new 1(this);
        this.gyF = new 2(this);
        this.hpQ = bh.getInt(((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zZ().F("BrandService", "continueLocationReportInterval"), 5);
        if (this.hpQ < this.hpP) {
            this.hpQ = this.hpP;
        }
        x.i("MicroMsg.ReportLocation", "reportLocation interval %d", new Object[]{Integer.valueOf(this.hpQ)});
    }

    public final void b(String str, au auVar) {
        if (auVar == null || !auVar.ciV()) {
            a(str, 10, 0, 0.0f, 0.0f, 0, null);
        } else {
            g.Dm().F(new 3(this, auVar, str));
        }
    }

    public static void kd(String str) {
        a(str, 12, 0, 0.0f, 0.0f, 0, null);
    }

    public final void ke(String str) {
        x.i("MicroMsg.ReportLocation", "Start report");
        this.userName = str;
        d jS = f.jS(str);
        if (jS != null) {
            if (this.hpN != 0) {
                LY();
            }
            this.hpN = 0;
            if (jS.KY()) {
                x.i("MicroMsg.ReportLocation", "need update contact %s", new Object[]{str});
                com.tencent.mm.ad.b.iX(str);
            }
            d.b bI = jS.bI(false);
            if (bI == null) {
                return;
            }
            if (bI.La() && jS.KX()) {
                this.hpO = c.OP();
                bI = jS.bI(false);
                if (bI.hou != null) {
                    boolean z;
                    if (bh.getInt(bI.hou.optString("ReportLocationType"), 0) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bI.hoH = z;
                }
                this.hpN = bI.hoH ? 3 : 2;
                if (c.OQ() || c.OR()) {
                    this.hpO.a(this.gyF, true);
                } else {
                    a(str, 11, 2, 0.0f, 0.0f, 0, null);
                }
            } else if (bI.La() && !jS.KX()) {
                a(str, 11, 1, 0.0f, 0.0f, 0, null);
            }
        }
    }

    public final void LY() {
        x.i("MicroMsg.ReportLocation", "Stop report");
        this.hpN = 0;
        if (this.hpO != null) {
            this.hpO.c(this.gyF);
        }
        if (g.Dh().Cy()) {
            ((h) g.h(h.class)).EY().b(this.hpS);
        }
    }

    private static void a(String str, int i, int i2, float f, float f2, int i3, LinkedList<oc> linkedList) {
        String str2;
        if (i2 == 3) {
            str2 = "<event></event>";
        } else {
            str2 = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[]{Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i3)});
        }
        x.i("MicroMsg.ReportLocation", "doScene, info: %s", new Object[]{str2});
        g.Di().gPJ.a(new q(str, i, str2, linkedList), 0);
    }
}

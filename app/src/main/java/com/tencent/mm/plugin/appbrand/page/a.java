package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class a {
    private static final a jCh = new 1();
    private static final HashMap<e, a> jCi = new HashMap();
    private final e irF;
    private int jCj;
    private int jCk;
    private a jCl;

    static void c(p pVar) {
        if (pVar != null) {
            a q = q(pVar.irP);
            x.i("MicroMsg.AppBrandActionBarSubTitleHintHelper", "applyToUpcomingPage, textId: %d, status: %s", new Object[]{Integer.valueOf(q.jCk), q.jCl});
            pVar.kj(q.jCk);
            pVar.jDN.b(q.jCl);
        }
    }

    public static a q(e eVar) {
        if (eVar == null) {
            return jCh;
        }
        a aVar = (a) jCi.get(eVar);
        if (aVar != null) {
            return aVar;
        }
        aVar = new a(eVar);
        jCi.put(eVar, aVar);
        return aVar;
    }

    private a(final e eVar) {
        this.jCj = 0;
        this.jCl = a.jCo;
        this.irF = eVar;
        if (eVar != null) {
            c.a(eVar.mAppId, new b(this) {
                final /* synthetic */ a jCm;

                public final void onDestroy() {
                    a.jCi.remove(eVar);
                }
            });
        }
    }

    public final int a(a aVar) {
        int i = 0;
        switch (3.jCn[aVar.ordinal()]) {
            case 1:
                i = j.izO;
                break;
            case 3:
                i = j.izP;
                break;
        }
        return a(i, aVar);
    }

    public int a(int i, a aVar) {
        try {
            x.i("MicroMsg.AppBrandActionBarSubTitleHintHelper", "blinkSubTitle, status: %s", new Object[]{aVar});
            this.irF.iqC.aiT().aex().kj(i);
            this.irF.iqC.aiT().aex().jDN.b(aVar);
            this.jCk = i;
            this.jCl = aVar;
            int i2 = this.jCj + 1;
            this.jCj = i2;
            return i2;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public void la(int i) {
        x.i("MicroMsg.AppBrandActionBarSubTitleHintHelper", "dismissBlink, seq: %d, currentSeq: %d, status: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(this.jCj), this.jCl});
        if (i == this.jCj) {
            try {
                this.irF.iqC.aiT().aex().kj(0);
                p.runOnUiThread(new p$18(this.irF.iqC.aiT().aex(), a.jCo));
            } catch (NullPointerException e) {
            }
            this.jCk = 0;
            this.jCl = a.jCo;
        }
    }
}

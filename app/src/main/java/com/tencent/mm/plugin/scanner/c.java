package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import com.tencent.mm.by.h.d;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.ac.a.b;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.plugin.scanner.a.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.io.File;
import java.util.HashMap;

public final class c implements ap {
    private static HashMap<Integer, d> gwY;
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, d> kHz = new HashMap();
    public String gQi;
    private a kHB;
    public b pSf = new b();
    private j pSg = new j();
    private n pSh = new n();
    private m pSi = new m();
    private com.tencent.mm.plugin.scanner.history.a.b pSj;
    private com.tencent.mm.plugin.scanner.a.b pSk = new com.tencent.mm.plugin.scanner.a.b();

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new 2());
    }

    public static c boA() {
        ar.Ha();
        c cVar = (c) bp.hY("plugin.scanner");
        if (cVar != null) {
            return cVar;
        }
        Object cVar2 = new c();
        ar.Ha().a("plugin.scanner", cVar2);
        return cVar2;
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xef.c(this.pSg);
        com.tencent.mm.sdk.b.a.xef.c(this.pSh.pTk);
        com.tencent.mm.sdk.b.a.xef.c(this.pSh.pTl);
        com.tencent.mm.sdk.b.a.xef.c(this.pSi);
        com.tencent.mm.plugin.scanner.a.b bVar = this.pSk;
        com.tencent.mm.sdk.b.a.xef.c(bVar.pSH);
        com.tencent.mm.sdk.b.a.xef.c(bVar.pSI);
        bVar.boC();
        b bVar2 = this.pSf;
        bVar2.hCK.clear();
        bVar2.puU.clear();
        bVar2.puV.clear();
        if (this.kHB != null) {
            this.kHB.iV(hashCode());
            this.kHB = null;
        }
        this.gQi = "";
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        this.kHB = g.a(hashCode(), stringBuilder.append(com.tencent.mm.z.c.FB()).append("CommonOneMicroMsg.db").toString(), kHz, false);
        com.tencent.mm.plugin.scanner.a.b bVar = this.pSk;
        com.tencent.mm.sdk.b.a.xef.b(bVar.pSH);
        com.tencent.mm.sdk.b.a.xef.b(bVar.pSI);
        com.tencent.mm.sdk.b.a.xef.b(this.pSg);
        com.tencent.mm.sdk.b.a.xef.b(this.pSh.pTk);
        com.tencent.mm.sdk.b.a.xef.b(this.pSh.pTl);
        com.tencent.mm.sdk.b.a.xef.a(this.pSi);
        ar.Dm().F(new Runnable(this) {
            final /* synthetic */ c pSl;

            {
                this.pSl = r1;
            }

            public final void run() {
                if (!ar.Hj()) {
                    return;
                }
                if (bh.ov(this.pSl.gQi)) {
                    x.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
                } else {
                    bh.g(this.pSl.gQi + "image/scan/img", "scanbook", 604800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
    }

    public final void br(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("onSdcardMount ");
        ar.Hg();
        x.d("MicroMsg.scanner.SubCoreScanner", stringBuilder.append(com.tencent.mm.z.c.FC()).toString());
        c boA = boA();
        ar.Hg();
        String FC = com.tencent.mm.z.c.FC();
        x.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : " + FC);
        boA.gQi = FC;
        File file = new File(FC);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(FC + "image/scan/img");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(FC + "image/scan/music");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String FC() {
        return boA().gQi;
    }

    public final String dS(String str, String str2) {
        if (!ar.Hj() || bh.ov(str)) {
            return "";
        }
        return String.format("%s/scanbook%s_%s", new Object[]{this.gQi + "image/scan/img", str2, com.tencent.mm.a.g.s(str.getBytes())});
    }

    public static com.tencent.mm.plugin.scanner.history.a.b boB() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (boA().pSj == null) {
            c boA = boA();
            ar.Hg();
            boA.pSj = new com.tencent.mm.plugin.scanner.history.a.b(com.tencent.mm.z.c.EV());
        }
        return boA().pSj;
    }
}

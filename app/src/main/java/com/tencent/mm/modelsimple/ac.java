package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.h;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Iterator;

public final class ac extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public final boolean hOh;

    public ac(String str) {
        this(str, 0);
    }

    public ac(String str, int i) {
        this(str, i, (byte) 0);
    }

    private ac(String str, int i, byte b) {
        this(str, 1, i, false);
    }

    public ac(String str, int i, int i2, boolean z) {
        this.hOh = z;
        a aVar = new a();
        aVar.hmj = new bel();
        aVar.hmk = new bem();
        aVar.uri = "/cgi-bin/micromsg-bin/searchcontact";
        aVar.hmi = 106;
        aVar.hml = 34;
        aVar.hmm = 1000000034;
        this.gJQ = aVar.JZ();
        x.d("MicroMsg.NetSceneSearchContact", "search username [%s]", str);
        bel com_tencent_mm_protocal_c_bel = (bel) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bel.vYI = new bdo().UA(str);
        com_tencent_mm_protocal_c_bel.wES = i;
        com_tencent_mm_protocal_c_bel.wJV = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 106;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bem com_tencent_mm_protocal_c_bem = (bem) this.gJQ.hmh.hmo;
        h hVar;
        if (com_tencent_mm_protocal_c_bem != null && com_tencent_mm_protocal_c_bem.wkk > 0) {
            Iterator it = com_tencent_mm_protocal_c_bem.wkl.iterator();
            while (it.hasNext()) {
                bek com_tencent_mm_protocal_c_bek = (bek) it.next();
                x.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", com_tencent_mm_protocal_c_bek.vYI);
                hVar = new h();
                hVar.username = n.a(com_tencent_mm_protocal_c_bek.vYI);
                hVar.hly = com_tencent_mm_protocal_c_bek.vUU;
                hVar.hlx = com_tencent_mm_protocal_c_bek.vUV;
                hVar.fDt = -1;
                x.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.JG(), hVar.JH());
                hVar.fWe = 3;
                hVar.bA(true);
                com.tencent.mm.ad.n.JQ().a(hVar);
            }
        } else if (!(com_tencent_mm_protocal_c_bem == null || bh.ov(n.a(com_tencent_mm_protocal_c_bem.vYI)))) {
            String a = n.a(com_tencent_mm_protocal_c_bem.vYI);
            hVar = new h();
            hVar.username = a;
            hVar.hly = com_tencent_mm_protocal_c_bem.vUU;
            hVar.hlx = com_tencent_mm_protocal_c_bem.vUV;
            hVar.fDt = -1;
            x.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.JG(), hVar.JH());
            hVar.fWe = 3;
            hVar.bA(true);
            com.tencent.mm.ad.n.JQ().a(hVar);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final bem So() {
        bem com_tencent_mm_protocal_c_bem = (bem) this.gJQ.hmh.hmo;
        if (com_tencent_mm_protocal_c_bem != null) {
            Iterator it = com_tencent_mm_protocal_c_bem.wkl.iterator();
            while (it.hasNext()) {
                bek com_tencent_mm_protocal_c_bek = (bek) it.next();
                ar.Hg();
                c.FI().fB(com_tencent_mm_protocal_c_bek.vYI.wJF, com_tencent_mm_protocal_c_bek.whR);
            }
        }
        return com_tencent_mm_protocal_c_bem;
    }
}

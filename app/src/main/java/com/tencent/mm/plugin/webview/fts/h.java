package com.tencent.mm.plugin.webview.fts;

import android.os.Build.VERSION;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.aj.a.a;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.aj.a.f;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.protocal.c.bzp;
import com.tencent.mm.protocal.c.bzq;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends a implements k {
    private b gJQ;
    private e gJT;
    private d hjF;

    public h(d dVar) {
        boolean z = true;
        this.hjF = dVar;
        this.tjM = dVar.fod;
        this.wn = dVar.offset;
        this.irz = dVar.scene;
        this.tjL = dVar.fDl;
        this.hjF = dVar;
        this.tjO = dVar.tkh;
        b.a aVar = new b.a();
        aVar.hmi = 1943;
        aVar.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        aVar.hmj = new bzp();
        aVar.hmk = new bzq();
        this.gJQ = aVar.JZ();
        bzp com_tencent_mm_protocal_c_bzp = (bzp) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bzp.vNW = dVar.offset;
        com_tencent_mm_protocal_c_bzp.wwH = g.zN(1);
        com_tencent_mm_protocal_c_bzp.wIL = dVar.tjP;
        com_tencent_mm_protocal_c_bzp.wgS = dVar.fod;
        com_tencent_mm_protocal_c_bzp.wwI = g.Je();
        com_tencent_mm_protocal_c_bzp.rYW = dVar.scene;
        com_tencent_mm_protocal_c_bzp.vPs = dVar.lEK;
        com_tencent_mm_protocal_c_bzp.wZl = dVar.tjR;
        com_tencent_mm_protocal_c_bzp.wYe = dVar.tjW;
        or orVar = new or();
        orVar.aAM = "client_system_version";
        orVar.vXx = (long) VERSION.SDK_INT;
        dVar.tka.add(orVar);
        com_tencent_mm_protocal_c_bzp.wZm = dVar.tka;
        com_tencent_mm_protocal_c_bzp.wYh = dVar.fqu;
        this.tjN = dVar.hKZ;
        int i = dVar.scene;
        String str = dVar.fqu;
        String str2 = dVar.tjs;
        String str3 = dVar.lEK;
        int i2 = dVar.offset;
        if (dVar.tjP != 1) {
            z = false;
        }
        f.a(i, str, str2, str3, i2, z, dVar.hKZ, dVar.fod, dVar.hKY, dVar.tkg);
    }

    public final int getType() {
        return 1943;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        com.tencent.mm.bc.g.bk(this.irz, 2);
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        boolean z = i2 == 0 && i3 == 0;
        f.a(this.hjF.scene, this.hjF.fqu, this.hjF.tjs, this.hjF.lEK, this.hjF.offset, this.hjF.tjP == 1, this.hjF.hKZ, z, this.hjF.fod, this.hjF.hKY, this.hjF.tkg);
        if (i3 == -1) {
            com.tencent.mm.bc.g.bk(this.irz, 4);
        } else if (i2 == 0 && i3 == 0) {
            com.tencent.mm.bc.g.bk(this.irz, 3);
        } else {
            com.tencent.mm.bc.g.bk(this.irz, 8);
        }
        this.gJT.a(i2, i3, str, this);
    }

    private bzq bPj() {
        return (bzq) this.gJQ.hmh.hmo;
    }

    public final String Jc() {
        return bPj() != null ? bPj().vOe : "";
    }

    public final int Jd() {
        return bPj() != null ? bPj().wYn : 0;
    }
}

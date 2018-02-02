package com.tencent.mm.modelappbrand;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.aj.a.b;
import com.tencent.mm.protocal.c.bxl;
import com.tencent.mm.protocal.c.bxm;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class n extends b implements k {
    private e gOB;
    private com.tencent.mm.ae.b hjD;
    private bxm hjG;

    public n(String str, int i, int i2) {
        this.iRL = str;
        this.irz = i;
        this.tjL = i2;
        if (bh.ov(str)) {
            x.e("MicroMsg.NetSceneWeAppSuggest", "keyword is unavailable");
            return;
        }
        x.i("MicroMsg.NetSceneWeAppSuggest", "Constructors: query = %s", str);
        a aVar = new a();
        aVar.hmi = 1173;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchsuggestion";
        aVar.hmj = new bxl();
        aVar.hmk = new bxm();
        this.hjD = aVar.JZ();
        bxl com_tencent_mm_protocal_c_bxl = (bxl) this.hjD.hmg.hmo;
        com_tencent_mm_protocal_c_bxl.fDj = str;
        com.tencent.mm.sdk.b.b hwVar = new hw();
        com.tencent.mm.sdk.b.a.xef.m(hwVar);
        com_tencent_mm_protocal_c_bxl.wYd = hwVar.fyo.fyp;
        ar.Hg();
        Object obj = c.CU().get(w.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
        if (obj != null && (obj instanceof String)) {
            com_tencent_mm_protocal_c_bxl.wYo = (String) obj;
        }
        com_tencent_mm_protocal_c_bxl.wYh = b.hjx;
        com_tencent_mm_protocal_c_bxl.wYi = b.hjy;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneWeAppSuggest", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.hjG = (bxm) this.hjD.hmh.hmo;
            if (this.hjG != null) {
                x.v("MicroMsg.NetSceneWeAppSuggest", "return data\n%s", this.hjG.vOe);
            }
            this.gOB.a(i2, i3, str, this);
            return;
        }
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1173;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.hjD, this);
    }

    public final String Jc() {
        return this.hjG != null ? this.hjG.vOe : "";
    }
}

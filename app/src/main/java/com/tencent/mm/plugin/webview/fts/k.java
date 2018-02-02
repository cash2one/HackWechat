package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.aj.a.b;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.protocal.c.bzv;
import com.tencent.mm.protocal.c.bzw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class k extends b implements com.tencent.mm.network.k {
    private e gJT;
    private com.tencent.mm.ae.b hFi;
    d hjF;
    private bzw tmL;

    public k(d dVar) {
        this.hjF = dVar;
        this.iRL = dVar.fod;
        this.irz = dVar.scene;
        this.tjL = dVar.fDl;
        if (bh.ov(dVar.fod)) {
            x.e("MicroMsg.FTS.NetSceneWebSuggest", "keyword is unavailable");
            return;
        }
        x.i("MicroMsg.FTS.NetSceneWebSuggest", "Constructors: query=%s", new Object[]{dVar.fod});
        a aVar = new a();
        aVar.hmi = 1161;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
        aVar.hmj = new bzv();
        aVar.hmk = new bzw();
        this.hFi = aVar.JZ();
        bzv com_tencent_mm_protocal_c_bzv = (bzv) this.hFi.hmg.hmo;
        com_tencent_mm_protocal_c_bzv.wgS = dVar.fod;
        com_tencent_mm_protocal_c_bzv.vPp = (long) dVar.hKY;
        com_tencent_mm_protocal_c_bzv.wYd = g.zN(0);
        com_tencent_mm_protocal_c_bzv.wIL = dVar.tjP;
        com_tencent_mm_protocal_c_bzv.wwI = g.Je();
        com_tencent_mm_protocal_c_bzv.rYW = dVar.scene;
        com_tencent_mm_protocal_c_bzv.wYh = dVar.fqu;
        if (dVar.tke != null) {
            try {
                com_tencent_mm_protocal_c_bzv.wZx = new com.tencent.mm.bq.b(dVar.tke.toByteArray());
            } catch (Exception e) {
            }
        }
        if (dVar.tkd != null) {
            try {
                com_tencent_mm_protocal_c_bzv.wZw = new com.tencent.mm.bq.b(dVar.tkd.toByteArray());
            } catch (IOException e2) {
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(dVar.tjV);
            com_tencent_mm_protocal_c_bzv.wZu = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                com_tencent_mm_protocal_c_bzv.wZu.add(URLDecoder.decode(jSONArray.getString(i), "UTF-8"));
            }
        } catch (Throwable e3) {
            x.printErrStackTrace("MicroMsg.FTS.NetSceneWebSuggest", e3, "decode json error", new Object[0]);
        }
        String str = "MicroMsg.FTS.NetSceneWebSuggest";
        String str2 = "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(dVar.hKY);
        objArr[1] = Boolean.valueOf(com_tencent_mm_protocal_c_bzv.wwI != null);
        objArr[2] = Integer.valueOf(dVar.scene);
        objArr[3] = Integer.valueOf(dVar.hKY);
        objArr[4] = Integer.valueOf(dVar.tjP);
        objArr[5] = Integer.valueOf(dVar.fDl);
        x.i(str, str2, objArr);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.tmL = (bzw) this.hFi.hmh.hmo;
            if (this.tmL != null) {
                x.v("MicroMsg.FTS.NetSceneWebSuggest", "return data\n%s", new Object[]{this.tmL.vOe});
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1161;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final String Jc() {
        return this.tmL != null ? this.tmL.vOe : "";
    }
}

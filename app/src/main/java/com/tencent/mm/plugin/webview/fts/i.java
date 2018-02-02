package com.tencent.mm.plugin.webview.fts;

import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.aj.a.a;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.aj.a.f;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.protocal.c.bjn;
import com.tencent.mm.protocal.c.bro;
import com.tencent.mm.protocal.c.bzr;
import com.tencent.mm.protocal.c.bzv;
import com.tencent.mm.protocal.c.bzw;
import com.tencent.mm.protocal.c.ii;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONObject;

public final class i extends a implements k {
    private e gJT;
    private b hFi;
    private d hjF;
    private int scene;
    private int tjP;
    private bzw tmL;
    private bzv tmM;

    public i(d dVar) {
        float f = 0.0f;
        boolean z = false;
        this.hjF = dVar;
        this.tjM = dVar.fod;
        this.tjN = dVar.hKZ;
        this.wn = dVar.offset;
        this.irz = dVar.scene;
        this.tjL = dVar.fDl;
        this.tjP = dVar.tjP;
        this.hjF = dVar;
        this.tjO = dVar.tkh;
        if (bh.ov(dVar.fod)) {
            x.e("MicroMsg.FTS.NetSceneWebSearch", "keyword is unavailable");
            return;
        }
        int i;
        float f2;
        x.i("MicroMsg.FTS.NetSceneWebSearch", "Constructors: keyword=%s", new Object[]{dVar.fod});
        this.scene = dVar.scene;
        b.a aVar = new b.a();
        aVar.hmi = 719;
        aVar.uri = "/cgi-bin/micromsg-bin/mmwebsearch";
        aVar.hmj = new bzv();
        aVar.hmk = new bzw();
        this.hFi = aVar.JZ();
        this.tmM = (bzv) this.hFi.hmg.hmo;
        this.tmM.wgS = dVar.fod;
        this.tmM.wIL = dVar.tjP;
        this.tmM.vPp = (long) dVar.hKY;
        this.tmM.wwI = g.Je();
        this.tmM.vNW = dVar.offset;
        this.tmM.wYd = g.zN(0);
        this.tmM.wKb = dVar.tjQ;
        this.tmM.rYW = dVar.scene;
        this.tmM.vPs = dVar.lEK;
        this.tmM.wZl = dVar.tjR;
        this.tmM.wZr = dVar.tjS;
        this.tmM.wZt = dVar.tjU;
        this.tmM.wZs = dVar.tjT;
        this.tmM.wZu = dVar.tjV;
        this.tmM.wZm = dVar.tka;
        this.tmM.tjZ = dVar.tjZ;
        this.tmM.wZv = dVar.tkb;
        this.tmM.lOo = dVar.ael;
        this.tmM.wYh = dVar.fqu;
        if (dVar.tke == null) {
            dVar.tke = new bzr();
        }
        if (dVar.tke.wZo == null) {
            dVar.tke.wZo = new ii();
        }
        if (this.tmM.wwI != null) {
            ii iiVar = dVar.tke.wZo;
            c OP = c.OP();
            if (OP.hxS <= 0 || !OP.hxU || System.currentTimeMillis() - OP.hxS >= 600000) {
                boolean z2 = false;
            } else {
                i = 1;
            }
            iiVar.vOB = i != 0 ? 0 : 1;
            f = this.tmM.wwI.vQt;
            f2 = this.tmM.wwI.vQu;
        } else {
            dVar.tke.wZo.vOB = 1;
            f2 = 0.0f;
        }
        x.i("MicroMsg.FTS.NetSceneWebSearch", "websearch location: longitude[%f], latitude[%f], isUsingCached[%d]", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(dVar.tke.wZo.vOB)});
        if (!TextUtils.isEmpty(dVar.tkf)) {
            try {
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(dVar.tkf));
                axj com_tencent_mm_protocal_c_axj = new axj();
                com_tencent_mm_protocal_c_axj.hvv = jSONObject.optString("city");
                com_tencent_mm_protocal_c_axj.hvC = jSONObject.optString("country");
                com_tencent_mm_protocal_c_axj.vQu = (float) jSONObject.optDouble("latitude");
                com_tencent_mm_protocal_c_axj.vQt = (float) jSONObject.optDouble("longitude");
                com_tencent_mm_protocal_c_axj.wEz = jSONObject.optString("poiId");
                com_tencent_mm_protocal_c_axj.wrN = jSONObject.optString("poiName");
                com_tencent_mm_protocal_c_axj.wEB = com.tencent.mm.bc.b.lS(jSONObject.optString("snsId"));
                if (!TextUtils.isEmpty(com_tencent_mm_protocal_c_axj.wEz)) {
                    this.tmM.wZA = com_tencent_mm_protocal_c_axj;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.NetSceneWebSearch", e, "", new Object[0]);
            }
        }
        if (dVar.tke != null) {
            try {
                this.tmM.wZx = new com.tencent.mm.bq.b(dVar.tke.toByteArray());
            } catch (Exception e2) {
            }
        }
        if (dVar.tkd != null) {
            try {
                this.tmM.wZw = new com.tencent.mm.bq.b(dVar.tkd.toByteArray());
            } catch (Exception e3) {
            }
        }
        String str = "MicroMsg.FTS.NetSceneWebSearch";
        String str2 = "contains location = %b | matchUserSize=%d | scene=%d | businessType=%d | isHomePage=%b | sceneActionType=%d | webViewId=%d";
        Object[] objArr = new Object[7];
        objArr[0] = Boolean.valueOf(this.tmM.wwI != null);
        objArr[1] = Integer.valueOf(dVar.tjQ.size());
        objArr[2] = Integer.valueOf(dVar.scene);
        objArr[3] = Integer.valueOf(dVar.hKY);
        objArr[4] = Integer.valueOf(this.tjP);
        objArr[5] = Integer.valueOf(dVar.tjR);
        objArr[6] = Integer.valueOf(dVar.fDl);
        x.i(str, str2, objArr);
        if (this.tmM.wwI != null) {
            o.a(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, this.tmM.wwI.vQt, this.tmM.wwI.vQu, this.tmM.wwI.wcr);
        }
        i = dVar.scene;
        str = dVar.fqu;
        str2 = dVar.tjs;
        String str3 = dVar.lEK;
        int i2 = dVar.offset;
        if (dVar.tjP == 1) {
            z = true;
        }
        f.a(i, str, str2, str3, i2, z, dVar.hKZ, dVar.fod, dVar.hKY, "");
    }

    public final int getType() {
        return 719;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        com.tencent.mm.bc.g.bl(this.scene, 2);
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSearch", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        boolean z = i2 == 0 && i3 == 0;
        if (i2 == 0 && i3 == 0) {
            this.tmL = (bzw) this.hFi.hmh.hmo;
            if (this.tmL != null) {
                f.a(this.hjF.scene, this.hjF.fqu, this.hjF.tjs, this.hjF.lEK, this.hjF.offset, this.hjF.tjP == 1, this.hjF.hKZ, z, this.hjF.fod, this.hjF.hKY);
                x.v("MicroMsg.FTS.NetSceneWebSearch", "return data\n%s", new Object[]{this.tmL.vOe});
            }
            this.gJT.a(i2, i3, str, this);
            com.tencent.mm.bc.g.z(this.scene, i2, i3);
            return;
        }
        this.gJT.a(i2, i3, str, this);
        f.a(this.hjF.scene, this.hjF.fqu, this.hjF.tjs, this.hjF.lEK, this.hjF.offset, this.hjF.tjP == 1, this.hjF.hKZ, z, this.hjF.fod, this.hjF.hKY);
        com.tencent.mm.bc.g.z(this.scene, i2, i3);
    }

    public final String Jc() {
        return this.tmL != null ? this.tmL.vOe : "";
    }

    public final int Jd() {
        return this.tmL != null ? this.tmL.wYn : 0;
    }

    public final void ao(LinkedList<bro> linkedList) {
        this.tmM.wKb = linkedList;
        bjn com_tencent_mm_protocal_c_bjn = new bjn();
        com_tencent_mm_protocal_c_bjn.wMR = linkedList.size();
        this.tmM.wZy = com_tencent_mm_protocal_c_bjn;
    }
}

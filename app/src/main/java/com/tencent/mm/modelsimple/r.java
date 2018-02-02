package com.tencent.mm.modelsimple;

import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aew;
import com.tencent.mm.protocal.c.aex;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.aq;

public final class r extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    private String hNv;

    public r(String str) {
        this.hNv = str;
        a aVar = new a();
        aVar.hmj = new aew();
        aVar.hmk = new aex();
        aVar.uri = "/cgi-bin/micromsg-bin/getprofile";
        aVar.hmi = HardCoderJNI.SCENE_QUIT_CHATTING;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((aew) this.gJQ.hmg.hmo).ksU = str;
    }

    public final int getType() {
        return HardCoderJNI.SCENE_QUIT_CHATTING;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bh.ov(this.hNv)) {
            x.e("MicroMsg.NetSceneGetProfile", "null or empty username");
            return -1;
        }
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
        if (i2 == 0 && i3 == 0) {
            aex com_tencent_mm_protocal_c_aex = (aex) this.gJQ.hmh.hmo;
            com.tencent.mm.sdk.b.b rzVar = new rz();
            rzVar.fJI.fJJ = com_tencent_mm_protocal_c_aex;
            com.tencent.mm.sdk.b.a.xef.m(rzVar);
            rzVar = new rx();
            rzVar.fJG.fJH = com_tencent_mm_protocal_c_aex.wmN.wTh;
            com.tencent.mm.sdk.b.a.xef.m(rzVar);
            if (com.tencent.mm.z.q.FS().equals(com_tencent_mm_protocal_c_aex.wmM.vYI.toString()) && !bh.ov(com_tencent_mm_protocal_c_aex.wmN.vUV)) {
                g.Dj().CU().a(w.a.xnL, com_tencent_mm_protocal_c_aex.wmN.vUV);
            }
            x.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aex.wmM.wzZ), Integer.valueOf(com_tencent_mm_protocal_c_aex.wmN.wTb)});
            g.Dj().CU().set(64, Integer.valueOf(com_tencent_mm_protocal_c_aex.wmN.vFx));
            g.Dj().CU().set(144385, Integer.valueOf(com_tencent_mm_protocal_c_aex.wmN.wTb));
            g.Dj().CU().set(40, Integer.valueOf(com_tencent_mm_protocal_c_aex.wmM.wzZ));
            g.Dj().CU().set(339975, Integer.valueOf(com_tencent_mm_protocal_c_aex.wmN.wTj));
            x.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aex.wmN.wTj)});
            g.Dj().CU().a(w.a.xrD, Integer.valueOf(com_tencent_mm_protocal_c_aex.wmN.whI));
            x.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aex.wmN.wTj), Integer.valueOf(com_tencent_mm_protocal_c_aex.wmN.whI)});
            g.Dj().CU().set(208903, com_tencent_mm_protocal_c_aex.wmN.vLO);
            g.Dj().CU().set(274433, com_tencent_mm_protocal_c_aex.wmN.wzk);
            g.Dj().CU().set(274434, com_tencent_mm_protocal_c_aex.wmN.wzj);
            g.Dj().CU().set(274436, com_tencent_mm_protocal_c_aex.wmN.wTc);
            g.Dj().CU().a(w.a.xpK, bh.az(com_tencent_mm_protocal_c_aex.wmN.fWD, ""));
            g.Dj().CU().a(w.a.xtD, com_tencent_mm_protocal_c_aex.wmN.wTl);
            x.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", new Object[]{com_tencent_mm_protocal_c_aex.wmN.fWD});
            aq.hfP.S("last_login_use_voice", com_tencent_mm_protocal_c_aex.wmM.wzZ);
            if (VERSION.SDK_INT < 23) {
                System.putString(ac.getContext().getContentResolver(), "89884a87498ef44f", com_tencent_mm_protocal_c_aex.wmN.wTi);
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}

package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.protocal.c.awb;
import com.tencent.mm.protocal.c.awc;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

public final class c extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public c() {
        boolean booleanValue;
        a aVar = new a();
        aVar.hmj = new awb();
        aVar.hmk = new awc();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
        aVar.hmi = 1577;
        this.gJQ = aVar.JZ();
        awb com_tencent_mm_protocal_c_awb = (awb) this.gJQ.hmg.hmo;
        g.Dk();
        Object obj = g.Dj().CU().get(w.a.xqA, Boolean.valueOf(false));
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        com_tencent_mm_protocal_c_awb.wDz = booleanValue ? 1 : 0;
        com_tencent_mm_protocal_c_awb.ael = com.tencent.mm.sdk.platformtools.w.cfi();
        com_tencent_mm_protocal_c_awb.wDC = VERSION.RELEASE;
        com_tencent_mm_protocal_c_awb.wDB = f.ag(null, d.vAz);
        com_tencent_mm_protocal_c_awb.wDD = Build.MANUFACTURER;
        x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_awb.wDz), com_tencent_mm_protocal_c_awb.ael, com_tencent_mm_protocal_c_awb.wDC, com_tencent_mm_protocal_c_awb.wDB, com_tencent_mm_protocal_c_awb.wDD});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            awc com_tencent_mm_protocal_c_awc = (awc) ((b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_awc.wDG == null || com_tencent_mm_protocal_c_awc.wDH == null) {
                x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + com_tencent_mm_protocal_c_awc.okQ);
            } else {
                x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd " + com_tencent_mm_protocal_c_awc.okQ + " wallet_gray_area: " + com_tencent_mm_protocal_c_awc.wDG.wiJ.size() + " wallet_threepoint_area: " + com_tencent_mm_protocal_c_awc.wDH.wiJ.size());
            }
            g.Dk();
            g.Dj().CU().a(w.a.xrD, Integer.valueOf(com_tencent_mm_protocal_c_awc.okQ));
            o.bLw().a(com_tencent_mm_protocal_c_awc.okQ, com_tencent_mm_protocal_c_awc);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1577;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}

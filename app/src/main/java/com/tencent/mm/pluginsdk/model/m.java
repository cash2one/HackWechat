package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.protocal.c.ahd;
import com.tencent.mm.protocal.c.ahe;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class m extends w {
    public String vdx;

    public m(String str, LinkedList<String> linkedList) {
        x.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", new Object[]{str});
        this.vdx = str;
        a aVar = new a();
        aVar.hmj = new ahd();
        aVar.hmk = new ahe();
        aVar.uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
        aVar.hmi = 452;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        ahd com_tencent_mm_protocal_c_ahd = (ahd) this.lMW.hmg.hmo;
        com_tencent_mm_protocal_c_ahd.nfn = str;
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!bh.ov(str2)) {
                linkedList2.add(n.os(str2));
            }
        }
        com_tencent_mm_protocal_c_ahd.vLm = linkedList2;
        com_tencent_mm_protocal_c_ahd.wkd = linkedList.size();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i2 + ", errCode = " + i3);
        if (i2 != 0 || i3 != 0) {
            x.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i2 + ", errCode = " + i3);
        }
    }

    public final byte[] aQX() {
        try {
            return ((b) this.lMW.Kb()).Hq();
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetUserInfoInApp", e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", e, "", new Object[0]);
            return null;
        }
    }

    public final void ax(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
            return;
        }
        try {
            this.lMW.hmh.E(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetUserInfoInApp", e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 14;
    }
}

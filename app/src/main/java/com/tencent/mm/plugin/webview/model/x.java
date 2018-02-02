package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.brx;
import com.tencent.mm.protocal.c.bry;

public final class x extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b hFi;

    public x(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hmj = new brx();
        aVar.hmk = new bry();
        aVar.uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
        aVar.hmi = 1702;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hFi = aVar.JZ();
        brx com_tencent_mm_protocal_c_brx = (brx) this.hFi.hmg.hmo;
        com_tencent_mm_protocal_c_brx.nfX = str;
        com_tencent_mm_protocal_c_brx.fFm = str2;
        com_tencent_mm_protocal_c_brx.frP = str3;
    }

    public final int getType() {
        return 1702;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end ok");
        } else {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end not ok");
        }
        this.gJT.a(i2, i3, str, this);
    }
}

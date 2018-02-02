package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class h extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b hFi;

    public h(List<akt> list, String str) {
        a aVar = new a();
        aVar.hmj = new yx();
        aVar.hmk = new yy();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconsingroup";
        aVar.hmi = 1704;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hFi = aVar.JZ();
        yx yxVar = (yx) this.hFi.hmg.hmo;
        yxVar.wiQ.addAll(list);
        yxVar.fFm = str;
        x.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang]getBeaconsInGroupRequest.beacons.size:%d", new Object[]{Integer.valueOf(yxVar.wiQ.size())});
    }

    public final int getType() {
        return 1704;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end ok");
        } else {
            x.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end not ok");
        }
        this.gJT.a(i2, i3, str, this);
    }
}

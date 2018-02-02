package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.protocal.c.akv;
import com.tencent.mm.protocal.c.yz;
import com.tencent.mm.protocal.c.za;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.e gJT;
    public final b hFi;

    public e(List<akt> list, long j, akv com_tencent_mm_protocal_c_akv) {
        a aVar = new a();
        aVar.hmj = new yz();
        aVar.hmk = new za();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
        aVar.hmi = 1708;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hFi = aVar.JZ();
        yz yzVar = (yz) this.hFi.hmg.hmo;
        yzVar.wiQ.addAll(list);
        yzVar.wiT = j;
        yzVar.wiS = com_tencent_mm_protocal_c_akv;
        x.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", new Object[]{Integer.valueOf(yzVar.wiQ.size())});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
        yz yzVar = (yz) this.hFi.hmg.hmo;
        akt com_tencent_mm_protocal_c_akt = (akt) yzVar.wiQ.get(0);
        akv com_tencent_mm_protocal_c_akv = yzVar.wiS;
        za zaVar = (za) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            if (zaVar.result != 0) {
                g.pQN.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(r2.size()), com_tencent_mm_protocal_c_akt.ned, Integer.valueOf(com_tencent_mm_protocal_c_akt.major), Integer.valueOf(com_tencent_mm_protocal_c_akt.minor), String.valueOf(com_tencent_mm_protocal_c_akv.latitude), String.valueOf(com_tencent_mm_protocal_c_akv.longitude), Integer.valueOf(2), Integer.valueOf(zaVar.result)});
            }
            x.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
            return;
        }
        g.pQN.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(r2.size()), com_tencent_mm_protocal_c_akt.ned, Integer.valueOf(com_tencent_mm_protocal_c_akt.major), Integer.valueOf(com_tencent_mm_protocal_c_akt.minor), String.valueOf(com_tencent_mm_protocal_c_akv.latitude), String.valueOf(com_tencent_mm_protocal_c_akv.longitude), Integer.valueOf(1), Integer.valueOf(zaVar.result)});
        x.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    }

    public final int getType() {
        return 1708;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }
}

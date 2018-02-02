package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ata;
import com.tencent.mm.protocal.c.atb;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class p extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gJT;

    public p(int i) {
        a aVar = new a();
        aVar.hmj = new ata();
        aVar.hmk = new atb();
        aVar.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
        aVar.hmi = com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX;
        this.gJQ = aVar.JZ();
        ((ata) this.gJQ.hmg.hmo).wsC = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        atb com_tencent_mm_protocal_c_atb = (atb) this.gJQ.hmh.hmo;
        x.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + com_tencent_mm_protocal_c_atb.nfM.size() + " group:" + com_tencent_mm_protocal_c_atb.vHz.size());
        Set hashSet = new HashSet();
        LinkedList linkedList = new LinkedList();
        for (int i4 = 0; i4 < com_tencent_mm_protocal_c_atb.wAN; i4++) {
            if (!hashSet.contains(((ate) com_tencent_mm_protocal_c_atb.nfM.get(i4)).ksU)) {
                linkedList.add(com_tencent_mm_protocal_c_atb.nfM.get(i4));
                hashSet.add(((ate) com_tencent_mm_protocal_c_atb.nfM.get(i4)).ksU);
            }
        }
        com_tencent_mm_protocal_c_atb.nfM = linkedList;
        com_tencent_mm_protocal_c_atb.wAN = linkedList.size();
        this.gJT.a(i2, i3, str, this);
    }
}

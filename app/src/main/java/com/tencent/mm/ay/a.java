package com.tencent.mm.ay;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.avd;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.om;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private e gJT;
    public a hIJ;
    public final List<b> hIK = new ArrayList();

    public static class c extends com.tencent.mm.protocal.k.e implements com.tencent.mm.protocal.k.c {
        public avd hIO = new avd();

        public final int E(byte[] bArr) {
            this.hIO = (avd) new avd().aF(bArr);
            return this.hIO.vJU;
        }
    }

    public a(List<b> list) {
        this.hIK.addAll(list);
        this.hIJ = new a();
        ((b) this.hIJ.Kb()).hIN.wBu = R(list);
    }

    private static om R(List<b> list) {
        om omVar = new om();
        for (b bVar : list) {
            byte[] buffer = bVar.getBuffer();
            ol olVar = new ol();
            olVar.vXp = bVar.getCmdId();
            olVar.vXq = new bdn().bj(buffer);
            omVar.ksP.add(olVar);
        }
        omVar.ksO = list.size();
        x.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + list.size());
        return omVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        for (b cmdId : this.hIK) {
            if (cmdId.getCmdId() == 1) {
                ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putBoolean(q.FS() + "_has_mod_userinfo", true).commit();
                break;
            }
        }
        this.gJT = eVar2;
        return a(eVar, this.hIJ, this);
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        return 5;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 681;
    }
}

package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.protocal.c.aeo;
import com.tencent.mm.protocal.c.aep;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class p extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    private int irz;
    public byte[] lyZ;
    private int lzk;

    public p(int i, byte[] bArr) {
        this(i, bArr, (byte) 0);
    }

    private p(int i, byte[] bArr, byte b) {
        this.lyZ = null;
        a aVar = new a();
        aVar.hmj = new aeo();
        aVar.hmk = new aep();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
        aVar.hmi = 720;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.lzk = i;
        this.lyZ = bArr;
        this.irz = 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        aep com_tencent_mm_protocal_c_aep = (aep) ((b) qVar).hmh.hmo;
        if (com_tencent_mm_protocal_c_aep.vHG != null) {
            this.lyZ = n.a(com_tencent_mm_protocal_c_aep.vHG);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 720;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        aeo com_tencent_mm_protocal_c_aeo = (aeo) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aeo.wko = this.lzk;
        if (this.lyZ != null) {
            com_tencent_mm_protocal_c_aeo.vHG = n.N(this.lyZ);
        } else {
            com_tencent_mm_protocal_c_aeo.vHG = new bdn();
        }
        com_tencent_mm_protocal_c_aeo.rYW = this.irz;
        x.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", com_tencent_mm_protocal_c_aeo.vHG == null ? "Buf is NULL" : com_tencent_mm_protocal_c_aeo.vHG.toString());
        return a(eVar, this.gJQ, this);
    }

    public final aep aBX() {
        return this.gJQ == null ? null : (aep) this.gJQ.hmh.hmo;
    }

    public static f a(aep com_tencent_mm_protocal_c_aep) {
        x.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
        if (com_tencent_mm_protocal_c_aep == null) {
            return null;
        }
        f fVar = new f();
        if (!(com_tencent_mm_protocal_c_aep == null || com_tencent_mm_protocal_c_aep.wkI == null)) {
            fVar.lxB = com_tencent_mm_protocal_c_aep.wkI.size();
            List arrayList = new ArrayList();
            Iterator it = com_tencent_mm_protocal_c_aep.wkI.iterator();
            while (it.hasNext()) {
                so soVar = (so) it.next();
                if (soVar.vIR != null) {
                    arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(soVar));
                }
            }
            fVar.lxC = arrayList;
        }
        return fVar;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        return 100;
    }
}

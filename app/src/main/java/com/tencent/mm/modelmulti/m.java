package com.tencent.mm.modelmulti;

import com.tencent.mm.g.a.hc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class m {
    public static boolean PZ() {
        boolean z;
        g.Dk();
        if (bh.ou((String) g.Dj().CU().get(8195, null)).length() > 0) {
            g.Dk();
            if (bh.e((Integer) g.Dj().CU().get(15, null)) != 0) {
                z = false;
                x.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", new Object[]{Boolean.valueOf(z)});
                return z;
            }
        }
        z = true;
        x.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public static void a(int i, byte[] bArr, byte[] bArr2, long j) {
        e bVar = new b();
        PByteArray pByteArray = new PByteArray();
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt(0);
        PInt pInt4 = new PInt(255);
        try {
            x.i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack ret[%b], noticeid[%d]", new Object[]{Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4)), Integer.valueOf(pInt3.value)});
            if (pInt3.value != 0) {
                com.tencent.mm.sdk.b.b hcVar = new hc();
                hcVar.fxm.fxn = pInt3.value;
                boolean m = a.xef.m(hcVar);
                x.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[]{Integer.valueOf(pInt3.value), Boolean.valueOf(m)});
                pInt3.value = 0;
            }
            if (r3) {
                bVar.vBq = pInt4.value;
                if (pInt.value == -13) {
                    bVar.vBp = pInt.value;
                    x.e("MicroMsg.NewSyncMgr", "unpack push resp failed session timeout");
                    return;
                }
                int E = bVar.E(pByteArray2.value);
                x.d("MicroMsg.NewSyncMgr", "bufToResp using protobuf ok");
                bVar.vBp = E;
                bVar.vBo = (long) bArr.length;
                g.Dk();
                byte[] VD = bh.VD(bh.ou((String) g.Dj().CU().get(8195, null)));
                byte[] a = n.a(bVar.vBR.vRA);
                g.Dk();
                g.Dh().aT(bVar.vBR.ktm, bVar.vBR.wBw);
                com.tencent.mm.kernel.a.gA(bVar.vBR.ktm);
                if (bh.bw(a) || !ad.h(VD, a)) {
                    x.e("MicroMsg.NewSyncMgr", "compareKeybuf syncKey failed");
                    return;
                }
                ((com.tencent.mm.plugin.zero.b.b) g.h(com.tencent.mm.plugin.zero.b.b.class)).Qc().a(bVar, i, j);
                if (pInt3.value != 0) {
                    com.tencent.mm.sdk.b.b hcVar2 = new hc();
                    hcVar2.fxm.fxn = pInt3.value;
                    boolean m2 = a.xef.m(hcVar2);
                    x.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[]{Integer.valueOf(pInt3.value), Boolean.valueOf(m2)});
                    pInt3.value = 0;
                    return;
                }
                return;
            }
            x.e("MicroMsg.NewSyncMgr", "unpack push resp failed");
        } catch (Throwable e) {
            x.e("MicroMsg.NewSyncMgr", "unpack push resp failed: %s", new Object[]{e});
            x.printErrStackTrace("MicroMsg.NewSyncMgr", e, "", new Object[0]);
        }
    }
}

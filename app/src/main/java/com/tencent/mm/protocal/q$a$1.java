package com.tencent.mm.protocal;

import com.tencent.mm.ae.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.sq;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.x;

class q$a$1 implements a {
    final /* synthetic */ d vBF;
    final /* synthetic */ q.a vBG;

    q$a$1(q.a aVar, d dVar) {
        this.vBG = aVar;
        this.vBF = dVar;
    }

    public final boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2) {
        long j;
        b bVar = (b) this.vBF;
        long j2 = (long) this.vBF.vBf;
        if (com.tencent.mm.sdk.a.b.ceK() && j2 == 0) {
            j = d.vAy;
        } else {
            j = j2;
        }
        ac acVar = this.vBF.vBn;
        if (i == 722) {
            x.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
            sq sqVar = ((q.a) this.vBF).vBE;
            byte[][] a = r.a(j, sqVar.wbe, sqVar.wbf);
            if (a == null) {
                return false;
            }
            byte[] bArr3 = a[0];
            byte[] bArr4 = a[1];
            if (MMProtocalJni.packHybrid(pByteArray, bArr, this.vBF.vBi, (int) j, bVar.Hr(), acVar.ver, bArr3, bArr4, acVar.vBY.getBytes(), acVar.vBZ.getBytes(), this.vBF.vBm, i2)) {
                x.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", new Object[]{Integer.valueOf(pByteArray.value.length), Integer.valueOf(i2)});
                return true;
            }
        }
        return false;
    }
}

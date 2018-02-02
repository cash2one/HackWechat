package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.i;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.protocal.j.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class a extends k implements com.tencent.mm.network.k {
    private e gJT;
    public q hnp = new a();

    public static class a extends i {
        private final com.tencent.mm.protocal.j.a klY = new com.tencent.mm.protocal.j.a();
        private final b klZ = new b();

        protected final d Ho() {
            return this.klY;
        }

        public final com.tencent.mm.protocal.k.e Hp() {
            return this.klZ;
        }

        public final int getType() {
            return 1000;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/bakchatcreateqrcodeoffline";
        }

        public final int JY() {
            return 1;
        }
    }

    public a(LinkedList<ov> linkedList, String str, String str2) {
        final com.tencent.mm.protocal.j.a aVar = (com.tencent.mm.protocal.j.a) this.hnp.Kb();
        aVar.vBd = com.tencent.mm.plugin.backup.a.d.aop();
        aVar.vBc.vJO = linkedList.size();
        aVar.vBc.vJP = linkedList;
        aVar.vBc.vJQ = com.tencent.mm.compatible.d.q.getDeviceID(ac.getContext());
        aVar.vBc.vJR = com.tencent.mm.z.q.FS();
        aVar.vBc.rYW = 2;
        aVar.vBc.kti = 0;
        aVar.vBc.vJS = str;
        aVar.vBc.vJT = str2;
        aVar.vBm = aVar.vBd;
        aVar.vBl = new com.tencent.mm.protocal.k.a(this) {
            final /* synthetic */ a klX;

            public final boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2) {
                long j;
                long j2 = (long) aVar.vBf;
                if (com.tencent.mm.sdk.a.b.ceK() && j2 == 0) {
                    j = com.tencent.mm.protocal.d.vAy;
                } else {
                    j = j2;
                }
                com.tencent.mm.protocal.ac acVar = aVar.vBn;
                if (i == 1000) {
                    byte[] bArr3 = aVar.vBm;
                    x.d("MicroMsg.BackupCreateQRCodeOfflineScene", "BakMove key:" + bArr3);
                    if (!acVar.cdO()) {
                        bArr3 = new byte[0];
                    }
                    if (bh.bw(bArr3)) {
                        x.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", new Object[]{Integer.valueOf(i)});
                        return false;
                    }
                    if (MMProtocalJni.pack(aVar.Hq(), pByteArray, bArr3, bArr, aVar.vBi, (int) j, 1000, acVar.ver, acVar.vBY.getBytes(), acVar.vBZ.getBytes(), bArr2, i2)) {
                        x.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[]{Integer.valueOf(pByteArray.value.length), Integer.valueOf(i2)});
                        return true;
                    }
                }
                return false;
            }
        };
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.BackupCreateQRCodeOfflineScene", "err: %d, %d, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[]{((b) qVar.Hp()).vBe.vJW});
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1000;
    }
}

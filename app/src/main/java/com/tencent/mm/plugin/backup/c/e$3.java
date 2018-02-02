package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.d.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.protocal.j;
import com.tencent.mm.sdk.platformtools.x;

class e$3 implements e {
    final /* synthetic */ e klV;

    e$3(e eVar) {
        this.klV = eVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        b.b(1000, this.klV.klU);
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            ep epVar = ((j.b) ((a) kVar).hnp.Hp()).vBe;
            String str2 = "MicroMsg.BackupCreateQRCodeOfflineScene";
            String str3 = "onGYNetEnd QRCodeUrl:%s";
            Object[] objArr = new Object[1];
            objArr[0] = epVar == null ? "null" : epVar.vJW;
            x.i(str2, str3, objArr);
            byte[] bArr = epVar == null ? null : epVar.vJV == null ? null : epVar.vJV.wJD.oz;
            if (bArr != null) {
                this.klV.kiE.kiJ = 51;
                this.klV.klR.k(51, bArr);
                return;
            }
            return;
        }
        x.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:" + str);
        this.klV.kiE.kiJ = -11;
        this.klV.klR.k(-11, null);
    }
}

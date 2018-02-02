package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.protocal.c.eo;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.LinkedList;

public final class b extends k implements com.tencent.mm.network.k {
    public com.tencent.mm.ae.b gJQ;
    protected e gJT;

    public b(LinkedList<ov> linkedList, String str) {
        a aVar = new a();
        aVar.hmj = new eo();
        aVar.hmk = new eq();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
        aVar.hmi = 704;
        this.gJQ = aVar.JZ();
        eo eoVar = (eo) this.gJQ.hmg.hmo;
        eoVar.vJO = linkedList.size();
        eoVar.vJP = linkedList;
        eoVar.vJR = q.FS();
        eoVar.vJQ = com.tencent.mm.compatible.d.q.getDeviceID(ac.getContext());
        eoVar.vJS = str;
        eoVar.kti = 0;
        eoVar.rYW = 2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", new Object[]{((eq) this.gJQ.hmh.hmo).vJW});
            d.X(r0.vJC.wJD.oz);
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 704;
    }
}

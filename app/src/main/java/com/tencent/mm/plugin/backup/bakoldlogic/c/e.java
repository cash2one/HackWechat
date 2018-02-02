package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.yn;
import com.tencent.mm.protocal.c.yo;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private com.tencent.mm.ae.e gJT;
    private final String id;
    public byte[] krF;

    public e(String str) {
        a aVar = new a();
        aVar.hmj = new yn();
        aVar.hmk = new yo();
        aVar.uri = "/cgi-bin/micromsg-bin/getbakchatkey";
        this.gJQ = aVar.JZ();
        yn ynVar = (yn) this.gJQ.hmg.hmo;
        ynVar.ID = str;
        ynVar.wiI = ac.cdN().ver;
        this.id = str;
        x.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", ynVar.ID, Integer.valueOf(ynVar.wiI));
    }

    public final void cancel() {
        super.cancel();
    }

    public final int getType() {
        return 596;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBakchatkey", "errType %d,  errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            this.krF = ((yo) this.gJQ.hmh.hmo).vJC.wJD.oz;
            String str2 = "MicroMsg.NetSceneGetBakchatkey";
            String str3 = "id:%s,  key len:%d";
            Object[] objArr = new Object[2];
            objArr[0] = this.id;
            objArr[1] = Integer.valueOf(this.krF == null ? 0 : this.krF.length);
            x.i(str2, str3, objArr);
            if (this.krF != null) {
                str2 = "";
                for (byte b : this.krF) {
                    str2 = str2 + Integer.toHexString(b & 255) + " ";
                }
                x.i("MicroMsg.NetSceneGetBakchatkey", "dump bakchat: %s", str2);
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}

package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nd;
import com.tencent.mm.protocal.c.ne;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class aa extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    private a veH;

    public interface a {
        void P(String str, int i, int i2);
    }

    public aa(String str, String str2, String str3, int i, a aVar) {
        com.tencent.mm.ae.b.a aVar2 = new com.tencent.mm.ae.b.a();
        aVar2.hmj = new nd();
        aVar2.hmk = new ne();
        aVar2.uri = "/cgi-bin/micromsg-bin/checkmd5";
        this.gJQ = aVar2.JZ();
        nd ndVar = (nd) this.gJQ.hmg.hmo;
        ndVar.fileid = str;
        ndVar.fqR = str2;
        ndVar.vVX = str3;
        ndVar.vVY = i;
        this.veH = aVar;
        x.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", ndVar.fileid, ndVar.fqR, ndVar.vVX, Integer.valueOf(ndVar.vVY), bh.cgy());
    }

    public final int getType() {
        return 939;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gJT.a(i2, i3, str, this);
        if (this.veH != null) {
            a aVar;
            String str2;
            a aVar2;
            if (i2 == 0 && i3 == 0) {
                ne neVar = (ne) ((b) qVar).hmh.hmo;
                aVar = this.veH;
                if (neVar != null) {
                    str2 = neVar.aeskey;
                    aVar.P(str2, i2, i3);
                }
                aVar2 = aVar;
            } else {
                aVar2 = this.veH;
            }
            aVar = aVar2;
            str2 = "";
            aVar.P(str2, i2, i3);
        }
    }
}

package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mi;
import com.tencent.mm.protocal.c.mj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class y extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    private final b veF;

    public y(b bVar, String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.hmj = new mi();
        aVar.hmk = new mj();
        aVar.uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
        aVar.hmi = 728;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.veF = bVar;
        mi miVar = (mi) this.gJQ.hmg.hmo;
        miVar.vQA = str;
        miVar.vVa = bVar.field_totalLen;
        miVar.vVb = str2;
        miVar.hJu = str3;
        miVar.vVc = str4;
        miVar.nkp = str5;
        ar.Hg();
        miVar.nko = (String) c.CU().get(2, "");
        miVar.vIE = com.tencent.mm.modelcdntran.b.hrM;
        x.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", new Object[]{bh.VT(miVar.vQA), miVar.vVb, miVar.hJu, miVar.vVc, Long.valueOf(miVar.vVa), Integer.valueOf(miVar.vIE), bh.cgy()});
    }

    public final int getType() {
        return 728;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            mj mjVar = (mj) ((b) qVar).hmh.hmo;
            this.veF.field_signature = mjVar.hvw;
            this.veF.field_fakeAeskey = mjVar.vVe;
            this.veF.field_fakeSignature = mjVar.vVf;
            boolean c = an.aqd().c(this.veF, new String[0]);
            x.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", new Object[]{bh.VT(this.veF.field_signature), bh.VT(this.veF.field_fakeAeskey), bh.VT(this.veF.field_fakeSignature), Boolean.valueOf(c)});
        }
        this.gJT.a(i2, i3, str, this);
    }
}

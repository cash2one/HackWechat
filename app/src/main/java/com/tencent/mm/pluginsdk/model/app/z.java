package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.protocal.c.mk;
import com.tencent.mm.protocal.c.ml;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.q;

public final class z extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    private final a veG;

    public z(a aVar, String str, String str2, a aVar2) {
        b.a aVar3 = new b.a();
        aVar3.hmj = new mk();
        aVar3.hmk = new ml();
        aVar3.uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
        aVar3.hmi = 727;
        aVar3.hml = 0;
        aVar3.hmm = 0;
        this.gJQ = aVar3.JZ();
        mk mkVar = (mk) this.gJQ.hmg.hmo;
        if (aVar != null) {
            mkVar.vQA = aVar.hbp;
            mkVar.vVb = aVar.filemd5;
            mkVar.hJu = aVar.title;
            mkVar.vVc = aVar.hbc;
            mkVar.vVa = (long) aVar.hbb;
        } else {
            g.MK();
            mkVar.vQA = com.tencent.mm.modelcdntran.b.MC();
            g.MK();
            mkVar.vVb = com.tencent.mm.modelcdntran.b.kB(str);
            mkVar.hJu = com.tencent.mm.a.e.bR(str);
            mkVar.vVc = com.tencent.mm.a.e.bQ(str);
            mkVar.vVa = (long) com.tencent.mm.a.e.bN(str);
        }
        mkVar.vIE = com.tencent.mm.modelcdntran.b.hrM;
        mkVar.nko = str2;
        mkVar.nkp = q.FS();
        this.veG = aVar2;
        x.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[]{aVar, mkVar.vQA, mkVar.vVb, mkVar.hJu, Long.valueOf(mkVar.vVa), mkVar.vVc, mkVar.nko, mkVar.nkp, bh.cgy()});
    }

    public final int getType() {
        return 727;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.gJT.a(i2, i3, str, this);
            mk mkVar = (mk) ((b) qVar).hmg.hmo;
            ml mlVar = (ml) ((b) qVar).hmh.hmo;
            x.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[]{mlVar.hvw, Integer.valueOf(mlVar.vVd), mlVar.vVe, mlVar.vVf});
            if (this.veG != null) {
                this.veG.a(mkVar.vVb, mkVar.vQA, mlVar.hvw, mlVar.vVe, mlVar.vVf, mkVar.vVa);
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
        if (this.veG != null) {
            this.veG.a("", "", "", "", "", 0);
        }
    }
}

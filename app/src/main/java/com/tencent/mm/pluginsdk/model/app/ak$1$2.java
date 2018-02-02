package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pluginsdk.model.app.ak.1;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ak$1$2 implements z$a {
    final /* synthetic */ int ljC;
    final /* synthetic */ 1 vff;

    ak$1$2(1 1, int i) {
        this.vff = 1;
        this.ljC = i;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, long j) {
        String str6 = "MicroMsg.NetSceneUploadAppAttach";
        String str7 = "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[1] = bh.VT(str2);
        objArr[2] = bh.VT(str3);
        objArr[3] = bh.VT(str4);
        objArr[4] = bh.VT(str5);
        objArr[5] = Boolean.valueOf(this.vff.vfe.fnC == null);
        objArr[6] = Boolean.valueOf(this.vff.vfe.hBF);
        x.i(str6, str7, objArr);
        if (!bh.ov(str3)) {
            this.vff.vfe.veF.field_signature = str3;
            this.vff.vfe.veF.field_fakeAeskey = str4;
            this.vff.vfe.veF.field_fakeSignature = str5;
            this.vff.vfe.veF.field_lastModifyTime = bh.Wp();
            if (this.vff.vfe.fnC != null) {
                this.vff.vfe.fnC.filemd5 = str;
                this.vff.vfe.fnC.hbp = str2;
                this.vff.vfe.fnC.hbb = (int) j;
                ar.Hg();
                au dH = c.Fa().dH(this.vff.vfe.veF.field_msgInfoId);
                dH.setContent(a.a(this.vff.vfe.fnC, null, null));
                ar.Hg();
                c.Fa().a(dH.field_msgId, dH);
            }
        }
        this.vff.vfe.hBF = false;
        boolean c = an.aqd().c(this.vff.vfe.veF, new String[0]);
        if (c) {
            ar.Dm().F(new 1(this));
            return;
        }
        x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + c);
        this.vff.vfe.retCode = -10000 - g.getLine();
        this.vff.vfe.gJT.a(3, this.ljC, "", this.vff.vfe);
    }
}

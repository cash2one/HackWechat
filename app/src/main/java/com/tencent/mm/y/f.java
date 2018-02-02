package com.tencent.mm.y;

import android.util.Base64;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.protocal.c.blr;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import java.util.Map;

public final class f extends d {
    public final d EJ() {
        return new f();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
        if (!bh.ov(aVar.appId)) {
            String replace;
            String str2 = aVar.fGG;
            blt com_tencent_mm_protocal_c_blt = new blt();
            if (str2 != null) {
                try {
                    com_tencent_mm_protocal_c_blt.aF(Base64.decode(str2, 0));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", e, "", new Object[0]);
                }
            }
            com_tencent_mm_protocal_c_blt.wPn = new blr();
            com_tencent_mm_protocal_c_blt.wPn.nbS = aVar.appId;
            try {
                str2 = Base64.encodeToString(com_tencent_mm_protocal_c_blt.toByteArray(), 0);
                replace = str2.replace("\n", "");
            } catch (Throwable e2) {
                Throwable th = e2;
                replace = str2;
                x.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", th, "", new Object[0]);
            }
            aVar.fGG = replace;
        }
        stringBuilder.append("<statextstr>" + bh.VG(aVar.fGG) + "</statextstr>");
    }

    public final void a(Map<String, String> map, a aVar) {
    }
}

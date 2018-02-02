package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.m;
import java.net.URLEncoder;

class ak$2 extends c<mr> {
    final /* synthetic */ ak vfe;

    ak$2(ak akVar) {
        this.vfe = akVar;
        this.xen = mr.class.getName().hashCode();
    }

    private boolean a(mr mrVar) {
        if (mrVar.fED.filePath.equals(this.vfe.veF.field_fileFullPath)) {
            String str = "";
            try {
                str = URLEncoder.encode(mrVar.fED.result, "UTF-8");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", e, "", new Object[0]);
            }
            if (this.vfe.gLV == 1) {
                ar.Hg();
                cf dH = com.tencent.mm.z.c.Fa().dH(this.vfe.veF.field_msgInfoId);
                d dVar = new d();
                dVar.q("20toUser", this.vfe.toUser + ",");
                dVar.q("21source", "4,");
                dVar.q("22qrUrl", str + ",");
                dVar.q("23md5", (this.vfe.gLW == null ? "" : this.vfe.gLW.field_filemd5) + ",");
                dVar.q("24cdnFileId", (this.vfe.gLW == null ? "" : this.vfe.gLW.field_fileId) + ",");
                dVar.q("25cdnAesKey", (this.vfe.gLW == null ? "" : this.vfe.gLW.field_aesKey) + ",");
                str = "";
                if (dH.aNc()) {
                    a fT = a.fT(dH.field_content);
                    if (fT != null) {
                        str = fT.appId;
                    }
                }
                dVar.q("26appip", str + ",");
                dVar.q("27toUsersCount", m.gl(this.vfe.toUser) + ",");
                dVar.q("28codeType", Integer.valueOf(mrVar.fED.fqb));
                x.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + dVar.Sz());
                o.w(13628, dVar.toString());
            }
            com.tencent.mm.sdk.b.a.xef.c(this.vfe.gLY);
        }
        return false;
    }
}

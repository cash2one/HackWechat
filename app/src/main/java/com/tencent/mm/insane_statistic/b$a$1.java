package com.tencent.mm.insane_statistic;

import com.tencent.mm.g.a.mr;
import com.tencent.mm.insane_statistic.b.a;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bqt;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.m;
import java.net.URLEncoder;

class b$a$1 extends c<mr> {
    final /* synthetic */ a gMa;

    b$a$1(a aVar) {
        this.gMa = aVar;
        this.xen = mr.class.getName().hashCode();
    }

    private boolean a(mr mrVar) {
        if (mrVar.fED.filePath.equals(this.gMa.gLU)) {
            String encode;
            String str = "";
            try {
                encode = URLEncoder.encode(mrVar.fED.result, "UTF-8");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", e, "", new Object[0]);
                encode = str;
            }
            if (this.gMa.gLX) {
                x.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", new Object[]{Long.valueOf(this.gMa.gLP), Integer.valueOf(this.gMa.hashCode()), this.gMa.gLS + encode, mrVar.fED.filePath});
                g.pQN.k(13717, str);
            }
            if (this.gMa.gLV == 1) {
                d dVar = new d();
                bqt com_tencent_mm_protocal_c_bqt = (bqt) this.gMa.gJQ.hmg.hmo;
                dVar.q("20toUser", com_tencent_mm_protocal_c_bqt.vGY.wJF + ",");
                dVar.q("21source", this.gMa.gLQ + ",");
                dVar.q("22qrUrl", encode + ",");
                dVar.q("23md5", (this.gMa.gLW == null ? "" : this.gMa.gLW.field_filemd5) + ",");
                dVar.q("24cdnFileId", (this.gMa.gLW == null ? "" : this.gMa.gLW.field_fileId) + ",");
                dVar.q("25cdnAesKey", (this.gMa.gLW == null ? "" : this.gMa.gLW.field_aesKey) + ",");
                encode = "";
                if (this.gMa.fnB.aNc()) {
                    com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(this.gMa.fnB.field_content);
                    if (fT != null) {
                        encode = fT.appId;
                    }
                }
                dVar.q("26appip", encode + ",");
                dVar.q("27toUsersCount", m.gl(com_tencent_mm_protocal_c_bqt.vGY.wJF) + ",");
                dVar.q("28codeType", Integer.valueOf(mrVar.fED.fqb));
                x.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + dVar.Sz());
                o.w(13628, dVar.toString());
            }
            a.a(this.gMa);
        }
        return false;
    }
}

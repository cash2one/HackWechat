package com.tencent.mm.plugin.record.b;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.b.d.1;
import com.tencent.mm.pluginsdk.model.app.aa.a;
import com.tencent.mm.sdk.platformtools.x;

class d$1$1 implements a {
    final /* synthetic */ f pFj;
    final /* synthetic */ keep_SceneResult pFk;
    final /* synthetic */ 1 pFl;

    d$1$1(1 1, f fVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        this.pFl = 1;
        this.pFj = fVar;
        this.pFk = com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void P(String str, int i, int i2) {
        x.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 callback [%d, %d], [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 4 && i2 == 102) {
            x.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 MM_ERR_GET_AESKEY_FAILED old status[%d, %d, %d]", new Object[]{Integer.valueOf(this.pFj.field_status), Integer.valueOf(this.pFj.field_offset), Integer.valueOf(this.pFj.field_totalLen)});
            this.pFj.field_offset = 0;
            this.pFj.field_totalLen = 0;
            this.pFj.field_status = 0;
            n.getRecordMsgCDNStorage().b(this.pFj, "localId");
            this.pFl.pFi.a(this.pFj, false);
            return;
        }
        this.pFj.field_cdnKey = str;
        this.pFj.field_cdnUrl = this.pFk.field_fileId;
        n.getRecordMsgCDNStorage().b(this.pFj, "localId");
        this.pFl.pFi.bmQ();
    }
}

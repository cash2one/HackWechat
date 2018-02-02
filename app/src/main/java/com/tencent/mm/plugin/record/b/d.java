package com.tencent.mm.plugin.record.b;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class d extends c<f> {
    private a hBx = new 1(this);

    protected final /* bridge */ /* synthetic */ void a(b bVar) {
        a((f) bVar, true);
    }

    protected final List<f> bmP() {
        x.d("MicroMsg.RecordMsgCDNService", "get to do jobs, size %d", new Object[]{Integer.valueOf(n.getRecordMsgCDNStorage().bmM().size())});
        return n.getRecordMsgCDNStorage().bmM();
    }

    final void a(f fVar, boolean z) {
        x.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, md5:%s, mediaId:%s, jobType[%d], jobStatus[%s]", new Object[]{fVar.field_dataId, fVar.field_mediaId, Integer.valueOf(fVar.field_type), Integer.valueOf(fVar.field_status)});
        i iVar = new i();
        iVar.htt = this.hBx;
        iVar.field_mediaId = fVar.field_mediaId;
        if (2 == fVar.field_type) {
            iVar.fLH = true;
            iVar.field_priority = com.tencent.mm.modelcdntran.b.hrJ;
            iVar.field_needStorage = false;
            iVar.field_totalLen = fVar.field_totalLen;
            iVar.field_aesKey = fVar.field_cdnKey;
            iVar.field_fileId = fVar.field_cdnUrl;
            iVar.htt = this.hBx;
            iVar.field_fullpath = fVar.field_path;
            iVar.field_fileType = fVar.field_fileType;
            iVar.field_talker = fVar.field_toUser;
            iVar.field_force_aeskeycdn = false;
            iVar.field_trysafecdn = true;
            iVar.field_enable_hitcheck = z;
            x.i("MicroMsg.RecordMsgCDNService", "summersafecdn doJob TYPE_UPLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b]", new Object[]{Boolean.valueOf(iVar.field_force_aeskeycdn), Integer.valueOf(iVar.field_fileType), iVar.field_aesKey, iVar.field_fileId, Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn), Boolean.valueOf(iVar.field_enable_hitcheck)});
            g.MJ().c(iVar);
        } else {
            iVar.fLH = false;
            iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
            iVar.field_needStorage = false;
            iVar.field_totalLen = fVar.field_totalLen;
            iVar.field_aesKey = fVar.field_cdnKey;
            iVar.field_fileId = fVar.field_cdnUrl;
            iVar.htt = this.hBx;
            iVar.field_fullpath = fVar.field_path + ".temp";
            iVar.field_fileType = fVar.field_fileType;
            g.MJ().b(iVar, -1);
        }
        x.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, isSend:%B totallen:%d, aseKey:%s, url[%s], fullPath[%s], fileType[%d], enable_hitcheck[%b], force_aeskeycdn[%b]", new Object[]{Boolean.valueOf(iVar.fLH), Integer.valueOf(iVar.field_totalLen), iVar.field_aesKey, iVar.field_fileId, iVar.field_fullpath, Integer.valueOf(iVar.field_fileType), Boolean.valueOf(iVar.field_enable_hitcheck), Boolean.valueOf(iVar.field_force_aeskeycdn)});
    }
}

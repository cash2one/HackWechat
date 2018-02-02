package com.tencent.mm.plugin.record.b;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class k$a implements Runnable {
    private g pEX;
    final /* synthetic */ k pFv;

    public k$a(k kVar, g gVar) {
        this.pFv = kVar;
        this.pEX = gVar;
    }

    public final void run() {
        Iterator it = this.pEX.field_dataProto.weU.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String str;
            String c;
            uq uqVar = (uq) it.next();
            if (!bh.ov(uqVar.wcJ) || e.bO(uqVar.wdh)) {
                str = uqVar.wdh;
                c = h.c(uqVar, this.pEX.field_msgId);
                x.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[]{uqVar.wcJ, str, c, Boolean.valueOf(k.q(str, c, false))});
                if (k.q(str, c, false)) {
                    if (bh.ov(uqVar.wda)) {
                        x.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
                        uqVar.TB(com.tencent.mm.a.g.bV(c));
                        z = true;
                    }
                    if (bh.ov(uqVar.wdc)) {
                        x.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
                        uqVar.TC(com.tencent.mm.a.g.bW(c));
                        z = true;
                    }
                }
                if (e.bN(c) != 0) {
                    uqVar.fw((long) e.bN(c));
                }
                str = h.d(uqVar.mvG, this.pEX.field_msgId, false);
                if (n.getRecordMsgCDNStorage().Ij(str) == null) {
                    f fVar = new f();
                    fVar.field_cdnKey = uqVar.wcL;
                    fVar.field_cdnUrl = uqVar.wcJ;
                    fVar.field_dataId = uqVar.mvG;
                    fVar.field_mediaId = str;
                    fVar.field_totalLen = (int) uqVar.wde;
                    fVar.field_localId = fVar.field_mediaId.hashCode();
                    fVar.field_path = h.c(uqVar, this.pEX.field_msgId);
                    fVar.field_type = 2;
                    fVar.field_fileType = h.vs(uqVar.bjS);
                    fVar.field_recordLocalId = this.pEX.field_localId;
                    fVar.field_toUser = this.pEX.field_toUser;
                    fVar.field_isThumb = false;
                    boolean a = n.getRecordMsgCDNStorage().a(fVar);
                    x.d("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[]{Integer.valueOf(fVar.field_localId), Boolean.valueOf(a), Integer.valueOf(fVar.field_fileType), str});
                }
            }
            if (!bh.ov(uqVar.hbj) || e.bO(uqVar.wdj)) {
                str = uqVar.wdj;
                c = h.f(uqVar, this.pEX.field_msgId);
                x.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[]{str, c, Boolean.valueOf(k.q(str, c, false))});
                uqVar.fx((long) e.bN(c));
                if (k.q(str, c, false)) {
                    if (bh.ov(uqVar.wdl)) {
                        x.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                        uqVar.TG(com.tencent.mm.a.g.bV(c));
                        z = true;
                    }
                    if (bh.ov(uqVar.wdn)) {
                        x.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                        uqVar.TH(com.tencent.mm.a.g.bW(c));
                        z = true;
                    }
                }
                str = h.Ac(uqVar.mvG);
                c = h.d(str, this.pEX.field_msgId, false);
                if (n.getRecordMsgCDNStorage().Ij(c) == null) {
                    f fVar2 = new f();
                    fVar2.field_cdnKey = uqVar.wcF;
                    fVar2.field_cdnUrl = uqVar.hbj;
                    fVar2.field_dataId = str;
                    fVar2.field_mediaId = c;
                    fVar2.field_totalLen = (int) uqVar.wdp;
                    fVar2.field_localId = fVar2.field_mediaId.hashCode();
                    fVar2.field_path = h.f(uqVar, this.pEX.field_msgId);
                    fVar2.field_type = 2;
                    fVar2.field_fileType = b.MediaType_FULLSIZEIMAGE;
                    fVar2.field_recordLocalId = this.pEX.field_localId;
                    fVar2.field_toUser = this.pEX.field_toUser;
                    fVar2.field_isThumb = true;
                    boolean a2 = n.getRecordMsgCDNStorage().a(fVar2);
                    x.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(fVar2.field_localId), Boolean.valueOf(a2)});
                }
            }
            z = z;
        }
        if (z) {
            x.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[]{Integer.valueOf(this.pEX.field_localId), Long.valueOf(this.pEX.field_msgId), Integer.valueOf(this.pEX.field_type)});
            n.bmS().c(this.pEX, new String[]{"localId"});
        }
        n.bmU().run();
    }
}

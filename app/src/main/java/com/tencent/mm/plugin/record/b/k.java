package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k implements e, c {
    boolean pFa = false;
    SparseArray<e> pFd = new SparseArray();
    LinkedList<g> pFe = new LinkedList();

    private class d implements Runnable {
        private g pEX;
        final /* synthetic */ k pFv;

        public d(k kVar, g gVar) {
            this.pFv = kVar;
            this.pEX = gVar;
        }

        public final void run() {
            Iterator it = this.pEX.field_dataProto.weU.iterator();
            boolean z = false;
            while (it.hasNext()) {
                String c;
                String c2;
                uq uqVar = (uq) it.next();
                if (!bh.ov(uqVar.wcJ)) {
                    c = h.c(uqVar, this.pEX.field_oriMsgId);
                    c2 = h.c(uqVar, this.pEX.field_msgId);
                    x.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[]{c, c2, Boolean.valueOf(com.tencent.mm.sdk.platformtools.k.q(c, c2, false))});
                    if (com.tencent.mm.sdk.platformtools.k.q(c, c2, false)) {
                        if (bh.ov(uqVar.wda)) {
                            x.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
                            uqVar.TB(com.tencent.mm.a.g.bV(c2));
                            z = true;
                        }
                        if (bh.ov(uqVar.wdc)) {
                            x.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
                            uqVar.TC(com.tencent.mm.a.g.bW(c2));
                            z = true;
                        }
                    }
                    c = h.d(uqVar.mvG, this.pEX.field_msgId, false);
                    if (n.getRecordMsgCDNStorage().Ij(c) == null) {
                        f fVar = new f();
                        fVar.field_cdnKey = uqVar.wcL;
                        fVar.field_cdnUrl = uqVar.wcJ;
                        fVar.field_dataId = uqVar.mvG;
                        fVar.field_mediaId = c;
                        fVar.field_totalLen = (int) uqVar.wde;
                        fVar.field_localId = fVar.field_mediaId.hashCode();
                        fVar.field_path = h.c(uqVar, this.pEX.field_msgId);
                        fVar.field_type = 2;
                        fVar.field_fileType = h.vs(uqVar.bjS);
                        fVar.field_recordLocalId = this.pEX.field_localId;
                        fVar.field_toUser = this.pEX.field_toUser;
                        fVar.field_isThumb = false;
                        boolean a = n.getRecordMsgCDNStorage().a(fVar);
                        x.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(fVar.field_localId), Boolean.valueOf(a)});
                    }
                }
                if (!bh.ov(uqVar.hbj)) {
                    boolean q = com.tencent.mm.sdk.platformtools.k.q(h.f(uqVar, this.pEX.field_oriMsgId), h.f(uqVar, this.pEX.field_msgId), false);
                    x.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[]{c, c2, Boolean.valueOf(q)});
                    c = h.Ac(uqVar.mvG);
                    c2 = h.d(c, this.pEX.field_msgId, false);
                    if (n.getRecordMsgCDNStorage().Ij(c2) == null) {
                        f fVar2 = new f();
                        fVar2.field_cdnKey = uqVar.wcF;
                        fVar2.field_cdnUrl = uqVar.hbj;
                        fVar2.field_dataId = c;
                        fVar2.field_mediaId = c2;
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
            }
            if (z) {
                x.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[]{Integer.valueOf(this.pEX.field_localId), Long.valueOf(this.pEX.field_msgId), Integer.valueOf(this.pEX.field_type)});
                n.bmS().c(this.pEX, new String[]{"localId"});
            }
            n.bmU().run();
        }
    }

    public k() {
        ar.CG().a(632, this);
        n.getRecordMsgCDNStorage().a(this);
    }

    public final void a(g gVar) {
        ar.Dm().F(new 1(this, gVar));
    }

    final void b(g gVar) {
        if (!this.pFe.contains(gVar)) {
            this.pFe.add(gVar);
        }
    }

    final void finish() {
        this.pFe.clear();
        this.pFd.clear();
        this.pFa = false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            x.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
            return;
        }
        switch (kVar.getType()) {
            case 632:
                x.d("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                a aVar = (a) kVar;
                if (i == 3) {
                    Object obj;
                    Iterator it = aVar.pEX.field_dataProto.weU.iterator();
                    while (it.hasNext()) {
                        if (((uq) it.next()).bjS != 1) {
                            obj = null;
                            if (obj != null) {
                                i = 0;
                                i2 = 0;
                            }
                        }
                    }
                    int i3 = 1;
                    if (obj != null) {
                        i = 0;
                        i2 = 0;
                    }
                }
                if (i == 0 && r10 == 0) {
                    ar.Hg();
                    cf dH = com.tencent.mm.z.c.Fa().dH(aVar.pEX.field_msgId);
                    if (dH.field_msgId == aVar.pEX.field_msgId) {
                        dH.setContent(aVar.pEW);
                        dH.eQ(1);
                        ar.Hg();
                        com.tencent.mm.z.c.Fa().a(aVar.pEX.field_msgId, dH);
                    }
                    com.tencent.mm.sdk.e.c fp = an.bYS().fp(aVar.pEX.field_msgId);
                    if (fp != null) {
                        fp.field_xml = dH.field_content;
                        an.bYS().c(fp, new String[]{"msgId"});
                    }
                    n.bmS().vq(aVar.pEX.field_localId);
                    this.pFd.remove(aVar.pEX.field_localId);
                    an.bYU();
                    a.ft(aVar.pEX.field_msgId);
                    x.d("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[]{Long.valueOf(aVar.pEX.field_msgId), Integer.valueOf(aVar.pEX.field_localId)});
                    break;
                }
                x.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[]{Long.valueOf(aVar.pEX.field_msgId), Integer.valueOf(aVar.pEX.field_localId)});
                x.w("MicroMsg.RecordMsgSendService", "try upload from local");
                Iterator it2 = aVar.pEX.field_dataProto.weU.iterator();
                while (it2.hasNext()) {
                    String d;
                    uq uqVar = (uq) it2.next();
                    if (uqVar.wde > 0) {
                        d = h.d(uqVar.mvG, aVar.pEX.field_msgId, false);
                        if (n.getRecordMsgCDNStorage().Ij(d) == null) {
                            f fVar = new f();
                            fVar.field_cdnKey = uqVar.wcL;
                            fVar.field_cdnUrl = uqVar.wcJ;
                            fVar.field_dataId = uqVar.mvG;
                            fVar.field_mediaId = d;
                            fVar.field_totalLen = (int) uqVar.wde;
                            fVar.field_localId = fVar.field_mediaId.hashCode();
                            fVar.field_path = h.c(uqVar, aVar.pEX.field_msgId);
                            fVar.field_type = 2;
                            fVar.field_fileType = h.vs(uqVar.bjS);
                            fVar.field_recordLocalId = aVar.pEX.field_localId;
                            fVar.field_toUser = aVar.pEX.field_toUser;
                            fVar.field_isThumb = false;
                            boolean a = n.getRecordMsgCDNStorage().a(fVar);
                            x.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(fVar.field_localId), Boolean.valueOf(a)});
                        }
                    }
                    if (uqVar.wdp > 0) {
                        d = h.Ac(uqVar.mvG);
                        String d2 = h.d(d, aVar.pEX.field_msgId, false);
                        if (n.getRecordMsgCDNStorage().Ij(d2) == null) {
                            f fVar2 = new f();
                            fVar2.field_cdnKey = uqVar.wcF;
                            fVar2.field_cdnUrl = uqVar.hbj;
                            fVar2.field_dataId = d;
                            fVar2.field_mediaId = d2;
                            fVar2.field_totalLen = (int) uqVar.wdp;
                            fVar2.field_localId = fVar2.field_mediaId.hashCode();
                            fVar2.field_path = h.f(uqVar, aVar.pEX.field_msgId);
                            fVar2.field_type = 2;
                            fVar2.field_fileType = b.MediaType_FULLSIZEIMAGE;
                            fVar2.field_recordLocalId = aVar.pEX.field_localId;
                            fVar2.field_toUser = aVar.pEX.field_toUser;
                            fVar2.field_isThumb = true;
                            boolean a2 = n.getRecordMsgCDNStorage().a(fVar2);
                            x.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(fVar2.field_localId), Boolean.valueOf(a2)});
                        }
                    }
                }
                n.bmU().run();
                return;
        }
        this.pFa = false;
        a(null);
    }

    public final void a(int i, f fVar) {
        if (1 != i) {
            x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", new Object[]{Integer.valueOf(i)});
        } else if (fVar == null) {
            x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
        } else if (2 != fVar.field_type) {
            x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload");
        } else if (fVar.field_status == 0 || 1 == fVar.field_status) {
            x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
        } else {
            Object obj;
            List<f> vp = n.getRecordMsgCDNStorage().vp(fVar.field_recordLocalId);
            for (f fVar2 : vp) {
                if (fVar2.field_status != 0) {
                    if (1 == fVar2.field_status) {
                    }
                }
                x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[]{fVar2.field_mediaId});
                obj = null;
            }
            int i2 = 1;
            if (obj != null) {
                g vr = n.bmS().vr(fVar.field_recordLocalId);
                String str = "MicroMsg.RecordMsgSendService";
                String str2 = "finish get record info, id %d result %B";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(fVar.field_recordLocalId);
                objArr[1] = Boolean.valueOf(vr != null);
                x.d(str, str2, objArr);
                if (vr != null) {
                    List<uq> list = vr.field_dataProto.weU;
                    for (f fVar22 : vp) {
                        x.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", new Object[]{fVar22.field_dataId, Boolean.valueOf(fVar22.field_isThumb)});
                        if (!fVar22.field_isThumb) {
                            for (uq uqVar : list) {
                                if (fVar22.field_dataId.equals(uqVar.mvG)) {
                                    x.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[]{uqVar.wcL, fVar22.field_cdnKey, uqVar.wcJ, fVar22.field_cdnUrl, Long.valueOf(uqVar.wde), Integer.valueOf(fVar22.field_totalLen)});
                                    uqVar.Tv(fVar22.field_cdnKey);
                                    uqVar.Tu(fVar22.field_cdnUrl);
                                    break;
                                }
                            }
                        }
                        for (uq uqVar2 : list) {
                            if (fVar22.field_dataId.equals(h.Ac(uqVar2.mvG))) {
                                x.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[]{uqVar2.wcF, fVar22.field_cdnKey, uqVar2.hbj, fVar22.field_cdnUrl, Long.valueOf(uqVar2.wdp), Integer.valueOf(fVar22.field_totalLen)});
                                uqVar2.Tt(fVar22.field_cdnKey);
                                uqVar2.Ts(fVar22.field_cdnUrl);
                                break;
                            }
                        }
                    }
                    ar.Hg();
                    cf dH = com.tencent.mm.z.c.Fa().dH(vr.field_msgId);
                    x.i("MicroMsg.RecordMsgSendService", "update msg content, msg null ? %B, msgId %d recordInfoId %d", new Object[]{Boolean.valueOf(false), Long.valueOf(dH.field_msgId), Long.valueOf(vr.field_msgId)});
                    if (dH.field_msgId == vr.field_msgId) {
                        dH.setContent(h.a(vr.field_title, vr.field_desc, vr.field_dataProto, vr.field_favFrom));
                        dH.eQ(1);
                        ar.Hg();
                        com.tencent.mm.z.c.Fa().a(vr.field_msgId, dH);
                    }
                    com.tencent.mm.sdk.e.c fp = an.bYS().fp(vr.field_msgId);
                    if (fp != null) {
                        fp.field_xml = dH.field_content;
                        an.bYS().c(fp, new String[]{"msgId"});
                    }
                    n.bmS().vq(vr.field_localId);
                    this.pFd.remove(vr.field_localId);
                    an.bYU();
                    a.ft(vr.field_msgId);
                }
                for (f fVar222 : vp) {
                    n.getRecordMsgCDNStorage().a(fVar222, new String[]{"localId"});
                }
                this.pFa = false;
                a(null);
            }
        }
    }
}

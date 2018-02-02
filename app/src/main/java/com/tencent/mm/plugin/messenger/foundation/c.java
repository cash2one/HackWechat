package com.tencent.mm.plugin.messenger.foundation;

import android.database.Cursor;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.qa;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.bb;
import com.tencent.mm.z.q;
import java.util.List;

public final class c implements p {
    public final void a(ol olVar, byte[] bArr, boolean z, r rVar) {
        int i;
        switch (olVar.vXp) {
            case 5:
                bw bwVar = (bw) new bw().aF(bArr);
                if (bwVar != null) {
                    a aVar = new a(bwVar, false, false, false);
                    a(aVar, rVar);
                    if (!aVar.hmr) {
                        bb.a(n.a(bwVar.vGX), bwVar.vHe, ((long) bwVar.pbl) * 1000, bwVar.ngq);
                        return;
                    }
                    return;
                }
                return;
            case 8:
                qa qaVar = (qa) new qa().aF(bArr);
                String a = n.a(qaVar.vYI);
                i = qaVar.vYM;
                Cursor bB = ((h) g.h(h.class)).aZi().bB(a, i);
                if (bB.moveToFirst()) {
                    while (!bB.isAfterLast()) {
                        au auVar = new au();
                        auVar.b(bB);
                        ba.j(auVar);
                        bB.moveToNext();
                    }
                }
                bB.close();
                ((h) g.h(h.class)).aZi().bA(a, i);
                return;
            case 9:
                qg qgVar = (qg) new qg().aF(bArr);
                List list = qgVar.vYP;
                for (i = 0; i < list.size(); i++) {
                    ba.o(n.a(qgVar.vYI), (long) ((Integer) list.get(i)).intValue());
                }
                return;
            default:
                return;
        }
    }

    public static void a(a aVar, r rVar) {
        com.tencent.mm.bq.a aVar2 = aVar.hmq;
        if (10008 == com.tencent.mm.platformtools.r.idt && com.tencent.mm.platformtools.r.idu != 0) {
            x.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", new Object[]{Long.valueOf(aVar2.vHe), Integer.valueOf(com.tencent.mm.platformtools.r.idu)});
            aVar2.vHe = Long.valueOf((long) com.tencent.mm.platformtools.r.idu).longValue();
            com.tencent.mm.platformtools.r.idu = 0;
        }
        if (((h) g.h(h.class)).aZi().dJ(aVar2.vHe)) {
            x.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
            return;
        }
        String a = n.a(aVar2.vGX);
        String a2 = n.a(aVar2.vGY);
        if (a.equals(q.FS()) && a2.equals("newsapp") && aVar2.ngq != 51) {
            x.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", new Object[]{Long.valueOf(aVar2.vHe), Integer.valueOf(aVar2.ngq)});
            return;
        }
        String str = "MicroMsg.MessageSyncExtension";
        String str2 = "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s";
        Object[] objArr = new Object[15];
        objArr[0] = a;
        objArr[1] = a2;
        objArr[2] = Long.valueOf(aVar2.vHe);
        objArr[3] = Integer.valueOf(aVar2.vGW);
        objArr[4] = Integer.valueOf(aVar2.vHf);
        objArr[5] = Integer.valueOf(aVar2.ktm);
        objArr[6] = Integer.valueOf(aVar2.ngq);
        objArr[7] = Integer.valueOf(aVar2.pbl);
        objArr[8] = bh.fJ((long) aVar2.pbl);
        objArr[9] = Long.valueOf(bh.Wo() - ((long) aVar2.pbl));
        objArr[10] = Integer.valueOf(aVar2.vHa);
        objArr[11] = Integer.valueOf(n.a(aVar2.vHb, new byte[0]).length);
        objArr[12] = Integer.valueOf(bh.ou(aVar2.vHc).length());
        objArr[13] = Integer.valueOf(bh.ou(aVar2.vHd).length());
        bdo com_tencent_mm_protocal_c_bdo = aVar2.vGZ;
        a2 = "";
        if (com_tencent_mm_protocal_c_bdo != null) {
            a2 = com_tencent_mm_protocal_c_bdo.wJF;
        }
        objArr[14] = bh.VT(a2);
        x.i(str, str2, objArr);
        x.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[]{aVar2.vHc, ""});
        s.h(aVar2);
        if (a.equals("readerapp")) {
            aVar2.vGX = n.os("newsapp");
            aVar2.ngq = 12399999;
        }
        if ((a.equals("blogapp") || a.equals("newsapp")) && aVar2.ngq != 10002) {
            aVar2.ngq = 12399999;
        }
        if (aVar2.ngq == 52) {
            aVar2.ngq = 1000052;
        }
        if (aVar2.ngq == 53) {
            aVar2.ngq = 1000053;
        }
        if (!(aVar == null || aVar.hmq == null)) {
            bw bwVar = aVar.hmq;
            cf F = ((h) g.h(h.class)).aZi().F(n.a(bwVar.vGX), bwVar.vHe);
            if (F.field_msgId != 0 && (F.field_isSend == 0 || bwVar.vHf != 0)) {
                int i;
                i = F.field_flag;
                i = aVar.hmr ? i | 2 : i & -3;
                i = aVar.hms ? i | 1 : i & -2;
                i = aVar.hmt ? i | 4 : i & -5;
                if (i != F.field_flag) {
                    x.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", new Object[]{Integer.valueOf(bwVar.ngq), Integer.valueOf(i), Integer.valueOf(F.field_flag)});
                    F.fa(i);
                    ((h) g.h(h.class)).aZi().b(F.field_msgSvrId, F);
                }
            }
        }
        Object obj = null;
        d aU = com.tencent.mm.ae.d.c.aU(Integer.valueOf(aVar2.ngq));
        if (aU == null) {
            aU = com.tencent.mm.ae.d.c.aU(a);
        }
        if (aU != null) {
            b b = aU.b(aVar);
            cf cfVar = b == null ? null : b.fnB;
            if (cfVar == null) {
                x.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", new Object[]{Integer.valueOf(aVar2.ngq), Long.valueOf(aVar2.vHe), Integer.valueOf(aVar2.vHf), Integer.valueOf(aVar2.pbl), aVar});
                if (aVar.hmr && aVar.hms) {
                    cfVar = ((h) g.h(h.class)).aZi().Q(a, (long) aVar2.vHf);
                    if (cfVar == null || cfVar.field_msgId == 0) {
                        a = "MicroMsg.MessageSyncExtension";
                        str2 = "summerbadcr extension declared but skipped msg and must revised fault id failed[%d]";
                        objArr = new Object[1];
                        objArr[0] = Long.valueOf(cfVar != null ? cfVar.field_msgId : -1);
                        x.i(a, str2, objArr);
                    } else {
                        i = cfVar.field_flag;
                        x.i("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg and must revised fault id[%d], flag[%d], svrId[%d], msgseq[%d], createtime[%d], type[%d]", new Object[]{Long.valueOf(cfVar.field_msgId), Integer.valueOf(cfVar.field_flag), Long.valueOf(cfVar.field_msgSvrId), Long.valueOf(cfVar.field_msgSeq), Long.valueOf(cfVar.field_createTime), Integer.valueOf(cfVar.getType())});
                        cfVar.fa((i | 2) | 1);
                        ((h) g.h(h.class)).aZi().a(cfVar.field_msgId, cfVar);
                    }
                }
                obj = 1;
            } else {
                obj = (!com.tencent.mm.z.s.gJ(a) || com.tencent.mm.ar.b.PT()) ? null : 1;
                if (obj == null) {
                    x.d("MicroMsg.MessageSyncExtension", " msg , id =" + cfVar.field_msgId + "  " + rVar);
                    if (cfVar.field_msgId > 0 && rVar != null && b.hmu) {
                        rVar.a(cfVar, aVar2);
                    }
                }
                obj = 1;
            }
        }
        s.b(5, aVar2);
        if (obj == null) {
            x.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", new Object[]{Integer.valueOf(aVar2.ngq)});
        }
    }
}

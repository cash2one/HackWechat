package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.u;
import java.io.File;

class c$b {
    static boolean a(Context context, a aVar) {
        if (aVar == null || context == null) {
            return false;
        }
        if (aVar.type == 3) {
            return g.m(context, 16);
        }
        if (aVar.type == 4) {
            return g.m(context, 8);
        }
        if (aVar.type == 5) {
            return g.m(context, 32);
        }
        if (aVar.type != 6) {
            return false;
        }
        Long Rc = b.a.Rc(aVar.hbc);
        if (Rc != null) {
            return g.m(context, Rc.longValue());
        }
        return false;
    }

    static void a(ChattingUI.a aVar, au auVar, String str) {
        String dk = aVar.dk(auVar.field_content, auVar.field_isSend);
        Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", dk);
        intent.putExtra("Retr_MsgFromScene", 2);
        a fT = a.fT(dk);
        if (fT != null && 19 == fT.type) {
            intent.putExtra("Retr_Msg_Type", 10);
        } else if (fT != null && 24 == fT.type) {
            intent.putExtra("Retr_Msg_Type", 10);
        } else if (fT == null || 16 != fT.type) {
            intent.putExtra("Retr_Msg_Type", 2);
            dk = auVar.field_talker;
            String hz = u.hz(auVar.field_msgSvrId);
            intent.putExtra("reportSessionId", hz);
            u.b t = u.GK().t(hz, true);
            t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
            t.o("preUsername", str);
            t.o("preChatName", dk);
            if (!(fT == null || fT.r(com.tencent.mm.y.a.class) == null)) {
                t.o("appservicetype", Integer.valueOf(((com.tencent.mm.y.a) fT.r(com.tencent.mm.y.a.class)).haB));
                intent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.y.a) fT.r(com.tencent.mm.y.a.class)).haB);
            }
            if (fT != null && 33 == fT.type) {
                if (aVar.ysk) {
                    t.o("fromScene", Integer.valueOf(2));
                    intent.putExtra("Retr_MsgAppBrandFromScene", 2);
                } else {
                    t.o("fromScene", Integer.valueOf(1));
                    intent.putExtra("Retr_MsgAppBrandFromScene", 1);
                }
                intent.putExtra("Retr_MsgFromUserName", str);
                intent.putExtra("Retr_MsgTalker", auVar.field_talker);
            }
            t.o("sendAppMsgScene", Integer.valueOf(1));
            ((i) com.tencent.mm.kernel.g.h(i.class)).a("adExtStr", t, auVar);
        } else {
            intent.putExtra("Retr_Msg_Type", 14);
        }
        intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
        if (fT == null || fT.type != 6) {
            aVar.startActivity(intent);
            return;
        }
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[6];
        objArr[0] = fT.hbi;
        objArr[1] = Integer.valueOf(fT.hbf == 1 ? 7 : 5);
        objArr[2] = Integer.valueOf(fT.hbb);
        objArr[3] = Integer.valueOf(2);
        objArr[4] = Long.valueOf((System.currentTimeMillis() - auVar.field_createTime) / 1000);
        objArr[5] = fT.hbc;
        gVar.h(14665, objArr);
        boolean z = fT.hbf != 0 || fT.hbb > 26214400;
        intent.putExtra("Retr_Big_File", z);
        com.tencent.mm.pluginsdk.model.app.b RI = l.RI(fT.fny);
        if (RI != null) {
            File file = new File(RI.field_fileFullPath);
            if (file.exists() && file.length() == RI.field_totalLen) {
                aVar.startActivity(intent);
                return;
            } else if (RI.field_offset > 0 && RI.field_totalLen > RI.field_offset) {
                a(aVar, intent, auVar, RI.field_fileFullPath);
                return;
            }
        }
        x.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", new Object[]{Integer.valueOf(fT.hbb), fT.hbi, bh.VT(fT.hbp)});
        if (z) {
            intent.putExtra("Retr_Big_File", z);
            com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
            iVar.htt = new 1(aVar, intent, auVar, RI);
            iVar.field_mediaId = d.a("checkExist", bh.Wp(), str, auVar.field_msgId);
            iVar.field_fileId = fT.hbi;
            iVar.field_aesKey = fT.hbp;
            iVar.field_filemd5 = fT.filemd5;
            iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrM;
            iVar.field_talker = str;
            iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
            iVar.field_svr_signature = "";
            iVar.field_onlycheckexist = true;
            x.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.modelcdntran.g.MJ().c(iVar)), iVar.field_fileId, iVar.field_mediaId, bh.VT(iVar.field_aesKey)});
            if (!com.tencent.mm.modelcdntran.g.MJ().c(iVar)) {
                a(aVar, intent, auVar, null);
                return;
            }
            return;
        }
        a(aVar, intent, auVar, null);
    }

    private static void a(ChattingUI.a aVar, Intent intent, au auVar, String str) {
        if (auVar.cjs() || c(auVar, str)) {
            x.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
            h.a(aVar.getContext(), aVar.getContext().getString(R.l.ehl), aVar.getContext().getString(R.l.dGO), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return;
        }
        aVar.startActivity(intent);
    }

    public static boolean c(au auVar, String str) {
        if (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bh.ov(str) && e.bO(str))) {
            return false;
        }
        return true;
    }
}

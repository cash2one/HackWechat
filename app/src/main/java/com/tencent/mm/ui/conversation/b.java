package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelmulti.b.a;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.l;
import com.tencent.mm.z.s;

public final class b {
    static /* synthetic */ void a(Context context, boolean z, String str) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.putExtra("chat_from_scene", 4);
            d.a(context, ".ui.chatting.ChattingUI", intent);
            return;
        }
        LauncherUI cmG = LauncherUI.cmG();
        if (cmG != null) {
            cmG.startChatting(str, null, true);
        }
    }

    static /* synthetic */ void a(String str, PBool pBool, ProgressDialog progressDialog) {
        if (l.ga(str)) {
            q.Qd().a(new a(str, 0, 0, 0, 0));
        }
        ba.a(str, new 4(pBool, progressDialog, str));
    }

    static /* synthetic */ void a(String str, ae aeVar, PBool pBool, ProgressDialog progressDialog) {
        ba.a(str, new 3(pBool, progressDialog));
        ar.Hg();
        af WO = c.EY().WO(str);
        WO.An();
        WO.Ao();
        if (WO.cia() && f.jT(str)) {
            g.pQN.h(13773, Integer.valueOf(0), Integer.valueOf(aeVar.field_unReadCount), Integer.valueOf(1), aeVar.field_username);
        }
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_arp = new arp();
        x.i("MicroMsg.ConvDelLogic", "oplog modContact user:%s remark:%s type:%d ", WO.field_username, WO.field_conRemark, Integer.valueOf(WO.field_type));
        com_tencent_mm_protocal_c_arp.vYI = new bdo().UA(t.ou(WO.field_username));
        com_tencent_mm_protocal_c_arp.wsB = new bdo().UA(t.ou(WO.field_nickname));
        com_tencent_mm_protocal_c_arp.vYw = new bdo().UA(t.ou(WO.vQ()));
        com_tencent_mm_protocal_c_arp.vYx = new bdo().UA(t.ou(WO.vR()));
        com_tencent_mm_protocal_c_arp.hvt = WO.fWf;
        com_tencent_mm_protocal_c_arp.vXM = 561023;
        com_tencent_mm_protocal_c_arp.vXN = WO.field_type;
        com_tencent_mm_protocal_c_arp.wyH = new bdo().UA(t.ou(WO.field_conRemark));
        com_tencent_mm_protocal_c_arp.wyI = new bdo().UA(t.ou(WO.field_conRemarkPYShort));
        com_tencent_mm_protocal_c_arp.wyJ = new bdo().UA(t.ou(WO.field_conRemarkPYFull));
        com_tencent_mm_protocal_c_arp.vXS = WO.fWk;
        com_tencent_mm_protocal_c_arp.wzc = new bdo().UA(t.ou(WO.field_domainList));
        com_tencent_mm_protocal_c_arp.vXW = WO.fWn;
        com_tencent_mm_protocal_c_arp.hvx = WO.fWo;
        com_tencent_mm_protocal_c_arp.hvw = t.ou(WO.signature);
        com_tencent_mm_protocal_c_arp.hvv = t.ou(WO.getCityCode());
        com_tencent_mm_protocal_c_arp.hvu = t.ou(WO.cie());
        com_tencent_mm_protocal_c_arp.wvh = t.ou(WO.fWt);
        com_tencent_mm_protocal_c_arp.wvj = WO.field_weiboFlag;
        com_tencent_mm_protocal_c_arp.wyY = 0;
        com_tencent_mm_protocal_c_arp.vHb = new bdn();
        com_tencent_mm_protocal_c_arp.hvC = t.ou(WO.getCountryCode());
        ar.Hg();
        c.EX().b(new e.a(2, com_tencent_mm_protocal_c_arp));
        ar.Hg();
        c.EY().a(str, WO);
        ar.Hg();
        aj WY = c.Fd().WY(str);
        ar.Hg();
        c.Fd().WX(str);
        if (WY == null) {
            return;
        }
        if (WY.gc(4194304) || (WO.cia() && !com.tencent.mm.l.a.fZ(WO.field_type) && WY.field_conversationTime < y.Mr())) {
            ar.CG().a(new i(str), 0);
        }
    }

    public static void a(String str, Context context, ae aeVar, Runnable runnable, boolean z, boolean z2) {
        PBool pBool = new PBool();
        String str2;
        if (s.eV(str)) {
            str2 = null;
            ar.Hg();
            cf Ew = c.Fa().Ew(str);
            ar.Hg();
            c.EX().b(new com.tencent.mm.ay.d(str, Ew.field_msgSvrId));
            pBool.value = false;
            context.getString(R.l.dGO);
            ProgressDialog a = h.a(context, context.getString(R.l.dHc), true, new 1(pBool));
            if (!pBool.value) {
                str2 = com.tencent.mm.pluginsdk.wallet.e.SZ(str);
            }
            if (t.ov(str2)) {
                a.dismiss();
                h.a(context, context.getString(R.l.eiC), "", context.getString(R.l.dEw), context.getString(R.l.dEn), new 9(str, pBool, a, runnable), null, R.e.brm);
            } else {
                a.dismiss();
                h.a(context, false, context.getString(R.l.eWe, new Object[]{str2}), null, context.getString(R.l.enD), context.getString(R.l.dYk), new 7(pBool, context, z2, str, z), new 8(a, pBool, str, z, runnable), -1, R.e.brm);
            }
        } else if (s.gV(str)) {
            ar.Hg();
            c.Fd().EE(str);
            com.tencent.mm.sdk.b.b mhVar = new mh();
            mhVar.fEe.opType = 4;
            mhVar.fEe.fEj = 20;
            com.tencent.mm.sdk.b.a.xef.m(mhVar);
        } else if (s.gL(str)) {
            ar.Hg();
            c.Fd().EE(str);
        } else if (s.gO(str)) {
            ar.Hg();
            c.Fd().WX(str);
        } else if (f.eE(str)) {
            pBool.value = false;
            context.getString(R.l.dGO);
            ProgressDialog a2 = h.a(context, context.getString(R.l.dHc), true, new 10(pBool));
            a2.dismiss();
            h.a(context, context.getString(R.l.eiA), "", context.getString(R.l.dEw), context.getString(R.l.dEn), new 11(str, pBool, a2, str), null, R.e.brm);
        } else {
            ar.Hg();
            cf Ew2 = c.Fa().Ew(str);
            ar.Hg();
            c.EX().b(new com.tencent.mm.ay.d(str, Ew2.field_msgSvrId));
            pBool.value = false;
            context.getString(R.l.dGO);
            ProgressDialog a3 = h.a(context, context.getString(R.l.dHc), true, new 12(pBool));
            str2 = null;
            if (!pBool.value) {
                str2 = com.tencent.mm.pluginsdk.wallet.e.SZ(str);
            }
            if (t.ov(str2)) {
                a3.dismiss();
                h.a(context, context.getString(s.hd(str) ? R.l.eiB : R.l.eiA), "", context.getString(R.l.dEw), context.getString(R.l.dEn), new 2(context, str, aeVar, pBool, a3, runnable), null, R.e.brm);
            } else {
                a3.dismiss();
                h.a(context, false, context.getString(R.l.eWe, new Object[]{str2}), null, context.getString(R.l.enD), context.getString(R.l.dYk), new 13(pBool, context, z2, str, z), new 14(a3, pBool, context, str, aeVar, runnable, z), -1, R.e.brm);
            }
        }
        if (s.gM(str)) {
            x.i("MicroMsg.ConvDelLogic", "del all qmessage");
            ba.Hy();
            ar.Hg();
            c.Fd().EE("@qqim");
        } else if (s.gK(str)) {
            x.i("MicroMsg.ConvDelLogic", "del all tmessage");
            ba.Hz();
            ar.Hg();
            c.Fd().EE("@t.qq.com");
        }
    }
}

package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.ax.a.b;
import com.tencent.mm.ay.e;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.b.c.3;
import com.tencent.mm.ui.chatting.b.c.4;
import com.tencent.mm.ui.chatting.b.c.5;
import com.tencent.mm.ui.chatting.b.c.6;
import com.tencent.mm.ui.chatting.g.a;
import com.tencent.mm.ui.chatting.g.c;
import com.tencent.mm.ui.chatting.g.d;
import com.tencent.mm.ui.chatting.x;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class y implements b, a.b {
    private l contextMenuHelper;
    p fhr;
    public final x yBL;
    public com.tencent.mm.ui.chatting.g.b yBM;
    public c yBN;
    public d yBO;
    public int yBP;
    public int yBQ;
    public int yBR;
    public q yvR;
    public a ywa;
    public e ywc;
    public c ywd;

    public y(p pVar) {
        this.fhr = pVar;
        this.yBL = new x(pVar);
    }

    public final void aA(LinkedList<String> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            aB(linkedList);
        }
    }

    public final void a(View view, a.a aVar) {
        if (view != null && aVar != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(aVar.username);
            a(view, linkedList, aVar.hOf);
        }
    }

    public final void aH(au auVar) {
        if (!this.fhr.csi().field_username.equals("medianote")) {
            ar.Hg();
            com.tencent.mm.z.c.EX().b(new e(auVar.field_talker, auVar.field_msgSvrId));
        }
        af.aH(auVar);
        this.fhr.mM(true);
    }

    public final boolean dm(String str, int i) {
        int i2 = 0;
        String VX = bh.VX(str);
        if (VX == null || VX.length() == 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.TextImp", "doSendMessage null");
            return false;
        }
        x xVar = this.yBL;
        if (!t.ov(VX)) {
            au auVar = new au();
            auVar.setContent(VX);
            auVar.eR(1);
            xVar.aB(auVar);
        }
        com.tencent.mm.sdk.b.b bsVar = new bs();
        bsVar.fpT.fpV = VX;
        bsVar.fpT.context = this.fhr.csq().getContext();
        com.tencent.mm.sdk.b.a.xef.m(bsVar);
        if (bsVar.fpU.fpW) {
            return true;
        }
        if (this.fhr.csw() != null) {
            String str2 = null;
            String XH = this.fhr.csw().xzU.XH("");
            if (XH.equalsIgnoreCase("@t.qq.com") && !this.fhr.csw().isEnable()) {
                str2 = this.fhr.csq().getMMString(R.l.ejj);
            } else if (XH.equalsIgnoreCase("@qqim") && (q.FW() & 64) == 0) {
                str2 = this.fhr.csq().getMMString(R.l.eji);
            } else if (!this.fhr.csw().isEnable()) {
                str2 = this.fhr.csq().getMMString(R.l.ejh, new Object[]{com.tencent.mm.l.a.fb(this.fhr.csw().name)});
            }
            if (str2 != null) {
                h.b(this.fhr.csq().getContext(), str2, this.fhr.csq().getMMString(R.l.dGO), true);
                return false;
            }
        }
        boolean z = HardCoderJNI.hcSendMsgEnable;
        int i3 = HardCoderJNI.hcSendMsgDelay;
        int i4 = HardCoderJNI.hcSendMsgCPU;
        int i5 = HardCoderJNI.hcSendMsgIO;
        if (HardCoderJNI.hcSendMsgThr) {
            i2 = g.Dm().cfD();
        }
        this.yBR = HardCoderJNI.startPerformance(z, i3, i4, i5, i2, HardCoderJNI.hcSendMsgTimeout, 202, HardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.TextImp");
        this.fhr.css().post(new 1(this, VX, i));
        this.fhr.mM(true);
        return true;
    }

    private void aB(LinkedList<String> linkedList) {
        if (this.fhr.csf()) {
            c cVar = this.ywd;
            com.tencent.mm.ag.y.Mh().ag(cVar.cti());
            LinkedList linkedList2 = new LinkedList();
            List Ms = cVar.ync.Ms();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (Ms != null && Ms.contains(str)) {
                    linkedList2.add(str);
                }
            }
            if (linkedList2.size() != 0) {
                h.a(cVar.fhr.csq().getContext(), cVar.fhr.csq().getMMString(R.l.eFc, new Object[]{cVar.ay(linkedList2)}), null, cVar.fhr.csq().getMMString(R.l.eFj), cVar.fhr.csq().getMMString(R.l.dEn), true, new 5(cVar, linkedList2), new 6(cVar));
                return;
            } else if (linkedList.size() == 1) {
                h.a(cVar.fhr.csq().getContext(), cVar.fhr.csq().getMMString(R.l.eFh), null, cVar.fhr.csq().getMMString(R.l.eFi), new 3(cVar));
                return;
            } else {
                h.a(cVar.fhr.csq().getContext(), cVar.fhr.csq().getMMString(R.l.eFd), null, cVar.fhr.csq().getMMString(R.l.eFi), new 4(cVar));
                return;
            }
        }
        this.ywc.az(linkedList);
    }

    private void a(View view, LinkedList<String> linkedList, String str) {
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new l(this.fhr.csq().getContext());
        }
        this.contextMenuHelper.b(view, new 2(this), new 3(this, linkedList, str));
    }

    public final void a(View view, au auVar, com.tencent.mm.ax.a aVar, int i) {
        if (aVar instanceof com.tencent.mm.ax.d) {
            com.tencent.mm.ax.d dVar = (com.tencent.mm.ax.d) aVar;
            String ou = bh.ou(dVar.hIu);
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.TextImp", "click delchatroommember link %s,isBizChat:%s", new Object[]{ou, Boolean.valueOf(this.ywd.vnK)});
            if (dVar.hII == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.TextImp", "click members is null!!!");
            } else if (!this.fhr.csd()) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.TextImp", "not group chat !!!!!");
            } else if (ou.equals("invite")) {
                aB(dVar.hII);
            } else if (ou.equals("qrcode")) {
                a(view, dVar.hII, dVar.fBq);
            } else if (ou.equals("webview") && !bh.ov(dVar.url)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", dVar.url);
                intent.putExtra("geta8key_username", q.FS());
                com.tencent.mm.bm.d.b(this.fhr.csq().getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
        } else if (aVar instanceof com.tencent.mm.ax.c) {
            com.tencent.mm.ax.c cVar = (com.tencent.mm.ax.c) aVar;
            if (i == 0) {
                a aVar2 = this.ywa;
                String str = cVar.hIF;
                String str2 = cVar.hIG;
                String str3 = cVar.hIz;
                String str4 = cVar.frP;
                List list = cVar.hIA;
                List list2 = cVar.hID;
                List list3 = cVar.hIE;
                Intent intent2 = new Intent();
                intent2.putExtra("msgLocalId", auVar.field_msgId);
                intent2.putExtra("invitertitle", aVar2.fhr.csq().getString(R.l.dCd, new Object[]{Integer.valueOf(list.size())}));
                intent2.putExtra("inviterusername", str);
                intent2.putExtra("chatroom", str3);
                intent2.putExtra("invitationreason", str2);
                intent2.putExtra("ticket", str4);
                intent2.putExtra("username", bh.d(list, ","));
                intent2.putExtra("nickname", bh.d(list2, ","));
                intent2.putExtra("headimgurl", bh.d(list3, ","));
                com.tencent.mm.bm.d.b(aVar2.fhr.csq().getContext(), "chatroom", ".ui.SeeAccessVerifyInfoUI", intent2);
            }
        } else if (aVar instanceof com.tencent.mm.ax.b) {
            com.tencent.mm.ax.b bVar = (com.tencent.mm.ax.b) aVar;
            List arrayList = new ArrayList();
            arrayList.addAll(bVar.hIA);
            e eVar = this.ywc;
            k kVar = new com.tencent.mm.plugin.chatroom.d.k(eVar.fhr.cse() ? eVar.fhr.csi().field_username : "", arrayList, bVar.frP, auVar);
            ar.CG().a(kVar, 0);
            Context context = eVar.fhr.csq().getContext();
            eVar.fhr.csq().getString(R.l.dGO);
            eVar.fhr.b(h.a(context, eVar.fhr.csq().getString(R.l.eFy), true, new e.3(eVar, kVar)));
        } else if (aVar instanceof com.tencent.mm.ui.chatting.d.a) {
            ar.Hg();
            if (((Boolean) com.tencent.mm.z.c.CU().get(w.a.xqz, Boolean.valueOf(true))).booleanValue()) {
                h.a(this.fhr.csq().getContext(), this.fhr.csq().getMMString(R.l.eqq), this.fhr.csq().getMMString(R.l.cRU), this.fhr.csq().getMMString(R.l.epk), new 4(this, view, aVar));
            } else {
                a(view, (com.tencent.mm.ui.chatting.d.a) aVar);
            }
        }
    }

    final void a(final View view, com.tencent.mm.ui.chatting.d.a aVar) {
        ar.Hg();
        com.tencent.mm.z.c.CU().a(w.a.xqz, Boolean.valueOf(false));
        final au auVar = aVar.fEJ;
        if (System.currentTimeMillis() - aVar.yGY >= 300000) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI.TextImp", "[handleClickInvokeMessageSysText] it's over time to copy invoke message!");
            h.b(this.fhr.csq().getContext(), this.fhr.csq().getMMString(R.l.eqr), this.fhr.csq().getMMString(R.l.dGO), true);
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ y yBS;

                public final void run() {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.TextImp", "[handleClickInvokeMessageSysText] is over time to delete invokeMsg:%s", new Object[]{Long.valueOf(auVar.field_msgId)});
                    z.a(this.yBS.fhr.csq().getMMString(R.l.dSM), "", auVar, "");
                    ar.Hg();
                    com.tencent.mm.z.c.Fa().a(auVar.field_msgId, auVar);
                    ag.y(new 1(this));
                }
            }, "deleteInvokeMsg");
            return;
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(15037, new Object[]{Integer.valueOf(1)});
        this.fhr.csB().Sy(this.fhr.csB().cbs() + aVar.yGX);
        if (!this.fhr.csB().cbQ()) {
            this.fhr.csq().showVKB();
        }
    }
}

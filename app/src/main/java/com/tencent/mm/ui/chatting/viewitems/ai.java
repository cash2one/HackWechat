package com.tencent.mm.ui.chatting.viewitems;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public final class ai extends b {
    private e hPs;
    private ProgressDialog qib;
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (i == -1879048189) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.deh);
        view.setTag(new an().dG(view));
        return view;
    }

    protected final boolean cvx() {
        return false;
    }

    public final void a(b.a aVar, final int i, a aVar2, final au auVar, String str) {
        String S;
        an anVar = (an) aVar;
        this.yqa = aVar2;
        g fp = an.bYS().fp(auVar.field_msgId);
        String str2 = auVar.field_content;
        g.a aVar3 = null;
        if (!(fp == null || str2 == null)) {
            aVar3 = g.a.fT(str2);
        }
        boolean z = false;
        com.tencent.mm.plugin.subapp.c.e Mj = com.tencent.mm.plugin.subapp.c.e.Mj(str2);
        if (!(Mj == null || Mj.rWq == 0)) {
            try {
                S = n.S(this.yqa.getContext(), Mj.rWq);
                if (!(aVar3 == null || aVar3.description == null)) {
                    int indexOf = aVar3.description.indexOf(124);
                    if (indexOf <= 0 || aVar3.description.length() <= indexOf + 1) {
                        anVar.iir.setText("");
                    } else {
                        anVar.iir.setText(aVar3.description.substring(indexOf + 1));
                    }
                }
                if (S != null && S.length() > 0) {
                    String[] split = S.split(";");
                    anVar.yOp.setText(split[0]);
                    if (split.length > 1) {
                        anVar.yOq.setText(split[1]);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", e, "", new Object[0]);
            }
            z = t.iX(Mj.rWq);
        }
        if (z) {
            anVar.yOt.setVisibility(0);
            anVar.iir.setTextColor(this.yqa.getResources().getColor(R.e.buc));
            anVar.yOq.setTextColor(this.yqa.getResources().getColor(R.e.buc));
            anVar.yOp.setTextColor(this.yqa.getResources().getColor(R.e.buc));
        } else {
            anVar.yOt.setVisibility(8);
            anVar.iir.setTextColor(this.yqa.getResources().getColor(R.e.bub));
            anVar.yOq.setTextColor(this.yqa.getResources().getColor(R.e.bub));
            anVar.yOp.setTextColor(this.yqa.getResources().getColor(R.e.bub));
        }
        anVar.yOr.setOnClickListener(new 1(this, auVar, i));
        Object obj = (this.yqa.ysf.ysR != null && this.yqa.ysf.ysR.isPlaying() && this.yqa.ysf.ysR.yqm == auVar.field_msgId) ? 1 : null;
        if (obj != null) {
            anVar.yOr.setBackgroundResource(R.g.bHk);
        } else {
            anVar.yOr.setBackgroundResource(R.g.bHl);
        }
        if (!(Mj == null || t.ov(Mj.rWs) || Mj.rWt <= 0 || !t.ov(auVar.field_reserved) || aVar3 == null)) {
            str2 = k.ns(q.FS());
            S = h.aJ(str2, false);
            auVar.dU(str2);
            ar.Hg();
            c.Fa().a(auVar.field_msgId, auVar);
            long j = auVar.field_msgId;
            int i2 = aVar3.sdkVer;
            String str3 = aVar3.appId;
            String str4 = Mj.rWs;
            int i3 = Mj.rWt;
            int i4 = aVar3.type;
            String str5 = aVar3.hbp;
            S = l.a(S, j, i2, str3, str4, i3, i4, aVar3.hbf);
            if (S != null) {
                com.tencent.mm.ae.n CG = ar.CG();
                e anonymousClass2 = new e(this) {
                    final /* synthetic */ ai yOa;

                    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
                        x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                        boolean z = false;
                        if (ak.a.hfO != null) {
                            z = ak.a.hfO.aJ(auVar.field_msgId);
                        }
                        if (!z && i == 0 && i2 == 0 && ((ab) kVar).getMediaId().equals(S)) {
                            au ae = au.ae(auVar);
                            ae.dT(auVar.field_reserved);
                            ae.ao(-1);
                            this.yOa.yqa.ysf.ysR.b(i, ae);
                        }
                        ar.CG().b(221, this.yOa.hPs);
                        this.yOa.hPs = null;
                    }
                };
                this.hPs = anonymousClass2;
                CG.a(221, anonymousClass2);
                com.tencent.mm.ae.k abVar = new ab(S);
                abVar.bYN();
                ar.CG().a(abVar, 0);
            }
        }
        if (t.ov(auVar.field_imgPath) && Mj.rWw > 0) {
            ar.Hg();
            cf F = c.Fa().F(auVar.field_talker, (long) Mj.rWw);
            if (!t.ov(F.field_imgPath)) {
                str2 = k.ns(q.FS());
                if (com.tencent.mm.sdk.platformtools.k.q(h.aJ(F.field_imgPath, false), h.aJ(str2, false), false)) {
                    auVar.dT(str2);
                    ar.Hg();
                    c.Fa().a(auVar.field_msgId, auVar);
                }
            }
        }
        if (t.ov(auVar.field_imgPath) && Mj != null && !t.ov(Mj.fny) && Mj.hbb > 0 && this.hPs == null) {
            str2 = k.ns(q.FS());
            S = h.aJ(str2, false);
            auVar.dT(str2);
            ar.Hg();
            c.Fa().a(auVar.field_msgId, auVar);
            b a = l.a(S, auVar.field_msgId, aVar3.sdkVer, aVar3.appId, aVar3.fny, aVar3.hbb);
            x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + a.field_mediaSvrId);
            if (a.field_mediaSvrId != null) {
                com.tencent.mm.ae.n CG2 = ar.CG();
                e 3 = new 3(this, a);
                this.hPs = 3;
                CG2.a(221, 3);
                ar.CG().a(new ab(a), 0);
            }
        }
        anVar.yOs.setOnClickListener(new 4(this, auVar, Mj));
        anVar.yIy.setTag(new ar(auVar, this.yqa.ypn, i, null, (byte) 0));
        ar.Hg();
        if (c.isSDCardAvailable()) {
            anVar.yIy.setOnLongClickListener(s(this.yqa));
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        int RH = l.RH(this.yqa.dk(auVar.field_content, auVar.field_isSend));
        g.a fT = g.a.fT(this.yqa.dk(auVar.field_content, auVar.field_isSend));
        if (fT.hbb <= 0 || (fT.hbb > 0 && RH >= 100)) {
            contextMenu.add(i, 111, 0, this.yqa.getString(R.l.eEC));
        }
        if (!this.yqa.csV()) {
            contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = auVar.field_content;
                g.a aVar2 = null;
                if (str != null) {
                    aVar2 = g.a.fT(str);
                }
                if (aVar2 != null) {
                    l.fq(auVar.field_msgId);
                }
                ba.aK(auVar.field_msgId);
                break;
            case 111:
                Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", aVar.dk(auVar.field_content, auVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        return true;
    }
}

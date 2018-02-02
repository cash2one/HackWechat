package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public final class aj extends b {
    private e hPs;
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (i == -1879048190) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.dei);
        view.setTag(new ax().dH(view));
        return view;
    }

    public final String a(a aVar, au auVar) {
        return aVar.ysf.talker;
    }

    protected final boolean r(a aVar) {
        return false;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        String S;
        ax axVar = (ax) aVar;
        this.yqa = aVar2;
        g fp = an.bYS().fp(auVar.field_msgId);
        String str2 = auVar.field_content;
        g.a aVar3 = null;
        if (!(fp == null || str2 == null)) {
            aVar3 = g.a.I(str2, auVar.field_reserved);
        }
        com.tencent.mm.plugin.subapp.c.e Mj = com.tencent.mm.plugin.subapp.c.e.Mj(str2);
        if (!(Mj == null || Mj.rWq == 0)) {
            try {
                S = n.S(aVar2.getContext(), Mj.rWq);
                CharSequence charSequence = "";
                if (S != null && S.length() > 0) {
                    String[] split = S.split(";");
                    charSequence = charSequence + split[0].replace(" ", "");
                    if (split.length > 1) {
                        charSequence = charSequence + split[1];
                    }
                }
                if (!(aVar3 == null || aVar3.description == null)) {
                    charSequence = charSequence + " " + aVar3.description;
                }
                axVar.iir.setText(charSequence);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", e, "", new Object[0]);
            }
        }
        x.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + auVar.field_content);
        if (bh.ov(auVar.field_imgPath) && Mj.rWw > 0) {
            ar.Hg();
            cf F = c.Fa().F(auVar.field_talker, (long) Mj.rWw);
            if (!bh.ov(F.field_imgPath)) {
                S = k.ns(q.FS());
                if (com.tencent.mm.sdk.platformtools.k.q(h.aJ(F.field_imgPath, false), h.aJ(S, false), false)) {
                    auVar.dT(S);
                    ar.Hg();
                    c.Fa().a(auVar.field_msgId, auVar);
                }
            }
        }
        if (bh.ov(auVar.field_imgPath) && Mj != null && Mj.fny != null && Mj.fny.length() > 0 && Mj.hbb > 0 && this.hPs == null) {
            str2 = k.ns(q.FS());
            String aJ = h.aJ(str2, false);
            if (bh.ov(auVar.field_imgPath)) {
                auVar.dT(str2);
                ar.Hg();
                c.Fa().a(auVar.field_msgId, auVar);
                x.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + aVar3.fny);
                b a = l.a(aJ, auVar.field_msgId, aVar3.sdkVer, aVar3.appId, aVar3.fny, aVar3.hbb);
                x.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + a.field_mediaSvrId);
                if (a.field_mediaSvrId != null) {
                    com.tencent.mm.ae.n CG = ar.CG();
                    e 1 = new 1(this);
                    this.hPs = 1;
                    CG.a(221, 1);
                    x.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
                    ar.CG().a(new ab(a), 0);
                }
            }
        }
        axVar.yPD.setOnClickListener(new 2(this, auVar, i));
        Object obj = (this.yqa.ysf.ysR.isPlaying() && this.yqa.ysf.ysR.yqm == auVar.field_msgId) ? 1 : null;
        if (obj != null) {
            axVar.yPD.setImageResource(R.g.bDR);
        } else {
            axVar.yPD.setImageResource(R.g.bDS);
        }
        axVar.yIy.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
        ar.Hg();
        if (c.isSDCardAvailable()) {
            axVar.yIy.setOnLongClickListener(s(aVar2));
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

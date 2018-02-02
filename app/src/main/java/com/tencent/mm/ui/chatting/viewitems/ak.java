package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public final class ak extends b {
    private e hPs;
    private a yOh;
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (i == -1879048191) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.dej);
        view.setTag(new ay().dI(view));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        ay ayVar = (ay) aVar;
        this.yqa = aVar2;
        g fp = an.bYS().fp(auVar.field_msgId);
        String str2 = auVar.field_content;
        g.a aVar3 = null;
        if (!(fp == null || str2 == null)) {
            aVar3 = g.a.I(str2, auVar.field_reserved);
        }
        if (aVar3 != null) {
            ayVar.iir.setText(aVar3.description);
        }
        x.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + auVar.field_content);
        com.tencent.mm.plugin.subapp.c.e Mj = com.tencent.mm.plugin.subapp.c.e.Mj(str2);
        if (Mj != null && Mj.rWs != null && Mj.rWs.length() > 0 && Mj.rWt > 0 && this.hPs == null && aVar3 != null && bh.ov(auVar.field_imgPath)) {
            str2 = k.ns(q.FS());
            String aJ = h.aJ(str2, false);
            auVar.dT(str2);
            ar.Hg();
            c.Fa().a(auVar.field_msgId, auVar);
            long j = auVar.field_msgId;
            int i2 = aVar3.sdkVer;
            String str3 = aVar3.appId;
            String str4 = Mj.rWs;
            int i3 = Mj.rWt;
            int i4 = aVar3.type;
            String str5 = aVar3.hbp;
            String a = l.a(aJ, j, i2, str3, str4, i3, i4, aVar3.hbf);
            if (a != null) {
                n CG = ar.CG();
                e 1 = new 1(this, auVar, a, i);
                this.hPs = 1;
                CG.a(221, 1);
                com.tencent.mm.ae.k abVar = new ab(a);
                abVar.bYN();
                ar.CG().a(abVar, 0);
            }
        }
        ayVar.iir.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
        TextView textView = ayVar.iir;
        if (this.yOh == null) {
            this.yOh = new a(this, this.yqa);
        }
        textView.setOnClickListener(this.yOh);
        ar.Hg();
        if (c.isSDCardAvailable()) {
            ayVar.iir.setOnLongClickListener(s(aVar2));
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
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
        }
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        return true;
    }
}

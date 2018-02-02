package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.ag.c;
import com.tencent.mm.ui.chatting.viewitems.ag.d;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.FileUtils;

public class ag$a extends b {
    private c yNs;
    private a yqa;

    private c cvB() {
        if (this.yNs == null) {
            this.yNs = new c(this.yqa);
        }
        return this.yNs;
    }

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (z || i != 43) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddA);
        view.setTag(new d().q(view, true));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        this.yqa = aVar2;
        d dVar = (d) aVar;
        d.a(dVar, auVar, true, i, aVar2, R.g.bAH, cvB(), s(aVar2));
        String str2 = auVar.gjD;
        if (str2 == null || str2.length() == 0) {
            dVar.yIW.setVisibility(8);
            return;
        }
        dVar.yIW.setVisibility(0);
        b(aVar2, dVar.yIW, ar.Zx(str2));
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ar.Hg();
        if (com.tencent.mm.z.c.isSDCardAvailable()) {
            int i = ((ar) view.getTag()).position;
            r nr = o.TU().nr(auVar.field_imgPath);
            contextMenu.add(i, 129, 0, view.getContext().getString(R.l.dRL));
            contextMenu.add(i, 107, 0, view.getContext().getString(R.l.eEC));
            if (com.tencent.mm.bm.d.OQ("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
            }
            b dhVar = new dh();
            dhVar.frQ.fqm = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.xef.m(dhVar);
            if (dhVar.frR.frp) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRM));
            }
            if (nr != null && ((nr.status == 199 || nr.status == 199) && f.LO() && !this.yqa.csV())) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRD));
            }
            if (!this.yqa.csV()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRI));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        cvB().onClick(view);
        return true;
    }
}

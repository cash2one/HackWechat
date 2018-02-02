package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.a.a.c;

class b$3 extends c {
    final /* synthetic */ b rPY;

    b$3(b bVar) {
        this.rPY = bVar;
    }

    public final boolean cL(View view) {
        if (!(view.getTag() instanceof c) && !(view.getTag() instanceof m)) {
            return false;
        }
        m Ll;
        Object tag = view.getTag();
        if (tag instanceof c) {
            Ll = h.Ll(((c) view.getTag()).fzW);
        } else if (tag instanceof m) {
            Ll = (m) tag;
        } else {
            Ll = null;
        }
        if (Ll != null) {
            this.rPY.rPp.a(view, Ll.byq(), Ll.bxV());
        }
        return true;
    }

    public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        Object tag = view.getTag();
        if ((tag instanceof c) || (tag instanceof m)) {
            m Ll;
            if (tag instanceof c) {
                Ll = h.Ll(((c) tag).fzW);
            } else if (tag instanceof m) {
                Ll = (m) tag;
            } else {
                Ll = null;
            }
            if (d.OQ("favorite")) {
                b bxR = Ll.bxR();
                a bxT = Ll.bxT();
                if (bxR.bwx()) {
                    if (bxR.bwt()) {
                        contextMenu.add(0, 2, 0, view.getContext().getString(j.eAd));
                    } else if (bxT.rdM == 0) {
                        contextMenu.add(0, 3, 0, view.getContext().getString(j.eAd));
                    }
                }
                com.tencent.mm.sdk.b.b dhVar = new dh();
                dhVar.frQ.frH = Ll.byq();
                com.tencent.mm.sdk.b.a.xef.m(dhVar);
                if (dhVar.frR.frp) {
                    contextMenu.add(0, 18, 0, view.getContext().getString(j.qJu));
                }
            }
            if (Ll != null) {
                com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, Ll);
            }
        }
    }
}

package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.sns.abtest.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.protocal.c.bnp;

class b$34 extends c {
    final /* synthetic */ b rPY;

    b$34(b bVar) {
        this.rPY = bVar;
    }

    public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        as asVar = (as) view.getTag();
        m Ll = ae.bvv().Ll(asVar.fzW);
        if (Ll != null) {
            contextMenu.add(0, 0, 0, this.rPY.activity.getString(j.dEs));
            if (d.OQ("favorite")) {
                contextMenu.add(0, 1, 0, this.rPY.activity.getString(j.eAd));
            }
            bnp bxV = Ll.bxV();
            if (asVar.rEQ || !(bxV == null || bxV.wQq == 1 || asVar.rER)) {
                if (asVar.bBp()) {
                    ao.b(contextMenu, true);
                } else {
                    ao.a(contextMenu, true);
                }
            }
            a.a(contextMenu, Ll);
        }
    }

    public final boolean cL(View view) {
        if (!(view.getTag() instanceof as)) {
            return false;
        }
        m Ll = ae.bvv().Ll(((as) view.getTag()).fzW);
        if (Ll == null) {
            return false;
        }
        this.rPY.rPp.a(view, Ll.byq(), Ll.bxV());
        return true;
    }
}

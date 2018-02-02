package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ao.b;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.z.q;

class b$15 extends c {
    final /* synthetic */ b rPY;

    b$15(b bVar) {
        this.rPY = bVar;
    }

    public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view.getTag() instanceof m) {
            m mVar = (m) view.getTag();
            contextMenu.add(0, 11, 0, this.rPY.activity.getString(j.dEs));
            if (mVar.ksU != null && mVar.ksU.equals(q.FS())) {
                contextMenu.add(0, 7, 0, this.rPY.activity.getString(j.dEw));
            }
            String eb = ao.eb(mVar.rse, (mVar.qTX.wMw != 0 ? (long) mVar.qTX.wMw : mVar.qTX.wMz));
            int i = mVar.scene == 1 ? 2 : mVar.scene == 2 ? 4 : -1;
            b Kr = ao.Kr(eb);
            boolean z = (Kr == null || !Kr.hik || Kr.hlj || (i & Kr.fWj) == 0) ? false : true;
            if (z) {
                ao.b(contextMenu, false);
            } else {
                ao.a(contextMenu, false);
            }
        }
    }

    public final boolean cL(View view) {
        if (!(view.getTag() instanceof m)) {
            return false;
        }
        com.tencent.mm.plugin.sns.storage.m Ll = ae.bvv().Ll(((m) view.getTag()).rse);
        this.rPY.rPp.a(view, Ll.byq(), Ll.bxV());
        return true;
    }
}

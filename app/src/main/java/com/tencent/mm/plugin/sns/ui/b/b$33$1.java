package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.b.b.33;

class b$33$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 33 rQf;

    b$33$1(33 33) {
        this.rQf = 33;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, this.rQf.rPY.activity.getString(j.dVO));
        contextMenu.add(1, 1, 0, this.rQf.rPY.activity.getString(j.qMt));
    }
}

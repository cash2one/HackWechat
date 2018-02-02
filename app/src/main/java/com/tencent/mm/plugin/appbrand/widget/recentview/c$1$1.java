package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.appbrand.widget.k$e;
import com.tencent.mm.plugin.appbrand.widget.recentview.c.1;

class c$1$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 1 kfF;

    c$1$1(1 1) {
        this.kfF = 1;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, k$e.jVl);
    }
}

package com.tencent.mm.pluginsdk.ui.d;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import java.util.List;

class k$3 implements OnCreateContextMenuListener {
    final /* synthetic */ List vuL;

    public k$3(List list) {
        this.vuL = list;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        for (String add : this.vuL) {
            contextMenu.add(0, 0, 0, add);
        }
    }
}

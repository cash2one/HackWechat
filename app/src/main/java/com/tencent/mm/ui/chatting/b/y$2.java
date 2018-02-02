package com.tencent.mm.ui.chatting.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;

class y$2 implements OnCreateContextMenuListener {
    final /* synthetic */ y yBS;

    y$2(y yVar) {
        this.yBS = yVar;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, view.getContext().getString(R.l.eFl));
        contextMenu.add(0, 1, 1, view.getContext().getString(R.l.eFe));
    }
}

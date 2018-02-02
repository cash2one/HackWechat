package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.l.4;

class l$4$7 implements OnCreateContextMenuListener {
    final /* synthetic */ 4 yrQ;

    l$4$7(4 4) {
        this.yrQ = 4;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, R.l.evQ);
        contextMenu.add(0, 1, 1, R.l.evR);
    }
}

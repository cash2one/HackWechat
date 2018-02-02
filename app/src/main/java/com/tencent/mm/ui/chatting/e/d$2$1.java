package com.tencent.mm.ui.chatting.e;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.e.d.2;

class d$2$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 2 yHt;

    d$2$1(2 2) {
        this.yHt = 2;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, view.getContext().getString(R.l.eEG));
        contextMenu.add(0, 1, 0, view.getContext().getString(R.l.dQP));
        contextMenu.add(0, 2, 0, view.getContext().getString(R.l.dRH));
    }
}

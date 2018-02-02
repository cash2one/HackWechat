package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;

class TextPreviewUI$1 implements OnCreateContextMenuListener {
    final /* synthetic */ TextPreviewUI yxT;

    TextPreviewUI$1(TextPreviewUI textPreviewUI) {
        this.yxT = textPreviewUI;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.clear();
        contextMenu.add(0, 0, 0, this.yxT.getResources().getString(R.l.dEs));
        contextMenu.add(1, 1, 0, this.yxT.getResources().getString(R.l.euY));
        contextMenu.add(1, 2, 0, this.yxT.getResources().getString(R.l.euX));
    }
}

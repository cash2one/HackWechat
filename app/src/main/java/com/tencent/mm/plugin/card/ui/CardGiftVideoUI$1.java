package com.tencent.mm.plugin.card.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;

class CardGiftVideoUI$1 implements OnCreateContextMenuListener {
    final /* synthetic */ CardGiftVideoUI kTl;

    CardGiftVideoUI$1(CardGiftVideoUI cardGiftVideoUI) {
        this.kTl = cardGiftVideoUI;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, this.kTl.getString(R.l.dRS));
    }
}

package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.game.gamewebview.ui.h.3;
import com.tencent.mm.sdk.platformtools.x;

class h$3$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 3 naa;

    h$3$1(3 3) {
        this.naa = 3;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (this.naa.mZZ.juX != null) {
            x.d("MicroMsg.GameWebViewMenuListHelper", "show webkit menu");
            this.naa.mZZ.b(contextMenu, this.naa.mZZ.juX);
            this.naa.mZZ.juX = null;
        } else if (this.naa.mZZ.juY != null) {
            x.d("MicroMsg.GameWebViewMenuListHelper", "show IX5 menu");
            this.naa.mZZ.a(contextMenu, this.naa.mZZ.juY);
            this.naa.mZZ.juY = null;
        }
    }
}

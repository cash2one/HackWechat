package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;

class i$1 implements OnCreateContextMenuListener {
    final /* synthetic */ i mWH;

    i$1(i iVar) {
        this.mWH = iVar;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, this.mWH.mWF.getString(R.l.dEW));
        contextMenu.add(0, 2, 1, this.mWH.mWF.getString(R.l.dFa));
    }
}

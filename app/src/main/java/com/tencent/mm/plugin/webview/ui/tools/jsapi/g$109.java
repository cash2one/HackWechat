package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;

class g$109 implements OnCreateContextMenuListener {
    final /* synthetic */ g tIj;

    g$109(g gVar) {
        this.tIj = gVar;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, g.i(this.tIj).getString(R.l.eHv));
        contextMenu.add(0, 2, 1, g.i(this.tIj).getString(R.l.eHq));
    }
}

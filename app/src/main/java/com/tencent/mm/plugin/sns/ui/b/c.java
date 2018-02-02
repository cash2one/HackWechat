package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.sdk.platformtools.x;

public abstract class c implements OnCreateContextMenuListener {
    public abstract void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo);

    public abstract boolean cL(View view);

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (cL(view)) {
            a(contextMenu, view, contextMenuInfo);
        } else {
            x.e("MicroMsg.TimelineOnCreateContextMenuListener", "onMMCreateContextMenu error");
        }
    }
}

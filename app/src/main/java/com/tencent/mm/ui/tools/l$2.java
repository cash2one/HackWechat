package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.sdk.platformtools.x;

class l$2 implements OnLongClickListener {
    final /* synthetic */ OnCreateContextMenuListener zlv;
    final /* synthetic */ l zlw;

    l$2(l lVar, OnCreateContextMenuListener onCreateContextMenuListener) {
        this.zlw = lVar;
        this.zlv = onCreateContextMenuListener;
    }

    public final boolean onLongClick(View view) {
        x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
        l.a(this.zlw).clear();
        this.zlv.onCreateContextMenu(l.a(this.zlw), view, null);
        this.zlw.bBX();
        if (l.a(this.zlw).size() > 0) {
            return true;
        }
        return false;
    }
}

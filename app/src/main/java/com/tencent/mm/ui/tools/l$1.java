package com.tencent.mm.ui.tools;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.o;

class l$1 implements OnItemLongClickListener {
    final /* synthetic */ OnCreateContextMenuListener zlv;
    final /* synthetic */ l zlw;

    l$1(l lVar, OnCreateContextMenuListener onCreateContextMenuListener) {
        this.zlw = lVar;
        this.zlv = onCreateContextMenuListener;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        l.a(this.zlw).clear();
        x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
        ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        this.zlv.onCreateContextMenu(l.a(this.zlw), view, adapterContextMenuInfo);
        for (MenuItem menuItem : l.a(this.zlw).ycc) {
            ((o) menuItem).ycf = adapterContextMenuInfo;
        }
        this.zlw.bBX();
        return true;
    }
}

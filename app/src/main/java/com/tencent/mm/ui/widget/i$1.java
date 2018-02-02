package com.tencent.mm.ui.widget;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.o;

class i$1 implements OnItemLongClickListener {
    final /* synthetic */ OnCreateContextMenuListener zup;
    final /* synthetic */ i zuq;

    i$1(i iVar, OnCreateContextMenuListener onCreateContextMenuListener) {
        this.zuq = iVar;
        this.zup = onCreateContextMenuListener;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        i.a(this.zuq).clear();
        x.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click");
        ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        this.zup.onCreateContextMenu(i.a(this.zuq), view, adapterContextMenuInfo);
        for (MenuItem menuItem : i.a(this.zuq).ycc) {
            ((o) menuItem).ycf = adapterContextMenuInfo;
        }
        this.zuq.bQ(0, 0);
        return true;
    }
}

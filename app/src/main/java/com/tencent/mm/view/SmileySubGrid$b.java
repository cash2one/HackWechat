package com.tencent.mm.view;

import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.SmileySubGrid.d;

class SmileySubGrid$b extends d implements Runnable {
    final /* synthetic */ SmileySubGrid zEj;
    View zEk;
    int zfh;

    private SmileySubGrid$b(SmileySubGrid smileySubGrid) {
        this.zEj = smileySubGrid;
        super(smileySubGrid, (byte) 0);
    }

    public final void run() {
        ListAdapter adapter = this.zEj.getAdapter();
        int i = this.zfh;
        if (adapter != null && this.zEj.getCount() > 0 && i != -1 && i < adapter.getCount() && cxq()) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", new Object[]{Integer.valueOf(i), Long.valueOf(adapter.getItemId(i))});
            this.zEj.performItemClick(this.zEk, i, adapter.getItemId(i));
        }
    }
}

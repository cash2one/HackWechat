package com.tencent.mm.view;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.SmileySubGrid.d;

class SmileySubGrid$a extends d implements Runnable {
    final /* synthetic */ SmileySubGrid zEj;

    private SmileySubGrid$a(SmileySubGrid smileySubGrid) {
        this.zEj = smileySubGrid;
        super(smileySubGrid, (byte) 0);
    }

    public final void run() {
        int i = this.zEj.TC;
        View childAt = this.zEj.getChildAt(i - this.zEj.getFirstVisiblePosition());
        if (childAt != null) {
            int i2 = this.zEj.TC;
            long itemId = this.zEj.getAdapter().getItemId(this.zEj.TC);
            if (cxq()) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", new Object[]{Integer.valueOf(i2), Long.valueOf(itemId)});
                SmileySubGrid.a(this.zEj, childAt, i);
                this.zEj.YQ = -1;
                this.zEj.xYH = 5;
                this.zEj.ew(false);
            }
        }
    }
}

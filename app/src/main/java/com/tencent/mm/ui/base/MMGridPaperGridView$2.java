package com.tencent.mm.ui.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;

class MMGridPaperGridView$2 implements OnItemLongClickListener {
    final /* synthetic */ MMGridPaperGridView ybt;

    MMGridPaperGridView$2(MMGridPaperGridView mMGridPaperGridView) {
        this.ybt = mMGridPaperGridView;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (MMGridPaperGridView.a(this.ybt) == null) {
            x.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
        }
        return false;
    }
}

package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;

class CollectBillUI$4 implements OnItemLongClickListener {
    final /* synthetic */ CollectBillUI llV;

    CollectBillUI$4(CollectBillUI collectBillUI) {
        this.llV = collectBillUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < 0 || i >= adapterView.getAdapter().getCount()) {
            x.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(adapterView.getAdapter().getCount())});
            return false;
        }
        CollectBillUI.i(this.llV).a(view, i, j, this.llV, CollectBillUI.h(this.llV));
        return true;
    }
}

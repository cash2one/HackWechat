package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class i$3 implements OnItemLongClickListener {
    final /* synthetic */ i yjw;

    i$3(i iVar) {
        this.yjw = iVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < i.e(this.yjw).getHeaderViewsCount()) {
            return false;
        }
        i.d(this.yjw).getItem(i - i.e(this.yjw).getHeaderViewsCount());
        i.d(this.yjw);
        i.e(this.yjw);
        return i.cqp();
    }
}

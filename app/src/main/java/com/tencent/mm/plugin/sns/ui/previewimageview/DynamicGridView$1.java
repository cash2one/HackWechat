package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class DynamicGridView$1 implements OnItemClickListener {
    final /* synthetic */ DynamicGridView rRm;

    DynamicGridView$1(DynamicGridView dynamicGridView) {
        this.rRm = dynamicGridView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.rRm.lUO && this.rRm.isEnabled() && DynamicGridView.a(this.rRm) != null) {
            DynamicGridView.a(this.rRm).onItemClick(adapterView, view, i, j);
        }
    }
}

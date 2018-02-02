package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.product.ui.d.a;

class d$1 implements OnItemClickListener {
    final /* synthetic */ OnItemClickListener pfw;
    final /* synthetic */ a pfx;

    d$1(OnItemClickListener onItemClickListener, a aVar) {
        this.pfw = onItemClickListener;
        this.pfx = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.pfw != null) {
            this.pfw.onItemClick(adapterView, view, i, j);
        }
        this.pfx.pfz = i;
        this.pfx.notifyDataSetChanged();
    }
}

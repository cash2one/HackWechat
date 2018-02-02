package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.l;

class ShakeItemListUI$4 implements OnItemLongClickListener {
    final /* synthetic */ l kBU;
    final /* synthetic */ ShakeItemListUI qqB;

    ShakeItemListUI$4(ShakeItemListUI shakeItemListUI, l lVar) {
        this.qqB = shakeItemListUI;
        this.kBU = lVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < ShakeItemListUI.c(this.qqB).getHeaderViewsCount()) {
            x.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
        } else {
            this.kBU.a(view, i, j, this.qqB, ShakeItemListUI.e(this.qqB));
        }
        return true;
    }
}

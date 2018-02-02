package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.l;

class NearbySayHiListUI$10 implements OnItemLongClickListener {
    final /* synthetic */ l kBU;
    final /* synthetic */ NearbySayHiListUI oPo;

    NearbySayHiListUI$10(NearbySayHiListUI nearbySayHiListUI, l lVar) {
        this.oPo = nearbySayHiListUI;
        this.kBU = lVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < NearbySayHiListUI.d(this.oPo).getHeaderViewsCount()) {
            x.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
        } else {
            this.kBU.a(view, i, j, this.oPo, NearbySayHiListUI.g(this.oPo));
        }
        return true;
    }
}

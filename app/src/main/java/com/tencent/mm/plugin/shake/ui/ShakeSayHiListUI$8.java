package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.l;

class ShakeSayHiListUI$8 implements OnItemLongClickListener {
    final /* synthetic */ l kBU;
    final /* synthetic */ ShakeSayHiListUI qsr;

    ShakeSayHiListUI$8(ShakeSayHiListUI shakeSayHiListUI, l lVar) {
        this.qsr = shakeSayHiListUI;
        this.kBU = lVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < ShakeSayHiListUI.d(this.qsr).getHeaderViewsCount()) {
            x.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
        } else {
            this.kBU.a(view, i, j, this.qsr, ShakeSayHiListUI.f(this.qsr));
        }
        return true;
    }
}

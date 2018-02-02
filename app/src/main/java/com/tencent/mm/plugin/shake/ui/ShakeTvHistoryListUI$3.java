package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.d.a.n;

class ShakeTvHistoryListUI$3 implements OnItemClickListener {
    final /* synthetic */ ShakeTvHistoryListUI qsv;

    ShakeTvHistoryListUI$3(ShakeTvHistoryListUI shakeTvHistoryListUI) {
        this.qsv = shakeTvHistoryListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        k.a((n) ShakeTvHistoryListUI.a(this.qsv).getItem(i), this.qsv.mController.xIM, 2);
    }
}

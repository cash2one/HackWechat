package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ui.tools.l;

class ShakeTvHistoryListUI$4 implements OnItemLongClickListener {
    final /* synthetic */ l kBU;
    final /* synthetic */ ShakeTvHistoryListUI qsv;

    ShakeTvHistoryListUI$4(ShakeTvHistoryListUI shakeTvHistoryListUI, l lVar) {
        this.qsv = shakeTvHistoryListUI;
        this.kBU = lVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= ShakeTvHistoryListUI.b(this.qsv).getHeaderViewsCount()) {
            this.kBU.a(view, i, j, this.qsv.mController.xIM, ShakeTvHistoryListUI.c(this.qsv));
        }
        return true;
    }
}

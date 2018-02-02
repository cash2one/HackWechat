package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.l;

class ShakeMsgListUI$5 implements OnItemLongClickListener {
    final /* synthetic */ l kBU;
    final /* synthetic */ ShakeMsgListUI qqQ;

    ShakeMsgListUI$5(ShakeMsgListUI shakeMsgListUI, l lVar) {
        this.qqQ = shakeMsgListUI;
        this.kBU = lVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < ShakeMsgListUI.f(this.qqQ).getHeaderViewsCount()) {
            x.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
        } else {
            this.kBU.a(view, i, j, this.qqQ.mController.xIM, ShakeMsgListUI.h(this.qqQ));
        }
        return true;
    }
}

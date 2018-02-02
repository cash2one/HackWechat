package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.sdk.platformtools.x;

class SnsMsgUI$14 implements OnItemClickListener {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$14(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == SnsMsgUI.d(this.rDE).getCount()) {
            int i2;
            if (ae.bvA().Tq() > 0) {
                ae.bvA().auv();
                i2 = SnsMsgUI.d(this.rDE).awe() ? 0 : 1;
            } else {
                i2 = SnsMsgUI.d(this.rDE).awf();
            }
            SnsMsgUI.d(this.rDE).a(null, null);
            if (!SnsMsgUI.f(this.rDE)) {
                if (SnsMsgUI.e(this.rDE).getParent() != null) {
                    x.d("MicroMsg.SnsMsgUI", "remove footer");
                    SnsMsgUI.b(this.rDE).removeFooterView(SnsMsgUI.e(this.rDE));
                }
                if (SnsMsgUI.g(this.rDE).getParent() == null && r0 > 0) {
                    SnsMsgUI.b(this.rDE).addFooterView(SnsMsgUI.g(this.rDE));
                    x.i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                }
            }
            SnsMsgUI.h(this.rDE);
            SnsMsgUI.e(this.rDE).setVisibility(8);
            return;
        }
        SnsMsgUI.a(this.rDE, (i) SnsMsgUI.d(this.rDE).getItem(i));
    }
}

package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.sdk.platformtools.x;

class SnsMsgUI$1 implements OnClickListener {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$1(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof ap) {
            SnsMsgUI.a(this.rDE).a(view, -1, null);
        } else if (view.getTag() instanceof i) {
            SnsMsgUI.a(this.rDE, (i) view.getTag());
        } else {
            x.w("MicroMsg.SnsMsgUI", "v.getTag():" + view.getTag());
        }
    }
}

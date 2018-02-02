package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.7;
import com.tencent.mm.sdk.f.e;

class UnfamiliarContactDetailUI$7$1 implements OnClickListener {
    final /* synthetic */ 7 qmd;

    UnfamiliarContactDetailUI$7$1(7 7) {
        this.qmd = 7;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (UnfamiliarContactDetailUI.h(this.qmd.qma) != null) {
            g.Dk();
            g.Di().gPJ.a(681, UnfamiliarContactDetailUI.h(this.qmd.qma));
            Runnable h = UnfamiliarContactDetailUI.h(this.qmd.qma);
            h.index = 0;
            h.ooY = 0;
            h.qmr = 0;
            h.qms.clear();
            h.qmt.clear();
            e.remove(h);
            if (h.qmp != null) {
                h.qmp.brj();
            }
            e.post(h, "delete_contact_task");
        }
        UnfamiliarContactDetailUI.b(this.qmd.qma, false);
    }
}

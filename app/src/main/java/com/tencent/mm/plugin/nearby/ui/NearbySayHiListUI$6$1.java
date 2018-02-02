package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.6;
import com.tencent.mm.z.ar;

class NearbySayHiListUI$6$1 implements OnCancelListener {
    final /* synthetic */ 6 oPq;

    NearbySayHiListUI$6$1(6 6) {
        this.oPq = 6;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(NearbySayHiListUI.f(this.oPq.oPo));
    }
}

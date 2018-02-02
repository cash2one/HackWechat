package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.ui.e.14;
import com.tencent.mm.sdk.platformtools.an;

class e$14$1 implements OnClickListener {
    final /* synthetic */ 14 srO;

    e$14$1(14 14) {
        this.srO = 14;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!an.is2G(this.srO.srL.getActivity())) {
            l.bHk();
        }
        e.e(this.srO.srL);
    }
}

package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.aa.ui.AASelectContactUI.4;
import com.tencent.mm.plugin.report.service.g;

class AASelectContactUI$4$2 implements OnClickListener {
    final /* synthetic */ 4 iiD;

    AASelectContactUI$4$2(4 4) {
        this.iiD = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.iiD.iiA.finish();
        g.pQN.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(10)});
    }
}

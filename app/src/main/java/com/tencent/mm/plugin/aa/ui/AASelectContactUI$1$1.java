package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.aa.ui.AASelectContactUI.1;
import java.util.List;

class AASelectContactUI$1$1 implements OnClickListener {
    final /* synthetic */ List iiB;
    final /* synthetic */ 1 iiC;

    AASelectContactUI$1$1(1 1, List list) {
        this.iiC = 1;
        this.iiB = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AASelectContactUI.a(this.iiC.iiA, this.iiB);
    }
}

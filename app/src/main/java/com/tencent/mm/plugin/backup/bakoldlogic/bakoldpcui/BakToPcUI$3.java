package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

class BakToPcUI$3 implements OnClickListener {
    final /* synthetic */ BakToPcUI ksc;

    BakToPcUI$3(BakToPcUI bakToPcUI) {
        this.ksc = bakToPcUI;
    }

    public final void onClick(View view) {
        if (BakToPcUI.b(this.ksc) == 0) {
            a.aql().aqn().hgg = 2;
            a.aql().aqn().HT();
            a.aql().aqm().mR(1);
            BakToPcUI.c(this.ksc);
        }
    }
}

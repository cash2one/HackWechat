package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.d.b.a;

class SoterTestUI$1 implements OnClickListener {
    final /* synthetic */ SoterTestUI rSE;

    SoterTestUI$1(SoterTestUI soterTestUI) {
        this.rSE = soterTestUI;
    }

    public final void onClick(View view) {
        SoterTestUI.a(this.rSE).setText(a.cFW() ? "passed" : "not support");
    }
}

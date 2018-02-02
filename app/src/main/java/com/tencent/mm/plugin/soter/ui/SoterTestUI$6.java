package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.d.a.a;

class SoterTestUI$6 implements OnClickListener {
    final /* synthetic */ SoterTestUI rSE;

    SoterTestUI$6(SoterTestUI soterTestUI) {
        this.rSE = soterTestUI;
    }

    public final void onClick(View view) {
        SoterTestUI.a(this.rSE).setText(a.bs("sample_auth_key_name", false).isSuccess() ? "pass" : "not passed");
    }
}

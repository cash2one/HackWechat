package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;

class ModRemarkNameUI$4 implements OnClickListener {
    final /* synthetic */ ModRemarkNameUI yTW;

    ModRemarkNameUI$4(ModRemarkNameUI modRemarkNameUI) {
        this.yTW = modRemarkNameUI;
    }

    public final void onClick(View view) {
        ModRemarkNameUI.f(this.yTW).setVisibility(0);
        ModRemarkNameUI.g(this.yTW).setVisibility(8);
        ModRemarkNameUI.h(this.yTW).requestFocus();
        this.yTW.showVKB();
    }
}

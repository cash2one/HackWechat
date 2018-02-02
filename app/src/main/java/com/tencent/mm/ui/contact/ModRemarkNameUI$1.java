package com.tencent.mm.ui.contact;

import com.tencent.mm.ui.widget.MMEditText.b;

class ModRemarkNameUI$1 implements b {
    final /* synthetic */ ModRemarkNameUI yTW;

    ModRemarkNameUI$1(ModRemarkNameUI modRemarkNameUI) {
        this.yTW = modRemarkNameUI;
    }

    public final void bot() {
        if (ModRemarkNameUI.a(this.yTW).getText().toString().trim().length() > 0) {
            this.yTW.enableOptionMenu(true);
        }
    }
}

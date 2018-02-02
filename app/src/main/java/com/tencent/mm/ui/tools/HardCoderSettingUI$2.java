package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;

class HardCoderSettingUI$2 implements OnClickListener {
    final /* synthetic */ HardCoderSettingUI zkJ;

    HardCoderSettingUI$2(HardCoderSettingUI hardCoderSettingUI) {
        this.zkJ = hardCoderSettingUI;
    }

    public final void onClick(View view) {
        HardCoderSettingUI.a(this.zkJ, true);
        this.zkJ.showDialog(1);
    }
}

package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.ui.tools.h;

class ModRemarkNameUI$b implements TextWatcher {
    private int qgT;
    final /* synthetic */ ModRemarkNameUI yTW;

    private ModRemarkNameUI$b(ModRemarkNameUI modRemarkNameUI) {
        this.yTW = modRemarkNameUI;
        this.qgT = 800;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        this.qgT = h.aY(800, editable.toString());
        if (this.qgT < 0) {
            this.qgT = 0;
        }
        if (ModRemarkNameUI.i(this.yTW) != null) {
            ModRemarkNameUI.i(this.yTW).setText(this.qgT);
        }
        ModRemarkNameUI.j(this.yTW);
    }
}

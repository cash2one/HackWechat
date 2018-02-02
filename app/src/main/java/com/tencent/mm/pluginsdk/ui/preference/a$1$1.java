package com.tencent.mm.pluginsdk.ui.preference;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.preference.a.1;
import com.tencent.mm.ui.tools.h;

class a$1$1 implements TextWatcher {
    final /* synthetic */ TextView vsZ;
    final /* synthetic */ 1 vta;

    a$1$1(1 1, TextView textView) {
        this.vta = 1;
        this.vsZ = textView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        int aY = h.aY(100, editable.toString());
        if (this.vsZ != null) {
            this.vsZ.setText(String.valueOf(aY));
        }
    }
}

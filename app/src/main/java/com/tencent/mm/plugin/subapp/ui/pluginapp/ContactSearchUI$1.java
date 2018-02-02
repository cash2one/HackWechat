package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.text.Editable;
import android.text.TextWatcher;

class ContactSearchUI$1 implements TextWatcher {
    final /* synthetic */ ContactSearchUI rYw;

    ContactSearchUI$1(ContactSearchUI contactSearchUI) {
        this.rYw = contactSearchUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        this.rYw.enableOptionMenu(editable.length() > 0);
    }
}

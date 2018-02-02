package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;

class ContactRemarkInfoModUI$14 implements TextWatcher {
    final /* synthetic */ ContactRemarkInfoModUI ySf;

    ContactRemarkInfoModUI$14(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ySf = contactRemarkInfoModUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        ContactRemarkInfoModUI.b(this.ySf);
    }
}

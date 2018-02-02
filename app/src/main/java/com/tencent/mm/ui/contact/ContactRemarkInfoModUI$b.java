package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.ui.tools.h;

class ContactRemarkInfoModUI$b implements TextWatcher {
    private int qgT;
    final /* synthetic */ ContactRemarkInfoModUI ySf;
    private String ySh;

    private ContactRemarkInfoModUI$b(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ySf = contactRemarkInfoModUI;
        this.qgT = 800;
        this.ySh = "";
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
        if (ContactRemarkInfoModUI.a(this.ySf) != null) {
            ContactRemarkInfoModUI.a(this.ySf).setText(this.qgT);
        }
        ContactRemarkInfoModUI.b(this.ySf);
    }
}

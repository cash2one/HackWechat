package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ContactLabelEditUI$6 implements OnClickListener {
    final /* synthetic */ ContactLabelEditUI nOY;

    ContactLabelEditUI$6(ContactLabelEditUI contactLabelEditUI) {
        this.nOY = contactLabelEditUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.nOY.setResult(0);
        this.nOY.finish();
    }
}

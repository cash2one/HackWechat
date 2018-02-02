package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class ContactLabelEditUI$3 implements OnCancelListener {
    final /* synthetic */ ContactLabelEditUI nOY;

    ContactLabelEditUI$3(ContactLabelEditUI contactLabelEditUI) {
        this.nOY = contactLabelEditUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().cancel(635);
        ar.CG().cancel(637);
    }
}

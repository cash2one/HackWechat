package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.storage.z;

class ContactLabelManagerUI$2 implements OnClickListener {
    final /* synthetic */ ContactLabelManagerUI nPj;
    final /* synthetic */ z nPk;

    ContactLabelManagerUI$2(ContactLabelManagerUI contactLabelManagerUI, z zVar) {
        this.nPj = contactLabelManagerUI;
        this.nPk = zVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.nPk == null) {
            return;
        }
        if (this.nPk.field_isTemporary) {
            ContactLabelManagerUI.a(this.nPj, this.nPk.field_labelID);
        } else {
            ContactLabelManagerUI.a(this.nPj, this.nPk);
        }
    }
}

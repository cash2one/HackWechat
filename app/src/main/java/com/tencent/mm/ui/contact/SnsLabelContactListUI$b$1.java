package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.contact.SnsLabelContactListUI.b;

class SnsLabelContactListUI$b$1 implements OnClickListener {
    final /* synthetic */ b yUQ;

    SnsLabelContactListUI$b$1(b bVar) {
        this.yUQ = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yUQ.yUM.finish();
    }
}

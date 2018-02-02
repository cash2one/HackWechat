package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.LinkedList;

class SelectContactUI$7 implements OnClickListener {
    final /* synthetic */ LinkedList yUB;
    final /* synthetic */ SelectContactUI yUy;

    SelectContactUI$7(SelectContactUI selectContactUI, LinkedList linkedList) {
        this.yUy = selectContactUI;
        this.yUB = linkedList;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SelectContactUI.a(this.yUy, this.yUB);
    }
}

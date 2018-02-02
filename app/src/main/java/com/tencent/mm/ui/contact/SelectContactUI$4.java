package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.b.a;

class SelectContactUI$4 implements OnCancelListener {
    final /* synthetic */ SelectContactUI yUy;

    SelectContactUI$4(SelectContactUI selectContactUI) {
        this.yUy = selectContactUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        SelectContactUI.d(this.yUy, false);
        if (SelectContactUI.f(this.yUy) != null) {
            SelectContactUI.f(this.yUy).fAK.fAJ = true;
            a.xef.m(SelectContactUI.f(this.yUy));
        }
    }
}

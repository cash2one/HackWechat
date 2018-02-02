package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.R;

class ContactRemarkInfoModUI$15 implements OnFocusChangeListener {
    final /* synthetic */ ContactRemarkInfoModUI ySf;

    ContactRemarkInfoModUI$15(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ySf = contactRemarkInfoModUI;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            ContactRemarkInfoModUI.i(this.ySf).setBackgroundResource(R.g.bDf);
        } else {
            ContactRemarkInfoModUI.i(this.ySf).setBackgroundResource(R.g.bDg);
        }
    }
}

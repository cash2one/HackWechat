package com.tencent.mm.ui.bindlinkedin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class BindLinkedInUI$7 implements OnClickListener {
    final /* synthetic */ BindLinkedInUI ylv;

    BindLinkedInUI$7(BindLinkedInUI bindLinkedInUI) {
        this.ylv = bindLinkedInUI;
    }

    public final void onClick(View view) {
        if (!BindLinkedInUI.b(this.ylv)) {
            BindLinkedInUI.c(this.ylv);
        } else if (BindLinkedInUI.d(this.ylv)) {
            h.a(this.ylv, this.ylv.getString(R.l.dVn), null, new 1(this), new 2(this));
        } else {
            BindLinkedInUI.e(this.ylv);
        }
    }
}

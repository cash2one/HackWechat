package com.tencent.mm.ui.bindlinkedin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class BindLinkedInUI$8 implements OnClickListener {
    final /* synthetic */ BindLinkedInUI ylv;

    BindLinkedInUI$8(BindLinkedInUI bindLinkedInUI) {
        this.ylv = bindLinkedInUI;
    }

    public final void onClick(View view) {
        h.a(this.ylv, this.ylv.getString(R.l.dVp), null, new 1(this), new 2(this));
    }
}

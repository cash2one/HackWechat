package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.recharge.ui.MallEditText.a;

class MallEditText$a$3 implements OnClickListener {
    final /* synthetic */ a pCE;

    MallEditText$a$3(a aVar) {
        this.pCE = aVar;
    }

    public final void onClick(View view) {
        MallEditText.a(this.pCE.pCy).dismissDropDown();
    }
}

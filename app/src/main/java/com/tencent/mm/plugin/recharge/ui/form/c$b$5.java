package com.tencent.mm.plugin.recharge.ui.form;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.recharge.ui.form.c.b;

class c$b$5 implements OnClickListener {
    final /* synthetic */ b pEe;
    final /* synthetic */ InstantAutoCompleteTextView pEf;

    public c$b$5(b bVar, InstantAutoCompleteTextView instantAutoCompleteTextView) {
        this.pEe = bVar;
        this.pEf = instantAutoCompleteTextView;
    }

    public final void onClick(View view) {
        this.pEf.requestFocus();
    }
}

package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a zyc;

    a$1(a aVar) {
        this.zyc = aVar;
    }

    public final void onClick(View view) {
        Object obj;
        a aVar = this.zyc;
        if (a.a(this.zyc) == null) {
            obj = null;
        } else {
            OptionPicker a = a.a(this.zyc);
            obj = (a.kdi == null || a.kdi.length <= 0) ? "" : a.kdi[a.getValue()];
        }
        a.a(aVar, true, obj);
    }
}

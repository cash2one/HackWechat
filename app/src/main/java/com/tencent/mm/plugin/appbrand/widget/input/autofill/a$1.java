package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a;

class a$1 implements OnDismissListener {
    final /* synthetic */ a jZV;

    a$1(a aVar) {
        this.jZV = aVar;
    }

    public final void onDismiss() {
        if (a.a(this.jZV) != null && !a.b(this.jZV)) {
            a.a(this.jZV).a("", a.kaE);
        }
    }
}

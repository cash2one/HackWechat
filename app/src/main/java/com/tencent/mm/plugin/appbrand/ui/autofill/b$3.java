package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.base.h;

class b$3 implements OnClickListener {
    final /* synthetic */ b jNZ;

    b$3(b bVar) {
        this.jNZ = bVar;
    }

    public final void onClick(View view) {
        h.a(this.jNZ.getContext(), this.jNZ.getString(j.izG) + b.d(this.jNZ).vJu, this.jNZ.getString(j.izF), this.jNZ.getString(j.dFU), this.jNZ.getString(j.dEn), false, new 1(this), new 2(this));
    }
}

package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements OnClickListener {
    final /* synthetic */ a jNF;

    a$2(a aVar) {
        this.jNF = aVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
        if (a.a(this.jNF) != null) {
            a.a(this.jNF).akY();
        }
    }
}

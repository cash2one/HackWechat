package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class b$5 implements OnClickListener {
    final /* synthetic */ b jNZ;

    b$5(b bVar) {
        this.jNZ = bVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
        if (b.a(this.jNZ) != null) {
            b.a(this.jNZ).a(b.e(this.jNZ).getText().toString(), b.d(this.jNZ));
        }
    }
}

package com.tencent.mm.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;

class SecurityImage$1 implements OnClickListener {
    final /* synthetic */ SecurityImage xWt;

    SecurityImage$1(SecurityImage securityImage) {
        this.xWt = securityImage;
    }

    public final void onClick(View view) {
        SecurityImage.a(this.xWt);
        if (SecurityImage.b(this.xWt) != null) {
            SecurityImage.b(this.xWt).cnJ();
        }
    }
}

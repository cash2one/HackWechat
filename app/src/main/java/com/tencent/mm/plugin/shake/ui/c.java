package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.ak;

final class c {
    ak fhK = new ak(new 1(this), false);
    View view;

    public c(View view) {
        this.view = view;
    }

    public final void bsj() {
        if (this.view != null) {
            this.view.setKeepScreenOn(false);
        }
    }
}

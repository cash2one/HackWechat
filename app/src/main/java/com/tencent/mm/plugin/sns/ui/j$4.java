package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import com.tencent.mm.ui.widget.MMEditText.a;

class j$4 implements a {
    final /* synthetic */ j rrK;

    j$4(j jVar) {
        this.rrK = jVar;
    }

    public final void aXC() {
        if (this.rrK.rrw.getVisibility() == 0) {
            this.rrK.rrw.setVisibility(8);
        } else {
            ((Activity) j.c(this.rrK)).finish();
        }
    }
}

package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ui.base.i;

public final class a extends com.tencent.mm.ui.base.i.a {
    private boolean jKj = false;

    public a(Context context) {
        super(context);
        if (context instanceof Activity) {
            this.jKj = j.c(((Activity) context).getWindow());
        }
    }

    public final i akx() {
        i akx = super.akx();
        j.a(akx.getWindow(), this.jKj);
        return akx;
    }
}

package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.c;

class b$2 implements OnClickListener {
    final /* synthetic */ b jKD;

    b$2(b bVar) {
        this.jKD = bVar;
    }

    public final void onClick(View view) {
        c.a(b.a(this.jKD).mAppId, c.c.iqj);
        b.a(this.jKD).finish();
    }
}

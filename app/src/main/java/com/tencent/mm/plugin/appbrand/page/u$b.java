package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import java.lang.ref.WeakReference;

class u$b {
    int id;
    WeakReference<View> jFA;
    public int jFB;
    boolean jFC;
    u$a jFD;
    int z;

    public u$b(View view, int i, int i2, int i3, boolean z) {
        this.jFA = new WeakReference(view);
        this.id = i;
        this.jFB = i2;
        this.z = i3;
        this.jFC = z;
    }
}

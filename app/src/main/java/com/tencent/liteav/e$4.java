package com.tencent.liteav;

import android.os.Bundle;
import com.tencent.liteav.basic.util.a;

class e$4 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ Bundle b;
    final /* synthetic */ e c;

    e$4(e eVar, int i, Bundle bundle) {
        this.c = eVar;
        this.a = i;
        this.b = bundle;
    }

    public void run() {
        a.a(this.c.d, this.a, this.b);
    }
}

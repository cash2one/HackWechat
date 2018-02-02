package com.tencent.mm.compatible.i;

import android.content.Intent;
import com.tencent.mm.compatible.a.a.a;

class b$1 implements a {
    final /* synthetic */ Intent gHX;

    b$1(Intent intent) {
        this.gHX = intent;
    }

    public final void run() {
        this.gHX.putExtra("android.intent.extra.durationLimit", 30);
        this.gHX.putExtra("android.intent.extra.sizeLimit", 10485760);
    }
}

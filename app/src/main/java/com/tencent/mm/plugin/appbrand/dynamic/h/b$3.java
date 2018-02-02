package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements c {
    b$3() {
    }

    public final void i(Bundle bundle) {
        x.i("MicroMsg.DynamicProcessPerformance", "on kill process tools callback");
        g.fj("com.tencent.mm:tools");
    }
}

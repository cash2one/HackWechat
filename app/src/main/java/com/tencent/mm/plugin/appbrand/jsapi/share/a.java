package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.modelappbrand.g;

final class a implements com.tencent.mm.ipcinvoker.a {
    a() {
    }

    public final void a(Bundle bundle, c cVar) {
        ((g) com.tencent.mm.kernel.g.h(g.class)).c(bundle.getInt("action"), bundle);
    }
}

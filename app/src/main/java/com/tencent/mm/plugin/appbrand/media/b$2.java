package com.tencent.mm.plugin.appbrand.media;

import com.tencent.mm.e.b.b.b;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements b {
    b$2() {
    }

    public final void onError() {
        x.e("MicroMsg.AppBrand.AudioRecorder", "onError");
        b.kS(-1);
    }
}

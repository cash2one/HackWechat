package com.tencent.liteav.screencapture;

import android.media.projection.MediaProjection.Callback;

class b$1 extends Callback {
    final /* synthetic */ b a;

    b$1(b bVar) {
        this.a = bVar;
    }

    public void onStop() {
        if (b.a(this.a)) {
            b.a(this.a, false);
        }
    }
}

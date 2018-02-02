package com.tencent.liteav;

import android.graphics.SurfaceTexture;

class b$6 implements Runnable {
    final /* synthetic */ SurfaceTexture a;
    final /* synthetic */ b b;

    b$6(b bVar, SurfaceTexture surfaceTexture) {
        this.b = bVar;
        this.a = surfaceTexture;
    }

    public void run() {
        b.a(this.b, this.a);
    }
}

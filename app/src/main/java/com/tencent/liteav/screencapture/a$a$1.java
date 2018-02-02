package com.tencent.liteav.screencapture;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.liteav.screencapture.a.a;

class a$a$1 implements OnFrameAvailableListener {
    final /* synthetic */ a a;

    a$a$1(a aVar) {
        this.a = aVar;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.a.n.a(104, new 1(this));
        surfaceTexture.setOnFrameAvailableListener(null);
    }
}

package com.tencent.mm.plugin.sight.encode.ui;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

class SightVideoTextureView$1 implements SurfaceTextureListener {
    final /* synthetic */ SightVideoTextureView qxT;

    SightVideoTextureView$1(SightVideoTextureView sightVideoTextureView) {
        this.qxT = sightVideoTextureView;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureAvailable, [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.qxT.qxB = a.qxK;
        SightVideoTextureView.a(this.qxT, surfaceTexture);
        ((MMTextureView) SightVideoTextureView.a(this.qxT)).cpK();
        x.i("MicroMsg.SightVideoTextureView", "available texture %s, wantPlay %B", new Object[]{surfaceTexture, Boolean.valueOf(SightVideoTextureView.b(this.qxT))});
        if (SightVideoTextureView.b(this.qxT)) {
            this.qxT.aB(SightVideoTextureView.c(this.qxT), SightVideoTextureView.d(this.qxT));
        }
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureSizeChanged, [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.qxT.qxB = a.qxL;
        x.i("MicroMsg.SightVideoTextureView", "changed texture %s", new Object[]{surfaceTexture});
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureDestroyed");
        this.qxT.qxB = a.qxM;
        SightVideoTextureView.a(this.qxT, null);
        this.qxT.qxD = false;
        x.i("MicroMsg.SightVideoTextureView", "destroyed texture %s", new Object[]{surfaceTexture});
        return true;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

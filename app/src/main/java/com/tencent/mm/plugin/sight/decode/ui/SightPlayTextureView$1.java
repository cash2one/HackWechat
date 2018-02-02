package com.tencent.mm.plugin.sight.decode.ui;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView.a;
import com.tencent.mm.sdk.platformtools.x;

class SightPlayTextureView$1 implements SurfaceTextureListener {
    final /* synthetic */ SightPlayTextureView quO;

    SightPlayTextureView$1(SightPlayTextureView sightPlayTextureView) {
        this.quO = sightPlayTextureView;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.SightPlayTextureView", "on surface texture size changed, width " + i + " height " + i2);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
        SightPlayTextureView.d(this.quO).d(null);
        SightPlayTextureView.d(this.quO).clear();
        Runnable aVar = new a((byte) 0);
        aVar.quP = SightPlayTextureView.e(this.quO);
        o.c(aVar, 0);
        SightPlayTextureView.a(this.quO, null);
        return false;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        Runnable aVar = new a((byte) 0);
        aVar.quP = SightPlayTextureView.e(this.quO);
        o.c(aVar, 0);
        SightPlayTextureView.a(this.quO, new Surface(surfaceTexture));
        SightPlayTextureView.d(this.quO).d(SightPlayTextureView.e(this.quO));
        this.quO.cpK();
    }
}

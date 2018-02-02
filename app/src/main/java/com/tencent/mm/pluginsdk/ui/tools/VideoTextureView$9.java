package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$9 implements SurfaceTextureListener {
    final /* synthetic */ VideoTextureView vyR;

    VideoTextureView$9(VideoTextureView videoTextureView) {
        this.vyR = videoTextureView;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (VideoTextureView.j(this.vyR)) {
            if (VideoTextureView.a(this.vyR) != null) {
                VideoTextureView.a(this.vyR).pause();
                if (VideoTextureView.m(this.vyR)) {
                    VideoTextureView.a(this.vyR).setVolume(0.0f, 0.0f);
                } else {
                    VideoTextureView.a(this.vyR).setVolume(1.0f, 1.0f);
                }
            }
            VideoTextureView.a(this.vyR, false);
        }
        if (VideoTextureView.n(this.vyR) > 0 && VideoTextureView.o(this.vyR) != null) {
            VideoTextureView.o(this.vyR).bbH();
            VideoTextureView.p(this.vyR);
        }
        VideoTextureView.a(this.vyR, System.currentTimeMillis());
        if (VideoTextureView.q(this.vyR)) {
            x.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", new Object[]{Integer.valueOf(this.vyR.hashCode()), Integer.valueOf(this.vyR.getCurrentPosition())});
            if (VideoTextureView.a(this.vyR) != null) {
                VideoTextureView.a(this.vyR).pause();
                this.vyR.setMute(VideoTextureView.m(this.vyR));
            }
            VideoTextureView.r(this.vyR);
        }
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.VideoTextureView", "on texture size changed width : " + i + " height : " + i2);
        if (VideoTextureView.a(this.vyR) != null && VideoTextureView.s(this.vyR) && VideoTextureView.b(this.vyR) == i && VideoTextureView.c(this.vyR) == i2) {
            VideoTextureView.a(this.vyR).start();
        }
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[]{Integer.valueOf(this.vyR.hashCode()), Boolean.valueOf(VideoTextureView.s(this.vyR))});
        VideoTextureView.a(this.vyR, null);
        if (VideoTextureView.a(this.vyR) == null || !VideoTextureView.s(this.vyR)) {
            VideoTextureView.t(this.vyR);
            VideoTextureView.b(this.vyR, false);
        } else if (this.vyR.isPlaying()) {
            VideoTextureView.b(this.vyR, true);
            VideoTextureView.a(this.vyR).pause();
        }
        return false;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        VideoTextureView.d(this.vyR, i);
        VideoTextureView.e(this.vyR, i2);
        this.vyR.cpK();
        VideoTextureView.a(this.vyR, new Surface(surfaceTexture));
        x.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[]{Integer.valueOf(this.vyR.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(VideoTextureView.s(this.vyR)), Integer.valueOf(VideoTextureView.u(this.vyR).hashCode())});
        if (VideoTextureView.a(this.vyR) == null || !VideoTextureView.s(this.vyR)) {
            VideoTextureView.v(this.vyR);
        } else {
            VideoTextureView.a(this.vyR).setSurface(VideoTextureView.u(this.vyR));
            if (VideoTextureView.w(this.vyR)) {
                VideoTextureView.a(this.vyR).start();
            } else {
                VideoTextureView.a(this.vyR, true);
                VideoTextureView.a(this.vyR).setVolume(0.0f, 0.0f);
                VideoTextureView.a(this.vyR).start();
            }
            VideoTextureView.b(this.vyR, false);
        }
        if (VideoTextureView.x(this.vyR) != null) {
            VideoTextureView.x(this.vyR).TI();
        }
    }
}

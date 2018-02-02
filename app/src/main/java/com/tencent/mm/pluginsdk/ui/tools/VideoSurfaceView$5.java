package com.tencent.mm.pluginsdk.ui.tools;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mm.sdk.platformtools.x;

class VideoSurfaceView$5 implements Callback {
    final /* synthetic */ VideoSurfaceView vyJ;

    VideoSurfaceView$5(VideoSurfaceView videoSurfaceView) {
        this.vyJ = videoSurfaceView;
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (VideoSurfaceView.g(this.vyJ) != null && VideoSurfaceView.i(this.vyJ) && VideoSurfaceView.a(this.vyJ) == i2 && VideoSurfaceView.b(this.vyJ) == i3) {
            VideoSurfaceView.g(this.vyJ).start();
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        x.i("MicroMsg.VideoSurfaceView", "on surface created");
        VideoSurfaceView.a(this.vyJ, surfaceHolder);
        VideoSurfaceView.j(this.vyJ);
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        x.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
        VideoSurfaceView.a(this.vyJ, null);
        if (VideoSurfaceView.g(this.vyJ) != null) {
            VideoSurfaceView.e(this.vyJ).cf(VideoSurfaceView.g(this.vyJ).getCurrentPosition(), VideoSurfaceView.g(this.vyJ).getDuration());
            VideoSurfaceView.g(this.vyJ).reset();
            VideoSurfaceView.g(this.vyJ).release();
            VideoSurfaceView.k(this.vyJ);
        }
    }
}

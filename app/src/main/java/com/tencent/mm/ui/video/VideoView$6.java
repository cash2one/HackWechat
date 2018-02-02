package com.tencent.mm.ui.video;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

class VideoView$6 implements Callback {
    final /* synthetic */ VideoView zqr;

    VideoView$6(VideoView videoView) {
        this.zqr = videoView;
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        VideoView.d(this.zqr, i2);
        VideoView.e(this.zqr, i3);
        if (VideoView.e(this.zqr) != null && VideoView.n(this.zqr) && VideoView.a(this.zqr) == i2 && VideoView.b(this.zqr) == i3) {
            if (VideoView.j(this.zqr) != 0) {
                VideoView.e(this.zqr).seekTo(VideoView.j(this.zqr));
                VideoView.k(this.zqr);
            }
            VideoView.e(this.zqr).start();
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        VideoView.a(this.zqr, surfaceHolder);
        VideoView.o(this.zqr);
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        VideoView.a(this.zqr, null);
        if (VideoView.e(this.zqr) != null) {
            VideoView.e(this.zqr).reset();
            VideoView.e(this.zqr).release();
            VideoView.p(this.zqr);
        }
    }
}

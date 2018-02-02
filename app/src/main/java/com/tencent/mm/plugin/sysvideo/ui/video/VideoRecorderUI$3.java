package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mm.sdk.platformtools.x;

class VideoRecorderUI$3 implements Callback {
    final /* synthetic */ VideoRecorderUI sao;

    VideoRecorderUI$3(VideoRecorderUI videoRecorderUI) {
        this.sao = videoRecorderUI;
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        x.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
        if (VideoRecorderUI.h(this.sao).a(this.sao, VideoRecorderUI.q(this.sao)) != 0) {
            VideoRecorderUI.s(this.sao);
        }
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        x.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
        VideoRecorderUI.b(this.sao, true);
        VideoRecorderUI.h(this.sao).bZK();
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + i + " w:" + i2 + " h:" + i3);
        if (VideoRecorderUI.h(this.sao).b(surfaceHolder) != 0) {
            VideoRecorderUI.s(this.sao);
        }
        VideoRecorderUI.a(this.sao, false);
        VideoRecorderUI.b(this.sao, false);
        VideoRecorderUI.x(this.sao);
    }
}

package com.tencent.mm.pluginsdk.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;

class VideoPlayerSeekBar$1 implements OnTouchListener {
    final /* synthetic */ VideoPlayerSeekBar vyd;

    VideoPlayerSeekBar$1(VideoPlayerSeekBar videoPlayerSeekBar) {
        this.vyd = videoPlayerSeekBar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            x.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
            VideoPlayerSeekBar.a(this.vyd);
            VideoPlayerSeekBar.a(this.vyd, motionEvent.getX());
            if (VideoPlayerSeekBar.b(this.vyd) != null) {
                VideoPlayerSeekBar.c(this.vyd).agX();
            }
        } else if (motionEvent.getAction() == 2) {
            float x = motionEvent.getX();
            LayoutParams layoutParams = (LayoutParams) VideoPlayerSeekBar.d(this.vyd).getLayoutParams();
            int a = VideoPlayerSeekBar.a(this.vyd, ((int) (x - VideoPlayerSeekBar.e(this.vyd))) + layoutParams.leftMargin, VideoPlayerSeekBar.f(this.vyd));
            layoutParams.leftMargin = a;
            VideoPlayerSeekBar.g(this.vyd).setLayoutParams(layoutParams);
            int i = VideoPlayerSeekBar.f(this.vyd).value;
            if (VideoPlayerSeekBar.h(this.vyd) > 0) {
                layoutParams = (LayoutParams) VideoPlayerSeekBar.i(this.vyd).getLayoutParams();
                layoutParams.width = a;
                VideoPlayerSeekBar.j(this.vyd).setLayoutParams(layoutParams);
            }
            VideoPlayerSeekBar.k(this.vyd).setText(VideoPlayerSeekBar.kG(i / 60) + ":" + VideoPlayerSeekBar.kG(i % 60));
            VideoPlayerSeekBar.l(this.vyd);
        } else {
            int m = VideoPlayerSeekBar.m(this.vyd);
            if (VideoPlayerSeekBar.n(this.vyd)) {
                m = VideoPlayerSeekBar.a(this.vyd, VideoPlayerSeekBar.f(this.vyd).value);
            }
            if (VideoPlayerSeekBar.o(this.vyd) != null) {
                x.i("MicroMsg.VideoPlayerSeekBar", "current time : " + m);
                VideoPlayerSeekBar.p(this.vyd).kH(m);
            }
            VideoPlayerSeekBar.q(this.vyd);
        }
        return true;
    }
}

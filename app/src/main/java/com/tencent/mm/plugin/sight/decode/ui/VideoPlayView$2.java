package com.tencent.mm.plugin.sight.decode.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class VideoPlayView$2 implements OnTouchListener {
    final /* synthetic */ VideoPlayView qvt;

    VideoPlayView$2(VideoPlayView videoPlayView) {
        this.qvt = videoPlayView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            VideoPlayView.m(this.qvt);
        } else {
            motionEvent.getAction();
        }
        return true;
    }
}

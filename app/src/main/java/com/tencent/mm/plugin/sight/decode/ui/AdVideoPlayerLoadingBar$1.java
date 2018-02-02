package com.tencent.mm.plugin.sight.decode.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;

class AdVideoPlayerLoadingBar$1 implements OnTouchListener {
    final /* synthetic */ AdVideoPlayerLoadingBar quz;

    AdVideoPlayerLoadingBar$1(AdVideoPlayerLoadingBar adVideoPlayerLoadingBar) {
        this.quz = adVideoPlayerLoadingBar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            x.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
            this.quz.kog = false;
            this.quz.quu = motionEvent.getX();
            if (this.quz.quk != null) {
                this.quz.quk.agX();
            }
        } else if (motionEvent.getAction() == 2) {
            float x = motionEvent.getX();
            LayoutParams layoutParams = (LayoutParams) this.quz.qun.getLayoutParams();
            layoutParams.leftMargin = AdVideoPlayerLoadingBar.a(this.quz, ((int) (x - this.quz.quu)) + layoutParams.leftMargin);
            this.quz.qun.setLayoutParams(layoutParams);
            int bsV = this.quz.bsV();
            if (this.quz.qur > 0) {
                layoutParams = (LayoutParams) this.quz.qul.getLayoutParams();
                layoutParams.width = (int) (((((double) bsV) * 1.0d) / ((double) this.quz.qur)) * ((double) this.quz.bsY()));
                this.quz.qul.setLayoutParams(layoutParams);
            }
            this.quz.qup.setText(AdVideoPlayerLoadingBar.kG(bsV / 60) + ":" + AdVideoPlayerLoadingBar.kG(bsV % 60));
            this.quz.kog = true;
        } else if (this.quz.kog) {
            int bsV2 = this.quz.bsV();
            if (this.quz.quk != null) {
                x.i("MicroMsg.VideoPlayerLoadingBar", "current time : " + bsV2);
                this.quz.quk.kH(bsV2);
            }
            this.quz.kog = false;
        }
        return true;
    }
}

package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class MaskLinearLayout$2 implements OnTouchListener {
    final /* synthetic */ MaskLinearLayout rur;

    MaskLinearLayout$2(MaskLinearLayout maskLinearLayout) {
        this.rur = maskLinearLayout;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        x.e("test", "touch: " + motionEvent.getAction());
        if (MaskLinearLayout.b(this.rur)) {
            switch (motionEvent.getAction()) {
                case 0:
                    view.setPressed(true);
                    MaskLinearLayout.a(this.rur);
                    view.invalidate();
                    MaskLinearLayout.d(this.rur).removeCallbacks(MaskLinearLayout.c(this.rur));
                    break;
                case 1:
                case 3:
                    MaskLinearLayout.d(this.rur).post(MaskLinearLayout.c(this.rur));
                    break;
            }
            if (MaskLinearLayout.e(this.rur) != null) {
                for (MaskImageView maskImageView : MaskLinearLayout.e(this.rur)) {
                    maskImageView.c(maskImageView, motionEvent);
                }
            }
        }
        return false;
    }
}

package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mm.ui.widget.MMWebView;

public class EmbedWebView extends MMWebView {
    private GestureDetector psc = new GestureDetector(new 1(this));
    private boolean psd = false;
    private float[] pse = new float[2];
    private float[] psf = new float[2];
    private float[] psg = new float[2];
    private float[] psh = new float[2];

    public EmbedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        postDelayed(new 2(this), 100);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        this.psc.onTouchEvent(motionEvent);
        if (this.psd) {
            int action = motionEvent.getAction() & 255;
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount == 2) {
                switch (action) {
                    case 2:
                        for (action = 0; action < pointerCount; action++) {
                            this.psg[action] = motionEvent.getX(action);
                            this.psh[action] = motionEvent.getY(action);
                        }
                        float pow = (float) (Math.pow((double) (this.pse[1] - this.pse[0]), 2.0d) + Math.pow((double) (this.psf[1] - this.psf[0]), 2.0d));
                        float pow2 = (float) (Math.pow((double) (this.psg[1] - this.psg[0]), 2.0d) + Math.pow((double) (this.psh[1] - this.psh[0]), 2.0d));
                        if (pow - pow2 > 20000.0f) {
                            zoomOut();
                        } else if (pow2 - pow > 20000.0f) {
                            zoomIn();
                        }
                        this.pse[0] = this.psg[0];
                        this.pse[1] = this.psg[1];
                        this.psf[0] = this.psh[0];
                        this.psf[1] = this.psh[1];
                        break;
                    case 5:
                        while (i < pointerCount) {
                            this.pse[i] = motionEvent.getX(i);
                            this.psf[i] = motionEvent.getY(i);
                            i++;
                        }
                        break;
                }
                i = 1;
            }
            if (i != 0) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}

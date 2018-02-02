package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.wcdb.support.Log;

public class MMSightCaptureTouchView extends RelativeLayout {
    private long ipR = -1;
    private float ipS = -1.0f;
    private int ipT = 0;
    a oAL;

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_DOWN");
                if (this.ipR <= 0 || SystemClock.elapsedRealtime() - this.ipR >= 400) {
                    if (this.oAL != null) {
                        this.oAL.D(motionEvent.getX(), motionEvent.getY());
                    }
                } else if (this.oAL != null) {
                    this.oAL.bbr();
                }
                this.ipR = SystemClock.elapsedRealtime();
                this.ipS = -1.0f;
                this.ipT++;
                break;
            case 1:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
                this.ipS = -1.0f;
                this.ipT = 0;
                break;
            case 2:
                if (this.ipT >= 2) {
                    float w = w(motionEvent);
                    Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", new Object[]{Float.valueOf(w)});
                    if (w > 0.0f) {
                        if (this.ipS > 0.0f) {
                            if (Math.abs(w - this.ipS) > 15.0f) {
                                if (w > this.ipS) {
                                    Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
                                    if (this.oAL != null) {
                                        this.oAL.Yp();
                                    }
                                } else {
                                    Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
                                    if (this.oAL != null) {
                                        this.oAL.Yq();
                                    }
                                }
                            }
                        }
                        this.ipS = w;
                        break;
                    }
                }
                break;
            case 5:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
                this.ipT++;
                break;
            case 6:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
                this.ipT--;
                break;
        }
        return true;
    }

    private float w(MotionEvent motionEvent) {
        try {
            if (this.ipT >= 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                return Math.abs(x - motionEvent.getX(1)) + Math.abs(y - motionEvent.getY(1));
            }
        } catch (Exception e) {
            Log.e("MicroMsg.MMSightCaptureTouchView", "pointerDistance error: %s", new Object[]{e.getMessage()});
        }
        return 0.0f;
    }
}

package com.tencent.mm.plugin.api.recordView;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

final class g implements OnTouchListener {
    private long ipR = -1;
    private float ipS = -1.0f;
    private int ipT = 0;
    a ipU;

    g() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                x.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_DOWN");
                if (this.ipR > 0 && SystemClock.elapsedRealtime() - this.ipR < 400) {
                    break;
                } else if (this.ipU != null) {
                    a aVar = this.ipU;
                    motionEvent.getX();
                    motionEvent.getY();
                    aVar.Yo();
                }
                this.ipR = SystemClock.elapsedRealtime();
                this.ipS = -1.0f;
                this.ipT++;
                break;
            case 1:
                x.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
                this.ipS = -1.0f;
                this.ipT = 0;
                break;
            case 2:
                if (this.ipT >= 2) {
                    float w = w(motionEvent);
                    x.v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", new Object[]{Float.valueOf(w)});
                    if (w > 0.0f) {
                        if (this.ipS > 0.0f) {
                            if (Math.abs(w - this.ipS) > 15.0f) {
                                if (w > this.ipS) {
                                    x.d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
                                    if (this.ipU != null) {
                                        this.ipU.Yp();
                                    }
                                } else {
                                    x.d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
                                    if (this.ipU != null) {
                                        this.ipU.Yq();
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
                x.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
                this.ipT++;
                break;
            case 6:
                x.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
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
            x.e("MicroMsg.MMSightRecordViewTouchListener", "pointerDistance error: %s", new Object[]{e.getMessage()});
        }
        return 0.0f;
    }
}

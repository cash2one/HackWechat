package com.tencent.mm.plugin.webview.fts.topstory.ui.widget;

import android.media.AudioManager;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.webview.fts.c.c;
import com.tencent.mm.plugin.webview.fts.topstory.ui.widget.a.a;

class a$2 extends SimpleOnGestureListener {
    final /* synthetic */ a tqs;

    a$2(a aVar) {
        this.tqs = aVar;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        this.tqs.jtu.postDelayed(this.tqs.jtC, 200);
        return true;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        this.tqs.jtu.removeCallbacks(this.tqs.jtC);
        this.tqs.tqp.agT();
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3 = 1.0f;
        if (!(motionEvent == null || motionEvent2 == null)) {
            if (this.tqs.tqo == a.tqt) {
                if (Math.abs(f) > Math.abs(f2)) {
                    this.tqs.tqo = a.tqw;
                } else if (motionEvent.getX() < ((float) (this.tqs.jtu.getMeasuredWidth() / 2))) {
                    this.tqs.tqo = a.tqv;
                } else {
                    this.tqs.tqo = a.tqu;
                }
            }
            float x = motionEvent2.getX() - motionEvent.getX();
            float y = motionEvent2.getY() - motionEvent.getY();
            a aVar = this.tqs;
            if (aVar.tqo == a.tqw) {
                if (aVar.jtA == -1) {
                    aVar.tqp.agU();
                    aVar.jtA = aVar.tqp.getCurrentPosition();
                }
                aVar.jtB = aVar.tqp.e(aVar.jtA, x);
            } else if (aVar.tqo == a.tqv && aVar.tqr) {
                x = (((y * -1.0f) / ((float) aVar.jtu.getMeasuredHeight())) * 1.2f) + aVar.jek;
                if (x < 0.0f) {
                    f3 = 0.0f;
                } else if (x <= 1.0f) {
                    f3 = x;
                }
                c.g(aVar.mContext, f3);
                aVar.tqp.Z(f3);
            } else if (aVar.tqo == a.tqu && aVar.tqq) {
                int i;
                float f4 = y * -1.0f;
                x = f4 / ((float) aVar.jtu.getMeasuredHeight());
                AudioManager audioManager = (AudioManager) aVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                float f5 = (x * ((float) streamMaxVolume)) * 1.2f;
                int i2 = (int) f5;
                if (i2 == 0 && Math.abs(f5) > 0.2f) {
                    if (f4 > 0.0f) {
                        i = 1;
                    } else if (f4 < 0.0f) {
                        i = -1;
                    }
                    i += aVar.jty;
                    if (i < 0) {
                        i = 0;
                    } else if (i >= streamMaxVolume) {
                        i = streamMaxVolume;
                    }
                    audioManager.setStreamVolume(3, i, 0);
                    aVar.tqp.Y(((float) i) / ((float) streamMaxVolume));
                }
                i = i2;
                i += aVar.jty;
                if (i < 0) {
                    i = 0;
                } else if (i >= streamMaxVolume) {
                    i = streamMaxVolume;
                }
                audioManager.setStreamVolume(3, i, 0);
                aVar.tqp.Y(((float) i) / ((float) streamMaxVolume));
            }
        }
        return true;
    }
}

package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class SnsOnlineVideoActivity$5 implements OnTouchListener {
    final /* synthetic */ SnsOnlineVideoActivity rEF;

    SnsOnlineVideoActivity$5(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        this.rEF = snsOnlineVideoActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        float f = 1.0f;
        SnsOnlineVideoActivity.d(this.rEF).onTouchEvent(motionEvent);
        if (SnsOnlineVideoActivity.e(this.rEF) == null) {
            SnsOnlineVideoActivity.a(this.rEF, VelocityTracker.obtain());
        }
        if (SnsOnlineVideoActivity.e(this.rEF) != null) {
            SnsOnlineVideoActivity.e(this.rEF).addMovement(motionEvent);
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                SnsOnlineVideoActivity.a(this.rEF, motionEvent.getX());
                SnsOnlineVideoActivity.b(this.rEF, motionEvent.getY());
                if (SnsOnlineVideoActivity.f(this.rEF)) {
                    SnsOnlineVideoActivity.g(this.rEF);
                    SnsOnlineVideoActivity.b(this.rEF, false);
                    break;
                }
                break;
            case 1:
                if (SnsOnlineVideoActivity.f(this.rEF)) {
                    SnsOnlineVideoActivity.c(this.rEF).setPivotX((float) (SnsOnlineVideoActivity.a(this.rEF).getWidth() / 2));
                    SnsOnlineVideoActivity.c(this.rEF).setPivotY((float) (SnsOnlineVideoActivity.a(this.rEF).getHeight() / 2));
                    SnsOnlineVideoActivity.c(this.rEF).setScaleX(1.0f);
                    SnsOnlineVideoActivity.c(this.rEF).setScaleY(1.0f);
                    SnsOnlineVideoActivity.c(this.rEF).setTranslationX(0.0f);
                    SnsOnlineVideoActivity.c(this.rEF).setTranslationY(0.0f);
                    SnsOnlineVideoActivity.h(this.rEF).setAlpha(1.0f);
                    SnsOnlineVideoActivity.c(this.rEF, 1.0f);
                    SnsOnlineVideoActivity.c(this.rEF, false);
                    SnsOnlineVideoActivity.a(this.rEF, false);
                    return true;
                } else if (!SnsOnlineVideoActivity.b(this.rEF) || SnsOnlineVideoActivity.i(this.rEF)) {
                    SnsOnlineVideoActivity.a(this.rEF, false);
                    break;
                } else {
                    this.rEF.avV();
                    SnsOnlineVideoActivity.a(this.rEF, false);
                    return true;
                }
                break;
            case 2:
                VelocityTracker e = SnsOnlineVideoActivity.e(this.rEF);
                e.computeCurrentVelocity(1000);
                int xVelocity = (int) e.getXVelocity();
                int yVelocity = (int) e.getYVelocity();
                float translationX = SnsOnlineVideoActivity.c(this.rEF).getTranslationX();
                float translationY = SnsOnlineVideoActivity.c(this.rEF).getTranslationY();
                SnsOnlineVideoActivity.a(this.rEF, (int) translationX);
                SnsOnlineVideoActivity.b(this.rEF, (int) translationY);
                x.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", new Object[]{Boolean.valueOf(SnsOnlineVideoActivity.b(this.rEF)), Float.valueOf(translationX), Float.valueOf(translationY), Integer.valueOf(xVelocity), Integer.valueOf(yVelocity)});
                if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || SnsOnlineVideoActivity.i(this.rEF)) && !SnsOnlineVideoActivity.b(this.rEF)) {
                    SnsOnlineVideoActivity.c(this.rEF, false);
                } else {
                    translationX = 1.0f - (translationY / ((float) SnsOnlineVideoActivity.a(this.rEF).getHeight()));
                    if (translationX <= 1.0f) {
                        f = translationX;
                    }
                    if (((yVelocity > 0 && f < SnsOnlineVideoActivity.j(this.rEF)) || yVelocity < 0) && ((double) f) >= 0.5d) {
                        x.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", new Object[]{Float.valueOf(f)});
                        SnsOnlineVideoActivity.c(this.rEF, f);
                        SnsOnlineVideoActivity.c(this.rEF).setPivotX((float) (SnsOnlineVideoActivity.a(this.rEF).getWidth() / 2));
                        SnsOnlineVideoActivity.c(this.rEF).setPivotY((float) (SnsOnlineVideoActivity.a(this.rEF).getHeight() / 2));
                        SnsOnlineVideoActivity.c(this.rEF).setScaleX(f);
                        SnsOnlineVideoActivity.c(this.rEF).setScaleY(f);
                        SnsOnlineVideoActivity.c(this.rEF).setTranslationY(translationY);
                        SnsOnlineVideoActivity.h(this.rEF).setAlpha(f);
                    }
                    SnsOnlineVideoActivity.c(this.rEF, true);
                }
                if (translationY > 200.0f) {
                    SnsOnlineVideoActivity.b(this.rEF, false);
                } else if (translationY > 10.0f) {
                    SnsOnlineVideoActivity.b(this.rEF, true);
                }
                if (translationY > 50.0f) {
                    SnsOnlineVideoActivity.c(this.rEF).setOnLongClickListener(null);
                }
                if (SnsOnlineVideoActivity.e(this.rEF) != null) {
                    SnsOnlineVideoActivity.e(this.rEF).recycle();
                    SnsOnlineVideoActivity.a(this.rEF, null);
                }
                if (SnsOnlineVideoActivity.b(this.rEF)) {
                    return true;
                }
                break;
        }
        return false;
    }
}

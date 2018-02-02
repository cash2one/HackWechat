package com.tencent.mm.ui.base;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;

class MMViewPager$d extends SimpleOnGestureListener {
    final /* synthetic */ MMViewPager yeI;

    private MMViewPager$d(MMViewPager mMViewPager) {
        this.yeI = mMViewPager;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (MMViewPager.l(this.yeI) != null) {
            MMViewPager.l(this.yeI).avW();
        }
        return true;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        if (MMViewPager.m(this.yeI) != null) {
            MMViewPager.m(this.yeI).forceFinished(true);
        }
        return super.onDown(motionEvent);
    }

    public final void onLongPress(MotionEvent motionEvent) {
        MMViewPager.n(this.yeI);
        if (MMViewPager.o(this.yeI) != null) {
            MMViewPager.o(this.yeI).aJi();
        }
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (MMViewPager.a(this.yeI) == null) {
            return false;
        }
        if (MMViewPager.a(this.yeI).getScale() <= MMViewPager.a(this.yeI).pXP) {
            MMViewPager.a(this.yeI).J(g.i(motionEvent, 0), g.j(motionEvent, 0));
        } else {
            MMViewPager.a(this.yeI).I(g.i(motionEvent, 0), g.j(motionEvent, 0));
        }
        return true;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        x.d("MicroMsg.MMViewPager", "onFling");
        MultiTouchImageView g = MMViewPager.g(this.yeI);
        if (g != null) {
            x.d("MicroMsg.MMViewPager", "onFling MultiTouchImageView");
            g = g;
            float scale = g.getScale() * ((float) g.imageWidth);
            float scale2 = g.getScale() * ((float) g.imageHeight);
            if (g.yfs || g.yft || ((int) scale) > MMViewPager.b(this.yeI) || ((int) scale2) > MMViewPager.d(this.yeI)) {
                float f3;
                r6 = new float[9];
                g.getImageMatrix().getValues(r6);
                float f4 = r6[2];
                float f5 = f4 + scale;
                float f6 = r6[5];
                float f7 = f6 + scale2;
                x.d("MicroMsg.MMViewPager", "left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", new Object[]{Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(MMViewPager.c(motionEvent, motionEvent2)), Float.valueOf(f), Float.valueOf(f2)});
                if (((float) Math.round(f4)) >= MMViewPager.p(this.yeI).left || ((float) Math.round(f5)) <= MMViewPager.p(this.yeI).right) {
                    f3 = 0.0f;
                } else {
                    f3 = f;
                }
                if (((float) Math.round(f6)) >= MMViewPager.p(this.yeI).top || ((float) Math.round(f7)) <= MMViewPager.p(this.yeI).bottom) {
                    f2 = 0.0f;
                }
                int i = (int) (MMViewPager.p(this.yeI).right - scale);
                int i2 = (int) (scale + MMViewPager.p(this.yeI).right);
                int i3 = (int) (MMViewPager.p(this.yeI).bottom - scale2);
                int i4 = (int) (MMViewPager.p(this.yeI).bottom + scale2);
                if (f3 >= 0.0f) {
                    if (Math.abs(f3) >= ((float) MMViewPager.q(this.yeI))) {
                        f3 = (float) MMViewPager.q(this.yeI);
                    }
                    f6 = f3;
                } else {
                    f6 = Math.abs(f) >= ((float) MMViewPager.q(this.yeI)) ? (float) (-MMViewPager.q(this.yeI)) : f;
                }
                if (f2 >= 0.0f) {
                    if (Math.abs(f2) >= ((float) MMViewPager.q(this.yeI))) {
                        f2 = (float) MMViewPager.q(this.yeI);
                    }
                } else if (Math.abs(f2) >= ((float) MMViewPager.q(this.yeI))) {
                    f2 = (float) (-MMViewPager.q(this.yeI));
                }
                MMViewPager.m(this.yeI).fling(MMViewPager.m(this.yeI).getCurrX(), MMViewPager.m(this.yeI).getCurrY(), (int) f6, (int) f2, i, i2, i3, i4, 0, 0);
                if ((!MMViewPager.c(motionEvent, motionEvent2) || f4 < 0.0f) && (MMViewPager.c(motionEvent, motionEvent2) || f5 > ((float) MMViewPager.b(this.yeI)))) {
                    return false;
                }
            }
        }
        if (MMViewPager.i(this.yeI)) {
            return false;
        }
        return MMViewPager.a(this.yeI, motionEvent, motionEvent2, f);
    }
}

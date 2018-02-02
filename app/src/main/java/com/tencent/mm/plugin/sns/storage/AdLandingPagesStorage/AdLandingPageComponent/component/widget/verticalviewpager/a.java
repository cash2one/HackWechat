package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.SystemClock;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b;

public final class a implements OnTouchListener {
    private float iQL = Float.MIN_VALUE;
    private DummyViewPager rmL;
    private float rmM = Float.MIN_VALUE;

    public a(DummyViewPager dummyViewPager) {
        this.rmL = dummyViewPager;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        new StringBuilder("onTouchEvent , action ").append(motionEvent.getAction()).append(", e.rawY ").append(motionEvent.getRawY()).append(",lastMotionY ").append(this.rmM).append(",downY ").append(this.iQL);
        switch (motionEvent.getAction()) {
            case 0:
                this.iQL = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                if (this.rmL.zg) {
                    try {
                        AdLandingViewPager adLandingViewPager = this.rmL;
                        if (adLandingViewPager.zg) {
                            VelocityTracker velocityTracker = adLandingViewPager.ft;
                            velocityTracker.computeCurrentVelocity(1000, (float) adLandingViewPager.zd);
                            int a = (int) y.a(velocityTracker, adLandingViewPager.fu);
                            adLandingViewPager.yV = true;
                            int bQ = adLandingViewPager.bQ();
                            int scrollX = adLandingViewPager.getScrollX();
                            b bxA = adLandingViewPager.bxA();
                            adLandingViewPager.a(adLandingViewPager.a(bxA.position, ((((float) scrollX) / ((float) bQ)) - bxA.zA) / bxA.zz, a, (int) (adLandingViewPager.za - adLandingViewPager.xP)), true, true, a);
                            adLandingViewPager.cD();
                            adLandingViewPager.zg = false;
                        } else {
                            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
                        }
                    } catch (Exception e) {
                    }
                }
                this.iQL = Float.MIN_VALUE;
                this.rmM = Float.MIN_VALUE;
                break;
            case 2:
                if (this.iQL == Float.MIN_VALUE && this.rmM == Float.MIN_VALUE) {
                    this.iQL = motionEvent.getRawY();
                    break;
                }
                float rawY = motionEvent.getRawY() - (this.rmM == Float.MIN_VALUE ? this.iQL : this.rmM);
                this.rmM = motionEvent.getRawY();
                float f = rawY / 2.0f;
                new StringBuilder("scrollX ").append(this.rmL.getScrollX()).append(",basescrollX ").append(this.rmL.bxC());
                if (this.rmL.getScrollX() == this.rmL.bxC()) {
                    if (z.h(view, (-f) > 0.0f ? 1 : -1)) {
                        new StringBuilder("scroll vertically  ").append(f).append(", move.lastMotionY ").append(motionEvent.getY());
                        break;
                    }
                    this.rmL.bxB();
                    a(view, motionEvent, f);
                    b(view, motionEvent);
                    return false;
                } else if (a(view, motionEvent, f)) {
                    return false;
                }
                break;
        }
        return view.onTouchEvent(motionEvent);
    }

    private boolean a(View view, MotionEvent motionEvent, float f) {
        if (!this.rmL.zg) {
            return false;
        }
        boolean z;
        float scrollX;
        float scrollX2 = (float) (((int) (((float) this.rmL.getScrollX()) - f)) - this.rmL.bxC());
        float scrollX3 = (float) (this.rmL.getScrollX() - this.rmL.bxC());
        if (Math.abs(scrollX2 + scrollX3) < Math.abs(scrollX2 - scrollX3)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            scrollX = (float) (this.rmL.getScrollX() - this.rmL.bxC());
        } else {
            scrollX = f;
        }
        AdLandingViewPager adLandingViewPager = this.rmL;
        if (adLandingViewPager.zg) {
            adLandingViewPager.za += scrollX;
            float scrollX4 = ((float) adLandingViewPager.getScrollX()) - scrollX;
            int bQ = adLandingViewPager.bQ();
            float f2 = ((float) bQ) * adLandingViewPager.yR;
            b bVar = (b) adLandingViewPager.ep.get(0);
            b bVar2 = (b) adLandingViewPager.ep.get(adLandingViewPager.ep.size() - 1);
            scrollX2 = bVar.position != 0 ? bVar.zA * ((float) bQ) : ((float) bQ) * adLandingViewPager.yQ;
            scrollX3 = bVar2.position != adLandingViewPager.yE.getCount() + -1 ? bVar2.zA * ((float) bQ) : f2;
            if (scrollX4 >= scrollX2) {
                scrollX2 = scrollX4 > scrollX3 ? scrollX3 : scrollX4;
            }
            adLandingViewPager.za += scrollX2 - ((float) ((int) scrollX2));
            adLandingViewPager.scrollTo((int) scrollX2, adLandingViewPager.getScrollY());
            adLandingViewPager.ak((int) scrollX2);
            MotionEvent obtain = MotionEvent.obtain(adLandingViewPager.rmC, SystemClock.uptimeMillis(), 2, adLandingViewPager.za, 0.0f, 0);
            adLandingViewPager.ft.addMovement(obtain);
            obtain.recycle();
            new StringBuilder("fake drag, diff ").append(f).append(",step ").append(scrollX).append(",scrollX ").append(this.rmL.getScrollX());
            b(view, motionEvent);
            return true;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    private static void b(View view, MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(0);
        view.dispatchTouchEvent(obtain);
    }
}

package com.tencent.mm.plugin.sport.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;

class SportChartView$1 extends SimpleOnGestureListener {
    private long rUL;
    final /* synthetic */ SportChartView rUM;

    SportChartView$1(SportChartView sportChartView) {
        this.rUM = sportChartView;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        SportChartView.a(this.rUM, SportChartView.a(this.rUM, x));
        SportChartView.a(this.rUM);
        SportChartView.b(this.rUM);
        x.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", Float.valueOf(x), Float.valueOf(y), Integer.valueOf(SportChartView.c(this.rUM)));
        this.rUM.invalidate();
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        x.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", Float.valueOf(f));
        if (System.currentTimeMillis() - this.rUL < 500 || !SportChartView.d(this.rUM)) {
            return false;
        }
        this.rUL = System.currentTimeMillis();
        if (f > 0.0f) {
            SportChartView.e(this.rUM);
            if (SportChartView.f(this.rUM) > SportChartView.g(this.rUM)) {
                SportChartView.b(this.rUM, SportChartView.g(this.rUM));
            }
            SportChartView.h(this.rUM);
            this.rUM.invalidate();
            return true;
        } else if (f >= 0.0f) {
            return false;
        } else {
            SportChartView.i(this.rUM);
            if (SportChartView.f(this.rUM) <= 0) {
                SportChartView.b(this.rUM, 1);
            }
            SportChartView.h(this.rUM);
            this.rUM.invalidate();
            return true;
        }
    }
}

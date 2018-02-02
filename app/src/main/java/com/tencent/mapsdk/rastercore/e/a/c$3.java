package com.tencent.mapsdk.rastercore.e.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mapsdk.raster.model.Marker;

class c$3 implements OnTouchListener {
    private /* synthetic */ c a;

    c$3(c cVar) {
        this.a = cVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Marker marker;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (c.b(this.a) && c.c(this.a)) {
                    c.a(this.a, false);
                    this.a.n();
                    new StringBuilder().append(c.e(this.a));
                    if (c.e(this.a)) {
                        this.a.f();
                        c.b(this.a, false);
                    }
                    if (c.a(this.a).e() != null) {
                        c.a(this.a).e();
                        marker = new Marker(this.a);
                        break;
                    }
                }
                break;
            case 2:
                if (c.b(this.a) && c.c(this.a)) {
                    float x = c.a(this.a).c().getX();
                    float y = c.a(this.a).c().getY();
                    c.a(this.a, x, y - ((float) c.f(this.a)));
                    new StringBuilder().append(x).append(",").append(y);
                    if (c.a(this.a).e() != null) {
                        c.a(this.a).e();
                        marker = new Marker(this.a);
                    }
                    return true;
                }
        }
        return c.i(this.a).onTouchEvent(motionEvent);
    }
}

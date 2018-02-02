package com.tencent.mapsdk.rastercore.a;

import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.tencentmap.mapsdk.map.c;

public abstract class a {
    protected e a;
    protected b b;
    protected c c;
    private a d = a.c;
    private Handler e = new Handler();
    private Scroller f;
    private long g;
    private float h = 0.0f;
    private boolean i = false;
    private double j = 0.0d;
    private Runnable k = new 1(this);

    public a(e eVar, long j, c cVar) {
        this.a = eVar;
        this.b = eVar.c();
        this.g = j;
        this.c = cVar;
    }

    public final void a() {
        switch (2.a[this.d.ordinal()]) {
            case 1:
                this.f = new Scroller(e.a(), new AccelerateInterpolator());
                break;
            case 2:
                this.f = new Scroller(e.a(), new DecelerateInterpolator());
                break;
            case 3:
                this.f = new Scroller(e.a(), new AccelerateDecelerateInterpolator());
                break;
            default:
                this.f = new Scroller(e.a());
                break;
        }
        c();
        this.i = true;
        this.f.startScroll(0, 0, 10000, 0, (int) this.g);
        this.e.postDelayed(this.k, 5);
        this.a.a(false, false);
    }

    protected abstract void a(float f);

    public final void a(a aVar) {
        this.d = aVar;
    }

    public final void b() {
        if (this.i) {
            this.i = false;
            if (this.c != null) {
                this.c.onCancel();
            }
            this.a.h().a(true);
        }
    }

    protected abstract void c();

    protected abstract void d();
}

package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d {
    public static final h zCO = new h(Looper.getMainLooper(), "Vending.UI");
    public static final h zCP = new h(b.cAb().zCY.getLooper(), "Vending.LOGIC");
    public static final h zCQ = new h(a.cAa().zCW.getLooper(), "Vending.HEAVY_WORK");

    public abstract void cancel();

    public abstract void f(Runnable runnable);

    public abstract void f(Runnable runnable, long j);

    public abstract String getType();

    static {
        g.czZ();
    }

    public static synchronized d czY() {
        d czY;
        synchronized (d.class) {
            czY = g.czY();
        }
        return czY;
    }
}

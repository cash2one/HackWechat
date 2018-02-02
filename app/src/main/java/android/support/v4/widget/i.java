package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class i {
    private static final c CB;
    private Object CA;

    interface c {
        boolean I(Object obj);

        void J(Object obj);

        boolean K(Object obj);

        void a(Object obj, int i, int i2);

        boolean a(Object obj, float f);

        boolean a(Object obj, float f, float f2);

        boolean a(Object obj, Canvas canvas);

        boolean k(Object obj, int i);

        Object o(Context context);
    }

    static class a implements c {
        a() {
        }

        public final Object o(Context context) {
            return null;
        }

        public final void a(Object obj, int i, int i2) {
        }

        public final boolean I(Object obj) {
            return true;
        }

        public final void J(Object obj) {
        }

        public final boolean a(Object obj, float f) {
            return false;
        }

        public final boolean K(Object obj) {
            return false;
        }

        public final boolean k(Object obj, int i) {
            return false;
        }

        public final boolean a(Object obj, Canvas canvas) {
            return false;
        }

        public final boolean a(Object obj, float f, float f2) {
            return false;
        }
    }

    static class b implements c {
        b() {
        }

        public final Object o(Context context) {
            return new EdgeEffect(context);
        }

        public final void a(Object obj, int i, int i2) {
            ((EdgeEffect) obj).setSize(i, i2);
        }

        public final boolean I(Object obj) {
            return ((EdgeEffect) obj).isFinished();
        }

        public final void J(Object obj) {
            ((EdgeEffect) obj).finish();
        }

        public final boolean a(Object obj, float f) {
            return j.a(obj, f);
        }

        public final boolean K(Object obj) {
            EdgeEffect edgeEffect = (EdgeEffect) obj;
            edgeEffect.onRelease();
            return edgeEffect.isFinished();
        }

        public final boolean k(Object obj, int i) {
            ((EdgeEffect) obj).onAbsorb(i);
            return true;
        }

        public final boolean a(Object obj, Canvas canvas) {
            return ((EdgeEffect) obj).draw(canvas);
        }

        public boolean a(Object obj, float f, float f2) {
            return j.a(obj, f);
        }
    }

    static class d extends b {
        d() {
        }

        public final boolean a(Object obj, float f, float f2) {
            ((EdgeEffect) obj).onPull(f, f2);
            return true;
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            CB = new d();
        } else if (VERSION.SDK_INT >= 14) {
            CB = new b();
        } else {
            CB = new a();
        }
    }

    public i(Context context) {
        this.CA = CB.o(context);
    }

    public final void setSize(int i, int i2) {
        CB.a(this.CA, i, i2);
    }

    public final boolean isFinished() {
        return CB.I(this.CA);
    }

    public final void finish() {
        CB.J(this.CA);
    }

    public final boolean x(float f) {
        return CB.a(this.CA, f);
    }

    public final boolean h(float f, float f2) {
        return CB.a(this.CA, f, f2);
    }

    public final boolean cv() {
        return CB.K(this.CA);
    }

    public final boolean ap(int i) {
        return CB.k(this.CA, i);
    }

    public final boolean draw(Canvas canvas) {
        return CB.a(this.CA, canvas);
    }
}

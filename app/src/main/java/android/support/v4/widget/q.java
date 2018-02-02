package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.Scroller;

public final class q {
    Object DG;
    a DH;

    interface a {
        boolean I(Object obj);

        int L(Object obj);

        int M(Object obj);

        float N(Object obj);

        boolean O(Object obj);

        void P(Object obj);

        int Q(Object obj);

        int R(Object obj);

        void a(Object obj, int i, int i2, int i3, int i4);

        void a(Object obj, int i, int i2, int i3, int i4, int i5);

        void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        boolean a(Object obj, int i, int i2, int i3, int i4, int i5, int i6);

        Object b(Context context, Interpolator interpolator);
    }

    static class b implements a {
        b() {
        }

        public final Object b(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        public final boolean I(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        public final int L(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        public final int M(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        public final float N(Object obj) {
            return 0.0f;
        }

        public final boolean O(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        public final void a(Object obj, int i, int i2, int i3, int i4) {
            ((Scroller) obj).startScroll(i, i2, 0, i4);
        }

        public final void a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        public final void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((Scroller) obj).fling(0, i2, i3, i4, i5, i6, i7, i8);
        }

        public final void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((Scroller) obj).fling(i, i2, 0, i4, 0, 0, 0, i8);
        }

        public final void P(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        public final int Q(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        public final int R(Object obj) {
            return ((Scroller) obj).getFinalY();
        }

        public final boolean a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return false;
        }
    }

    static class c implements a {
        c() {
        }

        public final Object b(Context context, Interpolator interpolator) {
            return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
        }

        public final boolean I(Object obj) {
            return ((OverScroller) obj).isFinished();
        }

        public final int L(Object obj) {
            return ((OverScroller) obj).getCurrX();
        }

        public final int M(Object obj) {
            return ((OverScroller) obj).getCurrY();
        }

        public float N(Object obj) {
            return 0.0f;
        }

        public final boolean O(Object obj) {
            return ((OverScroller) obj).computeScrollOffset();
        }

        public final void a(Object obj, int i, int i2, int i3, int i4) {
            ((OverScroller) obj).startScroll(i, i2, 0, i4);
        }

        public final void a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        public final void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((OverScroller) obj).fling(0, i2, i3, i4, i5, i6, i7, i8);
        }

        public final void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((OverScroller) obj).fling(i, i2, 0, i4, 0, 0, 0, i8, 0, i10);
        }

        public final void P(Object obj) {
            ((OverScroller) obj).abortAnimation();
        }

        public final int Q(Object obj) {
            return ((OverScroller) obj).getFinalX();
        }

        public final int R(Object obj) {
            return ((OverScroller) obj).getFinalY();
        }

        public final boolean a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return ((OverScroller) obj).springBack(i, i2, 0, 0, 0, i6);
        }
    }

    static class d extends c {
        d() {
        }

        public final float N(Object obj) {
            return ((OverScroller) obj).getCurrVelocity();
        }
    }

    public static q a(Context context, Interpolator interpolator) {
        return new q(VERSION.SDK_INT, context, interpolator);
    }

    private q(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.DH = new d();
        } else if (i >= 9) {
            this.DH = new c();
        } else {
            this.DH = new b();
        }
        this.DG = this.DH.b(context, interpolator);
    }

    public final boolean isFinished() {
        return this.DH.I(this.DG);
    }

    public final int getCurrX() {
        return this.DH.L(this.DG);
    }

    public final int getCurrY() {
        return this.DH.M(this.DG);
    }

    public final int getFinalX() {
        return this.DH.Q(this.DG);
    }

    public final int getFinalY() {
        return this.DH.R(this.DG);
    }

    public final float getCurrVelocity() {
        return this.DH.N(this.DG);
    }

    public final boolean computeScrollOffset() {
        return this.DH.O(this.DG);
    }

    public final void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.DH.a(this.DG, i, i2, i3, i4, i5);
    }

    public final void b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.DH.a(this.DG, 0, i, i2, i3, i4, i5, i6, i7);
    }

    public final boolean i(int i, int i2, int i3) {
        return this.DH.a(this.DG, i, i2, 0, 0, 0, i3);
    }

    public final void abortAnimation() {
        this.DH.P(this.DG);
    }
}

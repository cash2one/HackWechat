package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.widget.q;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class a {
    private static final Interpolator yC = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    public int EV;
    public float[] EW;
    public float[] EX;
    public float[] EY;
    public float[] EZ;
    public int[] Fa;
    private int[] Fb;
    private int[] Fc;
    public int Fd;
    public float Fe;
    public float Ff;
    private int Fg;
    public int Fh;
    public View Fj;
    public boolean Fk;
    public final ViewGroup Fl;
    public final Runnable Fm = new Runnable(this) {
        final /* synthetic */ a zft;

        {
            this.zft = r1;
        }

        public final void run() {
            this.zft.ax(0);
        }
    };
    public VelocityTracker ft;
    public int fu = -1;
    public q iK;
    private int iN;
    public final a zfs;

    public static abstract class a {
        public abstract boolean GF(int i);

        public void t(int i) {
        }

        public void fc(int i, int i2) {
        }

        public void a(View view, float f, float f2) {
        }

        public int cxr() {
            return 0;
        }

        public int d(View view, int i) {
            return 0;
        }
    }

    public static a a(ViewGroup viewGroup, a aVar) {
        return new a(viewGroup.getContext(), viewGroup, aVar);
    }

    private a(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.Fl = viewGroup;
            this.zfs = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.Fg = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.iN = viewConfiguration.getScaledTouchSlop();
            this.Fe = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.Ff = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.iK = q.a(context, yC);
        }
    }

    public final void cancel() {
        this.fu = -1;
        if (this.EW != null) {
            Arrays.fill(this.EW, 0.0f);
            Arrays.fill(this.EX, 0.0f);
            Arrays.fill(this.EY, 0.0f);
            Arrays.fill(this.EZ, 0.0f);
            Arrays.fill(this.Fa, 0);
            Arrays.fill(this.Fb, 0);
            Arrays.fill(this.Fc, 0);
            this.Fd = 0;
        }
        if (this.ft != null) {
            this.ft.recycle();
            this.ft = null;
        }
    }

    public final boolean f(int i, int i2, int i3, int i4) {
        int left = this.Fj.getLeft();
        int top = this.Fj.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.iK.abortAnimation();
            ax(0);
            return false;
        }
        int k = k(i3, (int) this.Ff, (int) this.Fe);
        int k2 = k(i4, (int) this.Ff, (int) this.Fe);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(k);
        int abs4 = Math.abs(k2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        x.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf((int) (((k2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) j(i6, k2, 0))) + ((k != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) j(i5, k, this.zfs.cxr()))))));
        this.iK.startScroll(left, top, i5, i6, abs3);
        ax(2);
        return true;
    }

    private int j(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.Fl.getWidth();
        int i4 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(sin / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private static int k(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private static float f(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    public final void i(float f, float f2) {
        this.Fk = true;
        this.zfs.a(this.Fj, f, f2);
        this.Fk = false;
        if (this.EV == 1) {
            ax(0);
        }
    }

    public final void av(int i) {
        if (this.EW != null) {
            this.EW[i] = 0.0f;
            this.EX[i] = 0.0f;
            this.EY[i] = 0.0f;
            this.EZ[i] = 0.0f;
            this.Fa[i] = 0;
            this.Fb[i] = 0;
            this.Fc[i] = 0;
            this.Fd &= (1 << i) ^ -1;
        }
    }

    public final void a(float f, float f2, int i) {
        int i2 = 0;
        if (this.EW == null || this.EW.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.EW != null) {
                System.arraycopy(this.EW, 0, obj, 0, this.EW.length);
                System.arraycopy(this.EX, 0, obj2, 0, this.EX.length);
                System.arraycopy(this.EY, 0, obj3, 0, this.EY.length);
                System.arraycopy(this.EZ, 0, obj4, 0, this.EZ.length);
                System.arraycopy(this.Fa, 0, obj5, 0, this.Fa.length);
                System.arraycopy(this.Fb, 0, obj6, 0, this.Fb.length);
                System.arraycopy(this.Fc, 0, obj7, 0, this.Fc.length);
            }
            this.EW = obj;
            this.EX = obj2;
            this.EY = obj3;
            this.EZ = obj4;
            this.Fa = obj5;
            this.Fb = obj6;
            this.Fc = obj7;
        }
        float[] fArr = this.EW;
        this.EY[i] = f;
        fArr[i] = f;
        fArr = this.EX;
        this.EZ[i] = f2;
        fArr[i] = f2;
        int[] iArr = this.Fa;
        int i3 = (int) f;
        int i4 = (int) f2;
        if (i3 < this.Fl.getLeft() + this.Fg) {
            i2 = 1;
        }
        if (i4 < this.Fl.getTop() + this.Fg) {
            i2 |= 4;
        }
        if (i3 > this.Fl.getRight() - this.Fg) {
            i2 |= 2;
        }
        if (i4 > this.Fl.getBottom() - this.Fg) {
            i2 |= 8;
        }
        iArr[i] = i2;
        this.Fd |= 1 << i;
    }

    public final void i(MotionEvent motionEvent) {
        int f = o.f(motionEvent);
        for (int i = 0; i < f; i++) {
            int c = o.c(motionEvent, i);
            float d = o.d(motionEvent, i);
            float e = o.e(motionEvent, i);
            this.EY[c] = d;
            this.EZ[c] = e;
        }
    }

    final void ax(int i) {
        if (this.EV != i) {
            this.EV = i;
            this.zfs.t(i);
            if (i == 0) {
                this.Fj = null;
            }
        }
    }

    public final boolean o(View view, int i) {
        if (view == this.Fj && this.fu == i) {
            return true;
        }
        if (view == null || !this.zfs.GF(i)) {
            return false;
        }
        this.fu = i;
        if (view.getParent() != this.Fl) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Fl + ")");
        }
        this.Fj = view;
        this.fu = i;
        ax(1);
        return true;
    }

    public final void b(float f, float f2, int i) {
        int i2 = 1;
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.Fb;
            iArr[i] = i2 | iArr[i];
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.Fa[i] & i2) != i2 || (this.Fh & i2) == 0 || (this.Fc[i] & i2) == i2 || (this.Fb[i] & i2) == i2) {
            return false;
        }
        if ((abs > ((float) this.iN) || abs2 > ((float) this.iN)) && (this.Fb[i] & i2) == 0 && abs > ((float) this.iN)) {
            return true;
        }
        return false;
    }

    public final boolean l(View view, float f) {
        if (view == null) {
            return false;
        }
        if (!(this.zfs.cxr() > 0) || Math.abs(f) <= ((float) this.iN)) {
            return false;
        }
        return true;
    }

    public final void cM() {
        this.ft.computeCurrentVelocity(1000, this.Fe);
        i(f(y.a(this.ft, this.fu), this.Ff, this.Fe), f(y.b(this.ft, this.fu), this.Ff, this.Fe));
    }

    public final View u(int i, int i2) {
        for (int childCount = this.Fl.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.Fl.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}

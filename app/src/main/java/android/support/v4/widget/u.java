package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public final class u {
    private static final Interpolator yC = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    int EV;
    float[] EW;
    float[] EX;
    float[] EY;
    float[] EZ;
    private int[] Fa;
    private int[] Fb;
    private int[] Fc;
    private int Fd;
    private float Fe;
    float Ff;
    int Fg;
    int Fh;
    private final a Fi;
    View Fj;
    private boolean Fk;
    private final ViewGroup Fl;
    private final Runnable Fm = new Runnable(this) {
        final /* synthetic */ u Fn;

        {
            this.Fn = r1;
        }

        public final void run() {
            this.Fn.ax(0);
        }
    };
    private VelocityTracker ft;
    private int fu = -1;
    private q iK;
    public int iN;

    public static abstract class a {
        public abstract boolean b(View view, int i);

        public void t(int i) {
        }

        public void a(View view, int i, int i2) {
        }

        public void f(View view, int i) {
        }

        public void a(View view, float f, float f2) {
        }

        public void cu() {
        }

        public void q(int i, int i2) {
        }

        public int s(View view) {
            return 0;
        }

        public int M() {
            return 0;
        }

        public int d(View view, int i) {
            return 0;
        }

        public int c(View view, int i) {
            return 0;
        }
    }

    public static u a(ViewGroup viewGroup, a aVar) {
        return new u(viewGroup.getContext(), viewGroup, aVar);
    }

    public static u a(ViewGroup viewGroup, float f, a aVar) {
        u a = a(viewGroup, aVar);
        a.iN = (int) (((float) a.iN) * (1.0f / f));
        return a;
    }

    private u(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.Fl = viewGroup;
            this.Fi = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.Fg = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.iN = viewConfiguration.getScaledTouchSlop();
            this.Fe = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.Ff = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.iK = q.a(context, yC);
        }
    }

    public final void n(View view, int i) {
        if (view.getParent() != this.Fl) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Fl + ")");
        }
        this.Fj = view;
        this.fu = i;
        this.Fi.f(view, i);
        ax(1);
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

    public final void abort() {
        cancel();
        if (this.EV == 2) {
            this.iK.getCurrX();
            this.iK.getCurrY();
            this.iK.abortAnimation();
            this.Fi.a(this.Fj, this.iK.getCurrX(), this.iK.getCurrY());
        }
        ax(0);
    }

    public final boolean e(View view, int i, int i2) {
        this.Fj = view;
        this.fu = -1;
        boolean f = f(i, i2, 0, 0);
        if (!(f || this.EV != 0 || this.Fj == null)) {
            this.Fj = null;
        }
        return f;
    }

    public final boolean t(int i, int i2) {
        if (this.Fk) {
            return f(i, i2, (int) y.a(this.ft, this.fu), (int) y.b(this.ft, this.fu));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean f(int i, int i2, int i3, int i4) {
        int left = this.Fj.getLeft();
        int top = this.Fj.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.iK.abortAnimation();
            ax(0);
            return false;
        }
        View view = this.Fj;
        int k = k(i3, (int) this.Ff, (int) this.Fe);
        int k2 = k(i4, (int) this.Ff, (int) this.Fe);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(k);
        int abs4 = Math.abs(k2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        this.iK.startScroll(left, top, i5, i6, (int) (((k2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) j(i6, k2, this.Fi.M()))) + ((k != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) j(i5, k, this.Fi.s(view))))));
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

    public final boolean cL() {
        if (this.EV == 2) {
            boolean computeScrollOffset = this.iK.computeScrollOffset();
            int currX = this.iK.getCurrX();
            int currY = this.iK.getCurrY();
            int left = currX - this.Fj.getLeft();
            int top = currY - this.Fj.getTop();
            if (left != 0) {
                z.k(this.Fj, left);
            }
            if (top != 0) {
                z.j(this.Fj, top);
            }
            if (!(left == 0 && top == 0)) {
                this.Fi.a(this.Fj, currX, currY);
            }
            if (computeScrollOffset && currX == this.iK.getFinalX() && currY == this.iK.getFinalY()) {
                this.iK.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.Fl.post(this.Fm);
            }
        }
        if (this.EV == 2) {
            return true;
        }
        return false;
    }

    private void i(float f, float f2) {
        this.Fk = true;
        this.Fi.a(this.Fj, f, f2);
        this.Fk = false;
        if (this.EV == 1) {
            ax(0);
        }
    }

    private void av(int i) {
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

    private void a(float f, float f2, int i) {
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

    private void i(MotionEvent motionEvent) {
        int f = o.f(motionEvent);
        for (int i = 0; i < f; i++) {
            int c = o.c(motionEvent, i);
            float d = o.d(motionEvent, i);
            float e = o.e(motionEvent, i);
            this.EY[c] = d;
            this.EZ[c] = e;
        }
    }

    public final boolean aw(int i) {
        return (this.Fd & (1 << i)) != 0;
    }

    final void ax(int i) {
        this.Fl.removeCallbacks(this.Fm);
        if (this.EV != i) {
            this.EV = i;
            this.Fi.t(i);
            if (this.EV == 0) {
                this.Fj = null;
            }
        }
    }

    private boolean o(View view, int i) {
        if (view == this.Fj && this.fu == i) {
            return true;
        }
        if (view == null || !this.Fi.b(view, i)) {
            return false;
        }
        this.fu = i;
        n(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        int e = o.e(motionEvent);
        if (d == 0) {
            cancel();
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        float x;
        float y;
        int c;
        switch (d) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                c = o.c(motionEvent, 0);
                a(x, y, c);
                View u = u((int) x, (int) y);
                if (u == this.Fj && this.EV == 2) {
                    o(u, c);
                }
                if ((this.Fa[c] & this.Fh) != 0) {
                    this.Fi.cu();
                    break;
                }
                break;
            case 1:
            case 3:
                cancel();
                break;
            case 2:
                if (!(this.EW == null || this.EX == null)) {
                    c = o.f(motionEvent);
                    for (e = 0; e < c; e++) {
                        int c2 = o.c(motionEvent, e);
                        if (ay(c2)) {
                            x = o.d(motionEvent, e);
                            float e2 = o.e(motionEvent, e);
                            float f = x - this.EW[c2];
                            float f2 = e2 - this.EX[c2];
                            View u2 = u((int) x, (int) e2);
                            Object obj = (u2 == null || !b(u2, f, f2)) ? null : 1;
                            if (obj != null) {
                                int left = u2.getLeft();
                                int d2 = this.Fi.d(u2, ((int) f) + left);
                                int top = u2.getTop();
                                int c3 = this.Fi.c(u2, ((int) f2) + top);
                                int s = this.Fi.s(u2);
                                int M = this.Fi.M();
                                if (s != 0) {
                                    if (s > 0) {
                                    }
                                }
                                if (M != 0) {
                                    if (M > 0 && c3 == top) {
                                    }
                                }
                                i(motionEvent);
                                break;
                            }
                            b(f, f2, c2);
                            if (this.EV != 1) {
                                if (obj != null && o(u2, c2)) {
                                }
                            }
                            i(motionEvent);
                        }
                    }
                    i(motionEvent);
                }
                break;
            case 5:
                d = o.c(motionEvent, e);
                float d3 = o.d(motionEvent, e);
                y = o.e(motionEvent, e);
                a(d3, y, d);
                if (this.EV != 0) {
                    if (this.EV == 2) {
                        View u3 = u((int) d3, (int) y);
                        if (u3 == this.Fj) {
                            o(u3, d);
                            break;
                        }
                    }
                } else if ((this.Fa[d] & this.Fh) != 0) {
                    this.Fi.cu();
                    break;
                }
                break;
            case 6:
                av(o.c(motionEvent, e));
                break;
        }
        if (this.EV == 1) {
            return true;
        }
        return false;
    }

    public final void k(MotionEvent motionEvent) {
        int i = 0;
        int d = o.d(motionEvent);
        int e = o.e(motionEvent);
        if (d == 0) {
            cancel();
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        float x;
        float y;
        View u;
        int left;
        switch (d) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = o.c(motionEvent, 0);
                u = u((int) x, (int) y);
                a(x, y, i);
                o(u, i);
                if ((this.Fa[i] & this.Fh) != 0) {
                    this.Fi.cu();
                    return;
                }
                return;
            case 1:
                if (this.EV == 1) {
                    cM();
                }
                cancel();
                return;
            case 2:
                int f;
                if (this.EV != 1) {
                    f = o.f(motionEvent);
                    while (i < f) {
                        d = o.c(motionEvent, i);
                        if (ay(d)) {
                            float d2 = o.d(motionEvent, i);
                            float e2 = o.e(motionEvent, i);
                            float f2 = d2 - this.EW[d];
                            float f3 = e2 - this.EX[d];
                            b(f2, f3, d);
                            if (this.EV != 1) {
                                u = u((int) d2, (int) e2);
                                if (b(u, f2, f3) && o(u, d)) {
                                }
                            }
                            i(motionEvent);
                            return;
                        }
                        i++;
                    }
                    i(motionEvent);
                    return;
                } else if (ay(this.fu)) {
                    i = o.b(motionEvent, this.fu);
                    x = o.d(motionEvent, i);
                    d = (int) (x - this.EY[this.fu]);
                    e = (int) (o.e(motionEvent, i) - this.EZ[this.fu]);
                    f = this.Fj.getLeft() + d;
                    i = this.Fj.getTop() + e;
                    left = this.Fj.getLeft();
                    int top = this.Fj.getTop();
                    if (d != 0) {
                        f = this.Fi.d(this.Fj, f);
                        z.k(this.Fj, f - left);
                    }
                    if (e != 0) {
                        i = this.Fi.c(this.Fj, i);
                        z.j(this.Fj, i - top);
                    }
                    if (!(d == 0 && e == 0)) {
                        this.Fi.a(this.Fj, f, i);
                    }
                    i(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.EV == 1) {
                    i(0.0f, 0.0f);
                }
                cancel();
                return;
            case 5:
                i = o.c(motionEvent, e);
                x = o.d(motionEvent, e);
                y = o.e(motionEvent, e);
                a(x, y, i);
                if (this.EV == 0) {
                    o(u((int) x, (int) y), i);
                    if ((this.Fa[i] & this.Fh) != 0) {
                        this.Fi.cu();
                        return;
                    }
                    return;
                }
                if (f(this.Fj, (int) x, (int) y)) {
                    o(this.Fj, i);
                    return;
                }
                return;
            case 6:
                d = o.c(motionEvent, e);
                if (this.EV == 1 && d == this.fu) {
                    e = o.f(motionEvent);
                    while (i < e) {
                        left = o.c(motionEvent, i);
                        if (left != this.fu) {
                            if (u((int) o.d(motionEvent, i), (int) o.e(motionEvent, i)) == this.Fj && o(this.Fj, left)) {
                                i = this.fu;
                                if (i == -1) {
                                    cM();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        cM();
                    }
                }
                av(d);
                return;
            default:
                return;
        }
    }

    private void b(float f, float f2, int i) {
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
            iArr[i] = iArr[i] | i2;
            this.Fi.q(i2, i);
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

    private boolean b(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.Fi.s(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.Fi.M() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) > ((float) (this.iN * this.iN))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.iN)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.iN)) {
            return false;
        } else {
            return true;
        }
    }

    private void cM() {
        this.ft.computeCurrentVelocity(1000, this.Fe);
        i(f(y.a(this.ft, this.fu), this.Ff, this.Fe), f(y.b(this.ft, this.fu), this.Ff, this.Fe));
    }

    public static boolean f(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
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

    private boolean ay(int i) {
        if (aw(i)) {
            return true;
        }
        new StringBuilder("Ignoring pointerId=").append(i).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}

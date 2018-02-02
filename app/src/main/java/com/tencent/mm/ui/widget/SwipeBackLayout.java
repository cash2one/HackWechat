package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.f;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SwipeBackLayout extends FrameLayout {
    private float BO;
    public View Iv;
    private Rect gO;
    public boolean mEnable;
    private boolean mInLayout;
    public boolean zsB;
    private float zwo;
    private int zwp;
    private int zwq;
    public com.tencent.mm.ui.mogic.a zwr;
    private float zws;
    public Drawable zwt;
    private boolean zwu;
    private boolean zwv;
    public boolean zww;
    public boolean zwx;
    private boolean zwy;
    public a zwz;

    public interface a {
        void onCancel();

        void onDrag();

        void onSwipeBack();
    }

    private class b extends com.tencent.mm.ui.mogic.a.a implements com.tencent.mm.ui.base.b.a {
        int zwA;
        int zwB;
        int zwC;
        final /* synthetic */ SwipeBackLayout zwD;

        private b(SwipeBackLayout swipeBackLayout) {
            this.zwD = swipeBackLayout;
            this.zwA = 0;
            this.zwB = 0;
            this.zwC = 0;
        }

        public final boolean GF(int i) {
            boolean z;
            com.tencent.mm.ui.mogic.a a = this.zwD.zwr;
            if ((a.Fd & (1 << i)) != 0) {
                z = true;
            } else {
                z = false;
            }
            return z && (a.Fa[i] & 1) != 0;
        }

        public final int cxr() {
            return 1;
        }

        public final void fc(int i, int i2) {
            if (this.zwD.zww) {
                this.zwD.zws = Math.abs(((float) i) / ((float) (this.zwD.Iv.getWidth() + this.zwD.zwt.getIntrinsicWidth())));
                this.zwD.zwp = i;
                this.zwD.zwq = i2;
                this.zwD.invalidate();
                if (Float.compare(this.zwD.zws, 1.0f) >= 0 && !this.zwD.zwx) {
                    this.zwD.zwx = true;
                    ag.y(new Runnable(this) {
                        final /* synthetic */ b zwE;

                        {
                            this.zwE = r1;
                        }

                        public final void run() {
                            if (this.zwE.zwD.zwz != null) {
                                this.zwE.zwD.zwz.onSwipeBack();
                                x.d("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
                            }
                            this.zwE.zwD.zsB = false;
                        }
                    });
                } else if (Float.compare(this.zwD.zws, 0.01f) <= 0) {
                    this.zwD.zsB = false;
                }
                if (this.zwD.zwr.EV == 1) {
                    l.aI(this.zwD.zws);
                }
            }
        }

        public final void a(View view, float f, float f2) {
            int width = view.getWidth();
            this.zwB = 0;
            this.zwC = 0;
            width = (f > 0.0f || (f == 0.0f && this.zwD.zws > this.zwD.zwo)) ? (width + this.zwD.zwt.getIntrinsicWidth()) + 10 : 0;
            this.zwB = width;
            x.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(this.zwB), Integer.valueOf(this.zwC), Boolean.valueOf(this.zwD.zww));
            this.zwD.zsB = true;
            if (this.zwD.zww) {
                com.tencent.mm.ui.mogic.a a = this.zwD.zwr;
                int i = this.zwB;
                int i2 = this.zwC;
                if (a.Fk) {
                    a.f(i, i2, (int) y.a(a.ft, a.fu), (int) y.b(a.ft, a.fu));
                    this.zwD.invalidate();
                    return;
                }
                throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
            }
            this.zwD.zwy = true;
        }

        public final int d(View view, int i) {
            if (this.zwD.zww) {
                int max = Math.max(this.zwA, i);
                this.zwA = 0;
                return Math.min(view.getWidth(), Math.max(max, 0));
            }
            this.zwA = Math.max(this.zwA, i);
            return 0;
        }

        public final void t(int i) {
            x.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", Integer.valueOf(i), Boolean.valueOf(this.zwD.zwv), Boolean.valueOf(this.zwD.zwy));
            if (1 == i) {
                x.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
                if (this.zwD.getContext() instanceof Activity) {
                    ((Activity) this.zwD.getContext()).getWindow().getDecorView().setBackgroundResource(d.transparent);
                }
                if (this.zwD.zwz != null) {
                    this.zwD.zwz.onDrag();
                }
                this.zwD.zwx = false;
                if (this.zwD.zww) {
                    l.aI(0.0f);
                }
            }
            if (i == 0 && !this.zwD.zwy) {
                x.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
                if (this.zwD.zwz != null) {
                    this.zwD.zwz.onCancel();
                }
                l.aI(1.0f);
            }
            if (1 == i && this.zwD.zwu && (this.zwD.getContext() instanceof Activity) && !this.zwD.zww && !this.zwD.zwv) {
                x.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
                this.zwD.zwv = true;
                Activity activity = (Activity) this.zwD.getContext();
                if (com.tencent.mm.compatible.util.d.fN(16)) {
                    x.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", Integer.valueOf(VERSION.SDK_INT));
                } else {
                    try {
                        Object newProxyInstance;
                        Class[] declaredClasses = Activity.class.getDeclaredClasses();
                        int length = declaredClasses.length;
                        int i2 = 0;
                        Class cls = null;
                        while (i2 < length) {
                            Class cls2 = declaredClasses[i2];
                            if (!cls2.getSimpleName().contains("TranslucentConversionListener")) {
                                cls2 = cls;
                            }
                            i2++;
                            cls = cls2;
                        }
                        if (this != null) {
                            InvocationHandler bVar = new b();
                            bVar.xWH = new WeakReference(this);
                            newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, bVar);
                        } else {
                            newProxyInstance = null;
                        }
                        Method declaredMethod;
                        if (com.tencent.mm.compatible.util.d.fN(21)) {
                            declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls});
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(activity, new Object[]{newProxyInstance});
                        } else {
                            declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(activity, new Object[]{newProxyInstance, null});
                        }
                    } catch (Throwable th) {
                        x.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityToTranslucent Fail: %s", th.getMessage());
                    }
                }
            }
            if (2 == i) {
                boolean z;
                x.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", Integer.valueOf(this.zwB));
                if (this.zwB > 0) {
                    z = true;
                } else {
                    z = false;
                }
                l.B(z, this.zwB);
            }
        }

        public final void me(final boolean z) {
            ag.y(new Runnable(this) {
                final /* synthetic */ b zwE;

                public final void run() {
                    x.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", Boolean.valueOf(z), Integer.valueOf(this.zwE.zwB));
                    this.zwE.zwD.zwv = z;
                    if (!z) {
                        this.zwE.zwD.zsB = false;
                    } else if (this.zwE.zwB > 0) {
                        l.aI(0.0f);
                    } else {
                        l.aI(1.0f);
                    }
                    this.zwE.zwD.nD(z);
                    if (z && this.zwE.zwD.zwy) {
                        if (this.zwE.zwB == 0) {
                            j.a(this.zwE.zwD.Iv, 200, 0.0f, new com.tencent.mm.ui.tools.j.a(this) {
                                final /* synthetic */ AnonymousClass2 zwG;

                                {
                                    this.zwG = r1;
                                }

                                public final void onAnimationEnd() {
                                    this.zwG.zwE.zwD.zsB = false;
                                }

                                public final void cxO() {
                                    onAnimationEnd();
                                }
                            });
                        } else {
                            j.a(this.zwE.zwD.Iv, 200, (float) this.zwE.zwB, new com.tencent.mm.ui.tools.j.a(this) {
                                final /* synthetic */ AnonymousClass2 zwG;

                                {
                                    this.zwG = r1;
                                }

                                public final void onAnimationEnd() {
                                    this.zwG.zwE.zwD.zwx = true;
                                    ag.y(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass2 zwH;

                                        {
                                            this.zwH = r1;
                                        }

                                        public final void run() {
                                            if (this.zwH.zwG.zwE.zwD.zwz != null) {
                                                this.zwH.zwG.zwE.zwD.zwz.onSwipeBack();
                                                x.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                                            }
                                            l.aI(1.0f);
                                            this.zwH.zwG.zwE.zwD.zsB = false;
                                        }
                                    });
                                }

                                public final void cxO() {
                                    onAnimationEnd();
                                }
                            });
                            l.B(true, this.zwE.zwB);
                        }
                    }
                    this.zwE.zwD.zwy = false;
                }
            });
        }
    }

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zwo = 0.3f;
        this.mEnable = true;
        this.gO = new Rect();
        this.zwu = true;
        this.zwv = false;
        this.zww = false;
        this.zwx = false;
        this.zsB = false;
        this.zwy = false;
        this.zwz = null;
        this.zwt = getResources().getDrawable(f.gUY);
        setFocusable(true);
        setDescendantFocusability(262144);
        init();
    }

    public final void init() {
        this.zwr = com.tencent.mm.ui.mogic.a.a(this, new b());
        this.zwr.Fh = 1;
        float f = getResources().getDisplayMetrics().density;
        float f2 = 100.0f * f;
        f *= 300.0f;
        this.zwr.Ff = f2;
        this.zwr.Fe = f;
        this.zwp = 0;
        this.zwq = 0;
    }

    public final void nD(boolean z) {
        x.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", Boolean.valueOf(z));
        this.zww = z;
    }

    public final void nE(boolean z) {
        this.zwu = z;
        if (this.zwu) {
            this.zwv = false;
        }
    }

    public final boolean czc() {
        czd();
        return this.zsB;
    }

    public void onFinishInflate() {
        this.Iv = this;
    }

    public final boolean czd() {
        if (!this.zsB) {
            return false;
        }
        if (Float.compare((float) this.Iv.getLeft(), 0.01f) > 0) {
            return true;
        }
        this.zsB = false;
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnable) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (czd()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        try {
            int d;
            int e;
            float x;
            View u;
            float d2;
            float e2;
            float f;
            float e3;
            if (this.zwr.EV == 1) {
                com.tencent.mm.ui.mogic.a aVar = this.zwr;
                d = o.d(motionEvent);
                e = o.e(motionEvent);
                if (d == 0) {
                    aVar.cancel();
                }
                if (aVar.ft == null) {
                    aVar.ft = VelocityTracker.obtain();
                }
                aVar.ft.addMovement(motionEvent);
                int e4;
                int left;
                int left2;
                switch (d) {
                    case 0:
                        x = motionEvent.getX();
                        float y = motionEvent.getY();
                        e = o.c(motionEvent, 0);
                        u = aVar.u((int) x, (int) y);
                        aVar.a(x, y, e);
                        aVar.o(u, e);
                        return (aVar.Fh & aVar.Fa[e]) != 0 ? true : true;
                    case 1:
                        if (aVar.EV == 1) {
                            aVar.cM();
                        }
                        aVar.cancel();
                        return true;
                    case 2:
                        if (aVar.EV == 1) {
                            d = o.b(motionEvent, aVar.fu);
                            e = (int) (o.d(motionEvent, d) - aVar.EY[aVar.fu]);
                            e4 = (int) (o.e(motionEvent, d) - aVar.EZ[aVar.fu]);
                            left = aVar.Fj.getLeft() + e;
                            d = aVar.Fj.getTop() + e4;
                            left2 = aVar.Fj.getLeft();
                            int top = aVar.Fj.getTop();
                            if (e != 0) {
                                left = aVar.zfs.d(aVar.Fj, left);
                                aVar.Fj.offsetLeftAndRight(left - left2);
                            }
                            if (e4 != 0) {
                                aVar.Fj.offsetTopAndBottom(0 - top);
                                d = 0;
                            }
                            if (!(e == 0 && e4 == 0)) {
                                aVar.zfs.fc(left, d);
                            }
                            aVar.i(motionEvent);
                            return true;
                        }
                        left = o.f(motionEvent);
                        d = 0;
                        while (d < left) {
                            e = o.c(motionEvent, d);
                            d2 = o.d(motionEvent, d);
                            e2 = o.e(motionEvent, d);
                            f = d2 - aVar.EW[e];
                            aVar.b(f, e2 - aVar.EX[e], e);
                            if (aVar.EV != 1) {
                                u = aVar.u((int) d2, (int) e2);
                                if (!aVar.l(u, f) || !aVar.o(u, e)) {
                                    d++;
                                }
                            }
                            aVar.i(motionEvent);
                            return true;
                        }
                        aVar.i(motionEvent);
                        return true;
                    case 3:
                        if (aVar.EV == 1) {
                            aVar.i(0.0f, 0.0f);
                        }
                        aVar.cancel();
                        return true;
                    case 5:
                        left = o.c(motionEvent, e);
                        x = o.d(motionEvent, e);
                        e3 = o.e(motionEvent, e);
                        aVar.a(x, e3, left);
                        if (aVar.EV == 0) {
                            aVar.o(aVar.u((int) x, (int) e3), left);
                            return true;
                        }
                        boolean z;
                        d = (int) x;
                        e = (int) e3;
                        u = aVar.Fj;
                        if (u == null || d < u.getLeft() || d >= u.getRight() || e < u.getTop() || e >= u.getBottom()) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            return true;
                        }
                        aVar.o(aVar.Fj, left);
                        return true;
                    case 6:
                        e = o.c(motionEvent, e);
                        if (aVar.EV == 1 && e == aVar.fu) {
                            e4 = o.f(motionEvent);
                            for (d = 0; d < e4; d++) {
                                left2 = o.c(motionEvent, d);
                                if (left2 != aVar.fu) {
                                    if (aVar.u((int) o.d(motionEvent, d), (int) o.e(motionEvent, d)) == aVar.Fj && aVar.o(aVar.Fj, left2)) {
                                        d = aVar.fu;
                                        if (d == -1) {
                                            aVar.cM();
                                        }
                                    }
                                }
                            }
                            d = -1;
                            if (d == -1) {
                                aVar.cM();
                            }
                        }
                        aVar.av(e);
                        return true;
                    default:
                        return true;
                }
            }
            com.tencent.mm.ui.mogic.a aVar2 = this.zwr;
            d = o.d(motionEvent);
            int e5 = o.e(motionEvent);
            if (d == 0) {
                aVar2.cancel();
            }
            if (aVar2.ft == null) {
                aVar2.ft = VelocityTracker.obtain();
            }
            aVar2.ft.addMovement(motionEvent);
            float y2;
            switch (d) {
                case 0:
                    x = motionEvent.getX();
                    y2 = motionEvent.getY();
                    e = o.c(motionEvent, 0);
                    aVar2.a(x, y2, e);
                    View u2 = aVar2.u((int) x, (int) y2);
                    if (u2 == aVar2.Fj && aVar2.EV == 2) {
                        aVar2.o(u2, e);
                    }
                    if ((aVar2.Fa[e] & aVar2.Fh) != 0) {
                        break;
                    }
                    break;
                case 1:
                case 3:
                    aVar2.cancel();
                    break;
                case 2:
                    e5 = o.f(motionEvent);
                    d = 0;
                    while (d < e5) {
                        e = o.c(motionEvent, d);
                        d2 = o.d(motionEvent, d);
                        e2 = o.e(motionEvent, d);
                        f = d2 - aVar2.EW[e];
                        aVar2.b(f, e2 - aVar2.EX[e], e);
                        if (aVar2.EV != 1) {
                            u = aVar2.u((int) d2, (int) e2);
                            if (u == null || !aVar2.l(u, f) || !aVar2.o(u, e)) {
                                d++;
                            }
                        }
                        aVar2.i(motionEvent);
                        break;
                    }
                    aVar2.i(motionEvent);
                    break;
                case 5:
                    d = o.c(motionEvent, e5);
                    e3 = o.d(motionEvent, e5);
                    y2 = o.e(motionEvent, e5);
                    aVar2.a(e3, y2, d);
                    if (aVar2.EV != 0 && aVar2.EV == 2) {
                        View u3 = aVar2.u((int) e3, (int) y2);
                        if (u3 == aVar2.Fj) {
                            aVar2.o(u3, d);
                            break;
                        }
                    }
                    break;
                case 6:
                    aVar2.av(o.c(motionEvent, e5));
                    break;
            }
            if (aVar2.EV == 1) {
                motionEvent.setAction(3);
                super.dispatchTouchEvent(motionEvent);
                return true;
            }
            super.dispatchTouchEvent(motionEvent);
            return true;
        } catch (Throwable e6) {
            x.printErrStackTrace("MicroMsg.SwipeBackLayout", e6, "got an NullPointerException", new Object[0]);
            return false;
        } catch (Throwable e62) {
            x.printErrStackTrace("MicroMsg.SwipeBackLayout", e62, "got an IllegalArgumentException", new Object[0]);
            return false;
        } catch (Throwable e622) {
            x.printErrStackTrace("MicroMsg.SwipeBackLayout", e622, "got an ArrayIndexOutOfBoundsException", new Object[0]);
            return false;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        if (this.Iv != null) {
            this.Iv.layout(this.zwp, this.zwq, this.zwp + this.Iv.getMeasuredWidth(), this.zwq + this.Iv.getMeasuredHeight());
        }
        this.mInLayout = false;
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        Object obj = view == this.Iv ? 1 : null;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (!(Float.compare(this.BO, 0.0f) <= 0 || obj == null || this.zwr.EV == 0)) {
            Rect rect = this.gO;
            view.getHitRect(rect);
            this.zwt.setBounds(rect.left - this.zwt.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.zwt.setAlpha((int) (this.BO * 255.0f));
            this.zwt.draw(canvas);
        }
        return drawChild;
    }

    public void computeScroll() {
        this.BO = Math.max(0.0f, 1.0f - this.zws);
        com.tencent.mm.ui.mogic.a aVar = this.zwr;
        if (aVar.EV == 2) {
            boolean computeScrollOffset = aVar.iK.computeScrollOffset();
            int currX = aVar.iK.getCurrX();
            int currY = aVar.iK.getCurrY();
            int left = currX - aVar.Fj.getLeft();
            int top = currY - aVar.Fj.getTop();
            if (left != 0) {
                aVar.Fj.offsetLeftAndRight(left);
            }
            if (top != 0) {
                aVar.Fj.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                aVar.zfs.fc(currX, currY);
            }
            if (computeScrollOffset && currX == aVar.iK.getFinalX() && currY == aVar.iK.getFinalY()) {
                aVar.iK.abortAnimation();
                computeScrollOffset = aVar.iK.isFinished();
            }
            if (!computeScrollOffset) {
                aVar.Fl.post(aVar.Fm);
            }
        }
        if ((aVar.EV == 2 ? 1 : null) != null) {
            z.E(this);
        }
    }
}

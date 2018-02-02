package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.af;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements h {
    private static final boolean BI = (VERSION.SDK_INT >= 19);
    private static final boolean BJ;
    static final c Cl;
    private static final int[] yz = new int[]{16842931};
    private final b BK;
    private float BL;
    private int BM;
    private int BN;
    private float BO;
    private Paint BP;
    final u BQ;
    final u BR;
    private final g BS;
    private final g BT;
    int BU;
    private int BV;
    private int BW;
    private int BX;
    private int BY;
    private boolean BZ;
    boolean Ca;
    private Drawable Cb;
    private Drawable Cc;
    CharSequence Cd;
    CharSequence Ce;
    private Object Cf;
    private Drawable Cg;
    private Drawable Ch;
    private Drawable Ci;
    private Drawable Cj;
    private final ArrayList<View> Ck;
    List<f> eM;
    private boolean hx;
    private Drawable hy;
    private boolean mInLayout;
    private float xP;
    private float xQ;
    private boolean zj;

    public static class LayoutParams extends MarginLayoutParams {
        private float Cn;
        private boolean Co;
        private int Cp;
        public int gravity = 0;

        static /* synthetic */ int b(LayoutParams layoutParams, int i) {
            int i2 = layoutParams.Cp | i;
            layoutParams.Cp = i2;
            return i2;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.yz);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Cq = 0;
        int Cr;
        int Cs;
        int Ct;
        int Cu;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.Cq = parcel.readInt();
            this.Cr = parcel.readInt();
            this.Cs = parcel.readInt();
            this.Ct = parcel.readInt();
            this.Cu = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Cq);
            parcel.writeInt(this.Cr);
            parcel.writeInt(this.Cs);
            parcel.writeInt(this.Ct);
            parcel.writeInt(this.Cu);
        }
    }

    interface c {
        int H(Object obj);

        void a(View view, Object obj, int i);

        void a(MarginLayoutParams marginLayoutParams, Object obj, int i);

        void aA(View view);

        Drawable n(Context context);
    }

    public interface f {
        void cr();

        void cs();

        void w(float f);
    }

    class a extends android.support.v4.view.a {
        final /* synthetic */ DrawerLayout Cm;
        private final Rect gO = new Rect();

        a(DrawerLayout drawerLayout) {
            this.Cm = drawerLayout;
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            if (DrawerLayout.BI) {
                super.a(view, bVar);
            } else {
                android.support.v4.view.a.b a = android.support.v4.view.a.b.a(bVar);
                super.a(view, a);
                bVar.setSource(view);
                ViewParent J = z.J(view);
                if (J instanceof View) {
                    bVar.setParent((View) J);
                }
                Rect rect = this.gO;
                a.getBoundsInParent(rect);
                bVar.setBoundsInParent(rect);
                a.getBoundsInScreen(rect);
                bVar.setBoundsInScreen(rect);
                bVar.setVisibleToUser(a.isVisibleToUser());
                bVar.setPackageName(a.getPackageName());
                bVar.setClassName(a.getClassName());
                bVar.setContentDescription(a.getContentDescription());
                bVar.setEnabled(a.isEnabled());
                bVar.setClickable(a.isClickable());
                bVar.setFocusable(a.isFocusable());
                bVar.setFocused(a.isFocused());
                bVar.setAccessibilityFocused(a.isAccessibilityFocused());
                bVar.setSelected(a.isSelected());
                bVar.setLongClickable(a.isLongClickable());
                bVar.addAction(a.getActions());
                a.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.az(childAt)) {
                        bVar.addChild(childAt);
                    }
                }
            }
            bVar.setClassName(DrawerLayout.class.getName());
            bVar.setFocusable(false);
            bVar.setFocused(false);
            bVar.a(android.support.v4.view.a.b.a.zY);
            bVar.a(android.support.v4.view.a.b.a.zZ);
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View a = this.Cm.cp();
            if (a != null) {
                int au = this.Cm.au(a);
                View view2 = this.Cm;
                au = android.support.v4.view.f.getAbsoluteGravity(au, z.I(view2));
                Object obj = au == 3 ? view2.Cd : au == 5 ? view2.Ce : null;
                if (obj != null) {
                    text.add(obj);
                }
            }
            return true;
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.BI || DrawerLayout.az(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    final class b extends android.support.v4.view.a {
        final /* synthetic */ DrawerLayout Cm;

        b(DrawerLayout drawerLayout) {
            this.Cm = drawerLayout;
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            if (!DrawerLayout.az(view)) {
                bVar.setParent(null);
            }
        }
    }

    static class d implements c {
        d() {
        }

        public final void aA(View view) {
            g.aA(view);
        }

        public final void a(View view, Object obj, int i) {
            g.a(view, obj, i);
        }

        public final void a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            g.a(marginLayoutParams, obj, i);
        }

        public final int H(Object obj) {
            return g.H(obj);
        }

        public final Drawable n(Context context) {
            return g.n(context);
        }
    }

    static class e implements c {
        e() {
        }

        public final void aA(View view) {
        }

        public final void a(View view, Object obj, int i) {
        }

        public final void a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        public final int H(Object obj) {
            return 0;
        }

        public final Drawable n(Context context) {
            return null;
        }
    }

    private class g extends android.support.v4.widget.u.a {
        final /* synthetic */ DrawerLayout Cm;
        final int Cv;
        u Cw;
        private final Runnable Cx = new Runnable(this) {
            final /* synthetic */ g Cy;

            {
                this.Cy = r1;
            }

            public final void run() {
                View view;
                int i;
                int i2 = 0;
                g gVar = this.Cy;
                int i3 = gVar.Cw.Fg;
                boolean z = gVar.Cv == 3;
                int i4;
                if (z) {
                    View ao = gVar.Cm.ao(3);
                    i4 = (ao != null ? -ao.getWidth() : 0) + i3;
                    view = ao;
                    i = i4;
                } else {
                    i4 = gVar.Cm.getWidth() - i3;
                    view = gVar.Cm.ao(5);
                    i = i4;
                }
                if (view == null) {
                    return;
                }
                if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && gVar.Cm.as(view) == 0) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    gVar.Cw.e(view, i, view.getTop());
                    layoutParams.Co = true;
                    gVar.Cm.invalidate();
                    gVar.ct();
                    DrawerLayout drawerLayout = gVar.Cm;
                    if (!drawerLayout.Ca) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        i = drawerLayout.getChildCount();
                        while (i2 < i) {
                            drawerLayout.getChildAt(i2).dispatchTouchEvent(obtain);
                            i2++;
                        }
                        obtain.recycle();
                        drawerLayout.Ca = true;
                    }
                }
            }
        };

        public g(DrawerLayout drawerLayout, int i) {
            this.Cm = drawerLayout;
            this.Cv = i;
        }

        public final void cn() {
            this.Cm.removeCallbacks(this.Cx);
        }

        public final boolean b(View view, int i) {
            return DrawerLayout.aw(view) && this.Cm.m(view, this.Cv) && this.Cm.as(view) == 0;
        }

        public final void t(int i) {
            DrawerLayout drawerLayout = this.Cm;
            View view = this.Cw.Fj;
            int i2 = drawerLayout.BQ.EV;
            int i3 = drawerLayout.BR.EV;
            i3 = (i2 == 1 || i3 == 1) ? 1 : (i2 == 2 || i3 == 2) ? 2 : 0;
            if (view != null && i == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.Cn == 0.0f) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams.Cp & 1) == 1) {
                        layoutParams.Cp = 0;
                        if (drawerLayout.eM != null) {
                            for (i2 = drawerLayout.eM.size() - 1; i2 >= 0; i2--) {
                                ((f) drawerLayout.eM.get(i2)).cs();
                            }
                        }
                        drawerLayout.d(view, false);
                        if (drawerLayout.hasWindowFocus()) {
                            View rootView = drawerLayout.getRootView();
                            if (rootView != null) {
                                rootView.sendAccessibilityEvent(32);
                            }
                        }
                    }
                } else if (layoutParams.Cn == 1.0f) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams.Cp & 1) == 0) {
                        layoutParams.Cp = 1;
                        if (drawerLayout.eM != null) {
                            for (i2 = drawerLayout.eM.size() - 1; i2 >= 0; i2--) {
                                ((f) drawerLayout.eM.get(i2)).cr();
                            }
                        }
                        drawerLayout.d(view, true);
                        if (drawerLayout.hasWindowFocus()) {
                            drawerLayout.sendAccessibilityEvent(32);
                        }
                        view.requestFocus();
                    }
                }
            }
            if (i3 != drawerLayout.BU) {
                drawerLayout.BU = i3;
                if (drawerLayout.eM != null) {
                    for (int size = drawerLayout.eM.size() - 1; size >= 0; size--) {
                        drawerLayout.eM.get(size);
                    }
                }
            }
        }

        public final void a(View view, int i, int i2) {
            float f;
            int width = view.getWidth();
            if (this.Cm.m(view, 3)) {
                f = ((float) (width + i)) / ((float) width);
            } else {
                f = ((float) (this.Cm.getWidth() - i)) / ((float) width);
            }
            this.Cm.i(view, f);
            view.setVisibility(f == 0.0f ? 4 : 0);
            this.Cm.invalidate();
        }

        public final void f(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).Co = false;
            ct();
        }

        final void ct() {
            int i = 3;
            if (this.Cv == 3) {
                i = 5;
            }
            View ao = this.Cm.ao(i);
            if (ao != null) {
                this.Cm.ay(ao);
            }
        }

        public final void a(View view, float f, float f2) {
            int i;
            float at = DrawerLayout.at(view);
            int width = view.getWidth();
            if (this.Cm.m(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && at > 0.5f)) ? 0 : -width;
            } else {
                i = this.Cm.getWidth();
                if (f < 0.0f || (f == 0.0f && at > 0.5f)) {
                    i -= width;
                }
            }
            this.Cw.t(i, view.getTop());
            this.Cm.invalidate();
        }

        public final void cu() {
            this.Cm.postDelayed(this.Cx, 160);
        }

        public final void q(int i, int i2) {
            View ao;
            if ((i & 1) == 1) {
                ao = this.Cm.ao(3);
            } else {
                ao = this.Cm.ao(5);
            }
            if (ao != null && this.Cm.as(ao) == 0) {
                this.Cw.n(ao, i2);
            }
        }

        public final int s(View view) {
            return DrawerLayout.aw(view) ? view.getWidth() : 0;
        }

        public final int d(View view, int i) {
            if (this.Cm.m(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.Cm.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public final int c(View view, int i) {
            return view.getTop();
        }
    }

    static /* synthetic */ boolean az(View view) {
        return (z.F(view) == 4 || z.F(view) == 2) ? false : true;
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        BJ = z;
        if (VERSION.SDK_INT >= 21) {
            Cl = new d();
        } else {
            Cl = new e();
        }
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BK = new b(this);
        this.BN = -1728053248;
        this.BP = new Paint();
        this.zj = true;
        this.BV = 3;
        this.BW = 3;
        this.BX = 3;
        this.BY = 3;
        this.Cg = null;
        this.Ch = null;
        this.Ci = null;
        this.Cj = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.BM = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.BS = new g(this, 3);
        this.BT = new g(this, 5);
        this.BQ = u.a((ViewGroup) this, 1.0f, this.BS);
        this.BQ.Fh = 1;
        this.BQ.Ff = f2;
        this.BS.Cw = this.BQ;
        this.BR = u.a((ViewGroup) this, 1.0f, this.BT);
        this.BR.Fh = 2;
        this.BR.Ff = f2;
        this.BT.Cw = this.BR;
        setFocusableInTouchMode(true);
        z.i(this, 1);
        z.a((View) this, new a(this));
        af.b(this);
        if (z.Z(this)) {
            Cl.aA(this);
            this.hy = Cl.n(context);
        }
        this.BL = f * 10.0f;
        this.Ck = new ArrayList();
    }

    public final void k(Object obj, boolean z) {
        this.Cf = obj;
        this.hx = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    private void p(int i, int i2) {
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(i2, z.I(this));
        switch (i2) {
            case 3:
                this.BV = i;
                break;
            case 5:
                this.BW = i;
                break;
            case 8388611:
                this.BX = i;
                break;
            case 8388613:
                this.BY = i;
                break;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.BQ : this.BR).cancel();
        }
        View ao;
        switch (i) {
            case 1:
                ao = ao(absoluteGravity);
                if (ao != null) {
                    ay(ao);
                    return;
                }
                return;
            case 2:
                ao = ao(absoluteGravity);
                if (ao != null) {
                    ax(ao);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int as(View view) {
        if (aw(view)) {
            int i = ((LayoutParams) view.getLayoutParams()).gravity;
            int I = z.I(this);
            switch (i) {
                case 3:
                    if (this.BV != 3) {
                        return this.BV;
                    }
                    i = I == 0 ? this.BX : this.BY;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 5:
                    if (this.BW != 3) {
                        return this.BW;
                    }
                    i = I == 0 ? this.BY : this.BX;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388611:
                    if (this.BX != 3) {
                        return this.BX;
                    }
                    i = I == 0 ? this.BV : this.BW;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388613:
                    if (this.BY != 3) {
                        return this.BY;
                    }
                    i = I == 0 ? this.BW : this.BV;
                    if (i != 3) {
                        return i;
                    }
                    break;
            }
            return 0;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    final void d(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || aw(childAt)) && !(z && childAt == view)) {
                z.i(childAt, 4);
            } else {
                z.i(childAt, 1);
            }
        }
    }

    final void i(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.Cn) {
            layoutParams.Cn = f;
            if (this.eM != null) {
                for (int size = this.eM.size() - 1; size >= 0; size--) {
                    ((f) this.eM.get(size)).w(f);
                }
            }
        }
    }

    static float at(View view) {
        return ((LayoutParams) view.getLayoutParams()).Cn;
    }

    final int au(View view) {
        return android.support.v4.view.f.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, z.I(this));
    }

    final boolean m(View view, int i) {
        return (au(view) & i) == i;
    }

    private View co() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).Cp & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    final View ao(int i) {
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(i, z.I(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((au(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.zj = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.zj = true;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int I;
        Object obj2;
        Object obj3;
        int childCount;
        int i3;
        View childAt;
        MarginLayoutParams marginLayoutParams;
        int absoluteGravity;
        int au;
        Object obj4;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    mode = size;
                    size = 300;
                    setMeasuredDimension(mode, size);
                    if (this.Cf == null && z.Z(this)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    I = z.I(this);
                    obj2 = null;
                    obj3 = null;
                    childCount = getChildCount();
                    for (i3 = 0; i3 < childCount; i3++) {
                        childAt = getChildAt(i3);
                        if (childAt.getVisibility() != 8) {
                            marginLayoutParams = (LayoutParams) childAt.getLayoutParams();
                            if (obj != null) {
                                absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(marginLayoutParams.gravity, I);
                                if (z.Z(childAt)) {
                                    Cl.a(marginLayoutParams, this.Cf, absoluteGravity);
                                } else {
                                    Cl.a(childAt, this.Cf, absoluteGravity);
                                }
                            }
                            if (av(childAt)) {
                                childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                            } else if (aw(childAt)) {
                                throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                            } else {
                                if (BJ && z.W(childAt) != this.BL) {
                                    z.g(childAt, this.BL);
                                }
                                au = au(childAt) & 7;
                                obj4 = au != 3 ? 1 : null;
                                if ((obj4 != null || r5 == null) && (obj4 != null || r4 == null)) {
                                    if (obj4 == null) {
                                        obj2 = 1;
                                    } else {
                                        obj3 = 1;
                                    }
                                    childAt.measure(getChildMeasureSpec(i, (this.BM + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                                } else {
                                    StringBuilder stringBuilder = new StringBuilder("Child drawer has absolute gravity ");
                                    String toHexString = (au & 3) == 3 ? "LEFT" : (au & 5) == 5 ? "RIGHT" : Integer.toHexString(au);
                                    throw new IllegalStateException(stringBuilder.append(toHexString).append(" but this DrawerLayout already has a drawer view along that edge").toString());
                                }
                            }
                        }
                    }
                }
            }
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        mode = size;
        size = size2;
        setMeasuredDimension(mode, size);
        if (this.Cf == null) {
        }
        obj = null;
        I = z.I(this);
        obj2 = null;
        obj3 = null;
        childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                marginLayoutParams = (LayoutParams) childAt.getLayoutParams();
                if (obj != null) {
                    absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(marginLayoutParams.gravity, I);
                    if (z.Z(childAt)) {
                        Cl.a(marginLayoutParams, this.Cf, absoluteGravity);
                    } else {
                        Cl.a(childAt, this.Cf, absoluteGravity);
                    }
                }
                if (av(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                } else if (aw(childAt)) {
                    throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                } else {
                    z.g(childAt, this.BL);
                    au = au(childAt) & 7;
                    if (au != 3) {
                    }
                    if (obj4 != null) {
                    }
                    if (obj4 == null) {
                        obj3 = 1;
                    } else {
                        obj2 = 1;
                    }
                    childAt.measure(getChildMeasureSpec(i, (this.BM + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                }
            }
        }
    }

    private static boolean c(Drawable drawable, int i) {
        if (drawable == null || !android.support.v4.b.a.a.d(drawable)) {
            return false;
        }
        android.support.v4.b.a.a.b(drawable, i);
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (av(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int a;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m(childAt, 3)) {
                        a = ((int) (((float) measuredWidth) * layoutParams.Cn)) + (-measuredWidth);
                        f = ((float) (measuredWidth + a)) / ((float) measuredWidth);
                    } else {
                        a = i5 - ((int) (((float) measuredWidth) * layoutParams.Cn));
                        f = ((float) (i5 - a)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.Cn ? 1 : null;
                    int i7;
                    switch (layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                        case 16:
                            int i8 = i4 - i2;
                            i7 = (i8 - measuredHeight) / 2;
                            if (i7 < layoutParams.topMargin) {
                                i7 = layoutParams.topMargin;
                            } else if (i7 + measuredHeight > i8 - layoutParams.bottomMargin) {
                                i7 = (i8 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(a, i7, measuredWidth + a, measuredHeight + i7);
                            break;
                        case 80:
                            i7 = i4 - i2;
                            childAt.layout(a, (i7 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + a, i7 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(a, layoutParams.topMargin, measuredWidth + a, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        i(childAt, f);
                    }
                    int i9 = layoutParams.Cn > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i9) {
                        childAt.setVisibility(i9);
                    }
                }
            }
        }
        this.mInLayout = false;
        this.zj = false;
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).Cn);
        }
        this.BO = f;
        if ((this.BQ.cL() | this.BR.cL()) != 0) {
            z.E(this);
        }
    }

    public void onRtlPropertiesChanged(int i) {
        if (!BJ) {
            Drawable drawable;
            int I = z.I(this);
            if (I == 0) {
                if (this.Cg != null) {
                    c(this.Cg, I);
                    drawable = this.Cg;
                }
                drawable = this.Ci;
            } else {
                if (this.Ch != null) {
                    c(this.Ch, I);
                    drawable = this.Ch;
                }
                drawable = this.Ci;
            }
            this.Cb = drawable;
            I = z.I(this);
            if (I == 0) {
                if (this.Ch != null) {
                    c(this.Ch, I);
                    drawable = this.Ch;
                }
                drawable = this.Cj;
            } else {
                if (this.Cg != null) {
                    c(this.Cg, I);
                    drawable = this.Cg;
                }
                drawable = this.Cj;
            }
            this.Cc = drawable;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.hx && this.hy != null) {
            int H = Cl.H(this.Cf);
            if (H > 0) {
                this.hy.setBounds(0, 0, getWidth(), H);
                this.hy.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int right;
        int height = getHeight();
        boolean av = av(view);
        int i = 0;
        int width = getWidth();
        int save = canvas.save();
        if (av) {
            int childCount = getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt != view && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    Object obj = background != null ? background.getOpacity() == -1 ? 1 : null : null;
                    if (obj != null && aw(childAt) && childAt.getHeight() >= height) {
                        if (m(childAt, 3)) {
                            right = childAt.getRight();
                            if (right <= i) {
                                right = i;
                            }
                            i = right;
                            right = width;
                        } else {
                            right = childAt.getLeft();
                            if (right < width) {
                            }
                        }
                        i2++;
                        width = right;
                    }
                }
                right = width;
                i2++;
                width = right;
            }
            canvas.clipRect(i, 0, width, getHeight());
        }
        right = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.BO > 0.0f && av) {
            this.BP.setColor((((int) (((float) ((this.BN & WebView.NIGHT_MODE_COLOR) >>> 24)) * this.BO)) << 24) | (this.BN & 16777215));
            canvas.drawRect((float) i, 0.0f, (float) right, (float) getHeight(), this.BP);
        } else if (this.Cb != null && m(view, 3)) {
            right = this.Cb.getIntrinsicWidth();
            i = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i) / ((float) this.BQ.Fg), 1.0f));
            this.Cb.setBounds(i, view.getTop(), right + i, view.getBottom());
            this.Cb.setAlpha((int) (255.0f * r2));
            this.Cb.draw(canvas);
        } else if (this.Cc != null && m(view, 5)) {
            right = this.Cc.getIntrinsicWidth();
            i = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i)) / ((float) this.BR.Fg), 1.0f));
            this.Cc.setBounds(i - right, view.getTop(), i, view.getBottom());
            this.Cc.setAlpha((int) (255.0f * r2));
            this.Cc.draw(canvas);
        }
        return drawChild;
    }

    private static boolean av(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    static boolean aw(View view) {
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, z.I(view));
        if ((absoluteGravity & 3) != 0) {
            return true;
        }
        if ((absoluteGravity & 5) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int j = this.BR.j(motionEvent) | this.BQ.j(motionEvent);
        float y;
        switch (o.d(motionEvent)) {
            case 0:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                this.xP = x;
                this.xQ = y;
                if (this.BO > 0.0f) {
                    View u = this.BQ.u((int) x, (int) y);
                    if (u != null && av(u)) {
                        z = true;
                        this.BZ = false;
                        this.Ca = false;
                        break;
                    }
                }
                z = false;
                this.BZ = false;
                this.Ca = false;
            case 1:
            case 3:
                s(true);
                this.BZ = false;
                this.Ca = false;
            case 2:
                u uVar = this.BQ;
                int length = uVar.EW.length;
                for (int i = 0; i < length; i++) {
                    boolean z2;
                    if (uVar.aw(i)) {
                        y = uVar.EY[i] - uVar.EW[i];
                        float f = uVar.EZ[i] - uVar.EX[i];
                        z2 = (y * y) + (f * f) > ((float) (uVar.iN * uVar.iN));
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z = true;
                        if (z) {
                            this.BS.cn();
                            this.BT.cn();
                            z = false;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    this.BS.cn();
                    this.BT.cn();
                    z = false;
                }
        }
        z = false;
        if (j == 0 && !r0) {
            j = getChildCount();
            for (int i2 = 0; i2 < j; i2++) {
                if (((LayoutParams) getChildAt(i2).getLayoutParams()).Co) {
                    z = true;
                    if (!(z || this.Ca)) {
                        return false;
                    }
                }
            }
            z = false;
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.BQ.k(motionEvent);
        this.BR.k(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.xP = x;
                this.xQ = y;
                this.BZ = false;
                this.Ca = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View u = this.BQ.u((int) x, (int) y);
                if (u != null && av(u)) {
                    x -= this.xP;
                    y -= this.xQ;
                    int i = this.BQ.iN;
                    if ((x * x) + (y * y) < ((float) (i * i))) {
                        View co = co();
                        if (co != null) {
                            z = as(co) == 2;
                            s(z);
                            this.BZ = false;
                            break;
                        }
                    }
                }
                z = true;
                s(z);
                this.BZ = false;
            case 3:
                s(true);
                this.BZ = false;
                this.Ca = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.BZ = z;
        if (z) {
            s(true);
        }
    }

    private void s(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (aw(childAt) && (!z || layoutParams.Co)) {
                int width = childAt.getWidth();
                if (m(childAt, 3)) {
                    i |= this.BQ.e(childAt, -width, childAt.getTop());
                } else {
                    i |= this.BR.e(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.Co = false;
            }
        }
        this.BS.cn();
        this.BT.cn();
        if (i != 0) {
            invalidate();
        }
    }

    private void ax(View view) {
        if (aw(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.zj) {
                layoutParams.Cn = 1.0f;
                layoutParams.Cp = 1;
                d(view, true);
            } else {
                LayoutParams.b(layoutParams, 2);
                if (m(view, 3)) {
                    this.BQ.e(view, 0, view.getTop());
                } else {
                    this.BR.e(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void ay(View view) {
        if (aw(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.zj) {
                layoutParams.Cn = 0.0f;
                layoutParams.Cp = 0;
            } else {
                LayoutParams.b(layoutParams, 4);
                if (m(view, 3)) {
                    this.BQ.e(view, -view.getWidth(), view.getTop());
                } else {
                    this.BR.e(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            int i3 = 0;
            Object obj = null;
            while (i3 < childCount) {
                Object obj2;
                View childAt = getChildAt(i3);
                if (!aw(childAt)) {
                    this.Ck.add(childAt);
                    obj2 = obj;
                } else if (aw(childAt)) {
                    if ((((LayoutParams) childAt.getLayoutParams()).Cp & 1) == 1) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        childAt.addFocusables(arrayList, i, i2);
                        obj2 = 1;
                    }
                    obj2 = obj;
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
                i3++;
                obj = obj2;
            }
            if (obj == null) {
                int size = this.Ck.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = (View) this.Ck.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.Ck.clear();
        }
    }

    private View cp() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (aw(childAt)) {
                if (aw(childAt)) {
                    Object obj;
                    if (((LayoutParams) childAt.getLayoutParams()).Cn > 0.0f) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        return childAt;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cp() != null) {
                android.support.v4.view.g.b(keyEvent);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View cp = cp();
        if (cp != null && as(cp) == 0) {
            s(false);
        }
        if (cp != null) {
            return true;
        }
        return false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.Cq != 0) {
                View ao = ao(savedState.Cq);
                if (ao != null) {
                    ax(ao);
                }
            }
            if (savedState.Cr != 3) {
                p(savedState.Cr, 3);
            }
            if (savedState.Cs != 3) {
                p(savedState.Cs, 5);
            }
            if (savedState.Ct != 3) {
                p(savedState.Ct, 8388611);
            }
            if (savedState.Cu != 3) {
                p(savedState.Cu, 8388613);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            Object obj = layoutParams.Cp == 1 ? 1 : null;
            Object obj2;
            if (layoutParams.Cp == 2) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj != null || r4 != null) {
                savedState.Cq = layoutParams.gravity;
                break;
            }
        }
        savedState.Cr = this.BV;
        savedState.Cs = this.BW;
        savedState.Ct = this.BX;
        savedState.Cu = this.BY;
        return savedState;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (co() != null || aw(view)) {
            z.i(view, 4);
        } else {
            z.i(view, 1);
        }
        if (!BI) {
            z.a(view, this.BK);
        }
    }
}

package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.ap;
import android.support.v4.view.o;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.t;
import android.support.v4.view.z;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.smtt.sdk.WebView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements r {
    static final String hc;
    static final Class<?>[] hd = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<Behavior>>> he = new ThreadLocal();
    static final Comparator<View> hg;
    static final g hh;
    private ap eL;
    private final s hA;
    final Comparator<View> hf;
    final List<View> hi;
    private final List<View> hj;
    private final List<View> hk;
    final Rect hl;
    final Rect hm;
    private final Rect hn;
    private final int[] ho;
    private boolean hp;
    private boolean hq;
    private int[] hr;
    private View hs;
    private View ht;
    private View hu;
    private e hv;
    private boolean hw;
    private boolean hx;
    private Drawable hy;
    private OnHierarchyChangeListener hz;

    public static abstract class Behavior<V extends View> {
        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean e(View view) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            return false;
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int[] iArr) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, float f, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public static ap a(ap apVar) {
            return apVar;
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new android.support.v4.os.c<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        });
        SparseArray<Parcelable> hO;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.hO = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.hO.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.hO != null ? this.hO.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.hO.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.hO.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        Class<? extends Behavior> value();
    }

    private class c implements OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout hB;

        private c(CoordinatorLayout coordinatorLayout) {
            this.hB = coordinatorLayout;
        }

        public final void onChildViewAdded(View view, View view2) {
            if (this.hB.hz != null) {
                this.hB.hz.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout coordinatorLayout = this.hB;
            int size = coordinatorLayout.hi.size();
            int i = 0;
            Object obj = null;
            while (i < size) {
                Object obj2;
                View view3 = (View) coordinatorLayout.hi.get(i);
                if (view3 == view2) {
                    obj2 = 1;
                } else {
                    if (obj != null) {
                        view3.getLayoutParams();
                    }
                    obj2 = obj;
                }
                i++;
                obj = obj2;
            }
            if (this.hB.hz != null) {
                this.hB.hz.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class d extends MarginLayoutParams {
        public int gravity = 0;
        Behavior hC;
        boolean hD = false;
        public int hE = 0;
        public int hF = -1;
        int hG = -1;
        View hH;
        View hI;
        boolean hJ;
        boolean hK;
        boolean hL;
        final Rect hM = new Rect();
        Object hN;

        public d() {
            super(-2, -2);
        }

        d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cv);
            this.gravity = obtainStyledAttributes.getInteger(i.cw, 0);
            this.hG = obtainStyledAttributes.getResourceId(i.cy, -1);
            this.hE = obtainStyledAttributes.getInteger(i.cA, 0);
            this.hF = obtainStyledAttributes.getInteger(i.cz, -1);
            this.hD = obtainStyledAttributes.hasValue(i.cx);
            if (this.hD) {
                this.hC = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(i.cx));
            }
            obtainStyledAttributes.recycle();
        }

        public d(d dVar) {
            super(dVar);
        }

        public d(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public d(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final void a(Behavior behavior) {
            if (this.hC != behavior) {
                this.hC = behavior;
                this.hN = null;
                this.hD = true;
            }
        }

        final boolean c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.hI || (this.hC != null && this.hC.e(view2));
        }
    }

    static class f implements Comparator<View> {
        f() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            View view = (View) obj2;
            float aj = z.aj((View) obj);
            float aj2 = z.aj(view);
            if (aj > aj2) {
                return -1;
            }
            return aj < aj2 ? 1 : 0;
        }
    }

    private class a implements t {
        final /* synthetic */ CoordinatorLayout hB;

        private a(CoordinatorLayout coordinatorLayout) {
            this.hB = coordinatorLayout;
        }

        public final ap a(View view, ap apVar) {
            return CoordinatorLayout.a(this.hB, apVar);
        }
    }

    static /* synthetic */ ap a(CoordinatorLayout coordinatorLayout, ap apVar) {
        boolean z = true;
        int i = 0;
        if (coordinatorLayout.eL == apVar) {
            return apVar;
        }
        ap apVar2;
        coordinatorLayout.eL = apVar;
        boolean z2 = apVar != null && apVar.getSystemWindowInsetTop() > 0;
        coordinatorLayout.hx = z2;
        if (coordinatorLayout.hx || coordinatorLayout.getBackground() != null) {
            z = false;
        }
        coordinatorLayout.setWillNotDraw(z);
        if (apVar.isConsumed()) {
            apVar2 = apVar;
        } else {
            int childCount = coordinatorLayout.getChildCount();
            ap apVar3 = apVar;
            while (i < childCount) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (z.Z(childAt) && ((d) childAt.getLayoutParams()).hC != null) {
                    apVar2 = Behavior.a(apVar3);
                    if (apVar2.isConsumed()) {
                        break;
                    }
                } else {
                    apVar2 = apVar3;
                }
                i++;
                apVar3 = apVar2;
            }
            apVar2 = apVar3;
        }
        coordinatorLayout.requestLayout();
        return apVar2;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            return new d((d) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new d((MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        hc = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            hg = new f();
            hh = new h();
        } else {
            hg = null;
            hh = null;
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hf = new 1(this);
        this.hi = new ArrayList();
        this.hj = new ArrayList();
        this.hk = new ArrayList();
        this.hl = new Rect();
        this.hm = new Rect();
        this.hn = new Rect();
        this.ho = new int[2];
        this.hA = new s(this);
        t.e(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cs, i, h.bI);
        int resourceId = obtainStyledAttributes.getResourceId(i.ct, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.hr = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.hr.length;
            for (resourceId = 0; resourceId < length; resourceId++) {
                int[] iArr = this.hr;
                iArr[resourceId] = (int) (((float) iArr[resourceId]) * f);
            }
        }
        this.hy = obtainStyledAttributes.getDrawable(i.cu);
        obtainStyledAttributes.recycle();
        if (hh != null) {
            hh.a(this, new a());
        }
        super.setOnHierarchyChangeListener(new c());
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.hz = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        T();
        if (this.hw) {
            if (this.hv == null) {
                this.hv = new e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.hv);
        }
        if (this.eL == null && z.Z(this)) {
            z.Y(this);
        }
        this.hq = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        T();
        if (this.hw && this.hv != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.hv);
        }
        if (this.hu != null) {
            onStopNestedScroll(this.hu);
        }
        this.hq = false;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.hy;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.hy;
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.hy != null && this.hy.isVisible() != z) {
            this.hy.setVisible(z, false);
        }
    }

    private void T() {
        if (this.hs != null) {
            Behavior behavior = ((d) this.hs.getLayoutParams()).hC;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                behavior.b(this, this.hs, obtain);
                obtain.recycle();
            }
            this.hs = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((d) getChildAt(i).getLayoutParams()).hJ = false;
        }
        this.hp = false;
    }

    private boolean a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        int d = o.d(motionEvent);
        List list = this.hj;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i2 = childCount - 1;
        while (i2 >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
            i2--;
        }
        if (hg != null) {
            Collections.sort(list, hg);
        }
        int size = list.size();
        int i3 = 0;
        MotionEvent motionEvent2 = null;
        while (i3 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i3);
            d dVar = (d) view.getLayoutParams();
            Behavior behavior = dVar.hC;
            if ((!z2 && obj == null) || d == 0) {
                if (!(z2 || behavior == null)) {
                    switch (i) {
                        case 0:
                            z2 = behavior.a(this, view, motionEvent);
                            break;
                        case 1:
                            z2 = behavior.b(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.hs = view;
                    }
                }
                z = z2;
                if (dVar.hC == null) {
                    dVar.hJ = false;
                }
                boolean z3 = dVar.hJ;
                if (dVar.hJ) {
                    isChildrenDrawingOrderEnabled = true;
                } else {
                    isChildrenDrawingOrderEnabled = dVar.hJ | 0;
                    dVar.hJ = isChildrenDrawingOrderEnabled;
                }
                Object obj3 = (!isChildrenDrawingOrderEnabled || z3) ? null : 1;
                if (isChildrenDrawingOrderEnabled && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (behavior != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        behavior.a(this, view, motionEvent3);
                        obj2 = obj;
                        z = z2;
                        continue;
                    case 1:
                        behavior.b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i3++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 0) {
            T();
        }
        boolean a = a(motionEvent, 0);
        if (d == 1 || d == 3) {
            T();
        }
        return a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2;
        int d = o.d(motionEvent);
        boolean z2;
        if (this.hs == null) {
            boolean a = a(motionEvent, 1);
            if (a) {
                z2 = a;
            } else {
                z2 = a;
                z = false;
                if (this.hs == null) {
                    z |= super.onTouchEvent(motionEvent);
                    motionEvent2 = null;
                } else if (z2) {
                    motionEvent2 = null;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    super.onTouchEvent(motionEvent2);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                if (d == 1 || d == 3) {
                    T();
                }
                return z;
            }
        }
        z2 = false;
        Behavior behavior = ((d) this.hs.getLayoutParams()).hC;
        z = behavior != null ? behavior.b(this, this.hs, motionEvent) : false;
        if (this.hs == null) {
            z |= super.onTouchEvent(motionEvent);
            motionEvent2 = null;
        } else if (z2) {
            motionEvent2 = null;
        } else {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            motionEvent2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEvent2);
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        T();
        return z;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.hp) {
            T();
            this.hp = true;
        }
    }

    private int C(int i) {
        if (this.hr == null) {
            new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(i);
            return 0;
        } else if (i >= 0 && i < this.hr.length) {
            return this.hr[i];
        } else {
            new StringBuilder("Keyline index ").append(i).append(" out of range for ").append(this);
            return 0;
        }
    }

    static Behavior a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(hc)) {
            str = hc + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) he.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                he.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(hd);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private static d m(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.hD) {
            b bVar = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                bVar = (b) cls.getAnnotation(b.class);
                if (bVar != null) {
                    break;
                }
            }
            b bVar2 = bVar;
            if (bVar2 != null) {
                try {
                    dVar.a((Behavior) bVar2.value().newInstance());
                } catch (Exception e) {
                    new StringBuilder("Default behavior class ").append(bVar2.value().getName()).append(" could not be instantiated. Did you forget a default constructor?");
                }
            }
            dVar.hD = true;
        }
        return dVar;
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public final void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        Object obj;
        this.hi.clear();
        int childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            ViewParent childAt = getChildAt(i3);
            d m = m(childAt);
            if (m.hG == -1) {
                m.hI = null;
                m.hH = null;
            } else {
                View view;
                ViewParent parent;
                if (m.hH != null) {
                    Object obj2;
                    if (m.hH.getId() != m.hG) {
                        obj2 = null;
                    } else {
                        view = m.hH;
                        parent = m.hH.getParent();
                        while (parent != this) {
                            if (parent == null || parent == childAt) {
                                m.hI = null;
                                m.hH = null;
                                obj2 = null;
                                break;
                            }
                            if (parent instanceof View) {
                                view = (View) parent;
                            }
                            parent = parent.getParent();
                        }
                        m.hI = view;
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        continue;
                    }
                }
                m.hH = findViewById(m.hG);
                if (m.hH != null) {
                    if (m.hH != this) {
                        view = m.hH;
                        parent = m.hH.getParent();
                        while (parent != this && parent != null) {
                            if (parent != childAt) {
                                if (parent instanceof View) {
                                    view = (View) parent;
                                }
                                parent = parent.getParent();
                            } else if (isInEditMode()) {
                                m.hI = null;
                                m.hH = null;
                            } else {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                        }
                        m.hI = view;
                    } else if (isInEditMode()) {
                        m.hI = null;
                        m.hH = null;
                    } else {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                } else if (isInEditMode()) {
                    m.hI = null;
                    m.hH = null;
                } else {
                    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(m.hG) + " to anchor view " + childAt);
                }
            }
            this.hi.add(childAt);
        }
        a(this.hi, this.hf);
        U();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        i3 = getPaddingBottom();
        int I = z.I(this);
        Object obj3;
        if (I == 1) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i4 = paddingLeft + paddingRight;
        int i5 = paddingTop + i3;
        childCount = getSuggestedMinimumWidth();
        i3 = getSuggestedMinimumHeight();
        if (this.eL == null || !z.Z(this)) {
            obj = null;
        } else {
            obj = 1;
        }
        int size3 = this.hi.size();
        int i6 = 0;
        int i7 = 0;
        int i8 = i3;
        int i9 = childCount;
        while (i6 < size3) {
            int i10;
            View view2 = (View) this.hi.get(i6);
            d dVar = (d) view2.getLayoutParams();
            int i11 = 0;
            if (dVar.hF >= 0 && mode != 0) {
                int C = C(dVar.hF);
                paddingTop = android.support.v4.view.f.getAbsoluteGravity(E(dVar.gravity), I) & 7;
                if ((paddingTop == 3 && r9 == null) || (paddingTop == 5 && r9 != null)) {
                    i11 = Math.max(0, (size - paddingRight) - C);
                } else if ((paddingTop == 5 && r9 == null) || (paddingTop == 3 && r9 != null)) {
                    i11 = Math.max(0, C - paddingLeft);
                }
            }
            if (obj == null || z.Z(view2)) {
                i10 = i2;
                childCount = i;
            } else {
                paddingTop = this.eL.getSystemWindowInsetTop() + this.eL.getSystemWindowInsetBottom();
                childCount = MeasureSpec.makeMeasureSpec(size - (this.eL.getSystemWindowInsetLeft() + this.eL.getSystemWindowInsetRight()), mode);
                i10 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
            }
            Behavior behavior = dVar.hC;
            if (behavior == null || !behavior.a(this, view2, childCount, i11, i10, 0)) {
                a(view2, childCount, i11, i10, 0);
            }
            i11 = Math.max(i9, ((view2.getMeasuredWidth() + i4) + dVar.leftMargin) + dVar.rightMargin);
            childCount = Math.max(i8, ((view2.getMeasuredHeight() + i5) + dVar.topMargin) + dVar.bottomMargin);
            i6++;
            i7 = z.combineMeasuredStates(i7, z.M(view2));
            i8 = childCount;
            i9 = i11;
        }
        setMeasuredDimension(z.resolveSizeAndState(i9, i, WebView.NIGHT_MODE_COLOR & i7), z.resolveSizeAndState(i8, i2, i7 << 16));
    }

    public final void e(View view, int i) {
        Object obj;
        d dVar = (d) view.getLayoutParams();
        if (dVar.hH != null || dVar.hG == -1) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (dVar.hH != null) {
            View view2 = dVar.hH;
            view.getLayoutParams();
            Rect rect = this.hl;
            Rect rect2 = this.hm;
            x.a(this, view2, rect);
            a(view, i, rect, rect2);
            view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        } else if (dVar.hF >= 0) {
            int i2;
            int i3 = dVar.hF;
            dVar = (d) view.getLayoutParams();
            int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(E(dVar.gravity), i);
            int i4 = absoluteGravity & 7;
            absoluteGravity &= MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
            int width = getWidth();
            int height = getHeight();
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (i == 1) {
                i3 = width - i3;
            }
            i3 = C(i3) - measuredWidth;
            switch (i4) {
                case 1:
                    i2 = i3 + (measuredWidth / 2);
                    break;
                case 5:
                    i2 = i3 + measuredWidth;
                    break;
                default:
                    i2 = i3;
                    break;
            }
            switch (absoluteGravity) {
                case 16:
                    i3 = (measuredHeight / 2) + 0;
                    break;
                case 80:
                    i3 = measuredHeight + 0;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(i2, ((width - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
            int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(i3, ((height - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
            view.layout(max, max2, max + measuredWidth, max2 + measuredHeight);
        } else {
            dVar = (d) view.getLayoutParams();
            Rect rect3 = this.hl;
            rect3.set(getPaddingLeft() + dVar.leftMargin, getPaddingTop() + dVar.topMargin, (getWidth() - getPaddingRight()) - dVar.rightMargin, (getHeight() - getPaddingBottom()) - dVar.bottomMargin);
            if (!(this.eL == null || !z.Z(this) || z.Z(view))) {
                rect3.left += this.eL.getSystemWindowInsetLeft();
                rect3.top += this.eL.getSystemWindowInsetTop();
                rect3.right -= this.eL.getSystemWindowInsetRight();
                rect3.bottom -= this.eL.getSystemWindowInsetBottom();
            }
            Rect rect4 = this.hm;
            android.support.v4.view.f.apply(D(dVar.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect3, rect4, i);
            view.layout(rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int I = z.I(this);
        int size = this.hi.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.hi.get(i5);
            Behavior behavior = ((d) view.getLayoutParams()).hC;
            if (behavior == null || !behavior.a(this, view, I)) {
                e(view, I);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.hx && this.hy != null) {
            int systemWindowInsetTop = this.eL != null ? this.eL.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.hy.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.hy.draw(canvas);
            }
        }
    }

    final void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            x.a(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void a(View view, int i, Rect rect, Rect rect2) {
        d dVar = (d) view.getLayoutParams();
        int i2 = dVar.gravity;
        if (i2 == 0) {
            i2 = 17;
        }
        i2 = android.support.v4.view.f.getAbsoluteGravity(i2, i);
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(D(dVar.hE), i);
        int i3 = i2 & 7;
        int i4 = i2 & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        i2 = absoluteGravity & 7;
        int i5 = absoluteGravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (i2) {
            case 1:
                absoluteGravity = (rect.width() / 2) + rect.left;
                break;
            case 5:
                absoluteGravity = rect.right;
                break;
            default:
                absoluteGravity = rect.left;
                break;
        }
        switch (i5) {
            case 16:
                i2 = rect.top + (rect.height() / 2);
                break;
            case 80:
                i2 = rect.bottom;
                break;
            default:
                i2 = rect.top;
                break;
        }
        switch (i3) {
            case 1:
                absoluteGravity -= measuredWidth / 2;
                break;
            case 5:
                break;
            default:
                absoluteGravity -= measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                i2 -= measuredHeight / 2;
                break;
            case 80:
                break;
            default:
                i2 -= measuredHeight;
                break;
        }
        i3 = getWidth();
        i4 = getHeight();
        absoluteGravity = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(absoluteGravity, ((i3 - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
        int max = Math.max(getPaddingTop() + dVar.topMargin, Math.min(i2, ((i4 - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
        rect2.set(absoluteGravity, max, absoluteGravity + measuredWidth, max + measuredHeight);
    }

    private static int D(int i) {
        return i == 0 ? 8388659 : i;
    }

    private static int E(int i) {
        return i == 0 ? 8388661 : i;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        view.getLayoutParams();
        return super.drawChild(canvas, view, j);
    }

    final void i(boolean z) {
        int I = z.I(this);
        int size = this.hi.size();
        for (int i = 0; i < size; i++) {
            int i2;
            Behavior behavior;
            View view = (View) this.hi.get(i);
            d dVar = (d) view.getLayoutParams();
            for (i2 = 0; i2 < i; i2++) {
                d dVar2;
                if (dVar.hI == ((View) this.hi.get(i2))) {
                    dVar2 = (d) view.getLayoutParams();
                    if (dVar2.hH != null) {
                        Rect rect = this.hl;
                        Rect rect2 = this.hm;
                        Rect rect3 = this.hn;
                        x.a(this, dVar2.hH, rect);
                        a(view, false, rect2);
                        a(view, I, rect, rect3);
                        int i3 = rect3.left - rect2.left;
                        int i4 = rect3.top - rect2.top;
                        if (i3 != 0) {
                            view.offsetLeftAndRight(i3);
                        }
                        if (i4 != 0) {
                            view.offsetTopAndBottom(i4);
                        }
                        if (i3 != 0 || i4 != 0) {
                            behavior = dVar2.hC;
                            if (behavior != null) {
                                behavior.b(this, view, dVar2.hH);
                            }
                        }
                    }
                }
            }
            Rect rect4 = this.hl;
            Rect rect5 = this.hm;
            rect4.set(((d) view.getLayoutParams()).hM);
            a(view, true, rect5);
            if (!rect4.equals(rect5)) {
                ((d) view.getLayoutParams()).hM.set(rect5);
                for (i2 = i + 1; i2 < size; i2++) {
                    View view2 = (View) this.hi.get(i2);
                    dVar2 = (d) view2.getLayoutParams();
                    behavior = dVar2.hC;
                    if (behavior != null && behavior.e(view)) {
                        if (z || !dVar2.hL) {
                            behavior.b(this, view2, view);
                            if (z) {
                                dVar2.hL = false;
                            }
                        } else {
                            dVar2.hL = false;
                        }
                    }
                }
            }
        }
    }

    public final List<View> n(View view) {
        d dVar = (d) view.getLayoutParams();
        List<View> list = this.hk;
        list.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && dVar.c(this, view, childAt)) {
                list.add(childAt);
            }
        }
        return list;
    }

    private void U() {
        boolean z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.hH != null) {
                z = true;
            } else {
                int childCount2 = getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt2 = getChildAt(i2);
                    if (childAt2 != childAt && dVar.c(this, childAt, childAt2)) {
                        z = true;
                        break;
                    }
                }
                z = false;
            }
            if (z) {
                z = true;
                break;
            }
        }
        z = false;
        if (z == this.hw) {
            return;
        }
        if (z) {
            if (this.hq) {
                if (this.hv == null) {
                    this.hv = new e(this);
                }
                getViewTreeObserver().addOnPreDrawListener(this.hv);
            }
            this.hw = true;
            return;
        }
        if (this.hq && this.hv != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.hv);
        }
        this.hw = false;
    }

    public final boolean b(View view, int i, int i2) {
        Rect rect = this.hl;
        x.a(this, view, rect);
        return rect.contains(i, i2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            d dVar = (d) childAt.getLayoutParams();
            Behavior behavior = dVar.hC;
            if (behavior != null) {
                boolean a = behavior.a(this, childAt, view, i);
                z |= a;
                dVar.hK = a;
                z2 = z;
            } else {
                dVar.hK = false;
                z2 = z;
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.hA.xA = i;
        this.ht = view;
        this.hu = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).getLayoutParams();
        }
    }

    public void onStopNestedScroll(View view) {
        this.hA.xA = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.hK) {
                Behavior behavior = dVar.hC;
                if (behavior != null) {
                    behavior.a(this, childAt, view);
                }
                dVar.hK = false;
                dVar.hL = false;
            }
        }
        this.ht = null;
        this.hu = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        boolean z = false;
        while (i5 < childCount) {
            boolean z2;
            View childAt = getChildAt(i5);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.hK) {
                Behavior behavior = dVar.hC;
                if (behavior != null) {
                    behavior.b(this, childAt, i4);
                    z2 = true;
                    i5++;
                    z = z2;
                }
            }
            z2 = z;
            i5++;
            z = z2;
        }
        if (z) {
            i(true);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            int max;
            int max2;
            Object obj2;
            View childAt = getChildAt(i5);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.hK) {
                Behavior behavior = dVar.hC;
                if (behavior != null) {
                    int[] iArr2 = this.ho;
                    this.ho[1] = 0;
                    iArr2[0] = 0;
                    behavior.a(this, childAt, view, i2, this.ho);
                    max = i > 0 ? Math.max(i3, this.ho[0]) : Math.min(i3, this.ho[0]);
                    max2 = i2 > 0 ? Math.max(i4, this.ho[1]) : Math.min(i4, this.ho[1]);
                    obj2 = 1;
                    i5++;
                    i4 = max2;
                    i3 = max;
                    obj = obj2;
                }
            }
            obj2 = obj;
            max = i3;
            max2 = i4;
            i5++;
            i4 = max2;
            i3 = max;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            i(true);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.hK) {
                Behavior behavior = dVar.hC;
                if (behavior != null) {
                    a = behavior.a(this, childAt, f2, z) | z2;
                    i++;
                    z2 = a;
                }
            }
            a = z2;
            i++;
            z2 = a;
        }
        if (z2) {
            i(true);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.hK) {
                Behavior behavior = dVar.hC;
                if (behavior != null) {
                    a = behavior.a(this, childAt, view, f, f2) | z;
                    i++;
                    z = a;
                }
            }
            a = z;
            i++;
            z = a;
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.hA.xA;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            SparseArray sparseArray = savedState.hO;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                Behavior behavior = m(childAt).hC;
                if (!(id == -1 || behavior == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        behavior.a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((d) childAt.getLayoutParams()).hC;
            if (!(id == -1 || behavior == null)) {
                Parcelable b = behavior.b(this, childAt);
                if (b != null) {
                    sparseArray.append(id, b);
                }
            }
        }
        savedState.hO = sparseArray;
        return savedState;
    }

    private static void a(List<View> list, Comparator<View> comparator) {
        if (list != null && list.size() >= 2) {
            int i;
            View[] viewArr = new View[list.size()];
            list.toArray(viewArr);
            for (int i2 = 0; i2 < r5; i2++) {
                i = i2;
                for (int i3 = i2 + 1; i3 < r5; i3++) {
                    if (comparator.compare(viewArr[i3], viewArr[i]) < 0) {
                        i = i3;
                    }
                }
                if (i2 != i) {
                    View view = viewArr[i];
                    viewArr[i] = viewArr[i2];
                    viewArr[i2] = view;
                }
            }
            list.clear();
            for (Object add : viewArr) {
                list.add(add);
            }
        }
    }
}

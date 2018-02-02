package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    static final d DW;
    private int DI;
    private int DJ;
    private Drawable DK;
    private Drawable DL;
    private final int DM;
    private boolean DN;
    private View DO;
    private float DP;
    private float DQ;
    private int DR;
    private int DS;
    private final u DT;
    private boolean DU;
    private final ArrayList<b> DV;
    private final Rect gO;
    private float xP;
    private float xQ;
    private boolean yX;
    private boolean zj;

    public static class LayoutParams extends MarginLayoutParams {
        private static final int[] yd = new int[]{16843137};
        boolean DZ;
        boolean Ea;
        Paint Eb;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, yd);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean Ec;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ec = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ec ? 1 : 0);
        }
    }

    private class b implements Runnable {
        final /* synthetic */ SlidingPaneLayout DX;
        final View DY;

        b(SlidingPaneLayout slidingPaneLayout, View view) {
            this.DX = slidingPaneLayout;
            this.DY = view;
        }

        public final void run() {
            if (this.DY.getParent() == this.DX) {
                z.a(this.DY, 0, null);
                this.DX.aE(this.DY);
            }
            this.DX.DV.remove(this);
        }
    }

    interface d {
        void b(SlidingPaneLayout slidingPaneLayout, View view);
    }

    class a extends android.support.v4.view.a {
        final /* synthetic */ SlidingPaneLayout DX;
        private final Rect gO = new Rect();

        a(SlidingPaneLayout slidingPaneLayout) {
            this.DX = slidingPaneLayout;
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            android.support.v4.view.a.b a = android.support.v4.view.a.b.a(bVar);
            super.a(view, a);
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
            android.support.v4.view.a.b.zW.c(bVar.zX, android.support.v4.view.a.b.zW.D(a.zX));
            a.recycle();
            bVar.setClassName(SlidingPaneLayout.class.getName());
            bVar.setSource(view);
            ViewParent J = z.J(view);
            if (J instanceof View) {
                bVar.setParent((View) J);
            }
            int childCount = this.DX.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.DX.getChildAt(i);
                if (!aG(childAt) && childAt.getVisibility() == 0) {
                    z.i(childAt, 1);
                    bVar.addChild(childAt);
                }
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (aG(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        private boolean aG(View view) {
            return this.DX.aF(view);
        }
    }

    private class c extends android.support.v4.widget.u.a {
        final /* synthetic */ SlidingPaneLayout DX;

        private c(SlidingPaneLayout slidingPaneLayout) {
            this.DX = slidingPaneLayout;
        }

        public final boolean b(View view, int i) {
            if (this.DX.yX) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).DZ;
        }

        public final void t(int i) {
            if (this.DX.DT.EV != 0) {
                return;
            }
            if (this.DX.DP == 0.0f) {
                this.DX.aD(this.DX.DO);
                SlidingPaneLayout slidingPaneLayout = this.DX;
                this.DX.DO;
                slidingPaneLayout.sendAccessibilityEvent(32);
                this.DX.DU = false;
                return;
            }
            slidingPaneLayout = this.DX;
            this.DX.DO;
            slidingPaneLayout.sendAccessibilityEvent(32);
            this.DX.DU = true;
        }

        public final void f(View view, int i) {
            this.DX.cF();
        }

        public final void a(View view, int i, int i2) {
            SlidingPaneLayout.a(this.DX, i);
            this.DX.invalidate();
        }

        public final void a(View view, float f, float f2) {
            int paddingRight;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.DX.cH()) {
                paddingRight = layoutParams.rightMargin + this.DX.getPaddingRight();
                if (f < 0.0f || (f == 0.0f && this.DX.DP > 0.5f)) {
                    paddingRight += this.DX.DR;
                }
                paddingRight = (this.DX.getWidth() - paddingRight) - this.DX.DO.getWidth();
            } else {
                paddingRight = layoutParams.leftMargin + this.DX.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && this.DX.DP > 0.5f)) {
                    paddingRight += this.DX.DR;
                }
            }
            this.DX.DT.t(paddingRight, view.getTop());
            this.DX.invalidate();
        }

        public final int s(View view) {
            return this.DX.DR;
        }

        public final int d(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) this.DX.DO.getLayoutParams();
            if (this.DX.cH()) {
                int width = this.DX.getWidth() - ((layoutParams.rightMargin + this.DX.getPaddingRight()) + this.DX.DO.getWidth());
                return Math.max(Math.min(i, width), width - this.DX.DR);
            }
            width = layoutParams.leftMargin + this.DX.getPaddingLeft();
            return Math.min(Math.max(i, width), this.DX.DR + width);
        }

        public final int c(View view, int i) {
            return view.getTop();
        }

        public final void q(int i, int i2) {
            this.DX.DT.n(this.DX.DO, i2);
        }
    }

    static class e implements d {
        e() {
        }

        public void b(SlidingPaneLayout slidingPaneLayout, View view) {
            z.b(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    static class f extends e {
        private Method Ed;
        private Field Ee;

        f() {
            try {
                this.Ed = View.class.getDeclaredMethod("getDisplayList", null);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.Ee = View.class.getDeclaredField("mRecreateDisplayList");
                this.Ee.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
        }

        public final void b(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.Ed == null || this.Ee == null) {
                view.invalidate();
                return;
            }
            try {
                this.Ee.setBoolean(view, true);
                this.Ed.invoke(view, null);
            } catch (Exception e) {
            }
            super.b(slidingPaneLayout, view);
        }
    }

    static class g extends e {
        g() {
        }

        public final void b(SlidingPaneLayout slidingPaneLayout, View view) {
            z.a(view, ((LayoutParams) view.getLayoutParams()).Eb);
        }
    }

    static /* synthetic */ void a(SlidingPaneLayout slidingPaneLayout, int i) {
        if (slidingPaneLayout.DO == null) {
            slidingPaneLayout.DP = 0.0f;
            return;
        }
        boolean cH = slidingPaneLayout.cH();
        LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.DO.getLayoutParams();
        int width = slidingPaneLayout.DO.getWidth();
        if (cH) {
            i = (slidingPaneLayout.getWidth() - i) - width;
        }
        slidingPaneLayout.DP = ((float) (i - ((cH ? layoutParams.rightMargin : layoutParams.leftMargin) + (cH ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft())))) / ((float) slidingPaneLayout.DR);
        if (slidingPaneLayout.DS != 0) {
            slidingPaneLayout.D(slidingPaneLayout.DP);
        }
        if (layoutParams.Ea) {
            slidingPaneLayout.a(slidingPaneLayout.DO, slidingPaneLayout.DP, slidingPaneLayout.DI);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            DW = new g();
        } else if (i >= 16) {
            DW = new f();
        } else {
            DW = new e();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DI = -858993460;
        this.zj = true;
        this.gO = new Rect();
        this.DV = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.DM = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        z.a((View) this, new a(this));
        z.i(this, 1);
        this.DT = u.a((ViewGroup) this, 0.5f, new c());
        this.DT.Ff = f * 400.0f;
    }

    final void aD(View view) {
        int left;
        int right;
        int top;
        int bottom;
        int childCount;
        int i;
        View childAt;
        int i2;
        int max;
        boolean cH = cH();
        int width = cH ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = cH ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view != null) {
            Object obj;
            if (z.K(view)) {
                obj = 1;
            } else {
                if (VERSION.SDK_INT < 18) {
                    Drawable background = view.getBackground();
                    if (background != null) {
                        obj = background.getOpacity() == -1 ? 1 : null;
                    }
                }
                obj = null;
            }
            if (obj != null) {
                left = view.getLeft();
                right = view.getRight();
                top = view.getTop();
                bottom = view.getBottom();
                childCount = getChildCount();
                i = 0;
                while (i < childCount) {
                    childAt = getChildAt(i);
                    if (childAt != view) {
                        if (cH) {
                            i2 = width;
                        } else {
                            i2 = paddingLeft;
                        }
                        max = Math.max(i2, childAt.getLeft());
                        int max2 = Math.max(paddingTop, childAt.getTop());
                        if (cH) {
                            i2 = paddingLeft;
                        } else {
                            i2 = width;
                        }
                        i2 = Math.min(i2, childAt.getRight());
                        int min = Math.min(height, childAt.getBottom());
                        if (max >= left || max2 < r3 || i2 > r4 || min > r2) {
                            i2 = 0;
                        } else {
                            i2 = 4;
                        }
                        childAt.setVisibility(i2);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
        bottom = 0;
        top = 0;
        right = 0;
        left = 0;
        childCount = getChildCount();
        i = 0;
        while (i < childCount) {
            childAt = getChildAt(i);
            if (childAt != view) {
                if (cH) {
                    i2 = width;
                } else {
                    i2 = paddingLeft;
                }
                max = Math.max(i2, childAt.getLeft());
                int max22 = Math.max(paddingTop, childAt.getTop());
                if (cH) {
                    i2 = paddingLeft;
                } else {
                    i2 = width;
                }
                i2 = Math.min(i2, childAt.getRight());
                int min2 = Math.min(height, childAt.getBottom());
                if (max >= left) {
                }
                i2 = 0;
                childAt.setVisibility(i2);
                i++;
            } else {
                return;
            }
        }
    }

    final void cF() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.zj = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.zj = true;
        int size = this.DV.size();
        for (int i = 0; i < size; i++) {
            ((b) this.DV.get(i)).run();
        }
        this.DV.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = 300;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (isInEditMode()) {
            if (mode != Integer.MIN_VALUE && mode == 0) {
                i3 = mode2;
                i4 = 300;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                mode2 = 0;
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                size2 = mode2;
                break;
            default:
                mode2 = 0;
                size2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        this.DO = null;
        int i5 = 0;
        int i6 = paddingLeft;
        int i7 = mode2;
        float f = 0.0f;
        while (i5 < childCount) {
            float f2;
            boolean z2;
            int makeMeasureSpec;
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.Ea = false;
                mode2 = i6;
                mode = i7;
                f2 = f;
                z2 = z;
            } else {
                if (layoutParams.weight > 0.0f) {
                    f += layoutParams.weight;
                    if (layoutParams.width == 0) {
                        mode2 = i6;
                        mode = i7;
                        f2 = f;
                        z2 = z;
                    }
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                } else {
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(mode, makeMeasureSpec);
                mode = childAt.getMeasuredWidth();
                makeMeasureSpec = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && makeMeasureSpec > i7) {
                    i7 = Math.min(makeMeasureSpec, size2);
                }
                makeMeasureSpec = i6 - mode;
                boolean z3 = makeMeasureSpec < 0;
                layoutParams.DZ = z3;
                z3 |= z;
                if (layoutParams.DZ) {
                    this.DO = childAt;
                }
                mode2 = makeMeasureSpec;
                f2 = f;
                z2 = z3;
                mode = i7;
            }
            i5++;
            z = z2;
            i7 = mode;
            i6 = mode2;
            f = f2;
        }
        if (z || f > 0.0f) {
            int i8 = paddingLeft - this.DM;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.weight <= 0.0f) ? null : 1;
                        makeMeasureSpec = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.DO) {
                            if (layoutParams.weight > 0.0f) {
                                if (layoutParams.width != 0) {
                                    mode = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams.height == -2) {
                                    mode = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
                                } else if (layoutParams.height == -1) {
                                    mode = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                } else {
                                    mode = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                                }
                                if (z) {
                                    mode2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                                    if (makeMeasureSpec != mode2) {
                                        childAt2.measure(i5, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.weight * ((float) Math.max(0, i6))) / f)) + makeMeasureSpec, 1073741824), mode);
                                }
                            }
                        } else if (layoutParams.width < 0 && (makeMeasureSpec > i8 || layoutParams.weight > 0.0f)) {
                            if (obj == null) {
                                mode2 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams.height == -2) {
                                mode2 = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
                            } else if (layoutParams.height == -1) {
                                mode2 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                            } else {
                                mode2 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i8, 1073741824), mode2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i7) + getPaddingBottom());
        this.DN = z;
        if (this.DT.EV != 0 && !z) {
            this.DT.abort();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean cH = cH();
        if (cH) {
            this.DT.Fh = 2;
        } else {
            this.DT.Fh = 1;
        }
        int i5 = i3 - i;
        int paddingRight = cH ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = cH ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.zj) {
            float f = (this.DN && this.DU) ? 1.0f : 0.0f;
            this.DP = f;
        }
        int i6 = 0;
        int i7 = paddingRight;
        while (i6 < childCount) {
            int i8;
            int i9;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int i11 = 0;
                if (layoutParams.DZ) {
                    int min = (Math.min(paddingRight, (i5 - paddingLeft) - this.DM) - i7) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.DR = min;
                    i8 = cH ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.Ea = ((i7 + i8) + min) + (measuredWidth / 2) > i5 - paddingLeft;
                    i9 = (int) (((float) min) * this.DP);
                    i10 = i7 + (i8 + i9);
                    this.DP = ((float) i9) / ((float) this.DR);
                } else {
                    if (!this.DN || this.DS == 0) {
                        i9 = 0;
                    } else {
                        i9 = (int) ((1.0f - this.DP) * ((float) this.DS));
                    }
                    i11 = i9;
                    i10 = paddingRight;
                }
                if (cH) {
                    i8 = (i5 - i10) + i11;
                    i9 = i8 - measuredWidth;
                } else {
                    i9 = i10 - i11;
                    i8 = i9 + measuredWidth;
                }
                childAt.layout(i9, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                i9 = childAt.getWidth() + paddingRight;
                i8 = i10;
            } else {
                i9 = paddingRight;
                i8 = i7;
            }
            i6++;
            paddingRight = i9;
            i7 = i8;
        }
        if (this.zj) {
            if (this.DN) {
                if (this.DS != 0) {
                    D(this.DP);
                }
                if (((LayoutParams) this.DO.getLayoutParams()).Ea) {
                    a(this.DO, this.DP, this.DI);
                }
            } else {
                for (i9 = 0; i9 < childCount; i9++) {
                    a(getChildAt(i9), 0.0f, this.DI);
                }
            }
            aD(this.DO);
        }
        this.zj = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.zj = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.DN) {
            this.DU = view == this.DO;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (!this.DN && d == 0 && getChildCount() > 1) {
            View childAt = getChildAt(1);
            if (childAt != null) {
                this.DU = !u.f(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
        }
        if (!this.DN || (this.yX && d != 0)) {
            this.DT.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (d == 3 || d == 1) {
            this.DT.cancel();
            return false;
        } else {
            boolean z;
            float x;
            float y;
            switch (d) {
                case 0:
                    this.yX = false;
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    this.xP = x;
                    this.xQ = y;
                    if (u.f(this.DO, (int) x, (int) y) && aF(this.DO)) {
                        z = true;
                        break;
                    }
                case 2:
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    x = Math.abs(x - this.xP);
                    y = Math.abs(y - this.xQ);
                    if (x > ((float) this.DT.iN) && y > x) {
                        this.DT.cancel();
                        this.yX = true;
                        return false;
                    }
                    z = false;
                    break;
            }
            z = false;
            if (this.DT.j(motionEvent) || r0) {
                return true;
            }
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.DN) {
            return super.onTouchEvent(motionEvent);
        }
        this.DT.k(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.xP = x;
                this.xQ = y;
                break;
            case 1:
                if (aF(this.DO)) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    float f = x - this.xP;
                    float f2 = y - this.xQ;
                    int i = this.DT.iN;
                    if ((f * f) + (f2 * f2) < ((float) (i * i)) && u.f(this.DO, (int) x, (int) y)) {
                        cG();
                        break;
                    }
                }
                break;
        }
        return true;
    }

    private boolean cG() {
        if (!this.zj && !C(0.0f)) {
            return false;
        }
        this.DU = false;
        return true;
    }

    private void a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((WebView.NIGHT_MODE_COLOR & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.Eb == null) {
                layoutParams.Eb = new Paint();
            }
            layoutParams.Eb.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (z.H(view) != 2) {
                z.a(view, 2, layoutParams.Eb);
            }
            aE(view);
        } else if (z.H(view) != 0) {
            if (layoutParams.Eb != null) {
                layoutParams.Eb.setColorFilter(null);
            }
            Runnable bVar = new b(this, view);
            this.DV.add(bVar);
            z.a((View) this, bVar);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.DN || layoutParams.DZ || this.DO == null)) {
            canvas.getClipBounds(this.gO);
            if (cH()) {
                this.gO.left = Math.max(this.gO.left, this.DO.getRight());
            } else {
                this.gO.right = Math.min(this.gO.right, this.DO.getLeft());
            }
            canvas.clipRect(this.gO);
        }
        if (VERSION.SDK_INT < 11) {
            if (layoutParams.Ea && this.DP > 0.0f) {
                if (!view.isDrawingCacheEnabled()) {
                    view.setDrawingCacheEnabled(true);
                }
                Bitmap drawingCache = view.getDrawingCache();
                if (drawingCache != null) {
                    canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.Eb);
                    z = false;
                    canvas.restoreToCount(save);
                    return z;
                }
                new StringBuilder("drawChild: child view ").append(view).append(" returned null drawing cache");
            } else if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
        }
        z = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return z;
    }

    private void aE(View view) {
        DW.b(this, view);
    }

    private boolean C(float f) {
        if (!this.DN) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.DO.getLayoutParams();
        if (cH()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.DR) * f)) + ((float) this.DO.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.DR) * f));
        }
        if (!this.DT.e(this.DO, width, this.DO.getTop())) {
            return false;
        }
        cF();
        z.E(this);
        return true;
    }

    public void computeScroll() {
        if (!this.DT.cL()) {
            return;
        }
        if (this.DN) {
            z.E(this);
        } else {
            this.DT.abort();
        }
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (cH()) {
            drawable = this.DL;
        } else {
            drawable = this.DK;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (cH()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    private void D(float f) {
        Object obj;
        int childCount;
        int i;
        View childAt;
        int i2;
        float f2;
        boolean cH = cH();
        LayoutParams layoutParams = (LayoutParams) this.DO.getLayoutParams();
        if (layoutParams.Ea) {
            if ((cH ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = getChildAt(i);
                    if (childAt != this.DO) {
                        i2 = (int) ((1.0f - this.DQ) * ((float) this.DS));
                        this.DQ = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.DS));
                        if (cH) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj == null) {
                            if (cH) {
                                f2 = 1.0f - this.DQ;
                            } else {
                                f2 = this.DQ - 1.0f;
                            }
                            a(childAt, f2, this.DJ);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt != this.DO) {
                i2 = (int) ((1.0f - this.DQ) * ((float) this.DS));
                this.DQ = f;
                i2 -= (int) ((1.0f - f) * ((float) this.DS));
                if (cH) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
                if (obj == null) {
                    if (cH) {
                        f2 = 1.0f - this.DQ;
                    } else {
                        f2 = this.DQ - 1.0f;
                    }
                    a(childAt, f2, this.DJ);
                }
            }
        }
    }

    final boolean aF(View view) {
        if (view == null) {
            return false;
        }
        return this.DN && ((LayoutParams) view.getLayoutParams()).Ea && this.DP > 0.0f;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.DN ? !this.DN || this.DP == 1.0f : this.DU;
        savedState.Ec = z;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (!savedState.Ec) {
                cG();
            } else if (this.zj || C(1.0f)) {
                this.DU = true;
            }
            this.DU = savedState.Ec;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private boolean cH() {
        return z.I(this) == 1;
    }
}

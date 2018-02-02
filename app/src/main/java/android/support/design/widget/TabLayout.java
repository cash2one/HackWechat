package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.a.d;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.e.i.a;
import android.support.v4.e.i.b;
import android.support.v4.e.i.c;
import android.support.v4.view.z;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;

public class TabLayout extends HorizontalScrollView {
    private static final a<b> ka = new c();
    private final ArrayList<b> kb;
    private b kc;
    private final a kd;
    private int ke;
    private int kf;
    private int kg;
    private int kh;
    private int ki;
    private ColorStateList kj;
    private float kk;
    private float kl;
    private final int km;
    private int kn;
    private final int ko;
    private final int kp;
    private final int kq;
    private int kr;
    private int ks;
    private u kt;
    private final a<c> ku;
    private int mMode;

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kb = new ArrayList();
        this.kn = Integer.MAX_VALUE;
        this.ku = new b(12);
        t.e(context);
        setHorizontalScrollBarEnabled(false);
        this.kd = new a(this, context);
        super.addView(this.kd, 0, new LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.do, i, h.bM);
        View view = this.kd;
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i.dq, 0);
        if (view.kw != dimensionPixelSize) {
            view.kw = dimensionPixelSize;
            z.E(view);
        }
        view = this.kd;
        dimensionPixelSize = obtainStyledAttributes.getColor(i.dp, 0);
        if (view.kx.getColor() != dimensionPixelSize) {
            view.kx.setColor(dimensionPixelSize);
            z.E(view);
        }
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(i.dE, 0);
        this.kh = dimensionPixelSize2;
        this.kg = dimensionPixelSize2;
        this.kf = dimensionPixelSize2;
        this.ke = dimensionPixelSize2;
        this.ke = obtainStyledAttributes.getDimensionPixelSize(i.dA, this.ke);
        this.kf = obtainStyledAttributes.getDimensionPixelSize(i.dB, this.kf);
        this.kg = obtainStyledAttributes.getDimensionPixelSize(i.dC, this.kg);
        this.kh = obtainStyledAttributes.getDimensionPixelSize(i.dD, this.kh);
        this.ki = obtainStyledAttributes.getResourceId(i.dx, h.bE);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.ki, i.TextAppearance);
        try {
            this.kk = (float) obtainStyledAttributes2.getDimensionPixelSize(i.TextAppearance_android_textSize, 0);
            this.kj = obtainStyledAttributes2.getColorStateList(i.TextAppearance_android_textColor);
            if (obtainStyledAttributes.hasValue(i.dy)) {
                this.kj = obtainStyledAttributes.getColorStateList(i.dy);
            }
            if (obtainStyledAttributes.hasValue(i.dz)) {
                dimensionPixelSize2 = obtainStyledAttributes.getColor(i.dz, 0);
                dimensionPixelSize = this.kj.getDefaultColor();
                r4 = new int[2][];
                int[] iArr = new int[]{SELECTED_STATE_SET, dimensionPixelSize2};
                r4[1] = EMPTY_STATE_SET;
                iArr[1] = dimensionPixelSize;
                this.kj = new ColorStateList(r4, iArr);
            }
            this.ko = obtainStyledAttributes.getDimensionPixelSize(i.dv, -1);
            this.kp = obtainStyledAttributes.getDimensionPixelSize(i.dw, -1);
            this.km = obtainStyledAttributes.getResourceId(i.ds, 0);
            this.kr = obtainStyledAttributes.getDimensionPixelSize(i.dr, 0);
            this.mMode = obtainStyledAttributes.getInt(i.dt, 1);
            this.ks = obtainStyledAttributes.getInt(i.du, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.kl = (float) resources.getDimensionPixelSize(d.bj);
            this.kq = resources.getDimensionPixelSize(d.bi);
            z.c(this.kd, this.mMode == 0 ? Math.max(0, this.kr - this.ke) : 0, 0, 0, 0);
            switch (this.mMode) {
                case 0:
                    this.kd.setGravity(8388611);
                    break;
                case 1:
                    this.kd.setGravity(1);
                    break;
            }
            j(true);
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    private void H(int i) {
        int round = Math.round(((float) i) + 0.0f);
        if (round >= 0 && round < this.kd.getChildCount()) {
            a aVar = this.kd;
            if (aVar.kC != null && aVar.kC.ls.isRunning()) {
                aVar.kC.ls.cancel();
            }
            aVar.ky = i;
            aVar.kz = 0.0f;
            aVar.as();
            if (this.kt != null && this.kt.ls.isRunning()) {
                this.kt.ls.cancel();
            }
            scrollTo(b(i, 0.0f), 0);
            K(round);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return Math.max(0, ((this.kd.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight()) > 0;
    }

    private void a(b bVar, int i) {
        bVar.mPosition = i;
        this.kb.add(i, bVar);
        int size = this.kb.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((b) this.kb.get(i2)).mPosition = i2;
        }
    }

    public void addView(View view) {
        t(view);
    }

    public void addView(View view, int i) {
        t(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        t(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        t(view);
    }

    private void t(View view) {
        if (view instanceof TabItem) {
            b bVar;
            TabItem tabItem = (TabItem) view;
            b bVar2 = (b) ka.bG();
            if (bVar2 == null) {
                bVar = new b((byte) 0);
            } else {
                bVar = bVar2;
            }
            bVar.kL = this;
            c cVar = this.ku != null ? (c) this.ku.bG() : null;
            if (cVar == null) {
                cVar = new c(this, getContext());
            }
            c.a(cVar, bVar);
            cVar.setFocusable(true);
            cVar.setMinimumWidth(ar());
            bVar.kM = cVar;
            if (tabItem.mText != null) {
                bVar.mText = tabItem.mText;
                bVar.au();
            }
            if (tabItem.jY != null) {
                bVar.jY = tabItem.jY;
                bVar.au();
            }
            if (tabItem.jZ != 0) {
                bVar.kK = LayoutInflater.from(bVar.kM.getContext()).inflate(tabItem.jZ, bVar.kM, false);
                bVar.au();
            }
            boolean isEmpty = this.kb.isEmpty();
            if (bVar.kL != this) {
                throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
            }
            View view2 = bVar.kM;
            a aVar = this.kd;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            a(layoutParams);
            aVar.addView(view2, layoutParams);
            if (isEmpty) {
                view2.setSelected(true);
            }
            a(bVar, this.kb.size());
            if (isEmpty) {
                bVar.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.mMode == 1 && this.ks == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private int I(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 1;
        int size = this.kb.size();
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = (b) this.kb.get(i5);
            if (bVar != null && bVar.jY != null && !TextUtils.isEmpty(bVar.mText)) {
                i3 = 1;
                break;
            }
        }
        i3 = 0;
        i3 = (I(i3 != 0 ? 72 : 48) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(i3, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
                break;
        }
        i3 = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            if (this.kp > 0) {
                i3 = this.kp;
            } else {
                i3 -= I(56);
            }
            this.kn = i3;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.mMode) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        i3 = 0;
                        break;
                    } else {
                        i3 = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i4 = 0;
                    }
                    i3 = i4;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void J(int i) {
        Object obj = null;
        if (i != -1) {
            if (getWindowToken() != null && z.ai(this)) {
                int i2;
                a aVar = this.kd;
                int childCount = aVar.getChildCount();
                for (i2 = 0; i2 < childCount; i2++) {
                    if (aVar.getChildAt(i2).getWidth() <= 0) {
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    int scrollX = getScrollX();
                    i2 = b(i, 0.0f);
                    if (scrollX != i2) {
                        if (this.kt == null) {
                            this.kt = aa.ay();
                            this.kt.setInterpolator(a.eB);
                            this.kt.setDuration(300);
                            this.kt.a(new 1(this));
                        }
                        this.kt.g(scrollX, i2);
                        this.kt.ls.start();
                    }
                    this.kd.f(i, 300);
                    return;
                }
            }
            H(i);
        }
    }

    private void K(int i) {
        int childCount = this.kd.getChildCount();
        if (i < childCount && !this.kd.getChildAt(i).isSelected()) {
            for (int i2 = 0; i2 < childCount; i2++) {
                boolean z;
                View childAt = this.kd.getChildAt(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    final void a(b bVar) {
        if (this.kc != bVar) {
            int i = bVar != null ? bVar.mPosition : -1;
            if (i != -1) {
                K(i);
            }
            if ((this.kc == null || this.kc.mPosition == -1) && i != -1) {
                H(i);
            } else {
                J(i);
            }
            this.kc = bVar;
        } else if (this.kc != null) {
            J(bVar.mPosition);
        }
    }

    private int b(int i, float f) {
        int i2 = 0;
        if (this.mMode != 0) {
            return 0;
        }
        int width;
        View childAt = this.kd.getChildAt(i);
        View childAt2 = i + 1 < this.kd.getChildCount() ? this.kd.getChildAt(i + 1) : null;
        if (childAt != null) {
            width = childAt.getWidth();
        } else {
            width = 0;
        }
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * 0.0f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private void j(boolean z) {
        for (int i = 0; i < this.kd.getChildCount(); i++) {
            View childAt = this.kd.getChildAt(i);
            childAt.setMinimumWidth(ar());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private int ar() {
        if (this.ko != -1) {
            return this.ko;
        }
        return this.mMode == 0 ? this.kq : 0;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }
}

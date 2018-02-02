package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.e;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.widget.AppBarLayout.a;
import android.support.v4.view.ap;
import android.support.v4.view.z;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;

public class CollapsingToolbarLayout extends FrameLayout {
    private ap eL;
    private boolean gF;
    private int gG;
    private Toolbar gH;
    private View gI;
    private View gJ;
    private int gK;
    private int gL;
    private int gM;
    private int gN;
    private final Rect gO;
    private final f gP;
    private boolean gQ;
    private boolean gR;
    private Drawable gS;
    private Drawable gT;
    int gU;
    boolean gV;
    u gW;
    private a gX;
    private int gY;

    static /* synthetic */ ap a(CollapsingToolbarLayout collapsingToolbarLayout, ap apVar) {
        if (collapsingToolbarLayout.eL != apVar) {
            collapsingToolbarLayout.eL = apVar;
            collapsingToolbarLayout.requestLayout();
        }
        return apVar.cb();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return S();
    }

    protected /* synthetic */ FrameLayout.LayoutParams m3generateDefaultLayoutParams() {
        return S();
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        Drawable drawable = null;
        super(context, attributeSet, i);
        this.gF = true;
        this.gO = new Rect();
        t.e(context);
        this.gP = new f(this);
        this.gP.a(a.eE);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cc, i, h.bH);
        this.gP.w(obtainStyledAttributes.getInt(i.cp, 8388691));
        this.gP.x(obtainStyledAttributes.getInt(i.co, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i.ce, 0);
        this.gN = dimensionPixelSize;
        this.gM = dimensionPixelSize;
        this.gL = dimensionPixelSize;
        this.gK = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(i.cf)) {
            this.gK = obtainStyledAttributes.getDimensionPixelSize(i.cf, 0);
        }
        if (obtainStyledAttributes.hasValue(i.ch)) {
            this.gM = obtainStyledAttributes.getDimensionPixelSize(i.ch, 0);
        }
        if (obtainStyledAttributes.hasValue(i.cg)) {
            this.gL = obtainStyledAttributes.getDimensionPixelSize(i.cg, 0);
        }
        if (obtainStyledAttributes.hasValue(i.ci)) {
            this.gN = obtainStyledAttributes.getDimensionPixelSize(i.ci, 0);
        }
        this.gQ = obtainStyledAttributes.getBoolean(i.cq, true);
        this.gP.setText(obtainStyledAttributes.getText(i.cd));
        this.gP.z(h.bD);
        this.gP.y(h.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(i.cj)) {
            this.gP.z(obtainStyledAttributes.getResourceId(i.cj, 0));
        }
        if (obtainStyledAttributes.hasValue(i.ck)) {
            this.gP.y(obtainStyledAttributes.getResourceId(i.ck, 0));
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(i.cl);
        if (this.gS != drawable2) {
            if (this.gS != null) {
                this.gS.setCallback(null);
            }
            this.gS = drawable2 != null ? drawable2.mutate() : null;
            if (this.gS != null) {
                this.gS.setBounds(0, 0, getWidth(), getHeight());
                this.gS.setCallback(this);
                this.gS.setAlpha(this.gU);
            }
            z.E(this);
        }
        drawable2 = obtainStyledAttributes.getDrawable(i.cm);
        if (this.gT != drawable2) {
            if (this.gT != null) {
                this.gT.setCallback(null);
            }
            if (drawable2 != null) {
                drawable = drawable2.mutate();
            }
            this.gT = drawable;
            if (this.gT != null) {
                boolean z;
                if (this.gT.isStateful()) {
                    this.gT.setState(getDrawableState());
                }
                android.support.v4.b.a.a.b(this.gT, z.I(this));
                drawable = this.gT;
                if (getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                drawable.setVisible(z, false);
                this.gT.setCallback(this);
                this.gT.setAlpha(this.gU);
            }
            z.E(this);
        }
        this.gG = obtainStyledAttributes.getResourceId(i.cn, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        z.b(this, new 1(this));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.gX == null) {
                this.gX = new a(this, (byte) 0);
            }
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            a aVar = this.gX;
            if (!(aVar == null || appBarLayout.eM.contains(aVar))) {
                appBarLayout.eM.add(aVar);
            }
        }
        z.Y(this);
    }

    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.gX != null && (parent instanceof AppBarLayout)) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            a aVar = this.gX;
            if (aVar != null) {
                appBarLayout.eM.remove(aVar);
            }
        }
        super.onDetachedFromWindow();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        R();
        if (this.gH == null && this.gS != null && this.gU > 0) {
            this.gS.mutate().setAlpha(this.gU);
            this.gS.draw(canvas);
        }
        if (this.gQ && this.gR) {
            this.gP.draw(canvas);
        }
        if (this.gT != null && this.gU > 0) {
            int systemWindowInsetTop = this.eL != null ? this.eL.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.gT.setBounds(0, -this.gY, getWidth(), systemWindowInsetTop - this.gY);
                this.gT.mutate().setAlpha(this.gU);
                this.gT.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        R();
        if (view == this.gH && this.gS != null && this.gU > 0) {
            this.gS.mutate().setAlpha(this.gU);
            this.gS.draw(canvas);
        }
        return super.drawChild(canvas, view, j);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.gS != null) {
            this.gS.setBounds(0, 0, i, i2);
        }
    }

    final void R() {
        if (this.gF) {
            View view;
            this.gH = null;
            this.gI = null;
            if (this.gG != -1) {
                this.gH = (Toolbar) findViewById(this.gG);
                if (this.gH != null) {
                    view = this.gH;
                    CollapsingToolbarLayout parent = view.getParent();
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = parent;
                        }
                        parent = parent.getParent();
                    }
                    this.gI = view;
                }
            }
            if (this.gH == null) {
                Toolbar toolbar;
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    view = getChildAt(i);
                    if (view instanceof Toolbar) {
                        toolbar = (Toolbar) view;
                        break;
                    }
                }
                toolbar = null;
                this.gH = toolbar;
            }
            if (!(this.gQ || this.gJ == null)) {
                ViewParent parent2 = this.gJ.getParent();
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(this.gJ);
                }
            }
            if (this.gQ && this.gH != null) {
                if (this.gJ == null) {
                    this.gJ = new View(getContext());
                }
                if (this.gJ.getParent() == null) {
                    this.gH.addView(this.gJ, -1, -1);
                }
            }
            this.gF = false;
        }
    }

    protected void onMeasure(int i, int i2) {
        R();
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 1;
        int i7 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.gQ && this.gJ != null) {
            boolean z2 = z.ak(this.gJ) && this.gJ.getVisibility() == 0;
            this.gR = z2;
            if (this.gR) {
                if (this.gI == null || this.gI == this) {
                    i5 = 0;
                } else {
                    i5 = ((LayoutParams) this.gI.getLayoutParams()).bottomMargin;
                }
                x.a(this, this.gJ, this.gO);
                this.gP.c(this.gO.left, (i4 - this.gO.height()) - i5, this.gO.right, i4 - i5);
                if (z.I(this) != 1) {
                    i6 = 0;
                }
                f fVar = this.gP;
                i5 = i6 != 0 ? this.gM : this.gK;
                int i8 = this.gO.bottom + this.gL;
                int i9 = i3 - i;
                if (i6 != 0) {
                    i6 = this.gK;
                } else {
                    i6 = this.gM;
                }
                fVar.b(i5, i8, i9 - i6, (i4 - i2) - this.gN);
                this.gP.P();
            }
        }
        i5 = getChildCount();
        while (i7 < i5) {
            View childAt = getChildAt(i7);
            if (!(this.eL == null || z.Z(childAt))) {
                int systemWindowInsetTop = this.eL.getSystemWindowInsetTop();
                if (childAt.getTop() < systemWindowInsetTop) {
                    z.j(childAt, systemWindowInsetTop);
                }
            }
            k(childAt).aB();
            i7++;
        }
        if (this.gH != null) {
            if (this.gQ && TextUtils.isEmpty(this.gP.mText)) {
                this.gP.setText(this.gH.ZM);
            }
            if (this.gI == null || this.gI == this) {
                setMinimumHeight(j(this.gH));
            } else {
                setMinimumHeight(j(this.gI));
            }
        }
    }

    private static int j(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + (view.getHeight() + marginLayoutParams.topMargin);
    }

    private static z k(View view) {
        z zVar = (z) view.getTag(e.bq);
        if (zVar != null) {
            return zVar;
        }
        zVar = new z(view);
        view.setTag(e.bq, zVar);
        return zVar;
    }

    final void B(int i) {
        if (i != this.gU) {
            if (!(this.gS == null || this.gH == null)) {
                z.E(this.gH);
            }
            this.gU = i;
            z.E(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.gT;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        drawable = this.gS;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.gS || drawable == this.gT;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.gT == null || this.gT.isVisible() == z)) {
            this.gT.setVisible(z, false);
        }
        if (this.gS != null && this.gS.isVisible() != z) {
            this.gS.setVisible(z, false);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private LayoutParams S() {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}

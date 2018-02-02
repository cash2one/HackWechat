package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.support.v7.a.a.f;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements r, t {
    static final int[] yd = new int[]{android.support.v7.a.a.a.actionBarSize, 16842841};
    private final s Du;
    private u HT;
    private boolean IM;
    private int MP;
    public int MQ = 0;
    private ContentFrameLayout MR;
    private ActionBarContainer MS;
    private Drawable MT;
    private boolean MU;
    public boolean MV;
    public boolean MW;
    private boolean MX;
    private int MY;
    public int MZ;
    private final Rect Na = new Rect();
    private final Rect Nb = new Rect();
    private final Rect Nc = new Rect();
    private final Rect Nd = new Rect();
    private final Rect Ne = new Rect();
    private final Rect Nf = new Rect();
    public a Ng;
    private final int Nh = 600;
    private q Ni;
    private ai Nj;
    private final am Nk = new an(this) {
        final /* synthetic */ ActionBarOverlayLayout Nn;

        {
            this.Nn = r1;
        }

        public final void q(View view) {
            this.Nn.Nj = null;
            this.Nn.MX = false;
        }

        public final void ar(View view) {
            this.Nn.Nj = null;
            this.Nn.MX = false;
        }
    };
    private final Runnable Nl = new Runnable(this) {
        final /* synthetic */ ActionBarOverlayLayout Nn;

        {
            this.Nn = r1;
        }

        public final void run() {
            this.Nn.dT();
            this.Nn.Nj = z.U(this.Nn.MS).s(0.0f).a(this.Nn.Nk);
        }
    };
    private final Runnable Nm = new Runnable(this) {
        final /* synthetic */ ActionBarOverlayLayout Nn;

        {
            this.Nn = r1;
        }

        public final void run() {
            this.Nn.dT();
            this.Nn.Nj = z.U(this.Nn.MS).s((float) (-this.Nn.MS.getHeight())).a(this.Nn.Nk);
        }
    };

    public static class LayoutParams extends MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface a {
        void db();

        void dc();

        void dd();

        void onWindowVisibilityChanged(int i);

        void z(boolean z);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
        this.Du = new s(this);
    }

    private void init(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(yd);
        this.MP = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.MT = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.MT == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.MU = z;
        this.Ni = q.a(context, null);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dT();
    }

    public static void dQ() {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        init(getContext());
        z.Y(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        dR();
        int i2 = this.MZ ^ i;
        this.MZ = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.Ng != null) {
            a aVar = this.Ng;
            if (z) {
                z2 = false;
            }
            aVar.z(z2);
            if (z3 || !z) {
                this.Ng.db();
            } else {
                this.Ng.dc();
            }
        }
        if ((i2 & 256) != 0 && this.Ng != null) {
            z.Y(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.MQ = i;
        if (this.Ng != null) {
            this.Ng.onWindowVisibilityChanged(i);
        }
    }

    private static boolean a(View view, Rect rect, boolean z) {
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z2 = true;
        }
        if (layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z2 = true;
        }
        if (layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z2 = true;
        }
        if (!z || layoutParams.bottomMargin == rect.bottom) {
            return z2;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        dR();
        z.X(this);
        boolean a = a(this.MS, rect, false);
        this.Nd.set(rect);
        at.a(this, this.Nd, this.Na);
        if (!this.Nb.equals(this.Na)) {
            this.Nb.set(this.Na);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        dR();
        measureChildWithMargins(this.MS, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.MS.getLayoutParams();
        int max = Math.max(0, (this.MS.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + (this.MS.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates = at.combineMeasuredStates(0, z.M(this.MS));
        boolean z = (z.X(this) & 256) != 0;
        if (z) {
            i3 = this.MP;
            if (this.MW && this.MS.Mz != null) {
                i3 += this.MP;
            }
        } else {
            i3 = this.MS.getVisibility() != 8 ? this.MS.getMeasuredHeight() : 0;
        }
        this.Nc.set(this.Na);
        this.Ne.set(this.Nd);
        Rect rect;
        Rect rect2;
        if (this.MV || z) {
            rect = this.Ne;
            rect.top = i3 + rect.top;
            rect2 = this.Ne;
            rect2.bottom += 0;
        } else {
            rect = this.Nc;
            rect.top = i3 + rect.top;
            rect2 = this.Nc;
            rect2.bottom += 0;
        }
        a(this.MR, this.Nc, true);
        if (!this.Nf.equals(this.Ne)) {
            this.Nf.set(this.Ne);
            this.MR.e(this.Ne);
        }
        measureChildWithMargins(this.MR, i, 0, i2, 0);
        layoutParams = (LayoutParams) this.MR.getLayoutParams();
        int max3 = Math.max(max, (this.MR.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        i3 = Math.max(max2, layoutParams.bottomMargin + (this.MR.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates2 = at.combineMeasuredStates(combineMeasuredStates, z.M(this.MR));
        setMeasuredDimension(z.resolveSizeAndState(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, combineMeasuredStates2), z.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i7);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.MT != null && !this.MU) {
            int bottom = this.MS.getVisibility() == 0 ? (int) ((((float) this.MS.getBottom()) + z.R(this.MS)) + 0.5f) : 0;
            this.MT.setBounds(0, bottom, getWidth(), this.MT.getIntrinsicHeight() + bottom);
            this.MT.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.MS.getVisibility() != 0) {
            return false;
        }
        return this.IM;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.Du.xA = i;
        this.MY = dS();
        dT();
        if (this.Ng != null) {
            this.Ng.dd();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.MY += i2;
        aG(this.MY);
    }

    public void onStopNestedScroll(View view) {
        if (this.IM && !this.MX) {
            if (this.MY <= this.MS.getHeight()) {
                dT();
                postDelayed(this.Nl, 600);
                return;
            }
            dT();
            postDelayed(this.Nm, 600);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2 = false;
        if (!this.IM || !z) {
            return false;
        }
        this.Ni.b(0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.Ni.getFinalY() > this.MS.getHeight()) {
            z2 = true;
        }
        if (z2) {
            dT();
            this.Nm.run();
        } else {
            dT();
            this.Nl.run();
        }
        this.MX = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.Du.xA;
    }

    private void dR() {
        if (this.MR == null) {
            u uVar;
            this.MR = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.MS = (ActionBarContainer) findViewById(f.action_bar_container);
            View findViewById = findViewById(f.action_bar);
            if (findViewById instanceof u) {
                uVar = (u) findViewById;
            } else if (findViewById instanceof Toolbar) {
                uVar = ((Toolbar) findViewById).gY();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of " + findViewById.getClass().getSimpleName());
            }
            this.HT = uVar;
        }
    }

    public final void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.IM) {
            this.IM = z;
            if (!z) {
                dT();
                aG(0);
            }
        }
    }

    public final int dS() {
        return this.MS != null ? -((int) z.R(this.MS)) : 0;
    }

    private void aG(int i) {
        dT();
        z.c(this.MS, (float) (-Math.max(0, Math.min(i, this.MS.getHeight()))));
    }

    private void dT() {
        removeCallbacks(this.Nl);
        removeCallbacks(this.Nm);
        if (this.Nj != null) {
            this.Nj.cancel();
        }
    }

    public final void b(Callback callback) {
        dR();
        this.HT.b(callback);
    }

    public final void e(CharSequence charSequence) {
        dR();
        this.HT.e(charSequence);
    }

    public final void aH(int i) {
        boolean z = true;
        dR();
        switch (i) {
            case 109:
                this.MV = true;
                if (getContext().getApplicationInfo().targetSdkVersion >= 19) {
                    z = false;
                }
                this.MU = z;
                return;
            default:
                return;
        }
    }

    public final boolean dU() {
        dR();
        return this.HT.dU();
    }

    public final boolean isOverflowMenuShowing() {
        dR();
        return this.HT.isOverflowMenuShowing();
    }

    public final boolean dV() {
        dR();
        return this.HT.dV();
    }

    public final boolean showOverflowMenu() {
        dR();
        return this.HT.showOverflowMenu();
    }

    public final boolean hideOverflowMenu() {
        dR();
        return this.HT.hideOverflowMenu();
    }

    public final void dW() {
        dR();
        this.HT.dW();
    }

    public final void a(Menu menu, android.support.v7.view.menu.l.a aVar) {
        dR();
        this.HT.a(menu, aVar);
    }

    public final void dX() {
        dR();
        this.HT.dismissPopupMenus();
    }
}

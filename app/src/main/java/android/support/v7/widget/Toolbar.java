package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.m;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.support.v7.view.c;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.p;
import android.support.v7.widget.ActionMenuView.d;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import org.xwalk.core.R$styleable;

public class Toolbar extends ViewGroup {
    private Context Mn;
    ActionMenuView Mo;
    private boolean Ms;
    private boolean Mt;
    private int NP;
    android.support.v7.view.menu.l.a NR;
    android.support.v7.view.menu.f.a NS;
    private final h Pc;
    private CharSequence ZA;
    private ImageButton ZB;
    View ZC;
    int ZD;
    int ZE;
    private int ZF;
    private int ZG;
    private int ZH;
    private int ZI;
    private int ZJ;
    private int ZK;
    final ag ZL;
    public CharSequence ZM;
    CharSequence ZN;
    private int ZO;
    private int ZP;
    private final ArrayList<View> ZQ;
    final ArrayList<View> ZR;
    private final int[] ZS;
    public b ZT;
    private final d ZU;
    private aq ZV;
    private ActionMenuPresenter ZW;
    a ZX;
    boolean ZY;
    private final Runnable ZZ;
    TextView Zv;
    TextView Zw;
    private ImageButton Zx;
    private ImageView Zy;
    private Drawable Zz;
    private int ug;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aad;
        boolean aae;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.aad = parcel.readInt();
            this.aae = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aad);
            parcel.writeInt(this.aae ? 1 : 0);
        }
    }

    public interface b {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        int aac;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.aac = 0;
        }

        public LayoutParams() {
            super(-2, -2);
            this.aac = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.aac = 0;
            this.aac = layoutParams.aac;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.aac = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.aac = 0;
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.aac = 0;
        }
    }

    private class a implements l {
        final /* synthetic */ Toolbar aaa;
        h aab;
        f eg;

        private a(Toolbar toolbar) {
            this.aaa = toolbar;
        }

        public final void a(Context context, f fVar) {
            if (!(this.eg == null || this.aab == null)) {
                this.eg.h(this.aab);
            }
            this.eg = fVar;
        }

        public final void f(boolean z) {
            Object obj = null;
            if (this.aab != null) {
                if (this.eg != null) {
                    int size = this.eg.size();
                    for (int i = 0; i < size; i++) {
                        if (this.eg.getItem(i) == this.aab) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    c(this.aab);
                }
            }
        }

        public final boolean a(p pVar) {
            return false;
        }

        public final void a(f fVar, boolean z) {
        }

        public final boolean D() {
            return false;
        }

        public final boolean b(h hVar) {
            Toolbar.b(this.aaa);
            if (this.aaa.ZB.getParent() != this.aaa) {
                this.aaa.addView(this.aaa.ZB);
            }
            this.aaa.ZC = hVar.getActionView();
            this.aab = hVar;
            if (this.aaa.ZC.getParent() != this.aaa) {
                android.view.ViewGroup.LayoutParams gX = Toolbar.gX();
                gX.gravity = 8388611 | (this.aaa.ZF & MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
                gX.aac = 2;
                this.aaa.ZC.setLayoutParams(gX);
                this.aaa.addView(this.aaa.ZC);
            }
            Toolbar toolbar = this.aaa;
            for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = toolbar.getChildAt(childCount);
                if (!(((LayoutParams) childAt.getLayoutParams()).aac == 2 || childAt == toolbar.Mo)) {
                    toolbar.removeViewAt(childCount);
                    toolbar.ZR.add(childAt);
                }
            }
            this.aaa.requestLayout();
            hVar.H(true);
            if (this.aaa.ZC instanceof c) {
                ((c) this.aaa.ZC).onActionViewExpanded();
            }
            return true;
        }

        public final boolean c(h hVar) {
            if (this.aaa.ZC instanceof c) {
                ((c) this.aaa.ZC).onActionViewCollapsed();
            }
            this.aaa.removeView(this.aaa.ZC);
            this.aaa.removeView(this.aaa.ZB);
            this.aaa.ZC = null;
            Toolbar toolbar = this.aaa;
            for (int size = toolbar.ZR.size() - 1; size >= 0; size--) {
                toolbar.addView((View) toolbar.ZR.get(size));
            }
            toolbar.ZR.clear();
            this.aab = null;
            this.aaa.requestLayout();
            hVar.H(false);
            return true;
        }

        public final int getId() {
            return 0;
        }

        public final Parcelable onSaveInstanceState() {
            return null;
        }

        public final void onRestoreInstanceState(Parcelable parcelable) {
        }
    }

    static /* synthetic */ void b(Toolbar toolbar) {
        if (toolbar.ZB == null) {
            toolbar.ZB = new ImageButton(toolbar.getContext(), null, android.support.v7.a.a.a.toolbarNavigationButtonStyle);
            toolbar.ZB.setImageDrawable(toolbar.Zz);
            toolbar.ZB.setContentDescription(toolbar.ZA);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388611 | (toolbar.ZF & MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
            layoutParams.aac = 2;
            toolbar.ZB.setLayoutParams(layoutParams);
            toolbar.ZB.setOnClickListener(new OnClickListener(toolbar) {
                final /* synthetic */ Toolbar aaa;

                {
                    this.aaa = r1;
                }

                public final void onClick(View view) {
                    this.aaa.collapseActionView();
                }
            });
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return f(layoutParams);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ZL = new ag();
        this.ug = 8388627;
        this.ZQ = new ArrayList();
        this.ZR = new ArrayList();
        this.ZS = new int[2];
        this.ZU = new d(this) {
            final /* synthetic */ Toolbar aaa;

            {
                this.aaa = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.aaa.ZT != null) {
                    return this.aaa.ZT.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.ZZ = new Runnable(this) {
            final /* synthetic */ Toolbar aaa;

            {
                this.aaa = r1;
            }

            public final void run() {
                this.aaa.showOverflowMenu();
            }
        };
        ap a = ap.a(getContext(), attributeSet, k.Toolbar, i);
        this.ZD = a.getResourceId(k.Toolbar_titleTextAppearance, 0);
        this.ZE = a.getResourceId(k.Toolbar_subtitleTextAppearance, 0);
        this.ug = a.Zu.getInteger(k.Toolbar_android_gravity, this.ug);
        this.ZF = 48;
        int dimensionPixelOffset = a.getDimensionPixelOffset(k.Toolbar_titleMargins, 0);
        this.ZK = dimensionPixelOffset;
        this.ZJ = dimensionPixelOffset;
        this.ZI = dimensionPixelOffset;
        this.ZH = dimensionPixelOffset;
        dimensionPixelOffset = a.getDimensionPixelOffset(k.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset >= 0) {
            this.ZH = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(k.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset >= 0) {
            this.ZI = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(k.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset >= 0) {
            this.ZJ = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(k.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset >= 0) {
            this.ZK = dimensionPixelOffset;
        }
        this.ZG = a.getDimensionPixelSize(k.Toolbar_maxButtonHeight, -1);
        dimensionPixelOffset = a.getDimensionPixelOffset(k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset2 = a.getDimensionPixelOffset(k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = a.getDimensionPixelSize(k.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = a.getDimensionPixelSize(k.Toolbar_contentInsetRight, 0);
        ag agVar = this.ZL;
        agVar.Wz = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            agVar.Wx = dimensionPixelSize;
            agVar.Wu = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            agVar.Wy = dimensionPixelSize2;
            agVar.Wv = dimensionPixelSize2;
        }
        if (!(dimensionPixelOffset == Integer.MIN_VALUE && dimensionPixelOffset2 == Integer.MIN_VALUE)) {
            this.ZL.ag(dimensionPixelOffset, dimensionPixelOffset2);
        }
        this.Zz = a.getDrawable(k.Toolbar_collapseIcon);
        this.ZA = a.getText(k.Toolbar_collapseContentDescription);
        CharSequence text = a.getText(k.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        text = a.getText(k.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text)) {
            setSubtitle(text);
        }
        this.Mn = getContext();
        setPopupTheme(a.getResourceId(k.Toolbar_popupTheme, 0));
        Drawable drawable = a.getDrawable(k.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        text = a.getText(k.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text)) {
            setNavigationContentDescription(text);
        }
        drawable = a.getDrawable(k.Toolbar_logo);
        if (drawable != null) {
            setLogo(drawable);
        }
        text = a.getText(k.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text)) {
            if (!TextUtils.isEmpty(text)) {
                gU();
            }
            if (this.Zy != null) {
                this.Zy.setContentDescription(text);
            }
        }
        if (a.hasValue(k.Toolbar_titleTextColor)) {
            dimensionPixelOffset = a.bO(k.Toolbar_titleTextColor);
            this.ZO = dimensionPixelOffset;
            if (this.Zv != null) {
                this.Zv.setTextColor(dimensionPixelOffset);
            }
        }
        if (a.hasValue(k.Toolbar_subtitleTextColor)) {
            dimensionPixelOffset = a.bO(k.Toolbar_subtitleTextColor);
            this.ZP = dimensionPixelOffset;
            if (this.Zw != null) {
                this.Zw.setTextColor(dimensionPixelOffset);
            }
        }
        a.Zu.recycle();
        this.Pc = h.ey();
    }

    public final void setPopupTheme(int i) {
        if (this.NP != i) {
            this.NP = i;
            if (i == 0) {
                this.Mn = getContext();
            } else {
                this.Mn = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ag agVar = this.ZL;
        if (i != 1) {
            z = false;
        }
        if (z != agVar.gl) {
            agVar.gl = z;
            if (!agVar.Wz) {
                agVar.Wu = agVar.Wx;
                agVar.Wv = agVar.Wy;
            } else if (z) {
                agVar.Wu = agVar.wq != Integer.MIN_VALUE ? agVar.wq : agVar.Wx;
                agVar.Wv = agVar.Ww != Integer.MIN_VALUE ? agVar.Ww : agVar.Wy;
            } else {
                agVar.Wu = agVar.Ww != Integer.MIN_VALUE ? agVar.Ww : agVar.Wx;
                agVar.Wv = agVar.wq != Integer.MIN_VALUE ? agVar.wq : agVar.Wy;
            }
        }
    }

    public final boolean isOverflowMenuShowing() {
        if (this.Mo != null) {
            ActionMenuView actionMenuView = this.Mo;
            boolean z = actionMenuView.NQ != null && actionMenuView.NQ.isOverflowMenuShowing();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean showOverflowMenu() {
        if (this.Mo != null) {
            ActionMenuView actionMenuView = this.Mo;
            boolean z = actionMenuView.NQ != null && actionMenuView.NQ.showOverflowMenu();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void a(f fVar, ActionMenuPresenter actionMenuPresenter) {
        if (fVar != null || this.Mo != null) {
            gV();
            f fVar2 = this.Mo.eg;
            if (fVar2 != fVar) {
                if (fVar2 != null) {
                    fVar2.b(this.ZW);
                    fVar2.b(this.ZX);
                }
                if (this.ZX == null) {
                    this.ZX = new a();
                }
                actionMenuPresenter.Nz = true;
                if (fVar != null) {
                    fVar.a((l) actionMenuPresenter, this.Mn);
                    fVar.a(this.ZX, this.Mn);
                } else {
                    actionMenuPresenter.a(this.Mn, null);
                    this.ZX.a(this.Mn, null);
                    actionMenuPresenter.f(true);
                    this.ZX.f(true);
                }
                this.Mo.setPopupTheme(this.NP);
                this.Mo.a(actionMenuPresenter);
                this.ZW = actionMenuPresenter;
            }
        }
    }

    public final void setLogo(Drawable drawable) {
        if (drawable != null) {
            gU();
            if (!bu(this.Zy)) {
                e(this.Zy, true);
            }
        } else if (this.Zy != null && bu(this.Zy)) {
            removeView(this.Zy);
            this.ZR.remove(this.Zy);
        }
        if (this.Zy != null) {
            this.Zy.setImageDrawable(drawable);
        }
    }

    private void gU() {
        if (this.Zy == null) {
            this.Zy = new ImageView(getContext());
        }
    }

    public final void collapseActionView() {
        h hVar = this.ZX == null ? null : this.ZX.aab;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    public final void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.Zv == null) {
                Context context = getContext();
                this.Zv = new TextView(context);
                this.Zv.setSingleLine();
                this.Zv.setEllipsize(TruncateAt.END);
                if (this.ZD != 0) {
                    this.Zv.setTextAppearance(context, this.ZD);
                }
                if (this.ZO != 0) {
                    this.Zv.setTextColor(this.ZO);
                }
            }
            if (!bu(this.Zv)) {
                e(this.Zv, true);
            }
        } else if (this.Zv != null && bu(this.Zv)) {
            removeView(this.Zv);
            this.ZR.remove(this.Zv);
        }
        if (this.Zv != null) {
            this.Zv.setText(charSequence);
        }
        this.ZM = charSequence;
    }

    public final void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.Zw == null) {
                Context context = getContext();
                this.Zw = new TextView(context);
                this.Zw.setSingleLine();
                this.Zw.setEllipsize(TruncateAt.END);
                if (this.ZE != 0) {
                    this.Zw.setTextAppearance(context, this.ZE);
                }
                if (this.ZP != 0) {
                    this.Zw.setTextColor(this.ZP);
                }
            }
            if (!bu(this.Zw)) {
                e(this.Zw, true);
            }
        } else if (this.Zw != null && bu(this.Zw)) {
            removeView(this.Zw);
            this.ZR.remove(this.Zw);
        }
        if (this.Zw != null) {
            this.Zw.setText(charSequence);
        }
        this.ZN = charSequence;
    }

    public final CharSequence getNavigationContentDescription() {
        return this.Zx != null ? this.Zx.getContentDescription() : null;
    }

    public final void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            gW();
        }
        if (this.Zx != null) {
            this.Zx.setContentDescription(charSequence);
        }
    }

    public final void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            gW();
            if (!bu(this.Zx)) {
                e(this.Zx, true);
            }
        } else if (this.Zx != null && bu(this.Zx)) {
            removeView(this.Zx);
            this.ZR.remove(this.Zx);
        }
        if (this.Zx != null) {
            this.Zx.setImageDrawable(drawable);
        }
    }

    public final Drawable getNavigationIcon() {
        return this.Zx != null ? this.Zx.getDrawable() : null;
    }

    public final void setNavigationOnClickListener(OnClickListener onClickListener) {
        gW();
        this.Zx.setOnClickListener(onClickListener);
    }

    public final Menu getMenu() {
        gV();
        if (this.Mo.eg == null) {
            f fVar = (f) this.Mo.getMenu();
            if (this.ZX == null) {
                this.ZX = new a();
            }
            this.Mo.NQ.Nz = true;
            fVar.a(this.ZX, this.Mn);
        }
        return this.Mo.getMenu();
    }

    private void gV() {
        if (this.Mo == null) {
            this.Mo = new ActionMenuView(getContext());
            this.Mo.setPopupTheme(this.NP);
            this.Mo.NW = this.ZU;
            this.Mo.a(this.NR, this.NS);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388613 | (this.ZF & MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
            this.Mo.setLayoutParams(layoutParams);
            e(this.Mo, false);
        }
    }

    private void gW() {
        if (this.Zx == null) {
            this.Zx = new ImageButton(getContext(), null, android.support.v7.a.a.a.toolbarNavigationButtonStyle);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388611 | (this.ZF & MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
            this.Zx.setLayoutParams(layoutParams);
        }
    }

    private void e(View view, boolean z) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams();
        } else if (checkLayoutParams(layoutParams)) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        } else {
            layoutParams = f(layoutParams);
        }
        layoutParams.aac = 1;
        if (!z || this.ZC == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.ZR.add(view);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.ZX == null || this.ZX.aab == null)) {
            savedState.aad = this.ZX.aab.getItemId();
        }
        savedState.aae = isOverflowMenuShowing();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            Menu menu = this.Mo != null ? this.Mo.eg : null;
            if (!(savedState.aad == 0 || this.ZX == null || menu == null)) {
                MenuItem findItem = menu.findItem(savedState.aad);
                if (findItem != null) {
                    m.b(findItem);
                }
            }
            if (savedState.aae) {
                removeCallbacks(this.ZZ);
                post(this.ZZ);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.ZZ);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 0) {
            this.Ms = false;
        }
        if (!this.Ms) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (d == 0 && !onTouchEvent) {
                this.Ms = true;
            }
        }
        if (d == 1 || d == 3) {
            this.Ms = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 9) {
            this.Mt = false;
        }
        if (!this.Mt) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (d == 9 && !onHoverEvent) {
                this.Mt = true;
            }
        }
        if (d == 10 || d == 3) {
            this.Mt = false;
        }
        return true;
    }

    private void i(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + 0, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int combineMeasuredStates;
        int i5;
        Object obj;
        int[] iArr = this.ZS;
        if (at.bv(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i6 = 0;
        if (br(this.Zx)) {
            i(this.Zx, i, 0, i2, this.ZG);
            i6 = this.Zx.getMeasuredWidth() + bs(this.Zx);
            max = Math.max(0, this.Zx.getMeasuredHeight() + bt(this.Zx));
            combineMeasuredStates = at.combineMeasuredStates(0, z.M(this.Zx));
            i5 = max;
        } else {
            combineMeasuredStates = 0;
            i5 = 0;
        }
        if (br(this.ZB)) {
            i(this.ZB, i, 0, i2, this.ZG);
            i6 = this.ZB.getMeasuredWidth() + bs(this.ZB);
            i5 = Math.max(i5, this.ZB.getMeasuredHeight() + bt(this.ZB));
            combineMeasuredStates = at.combineMeasuredStates(combineMeasuredStates, z.M(this.ZB));
        }
        ag agVar = this.ZL;
        int i7 = agVar.gl ? agVar.Wv : agVar.Wu;
        int max2 = Math.max(i7, i6) + 0;
        iArr[i4] = Math.max(0, i7 - i6);
        i6 = 0;
        if (br(this.Mo)) {
            i(this.Mo, i, max2, i2, this.ZG);
            i6 = this.Mo.getMeasuredWidth() + bs(this.Mo);
            i5 = Math.max(i5, this.Mo.getMeasuredHeight() + bt(this.Mo));
            combineMeasuredStates = at.combineMeasuredStates(combineMeasuredStates, z.M(this.Mo));
        }
        agVar = this.ZL;
        i7 = agVar.gl ? agVar.Wu : agVar.Wv;
        max2 += Math.max(i7, i6);
        iArr[i3] = Math.max(0, i7 - i6);
        if (br(this.ZC)) {
            max2 += a(this.ZC, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.ZC.getMeasuredHeight() + bt(this.ZC));
            combineMeasuredStates = at.combineMeasuredStates(combineMeasuredStates, z.M(this.ZC));
        }
        if (br(this.Zy)) {
            max2 += a(this.Zy, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.Zy.getMeasuredHeight() + bt(this.Zy));
            combineMeasuredStates = at.combineMeasuredStates(combineMeasuredStates, z.M(this.Zy));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = combineMeasuredStates;
        int i9 = i5;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).aac == 0 && br(childAt)) {
                max2 += a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i9, childAt.getMeasuredHeight() + bt(childAt));
                i6 = at.combineMeasuredStates(i8, z.M(childAt));
                i7 = max;
            } else {
                i6 = i8;
                i7 = i9;
            }
            i3++;
            i8 = i6;
            i9 = i7;
        }
        i7 = 0;
        i6 = 0;
        int i10 = this.ZJ + this.ZK;
        max = this.ZH + this.ZI;
        if (br(this.Zv)) {
            a(this.Zv, i, max2 + max, i2, i10, iArr);
            i7 = bs(this.Zv) + this.Zv.getMeasuredWidth();
            i6 = this.Zv.getMeasuredHeight() + bt(this.Zv);
            i8 = at.combineMeasuredStates(i8, z.M(this.Zv));
        }
        if (br(this.Zw)) {
            i7 = Math.max(i7, a(this.Zw, i, max2 + max, i2, i10 + i6, iArr));
            i6 += this.Zw.getMeasuredHeight() + bt(this.Zw);
            i8 = at.combineMeasuredStates(i8, z.M(this.Zw));
        }
        i6 = Math.max(i9, i6) + (getPaddingTop() + getPaddingBottom());
        max = z.resolveSizeAndState(Math.max((i7 + max2) + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, WebView.NIGHT_MODE_COLOR & i8);
        i6 = z.resolveSizeAndState(Math.max(i6, getSuggestedMinimumHeight()), i2, i8 << 16);
        if (this.ZY) {
            max2 = getChildCount();
            for (i7 = 0; i7 < max2; i7++) {
                View childAt2 = getChildAt(i7);
                if (br(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i6 = 0;
        }
        setMeasuredDimension(max, i6);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int paddingTop;
        int measuredWidth;
        if (z.I(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.ZS;
        iArr[1] = 0;
        iArr[0] = 0;
        int T = z.T(this);
        if (!br(this.Zx)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = b(this.Zx, i8, iArr, T);
            i5 = paddingLeft;
        } else {
            i5 = a(this.Zx, paddingLeft, iArr, T);
        }
        if (br(this.ZB)) {
            if (obj != null) {
                i8 = b(this.ZB, i8, iArr, T);
            } else {
                i5 = a(this.ZB, i5, iArr, T);
            }
        }
        if (br(this.Mo)) {
            if (obj != null) {
                i5 = a(this.Mo, i5, iArr, T);
            } else {
                i8 = b(this.Mo, i8, iArr, T);
            }
        }
        iArr[0] = Math.max(0, this.ZL.Wu - i5);
        iArr[1] = Math.max(0, this.ZL.Wv - ((width - paddingRight) - i8));
        i5 = Math.max(i5, this.ZL.Wu);
        i8 = Math.min(i8, (width - paddingRight) - this.ZL.Wv);
        if (br(this.ZC)) {
            if (obj != null) {
                i8 = b(this.ZC, i8, iArr, T);
            } else {
                i5 = a(this.ZC, i5, iArr, T);
            }
        }
        if (!br(this.Zy)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = b(this.Zy, i8, iArr, T);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = a(this.Zy, i5, iArr, T);
        }
        boolean br = br(this.Zv);
        boolean br2 = br(this.Zw);
        i5 = 0;
        if (br) {
            LayoutParams layoutParams = (LayoutParams) this.Zv.getLayoutParams();
            i5 = (layoutParams.bottomMargin + (layoutParams.topMargin + this.Zv.getMeasuredHeight())) + 0;
        }
        if (br2) {
            layoutParams = (LayoutParams) this.Zw.getLayoutParams();
            measuredHeight = (layoutParams.bottomMargin + (layoutParams.topMargin + this.Zw.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (br || br2) {
            layoutParams = (LayoutParams) (br ? this.Zv : this.Zw).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) (br2 ? this.Zw : this.Zv).getLayoutParams();
            Object obj2 = ((!br || this.Zv.getMeasuredWidth() <= 0) && (!br2 || this.Zw.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    paddingTop = (layoutParams.topMargin + getPaddingTop()) + this.ZJ;
                    break;
                case 80:
                    paddingTop = (((height - paddingBottom) - layoutParams2.bottomMargin) - this.ZK) - measuredHeight;
                    break;
                default:
                    paddingTop = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop < layoutParams.topMargin + this.ZJ) {
                        i8 = layoutParams.topMargin + this.ZJ;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop) - paddingTop2;
                        if (measuredHeight < layoutParams.bottomMargin + this.ZK) {
                            i8 = Math.max(0, paddingTop - ((layoutParams2.bottomMargin + this.ZK) - measuredHeight));
                        } else {
                            i8 = paddingTop;
                        }
                    }
                    paddingTop = paddingTop2 + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.ZH : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (br) {
                    layoutParams = (LayoutParams) this.Zv.getLayoutParams();
                    measuredWidth = i5 - this.Zv.getMeasuredWidth();
                    i6 = this.Zv.getMeasuredHeight() + paddingTop;
                    this.Zv.layout(measuredWidth, paddingTop, i5, i6);
                    paddingTop = i6 + layoutParams.bottomMargin;
                    i6 = measuredWidth - this.ZI;
                } else {
                    i6 = i5;
                }
                if (br2) {
                    layoutParams = (LayoutParams) this.Zw.getLayoutParams();
                    measuredWidth = layoutParams.topMargin + paddingTop;
                    this.Zw.layout(i5 - this.Zw.getMeasuredWidth(), measuredWidth, i5, this.Zw.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i5 - this.ZI;
                    i8 = layoutParams.bottomMargin;
                    i8 = measuredWidth;
                } else {
                    i8 = i5;
                }
                if (obj2 != null) {
                    i8 = Math.min(i6, i8);
                } else {
                    i8 = i5;
                }
                i6 = i8;
            } else {
                i8 = (obj2 != null ? this.ZH : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (br) {
                    layoutParams = (LayoutParams) this.Zv.getLayoutParams();
                    i5 = this.Zv.getMeasuredWidth() + i7;
                    measuredWidth = this.Zv.getMeasuredHeight() + paddingTop;
                    this.Zv.layout(i7, paddingTop, i5, measuredWidth);
                    i8 = layoutParams.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.ZI;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop;
                }
                if (br2) {
                    layoutParams = (LayoutParams) this.Zw.getLayoutParams();
                    i5 += layoutParams.topMargin;
                    paddingTop = this.Zw.getMeasuredWidth() + i7;
                    this.Zw.layout(i7, i5, paddingTop, this.Zw.getMeasuredHeight() + i5);
                    i5 = this.ZI + paddingTop;
                    i8 = layoutParams.bottomMargin;
                    i8 = i5;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        a(this.ZQ, 3);
        int size = this.ZQ.size();
        measuredWidth = i7;
        for (i5 = 0; i5 < size; i5++) {
            measuredWidth = a((View) this.ZQ.get(i5), measuredWidth, iArr, T);
        }
        a(this.ZQ, 5);
        i7 = this.ZQ.size();
        i5 = 0;
        measuredHeight = i6;
        while (i5 < i7) {
            i6 = b((View) this.ZQ.get(i5), measuredHeight, iArr, T);
            i5++;
            measuredHeight = i6;
        }
        a(this.ZQ, 1);
        List list = this.ZQ;
        i6 = iArr[0];
        i7 = iArr[1];
        paddingTop2 = list.size();
        size = i6;
        paddingTop = i7;
        i6 = 0;
        i7 = 0;
        while (i6 < paddingTop2) {
            View view = (View) list.get(i6);
            layoutParams = (LayoutParams) view.getLayoutParams();
            size = layoutParams.leftMargin - size;
            i8 = layoutParams.rightMargin - paddingTop;
            paddingBottom = Math.max(0, size);
            int max = Math.max(0, i8);
            size = Math.max(0, -size);
            paddingTop = Math.max(0, -i8);
            i6++;
            i7 += (view.getMeasuredWidth() + paddingBottom) + max;
        }
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (i7 / 2);
        i5 = i8 + i7;
        if (i8 < measuredWidth) {
            i8 = measuredWidth;
        } else if (i5 > measuredHeight) {
            i8 -= i5 - measuredHeight;
        }
        paddingLeft = this.ZQ.size();
        measuredWidth = 0;
        i5 = i8;
        while (measuredWidth < paddingLeft) {
            i8 = a((View) this.ZQ.get(measuredWidth), i5, iArr, T);
            measuredWidth++;
            i5 = i8;
        }
        this.ZQ.clear();
    }

    private int a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = p(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    private int b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = p(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int p(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        switch (i3) {
            case 16:
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
            case 80:
                break;
            default:
                i3 = this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                break;
        }
        switch (i3) {
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int i4;
                i3 = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - i3) - paddingBottom) - measuredHeight) / 2;
                if (i2 < layoutParams.topMargin) {
                    i4 = layoutParams.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - i3;
                    i4 = measuredHeight < layoutParams.bottomMargin ? Math.max(0, i2 - (layoutParams.bottomMargin - measuredHeight)) : i2;
                }
                return i4 + i3;
        }
    }

    private void a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (z.I(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(i, z.I(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.aac == 0 && br(childAt) && bP(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.aac == 0 && br(childAt2) && bP(layoutParams.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int bP(int i) {
        int I = z.I(this);
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(i, I) & 7;
        switch (absoluteGravity) {
            case 1:
            case 3:
            case 5:
                return absoluteGravity;
            default:
                return I == 1 ? 5 : 3;
        }
    }

    private boolean br(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private static int bs(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return android.support.v4.view.l.b(marginLayoutParams) + android.support.v4.view.l.a(marginLayoutParams);
    }

    private static int bt(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private static LayoutParams f(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams) {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected static LayoutParams gX() {
        return new LayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public final u gY() {
        if (this.ZV == null) {
            this.ZV = new aq(this, true);
        }
        return this.ZV;
    }

    private boolean bu(View view) {
        return view.getParent() == this || this.ZR.contains(view);
    }
}

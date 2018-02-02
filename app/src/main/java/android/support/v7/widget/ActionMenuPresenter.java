package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ae;
import android.support.v7.a.a.g;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.k;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.p;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

final class ActionMenuPresenter extends android.support.v7.view.menu.b implements android.support.v4.view.d.a {
    private int NA;
    private final SparseBooleanArray NB = new SparseBooleanArray();
    private View NC;
    e ND;
    a NE;
    c NF;
    private b NG;
    final f NH = new f();
    int NI;
    d No;
    private Drawable Np;
    private boolean Nq;
    private boolean Nr;
    private boolean Ns;
    private int Nt;
    private int Nu;
    int Nv;
    boolean Nw;
    private boolean Nx;
    private boolean Ny;
    boolean Nz;

    private static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int NO;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.NO = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.NO);
        }
    }

    private class c implements Runnable {
        final /* synthetic */ ActionMenuPresenter NJ;
        private e NK;

        public c(ActionMenuPresenter actionMenuPresenter, e eVar) {
            this.NJ = actionMenuPresenter;
            this.NK = eVar;
        }

        public final void run() {
            android.support.v7.view.menu.f fVar = this.NJ.eg;
            if (fVar.Lh != null) {
                fVar.Lh.b(fVar);
            }
            View view = (View) this.NJ.KL;
            if (!(view == null || view.getWindowToken() == null || !this.NK.dM())) {
                this.NJ.ND = this.NK;
            }
            this.NJ.NF = null;
        }
    }

    private class b extends android.support.v7.view.menu.ActionMenuItemView.b {
        final /* synthetic */ ActionMenuPresenter NJ;

        private b(ActionMenuPresenter actionMenuPresenter) {
            this.NJ = actionMenuPresenter;
        }

        public final ListPopupWindow dp() {
            return this.NJ.NE != null ? this.NJ.NE.Mc : null;
        }
    }

    private class f implements android.support.v7.view.menu.l.a {
        final /* synthetic */ ActionMenuPresenter NJ;

        private f(ActionMenuPresenter actionMenuPresenter) {
            this.NJ = actionMenuPresenter;
        }

        public final boolean d(android.support.v7.view.menu.f fVar) {
            if (fVar == null) {
                return false;
            }
            this.NJ.NI = ((p) fVar).getItem().getItemId();
            android.support.v7.view.menu.l.a aVar = this.NJ.ef;
            return aVar != null ? aVar.d(fVar) : false;
        }

        public final void a(android.support.v7.view.menu.f fVar, boolean z) {
            if (fVar instanceof p) {
                ((p) fVar).Mk.C(false);
            }
            android.support.v7.view.menu.l.a aVar = this.NJ.ef;
            if (aVar != null) {
                aVar.a(fVar, z);
            }
        }
    }

    private class a extends k {
        private p LD;
        final /* synthetic */ ActionMenuPresenter NJ;

        public a(ActionMenuPresenter actionMenuPresenter, Context context, p pVar) {
            boolean z = false;
            this.NJ = actionMenuPresenter;
            super(context, pVar, null, false, android.support.v7.a.a.a.actionOverflowMenuStyle);
            this.LD = pVar;
            if (!((h) pVar.getItem()).dI()) {
                this.hH = actionMenuPresenter.No == null ? (View) actionMenuPresenter.KL : actionMenuPresenter.No;
            }
            this.LC = actionMenuPresenter.NH;
            int size = pVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = pVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            this.KX = z;
        }

        public final void onDismiss() {
            super.onDismiss();
            this.NJ.NE = null;
            this.NJ.NI = 0;
        }
    }

    private class d extends AppCompatImageView implements android.support.v7.widget.ActionMenuView.a {
        final /* synthetic */ ActionMenuPresenter NJ;
        private final float[] NL = new float[2];

        public d(final ActionMenuPresenter actionMenuPresenter, Context context) {
            this.NJ = actionMenuPresenter;
            super(context, null, android.support.v7.a.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new android.support.v7.widget.ListPopupWindow.b(this, this) {
                final /* synthetic */ d NN;

                public final ListPopupWindow dp() {
                    if (this.NN.NJ.ND == null) {
                        return null;
                    }
                    return this.NN.NJ.ND.Mc;
                }

                public final boolean dq() {
                    this.NN.NJ.showOverflowMenu();
                    return true;
                }

                public final boolean eb() {
                    if (this.NN.NJ.NF != null) {
                        return false;
                    }
                    this.NN.NJ.hideOverflowMenu();
                    return true;
                }
            });
        }

        public final boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.NJ.showOverflowMenu();
            }
            return true;
        }

        public final boolean dn() {
            return false;
        }

        public final boolean do() {
            return false;
        }

        protected final boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.b.a.a.a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    private class e extends k {
        final /* synthetic */ ActionMenuPresenter NJ;

        public e(ActionMenuPresenter actionMenuPresenter, Context context, android.support.v7.view.menu.f fVar, View view) {
            this.NJ = actionMenuPresenter;
            super(context, fVar, view, true, android.support.v7.a.a.a.actionOverflowMenuStyle);
            this.LC = actionMenuPresenter.NH;
        }

        public final void onDismiss() {
            super.onDismiss();
            if (this.NJ.eg != null) {
                this.NJ.eg.close();
            }
            this.NJ.ND = null;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, android.support.v7.a.a.h.abc_action_menu_layout, android.support.v7.a.a.h.abc_action_menu_item_layout);
    }

    public final void a(Context context, android.support.v7.view.menu.f fVar) {
        boolean z = true;
        super.a(context, fVar);
        Resources resources = context.getResources();
        android.support.v7.view.a p = android.support.v7.view.a.p(context);
        if (!this.Ns) {
            if (VERSION.SDK_INT < 19 && ae.b(ViewConfiguration.get(p.mContext))) {
                z = false;
            }
            this.Nr = z;
        }
        if (!this.Ny) {
            this.Nt = p.mContext.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.Nw) {
            this.Nv = p.mContext.getResources().getInteger(g.abc_max_action_buttons);
        }
        int i = this.Nt;
        if (this.Nr) {
            if (this.No == null) {
                this.No = new d(this, this.KH);
                if (this.Nq) {
                    this.No.setImageDrawable(this.Np);
                    this.Np = null;
                    this.Nq = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.No.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.No.getMeasuredWidth();
        } else {
            this.No = null;
        }
        this.Nu = i;
        this.NA = (int) (56.0f * resources.getDisplayMetrics().density);
        this.NC = null;
    }

    public final void dY() {
        this.Nr = true;
        this.Ns = true;
    }

    public final m c(ViewGroup viewGroup) {
        m c = super.c(viewGroup);
        ((ActionMenuView) c).a(this);
        return c;
    }

    public final View a(h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.dL()) {
            actionView = super.a(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.c(layoutParams));
        }
        return actionView;
    }

    public final void a(h hVar, android.support.v7.view.menu.m.a aVar) {
        aVar.a(hVar);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.Ky = (ActionMenuView) this.KL;
        if (this.NG == null) {
            this.NG = new b();
        }
        actionMenuItemView.KA = this.NG;
    }

    public final boolean e(h hVar) {
        return hVar.dI();
    }

    public final void f(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ((View) this.KL).getParent();
        super.f(z);
        ((View) this.KL).requestLayout();
        if (this.eg != null) {
            android.support.v7.view.menu.f fVar = this.eg;
            fVar.dB();
            ArrayList arrayList = fVar.Lk;
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                android.support.v4.view.d dVar = ((h) arrayList.get(i)).LH;
                if (dVar != null) {
                    dVar.wJ = this;
                }
            }
        }
        ArrayList dC = this.eg != null ? this.eg.dC() : null;
        if (this.Nr && dC != null) {
            i = dC.size();
            if (i == 1) {
                int i4;
                if (((h) dC.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.No == null) {
                this.No = new d(this, this.KH);
            }
            ViewGroup viewGroup = (ViewGroup) this.No.getParent();
            if (viewGroup != this.KL) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.No);
                }
                ((ActionMenuView) this.KL).addView(this.No, ActionMenuView.ed());
            }
        } else if (this.No != null && this.No.getParent() == this.KL) {
            ((ViewGroup) this.KL).removeView(this.No);
        }
        ((ActionMenuView) this.KL).Nr = this.Nr;
    }

    public final boolean c(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.No) {
            return false;
        }
        return super.c(viewGroup, i);
    }

    public final boolean a(p pVar) {
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        View view;
        p pVar2 = pVar;
        while (pVar2.Mk != this.eg) {
            pVar2 = (p) pVar2.Mk;
        }
        h item = pVar2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.KL;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof android.support.v7.view.menu.m.a) && ((android.support.v7.view.menu.m.a) childAt).B() == item) {
                    view = childAt;
                    break;
                }
            }
        }
        view = null;
        if (view == null) {
            if (this.No == null) {
                return false;
            }
            view = this.No;
        }
        this.NI = pVar.getItem().getItemId();
        this.NE = new a(this, this.mContext, pVar);
        this.NE.hH = view;
        if (this.NE.dM()) {
            super.a(pVar);
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public final boolean showOverflowMenu() {
        if (!this.Nr || isOverflowMenuShowing() || this.eg == null || this.KL == null || this.NF != null || this.eg.dC().isEmpty()) {
            return false;
        }
        this.NF = new c(this, new e(this, this.mContext, this.eg, this.No));
        ((View) this.KL).post(this.NF);
        super.a(null);
        return true;
    }

    public final boolean hideOverflowMenu() {
        if (this.NF == null || this.KL == null) {
            k kVar = this.ND;
            if (kVar == null) {
                return false;
            }
            kVar.dismiss();
            return true;
        }
        ((View) this.KL).removeCallbacks(this.NF);
        this.NF = null;
        return true;
    }

    public final boolean dZ() {
        return hideOverflowMenu() | ea();
    }

    public final boolean ea() {
        if (this.NE == null) {
            return false;
        }
        this.NE.dismiss();
        return true;
    }

    public final boolean isOverflowMenuShowing() {
        return this.ND != null && this.ND.isShowing();
    }

    public final boolean D() {
        int i;
        ArrayList dA = this.eg.dA();
        int size = dA.size();
        int i2 = this.Nv;
        int i3 = this.Nu;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.KL;
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int i6 = 0;
        while (i6 < size) {
            h hVar = (h) dA.get(i6);
            if (hVar.dK()) {
                i4++;
            } else if (hVar.dJ()) {
                i5++;
            } else {
                obj = 1;
            }
            if (this.Nz && hVar.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i2;
            }
            i6++;
            i2 = i;
        }
        if (this.Nr && (r4 != null || i4 + i5 > i2)) {
            i2--;
        }
        i6 = i2 - i4;
        SparseBooleanArray sparseBooleanArray = this.NB;
        sparseBooleanArray.clear();
        if (this.Nx) {
            int i7 = i3 / this.NA;
            i5 = ((i3 % this.NA) / i7) + this.NA;
            i = i7;
        } else {
            i5 = 0;
            i = 0;
        }
        i2 = 0;
        int i8 = 0;
        i4 = i;
        while (i8 < size) {
            h hVar2 = (h) dA.get(i8);
            View a;
            int i9;
            if (hVar2.dK()) {
                a = a(hVar2, this.NC, viewGroup);
                if (this.NC == null) {
                    this.NC = a;
                }
                if (this.Nx) {
                    i = i4 - ActionMenuView.d(a, i5, i4, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                    i = i4;
                }
                i4 = a.getMeasuredWidth();
                i9 = i3 - i4;
                if (i2 != 0) {
                    i4 = i2;
                }
                i2 = hVar2.getGroupId();
                if (i2 != 0) {
                    sparseBooleanArray.put(i2, true);
                }
                hVar2.G(true);
                i7 = i9;
                i2 = i6;
            } else if (hVar2.dJ()) {
                boolean z;
                int groupId = hVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i6 > 0 || z2) && i3 > 0 && (!this.Nx || i4 > 0);
                if (z3) {
                    a = a(hVar2, this.NC, viewGroup);
                    if (this.NC == null) {
                        this.NC = a;
                    }
                    if (this.Nx) {
                        int d = ActionMenuView.d(a, i5, i4, makeMeasureSpec, 0);
                        i4 -= d;
                        if (d == 0) {
                            i = 0;
                        }
                    } else {
                        a.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    i9 = a.getMeasuredWidth();
                    i3 -= i9;
                    if (i2 == 0) {
                        i2 = i9;
                    }
                    if (this.Nx) {
                        z = i & (i3 >= 0 ? 1 : 0);
                        i9 = i4;
                    } else {
                        z = i & (i3 + i2 > 0 ? 1 : 0);
                        i9 = i4;
                    }
                } else {
                    z = z3;
                    i9 = i4;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i = i6;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i4 = i6;
                    for (i6 = 0; i6 < i8; i6++) {
                        hVar = (h) dA.get(i6);
                        if (hVar.getGroupId() == groupId) {
                            if (hVar.dI()) {
                                i4++;
                            }
                            hVar.G(false);
                        }
                    }
                    i = i4;
                } else {
                    i = i6;
                }
                if (z) {
                    i--;
                }
                hVar2.G(z);
                i4 = i2;
                i7 = i3;
                i2 = i;
                i = i9;
            } else {
                hVar2.G(false);
                i = i4;
                i7 = i3;
                i4 = i2;
                i2 = i6;
            }
            i8++;
            i3 = i7;
            i6 = i2;
            i2 = i4;
            i4 = i;
        }
        return true;
    }

    public final void a(android.support.v7.view.menu.f fVar, boolean z) {
        dZ();
        super.a(fVar, z);
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState();
        savedState.NO = this.NI;
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.NO > 0) {
                MenuItem findItem = this.eg.findItem(savedState.NO);
                if (findItem != null) {
                    a((p) findItem.getSubMenu());
                }
            }
        }
    }

    public final void p(boolean z) {
        if (z) {
            super.a(null);
        } else {
            this.eg.C(false);
        }
    }

    public final void a(ActionMenuView actionMenuView) {
        this.KL = actionMenuView;
        actionMenuView.eg = this.eg;
    }
}

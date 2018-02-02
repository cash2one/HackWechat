package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.support.v4.view.m.e;
import android.support.v7.view.menu.m.a;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class h implements b {
    static String LL;
    static String LM;
    static String LN;
    static String LO;
    private final int Ko;
    private final int Kp;
    final int Kq;
    private CharSequence Kr;
    private Intent Ks;
    private char Kt;
    private char Ku;
    private Drawable Kv;
    private int Kw = 0;
    private OnMenuItemClickListener Kx;
    private p LD;
    private Runnable LE;
    int LF = 0;
    private View LG;
    public d LH;
    private e LI;
    private boolean LJ = false;
    ContextMenuInfo LK;
    f eg;
    private final int mId;
    private CharSequence uU;
    private int ur = 16;

    public final /* synthetic */ MenuItem setActionView(int i) {
        Context context = this.eg.mContext;
        aJ(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public final /* synthetic */ MenuItem setActionView(View view) {
        return aJ(view);
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    h(f fVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.eg = fVar;
        this.mId = i2;
        this.Ko = i;
        this.Kp = i3;
        this.Kq = i4;
        this.uU = charSequence;
        this.LF = i5;
    }

    public final boolean dE() {
        if ((this.Kx != null && this.Kx.onMenuItemClick(this)) || this.eg.b(this.eg.dD(), this)) {
            return true;
        }
        if (this.LE != null) {
            this.LE.run();
            return true;
        }
        if (this.Ks != null) {
            try {
                this.eg.mContext.startActivity(this.Ks);
                return true;
            } catch (ActivityNotFoundException e) {
            }
        }
        if (this.LH == null || !this.LH.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled() {
        return (this.ur & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.ur |= 16;
        } else {
            this.ur &= -17;
        }
        this.eg.h(false);
        return this;
    }

    public final int getGroupId() {
        return this.Ko;
    }

    @CapturedViewProperty
    public final int getItemId() {
        return this.mId;
    }

    public final int getOrder() {
        return this.Kp;
    }

    public final Intent getIntent() {
        return this.Ks;
    }

    public final MenuItem setIntent(Intent intent) {
        this.Ks = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.Ku;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.Ku != c) {
            this.Ku = Character.toLowerCase(c);
            this.eg.h(false);
        }
        return this;
    }

    public final char getNumericShortcut() {
        return this.Kt;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.Kt != c) {
            this.Kt = c;
            this.eg.h(false);
        }
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.Kt = c;
        this.Ku = Character.toLowerCase(c2);
        this.eg.h(false);
        return this;
    }

    final char dF() {
        return this.eg.du() ? this.Ku : this.Kt;
    }

    final boolean dG() {
        return this.eg.dv() && dF() != '\u0000';
    }

    public final SubMenu getSubMenu() {
        return this.LD;
    }

    public final boolean hasSubMenu() {
        return this.LD != null;
    }

    public final void b(p pVar) {
        this.LD = pVar;
        pVar.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public final CharSequence getTitle() {
        return this.uU;
    }

    final CharSequence a(a aVar) {
        return (aVar == null || !aVar.C()) ? getTitle() : getTitleCondensed();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.uU = charSequence;
        this.eg.h(false);
        if (this.LD != null) {
            this.LD.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.eg.mContext.getString(i));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.Kr != null ? this.Kr : this.uU;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.Kr = charSequence;
        this.eg.h(false);
        return this;
    }

    public final Drawable getIcon() {
        if (this.Kv != null) {
            return this.Kv;
        }
        if (this.Kw == 0) {
            return null;
        }
        Drawable a = android.support.v7.widget.h.ey().a(this.eg.mContext, this.Kw, false);
        this.Kw = 0;
        this.Kv = a;
        return a;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.Kw = 0;
        this.Kv = drawable;
        this.eg.h(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.Kv = null;
        this.Kw = i;
        this.eg.h(false);
        return this;
    }

    public final boolean isCheckable() {
        return (this.ur & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        int i = this.ur;
        this.ur = (z ? 1 : 0) | (this.ur & -2);
        if (i != this.ur) {
            this.eg.h(false);
        }
        return this;
    }

    public final void D(boolean z) {
        this.ur = (z ? 4 : 0) | (this.ur & -5);
    }

    public final boolean dH() {
        return (this.ur & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.ur & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.ur & 4) != 0) {
            f fVar = this.eg;
            int groupId = getGroupId();
            int size = fVar.ep.size();
            for (int i = 0; i < size; i++) {
                h hVar = (h) fVar.ep.get(i);
                if (hVar.getGroupId() == groupId && hVar.dH() && hVar.isCheckable()) {
                    hVar.E(hVar == this);
                }
            }
        } else {
            E(z);
        }
        return this;
    }

    private void E(boolean z) {
        int i;
        int i2 = this.ur;
        int i3 = this.ur & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.ur = i | i3;
        if (i2 != this.ur) {
            this.eg.h(false);
        }
    }

    public final boolean isVisible() {
        if (this.LH == null || !this.LH.overridesItemVisibility()) {
            if ((this.ur & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.ur & 8) == 0 && this.LH.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    final boolean F(boolean z) {
        int i = this.ur;
        this.ur = (z ? 0 : 8) | (this.ur & -9);
        if (i != this.ur) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (F(z)) {
            this.eg.dy();
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.Kx = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        return this.uU != null ? this.uU.toString() : null;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.LK;
    }

    public final boolean dI() {
        return (this.ur & 32) == 32;
    }

    public final boolean dJ() {
        return (this.LF & 1) == 1;
    }

    public final boolean dK() {
        return (this.LF & 2) == 2;
    }

    public final void G(boolean z) {
        if (z) {
            this.ur |= 32;
        } else {
            this.ur &= -33;
        }
    }

    public final void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.LF = i;
                this.eg.dz();
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    private b aJ(View view) {
        this.LG = view;
        this.LH = null;
        if (view != null && view.getId() == -1 && this.mId > 0) {
            view.setId(this.mId);
        }
        this.eg.dz();
        return this;
    }

    public final View getActionView() {
        if (this.LG != null) {
            return this.LG;
        }
        if (this.LH == null) {
            return null;
        }
        this.LG = this.LH.onCreateActionView(this);
        return this.LG;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final d bt() {
        return this.LH;
    }

    public final b a(d dVar) {
        if (this.LH != null) {
            d dVar2 = this.LH;
            dVar2.wK = null;
            dVar2.wJ = null;
        }
        this.LG = null;
        this.LH = dVar;
        this.eg.h(true);
        if (this.LH != null) {
            this.LH.a(new d.b(this) {
                final /* synthetic */ h LP;

                {
                    this.LP = r1;
                }

                public final void bK() {
                    this.LP.eg.dy();
                }
            });
        }
        return this;
    }

    public final boolean expandActionView() {
        if (!dL()) {
            return false;
        }
        if (this.LI == null || this.LI.onMenuItemActionExpand(this)) {
            return this.eg.g(this);
        }
        return false;
    }

    public final boolean collapseActionView() {
        if ((this.LF & 8) == 0) {
            return false;
        }
        if (this.LG == null) {
            return true;
        }
        if (this.LI == null || this.LI.onMenuItemActionCollapse(this)) {
            return this.eg.h(this);
        }
        return false;
    }

    public final b a(e eVar) {
        this.LI = eVar;
        return this;
    }

    public final boolean dL() {
        if ((this.LF & 8) == 0) {
            return false;
        }
        if (this.LG == null && this.LH != null) {
            this.LG = this.LH.onCreateActionView(this);
        }
        if (this.LG != null) {
            return true;
        }
        return false;
    }

    public final void H(boolean z) {
        this.LJ = z;
        this.eg.h(false);
    }

    public final boolean isActionViewExpanded() {
        return this.LJ;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}

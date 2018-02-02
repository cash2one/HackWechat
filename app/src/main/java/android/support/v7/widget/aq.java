package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.a.a.e;
import android.support.v7.a.a.f;
import android.support.v7.a.a.i;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.l;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public final class aq implements u {
    Callback HV;
    private ActionMenuPresenter Mp;
    private final h Pc;
    private int aaf;
    private View aag;
    private Drawable aah;
    private Drawable aai;
    private boolean aaj;
    private CharSequence aak;
    boolean aal;
    private int aam;
    private int aan;
    private Drawable aao;
    Toolbar gH;
    private Drawable jY;
    private View kK;
    CharSequence uU;
    private CharSequence uV;

    public aq(Toolbar toolbar, boolean z) {
        this(toolbar, z, i.abc_action_bar_up_description, e.abc_ic_ab_back_mtrl_am_alpha);
    }

    private aq(Toolbar toolbar, boolean z, int i, int i2) {
        this.aam = 0;
        this.aan = 0;
        this.gH = toolbar;
        this.uU = toolbar.ZM;
        this.uV = toolbar.ZN;
        this.aaj = this.uU != null;
        this.aai = toolbar.getNavigationIcon();
        if (z) {
            Toolbar toolbar2;
            Context context;
            ap a = ap.a(toolbar.getContext(), null, k.ActionBar, a.actionBarStyle);
            CharSequence text = a.getText(k.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                this.aaj = true;
                j(text);
            }
            CharSequence text2 = a.getText(k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                this.uV = text2;
                if ((this.aaf & 8) != 0) {
                    this.gH.setSubtitle(text2);
                }
            }
            Drawable drawable = a.getDrawable(k.ActionBar_logo);
            if (drawable != null) {
                setLogo(drawable);
            }
            drawable = a.getDrawable(k.ActionBar_icon);
            if (this.aai == null && drawable != null) {
                setIcon(drawable);
            }
            drawable = a.getDrawable(k.ActionBar_homeAsUpIndicator);
            if (drawable != null) {
                this.aai = drawable;
                hb();
            }
            setDisplayOptions(a.getInt(k.ActionBar_displayOptions, 0));
            int resourceId = a.getResourceId(k.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.gH.getContext()).inflate(resourceId, this.gH, false));
                setDisplayOptions(this.aaf | 16);
            }
            resourceId = a.getLayoutDimension(k.ActionBar_height, 0);
            if (resourceId > 0) {
                LayoutParams layoutParams = this.gH.getLayoutParams();
                layoutParams.height = resourceId;
                this.gH.setLayoutParams(layoutParams);
            }
            resourceId = a.getDimensionPixelOffset(k.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset = a.getDimensionPixelOffset(k.ActionBar_contentInsetEnd, -1);
            if (resourceId >= 0 || dimensionPixelOffset >= 0) {
                this.gH.ZL.ag(Math.max(resourceId, 0), Math.max(dimensionPixelOffset, 0));
            }
            resourceId = a.getResourceId(k.ActionBar_titleTextStyle, 0);
            if (resourceId != 0) {
                toolbar2 = this.gH;
                context = this.gH.getContext();
                toolbar2.ZD = resourceId;
                if (toolbar2.Zv != null) {
                    toolbar2.Zv.setTextAppearance(context, resourceId);
                }
            }
            resourceId = a.getResourceId(k.ActionBar_subtitleTextStyle, 0);
            if (resourceId != 0) {
                toolbar2 = this.gH;
                context = this.gH.getContext();
                toolbar2.ZE = resourceId;
                if (toolbar2.Zw != null) {
                    toolbar2.Zw.setTextAppearance(context, resourceId);
                }
            }
            resourceId = a.getResourceId(k.ActionBar_popupTheme, 0);
            if (resourceId != 0) {
                this.gH.setPopupTheme(resourceId);
            }
            a.Zu.recycle();
        } else {
            int i3 = 11;
            if (this.gH.getNavigationIcon() != null) {
                i3 = 15;
            }
            this.aaf = i3;
        }
        this.Pc = h.ey();
        if (i != this.aan) {
            this.aan = i;
            if (TextUtils.isEmpty(this.gH.getNavigationContentDescription())) {
                setNavigationContentDescription(this.aan);
            }
        }
        this.aak = this.gH.getNavigationContentDescription();
        Drawable a2 = this.Pc.a(this.gH.getContext(), i2, false);
        if (this.aao != a2) {
            this.aao = a2;
            hb();
        }
        this.gH.setNavigationOnClickListener(new OnClickListener(this) {
            final android.support.v7.view.menu.a aap = new android.support.v7.view.menu.a(this.aaq.gH.getContext(), this.aaq.uU);
            final /* synthetic */ aq aaq;

            {
                this.aaq = r4;
            }

            public final void onClick(View view) {
                if (this.aaq.HV != null && this.aaq.aal) {
                    this.aaq.HV.onMenuItemSelected(0, this.aap);
                }
            }
        });
    }

    public final ViewGroup eH() {
        return this.gH;
    }

    public final Context getContext() {
        return this.gH.getContext();
    }

    public final boolean hasExpandedActionView() {
        Toolbar toolbar = this.gH;
        return (toolbar.ZX == null || toolbar.ZX.aab == null) ? false : true;
    }

    public final void collapseActionView() {
        this.gH.collapseActionView();
    }

    public final void b(Callback callback) {
        this.HV = callback;
    }

    public final void e(CharSequence charSequence) {
        if (!this.aaj) {
            j(charSequence);
        }
    }

    public final CharSequence getTitle() {
        return this.gH.ZM;
    }

    private void j(CharSequence charSequence) {
        this.uU = charSequence;
        if ((this.aaf & 8) != 0) {
            this.gH.setTitle(charSequence);
        }
    }

    public final void setIcon(int i) {
        setIcon(i != 0 ? this.Pc.a(this.gH.getContext(), i, false) : null);
    }

    private void setIcon(Drawable drawable) {
        this.jY = drawable;
        gZ();
    }

    public final void setLogo(Drawable drawable) {
        this.aah = drawable;
        gZ();
    }

    private void gZ() {
        Drawable drawable = null;
        if ((this.aaf & 2) != 0) {
            drawable = (this.aaf & 1) != 0 ? this.aah != null ? this.aah : this.jY : this.jY;
        }
        this.gH.setLogo(drawable);
    }

    public final boolean dU() {
        Toolbar toolbar = this.gH;
        return toolbar.getVisibility() == 0 && toolbar.Mo != null && toolbar.Mo.Nr;
    }

    public final boolean isOverflowMenuShowing() {
        return this.gH.isOverflowMenuShowing();
    }

    public final boolean dV() {
        Toolbar toolbar = this.gH;
        if (toolbar.Mo != null) {
            boolean z;
            ActionMenuView actionMenuView = toolbar.Mo;
            if (actionMenuView.NQ != null) {
                ActionMenuPresenter actionMenuPresenter = actionMenuView.NQ;
                z = actionMenuPresenter.NF != null || actionMenuPresenter.isOverflowMenuShowing();
                if (z) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean showOverflowMenu() {
        return this.gH.showOverflowMenu();
    }

    public final boolean hideOverflowMenu() {
        Toolbar toolbar = this.gH;
        if (toolbar.Mo != null) {
            ActionMenuView actionMenuView = toolbar.Mo;
            boolean z = actionMenuView.NQ != null && actionMenuView.NQ.hideOverflowMenu();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void dW() {
        this.aal = true;
    }

    public final void a(Menu menu, l.a aVar) {
        if (this.Mp == null) {
            this.Mp = new ActionMenuPresenter(this.gH.getContext());
            this.Mp.mId = f.action_menu_presenter;
        }
        this.Mp.ef = aVar;
        this.gH.a((android.support.v7.view.menu.f) menu, this.Mp);
    }

    public final void dismissPopupMenus() {
        Toolbar toolbar = this.gH;
        if (toolbar.Mo != null) {
            toolbar.Mo.dismissPopupMenus();
        }
    }

    public final int getDisplayOptions() {
        return this.aaf;
    }

    public final void setDisplayOptions(int i) {
        int i2 = this.aaf ^ i;
        this.aaf = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    hb();
                    ha();
                } else {
                    this.gH.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                gZ();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.gH.setTitle(this.uU);
                    this.gH.setSubtitle(this.uV);
                } else {
                    this.gH.setTitle(null);
                    this.gH.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.kK != null) {
                if ((i & 16) != 0) {
                    this.gH.addView(this.kK);
                } else {
                    this.gH.removeView(this.kK);
                }
            }
        }
    }

    public final void b(ai aiVar) {
        if (this.aag != null && this.aag.getParent() == this.gH) {
            this.gH.removeView(this.aag);
        }
        this.aag = aiVar;
        if (aiVar != null && this.aam == 2) {
            this.gH.addView(this.aag, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.aag.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            aiVar.WD = true;
        }
    }

    public final void M(boolean z) {
        Toolbar toolbar = this.gH;
        toolbar.ZY = z;
        toolbar.requestLayout();
    }

    public final int getNavigationMode() {
        return this.aam;
    }

    public final void setCustomView(View view) {
        if (!(this.kK == null || (this.aaf & 16) == 0)) {
            this.gH.removeView(this.kK);
        }
        this.kK = view;
        if (view != null && (this.aaf & 16) != 0) {
            this.gH.addView(this.kK);
        }
    }

    public final View getCustomView() {
        return this.kK;
    }

    public final ai c(final int i, long j) {
        return z.U(this.gH).q(i == 0 ? 1.0f : 0.0f).d(j).a(new an(this) {
            private boolean Mu = false;
            final /* synthetic */ aq aaq;

            public final void p(View view) {
                this.aaq.gH.setVisibility(0);
            }

            public final void q(View view) {
                if (!this.Mu) {
                    this.aaq.gH.setVisibility(i);
                }
            }

            public final void ar(View view) {
                this.Mu = true;
            }
        });
    }

    public final void setNavigationContentDescription(int i) {
        this.aak = i == 0 ? null : this.gH.getContext().getString(i);
        ha();
    }

    private void ha() {
        if ((this.aaf & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.aak)) {
            Toolbar toolbar = this.gH;
            int i = this.aan;
            toolbar.setNavigationContentDescription(i != 0 ? toolbar.getContext().getText(i) : null);
            return;
        }
        this.gH.setNavigationContentDescription(this.aak);
    }

    private void hb() {
        if ((this.aaf & 4) != 0) {
            this.gH.setNavigationIcon(this.aai != null ? this.aai : this.aao);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.gH.setBackgroundDrawable(drawable);
    }

    public final int getHeight() {
        return this.gH.getHeight();
    }

    public final void setVisibility(int i) {
        this.gH.setVisibility(i);
    }

    public final int getVisibility() {
        return this.gH.getVisibility();
    }

    public final void a(l.a aVar, android.support.v7.view.menu.f.a aVar2) {
        Toolbar toolbar = this.gH;
        toolbar.NR = aVar;
        toolbar.NS = aVar2;
        if (toolbar.Mo != null) {
            toolbar.Mo.a(aVar, aVar2);
        }
    }

    public final Menu getMenu() {
        return this.gH.getMenu();
    }
}

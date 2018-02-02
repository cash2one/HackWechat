package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.m.e;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
public class i extends c<android.support.v4.c.a.b> implements MenuItem {
    public Method LQ;

    class a extends android.support.v4.view.d {
        final ActionProvider LR;
        final /* synthetic */ i LS;

        public a(i iVar, Context context, ActionProvider actionProvider) {
            this.LS = iVar;
            super(context);
            this.LR = actionProvider;
        }

        public final View onCreateActionView() {
            return this.LR.onCreateActionView();
        }

        public final boolean onPerformDefaultAction() {
            return this.LR.onPerformDefaultAction();
        }

        public final boolean hasSubMenu() {
            return this.LR.hasSubMenu();
        }

        public final void onPrepareSubMenu(SubMenu subMenu) {
            this.LR.onPrepareSubMenu(this.LS.a(subMenu));
        }
    }

    static class b extends FrameLayout implements android.support.v7.view.c {
        final CollapsibleActionView LT;

        b(View view) {
            super(view.getContext());
            this.LT = (CollapsibleActionView) view;
            addView(view);
        }

        public final void onActionViewExpanded() {
            this.LT.onActionViewExpanded();
        }

        public final void onActionViewCollapsed() {
            this.LT.onActionViewCollapsed();
        }
    }

    private class c extends d<OnActionExpandListener> implements e {
        final /* synthetic */ i LS;

        c(i iVar, OnActionExpandListener onActionExpandListener) {
            this.LS = iVar;
            super(onActionExpandListener);
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.KO).onMenuItemActionExpand(this.LS.f(menuItem));
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.KO).onMenuItemActionCollapse(this.LS.f(menuItem));
        }
    }

    private class d extends d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ i LS;

        d(i iVar, OnMenuItemClickListener onMenuItemClickListener) {
            this.LS = iVar;
            super(onMenuItemClickListener);
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.KO).onMenuItemClick(this.LS.f(menuItem));
        }
    }

    i(Context context, android.support.v4.c.a.b bVar) {
        super(context, bVar);
    }

    public int getItemId() {
        return ((android.support.v4.c.a.b) this.KO).getItemId();
    }

    public int getGroupId() {
        return ((android.support.v4.c.a.b) this.KO).getGroupId();
    }

    public int getOrder() {
        return ((android.support.v4.c.a.b) this.KO).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((android.support.v4.c.a.b) this.KO).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((android.support.v4.c.a.b) this.KO).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((android.support.v4.c.a.b) this.KO).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((android.support.v4.c.a.b) this.KO).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((android.support.v4.c.a.b) this.KO).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((android.support.v4.c.a.b) this.KO).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((android.support.v4.c.a.b) this.KO).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((android.support.v4.c.a.b) this.KO).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((android.support.v4.c.a.b) this.KO).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((android.support.v4.c.a.b) this.KO).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((android.support.v4.c.a.b) this.KO).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((android.support.v4.c.a.b) this.KO).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((android.support.v4.c.a.b) this.KO).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((android.support.v4.c.a.b) this.KO).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((android.support.v4.c.a.b) this.KO).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((android.support.v4.c.a.b) this.KO).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((android.support.v4.c.a.b) this.KO).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((android.support.v4.c.a.b) this.KO).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((android.support.v4.c.a.b) this.KO).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((android.support.v4.c.a.b) this.KO).setVisible(z);
    }

    public boolean isVisible() {
        return ((android.support.v4.c.a.b) this.KO).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((android.support.v4.c.a.b) this.KO).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((android.support.v4.c.a.b) this.KO).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((android.support.v4.c.a.b) this.KO).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return a(((android.support.v4.c.a.b) this.KO).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((android.support.v4.c.a.b) this.KO).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((android.support.v4.c.a.b) this.KO).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((android.support.v4.c.a.b) this.KO).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((android.support.v4.c.a.b) this.KO).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((android.support.v4.c.a.b) this.KO).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((android.support.v4.c.a.b) this.KO).setActionView(i);
        View actionView = ((android.support.v4.c.a.b) this.KO).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((android.support.v4.c.a.b) this.KO).setActionView(new b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((android.support.v4.c.a.b) this.KO).getActionView();
        if (actionView instanceof b) {
            return (View) ((b) actionView).LT;
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((android.support.v4.c.a.b) this.KO).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        android.support.v4.view.d bt = ((android.support.v4.c.a.b) this.KO).bt();
        if (bt instanceof a) {
            return ((a) bt).LR;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((android.support.v4.c.a.b) this.KO).expandActionView();
    }

    public boolean collapseActionView() {
        return ((android.support.v4.c.a.b) this.KO).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((android.support.v4.c.a.b) this.KO).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((android.support.v4.c.a.b) this.KO).a(onActionExpandListener != null ? new c(this, onActionExpandListener) : null);
        return this;
    }

    a a(ActionProvider actionProvider) {
        return new a(this, this.mContext, actionProvider);
    }
}

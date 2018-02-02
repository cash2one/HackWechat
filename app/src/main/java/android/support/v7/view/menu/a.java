package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.support.v4.view.m.e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class a implements b {
    private final int Ko;
    private final int Kp;
    private final int Kq;
    private CharSequence Kr;
    private Intent Ks;
    private char Kt;
    private char Ku;
    private Drawable Kv;
    private int Kw = 0;
    private OnMenuItemClickListener Kx;
    private Context mContext;
    private final int mId;
    private CharSequence uU;
    private int ur = 16;

    public final /* synthetic */ MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public a(Context context, CharSequence charSequence) {
        this.mContext = context;
        this.mId = 16908332;
        this.Ko = 0;
        this.Kp = 0;
        this.Kq = 0;
        this.uU = charSequence;
    }

    public final char getAlphabeticShortcut() {
        return this.Ku;
    }

    public final int getGroupId() {
        return this.Ko;
    }

    public final Drawable getIcon() {
        return this.Kv;
    }

    public final Intent getIntent() {
        return this.Ks;
    }

    public final int getItemId() {
        return this.mId;
    }

    public final ContextMenuInfo getMenuInfo() {
        return null;
    }

    public final char getNumericShortcut() {
        return this.Kt;
    }

    public final int getOrder() {
        return this.Kq;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final CharSequence getTitle() {
        return this.uU;
    }

    public final CharSequence getTitleCondensed() {
        return this.Kr != null ? this.Kr : this.uU;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final boolean isCheckable() {
        return (this.ur & 1) != 0;
    }

    public final boolean isChecked() {
        return (this.ur & 2) != 0;
    }

    public final boolean isEnabled() {
        return (this.ur & 16) != 0;
    }

    public final boolean isVisible() {
        return (this.ur & 8) == 0;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        this.Ku = c;
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        this.ur = (z ? 1 : 0) | (this.ur & -2);
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        this.ur = (z ? 2 : 0) | (this.ur & -3);
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        this.ur = (z ? 16 : 0) | (this.ur & -17);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.Kv = drawable;
        this.Kw = 0;
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.Kw = i;
        this.Kv = android.support.v4.content.a.b(this.mContext, i);
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.Ks = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c) {
        this.Kt = c;
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.Kx = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.Kt = c;
        this.Ku = c2;
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.uU = charSequence;
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.uU = this.mContext.getResources().getString(i);
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.Kr = charSequence;
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        this.ur = (z ? 0 : 8) | (this.ur & 8);
        return this;
    }

    public final void setShowAsAction(int i) {
    }

    public final View getActionView() {
        return null;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public final d bt() {
        return null;
    }

    public final b a(d dVar) {
        throw new UnsupportedOperationException();
    }

    public final boolean expandActionView() {
        return false;
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public final b a(e eVar) {
        return this;
    }
}

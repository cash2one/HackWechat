package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.f.a;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class p extends f implements SubMenu {
    public f Mk;
    private h Ml;

    public p(Context context, f fVar, h hVar) {
        super(context);
        this.Mk = fVar;
        this.Ml = hVar;
    }

    public void setQwertyMode(boolean z) {
        this.Mk.setQwertyMode(z);
    }

    public final boolean du() {
        return this.Mk.du();
    }

    public final boolean dv() {
        return this.Mk.dv();
    }

    public MenuItem getItem() {
        return this.Ml;
    }

    public final void a(a aVar) {
        this.Mk.a(aVar);
    }

    public final f dD() {
        return this.Mk;
    }

    final boolean b(f fVar, MenuItem menuItem) {
        return super.b(fVar, menuItem) || this.Mk.b(fVar, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.Ml.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.Ml.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.l(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.l(android.support.v4.content.a.b(this.mContext, i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.g(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.g(this.mContext.getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.a(null, null, view);
        return this;
    }

    public final boolean g(h hVar) {
        return this.Mk.g(hVar);
    }

    public final boolean h(h hVar) {
        return this.Mk.h(hVar);
    }

    public final String dt() {
        int itemId = this.Ml != null ? this.Ml.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.dt() + ":" + itemId;
    }
}

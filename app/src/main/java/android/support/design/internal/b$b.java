package android.support.design.internal;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.internal.b.a;
import android.support.design.internal.b.c;
import android.support.design.internal.b.d;
import android.support.design.internal.b.e;
import android.support.design.internal.b.f;
import android.support.design.internal.b.g;
import android.support.design.internal.b.i;
import android.support.design.internal.b.j;
import android.support.v7.view.menu.h;
import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

class b$b extends RecyclerView$a<j> {
    final /* synthetic */ b eo;
    final ArrayList<d> ep = new ArrayList();
    private h eq;
    private ColorDrawable er;
    boolean es;

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return new g(this.eo.mLayoutInflater, viewGroup, this.eo.mOnClickListener);
            case 1:
                return new i(this.eo.mLayoutInflater, viewGroup);
            case 2:
                return new b.h(this.eo.mLayoutInflater, viewGroup);
            case 3:
                return new a(this.eo.ee);
            default:
                return null;
        }
    }

    public final /* synthetic */ void a(t tVar) {
        j jVar = (j) tVar;
        if (jVar instanceof g) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.VU;
            if (navigationMenuItemView.ea != null) {
                navigationMenuItemView.ea.removeAllViews();
            }
            navigationMenuItemView.dZ.setCompoundDrawables(null, null, null, null);
        }
    }

    public final /* synthetic */ void a(t tVar, int i) {
        j jVar = (j) tVar;
        switch (getItemViewType(i)) {
            case 0:
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.VU;
                navigationMenuItemView.ec = this.eo.ec;
                if (navigationMenuItemView.eb != null) {
                    navigationMenuItemView.setIcon(navigationMenuItemView.eb.getIcon());
                }
                if (this.eo.ej) {
                    navigationMenuItemView.dZ.setTextAppearance(navigationMenuItemView.getContext(), this.eo.ei);
                }
                if (this.eo.ek != null) {
                    navigationMenuItemView.dZ.setTextColor(this.eo.ek);
                }
                navigationMenuItemView.setBackgroundDrawable(this.eo.el != null ? this.eo.el.getConstantState().newDrawable() : null);
                navigationMenuItemView.a(((f) this.ep.get(i)).ev);
                return;
            case 1:
                ((TextView) jVar.VU).setText(((f) this.ep.get(i)).ev.getTitle());
                return;
            case 2:
                e eVar = (e) this.ep.get(i);
                jVar.VU.setPadding(0, eVar.et, 0, eVar.eu);
                return;
            default:
                return;
        }
    }

    public b$b(b bVar) {
        this.eo = bVar;
        E();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemCount() {
        return this.ep.size();
    }

    public final int getItemViewType(int i) {
        d dVar = (d) this.ep.get(i);
        if (dVar instanceof e) {
            return 2;
        }
        if (dVar instanceof c) {
            return 3;
        }
        if (!(dVar instanceof f)) {
            throw new RuntimeException("Unknown item type.");
        } else if (((f) dVar).ev.hasSubMenu()) {
            return 1;
        } else {
            return 0;
        }
    }

    final void E() {
        if (!this.es) {
            this.es = true;
            this.ep.clear();
            this.ep.add(new c((byte) 0));
            int i = -1;
            int i2 = 0;
            Object obj = null;
            int size = this.eo.eg.dA().size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2;
                int i4;
                int i5;
                h hVar = (h) this.eo.eg.dA().get(i3);
                if (hVar.isChecked()) {
                    d(hVar);
                }
                if (hVar.isCheckable()) {
                    hVar.D(false);
                }
                int i6;
                if (hVar.hasSubMenu()) {
                    SubMenu subMenu = hVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i3 != 0) {
                            this.ep.add(new e(this.eo.en, 0));
                        }
                        this.ep.add(new f(hVar, (byte) 0));
                        Object obj3 = null;
                        int size2 = this.ep.size();
                        int size3 = subMenu.size();
                        for (i6 = 0; i6 < size3; i6++) {
                            h hVar2 = (h) subMenu.getItem(i6);
                            if (hVar2.isVisible()) {
                                if (obj3 == null && hVar2.getIcon() != null) {
                                    obj3 = 1;
                                }
                                if (hVar2.isCheckable()) {
                                    hVar2.D(false);
                                }
                                if (hVar.isChecked()) {
                                    d(hVar);
                                }
                                this.ep.add(new f(hVar2, (byte) 0));
                            }
                        }
                        if (obj3 != null) {
                            d(size2, this.ep.size());
                        }
                    }
                    obj2 = obj;
                    i4 = i2;
                    i5 = i;
                } else {
                    Object obj4;
                    i6 = hVar.getGroupId();
                    if (i6 != i) {
                        i2 = this.ep.size();
                        obj = hVar.getIcon() != null ? 1 : null;
                        if (i3 != 0) {
                            i2++;
                            this.ep.add(new e(this.eo.en, this.eo.en));
                            obj4 = obj;
                            i5 = i2;
                        }
                        obj4 = obj;
                        i5 = i2;
                    } else {
                        if (obj == null && hVar.getIcon() != null) {
                            obj = 1;
                            d(i2, this.ep.size());
                        }
                        obj4 = obj;
                        i5 = i2;
                    }
                    if (obj4 != null && hVar.getIcon() == null) {
                        hVar.setIcon(17170445);
                    }
                    this.ep.add(new f(hVar, (byte) 0));
                    obj2 = obj4;
                    i4 = i5;
                    i5 = i6;
                }
                i3++;
                i2 = i4;
                i = i5;
                obj = obj2;
            }
            this.es = false;
        }
    }

    private void d(int i, int i2) {
        while (i < i2) {
            MenuItem menuItem = ((f) this.ep.get(i)).ev;
            if (menuItem.getIcon() == null) {
                if (this.er == null) {
                    this.er = new ColorDrawable(0);
                }
                menuItem.setIcon(this.er);
            }
            i++;
        }
    }

    public final void d(h hVar) {
        if (this.eq != hVar && hVar.isCheckable()) {
            if (this.eq != null) {
                this.eq.setChecked(false);
            }
            this.eq = hVar;
            hVar.setChecked(true);
        }
    }

    public final Bundle F() {
        Bundle bundle = new Bundle();
        if (this.eq != null) {
            bundle.putInt("android:menu:checked", this.eq.getItemId());
        }
        SparseArray sparseArray = new SparseArray();
        Iterator it = this.ep.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar instanceof f) {
                h hVar = ((f) dVar).ev;
                View actionView = hVar != null ? hVar.getActionView() : null;
                if (actionView != null) {
                    SparseArray parcelableSparseArray = new ParcelableSparseArray();
                    actionView.saveHierarchyState(parcelableSparseArray);
                    sparseArray.put(hVar.getItemId(), parcelableSparseArray);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
        return bundle;
    }
}

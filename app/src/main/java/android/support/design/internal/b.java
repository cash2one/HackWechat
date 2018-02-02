package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.l.a;
import android.support.v7.view.menu.p;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.Iterator;

public final class b implements l {
    ColorStateList ec;
    public NavigationMenuView ed;
    public LinearLayout ee;
    private a ef;
    f eg;
    public b eh;
    int ei;
    boolean ej;
    ColorStateList ek;
    Drawable el;
    public int em;
    int en;
    public int mId;
    public LayoutInflater mLayoutInflater;
    final OnClickListener mOnClickListener = new 1(this);

    private interface d {
    }

    private static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
            super(layoutInflater.inflate(android.support.design.a.f.bw, viewGroup, false));
            this.VU.setOnClickListener(onClickListener);
        }
    }

    private static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(android.support.design.a.f.by, viewGroup, false));
        }
    }

    private static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(android.support.design.a.f.bz, viewGroup, false));
        }
    }

    public final void a(Context context, f fVar) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.eg = fVar;
        this.en = context.getResources().getDimensionPixelOffset(android.support.design.a.d.bf);
    }

    public final void f(boolean z) {
        if (this.eh != null) {
            RecyclerView.a aVar = this.eh;
            aVar.E();
            aVar.UR.notifyChanged();
        }
    }

    public final boolean a(p pVar) {
        return false;
    }

    public final void a(f fVar, boolean z) {
        if (this.ef != null) {
            this.ef.a(fVar, z);
        }
    }

    public final boolean D() {
        return false;
    }

    public final boolean b(android.support.v7.view.menu.h hVar) {
        return false;
    }

    public final boolean c(android.support.v7.view.menu.h hVar) {
        return false;
    }

    public final int getId() {
        return this.mId;
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        if (this.ed != null) {
            SparseArray sparseArray = new SparseArray();
            this.ed.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.eh != null) {
            bundle.putBundle("android:menu:adapter", this.eh.F());
        }
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.ed.restoreHierarchyState(sparseParcelableArray);
        }
        Bundle bundle2 = bundle.getBundle("android:menu:adapter");
        if (bundle2 != null) {
            d dVar;
            b bVar = this.eh;
            int i = bundle2.getInt("android:menu:checked", 0);
            if (i != 0) {
                bVar.es = true;
                Iterator it = bVar.ep.iterator();
                while (it.hasNext()) {
                    dVar = (d) it.next();
                    if (dVar instanceof f) {
                        android.support.v7.view.menu.h hVar = ((f) dVar).ev;
                        if (hVar != null && hVar.getItemId() == i) {
                            bVar.d(hVar);
                            break;
                        }
                    }
                }
                bVar.es = false;
                bVar.E();
            }
            SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
            Iterator it2 = bVar.ep.iterator();
            while (it2.hasNext()) {
                dVar = (d) it2.next();
                if (dVar instanceof f) {
                    android.support.v7.view.menu.h hVar2 = ((f) dVar).ev;
                    View actionView = hVar2 != null ? hVar2.getActionView() : null;
                    if (actionView != null) {
                        actionView.restoreHierarchyState((SparseArray) sparseParcelableArray2.get(hVar2.getItemId()));
                    }
                }
            }
        }
    }

    public final void a(ColorStateList colorStateList) {
        this.ec = colorStateList;
        f(false);
    }

    public final void b(ColorStateList colorStateList) {
        this.ek = colorStateList;
        f(false);
    }

    public final void o(int i) {
        this.ei = i;
        this.ej = true;
        f(false);
    }

    public final void a(Drawable drawable) {
        this.el = drawable;
        f(false);
    }

    public final void g(boolean z) {
        if (this.eh != null) {
            this.eh.es = z;
        }
    }
}

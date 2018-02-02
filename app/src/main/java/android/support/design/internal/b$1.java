package android.support.design.internal;

import android.support.v7.view.menu.h;
import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b eo;

    b$1(b bVar) {
        this.eo = bVar;
    }

    public final void onClick(View view) {
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
        this.eo.g(true);
        h hVar = navigationMenuItemView.eb;
        boolean a = this.eo.eg.a(hVar, this.eo, 0);
        if (hVar != null && hVar.isCheckable() && a) {
            this.eo.eh.d(hVar);
        }
        this.eo.g(false);
        this.eo.f(false);
    }
}

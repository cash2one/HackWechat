package com.tencent.mm.ui.appbrand;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.n;

public class a$e extends a$c {
    final /* synthetic */ a xVC;

    public a$e(a aVar) {
        this.xVC = aVar;
        super(aVar);
    }

    public final void a(n nVar) {
        super.a(nVar);
        nVar.f(3, this.xVC.context.getString(R.l.dEi));
        nVar.f(8, this.xVC.context.getString(R.l.dEe));
        nVar.f(7, a.a(this.xVC));
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        super.onMMMenuItemSelected(menuItem, i);
    }
}

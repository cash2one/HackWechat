package com.tencent.mm.ui.appbrand;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.v;

public class a$g extends a$c {
    final /* synthetic */ a xVC;

    public a$g(a aVar) {
        this.xVC = aVar;
        super(aVar);
    }

    public final View coC() {
        View inflate = v.fv(this.xVC.context).inflate(R.i.dcV, null);
        ((TextView) inflate.findViewById(R.h.bKO)).setText(this.xVC.context.getString(R.l.dEh));
        return inflate;
    }

    public final void a(n nVar) {
        super.a(nVar);
        nVar.f(6, this.xVC.context.getString(R.l.dDX));
        nVar.f(4, this.xVC.context.getString(R.l.dEd));
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        super.onMMMenuItemSelected(menuItem, i);
    }
}

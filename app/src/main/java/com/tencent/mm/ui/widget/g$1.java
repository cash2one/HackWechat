package com.tencent.mm.ui.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.base.o;

class g$1 implements OnItemClickListener {
    final /* synthetic */ g ztC;

    g$1(g gVar) {
        this.ztC = gVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        o oVar = (o) g.a(this.ztC).ycc.get(i);
        if (oVar == null || !oVar.wPS) {
            if (i < g.a(this.ztC).size()) {
                if (g.b(this.ztC) != null) {
                    g.b(this.ztC).onMMMenuItemSelected(g.a(this.ztC).getItem(i), i);
                }
            } else if (g.c(this.ztC).size() > 0 && i < g.a(this.ztC).size() + g.c(this.ztC).size() && g.d(this.ztC) != null) {
                g.d(this.ztC).onMMMenuItemSelected(g.c(this.ztC).getItem(i - g.a(this.ztC).size()), i);
            }
            if (!g.e(this.ztC)) {
                this.ztC.bxh();
            }
            g.f(this.ztC);
            g.a(this.ztC, i);
            g.g(this.ztC).UR.notifyChanged();
        }
    }
}

package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;

class ac$1 extends a {
    final /* synthetic */ ac Wk;

    ac$1(ac acVar) {
        this.Wk = acVar;
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        if (!this.Wk.gb() && this.Wk.Va.TV != null) {
            this.Wk.Va.TV.b(view, bVar);
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (this.Wk.gb() || this.Wk.Va.TV == null) {
            return false;
        }
        h hVar = this.Wk.Va.TV;
        m mVar = hVar.Va.TN;
        q qVar = hVar.Va.UB;
        return false;
    }
}

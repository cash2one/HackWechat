package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.View;

public class MRecyclerView extends RecyclerView {
    protected a kgj;
    private a kgk;
    private View kgl;

    public MRecyclerView(Context context) {
        super(context);
        init();
    }

    public MRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.kgj = new a();
        this.kgj.fP();
        super.a(this.kgj);
        this.kgj.a(new 1(this));
    }

    public final int G(t tVar) {
        if (this.kgj == null) {
            return -1;
        }
        a aVar = this.kgj;
        if (tVar == null || tVar.ge() == -1) {
            return -1;
        }
        return tVar.ge() - (aVar.kfW.isEmpty() ? 0 : 1);
    }

    public final void a(RecyclerView$a recyclerView$a) {
        a aVar = this.kgj;
        if (aVar.TU != null) {
            if (!aVar.TU.equals(recyclerView$a)) {
                aVar.TU.b(aVar.kga);
            } else {
                return;
            }
        }
        aVar.TU = recyclerView$a;
        if (aVar.TU != null) {
            aVar.TU.a(aVar.kga);
        }
    }

    public final RecyclerView$a fm() {
        return this.kgj;
    }

    public final void be(int i) {
        super.be(i);
    }

    public final void addHeaderView(View view) {
        a aVar = this.kgj;
        aVar.kfW.add(view);
        aVar.U(0, 1);
    }

    public void addFooterView(View view) {
        this.kgj.addFooterView(view);
    }

    public final void c(int i, View view) {
        this.kgj.c(i, view);
    }

    public final void cf(View view) {
        this.kgj.cf(view);
    }

    public final void a(a aVar) {
        this.kgk = aVar;
        this.kgj.kfY = new 2(this);
    }

    protected boolean aoa() {
        return this.kgj.getItemCount() == 0;
    }
}

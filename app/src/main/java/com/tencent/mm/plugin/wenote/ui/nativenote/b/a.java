package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.support.v7.widget.RecyclerView$t;
import android.view.View;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public abstract class a extends RecyclerView$t {
    protected k tWs;

    public abstract void a(b bVar, int i, int i2);

    public abstract int bXO();

    public a(View view, k kVar) {
        super(view);
        this.tWs = kVar;
    }
}

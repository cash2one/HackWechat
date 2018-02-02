package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class c extends h {
    public c(View view, k kVar) {
        super(view, kVar);
        this.tYc.setVisibility(0);
        this.fvf.setVisibility(8);
        this.tYh.setVisibility(8);
        this.tYc.setTag(this);
        this.tYc.setOnClickListener(this.npY);
    }

    public final void a(b bVar, int i, int i2) {
        this.tYf.setImageResource(com.tencent.mm.pluginsdk.model.c.Rr(((com.tencent.mm.plugin.wenote.model.a.c) bVar).tRF));
        this.tYd.setText(((com.tencent.mm.plugin.wenote.model.a.c) bVar).title);
        this.tYe.setText(((com.tencent.mm.plugin.wenote.model.a.c) bVar).content);
        super.a(bVar, i, i2);
    }

    public final int bXO() {
        return 5;
    }
}

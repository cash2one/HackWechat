package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class b extends h {
    public b(View view, k kVar) {
        super(view, kVar);
        this.tYc.setVisibility(8);
        this.fvf.setVisibility(8);
        this.tYh.setVisibility(8);
        this.tYc.setOnClickListener(null);
    }

    public final void a(com.tencent.mm.plugin.wenote.model.a.b bVar, int i, int i2) {
        super.a(bVar, i, i2);
        if (bVar.getType() == -2 && this.tWs.tUp == 3) {
            this.tYl.setVisibility(0);
        }
    }

    public final int bXO() {
        return -2;
    }
}

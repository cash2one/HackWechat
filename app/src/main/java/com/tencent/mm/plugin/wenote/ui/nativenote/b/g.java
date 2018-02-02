package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class g extends h {
    public g(View view, k kVar) {
        super(view, kVar);
        this.tYc.setVisibility(0);
        this.fvf.setVisibility(8);
        this.tYh.setVisibility(8);
        this.tYc.setTag(this);
        this.tYc.setOnClickListener(this.npY);
    }

    public final void a(b bVar, int i, int i2) {
        this.tYf.setImageResource(R.k.dvm);
        this.tYd.setText(((f) bVar).nTe);
        this.tYe.setText(((f) bVar).hxu);
        super.a(bVar, i, i2);
    }

    public final int bXO() {
        return 3;
    }
}

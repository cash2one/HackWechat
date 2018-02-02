package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class i extends h {
    private ImageView tYt;
    private TextView tYu;

    public i(View view, k kVar) {
        super(view, kVar);
        this.tYc.setVisibility(8);
        this.fvf.setVisibility(8);
        this.tYh.setVisibility(8);
        this.tYc.setOnClickListener(null);
        this.tYt = (ImageView) view.findViewById(R.h.cAV);
        this.tYu = (TextView) view.findViewById(R.h.cAX);
    }

    public final void a(b bVar, int i, int i2) {
        super.a(bVar, i, i2);
        if (bVar.getType() == -4) {
            this.tYk.setVisibility(0);
        }
    }

    public final int bXO() {
        return -4;
    }
}

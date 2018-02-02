package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class j extends h {
    private View tYv;

    public j(View view, k kVar) {
        super(view, kVar);
        this.tYc.setVisibility(8);
        this.fvf.setVisibility(8);
        this.tYh.setVisibility(8);
        this.tYc.setOnClickListener(null);
        this.tYi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ j tYw;

            {
                this.tYw = r1;
            }

            public final void onClick(View view) {
                this.tYw.tYb.bWL();
                this.tYw.tYb.requestFocus();
            }
        });
    }

    public final void a(b bVar, int i, int i2) {
        super.a(bVar, i, i2);
        if (bVar.getType() == -1) {
            LayoutParams layoutParams = (LayoutParams) this.tYj.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.tYj.setLayoutParams(layoutParams);
            this.tYi.setVisibility(0);
            this.tYv = this.VU.findViewById(R.h.cBa);
        }
    }

    public final int bXO() {
        return -1;
    }
}

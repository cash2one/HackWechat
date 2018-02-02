package com.tencent.mm.plugin.appbrand.widget.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.widget.c.c.b;
import com.tencent.mm.protocal.c.bec;

class c$b$1 implements OnClickListener {
    final /* synthetic */ bec iVI;
    final /* synthetic */ ImageView iVJ;
    final /* synthetic */ b jWt;

    c$b$1(b bVar, bec com_tencent_mm_protocal_c_bec, ImageView imageView) {
        this.jWt = bVar;
        this.iVI = com_tencent_mm_protocal_c_bec;
        this.iVJ = imageView;
    }

    public final void onClick(View view) {
        if (this.iVI.wJQ == 2) {
            this.iVJ.setImageResource(i.dyV);
            this.iVI.wJQ = 1;
        } else if (this.iVI.wJQ == 1) {
            this.iVJ.setImageResource(i.dyT);
            this.iVI.wJQ = 2;
        }
    }
}

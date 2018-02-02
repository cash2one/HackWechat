package com.tencent.mm.plugin.brandservice.ui;

import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class EnterpriseBizContactPlainListUI$a$2 implements Runnable {
    final /* synthetic */ a kGG;

    EnterpriseBizContactPlainListUI$a$2(a aVar) {
        this.kGG = aVar;
    }

    public final void run() {
        this.kGG.Xz();
        TextView textView = (TextView) this.kGG.kGD.findViewById(R.h.ceF);
        if (!(this.kGG.kGD.kGl == null || textView == null)) {
            ar.Hg();
            af WO = c.EY().WO(this.kGG.kGD.hog);
            if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type)) {
                this.kGG.kGD.kGl.setVisibility(8);
                textView.setVisibility(0);
            } else if (this.kGG.kGD.kGA.getCount() <= 0) {
                this.kGG.kGD.kGl.setVisibility(8);
                textView.setVisibility(0);
            } else {
                this.kGG.kGD.kGl.setVisibility(0);
                textView.setVisibility(8);
                this.kGG.kGD.kGl.setAdapter(this.kGG.kGD.kGA);
                this.kGG.kGD.kGl.setOnItemClickListener(this.kGG.kGD.kGC);
            }
        }
        this.kGG.notifyDataSetChanged();
    }
}

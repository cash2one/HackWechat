package com.tencent.mm.plugin.voip_cs.b.a;

import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ b sxB;

    b$2(b bVar) {
        this.sxB = bVar;
    }

    public final boolean uF() {
        b.a(this.sxB).setText(ac.getContext().getString(R.l.eVa));
        b.b(this.sxB).setVisibility(0);
        com.tencent.mm.plugin.voip_cs.c.a c = b.c(this.sxB);
        TextView b = b.b(this.sxB);
        int[] iArr = b.sqb;
        if (iArr == null || b == null) {
            x.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        } else {
            c.bIg();
            c.sqq = 0;
            c.sqo = iArr;
            c.kO = b;
            c.sqp = 500;
            if (c.ikI != null) {
                long j = (long) c.sqp;
                c.ikI.J(j, j);
            }
            x.j("MicroMsg.DynamicTextWrap", "start textview:" + b, new Object[0]);
        }
        return true;
    }
}

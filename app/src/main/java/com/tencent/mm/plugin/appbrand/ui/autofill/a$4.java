package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bik;
import com.tencent.mm.protocal.c.eb;

class a$4 implements OnClickListener {
    final /* synthetic */ a jNF;
    final /* synthetic */ bik jNG;

    a$4(a aVar, bik com_tencent_mm_protocal_c_bik) {
        this.jNF = aVar;
        this.jNG = com_tencent_mm_protocal_c_bik;
    }

    public final void onClick(View view) {
        if (a.a(this.jNF) != null) {
            a.a(this.jNF).us(((eb) this.jNG.wLV.get(0)).url);
        }
    }
}

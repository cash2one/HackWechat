package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bik;
import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.sdk.platformtools.x;

class a$5 implements OnClickListener {
    final /* synthetic */ a jNF;
    final /* synthetic */ bik jNG;

    a$5(a aVar, bik com_tencent_mm_protocal_c_bik) {
        this.jNF = aVar;
        this.jNG = com_tencent_mm_protocal_c_bik;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
        if (a.a(this.jNF) != null) {
            a.a(this.jNF).us(((eb) this.jNG.wLV.get(0)).url);
        }
    }
}

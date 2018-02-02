package com.tencent.mm.app.plugin;

import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.protocal.c.boo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;

class URISpanHandlerSet$DeeplinkUriSpanHandler$4 implements a {
    final /* synthetic */ DeeplinkUriSpanHandler fhm;
    final /* synthetic */ r fho;

    URISpanHandlerSet$DeeplinkUriSpanHandler$4(DeeplinkUriSpanHandler deeplinkUriSpanHandler, r rVar) {
        this.fhm = deeplinkUriSpanHandler;
        this.fho = rVar;
    }

    public final void a(int i, int i2, String str, k kVar, boolean z) {
        if (this.fho != null && this.fho.isShowing()) {
            this.fho.dismiss();
        }
        if (kVar != null && i != 0 && i2 != 0 && (kVar instanceof ak)) {
            boo Sq = ((ak) kVar).Sq();
            if (Sq != null && URISpanHandlerSet.a(this.fhm.fhe) != null) {
                u.makeText(URISpanHandlerSet.a(this.fhm.fhe), URISpanHandlerSet.a(this.fhm.fhe).getString(R.l.dGO) + " : " + bh.ou(Sq.wQX), 0).show();
            }
        }
    }
}

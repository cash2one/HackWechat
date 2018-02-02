package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler;
import com.tencent.mm.sdk.platformtools.x;

class URISpanHandlerSet$DeeplinkUriSpanHandler$2 implements OnClickListener {
    final /* synthetic */ d fhj;
    final /* synthetic */ String fhk;
    final /* synthetic */ String fhl;
    final /* synthetic */ DeeplinkUriSpanHandler fhm;

    URISpanHandlerSet$DeeplinkUriSpanHandler$2(DeeplinkUriSpanHandler deeplinkUriSpanHandler, d dVar, String str, String str2) {
        this.fhm = deeplinkUriSpanHandler;
        this.fhj = dVar;
        this.fhk = str;
        this.fhl = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.fhj.field_brandFlag;
        this.fhj.field_brandFlag &= -2;
        x.i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", new Object[]{this.fhk, this.fhl, Integer.valueOf(i2), Integer.valueOf(this.fhj.field_brandFlag)});
        f.f(this.fhj);
    }
}

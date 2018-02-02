package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.appbrand.b;

class URISpanHandlerSet$DeeplinkUriSpanHandler$3 implements OnClickListener {
    final /* synthetic */ DeeplinkUriSpanHandler fhm;
    final /* synthetic */ String fhn;

    URISpanHandlerSet$DeeplinkUriSpanHandler$3(DeeplinkUriSpanHandler deeplinkUriSpanHandler, String str) {
        this.fhm = deeplinkUriSpanHandler;
        this.fhn = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.URISpanHandlerSet", "AppBrandServiceHelper switchTo to receive msg for username %s", new Object[]{this.fhn});
        b.i(this.fhm.fhe.mContext, this.fhn, true);
    }
}

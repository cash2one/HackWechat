package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a;
import com.tencent.mm.sdk.platformtools.x;

class JsApiChooseMedia$a$8 implements OnCancelListener {
    final /* synthetic */ a jnj;

    JsApiChooseMedia$a$8(a aVar) {
        this.jnj = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.e("MicroMsg.JsApiChooseMedia", "cancel show the progress dialog and finish progress");
        a.e(this.jnj).bjW = 0;
        a.l(this.jnj, a.e(this.jnj));
    }
}

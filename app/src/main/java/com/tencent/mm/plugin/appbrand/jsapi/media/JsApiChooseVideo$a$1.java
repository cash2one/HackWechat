package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a;

class JsApiChooseVideo$a$1 implements OnCancelListener {
    final /* synthetic */ a jnv;

    JsApiChooseVideo$a$1(a aVar) {
        this.jnv = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a.a(this.jnv).bjW = 0;
        a.a(this.jnv, a.a(this.jnv));
    }
}

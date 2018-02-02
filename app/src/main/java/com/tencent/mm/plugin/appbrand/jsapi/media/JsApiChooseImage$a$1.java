package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a;

class JsApiChooseImage$a$1 implements OnCancelListener {
    final /* synthetic */ a jmQ;

    JsApiChooseImage$a$1(a aVar) {
        this.jmQ = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.jmQ.jmM.bjW = 0;
        a.a(this.jmQ, this.jmQ.jmM);
    }
}

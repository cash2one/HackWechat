package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.a;
import com.tencent.mm.sdk.platformtools.x;

class JsApiOpenDocument$a$1 implements ValueCallback<String> {
    final /* synthetic */ a jjF;

    JsApiOpenDocument$a$1(a aVar) {
        this.jjF = aVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, receiveValue = %s", new Object[]{(String) obj});
        if ("fileReaderClosed".equals((String) obj) && !a.a(this.jjF)) {
            a.b(this.jjF);
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.OpenResult;

class JsApiOpenDocument$1 implements b<OpenResult> {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiOpenDocument jjD;

    JsApiOpenDocument$1(JsApiOpenDocument jsApiOpenDocument, j jVar, int i) {
        this.jjD = jsApiOpenDocument;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final /* synthetic */ void c(ProcessResult processResult) {
        OpenResult openResult = (OpenResult) processResult;
        if (this.iZy.Vx) {
            String str;
            if (openResult != null) {
                switch (openResult.ret) {
                    case 0:
                        str = "ok";
                        break;
                    case Integer.MAX_VALUE:
                        str = "fail user cancel";
                        break;
                    default:
                        str = "fail file type not supported " + openResult.ret;
                        break;
                }
            }
            str = "fail env error";
            this.iZy.E(this.gOK, this.jjD.e(str, null));
        }
    }
}

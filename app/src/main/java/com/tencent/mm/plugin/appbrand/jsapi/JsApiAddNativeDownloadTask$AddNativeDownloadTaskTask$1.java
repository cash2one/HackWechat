package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.g.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask$1 extends c<i> {
    final /* synthetic */ AddNativeDownloadTaskTask jcJ;

    JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask$1(AddNativeDownloadTaskTask addNativeDownloadTaskTask) {
        this.jcJ = addNativeDownloadTaskTask;
        this.xen = i.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        i iVar = (i) bVar;
        if (!(iVar instanceof i)) {
            x.w("MicroMsg.JsApiAddNativeDownloadTask", "mismatched event");
            return false;
        } else if (iVar.fmX.scene != 1) {
            x.i("MicroMsg.JsApiAddNativeDownloadTask", "not jsapi api callback");
            return false;
        } else {
            if (iVar.fmX.fmY) {
                x.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, cancel");
                this.jcJ.fDt = 0;
                AddNativeDownloadTaskTask.a(this.jcJ);
            } else if (iVar.fmX.fmZ > 0) {
                new HashMap().put("download_id", Long.valueOf(iVar.fmX.fmZ));
                this.jcJ.fmZ = iVar.fmX.fmZ;
                x.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, ok downloadId:%s", new Object[]{Long.valueOf(this.jcJ.fmZ)});
                this.jcJ.fDt = 2;
                AddNativeDownloadTaskTask.b(this.jcJ);
            } else {
                x.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, failed");
                this.jcJ.fDt = 1;
                AddNativeDownloadTaskTask.c(this.jcJ);
            }
            a.xef.c(AddNativeDownloadTaskTask.d(this.jcJ));
            return true;
        }
    }
}

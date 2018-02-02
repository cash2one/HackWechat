package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.c.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$1 implements a {
    final /* synthetic */ JsApiUploadEncryptedMediaFileTask jnS;

    JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$1(JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask) {
        this.jnS = jsApiUploadEncryptedMediaFileTask;
    }

    public final void B(int i, String str) {
        x.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", new Object[]{Integer.valueOf(i), str});
        this.jnS.jnM = i;
        this.jnS.jnO = 3;
        JsApiUploadEncryptedMediaFileTask.a(this.jnS);
    }
}

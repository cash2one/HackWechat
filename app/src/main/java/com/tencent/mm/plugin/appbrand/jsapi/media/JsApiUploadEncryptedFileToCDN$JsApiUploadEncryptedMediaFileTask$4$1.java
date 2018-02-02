package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4;
import com.tencent.mm.sdk.platformtools.x;

class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4$1 implements OnClickListener {
    final /* synthetic */ 4 jnU;

    JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4$1(4 4) {
        this.jnU = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
        JsApiUploadEncryptedMediaFileTask.c(this.jnU.jnS).cancel();
        this.jnU.jnS.jnN = 1;
        this.jnU.jnS.jnO = 1;
        AppBrandMainProcessService.a(this.jnU.jnS);
    }
}

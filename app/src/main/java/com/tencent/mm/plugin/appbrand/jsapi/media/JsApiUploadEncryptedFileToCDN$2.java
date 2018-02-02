package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.sdk.platformtools.x;

class JsApiUploadEncryptedFileToCDN$2 implements OnClickListener {
    final /* synthetic */ JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask jnJ;
    final /* synthetic */ JsApiUploadEncryptedFileToCDN jnK;

    JsApiUploadEncryptedFileToCDN$2(JsApiUploadEncryptedFileToCDN jsApiUploadEncryptedFileToCDN, JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask) {
        this.jnK = jsApiUploadEncryptedFileToCDN;
        this.jnJ = jsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
        this.jnJ.afi();
        AppBrandMainProcessService.a(this.jnJ);
    }
}

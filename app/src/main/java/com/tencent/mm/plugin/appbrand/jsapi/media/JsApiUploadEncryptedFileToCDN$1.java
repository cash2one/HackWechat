package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiUploadEncryptedFileToCDN$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiUploadEncryptedMediaFileTask jnJ;
    final /* synthetic */ JsApiUploadEncryptedFileToCDN jnK;

    JsApiUploadEncryptedFileToCDN$1(JsApiUploadEncryptedFileToCDN jsApiUploadEncryptedFileToCDN, JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask, j jVar, int i) {
        this.jnK = jsApiUploadEncryptedFileToCDN;
        this.jnJ = jsApiUploadEncryptedMediaFileTask;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("fileId", this.jnJ.fzR);
        hashMap.put("aesKey", this.jnJ.hbp);
        hashMap.put("fileUrl", this.jnJ.fileUrl);
        hashMap.put("fileLength", this.jnJ.iFv);
        x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", new Object[]{this.jnJ.fzR});
        if (bh.ov(this.jnJ.fzR)) {
            x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
            this.iZy.E(this.gOK, this.jnK.e("fail", null));
        } else {
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
            this.iZy.E(this.gOK, this.jnK.e("ok", hashMap));
        }
        this.jnJ.afj();
    }
}

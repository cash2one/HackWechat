package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.c.a;
import com.tencent.mm.plugin.appbrand.c.c;
import com.tencent.mm.plugin.appbrand.c.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$2 implements b {
    final /* synthetic */ JsApiUploadEncryptedMediaFileTask jnS;
    final /* synthetic */ AppBrandLocalMediaObject jnT;

    JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$2(JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask, AppBrandLocalMediaObject appBrandLocalMediaObject) {
        this.jnS = jsApiUploadEncryptedMediaFileTask;
        this.jnT = appBrandLocalMediaObject;
    }

    public final void a(boolean z, String str, String str2, String str3) {
        x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
        if (!bh.ov(str) && str.equals(this.jnT.fus)) {
            f.Zr().a(this.jnS.jnQ);
            f.Zr().a(this.jnS.jnR);
            f.Zr();
            com.tencent.mm.plugin.appbrand.c.b.qh(this.jnT.fus);
            if (z) {
                this.jnS.fzR = str2;
                x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
            } else {
                x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
            }
            c Zq = f.Zq();
            String str4 = this.jnS.fzR;
            if (!bh.ov(str4)) {
                for (a aVar : Zq.iLF.values()) {
                    if (bh.ou(aVar.iLv).equals(str4)) {
                        break;
                    }
                }
            }
            x.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByServerId error, media id is null or nil");
            a aVar2 = null;
            if (aVar2 == null || aVar2.iLw == null) {
                x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
            } else {
                x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
                this.jnS.hbp = aVar2.iLw.field_aesKey;
                this.jnS.fzR = aVar2.iLw.field_fileId;
                this.jnS.fileUrl = aVar2.iLw.field_fileUrl;
                this.jnS.iFv = aVar2.iLw.field_fileLength;
                x.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", new Object[]{this.jnS.hbp, Integer.valueOf(this.jnS.iFv)});
            }
            this.jnS.jnO = 1;
            JsApiUploadEncryptedMediaFileTask.b(this.jnS);
        }
    }
}

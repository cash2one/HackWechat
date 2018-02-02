package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public final class JsApiUploadEncryptedFileToCDN extends a {
    public static final int CTRL_INDEX = 194;
    public static final String NAME = "uploadEncryptedFileToCDN";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        Context a = a(jVar);
        if (a == null) {
            x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
            jVar.E(i, e("fail", null));
        } else if (jSONObject == null) {
            x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
            jVar.E(i, e("fail:data is null", null));
        } else {
            String str = jVar.mAppId;
            String optString = jSONObject.optString("tempFilePath");
            boolean optBoolean = jSONObject.optBoolean("isShowProgressTips", false);
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", new Object[]{str, jSONObject.toString()});
            if (bh.ov(optString)) {
                x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
                jVar.E(i, e("fail:tempFilePath is null", null));
                return;
            }
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, optString);
            if (itemByLocalId == null) {
                x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
                jVar.E(i, e("fail:file doesn't exist", null));
            } else if (TextUtils.isEmpty(itemByLocalId.hhZ)) {
                x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
                jVar.E(i, e("fail:fileFullPath is null", null));
            } else {
                final MainProcessTask jsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask();
                jsApiUploadEncryptedMediaFileTask.appId = str;
                jsApiUploadEncryptedMediaFileTask.fus = optString;
                jsApiUploadEncryptedMediaFileTask.jnL = optBoolean;
                jsApiUploadEncryptedMediaFileTask.jnP = a;
                jsApiUploadEncryptedMediaFileTask.jcM = jVar;
                jsApiUploadEncryptedMediaFileTask.mimeType = itemByLocalId.mimeType;
                jsApiUploadEncryptedMediaFileTask.jcI = new 1(this, jsApiUploadEncryptedMediaFileTask, jVar, i);
                if (ab.bC(a)) {
                    x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
                    jsApiUploadEncryptedMediaFileTask.afi();
                    AppBrandMainProcessService.a(jsApiUploadEncryptedMediaFileTask);
                    return;
                }
                x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
                if (TextUtils.isEmpty(itemByLocalId.mimeType) || !itemByLocalId.mimeType.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                    str = a.getString(q.j.iBN);
                } else {
                    str = a.getString(q.j.iBT);
                }
                optString = bh.fK((long) e.bN(itemByLocalId.hhZ));
                h.a(a, a.getString(q.j.iBP, new Object[]{str, optString}), a.getString(q.j.dGO), new 2(this, jsApiUploadEncryptedMediaFileTask), new OnClickListener(this) {
                    final /* synthetic */ JsApiUploadEncryptedFileToCDN jnK;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
                        jVar.E(i, this.jnK.e("cancel", null));
                        jsApiUploadEncryptedMediaFileTask.afj();
                    }
                });
            }
        }
    }
}

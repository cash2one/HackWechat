package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiAddNativeDownloadTask extends a {
    private static final int CTRL_INDEX = 428;
    private static final String NAME = "addNativeDownloadTask";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiAddNativeDownloadTask", "data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        String optString = jSONObject.optString("taskName");
        String optString2 = jSONObject.optString("taskUrl");
        long j = bh.getLong(jSONObject.optString("taskSize"), 0);
        String optString3 = jSONObject.optString("fileMD5");
        String optString4 = jSONObject.optString("thumbUrl");
        String optString5 = jSONObject.optString("title");
        final Context context = jVar.getContext();
        x.i("MicroMsg.JsApiAddNativeDownloadTask", "taskUrl : %s, taskSize : %s, fileMD5:[%s], title : %s, thumbUrl : %s", new Object[]{optString2, Long.valueOf(j), optString3, optString5, optString4});
        if (!an.isNetworkConnected(context)) {
            jVar.E(i, e("fail:fail network not connected", null));
            ag.y(new 1(this, context));
            x.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, network not ready");
        } else if (!f.ze()) {
            jVar.E(i, e("fail:fail sdcard not ready", null));
            ag.y(new Runnable(this) {
                final /* synthetic */ JsApiAddNativeDownloadTask jcF;

                public final void run() {
                    Toast.makeText(context, context.getString(q.j.emj), 0).show();
                }
            });
            x.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, sdcard not ready");
        } else if (j > 0 && !f.aC(j)) {
            jVar.E(i, e("fail:fail sdcard has not enough space", null));
            ag.y(new 3(this, context));
            x.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, not enough space, require size = " + j);
        } else if (bh.ov(optString2)) {
            x.e("MicroMsg.JsApiAddNativeDownloadTask", "doAddDownloadTask fail, url is null");
            jVar.E(i, e("fail:taskUrl is null or nil", null));
        } else {
            Intent intent = new Intent();
            intent.putExtra("task_name", optString);
            intent.putExtra("task_url", optString2);
            intent.putExtra("task_size", j);
            intent.putExtra("file_md5", optString3);
            intent.putExtra("appid", jVar.mAppId);
            intent.putExtra("thumb_url", optString4);
            intent.putExtra("title", optString5);
            p b = b(jVar);
            if (b != null) {
                intent.putExtra("page_url", b.getURL());
            } else {
                x.e("MicroMsg.JsApiAddNativeDownloadTask", "getCurrentPageView is null");
            }
            intent.putExtra("page_scene", 1);
            d.b(context, "webview", ".ui.tools.WebViewDownloadUI", intent);
            MainProcessTask addNativeDownloadTaskTask = new AddNativeDownloadTaskTask();
            addNativeDownloadTaskTask.jcI = new 4(this, addNativeDownloadTaskTask, jVar, i);
            addNativeDownloadTaskTask.afi();
            AppBrandMainProcessService.a(addNativeDownloadTaskTask);
        }
    }
}

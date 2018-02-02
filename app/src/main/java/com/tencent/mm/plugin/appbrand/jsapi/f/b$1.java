package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class b$1 implements a {
    final /* synthetic */ String fgU;
    final /* synthetic */ j iZy;
    final /* synthetic */ String jos;
    final /* synthetic */ String jot;
    final /* synthetic */ b jou;

    b$1(b bVar, String str, j jVar, String str2, String str3) {
        this.jou = bVar;
        this.jos = str;
        this.iZy = jVar;
        this.jot = str2;
        this.fgU = str3;
    }

    public final void c(int i, String str, String str2, int i2) {
        x.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %s", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)});
        if (bh.ov(this.jos)) {
            if (com.tencent.mm.plugin.appbrand.j.a.FAILED != i) {
                AppBrandLocalMediaObject z = b.z(this.fgU, str2, str);
                if (z != null) {
                    x.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode localId %s", new Object[]{z.fus});
                    Map hashMap = new HashMap();
                    hashMap.put("downloadTaskId", this.jot);
                    hashMap.put("tempFilePath", z.fus);
                    hashMap.put("statusCode", Integer.valueOf(i2));
                    hashMap.put("state", "success");
                    String jSONObject = new JSONObject(hashMap).toString();
                    f a = new b.a().a(this.iZy);
                    a.mData = jSONObject;
                    a.afs();
                    return;
                }
            }
            if (!b.a(this.iZy, this.jot)) {
                b.b(this.iZy, this.jot, "download fail");
                return;
            }
            return;
        }
        jSONObject = ac.a(this.iZy.irP, str2, this.jos);
        if (com.tencent.mm.plugin.appbrand.j.a.FAILED != i && "ok".equals(jSONObject)) {
            x.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode filePath %s", new Object[]{this.jos});
            Map hashMap2 = new HashMap();
            hashMap2.put("downloadTaskId", this.jot);
            hashMap2.put(DownloadInfoColumns.FILEPATH, this.jos);
            hashMap2.put("statusCode", Integer.valueOf(i2));
            hashMap2.put("state", "success");
            jSONObject = new JSONObject(hashMap2).toString();
            a = new b.a().a(this.iZy);
            a.mData = jSONObject;
            a.afs();
        } else if (!b.a(this.iZy, this.jot)) {
            b.b(this.iZy, this.jot, jSONObject);
        }
    }

    public final void f(int i, long j, long j2) {
        Map hashMap = new HashMap();
        hashMap.put("downloadTaskId", this.jot);
        hashMap.put("state", "progressUpdate");
        hashMap.put("progress", Integer.valueOf(i));
        hashMap.put("totalBytesWritten", Long.valueOf(j));
        hashMap.put("totalBytesExpectedToWrite", Long.valueOf(j2));
        String jSONObject = new JSONObject(hashMap).toString();
        f a = new b.a().a(this.iZy);
        a.mData = jSONObject;
        a.afs();
    }

    public final void sB(String str) {
        if (!b.a(this.iZy, this.jot)) {
            b.b(this.iZy, this.jot, str);
        }
    }
}

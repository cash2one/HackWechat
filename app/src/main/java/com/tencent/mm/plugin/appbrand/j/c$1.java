package com.tencent.mm.plugin.appbrand.j;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

class c$1 implements Runnable {
    final /* synthetic */ j iZy;
    final /* synthetic */ JSONObject jBq;
    final /* synthetic */ c$a jBr;
    final /* synthetic */ int jBs;
    final /* synthetic */ Map jBt;
    final /* synthetic */ ArrayList jBu;
    final /* synthetic */ String jBv;
    final /* synthetic */ c jBw;
    final /* synthetic */ e jbX;
    final /* synthetic */ String jbj;

    c$1(c cVar, j jVar, JSONObject jSONObject, e eVar, c$a com_tencent_mm_plugin_appbrand_j_c_a, int i, Map map, ArrayList arrayList, String str, String str2) {
        this.jBw = cVar;
        this.iZy = jVar;
        this.jBq = jSONObject;
        this.jbX = eVar;
        this.jBr = com_tencent_mm_plugin_appbrand_j_c_a;
        this.jBs = i;
        this.jBt = map;
        this.jBu = arrayList;
        this.jBv = str;
        this.jbj = str2;
    }

    public final void run() {
        if (l.a(this.iZy, this.jBq, this.jbX)) {
            String optString = this.jBq.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            Object opt = this.jBq.opt(SlookAirButtonFrequentContactAdapter.DATA);
            String optString2 = this.jBq.optString("method");
            if (bh.ov(optString2)) {
                optString2 = "GET";
            }
            if (TextUtils.isEmpty(optString)) {
                this.jBr.sC("url is null");
                return;
            } else if (URLUtil.isHttpsUrl(optString) || URLUtil.isHttpUrl(optString)) {
                byte[] bArr = new byte[0];
                if (opt != null && c.tr(optString2)) {
                    if (opt instanceof String) {
                        bArr = ((String) opt).getBytes(Charset.forName("UTF-8"));
                    } else if (opt instanceof ByteBuffer) {
                        bArr = c.j((ByteBuffer) opt);
                    }
                }
                synchronized (this.jBw.jBp) {
                    if (this.jBw.jBp.size() >= this.jBw.jBf) {
                        this.jBr.sC("max connected");
                        x.i("MicroMsg.AppBrandNetworkRequest", "max connected");
                        return;
                    }
                    x.i("MicroMsg.AppBrandNetworkRequest", "method %s ,url %s timeout %s", new Object[]{optString2, optString, Integer.valueOf(this.jBs)});
                    d dVar = new d(optString, bArr, this.jBs, this.jBr, optString2);
                    dVar.jBB = this.jBt;
                    dVar.jBC = this.jBu;
                    dVar.jBG = this.jBv;
                    dVar.jBE = this.jBq.optString("responseType", "text");
                    synchronized (this.jBw.jBp) {
                        this.jBw.jBp.add(dVar);
                    }
                    dVar.jbo = this.jbj;
                    c.a(this.jBw, dVar);
                    return;
                }
            } else {
                this.jBr.sC("request protocol must be http or https");
                return;
            }
        }
        this.jBr.sC(this.jbX.jbZ);
    }
}

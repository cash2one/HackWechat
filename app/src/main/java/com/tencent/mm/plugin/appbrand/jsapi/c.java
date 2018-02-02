package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public abstract class c {
    public h jbH = new h();
    private final AtomicInteger jbI = new AtomicInteger(0);
    private final SparseArray<a> jbJ = new SparseArray();

    public abstract e YQ();

    public abstract b YR();

    public abstract void a(String str, String str2, int[] iArr);

    public abstract boolean isRunning();

    public void h(String str, String str2, int i) {
        if (bh.ov(str2)) {
            str2 = "{}";
        }
        x.d("MicroMsg.AppBrandComponent", "dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), Integer.valueOf(i));
        b YR = YR();
        String str3 = "typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.subscribeHandler(\"%s\", %s, %s, %s)";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = i == 0 ? "undefined" : String.valueOf(i);
        objArr[3] = Cc();
        YR.evaluateJavascript(String.format(str3, objArr), null);
    }

    public void E(int i, String str) {
        if (isRunning()) {
            if (bh.ov(str)) {
                str = "{}";
            }
            x.d("MicroMsg.AppBrandComponent", "callbackId: %d, data size: %d", Integer.valueOf(i), Integer.valueOf(str.length()));
            a ko = ko(i);
            if (ko == null) {
                x.e("MicroMsg.AppBrandComponent", "callbackid = [%d] This is a Sync Api, No callback runtime stored.");
                return;
            }
            ko.jbK.evaluateJavascript(String.format("typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(ko.id), str}), null);
            this.jbH.H(i, str);
            return;
        }
        x.e("MicroMsg.AppBrandComponent", "callback but destroyed, callbackId %d", Integer.valueOf(i));
    }

    public static String Cc() {
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        return new JSONObject(hashMap).toString();
    }

    public String getAppId() {
        return YQ().mAppId;
    }

    public void cleanup() {
        synchronized (this.jbJ) {
            this.jbJ.clear();
        }
    }

    public int a(b bVar, int i) {
        if (i == 0) {
            return 0;
        }
        int incrementAndGet = this.jbI.incrementAndGet();
        synchronized (this.jbJ) {
            this.jbJ.put(incrementAndGet, new a(bVar, i));
        }
        return incrementAndGet;
    }

    private a ko(int i) {
        a aVar;
        synchronized (this.jbJ) {
            aVar = (a) this.jbJ.get(i);
        }
        return aVar;
    }

    public void onResume() {
    }

    public String acw() {
        return null;
    }
}

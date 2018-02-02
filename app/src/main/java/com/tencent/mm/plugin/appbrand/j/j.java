package com.tencent.mm.plugin.appbrand.j;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.r.e.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j {
    private SSLSocketFactory iQZ;
    protected final ArrayList<com.tencent.mm.plugin.appbrand.r.a.a> jBS = new ArrayList();
    private int jBf;
    private final String jBi;
    private String mAppId;

    public interface a {
        void C(int i, String str);

        void a(h hVar);

        void e(ByteBuffer byteBuffer);

        void re(String str);

        void rf(String str);

        void rg(String str);
    }

    public j(String str, String str2, AppBrandSysConfig appBrandSysConfig) {
        this.mAppId = str;
        SSLContext tx = i.tx(str);
        if (tx != null) {
            this.iQZ = tx.getSocketFactory();
        }
        this.jBi = str2;
        this.jBf = appBrandSysConfig.iOt;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(String str, int i, JSONObject jSONObject, Map<String, String> map, final a aVar) {
        synchronized (this.jBS) {
            if (this.jBS.size() >= this.jBf) {
                aVar.rg("max connected");
                x.i("MicroMsg.AppBrandNetworkWebSocket", "max connected");
            }
        }
    }

    private void a(com.tencent.mm.plugin.appbrand.r.a.a aVar) {
        synchronized (this.jBS) {
            if ("0".equals(aVar.jbo)) {
                this.jBS.clear();
            }
            this.jBS.add(aVar);
        }
    }

    public final synchronized void b(com.tencent.mm.plugin.appbrand.r.a.a aVar) {
        if (aVar != null) {
            synchronized (this.jBS) {
                this.jBS.remove(aVar);
            }
        }
    }

    public static void c(com.tencent.mm.plugin.appbrand.r.a.a aVar) {
        if (aVar != null) {
            Timer timer = aVar.bnp;
            x.i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
            if (timer != null) {
                timer.cancel();
                aVar.bnp = null;
            }
        }
    }

    private static String w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterable linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("protocols");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                linkedList.add(optJSONArray.optString(i));
            }
        }
        return !bh.cA(linkedList) ? TextUtils.join(", ", linkedList) : null;
    }

    public final com.tencent.mm.plugin.appbrand.r.a.a tA(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.jBS) {
            Iterator it = this.jBS.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.appbrand.r.a.a aVar = (com.tencent.mm.plugin.appbrand.r.a.a) it.next();
                if (str.equals(aVar.jbo)) {
                    return aVar;
                }
            }
            return null;
        }
    }
}

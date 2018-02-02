package com.tencent.mm.plugin.appbrand.j;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.b.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class f {
    private final ArrayList<g> jBI = new ArrayList();
    private int jBf;
    SSLContext jBh;
    final String jBi;
    protected final ArrayList<String> jBj = new ArrayList();
    String mAppId;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] iGZ = new int[a.values().length];

        static {
            try {
                iGZ[a.iGS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iGZ[a.iGT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public f(String str, String str2, AppBrandSysConfig appBrandSysConfig) {
        this.mAppId = str;
        this.jBf = appBrandSysConfig.iOr;
        this.jBi = str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, String str, String str2, JSONObject jSONObject, Map<String, String> map, ArrayList<String> arrayList, a aVar, String str3, String str4, String str5) {
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        Object optString2 = jSONObject.optString("name");
        Map v = i.v(jSONObject);
        synchronized (this.jBI) {
            if (this.jBI.size() >= this.jBf) {
                aVar.sD("tasked refused max connected");
                x.i("MicroMsg.AppBrandNetworkUpload", "max connected");
            }
        }
    }

    public final g tu(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.jBI) {
            Iterator it = this.jBI.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (str.equals(gVar.jbo)) {
                    return gVar;
                }
            }
            return null;
        }
    }

    public final void a(g gVar) {
        if (gVar != null) {
            this.jBj.add(gVar.jbo);
            gVar.bgH = false;
            a(gVar.jbo, gVar.jBF);
        }
    }

    public final boolean to(String str) {
        return this.jBj.contains(str);
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        if (str != null) {
            synchronized (this.jBI) {
                Iterator it = this.jBI.iterator();
                while (it.hasNext()) {
                    g gVar = (g) it.next();
                    if (str.equals(gVar.jbo)) {
                        this.jBI.remove(gVar);
                        break;
                    }
                }
            }
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }
}

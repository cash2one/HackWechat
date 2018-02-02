package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static boolean jhB = false;
    public static j jhC = null;
    public static int jhD = 0;
    private static Map<String, JSONObject> jhE;
    private static JSONArray jhF;
    private static JSONArray jhG;

    public static Map<String, JSONObject> afS() {
        if (jhE == null) {
            jhE = new ConcurrentHashMap();
        }
        return jhE;
    }

    public static void afT() {
        if (jhE != null) {
            jhE.clear();
            jhE = null;
        }
    }

    public static j afU() {
        return jhC;
    }

    public static void e(j jVar) {
        jhC = jVar;
    }

    public static int afV() {
        return jhD;
    }

    public static void ku(int i) {
        jhD = i;
    }

    public static void afW() {
        if (jhF != null) {
            jhF = null;
        }
    }

    public static void afX() {
        if (jhG != null) {
            jhG = null;
        }
    }

    private static String f(j jVar) {
        return "JsApi#BluetoothSessionId" + jVar.hashCode();
    }

    public static com.tencent.mm.z.u.b g(j jVar) {
        String f = f(jVar);
        com.tencent.mm.z.u.b hx = u.GK().hx(f);
        if (hx != null) {
            return hx;
        }
        x.d("MicroMsg.JsApiBluetoothUtil", "getDataStore true!");
        return u.GK().t(f, true);
    }

    public static void h(j jVar) {
        com.tencent.mm.z.u.b hy = u.GK().hy(f(jVar));
        if (hy != null) {
            hy.recycle();
            x.d("MicroMsg.JsApiBluetoothUtil", "removeDataKeyValueSet!");
        }
    }
}

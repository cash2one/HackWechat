package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.config.d.b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public e iMA;
    public c iMB;
    public a iMC;
    public boolean iMD = true;
    public JSONObject iME;
    public String iMF;
    public b iMy;
    private Map<String, d> iMz;

    public static class a {
        String iMG;
        public boolean iMH;
    }

    public static class c {
        public int fLk;
        public int iMI;
        public int iMJ;
        public int iMK;
    }

    public final d qz(String str) {
        if (this.iMz.containsKey(str)) {
            return (d) this.iMz.get(str);
        }
        return b(null, this.iMy);
    }

    public final String abL() {
        return this.iMC == null ? b.iNe.name().toLowerCase() : this.iMC.iMG;
    }

    public final String abM() {
        if (bh.ov(this.iMF)) {
            return "index.html";
        }
        return this.iMF;
    }

    public static a m(e eVar) {
        JSONObject jSONObject;
        String a = ah.a(eVar, "app-config.json");
        a aVar = new a();
        try {
            jSONObject = new JSONObject(a);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandAppConfig", e.getMessage());
            jSONObject = new JSONObject();
        }
        aVar.iMF = jSONObject.optString("entryPagePath");
        aVar.iME = jSONObject;
        JSONObject optJSONObject = jSONObject.optJSONObject("global");
        g bVar = new b();
        a(optJSONObject, bVar, bVar);
        if (ac.cfu().getBoolean("appbrand_new_actionbar", false)) {
            bVar.iMT = "custom";
        }
        aVar.iMy = bVar;
        aVar.iMz = a(jSONObject.optJSONObject("page"), aVar.iMy);
        aVar.iMA = f(jSONObject.optJSONObject("tabBar"));
        optJSONObject = jSONObject.optJSONObject("networkTimeout");
        c cVar = new c();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        cVar.fLk = optJSONObject.optInt("request");
        cVar.iMI = optJSONObject.optInt("connectSocket");
        cVar.iMK = optJSONObject.optInt("downloadFile");
        cVar.iMJ = optJSONObject.optInt("uploadFile");
        aVar.iMB = cVar;
        if (eVar.Yz()) {
            a aVar2 = new a();
            aVar2.iMG = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.iMH = jSONObject.optBoolean("showStatusBar", false);
            aVar.iMC = aVar2;
        }
        aVar.iMD = jSONObject.optBoolean("preloadEnabled", true);
        return aVar;
    }

    private static <T extends g> T a(JSONObject jSONObject, T t, g gVar) {
        if (jSONObject == null) {
            jSONObject = g.iNb;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            optJSONObject = g.iNb;
        }
        t.iMQ = optJSONObject.optString("navigationBarTitleText", gVar.iMQ);
        t.iMR = optJSONObject.optString("navigationBarTextStyle", gVar.iMR);
        t.iMT = optJSONObject.optString("navigationStyle", gVar.iMT);
        t.iMU = optJSONObject.optString("navigationBarBackgroundColor", gVar.iMU);
        t.iMN = optJSONObject.optString("backgroundColor", gVar.iMN);
        t.iMZ = optJSONObject.optBoolean("enablePullDownRefresh", gVar.iMZ);
        t.iNa = optJSONObject.optString("backgroundTextStyle", gVar.iNa);
        t.iMY = optJSONObject.optBoolean("enableFullScreen", gVar.iMY);
        optJSONObject = optJSONObject.optJSONObject("navigationBarRightButton");
        if (optJSONObject == null) {
            optJSONObject = g.iNb;
        }
        t.iMX = optJSONObject.optBoolean("hide", gVar.iMX);
        t.iMV = optJSONObject.optString("text", gVar.iMV);
        t.iMW = optJSONObject.optString("iconPath", gVar.iMW);
        return t;
    }

    private static Map<String, d> a(JSONObject jSONObject, b bVar) {
        Map<String, d> hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, b(jSONObject.optJSONObject(str), bVar));
        }
        return hashMap;
    }

    private static d b(JSONObject jSONObject, b bVar) {
        return (d) a(jSONObject, new d(), bVar);
    }

    private static e f(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        e eVar = new e();
        eVar.iML = jSONObject.optString("position");
        eVar.hbM = jSONObject.optString("color");
        eVar.iMM = jSONObject.optString("selectedColor");
        eVar.iMN = jSONObject.optString("backgroundColor");
        eVar.iMO = jSONObject.optString("borderStyle");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            for (int i = 0; i < jSONArray.length(); i++) {
                ArrayList arrayList = eVar.fBU;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                f fVar = new f();
                fVar.url = jSONObject2.optString("pagePath");
                fVar.text = jSONObject2.optString("text");
                fVar.fDI = jSONObject2.optString("iconData");
                fVar.iMP = jSONObject2.optString("selectedIconData");
                arrayList.add(fVar);
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandAppConfig", e.getMessage());
        }
        return eVar;
    }
}

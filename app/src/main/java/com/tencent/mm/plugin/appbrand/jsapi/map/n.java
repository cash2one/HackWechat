package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n extends c {
    public static final int CTRL_INDEX = 4;
    public static final String NAME = "updateMap";

    protected final int i(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", e);
        }
        return i;
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        b y = pVar.aeF().y(i, false);
        if (y == null) {
            x.i("MicroMsg.JsApiUpdateMap", "KeyValueSet(%s) is null.", Integer.valueOf(i));
            return false;
        } else if (view instanceof CoverViewContainer) {
            try {
                com.tencent.mm.plugin.appbrand.compat.a.b bE = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bE(((CoverViewContainer) view).w(View.class));
                if (bE == null) {
                    x.w("MicroMsg.JsApiUpdateMap", "MapView(%s) is null", Integer.valueOf(i));
                    return false;
                }
                if (jSONObject.has("scale")) {
                    bE.jM(jSONObject.optInt("scale", 16));
                }
                try {
                    float optDouble;
                    if (jSONObject.has("covers")) {
                        List list;
                        int i2;
                        List list2 = (List) y.get("converters", null);
                        if (list2 == null) {
                            ArrayList arrayList = new ArrayList();
                            y.o("converters", arrayList);
                            list = arrayList;
                        } else {
                            list = list2;
                        }
                        if (list.size() > 0) {
                            for (i2 = 0; i2 < list.size(); i2++) {
                                ((h) list.get(i2)).remove();
                            }
                            list.clear();
                        }
                        JSONArray jSONArray = new JSONArray(jSONObject.optString("covers"));
                        for (i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                            float f = bh.getFloat(jSONObject2.optString("latitude"), 0.0f);
                            float f2 = bh.getFloat(jSONObject2.optString("longitude"), 0.0f);
                            String optString = jSONObject2.optString("iconPath");
                            optDouble = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                            i abw = bE.abw();
                            abw.f((double) f, (double) f2);
                            Bitmap j = o.j(pVar.irP, optString);
                            if (!(j == null || j.isRecycled())) {
                                abw.p(j);
                            }
                            abw.T(optDouble);
                            h a = bE.a(abw);
                            a.qw("cover");
                            list.add(a);
                        }
                    }
                    if (jSONObject.has("centerLatitude")) {
                        if (jSONObject.has("centerLongitude")) {
                            optDouble = bh.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
                            float f3 = bh.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
                            if (Math.abs(optDouble) <= 90.0f && Math.abs(f3) <= 180.0f) {
                                bE.setCenter((double) optDouble, (double) f3);
                            }
                        }
                    }
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiUpdateMap", "parse covers error, exception : %s", e);
                    return false;
                }
            } catch (Exception e2) {
                x.e("MicroMsg.JsApiUpdateMap", "get SoSoMapView(%s) by id failed, exception : %s", Integer.valueOf(i), e2);
                return false;
            }
        } else {
            x.w("MicroMsg.JsApiUpdateMap", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
            return false;
        }
    }
}

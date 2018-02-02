package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.SensorManager;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.b.m;
import com.tencent.mm.plugin.appbrand.compat.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_INDEX = 2;
    public static final String NAME = "insertMap";

    protected final View a(p pVar, JSONObject jSONObject) {
        float f = bh.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
        float f2 = bh.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
        if (Math.abs(f) > 90.0f || Math.abs(f2) > 180.0f) {
            x.d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
            return null;
        }
        Context context = pVar.mContext;
        b bP = ((c) g.h(c.class)).bP(context);
        bP.getView().setVisibility(0);
        return new CoverViewContainer(context, bP.getView());
    }

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("mapId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        final b bE = ((c) g.h(c.class)).bE(((CoverViewContainer) view).w(View.class));
        u.b y = pVar.aeF().y(i, true);
        if (jSONObject.optBoolean("showLocation")) {
            u.b y2 = pVar.aeF().y(i, true);
            com.tencent.mm.plugin.appbrand.q.b.b 5 = new 5(this, pVar, y2, i, bE);
            com.tencent.mm.plugin.appbrand.q.b.a.b.alN().a(5);
            Object bVar = new b(this, i, y2);
            SensorManager sensorManager = (SensorManager) ac.getContext().getSystemService("sensor");
            sensorManager.registerListener(bVar, sensorManager.getDefaultSensor(3), 1);
            if (((e) y2.get("mapDestroyListener", null)) == null) {
                e 6 = new 6(this, pVar, bE, sensorManager, bVar, 5, y2);
                y2.o("mapDestroyListener", 6);
                pVar.a(6);
            }
        } else {
            if (((e) y.get("mapDestroyListener", null)) == null) {
                e 1 = new 1(this, pVar, bE, y);
                y.o("mapDestroyListener", 1);
                pVar.a(1);
            }
        }
        final JSONObject jSONObject2 = jSONObject;
        bE.a(new m(this) {
            final /* synthetic */ i jmd;

            public final void abz() {
                x.i("MicroMsg.JsApiInsertMap", "onMapLoaded");
                float f = bh.getFloat(jSONObject2.optString("centerLatitude"), 0.0f);
                float f2 = bh.getFloat(jSONObject2.optString("centerLongitude"), 0.0f);
                if (Math.abs(f) > 90.0f || Math.abs(f2) > 180.0f) {
                    x.e("MicroMsg.JsApiInsertMap", "[onMapLoaded] centerLatitude or centerLongitude value is error!");
                    return;
                }
                bE.a((double) f, (double) f2, jSONObject2.optInt("scale", 16));
            }
        });
        bE.a(new 3(this, i, pVar));
        bE.a(new 4(this, i, pVar));
        try {
            List arrayList;
            JSONArray jSONArray;
            int i2;
            JSONObject jSONObject3;
            float f;
            float f2;
            String uE;
            com.tencent.mm.plugin.appbrand.compat.a.b.i abw;
            if (jSONObject.has("markers")) {
                arrayList = new ArrayList();
                jSONArray = new JSONArray(jSONObject.optString("markers"));
                for (i2 = 0; i2 < jSONArray.length(); i2++) {
                    jSONObject3 = (JSONObject) jSONArray.get(i2);
                    f = bh.getFloat(jSONObject3.optString("latitude"), 0.0f);
                    f2 = bh.getFloat(jSONObject3.optString("longitude"), 0.0f);
                    uE = com.tencent.mm.plugin.appbrand.q.c.uE(jSONObject3.optString("name"));
                    String uE2 = com.tencent.mm.plugin.appbrand.q.c.uE(jSONObject3.optString("desc"));
                    abw = bE.abw();
                    abw.f((double) f, (double) f2);
                    abw.qx(uE);
                    if (!bh.ov(uE2)) {
                        abw.qy(uE2);
                    }
                    arrayList.add(bE.a(abw));
                }
                y.o("markers", arrayList);
            }
            try {
                if (jSONObject.has("covers")) {
                    arrayList = new ArrayList();
                    jSONArray = new JSONArray(jSONObject.optString("covers"));
                    for (i2 = 0; i2 < jSONArray.length(); i2++) {
                        jSONObject3 = (JSONObject) jSONArray.get(i2);
                        f = bh.getFloat(jSONObject3.optString("latitude"), 0.0f);
                        f2 = bh.getFloat(jSONObject3.optString("longitude"), 0.0f);
                        uE = jSONObject3.optString("iconPath");
                        float optDouble = (float) jSONObject3.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                        abw = bE.abw();
                        abw.f((double) f, (double) f2);
                        Bitmap j = o.j(pVar.irP, uE);
                        if (!(j == null || j.isRecycled())) {
                            abw.p(j);
                        }
                        abw.T(optDouble);
                        h a = bE.a(abw);
                        a.qw("cover");
                        arrayList.add(a);
                    }
                    y.o("converters", arrayList);
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiInsertMap", "parse covers error, exception : %s", new Object[]{e});
            }
        } catch (Exception e2) {
            x.e("MicroMsg.JsApiInsertMap", "parse markers error, exception : %s", new Object[]{e2});
        }
    }
}

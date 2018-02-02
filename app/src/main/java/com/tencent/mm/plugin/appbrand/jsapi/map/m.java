package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.e.a;
import com.tencent.mm.plugin.appbrand.widget.e.c;
import com.tencent.mm.plugin.appbrand.widget.e.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m extends a {
    public static final int CTRL_INDEX = 200;
    public static final String NAME = "translateMapMarker";
    private static final LinkedList<JSONObject> jmp = new LinkedList();
    private p jia;
    private b jlW;
    private a.a jmq;
    private h jmr;
    private double jms;
    private double jmt;
    private int jmu;
    private f jmv;
    private a jmw = new 1(this);

    static /* synthetic */ void a(m mVar, JSONObject jSONObject) {
        boolean z;
        int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
        if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
            float optDouble = (float) jSONObject.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
            float rotation = mVar.jmr.getRotation();
            c cVar = new c(mVar.jmr, (long) optInt, rotation, optDouble + rotation);
            cVar.a(new 2(mVar));
            cVar.anF();
            z = true;
        } else {
            z = false;
        }
        b.f[] fVarArr = new b.f[2];
        if (jSONObject.has("latitude") && jSONObject.has("longitude")) {
            float f = bh.getFloat(jSONObject.optString("latitude"), 0.0f);
            float f2 = bh.getFloat(jSONObject.optString("longitude"), 0.0f);
            fVarArr[0] = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).e(mVar.jms, mVar.jmt);
            fVarArr[1] = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).e((double) f, (double) f2);
            mVar.jms = (double) f;
            mVar.jmt = (double) f2;
            d dVar = new d(mVar.jmr, mVar.jlW, (long) optInt, fVarArr, z);
            dVar.a(new 3(mVar));
            dVar.anF();
        }
    }

    protected final int i(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiTranslateMapMarker", "get mapId error, exception : %s", e);
        }
        return i;
    }

    protected final boolean a(p pVar, int i, View view, JSONObject jSONObject, a.a aVar, f fVar) {
        this.jmq = aVar;
        this.jia = pVar;
        this.jmu = i;
        this.jmv = fVar;
        u.b y = pVar.aeF().y(i, false);
        if (y == null) {
            x.e("MicroMsg.JsApiTranslateMapMarker", "KeyValueSet(%s) is null.", Integer.valueOf(i));
            fVar.sj(e("fail", null));
            return false;
        } else if (view instanceof CoverViewContainer) {
            String optString = jSONObject.optString("markerId");
            Map map = (Map) y.get("marker", null);
            if (map == null || map.size() < 0) {
                x.e("MicroMsg.JsApiTranslateMapMarker", "markerMap is empty!");
                fVar.sj(e("fail", null));
                return false;
            }
            this.jmr = (h) map.get(optString);
            if (this.jmr == null) {
                x.e("MicroMsg.JsApiTranslateMapMarker", "get marker failed!");
                fVar.sj(e("fail", null));
                return false;
            }
            this.jlW = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bE(((CoverViewContainer) view).w(View.class));
            try {
                this.jms = this.jmr.abE().abC();
                this.jmt = this.jmr.abE().abD();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("keyFrames"));
                x.d("MicroMsg.JsApiTranslateMapMarker", "keyFramesArray size :%d", Integer.valueOf(jSONArray.length()));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    jmp.add((JSONObject) jSONArray.get(i2));
                }
                this.jmw.afh();
                return true;
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", e);
                fVar.sj(e("fail", null));
                return false;
            }
        } else {
            x.w("MicroMsg.JsApiTranslateMapMarker", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
            return false;
        }
    }

    protected final boolean afN() {
        return true;
    }
}

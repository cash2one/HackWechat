package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.compat.a.b.o;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.base.c {
    public static final int CTRL_INDEX = 134;
    public static final String NAME = "addMapLines";

    protected final int i(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapLines", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        b y = pVar.aeF().y(i, false);
        if (y == null) {
            x.e("MicroMsg.JsApiAddMapLines", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        } else if (view instanceof CoverViewContainer) {
            try {
                com.tencent.mm.plugin.appbrand.compat.a.b bE = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bE(((CoverViewContainer) view).w(View.class));
                if (jSONObject == null) {
                    x.e("MicroMsg.JsApiAddMapLines", "data is null");
                    return false;
                }
                x.d("MicroMsg.JsApiAddMapLines", "onUpdateView, data:%s", new Object[]{jSONObject.toString()});
                try {
                    if (jSONObject.has("lines")) {
                        List list;
                        int i2;
                        List list2 = (List) y.get("map_line", null);
                        if (list2 == null) {
                            ArrayList arrayList = new ArrayList();
                            y.o("map_line", arrayList);
                            list = arrayList;
                        } else {
                            list = list2;
                        }
                        if (list.size() > 0) {
                            for (i2 = 0; i2 < list.size(); i2++) {
                                ((o) list.get(i2)).remove();
                            }
                            list.clear();
                        }
                        JSONArray jSONArray = new JSONArray(jSONObject.optString("lines"));
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                            Iterable arrayList2 = new ArrayList();
                            JSONArray jSONArray2 = new JSONArray(jSONObject2.optString("points"));
                            for (i2 = 0; i2 < jSONArray2.length(); i2++) {
                                JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                                arrayList2.add(bE.e((double) bh.getFloat(jSONObject3.optString("latitude"), 0.0f), (double) bh.getFloat(jSONObject3.optString("longitude"), 0.0f)));
                            }
                            i2 = f.aP(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                            int a = f.a(jSONObject2, "width", 0);
                            boolean optBoolean = jSONObject2.optBoolean("dottedLine", false);
                            int aP = f.aP(jSONObject2.optString("borderColor", ""), Color.parseColor("#000000"));
                            int a2 = f.a(jSONObject2, "borderWidth", 0);
                            boolean optBoolean2 = jSONObject2.optBoolean("arrowLine", false);
                            String optString = jSONObject2.optString("arrowIconPath", "");
                            com.tencent.mm.plugin.appbrand.compat.a.b.p aby = bE.aby();
                            aby.a(arrayList2);
                            aby.jN(i2);
                            aby.jO(a);
                            aby.setDottedLine(optBoolean);
                            aby.jP(aP);
                            aby.jQ(a2);
                            if (optBoolean2) {
                                Object obj = 1;
                                Bitmap decodeFile;
                                if (!bh.ov(optString) && optString.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                                    AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(pVar.mAppId, optString);
                                    if (itemByLocalId == null || TextUtils.isEmpty(itemByLocalId.hhZ)) {
                                        x.e("MicroMsg.JsApiAddMapLines", "arrowIconPath:%s, item is null", new Object[]{optString});
                                    } else {
                                        x.d("MicroMsg.JsApiAddMapLines", "fileFullPath:%s", new Object[]{itemByLocalId.hhZ});
                                        decodeFile = d.decodeFile(itemByLocalId.hhZ, null);
                                        if (decodeFile != null) {
                                            aby.q(decodeFile);
                                            obj = null;
                                        } else {
                                            x.e("MicroMsg.JsApiAddMapLines", "BitmapUtil decode fail, mLocalBitmap is null, use default");
                                        }
                                    }
                                } else if (!bh.ov(optString)) {
                                    decodeFile = com.tencent.mm.plugin.appbrand.page.o.j(pVar.irP, optString);
                                    if (decodeFile != null) {
                                        obj = null;
                                        aby.q(decodeFile);
                                    } else {
                                        x.e("MicroMsg.JsApiAddMapLines", "arrowIconPath:%s, AppBrandPageIconCache.getIcon fail, mLocalBitmap is null", new Object[]{optString});
                                    }
                                }
                                if (obj != null) {
                                    aby.q(BitmapFactory.decodeStream(ac.getContext().getAssets().open("app_brand_map_line_texture_arrow.png")));
                                }
                            }
                            list.add(bE.a(aby));
                        }
                    } else {
                        x.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
                    }
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", new Object[]{e});
                    return false;
                }
            } catch (Exception e2) {
                x.e("MicroMsg.JsApiAddMapLines", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e2});
                return false;
            }
        } else {
            x.w("MicroMsg.JsApiAddMapLines", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
            return false;
        }
    }
}

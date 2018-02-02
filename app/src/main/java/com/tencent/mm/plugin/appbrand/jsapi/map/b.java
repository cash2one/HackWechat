package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends c {
    public static final int CTRL_INDEX = 140;
    public static final String NAME = "addMapControls";

    protected final int i(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapControls", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        com.tencent.mm.z.u.b y = pVar.aeF().y(i, false);
        if (y == null) {
            x.i("MicroMsg.JsApiAddMapControls", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        } else if (view instanceof CoverViewContainer) {
            View w = ((CoverViewContainer) view).w(View.class);
            if (jSONObject.has("controls")) {
                List list;
                int i2;
                List list2 = (List) y.get("map_controls", null);
                if (list2 == null) {
                    ArrayList arrayList = new ArrayList();
                    y.o("map_controls", arrayList);
                    list = arrayList;
                } else {
                    list = list2;
                }
                if (list.size() > 0) {
                    for (i2 = 0; i2 < list.size(); i2++) {
                        ((ImageView) list.get(i2)).setVisibility(8);
                    }
                    list.clear();
                }
                JSONArray jSONArray = new JSONArray(jSONObject.optString("controls"));
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    JSONObject jSONObject2;
                    int i4;
                    JSONObject jSONObject3 = (JSONObject) jSONArray.get(i3);
                    String optString = jSONObject3.optString("iconPath");
                    boolean optBoolean = jSONObject3.optBoolean("clickable");
                    String optString2 = jSONObject3.optString(SlookAirButtonFrequentContactAdapter.DATA);
                    try {
                        jSONObject2 = jSONObject3.getJSONObject("position");
                        i2 = 0;
                        i4 = 0;
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiAddMapControls", "parse position error, exception : %s", new Object[]{e});
                        return false;
                    }
                    try {
                        int a;
                        View imageView = new ImageView(view.getContext());
                        if (optString.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(pVar.mAppId, optString);
                            if (itemByLocalId != null) {
                                Bitmap decodeFile = d.decodeFile(itemByLocalId.hhZ, null);
                                imageView.setImageBitmap(decodeFile);
                                i4 = decodeFile.getHeight();
                                i2 = decodeFile.getWidth();
                            }
                        } else {
                            Bitmap j = o.j(pVar.irP, optString);
                            if (!(j == null || j.isRecycled())) {
                                imageView.setImageBitmap(j);
                                i4 = j.getHeight();
                                i2 = j.getWidth();
                            }
                        }
                        if (jSONObject2.has("width")) {
                            a = f.a(jSONObject2, "width", 0);
                        } else {
                            a = i2;
                        }
                        if (jSONObject2.has("height")) {
                            i2 = f.a(jSONObject2, "height", 0);
                        } else {
                            i2 = i4;
                        }
                        int a2 = f.a(jSONObject2, "top", 0);
                        int a3 = f.a(jSONObject2, "left", 0);
                        FrameLayout frameLayout = (FrameLayout) w;
                        LayoutParams layoutParams = new FrameLayout.LayoutParams(a, i2);
                        layoutParams.setMargins(a3, a2, 0, 0);
                        frameLayout.addView(imageView, layoutParams);
                        list.add(imageView);
                        if (optBoolean) {
                            imageView.setOnTouchListener(new 1(this, imageView));
                            imageView.setClickable(true);
                            imageView.setOnClickListener(new 2(this, i, optString2, pVar));
                        }
                        i3++;
                    } catch (Exception e2) {
                        x.e("MicroMsg.JsApiAddMapControls", "parse circles error, exception : %s", new Object[]{e2});
                        return false;
                    }
                }
            }
            return true;
        } else {
            x.w("MicroMsg.JsApiAddMapControls", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
            return false;
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b$i;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.base.c {
    public static final int CTRL_INDEX = 133;
    public static final String NAME = "addMapMarkers";
    p jia;
    private b jlW;
    private a jlX;
    Map<String, String> jlY = new HashMap();

    private static class c extends f {
        private static final int CTRL_INDEX = 142;
        private static final String NAME = "onMapMarkerClick";

        private c() {
        }
    }

    protected final int i(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapMarkers", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        u.b y = pVar.aeF().y(i, false);
        if (y == null) {
            x.e("MicroMsg.JsApiAddMapMarkers", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        } else if (!(view instanceof CoverViewContainer)) {
            x.w("MicroMsg.JsApiAddMapMarkers", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
            return false;
        } else if (jSONObject == null) {
            x.e("MicroMsg.JsApiAddMapMarkers", "data is null");
            return false;
        } else {
            x.i("MicroMsg.JsApiAddMapMarkers", "onUpdateView, data:%s", new Object[]{jSONObject.toString()});
            this.jia = pVar;
            this.jlW = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bE(((CoverViewContainer) view).w(View.class));
            Map map = (Map) y.get("marker", new HashMap());
            Map map2 = (Map) y.get("marker_data", new HashMap());
            try {
                if (jSONObject.has("markers")) {
                    h a;
                    if (jSONObject.optBoolean("clear", true)) {
                        for (h a2 : map.values()) {
                            a2.remove();
                        }
                        map.clear();
                        map2.clear();
                    }
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("markers"));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        int a3;
                        float width;
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                        float f = bh.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        float f2 = bh.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        String optString = jSONObject2.optString("iconPath");
                        b$i abw = this.jlW.abw();
                        abw.f((double) f, (double) f2);
                        View view2 = (FrameLayout) ((LayoutInflater) pVar.mContext.getSystemService("layout_inflater")).inflate(q.h.ixa, null);
                        ImageView imageView = (ImageView) view2.findViewById(q.g.ivT);
                        TextView textView = (TextView) view2.findViewById(q.g.ivU);
                        view2.setVisibility(8);
                        Bitmap bitmap = null;
                        if (optString == null || !optString.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                            bitmap = o.j(pVar.irP, optString);
                        } else {
                            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(pVar.mAppId, optString);
                            if (itemByLocalId != null) {
                                bitmap = com.tencent.mm.sdk.platformtools.d.decodeFile(itemByLocalId.hhZ, null);
                            }
                        }
                        if (bitmap != null) {
                            int a4 = com.tencent.mm.plugin.appbrand.p.f.a(jSONObject2, "width", 0);
                            a3 = com.tencent.mm.plugin.appbrand.p.f.a(jSONObject2, "height", 0);
                            if (a4 == 0 && a3 == 0) {
                                a4 = com.tencent.mm.plugin.appbrand.p.f.lI(bitmap.getWidth());
                                a3 = com.tencent.mm.plugin.appbrand.p.f.lI(bitmap.getHeight());
                            }
                            if (a4 <= 0 || a3 <= 0 || (a4 == bitmap.getWidth() && a3 == bitmap.getHeight())) {
                                imageView.setImageBitmap(bitmap);
                                imageView.setScaleType(ScaleType.CENTER);
                            } else {
                                width = ((float) a4) / ((float) bitmap.getWidth());
                                f2 = ((float) a3) / ((float) bitmap.getHeight());
                                Matrix matrix = new Matrix();
                                matrix.postScale(width, f2);
                                imageView.setImageBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
                            }
                        }
                        imageView.measure(0, 0);
                        a3 = imageView.getMeasuredWidth();
                        int measuredHeight = imageView.getMeasuredHeight();
                        float f3 = 0.5f;
                        width = 1.0f;
                        if (jSONObject2.has("anchor")) {
                            JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("anchor"));
                            f3 = (float) jSONObject3.optDouble("x");
                            width = (float) jSONObject3.optDouble("y");
                            x.i("MicroMsg.JsApiAddMapMarkers", "anchorObj:%s", new Object[]{jSONObject3.toString()});
                        }
                        int i3 = (int) (((float) a3) * f3);
                        measuredHeight = (int) (((float) measuredHeight) * width);
                        String optString2 = jSONObject2.optString("label");
                        if (!bh.ov(optString2)) {
                            int a5;
                            JSONObject jSONObject4 = new JSONObject(optString2);
                            CharSequence optString3 = jSONObject4.optString("color");
                            a3 = Color.parseColor("#000000");
                            if (!TextUtils.isEmpty(optString3)) {
                                a3 = com.tencent.mm.plugin.appbrand.p.f.aP(optString3, Color.parseColor("#000000"));
                            }
                            int optInt = jSONObject4.optInt("fontSize", 0);
                            String optString4 = jSONObject4.optString("content");
                            Drawable gradientDrawable = new GradientDrawable();
                            if (jSONObject4.has("borderRadius")) {
                                gradientDrawable.setCornerRadius((float) jSONObject4.optInt("borderRadius"));
                            }
                            if (jSONObject4.has("borderWidth") && jSONObject4.has("borderColor")) {
                                gradientDrawable.setStroke(com.tencent.mm.plugin.appbrand.p.f.b(jSONObject4, "borderWidth"), com.tencent.mm.plugin.appbrand.p.f.uA(jSONObject4.optString("borderColor")));
                            }
                            gradientDrawable.setColor(com.tencent.mm.plugin.appbrand.p.f.aP(jSONObject4.optString("bgColor", ""), Color.parseColor("#000000")));
                            textView.setBackgroundDrawable(gradientDrawable);
                            if (jSONObject4.has("textAlign")) {
                                String optString5 = jSONObject4.optString("textAlign", "");
                                if (optString5.equals("left")) {
                                    textView.setGravity(3);
                                } else if (optString5.equals("right")) {
                                    textView.setGravity(5);
                                } else if (optString5.equals("center")) {
                                    textView.setGravity(17);
                                } else {
                                    textView.setGravity(8388659);
                                }
                            } else {
                                textView.setGravity(8388659);
                            }
                            if (jSONObject4.has("padding")) {
                                a5 = com.tencent.mm.plugin.appbrand.p.f.a(jSONObject4, "padding", 0);
                                textView.setPadding(a5, a5, a5, a5);
                            }
                            a5 = com.tencent.mm.plugin.appbrand.p.f.a(jSONObject4, "x", 0);
                            int a6 = com.tencent.mm.plugin.appbrand.p.f.a(jSONObject4, "y", 0);
                            textView.setText(optString4);
                            textView.setTextColor(a3);
                            if (optInt > 0) {
                                textView.setTextSize((float) optInt);
                            }
                            ((MarginLayoutParams) textView.getLayoutParams()).setMargins(i3 + a5, a6 + measuredHeight, 0, 0);
                            textView.requestLayout();
                        }
                        if (bitmap != null) {
                            view2.setVisibility(0);
                            abw.bD(view2);
                        } else if (bh.ov(optString2)) {
                            x.e("MicroMsg.JsApiAddMapMarkers", "bitmap is null");
                        } else {
                            view2.setVisibility(0);
                            abw.bD(view2);
                        }
                        f = (float) jSONObject2.optDouble("alpha", 1.0d);
                        abw.T((float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d));
                        abw.U(f);
                        if (bh.ov(optString2)) {
                            abw.p(f3, width);
                        } else {
                            view2.measure(0, 0);
                            int measuredWidth = view2.getMeasuredWidth();
                            int measuredHeight2 = view2.getMeasuredHeight();
                            if (measuredWidth <= 0 || measuredHeight2 <= 0) {
                                f = width;
                                f2 = f3;
                            } else {
                                f2 = ((float) i3) / ((float) measuredWidth);
                                f = ((float) measuredHeight) / ((float) measuredHeight2);
                            }
                            abw.p(f2, f);
                        }
                        String optString6 = jSONObject2.optString("title");
                        if (!bh.ov(optString6)) {
                            abw.qx(optString6);
                        }
                        abw.f(new 1(this));
                        abw.e(new 2(this));
                        a2 = this.jlW.a(abw);
                        if (jSONObject2.has(SlookAirButtonFrequentContactAdapter.ID)) {
                            map.put(jSONObject2.optString(SlookAirButtonFrequentContactAdapter.ID), a2);
                        } else {
                            map.put(a2.hashCode(), a2);
                        }
                        String optString7 = jSONObject2.optString("callout");
                        if (!bh.ov(optString7)) {
                            this.jlY.put(a2.getId(), optString7);
                            this.jlX = new a(this);
                            this.jlW.a(this.jlX);
                            if (d(a2)) {
                                a2.showInfoWindow();
                            }
                        }
                        map2.put(a2.getId(), jSONObject2.optString(SlookAirButtonFrequentContactAdapter.DATA));
                    }
                    if (map.size() > 0) {
                        y.o("marker", map);
                        y.o("marker_data", map2);
                    }
                    this.jlW.a(new 3(this, map2, i, pVar));
                    this.jlW.a(new 4(this, map, i, pVar));
                    this.jlW.a(new 5(this, map2, i, pVar));
                } else {
                    x.e("MicroMsg.JsApiAddMapMarkers", "data has not markers");
                }
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.JsApiAddMapMarkers", "parse markers error, exception : %s", new Object[]{e});
                return false;
            }
        }
    }

    final boolean d(h hVar) {
        String str = (String) this.jlY.get(hVar.getId());
        try {
            if (TextUtils.isEmpty(str)) {
                x.e("MicroMsg.JsApiAddMapMarkers", "isShowInfoWindow, callout is empty");
                return false;
            }
            if (new JSONObject(str).optInt("display") == 1) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", e, "isShowInfoWindow", new Object[0]);
        }
    }
}

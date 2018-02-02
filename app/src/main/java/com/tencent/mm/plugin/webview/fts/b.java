package com.tencent.mm.plugin.webview.fts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bc.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.p.k;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.31;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static l tlA = new l();
    private Context context;
    private MMWebView ptK;
    public HashMap<String, Object> tls = new HashMap();
    private HashMap<String, Object> tlt = new HashMap();
    private HashMap<String, Object> tlu = new HashMap();
    private int tlv = -1;
    public e tlw;
    public d tlx;
    private Map<String, c> tly = new HashMap();
    private Map<String, b> tlz = new HashMap();

    static /* synthetic */ void a(b bVar, String str, int i, p pVar) {
        x.i("FTSSearchWidgetMgr", "onSetWidgetSize widgetId %s, height %d", new Object[]{str, Integer.valueOf(i)});
        c cVar = (c) bVar.tly.get(str);
        Bundle bundle = new Bundle();
        if (cVar != null && (i > cVar.tlM || i < cVar.tlL)) {
            x.w("FTSSearchWidgetMgr", "invalid widget size, should in range %s", new Object[]{cVar.toString()});
            if (pVar != null) {
                bundle.putInt("errCode", -2);
                pVar.b(false, "invalid widget size, should in range " + cVar.toString(), bundle);
            }
        } else if (bVar.tlx != null) {
            d dVar = bVar.tlx;
            if (dVar.tGQ) {
                x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged success, ready");
                Map hashMap = new HashMap();
                hashMap.put("widgetId", str);
                hashMap.put("height", Integer.valueOf(i));
                ag.y(new 31(dVar, a.a("onSearchWAWidgetAttrChanged", hashMap, dVar.tGS, dVar.tGT)));
            } else {
                x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, not ready");
            }
            if (pVar != null) {
                bundle.putInt("errCode", 0);
                pVar.b(true, "", bundle);
            }
        } else if (pVar != null) {
            bundle.putInt("errCode", -1);
            pVar.b(false, "jsapi is null", bundle);
        }
    }

    public static l bPe() {
        return tlA;
    }

    public b(Context context, MMWebView mMWebView) {
        this.context = context;
        this.ptK = mMWebView;
        this.tlw = (e) g.h(e.class);
    }

    public final void L(Bundle bundle) {
        b bVar = (b) this.tlz.get((String) bundle.get("widgetId"));
        if (bVar != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("app_id", bVar.fFm);
            bundle2.putString("msg_id", bVar.iSe);
            bundle2.putInt("pkg_type", bVar.fvM);
            bundle2.putInt("pkg_version", bVar.iGL);
            ((e) g.h(e.class)).IX().b(this.context, bundle2);
        }
    }

    public final void a(Bundle bundle, int i) {
        String string = bundle.getString("fts_key_json_data");
        String string2 = bundle.getString("fts_key_widget_view_cache_key");
        String bi = k.bi(this);
        x.i("FTSSearchWidgetMgr", "inserting widget: widgetId %s, sessionId %s, jsonData %s ", new Object[]{string2, bi, string});
        if (string == null || string.length() == 0) {
            x.i("FTSSearchWidgetMgr", "insert args invalid");
            return;
        }
        try {
            b bVar;
            String optString;
            String optString2;
            String optString3;
            String optString4;
            int i2;
            int i3;
            View be;
            com.tencent.mm.plugin.report.service.g gVar;
            Object[] objArr;
            View view;
            LayoutParams layoutParams;
            FrameLayout frameLayout;
            ThreeDotsLoadingView threeDotsLoadingView;
            ImageView imageView;
            String optString5;
            String str;
            Bundle bundle2;
            int optInt;
            Bundle bundle3;
            q rVar;
            ViewGroup topView;
            b bVar2 = (b) this.tlz.get(string2);
            if (bVar2 == null) {
                bVar2 = new b(this, (byte) 0);
                this.tlz.put(string2, bVar2);
                bVar = bVar2;
            } else {
                bVar = bVar2;
            }
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("maxHeight")) {
                if (jSONObject.has("minHeight")) {
                    c cVar = (c) this.tly.get(string2);
                    if (cVar == null) {
                        cVar = new c(this, (byte) 0);
                        this.tly.put(string2, cVar);
                    }
                    cVar.tlL = jSONObject.optInt("minHeight");
                    cVar.tlM = jSONObject.optInt("maxHeight");
                    x.i("FTSSearchWidgetMgr", "update widgetSize %s", new Object[]{cVar.toString()});
                    optString = jSONObject.optString("appid");
                    optString2 = jSONObject.optString("pagePath");
                    optString3 = jSONObject.optString("searchId");
                    l.lX(optString);
                    if (optString2.contains("widgetData")) {
                        l.Rg();
                    }
                    optString4 = jSONObject.optString("nickName");
                    i2 = jSONObject.getInt("version");
                    if (jSONObject.has("debugMode")) {
                        i3 = 0;
                    } else {
                        i3 = jSONObject.optInt("debugMode");
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(14452, new Object[]{jSONObject.optString("searchId") + "-" + optString, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis())});
                    be = this.tlw.be(this.context);
                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr = new Object[3];
                    objArr[0] = jSONObject.optString("searchId") + "-" + optString;
                    objArr[1] = Integer.valueOf(2);
                    objArr[2] = Long.valueOf(System.currentTimeMillis());
                    gVar.h(14452, objArr);
                    view = (AbsoluteLayout) v.fv(this.context).inflate(R.i.djo, null);
                    view.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.getInt("offsetX")), com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.getInt("offsetY"))));
                    layoutParams = new AbsoluteLayout.LayoutParams(com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.getInt("width")), com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.getInt("height")), 0, 0);
                    be.setLayoutParams(layoutParams);
                    view.addView(be);
                    frameLayout = (FrameLayout) view.findViewById(R.h.ctE);
                    frameLayout.setLayoutParams(layoutParams);
                    view.removeView(frameLayout);
                    view.addView(frameLayout);
                    try {
                        be.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                    } catch (Exception e) {
                        x.e("FTSSearchWidgetMgr", "the color is error : ");
                    }
                    be.setTag(bi);
                    this.tls.put(string2, be);
                    this.tlt.put(string2, view);
                    this.tlu.put(string2, frameLayout);
                    threeDotsLoadingView = (ThreeDotsLoadingView) view.findViewById(R.h.ctD);
                    imageView = (ImageView) view.findViewById(R.h.bZs);
                    optString5 = jSONObject.optString("wxaData");
                    str = optString + "_" + optString5.hashCode();
                    bundle2 = new Bundle();
                    bundle2.putString("app_id", optString);
                    bundle2.putString("msg_id", str);
                    bundle2.putString("search_id", optString3);
                    bundle2.putString("cache_key", optString5);
                    bundle2.putString("msg_title", optString4);
                    bundle2.putString("msg_path", optString2);
                    bundle2.putInt("pkg_version", i2);
                    bundle2.putInt("msg_pkg_type", i3);
                    optString2 = jSONObject.optString("inputData");
                    bundle2.putString("init_data", optString2);
                    bundle2.putInt("widget_type", 1);
                    optInt = jSONObject.optInt("serviceType");
                    bundle2.putInt("service_type", optInt);
                    bundle2.putInt("scene", com.tencent.mm.bc.b.il(i));
                    jSONObject = jSONObject;
                    bundle3 = bundle2;
                    bundle3.putInt("view_init_width", com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.getInt("width")));
                    jSONObject = jSONObject;
                    bundle3 = bundle2;
                    bundle3.putInt("view_init_height", com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.getInt("height")));
                    optString2 = jSONObject.optString("wxaData");
                    bundle2.putString("query", optString2);
                    optString2 = jSONObject.optString("launchwxawidget");
                    bundle2.putString("preload_launch_data", optString2);
                    threeDotsLoadingView.setVisibility(0);
                    imageView.setVisibility(4);
                    threeDotsLoadingView.cze();
                    bVar.fFm = optString;
                    bVar.fvM = i3;
                    bVar.iGL = i2;
                    bVar.iSe = str;
                    x.i("FTSSearchWidgetMgr", "inserting widget %s", new Object[]{bVar.toString()});
                    rVar = new r(new 2(this, bi, threeDotsLoadingView, imageView, string2, optString));
                    rVar.a(new 3(this, string2));
                    rVar.a(new 4(this, string2));
                    rVar.a(new 5(this, string2));
                    rVar.a(new 6(this));
                    rVar.a(new 7(this));
                    rVar.a(new 8(this));
                    this.tlw.a(bi, be, bundle2, rVar);
                    com.tencent.mm.bz.a.post(new 9(this, optString, threeDotsLoadingView, string2, bi, be, view, jSONObject));
                    topView = this.ptK.getTopView();
                    if (topView == null && (topView instanceof AbsoluteLayout)) {
                        topView.addView(view);
                        return;
                    } else {
                        x.e("FTSSearchWidgetMgr", "webview invalid viewgroup " + topView);
                    }
                }
            }
            try {
                x.i("FTSSearchWidgetMgr", "removew widgetSize " + ((c) this.tly.remove(string2)));
                optString = jSONObject.optString("appid");
                optString2 = jSONObject.optString("pagePath");
                optString3 = jSONObject.optString("searchId");
                l.lX(optString);
                if (optString2.contains("widgetData")) {
                    l.Rg();
                }
                optString4 = jSONObject.optString("nickName");
                i2 = jSONObject.getInt("version");
                if (jSONObject.has("debugMode")) {
                    i3 = jSONObject.optInt("debugMode");
                } else {
                    i3 = 0;
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(14452, new Object[]{jSONObject.optString("searchId") + "-" + optString, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis())});
                be = this.tlw.be(this.context);
                gVar = com.tencent.mm.plugin.report.service.g.pQN;
                objArr = new Object[3];
                objArr[0] = jSONObject.optString("searchId") + "-" + optString;
                objArr[1] = Integer.valueOf(2);
                objArr[2] = Long.valueOf(System.currentTimeMillis());
                gVar.h(14452, objArr);
                view = (AbsoluteLayout) v.fv(this.context).inflate(R.i.djo, null);
                view.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.getInt("offsetX")), com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.getInt("offsetY"))));
                layoutParams = new AbsoluteLayout.LayoutParams(com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.getInt("width")), com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.getInt("height")), 0, 0);
                be.setLayoutParams(layoutParams);
                view.addView(be);
                frameLayout = (FrameLayout) view.findViewById(R.h.ctE);
                frameLayout.setLayoutParams(layoutParams);
                view.removeView(frameLayout);
                view.addView(frameLayout);
                be.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                be.setTag(bi);
                this.tls.put(string2, be);
                this.tlt.put(string2, view);
                this.tlu.put(string2, frameLayout);
                threeDotsLoadingView = (ThreeDotsLoadingView) view.findViewById(R.h.ctD);
                imageView = (ImageView) view.findViewById(R.h.bZs);
                optString5 = jSONObject.optString("wxaData");
                str = optString + "_" + optString5.hashCode();
                bundle2 = new Bundle();
                bundle2.putString("app_id", optString);
                bundle2.putString("msg_id", str);
                bundle2.putString("search_id", optString3);
                bundle2.putString("cache_key", optString5);
                bundle2.putString("msg_title", optString4);
                bundle2.putString("msg_path", optString2);
                bundle2.putInt("pkg_version", i2);
                bundle2.putInt("msg_pkg_type", i3);
                optString2 = jSONObject.optString("inputData");
                bundle2.putString("init_data", optString2);
                bundle2.putInt("widget_type", 1);
                optInt = jSONObject.optInt("serviceType");
                bundle2.putInt("service_type", optInt);
                bundle2.putInt("scene", com.tencent.mm.bc.b.il(i));
                jSONObject = jSONObject;
                bundle3 = bundle2;
                bundle3.putInt("view_init_width", com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.getInt("width")));
                jSONObject = jSONObject;
                bundle3 = bundle2;
                bundle3.putInt("view_init_height", com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.getInt("height")));
                optString2 = jSONObject.optString("wxaData");
                bundle2.putString("query", optString2);
                optString2 = jSONObject.optString("launchwxawidget");
                bundle2.putString("preload_launch_data", optString2);
                threeDotsLoadingView.setVisibility(0);
                imageView.setVisibility(4);
                threeDotsLoadingView.cze();
                bVar.fFm = optString;
                bVar.fvM = i3;
                bVar.iGL = i2;
                bVar.iSe = str;
                x.i("FTSSearchWidgetMgr", "inserting widget %s", new Object[]{bVar.toString()});
                rVar = new r(new 2(this, bi, threeDotsLoadingView, imageView, string2, optString));
                rVar.a(new 3(this, string2));
                rVar.a(new 4(this, string2));
                rVar.a(new 5(this, string2));
                rVar.a(new 6(this));
                rVar.a(new 7(this));
                rVar.a(new 8(this));
                this.tlw.a(bi, be, bundle2, rVar);
                com.tencent.mm.bz.a.post(new 9(this, optString, threeDotsLoadingView, string2, bi, be, view, jSONObject));
                topView = this.ptK.getTopView();
                if (topView == null) {
                }
                x.e("FTSSearchWidgetMgr", "webview invalid viewgroup " + topView);
            } catch (Exception e2) {
                x.e("FTSSearchWidgetMgr", "this is has a error" + e2.toString());
            }
        } catch (JSONException e3) {
            x.e("FTSSearchWidgetMgr", "parse json and init dynamicPageService is error!");
        }
    }

    public final void M(Bundle bundle) {
        NX(bundle.getString("fts_key_widget_view_cache_key"));
    }

    private void NX(String str) {
        if (str != null && str.length() > 0) {
            View view = (View) this.tls.get(str);
            if (view == null) {
                x.i("FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", new Object[]{str});
                return;
            }
            x.i("FTSSearchWidgetMgr", "removing widget sessionId %s", new Object[]{view.getTag().toString()});
            if (this.tlw != null) {
                this.tlw.a((String) view.getTag(), view);
            }
            this.tls.remove(str);
            this.tlu.remove(str);
            view = (View) this.tlt.get(str);
            if (view != null) {
                ViewGroup topView = this.ptK.getTopView();
                if (topView != null && (topView instanceof AbsoluteLayout)) {
                    topView.removeView(view);
                }
                this.tlt.remove(str);
            }
        }
    }

    public final void N(Bundle bundle) {
        String string = bundle.getString("fts_key_json_data");
        String string2 = bundle.getString("fts_key_widget_view_cache_key");
        x.i("FTSSearchWidgetMgr", "updating widget: widgetId %s, jsonData %s", new Object[]{string2, string});
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (string2 != null && string2.length() > 0) {
                View view = (View) this.tls.get(string2);
                View view2 = (View) this.tlt.get(string2);
                if (view != null) {
                    AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) view.getLayoutParams();
                    LayoutParams layoutParams2 = (AbsoluteLayout.LayoutParams) view2.getLayoutParams();
                    if (jSONObject.has("width") || jSONObject.has("height")) {
                        View view3 = (View) this.tlu.get(string2);
                        x.i("FTSSearchWidgetMgr", "animating  size beginH %d, endH %d, beginW %d, endW %d", new Object[]{Integer.valueOf(layoutParams.height), Integer.valueOf(com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.optInt("height"))), Integer.valueOf(layoutParams.width), Integer.valueOf(com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.optInt("width")))});
                        if (!(layoutParams.height == com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.optInt("height")) && r2 == r6)) {
                            LayoutParams layoutParams3 = view.getLayoutParams();
                            LayoutParams layoutParams4 = view3.getLayoutParams();
                            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{r3, r11});
                            ofInt.setDuration(300);
                            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
                            ofInt.addUpdateListener(new 1(this, layoutParams3, view, layoutParams4, view3));
                            ofInt.start();
                        }
                    }
                    if (jSONObject.has("offsetX")) {
                        layoutParams2.x = com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.optInt("offsetX"));
                    }
                    if (jSONObject.has("offsetY")) {
                        layoutParams2.y = com.tencent.mm.bv.a.fromDPToPix(this.context, jSONObject.optInt("offsetY"));
                    }
                    view2.setLayoutParams(layoutParams2);
                    if (jSONObject.has("backgroundColor")) {
                        try {
                            view.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                        } catch (Throwable e) {
                            x.e("FTSSearchWidgetMgr", bh.i(e));
                        }
                    }
                    if (jSONObject.has("show")) {
                        if (jSONObject.has("show") ? jSONObject.optBoolean("show") : false) {
                            view.setVisibility(0);
                            view2.setVisibility(0);
                            return;
                        }
                        view.setVisibility(8);
                        view2.setVisibility(8);
                    }
                }
            }
        } catch (Exception e2) {
            x.e("FTSSearchWidgetMgr", "the error is e");
        }
    }

    public final void onResume() {
        if (this.tlw != null) {
            for (String str : this.tls.keySet()) {
                if (str != null && str.length() > 0) {
                    ((e) g.h(e.class)).IW().iw((String) ((View) this.tls.get(str)).getTag());
                }
            }
        }
    }

    public final void onPause() {
        if (this.tlw != null) {
            for (String str : this.tls.keySet()) {
                if (str != null && str.length() > 0) {
                    ((e) g.h(e.class)).IW().iv((String) ((View) this.tls.get(str)).getTag());
                }
            }
        }
    }

    public final void onDestroy() {
        try {
            if (this.tlw != null) {
                x.i("FTSSearchWidgetMgr", "remove all widget count %d", new Object[]{Integer.valueOf(this.tls.size())});
                for (String str : new HashMap(this.tls).keySet()) {
                    if (str != null && str.length() > 0) {
                        this.tlw.ix((String) ((View) this.tls.get(str)).getTag());
                        if (((View) this.tlt.get(str)) != null) {
                            NX(str);
                            this.tlt.remove(str);
                        }
                    }
                }
                this.tls.clear();
                this.tlu.clear();
            }
        } catch (Throwable e) {
            x.e("FTSSearchWidgetMgr", bh.i(e));
        }
    }
}

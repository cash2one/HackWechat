package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.live.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends c {
    private static final int CTRL_INDEX = 361;
    public static final String NAME = "updateLivePusher";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.optInt("livePusherId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView : livePusherId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            View w = ((CoverViewContainer) view).w(View.class);
            if (w instanceof AppBrandLivePusherView) {
                final AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) w;
                appBrandLivePusherView.u(q(jSONObject));
                try {
                    if (jSONObject.has("backgroundImage")) {
                        a.a(jSONObject.getString("backgroundImage"), jSONObject.optString("backgroundMD5"), new a(this) {
                            final /* synthetic */ i jlg;

                            public final void sq(String str) {
                                x.i("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath onDownload localPath:%s", new Object[]{str});
                                Bundle bundle = new Bundle();
                                bundle.putString("backgroundImage", str);
                                appBrandLivePusherView.u(bundle);
                            }
                        });
                    }
                } catch (JSONException e) {
                    x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"backgroundMute", e.getLocalizedMessage()});
                }
                return true;
            }
            x.e("MicroMsg.JsApiUpdateLivePusher", "targetView not AppBrandLivePusherView");
            return false;
        }
        x.w("MicroMsg.JsApiUpdateLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }

    private static Bundle q(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        try {
            if (jSONObject.has("pushUrl")) {
                bundle.putString("pushUrl", jSONObject.getString("pushUrl"));
                x.i("MicroMsg.JsApiUpdateLivePusher", "convertParams pushUrl:%s", new Object[]{jSONObject.getString("pushUrl")});
            }
        } catch (JSONException e) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"pushUrl", e.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("mode")) {
                bundle.putInt("mode", jSONObject.getInt("mode"));
            }
        } catch (JSONException e2) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"mode", e2.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("autopush")) {
                bundle.putBoolean("autopush", jSONObject.getBoolean("autopush"));
            }
        } catch (JSONException e22) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"autopush", e22.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("audioQuality")) {
                bundle.putString("audioQuality", jSONObject.getString("audioQuality"));
            }
        } catch (JSONException e222) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"audioQuality", e222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("muted")) {
                bundle.putBoolean("muted", jSONObject.getBoolean("muted"));
            }
        } catch (JSONException e2222) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"muted", e2222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("enableCamera")) {
                bundle.putBoolean("enableCamera", jSONObject.getBoolean("enableCamera"));
            }
        } catch (JSONException e22222) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"enableCamera", e22222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("focusMode")) {
                bundle.putInt("focusMode", jSONObject.getInt("focusMode"));
            }
        } catch (JSONException e222222) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"focusMode", e222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("orientation")) {
                bundle.putString("orientation", jSONObject.getString("orientation"));
            }
        } catch (JSONException e2222222) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"orientation", e2222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("beauty")) {
                bundle.putInt("beauty", jSONObject.getInt("beauty"));
            }
        } catch (JSONException e22222222) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"beauty", e22222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("whiteness")) {
                bundle.putInt("whiteness", jSONObject.getInt("whiteness"));
            }
        } catch (JSONException e222222222) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"whiteness", e222222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("aspect")) {
                bundle.putInt("aspect", jSONObject.getInt("aspect"));
            }
        } catch (JSONException e2222222222) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"aspect", e2222222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("minBitrate")) {
                bundle.putInt("minBitrate", jSONObject.getInt("minBitrate"));
            }
        } catch (JSONException e22222222222) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"minBitrate", e22222222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("maxBitrate")) {
                bundle.putInt("maxBitrate", jSONObject.getInt("maxBitrate"));
            }
        } catch (JSONException e222222222222) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"maxBitrate", e222222222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("backgroundImage")) {
                bundle.putString("backgroundImage", jSONObject.getString("backgroundImage"));
            }
        } catch (JSONException e2222222222222) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"pushUrl", e2222222222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("debug")) {
                bundle.putBoolean("debug", jSONObject.getBoolean("debug"));
            }
        } catch (JSONException e22222222222222) {
            x.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[]{"debug", e22222222222222.getLocalizedMessage()});
        }
        return bundle;
    }
}

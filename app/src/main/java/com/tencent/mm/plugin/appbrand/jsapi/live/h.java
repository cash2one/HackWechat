package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends c {
    private static final int CTRL_INDEX = 365;
    public static final String NAME = "updateLivePlayer";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.optInt("livePlayerId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView : livePlayerId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            View w = ((CoverViewContainer) view).w(View.class);
            if (w instanceof AppBrandLivePlayerView) {
                j jVar;
                AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) w;
                Bundle q = q(jSONObject);
                appBrandLivePlayerView.jkS = q.getBoolean("needEvent", appBrandLivePlayerView.jkS);
                l lVar = appBrandLivePlayerView.jkO;
                if (lVar.gNe) {
                    l.c(NAME, q);
                    lVar.w(q);
                    boolean isPlaying = lVar.jll.isPlaying();
                    String string = q.getString("playUrl", lVar.jln);
                    if (!(string == null || string.isEmpty() || lVar.jln == null || lVar.jln.equalsIgnoreCase(string) || !lVar.jll.isPlaying())) {
                        x.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + lVar.jln + " playUrl-new = " + string);
                        lVar.jll.stopPlay(true);
                    }
                    lVar.jln = string;
                    int v = lVar.v(q);
                    if (v != lVar.jlo && lVar.jll.isPlaying()) {
                        x.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + lVar.jlo + " playType-new = " + v);
                        lVar.jll.stopPlay(true);
                    }
                    lVar.jlo = v;
                    lVar.mAutoPlay = q.getBoolean("autoplay", lVar.mAutoPlay);
                    if (!((!lVar.mAutoPlay && !isPlaying) || lVar.jln == null || lVar.jln.isEmpty() || lVar.jll.isPlaying())) {
                        x.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
                        lVar.jll.startPlay(lVar.jln, lVar.jlo);
                    }
                    jVar = new j();
                } else {
                    jVar = new j(-3, "uninited livePlayer");
                }
                x.i("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", new Object[]{Integer.valueOf(jVar.errorCode), jVar.jlh});
                return true;
            }
            x.e("MicroMsg.JsApiUpdateLivePlayer", "targetView not AppBrandLivePlayerView");
            return false;
        }
        x.w("MicroMsg.JsApiUpdateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }

    private static Bundle q(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        try {
            if (jSONObject.has("playUrl")) {
                bundle.putString("playUrl", jSONObject.getString("playUrl"));
                x.i("MicroMsg.JsApiUpdateLivePlayer", "convertParams playUrl:%s", new Object[]{jSONObject.getString("playUrl")});
            }
        } catch (JSONException e) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[]{"playUrl", e.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("mode")) {
                bundle.putInt("mode", jSONObject.getInt("mode"));
            }
        } catch (JSONException e2) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[]{"mode", e2.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("autoplay")) {
                bundle.putBoolean("autoplay", jSONObject.getBoolean("autoplay"));
            }
        } catch (JSONException e22) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[]{"autoplay", e22.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("muted")) {
                bundle.putBoolean("muted", jSONObject.getBoolean("muted"));
            }
        } catch (JSONException e222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[]{"muted", e222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("orientation")) {
                bundle.putString("orientation", jSONObject.getString("orientation"));
            }
        } catch (JSONException e2222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[]{"orientation", e2222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("objectFit")) {
                bundle.putString("objectFit", jSONObject.getString("objectFit"));
            }
        } catch (JSONException e22222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[]{"objectFit", e22222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("backgroundMute")) {
                bundle.putBoolean("backgroundMute", jSONObject.getBoolean("backgroundMute"));
            }
        } catch (JSONException e222222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[]{"backgroundMute", e222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("minCache")) {
                bundle.putFloat("minCache", BigDecimal.valueOf((long) jSONObject.getInt("minCache")).floatValue());
            }
        } catch (JSONException e2222222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[]{"minCache", e2222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("maxCache")) {
                bundle.putFloat("maxCache", BigDecimal.valueOf((long) jSONObject.getInt("maxCache")).floatValue());
            }
        } catch (JSONException e22222222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[]{"maxCache", e22222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("needEvent")) {
                bundle.putBoolean("needEvent", jSONObject.getBoolean("needEvent"));
            }
        } catch (JSONException e222222222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[]{"needEvent", e222222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("debug")) {
                bundle.putBoolean("debug", jSONObject.getBoolean("debug"));
            }
        } catch (JSONException e2222222222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[]{"debug", e2222222222.getLocalizedMessage()});
        }
        try {
            if (jSONObject.has("soundMode")) {
                bundle.putString("soundMode", jSONObject.getString("soundMode"));
                x.i("MicroMsg.JsApiUpdateLivePlayer", "convertParams soundMode:%s", new Object[]{jSONObject.getString("soundMode")});
            }
        } catch (JSONException e22222222222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[]{"soundMode", e22222222222.getLocalizedMessage()});
        }
        return bundle;
    }
}

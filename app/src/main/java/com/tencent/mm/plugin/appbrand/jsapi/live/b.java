package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 364;
    public static final String NAME = "insertLivePlayer";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        k.agu();
        if (jSONObject.optInt("mode", 0) != 2) {
            super.a(pVar, jSONObject, i);
        } else if (pVar.mContext instanceof Activity) {
            try {
                if (android.support.v4.content.a.b((Activity) pVar.mContext, "android.permission.RECORD_AUDIO") == 0) {
                    super.a(pVar, jSONObject, i);
                    return;
                }
                Map hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10001));
                pVar.E(i, e("fail:system permission denied", hashMap));
            } catch (Exception e) {
                x.e("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", new Object[]{e});
                pVar.E(i, e("fail", null));
            }
        } else {
            x.w("MicroMsg.JsApiInsertLivePlayer", "invokeAfterRequestPermission pageContext not activity");
            pVar.E(i, e("fail", null));
        }
    }

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("livePlayerId");
    }

    protected final View a(p pVar, JSONObject jSONObject) {
        return new CoverViewContainer(pVar.mContext, new AppBrandLivePlayerView(pVar.mContext));
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiInsertLivePlayer", "onInsertView livePlayerId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            j jVar;
            AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) ((CoverViewContainer) view).w(AppBrandLivePlayerView.class);
            y 1 = new 1(this, appBrandLivePlayerView);
            f 2 = new 2(this, appBrandLivePlayerView);
            d 3 = new 3(this, appBrandLivePlayerView);
            e 4 = new 4(this, appBrandLivePlayerView, pVar, 2, 3);
            pVar.a(2);
            pVar.a(3);
            pVar.a(4);
            appBrandLivePlayerView.jkP = new 5(this, pVar, i, 1);
            appBrandLivePlayerView.jkS = jSONObject.optBoolean("needEvent", false);
            appBrandLivePlayerView.jkQ = new 6(this, i, pVar);
            Bundle bundle = new Bundle();
            bundle.putString("playUrl", jSONObject.optString("playUrl"));
            bundle.putInt("mode", jSONObject.optInt("mode", 0));
            bundle.putBoolean("autoplay", jSONObject.optBoolean("autoplay", false));
            bundle.putBoolean("muted", jSONObject.optBoolean("muted", false));
            bundle.putString("orientation", jSONObject.optString("orientation"));
            bundle.putString("objectFit", jSONObject.optString("objectFit"));
            bundle.putBoolean("backgroundMute", jSONObject.optBoolean("backgroundMute", true));
            bundle.putFloat("minCache", BigDecimal.valueOf(jSONObject.optDouble("minCache", 1.0d)).floatValue());
            bundle.putFloat("maxCache", BigDecimal.valueOf(jSONObject.optDouble("maxCache", 3.0d)).floatValue());
            bundle.putBoolean("needEvent", jSONObject.optBoolean("needEvent", false));
            bundle.putBoolean("debug", jSONObject.optBoolean("debug", false));
            bundle.putString("soundMode", jSONObject.optString("soundMode", "speaker"));
            x.i("MicroMsg.JsApiInsertLivePlayer", "convertParams playUrl:%s", new Object[]{jSONObject.optString("playUrl")});
            l lVar = appBrandLivePlayerView.jkO;
            if (appBrandLivePlayerView == null) {
                jVar = new j(-1, "invalid params");
            } else {
                l.c("initLivePlayer", bundle);
                lVar.jlj = appBrandLivePlayerView;
                lVar.jlj.disableLog(false);
                lVar.jll.setPlayerView(appBrandLivePlayerView);
                lVar.jln = bundle.getString("playUrl", lVar.jln);
                lVar.jlo = lVar.v(bundle);
                lVar.w(bundle);
                lVar.mAutoPlay = bundle.getBoolean("autoplay", lVar.mAutoPlay);
                if (!(!lVar.mAutoPlay || lVar.jln == null || lVar.jln.isEmpty())) {
                    x.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
                    lVar.jll.startPlay(lVar.jln, lVar.jlo);
                }
                lVar.gNe = true;
                jVar = new j();
            }
            x.i("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", new Object[]{Integer.valueOf(jVar.errorCode), jVar.jlh});
            appBrandLivePlayerView.jkO.jlm = new 7(this, i, pVar);
            return;
        }
        x.w("MicroMsg.JsApiInsertLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
    }
}

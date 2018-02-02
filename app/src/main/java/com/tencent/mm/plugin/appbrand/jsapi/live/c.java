package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 360;
    public static final String NAME = "insertLivePusher";
    private int jla;

    public final void a(p pVar, JSONObject jSONObject, int i) {
        k.agu();
        if (pVar.mContext instanceof Activity) {
            this.jla = 0;
            a((Activity) pVar.mContext, pVar, jSONObject, i);
            return;
        }
        x.w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
        pVar.E(i, e("fail", null));
        com.tencent.mm.plugin.appbrand.a.oR(pVar.mAppId);
    }

    protected final View a(p pVar, JSONObject jSONObject) {
        return new CoverViewContainer(pVar.mContext, new AppBrandLivePusherView(pVar.mContext));
    }

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("livePusherId");
    }

    protected final void a(final p pVar, final int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            j jVar;
            TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[]{pVar.mAppId}));
            AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) ((CoverViewContainer) view).w(AppBrandLivePusherView.class);
            f 1 = new 1(this, appBrandLivePusherView);
            d 2 = new 2(this, appBrandLivePusherView);
            b 3 = new 3(this, appBrandLivePusherView, pVar);
            e 4 = new 4(this, appBrandLivePusherView, pVar, 1, 2, 3);
            pVar.a(1);
            pVar.a(2);
            pVar.a(4);
            com.tencent.mm.plugin.appbrand.c.a(pVar.mAppId, 3);
            appBrandLivePusherView.jkU = new ITXLivePushListener(this) {
                final /* synthetic */ c jlc;

                public final void onPushEvent(int i, Bundle bundle) {
                    x.i("MicroMsg.JsApiInsertLivePusher", "onPushEvent errCode:%d", new Object[]{Integer.valueOf(i)});
                    b bVar = new b((byte) 0);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errCode", i);
                        jSONObject.put("errMsg", bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
                        jSONObject.put("livePusherId", i);
                    } catch (JSONException e) {
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.f az = bVar.az(pVar.mAppId, pVar.hashCode());
                    az.mData = jSONObject.toString();
                    az.afs();
                }

                public final void onNetStatus(Bundle bundle) {
                    a aVar = new a((byte) 0);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("livePusherId", i);
                        JSONObject jSONObject2 = new JSONObject();
                        if (bundle != null) {
                            for (String str : bundle.keySet()) {
                                jSONObject2.put(str, bundle.get(str));
                            }
                        }
                        jSONObject.put("info", jSONObject2);
                    } catch (JSONException e) {
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.f az = aVar.az(pVar.mAppId, pVar.hashCode());
                    az.mData = jSONObject.toString();
                    az.afs();
                }
            };
            appBrandLivePusherView.jkT.jlz = appBrandLivePusherView.jkU;
            Bundle bundle = new Bundle();
            bundle.putString("pushUrl", jSONObject.optString("pushUrl"));
            bundle.putInt("mode", jSONObject.optInt("mode", 0));
            bundle.putBoolean("autopush", jSONObject.optBoolean("autopush", false));
            bundle.putBoolean("muted", jSONObject.optBoolean("muted", false));
            bundle.putBoolean("enableCamera", jSONObject.optBoolean("enableCamera", true));
            bundle.putInt("focusMode", jSONObject.optInt("focusMode", 0));
            bundle.putString("orientation", jSONObject.optString("orientation"));
            bundle.putInt("beauty", jSONObject.optInt("beauty", 0));
            bundle.putInt("whiteness", jSONObject.optInt("whiteness", 0));
            bundle.putString("audioQuality", jSONObject.optString("audioQuality", "high"));
            bundle.putInt("aspect", jSONObject.optInt("aspect", 0));
            bundle.putInt("minBitrate", jSONObject.optInt("minBitrate", 0));
            bundle.putInt("maxBitrate", jSONObject.optInt("maxBitrate", 0));
            bundle.putBoolean("backgroundMute", jSONObject.optBoolean("backgroundMute", false));
            bundle.putBoolean("needEvent", jSONObject.optBoolean("needEvent", false));
            bundle.putBoolean("debug", jSONObject.optBoolean("debug", false));
            x.i("MicroMsg.JsApiInsertLivePusher", "convertParams pushUrl:%s", new Object[]{jSONObject.optString("pushUrl")});
            m mVar = appBrandLivePusherView.jkT;
            if (appBrandLivePusherView == null) {
                jVar = new j(-1, "invalid params");
            } else {
                m.c("InitLivePusher", bundle);
                mVar.jlj = appBrandLivePusherView;
                mVar.jlj.disableLog(false);
                mVar.jlA = bundle.getString("pushUrl", "");
                mVar.c(bundle, true);
                if (!(!bundle.getBoolean("autopush", false) || mVar.jlA == null || mVar.jlA.isEmpty() || mVar.jly.isPushing())) {
                    x.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
                    mVar.jlj.setVisibility(0);
                    if (mVar.jlI) {
                        mVar.jly.startCameraPreview(mVar.jlj);
                    }
                    mVar.jly.startPusher(mVar.jlA);
                }
                mVar.gNe = true;
                jVar = new j();
            }
            x.i("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", new Object[]{Integer.valueOf(jVar.errorCode), jVar.jlh});
            a.a(jSONObject.optString("backgroundImage"), jSONObject.optString("backgroundMD5"), new 6(this, appBrandLivePusherView));
            return;
        }
        x.w("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
    }

    private void a(Activity activity, p pVar, JSONObject jSONObject, int i) {
        int i2 = this.jla;
        this.jla = i2 + 1;
        if (i2 > 5) {
            x.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
            return;
        }
        com.tencent.mm.plugin.appbrand.a.a(pVar.mAppId, new 7(this, activity, pVar, jSONObject, i));
        if (!com.tencent.mm.pluginsdk.g.a.a(activity, "android.permission.CAMERA", 117, "", "")) {
            x.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
        } else if (com.tencent.mm.pluginsdk.g.a.a(activity, "android.permission.RECORD_AUDIO", 118, "", "")) {
            x.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
            super.a(pVar, jSONObject, i);
        } else {
            x.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
        }
    }
}

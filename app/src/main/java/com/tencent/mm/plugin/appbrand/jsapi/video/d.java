package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends c {
    private static final int CTRL_INDEX = 87;
    public static final String NAME = "updateVideoPlayer";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView : videoPlayerId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).w(AppBrandVideoView.class);
            if (appBrandVideoView == null) {
                x.e("MicroMsg.JsApiUpdateVideoPlayer", "view not AppBrandVideoView");
                return false;
            }
            try {
                if (jSONObject.has("showDanmuBtn")) {
                    appBrandVideoView.cX(jSONObject.getBoolean("showDanmuBtn"));
                }
            } catch (JSONException e) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showDanmuBtn", e.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("danmuList")) {
                    appBrandVideoView.h(jSONObject.getJSONArray("danmuList"));
                }
            } catch (JSONException e2) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"danmuList", e2.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("objectFit")) {
                    appBrandVideoView.sP(jSONObject.getString("objectFit"));
                }
            } catch (JSONException e22) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"objectFit", e22.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("autoplay")) {
                    x.i("MicroMsg.AppBrandVideoView", "setAutoPlay =%b", new Object[]{Boolean.valueOf(jSONObject.getBoolean("autoplay"))});
                    appBrandVideoView.mAutoPlay = r3;
                }
            } catch (JSONException e222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"autoplay", e222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showBasicControls")) {
                    appBrandVideoView.cQ(jSONObject.getBoolean("showBasicControls"));
                }
            } catch (JSONException e2222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showBasicControls", e2222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("poster")) {
                    appBrandVideoView.sO(jSONObject.getString("poster"));
                }
            } catch (JSONException e22222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"poster", e22222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has(TencentLocation.EXTRA_DIRECTION)) {
                    appBrandVideoView.kD(jSONObject.getInt(TencentLocation.EXTRA_DIRECTION));
                }
            } catch (Exception e3) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{TencentLocation.EXTRA_DIRECTION, e3.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("muted")) {
                    appBrandVideoView.setMute(jSONObject.getBoolean("muted"));
                }
            } catch (JSONException e222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"muted", e222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("loop")) {
                    appBrandVideoView.cP(jSONObject.getBoolean("loop"));
                }
            } catch (JSONException e2222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"loop", e2222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has(SlookAirButtonFrequentContactAdapter.DATA)) {
                    appBrandVideoView.jsv = jSONObject.getString(SlookAirButtonFrequentContactAdapter.DATA);
                }
            } catch (JSONException e22222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{SlookAirButtonFrequentContactAdapter.DATA, e22222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("pageGesture")) {
                    appBrandVideoView.cY(jSONObject.getBoolean("pageGesture"));
                }
            } catch (JSONException e222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"pageGesture", e222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showLiveBtn")) {
                    appBrandVideoView.cR(jSONObject.getBoolean("showLiveBtn"));
                }
            } catch (JSONException e2222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showLiveBtn", e2222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showProgress")) {
                    appBrandVideoView.cS(jSONObject.getBoolean("showProgress"));
                }
            } catch (JSONException e22222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showProgress", e22222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showFullScreenBtn")) {
                    appBrandVideoView.cT(jSONObject.getBoolean("showFullScreenBtn"));
                }
            } catch (JSONException e222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showFullScreenBtn", e222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showPlayBtn")) {
                    appBrandVideoView.cU(jSONObject.getBoolean("showPlayBtn"));
                }
            } catch (JSONException e2222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showPlayBtn", e2222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showCenterPlayBtn")) {
                    appBrandVideoView.cW(jSONObject.getBoolean("showCenterPlayBtn"));
                }
            } catch (JSONException e22222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showCenterPlayBtn", e22222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("enableProgressGesture")) {
                    appBrandVideoView.cV(jSONObject.getBoolean("enableProgressGesture"));
                }
            } catch (JSONException e222222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"enableProgressGesture", e222222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_DURATION)) {
                    int i2 = jSONObject.getInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    if (i2 <= 0) {
                        x.i("MicroMsg.AppBrandVideoView", "setDuration error duration=%d", new Object[]{Integer.valueOf(i2)});
                    } else {
                        appBrandVideoView.jsp.setText(AppBrandVideoView.kF(i2));
                        appBrandVideoView.mDuration = i2;
                    }
                }
            } catch (JSONException e2222222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"disableScroll", e2222222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("hide") && jSONObject.getBoolean("hide")) {
                    x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView hide stop");
                    appBrandVideoView.stop();
                }
            } catch (JSONException e22222222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"hide", e22222222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("initialTime")) {
                    appBrandVideoView.kE(jSONObject.getInt("initialTime"));
                }
            } catch (JSONException e222222222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"initialTime", e222222222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("needEvent")) {
                    if (jSONObject.getBoolean("needEvent")) {
                        if ((appBrandVideoView.jsy != null ? 1 : 0) == 0) {
                            appBrandVideoView.jsy = new e(appBrandVideoView, pVar);
                        }
                    } else {
                        appBrandVideoView.jsy = null;
                    }
                }
            } catch (JSONException e2222222222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"needEvent", e2222222222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has(DownloadInfoColumns.FILEPATH)) {
                    appBrandVideoView.e(jSONObject.getString(DownloadInfoColumns.FILEPATH), jSONObject.optBoolean("live"), jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION));
                }
            } catch (JSONException e4) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{DownloadInfoColumns.FILEPATH, e4.getLocalizedMessage()});
            }
            return true;
        }
        x.w("MicroMsg.JsApiUpdateVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 6;
    public static final String NAME = "insertVideoPlayer";

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        return new CoverViewContainer(context, new AppBrandVideoView(context));
    }

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("videoPlayerId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView videoPlayerId=%d", new Object[]{Integer.valueOf(i)});
        AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).w(AppBrandVideoView.class);
        y 1 = new 1(this, appBrandVideoView);
        f 2 = new 2(this, appBrandVideoView);
        d 3 = new 3(this, appBrandVideoView);
        e 4 = new 4(this, appBrandVideoView, pVar, 2, 3);
        pVar.a(2);
        pVar.a(3);
        pVar.a(4);
        appBrandVideoView.jsB = new 5(this, pVar, i, 1);
        appBrandVideoView.setMute(jSONObject.optBoolean("muted", false));
        boolean optBoolean = jSONObject.optBoolean("needEvent", false);
        JSONObject jSONObject2 = jSONObject;
        x.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView autoPlay=%b needEvent=%b", new Object[]{Boolean.valueOf(jSONObject2.optBoolean("autoplay", false)), Boolean.valueOf(optBoolean)});
        boolean optBoolean2 = jSONObject.optBoolean("showDanmuBtn", true);
        boolean optBoolean3 = jSONObject.optBoolean("enableDanmu", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("danmuList");
        String optString = jSONObject.optString("objectFit");
        String optString2 = jSONObject.optString("poster");
        boolean optBoolean4 = jSONObject.optBoolean("showBasicControls", true);
        String optString3 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        int optInt = jSONObject.optInt(TencentLocation.EXTRA_DIRECTION, 90);
        boolean optBoolean5 = jSONObject.optBoolean("loop", false);
        boolean optBoolean6 = jSONObject.optBoolean("pageGesture", false);
        int optInt2 = jSONObject.optInt("initialTime", 0);
        boolean optBoolean7 = jSONObject.optBoolean("showLiveBtn", true);
        boolean optBoolean8 = jSONObject.optBoolean("showProgress", true);
        boolean optBoolean9 = jSONObject.optBoolean("showFullScreenBtn", true);
        boolean optBoolean10 = jSONObject.optBoolean("showPlayBtn", true);
        boolean optBoolean11 = jSONObject.optBoolean("showCenterPlayBtn", true);
        boolean optBoolean12 = jSONObject.optBoolean("enableProgressGesture", true);
        x.i("MicroMsg.AppBrandVideoView", "setAppId appid=%s", new Object[]{pVar.mAppId});
        appBrandVideoView.mAppId = r22;
        x.i("MicroMsg.AppBrandVideoView", "setIsGame game=%s", new Object[]{Boolean.valueOf(pVar.irP.Yz())});
        appBrandVideoView.jsG = r22;
        appBrandVideoView.jsv = optString3;
        appBrandVideoView.cQ(optBoolean4);
        appBrandVideoView.sO(optString2);
        appBrandVideoView.kD(optInt);
        appBrandVideoView.sP(optString);
        appBrandVideoView.cP(optBoolean5);
        appBrandVideoView.cY(optBoolean6);
        try {
            appBrandVideoView.jsw = i(jSONObject);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", new Object[]{e});
        }
        appBrandVideoView.cX(optBoolean2);
        x.i("MicroMsg.AppBrandVideoView", "setDanmakuEnable isEnable=%b", new Object[]{Boolean.valueOf(optBoolean3)});
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = appBrandVideoView.jsm;
        appBrandVideoViewControlBar.jsZ = optBoolean3;
        appBrandVideoViewControlBar.agZ();
        appBrandVideoView.h(optJSONArray);
        appBrandVideoView.kE(optInt2);
        appBrandVideoView.cR(optBoolean7);
        appBrandVideoView.cS(optBoolean8);
        appBrandVideoView.cT(optBoolean9);
        appBrandVideoView.cU(optBoolean10);
        appBrandVideoView.cW(optBoolean11);
        appBrandVideoView.cV(optBoolean12);
        if (optBoolean) {
            appBrandVideoView.jsy = new e(appBrandVideoView, pVar);
        }
        int optInt3 = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, -1);
        x.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView filePath=%s live=%b", new Object[]{jSONObject.optString(DownloadInfoColumns.FILEPATH), Boolean.valueOf(jSONObject.optBoolean("live", false))});
        appBrandVideoView.e(r4, optBoolean2, optInt3);
    }
}

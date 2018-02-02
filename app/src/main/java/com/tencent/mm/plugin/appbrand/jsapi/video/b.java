package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends c {
    private static final int CTRL_INDEX = 114;
    public static final String NAME = "operateVideoPlayer";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        int i2 = -1;
        x.i("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView : videoPlayerId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).w(AppBrandVideoView.class);
            if (appBrandVideoView == null) {
                x.e("MicroMsg.JsApiOperateVideoPlayer", "view not AppBrandVideoView");
                return false;
            }
            int i3;
            String optString = jSONObject.optString(DownloadSettingTable$Columns.TYPE);
            x.i("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView operateType=%s", new Object[]{optString});
            boolean z;
            switch (optString.hashCode()) {
                case -802181223:
                    if (optString.equals("exitFullScreen")) {
                        i3 = 4;
                        break;
                    }
                case 1222225:
                    if (optString.equals("sendDanmu")) {
                        i3 = 7;
                        break;
                    }
                case 3443508:
                    if (optString.equals("play")) {
                        z = false;
                        break;
                    }
                case 3526264:
                    if (optString.equals("seek")) {
                        i3 = 6;
                        break;
                    }
                case 3540994:
                    if (optString.equals("stop")) {
                        i3 = 2;
                        break;
                    }
                case 106440182:
                    if (optString.equals("pause")) {
                        z = true;
                        break;
                    }
                case 458133450:
                    if (optString.equals("requestFullScreen")) {
                        i3 = 3;
                        break;
                    }
                case 1355420059:
                    if (optString.equals("playbackRate")) {
                        i3 = 5;
                        break;
                    }
                default:
                    i3 = -1;
                    break;
            }
            JSONArray optJSONArray;
            JSONArray optJSONArray2;
            switch (i3) {
                case 0:
                    appBrandVideoView.start();
                    break;
                case 1:
                    appBrandVideoView.pause();
                    break;
                case 2:
                    appBrandVideoView.stop();
                    break;
                case 3:
                    optJSONArray = jSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                    if (optJSONArray == null || optJSONArray.length() == 0) {
                        x.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView directionArr nil");
                    } else {
                        i2 = optJSONArray.optInt(0, -1);
                    }
                    appBrandVideoView.f(true, i2);
                    break;
                case 4:
                    appBrandVideoView.f(false, -1);
                    break;
                case 5:
                    optJSONArray2 = jSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                    if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                        double optDouble = optJSONArray2.optDouble(0, -1.0d);
                        if (optDouble >= 0.0d) {
                            x.i("MicroMsg.AppBrandVideoView", "setPlaybackRate %s", new Object[]{Float.valueOf((float) optDouble)});
                            appBrandVideoView.jsj.aa(r1);
                            break;
                        }
                        x.i("MicroMsg.JsApiOperateVideoPlayer", "rate invalid %f", new Object[]{Double.valueOf(optDouble)});
                        return false;
                    }
                    x.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
                    return false;
                    break;
                case 6:
                    optJSONArray = jSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        i2 = optJSONArray.optInt(0, -1);
                        if (i2 >= 0) {
                            appBrandVideoView.w(i2, false);
                            break;
                        }
                        x.i("MicroMsg.JsApiOperateVideoPlayer", "pos invalid %d", new Object[]{Integer.valueOf(i2)});
                        return false;
                    }
                    x.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
                    return false;
                case 7:
                    optJSONArray2 = jSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                    if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                        if (optJSONArray2.length() != 1) {
                            appBrandVideoView.bj(optJSONArray2.optString(0, ""), optJSONArray2.optString(1, ""));
                            break;
                        }
                        appBrandVideoView.bj(optJSONArray2.optString(0, ""), "");
                        break;
                    }
                    x.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
                    return false;
                    break;
                default:
                    x.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView operateType not supported: %s", new Object[]{optString});
                    return false;
            }
            return true;
        }
        x.w("MicroMsg.JsApiOperateVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }
}

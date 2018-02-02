package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class e$1 implements a {
    final /* synthetic */ e jtt;

    e$1(e eVar) {
        this.jtt = eVar;
    }

    public final boolean uF() {
        try {
            int ahj = this.jtt.jtp.jsj.ahj();
            if (Math.abs(ahj - this.jtt.jts) >= 250) {
                JSONObject ahm = this.jtt.ahm();
                this.jtt.jts = ahj;
                ahm.put("position", this.jtt.jtp.jsj.ahk());
                String str = FFmpegMetadataRetriever.METADATA_KEY_DURATION;
                AppBrandVideoView appBrandVideoView = this.jtt.jtp;
                ahm.put(str, appBrandVideoView.mDuration > 0 ? appBrandVideoView.mDuration : appBrandVideoView.jsj.ahi());
                this.jtt.a(new g((byte) 0), ahm);
            }
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", new Object[]{e});
        }
        return true;
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 413;
    public static final String NAME = "scrollWebviewTo";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        long optLong = jSONObject.optLong(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 300);
        if (jSONObject.has("scrollTop")) {
            try {
                ag.y(new 1(this, pVar, Math.round(f.ac(new BigDecimal(jSONObject.getString("scrollTop")).floatValue())), optLong, i));
                return;
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", new Object[]{e});
                pVar.E(i, e("fail:invalid data " + bh.ou(e.getMessage()), null));
                return;
            }
        }
        pVar.E(i, e("fail:invalid data", null));
    }
}

package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.b.b$a;
import com.tencent.mm.z.u.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public d(int i) {
        super(ad.NAME, i);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, b$a<JSONObject> com_tencent_mm_u_b_b_a_org_json_JSONObject) {
        Context context = aVar.getContext();
        b Cb = aVar.Cb();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        Map hashMap = new HashMap();
        hashMap.put("model", q.yJ());
        hashMap.put("pixelRatio", Float.valueOf(f));
        hashMap.put("windowWidth", Integer.valueOf(f.lH(Cb.getInt("__page_view_width", 0))));
        hashMap.put("windowHeight", Integer.valueOf(f.lH(Cb.getInt("__page_view_height", 0))));
        hashMap.put("screenWidth", Integer.valueOf(f.lH(displayMetrics.widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(f.lH(displayMetrics.heightPixels)));
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, w.eL(context));
        hashMap.put("version", com.tencent.mm.sdk.platformtools.f.ag(null, com.tencent.mm.protocal.d.vAz));
        hashMap.put("system", "Android " + VERSION.RELEASE);
        com_tencent_mm_u_b_b_a_org_json_JSONObject.aw(a(true, "", hashMap));
    }
}

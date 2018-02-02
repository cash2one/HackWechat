package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.game.l;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import org.json.JSONObject;

public final class ad extends l {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";
    private float jdb = -1.0f;

    public final String a(j jVar, JSONObject jSONObject) {
        int[] iArr;
        HashMap hashMap = new HashMap();
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        hashMap.put("pixelRatio", Float.valueOf(jVar.getContext().getResources().getDisplayMetrics().density));
        if (c(jVar) != null) {
            x.i("MicroMsg.JsApiGetSystemInfo", "Method: normal");
            iArr = new int[]{c(jVar).getWidth(), c(jVar).getHeight()};
        } else if (jVar.getContext() instanceof Activity) {
            x.i("MicroMsg.JsApiGetSystemInfo", "Method: DecorView");
            jVar.getContext().getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
            iArr = new int[]{r2.right - r2.left, (r2.bottom - r2.top) - a.fromDPToPix(jVar.getContext(), 48)};
        } else {
            x.i("MicroMsg.JsApiGetSystemInfo", "Method: Screen");
            iArr = new int[]{jVar.getContext().getResources().getDisplayMetrics().widthPixels, jVar.getContext().getResources().getDisplayMetrics().heightPixels};
        }
        hashMap.put("windowWidth", Integer.valueOf(f.lH(iArr[0])));
        hashMap.put("windowHeight", Integer.valueOf(f.lH(iArr[1])));
        if (jVar.irP == null || !jVar.irP.Yz()) {
            hashMap.put("screenWidth", Integer.valueOf(f.lH(jVar.getContext().getResources().getDisplayMetrics().widthPixels)));
            hashMap.put("screenHeight", Integer.valueOf(f.lH(jVar.getContext().getResources().getDisplayMetrics().heightPixels)));
        } else {
            Point point = new Point();
            l.iXJ.b(point);
            hashMap.put("screenWidth", Integer.valueOf(f.lH(point.x)));
            hashMap.put("screenHeight", Integer.valueOf(f.lH(point.y)));
        }
        if (jVar.irP.iqy.iMy.abN()) {
            hashMap.put("statusBarHeight", Integer.valueOf(f.lH(com.tencent.mm.ui.statusbar.a.ab(jVar.getContext()))));
        }
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, w.eL(jVar.getContext()));
        hashMap.put("version", com.tencent.mm.sdk.platformtools.f.ag(null, d.vAz));
        hashMap.put("system", "Android " + VERSION.RELEASE);
        hashMap.put("benchmarkLevel", Integer.valueOf(jVar.irP.iqx.iOH));
        if (this.jdb != -1.0f) {
            hashMap.put("fontSizeSetting", Integer.valueOf((int) (this.jdb * 16.0f)));
        } else {
            float f = MultiProcessSharedPreferences.getSharedPreferences(jVar.getContext(), ac.cfs(), 0).getFloat("text_size_scale_key", 1.0f);
            hashMap.put("fontSizeSetting", Integer.valueOf((int) (f * 16.0f)));
            this.jdb = f;
        }
        return e("ok", hashMap);
    }

    private static View c(j jVar) {
        p b = b(jVar);
        return b == null ? null : b.aeM();
    }
}

package com.tencent.mm.plugin.appbrand.jsapi;

import android.animation.ObjectAnimator;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.plugin.appbrand.widget.c.4;
import org.json.JSONObject;

public final class bj extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "showTabBar";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        l aiT = jVar.irP.iqC.aiT();
        if (aiT instanceof e) {
            int i2;
            c cVar = ((e) aiT).jCV;
            boolean optBoolean = jSONObject.optBoolean("animation", true);
            String str = "translationY";
            float[] fArr = new float[2];
            int height = cVar.getHeight();
            if ("top".equals(cVar.jUw)) {
                i2 = -1;
            } else {
                i2 = 1;
            }
            fArr[0] = (float) (i2 * height);
            fArr[1] = 0.0f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cVar, str, fArr);
            ofFloat.setDuration(optBoolean ? 250 : 0);
            cVar.post(new 4(cVar, ofFloat));
            jVar.E(i, e("ok", null));
            return;
        }
        jVar.E(i, e("fail:not TabBar page", null));
    }
}

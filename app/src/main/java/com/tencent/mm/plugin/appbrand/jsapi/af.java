package com.tencent.mm.plugin.appbrand.jsapi;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.plugin.appbrand.widget.c.3;
import org.json.JSONObject;

public final class af extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "hideTabBar";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        l aiT = jVar.irP.iqC.aiT();
        if (aiT instanceof e) {
            int i2;
            c cVar = ((e) aiT).jCV;
            boolean optBoolean = jSONObject.optBoolean("animation", true);
            String str = "translationY";
            float[] fArr = new float[2];
            fArr[0] = 0.0f;
            int height = cVar.getHeight();
            if ("top".equals(cVar.jUw)) {
                i2 = -1;
            } else {
                i2 = 1;
            }
            fArr[1] = (float) (i2 * height);
            Animator ofFloat = ObjectAnimator.ofFloat(cVar, str, fArr);
            ofFloat.setDuration(optBoolean ? 250 : 0);
            cVar.a(ofFloat, new 3(cVar));
            jVar.E(i, e("ok", null));
            return;
        }
        jVar.E(i, e("fail:not TabBar page", null));
    }
}

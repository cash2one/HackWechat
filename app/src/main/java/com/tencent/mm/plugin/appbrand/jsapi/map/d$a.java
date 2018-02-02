package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.compat.a.b.e;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.widget.e.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class d$a implements e {
    final /* synthetic */ d jlZ;

    d$a(d dVar) {
        this.jlZ = dVar;
    }

    public final View a(h hVar) {
        String str = (String) this.jlZ.jlY.get(hVar.getId());
        if (!bh.ov(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                f.aP(jSONObject.optString("shadowColor", ""), Color.parseColor("#000000"));
                jSONObject.optInt("shadowOpacity");
                jSONObject.optInt("shadowOffsetX");
                jSONObject.optInt("shadowOffsetY");
                View linearLayout = new LinearLayout(this.jlZ.jia.mContext);
                linearLayout.setLayoutParams(new LayoutParams(-2, -2));
                linearLayout.setOrientation(1);
                linearLayout.setGravity(17);
                int lI = f.lI(3);
                linearLayout.setPadding(lI, lI, lI, lI);
                View textView = new TextView(this.jlZ.jia.mContext);
                Object optString = jSONObject.optString("color");
                lI = Color.parseColor("#000000");
                if (!TextUtils.isEmpty(optString)) {
                    lI = f.aP(optString, Color.parseColor("#000000"));
                }
                if (jSONObject.has("padding")) {
                    int a = f.a(jSONObject, "padding", 0);
                    textView.setPadding(a, a, a, a);
                }
                textView.setTextColor(lI);
                if (jSONObject.has("fontSize")) {
                    textView.setTextSize((float) jSONObject.optInt("fontSize"));
                }
                if (jSONObject.has("content")) {
                    textView.setText(jSONObject.optString("content"));
                }
                textView.setLayoutParams(new LayoutParams(-2, -2));
                if (jSONObject.has("textAlign")) {
                    String optString2 = jSONObject.optString("textAlign", "");
                    if (optString2.equals("left")) {
                        textView.setGravity(3);
                    } else if (optString2.equals("right")) {
                        textView.setGravity(5);
                    } else if (optString2.equals("center")) {
                        textView.setGravity(17);
                    }
                }
                linearLayout.addView(textView);
                Drawable bVar = new b();
                if (jSONObject.has("borderRadius")) {
                    bVar.Wl = (float) jSONObject.optInt("borderRadius");
                }
                bVar.fC.setColor(f.aP(jSONObject.optString("bgColor", ""), Color.parseColor("#000000")));
                linearLayout.setBackgroundDrawable(bVar);
                return linearLayout;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", e, "getInfoWindow", new Object[0]);
            }
        }
        return null;
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a extends c {
    public static final int CTRL_INDEX = 342;
    public static final String NAME = "animateCoverView";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final boolean a(p pVar, int i, View view, JSONObject jSONObject, f fVar) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("finalStyle");
            float a = com.tencent.mm.plugin.appbrand.p.f.a(jSONObject2, "left", com.tencent.mm.plugin.appbrand.p.f.ab(view.getX()));
            float a2 = com.tencent.mm.plugin.appbrand.p.f.a(jSONObject2, "top", com.tencent.mm.plugin.appbrand.p.f.ab(view.getY()));
            float optDouble = (float) jSONObject2.optDouble("opacity", (double) view.getAlpha());
            int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 300);
            String optString = jSONObject.optString("easing", "linear");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "x", new float[]{view.getX(), a});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "y", new float[]{view.getY(), a2});
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", new float[]{view.getAlpha(), optDouble});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration((long) optInt);
            TimeInterpolator timeInterpolator = null;
            if (optString != null) {
                if (optString.equals("ease")) {
                    timeInterpolator = new AccelerateDecelerateInterpolator();
                } else if (optString.equals("ease-in")) {
                    timeInterpolator = new AccelerateInterpolator();
                } else if (optString.equals("ease-out")) {
                    timeInterpolator = new DecelerateInterpolator();
                }
            }
            if (timeInterpolator == null) {
                timeInterpolator = new LinearInterpolator();
            }
            animatorSet.setInterpolator(timeInterpolator);
            animatorSet.addListener(new 1(this, fVar));
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
            animatorSet.start();
            return true;
        } catch (Throwable e) {
            x.w("MicroMsg.JsApiAnimateCoverView", "get finalStyle error : %s", new Object[]{Log.getStackTraceString(e)});
            fVar.sj(e("fail:missing finalStyle", null));
            return false;
        }
    }

    protected final boolean afN() {
        return true;
    }
}

package com.tencent.mm.ui.c;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.c.a.c;

public final class a {
    public static Animation fA(Context context) {
        if (context == null) {
            x.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
            return null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, com.tencent.mm.w.a.a.gUs);
        if (-1 > 0) {
            loadAnimation.setDuration(-1);
        }
        loadAnimation.setInterpolator(new c());
        return loadAnimation;
    }
}

package com.tencent.mm.ui.conversation;

import android.view.animation.Interpolator;

class ConversationOverscrollListView$c implements Interpolator {
    private float pyG = 1.3f;

    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        f2 = (((f2 * (this.pyG + 1.0f)) + this.pyG) * (f2 * f2)) + 1.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }
}

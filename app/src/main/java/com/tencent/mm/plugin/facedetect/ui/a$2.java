package com.tencent.mm.plugin.facedetect.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements AnimationListener {
    final /* synthetic */ a miY;
    final /* synthetic */ a$b mja;

    a$2(a aVar, a$b com_tencent_mm_plugin_facedetect_ui_a_b) {
        this.miY = aVar;
        this.mja = com_tencent_mm_plugin_facedetect_ui_a_b;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        x.i("MicroMsg.FaceDetectJumper", "showJumperEnd: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}

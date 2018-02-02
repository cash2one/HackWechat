package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ao$b;

class SnsTranslateResultView$1 implements AnimatorListener {
    final /* synthetic */ ao$b rKR;
    final /* synthetic */ SnsTranslateResultView rKS;

    SnsTranslateResultView$1(SnsTranslateResultView snsTranslateResultView, ao$b com_tencent_mm_plugin_sns_model_ao_b) {
        this.rKS = snsTranslateResultView;
        this.rKR = com_tencent_mm_plugin_sns_model_ao_b;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.rKR != null) {
            ao.a(this.rKR);
        }
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}

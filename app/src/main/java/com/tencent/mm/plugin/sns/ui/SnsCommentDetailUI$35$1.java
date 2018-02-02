package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.35;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

class SnsCommentDetailUI$35$1 implements Runnable {
    final /* synthetic */ View jLA;
    final /* synthetic */ 35 rAF;

    SnsCommentDetailUI$35$1(35 35, View view) {
        this.rAF = 35;
        this.jLA = view;
    }

    public final void run() {
        SnsCommentDetailUI snsCommentDetailUI = this.rAF.rAr;
        LinearLayout linearLayout = (LinearLayout) this.jLA;
        ImageView imageView = (ImageView) linearLayout.findViewById(f.qBc);
        Animation scaleAnimation = new ScaleAnimation(0.9f, DownloadHelper.SAVE_FATOR, 0.9f, DownloadHelper.SAVE_FATOR, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400);
        scaleAnimation.setStartOffset(100);
        scaleAnimation.setRepeatCount(0);
        imageView.clearAnimation();
        imageView.startAnimation(scaleAnimation);
        scaleAnimation.setAnimationListener(new SnsCommentDetailUI$38(snsCommentDetailUI, linearLayout));
        SnsCommentDetailUI.v(this.rAF.rAr);
    }
}

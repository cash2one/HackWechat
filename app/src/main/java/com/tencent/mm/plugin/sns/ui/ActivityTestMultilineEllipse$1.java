package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ActivityTestMultilineEllipse$1 implements OnClickListener {
    final /* synthetic */ QTextView rpw;
    final /* synthetic */ ActivityTestMultilineEllipse rpx;

    ActivityTestMultilineEllipse$1(ActivityTestMultilineEllipse activityTestMultilineEllipse, QTextView qTextView) {
        this.rpx = activityTestMultilineEllipse;
        this.rpw = qTextView;
    }

    public final void onClick(View view) {
        if (this.rpw.rwg) {
            QTextView qTextView = this.rpw;
            qTextView.rwg = false;
            qTextView.requestLayout();
            qTextView.invalidate();
            return;
        }
        qTextView = this.rpw;
        qTextView.rwg = true;
        qTextView.requestLayout();
        qTextView.invalidate();
    }
}

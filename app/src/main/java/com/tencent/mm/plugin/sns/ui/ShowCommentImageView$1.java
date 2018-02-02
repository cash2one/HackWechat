package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ShowCommentImageView$1 implements OnClickListener {
    final /* synthetic */ OnClickListener rwN;
    final /* synthetic */ ShowCommentImageView rwO;

    ShowCommentImageView$1(ShowCommentImageView showCommentImageView, OnClickListener onClickListener) {
        this.rwO = showCommentImageView;
        this.rwN = onClickListener;
    }

    public final void onClick(View view) {
        ShowCommentImageView.a(this.rwO, true);
        this.rwN.onClick(view);
    }
}

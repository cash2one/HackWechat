package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;

class ChatFooterCustom$3 implements OnClickListener {
    final /* synthetic */ ChatFooterCustom yqX;

    ChatFooterCustom$3(ChatFooterCustom chatFooterCustom) {
        this.yqX = chatFooterCustom;
    }

    public final void onClick(View view) {
        ChatFooterCustom.d(this.yqX).cro();
        ImageView imageView = (ImageView) view;
        int i;
        int i2;
        if (imageView.getTag() == null) {
            imageView.setTag(new Object());
            imageView.setImageResource(R.g.bDL);
            for (i = 0; i < ChatFooterCustom.e(this.yqX); i++) {
                View childAt = ChatFooterCustom.f(this.yqX).getChildAt(i);
                if (i >= 3) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                childAt.setVisibility(i2);
            }
            return;
        }
        imageView.setTag(null);
        imageView.setImageResource(R.g.bDK);
        for (i = 0; i < ChatFooterCustom.e(this.yqX); i++) {
            childAt = ChatFooterCustom.f(this.yqX).getChildAt(i);
            if (i < 3) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            childAt.setVisibility(i2);
        }
    }
}

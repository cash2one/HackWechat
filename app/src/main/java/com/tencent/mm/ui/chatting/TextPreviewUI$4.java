package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;

class TextPreviewUI$4 implements OnClickListener {
    final /* synthetic */ TextPreviewUI yxT;

    TextPreviewUI$4(TextPreviewUI textPreviewUI) {
        this.yxT = textPreviewUI;
    }

    public final void onClick(View view) {
        if (TextPreviewUI.b(this.yxT) == null) {
            return;
        }
        if (TextPreviewUI.b(this.yxT).fJl) {
            this.yxT.finish();
            return;
        }
        TextPreviewUI.b(this.yxT).cqd();
        TextPreviewUI.b(this.yxT).cqc();
    }
}

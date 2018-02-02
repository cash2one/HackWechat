package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.c.a;

class SnsCommentDetailUI$32 implements OnClickListener {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$32(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final void onClick(View view) {
        try {
            int intValue = ((Integer) view.getTag()).intValue();
            Intent intent = new Intent();
            intent.putExtra("sns_label_sns_info", intValue);
            a.ifs.x(intent, this.rAr);
        } catch (Exception e) {
        }
    }
}

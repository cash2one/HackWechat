package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.MMActivity;

class j$5 implements OnLongClickListener {
    final /* synthetic */ j rrK;

    j$5(j jVar) {
        this.rrK = jVar;
    }

    public final boolean onLongClick(View view) {
        g.Dk();
        if (((Boolean) g.Dj().CU().get(7490, Boolean.valueOf(true))).booleanValue()) {
            j.c(this.rrK).startActivity(new Intent().setClass(j.c(this.rrK), SnsLongMsgUI.class));
            g.Dk();
            g.Dj().CU().set(7490, Boolean.valueOf(false));
        } else {
            Intent intent = new Intent();
            intent.setClass(j.c(this.rrK), SnsCommentUI.class);
            intent.putExtra("sns_comment_type", 1);
            ((MMActivity) j.c(this.rrK)).startActivityForResult(intent, 9);
        }
        return true;
    }
}

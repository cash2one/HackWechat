package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class t$1 implements OnClickListener {
    final /* synthetic */ t yuo;

    t$1(t tVar) {
        this.yuo = tVar;
    }

    public final void onClick(View view) {
        new Intent().putExtra("composeType", 1);
        d.y(this.yuo.mContext, "qqmail", ".ui.ComposeUI");
    }
}

package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsStrangerCommentDetailUI$a$1 implements OnClickListener {
    final /* synthetic */ a rGX;

    SnsStrangerCommentDetailUI$a$1(a aVar) {
        this.rGX = aVar;
    }

    public final void onClick(View view) {
        String str = (String) view.getTag();
        x.d("MicroMsg.SnsStrangerCommentDetailUI", "onCommentClick:" + str);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        com.tencent.mm.plugin.sns.c.a.ifs.d(intent, a.a(this.rGX));
    }
}

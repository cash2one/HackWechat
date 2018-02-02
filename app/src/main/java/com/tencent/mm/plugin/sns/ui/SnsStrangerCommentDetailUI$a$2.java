package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.a;
import com.tencent.mm.pluginsdk.ui.d.n;

class SnsStrangerCommentDetailUI$a$2 extends n {
    final /* synthetic */ a rGX;

    SnsStrangerCommentDetailUI$a$2(a aVar, Object obj) {
        this.rGX = aVar;
        super(obj, null);
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", view.getTag().toString());
        com.tencent.mm.plugin.sns.c.a.ifs.d(intent, a.a(this.rGX));
    }
}

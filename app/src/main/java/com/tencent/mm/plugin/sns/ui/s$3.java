package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.ui.MMActivity;

class s$3 implements OnClickListener {
    final /* synthetic */ s rsQ;
    final /* synthetic */ Context val$context;

    s$3(s sVar, Context context) {
        this.rsQ = sVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        if (s.a(this.rsQ) != null) {
            String eq = s.a(this.rsQ).field_snsId == 0 ? "" : i.eq(s.a(this.rsQ).field_snsId);
            g.pQN.h(11989, new Object[]{Integer.valueOf(3), eq, Integer.valueOf(0)});
            int i = s.a(this.rsQ).roJ;
            Intent intent = new Intent();
            intent.setClass(this.val$context, SnsCommentDetailUI.class);
            intent.putExtra("INTENT_TALKER", s.a(this.rsQ).field_userName);
            intent.putExtra("INTENT_SNS_LOCAL_ID", u.ac("sns_table_", (long) i));
            intent.putExtra("INTENT_FROMGALLERY", true);
            ((MMActivity) this.val$context).startActivityForResult(intent, 1);
        }
    }
}

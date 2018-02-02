package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.plugin.report.service.g;

class NormalUserFooterPreference$a$7 implements OnClickListener {
    final /* synthetic */ a pkC;

    NormalUserFooterPreference$a$7(a aVar) {
        this.pkC = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14553, new Object[]{Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.a(this.pkC.pkA).field_username});
        this.pkC.isDeleteCancel = true;
        Intent intent = new Intent();
        intent.putExtra("Chat_User", NormalUserFooterPreference.a(this.pkC.pkA).field_username);
        intent.addFlags(67108864);
        d.a(this.pkC.pkA.mContext, ".ui.chatting.ChattingUI", intent);
    }
}

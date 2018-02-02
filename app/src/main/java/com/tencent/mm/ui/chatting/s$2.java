package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class s$2 implements OnClickListener {
    final /* synthetic */ s ytT;

    s$2(s sVar) {
        this.ytT = sVar;
    }

    public final void onClick(View view) {
        if (s.a(this.ytT).ytp.size() == 0) {
            x.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
            return;
        }
        Context context = s.b(this.ytT).getContext();
        h.a(context, context.getString(R.l.dTV), "", context.getString(R.l.dYt), context.getString(R.l.dEn), new 1(this, context), null, R.e.brm);
    }
}

package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r.b;
import com.tencent.mm.ui.chatting.viewitems.ar;

public class r$a extends b {
    public r$a(a aVar) {
        super(aVar);
    }

    public final void a(Intent intent, ar arVar) {
        if (!t.ov(arVar.yOH)) {
            intent.putExtra("Contact_BIZ_KF_WORKER_ID", arVar.yOH);
        }
    }
}

package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.storage.x;
import java.util.List;

class ai$2 implements OnClickListener {
    final /* synthetic */ x rAD;
    final /* synthetic */ Context val$context;
    final /* synthetic */ List yxK;
    final /* synthetic */ boolean yxL;

    ai$2(Context context, x xVar, List list, boolean z) {
        this.val$context = context;
        this.rAD = xVar;
        this.yxK = list;
        this.yxL = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ai.a(this.val$context, this.rAD, this.yxK, this.yxL);
    }
}

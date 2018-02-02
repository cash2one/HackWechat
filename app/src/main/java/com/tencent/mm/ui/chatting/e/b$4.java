package com.tencent.mm.ui.chatting.e;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.h;
import java.util.Set;

class b$4 implements OnClickListener {
    final /* synthetic */ au heZ;
    final /* synthetic */ Set yEi;
    final /* synthetic */ b yHl;

    b$4(b bVar, Set set, au auVar) {
        this.yHl = bVar;
        this.yEi = set;
        this.heZ = auVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BaseHistoryListPresenter", "delete message");
        h.a(this.yHl.mContext, this.yEi, new 1(this));
    }
}

package com.tencent.mm.ui.chatting.e;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.h;
import java.util.List;
import java.util.Set;

class e$5 implements OnClickListener {
    final /* synthetic */ List juo;
    final /* synthetic */ Set yEi;
    final /* synthetic */ e yHA;

    e$5(e eVar, Set set, List list) {
        this.yHA = eVar;
        this.yEi = set;
        this.juo = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "delete message");
        h.a(e.b(this.yHA), this.yEi, new 1(this));
    }
}

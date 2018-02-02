package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.i.a.a;

class e$5 implements a {
    final /* synthetic */ f mxX;
    final /* synthetic */ Context val$context;

    e$5(f fVar, Context context) {
        this.mxX = fVar;
        this.val$context = context;
    }

    public final void aJL() {
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", this.mxX.field_favProto.desc);
        d.a(this.val$context, ".ui.transmit.RetransmitPreviewUI", intent);
        b.fF(this.val$context);
    }
}

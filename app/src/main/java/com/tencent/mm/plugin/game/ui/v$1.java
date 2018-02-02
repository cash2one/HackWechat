package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;

class v$1 implements OnClickListener {
    final /* synthetic */ v nwa;
    final /* synthetic */ String val$url;

    v$1(v vVar, String str) {
        this.nwa = vVar;
        this.val$url = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.ac(v.a(this.nwa), this.val$url);
        ap.a(v.a(this.nwa), v.b(this.nwa).scene, v.b(this.nwa).fFj, v.b(this.nwa).position, 17, v.b(this.nwa).field_appId, v.c(this.nwa), v.b(this.nwa).fop, v.b(this.nwa).nbh);
    }
}

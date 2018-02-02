package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.g.a;

class g$2 implements Runnable {
    final /* synthetic */ f nbv;
    final /* synthetic */ WXMediaMessage nbw;
    final /* synthetic */ a nbx;
    final /* synthetic */ Context val$context;

    g$2(Context context, f fVar, WXMediaMessage wXMediaMessage, a aVar) {
        this.val$context = context;
        this.nbv = fVar;
        this.nbw = wXMediaMessage;
        this.nbx = aVar;
    }

    public final void run() {
        g.a(this.val$context, this.nbv.field_packageName, this.nbw, this.nbv.field_appId, this.nbv.field_openId, 0, this.nbx, null);
    }
}

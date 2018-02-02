package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.av.b;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements OnClickListener {
    final /* synthetic */ a oNi;

    a$1(a aVar) {
        this.oNi = aVar;
    }

    public final void onClick(View view) {
        asv Qs = b.Qs();
        if (Qs == null || !Qs.wAD || TextUtils.isEmpty(Qs.wAE)) {
            Intent intent = new Intent();
            g.pQN.h(11992, new Object[]{Integer.valueOf(1)});
            intent.putExtra("key_scene", 1);
            d.b((Context) this.oNi.voC.get(), "music", ".ui.MusicMainUI", intent);
            return;
        }
        x.i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", new Object[]{Qs.wAE});
        intent = new Intent();
        intent.putExtra("rawUrl", r0);
        d.b((Context) this.oNi.voC.get(), "webview", ".ui.tools.WebViewUI", intent);
    }
}

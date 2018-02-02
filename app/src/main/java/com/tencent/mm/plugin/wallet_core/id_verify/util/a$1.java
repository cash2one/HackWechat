package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wallet_core.ui.g$a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.e;

class a$1 implements g$a {
    final /* synthetic */ MMActivity fgW;
    final /* synthetic */ int sKm;
    final /* synthetic */ String sKn;
    final /* synthetic */ a sKo;

    a$1(a aVar, int i, String str, MMActivity mMActivity) {
        this.sKo = aVar;
        this.sKm = i;
        this.sKn = str;
        this.fgW = mMActivity;
    }

    public final void onClick(View view) {
        e.a(3, bh.Wo(), this.sKm);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.sKn);
        intent.putExtra("showShare", false);
        d.b(this.fgW, "webview", ".ui.tools.WebViewUI", intent);
    }
}

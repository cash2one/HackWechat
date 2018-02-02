package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.f.a.a;
import com.tencent.mm.ui.f.a.a.1;
import com.tencent.mm.ui.f.a.c;

public final class h {
    af handler;
    private c xNv;
    a xPR;

    static /* synthetic */ void a(h hVar, int i, String str) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        obtain.obj = str;
        hVar.handler.sendMessage(obtain);
    }

    public h(c cVar, a aVar) {
        this.xNv = cVar;
        this.xPR = aVar;
    }

    public final void cnV() {
        this.handler = new 1(this);
        Bundle bundle = new Bundle();
        bundle.putString("client_id", "290293790992170");
        bundle.putString("client_secret", "6667e9307e67283c76028fd37189c096");
        bundle.putString("grant_type", "fb_exchange_token");
        bundle.putString("fb_exchange_token", this.xNv.ykF);
        e.post(new 1(new a(this.xNv), "oauth/access_token", bundle, "GET", new 2(this), null), "AsyncFacebookRunner_request");
    }
}

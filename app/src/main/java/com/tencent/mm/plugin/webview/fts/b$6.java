package com.tencent.mm.plugin.webview.fts;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;

class b$6 extends s {
    final /* synthetic */ b tlF;

    b$6(b bVar) {
        this.tlF = bVar;
    }

    public final void iz(String str) {
        x.v("FTSSearchWidgetMgr", "on widget call %s ", "onMakePhoneCall");
        if (TextUtils.isEmpty(str)) {
            x.e("FTSSearchWidgetMgr", "onMakePhone null number");
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (bh.k(b.b(this.tlF), intent)) {
            b.b(this.tlF).startActivity(intent);
        }
    }
}

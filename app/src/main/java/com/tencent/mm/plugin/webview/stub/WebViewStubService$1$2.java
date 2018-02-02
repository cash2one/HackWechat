package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.plugin.webview.stub.WebViewStubService.1;
import com.tencent.wcdb.database.SQLiteDatabase;

class WebViewStubService$1$2 implements Runnable {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ Bundle jdd;
    final /* synthetic */ 1 tvH;

    WebViewStubService$1$2(1 1, Bundle bundle, Bundle bundle2) {
        this.tvH = 1;
        this.fhp = bundle;
        this.jdd = bundle2;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtras(this.fhp);
        intent.putExtra("isFromWebView", true);
        intent.putExtra("_stat_obj", this.jdd);
        a.ifs.t(intent, this.tvH.tvE);
    }
}

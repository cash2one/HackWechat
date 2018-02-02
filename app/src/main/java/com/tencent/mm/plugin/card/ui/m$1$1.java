package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.card.ui.m.1;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;

class m$1$1 implements OnClickListener {
    final /* synthetic */ String kVP;
    final /* synthetic */ 1 kVQ;

    m$1$1(1 1, String str) {
        this.kVQ = 1;
        this.kVP = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(this.kVP).toString()));
        m.a(this.kVQ.kVO).startActivity(intent);
    }
}

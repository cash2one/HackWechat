package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;

class c$6 implements OnClickListener {
    final /* synthetic */ String kVP;
    final /* synthetic */ c piX;

    c$6(c cVar, String str) {
        this.piX = cVar;
        this.kVP = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(this.kVP).toString()));
        if (bh.k(this.piX.fmM, intent)) {
            this.piX.fmM.startActivity(intent);
        }
    }
}

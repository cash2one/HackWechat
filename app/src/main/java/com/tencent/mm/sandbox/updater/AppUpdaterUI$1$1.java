package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sandbox.updater.AppUpdaterUI.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

class AppUpdaterUI$1$1 implements OnClickListener {
    final /* synthetic */ 1 xcr;

    AppUpdaterUI$1$1(1 1) {
        this.xcr = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AppUpdaterUI", "go to WebView");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.xcr.xcq.startActivity(intent);
    }
}

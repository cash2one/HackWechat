package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sandbox.updater.AppUpdaterUI.7;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.database.SQLiteDatabase;

class AppUpdaterUI$7$1 implements OnClickListener {
    final /* synthetic */ 7 xcs;

    AppUpdaterUI$7$1(7 7) {
        this.xcs = 7;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(AppUpdaterUI.e(this.xcs.xcq).xcD[0]));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        ac.getContext().startActivity(intent);
        AppUpdaterUI.f(this.xcs.xcq);
    }
}

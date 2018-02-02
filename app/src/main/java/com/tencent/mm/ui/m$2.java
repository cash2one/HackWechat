package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.d;
import com.tencent.wcdb.database.SQLiteDatabase;

class m$2 implements OnClickListener {
    final /* synthetic */ int kvg;
    final /* synthetic */ Activity oZ;
    final /* synthetic */ m xHN;

    m$2(m mVar, int i, Activity activity) {
        this.xHN = mVar;
        this.kvg = i;
        this.oZ = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.kvg == 32) {
            d.pPH.a(462, 3, 1, true);
        } else if (this.kvg == 96) {
            d.pPH.a(462, 4, 1, true);
        } else {
            d.pPH.a(462, 5, 1, true);
        }
        Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.oZ.startActivity(intent);
        dialogInterface.dismiss();
        MMAppMgr.b(this.oZ, true);
        this.oZ.finish();
    }
}

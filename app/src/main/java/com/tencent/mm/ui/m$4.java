package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.d;
import com.tencent.wcdb.database.SQLiteDatabase;

class m$4 implements OnClickListener {
    final /* synthetic */ int kvg;
    final /* synthetic */ Activity oZ;
    final /* synthetic */ m xHN;

    m$4(m mVar, int i, Activity activity) {
        this.xHN = mVar;
        this.kvg = i;
        this.oZ = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.kvg == 33) {
            d.pPH.a(462, 12, 1, true);
        } else if (this.kvg == 97) {
            d.pPH.a(462, 13, 1, true);
        } else {
            d.pPH.a(462, 14, 1, true);
        }
        Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.oZ.startActivity(intent);
        dialogInterface.dismiss();
        this.xHN.pyw = true;
        MMAppMgr.b(this.oZ, true);
        this.oZ.finish();
    }
}

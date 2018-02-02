package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

class NetworkDiagnoseReportUI$4 implements OnClickListener {
    final /* synthetic */ NetworkDiagnoseReportUI sfJ;

    NetworkDiagnoseReportUI$4(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        this.sfJ = networkDiagnoseReportUI;
    }

    public final void onClick(View view) {
        if (!bh.ov(NetworkDiagnoseReportUI.bz())) {
            File file = new File(NetworkDiagnoseReportUI.bz());
            if (file.exists()) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(file), "text/plain");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.sfJ.startActivity(intent);
            }
        }
    }
}

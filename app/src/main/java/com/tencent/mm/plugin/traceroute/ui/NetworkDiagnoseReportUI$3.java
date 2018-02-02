package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

class NetworkDiagnoseReportUI$3 implements OnClickListener {
    final /* synthetic */ NetworkDiagnoseReportUI sfJ;

    NetworkDiagnoseReportUI$3(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        this.sfJ = networkDiagnoseReportUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"WeChat_Log@qq.com"});
        intent.putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(this.sfJ));
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(NetworkDiagnoseReportUI.bz())));
        intent.setType("text/plain");
        this.sfJ.startActivity(intent);
    }
}

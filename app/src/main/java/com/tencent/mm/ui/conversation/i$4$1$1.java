package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.conversation.i.4.1;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

class i$4$1$1 implements OnClickListener {
    final /* synthetic */ 1 yZB;

    i$4$1$1(1 1) {
        this.yZB = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setDataAndType(Uri.fromFile(new File(this.yZB.yZA.yZz.wQA)), "application/vnd.android.package-archive");
        i.a(this.yZB.yZA.yZy).startActivity(intent);
        g.pQN.a(614, 50, 1, false);
        dialogInterface.dismiss();
    }
}

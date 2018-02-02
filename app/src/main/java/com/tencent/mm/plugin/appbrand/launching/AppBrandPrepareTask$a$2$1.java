package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.2;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.database.SQLiteDatabase;

class AppBrandPrepareTask$a$2$1 implements Runnable {
    final /* synthetic */ 2 jxg;

    AppBrandPrepareTask$a$2$1(2 2) {
        this.jxg = 2;
    }

    public final void run() {
        Toast.makeText(ac.getContext(), j.iyo, 0).show();
        try {
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864);
            d.a(ac.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
        } catch (Exception e) {
        }
    }
}

package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.ae.b;
import com.tencent.mm.plugin.ae.c;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public class WXShortcutEntryActivity extends AutoLoginActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final boolean z(Intent intent) {
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.WXShortcutEntryActivity", "intent is null");
            finish();
            return;
        }
        c cVar = c.qsQ;
        int a = t.a(intent, DownloadSettingTable$Columns.TYPE, 0);
        if (intent != null) {
            b bVar = (b) cVar.qsR.get(a);
            if (bVar != null) {
                bVar.l(this, intent);
            }
        }
        finish();
    }
}

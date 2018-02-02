package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.console.Shell.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

class Shell$1 implements a {
    Shell$1() {
    }

    public final void m(Intent intent) {
        int intExtra = intent.getIntExtra(DownloadSettingTable$Columns.TYPE, Integer.MAX_VALUE);
        int intExtra2 = intent.getIntExtra("error", 0);
        if (intExtra != Integer.MAX_VALUE && intExtra2 != 0) {
            x.w("MicroMsg.Shell", "kiro set Test.pushNextErrorRet(type=%d, err=%d)", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
            r.br(intExtra, intExtra2);
        }
    }
}

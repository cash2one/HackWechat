package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;

class JDRemindDialog$1 implements OnClickListener {
    final /* synthetic */ JDRemindDialog rVF;

    JDRemindDialog$1(JDRemindDialog jDRemindDialog) {
        this.rVF = jDRemindDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String str = null;
        String str2 = "";
        if (!(this.rVF.getIntent() == null || this.rVF.getIntent().getExtras() == null)) {
            str = this.rVF.getIntent().getExtras().getString("alertjumpurl");
            str2 = this.rVF.getIntent().getExtras().getString("alert_activityid");
        }
        if (str2.equals(c.bDO().bDT().rVK) && c.bDO().bDP()) {
            c.bDO().bDS();
            c.bDO().bDR();
        }
        if (!bh.ov(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            d.b(this.rVF, "webview", ".ui.tools.WebViewUI", intent);
            g.pQN.h(11179, str, c.bDO().bDT().rVK, Integer.valueOf(5));
        }
        this.rVF.finish();
    }
}

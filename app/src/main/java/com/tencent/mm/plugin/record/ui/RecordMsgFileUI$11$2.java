package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI.11;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import java.io.File;

class RecordMsgFileUI$11$2 implements d {
    final /* synthetic */ 11 pGt;

    RecordMsgFileUI$11$2(11 11) {
        this.pGt = 11;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                if (RecordMsgFileUI.c(this.pGt.pGq) == 8) {
                    String c = h.c(RecordMsgFileUI.a(this.pGt.pGq), RecordMsgFileUI.b(this.pGt.pGq));
                    if (!e.bO(c)) {
                        x.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                        Toast.makeText(this.pGt.pGq, this.pGt.pGq.getString(R.l.egx), 1).show();
                        return;
                    } else if (new File(c).length() > 10485760) {
                        x.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                        Toast.makeText(this.pGt.pGq, this.pGt.pGq.getString(R.l.egy), 1).show();
                        return;
                    }
                }
                RecordMsgFileUI.h(this.pGt.pGq);
                return;
            default:
                return;
        }
    }
}

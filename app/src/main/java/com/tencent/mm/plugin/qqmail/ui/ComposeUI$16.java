package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class ComposeUI$16 implements OnClickListener {
    final /* synthetic */ String gBF;
    final /* synthetic */ int gIp;
    final /* synthetic */ ComposeUI prr;
    final /* synthetic */ File val$file;

    ComposeUI$16(ComposeUI composeUI, int i, File file, String str) {
        this.prr = composeUI;
        this.gIp = i;
        this.val$file = file;
        this.gBF = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (ComposeUI.E(this.prr).bkS() + this.gIp > 52428800) {
            h.a(this.prr, R.l.eAP, R.l.dGO, null);
            return;
        }
        if (ComposeUI.j(this.prr).getText().toString().trim().length() == 0) {
            String trim = this.val$file.getName().trim();
            int lastIndexOf = trim.lastIndexOf(".");
            EditText j = ComposeUI.j(this.prr);
            if (lastIndexOf <= 0) {
                lastIndexOf = trim.length();
            }
            j.setText(trim.substring(0, lastIndexOf));
        }
        x.i("MicroMsg.ComposeUI", "in upload file mode = %d", Integer.valueOf(ComposeUI.a(this.prr)));
        ComposeUI.E(this.prr).dI(this.gBF, null);
    }
}

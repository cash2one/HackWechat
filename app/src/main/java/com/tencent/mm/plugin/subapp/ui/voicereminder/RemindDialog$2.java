package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.plugin.subapp.c.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;

class RemindDialog$2 implements OnClickListener {
    final /* synthetic */ RemindDialog rYR;

    RemindDialog$2(RemindDialog remindDialog) {
        this.rYR = remindDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d bEa = d.bEa();
        if (bEa != null) {
            bEa.hL(RemindDialog.c(this.rYR));
        }
        if (s.hb(ar.getNotification().wX())) {
            this.rYR.finish();
            return;
        }
        b.ifs.e(new Intent().putExtra("Chat_User", RemindDialog.c(this.rYR)), this.rYR);
        this.rYR.finish();
    }
}

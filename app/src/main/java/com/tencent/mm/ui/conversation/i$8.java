package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.dbbackup.DBRecoveryUI;

class i$8 implements OnClickListener {
    final /* synthetic */ i yZy;

    i$8(i iVar) {
        this.yZy = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        i.e(this.yZy).dismiss();
        Intent intent = new Intent(i.a(this.yZy), DBRecoveryUI.class);
        intent.putExtra("scene", 0);
        i.a(this.yZy).startActivity(intent);
    }
}

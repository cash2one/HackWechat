package com.tencent.mm.ui.conversation.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class m$1 implements OnClickListener {
    m$1() {
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]yes");
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }
}

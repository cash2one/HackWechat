package com.tencent.mm.plugin.subapp.ui.friend;

import android.os.Bundle;
import com.tencent.mm.bf.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;

public class FMessageTransferUI extends MMActivity {
    private int fgs;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("friend_message_transfer_username");
        l.Tx().mS(stringExtra);
        l.Tx().Tn();
        String action = getIntent().getAction();
        String str = "friend_message_accept_" + stringExtra;
        this.fgs = 2130706432 | (Integer.MAX_VALUE & stringExtra.hashCode());
        ar.getNotification().cancel(this.fgs);
        if (str.equals(action)) {
            a.g(this.mController.xIM, stringExtra, true);
        }
        finish();
    }

    protected final int getLayoutId() {
        return -1;
    }
}

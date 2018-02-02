package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.ak.a;

class ReadMailUI$4 implements a {
    final /* synthetic */ ReadMailUI puG;

    ReadMailUI$4(ReadMailUI readMailUI) {
        this.puG = readMailUI;
    }

    public final boolean uF() {
        if (!ReadMailUI.l(this.puG).isConnected()) {
            return false;
        }
        double doubleValue = ((Double) new ReadMailProxy(ReadMailUI.l(this.puG), null).REMOTE_CALL("getMailAppDownloadProgress", new Object[]{Long.valueOf(ReadMailUI.B(this.puG))})).doubleValue();
        if (doubleValue == 1.0d) {
            ReadMailUI.t(this.puG);
            return false;
        }
        int i;
        if (ReadMailUI.N(this.puG) == 0) {
            ReadMailUI.c(this.puG, ReadMailUI.O(this.puG).getWidth());
            i = 0;
        } else {
            i = (int) (((double) ReadMailUI.N(this.puG)) * doubleValue);
        }
        ReadMailUI.b(this.puG, i);
        return true;
    }
}

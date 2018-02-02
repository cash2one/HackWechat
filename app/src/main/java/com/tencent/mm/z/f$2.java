package com.tencent.mm.z;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import org.xwalk.core.R$styleable;

class f$2 implements Runnable {
    final /* synthetic */ f heY;
    final /* synthetic */ au heZ;

    f$2(f fVar, au auVar) {
        this.heY = fVar;
        this.heZ = auVar;
    }

    public final void run() {
        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", new Object[]{Long.valueOf(this.heZ.field_msgId), Integer.valueOf(this.heZ.getType())});
        switch (this.heZ.getType()) {
            case 3:
            case 34:
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
            case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
            case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
            case 62:
            case 268435505:
                ba.j(this.heZ);
                return;
            default:
                return;
        }
    }
}

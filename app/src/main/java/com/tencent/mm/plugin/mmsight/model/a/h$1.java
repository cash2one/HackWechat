package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class h$1 extends af {
    final /* synthetic */ h ouI;

    h$1(h hVar, Looper looper) {
        this.ouI = hVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (this.ouI.oux != null) {
            this.ouI.oux.bat();
            this.ouI.oux = null;
        }
    }
}

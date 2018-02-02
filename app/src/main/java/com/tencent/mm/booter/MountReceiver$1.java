package com.tencent.mm.booter;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;

class MountReceiver$1 extends af {
    final /* synthetic */ MountReceiver gyg;

    MountReceiver$1(MountReceiver mountReceiver, Looper looper) {
        this.gyg = mountReceiver;
        super(looper);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        String str = "MicroMsg.MountReceiver";
        String str2 = "dkmount action:%s hasuin:%b ContextNull:%b SdcardFull:%b";
        Object[] objArr = new Object[4];
        objArr[0] = MountReceiver.a(this.gyg);
        objArr[1] = Boolean.valueOf(ar.Hj());
        if (MountReceiver.b(this.gyg) != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Boolean.valueOf(f.zf());
        x.d(str, str2, objArr);
        if (MountReceiver.b(this.gyg) != null && f.zf()) {
            u.fJ(MountReceiver.b(this.gyg));
        }
    }
}

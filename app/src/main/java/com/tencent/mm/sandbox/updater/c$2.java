package com.tencent.mm.sandbox.updater;

import android.os.Message;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$2 implements Runnable {
    final /* synthetic */ c xcI;
    final /* synthetic */ bdf xcJ;

    c$2(c cVar, bdf com_tencent_mm_protocal_c_bdf) {
        this.xcI = cVar;
        this.xcJ = com_tencent_mm_protocal_c_bdf;
    }

    public final void run() {
        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch start");
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = this.xcJ;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        int e = i.e(ac.getContext(), this.xcI.baW(), this.xcI.ceg(), c.c(this.xcI));
        x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "gen new apk finish, time cost = " + (System.currentTimeMillis() - valueOf.longValue()));
        if (e == 0) {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch ok");
            obtain.arg1 = 0;
            c.d(this.xcI).sendMessage(obtain);
            return;
        }
        x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch error in genNewAPKInNewThread()");
        File file = new File(this.xcI.ceg());
        if (file.exists()) {
            file.delete();
        }
        if (e == -1) {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_GEN_APK_ERR");
            obtain.arg1 = 3;
            c.d(this.xcI).sendMessage(obtain);
        } else if (e == -2) {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_APK_MD5_ERR");
            obtain.arg1 = 4;
            c.d(this.xcI).sendMessage(obtain);
        }
    }
}

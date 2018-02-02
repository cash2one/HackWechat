package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import com.tencent.mm.compatible.d.d.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class n {
    final Object lock = new byte[0];
    boolean otb = false;
    a otc;

    n() {
    }

    public final a o(Context context, int i) {
        if (context == null) {
            return null;
        }
        long Wp = bh.Wp();
        long id = Thread.currentThread().getId();
        synchronized (this.lock) {
            this.otb = false;
            this.otc = null;
            e.post(new 1(this, id, Wp, context, i), "SightCamera_openCamera");
            try {
                this.lock.wait(30000);
            } catch (InterruptedException e) {
                x.e("MicroMsg.SightCamera.OpenCameraThread", "Lock wait failed e:%s", e.getMessage());
            }
            if (this.otc == null || this.otc.gEB == null) {
                this.otb = true;
                x.e("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Timeout:%d", Long.valueOf(bh.Wp() - Wp));
                return null;
            }
            x.i("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Succ thread:%d Time:%d camera:%s", Long.valueOf(id), Long.valueOf(bh.Wp() - Wp), this.otc.gEB);
            a aVar = this.otc;
            return aVar;
        }
    }
}

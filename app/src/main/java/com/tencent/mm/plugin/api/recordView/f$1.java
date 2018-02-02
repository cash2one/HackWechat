package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements b {
    final /* synthetic */ f ipN;

    f$1(f fVar) {
        this.ipN = fVar;
    }

    public final void d(SurfaceTexture surfaceTexture) {
        if (this.ipN.ips.a(surfaceTexture, this.ipN.ipt, this.ipN.ipu, this.ipN.ipB) < 0) {
            x.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (this.ipN.ipJ != null) {
                this.ipN.ipJ.agh();
            }
        }
        if (this.ipN.ipD != -1) {
            this.ipN.Yi();
        }
        this.ipN.ips.aZY();
        this.ipN.Yd();
        x.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
    }
}

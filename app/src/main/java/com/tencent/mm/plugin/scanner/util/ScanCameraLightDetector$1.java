package com.tencent.mm.plugin.scanner.util;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ScanCameraLightDetector$1 extends af {
    final /* synthetic */ ScanCameraLightDetector qaG;

    public ScanCameraLightDetector$1(ScanCameraLightDetector scanCameraLightDetector, Looper looper) {
        this.qaG = scanCameraLightDetector;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 233) {
            a aVar = (a) message.obj;
            if (aVar != null) {
                long Wq = bh.Wq();
                x.i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", new Object[]{Boolean.valueOf(ScanCameraLightDetector.r(aVar.otM, aVar.width, aVar.height)), Float.valueOf(ScanCameraLightDetector.a(this.qaG)), Long.valueOf(bh.bA(Wq))});
                if (ScanCameraLightDetector.r(aVar.otM, aVar.width, aVar.height)) {
                    x.i("MicroMsg.ScanCameraLightDetector", "is dark now");
                    ag.y(new 1(this));
                    return;
                }
                x.i("MicroMsg.ScanCameraLightDetector", "not dark");
                ag.y(new 2(this));
            }
        }
    }
}

package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

class ad$2 implements Runnable {
    final /* synthetic */ ad lNY;

    ad$2(ad adVar) {
        this.lNY = adVar;
    }

    public final void run() {
        boolean hasSystemFeature = ac.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
        boolean hasSystemFeature2 = ac.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
        if (hasSystemFeature && hasSystemFeature2) {
            g.pQN.a(11891, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, true, true);
        } else if (hasSystemFeature) {
            g.pQN.a(11891, "1", true, true);
        } else if (hasSystemFeature2) {
            g.pQN.a(11891, "2", true, true);
        }
        x.i("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] deviceFeatures stepCounter %s, stepDetector %s", new Object[]{Boolean.valueOf(hasSystemFeature), Boolean.valueOf(hasSystemFeature2)});
    }
}

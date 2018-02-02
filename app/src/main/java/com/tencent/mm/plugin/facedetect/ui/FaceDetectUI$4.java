package com.tencent.mm.plugin.facedetect.ui;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$4 implements ServiceConnection {
    final /* synthetic */ FaceDetectUI mkq;

    FaceDetectUI$4(FaceDetectUI faceDetectUI) {
        this.mkq = faceDetectUI;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        x.i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", componentName);
        FaceDetectUI.a(this.mkq, true);
        FaceDetectUI.a(this.mkq, ((a) iBinder).mip);
        f fVar = f.mgf;
        FaceDetectProcessService d = FaceDetectUI.d(this.mkq);
        x.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", bh.r(ac.getContext(), Process.myPid()), Integer.valueOf(fVar.hashCode()));
        fVar.mgg = d;
        x.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI service hashCode: %d", Integer.valueOf(FaceDetectUI.d(this.mkq).hashCode()));
        FaceDetectUI.e(this.mkq);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        x.i("MicroMsg.FaceDetectUI", "alvinluo service disconnected %s", componentName.toString());
        FaceDetectUI.a(this.mkq, false);
    }
}

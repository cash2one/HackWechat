package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.rtmp.sharp.jni.TraeAudioManager.k;

class TraeAudioManager$g extends k {
    final /* synthetic */ TraeAudioManager a;

    TraeAudioManager$g(TraeAudioManager traeAudioManager) {
        this.a = traeAudioManager;
        super(traeAudioManager);
    }

    public void a() {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "connect bluetoothHeadset: do nothing");
        }
        e();
    }

    public String b() {
        return TraeAudioManager.DEVICE_BLUETOOTHHEADSET;
    }

    @TargetApi(8)
    public void c() {
        if (this.a._am != null) {
            d();
        }
    }

    @TargetApi(8)
    void d() {
        if (VERSION.SDK_INT > 8) {
            this.a._am.stopBluetoothSco();
        }
        this.a._am.setBluetoothScoOn(false);
    }
}

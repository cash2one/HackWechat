package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.rtmp.sharp.jni.TraeAudioManager.f;
import java.util.HashMap;

class TraeAudioManager$f$2 extends Handler {
    final /* synthetic */ f a;

    TraeAudioManager$f$2(f fVar) {
        this.a = fVar;
    }

    public void handleMessage(Message message) {
        HashMap hashMap;
        try {
            hashMap = (HashMap) message.obj;
        } catch (Exception e) {
            hashMap = null;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "TraeAudioManagerLooper msg:" + message.what + " _enabled:" + (this.a.g ? "Y" : "N"));
        }
        if (message.what == 32772) {
            this.a.a(hashMap);
        } else if (this.a.g) {
            String f;
            switch (message.what) {
                case 32773:
                    this.a.b();
                    return;
                case 32774:
                    this.a.b(hashMap);
                    return;
                case 32775:
                    this.a.p.InternalSessionConnectDevice(hashMap);
                    return;
                case 32776:
                    this.a.p.InternalSessionEarAction(hashMap);
                    return;
                case 32777:
                    this.a.p.InternalSessionIsDeviceChangabled(hashMap);
                    return;
                case 32778:
                    this.a.p.InternalSessionGetConnectedDevice(hashMap);
                    return;
                case 32779:
                    this.a.p.InternalSessionGetConnectingDevice(hashMap);
                    return;
                case 32780:
                    this.a.c(hashMap);
                    return;
                case 32781:
                    this.a.d(hashMap);
                    return;
                case 32782:
                    this.a.e(hashMap);
                    return;
                case 32783:
                    this.a.f(hashMap);
                    return;
                case 32784:
                    this.a.g(hashMap);
                    return;
                case 32785:
                case 32789:
                    f = this.a.p._deviceConfigManager.f();
                    String h = this.a.p._deviceConfigManager.h();
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:" + h + " highestDev" + f);
                    }
                    if (TraeAudioManager.IsUpdateSceneFlag) {
                        if (!TraeAudioManager.IsMusicScene || this.a.p.IsBluetoothA2dpExisted) {
                            this.a.p.InternalConnectDevice(f, null, true);
                            return;
                        } else {
                            this.a.p.InternalConnectDevice(this.a.p._deviceConfigManager.e(TraeAudioManager.DEVICE_BLUETOOTHHEADSET), null, true);
                            return;
                        }
                    } else if (f.equals(h)) {
                        this.a.p.InternalNotifyDeviceListUpdate();
                        return;
                    } else {
                        this.a.p.InternalConnectDevice(f, null, false);
                        return;
                    }
                case 32786:
                    f = (String) hashMap.get(TraeAudioManager.PARAM_DEVICE);
                    if (this.a.p.InternalConnectDevice(f, null, false) != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, " plugin dev:" + f + " sessionConnectedDev:" + this.a.p.sessionConnectedDev + " connected fail,auto switch!");
                        }
                        this.a.p.InternalConnectDevice(this.a.p._deviceConfigManager.f(), null, false);
                        return;
                    }
                    return;
                case 32787:
                    if (this.a.p.InternalConnectDevice(this.a.p.sessionConnectedDev, null, false) != 0) {
                        f = (String) hashMap.get(TraeAudioManager.PARAM_DEVICE);
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, " plugout dev:" + f + " sessionConnectedDev:" + this.a.p.sessionConnectedDev + " connected fail,auto switch!");
                        }
                        this.a.p.InternalConnectDevice(this.a.p._deviceConfigManager.f(), null, false);
                        return;
                    }
                    return;
                case 32788:
                    Integer num = (Integer) hashMap.get(TraeAudioManager.PARAM_STREAMTYPE);
                    if (num != null) {
                        this.a.p._streamType = num.intValue();
                        this.a.b(num.intValue());
                        return;
                    } else if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
                        return;
                    } else {
                        return;
                    }
                case 32790:
                    this.a.g();
                    return;
                case 32791:
                    this.a.a(this.a.p._streamType);
                    return;
                default:
                    return;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "******* disabled ,skip msg******");
            }
            this.a.p.sendResBroadcast(new Intent(), hashMap, 1);
        }
    }
}

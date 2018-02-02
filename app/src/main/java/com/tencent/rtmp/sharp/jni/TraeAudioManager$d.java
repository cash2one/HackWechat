package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.rtmp.sharp.jni.TraeAudioManager.e;

abstract class TraeAudioManager$d {
    final /* synthetic */ TraeAudioManager h;

    public abstract void a();

    abstract void a(Context context, Intent intent);

    abstract void a(IntentFilter intentFilter);

    public abstract boolean a(Context context, e eVar);

    public abstract boolean b();

    public abstract String c();

    TraeAudioManager$d(TraeAudioManager traeAudioManager) {
        this.h = traeAudioManager;
    }

    public void b(IntentFilter intentFilter) {
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        a(intentFilter);
    }

    public void a(Context context, Intent intent, e eVar) {
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "BT ACTION_STATE_CHANGED|   EXTRA_STATE " + a(intExtra));
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE " + a(intExtra2));
            }
            if (intExtra == 10) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "    BT off");
                }
                eVar.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
            } else if (intExtra == 12 && QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "BT OFF-->ON,Visiable it...");
            }
        } else if ("android.bluetooth.device.action.ACL_CONNECTED".equals(intent.getAction()) && VERSION.SDK_INT < 11) {
        } else {
            if (!"android.bluetooth.device.action.ACL_DISCONNECTED".equals(intent.getAction()) || VERSION.SDK_INT >= 11) {
                a(context, intent);
            }
        }
    }

    String a(int i) {
        String str;
        switch (i) {
            case 10:
                str = "STATE_OFF";
                break;
            case 11:
                str = "STATE_TURNING_ON";
                break;
            case 12:
                str = "STATE_ON";
                break;
            case 13:
                str = "STATE_TURNING_OFF";
                break;
            default:
                str = "unknow";
                break;
        }
        return str + ":" + i;
    }

    String b(int i) {
        String str;
        switch (i) {
            case -1:
                str = "SCO_AUDIO_STATE_ERROR";
                break;
            case 0:
                str = "SCO_AUDIO_STATE_DISCONNECTED";
                break;
            case 1:
                str = "SCO_AUDIO_STATE_CONNECTED";
                break;
            case 2:
                str = "SCO_AUDIO_STATE_CONNECTING";
                break;
            default:
                str = "unknow";
                break;
        }
        return str + ":" + i;
    }

    String c(int i) {
        String str;
        switch (i) {
            case 0:
                str = "STATE_DISCONNECTED";
                break;
            case 1:
                str = "STATE_CONNECTING";
                break;
            case 2:
                str = "STATE_CONNECTED";
                break;
            case 3:
                str = "STATE_DISCONNECTING";
                break;
            default:
                str = "unknow";
                break;
        }
        return str + ":" + i;
    }
}

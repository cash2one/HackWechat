package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import java.util.HashMap;

abstract class TraeAudioManager$k extends Thread {
    boolean b = true;
    boolean[] c = new boolean[]{false};
    HashMap<String, Object> d = null;
    long e = 0;
    final /* synthetic */ TraeAudioManager f;

    public abstract void a();

    public abstract String b();

    public abstract void c();

    TraeAudioManager$k(TraeAudioManager traeAudioManager) {
        this.f = traeAudioManager;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " ++switchThread:" + b());
        }
    }

    public void a(HashMap<String, Object> hashMap) {
        this.d = hashMap;
    }

    void e() {
        this.f._deviceConfigManager.g(b());
        a(0);
    }

    void a(int i) {
        this.f.InternalNotifyDeviceChangableUpdate();
        AudioDeviceInterface.LogTraceEntry(b() + " err:" + i);
        if (this.d == null) {
            this.f.InternalNotifyDeviceListUpdate();
            return;
        }
        this.f.sessionConnectedDev = this.f._deviceConfigManager.h();
        Long l = (Long) this.d.get(TraeAudioManager.PARAM_SESSIONID);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " sessonID:" + l);
        }
        if (l == null || l.longValue() == Long.MIN_VALUE) {
            this.f.InternalNotifyDeviceListUpdate();
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "processDeviceConnectRes sid null,don't send res");
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(TraeAudioManager.CONNECTDEVICE_RESULT_DEVICENAME, (String) this.d.get(TraeAudioManager.PARAM_DEVICE));
        if (this.f.sendResBroadcast(intent, this.d, i) == 0) {
            this.f.InternalNotifyDeviceListUpdate();
        }
        AudioDeviceInterface.LogTraceExit();
    }

    public void run() {
        AudioDeviceInterface.LogTraceEntry(b());
        this.f._deviceConfigManager.f(b());
        this.f.InternalNotifyDeviceChangableUpdate();
        a();
        synchronized (this.c) {
            this.c[0] = true;
            this.c.notify();
        }
        AudioDeviceInterface.LogTraceExit();
    }

    public void f() {
        AudioDeviceInterface.LogTraceEntry(b());
        this.b = false;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " quit:" + b() + " _running:" + this.b);
        }
        interrupt();
        c();
        synchronized (this.c) {
            if (!this.c[0]) {
                try {
                    this.c.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        AudioDeviceInterface.LogTraceExit();
    }
}

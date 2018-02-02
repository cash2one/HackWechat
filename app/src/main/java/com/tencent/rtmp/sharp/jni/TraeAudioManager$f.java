package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager.e;
import java.util.ArrayList;
import java.util.HashMap;

class TraeAudioManager$f extends Thread {
    Handler a = null;
    TraeMediaPlayer b = null;
    long c = -1;
    String d = "";
    String e = "";
    final boolean[] f = new boolean[]{false};
    boolean g = false;
    TraeAudioManager h = null;
    String i = "";
    int j = 0;
    int k = 0;
    long l = -1;
    String m = "";
    OnAudioFocusChangeListener n = null;
    int o = 0;
    final /* synthetic */ TraeAudioManager p;

    public TraeAudioManager$f(TraeAudioManager traeAudioManager, TraeAudioManager traeAudioManager2) {
        this.p = traeAudioManager;
        this.h = traeAudioManager2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "TraeAudioManagerLooper start...");
        }
        start();
        synchronized (this.f) {
            if (!this.f[0]) {
                try {
                    this.f.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "  start used:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
        }
    }

    public void a() {
        AudioDeviceInterface.LogTraceEntry("");
        if (this.a != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.a.getLooper().quit();
            synchronized (this.f) {
                if (this.f[0]) {
                    try {
                        this.f.wait(10000);
                    } catch (InterruptedException e) {
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "  quit used:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
            }
            this.a = null;
            AudioDeviceInterface.LogTraceExit();
        }
    }

    public int a(int i, HashMap<String, Object> hashMap) {
        if (this.a == null) {
            AudioDeviceInterface.LogTraceEntry(" fail mMsgHandler==null _enabled:" + (this.g ? "Y" : "N") + " activeMode:" + this.p._activeMode + " msg:" + i);
            return -1;
        }
        return this.a.sendMessage(Message.obtain(this.a, i, hashMap)) ? 0 : -1;
    }

    void a(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get(TraeAudioManager.EXTRA_DATA_DEVICECONFIG);
        TXCLog.w("TRAE", "startService cfg:" + str);
        AudioDeviceInterface.LogTraceEntry(" _enabled:" + (this.g ? "Y" : "N") + " activeMode:" + this.p._activeMode + " cfg:" + str);
        if (this.p._context != null) {
            QLog.w("TRAE", 2, "   startService:" + str);
            if (!(this.g && this.i.equals(str)) && this.p._activeMode == 0) {
                if (this.g) {
                    b();
                }
                d();
                this.p._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                this.p._deviceConfigManager.a();
                this.p._deviceConfigManager.a(str);
                this.i = str;
                if (this.p._am != null) {
                    this.j = this.p._am.getMode();
                }
                this.g = true;
                if (this.b == null) {
                    this.b = new TraeMediaPlayer(this.p._context, new 1(this));
                }
                a(this.g);
                this.p.updateDeviceStatus();
                AudioDeviceInterface.LogTraceExit();
            }
        }
    }

    void b() {
        AudioDeviceInterface.LogTraceEntry(" _enabled:" + (this.g ? "Y" : "N") + " activeMode:" + this.p._activeMode);
        if (this.g) {
            if (this.p._activeMode == 1) {
                h();
            } else if (this.p._activeMode == 2) {
                i();
            }
            if (this.p._switchThread != null) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "_switchThread:" + this.p._switchThread.b());
                }
                this.p._switchThread.f();
                this.p._switchThread = null;
            }
            if (this.b != null) {
                this.b.stopRing();
            }
            this.b = null;
            this.g = false;
            a(this.g);
            if (!(this.p._am == null || this.p._context == null)) {
                try {
                    this.p.InternalSetMode(0);
                } catch (Exception e) {
                }
            }
            e();
            AudioDeviceInterface.LogTraceExit();
        }
    }

    int a(boolean z) {
        if (this.p._context == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_SERVICE_STATE);
        intent.putExtra(TraeAudioManager.NOTIFY_SERVICE_STATE_DATE, z);
        if (this.p._context != null) {
            this.p._context.sendBroadcast(intent);
        }
        return 0;
    }

    public void run() {
        AudioDeviceInterface.LogTraceEntry("");
        Looper.prepare();
        this.a = new 2(this);
        c();
        synchronized (this.f) {
            this.f[0] = true;
            this.f.notify();
        }
        Looper.loop();
        f();
        synchronized (this.f) {
            this.f[0] = false;
            this.f.notify();
        }
        AudioDeviceInterface.LogTraceExit();
    }

    void c() {
        AudioDeviceInterface.LogTraceEntry("");
        try {
            this.p._audioSessionHost = new TraeAudioSessionHost();
            this.p._deviceConfigManager = new e(this.p);
            TraeAudioManager._gHostProcessId = Process.myPid();
            this.p._am = (AudioManager) this.p._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            this.p._bluetoothCheck = this.p.CreateBluetoothCheck(this.p._context, this.p._deviceConfigManager);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
            this.p._bluetoothCheck.b(intentFilter);
            intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            this.p._context.registerReceiver(this.h, intentFilter);
        } catch (Exception e) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "======7");
            }
        }
        AudioDeviceInterface.LogTraceExit();
    }

    void d() {
        try {
            this.p._am = (AudioManager) this.p._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (this.p._bluetoothCheck == null) {
                this.p._bluetoothCheck = this.p.CreateBluetoothCheck(this.p._context, this.p._deviceConfigManager);
            }
            this.p._context.unregisterReceiver(this.h);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
            this.p._bluetoothCheck.b(intentFilter);
            intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            this.p._context.registerReceiver(this.h, intentFilter);
        } catch (Exception e) {
        }
    }

    void e() {
        try {
            if (this.p._bluetoothCheck != null) {
                this.p._bluetoothCheck.a();
            }
            this.p._bluetoothCheck = null;
            if (this.p._context != null) {
                this.p._context.unregisterReceiver(this.h);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
                this.p._context.registerReceiver(this.h, intentFilter);
            }
        } catch (Exception e) {
        }
    }

    void f() {
        AudioDeviceInterface.LogTraceEntry("");
        try {
            b();
            if (this.p._bluetoothCheck != null) {
                this.p._bluetoothCheck.a();
            }
            this.p._bluetoothCheck = null;
            if (this.p._context != null) {
                this.p._context.unregisterReceiver(this.h);
                this.p._context = null;
            }
            if (this.p._deviceConfigManager != null) {
                this.p._deviceConfigManager.a();
            }
            this.p._deviceConfigManager = null;
        } catch (Exception e) {
        }
        AudioDeviceInterface.LogTraceExit();
    }

    int b(HashMap<String, Object> hashMap) {
        Intent intent = new Intent();
        HashMap j = this.p._deviceConfigManager.j();
        ArrayList arrayList = (ArrayList) j.get(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST);
        String str = (String) j.get(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE);
        String str2 = (String) j.get(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE);
        intent.putExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST, (String[]) arrayList.toArray(new String[0]));
        intent.putExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE, str);
        intent.putExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE, str2);
        intent.putExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME, this.p._deviceConfigManager.d());
        this.p.sendResBroadcast(intent, hashMap, 0);
        return 0;
    }

    @TargetApi(8)
    void a(int i) {
        if (VERSION.SDK_INT > 8 && this.n == null) {
            this.n = new 3(this);
            if (this.p._am != null) {
                int requestAudioFocus = this.p._am.requestAudioFocus(this.n, i, 1);
                if (requestAudioFocus != 1 && QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "request audio focus fail. " + requestAudioFocus + " mode:" + this.p._am.getMode());
                }
                this.o = i;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "-------requestAudioFocus _focusSteamType:" + this.o);
                }
            }
        }
    }

    @TargetApi(8)
    void g() {
        if (VERSION.SDK_INT > 8 && this.p._am != null && this.n != null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "-------abandonAudioFocus _focusSteamType:" + this.o);
            }
            this.p._am.abandonAudioFocus(this.n);
            this.n = null;
        }
    }

    int c(HashMap<String, Object> hashMap) {
        AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode);
        if (hashMap == null) {
            return -1;
        }
        if (this.p._am == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, " InternalVoicecallPreprocess am==null!!");
            }
            return -1;
        } else if (this.p._activeMode == 1) {
            this.p.sendResBroadcast(new Intent(), hashMap, 2);
            return -1;
        } else {
            this.l = ((Long) hashMap.get(TraeAudioManager.PARAM_SESSIONID)).longValue();
            this.m = (String) hashMap.get(TraeAudioManager.PARAM_OPERATION);
            this.p._activeMode = 1;
            this.p._prevMode = this.p._am.getMode();
            Integer.valueOf(-1);
            Integer.valueOf(0);
            Integer num = (Integer) hashMap.get(TraeAudioManager.PARAM_MODEPOLICY);
            if (num == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " params.get(PARAM_MODEPOLICY)==null!!");
                }
                this.p._modePolicy = -1;
            } else {
                this.p._modePolicy = num.intValue();
            }
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "  _modePolicy:" + this.p._modePolicy);
            }
            num = (Integer) hashMap.get(TraeAudioManager.PARAM_STREAMTYPE);
            if (num == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " params.get(PARAM_STREAMTYPE)==null!!");
                }
                this.p._streamType = 0;
            } else {
                this.p._streamType = num.intValue();
            }
            if (!TraeAudioManager.isCloseSystemAPM(this.p._modePolicy) || this.p._activeMode == 2 || this.p._deviceConfigManager == null) {
                this.p.InternalSetMode(TraeAudioManager.getCallAudioMode(this.p._modePolicy));
                a(this.p._streamType);
            } else if (this.p._deviceConfigManager.h().equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                this.p.InternalSetMode(0);
                a(3);
            } else {
                this.p.InternalSetMode(3);
                a(0);
            }
            this.p.sendResBroadcast(new Intent(), hashMap, 0);
            AudioDeviceInterface.LogTraceExit();
            return 0;
        }
    }

    int d(HashMap<String, Object> hashMap) {
        AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode);
        if (this.p._am == null) {
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.e("TRAE", 2, " InternalVoicecallPostprocess am==null!!");
            return -1;
        } else if (this.p._activeMode != 1) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, " not ACTIVE_VOICECALL!!");
            }
            this.p.sendResBroadcast(new Intent(), hashMap, 3);
            return -1;
        } else {
            this.p._activeMode = 0;
            g();
            AudioDeviceInterface.LogTraceExit();
            return 0;
        }
    }

    int h() {
        AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode);
        if (this.p._am == null) {
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.e("TRAE", 2, " am==null!!");
            return -1;
        } else if (this.p._activeMode == 1) {
            this.p._activeMode = 0;
            if (this.p._prevMode != -1) {
                this.p.InternalSetMode(this.p._prevMode);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TraeAudioManager.PARAM_SESSIONID, Long.valueOf(this.l));
            hashMap.put(TraeAudioManager.PARAM_OPERATION, this.m);
            this.p.sendResBroadcast(new Intent(), hashMap, 6);
            AudioDeviceInterface.LogTraceExit();
            return 0;
        } else if (!QLog.isColorLevel()) {
            return -1;
        } else {
            QLog.e("TRAE", 2, " not ACTIVE_RING!!");
            return -1;
        }
    }

    int e(HashMap<String, Object> hashMap) {
        boolean z = true;
        AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode);
        if (this.p._am == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, " InternalStartRing am==null!!");
            }
            return -1;
        }
        if (this.p._activeMode == 2) {
            i();
        }
        try {
            this.c = ((Long) hashMap.get(TraeAudioManager.PARAM_SESSIONID)).longValue();
            this.d = (String) hashMap.get(TraeAudioManager.PARAM_OPERATION);
            this.e = (String) hashMap.get(TraeAudioManager.PARAM_RING_USERDATA_STRING);
            int intValue = ((Integer) hashMap.get(TraeAudioManager.PARAM_RING_DATASOURCE)).intValue();
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "  dataSource:" + intValue);
            }
            int intValue2 = ((Integer) hashMap.get(TraeAudioManager.PARAM_RING_RSID)).intValue();
            Uri uri = (Uri) hashMap.get(TraeAudioManager.PARAM_RING_URI);
            String str = (String) hashMap.get(TraeAudioManager.PARAM_RING_FILEPATH);
            boolean booleanValue = ((Boolean) hashMap.get(TraeAudioManager.PARAM_RING_LOOP)).booleanValue();
            int intValue3 = ((Integer) hashMap.get(TraeAudioManager.PARAM_RING_LOOPCOUNT)).intValue();
            boolean booleanValue2 = ((Boolean) hashMap.get(TraeAudioManager.PARAM_RING_MODE)).booleanValue();
            if (this.p._activeMode != 1) {
                this.p._activeMode = 2;
            }
            Intent intent = new Intent();
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this.e);
            this.p.sendResBroadcast(intent, hashMap, 0);
            this.k = this.p._am.getMode();
            TraeMediaPlayer traeMediaPlayer = this.b;
            if (this.p._activeMode != 1) {
                z = false;
            }
            traeMediaPlayer.playRing(intValue, intValue2, uri, str, booleanValue, intValue3, booleanValue2, z, this.p._streamType);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " _ringUserdata:" + this.e + " DurationMS:" + this.b.getDuration());
            }
            if (!this.b.hasCall()) {
                a(this.b.getStreamType());
            }
            b(this.b.getStreamType());
            AudioDeviceInterface.LogTraceExit();
            return 0;
        } catch (Exception e) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, " startRing err params");
            }
            return -1;
        }
    }

    int f(HashMap<String, Object> hashMap) {
        AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode + " _preRingMode:" + this.k);
        if (this.p._am == null || this.b == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, " InternalStopRing am==null!!");
            }
            return -1;
        }
        this.b.stopRing();
        if (!this.b.hasCall() && this.p._activeMode == 2) {
            g();
            this.p._activeMode = 0;
        }
        Intent intent = new Intent();
        intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this.e);
        this.p.sendResBroadcast(intent, hashMap, 0);
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    int g(HashMap<String, Object> hashMap) {
        AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode + " _preRingMode:" + this.k);
        if (this.p._am == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, " InternalStopRing am==null!!");
            }
            return -1;
        }
        int streamType;
        if (this.p._activeMode == 2) {
            streamType = this.b.getStreamType();
        } else {
            streamType = this.p._streamType;
        }
        Intent intent = new Intent();
        intent.putExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, streamType);
        this.p.sendResBroadcast(intent, hashMap, 0);
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    int b(int i) {
        if (this.p._context == null) {
            return -1;
        }
        new Handler(Looper.getMainLooper()).post(new 4(this, i));
        return 0;
    }

    int i() {
        AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode + " _preRingMode:" + this.k);
        if (this.p._am == null) {
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.e("TRAE", 2, " interruptRing am==null!!");
            return -1;
        } else if (this.p._activeMode == 2) {
            this.b.stopRing();
            g();
            this.p._activeMode = 0;
            HashMap hashMap = new HashMap();
            hashMap.put(TraeAudioManager.PARAM_SESSIONID, Long.valueOf(this.c));
            hashMap.put(TraeAudioManager.PARAM_OPERATION, this.d);
            Intent intent = new Intent();
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this.e);
            this.p.sendResBroadcast(intent, hashMap, 4);
            AudioDeviceInterface.LogTraceExit();
            return 0;
        } else if (!QLog.isColorLevel()) {
            return -1;
        } else {
            QLog.e("TRAE", 2, " not ACTIVE_RING!!");
            return -1;
        }
    }

    void j() {
        HashMap hashMap = new HashMap();
        hashMap.put(TraeAudioManager.PARAM_SESSIONID, Long.valueOf(this.c));
        hashMap.put(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_RING_COMPLETION);
        Intent intent = new Intent();
        intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this.e);
        this.p.sendResBroadcast(intent, hashMap, 0);
    }
}

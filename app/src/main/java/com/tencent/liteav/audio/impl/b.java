package com.tencent.liteav.audio.impl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.log.TXCLog;

public class b {
    private static final String a = b.class.getSimpleName();
    private Context b;
    private BroadcastReceiver c;
    private boolean d = false;
    private BluetoothHeadset e;
    private ServiceListener f;
    private d g;

    public b(Context context) {
        this.b = context.getApplicationContext();
        this.c = new 1(this);
        this.f = new 2(this);
        boolean isWiredHeadsetOn = ((AudioManager) this.b.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).isWiredHeadsetOn();
        if (this.g != null) {
            this.g.OnHeadsetState(isWiredHeadsetOn);
        }
        this.d = false;
    }

    public void a(d dVar) {
        this.g = dVar;
        if (this.d) {
            TXCLog.w(a, " repeate register headset, ignore");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.b.registerReceiver(this.c, intentFilter);
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                defaultAdapter.getProfileProxy(this.b, this.f, 1);
            }
        } catch (Exception e) {
            TXCLog.e(a, "BluetoothAdapter getProfileProxy: " + e);
        }
        this.d = true;
    }

    public void a() {
        this.g = null;
        if (this.d) {
            this.d = false;
            this.b.unregisterReceiver(this.c);
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    defaultAdapter.closeProfileProxy(1, this.e);
                    return;
                }
                return;
            } catch (Exception e) {
                TXCLog.e(a, "BluetoothAdapter closeProfileProxy: " + e);
                return;
            }
        }
        TXCLog.w(a, " invalid unregister headset, ignore");
    }

    private void a(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null && this.e != null) {
            int connectionState;
            try {
                connectionState = this.e.getConnectionState(bluetoothDevice);
            } catch (Exception e) {
                TXCLog.e(a, "getConnectionState exception: " + e);
                connectionState = 0;
            }
            TXCLog.d(a, "蓝牙耳机状态：" + connectionState);
            switch (connectionState) {
                case 0:
                    if (c.a().f() != TXEAudioDef.TXE_AEC_SYSTEM) {
                        if (this.g != null) {
                            this.g.OnHeadsetState(false);
                        }
                    } else if (this.g != null) {
                        this.g.OnHeadsetState(true);
                    }
                    TXCLog.d(a, "蓝牙耳机拔出");
                    return;
                case 2:
                    if (this.g != null) {
                        this.g.OnHeadsetState(true);
                    }
                    TXCLog.d(a, "蓝牙耳机插入");
                    return;
                default:
                    return;
            }
        }
    }
}

package com.tencent.liteav.audio.impl;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.log.TXCLog;

class b$1 extends BroadcastReceiver {
    final /* synthetic */ b a;

    b$1(b bVar) {
        this.a = bVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (!intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null && b.b(this.a) != null) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                b.a(this.a, bluetoothDevice);
            }
        } else if (!intent.hasExtra("state")) {
        } else {
            if (intent.getIntExtra("state", 0) == 0) {
                if (c.a().f() != TXEAudioDef.TXE_AEC_SYSTEM) {
                    if (b.a(this.a) != null) {
                        b.a(this.a).OnHeadsetState(false);
                    }
                } else if (b.a(this.a) != null) {
                    b.a(this.a).OnHeadsetState(true);
                }
                TXCLog.d(b.b(), "耳机拔出");
            } else if (1 == intent.getIntExtra("state", 0)) {
                if (b.a(this.a) != null) {
                    b.a(this.a).OnHeadsetState(true);
                }
                TXCLog.d(b.b(), "耳机插入");
            }
        }
    }
}

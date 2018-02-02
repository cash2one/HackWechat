package com.tencent.mm.plugin.g.a.c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.HandlerThread;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class c$a {
    boolean kAa = false;
    final BluetoothDevice kAb;
    BluetoothSocket kzW;
    final boolean kzX = true;
    public final b kzY;
    public final a kzZ;
    public final af mHandler;
    private final HandlerThread mThread;

    public c$a(b bVar, a aVar, BluetoothDevice bluetoothDevice, boolean z) {
        this.kzZ = aVar;
        this.kzY = bVar;
        this.kAb = bluetoothDevice;
        this.mThread = e.Wf("BluetoothChatThreads_handlerThread");
        this.mThread.start();
        this.mHandler = new a(this.mThread.getLooper(), this);
    }

    public final void disconnect() {
        x.i("MicroMsg.exdevice.ConnectThread", "------disconnect------");
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1))) {
            x.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", new Object[]{Integer.valueOf(1)});
        }
        if (f.fM(18)) {
            this.mThread.quitSafely();
        } else {
            this.mThread.quit();
        }
    }
}

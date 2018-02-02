package com.tencent.mm.plugin.g.a.c;

import android.bluetooth.BluetoothSocket;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import junit.framework.Assert;

public final class c$c implements Runnable {
    private volatile boolean kAd = false;
    private volatile Runnable kAe = null;
    private OutputStream kAf = null;
    private final LinkedList<byte[]> kAg = new LinkedList();
    private final LinkedList<byte[]> kAh = new LinkedList();
    private b kzY = null;
    private a kzZ = null;

    public c$c(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
        this.kzY = bVar;
        this.kzZ = aVar;
        try {
            OutputStream outputStream = bluetoothSocket.getOutputStream();
            this.kAe = this;
            this.kAf = outputStream;
        } catch (IOException e) {
            x.e("MicroMsg.exdevice.SendThread", "temp sockets not created", new Object[]{e});
            this.kAf = null;
            if (this.kzZ != null) {
                this.kzZ.kzP.b(this.kzY.mSessionId, 11, "Can not get write stream");
            }
        }
    }

    public final void run() {
        x.i("MicroMsg.exdevice.SendThread", "BEGIN SendThread");
        if (this.kAf != null) {
            while (!this.kAd) {
                if (this.kAe == null) {
                    x.w("MicroMsg.exdevice.SendThread", "Send thread has been close. just leave");
                    return;
                } else if (!this.kAh.isEmpty()) {
                    try {
                        this.kAf.write((byte[]) this.kAh.pop());
                        if (this.kzZ != null) {
                            this.kzZ.kzP.h(this.kzY.mSessionId, true);
                        }
                    } catch (IOException e) {
                        if (this.kzZ != null) {
                            this.kzZ.kzP.h(this.kzY.mSessionId, false);
                        }
                    }
                } else if (this.kAg.isEmpty()) {
                    synchronized (this) {
                        try {
                            wait();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.exdevice.SendThread", e2, "", new Object[0]);
                            x.w("MicroMsg.exdevice.SendThread", "BluetoothChatThread_SendRunnable InterruptedException...");
                        }
                    }
                } else {
                    synchronized (this.kAg) {
                        Assert.assertTrue(this.kAh.addAll(this.kAg));
                        this.kAg.clear();
                    }
                }
            }
        }
    }

    public final boolean af(byte[] bArr) {
        x.i("MicroMsg.exdevice.SendThread", "------write------buffer length = %d", new Object[]{Integer.valueOf(bArr.length)});
        if (this.kAe == null) {
            x.e("MicroMsg.exdevice.SendThread", "Send thread has been close. Send data abort");
            return false;
        }
        synchronized (this) {
            this.kAg.add(bArr);
            notify();
        }
        return true;
    }

    public final void cancel() {
        this.kAe = null;
        this.kAd = true;
        synchronized (this) {
            notify();
        }
        this.kAh.clear();
        this.kAg.clear();
    }
}

package com.tencent.mm.plugin.g.a.c;

import android.bluetooth.BluetoothSocket;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;

public final class c {

    public static final class b implements Runnable {
        private InputStream kAc = null;
        private volatile boolean kAd = false;
        private final BluetoothSocket kzW;
        private b kzY;
        a kzZ;

        public b(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
            this.kzW = bluetoothSocket;
            this.kzY = bVar;
            this.kzZ = aVar;
            try {
                this.kAc = bluetoothSocket.getInputStream();
            } catch (IOException e) {
                this.kAc = null;
                x.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", e.toString());
            }
        }

        public final void run() {
            x.i("MicroMsg.exdevice.RecvThread", "BEGIN RecvThread");
            if (this.kAc == null) {
                x.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
                return;
            }
            Object obj = new byte[2048];
            while (!this.kAd) {
                try {
                    int read = this.kAc.read(obj);
                    if (read > 0) {
                        x.i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", Integer.valueOf(read));
                        x.d("MicroMsg.exdevice.RecvThread", "data dump = %s", com.tencent.mm.plugin.exdevice.j.b.K(obj, read));
                        Object obj2 = new byte[read];
                        System.arraycopy(obj, 0, obj2, 0, read);
                        if (this.kzZ != null) {
                            this.kzZ.kzP.b(this.kzY.mSessionId, obj2);
                        }
                    }
                } catch (IOException e) {
                    x.e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", e.toString());
                    try {
                        this.kzW.close();
                        return;
                    } catch (IOException e2) {
                        x.e("MicroMsg.exdevice.RecvThread", "Close socket failed!!! (%s)", e2.toString());
                        return;
                    }
                }
            }
            x.w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
        }

        public final void cancel() {
            x.i("MicroMsg.exdevice.RecvThread", "------cancel------");
            if (this.kAd) {
                x.w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
                return;
            }
            this.kAd = true;
            e.Q(this);
            try {
                this.kzW.close();
            } catch (IOException e) {
                x.e("MicroMsg.exdevice.RecvThread", "close() of connect socket failed", e);
            }
        }
    }
}

package com.tencent.mm.plugin.g.a.c;

import android.bluetooth.BluetoothSocket;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.g.a.c.c.a;
import com.tencent.mm.plugin.g.a.c.c.b;
import com.tencent.mm.plugin.g.a.c.c.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.lang.ref.WeakReference;

class c$a$a extends af {
    private WeakReference<a> kxt = null;

    public c$a$a(Looper looper, a aVar) {
        super(looper);
        this.kxt = new WeakReference(aVar);
    }

    public final void handleMessage(Message message) {
        a aVar = (a) this.kxt.get();
        if (aVar == null) {
            x.e("MicroMsg.exdevice.BluetoothChatThreads", "null == connectTread");
            return;
        }
        switch (message.what) {
            case 0:
                x.i("MicroMsg.exdevice.ConnectThread", "------connectImp------");
                if (aVar.kAa) {
                    x.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready connect, just leave");
                    return;
                }
                try {
                    if (aVar.kzX) {
                        aVar.kzW = aVar.kAb.createRfcommSocketToServiceRecord(a.kzN);
                    } else {
                        aVar.kzW = aVar.kAb.createInsecureRfcommSocketToServiceRecord(a.kzO);
                    }
                    try {
                        aVar.kzW.connect();
                        aVar.kAa = true;
                        b bVar = aVar.kzY;
                        a aVar2 = aVar.kzZ;
                        BluetoothSocket bluetoothSocket = aVar.kzW;
                        x.i("MicroMsg.exdevice.BluetoothChatSession", "connected");
                        bVar.mState = 3;
                        if (bVar.kzU != null) {
                            bVar.kzU.cancel();
                            bVar.kzU = null;
                        }
                        if (bVar.kzV != null) {
                            bVar.kzV.cancel();
                            bVar.kzV = null;
                        }
                        bVar.kzU = new b(bVar, aVar2, bluetoothSocket);
                        e.b(bVar.kzU, "BluetoothChatSession_recv").start();
                        bVar.kzV = new c(bVar, aVar2, bluetoothSocket);
                        e.b(bVar.kzV, "BluetoothChatSession_send").start();
                        if (aVar.kzZ != null) {
                            aVar.kzZ.kzP.g(aVar.kzY.mSessionId, true);
                            return;
                        }
                        return;
                    } catch (IOException e) {
                        x.e("MicroMsg.exdevice.ConnectThread", "socket connect failed (%s)", new Object[]{e.toString()});
                        try {
                            aVar.kzW.close();
                        } catch (IOException e2) {
                            x.e("MicroMsg.exdevice.ConnectThread", "Close socket failed!!! (%s)", new Object[]{e2.toString()});
                        }
                        if (aVar.kzZ != null) {
                            aVar.kzZ.kzP.g(aVar.kzY.mSessionId, false);
                            return;
                        }
                        return;
                    }
                } catch (IOException e22) {
                    aVar.kzW = null;
                    x.e("MicroMsg.exdevice.ConnectThread", "createRfcommSocket Failed!!! (%s)", new Object[]{e22.toString()});
                    if (aVar.kzZ != null) {
                        aVar.kzZ.kzP.g(aVar.kzY.mSessionId, false);
                        return;
                    }
                    return;
                }
            case 1:
                if (aVar.kAa) {
                    try {
                        aVar.kzW.close();
                        return;
                    } catch (IOException e3) {
                        x.e("MicroMsg.exdevice.ConnectThread", "socket close failed (%s)", new Object[]{e3.toString()});
                        return;
                    }
                }
                x.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready disconnect, just leave");
                return;
            default:
                return;
        }
    }
}

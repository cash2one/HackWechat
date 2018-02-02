package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class f$b extends af {
    private final WeakReference<f> kxt;

    public f$b(Looper looper, f fVar) {
        super(looper);
        this.kxt = new WeakReference(fVar);
    }

    public final void handleMessage(Message message) {
        f fVar = (f) this.kxt.get();
        if (fVar == null) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
            return;
        }
        switch (message.what) {
            case 0:
                f.a(fVar);
                return;
            case 1:
                f.b(fVar);
                return;
            case 2:
                f.c(fVar);
                return;
            case 3:
                f.a(fVar, (byte[]) message.obj);
                return;
            case 4:
                f.a(fVar, message.arg1);
                return;
            case 5:
                if (!f.a(fVar, (BluetoothGatt) message.obj, message.arg1)) {
                    x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", new Object[]{b.cK(fVar.mSessionId), fVar.kxd.getName()});
                    if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(1))) {
                        x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(1)});
                        return;
                    }
                    return;
                }
                return;
            case 6:
                Object obj = message.obj;
                f.b(fVar, message.arg1);
                return;
            case 7:
                f.c(fVar, message.arg1);
                return;
            case 8:
                f.a(fVar, (BluetoothGattCharacteristic) message.obj);
                return;
            case 9:
                f.d(fVar);
                return;
            default:
                return;
        }
    }
}

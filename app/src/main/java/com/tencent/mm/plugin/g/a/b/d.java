package com.tencent.mm.plugin.g.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.g.a.e.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

@TargetApi(18)
public final class d {
    private int aen;
    private BluetoothAdapter kwe;
    BluetoothDevice kxd;
    Context kxe;
    BluetoothGatt kxf;
    b kxg;
    BluetoothGattCharacteristic kxh;
    BluetoothGattCharacteristic kxi;
    a kxj;
    Runnable kxk;
    Runnable kxl;
    Runnable kxm;
    d kxn;
    final LinkedList<byte[]> kxo;
    volatile boolean kxp;
    int kxq;
    final BluetoothGattCallback kxr;
    public af mHandler;
    long mSessionId;
    private HandlerThread mThread;

    @TargetApi(18)
    public d(long j, Context context, b bVar) {
        this.kxo = new LinkedList();
        this.kxp = false;
        this.kxr = new 1(this);
        this.aen = -1;
        this.aen = hashCode();
        this.kxn = this;
        this.kxg = bVar;
        this.kxe = context;
        this.kwe = ((BluetoothManager) this.kxe.getSystemService("bluetooth")).getAdapter();
        this.mSessionId = j;
        this.kxq = 3;
        this.kxd = this.kwe.getRemoteDevice(a.bM(j));
        this.kxh = null;
        this.kxi = null;
        this.kxj = new a();
        this.mThread = e.Wf("BluetoothLESession_handlerThread");
        this.mThread.start();
        this.mHandler = new a(this.mThread.getLooper(), this);
        this.kxk = new 2(this);
        this.kxl = new 3(this);
        this.kxm = new 4(this);
    }

    public final boolean connect() {
        x.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    public final void close() {
        x.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
            x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(2)});
        }
        this.mThread.quitSafely();
    }

    final void arn() {
        this.kxp = false;
        this.kxo.clear();
    }

    final void aro() {
        if (this.kxo.isEmpty()) {
            this.kxp = false;
            return;
        }
        this.kxj.setData((byte[]) this.kxo.pop());
        x.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[]{b.ap(this.kxj.ari())});
        this.kxi.setValue(r0);
        this.mHandler.postDelayed(this.kxk, 5000);
        if (!this.kxf.writeCharacteristic(this.kxi)) {
            x.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
        }
        this.kxp = true;
    }
}

package com.tencent.mm.plugin.g.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import junit.framework.Assert;

@TargetApi(18)
public final class c implements LeScanCallback {
    private static c kwY;
    private ArrayList<a> kwZ;
    private BluetoothAdapter kwe;
    private boolean kxa;
    private Context mContext;
    private af mHandler;

    static /* synthetic */ boolean a(c cVar, boolean z, a aVar) {
        boolean z2;
        if (cVar.mContext == null) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "not found context");
            z2 = false;
        } else {
            z2 = cVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (!z2) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "this phone is not support BLE");
            return false;
        } else if (cVar.kwe == null) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "not found BluetoothAdapter");
            return false;
        } else {
            if (z) {
                if (cVar.kxa) {
                    x.w("MicroMsg.exdevice.BluetoothLEScaner", "ble has scan. just add callback and return");
                    cVar.a(aVar);
                    return true;
                }
                x.d("MicroMsg.exdevice.BluetoothLEScaner", "start scan");
                z2 = cVar.kwe.startLeScan(cVar);
                if (z2) {
                    cVar.kxa = true;
                    cVar.a(aVar);
                } else if (cVar.kwZ.size() <= 0) {
                    x.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed and callbacklist size is 0,start retry,and bluetooth state is(12 is on ,10 is off): " + cVar.kwe.getState());
                    int i = 0;
                    while (!z2 && i < 3) {
                        cVar.kwe.stopLeScan(cVar);
                        cVar.kxa = false;
                        x.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed,retry no " + i + " time");
                        boolean startLeScan = cVar.kwe.startLeScan(cVar);
                        if (startLeScan) {
                            cVar.kxa = true;
                            cVar.a(aVar);
                        }
                        i++;
                        z2 = startLeScan;
                    }
                    return z2;
                } else if (cVar.kwe.getState() == 12) {
                    x.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed when bluetooth state is on.");
                    cVar.kxa = true;
                    cVar.a(aVar);
                    z2 = true;
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed");
                }
            } else if (cVar.kxa) {
                if (aVar == null) {
                    x.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
                } else {
                    x.d("MicroMsg.exdevice.BluetoothLEScaner", "remove callback " + cVar.kwZ.remove(aVar));
                }
                if (aVar != null) {
                    aVar.arl();
                }
                x.d("MicroMsg.exdevice.BluetoothLEScaner", "stop deleteCallback");
                if (cVar.kwZ.size() <= 0) {
                    x.d("MicroMsg.exdevice.BluetoothLEScaner", "stop scan");
                    cVar.kwe.stopLeScan(cVar);
                    cVar.kxa = false;
                }
                z2 = true;
            } else {
                x.w("MicroMsg.exdevice.BluetoothLEScaner", "scan haven't started. just return, callback size = %d", new Object[]{Integer.valueOf(cVar.kwZ.size())});
                return true;
            }
            return z2;
        }
    }

    public static c arm() {
        if (kwY != null) {
            return kwY;
        }
        c cVar = new c(ac.getContext());
        kwY = cVar;
        return cVar;
    }

    private c(Context context) {
        if (context == null) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
            return;
        }
        this.mContext = context;
        this.kwZ = new ArrayList();
        this.kxa = false;
        this.kwe = null;
        this.mHandler = null;
        this.kwe = ((BluetoothManager) this.mContext.getSystemService("bluetooth")).getAdapter();
        this.mHandler = new af(new ag("BluetoothLEScanerThread").oAt.getLooper());
    }

    public final boolean a(boolean z, a aVar) {
        Boolean bool = (Boolean) new 1(this, z, aVar).b(this.mHandler);
        Assert.assertTrue(bool != null);
        return bool.booleanValue();
    }

    private boolean a(a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
            return false;
        }
        int i = 0;
        while (i < this.kwZ.size()) {
            if (((a) this.kwZ.get(i)) == aVar) {
                break;
            }
            i++;
        }
        i = -1;
        if (i < 0) {
            boolean add = this.kwZ.add(aVar);
            x.d("MicroMsg.exdevice.BluetoothLEScaner", "add callback " + add);
            return add;
        }
        x.w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
        return true;
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
        x.d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[]{bluetoothDevice.getAddress(), bluetoothDevice.getName(), b.ap(bArr)});
        x.d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", new Object[]{Integer.valueOf(this.kwZ.size())});
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ c kxc;

            public final void run() {
                for (int i = 0; i < this.kxc.kwZ.size(); i++) {
                    ((a) this.kxc.kwZ.get(i)).c(bluetoothDevice, i, bArr);
                }
            }
        });
    }
}

package com.tencent.mm.plugin.g.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.g.a.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

@TargetApi(21)
public final class g extends ScanCallback {
    private static g kxO;
    private ArrayList<a> kwZ;
    private BluetoothAdapter kwe;
    private BluetoothManager kxP;
    private BluetoothLeScanner kxQ;
    private boolean kxa;
    private Context mContext;
    af mHandler;

    static /* synthetic */ boolean a(g gVar, boolean z, a aVar) {
        boolean z2;
        if (gVar.mContext == null) {
            x.e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found context");
            z2 = false;
        } else {
            z2 = gVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (z2) {
            if (gVar.kxQ == null) {
                gVar.kwe = gVar.kxP.getAdapter();
                if (gVar.kwe != null) {
                    x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
                    gVar.kxQ = gVar.kwe.getBluetoothLeScanner();
                    if (gVar.kxQ == null) {
                        return false;
                    }
                }
                x.e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found BluetoothScannner");
                return false;
            }
            if (!a.arv()) {
                x.i("MicroMsg.exdevice.NewBluetoothLEScanner", "Bluetooth state off");
            } else if (z) {
                x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "start scan");
                if (gVar.kxa) {
                    x.w("MicroMsg.exdevice.NewBluetoothLEScanner", "ble has scan. just add callback and return");
                    gVar.a(aVar);
                } else {
                    gVar.kxQ.startScan(gVar);
                    gVar.a(aVar);
                    gVar.kxa = true;
                }
            } else if (gVar.kxa) {
                if (aVar == null) {
                    x.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
                } else {
                    x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "remove callback " + gVar.kwZ.remove(aVar));
                }
                if (gVar.kwZ.size() <= 0) {
                    x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "stop scan");
                    gVar.kxQ.stopScan(gVar);
                    gVar.kxa = false;
                }
            } else {
                x.w("MicroMsg.exdevice.NewBluetoothLEScanner", "scan haven't started. just return, callback size = %d", new Object[]{Integer.valueOf(gVar.kwZ.size())});
            }
            return true;
        }
        x.e("MicroMsg.exdevice.NewBluetoothLEScanner", "this phone is not support BLE");
        return false;
    }

    public static g arr() {
        if (kxO != null) {
            return kxO;
        }
        g gVar = new g(ac.getContext());
        kxO = gVar;
        return gVar;
    }

    private g(Context context) {
        if (context == null) {
            x.e("MicroMsg.exdevice.NewBluetoothLEScanner", "No context for scanner");
            return;
        }
        this.mContext = context;
        this.kwZ = new ArrayList();
        this.kxa = false;
        this.kwe = null;
        this.kxQ = null;
        this.mHandler = null;
        this.kxP = (BluetoothManager) this.mContext.getSystemService("bluetooth");
        this.kwe = this.kxP.getAdapter();
        if (this.kwe != null) {
            x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
            this.kxQ = this.kwe.getBluetoothLeScanner();
        }
        this.mHandler = new af(new ag("NewBluetoothLEScannerThread").oAt.getLooper());
    }

    private boolean a(a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
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
            x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "add callback " + add);
            return add;
        }
        x.w("MicroMsg.exdevice.NewBluetoothLEScanner", "callback has in queue. pass");
        return true;
    }

    public final void onScanFailed(int i) {
        this.mHandler.post(new 3(this, i));
    }

    public final void onScanResult(int i, ScanResult scanResult) {
        if (scanResult != null && scanResult.getScanRecord() != null) {
            x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[]{scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b.ap(scanResult.getScanRecord().getBytes())});
            x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "callback size = %d", new Object[]{Integer.valueOf(this.kwZ.size())});
            this.mHandler.post(new 2(this, scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes()));
        }
    }

    public final void onBatchScanResults(List<ScanResult> list) {
        if (list != null) {
            for (ScanResult scanResult : list) {
                x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[]{scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b.ap(scanResult.getScanRecord().getBytes())});
            }
        }
    }
}

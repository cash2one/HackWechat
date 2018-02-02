package com.tencent.mm.plugin.g.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.r;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f implements LeScanCallback, r, b {
    private static boolean kwb = false;
    public static boolean kwd = false;
    private final b kvW;
    private final d kvZ;
    private final HashSet<UUID> kwa;
    private boolean kwc = false;
    private BluetoothAdapter kwe;
    private boolean kwf = true;
    private int kwg = 0;
    private String kwh = "";
    private e kwi = null;
    private Map<String, Long> kwj = new ConcurrentHashMap();
    private final ak kwk = new ak(v.aEN().hOa.oAt.getLooper(), new 1(this), true);
    private final ak kwl = new ak(v.aEN().hOa.oAt.getLooper(), new 2(this), true);
    private final ak kwm = new ak(v.aEN().hOa.oAt.getLooper(), new 3(this), true);
    private final ak kwn = new ak(v.aEN().hOa.oAt.getLooper(), new a(this) {
        final /* synthetic */ f kwp;

        {
            this.kwp = r1;
        }

        public final boolean uF() {
            x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
            f.kwb = false;
            return false;
        }
    }, true);
    private final ak kwo = new ak(v.aEN().hOa.oAt.getLooper(), new 5(this), true);
    public final af mHandler;

    static /* synthetic */ boolean a(f fVar, UUID uuid) {
        x.i("MicroMsg.exdevice.IBeaconServer", "startRanging");
        if (uuid == null) {
            x.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
            return false;
        }
        if (!fVar.kwa.contains(uuid)) {
            fVar.kwa.add(uuid);
        }
        fVar.arg();
        return true;
    }

    static /* synthetic */ boolean b(f fVar, UUID uuid) {
        x.i("MicroMsg.exdevice.IBeaconServer", "stopRanging");
        if (uuid == null) {
            x.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
            return false;
        }
        fVar.kwa.remove(uuid);
        fVar.arf();
        return true;
    }

    static /* synthetic */ Boolean g(f fVar) {
        return fVar.kwe != null ? Boolean.valueOf(fVar.kwe.startLeScan(fVar)) : Boolean.valueOf(false);
    }

    static /* synthetic */ void j(f fVar) {
        if (fVar.kwe != null) {
            fVar.kwe.stopLeScan(fVar);
        }
    }

    public f(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("aCallback is null");
        }
        this.kwa = new HashSet();
        this.kvZ = new d(this);
        this.kvW = bVar;
        this.mHandler = new af(v.aEN().hOa.oAt.getLooper());
        this.kwe = ((BluetoothManager) ac.getContext().getSystemService("bluetooth")).getAdapter();
    }

    private void arf() {
        this.kwj.clear();
        kwb = false;
        if (!this.kwn.cfK()) {
            this.kwn.TG();
        }
        if (!this.kwm.cfK()) {
            this.kwm.TG();
        }
        if (!this.kwl.cfK()) {
            this.kwl.TG();
        }
        if (!this.kwk.cfK()) {
            this.kwk.TG();
        }
        if (!this.kwo.cfK()) {
            this.kwo.TG();
        }
        if (this.kwc && this.kwe != null) {
            this.kwe.stopLeScan(this);
            this.kwc = false;
        }
    }

    private synchronized void arg() {
        if (this.kwn.cfK()) {
            this.kwn.J(2000, 2000);
        }
        if (kwd && this.kwm.cfK()) {
            this.kwm.J(10000, 10000);
        }
        if (this.kwo.cfK()) {
            if (kwd) {
                this.kwo.J(1800000, 1800000);
            } else {
                this.kwo.J(120000, 120000);
            }
        }
        if (!kwb) {
            this.kwf = true;
            Boolean valueOf = Boolean.valueOf(this.kwe.startLeScan(this));
            if (valueOf.booleanValue() || kwb) {
                this.kwc = true;
                kwb = true;
                x.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
            } else {
                int i = 0;
                while (!valueOf.booleanValue() && i < 3 && !kwb) {
                    i++;
                    this.kwe.stopLeScan(this);
                    x.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + i + " time");
                    valueOf = Boolean.valueOf(this.kwe.startLeScan(this));
                    if (valueOf.booleanValue()) {
                        kwb = true;
                        this.kwc = true;
                        x.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
                    }
                }
            }
        }
    }

    public final void a(double d, c cVar) {
        x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[]{Double.valueOf(d)});
        String ap = b.ap(cVar.kvU.kvY.kwz);
        if (ap.length() >= 32) {
            ap = ap.substring(0, 8) + "-" + ap.substring(8, 12) + "-" + ap.substring(12, 16) + "-" + ap.substring(16, 20) + "-" + ap.substring(20);
        }
        String str = ap + cVar.kvU.kvY.kwA + cVar.kvU.kvY.kwB;
        if (this.kwj.containsKey(str)) {
            long longValue = ((Long) this.kwj.get(str)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 500) {
                this.kwj.put(str, Long.valueOf(currentTimeMillis));
                this.kvW.a(d, cVar);
                return;
            }
            return;
        }
        this.kwj.put(str, Long.valueOf(System.currentTimeMillis()));
        this.kvW.a(d, cVar);
        x.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + ap + ",major = " + cVar.kvU.kvY.kwA + ",minor = " + (cVar.kvU.kvY.kwB & 65535));
    }

    public final void nd(int i) {
        if (i == 0) {
            arf();
        }
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        x.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), b.ap(bArr)});
        if (i == 0) {
            e eVar = new e();
            if (eVar.ab(bArr)) {
                UUID ar = b.ar(eVar.kvY.kwz);
                if (ar == null) {
                    x.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                    return;
                } else if (this.kwa.contains(ar)) {
                    if (this.kwf) {
                        this.kwh = str;
                    }
                    this.mHandler.post(new 8(this, i2, str, eVar));
                    return;
                } else {
                    x.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                    return;
                }
            }
            x.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
        }
    }

    public final void vM(String str) {
        x.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", new Object[]{Integer.valueOf(-1), str});
    }

    public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        e eVar = new e();
        if (eVar.ab(bArr)) {
            UUID ar = b.ar(eVar.kvY.kwz);
            if (ar == null) {
                x.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                return;
            } else if (this.kwa.contains(ar)) {
                if (this.kwf) {
                    this.kwg = i;
                    this.kwi = eVar;
                    if (this.kwk.cfK()) {
                        this.kwk.J(2000, 2000);
                    }
                    this.kwf = false;
                }
                this.mHandler.post(new 9(this, i, bluetoothDevice, eVar));
                return;
            } else {
                x.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                return;
            }
        }
        x.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
    }
}

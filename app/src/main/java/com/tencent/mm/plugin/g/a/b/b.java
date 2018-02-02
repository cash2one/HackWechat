package com.tencent.mm.plugin.g.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.hardware.input.InputManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.view.InputDevice;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.g.a.b.c.a;
import com.tencent.mm.plugin.g.a.b.g.1;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

@TargetApi(18)
public final class b {
    public a kwK;
    public final HashMap<String, d> kwL;
    volatile boolean kwM;
    public c kwN;
    public g kwO;
    final HashSet<Long> kwP;
    private a kwQ;
    private g.a kwR;
    public BluetoothAdapter kwe;
    public af mHandler;
    public volatile boolean mIsInit;
    private Runnable mRunnable;
    public Context tI;

    static /* synthetic */ void a(b bVar, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        x.d("MicroMsg.exdevice.BluetoothLEManager", "onLeScanImp");
        if (!bVar.kwP.isEmpty()) {
            long zu = com.tencent.mm.plugin.exdevice.j.b.zu(bluetoothDevice.getAddress());
            if (bVar.kwP.contains(Long.valueOf(zu))) {
                x.i("MicroMsg.exdevice.BluetoothLEManager", "------onConnectPreScanFound------ sessionid = %d", new Object[]{Long.valueOf(zu)});
                d dVar = (d) bVar.kwL.get(String.valueOf(zu));
                if (dVar == null) {
                    x.e("MicroMsg.exdevice.BluetoothLEManager", "null == les");
                    if (bVar.kwK != null) {
                        bVar.kwK.g(zu, false);
                    }
                } else if (!dVar.connect()) {
                    x.e("MicroMsg.exdevice.BluetoothLEManager", "les.connect() Failed!!!");
                    if (bVar.kwK != null) {
                        bVar.kwK.g(zu, false);
                    }
                }
                bVar.kwP.remove(Long.valueOf(zu));
                if (bVar.kwP.isEmpty()) {
                    x.i("MicroMsg.exdevice.BluetoothLEManager", "Connect PreScan is done.");
                }
            }
        }
        if (bVar.kwK != null) {
            bVar.kwK.a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bArr);
        }
    }

    public b(ag agVar) {
        this.kwK = null;
        this.tI = null;
        this.kwL = new HashMap();
        this.kwe = null;
        this.mHandler = null;
        this.mRunnable = null;
        this.kwM = false;
        this.mIsInit = false;
        this.kwP = new HashSet();
        this.kwQ = new a(this) {
            final /* synthetic */ b kwS;

            {
                this.kwS = r1;
            }

            public final void c(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                x.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.zu(bluetoothDevice.getAddress()))});
                this.kwS.mHandler.post(new 1(this, bluetoothDevice, i, bArr));
            }

            public final void arl() {
            }
        };
        this.kwR = new 3(this);
        this.mRunnable = new 1(this);
        this.mHandler = new af(agVar.oAt.getLooper());
    }

    final void arj() {
        x.i("MicroMsg.exdevice.BluetoothLEManager", "tryToCleanPreScanSet");
        if (!this.kwP.isEmpty()) {
            Iterator it = this.kwP.iterator();
            while (it.hasNext()) {
                x.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[]{(Long) it.next()});
                if (this.kwK != null) {
                    this.kwK.g(r0.longValue(), false);
                }
            }
            this.kwP.clear();
        }
    }

    @TargetApi(18)
    public final boolean ark() {
        Assert.assertTrue(this.mIsInit);
        return this.tI.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    private void arf() {
        if (this.kwM) {
            this.mHandler.removeCallbacks(this.mRunnable);
            this.kwM = false;
            dR(false);
            arj();
            if (this.kwK != null) {
                this.kwK.arl();
            }
        }
    }

    public final boolean a(boolean z, int... iArr) {
        x.i("MicroMsg.exdevice.BluetoothLEManager", "------scanLEDevice------" + (z ? "true" : "false"));
        Assert.assertTrue(this.mIsInit);
        if (!ark()) {
            x.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
            return false;
        } else if (!z) {
            arf();
            return true;
        } else if (this.kwM) {
            return true;
        } else {
            if (dR(z)) {
                if (iArr == null || iArr.length <= 0 || iArr[0] != 1) {
                    this.mHandler.postDelayed(this.mRunnable, 10000);
                } else {
                    this.mHandler.removeCallbacks(this.mRunnable);
                }
                this.kwM = true;
                return true;
            }
            x.e("MicroMsg.exdevice.BluetoothLEManager", "mAdapter.startLeScan Failed!!!");
            if (!this.kwP.isEmpty()) {
                Iterator it = this.kwP.iterator();
                while (it.hasNext()) {
                    x.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[]{(Long) it.next()});
                    if (this.kwK != null) {
                        this.kwK.g(r0.longValue(), false);
                    }
                }
                this.kwP.clear();
            }
            return false;
        }
    }

    final boolean dR(boolean z) {
        boolean z2 = false;
        if (f.fM(21) && this.kwO != null) {
            g gVar = this.kwO;
            g.a aVar = this.kwR;
            x.i("MicroMsg.exdevice.NewBluetoothLEScanner", "(API21)execute scan");
            Boolean bool = (Boolean) new 1(gVar, z, aVar).b(gVar.mHandler);
            if (bool != null) {
                z2 = true;
            }
            Assert.assertTrue(z2);
            return bool.booleanValue();
        } else if (this.kwN != null) {
            return this.kwN.a(z, this.kwQ);
        } else {
            x.e("MicroMsg.exdevice.BluetoothLEManager", "Scanner is null");
            return false;
        }
    }

    public final boolean connect(long j) {
        x.i("MicroMsg.exdevice.BluetoothLEManager", "------connect------ sessionId = %d ", new Object[]{Long.valueOf(j)});
        Assert.assertTrue(this.mIsInit);
        if (ark()) {
            d dVar = (d) this.kwL.get(String.valueOf(j));
            Assert.assertTrue(dVar != null);
            BluetoothManager bluetoothManager = (BluetoothManager) this.tI.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.exdevice.BluetoothLEManager", "null == bluetoothManager");
            } else {
                List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(8);
                if (connectedDevices == null) {
                    x.i("MicroMsg.exdevice.BluetoothLEManager", "null == list, may be no device is connected phone now");
                } else {
                    for (BluetoothDevice address : connectedDevices) {
                        x.i("MicroMsg.exdevice.BluetoothLEManager", "get connected device: mac = %s, long of mac =%d, name = %s", new Object[]{address.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.zu(((BluetoothDevice) r3.next()).getAddress())), ((BluetoothDevice) r3.next()).getName()});
                        if (j == com.tencent.mm.plugin.exdevice.j.b.zu(((BluetoothDevice) r3.next()).getAddress())) {
                            x.i("MicroMsg.exdevice.BluetoothLEManager", "This device is connected to phone now, start connecting without scan...");
                            return dVar.connect();
                        }
                    }
                    x.i("MicroMsg.exdevice.BluetoothLEManager", "Android version realse code: %s", new Object[]{VERSION.RELEASE});
                    if (f.fM(23) && !((LocationManager) this.tI.getSystemService("location")).isProviderEnabled("gps") && !VERSION.RELEASE.equalsIgnoreCase("6.0") && !VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
                        return dVar.connect();
                    }
                    Set<BluetoothDevice> bondedDevices = bluetoothManager.getAdapter().getBondedDevices();
                    if (bondedDevices == null) {
                        x.i("MicroMsg.exdevice.BluetoothLEManager", "null == pairedDevices,get paired devices failed");
                    } else {
                        for (BluetoothDevice bluetoothDevice : bondedDevices) {
                            x.i("MicroMsg.exdevice.BluetoothLEManager", "get paired device: mac = %s, long of mac =%d, name = %s", new Object[]{bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.zu(bluetoothDevice.getAddress())), bluetoothDevice.getName()});
                            if (j == com.tencent.mm.plugin.exdevice.j.b.zu(bluetoothDevice.getAddress())) {
                                x.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device is paired to phone now, check if it is connected...");
                                InputManager inputManager = (InputManager) this.tI.getSystemService("input");
                                int[] inputDeviceIds = inputManager.getInputDeviceIds();
                                if (inputDeviceIds == null) {
                                    x.i("MicroMsg.exdevice.BluetoothLEManager", "get input devices failed");
                                    break;
                                }
                                for (int inputDevice : inputDeviceIds) {
                                    InputDevice inputDevice2 = inputManager.getInputDevice(inputDevice);
                                    if (inputDevice2 != null) {
                                        String name = inputDevice2.getName();
                                        x.d("MicroMsg.exdevice.BluetoothLEManager", "Input devices: %s", new Object[]{name});
                                        if (name != null && name.equals(bluetoothDevice.getName())) {
                                            x.i("MicroMsg.exdevice.BluetoothLEManager", "This HID deivce has connected to phone as a input device");
                                            return dVar.connect();
                                        }
                                    }
                                }
                                x.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device hasn't been connected...");
                            }
                        }
                    }
                }
            }
            this.kwP.add(Long.valueOf(j));
            return a(true, new int[0]);
        }
        x.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
        return false;
    }
}

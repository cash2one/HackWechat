package com.tencent.mm.plugin.g.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.g.a.b.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class f {
    static int kxM = 0;
    private int aen;
    private BluetoothAdapter kwe;
    private a kxF;
    private Runnable kxG;
    private f kxH;
    private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> kxI;
    private long kxJ;
    private ArrayList<BluetoothGattCharacteristic> kxK;
    private boolean kxL;
    public BluetoothDevice kxd;
    private Context kxe;
    private BluetoothGatt kxf;
    private a kxj;
    private Runnable kxk;
    private Runnable kxm;
    private final LinkedList<byte[]> kxo;
    private volatile boolean kxp;
    private volatile int kxq;
    private final BluetoothGattCallback kxr;
    public af mHandler;
    public long mSessionId;
    private HandlerThread mThread;

    public static abstract class a {
        public void a(long j, boolean z, long j2) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void h(long j, boolean z) {
        }
    }

    static /* synthetic */ void a(f fVar) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connectImp------, mac=%s, name=%s", new Object[]{b.cK(fVar.mSessionId), fVar.kxd.getName()});
        if (1 == fVar.kxq) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connected !!!");
            if (fVar.kxF != null) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device has connected, just callback.");
                fVar.kxF.a(fVar.mSessionId, true, fVar.kxJ);
            }
        } else if (fVar.kxq == 0) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connecting !!!");
        } else {
            fVar.arn();
            if (fVar.kxf == null) {
                fVar.kxf = fVar.kxd.connectGatt(fVar.kxe, false, fVar.kxr);
                kxM++;
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------create resource------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[]{Integer.valueOf(fVar.hashCode()), Integer.valueOf(kxM), b.cK(fVar.mSessionId), fVar.kxd.getName()});
                if (fVar.kxf == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mDevice.connectGatt Failed!!!");
                    fVar.arq();
                    return;
                }
                fVar.kxq = 0;
                fVar.mHandler.postDelayed(fVar.kxm, 10000);
            } else if (fVar.kxf.connect()) {
                fVar.kxq = 0;
                fVar.mHandler.postDelayed(fVar.kxm, 10000);
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.connect() Failed!!!");
                fVar.arq();
            }
        }
    }

    static /* synthetic */ void a(f fVar, int i) {
        String str = "MicroMsg.exdevice.BluetoothLESimpleSession";
        String str2 = "------onConnectionStateChangeImp------ aState = %s, mac=%s, name=%s";
        Object[] objArr = new Object[3];
        objArr[0] = i == 2 ? "Connected" : "Disconnected";
        objArr[1] = b.cK(fVar.mSessionId);
        objArr[2] = fVar.kxd.getName();
        x.i(str, str2, objArr);
        if (i == 2) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "PHY Connected is OK, mConnectState = %d", new Object[]{Integer.valueOf(fVar.kxq)});
            if (3 == fVar.kxq) {
                x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Leave without discover Services");
                fVar.mHandler.removeCallbacks(fVar.kxm);
            } else if (1 == fVar.kxq) {
                x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Leave without discover Services");
                fVar.mHandler.removeCallbacks(fVar.kxm);
            } else if (fVar.kxf.discoverServices()) {
                fVar.mHandler.removeCallbacks(fVar.kxm);
                fVar.mHandler.postDelayed(fVar.kxm, 10000);
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "start discoverServices...");
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "discover Services start failed!!!");
                fVar.arp();
            }
        } else if (i == 0) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Disconnected from GATT server.");
            fVar.kxI.clear();
            fVar.kxK.clear();
            fVar.kxJ = 0;
            fVar.arp();
        }
    }

    static /* synthetic */ void a(f fVar, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceiveImp------, mac=%s, name=%s", new Object[]{b.cK(fVar.mSessionId), fVar.kxd.getName()});
        if (bluetoothGattCharacteristic == null) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic is null");
            return;
        }
        byte[] value = bluetoothGattCharacteristic.getValue();
        String K = b.K(value, value.length);
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "data length = %d", new Object[]{Integer.valueOf(value.length)});
        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "data dump = %s", new Object[]{K});
        value = c.a(bluetoothGattCharacteristic, value);
        if (value == null) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse data error");
        } else if (fVar.kxF != null) {
            fVar.kxF.b(fVar.mSessionId, value);
        }
    }

    static /* synthetic */ void a(f fVar, byte[] bArr) {
        boolean z = true;
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeDataAsync------parserobj length = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(bArr.length), b.cK(fVar.mSessionId), fVar.kxd.getName()});
        if (1 != fVar.kxq) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Not ready for write data, connectstate = %d", new Object[]{Integer.valueOf(fVar.kxq)});
            if (fVar.kxF != null) {
                fVar.kxF.h(fVar.mSessionId, false);
                return;
            }
            return;
        }
        com.tencent.mm.plugin.g.a.b.a.a ad = com.tencent.mm.plugin.g.a.b.a.a.ad(bArr);
        if (ad == null) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "write data error, no match ProfileParser, connect state = %d", new Object[]{Integer.valueOf(fVar.kxq)});
            if (fVar.kxF != null) {
                fVar.kxF.h(fVar.mSessionId, false);
                return;
            }
            return;
        }
        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "rawData data dump = %s", new Object[]{b.ap(ad.ars())});
        String str = ad.kyq;
        int i = ad.kyr;
        HashMap hashMap = (HashMap) fVar.kxI.get(c.bK(ad.kxJ));
        if (hashMap == null) {
            String str2;
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found", new Object[]{str2});
            if (fVar.kxF != null) {
                fVar.kxF.h(fVar.mSessionId, false);
                return;
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) hashMap.get(str);
        String str3;
        if (bluetoothGattCharacteristic == null) {
            str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            str2 = "characteristic(%s) not found";
            Object[] objArr = new Object[1];
            objArr[0] = str == null ? "null" : str;
            x.e(str3, str2, objArr);
            if (fVar.kxF != null) {
                fVar.kxF.h(fVar.mSessionId, false);
            }
        } else if ((bluetoothGattCharacteristic.getProperties() | i) == 0) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "property not support. current = %d, provided = %d", new Object[]{Integer.valueOf(bluetoothGattCharacteristic.getProperties()), Integer.valueOf(i)});
            if (fVar.kxF != null) {
                fVar.kxF.h(fVar.mSessionId, false);
            }
        } else if (i == 2) {
            boolean z2;
            if (bluetoothGattCharacteristic == null) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic not found");
                z2 = false;
            } else if (fVar.kxf.readCharacteristic(bluetoothGattCharacteristic)) {
                z2 = true;
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.readCharacteristic Failed!!!");
                z2 = false;
            }
            str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            str2 = "readCharacteristic state: %s";
            Object[] objArr2 = new Object[1];
            objArr2[0] = z2 ? "true" : "false";
            x.d(str3, str2, objArr2);
            if (fVar.kxF == null) {
                return;
            }
            if (z2) {
                fVar.kxF.h(fVar.mSessionId, true);
            } else {
                fVar.kxF.h(fVar.mSessionId, false);
            }
        } else {
            Assert.assertTrue(fVar.kxf != null);
            fVar.kxo.add(bArr);
            if (!fVar.kxp) {
                if (1 != fVar.kxo.size()) {
                    z = false;
                }
                Assert.assertTrue(z);
                fVar.aro();
            }
        }
    }

    static /* synthetic */ boolean a(f fVar, BluetoothGatt bluetoothGatt, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "onServicesDiscoveredImp, status = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), b.cK(fVar.mSessionId), fVar.kxd.getName()});
        fVar.mHandler.removeCallbacks(fVar.kxm);
        if (3 == fVar.kxq) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Just Leave");
            return false;
        }
        if (1 == fVar.kxq) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Just Leave");
        } else if (i != 0) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Discover services error");
            fVar.arp();
            return false;
        } else {
            List services = bluetoothGatt.getServices();
            for (int i2 = 0; i2 < services.size(); i2++) {
                Object obj;
                BluetoothGattService bluetoothGattService = (BluetoothGattService) services.get(i2);
                if (bluetoothGattService == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service is null");
                    obj = null;
                } else if (c.b(bluetoothGattService)) {
                    fVar.kxJ |= c.a(bluetoothGattService);
                    HashMap hashMap = new HashMap();
                    List characteristics = bluetoothGattService.getCharacteristics();
                    for (int i3 = 0; i3 < characteristics.size(); i3++) {
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) characteristics.get(i3);
                        Object uuid = bluetoothGattCharacteristic.getUuid().toString();
                        int properties = bluetoothGattCharacteristic.getProperties();
                        int permissions = bluetoothGattCharacteristic.getPermissions();
                        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "found characteristic = %s, properties = %d, permission = %d", new Object[]{uuid, Integer.valueOf(properties), Integer.valueOf(permissions)});
                        if (uuid == null) {
                            uuid = "null";
                        }
                        hashMap.put(uuid, bluetoothGattCharacteristic);
                        fVar.kxK.add(bluetoothGattCharacteristic);
                    }
                    fVar.kxI.put(bluetoothGattService.getUuid().toString(), hashMap);
                    obj = 1;
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse service error");
                    obj = null;
                }
                if (obj == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parseService error. service uuid = %s", new Object[]{bluetoothGattService.getUuid().toString()});
                }
            }
            if (0 == fVar.kxJ) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "the device hasn't pass test");
                fVar.arp();
                return false;
            } else if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(9)});
            }
        }
        return true;
    }

    static /* synthetic */ void b(f fVar) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnectImp------, mac=%s, name=%s", new Object[]{b.cK(fVar.mSessionId), fVar.kxd.getName()});
        if (3 == fVar.kxq) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "diconnect or close is called aready, just leave");
        } else if (2 == fVar.kxq) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "already disconnected, just leave");
        } else {
            fVar.arn();
            if (fVar.kxf == null) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect:BluetoothGatt not found");
                return;
            }
            fVar.kxq = 3;
            fVar.mHandler.removeCallbacks(fVar.kxm);
            if (fVar.kxf != null) {
                fVar.kxf.disconnect();
            }
        }
    }

    static /* synthetic */ void b(f fVar, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWriteImp------ status = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), b.cK(fVar.mSessionId), fVar.kxd.getName()});
        if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(9)});
        }
    }

    static /* synthetic */ void c(f fVar) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------closeImp------, mac=%s, name=%s", new Object[]{b.cK(fVar.mSessionId), fVar.kxd.getName()});
        if (3 == fVar.kxq) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close aready, Just leave");
            fVar.arq();
            return;
        }
        fVar.arn();
        if (fVar.kxf == null) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "close:BluetoothGatt not found");
            fVar.arq();
            return;
        }
        fVar.kxq = 3;
        fVar.mHandler.removeCallbacks(fVar.kxm);
        fVar.arq();
        if (fVar.kxf != null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect gatt, and wait gatt disconnected callback, mac=%s, name=%s", new Object[]{b.cK(fVar.mSessionId), fVar.kxd.getName()});
            fVar.kxf.disconnect();
            fVar.kxL = true;
            fVar.mHandler.postDelayed(fVar.kxG, 10000);
        }
    }

    static /* synthetic */ void c(f fVar, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallbackImp------ status = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), b.cK(fVar.mSessionId), fVar.kxd.getName()});
        fVar.mHandler.removeCallbacks(fVar.kxk);
        if (i != 0) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "write data error: " + i);
            if (fVar.kxF != null) {
                fVar.kxF.h(fVar.mSessionId, false);
            }
            fVar.aro();
            return;
        }
        byte[] ari = fVar.kxj.ari();
        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "Out data dump = %s", new Object[]{b.ap(ari)});
        if (ari == null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write data complete");
            if (fVar.kxF != null) {
                fVar.kxF.h(fVar.mSessionId, true);
            }
            fVar.aro();
            return;
        }
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write next chunk...");
        fVar.kxj.kwJ.setValue(ari);
        fVar.kxf.writeCharacteristic(fVar.kxj.kwJ);
        fVar.mHandler.postDelayed(fVar.kxk, 5000);
    }

    static /* synthetic */ void d(f fVar) {
        while (fVar.kxK.size() > 0) {
            int i;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) fVar.kxK.remove(0);
            f fVar2 = fVar.kxH;
            int properties = bluetoothGattCharacteristic.getProperties();
            if ((properties & 48) == 0) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "no indicate and notify");
                i = 0;
            } else if (fVar2.kxf.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.kxU));
                if (descriptor == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not get configure descriptor");
                    i = 0;
                } else {
                    x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Configure descriptor permissions: " + descriptor.getPermissions());
                    byte[] bArr = new byte[]{(byte) 0, (byte) 0};
                    if ((properties & 32) != 0) {
                        bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[0]);
                        bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[1]);
                    }
                    if ((properties & 16) != 0) {
                        bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[0]);
                        bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[1]);
                    }
                    if (!descriptor.setValue(bArr)) {
                        x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not set configure descriptor value");
                        i = 0;
                    } else if (fVar2.kxf.writeDescriptor(descriptor)) {
                        boolean z = true;
                    } else {
                        x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not write configure descriptor value");
                        i = 0;
                    }
                }
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Unable to set indicator for read characteristic");
                i = 0;
            }
            if (i == 0) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mSelfSession.setCharacteristicNotification Failed!!!. uuid = %s, properties = %d", new Object[]{bluetoothGattCharacteristic.getUuid().toString(), Integer.valueOf(bluetoothGattCharacteristic.getProperties())});
            } else {
                return;
            }
        }
        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "onConnected = true");
        fVar.kxq = 1;
        fVar.mHandler.removeCallbacks(fVar.kxm);
        if (fVar.kxF != null) {
            fVar.kxF.a(fVar.mSessionId, true, fVar.kxJ);
        }
    }

    final void arp() {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", new Object[]{b.cK(this.mSessionId), this.kxd.getName()});
        this.kxq = 2;
        this.mHandler.removeCallbacks(this.kxm);
        this.mHandler.removeCallbacks(this.kxG);
        arq();
        releaseResources();
    }

    @TargetApi(18)
    public f(long j, Context context, a aVar) {
        this.kxo = new LinkedList();
        this.kxp = false;
        this.kxI = new HashMap();
        this.kxJ = 0;
        this.kxK = new ArrayList();
        this.kxr = new BluetoothGattCallback(this) {
            final /* synthetic */ f kxN;

            {
                this.kxN = r1;
            }

            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(this.kxN.kxq)});
                if (!this.kxN.mHandler.sendMessage(this.kxN.mHandler.obtainMessage(4, i2, 0))) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(4)});
                }
            }

            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.kxN.mHandler.sendMessage(this.kxN.mHandler.obtainMessage(5, i, 0, bluetoothGatt))) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(5)});
                }
            }

            public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.kxN.mHandler.sendMessage(this.kxN.mHandler.obtainMessage(6, i, 0, bluetoothGatt))) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(6)});
                }
            }

            public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
                if (!this.kxN.mHandler.sendMessage(this.kxN.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(8)});
                }
            }

            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", new Object[]{Integer.valueOf(i)});
                if (i == 0 && !this.kxN.mHandler.sendMessage(this.kxN.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(8)});
                }
            }

            public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.kxN.mHandler.sendMessage(this.kxN.mHandler.obtainMessage(7, i, 0))) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(7)});
                }
            }
        };
        this.aen = -1;
        this.aen = hashCode();
        this.kxH = this;
        this.kxF = aVar;
        this.kxe = context;
        this.kwe = ((BluetoothManager) this.kxe.getSystemService("bluetooth")).getAdapter();
        this.mSessionId = j;
        this.kxq = 3;
        this.kxd = this.kwe.getRemoteDevice(com.tencent.mm.plugin.g.a.e.a.bM(j));
        this.kxj = new a();
        this.kxL = false;
        this.mThread = e.Wf("BluetoothLESimpleSession_handlerThread");
        this.mThread.start();
        this.mHandler = new b(this.mThread.getLooper(), this);
        this.kxk = new 2(this);
        this.kxm = new 3(this);
        this.kxG = new 4(this);
    }

    private void releaseResources() {
        if (this.kxf == null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", new Object[]{Integer.valueOf(hashCode()), b.cK(this.mSessionId), this.kxd.getName()});
            return;
        }
        kxM--;
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(kxM), b.cK(this.mSessionId), this.kxd.getName()});
        this.kxL = false;
        this.kxf.close();
        this.mThread.quitSafely();
        this.kxf = null;
        this.mThread = null;
    }

    public final boolean connect() {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", new Object[]{b.cK(this.mSessionId), this.kxd.getName()});
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    private void arn() {
        this.kxp = false;
        this.kxo.clear();
    }

    private void arq() {
        if (this.kxF == null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", new Object[]{b.cK(this.mSessionId), this.kxd.getName()});
            return;
        }
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", new Object[]{b.cK(this.mSessionId), this.kxd.getName()});
        if (this.kxF != null) {
            this.kxF.a(this.mSessionId, false, this.kxJ);
        }
        this.kxF = null;
    }

    private void aro() {
        if (this.kxo.isEmpty()) {
            this.kxp = false;
            return;
        }
        com.tencent.mm.plugin.g.a.b.a.a ad = com.tencent.mm.plugin.g.a.b.a.a.ad((byte[]) this.kxo.pop());
        byte[] ars = ad.ars();
        String str = ad.kyq;
        int i = ad.kyr;
        HashMap hashMap = (HashMap) this.kxI.get(c.bK(ad.kxJ));
        if (hashMap == null) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", new Object[]{r4, b.cK(this.mSessionId), this.kxd.getName()});
            if (this.kxF != null) {
                this.kxF.h(this.mSessionId, false);
                return;
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) hashMap.get(str);
        if (bluetoothGattCharacteristic == null) {
            String str2;
            String str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            String str4 = "characteristic(%s) not found, mac=%s, name=%s";
            Object[] objArr = new Object[3];
            if (str == null) {
                str2 = "null";
            } else {
                str2 = str;
            }
            objArr[0] = str2;
            objArr[1] = b.cK(this.mSessionId);
            objArr[2] = this.kxd.getName();
            x.e(str3, str4, objArr);
            if (this.kxF != null) {
                this.kxF.h(this.mSessionId, false);
            }
        } else if (i == 8) {
            this.kxj.kwJ = bluetoothGattCharacteristic;
            this.kxj.setData(ars);
            x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", new Object[]{b.ap(this.kxj.ari()), str, b.cK(this.mSessionId), this.kxd.getName()});
            bluetoothGattCharacteristic.setValue(ars);
            this.mHandler.postDelayed(this.kxk, 5000);
            if (this.kxf.writeCharacteristic(bluetoothGattCharacteristic)) {
                this.kxp = true;
                return;
            }
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", new Object[]{b.cK(this.mSessionId), this.kxd.getName()});
            if (this.kxF != null) {
                this.kxF.h(this.mSessionId, false);
            }
        } else {
            x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), b.cK(this.mSessionId), this.kxd.getName()});
            if (this.kxF != null) {
                this.kxF.h(this.mSessionId, false);
            }
        }
    }
}

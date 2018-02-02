package com.tencent.mm.plugin.exdevice.service;

import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.g.a.b.d;
import com.tencent.mm.plugin.g.a.c.a;
import com.tencent.mm.plugin.g.a.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

public final class b implements c {
    private static b lPS = null;
    private com.tencent.mm.plugin.g.a.d.b lPO = null;
    private final Vector<r> lPP = new Vector();
    private final HashMap<Long, Integer> lPQ = new HashMap();
    private final HashMap<Long, Integer> lPR = new HashMap();
    private CountDownLatch lPT;
    private af mHandler = new af(v.aEN().hOa.oAt.getLooper());

    static /* synthetic */ void a(b bVar, long j, long j2) {
        boolean z = false;
        if (bVar.lPQ.containsKey(Long.valueOf(j))) {
            bVar.lPO.b(j, j2, ((Integer) bVar.lPQ.get(Long.valueOf(j))).intValue());
            return;
        }
        int intValue;
        v aEN = v.aEN();
        if (aEN.lQr.containsKey(Long.valueOf(j))) {
            intValue = ((Integer) aEN.lQr.get(Long.valueOf(j))).intValue();
        } else {
            x.e("MicroMsg.exdevice.MMExDevicePushCore", "getBluetoothVersionByDeviceId Failed!!! Cannot find BLuetoothVersion by DeviceId(%d)", Long.valueOf(j));
            intValue = -1;
        }
        Assert.assertTrue(-1 != intValue);
        String cK = com.tencent.mm.plugin.exdevice.j.b.cK(j);
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "insertDeviceIdTypeMap deviceid = %s, BTVersion = %d", cK, Integer.valueOf(intValue));
        Assert.assertNotNull(cK);
        if (1 == intValue || intValue == 0) {
            z = true;
        }
        Assert.assertTrue(z);
        long zu = com.tencent.mm.plugin.exdevice.j.b.zu(cK);
        if (!bVar.lPQ.containsKey(Long.valueOf(zu))) {
            bVar.lPQ.put(Long.valueOf(zu), Integer.valueOf(intValue));
        }
        bVar.lPO.b(j, j2, intValue);
    }

    static /* synthetic */ boolean a(b bVar, int i) {
        boolean a;
        com.tencent.mm.plugin.g.a.d.b bVar2 = bVar.lPO;
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***stopScan*** aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (bVar2.kAl != null) {
                    a = bVar2.kAl.a(false, new int[0]);
                    break;
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                a = false;
                break;
            case 1:
                if (bVar2.kAm != null) {
                    a = bVar2.kAm.dS(false);
                    break;
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                a = false;
                break;
            default:
                Assert.assertTrue(false);
                a = false;
                break;
        }
        if (a) {
            return true;
        }
        x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.stopScan failed!!!");
        return false;
    }

    static /* synthetic */ boolean a(b bVar, int i, r rVar, int[] iArr) {
        if (rVar == null) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
            throw new IllegalArgumentException("scanImp: null == aCallback");
        }
        if (iArr == null ? bVar.lPO.a(i, new int[0]) : bVar.lPO.a(i, iArr)) {
            bVar.lPP.add(rVar);
            return true;
        }
        x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.scan failed!!!");
        if (rVar == null) {
            return false;
        }
        rVar.vM("scanImp: mBTSDKMrg.scan failed!!!");
        return false;
    }

    static /* synthetic */ boolean a(b bVar, long j) {
        boolean z = true;
        Assert.assertTrue(bVar.lPR.containsKey(Long.valueOf(j)));
        com.tencent.mm.plugin.g.a.d.b bVar2 = bVar.lPO;
        int intValue = ((Integer) bVar.lPR.get(Long.valueOf(j))).intValue();
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***connect*** aSessionId = " + j + " aBluetoothVersion = " + intValue);
        switch (intValue) {
            case 0:
                if (bVar2.kAl != null) {
                    z = bVar2.kAl.connect(j);
                    break;
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                z = false;
                break;
            case 1:
                if (bVar2.kAm != null) {
                    a aVar = bVar2.kAm;
                    x.i("MicroMsg.exdevice.BluetoothChatManager", "connect, session id = %d, secure = %s", Long.valueOf(j), "true");
                    Assert.assertTrue(aVar.mIsInit);
                    if (!aVar.art()) {
                        x.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                        z = false;
                        break;
                    }
                    com.tencent.mm.plugin.g.a.c.b bVar3 = (com.tencent.mm.plugin.g.a.c.b) aVar.kwL.get(Long.valueOf(j));
                    Assert.assertTrue(bVar3 != null);
                    x.i("MicroMsg.exdevice.BluetoothChatSession", "connect");
                    if (bVar3.kxd != null) {
                        bVar3.mState = 2;
                        if (bVar3.kzT != null) {
                            bVar3.kzT.disconnect();
                            bVar3.kzT = null;
                        }
                        bVar3.kzT = new com.tencent.mm.plugin.g.a.c.c.a(bVar3, aVar, bVar3.kxd, true);
                        com.tencent.mm.plugin.g.a.c.c.a aVar2 = bVar3.kzT;
                        x.i("MicroMsg.exdevice.ConnectThread", "------connect------");
                        if (!aVar2.mHandler.sendMessage(aVar2.mHandler.obtainMessage(0))) {
                            x.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", Integer.valueOf(0));
                            if (aVar2.kzZ != null) {
                                aVar2.kzZ.kzP.g(aVar2.kzY.mSessionId, false);
                                break;
                            }
                        }
                    }
                    x.e("MicroMsg.exdevice.BluetoothChatSession", "Can not found remote device(" + com.tencent.mm.plugin.g.a.e.a.bM(bVar3.kzS) + ")");
                    if (aVar != null) {
                        aVar.kzP.b(bVar3.mSessionId, 7, "Device not found");
                    }
                    z = false;
                    break;
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                z = false;
                break;
                break;
            default:
                Assert.assertTrue(false);
                z = false;
                break;
        }
        if (!z) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.connect failed!!!");
            bVar.g(j, false);
        }
        return z;
    }

    static /* synthetic */ boolean a(b bVar, long j, byte[] bArr) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(bVar.lPR.containsKey(Long.valueOf(j)));
        com.tencent.mm.plugin.g.a.d.b bVar2 = bVar.lPO;
        int intValue = ((Integer) bVar.lPR.get(Long.valueOf(j))).intValue();
        Assert.assertNotNull(bArr);
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***SendData*** sessionId = " + j + "bluetoothVersion = " + intValue);
        switch (intValue) {
            case 0:
                if (bVar2.kAl != null) {
                    com.tencent.mm.plugin.g.a.b.b bVar3 = bVar2.kAl;
                    x.i("MicroMsg.exdevice.BluetoothLEManager", "------writeData------ sessionId = %d, data length = %d", Long.valueOf(j), Integer.valueOf(bArr.length));
                    Assert.assertTrue(bVar3.mIsInit);
                    if (!bVar3.ark()) {
                        x.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                        z = false;
                        break;
                    }
                    d dVar = (d) bVar3.kwL.get(String.valueOf(j));
                    if (dVar != null) {
                        x.i("MicroMsg.exdevice.BluetoothLESession", "------writeData------length = %d", Integer.valueOf(bArr.length));
                        x.d("MicroMsg.exdevice.BluetoothLESession", "writeData data dump = %s", com.tencent.mm.plugin.exdevice.j.b.ap(bArr));
                        z = dVar.mHandler.sendMessage(dVar.mHandler.obtainMessage(3, bArr));
                        break;
                    }
                    x.w("MicroMsg.exdevice.BluetoothLEManager", "session is null, may be this session is closed");
                    z = false;
                    break;
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                z = false;
                break;
            case 1:
                if (bVar2.kAm != null) {
                    a aVar = bVar2.kAm;
                    x.i("MicroMsg.exdevice.BluetoothChatManager", "writeData to: " + j);
                    Assert.assertTrue(aVar.mIsInit);
                    if (!aVar.art()) {
                        x.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                        z = false;
                        break;
                    }
                    com.tencent.mm.plugin.g.a.c.b bVar4 = (com.tencent.mm.plugin.g.a.c.b) aVar.kwL.get(Long.valueOf(j));
                    if (bVar4 == null) {
                        z2 = false;
                    }
                    Assert.assertTrue(z2);
                    x.i("MicroMsg.exdevice.BluetoothChatSession", "write");
                    if (bVar4.kzV == null) {
                        z = false;
                        break;
                    }
                    z = bVar4.kzV.af(bArr);
                    break;
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                z = false;
                break;
            default:
                Assert.assertTrue(false);
                z = false;
                break;
        }
        if (!z) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.sendData failed!!!");
            bVar.h(j, false);
        }
        return z;
    }

    static /* synthetic */ void b(b bVar, long j) {
        boolean z = true;
        if (bVar.lPQ.containsKey(Long.valueOf(j))) {
            com.tencent.mm.plugin.g.a.d.b bVar2 = bVar.lPO;
            int intValue = ((Integer) bVar.lPR.get(Long.valueOf(j))).intValue();
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***Destroy Session*** aSessionId = " + j + " aBluetoothVersion" + intValue);
            switch (intValue) {
                case 0:
                    if (bVar2.kAl == null) {
                        x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                        return;
                    }
                    com.tencent.mm.plugin.g.a.b.b bVar3 = bVar2.kAl;
                    x.i("MicroMsg.exdevice.BluetoothLEManager", "------destroySession------ sessionId = %d", Long.valueOf(j));
                    Assert.assertTrue(bVar3.mIsInit);
                    if (bVar3.ark()) {
                        d dVar = (d) bVar3.kwL.remove(String.valueOf(j));
                        if (dVar == null) {
                            x.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot find BluetoothLESession by sessionId(%d)", Long.valueOf(j));
                            return;
                        }
                        dVar.close();
                        return;
                    }
                    x.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                    return;
                case 1:
                    if (bVar2.kAm == null) {
                        x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                        return;
                    }
                    a aVar = bVar2.kAm;
                    x.i("MicroMsg.exdevice.BluetoothChatManager", "------destroySession------ sessionId = %d", Long.valueOf(j));
                    Assert.assertTrue(aVar.mIsInit);
                    if (aVar.art()) {
                        com.tencent.mm.plugin.g.a.c.b bVar4 = (com.tencent.mm.plugin.g.a.c.b) aVar.kwL.remove(Long.valueOf(j));
                        if (bVar4 == null) {
                            z = false;
                        }
                        Assert.assertTrue(z);
                        bVar4.disconnect();
                        return;
                    }
                    x.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                    return;
                default:
                    Assert.assertTrue(false);
                    return;
            }
        }
        x.w("MicroMsg.exdevice.BluetoothSDKAdapter", "the session not exist");
    }

    public b() {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now thread id : %d, main thread is : %d", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(Looper.getMainLooper().getThread().getId()));
        if (VERSION.SDK_INT != 14 && VERSION.SDK_INT != 15) {
            this.lPO = new com.tencent.mm.plugin.g.a.d.b(ac.getContext(), this, v.aEN().hOa);
        } else if (r0 == r2) {
            x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "it is main thread now, init the bluetoothadapter directly");
            this.lPO = new com.tencent.mm.plugin.g.a.d.b(ac.getContext(), this, v.aEN().hOa);
        } else {
            new af(Looper.getMainLooper()).postAtFrontOfQueueV2(new 1(this));
            this.lPT = new CountDownLatch(1);
            try {
                this.lPT.await();
            } catch (InterruptedException e) {
            }
            x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now has init the sdk adapter");
        }
    }

    private static b aEA() {
        if (lPS != null) {
            return lPS;
        }
        b bVar = new b();
        lPS = bVar;
        return bVar;
    }

    public static boolean a(int i, r rVar, int... iArr) {
        if (rVar == null) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
            return false;
        }
        b aEA = aEA();
        boolean post = aEA.mHandler.post(new 2(aEA, i, rVar, iArr));
        if (post) {
            return post;
        }
        x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "scan: instance.mHandler.post failed!!!");
        return post;
    }

    public static boolean pc(int i) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---stopScan--- aBluetoothVersion = %d", Integer.valueOf(i));
        b aEA = aEA();
        boolean post = aEA.mHandler.post(new 3(aEA, i));
        if (!post) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "stopScan: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static void createSession(long j, long j2) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---createSession--- aDeviceId = %d, aChannelId = %d", Long.valueOf(j), Long.valueOf(j2));
        b aEA = aEA();
        if (!aEA.mHandler.post(new 4(aEA, j, j2))) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "createSession: instance.mHandler.post failed!!!");
        }
    }

    public static boolean sendData(long j, byte[] bArr) {
        int i = 0;
        String str = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str2 = "----sendData---- aSessionId = %d, datalength = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        x.i(str, str2, objArr);
        Assert.assertNotNull(bArr);
        b aEA = aEA();
        boolean post = aEA.mHandler.post(new 5(aEA, j, bArr));
        if (!post) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "sendData: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static boolean connect(long j) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---connect--- aSessionId = %d", Long.valueOf(j));
        b aEA = aEA();
        boolean post = aEA.mHandler.post(new 6(aEA, j));
        if (!post) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "connect: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static void destroySession(long j) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---destroySession--- aSessionId = %d", Long.valueOf(j));
        b aEA = aEA();
        if (!aEA.mHandler.post(new 7(aEA, j))) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "destroySession: instance.mHandler.post failed!!!");
        }
    }

    public final void b(long j, long j2, long j3) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSessionCreate--- aSessionId = " + j + " aDeviceID = " + j2);
        Assert.assertTrue(this.lPQ.containsKey(Long.valueOf(j2)));
        if (!this.lPR.containsKey(Long.valueOf(j))) {
            this.lPR.put(Long.valueOf(j), this.lPQ.get(Long.valueOf(j2)));
        }
        Java2CExDevice.onBluetoothSessionCreated(j2, j3, j);
    }

    public final void nd(int i) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFinished--- aBluetoothVersion =%d", Integer.valueOf(i));
        if (this.lPP.isEmpty()) {
            x.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            return;
        }
        Iterator it = this.lPP.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                rVar.nd(i);
            }
        }
        this.lPP.clear();
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        String str3 = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str4 = "---onScanFound--- deviceMac = %s, deviceName = %s, BTversion = %d, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.d(str3, str4, objArr);
        if (this.lPP.isEmpty()) {
            x.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            return;
        }
        Iterator it = this.lPP.iterator();
        while (it.hasNext()) {
            ((r) it.next()).a(str, str2, i, i2, bArr);
        }
    }

    public final void g(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onConnected--- sessionId = " + j + "Connected = " + z);
        if (z) {
            Java2CExDevice.onBluetoothConnected(j);
        } else {
            Java2CExDevice.onBluetoothDisconnected(j);
        }
    }

    public final void b(long j, byte[] bArr) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onRecv--- sessionId = " + j);
        Java2CExDevice.onBluetoothRecvData(j, bArr);
    }

    public final void h(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSend--- sessionId = " + j + "success = " + z);
        if (z) {
            Java2CExDevice.onBluetoothSendDataCompleted(j);
        } else {
            Java2CExDevice.onBluetoothError(j, 0);
        }
    }

    public final void bL(long j) {
        Java2CExDevice.onBluetoothError(j, 0);
    }
}

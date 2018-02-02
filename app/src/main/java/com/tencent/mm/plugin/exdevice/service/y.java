package com.tencent.mm.plugin.exdevice.service;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import com.tencent.mm.compatible.a.a$a;
import com.tencent.mm.plugin.exdevice.service.a.g;
import com.tencent.mm.plugin.exdevice.service.h.a;
import com.tencent.mm.plugin.g.a.a.c;
import com.tencent.mm.plugin.g.a.a.f;
import com.tencent.mm.plugin.g.a.a.f.6;
import com.tencent.mm.plugin.g.a.a.f.7;
import com.tencent.mm.plugin.g.a.a.h;
import com.tencent.mm.plugin.g.a.b.e;
import com.tencent.mm.plugin.g.a.b.e$a;
import com.tencent.mm.plugin.g.a.b.e.4;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

public final class y extends a implements g, com.tencent.mm.plugin.g.a.a.b, com.tencent.mm.plugin.g.a.d.a.a {
    private final l lQA;
    private int lQB;
    private final f lQC;
    private final com.tencent.mm.plugin.g.a.d.a lQD;
    private RemoteCallbackList<j> lQE;
    private RemoteCallbackList<k> lQF;
    private RemoteCallbackList<s> lQG;
    private RemoteCallbackList<t> lQH;
    e lQI;
    private e$a lQJ;
    private a lQt;
    private RemoteCallbackList<k> lQu;
    private RemoteCallbackList<p> lQv;
    private RemoteCallbackList<j> lQw;
    private RemoteCallbackList<i> lQx;
    private RemoteCallbackList<q> lQy;
    private RemoteCallbackList<n> lQz;
    private final af mHandler;

    private static final class b {
        long kAq;
        byte[] lJZ;
        short lKf;
        short lPJ;
        int mErrorCode;

        private b() {
            this.kAq = 0;
            this.lKf = (short) 0;
            this.lPJ = (short) 0;
            this.lJZ = null;
            this.mErrorCode = 0;
        }
    }

    private static final class d {
        String jcD = null;
        int lJY = 0;
        int lKk = 0;
        long lPM = 0;
    }

    private static final class i {
        public byte[] kwG;
        public long lMZ;
        public t lQQ;

        private i() {
        }
    }

    private static final class k {
        long lPM;
        p lQS;

        public k(long j, p pVar) {
            this.lPM = j;
            this.lQS = pVar;
        }
    }

    static /* synthetic */ void a(y yVar, int i, long j, short s, short s2, byte[] bArr) {
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onDeviceRequestImp errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Short.valueOf(s);
        objArr[3] = Short.valueOf(s2);
        objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str, str2, objArr);
        int beginBroadcast = yVar.lQx.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            try {
                i iVar = (i) yVar.lQx.getBroadcastItem(i2);
                if (iVar != null) {
                    iVar.a(i, j, s, s2, bArr);
                } else {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "get req callback failed, cmdId = %d", new Object[]{Short.valueOf(s2)});
                }
            } catch (Throwable e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDeviceRequest Failed!!! i = " + i2);
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        yVar.lQx.finishBroadcast();
    }

    static /* synthetic */ void a(y yVar, long j, int i, int i2, int i3) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChangeImp deviceId = " + j + " oldState" + i + " newState = " + i2 + " errCode = " + i3);
        k kVar = (k) a(j, yVar.lQu, yVar.lQu.beginBroadcast());
        if (kVar == null) {
            x.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + j);
            yVar.lQu.finishBroadcast();
            return;
        }
        try {
            kVar.a(j, i, i2, i3, 0);
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
        }
        yVar.lQu.finishBroadcast();
    }

    static /* synthetic */ void a(y yVar, g gVar) {
        int beginBroadcast = yVar.lQE.beginBroadcast();
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnDiscoverCallback size=%d", new Object[]{Integer.valueOf(beginBroadcast)});
        if (beginBroadcast <= 0) {
            x.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "no simpleBTOnDiscoverCallback");
        }
        int i = 0;
        while (i < beginBroadcast) {
            try {
                if (gVar.lQO) {
                    ((j) yVar.lQE.getBroadcastItem(i)).a(2, 0, "scan finish", null, null, 0, null);
                    if (!yVar.lQE.unregister(yVar.lQE.getBroadcastItem(i))) {
                        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mSimpleOnScanCallbackList.unregister failed!!!");
                    }
                } else {
                    ((j) yVar.lQE.getBroadcastItem(i)).a(1, 0, "discover device", gVar.kAu, gVar.kAv, gVar.kAw, gVar.lQP);
                }
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception: " + e.toString());
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                return;
            } finally {
                yVar.lQE.finishBroadcast();
            }
        }
        yVar.lQE.finishBroadcast();
    }

    static /* synthetic */ boolean a(y yVar, long j) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp, task id = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
            return false;
        }
        int beginBroadcast = yVar.lQv.beginBroadcast();
        IInterface iInterface = (p) a(j, yVar.lQv, beginBroadcast);
        if (iInterface == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask Failed, Cannot find such netCmd in RemoteCallbackList");
            yVar.lQv.finishBroadcast();
            return false;
        }
        a aVar = yVar.lQt;
        x.i("MicroMsg.exdevice.BTDeviceManager", "stopTask taskId = %d", new Object[]{Long.valueOf(j)});
        aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(9, Long.valueOf(j)));
        boolean a = a(yVar.lQv, j, iInterface, beginBroadcast);
        if (!a) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListTask.unregister Failed!!!");
        }
        yVar.lQv.finishBroadcast();
        return a;
    }

    static /* synthetic */ boolean a(y yVar, long j, int i, k kVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp deviceId = %d, bluetoothVersion = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        Assert.assertNotNull(kVar);
        v aEN = v.aEN();
        x.i("MicroMsg.exdevice.MMExDevicePushCore", "insertDeviceIdAndBluetoothVersion aDeviceId = %d, aBluetoothVersion = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        aEN.lQr.put(Long.valueOf(j), Integer.valueOf(i));
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registChannelStateChange, deviceId = %d", new Object[]{Long.valueOf(j)});
        boolean a = a(yVar.lQu, j, (IInterface) kVar);
        if (!a) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnStateChange.register Failed!!!");
        }
        if (a) {
            a aVar = yVar.lQt;
            x.i("MicroMsg.exdevice.BTDeviceManager", "startChannel deviceId = %d", new Object[]{Long.valueOf(j)});
            if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(11, Long.valueOf(j)))) {
                return true;
            }
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.startChannel Failed!!!");
            x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unregistChannelStateChange, deviceId = %d", new Object[]{Long.valueOf(j)});
            a = a(yVar.lQu, j, (IInterface) kVar, yVar.lQu.beginBroadcast());
            if (!a) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
            }
            yVar.lQu.finishBroadcast();
            if (!a) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unregistChannelStateChange");
            }
            yVar.b(j, 1, 4, -1);
            return false;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registChannelStateChange Failed!!!");
        yVar.b(j, 1, 4, -1);
        return false;
    }

    static /* synthetic */ boolean b(y yVar, long j) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp deviceId = %d", new Object[]{Long.valueOf(j)});
        a aVar = yVar.lQt;
        x.i("MicroMsg.exdevice.BTDeviceManager", "stopChannel deviceId = " + j);
        if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(12, Long.valueOf(j)))) {
            return true;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopChannel Failed!!!");
        return false;
    }

    public y() {
        this.lQt = null;
        this.lQu = new RemoteCallbackList();
        this.lQv = new RemoteCallbackList();
        this.lQw = new RemoteCallbackList();
        this.lQx = new RemoteCallbackList();
        this.lQy = new RemoteCallbackList();
        this.lQz = new RemoteCallbackList();
        this.lQA = new l((byte) 0);
        this.lQB = 0;
        this.lQE = new RemoteCallbackList();
        this.lQF = new RemoteCallbackList();
        this.lQG = new RemoteCallbackList();
        this.lQH = new RemoteCallbackList();
        this.lQt = new a(this);
        this.mHandler = new a(this, v.aEN().hOa.oAt.getLooper());
        if (VERSION.SDK_INT >= 18) {
            this.lQC = new f(this);
        } else {
            this.lQC = null;
        }
        this.lQD = new com.tencent.mm.plugin.g.a.d.a(this);
        this.lQJ = new 1(this);
        com.tencent.mm.compatible.a.a.a(18, new a$a(this) {
            final /* synthetic */ y lQK;

            {
                this.lQK = r1;
            }

            public final void run() {
                this.lQK.lQI = new e(this.lQK.lQJ);
            }
        });
    }

    private static IInterface a(long j, RemoteCallbackList remoteCallbackList, int i) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "findCallbackbyId, Id = %d, count = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        for (int i2 = 0; i2 < i; i2++) {
            HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i2);
            if (hashMap.containsKey(Long.valueOf(j))) {
                return (IInterface) hashMap.get(Long.valueOf(j));
            }
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find id in the callback list");
        return null;
    }

    private boolean c(j jVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnscanCallback");
        boolean unregister = this.lQw.unregister(jVar);
        if (unregister) {
            this.lQB--;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
        }
        return unregister;
    }

    public final boolean b(int i, j jVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---scan--- aBluetoothVersion = " + i);
        if (jVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            return false;
        }
        boolean post = this.mHandler.post(new 3(this, i, jVar));
        if (post) {
            return post;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan: mHandler.post failed!!!");
        return post;
    }

    private boolean f(int i, j jVar) {
        if (jVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            throw new IllegalArgumentException("scanImp: null == aCallback");
        }
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnscanCallback");
        boolean register = this.lQw.register(jVar);
        if (register) {
            this.lQB++;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.register Failed!!!");
        }
        if (register) {
            boolean z;
            r rVar = this.lQt;
            x.i("MicroMsg.exdevice.BTDeviceManager", "------scan------ bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            if (b.a(i, rVar, new int[0])) {
                z = true;
            } else {
                x.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.scan Failed!!!");
                z = false;
            }
            if (!z) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.scan Failed!!!");
                try {
                    jVar.a(0, -1, "scanImp: mBTDeviceMrg.scan failed!!!", "", "", 0, null);
                } catch (Throwable e) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
                if (!c(jVar)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
                }
            }
            return z;
        }
        try {
            jVar.a(0, -1, "scanImp: registScanCallback failed!!!", "", "", 0, null);
        } catch (Throwable e2) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", new Object[]{e2.getMessage()});
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
        }
        return false;
    }

    public final boolean c(int i, j jVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---stopScan--- aBluetoothVersion = " + i);
        if (jVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback");
            return false;
        }
        boolean post = this.mHandler.post(new 4(this, i, jVar));
        if (post) {
            return post;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScan: mHandler.post failed!!!");
        return post;
    }

    private boolean g(int i, j jVar) {
        if (jVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            return false;
        }
        boolean pc = a.pc(i);
        if (!pc) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
            try {
                jVar.a(0, -1, "stopScanImp: mBTDeviceMrg.stopScan failed!!!", "", "", 0, null);
            } catch (Throwable e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp: aCallback.onScanCallback failed!!!, %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        if (!c(jVar)) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
        }
        return pc;
    }

    public final long[] aEz() {
        return a.aEz();
    }

    private static boolean a(RemoteCallbackList remoteCallbackList, long j, IInterface iInterface) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB, ID = %d", new Object[]{Long.valueOf(j)});
        if (remoteCallbackList == null || iInterface == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
            return false;
        }
        int beginBroadcast = remoteCallbackList.beginBroadcast();
        do {
            beginBroadcast--;
            if (beginBroadcast < 0) {
                break;
            }
        } while (!remoteCallbackList.getBroadcastItem(beginBroadcast).asBinder().equals(iInterface.asBinder()));
        if (beginBroadcast < 0) {
            x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Register a new process in callback list.");
            HashMap hashMap = new HashMap();
            hashMap.put(Long.valueOf(j), iInterface);
            remoteCallbackList.register(iInterface, hashMap);
            remoteCallbackList.finishBroadcast();
            return true;
        }
        hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(beginBroadcast);
        if (hashMap == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
            remoteCallbackList.finishBroadcast();
            return false;
        }
        hashMap.put(Long.valueOf(j), iInterface);
        remoteCallbackList.finishBroadcast();
        return true;
    }

    private static boolean a(RemoteCallbackList remoteCallbackList, long j, IInterface iInterface, int i) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB, device id = %d, aCount = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (remoteCallbackList == null || iInterface == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
            return false;
        }
        do {
            i--;
            if (i < 0) {
                break;
            }
        } while (!remoteCallbackList.getBroadcastItem(i).asBinder().equals(iInterface.asBinder()));
        if (i < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find callback in callback list");
            return false;
        }
        HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i);
        if (hashMap == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
            return false;
        } else if (((IInterface) hashMap.remove(Long.valueOf(j))) == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find id in the map");
            return false;
        } else if (!hashMap.isEmpty()) {
            return true;
        } else {
            x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "No id is in the map, unregister this process");
            boolean unregister = remoteCallbackList.unregister(iInterface);
            if (unregister) {
                return unregister;
            }
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallbackList.unregister failed!!!");
            return unregister;
        }
    }

    public final boolean a(long j, int i, k kVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannel deviceId = %d, bluetoothVersion = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (kVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == callback");
            return false;
        } else if (j < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[]{Long.valueOf(j)});
            return false;
        } else if (1 == i || i == 0) {
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(3, new j(j, i, kVar)))) {
                return true;
            }
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", new Object[]{Integer.valueOf(3)});
            return false;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            return false;
        }
    }

    public final boolean cF(long j) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannel deviceId = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[]{Long.valueOf(j)});
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Long.valueOf(j)))) {
            return true;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", new Object[]{Integer.valueOf(4)});
            return false;
        }
    }

    public final boolean cG(long j) {
        return false;
    }

    private boolean b(long j, p pVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp, task Id = %d", new Object[]{Long.valueOf(j)});
        if (pVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
            d(j, -1, -1, "null == aTask");
            return false;
        }
        boolean z;
        a aVar = this.lQt;
        x.i("MicroMsg.exdevice.BTDeviceManager", "startTask, taskId = %d", new Object[]{Long.valueOf(j)});
        Assert.assertNotNull(pVar);
        if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(8, new g(j, pVar)))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", new StringBuilder("mBTDeviceMrg.startTask Failed ret = -1").toString());
            d(j, -1, -1, "mBTDeviceMrg.startTask Failed!!!");
            return false;
        } else if (a(this.lQv, j, (IInterface) pVar)) {
            return true;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB Fail!!!");
            d(j, -1, -1, "registerRemoteCB Fail!!!");
            return false;
        }
    }

    public final long a(p pVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTask");
        if (pVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
            return -1;
        }
        l lVar = this.lQA;
        if (Long.MAX_VALUE == lVar.lPM) {
            x.w("MicroMsg.TaskId", "TaskId Data-overrun!!!");
            lVar.lPM = 0;
        }
        long j = lVar.lPM;
        lVar.lPM = 1 + j;
        if (this.mHandler.sendMessage(this.mHandler.obtainMessage(0, new k(j, pVar)))) {
            return j;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! messsage what  = %d", new Object[]{Integer.valueOf(0)});
        return -1;
    }

    public final boolean cH(long j) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask, task Id = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(1, Long.valueOf(j)))) {
            return true;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage, message what = %d", new Object[]{Integer.valueOf(1)});
            return false;
        }
    }

    public final boolean a(i iVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnDeviceRequest");
        boolean register = this.lQx.register(iVar);
        if (!register) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.register Failed!!!");
        }
        return register;
    }

    public final boolean b(i iVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnDeviceRequest");
        boolean unregister = this.lQx.unregister(iVar);
        if (!unregister) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.unregister Failed!!!");
        }
        return unregister;
    }

    public final void a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
        int beginBroadcast = this.lQw.beginBroadcast();
        int i4 = 0;
        while (i4 < beginBroadcast) {
            try {
                ((j) this.lQw.getBroadcastItem(i4)).a(i, i2, str, str2, str3, i3, bArr);
                if (2 == i && !this.lQw.unregister(this.lQw.getBroadcastItem(i4))) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mCBListOnScanCallback.unregister failed!!!");
                }
            } catch (Throwable e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception i = " + i4);
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
            i4++;
        }
        this.lQw.finishBroadcast();
    }

    private void d(long j, int i, int i2, String str) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEndImp taskId = %d, errType = %d, errCode =%d, errMsg = %s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        int beginBroadcast = this.lQv.beginBroadcast();
        IInterface iInterface = (p) a(j, this.lQv, beginBroadcast);
        if (iInterface == null) {
            x.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By taskId = " + j);
            this.lQv.finishBroadcast();
            return;
        }
        try {
            iInterface.aEJ().a(j, i, i2, str, iInterface);
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onTaskEnd Error!!!");
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
        }
        if (!a(this.lQv, j, iInterface, beginBroadcast)) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB failed!!!");
        }
        this.lQv.finishBroadcast();
    }

    public final void c(long j, int i, int i2, String str) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEnd taskId = %d, errTpye = %d, errCode = %d, errMsg = %s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        d dVar = new d();
        dVar.lPM = j;
        dVar.lKk = i;
        dVar.lJY = i2;
        dVar.jcD = str;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2, dVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, MessageWhat = %d", new Object[]{Integer.valueOf(2)});
        }
    }

    public final void a(int i, long j, short s, short s2, byte[] bArr) {
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onDeviceRequest errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Short.valueOf(s);
        objArr[3] = Short.valueOf(s2);
        objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str, str2, objArr);
        b bVar = new b();
        bVar.lPJ = s2;
        bVar.lJZ = bArr;
        bVar.kAq = j;
        bVar.lKf = s;
        bVar.mErrorCode = i;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(6, bVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(6)});
        }
    }

    public final void b(long j, int i, int i2, int i3) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChange deviceId = " + j + " oldState" + i + " newState = " + i2 + " errCode = " + i3);
        c cVar = new c((byte) 0);
        cVar.kAq = j;
        cVar.lPK = i;
        cVar.lPL = i2;
        cVar.lJY = i3;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(5, cVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, messagewhat = %d", new Object[]{Integer.valueOf(5)});
        }
    }

    public final void setChannelSessionKey(long j, byte[] bArr) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---setChannelSessionKey--- deviceId = %d", new Object[]{Long.valueOf(j)});
        a aVar = this.lQt;
        x.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKey------ deviceId = %d", new Object[]{Long.valueOf(j)});
        if (!aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(10, new a.f(j, bArr)))) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "mHandler.sendMessage failed!!! messageWhat = %d", new Object[]{Integer.valueOf(10)});
        }
    }

    public final boolean a(String str, boolean z, q qVar) {
        if (VERSION.SDK_INT < 18 || this.lQC == null) {
            return false;
        }
        boolean hasSystemFeature = ac.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!hasSystemFeature || defaultAdapter == null) {
            return false;
        }
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
        if (this.lQy.register(qVar)) {
            try {
                UUID fromString = UUID.fromString(str);
                f fVar = this.lQC;
                f.kwd = ac.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                String str2 = "MicroMsg.exdevice.IBeaconServer";
                String str3 = "Ranging, uuid = %s, op = %s";
                Object[] objArr = new Object[2];
                objArr[0] = fromString == null ? "" : fromString.toString();
                objArr[1] = String.valueOf(z);
                x.d(str2, str3, objArr);
                if (fromString == null) {
                    x.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
                    hasSystemFeature = false;
                } else {
                    hasSystemFeature = z ? fVar.mHandler.post(new 6(fVar, fromString)) : fVar.mHandler.post(new 7(fVar, fromString));
                }
                if (hasSystemFeature) {
                    return true;
                }
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mIBeaconServer.ranging failed!!!");
                if (!this.lQy.unregister(qVar)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.unregister failed!!!");
                }
                return false;
            } catch (Exception e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "UUID.fromString failed!!!, (%s)", new Object[]{e.getMessage()});
                return false;
            }
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.register failed!!!");
        return false;
    }

    public final void a(double d, c cVar) {
        if (cVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aContext is null");
            return;
        }
        h hVar = cVar.kvU.kvY;
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onRangingCallback, distance = %f, uuid = %s, major = %d, minor = %d ,minor&0xFFFF = %d", new Object[]{Double.valueOf(d), com.tencent.mm.plugin.exdevice.j.b.ap(hVar.kwz), Short.valueOf(hVar.kwA), Short.valueOf(hVar.kwB), Integer.valueOf(hVar.kwB & 65535)});
        try {
            int beginBroadcast = this.lQy.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    ((q) this.lQy.getBroadcastItem(i)).a(d, hVar.kwA, hVar.kwB, hVar.kwz, cVar.kvV, cVar.kvU.kvY.kwC, cVar.bpq);
                } catch (Throwable e) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.getBroadcastItem failed!!!, i = %d, (%s)", new Object[]{Integer.valueOf(i), e.toString()});
                    x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[shakezb] beginBroadcast fail!", new Object[]{e2.toString()});
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
        } finally {
            this.lQy.finishBroadcast();
        }
    }

    public final void nf(int i) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "OnBluetoothStateChange, state = %d", new Object[]{Integer.valueOf(i)});
        for (int beginBroadcast = this.lQz.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_state", i);
            try {
                ((n) this.lQz.getBroadcastItem(beginBroadcast)).i(0, bundle);
            } catch (Throwable e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.getBroadcastItem(%d).onExdeviceInvoke failed!!!", new Object[]{Integer.valueOf(beginBroadcast)});
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        this.lQz.finishBroadcast();
    }

    public final void a(n nVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registExDeviceInvokerHandler");
        if (!this.lQz.register(nVar)) {
            x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.register failed!!!");
        }
    }

    public final boolean d(int i, j jVar) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothScan. bluetoothVersion=%d", new Object[]{Integer.valueOf(i)});
        if (jVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan callback is null. just return");
            return false;
        } else if (i != 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "this is not ble scan cmd");
            return false;
        } else {
            boolean register = this.lQE.register(jVar);
            if (register) {
                x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback ok");
            } else {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback fail");
            }
            if (this.lQI != null) {
                boolean z;
                e eVar = this.lQI;
                x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble scan");
                if (eVar.kwN != null) {
                    z = true;
                } else {
                    z = false;
                }
                Assert.assertTrue(z);
                if (eVar.ark()) {
                    z = eVar.kwN.a(true, eVar.kwQ);
                    if (z) {
                        eVar.kxv.clear();
                    }
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                    z = false;
                }
                if (!z) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simple ble scan fail");
                    try {
                        jVar.a(0, -1, "simpleBLE.scan failed!!!", "", "", 0, null);
                    } catch (Throwable e) {
                        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.scan callback failed!!!, %s", new Object[]{e.getMessage()});
                        x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                    }
                    if (!register) {
                        return false;
                    }
                    this.lQE.unregister(jVar);
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean e(int i, j jVar) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothStopScan. bluetoothVersion=%d", new Object[]{Integer.valueOf(i)});
        if (jVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan callback is null. just return");
            return false;
        } else if (this.lQI == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan mBLESimpleMgr is null. just return");
            return false;
        } else {
            boolean a;
            e eVar = this.lQI;
            x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble stop scan");
            Assert.assertTrue(eVar.kwN != null);
            if (eVar.ark()) {
                eVar.mHandler.removeCallbacks(eVar.mRunnable);
                a = eVar.kwN.a(false, eVar.kwQ);
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                a = false;
            }
            if (!a) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
                try {
                    jVar.a(0, -1, "simpleBLE.stopScan failed!!!", "", "", 0, null);
                } catch (Throwable e) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.onScanCallback failed!!!, %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
            }
            return a;
        }
    }

    public final boolean b(long j, int i, k kVar) {
        if (kVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            return false;
        } else if (j < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[]{Long.valueOf(j)});
            return false;
        } else if (i != 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            return false;
        } else {
            e eVar = new e((byte) 0);
            eVar.lMZ = j;
            eVar.lQM = i;
            eVar.lQN = kVar;
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(7, eVar))) {
                return true;
            }
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(7)});
            return false;
        }
    }

    public final boolean cI(long j) {
        if (j < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[]{Long.valueOf(j)});
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(8, Long.valueOf(j)))) {
            return true;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(8)});
            return false;
        }
    }

    public final boolean a(s sVar) {
        if (sVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            return false;
        }
        boolean register = this.lQG.register(sVar);
        if (register) {
            return register;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBluetoothRegistOnRecv error");
        return register;
    }

    public final boolean b(long j, byte[] bArr, t tVar) {
        if (0 > j) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mac < 0");
            return false;
        } else if (bArr == null || bArr.length <= 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "data is empty");
            return false;
        } else if (tVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            return false;
        } else {
            i iVar = new i();
            iVar.lMZ = j;
            iVar.kwG = bArr;
            iVar.lQQ = tVar;
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(10, iVar))) {
                return true;
            }
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(10)});
            return false;
        }
    }

    public final boolean c(long j, int i, k kVar) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl. mac=%d, bTVersion=%d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (a(this.lQF, j, (IInterface) kVar)) {
            try {
                kVar.a(j, -1, 1, -1, 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
            if (this.lQI != null) {
                boolean connect;
                e eVar = this.lQI;
                x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "connect. mac = %d", new Object[]{Long.valueOf(j)});
                if (eVar.ark()) {
                    com.tencent.mm.plugin.g.a.b.f fVar = (com.tencent.mm.plugin.g.a.b.f) eVar.kwL.get(Long.valueOf(j));
                    if (fVar != null) {
                        x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session(mac=%s) has been in map");
                        connect = fVar.connect();
                    } else {
                        fVar = new com.tencent.mm.plugin.g.a.b.f(j, eVar.tI, eVar.kxx);
                        if (fVar.connect()) {
                            eVar.t(new 4(eVar, j, fVar));
                            connect = true;
                        } else {
                            x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "tmpConnectForScan error");
                            connect = false;
                        }
                    }
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                    connect = false;
                }
                if (!connect) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "connect device(mac=%d) error", new Object[]{Long.valueOf(j)});
                    if (kVar != null) {
                        try {
                            kVar.a(j, 1, 4, -1, 0);
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register connect callback error");
        try {
            kVar.a(j, -1, 4, -1, 0);
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e22, "", new Object[0]);
        }
        return false;
    }

    public final boolean c(long j, byte[] bArr, t tVar) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl. mac=%d, data=%s", new Object[]{Long.valueOf(j), com.tencent.mm.plugin.exdevice.j.b.ap(bArr)});
        if (this.lQI != null) {
            boolean z;
            e eVar = this.lQI;
            x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "writeData. mac = %d", new Object[]{Long.valueOf(j)});
            if (eVar.ark()) {
                com.tencent.mm.plugin.g.a.b.f fVar = (com.tencent.mm.plugin.g.a.b.f) eVar.kwL.get(Long.valueOf(j));
                if (fVar == null) {
                    x.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session is null, may be this session is closed");
                    z = false;
                } else {
                    x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeData------parserobj, length = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(bArr.length), com.tencent.mm.plugin.exdevice.j.b.cK(fVar.mSessionId), fVar.kxd.getName()});
                    z = fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(3, bArr));
                }
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                z = false;
            }
            if (!z) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "writeData error");
                if (tVar != null) {
                    try {
                        tVar.b(j, -1, -1, "start write data error");
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                    }
                }
                return false;
            }
        }
        if (a(this.lQH, j, (IInterface) tVar)) {
            return true;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register on send end callback error");
        return false;
    }

    public final boolean b(long j, int i, int i2, int i3, long j2) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl. mac=%d, oldstate = %d, newsate=%d, errcode=%d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        k kVar = (k) a(j, this.lQF, this.lQF.beginBroadcast());
        if (kVar == null) {
            x.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + j);
            this.lQF.finishBroadcast();
            return false;
        }
        try {
            kVar.a(j, i, i2, i3, j2);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            return false;
        } finally {
            this.lQF.finishBroadcast();
        }
    }

    public final boolean e(long j, int i, int i2, String str) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl. mac=%d, errType = %d, errCode=%d, errMsg=%s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        t tVar = (t) a(j, this.lQH, this.lQH.beginBroadcast());
        if (tVar == null) {
            x.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + j);
            this.lQH.finishBroadcast();
            return false;
        }
        try {
            tVar.b(j, i, i2, str);
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onSendEnd Failed!!!");
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            return false;
        } finally {
            this.lQH.finishBroadcast();
        }
        return true;
    }

    public final boolean d(long j, byte[] bArr) {
        int i = 0;
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "simpleBTOnRecvImpl. mac=%d, data = %s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = bArr == null ? "null" : com.tencent.mm.plugin.exdevice.j.b.ap(bArr);
        x.d(str, str2, objArr);
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "SimpleOnRecvList size = %d", new Object[]{Integer.valueOf(this.lQG.beginBroadcast())});
        while (i < r2) {
            try {
                s sVar = (s) this.lQG.getBroadcastItem(i);
                if (sVar != null) {
                    sVar.c(j, bArr);
                } else {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ISimpleBTOnRecv_AIDL callback is null");
                }
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onDataRecv Failed!!!");
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            } finally {
                this.lQG.finishBroadcast();
            }
        }
        this.lQG.finishBroadcast();
        return true;
    }
}

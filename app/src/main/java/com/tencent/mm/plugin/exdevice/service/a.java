package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.AccessoryCmd;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.LongWrapper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class a implements r {
    private static a lPF = null;
    private Object hpF = new Object();
    private final HashMap<Long, Long> lPG = new HashMap();
    private g lPH = null;
    af mHandler = new a(this, v.aEN().hOa.oAt.getLooper());

    private static final class g {
        long lPM;
        p lPN;

        public g(long j, p pVar) {
            this.lPM = j;
            this.lPN = pVar;
        }
    }

    static /* synthetic */ void a(a aVar, long j, byte[] bArr) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKeyImp------ deviceId = %d", Long.valueOf(j));
        if (aVar.lPG.containsKey(Long.valueOf(j))) {
            Java2CExDevice.setChannelSessionKey(((Long) aVar.lPG.get(Long.valueOf(j))).longValue(), bArr);
        } else {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
        }
    }

    static /* synthetic */ boolean a(a aVar, long j) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "startChannelImp deviceId = %d", Long.valueOf(j));
        if (com.tencent.mm.plugin.exdevice.h.a.x("conneted_device", j)) {
            x.w("MicroMsg.exdevice.BTDeviceManager", "This deviceId is not call stop channel before startChannel, Call it");
            aVar.cu(j);
        }
        LongWrapper longWrapper = new LongWrapper();
        longWrapper.value = -1;
        int createChannel = Java2CExDevice.createChannel(j, longWrapper);
        if (createChannel != 0) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.createChannel Failed, ret = " + createChannel);
            aVar.lPH.b(j, 1, 4, -1);
            return false;
        }
        x.i("MicroMsg.exdevice.BTDeviceManager", "Create channel id is ok, deviceId = %d, channelId = %d", Long.valueOf(j), Long.valueOf(longWrapper.value));
        aVar.lPG.put(Long.valueOf(j), Long.valueOf(longWrapper.value));
        x.i("MicroMsg.exdevice.BTDeviceManager", "add the device to connected devices : [%d]", Long.valueOf(j));
        if (com.tencent.mm.plugin.exdevice.h.a.y("conneted_device", j)) {
            int startChannelService = Java2CExDevice.startChannelService(longWrapper.value);
            if (startChannelService == 0) {
                return true;
            }
            x.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startChannelService Failed, ret = " + startChannelService);
            aVar.lPH.b(j, 1, 4, -1);
            return false;
        }
        x.e("MicroMsg.exdevice.BTDeviceManager", "addToSharedPreferences failed!!!");
        aVar.lPH.b(j, 1, 4, -1);
        return false;
    }

    static /* synthetic */ void cw(long j) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "stopTaskImp taskId = %d", Long.valueOf(j));
        Java2CExDevice.stopTask(j);
    }

    public a(g gVar) {
        this.lPH = gVar;
        lPF = this;
    }

    public static boolean pc(int i) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "------stopScan------");
        if (b.pc(i)) {
            return true;
        }
        x.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.stopScan Failed!!!");
        return false;
    }

    public static long[] aEz() {
        return com.tencent.mm.plugin.exdevice.h.a.ze("conneted_device");
    }

    private boolean cu(long j) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "stopChannelImp deviceId = " + j);
        x.i("MicroMsg.exdevice.BTDeviceManager", "remove the device from connected devices : [%d]", Long.valueOf(j));
        if (!com.tencent.mm.plugin.exdevice.h.a.z("conneted_device", j)) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "removeFromSharedPreferences failed!!!");
        }
        if (this.lPG.containsKey(Long.valueOf(j))) {
            Java2CExDevice.stopChannelService(((Long) this.lPG.get(Long.valueOf(j))).longValue());
            Java2CExDevice.destroyChannel(((Long) this.lPG.get(Long.valueOf(j))).longValue());
            return true;
        }
        x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
        return false;
    }

    private int a(long j, p pVar) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "startTaskImp, taskId = %d", Long.valueOf(j));
        Assert.assertNotNull(pVar);
        try {
            long aED = pVar.aEI().aED();
            if (!com.tencent.mm.plugin.exdevice.h.a.x("conneted_device", aED)) {
                x.w("MicroMsg.exdevice.BTDeviceManager", "Cannot startTask because this channel is close aready!!!");
                e eVar = new e();
                eVar.lPM = j;
                eVar.lJY = -1;
                eVar.lKk = -1;
                eVar.jcD = "Channel is close aready!!!";
                Assert.assertTrue(lPF.mHandler.sendMessage(lPF.mHandler.obtainMessage(3, 0, 0, eVar)));
                return -1;
            } else if (this.lPG.containsKey(Long.valueOf(aED))) {
                AccessoryCmd accessoryCmd = new AccessoryCmd();
                accessoryCmd.channelID = ((Long) this.lPG.get(Long.valueOf(aED))).longValue();
                try {
                    accessoryCmd.reqCmdID = pVar.aEI().aEF();
                    accessoryCmd.respCmdID = pVar.aEI().aEG();
                    try {
                        if (Java2CExDevice.startTask(j, (short) pVar.aEI().aEH(), accessoryCmd, pVar.aEI().aEE()) != 0) {
                            x.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startTask Failed!!!");
                            return -1;
                        }
                        x.i("MicroMsg.exdevice.BTDeviceManager", "------let task go------ taskId = %d, deviceId = %d, channelId = %d, seq = %d, reqCmdId = %d, respCmdId = %d", Long.valueOf(j), Long.valueOf(aED), Long.valueOf(accessoryCmd.channelID), Integer.valueOf(pVar.aEI().aEH()), Integer.valueOf(accessoryCmd.reqCmdID), Integer.valueOf(accessoryCmd.respCmdID));
                        return 0;
                    } catch (Throwable e) {
                        x.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDataOut failed!!! %s", e.getMessage());
                        x.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e, "", new Object[0]);
                        this.lPH.c(j, -1, -1, "Remote getDataOut failed!!!!!!");
                        return -1;
                    }
                } catch (Throwable e2) {
                    x.e("MicroMsg.exdevice.BTDeviceManager", "Remote getResquestCmdId or getResponseCmdId failed!!! %s", e2.getMessage());
                    x.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e2, "", new Object[0]);
                    this.lPH.c(j, -1, -1, "Remote getResquestCmdId or getResponseCmdId failed!!!");
                    return -1;
                }
            } else {
                x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find Channel by DeviceId(%s) in mMapDeviceChannelId", Long.valueOf(aED));
                this.lPH.c(j, -1, -1, "Cannot find Channel by DeviceId!!!");
                return -1;
            }
        } catch (Throwable e22) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDeviceId failed!!! %s", e22.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e22, "", new Object[0]);
            this.lPH.c(j, -1, -1, "Remote getDeviceId failed!!!");
            return -1;
        }
    }

    public static void c(long j, int i, int i2, String str) {
        Assert.assertNotNull(lPF);
        x.i("MicroMsg.exdevice.BTDeviceManager", "onTaskEnd taskId = " + j + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        e eVar = new e();
        eVar.lPM = j;
        eVar.lJY = i2;
        eVar.lKk = i;
        eVar.jcD = str;
        Assert.assertTrue(lPF.mHandler.sendMessage(lPF.mHandler.obtainMessage(3, 0, 0, eVar)));
    }

    public static void b(long j, int i, int i2, int i3) {
        Assert.assertNotNull(lPF);
        x.i("MicroMsg.exdevice.BTDeviceManager", "onStateChange channelId = " + j + " oldState = " + i + " newState = " + i2 + " errCode = " + i3);
        long cv = lPF.cv(j);
        if (-1 == cv) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            return;
        }
        d dVar = new d((byte) 0);
        dVar.kAq = cv;
        dVar.lJY = i3;
        dVar.lPL = i2;
        dVar.lPK = i;
        Assert.assertTrue(lPF.mHandler.sendMessage(lPF.mHandler.obtainMessage(4, 0, 0, dVar)));
    }

    private long cv(long j) {
        if (this.lPG.containsValue(Long.valueOf(j))) {
            for (Entry entry : this.lPG.entrySet()) {
                if (j == ((Long) entry.getValue()).longValue()) {
                    return ((Long) entry.getKey()).longValue();
                }
            }
            Assert.assertTrue(false);
            return -1;
        }
        x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find DeviceId by channelId");
        return -1;
    }

    public static void onDeviceRequest(long j, short s, short s2, byte[] bArr, int i) {
        String str = "MicroMsg.exdevice.BTDeviceManager";
        String str2 = "onDeviceRequest channelId = %d, seq = %d, cmdId =%d, datain len = %d, errCode = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Short.valueOf(s);
        objArr[2] = Short.valueOf(s2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[4] = Integer.valueOf(i);
        x.i(str, str2, objArr);
        Assert.assertNotNull(lPF);
        x.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = " + j + " seq = " + s + "cmdId = " + s2 + "errCode = " + i);
        long cv = lPF.cv(j);
        if (-1 == cv) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            return;
        }
        b bVar = new b((byte) 0);
        bVar.kAq = cv;
        bVar.lJZ = bArr;
        bVar.lPJ = s2;
        bVar.lKf = s;
        Assert.assertTrue(lPF.mHandler.sendMessage(lPF.mHandler.obtainMessage(5, i, 0, bVar)));
    }

    public final void nd(int i) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "******onScanFinished******aBluetoothVersion = " + i);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 0, 0, null)));
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        String str3 = "MicroMsg.exdevice.BTDeviceManager";
        String str4 = "------onScanFound------ aBluetoothVersion = %d, device mac = %s, device name = %s, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.d(str3, str4, objArr);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 0, 0, new c(str, str2, i2, bArr))));
    }

    public final void vM(String str) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "------onScanError------ error code = %d, error msg = %s", Integer.valueOf(-1), Integer.valueOf(-1));
        if (!this.mHandler.post(new 1(this))) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "onScanError: mHandler.post failed!!!");
        }
    }
}

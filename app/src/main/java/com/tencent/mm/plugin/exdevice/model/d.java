package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.plugin.exdevice.h.a;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.f$a;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;

public final class d {
    private static int lKG = 0;
    public c lKB;
    private w lKC;
    HashMap<Long, ak> lKD;
    HashMap<Long, ak> lKE;
    HashMap<Long, Integer> lKF;
    j lKH;
    private Object lKI;

    public d() {
        this.lKH = null;
        this.lKI = new Object();
        u.aEM().lKx = new 1(this);
        if (this.lKC == null) {
            this.lKC = new 10(this);
        }
        this.lKD = new HashMap();
        this.lKE = new HashMap();
        this.lKF = new HashMap();
    }

    public static int aDS() {
        return lKG;
    }

    public final synchronized void pa(int i) {
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", Integer.valueOf(i));
        lKG = i;
    }

    public final synchronized void a(Long l, int i) {
        this.lKF.put(l, Integer.valueOf(i));
    }

    public final void a(String str, long j, int i) {
        a(str, j, i, false);
    }

    public final void a(String str, long j, int i, boolean z) {
        a.z("shut_down_device", j);
        if (this.lKB == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
            this.lKB = new c();
            this.lKB.lQd = new 6(this, i, str, j, z);
            this.lKB.cx(ac.getContext());
        } else if (this.lKB == null || this.lKB.lQe) {
            b(str, j, i, z);
        } else {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
            this.lKB.lQd = new 7(this, i, str, j, z);
            this.lKB.cx(ac.getContext());
        }
    }

    public final void b(String str, long j, int i, boolean z) {
        boolean b;
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
        if (z) {
            b = b(str, j, i);
        } else if (ar.CG().Km() != 4) {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            b = false;
        } else {
            if (this.lKD.containsKey(Long.valueOf(j))) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", str, Long.valueOf(j), Integer.valueOf(i));
                ak akVar = (ak) this.lKD.get(Long.valueOf(j));
                akVar.TG();
                akVar.J(30000, 30000);
            } else {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", str, Long.valueOf(j), Integer.valueOf(i));
                ak akVar2 = new ak(Looper.getMainLooper(), new 9(this, j, str, i), false);
                akVar2.J(30000, 30000);
                this.lKD.put(Long.valueOf(j), akVar2);
            }
            if (u.aEM().lKw == null) {
                x.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", str, Long.valueOf(j), Integer.valueOf(i));
                b = false;
            } else {
                f$a cz = u.aEL().cz(j);
                if (cz == null) {
                    x.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", Long.valueOf(j));
                    b = false;
                } else {
                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", Integer.valueOf(cz.fsg));
                    if (!(cz.fsg == 2 || cz.fsg == 1)) {
                        u.aEM().lKw.a(j, i, this.lKC);
                    }
                    b = true;
                }
            }
        }
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", Boolean.valueOf(b));
    }

    public static void cn(long j) {
        if (u.aEM().lKw != null) {
            boolean cF = u.aEM().lKw.cF(j);
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", Long.valueOf(j), Boolean.valueOf(cF));
        }
    }

    public final void aDT() {
        if (this.lKB != null && this.lKB.lQe) {
            try {
                ac.getContext().unbindService(this.lKB);
            } catch (Exception e) {
            }
        }
    }

    private synchronized boolean b(String str, long j, int i) {
        boolean z;
        int Km = ar.CG().Km();
        if (Km != 4 && Km != 6) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            z = false;
        } else if (this.lKE.containsKey(Long.valueOf(j))) {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", str, Long.valueOf(j));
            z = false;
        } else {
            ak akVar = new ak(Looper.getMainLooper(), new 8(this, j, str, i), false);
            long aFy = b.aFy();
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", Long.valueOf(aFy));
            akVar.J(aFy, aFy);
            this.lKE.put(Long.valueOf(j), akVar);
            if (u.aEM().lKw != null) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", str, Long.valueOf(j));
                z = u.aEM().lKw.a(j, i, this.lKC);
            } else {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
                z = false;
            }
        }
        return z;
    }

    public static boolean eG(boolean z) {
        if (u.aEM().lKw != null) {
            long[] aEz = u.aEM().lKw.aEz();
            if (aEz == null || aEz.length <= 0) {
                x.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
                return false;
            }
            for (long j : aEz) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", Long.valueOf(j));
                com.tencent.mm.plugin.exdevice.h.b cJ = ad.aEk().cJ(j);
                if (cJ == null) {
                    x.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", Long.valueOf(j));
                } else if (z && (cJ.field_closeStrategy & 1) == 0) {
                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", Long.valueOf(j));
                } else {
                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", Long.valueOf(j));
                    u.aEM().lKw.cF(j);
                }
            }
            return true;
        }
        x.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
        return false;
    }

    public final void a(int i, j jVar) {
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", Integer.valueOf(i));
        if (jVar == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
            return;
        }
        this.lKH = jVar;
        if (this.lKB == null) {
            this.lKB = new c();
            this.lKB.lQd = new 12(this, i, i);
            this.lKB.cx(ac.getContext());
            return;
        }
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (u.aEM().lKw == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else if (!u.aEM().lKw.b(i, this.lKH)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
    }
}

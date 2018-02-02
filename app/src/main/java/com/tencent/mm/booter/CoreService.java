package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mars.Mars;
import com.tencent.mars.comm.Alarm;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.comm.PlatformComm.IResetProcess;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.aa.a;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.m;
import com.tencent.mm.network.p;
import com.tencent.mm.network.t;
import com.tencent.mm.network.t.12;
import com.tencent.mm.network.w;
import com.tencent.mm.network.y;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class CoreService extends Service implements IResetProcess, a, m {
    private t gxO;
    private e gxP = new e();
    private boolean gxQ = true;
    private final b gxR = new 1(this);
    private int gxS = -1;
    private long gxT = 0;
    private long gxU = 0;
    private long gxV = 0;
    private WakerLock gxW = null;
    private f gxX = new f();
    private ak gxY = new ak(new 4(this), false);

    public static class InnerService extends Service {
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(-1213, new Notification());
            } catch (NullPointerException e) {
                x.e("MicroMsg.CoreService", "set service for push exception:%s.", new Object[]{e});
            }
            stopSelf();
        }

        public void onDestroy() {
            stopForeground(true);
            super.onDestroy();
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public void onCreate() {
        String string;
        String string2;
        String str;
        NetworkInfo networkInfo = null;
        x.d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        if (VERSION.SDK_INT < 24 && !h.zj()) {
            if (VERSION.SDK_INT < 18) {
                startForeground(-1213, new Notification());
            } else if (getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false)) {
                startForeground(-1213, new Notification());
                startService(new Intent(this, InnerService.class));
                x.i("MicroMsg.CoreService", "set service for push.");
            }
        }
        af afVar = new af(Looper.getMainLooper());
        Mars.init(ac.getContext(), afVar);
        StnLogic.setCallBack(new com.tencent.mm.network.af());
        IPxxLogic.setCallBack(new p());
        com.tencent.mm.jni.a.a.BN();
        com.tencent.mm.sdk.b.a.xef.b(new c<nj>(this) {
            final /* synthetic */ CoreService gxZ;

            {
                this.gxZ = r2;
                this.xen = nj.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                String str = ((nj) bVar).fFs.fFt;
                if (bh.ov(str)) {
                    return false;
                }
                d.pPH.a(12900, str, true, false);
                return true;
            }
        });
        aa.VK();
        com.tencent.mm.sdk.platformtools.aa.a(this.gxR);
        if (PlatformComm.resetprocessimp == null) {
            PlatformComm.resetprocessimp = this;
        }
        aa.a(afVar);
        aa.setContext(getApplicationContext());
        aa.a(new ab());
        aa.a(new com.tencent.mm.network.ac());
        aa.a(this);
        aa.a(new w());
        this.gxO = aa.VQ();
        if (this.gxO == null) {
            x.i("MicroMsg.CoreService", "autoAuth is null and new one");
            this.gxO = new t(aa.VO());
            aa.b(this.gxO);
        } else {
            x.w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.gxO.reset();
        }
        Mars.onCreate(true);
        if (aa.VR() == null) {
            x.i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
            aa.a(new z());
        } else {
            x.w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            aa.VR().reset();
        }
        if (aa.VS() == null) {
            x.i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
            aa.a(new y());
            aa.VS().iaE = this;
            if (aa.VV()) {
                aa.cf(false);
                aa.VO().post(new Runnable(this) {
                    final /* synthetic */ CoreService gxZ;

                    {
                        this.gxZ = r1;
                    }

                    public final void run() {
                        x.i("MicroMsg.CoreService", "NetNotifyAdapter NeedNotifyGCM after init");
                        aa.VS().onPush(2147480001, new byte[0]);
                    }

                    public final String toString() {
                        return "NotifyGCM";
                    }
                });
            }
        }
        c cVar = ((com.tencent.mm.kernel.b.h) g.Dg().CN()).gyS;
        if (cVar != null) {
            this.gxO.e(cVar.getString(".com.tencent.mm.debug.server.host.http"), cVar.getString(".com.tencent.mm.debug.server.ports.http"), cVar.getString(".com.tencent.mm.debug.server.host.socket"), cVar.getString(".com.tencent.mm.debug.server.ports.socket"));
            string = cVar.getString(".com.tencent.mm.debug.server.wallet.host");
            string2 = cVar.getString(".com.tencent.mm.debug.server.wallet.ip");
            t tVar = this.gxO;
            if (!(bh.ov(string) || bh.G(new String[0]))) {
                new 12(tVar, string, string2).b(tVar.handler);
            }
        }
        if (cVar == null) {
            str = networkInfo;
        } else {
            str = cVar.getString(".com.tencent.mm.debug.server.host.newdns");
        }
        if (str == null || !str.contains(":")) {
            string = str;
            Object obj = networkInfo;
        } else {
            String[] split = str.split(":");
            string = split[0];
            str = split[1];
        }
        this.gxO.setNewDnsDebugHost(string, str);
        MMReceivers$AlarmReceiver.aE(getApplicationContext());
        MMReceivers$AlarmReceiver.aD(getApplicationContext());
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CoreService", e, "", new Object[0]);
            x.e("MicroMsg.CoreService", "getActiveNetworkInfo failed. %s", new Object[]{e.getMessage()});
        }
        if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
            string = "MicroMsg.CoreService";
            string2 = "networkInfo.state: %s";
            Object[] objArr = new Object[1];
            objArr[0] = networkInfo == null ? "null" : networkInfo.getState();
            x.e(string, string2, objArr);
            aa.VM().iaX = false;
            aa.VN().iT(0);
        } else {
            aa.VM().iaX = true;
            aa.VN().iT(6);
        }
        ((PluginZero) g.k(PluginZero.class)).vaH.a(this);
        x.i("MicroMsg.CoreService", "CoreService OnCreate ");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int myPid = Process.myPid();
        x.i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", new Object[]{Integer.valueOf(this.gxS), Integer.valueOf(myPid), Integer.valueOf(i), Integer.valueOf(i2)});
        if (myPid != this.gxS) {
            this.gxS = myPid;
            d.pPH.a(99, 141, 1, false);
            if (intent != null && "auto".equals(intent.getStringExtra("START_TYPE"))) {
                d.pPH.a(99, 140, 1, false);
            }
        }
        return 1;
    }

    public void onDestroy() {
        x.d("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
        ((PluginZero) g.k(PluginZero.class)).vaH.b(this);
        com.tencent.mm.jni.a.a.BO();
        super.onDestroy();
        wD();
    }

    public boolean onUnbind(Intent intent) {
        x.d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
        aa.VM().iaW = null;
        aa.VU().iax = null;
        return super.onUnbind(intent);
    }

    public IBinder onBind(Intent intent) {
        x.d("MicroMsg.CoreService", "onBind~~~ threadID:" + Thread.currentThread());
        return this.gxO;
    }

    public void onRebind(Intent intent) {
        x.d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
    }

    public final boolean d(int i, byte[] bArr) {
        if (k.aX(this)) {
            x.i("MicroMsg.CoreService", "fully exited, no need to notify worker");
            return false;
        }
        int i2;
        if (i == -255) {
            i2 = 138;
        } else {
            i2 = i;
        }
        boolean z = aa.VJ().getBoolean("is_in_notify_mode", false);
        boolean bw = bh.bw(this.gxO.hZK.CF());
        boolean Vx = aa.VQ().Vx();
        if (!(!z || bw || Vx)) {
            if (f.a(2, i2, bArr, this.gxO.hZK.CF(), bh.Wp())) {
                x.i("MicroMsg.CoreService", "deal with notify sync in push");
                return true;
            }
        }
        x.i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isSessionKeyNull:%b, isMMProcessExist:%b, isInNotifyMode:%b", new Object[]{Boolean.valueOf(bw), Boolean.valueOf(Vx), Boolean.valueOf(z)});
        Intent intent = new Intent(this, NotifyReceiver.class);
        intent.putExtra("notify_option_type", 2);
        intent.putExtra("notify_uin", this.gxO.hZK.Cg());
        intent.putExtra("notify_respType", i2);
        intent.putExtra("notify_respBuf", bArr);
        intent.putExtra("notfiy_recv_time", bh.Wp());
        intent.putExtra("notify_skey", this.gxO.hZK.CF());
        x.i("MicroMsg.CoreService", "notify broadcast:" + intent.getAction() + ", type=" + i2);
        try {
            x.i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d", new Object[]{Long.valueOf(intent.getLongExtra("notfiy_recv_time", 0)), Integer.valueOf(intent.getIntExtra("notify_uin", 0)), Integer.valueOf(intent.getIntExtra("notify_respType", 0)), Integer.valueOf(bh.i(intent.getByteArrayExtra("notify_respBuf"), new byte[0]).length)});
            sendBroadcast(intent);
            com.tencent.mm.aj.a.hx(i2);
        } catch (Throwable th) {
            x.e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", new Object[]{bh.i(th)});
        }
        return true;
    }

    public final void aS(boolean z) {
        if (z) {
            x.w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
            aa.VM().iaX = true;
            boolean wE = this.gxP.wE();
            if (!this.gxQ || wE) {
                if (wE) {
                    aa.VQ().Vp();
                }
                this.gxQ = true;
                aa.VN().iT(6);
                if (this.gxW == null) {
                    this.gxW = new WakerLock(getApplicationContext());
                }
                if (!this.gxW.isLocking()) {
                    this.gxW.lock(6000, "CoreService.setNetworkAvailable");
                    this.gxT++;
                }
                if (0 == this.gxV) {
                    this.gxU = bh.Wp();
                }
                this.gxV++;
                x.i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", new Object[]{Long.valueOf(this.gxT), Long.valueOf(this.gxV), Long.valueOf(bh.Wp() - this.gxU)});
                this.gxY.J(3000, 3000);
                return;
            }
            x.i("MicroMsg.CoreService", "network not change or can't get network info, lastStatus connect:%b", new Object[]{Boolean.valueOf(this.gxQ)});
            return;
        }
        x.w("MicroMsg.CoreService", "[NETWORK LOST]");
        aa.VM().iaX = false;
        aa.VN().iT(0);
        if (this.gxQ) {
            aa.VQ().Vp();
            e eVar = this.gxP;
            eVar.gyh = null;
            eVar.gyi = null;
        }
        this.gxQ = false;
    }

    public static void wC() {
        Intent intent = new Intent(aa.getContext(), NotifyReceiver.class);
        intent.putExtra("notify_option_type", 1);
        intent.putExtra("notify_uin", aa.VQ().hZK.Cg());
        try {
            aa.getContext().sendBroadcast(intent);
        } catch (Exception e) {
            x.f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", new Object[]{e.toString()});
        }
    }

    private void wD() {
        x.w("MicroMsg.CoreService", "[COMPLETE EXIT]");
        aa.VR().e(3, 10000, "");
        Mars.onDestroy();
        try {
            MMReceivers$AlarmReceiver.aE(getApplicationContext());
            MMReceivers$AlarmReceiver.aC(getApplicationContext());
            Alarm.resetAlarm(getApplicationContext());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CoreService", e, "", new Object[0]);
        }
        x.appenderClose();
        Process.killProcess(Process.myPid());
    }

    public void restartProcess() {
        x.w("MicroMsg.CoreService", "restartProcess");
        wD();
    }
}

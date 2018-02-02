package com.tencent.mm.plugin.bbom;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.d.a;
import com.tencent.mm.booter.d.c;
import com.tencent.mm.booter.q;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.p$a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.mm.ui.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bc;
import com.tencent.mm.z.d.b.3;
import com.tencent.mm.z.l;
import com.tencent.mm.z.l.1;
import com.tencent.mm.z.l.2;
import com.tencent.mm.z.t;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteTrace;
import java.util.List;

public class PluginBigBallOfMud extends f implements ApplicationLifeCycleBucket {
    private static final String TAG = "MicroMsg.PluginBigBallOfMud";
    public Application app;
    private final MMAppMgr appMgr = new MMAppMgr();
    private e mProfileCompat;

    public String toString() {
        return "plugin-big-ball-of-mud";
    }

    public void installed() {
    }

    public void dependency() {
        dependsOn(b.class);
        dependsOn(n.class);
    }

    public void configure(g gVar) {
        String str;
        e eVar;
        int i;
        d.a(new 1(this));
        MMReceivers$ToolsProcessReceiver.a(new c());
        SandBoxProcessReceiver.a(new com.tencent.mm.booter.d.b());
        ExdeviceProcessReceiver.a(new a());
        com.tencent.mm.plugin.zero.a.d dVar = (com.tencent.mm.plugin.zero.a.d) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.zero.a.d.class);
        dVar.setILightPushDelegate(new i());
        dVar.addNotifyReceiverCallback(new n());
        dVar.addICoreServiceLifecycleCallback(new f());
        x.i(TAG, "zero %s", new Object[]{dVar});
        this.app = gVar.gSI;
        com.tencent.mm.modelstat.d.a(this.app);
        x.i(TAG, "app.getResources() is:" + gVar.gSI.getResources());
        ac.a(com.tencent.mm.bw.a.a(gVar.gSI.getResources(), gVar.gSI));
        com.tencent.mm.app.c.al(this.app.getApplicationContext());
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.compatible.loader.f fVar = new com.tencent.mm.compatible.loader.f();
        Application application = this.app;
        String str2 = gVar.gOs;
        if (str2 == null || str2.length() <= 0) {
            HandlerThread Wf = com.tencent.mm.sdk.f.e.Wf("ProfileFactoryImp_handlerThread");
            Wf.start();
            str2 = (String) new f$1(fVar).b(new af(Wf.getLooper()));
            Wf.getLooper().quit();
            str = str2;
        } else {
            str = str2;
        }
        if (str == null) {
            x.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
            eVar = null;
        } else {
            ac.Va(str);
            if (str.equals(ac.getPackageName())) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.WorkerProfile");
            } else if (str.equals(ac.getPackageName() + ":push")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.PusherProfile");
            } else if (str.equals(ac.getPackageName() + ":tools")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.ToolsProfile");
            } else if (str.equals(ac.getPackageName() + ":sandbox")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.SandBoxProfile");
            } else if (str.equals(ac.getPackageName() + ":exdevice")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.ExDeviceProfile");
            } else if (str.equals(ac.getPackageName() + ":TMAssistantDownloadSDKService")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.TMAssistantProfile");
            } else if (str.equals(ac.getPackageName() + ":nospace")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.NoSpaceProfile");
            } else if (str.equals(ac.getPackageName() + ":patch")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.PatchProfile");
            } else if (str.startsWith(ac.getPackageName() + ":appbrand")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.AppBrandProfile");
            } else if (str.startsWith(ac.getPackageName() + ":support")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.SupportProfile");
            } else {
                com.tencent.mm.sdk.a.b.z("MMApplication onCreate profile == null", "profile is null and initMMcore failed");
                eVar = null;
            }
            x.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", new Object[]{str});
        }
        this.mProfileCompat = eVar;
        if (!(this.mProfileCompat == null || gVar.DS())) {
            x.i(TAG, "before profile oncreate.");
            this.mProfileCompat.onCreate();
        }
        x.i(TAG, "after profile oncreate.");
        ((h) gVar).mProfileCompat = this.mProfileCompat;
        SharedPreferences sharedPreferences = gVar.gSI.getSharedPreferences("system_config_prefs", 0);
        if (sharedPreferences != null) {
            i = sharedPreferences.getInt("default_uin", 0);
        } else {
            i = 0;
        }
        x.i(TAG, "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", new Object[]{gVar.gOs, Long.valueOf(bh.bz(MMApplicationLike.sAppStartTime)), Long.valueOf(bh.bz(currentTimeMillis)), Integer.valueOf(i), w.gZK, com.tencent.mm.compatible.util.e.bnD});
        com.tencent.mm.j.a.a.a(new com.tencent.mm.j.a(this) {
            final /* synthetic */ PluginBigBallOfMud kvG;

            {
                this.kvG = r1;
            }

            public final void b(au auVar) {
                if (com.tencent.mm.ag.f.eE(auVar.field_talker)) {
                    auVar.dY(com.tencent.mm.ag.a.e.HD());
                }
            }

            public final String z(String str, int i) {
                if (com.tencent.mm.ag.f.eE(str)) {
                    return com.tencent.mm.ag.a.e.kr(((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH((long) i).gjF);
                }
                return bc.HE();
            }

            public final String c(au auVar) {
                if (com.tencent.mm.ag.f.eE(auVar.field_talker)) {
                    return com.tencent.mm.ag.a.e.kr(auVar.gjF);
                }
                return null;
            }

            public final boolean eE(String str) {
                return com.tencent.mm.ag.f.eE(str);
            }
        });
        if (gVar.DS()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            k.b("hardcoder", getClass().getClassLoader());
            HardCoderJNI.initReporter(new com.tencent.mm.pluginsdk.f());
            currentTimeMillis = SystemClock.elapsedRealtime();
            x.i(TAG, "summerhardcoder initHardCoder[%d %d %d %d] take[%d]ms", new Object[]{Long.valueOf(com.tencent.mm.kernel.a.a.gRi), Long.valueOf(com.tencent.mm.kernel.a.a.gRj), Long.valueOf(elapsedRealtime), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - com.tencent.mm.kernel.a.a.gRi)});
            HardCoderJNI.initHardCoder();
            s.hwp = new 7(this);
            com.tencent.mm.by.f.a(new SQLiteTrace(this) {
                final /* synthetic */ PluginBigBallOfMud kvG;

                {
                    this.kvG = r1;
                }

                public final void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j) {
                    try {
                        com.tencent.mm.z.d.b IP = com.tencent.mm.z.d.b.IP();
                        boolean isMainThread = ag.isMainThread();
                        String path = sQLiteDatabase.getPath();
                        if ((j > IP.hje && isMainThread) || (j > IP.hjg && !isMainThread)) {
                            for (String str2 : com.tencent.mm.z.d.b.hjm) {
                                if (!isMainThread && path.contains(str2)) {
                                    return;
                                }
                            }
                            if (i != 2 || !isMainThread || j >= IP.hjf) {
                                if (IP.hiJ) {
                                    x.i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
                                    return;
                                }
                                String toUpperCase = str.trim().toUpperCase();
                                if (toUpperCase.startsWith("INSERT") || toUpperCase.startsWith("UPDATE") || toUpperCase.startsWith("DELETE") || toUpperCase.startsWith("COMMIT") || toUpperCase.startsWith("SELECT")) {
                                    if (toUpperCase.startsWith("INSERT")) {
                                        toUpperCase = toUpperCase.substring(0, toUpperCase.indexOf("(", 0));
                                    } else if (toUpperCase.startsWith("COMMIT")) {
                                        toUpperCase = j > IP.hjh ? toUpperCase + "task:" + bh.cgy() : null;
                                    }
                                    if (toUpperCase.length() > WXMediaMessage.TITLE_LENGTH_LIMIT) {
                                        toUpperCase = toUpperCase.substring(0, WXMediaMessage.TITLE_LENGTH_LIMIT) + "...";
                                    }
                                    if (!toUpperCase.trim().endsWith(";")) {
                                        toUpperCase = toUpperCase + ";";
                                    }
                                } else {
                                    toUpperCase = null;
                                }
                                if (!bh.ov(toUpperCase)) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    com.tencent.mm.z.d.b.a("tid", String.valueOf(Thread.currentThread().getId()), stringBuilder);
                                    com.tencent.mm.z.d.b.a("sql", toUpperCase, stringBuilder);
                                    com.tencent.mm.z.d.b.a("lastTime", String.valueOf(j), stringBuilder);
                                    com.tencent.mm.z.d.b.a("foreground", com.tencent.mm.sdk.a.b.foreground ? "1" : "0", stringBuilder);
                                    com.tencent.mm.z.d.b.a("tname", Thread.currentThread().getName(), stringBuilder);
                                    toUpperCase = stringBuilder.toString();
                                    x.d("MicroMsg.SQLTraceManager", "SQL Trace mark : " + toUpperCase);
                                    ar.Dm().F(new 3(IP, toUpperCase));
                                }
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SQLiteTrace", e, "Failed to send trace.", new Object[0]);
                    }
                }

                public final void onConnectionObtained(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z) {
                }

                public final void onConnectionPoolBusy(SQLiteDatabase sQLiteDatabase, String str, List<String> list, String str2) {
                    int cfD;
                    boolean z = HardCoderJNI.hcDBEnable;
                    int i = HardCoderJNI.hcDBDelayWrite;
                    int i2 = HardCoderJNI.hcDBCPU;
                    int i3 = HardCoderJNI.hcDBIO;
                    if (HardCoderJNI.hcDBThr) {
                        cfD = com.tencent.mm.kernel.g.Dm().cfD();
                    } else {
                        cfD = 0;
                    }
                    HardCoderJNI.startPerformance(z, i, i2, i3, cfD, HardCoderJNI.hcDBTimeoutBusy, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, PluginBigBallOfMud.TAG);
                }

                public final void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase) {
                }
            });
            com.tencent.mm.storage.e.xmt = new j(this) {
                final /* synthetic */ PluginBigBallOfMud kvG;

                {
                    this.kvG = r1;
                }

                public final String F(au auVar) {
                    int i = (auVar.field_bizChatId == -1 || !com.tencent.mm.ag.f.eE(auVar.field_talker)) ? 0 : 1;
                    if (i == 0) {
                        return auVar.field_talker;
                    }
                    x.d(PluginBigBallOfMud.TAG, "mapNotifyInfo key:%s", new Object[]{auVar.field_talker + ":" + auVar.field_bizChatId});
                    return auVar.field_talker + ":" + auVar.field_bizChatId;
                }
            };
            t.a(new 10(this));
            com.tencent.mm.plugin.messenger.foundation.a.s.b(new com.tencent.mm.cd.c<r>(this) {
                final /* synthetic */ PluginBigBallOfMud kvG;

                {
                    this.kvG = r1;
                }

                public final /* synthetic */ Object get() {
                    return new q();
                }
            });
            p aVar = new com.tencent.mm.modelmulti.a();
            p$a.a(69, aVar);
            p$a.a(68, aVar);
            p$a.a(22, aVar);
            p$a.a(13, aVar);
            p$a.a(15, aVar);
            p$a.a(23, aVar);
            p$a.a(25, aVar);
            p$a.a(24, aVar);
            p$a.a(33, aVar);
            p$a.a(35, aVar);
            p$a.a(44, aVar);
            p$a.a(999999, aVar);
            p$a.a(53, aVar);
            p$a.a(com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX, aVar);
            Object cVar = new c();
            ((com.tencent.mm.plugin.messenger.foundation.a.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(cVar);
            com.tencent.mm.kernel.g.CG().a(681, cVar);
            com.tencent.mm.plugin.messenger.foundation.a.s.a(5, new k());
            com.tencent.mm.plugin.messenger.foundation.a.s.a(1, new r());
            com.tencent.mm.plugin.messenger.foundation.a.s.a(4, new g());
            ((b) com.tencent.mm.kernel.g.k(b.class)).addHandleAuthResponse(new a());
            com.tencent.mm.plugin.messenger.foundation.a.f lVar = new l();
            ((o) com.tencent.mm.kernel.g.h(o.class)).a((com.tencent.mm.plugin.messenger.foundation.a.k) lVar);
            ((o) com.tencent.mm.kernel.g.h(o.class)).a(lVar);
            com.tencent.mm.z.e.a(new b());
            com.tencent.mm.permission.b bVar = new com.tencent.mm.permission.b();
            new p().ceO();
            com.tencent.mm.kernel.g.CG().b(138, m.kvD);
            com.tencent.mm.kernel.g.CG().b(39, m.kvD);
            com.tencent.mm.kernel.g.CG().b(268369922, m.kvD);
            if (m.kvD == null) {
                m.kvD = new m();
            }
            com.tencent.mm.kernel.g.CG().a(138, m.kvD);
            com.tencent.mm.kernel.g.CG().a(39, m.kvD);
            com.tencent.mm.kernel.g.CG().a(268369922, m.kvD);
            o.cb(this.app);
            com.tencent.mm.ax.a.a.a("delchatroommember", new 1());
            com.tencent.mm.ax.a.a.a("NewXmlChatRoomAccessVerifyApplication", new 2());
            com.tencent.mm.ax.a.a.a("NewXmlChatRoomAccessVerifyApproval", new l.3());
            com.tencent.mm.ax.a.a.a("invokeMessage", new com.tencent.mm.ui.chatting.d.b.1());
            MMAppMgr mMAppMgr = this.appMgr;
            Context context = this.app;
            if (mMAppMgr.xJN == null) {
                mMAppMgr.xJN = new Receiver(mMAppMgr);
            }
            MMActivity.cmR();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            intentFilter.addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            intentFilter.addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            intentFilter.addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            intentFilter.addAction("MINIQB_OPEN_RET");
            context.registerReceiver(mMAppMgr.xJN, intentFilter, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION, null);
            q xVar = new com.tencent.mm.booter.x(com.tencent.mm.booter.c.aA(this.app));
            xVar.ee("MM");
            com.tencent.mm.platformtools.r.idz = bh.a(xVar.ef(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            com.tencent.mm.platformtools.r.icH = bh.a(xVar.ef(".com.tencent.mm.debug.test.display_errcode"), false);
            com.tencent.mm.platformtools.r.icI = bh.a(xVar.ef(".com.tencent.mm.debug.test.display_msgstate"), false);
            com.tencent.mm.platformtools.r.icJ = bh.a(xVar.ef(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            com.tencent.mm.platformtools.r.icK = bh.a(xVar.ef(".com.tencent.mm.debug.test.network.force_touch"), false);
            com.tencent.mm.platformtools.r.icL = bh.a(xVar.ef(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            com.tencent.mm.platformtools.r.icM = bh.a(xVar.ef(".com.tencent.mm.debug.test.crashIsExit"), false);
            com.tencent.mm.platformtools.r.idl = bh.getInt(bh.az(xVar.getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
            com.tencent.mm.platformtools.r.idm = bh.getInt(bh.az(xVar.getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
            com.tencent.mm.platformtools.r.icO = bh.a(xVar.ef(".com.tencent.mm.debug.test.album_drop_table"), false);
            com.tencent.mm.platformtools.r.icP = bh.a(xVar.ef(".com.tencent.mm.debug.test.album_dle_file"), false);
            com.tencent.mm.platformtools.r.icQ = bh.a(xVar.ef(".com.tencent.mm.debug.test.album_show_info"), false);
            com.tencent.mm.platformtools.r.icR = bh.a(xVar.ef(".com.tencent.mm.debug.test.location_help"), false);
            com.tencent.mm.platformtools.r.icU = bh.a(xVar.ef(".com.tencent.mm.debug.test.force_soso"), false);
            com.tencent.mm.platformtools.r.icV = bh.a(xVar.ef(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            com.tencent.mm.platformtools.r.icW = bh.a(xVar.ef(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            com.tencent.mm.platformtools.r.icX = bh.a(xVar.ef(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            com.tencent.mm.platformtools.r.ida = bh.a(xVar.ef(".com.tencent.mm.debug.test.filterfpnp"), false);
            com.tencent.mm.platformtools.r.idb = bh.a(xVar.ef(".com.tencent.mm.debug.test.testForPull"), false);
            int a = bh.a(xVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            com.tencent.mm.platformtools.r.icY = a;
            if (a != 4 && com.tencent.mm.platformtools.r.icY > 0) {
                v.xmG = com.tencent.mm.platformtools.r.icY;
                x.e("MicroMsg.WorkerDebugger", "cdn thread num " + com.tencent.mm.platformtools.r.icY);
            }
            com.tencent.mm.platformtools.r.icZ = bh.a(xVar.ef(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            com.tencent.mm.platformtools.r.idc = bh.az(xVar.getString(".com.tencent.mm.debug.server.host.http"), "");
            com.tencent.mm.platformtools.r.idd = bh.az(xVar.getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (bh.a(xVar.ef(".com.tencent.mm.debug.test.show_full_version"), false)) {
                com.tencent.mm.sdk.platformtools.f.xeA = true;
            }
            try {
                a = Integer.decode(xVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
                com.tencent.mm.protocal.d.CE(a);
                new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
            } catch (Exception e) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                str = xVar.getString(".com.tencent.mm.debug.log.setapilevel");
                if (!bh.ov(str)) {
                    com.tencent.mm.protocal.d.DEVICE_TYPE = "android-" + str;
                    com.tencent.mm.protocal.d.vAu = "android-" + str;
                    com.tencent.mm.protocal.d.vAw = str;
                    com.tencent.mm.sdk.a.b.UI(str);
                    new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.DEVICE_TYPE).append(" ").append(com.tencent.mm.sdk.a.b.ceL());
                }
            } catch (Exception e2) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                elapsedRealtime = Long.decode(xVar.getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.vAy).append(" new: ").append(elapsedRealtime);
                com.tencent.mm.protocal.d.vAy = elapsedRealtime;
            } catch (Exception e3) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                xVar.gyS.gyb = Integer.decode(xVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            } catch (Exception e4) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                boolean a2 = bh.a(xVar.ef(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean a3 = bh.a(xVar.ef(".com.tencent.mm.debug.report.kvstat"), false);
                boolean a4 = bh.a(xVar.ef(".com.tencent.mm.debug.report.clientpref"), false);
                boolean a5 = bh.a(xVar.ef(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
                new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
            } catch (Exception e5) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            com.tencent.mm.platformtools.r.idg = bh.a(xVar.ef(".com.tencent.mm.debug.test.update_test"), false);
            com.tencent.mm.platformtools.r.idh = bh.a(xVar.ef(".com.tencent.mm.debug.test.scan_save_image"), false);
            com.tencent.mm.platformtools.r.idj = bh.a(xVar.ef(".com.tencent.mm.debug.test.shake_get_config_list"), false);
            com.tencent.mm.platformtools.r.idk = bh.a(xVar.ef(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
            com.tencent.mm.platformtools.r.ido = bh.az(xVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
            x.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.r.ido);
            com.tencent.mm.platformtools.r.idD = bh.az(xVar.getString(".com.tencent.mm.debug.cdn.front"), "");
            com.tencent.mm.platformtools.r.idE = bh.az(xVar.getString(".com.tencent.mm.debug.cdn.zone"), "");
            com.tencent.mm.platformtools.r.idF = bh.az(xVar.getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
            com.tencent.mm.platformtools.r.idG = bh.az(xVar.getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
            com.tencent.mm.platformtools.r.idH = bh.az(xVar.getString(".com.tencent.mm.debug.cdn.ptl"), "");
            com.tencent.mm.platformtools.r.idI = bh.a(xVar.ef(".com.tencent.mm.debug.cdn.usestream"), false);
            com.tencent.mm.platformtools.r.idJ = bh.a(xVar.ef(".com.tencent.mm.debug.cdn.onlysendetl"), false);
            com.tencent.mm.platformtools.r.idK = bh.a(xVar.ef(".com.tencent.mm.debug.cdn.onlysendptl"), false);
            com.tencent.mm.platformtools.r.idM = bh.a(xVar.ef(".com.tencent.mm.debug.cdn.enable_debug"), false);
            com.tencent.mm.platformtools.r.idN = bh.a(xVar.ef(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
            com.tencent.mm.platformtools.r.idO = bh.a(xVar.ef(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
            com.tencent.mm.platformtools.r.idU = bh.a(xVar.ef(".com.tencent.mm.debug.bakmove_hardcode"), false);
            x.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + com.tencent.mm.platformtools.r.idU);
            com.tencent.mm.platformtools.r.idV = bh.az(xVar.getString(".com.tencent.mm.debug.bakmove_ip"), "");
            com.tencent.mm.platformtools.r.idW = bh.getInt(bh.az(xVar.getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
            com.tencent.mm.platformtools.r.idR = bh.a(xVar.ef(".com.tencent.mm.debug.cursormode_enabled"), true);
            com.tencent.mm.platformtools.r.ies = bh.a(xVar.ef(".com.tencent.mm.debug.disaster_ignore_interval"), false);
            com.tencent.mm.platformtools.r.iet = bh.a(xVar.ef(".com.tencent.mm.debug.disaster_ignore_expire"), false);
            com.tencent.mm.platformtools.r.ieu = bh.a(xVar.ef(".com.tencent.mm.debug.disaster_ignore_remove"), false);
            com.tencent.mm.platformtools.r.ieh = bh.a(xVar.ef(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
            com.tencent.mm.platformtools.r.iej = bh.az(xVar.getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
            com.tencent.mm.platformtools.r.iei = bh.a(xVar.ef(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
            com.tencent.mm.platformtools.r.iek = bh.az(xVar.getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
            com.tencent.mm.platformtools.r.ieq = bh.a(xVar.ef(".com.tencent.mm.debug.netmock"), false);
            ComponentName fc = bh.fc(ac.getContext());
            if (fc != null && fc.getPackageName().equals(ac.getPackageName()) && fc.getClassName().equals(ac.cfq())) {
                WorkerProfile.uu().fgo = true;
                WorkerProfile.uu().fgp = true;
                x.i(TAG, "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[]{fc.getPackageName(), fc.getClassName()});
            } else {
                if (fc != null) {
                    x.i(TAG, "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[]{fc.getPackageName(), fc.getClassName()});
                } else {
                    x.i(TAG, "start time check onCreate appOnCreate currentActivity == null");
                }
                if (!(fc == null || fc.getPackageName().equals(ac.getPackageName()))) {
                    WorkerProfile.uu().fgo = true;
                }
            }
            com.tencent.mm.z.d.b.IP();
            com.tencent.mm.z.d.b.setup();
            AppLogic.setCallBack(new AppCallBack(ac.getContext()));
            SmcLogic.setCallBack(new com.tencent.mm.plugin.report.service.h());
            com.tencent.mm.plugin.report.service.h.pRc = (WorkerProfile) this.mProfileCompat;
            k.b(com.tencent.mm.sdk.a.xdX, getClass().getClassLoader());
            BaseEvent.onCreate();
            SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.pPK);
            str = TAG;
            String str3 = "SmcLogic, class loader %s, %s";
            Object[] objArr = new Object[2];
            if (getClass().getClassLoader() == null) {
                i = -1;
            } else {
                i = getClass().getClassLoader().hashCode();
            }
            objArr[0] = Integer.valueOf(i);
            if (Thread.currentThread().getContextClassLoader() == null) {
                i = -1;
            } else {
                i = Thread.currentThread().getContextClassLoader().hashCode();
            }
            objArr[1] = Integer.valueOf(i);
            x.i(str, str3, objArr);
            try {
                if (com.tencent.mm.compatible.util.d.fN(20)) {
                    x.i(TAG, "weird");
                    SmcLogic.setUin(0);
                }
            } catch (Throwable th) {
                x.printErrStackTrace(TAG, th, "", new Object[0]);
            }
            n nVar = (n) com.tencent.mm.kernel.g.k(n.class);
            com.tencent.mm.plugin.zero.a.d dVar2 = (com.tencent.mm.plugin.zero.a.d) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.zero.a.d.class);
            new com.tencent.mm.plugin.h.d().after(nVar).before(this);
            new com.tencent.mm.plugin.h.f().after((com.tencent.mm.plugin.h.b) new com.tencent.mm.plugin.h.b().after(nVar).before(this)).before(this);
            new com.tencent.mm.plugin.h.c().after(nVar).before(this);
            new com.tencent.mm.plugin.h.a().after(dVar2);
        }
        com.tencent.mm.pluginsdk.i.a.b.n.a(new 12(this));
        com.tencent.mm.y.g.b.a(new 13(this));
        com.tencent.mm.y.g.b.a(new 2(this));
        com.tencent.mm.y.g.b.a(new com.tencent.mm.cd.c<com.tencent.mm.y.e>(this) {
            final /* synthetic */ PluginBigBallOfMud kvG;

            {
                this.kvG = r1;
            }

            public final /* synthetic */ Object get() {
                return new com.tencent.mm.y.e();
            }
        });
        com.tencent.mm.y.g.b.a(new 4(this));
        com.tencent.mm.y.g.b.a(new com.tencent.mm.cd.c<com.tencent.mm.y.f>(this) {
            final /* synthetic */ PluginBigBallOfMud kvG;

            {
                this.kvG = r1;
            }

            public final /* synthetic */ Object get() {
                return new com.tencent.mm.y.f();
            }
        });
    }

    public void execute(g gVar) {
    }

    public void onTerminate() {
        x.i(TAG, "onTerminate(%s)", new Object[]{ac.Br()});
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTerminate();
        }
        MMAppMgr mMAppMgr = this.appMgr;
        Context context = this.app;
        if (mMAppMgr.xJN != null) {
            context.unregisterReceiver(mMAppMgr.xJN);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onConfigurationChanged(configuration);
        }
        Resources resources = ac.getResources();
        if (resources instanceof com.tencent.mm.bw.a) {
            ((com.tencent.mm.bw.a) resources).cdY();
        }
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        x.i(TAG, "onTrimMemory, level = %d, process = %s", new Object[]{Integer.valueOf(i), ac.Br()});
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTrimMemory(i);
        }
    }

    public void onCreate() {
    }

    public void onBaseContextAttached(Context context) {
    }
}

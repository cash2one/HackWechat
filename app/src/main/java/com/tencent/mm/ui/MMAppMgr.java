package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.LocationManager;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.provider.Settings.Secure;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.R;
import com.tencent.mm.ad.m;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.aq.o;
import com.tencent.mm.be.e;
import com.tencent.mm.be.e.1;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.z;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.g.a.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.b.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bo;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Map;

public final class MMAppMgr {
    static StringBuffer xJK;
    private static long xJL;
    long hOl;
    String xJM;
    public Receiver xJN;
    boolean xJO = false;
    boolean xJP = false;
    final ak xJQ = new ak(new 1(this), true);
    private final ak xJR = new ak(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ MMAppMgr xJS;

        {
            this.xJS = r1;
        }

        public final boolean uF() {
            if (this.xJS.xJP == this.xJS.xJO) {
                x.d("MicroMsg.MMAppMgr", "status not changed, cur=" + this.xJS.xJP);
                return true;
            } else if (ar.GZ()) {
                return false;
            } else {
                this.xJS.xJP = this.xJS.xJO;
                BaseEvent.onForeground(this.xJS.xJP);
                com.tencent.mm.aj.a.bK(this.xJS.xJP);
                b lVar;
                if (this.xJS.xJP) {
                    x.w("MicroMsg.MMAppMgr", "[ACTIVATED MODE]");
                    WorkerProfile.uv();
                    ar.CG().bD(true);
                    if (ar.Hj() && g.Dh().gPy && !ar.Cs()) {
                        z zVar = z.gyU;
                        if (!zVar.hasInit) {
                            Map chI;
                            zVar.hasInit = true;
                            c fn = com.tencent.mm.z.c.c.IF().fn("100066");
                            if (fn.isValid()) {
                                chI = fn.chI();
                                zVar.gzg = t.getInt((String) chI.get("maxCacheCount"), 20);
                                zVar.gzh = t.getInt((String) chI.get("maxCacheHours"), 24);
                            }
                            fn = com.tencent.mm.z.c.c.IF().fn("100058");
                            if (fn.isValid()) {
                                chI = fn.chI();
                                zVar.gzi = t.getInt((String) chI.get("cacheLogCount"), 30);
                                zVar.gzj = t.getInt((String) chI.get("maxCacheTime"), 10800);
                            }
                            x.i("MicroMsg.StayTimeReport", "initAbtestChattingArg appMaxCnt:%d, appMaxHour:%d, chattingMaxCnt:%d, chattingMaxSeconds:%d", Integer.valueOf(zVar.gzg), Integer.valueOf(zVar.gzh), Integer.valueOf(zVar.gzi), Integer.valueOf(zVar.gzj));
                        }
                        f.bS(true);
                        q.Qc().id(3);
                        ar.CG().a(new j(), 0);
                        com.tencent.mm.blink.b.wo().f(new 1(this));
                        bo.HS().c(19, new Object[]{Integer.valueOf(1)});
                        e SL = e.SL();
                        x.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
                        SL.hxL.lD(true);
                        o.Py().bD(true);
                        if (com.tencent.mm.pluginsdk.q.z.vcD != null) {
                            com.tencent.mm.pluginsdk.q.z.vcD.bDV();
                        }
                        lVar = new l();
                        lVar.fnh.fni = true;
                        com.tencent.mm.sdk.b.a.xef.m(lVar);
                        com.tencent.mm.modelstat.o.iC(4);
                        com.tencent.mm.modelstat.o.iC(3);
                        com.tencent.mm.modelstat.o.bV(true);
                        lVar = new rd();
                        lVar.fIS.fIT = true;
                        lVar.fIS.scene = 1;
                        com.tencent.mm.sdk.b.a.xef.m(lVar);
                        lVar = new tv();
                        lVar.fMD.fpr = 5;
                        com.tencent.mm.sdk.b.a.xef.m(lVar);
                    }
                    ar.CG().bC(false);
                    ac.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", false).commit();
                    if (this.xJS.xJQ.cfK()) {
                        return true;
                    }
                    this.xJS.xJQ.TG();
                    return true;
                }
                x.w("MicroMsg.MMAppMgr", "[DEACTIVATED MODE]");
                WorkerProfile.uv();
                this.xJS.hOl = bh.Wq();
                this.xJS.xJM = "desktop";
                lVar = new l();
                lVar.fnh.fni = false;
                com.tencent.mm.sdk.b.a.xef.m(lVar);
                ar.CG().bD(false);
                if (ar.Hj()) {
                    g.Dk();
                    if (g.Dh().gPy) {
                        boolean z;
                        com.tencent.mm.bn.a.Ti(com.tencent.mm.bn.a.ccX());
                        Looper.myQueue().addIdleHandler(new 1(e.SL()));
                        lVar = new nc();
                        lVar.fFc.state = 0;
                        com.tencent.mm.sdk.b.a.xef.m(lVar);
                        com.tencent.mm.sdk.b.a.xef.m(new rq());
                        lVar = new com.tencent.mm.g.a.e();
                        lVar.fmQ.fmR = false;
                        com.tencent.mm.sdk.b.a.xef.m(lVar);
                        lVar = new nx();
                        lVar.fFQ.ahf = false;
                        com.tencent.mm.sdk.b.a.xef.m(lVar);
                        o.Py().bD(false);
                        x.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod]");
                        ar.Hg();
                        Object obj = com.tencent.mm.z.c.CU().get(327808, null);
                        if (obj == null) {
                            z = true;
                        } else if (bh.ov(obj.toString())) {
                            z = true;
                        } else {
                            z = System.currentTimeMillis() - bh.VJ(obj.toString()) >= 604800000;
                        }
                        x.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod] needToStat:%s", String.valueOf(z));
                        if (z) {
                            try {
                                com.tencent.mm.plugin.report.service.g.pQN.k(11375, bh.ou(Secure.getString(ac.getContext().getContentResolver(), "default_input_method")));
                                ar.Hg();
                                com.tencent.mm.z.c.CU().set(327808, Long.valueOf(System.currentTimeMillis()));
                            } catch (Exception e) {
                                x.e("MicroMsg.MMAppMgr", "[oneliang][inputMethodStat]exception:" + e.getMessage());
                            }
                        }
                        lVar = new co();
                        lVar.fqN.state = 0;
                        com.tencent.mm.sdk.b.a.xef.m(lVar);
                        lVar = new tv();
                        lVar.fMD.fpr = 3;
                        com.tencent.mm.sdk.b.a.xef.m(lVar);
                        f.bS(false);
                        com.tencent.mm.modelstat.o.bV(false);
                    }
                }
                if (!this.xJS.xJQ.cfK()) {
                    this.xJS.xJQ.TG();
                }
                x.i("MicroMsg.MMAppMgr", "before kill tools, tools is running : %b", Boolean.valueOf(bh.bj(ac.getContext(), ac.getPackageName() + ":tools")));
                if (!bh.bj(ac.getContext(), ac.getPackageName() + ":tools")) {
                    return true;
                }
                this.xJS.xJQ.J(60000, 60000);
                return true;
            }
        }
    }, false);

    static /* synthetic */ void a(MMAppMgr mMAppMgr, Intent intent, boolean z) {
        String stringExtra = intent.getStringExtra("classname");
        if (bh.ov(stringExtra)) {
            x.i("MicroMsg.MMAppMgr", "dealWithClickStream className is null, broadcast should set this intent flag");
            return;
        }
        stringExtra = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        com.tencent.mm.sdk.a.b.UH(stringExtra);
        if (xJK == null) {
            xJK = new StringBuffer(800);
            xJL = bh.Wo();
            xJK.append("start:");
            xJK.append(bh.Wo());
            xJK.append("|");
        }
        if (z) {
            if ("desktop".equals(mMAppMgr.xJM)) {
                xJK.append("desktop:");
                xJK.append(bh.bA(mMAppMgr.hOl) + 800);
                xJK.append("|");
            }
            mMAppMgr.hOl = bh.Wq();
            mMAppMgr.xJM = stringExtra;
        } else {
            xJK.append(mMAppMgr.xJM + ":");
            xJK.append(bh.bA(mMAppMgr.hOl));
            xJK.append("|");
        }
        b fVar = new com.tencent.mm.g.a.f();
        fVar.fmS.ahf = z;
        fVar.fmS.className = stringExtra;
        com.tencent.mm.sdk.b.a.xef.m(fVar);
        x.i("MicroMsg.MMAppMgr", "dkact classname %s, isAcitvity %b", stringExtra, Boolean.valueOf(z));
    }

    public final void e(Intent intent, boolean z) {
        b ncVar;
        String str;
        if (z) {
            m.JK();
            ncVar = new nc();
            ncVar.fFc.state = 1;
            com.tencent.mm.sdk.b.a.xef.m(ncVar);
            ncVar = new com.tencent.mm.g.a.e();
            ncVar.fmQ.fmR = true;
            com.tencent.mm.sdk.b.a.xef.m(ncVar);
            ncVar = new nx();
            ncVar.fFQ.ahf = true;
            com.tencent.mm.sdk.b.a.xef.m(ncVar);
            ncVar = new co();
            ncVar.fqN.state = 1;
            com.tencent.mm.sdk.b.a.xef.m(ncVar);
        }
        ncVar = new fr();
        ncVar.fvb.fni = z;
        com.tencent.mm.sdk.b.a.xef.m(ncVar);
        this.xJO = z;
        String stringExtra = intent.getStringExtra("classname");
        if (bh.ov(stringExtra)) {
            str = "";
        } else {
            str = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        }
        z zVar;
        if (z) {
            zVar = z.gyU;
            if (zVar.gzf == -1) {
                if (zVar.gyV.Dl(3) == 0) {
                    zVar.gyV.setLong(1, t.Wo());
                }
                zVar.gzf = t.Wo();
                String str2 = "MicroMsg.StayTimeReport";
                String str3 = "onAppResume chatUser:%s, class:%s";
                Object[] objArr = new Object[2];
                objArr[0] = zVar.gyY == null ? "null" : zVar.gyY.gzl;
                objArr[1] = str;
                x.i(str2, str3, objArr);
                if (zVar.gyY != null) {
                    zVar.gzc = t.Wq();
                    if (str != null && str.contains("WebViewUI")) {
                        zVar.gzd = t.Wq();
                    }
                }
            }
        } else {
            zVar = z.gyU;
            if (zVar.gzf != -1) {
                stringExtra = ((String) zVar.gyV.get(2, "")) + zVar.gzf + "|" + t.Wo() + "#";
                zVar.gyV.set(2, stringExtra);
                int Dl = zVar.gyV.Dl(3) + 1;
                zVar.gyV.setInt(3, Dl);
                x.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", Integer.valueOf(Dl), Long.valueOf(zVar.gzf), Long.valueOf(r4));
                zVar.gzf = -1;
                if (t.by(zVar.gyV.getLong(1, 0)) > 3600 * ((long) zVar.gzh) || Dl > zVar.gzg) {
                    com.tencent.mm.plugin.report.service.g.pQN.k(13110, stringExtra);
                    x.i("MicroMsg.StayTimeReport", "report appStayTime:%s", stringExtra);
                    zVar.gyV.set(2, "");
                    zVar.gyV.setInt(3, 0);
                }
                if (zVar.gyY != null) {
                    z.a aVar = zVar.gyY;
                    aVar.time += t.bA(zVar.gzc) / 1000;
                    if (str != null && str.contains("WebViewUI")) {
                        aVar = zVar.gyY;
                        aVar.gzp = (int) (((long) aVar.gzp) + (t.bA(zVar.gzd) / 1000));
                    }
                    x.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", Long.valueOf(zVar.gyY.time));
                }
            }
        }
        this.xJR.J(800, 800);
    }

    public static void cnc() {
        StringBuffer stringBuffer = new StringBuffer(800);
        if (xJK == null) {
            xJK = stringBuffer;
            xJL = bh.Wo();
            return;
        }
        String stringBuffer2 = xJK.toString();
        stringBuffer.append(Yn(stringBuffer2));
        xJK = stringBuffer;
        x.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", stringBuffer2);
        com.tencent.mm.plugin.report.service.g.pQN.k(10508, "1," + xJL + "," + stringBuffer2);
        xJL = bh.Wo();
    }

    private static String Yn(String str) {
        int i = 0;
        int length = str.length() - 1;
        while (length >= 0) {
            if (str.charAt(length) == '|') {
                i++;
            }
            if (i == 3) {
                break;
            }
            length--;
        }
        return str.substring(length + 1);
    }

    public static void cancelNotification(String str) {
        ar.getNotification().cancelNotification(str);
    }

    public static void up() {
        ar.getNotification().up();
    }

    public static void adg() {
        lW(true);
    }

    public static void lW(boolean z) {
        x.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), bh.cgy(), Boolean.valueOf(z));
        d.n(2, 0, "");
        if (z) {
            Context context = ac.getContext();
            if (context != null) {
                context.stopService(new Intent(context, CoreService.class));
                context.stopService(new Intent(context, NotifyService.class));
                context.stopService(new Intent(context, CacheService.class));
                context.stopService(new Intent().setClassName(context, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"));
            }
        }
        com.tencent.mm.sdk.b.a.xef.m(new w());
        b izVar = new iz();
        izVar.fzC.status = 0;
        izVar.fzC.aAk = 2;
        com.tencent.mm.sdk.b.a.xef.m(izVar);
        cnc();
        if (z) {
            ar.fG(bh.cgy().toString());
            g.Dk().releaseAll();
        }
        x.appenderClose();
        BaseEvent.onSingalCrash(0);
        com.tencent.mm.bp.a.e(ac.getContext(), new String[]{"com.tencent.mm:recovery", "com.tencent.mm:support", "com.tencent.mm:tools", "com.tencent.mm:appbrand0", "com.tencent.mm:appbrand1", "com.tencent.mm:appbrand2", "com.tencent.mm:appbrand3", "com.tencent.mm:appbrand4"});
        Process.killProcess(Process.myPid());
    }

    public static void ar(Context context) {
        b(context, true);
    }

    public static void b(Context context, boolean z) {
        g.Dk().gQE.gQZ.aG(z);
        BaseEvent.onSingalCrash(0);
        MMNativeJpeg.Destroy();
        com.tencent.mm.booter.o.us();
        if (!(ar.CG() == null || ar.CG().hmV == null)) {
            ar.CG().hmV.bG(z);
        }
        Intent intent = new Intent().setClass(context, LauncherUI.class);
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        intent.putExtra("kill_service", z);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    public static void W(Activity activity) {
        com.tencent.mm.bm.d.b(activity, "whatsnew", ".ui.WhatsNewUI", new Intent(), 57005);
    }

    public static void ft(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ac.cfs(), 0);
        if (!sharedPreferences.getBoolean("Main_ShortCut", false)) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", context.getString(R.l.esK));
            intent.putExtra("duplicate", false);
            Parcelable intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(context.getPackageName(), ac.cfr() + ".ui.LauncherUI"));
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, R.g.icon));
            intent.putExtra("shortcut_icon_resource_id", R.g.icon);
            intent.putExtra("shortcut_is_adaptive_icon", true);
            intent.putExtra("is_main_shortcut", true);
            com.tencent.mm.plugin.base.model.b.o(context, intent);
            Editor edit = sharedPreferences.edit();
            edit.putBoolean("Main_ShortCut", true);
            edit.commit();
        }
    }

    public static boolean a(final Activity activity, OnClickListener onClickListener) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(ac.cfs(), 0);
        boolean z = sharedPreferences.getBoolean("gprs_alert", true);
        com.tencent.mm.sdk.platformtools.f.xeB &= z;
        if (z) {
            View inflate = View.inflate(activity, R.i.dlw, null);
            Context context = activity;
            Dialog a = h.a(context, false, null, inflate, activity.getString(R.l.dUc), activity.getString(R.l.euw), new 2((CheckBox) inflate.findViewById(R.h.cnR), sharedPreferences, activity, onClickListener), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    MMAppMgr.b(activity, true);
                }
            });
            if (a == null) {
                return false;
            }
            a.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    activity.onKeyDown(4, new KeyEvent(0, 4));
                }
            });
        }
        return z;
    }

    public static boolean a(Context context, int i, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z;
        View inflate = View.inflate(context, R.i.doW, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.czj);
        checkBox.setText(context.getString(R.l.exJ));
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(16385, Boolean.valueOf(!z));
            }
        });
        inflate.findViewById(R.h.czl).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.h.czk);
        switch (i) {
            case 1:
                textView.setText(R.l.exI);
                z = true;
                break;
            case 3:
                textView.setText(R.l.exP);
                z = false;
                break;
            default:
                textView.setText(R.l.exP);
                z = true;
                break;
        }
        if (!z) {
            return false;
        }
        i.a aVar = new i.a(context);
        aVar.Ez(R.l.dGO);
        aVar.mi(false);
        aVar.dk(inflate);
        aVar.EC(R.l.exM).a(onClickListener);
        aVar.ED(R.l.exJ).b(onClickListener2);
        aVar.akx().show();
        return true;
    }

    public static i as(final Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (an.isWifi(context) && locationManager.isProviderEnabled("gps")) {
                return null;
            }
            ar.Hg();
            Boolean bool = (Boolean) com.tencent.mm.z.c.CU().get(4105, Boolean.valueOf(false));
            if (bool != null && bool.booleanValue()) {
                return null;
            }
            View inflate = View.inflate(context, R.i.dmD, null);
            ((CheckBox) inflate.findViewById(R.h.csI)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.Hg();
                        com.tencent.mm.z.c.CU().set(4105, Boolean.valueOf(true));
                        return;
                    }
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(4105, Boolean.valueOf(false));
                }
            });
            OnClickListener anonymousClass7 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.MMAppMgr", e, "showLbsTipsAlert", new Object[0]);
                    }
                }
            };
            i.a aVar = new i.a(context);
            aVar.Ez(R.l.exq);
            aVar.dk(inflate);
            aVar.EC(R.l.dGD).a(anonymousClass7);
            aVar.ED(R.l.dFu);
            i akx = aVar.akx();
            akx.show();
            return akx;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMAppMgr", e, "showLbsTipsAlert error", new Object[0]);
            return null;
        }
    }
}

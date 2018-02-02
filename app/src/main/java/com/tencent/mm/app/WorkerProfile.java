package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.t;
import com.tencent.mm.ae.t.a;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.console.Shell;
import com.tencent.mm.console.Shell.Receiver;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import com.tencent.mm.z.ai;
import com.tencent.mm.z.aj;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.d.a.2;
import com.tencent.mm.z.f;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

public final class WorkerProfile extends e implements com.tencent.mm.ae.e, a, IKVReportNotify, ai, f.a {
    public static final String ffc = (ac.getPackageName());
    private static WorkerProfile fgi;
    private final Shell ffG = new Shell();
    private final com.tencent.mm.console.a fgh = new com.tencent.mm.console.a();
    private aj fgj;
    private b fgk;
    private com.tencent.mm.z.ac fgl;
    private boolean fgm;
    private boolean fgn = false;
    @Deprecated
    public boolean fgo;
    public boolean fgp;
    private final int fgq = 0;
    private final int fgr = 1;
    private int fgs;
    private final int fgt = 2130706432;
    private StringBuilder fgu = new StringBuilder();
    private g fgv;
    private com.tencent.mm.h.b fgw;
    public final q fgx = new q();
    public final p fgy = new p();
    protected Locale locale;

    public WorkerProfile() {
        fgi = this;
    }

    public static WorkerProfile uu() {
        return fgi;
    }

    public static void uv() {
    }

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        a.cl(ffc);
        x.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
        x.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + ffc + Process.myPid());
        x.i("MicroMsg.WorkerProfile", "appOnCreate start getAccStg %b, thread name %s", new Object[]{Boolean.valueOf(true), Thread.currentThread().getName()});
        long currentTimeMillis2 = System.currentTimeMillis();
        com.tencent.mm.z.d.a II = com.tencent.mm.z.d.a.II();
        com.tencent.mm.z.d.a.ffs = ffc;
        if (ac.xft) {
            x.i("MicroMsg.HandlerTraceManager", "trace setup delete old file ret: " + com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.z.d.a.hiH));
        }
        II.hiW = System.currentTimeMillis();
        af.setLogCallback(new a$1(II));
        com.tencent.mm.sdk.platformtools.aj.a("NetsceneQueue forbid in ", new 2(II));
        ar.CG().a(-1, this);
        t.a(this);
        ar.Hk().heW = this;
        ar.a(new 1(this));
        ar.getSysCmdMsgExtension().a("getkvidkeystg", new 12(this), true);
        Context context = this.app;
        com.tencent.mm.sdk.platformtools.f.eH(context);
        com.tencent.mm.sdk.platformtools.f.eI(context);
        try {
            com.tencent.mm.c.a aVar;
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            x.i("MicroMsg.WorkerProfile", "initChannelUtil sourceFile = %s", new Object[]{str});
            try {
                int bN = com.tencent.mm.a.e.bN(str);
                x.i("MicroMsg.WorkerProfile", "checkApkExternal, fileSize = %s", new Object[]{Integer.valueOf(bN)});
                if (bN >= 8) {
                    com.tencent.mm.c.a.a w = com.tencent.mm.c.a.a.w(com.tencent.mm.a.e.e(str, bN - 8, 8));
                    if (w == null) {
                        x.e("MicroMsg.WorkerProfile", "checkApkExternal, header null");
                    } else if ((w.fdR + 8) - 8 >= 0) {
                        com.tencent.mm.c.b bVar = new com.tencent.mm.c.b();
                        bVar.aF(com.tencent.mm.a.e.e(str, (bN - ((w.fdR + 8) - 8)) - 8, (w.fdR + 8) - 8));
                        aVar = new com.tencent.mm.c.a(bVar);
                        x.i("MicroMsg.WorkerProfile", "checkApkExternal, check ok");
                    } else {
                        x.e("MicroMsg.WorkerProfile", "checkApkExternal header wrong");
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                x.e("MicroMsg.WorkerProfile", "Exception in checkApkExternal, %s", new Object[]{e.getMessage()});
            } catch (NameNotFoundException e2) {
                x.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
            }
            aVar = com.tencent.mm.c.a.cg(str);
            c aA;
            int i;
            int i2;
            SharedPreferences sharedPreferences;
            int i3;
            int i4;
            Editor edit;
            Shell shell;
            Context context2;
            j.a bVar2;
            com.tencent.mm.h.b bVar3;
            com.tencent.mm.l.a.a 26;
            com.tencent.mm.plugin.report.service.g gVar;
            Object[] objArr;
            if (aVar == null || aVar.fdP == null) {
                str = "MicroMsg.WorkerProfile";
                String str2 = "initChannelUtil something null %s";
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(aVar == null);
                x.e(str, str2, objArr2);
                c.tK();
                aA = c.aA(this.app);
                if (!(aA == null || aA.gyb == -1)) {
                    com.tencent.mm.sdk.platformtools.f.fdS = aA.gyb;
                }
                context = this.app.getApplicationContext();
                i = com.tencent.mm.sdk.platformtools.f.fdS;
                i2 = d.vAz;
                if (context != null && i >= 0 && i2 >= 637534208) {
                    try {
                        sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                        i3 = sharedPreferences.getInt("channel", -1);
                        i4 = sharedPreferences.getInt("version", 0);
                        if (!(i3 == i && i4 == i2)) {
                            edit = sharedPreferences.edit();
                            edit.putInt("channel", i);
                            edit.putInt("version", i2);
                            edit.commit();
                        }
                    } catch (Throwable th) {
                    }
                }
                if (com.tencent.mm.sdk.platformtools.f.xey > 0) {
                    com.tencent.mm.sdk.platformtools.f.xeA = true;
                }
                com.tencent.mm.bm.d.ccW();
                d.DEVICE_TYPE = "android-" + (bh.ov(com.tencent.mm.sdk.platformtools.f.fdT) ? Integer.valueOf(VERSION.SDK_INT) : com.tencent.mm.sdk.platformtools.f.fdT);
                if (!bh.ov(com.tencent.mm.sdk.a.b.ceL())) {
                    d.DEVICE_TYPE = "android-" + com.tencent.mm.sdk.a.b.ceL();
                }
                x.v("MicroMsg.WorkerProfile", "set device type :%s  %s", new Object[]{d.DEVICE_TYPE, com.tencent.mm.sdk.a.b.ceL()});
                this.locale = MMActivity.initLanguage(this.app.getBaseContext());
                if (com.tencent.mm.sdk.a.b.ceK()) {
                    shell = this.ffG;
                    context2 = ac.getContext();
                    if (shell.gIF == null) {
                        shell.gIF = new Receiver();
                        context2.registerReceiver(shell.gIF, Shell.gIH);
                    }
                }
                com.tencent.mm.sdk.b.a.xef.b(this.fgh);
                bVar2 = new b();
                x.d("MicroMsg.AvatarDrawable", "setLoader" + bVar2);
                com.tencent.mm.pluginsdk.ui.a.b.plt = bVar2;
                q.a.vcr = new 25(this);
                com.tencent.mm.kernel.g.a(o.class, new com.tencent.mm.kernel.c.d(this.fgy));
                com.tencent.mm.kernel.g.a(h.class, new com.tencent.mm.kernel.c.d(this.fgy));
                com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.j.class, new com.tencent.mm.kernel.c.d(this.fgy));
                com.tencent.mm.sdk.b.a.xef.b(new com.tencent.mm.app.plugin.b.a.a());
                if (this.fgj == null) {
                    this.fgj = new com.tencent.mm.booter.notification.b(this.app);
                }
                this.fgw = new com.tencent.mm.h.b();
                bVar3 = this.fgw;
                x.i("MicroMsg.BroadcastController", "summerdiz init");
                com.tencent.mm.sdk.b.a.xef.b(bVar3.gBc);
                if (this.fgm) {
                    a(null);
                    this.fgm = false;
                }
                com.tencent.mm.sdk.b.a.xef.b(new com.tencent.mm.kiss.a.b.2(com.tencent.mm.kiss.a.b.DY()));
                com.tencent.mm.sdk.b.a.xef.a(new 23(this));
                com.tencent.mm.sdk.b.a.xef.b(new com.tencent.mm.ui.bindqq.a());
                com.tencent.mm.sdk.b.a.xef.b(new com.tencent.mm.sdk.b.c<iz>(this) {
                    final /* synthetic */ WorkerProfile fgz;

                    {
                        this.fgz = r2;
                        this.xen = iz.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        iz izVar = (iz) bVar;
                        if (izVar.fzC.aAk != 2 && izVar.fzC.status == 0) {
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(com.tencent.mm.ui.e.h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE");
                            ac.getContext().sendBroadcast(intent);
                        }
                        if (ar.Hj()) {
                            if (izVar.fzC.aAk == 3) {
                                aq.hfP.S("login_user_name", "");
                            } else {
                                aq aqVar = aq.hfP;
                                ar.Hg();
                                String str = (String) com.tencent.mm.z.c.CU().get(6, null);
                                ar.Hg();
                                int intValue = ((Integer) com.tencent.mm.z.c.CU().get(9, null)).intValue();
                                ar.Hg();
                                aqVar.c(str, intValue, (String) com.tencent.mm.z.c.CU().get(5, null));
                            }
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xef.b(new 30(this));
                com.tencent.mm.sdk.b.a.xef.b(new 31(this));
                com.tencent.mm.sdk.b.a.xef.b(new 32(this));
                com.tencent.mm.sdk.b.a.xef.b(new 33(this));
                com.tencent.mm.sdk.b.a.xef.b(new 34(this));
                com.tencent.mm.sdk.b.a.xef.b(new 2(this));
                com.tencent.mm.sdk.b.a.xef.b(new 3(this));
                com.tencent.mm.sdk.b.a.xef.b(new 4(this));
                com.tencent.mm.sdk.b.a.xef.b(new 5(this));
                com.tencent.mm.sdk.b.a.xef.b(new com.tencent.mm.sdk.b.c<qv>(this) {
                    final /* synthetic */ WorkerProfile fgz;

                    {
                        this.fgz = r2;
                        this.xen = qv.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        qv qvVar = (qv) bVar;
                        Context context = qvVar.fIF.context;
                        String str = qvVar.fIF.fIG;
                        if (!(context == null || bh.ov(str))) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xef.b(new 7(this));
                com.tencent.mm.sdk.b.a.xef.b(new 8(this));
                com.tencent.mm.sdk.b.a.xef.b(new com.tencent.mm.sdk.b.c<er>(this) {
                    final /* synthetic */ WorkerProfile fgz;

                    {
                        this.fgz = r2;
                        this.xen = er.class.getName().hashCode();
                    }

                    private static boolean a(er erVar) {
                        if (erVar == null) {
                            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is null.");
                            return false;
                        } else if (!(erVar instanceof er)) {
                            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is not a instance of ExtCallBizEvent.");
                            return false;
                        } else if (erVar.fti == null) {
                            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event.data is null.");
                            return false;
                        } else {
                            Intent intent;
                            switch (erVar.fti.op) {
                                case 27:
                                    if (erVar.fti.selectionArgs == null || erVar.fti.selectionArgs.length < 2) {
                                        x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent selectionArgs error.");
                                        return true;
                                    }
                                    Object encode;
                                    String str = "";
                                    Object obj = erVar.fti.selectionArgs[0];
                                    String str2 = erVar.fti.selectionArgs[1];
                                    if (erVar.fti.selectionArgs.length >= 3) {
                                        Object ou = bh.ou(erVar.fti.selectionArgs[2]);
                                        try {
                                            encode = URLEncoder.encode(ou, "UTF-8");
                                        } catch (UnsupportedEncodingException e) {
                                            encode = ou;
                                        }
                                    } else {
                                        String str3 = str;
                                    }
                                    if (obj == null || str2 == null) {
                                        x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent wrong args, %s, %s", new Object[]{obj, str2});
                                        return true;
                                    }
                                    int i;
                                    if (erVar.fti.selectionArgs.length >= 4) {
                                        str = erVar.fti.selectionArgs[3];
                                        if (!bh.ov(str)) {
                                            i = bh.getInt(str, 0);
                                            x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
                                            str = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{str2, obj, encode, Integer.valueOf(i), Integer.valueOf(0)});
                                            intent = new Intent(erVar.fti.context, WXCustomSchemeEntryActivity.class);
                                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                            intent.setData(Uri.parse(str));
                                            intent.putExtra("translate_link_scene", 1);
                                            erVar.fti.context.startActivity(intent);
                                            return true;
                                        }
                                    }
                                    i = 0;
                                    x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
                                    str = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{str2, obj, encode, Integer.valueOf(i), Integer.valueOf(0)});
                                    intent = new Intent(erVar.fti.context, WXCustomSchemeEntryActivity.class);
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    intent.setData(Uri.parse(str));
                                    intent.putExtra("translate_link_scene", 1);
                                    erVar.fti.context.startActivity(intent);
                                    return true;
                                case 28:
                                    x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent open exdevice rank list.");
                                    Context context = erVar.fti.context;
                                    intent = new Intent(context, WXBizEntryActivity.class);
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    intent.putExtra("key_command_id", 11);
                                    context.startActivity(intent);
                                    return true;
                                default:
                                    return AnonymousClass9.a(erVar.fti.context, erVar.fti.selectionArgs, erVar.fti.fmW, erVar.fti.cOY, erVar.fti.ftj);
                            }
                        }
                    }

                    private static boolean a(Context context, String[] strArr, String[] strArr2, int i, String str) {
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:context is null.");
                            context = ac.getContext();
                        }
                        if (strArr == null || strArr.length < 2) {
                            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:args error.");
                            return false;
                        }
                        int length = strArr.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            x.i("MicroMsg.WorkerProfile", "arg : %s", new Object[]{strArr[i2]});
                        }
                        String str2 = strArr[0];
                        String str3 = strArr[1];
                        String str4 = null;
                        if (strArr.length > 2) {
                            str4 = strArr[2];
                        }
                        length = 0;
                        if (strArr.length > 3) {
                            length = bh.getInt(strArr[3], 0);
                        }
                        int i3 = 0;
                        if (strArr.length > 4) {
                            i3 = bh.getInt(strArr[4], 0);
                        }
                        x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source(%d)", new Object[]{Integer.valueOf(i)});
                        switch (i) {
                            case 1:
                                if (strArr2 == null || strArr2.length == 0) {
                                    x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:packageNames is null or nil.");
                                    return false;
                                }
                            case 2:
                                if (bh.ov(str)) {
                                    x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:fromURL(%s) is null or nil.", new Object[]{str});
                                    return false;
                                }
                                break;
                            default:
                                x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source is out of range.");
                                return false;
                        }
                        x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener: appId(%s), toUserName(%s), extInfo(%s), fromURL(%s)", new Object[]{str2, str3, str4, str});
                        if (bh.ov(str2) || bh.ov(str3)) {
                            x.e("MicroMsg.WorkerProfile", "appId or toUsername is null or nil.");
                            return false;
                        }
                        int i4 = 0;
                        if (length == 1) {
                            i4 = 8;
                        } else if (length == 0) {
                            i4 = 7;
                        }
                        Intent intent = new Intent(context, WXBizEntryActivity.class);
                        intent.putExtra("key_command_id", i4);
                        intent.putExtra("appId", str2);
                        intent.putExtra("toUserName", str3);
                        intent.putExtra("extInfo", str4);
                        intent.putExtra("source", i);
                        intent.putExtra("scene", length);
                        intent.putExtra("jump_profile_type", i3);
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864);
                        if (strArr2 != null && strArr2.length > 0) {
                            ArrayList arrayList = new ArrayList();
                            for (Object add : strArr2) {
                                arrayList.add(add);
                            }
                            intent.putStringArrayListExtra("androidPackNameList", arrayList);
                        }
                        context.startActivity(intent);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xef.b(new 10(this));
                com.tencent.mm.sdk.b.a.xef.b(new com.tencent.mm.sdk.b.c<nq>(this) {
                    final /* synthetic */ WorkerProfile fgz;

                    {
                        this.fgz = r2;
                        this.xen = nq.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        cf cfVar = ((nq) bVar).fFG.fnB;
                        if (cfVar != null) {
                            x.i("MicroMsg.WorkerProfile", "resend msg, type:%d", new Object[]{Integer.valueOf(cfVar.getType())});
                            if (cfVar.ciW()) {
                                com.tencent.mm.ui.chatting.af.aD(cfVar);
                            } else if (cfVar.cje()) {
                                com.tencent.mm.ui.chatting.af.aE(cfVar);
                            } else if (cfVar.cjj()) {
                                com.tencent.mm.ui.chatting.af.aF(cfVar);
                            } else if (cfVar.cjg()) {
                                com.tencent.mm.ui.chatting.af.aH(cfVar);
                            } else if (cfVar.aNe()) {
                                com.tencent.mm.ui.chatting.af.aI(cfVar);
                            } else if (cfVar.cjk()) {
                                com.tencent.mm.ui.chatting.af.aG(cfVar);
                            } else if (cfVar.aNc()) {
                                x.i("MicroMsg.ResendMsgLogic", "resendAppMsg, msgId:%d", new Object[]{Long.valueOf(cfVar.field_msgId)});
                                r0 = ba.hR(cfVar.field_talker);
                                if (r0 == cfVar.field_createTime) {
                                    r0++;
                                }
                                cfVar.aq(r0);
                                ar.Hg();
                                com.tencent.mm.z.c.Fa().a(cfVar.field_msgId, cfVar);
                                String str = cfVar.field_content;
                                int i = cfVar.field_isSend;
                                String str2 = cfVar.field_talker;
                                boolean z = s.gA(str2) || m.gd(str2);
                                if (z && str != null && i == 0) {
                                    str = ba.hQ(str);
                                }
                                com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(str);
                                if ((fT == null || 19 != fT.type) && (fT == null || 24 != fT.type)) {
                                    l.aa(cfVar);
                                } else {
                                    com.tencent.mm.sdk.b.b mtVar = new mt();
                                    mtVar.fEE.type = 4;
                                    mtVar.fEE.fEJ = cfVar;
                                    mtVar.fEE.toUser = cfVar.field_talker;
                                    com.tencent.mm.sdk.b.a.xef.m(mtVar);
                                }
                                ba.aK(cfVar.field_msgId);
                            } else if (cfVar.cjf()) {
                                com.tencent.mm.ui.chatting.af.aJ(cfVar);
                            } else if (cfVar.cjh() || cfVar.cji()) {
                                r0 = ba.hR(cfVar.field_talker);
                                if (r0 == cfVar.field_createTime) {
                                    r0++;
                                }
                                cfVar.aq(r0);
                                ar.Hg();
                                com.tencent.mm.z.c.Fa().a(cfVar.field_msgId, cfVar);
                                r nr = com.tencent.mm.modelvideo.o.TU().nr(cfVar.field_imgPath);
                                if (nr != null) {
                                    nr.hVE = cfVar.field_createTime;
                                    nr.fDt = FileUtils.S_IWUSR;
                                    com.tencent.mm.modelvideo.o.TU().b(nr);
                                    x.i("MicroMsg.ResendMsgLogic", "resendVideoMsg, msgId:%d, msgtime: %d, infotime:%d", new Object[]{Long.valueOf(cfVar.field_msgId), Long.valueOf(cfVar.field_createTime), Long.valueOf(nr.hVE)});
                                }
                                ar.Hg();
                                if (com.tencent.mm.z.c.isSDCardAvailable()) {
                                    com.tencent.mm.modelvideo.t.nE(cfVar.field_imgPath);
                                } else {
                                    u.fI(ac.getContext());
                                }
                            } else {
                                cfVar.eQ(5);
                                ar.Hg();
                                com.tencent.mm.z.c.Fa().a(cfVar.field_msgId, cfVar);
                                x.e("MicroMsg.WorkerProfile", "resendMsg, unknown msg type");
                            }
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xef.b(new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.h>(this) {
                    final /* synthetic */ WorkerProfile fgz;

                    {
                        this.fgz = r2;
                        this.xen = com.tencent.mm.g.a.h.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        String str = null;
                        com.tencent.mm.g.a.h hVar = (com.tencent.mm.g.a.h) bVar;
                        Context context = hVar.fmV.context;
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "add card to wx event, context is null");
                            return false;
                        }
                        String str2;
                        String str3;
                        String str4;
                        String str5;
                        String[] strArr = hVar.fmV.fmW;
                        if (strArr == null || strArr.length <= 0) {
                            str2 = null;
                            str3 = null;
                        } else {
                            str3 = strArr[0];
                            str2 = com.tencent.mm.a.g.s(p.aX(hVar.fmV.context, strArr[0])[0].toByteArray());
                        }
                        String[] strArr2 = hVar.fmV.selectionArgs;
                        if (strArr2 == null || strArr2.length <= 1) {
                            str4 = null;
                            str5 = null;
                        } else {
                            str4 = strArr2[0];
                            str5 = strArr2[1];
                        }
                        if (strArr2 != null && strArr2.length > 2) {
                            str = strArr2[2];
                        }
                        x.i("MicroMsg.WorkerProfile", "carlist = %s, appid = %s, transcation = %s", new Object[]{str5, str4, str});
                        Intent intent = new Intent(context, WXBizEntryActivity.class);
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(134217728).addFlags(67108864);
                        intent.putExtra("key_in_card_list", str5);
                        intent.putExtra("key_package_name", str3);
                        intent.putExtra("key_sign", str2);
                        intent.putExtra("key_from_scene", 8);
                        intent.putExtra("key_command_id", 9);
                        intent.putExtra("key_app_id", str4);
                        intent.putExtra("key_transaction", str);
                        context.startActivity(intent);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xef.b(new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.bh>(this) {
                    final /* synthetic */ WorkerProfile fgz;

                    {
                        this.fgz = r2;
                        this.xen = com.tencent.mm.g.a.bh.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        int i = 0;
                        com.tencent.mm.g.a.bh bhVar = (com.tencent.mm.g.a.bh) bVar;
                        Context context = bhVar.fpC.context;
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "choose card from wx event, context is null");
                            return false;
                        }
                        String[] strArr = bhVar.fpC.fmW;
                        String str = null;
                        if (strArr != null && strArr.length > 0) {
                            str = strArr[0];
                            com.tencent.mm.a.g.s(p.aX(bhVar.fpC.context, strArr[0])[0].toByteArray());
                        }
                        Object obj = bhVar.fpC.selectionArgs;
                        if (obj == null || obj.length < 10) {
                            if (obj != null) {
                                i = obj.length;
                            }
                            x.e("MicroMsg.WorkerProfile", "ChooseCardFromWXEvent selectionArgs is null or length is < 10, the length is " + i);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i2 = 0; i2 < obj.length; i2++) {
                                stringBuilder.append(", selectionArgs[" + i2 + "]:" + obj[i2]);
                            }
                            x.i("MicroMsg.WorkerProfile", "ChooseCardFromWXEvent selectionArgs:", new Object[]{obj.toString()});
                            Intent intent = new Intent(context, WXBizEntryActivity.class);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(134217728).addFlags(67108864);
                            intent.putExtra("app_id", obj[0]);
                            intent.putExtra("shop_id", bh.getInt(obj[1], 0));
                            intent.putExtra("sign_type", obj[2]);
                            intent.putExtra("card_sign", obj[3]);
                            intent.putExtra("time_stamp", bh.getInt(obj[4], 0));
                            intent.putExtra("nonce_str", obj[5]);
                            intent.putExtra("card_tp_id", obj[6]);
                            intent.putExtra("card_type", obj[7]);
                            intent.putExtra("can_multi_select", bh.getInt(obj[8], 0));
                            intent.putExtra("key_from_scene", 8);
                            intent.putExtra("key_command_id", 16);
                            intent.putExtra("key_app_id", obj[0]);
                            intent.putExtra("key_package_name", str);
                            intent.putExtra("key_transaction", obj[9]);
                            context.startActivity(intent);
                        }
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xef.b(new 15(this));
                com.tencent.mm.sdk.b.a.xef.b(new 16(this));
                com.tencent.mm.sdk.b.a.xef.b(new 17(this));
                com.tencent.mm.sdk.b.a.xef.b(new 18(this));
                com.tencent.mm.sdk.b.a.xef.b(new 19(this));
                com.tencent.mm.sdk.b.a.xef.b(new 20(this));
                com.tencent.mm.sdk.b.a.xef.b(new 21(this));
                com.tencent.mm.sdk.b.a.xef.b(new 22(this));
                com.tencent.mm.sdk.b.a.xef.b(new j(2, 12));
                com.tencent.mm.plugin.messenger.a.f.ooo = new com.tencent.mm.ui.transmit.d();
                q.a.vcy = new com.tencent.mm.app.plugin.a();
                q.a.vcz = new com.tencent.mm.app.plugin.c();
                com.tencent.mm.pluginsdk.ui.d.b.a.vuo = com.tencent.mm.app.plugin.d.uB();
                if (!ar.Cs()) {
                    ar.Hg();
                }
                com.tencent.mm.sdk.b.a.xef.m(new ce());
                this.fgn = true;
                Log.setLogImpl(new 24(this));
                x.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - currentTimeMillis2));
                26 = new 26(ac.getContext());
                26.map.put("qqmail", Integer.valueOf(R.l.eoC));
                26.map.put("fmessage", Integer.valueOf(R.l.enZ));
                26.map.put("floatbottle", Integer.valueOf(R.l.enN));
                26.map.put("lbsapp", Integer.valueOf(R.l.eog));
                26.map.put("shakeapp", Integer.valueOf(R.l.eoM));
                26.map.put("medianote", Integer.valueOf(R.l.eop));
                26.map.put("qqfriend", Integer.valueOf(R.l.eoz));
                26.map.put("newsapp", Integer.valueOf(R.l.eoI));
                26.map.put("facebookapp", Integer.valueOf(R.l.enT));
                26.map.put("masssendapp", Integer.valueOf(R.l.eom));
                26.map.put("meishiapp", Integer.valueOf(R.l.eos));
                26.map.put("feedsapp", Integer.valueOf(R.l.enW));
                26.map.put("voipapp", Integer.valueOf(R.l.eoT));
                26.map.put("weixin", Integer.valueOf(R.l.ezI));
                26.map.put("filehelper", Integer.valueOf(R.l.enJ));
                26.map.put("cardpackage", Integer.valueOf(R.l.enQ));
                26.map.put("officialaccounts", Integer.valueOf(R.l.eow));
                26.map.put("voicevoipapp", Integer.valueOf(R.l.eoW));
                26.map.put("helper_entry", Integer.valueOf(R.l.eoc));
                26.map.put("voiceinputapp", Integer.valueOf(R.l.eoQ));
                26.map.put("linkedinplugin", Integer.valueOf(R.l.eoj));
                26.map.put("notifymessage", Integer.valueOf(R.l.eot));
                26.map.put("gh_43f2581f6fd6", Integer.valueOf(R.l.eoP));
                26.map.put("appbrandcustomerservicemsg", Integer.valueOf(R.l.enK));
                26.fgJ.put("weixin", Integer.valueOf(R.l.ezH));
                com.tencent.mm.l.a.a(26);
                if (!com.tencent.mm.compatible.util.f.ze()) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(340, com.tencent.mm.compatible.util.d.fM(19) ? 5 : 6, 1, false);
                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(com.tencent.mm.compatible.util.d.fM(19) ? 5001 : 5002);
                    objArr[1] = String.format("%s;%s;%s", new Object[]{com.tencent.mm.compatible.util.e.bnD, Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()});
                    gVar.h(11098, objArr);
                }
                x.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(this.fgo), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fdS), Integer.valueOf(d.vAz), bh.fd(ac.getContext())});
            }
            x.i("MicroMsg.WorkerProfile", "apk external info not null");
            if (aVar.fdP.fdS != 0) {
                com.tencent.mm.sdk.platformtools.f.fdS = aVar.fdP.fdS;
                x.i("MicroMsg.WorkerProfile", "read channelId from apk external");
            }
            if (aVar.fdP.fdU != 0) {
                com.tencent.mm.sdk.platformtools.f.fdU = aVar.fdP.fdU;
                x.i("MicroMsg.WorkerProfile", "ext.updateMode = %s", new Object[]{Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fdU)});
            }
            if (aVar.fdP.fdV != null) {
                com.tencent.mm.sdk.platformtools.f.xey = bh.getInt(aVar.fdP.fdV, 0);
            }
            if (aVar.fdP.fdW != null) {
                com.tencent.mm.sdk.platformtools.f.xez = aVar.fdP.fdW;
            }
            if (aVar.fdP.fdT != null) {
                com.tencent.mm.sdk.platformtools.f.fdT = aVar.fdP.fdT;
            }
            if (aVar.fdP.fdZ) {
                com.tencent.mm.sdk.platformtools.f.xeD = aVar.fdP.fdZ;
                x.i("MicroMsg.WorkerProfile", "ext.isNokiaol = %s", new Object[]{Boolean.valueOf(com.tencent.mm.sdk.platformtools.f.xeD)});
            }
            if (aVar.fdP.fdY != 0) {
                com.tencent.mm.sdk.platformtools.f.fdY = aVar.fdP.fdY;
                x.i("MicroMsg.WorkerProfile", "ext.autoAddAccount = %s", new Object[]{Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fdY)});
            }
            if (aVar.fdP.fdX) {
                com.tencent.mm.sdk.platformtools.f.xeC = aVar.fdP.fdX;
                x.i("MicroMsg.WorkerProfile", "ext.shouldShowGprsAlert = %s", new Object[]{Boolean.valueOf(com.tencent.mm.sdk.platformtools.f.xeC)});
            }
            c.tK();
            aA = c.aA(this.app);
            com.tencent.mm.sdk.platformtools.f.fdS = aA.gyb;
            context = this.app.getApplicationContext();
            i = com.tencent.mm.sdk.platformtools.f.fdS;
            i2 = d.vAz;
            sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
            i3 = sharedPreferences.getInt("channel", -1);
            i4 = sharedPreferences.getInt("version", 0);
            edit = sharedPreferences.edit();
            edit.putInt("channel", i);
            edit.putInt("version", i2);
            edit.commit();
            if (com.tencent.mm.sdk.platformtools.f.xey > 0) {
                com.tencent.mm.sdk.platformtools.f.xeA = true;
            }
            com.tencent.mm.bm.d.ccW();
            if (bh.ov(com.tencent.mm.sdk.platformtools.f.fdT)) {
            }
            d.DEVICE_TYPE = "android-" + (bh.ov(com.tencent.mm.sdk.platformtools.f.fdT) ? Integer.valueOf(VERSION.SDK_INT) : com.tencent.mm.sdk.platformtools.f.fdT);
            if (bh.ov(com.tencent.mm.sdk.a.b.ceL())) {
                d.DEVICE_TYPE = "android-" + com.tencent.mm.sdk.a.b.ceL();
            }
            x.v("MicroMsg.WorkerProfile", "set device type :%s  %s", new Object[]{d.DEVICE_TYPE, com.tencent.mm.sdk.a.b.ceL()});
            this.locale = MMActivity.initLanguage(this.app.getBaseContext());
            if (com.tencent.mm.sdk.a.b.ceK()) {
                shell = this.ffG;
                context2 = ac.getContext();
                if (shell.gIF == null) {
                    shell.gIF = new Receiver();
                    context2.registerReceiver(shell.gIF, Shell.gIH);
                }
            }
            com.tencent.mm.sdk.b.a.xef.b(this.fgh);
            bVar2 = new b();
            x.d("MicroMsg.AvatarDrawable", "setLoader" + bVar2);
            com.tencent.mm.pluginsdk.ui.a.b.plt = bVar2;
            q.a.vcr = new 25(this);
            com.tencent.mm.kernel.g.a(o.class, new com.tencent.mm.kernel.c.d(this.fgy));
            com.tencent.mm.kernel.g.a(h.class, new com.tencent.mm.kernel.c.d(this.fgy));
            com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.j.class, new com.tencent.mm.kernel.c.d(this.fgy));
            com.tencent.mm.sdk.b.a.xef.b(new com.tencent.mm.app.plugin.b.a.a());
            if (this.fgj == null) {
                this.fgj = new com.tencent.mm.booter.notification.b(this.app);
            }
            this.fgw = new com.tencent.mm.h.b();
            bVar3 = this.fgw;
            x.i("MicroMsg.BroadcastController", "summerdiz init");
            com.tencent.mm.sdk.b.a.xef.b(bVar3.gBc);
            if (this.fgm) {
                a(null);
                this.fgm = false;
            }
            com.tencent.mm.sdk.b.a.xef.b(new com.tencent.mm.kiss.a.b.2(com.tencent.mm.kiss.a.b.DY()));
            com.tencent.mm.sdk.b.a.xef.a(new 23(this));
            com.tencent.mm.sdk.b.a.xef.b(new com.tencent.mm.ui.bindqq.a());
            com.tencent.mm.sdk.b.a.xef.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xef.b(new 30(this));
            com.tencent.mm.sdk.b.a.xef.b(new 31(this));
            com.tencent.mm.sdk.b.a.xef.b(new 32(this));
            com.tencent.mm.sdk.b.a.xef.b(new 33(this));
            com.tencent.mm.sdk.b.a.xef.b(new 34(this));
            com.tencent.mm.sdk.b.a.xef.b(new 2(this));
            com.tencent.mm.sdk.b.a.xef.b(new 3(this));
            com.tencent.mm.sdk.b.a.xef.b(new 4(this));
            com.tencent.mm.sdk.b.a.xef.b(new 5(this));
            com.tencent.mm.sdk.b.a.xef.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xef.b(new 7(this));
            com.tencent.mm.sdk.b.a.xef.b(new 8(this));
            com.tencent.mm.sdk.b.a.xef.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xef.b(new 10(this));
            com.tencent.mm.sdk.b.a.xef.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xef.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xef.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xef.b(new 15(this));
            com.tencent.mm.sdk.b.a.xef.b(new 16(this));
            com.tencent.mm.sdk.b.a.xef.b(new 17(this));
            com.tencent.mm.sdk.b.a.xef.b(new 18(this));
            com.tencent.mm.sdk.b.a.xef.b(new 19(this));
            com.tencent.mm.sdk.b.a.xef.b(new 20(this));
            com.tencent.mm.sdk.b.a.xef.b(new 21(this));
            com.tencent.mm.sdk.b.a.xef.b(new 22(this));
            com.tencent.mm.sdk.b.a.xef.b(new j(2, 12));
            com.tencent.mm.plugin.messenger.a.f.ooo = new com.tencent.mm.ui.transmit.d();
            q.a.vcy = new com.tencent.mm.app.plugin.a();
            q.a.vcz = new com.tencent.mm.app.plugin.c();
            com.tencent.mm.pluginsdk.ui.d.b.a.vuo = com.tencent.mm.app.plugin.d.uB();
            if (ar.Cs()) {
                ar.Hg();
            }
            com.tencent.mm.sdk.b.a.xef.m(new ce());
            this.fgn = true;
            Log.setLogImpl(new 24(this));
            x.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - currentTimeMillis2));
            26 = new 26(ac.getContext());
            26.map.put("qqmail", Integer.valueOf(R.l.eoC));
            26.map.put("fmessage", Integer.valueOf(R.l.enZ));
            26.map.put("floatbottle", Integer.valueOf(R.l.enN));
            26.map.put("lbsapp", Integer.valueOf(R.l.eog));
            26.map.put("shakeapp", Integer.valueOf(R.l.eoM));
            26.map.put("medianote", Integer.valueOf(R.l.eop));
            26.map.put("qqfriend", Integer.valueOf(R.l.eoz));
            26.map.put("newsapp", Integer.valueOf(R.l.eoI));
            26.map.put("facebookapp", Integer.valueOf(R.l.enT));
            26.map.put("masssendapp", Integer.valueOf(R.l.eom));
            26.map.put("meishiapp", Integer.valueOf(R.l.eos));
            26.map.put("feedsapp", Integer.valueOf(R.l.enW));
            26.map.put("voipapp", Integer.valueOf(R.l.eoT));
            26.map.put("weixin", Integer.valueOf(R.l.ezI));
            26.map.put("filehelper", Integer.valueOf(R.l.enJ));
            26.map.put("cardpackage", Integer.valueOf(R.l.enQ));
            26.map.put("officialaccounts", Integer.valueOf(R.l.eow));
            26.map.put("voicevoipapp", Integer.valueOf(R.l.eoW));
            26.map.put("helper_entry", Integer.valueOf(R.l.eoc));
            26.map.put("voiceinputapp", Integer.valueOf(R.l.eoQ));
            26.map.put("linkedinplugin", Integer.valueOf(R.l.eoj));
            26.map.put("notifymessage", Integer.valueOf(R.l.eot));
            26.map.put("gh_43f2581f6fd6", Integer.valueOf(R.l.eoP));
            26.map.put("appbrandcustomerservicemsg", Integer.valueOf(R.l.enK));
            26.fgJ.put("weixin", Integer.valueOf(R.l.ezH));
            com.tencent.mm.l.a.a(26);
            if (com.tencent.mm.compatible.util.f.ze()) {
                if (com.tencent.mm.compatible.util.d.fM(19)) {
                }
                com.tencent.mm.plugin.report.service.g.pQN.a(340, com.tencent.mm.compatible.util.d.fM(19) ? 5 : 6, 1, false);
                gVar = com.tencent.mm.plugin.report.service.g.pQN;
                objArr = new Object[2];
                if (com.tencent.mm.compatible.util.d.fM(19)) {
                }
                objArr[0] = Integer.valueOf(com.tencent.mm.compatible.util.d.fM(19) ? 5001 : 5002);
                objArr[1] = String.format("%s;%s;%s", new Object[]{com.tencent.mm.compatible.util.e.bnD, Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()});
                gVar.h(11098, objArr);
            }
            x.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(this.fgo), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fdS), Integer.valueOf(d.vAz), bh.fd(ac.getContext())});
        } catch (NameNotFoundException e22) {
            x.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
        } catch (Exception e3) {
            x.e("MicroMsg.WorkerProfile", "Exception in initChannel, %s", new Object[]{e3.getMessage()});
        }
    }

    public final void onTerminate() {
        super.onTerminate();
        com.tencent.mm.h.b bVar = this.fgw;
        x.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", new Object[]{bVar.gAZ, Integer.valueOf(bVar.gBb.size())});
        com.tencent.mm.sdk.b.a.xef.c(bVar.gBc);
        bVar.gAZ = null;
        bVar.gBa.clear();
        bVar.gBb.clear();
        this.fgw = null;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        String property = bd.getProperty("system_property_key_locale");
        if (property != null && property.length() > 0) {
            this.locale = new Locale(property);
        }
        synchronized (this) {
            if (this.fgn) {
                a(configuration);
                return;
            }
            this.fgm = true;
        }
    }

    private void a(Configuration configuration) {
        w.c(configuration);
        String property = bd.getProperty("system_property_key_locale");
        if (property != null && property.length() > 0) {
            if ("language_default".equalsIgnoreCase(property)) {
                this.locale = Locale.getDefault();
            } else {
                String[] split = property.split("_");
                if (split == null || split.length < 2) {
                    this.locale = new Locale(property);
                } else {
                    x.d("MicroMsg.WorkerProfile", "initLanguage arr.length = %s", new Object[]{Integer.valueOf(split.length)});
                    this.locale = new Locale(split[0], split[1]);
                }
            }
        }
        Locale initLanguage = MMActivity.initLanguage(this.app.getBaseContext());
        x.d("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s, lang = %s", new Object[]{this.locale, initLanguage, property});
        if (initLanguage != null && this.locale != null && !initLanguage.equals(this.locale)) {
            if (ar.Hj()) {
                try {
                    com.tencent.mm.network.e eVar = ar.CG().hmV;
                    if (eVar != null) {
                        com.tencent.mm.network.c Kx = eVar.Kx();
                        if (Kx != null) {
                            byte[] bArr = new byte[0];
                            ar.Hg();
                            Kx.v(bArr, com.tencent.mm.z.c.Cg());
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                    x.printErrStackTrace("MicroMsg.WorkerProfile", e, "what the f$!k", new Object[0]);
                }
            }
            x.w("MicroMsg.WorkerProfile", "language changed, restart process");
            System.exit(-1);
        }
    }

    public final String toString() {
        return ffc;
    }

    public final aj getNotification() {
        if (this.fgj == null) {
            this.fgj = new com.tencent.mm.booter.notification.b(this.app);
        }
        return this.fgj;
    }

    public final b uw() {
        if (this.fgk == null) {
            this.fgk = new 27(this);
        }
        return this.fgk;
    }

    public final com.tencent.mm.z.ac ux() {
        if (this.fgl == null) {
            this.fgl = com.tencent.mm.booter.a.wz();
        }
        return this.fgl;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 3 && i2 == -1) {
            x.i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", new Object[]{bh.cgy(), Long.valueOf(Thread.currentThread().getId())});
        }
        com.tencent.mm.sdk.b.b ahVar;
        if (i == 4 && i2 == -3002) {
            if (bh.ov(str)) {
                x.e("MicroMsg.WorkerProfile", "summerdiz -3002 but errMsg is null");
                return;
            }
            if (str.startsWith("autoauth_errmsg_")) {
                str = str.substring(16);
            }
            x.i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", new Object[]{str});
            ahVar = new ah();
            ahVar.foi.type = 4;
            ahVar.foi.fok = str;
            com.tencent.mm.sdk.b.a.xef.m(ahVar);
        } else if (ar.Hj() && i == 4 && ((i2 == -6 || i2 == -310 || i2 == -311) && str != null && str.startsWith("autoauth_errmsg_"))) {
            if (NewTaskUI.cxW() == null) {
                r0 = new Intent();
                r0.setClass(ac.getContext(), NewTaskUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                ac.getContext().startActivity(r0);
            }
        } else if (i == 4 && i2 == -213) {
            ahVar = new iz();
            ahVar.fzC.status = 0;
            ahVar.fzC.aAk = 3;
            com.tencent.mm.sdk.b.a.xef.m(ahVar);
            if (AccountDeletedAlphaAlertUI.cxu() == null) {
                r0 = new Intent();
                r0.setClass(ac.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                r0.putExtra("errmsg", str);
                ac.getContext().startActivity(r0);
            }
        }
    }

    public final void onReportKVDataReady(byte[] bArr, byte[] bArr2, int i) {
        ar.Dm().F(new 28(this, i, bArr2));
    }

    public final void cC(String str) {
        x.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", new Object[]{str});
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.foi.type = 4;
        ahVar.foi.fok = str;
        com.tencent.mm.sdk.b.a.xef.m(ahVar);
    }

    public final void cD(String str) {
        x.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", new Object[]{str});
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.foi.type = 1;
        ahVar.foi.fok = str;
        com.tencent.mm.sdk.b.a.xef.m(ahVar);
    }
}

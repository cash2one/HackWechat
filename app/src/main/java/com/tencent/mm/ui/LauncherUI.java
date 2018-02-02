package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.R;
import com.tencent.mm.ad.m;
import com.tencent.mm.ag.d;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.blink.FirstScreenFrameLayout;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.k;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.i.a.b.o;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.HomeUI.1;
import com.tencent.mm.ui.HomeUI.12;
import com.tencent.mm.ui.HomeUI.14;
import com.tencent.mm.ui.HomeUI.15;
import com.tencent.mm.ui.HomeUI.16;
import com.tencent.mm.ui.HomeUI.19;
import com.tencent.mm.ui.HomeUI.20;
import com.tencent.mm.ui.HomeUI.22;
import com.tencent.mm.ui.HomeUI.23;
import com.tencent.mm.ui.HomeUI.25;
import com.tencent.mm.ui.HomeUI.5;
import com.tencent.mm.ui.HomeUI.9;
import com.tencent.mm.ui.account.WelcomeSelectView;
import com.tencent.mm.ui.account.WelcomeView;
import com.tencent.mm.ui.b.c;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.i$a;
import com.tencent.mm.ui.chatting.b.y;
import com.tencent.mm.ui.conversation.j;
import com.tencent.mm.ui.j.6;
import com.tencent.mm.ui.widget.l;
import com.tencent.mm.ui.x.7;
import com.tencent.mm.ui.z.10;
import com.tencent.mm.ui.z.11;
import com.tencent.mm.ui.z.13;
import com.tencent.mm.ui.z.17;
import com.tencent.mm.ui.z.2;
import com.tencent.mm.ui.z.3;
import com.tencent.mm.ui.z.8;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import com.tencent.mm.z.bq;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class LauncherUI extends MMFragmentActivity {
    private static ArrayList<LauncherUI> xGP = new ArrayList();
    private static boolean xGQ = true;
    public static long xGR;
    private static boolean xHa = false;
    private Intent fzg = null;
    public HomeUI xGS = new HomeUI();
    private z xGT = new z(this.xGS);
    private m xGU = new m();
    public boolean xGV = false;
    boolean xGW = false;
    private boolean xGX = false;
    private WelcomeView xGY;
    private s xGZ = new s("MicroMsg.LauncherUI");
    private boolean xHb = false;
    private boolean xHc = false;
    private af xHd = new af();
    private Runnable xHe = new 4(this);

    interface a {
        boolean cmM();
    }

    public static LauncherUI cmG() {
        if (!xGP.isEmpty()) {
            return (LauncherUI) xGP.get(0);
        }
        x.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", new Object[]{bh.cgy()});
        return null;
    }

    public static int cmH() {
        if (cmG() == null || cmG().xGS == null || cmG().xGS.xGh == null) {
            return -1;
        }
        return cmG().xGS.xGh.mnk;
    }

    private void cmI() {
        int indexOf = xGP.indexOf(this);
        if (indexOf >= 0) {
            xGP.remove(indexOf);
        }
        x.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", new Object[]{Integer.valueOf(indexOf), Integer.valueOf(xGP.size()), Integer.valueOf(hashCode())});
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        HomeUI homeUI;
        com.tencent.mm.blink.a.au(h.Do().gQY);
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bh.fb(this)});
        super.onCreate(bundle);
        long currentTimeMillis2 = System.currentTimeMillis();
        int taskId = getTaskId();
        String packageName = getPackageName();
        Intent intent = getIntent();
        boolean z = false;
        if (intent != null && t.a(intent, "absolutely_exit", false)) {
            z = true;
            x.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
        }
        RunningTaskInfo runningTaskInfo = null;
        if (!z) {
            Iterator it = xGP.iterator();
            while (it.hasNext()) {
                LauncherUI launcherUI = (LauncherUI) it.next();
                if (launcherUI.getTaskId() != taskId) {
                    x.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", new Object[]{Integer.valueOf(launcherUI.hashCode()), Integer.valueOf(launcherUI.getTaskId()), Integer.valueOf(taskId)});
                    runningTaskInfo = bh.ah(this, taskId);
                    if (runningTaskInfo == null) {
                        x.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", new Object[]{Integer.valueOf(taskId)});
                        finish();
                        obj = null;
                        break;
                    }
                    x.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[]{Integer.valueOf(runningTaskInfo.id), runningTaskInfo.topActivity.getClassName(), runningTaskInfo.baseActivity.getClassName(), Integer.valueOf(runningTaskInfo.numActivities), Integer.valueOf(runningTaskInfo.numRunning)});
                    if (runningTaskInfo.baseActivity.getPackageName().equals(packageName)) {
                        launcherUI.finish();
                        xGP.remove(launcherUI);
                    } else {
                        x.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + runningTaskInfo.baseActivity.getPackageName());
                        finish();
                        if (bh.ah(this, launcherUI.getTaskId()) != null) {
                            x.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
                            Intent intent2 = new Intent(this, LauncherUI.class);
                            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            startActivity(intent2);
                        }
                        obj = null;
                    }
                }
                runningTaskInfo = runningTaskInfo;
            }
        }
        if (!xGP.isEmpty()) {
            if (runningTaskInfo == null) {
                runningTaskInfo = bh.ah(this, taskId);
            }
            if (runningTaskInfo != null) {
                x.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[]{Integer.valueOf(runningTaskInfo.id), runningTaskInfo.baseActivity.getClassName(), runningTaskInfo.baseActivity.getClassName(), Integer.valueOf(runningTaskInfo.numActivities), Integer.valueOf(runningTaskInfo.numRunning)});
                packageName = getComponentName().getClassName();
                if (runningTaskInfo.numActivities > 1 && packageName.equals(r0) && packageName.equals(r3)) {
                    finish();
                    x.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", new Object[]{Integer.valueOf(xGP.size())});
                    obj = null;
                    if (obj != null) {
                        x.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
                    }
                    x.i("MicroMsg.LauncherUI", "onCreate normally");
                    this.xGS = new HomeUI();
                    this.xGT = new z(this.xGS);
                    homeUI = this.xGS;
                    a aVar = this.xGT;
                    homeUI.xFE = this;
                    homeUI.xGf = aVar;
                    w wVar = homeUI.xGh;
                    wVar.xFE = this;
                    wVar.xKy = homeUI;
                    x xVar = wVar.xKx;
                    xVar.xFE = this;
                    xVar.xKO = homeUI;
                    homeUI.xGg = new j(this, homeUI);
                    NotifyReceiver.wF();
                    e.O(homeUI.xFE);
                    homeUI.mActionBar = getSupportActionBar();
                    if (homeUI.mActionBar != null) {
                        if (VERSION.SDK_INT < 11) {
                            homeUI.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.brg)));
                        }
                        homeUI.mActionBar.hide();
                    }
                    setRequestedOrientation(1);
                    String H = aq.hfP.H("login_user_name", "");
                    this.fzg = getIntent();
                    this.xGZ.vcF = this.fzg.getBooleanExtra("splash-hack-activity-recreate", false);
                    x.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[]{r1.mTag, Boolean.valueOf(r1.vcF)});
                    x.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[]{H, Boolean.valueOf(ar.Hi()), Boolean.valueOf(xGQ)});
                    if (!xGQ || (!ar.Hi() && H.equals(""))) {
                        xGR = currentTimeMillis;
                        x.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
                        setRequestedOrientation(1);
                        obj = (ar.Hi() || !aq.hfP.H("login_user_name", "").equals("")) ? null : 1;
                        if (obj != null) {
                            f.xeB = false;
                        } else {
                            z = false;
                            if (f.xeC) {
                                MMAppMgr.ft(this);
                            } else {
                                z = MMAppMgr.a(this, new OnClickListener(this) {
                                    final /* synthetic */ LauncherUI xHf;

                                    {
                                        this.xHf = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.xHf.lT(true);
                                    }
                                });
                            }
                            if (!z) {
                                lT(true);
                            }
                            o.aqV();
                            com.tencent.mm.plugin.report.service.f.vB(8);
                            View welcomeSelectView = new WelcomeSelectView(this);
                            setContentView(welcomeSelectView);
                            this.xGY = welcomeSelectView;
                            x.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[]{Integer.valueOf(hashCode())});
                            ag.K(this.xHe);
                            ag.h(this.xHe, 2000);
                        }
                    } else {
                        xGR = currentTimeMillis;
                        x.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
                    }
                    if (cmL()) {
                        cmJ();
                        return;
                    } else {
                        x.i("MicroMsg.LauncherUI", "handleExitIntent return");
                        return;
                    }
                }
                x.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", new Object[]{Integer.valueOf(xGP.size()), Boolean.valueOf(r2)});
                xGP.clear();
            } else {
                x.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", new Object[]{Integer.valueOf(taskId), Integer.valueOf(xGP.size())});
                xGP.clear();
            }
        }
        xGP.add(this);
        x.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d, use time %d", new Object[]{Integer.valueOf(xGP.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        obj = 1;
        if (obj != null) {
            x.i("MicroMsg.LauncherUI", "onCreate normally");
            this.xGS = new HomeUI();
            this.xGT = new z(this.xGS);
            homeUI = this.xGS;
            a aVar2 = this.xGT;
            homeUI.xFE = this;
            homeUI.xGf = aVar2;
            w wVar2 = homeUI.xGh;
            wVar2.xFE = this;
            wVar2.xKy = homeUI;
            x xVar2 = wVar2.xKx;
            xVar2.xFE = this;
            xVar2.xKO = homeUI;
            homeUI.xGg = new j(this, homeUI);
            NotifyReceiver.wF();
            e.O(homeUI.xFE);
            homeUI.mActionBar = getSupportActionBar();
            if (homeUI.mActionBar != null) {
                if (VERSION.SDK_INT < 11) {
                    homeUI.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.brg)));
                }
                homeUI.mActionBar.hide();
            }
            setRequestedOrientation(1);
            String H2 = aq.hfP.H("login_user_name", "");
            this.fzg = getIntent();
            this.xGZ.vcF = this.fzg.getBooleanExtra("splash-hack-activity-recreate", false);
            x.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[]{r1.mTag, Boolean.valueOf(r1.vcF)});
            x.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[]{H2, Boolean.valueOf(ar.Hi()), Boolean.valueOf(xGQ)});
            if (xGQ) {
            }
            xGR = currentTimeMillis;
            x.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
            setRequestedOrientation(1);
            if (!ar.Hi()) {
            }
            if (obj != null) {
                z = false;
                if (f.xeC) {
                    MMAppMgr.ft(this);
                } else {
                    z = MMAppMgr.a(this, /* anonymous class already generated */);
                }
                if (z) {
                    lT(true);
                }
                o.aqV();
                com.tencent.mm.plugin.report.service.f.vB(8);
                View welcomeSelectView2 = new WelcomeSelectView(this);
                setContentView(welcomeSelectView2);
                this.xGY = welcomeSelectView2;
                x.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[]{Integer.valueOf(hashCode())});
                ag.K(this.xHe);
                ag.h(this.xHe, 2000);
            } else {
                f.xeB = false;
            }
            if (cmL()) {
                cmJ();
                return;
            } else {
                x.i("MicroMsg.LauncherUI", "handleExitIntent return");
                return;
            }
        }
        x.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
    }

    private void cmJ() {
        if (xHa) {
            x.i("MicroMsg.LauncherUI", "whatnew has been started.");
            return;
        }
        xHa = true;
        if (!g.Dh().Cy()) {
            g.Dh();
            if (com.tencent.mm.kernel.a.Cx()) {
                x.i("MicroMsg.LauncherUI", "account not initiate, skip whatsnew");
                return;
            }
            this.xHb = true;
            xHa = false;
        } else if (!cmK()) {
            x.i("MicroMsg.LauncherUI", "notSwitchOrHold is false, skip whatsnew");
        } else if (!t.a(getIntent(), "LauncherUI.enter_from_reg", false) && com.tencent.mm.pluginsdk.q.a.vcr != null) {
            com.tencent.mm.pluginsdk.q.a.vcr.uz();
        }
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", new Object[]{Integer.valueOf(hashCode()), bh.fb(this)});
        this.fzg = intent;
        super.onNewIntent(intent);
        setIntent(intent);
        if (cmL()) {
            x.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
        } else if (this.fzg == null || !t.a(this.fzg, "Intro_Need_Clear_Top ", false)) {
            if ((intent.getFlags() & 67108864) == 67108864) {
                closeChatting(false);
            }
            w wVar = this.xGS.xGh;
            if ((intent.getFlags() & 67108864) == 67108864) {
                wVar.xKz = true;
            }
            if (this.xGV) {
                x.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
                aj(intent);
            }
        } else {
            x.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
            finish();
            fr(this);
        }
    }

    private void lT(boolean z) {
        boolean z2 = true;
        if (z) {
            if (this.xGU.c(this, new 2(this))) {
                z2 = false;
            }
            this.xHc = z2;
        } else if (!this.xHc) {
            int i;
            if (this.xGU.pyw) {
                x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", ""))});
                if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "")) {
                    x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_PHONE_STATE", 97, "", ""))});
                    if (!com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_PHONE_STATE", 97, "", "")) {
                        i = 0;
                    }
                } else {
                    i = 0;
                }
                if (i != 0) {
                    z2 = false;
                }
                this.xHc = z2;
            }
            boolean z3 = true;
            if (i != 0) {
                z2 = false;
            }
            this.xHc = z2;
        }
    }

    public void onResume() {
        super.onResume();
        if (this.xGZ.ch("onResume")) {
            x.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
            return;
        }
        x.i("MicroMsg.LauncherUI", "not skip this onResume");
        xGQ = false;
        SharedPreferences sharedPreferences;
        boolean cmM;
        String j;
        boolean a;
        String vD;
        Intent intent;
        if (cmK()) {
            HomeUI homeUI;
            j jVar;
            long currentTimeMillis;
            long currentTimeMillis2;
            j jVar2;
            LauncherUI cmG;
            x.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", new Object[]{Boolean.valueOf(this.xGV)});
            if (!this.xGV) {
                this.xGV = true;
                homeUI = this.xGS;
                jVar = homeUI.xGg;
                com.tencent.mm.sdk.b.a.xef.b(jVar.xFJ);
                com.tencent.mm.sdk.b.a.xef.b(jVar.xFK);
                getWindow().setCallback(new c(getWindow().getCallback(), this));
                sharedPreferences = homeUI.xFE.getSharedPreferences("system_config_prefs", 4);
                if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                    sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                    XLogSetup.realSetupXlog();
                }
                homeUI.xFZ = new ab(this);
                homeUI.xFW = true;
                NotifyReceiver.wG();
                ar.getNotification().fm(1);
                x.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
                currentTimeMillis = System.currentTimeMillis();
                if (ar.Hj()) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    MMActivity.initLanguage(homeUI.xFE);
                    try {
                        Set hashSet = new HashSet();
                        String[] split = homeUI.getString(R.l.dXJ).split(";");
                        hashSet.add(split[0]);
                        hashSet.add(split[1]);
                        r.b(hashSet);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e, "", new Object[0]);
                    }
                    g.Dk();
                    g.Dm().F(new 5(homeUI));
                    x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - currentTimeMillis2));
                    homeUI.nny = (LayoutInflater) homeUI.xFE.getSystemService("layout_inflater");
                    currentTimeMillis2 = System.currentTimeMillis();
                    homeUI.contentView = b.DY().a(homeUI.xFE, "R.layout.main_tab", R.i.dmV);
                    com.tencent.mm.blink.b.wo().wp();
                    ((FirstScreenFrameLayout) homeUI.contentView.findViewById(R.h.cih)).gxG = new 1(homeUI);
                    an.bYR();
                    x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - currentTimeMillis2));
                    homeUI.xFE.setContentView(homeUI.contentView);
                    Looper.myQueue().addIdleHandler(homeUI.xGr);
                    homeUI.xFX = true;
                    homeUI.xGp = (VoiceSearchLayout) homeUI.xFE.findViewById(R.h.cWW);
                    homeUI.xGp.BV(BackwardSupportUtil.b.b(homeUI.xFE, 100.0f));
                    x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - currentTimeMillis2));
                    x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - System.currentTimeMillis()));
                    x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - System.currentTimeMillis()));
                    homeUI.initActionBar();
                    homeUI.mActionBar.show();
                    homeUI.contentView.post(new 12(homeUI));
                    x.v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - currentTimeMillis));
                    ag.h(new 19(homeUI), 2000);
                    homeUI.contentView.addOnLayoutChangeListener(homeUI.xGi);
                    e.a(homeUI.xFE, homeUI.contentView);
                    homeUI.contentView.postDelayed(new 20(homeUI), 20);
                } else {
                    x.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
                    homeUI.xFE.finish();
                }
                w wVar = homeUI.xGh;
                wVar.xKB = (CustomViewPager) wVar.xFE.findViewById(R.h.cCl);
                wVar.xKB.xe(4);
                wVar.xKB.DN = true;
                wVar.xKB.xXJ = false;
                wVar.xKC = new com.tencent.mm.ui.w.a(wVar, wVar.xFE, wVar.xKB);
                wVar.DW(0);
                x xVar = wVar.xKx;
                ViewGroup viewGroup = (ViewGroup) wVar.xKB.getParent();
                c$a com_tencent_mm_ui_c_a = wVar.xKC;
                c cVar = xVar.xKP;
                if (xVar.xKP != null) {
                    xVar.xKP.a(null);
                    ((View) xVar.xKP).setVisibility(8);
                    if (viewGroup != null) {
                        viewGroup.removeView((View) xVar.xKP);
                    }
                }
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                Object launcherUIBottomTabView = new LauncherUIBottomTabView(xVar.xFE);
                if (viewGroup != null) {
                    viewGroup.addView(launcherUIBottomTabView, layoutParams);
                }
                xVar.xKP = launcherUIBottomTabView;
                ((View) xVar.xKP).setVisibility(0);
                xVar.xKP.a(com_tencent_mm_ui_c_a);
                if (!(cVar == null || cVar == xVar.xKP)) {
                    xVar.xKP.lM(cVar.clL());
                    xVar.xKP.lN(cVar.clM());
                    xVar.xKP.DH(cVar.clH());
                    xVar.xKP.DI(cVar.clI());
                    xVar.xKP.DJ(cVar.clJ());
                    xVar.xKP.DK(cVar.clK());
                    xVar.xKP.oV(cVar.clN());
                }
                this.xGT.qwI = this;
                aj(getIntent());
            }
            homeUI = this.xGS;
            currentTimeMillis = com.tencent.mm.platformtools.t.Wp();
            w wVar2 = homeUI.xGh;
            x.i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d", new Object[]{Integer.valueOf(wVar2.mnk)});
            if (wVar2.xKH.size() != 0) {
                ((l) ((u) wVar2.xKH.get(Integer.valueOf(wVar2.mnk)))).clD();
            }
            if (wVar2.xKz && wVar2.xFE.getIntent().hasExtra("isScrollFirst") && wVar2.xFE.getIntent().hasExtra("isShowHeader")) {
                jVar2 = (j) wVar2.xKH.get(Integer.valueOf(0));
                if (jVar2 != null) {
                    jVar2.d(wVar2.xFE.getIntent().getBooleanExtra("isShowHeader", false), wVar2.xFE.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), wVar2.xFE.getIntent().getBooleanExtra("isScrollFirst", true));
                }
            }
            if (wVar2.xKz) {
                wVar2.xKz = false;
                wVar2.Yp("tab_main");
            }
            jVar2 = (j) wVar2.xKH.get(Integer.valueOf(0));
            if (jVar2 != null) {
                jVar2.cvI();
                jVar2.cwK();
            }
            if (wVar2.mnk == 0) {
                ar.getNotification().aU(true);
            } else {
                ar.getNotification().aU(false);
            }
            l lVar = (l) wVar2.DX(wVar2.mnk);
            if (lVar != null) {
                lVar.clE();
            }
            wVar2.xKz = false;
            int a2 = t.a(wVar2.xFE.getIntent(), "preferred_tab", 0);
            x.d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", new Object[]{Integer.valueOf(a2)});
            if (a2 != 0) {
                wVar2.DW(a2);
                wVar2.xFE.getIntent().putExtra("preferred_tab", 0);
            }
            com.tencent.mm.sdk.b.a.xef.b(wVar2.xKF);
            x xVar2 = wVar2.xKx;
            if (xVar2.xKP != null) {
                xVar2.xKP.clG();
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().a(xVar2.xKT);
            com.tencent.mm.s.c.Bq().a(xVar2.xKS);
            ar.Hg();
            com.tencent.mm.z.c.Fd().a(xVar2);
            com.tencent.mm.sdk.b.a.xef.b(xVar2.xFm);
            com.tencent.mm.sdk.b.a.xef.b(xVar2.xKU);
            com.tencent.mm.sdk.b.a.xef.b(xVar2.xFl);
            com.tencent.mm.blink.b.wo().f(new 7(xVar2));
            jVar = homeUI.xGg;
            com.tencent.mm.sdk.b.b awVar = new aw();
            com.tencent.mm.sdk.b.a.xef.m(awVar);
            if (awVar.foZ.fpa && !com.tencent.mm.platformtools.t.ov(awVar.foZ.fpb)) {
                x.d("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", new Object[]{awVar.foZ.fpb});
                com.tencent.mm.ui.base.h.b(jVar.xFE, awVar.foZ.fpb, awVar.foZ.title, true);
            }
            if (!jVar.a(jVar.xFG)) {
                ar.Dm().g(new 6(jVar), 500);
            }
            jVar.xFG = null;
            com.tencent.mm.sdk.a.b.bD(true);
            cmM = homeUI.xGf.cmM();
            if (!cmM && ar.Hj()) {
                com.tencent.mm.blink.b.wo().f(new 22(homeUI));
                if (!(com.tencent.mm.pluginsdk.q.a.vcv == null || com.tencent.mm.pluginsdk.q.a.vcw == null || com.tencent.mm.platformtools.t.ov(com.tencent.mm.pluginsdk.q.a.vcw.aVL()))) {
                    x.i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", new Object[]{com.tencent.mm.pluginsdk.q.a.vcv.aVB()});
                    awVar = new ep();
                    awVar.ftg.username = com.tencent.mm.pluginsdk.q.a.vcv.aVB();
                    com.tencent.mm.sdk.b.a.xef.m(awVar);
                }
            }
            if (!cmM) {
                k.a(homeUI.xFE, 3, homeUI.xGh.mnk, "directReport_onResume");
            }
            l.b(homeUI.xFE);
            homeUI.xFE.onSwipe(1.0f);
            homeUI.xGe = com.tencent.mm.ui.HomeUI.a.xGD;
            if (homeUI.xFY) {
                homeUI.xFY = false;
                homeUI.cmB();
            }
            m.JK();
            currentTimeMillis2 = System.currentTimeMillis();
            x.w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
            k.e(homeUI.xFE, false);
            k.f(homeUI.xFE, false);
            long currentTimeMillis3 = System.currentTimeMillis();
            if (homeUI.xFE.getSharedPreferences(ac.cfs(), 0).getBoolean("settings_landscape_mode", false)) {
                homeUI.xFE.setRequestedOrientation(-1);
            } else {
                homeUI.xFE.setRequestedOrientation(1);
            }
            long currentTimeMillis4 = System.currentTimeMillis();
            if (cmG() != null) {
                com.tencent.mm.blink.b.wo().wr();
                ((n) g.k(n.class)).getSysCmdMsgExtension().a("showprivacypolicy", homeUI.xGu);
                homeUI.lS(false);
                com.tencent.mm.sdk.b.a.xef.b(homeUI.xGq);
                x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - currentTimeMillis4));
            }
            x.v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - currentTimeMillis3));
            x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - currentTimeMillis2));
            x.i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - currentTimeMillis));
            if (homeUI.xFY) {
                homeUI.xFY = false;
                homeUI.cmB();
            }
            com.tencent.mm.app.k tX = com.tencent.mm.app.k.tX();
            tX.ffC = true;
            tX.ffD.removeMessages(-1999);
            tX.ffD.removeMessages(-2999);
            x.i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - currentTimeMillis));
            if (q.GA().booleanValue()) {
                homeUI.cmw();
            }
            com.tencent.mm.blink.b.wo().f(new 23(homeUI));
            z zVar = this.xGT;
            zVar.xLz = com.tencent.mm.platformtools.t.Wo();
            if (zVar.cny()) {
                Looper.myQueue().addIdleHandler(new 17(zVar));
                zVar.xLE = new 2(zVar);
                ag.h(new 3(zVar), 500);
            }
            if (zVar.cmM()) {
                zVar.pY(3);
                if (zVar.xLx != null && zVar.xLx.isSupportNavigationSwipeBack()) {
                    zVar.xLx.getSwipeBackLayout().mEnable = true;
                }
            }
            x.i("MicroMsg.LauncherUI", "resumeNormalJump");
            com.tencent.mm.ui.MMFragmentActivity.a.cnd();
            if ("pushcontent_notification".equals(t.j(getIntent(), "nofification_type")) && !bh.ov(t.j(getIntent(), "Main_FromUserName"))) {
                x.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + t.j(getIntent(), "Main_FromUserName") + t.a(getIntent(), "MainUI_User_Last_Msg_Type", 0));
                com.tencent.mm.plugin.report.service.g.pQN.h(10856, new Object[]{Integer.valueOf(r1), j, Integer.valueOf(0)});
            }
            j = t.j(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (j != null) {
                if (j.equals("launch_type_voip")) {
                    x.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
                    startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip"));
                    com.tencent.mm.plugin.report.service.g.pQN.h(11034, new Object[]{Integer.valueOf(2), Integer.valueOf(0)});
                } else if (j.equals("launch_type_voip_audio")) {
                    x.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
                    startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio"));
                    com.tencent.mm.plugin.report.service.g.pQN.h(11034, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
                }
            }
            j = t.j(getIntent(), "LauncherUI.switch.tab");
            if (!bh.ov(j)) {
                this.xGS.xGh.Yp(j);
                getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if (t.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false) || this.xGX) {
                this.xGX = false;
                cmG = cmG();
                if (cmG != null) {
                    cmG.xGS.cmz();
                }
                getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
                getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            a = t.a(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (a) {
                j = t.j(getIntent(), "LauncherUI.Shortcut.Username");
            } else {
                a = t.a(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
                j = getIntent().getAction();
            }
            if (a) {
                x.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = " + j);
                if (!bh.ov(j)) {
                    vD = com.tencent.mm.plugin.base.model.b.vD(j);
                    if (!bh.ov(vD)) {
                        if (com.tencent.mm.z.s.gE(vD)) {
                            x.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                            if (!com.tencent.mm.ag.f.jV(vD)) {
                                cmG = cmG();
                                if (cmG != null) {
                                    cmG.startChatting(vD, null, false);
                                }
                            } else if (com.tencent.mm.ag.f.eE(vD)) {
                                intent = new Intent();
                                intent.setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                                intent.putExtra("Contact_User", vD);
                                intent.putExtra("biz_chat_from_scene", 9);
                                intent.addFlags(67108864);
                                startActivity(intent);
                            } else if (com.tencent.mm.ag.f.jX(vD)) {
                                intent = new Intent();
                                intent.setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
                                intent.putExtra("enterprise_biz_name", vD);
                                intent.putExtra("enterprise_biz_display_name", r.gu(vD));
                                startActivity(intent);
                            } else if (com.tencent.mm.ag.f.jY(vD)) {
                                d jS = com.tencent.mm.ag.f.jS(vD);
                                j = jS == null ? null : jS.Li();
                                if (j == null) {
                                    j = "";
                                }
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", j);
                                intent2.putExtra("useJs", true);
                                intent2.putExtra("srcUsername", vD);
                                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                                intent2.addFlags(67108864);
                                com.tencent.mm.bm.d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                            } else {
                                cmG = cmG();
                                Bundle bundle = new Bundle();
                                bundle.putInt("chat_from_scene", 3);
                                cmG.startChatting(vD, bundle, false);
                            }
                        }
                        getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                        getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                    }
                }
            }
            this.xGW = true;
        } else {
            x.i("MicroMsg.LauncherUI", "resumeLogoutJump");
            com.tencent.mm.ui.MMFragmentActivity.a.cnd();
            j = aq.hfP.H("login_user_name", "");
            if (ar.Hi() || !j.equals("")) {
                com.tencent.mm.plugin.report.service.f.vB(8);
                com.tencent.mm.kernel.b Di = g.Di();
                Di.gPJ.a(new bd(new com.tencent.mm.kernel.b.3(Di), "reset accinfo"), 0);
                x.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", new Object[]{Boolean.valueOf(this.xGV), Boolean.valueOf((this.fzg.getFlags() & 67108864) == 67108864), Boolean.valueOf(t.a(this.fzg, "Intro_Notify", false)), Boolean.valueOf(ar.Cs())});
                x.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", new Object[]{Boolean.valueOf(ar.Hi())});
                if (t.a(this.fzg, "key_transit_to_switch_account", false)) {
                    x.i("MicroMsg.LauncherUI", "transit to fake switch account");
                    this.fzg.removeExtra("key_transit_to_switch_account");
                    sharedPreferences = ac.getContext().getSharedPreferences("switch_account_preferences", 0);
                    vD = sharedPreferences.getString("last_switch_account_to_wx_username", "");
                    sharedPreferences.edit().putBoolean("transit_to_switch_account", true).commit();
                    intent = new Intent();
                    String H = aq.hfP.H("login_weixin_username", "");
                    intent.putParcelableArrayListExtra("key_switch_account_users", this.fzg.getParcelableArrayListExtra("key_switch_account_users"));
                    intent.putExtra("key_switch_from_wx_username", H);
                    intent.putExtra("key_switch_to_wx_username", vD);
                    intent.putExtra("key_langauage_code", w.d(getSharedPreferences(ac.cfs(), 0)));
                    x.i("MicroMsg.LauncherUI", "mm pid %d", new Object[]{Integer.valueOf(Process.myPid())});
                    intent.putExtra("key_mm_process_pid", Process.myPid());
                    intent.setClassName(this, "com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI");
                    startActivity(intent);
                    com.tencent.mm.ui.base.b.fH(this);
                    ag.h(new Runnable(this) {
                        final /* synthetic */ LauncherUI xHf;

                        {
                            this.xHf = r1;
                        }

                        public final void run() {
                            ar.hold();
                            com.tencent.mm.sdk.b.a.xef.m(new com.tencent.mm.g.a.w());
                            g.Dk().fM("switch account ,delay logout");
                            if (t.a(this.xHf.getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
                                this.xHf.xGX = true;
                            }
                            this.xHf.fq(this.xHf);
                            ar.unhold();
                        }
                    }, 500);
                } else {
                    ar.hold();
                    com.tencent.mm.sdk.b.a.xef.m(new com.tencent.mm.g.a.w());
                    g.Dk().fM("[" + this.xGV + " " + cmM + " " + a + "]");
                    if (t.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
                        this.xGX = true;
                    }
                    fq(this);
                    ar.unhold();
                }
            } else {
                if (this.xGY != null) {
                    this.xGY.cot();
                }
                x.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
                ag.K(this.xHe);
                ag.h(this.xHe, 2000);
            }
        }
        com.tencent.mm.blink.a.fh(5);
        lT(false);
        cmJ();
        com.tencent.mm.blink.a.ec("LauncherUI");
    }

    private boolean cmK() {
        if (this.fzg == null || t.a(this.fzg, "Intro_Switch", false) || !ar.Hi() || ar.Cs()) {
            return false;
        }
        return true;
    }

    private boolean cmL() {
        if (this.fzg != null && (t.a(this.fzg, "absolutely_exit", false) || t.a(this.fzg, "absolutely_exit_pid", 0) == Process.myPid())) {
            x.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", new Object[]{Integer.valueOf(hashCode())});
            finish();
            com.tencent.mm.plugin.report.service.f.vB(8);
            MMAppMgr.lW(t.a(this.fzg, "kill_service", true));
            System.exit(0);
            return true;
        } else if (this.fzg == null || !t.a(this.fzg, "can_finish", false)) {
            return false;
        } else {
            x.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
            ar.CG().bC(true);
            if (k.aX(getApplicationContext())) {
                Context applicationContext = getApplicationContext();
                applicationContext.stopService(new Intent(applicationContext, CoreService.class));
            }
            com.tencent.mm.plugin.report.service.f.vB(8);
            sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
            finish();
            com.tencent.mm.ui.base.b.fG(this);
            return true;
        }
    }

    private void aj(Intent intent) {
        x.i("MicroMsg.LauncherUI", "handleJump");
        if (ar.Hj()) {
            com.tencent.mm.sdk.b.b irVar = new ir();
            irVar.fzf.fzg = this.fzg;
            com.tencent.mm.sdk.b.a.xef.m(irVar);
            String j;
            if ("talkroom_notification".equals(t.j(intent, "nofification_type"))) {
                j = t.j(intent, "enter_chat_usrname");
                if (!bh.ov(j)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("enter_room_username", j);
                    intent2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    com.tencent.mm.bm.d.b(this, "talkroom", ".ui.TalkRoomUI", intent2);
                    return;
                }
                return;
            } else if ("back_to_pcmgr_notification".equals(intent.getStringExtra("nofification_type"))) {
                if (intent.getBooleanExtra("newPCBackup", true)) {
                    x.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
                    r0 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
                } else {
                    x.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BakToPcUI");
                    r0 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");
                }
                r0.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                MMWizardActivity.A(this, r0);
                return;
            } else if ("back_to_pcmgr_error_notification".equals(intent.getStringExtra("nofification_type"))) {
                r0 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
                r0.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                MMWizardActivity.A(this, r0);
                return;
            } else if ("backup_move_notification".equals(intent.getStringExtra("nofification_type"))) {
                r0 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
                r0.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                MMWizardActivity.A(this, r0);
                return;
            } else {
                int a;
                if (t.a(intent, "show_update_dialog", false)) {
                    a = t.a(intent, "update_type", -1);
                    if (a == -1) {
                        x.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
                    } else {
                        com.tencent.mm.plugin.report.service.g.pQN.a(405, 28, 1, true);
                        if (com.tencent.mm.pluginsdk.q.x.bYd() != null) {
                            com.tencent.mm.pluginsdk.q.s a2 = com.tencent.mm.pluginsdk.q.x.bYd().a(this, null);
                            if (a2 != null) {
                                com.tencent.mm.plugin.report.service.g.pQN.a(405, a == 2 ? 29 : 30, 1, true);
                                a2.update(a);
                            }
                        }
                    }
                }
                String j2 = t.j(intent, "Main_User");
                if (j2 == null || j2.equals("")) {
                    a = 0;
                } else {
                    ar.Hg();
                    aj WY = com.tencent.mm.z.c.Fd().WY(j2);
                    if (WY != null) {
                        a = WY.field_unReadCount;
                    } else {
                        a = 0;
                    }
                    x.i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", new Object[]{j2, WY, Integer.valueOf(a)});
                }
                if (a == 0) {
                    a = t.a(intent, "pushcontent_unread_count", 0);
                }
                MMAppMgr.up();
                com.tencent.mm.sdk.b.a.xef.m(new ab());
                boolean a3 = t.a(intent, "Intro_Is_Muti_Talker", true);
                x.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", new Object[]{Boolean.valueOf(a3), Integer.valueOf(a)});
                if (!a3 && a > 0 && t.a(intent, "Intro_Bottle_unread_count", 0) > 0) {
                    x.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", new Object[]{Integer.valueOf(t.a(intent, "Intro_Bottle_unread_count", 0))});
                    com.tencent.mm.bm.d.y(this, "bottle", ".ui.BottleConversationUI");
                }
                LauncherUI cmG;
                Bundle bundle;
                if (a3 || a <= 0) {
                    if (t.a(intent, "From_fail_notify", false)) {
                        if (!bh.ov(j2)) {
                            cmG = cmG();
                            if (cmG != null) {
                                bundle = new Bundle();
                                bundle.putBoolean("Chat_Mode", t.a(intent, "resend_fail_messages", false));
                                if (com.tencent.mm.ag.f.eE(j2)) {
                                    intent.putExtra("Contact_User", j2);
                                    intent.addFlags(67108864);
                                    intent.putExtra("biz_chat_from_scene", 4);
                                    com.tencent.mm.bm.d.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                                } else {
                                    cmG.startChatting(j2, bundle, false);
                                }
                            }
                        } else if (t.a(intent, "jump_sns_from_notify", false)) {
                            r0 = new Intent();
                            r0.addFlags(67108864);
                            r0.putExtra("is_need_resend_sns", intent.getBooleanExtra("is_need_resend_sns", false));
                            r0.putExtra("sns_resume_state", intent.getBooleanExtra("sns_resume_state", false));
                            r0.putExtra("sns_timeline_NeedFirstLoadint", intent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
                            com.tencent.mm.bm.d.b(this, "sns", ".ui.SnsTimeLineUI", r0);
                        }
                    } else if (t.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false) && cmG() != null && com.tencent.mm.ag.f.eE(j2)) {
                        intent.putExtra("Contact_User", j2);
                        intent.addFlags(67108864);
                        com.tencent.mm.bm.d.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                    }
                } else if (com.tencent.mm.z.s.gV(j2)) {
                    x.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
                    r0 = new Intent();
                    r0.addFlags(67108864);
                    r0.putExtra(DownloadSettingTable$Columns.TYPE, 20);
                    com.tencent.mm.bm.d.b(this, "readerapp", ".ui.ReaderAppUI", r0);
                } else if (com.tencent.mm.z.s.hc(j2)) {
                    x.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
                    r0 = new Intent();
                    r0.addFlags(67108864);
                    r0.putExtra(DownloadSettingTable$Columns.TYPE, 11);
                    com.tencent.mm.bm.d.b(this, "readerapp", ".ui.ReaderAppUI", r0);
                } else {
                    if (intent.getIntExtra("MainUI_User_Last_Msg_Type", 34) == 34) {
                        a = 2;
                    } else {
                        a = 1;
                    }
                    bundle = new Bundle();
                    bundle.putInt("Chat_Mode", a);
                    if ("new_msg_nofification".equals(t.j(intent, "nofification_type"))) {
                        bundle.putInt("chat_from_scene", 1);
                    }
                    cmG = cmG();
                    if (cmG != null) {
                        if (com.tencent.mm.ag.f.eE(j2)) {
                            intent.putExtra("Contact_User", j2);
                            intent.addFlags(67108864);
                            intent.putExtra("biz_chat_from_scene", 4);
                            com.tencent.mm.bm.d.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                        } else if (com.tencent.mm.ag.f.jY(j2)) {
                            d jS = com.tencent.mm.ag.f.jS(j2);
                            j = jS == null ? null : jS.Li();
                            if (j == null) {
                                j = "";
                            }
                            intent.putExtra("rawUrl", j);
                            intent.putExtra("useJs", true);
                            intent.putExtra("srcUsername", j2);
                            intent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                            intent.addFlags(67108864);
                            com.tencent.mm.bm.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                        } else if (com.tencent.mm.storage.x.fV(j2)) {
                            intent.putExtra("Contact_User", j2);
                            intent.addFlags(67108864);
                            intent.putExtra("app_brand_conversation_from_scene", 3);
                            intent.putExtra("finish_direct", true);
                            intent.putExtra("key_need_send_video", false);
                            com.tencent.mm.bm.d.a((Context) this, ".ui.conversation.AppBrandServiceConversationUI", intent);
                        } else {
                            cmG.startChatting(j2, bundle, false);
                        }
                    }
                }
                if (t.a(intent, "kstyle_show_bind_mobile_afterauth", 0) > 0) {
                    r0 = new Intent();
                    r0.setClassName(this, "com.tencent.mm.ui.account.bind.BindMobileUI");
                    r0.putExtra("kstyle_bind_recommend_show", intent.getIntExtra("kstyle_bind_recommend_show", 0));
                    r0.putExtra("kstyle_bind_wording", intent.getParcelableExtra("kstyle_bind_wording"));
                    MMWizardActivity.A(this, r0);
                    return;
                }
                return;
            }
        }
        x.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
        startActivity(new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864));
        finish();
    }

    private void fq(Context context) {
        Intent intent;
        if (t.a(this.fzg, "LauncherUI.jump_switch_account", false)) {
            x.i("MicroMsg.LauncherUI", "launcher to switch account");
            SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("switch_account_preferences", 0);
            String string = sharedPreferences.getString("last_switch_account_to_wx_username", "");
            x.i("MicroMsg.LauncherUI", "switch to wxid %s", new Object[]{string});
            sharedPreferences.edit().putBoolean("transit_to_switch_account", false).commit();
            intent = new Intent();
            intent.setClass(this, SettingsSwitchAccountUI.class);
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.putExtra("key_scene", 1);
            startActivity(intent);
            com.tencent.mm.ui.base.b.fH(this);
            this.fzg.removeExtra("LauncherUI.jump_switch_account");
        } else if (t.a(this.fzg, "Intro_Switch", false) || (ar.Cs() && this.xGV)) {
            BaseEvent.onSingalCrash(0);
            x.i("MicroMsg.LauncherUI", "switch users count %d", new Object[]{Integer.valueOf(bq.hhK.HV().size())});
            x.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
            x.cfk();
            ar.unhold();
            finish();
            if (!ac.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("transit_to_switch_account", false)) {
                intent = new Intent(context, LauncherUI.class);
                intent.addFlags(67108864);
                context.startActivity(intent);
            }
            x.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[]{Integer.valueOf(Process.myPid())});
            Process.killProcess(Process.myPid());
        } else if (!t.a(this.fzg, "LauncherUI.jump_switch_account", false)) {
            x.i("MicroMsg.LauncherUI", "jumpToLogin %s", new Object[]{aq.hfP.H("login_user_name", "")});
            if (!bh.ov(aq.hfP.H("login_user_name", ""))) {
                x.i("MicroMsg.LauncherUI", "switchAccount %s", new Object[]{Boolean.valueOf(ac.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false))});
                if (ac.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false)) {
                    intent = new Intent(this, SettingsSwitchAccountUI.class);
                    intent.addFlags(67108864);
                    intent.putExtra("key_scene", 2);
                    startActivity(intent);
                } else {
                    int VI = bh.VI(aq.hfP.H("last_login_use_voice", ""));
                    x.i("MicroMsg.LauncherUI", "pluginSwitch  " + VI);
                    if ((VI & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                        startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.account.LoginVoiceUI"));
                    } else {
                        startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.account.LoginPasswordUI"));
                    }
                }
                com.tencent.mm.ui.base.b.fE(this);
            } else if (this.xGY == null) {
                this.xGY = new WelcomeSelectView(this);
                setContentView(this.xGY);
                this.xGY.cot();
            }
            com.tencent.mm.plugin.report.service.f.vB(8);
            ag.K(this.xHe);
            ag.h(this.xHe, 2000);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        super.onActivityResult(i, i2, intent);
        x.v("MicroMsg.LauncherUI", "edw on activity result");
        z zVar = this.xGT;
        if (i == 2001 && zVar.xLx != null) {
            zVar.xLx.onActivityResult(i, i2, intent);
        }
        x.w("MicroMsg.LauncherUI.NewChattingTabUI", "check request code %d", new Object[]{Integer.valueOf(65535 & i)});
        switch (65535 & i) {
            case com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX /*217*/:
            case 218:
            case com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX /*226*/:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z && zVar.xLx == null) {
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
            ag.K(zVar.xLJ);
            zVar.xLJ.xLT = 0;
            zVar.xLJ.fyV = i;
            zVar.xLJ.bjW = i2;
            zVar.xLJ.fyW = intent;
            ag.y(zVar.xLJ);
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            HomeUI homeUI = this.xGS;
            if (!homeUI.xFW) {
                return;
            }
            if (i == 1) {
                ar.Hg();
                if (!com.tencent.mm.platformtools.t.c((Boolean) com.tencent.mm.z.c.CU().get(12323, null))) {
                    com.tencent.mm.platformtools.m.a(homeUI.xFE, null, false, 3);
                    return;
                }
                return;
            }
            if (i == 22722) {
                x.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (i2 == 102001) {
                    g.CG().a(new com.tencent.mm.modelsimple.w(1), 0);
                } else if (i2 == 102002) {
                    g.CG().a(new com.tencent.mm.modelsimple.w(2), 0);
                }
            }
            if (i == 65534 && i2 == -1) {
                ae.Vd("welcome_page_show");
                k.e(homeUI.xFE, true);
                MMAppMgr.up();
                MMAppMgr.b(homeUI.xFE, true);
                homeUI.xFE.finish();
            }
        }
    }

    protected void onPause() {
        x.d("MicroMsg.LauncherUI", "onPause, chatting is show ");
        super.onPause();
        s sVar = this.xGZ;
        boolean ch = sVar.ch("onPause");
        if (ch) {
            sVar.vcF = false;
        }
        if (ch) {
            x.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
            return;
        }
        com.tencent.mm.blink.a.wk();
        x.i("MicroMsg.LauncherUI", "not skip this onPause");
        u currentFragmet = getCurrentFragmet();
        this.xHd.removeCallbacksAndMessages(null);
        HomeUI homeUI = this.xGS;
        w wVar = homeUI.xGh;
        x.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", new Object[]{Integer.valueOf(wVar.mnk), Boolean.valueOf(homeUI.xFW)});
        if (homeUI.xFW) {
            wVar.cnh();
        }
        x xVar = wVar.xKx;
        if (ar.Hj()) {
            ar.Hg();
            com.tencent.mm.z.c.CU().b(xVar.xKT);
            ar.Hg();
            com.tencent.mm.z.c.Fd().b(xVar);
            com.tencent.mm.s.c.Bq().b(xVar.xKS);
            com.tencent.mm.sdk.b.a.xef.c(xVar.xKU);
            com.tencent.mm.sdk.b.a.xef.c(xVar.xFm);
            com.tencent.mm.sdk.b.a.xef.c(xVar.xFl);
        }
        j jVar = homeUI.xGg;
        if (jVar.xFH != null) {
            ar.CG().b(255, jVar.xFH);
            ar.CG().b(384, jVar.xFH);
            jVar.xFH = null;
        }
        com.tencent.mm.sdk.a.b.bD(false);
        homeUI.xGe = com.tencent.mm.ui.HomeUI.a.xGE;
        if (!ar.GZ()) {
            ar.getNotification().aU(false);
        }
        boolean cmM = homeUI.xGf.cmM();
        x.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show " + cmM);
        if (!cmM) {
            k.a(homeUI.xFE, 4, homeUI.xGh.mnk, "directReport_onPause");
        }
        if (!homeUI.xFE.isFinishing()) {
            l.a(homeUI.xFE);
        }
        if (homeUI.xFW) {
            x.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
            com.tencent.mm.blink.b.wo().wq();
            ((n) g.k(n.class)).getSysCmdMsgExtension().a("showprivacypolicy", homeUI.xGu);
            if (ar.Hj()) {
                com.tencent.mm.sdk.b.a.xef.c(homeUI.xGq);
            }
        }
        if (homeUI.xFZ != null && homeUI.xFZ.isShowing()) {
            homeUI.xFZ.dismiss();
        }
        z zVar = this.xGT;
        if (zVar.cmM()) {
            zVar.pY(4);
            if (zVar.xLx != null && zVar.xLx.isSupportNavigationSwipeBack()) {
                zVar.xLx.getSwipeBackLayout().mEnable = false;
            }
        }
        if (currentFragmet == null) {
            this.xGW = false;
        }
    }

    protected void onStop() {
        x.i("MicroMsg.LauncherUI", "onStop");
        com.tencent.mm.blink.a.wk();
        super.onStop();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.xHc = false;
        if (!this.xGU.a(this, i, strArr, iArr)) {
            int i2;
            HomeUI homeUI = this.xGS;
            switch (i) {
                case 16:
                case 80:
                    i2 = i == 80 ? R.l.ezQ : R.l.ezM;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(homeUI.xFE, homeUI.getString(i2), homeUI.getString(R.l.ezT), homeUI.getString(R.l.est), homeUI.getString(R.l.cancel), false, new 14(homeUI), new 15(homeUI));
                        break;
                    }
                    break;
                case 65:
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(homeUI.xFE, homeUI.getString(R.l.ezP), homeUI.getString(R.l.ezT), homeUI.getString(R.l.est), homeUI.getString(R.l.cancel), false, new 16(homeUI), null);
                        break;
                    } else {
                        homeUI.cmy();
                        break;
                    }
                case 66:
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(homeUI.xFE, homeUI.getString(R.l.ezP), homeUI.getString(R.l.ezT), homeUI.getString(R.l.est), homeUI.getString(R.l.cancel), false, new HomeUI.17(homeUI), null);
                        break;
                    }
                    u cng = homeUI.xGh.cng();
                    if (cng instanceof h) {
                        ((h) cng).cmm();
                        break;
                    }
                    break;
            }
            z zVar = this.xGT;
            switch (i) {
                case 18:
                    if (iArr[0] != 0) {
                        i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.ezM : R.l.ezQ;
                        if (iArr[0] != 0) {
                            com.tencent.mm.ui.base.h.a(zVar.qwI, zVar.getString(i2), zVar.getString(R.l.ezT), zVar.getString(R.l.est), zVar.getString(R.l.cancel), false, new z.1(zVar), new 10(zVar));
                            return;
                        }
                        return;
                    } else if (zVar.xLx != null) {
                        zVar.xLx.ywe.ctQ();
                        return;
                    } else {
                        return;
                    }
                case 19:
                case 21:
                case 22:
                    if (iArr[0] != 0) {
                        i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.ezM : R.l.ezQ;
                        if (iArr[0] != 0) {
                            com.tencent.mm.ui.base.h.a(zVar.qwI, zVar.getString(i2), zVar.getString(R.l.ezT), zVar.getString(R.l.est), zVar.getString(R.l.cancel), false, new 11(zVar), new z.12(zVar));
                            return;
                        }
                        return;
                    } else if (zVar.xLx == null) {
                        return;
                    } else {
                        if (i == 19) {
                            zVar.xLx.ywe.bjC();
                            return;
                        } else if (i == 21) {
                            zVar.xLx.ywe.crC();
                            return;
                        } else {
                            zVar.xLx.ywe.crA();
                            return;
                        }
                    }
                case 20:
                    if (iArr[0] == 0) {
                        zVar.xLx.ywe.crE();
                        return;
                    } else {
                        com.tencent.mm.ui.base.h.a(zVar.qwI, zVar.getString(R.l.ezM), zVar.getString(R.l.ezT), zVar.getString(R.l.est), zVar.getString(R.l.cancel), false, new 13(zVar), null);
                        return;
                    }
                case 67:
                case 68:
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(zVar.qwI, zVar.getString(R.l.ezP), zVar.getString(R.l.ezT), zVar.getString(R.l.est), zVar.getString(R.l.cancel), false, new z.14(zVar), null);
                        return;
                    } else if (i == 67) {
                        zVar.xLx.yvX.ctS();
                        return;
                    } else {
                        zVar.xLx.yvX.ctT();
                        return;
                    }
                case 81:
                    if (iArr[0] == 0) {
                        zVar.xLx.ywe.crD();
                        return;
                    } else {
                        com.tencent.mm.ui.base.h.a(zVar.qwI, zVar.getString(R.l.ezP), zVar.getString(R.l.ezT), zVar.getString(R.l.est), zVar.getString(R.l.cancel), false, new z.15(zVar), null);
                        return;
                    }
                case 82:
                case 83:
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(zVar.qwI, zVar.getString(R.l.ezQ), zVar.getString(R.l.ezT), zVar.getString(R.l.est), zVar.getString(R.l.cancel), false, new z$16(zVar), null);
                        return;
                    } else if (i == 82) {
                        zVar.xLx.ywe.bjB();
                        return;
                    } else {
                        zVar.xLx.ywe.crB();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    protected void onDestroy() {
        com.tencent.mm.blink.a.wk();
        super.onDestroy();
        HomeUI homeUI = this.xGS;
        w wVar = homeUI.xGh;
        com.tencent.mm.sdk.b.a.xef.c(wVar.xKF);
        wVar.xKH.clear();
        if (homeUI.xGg != null) {
            j jVar = homeUI.xGg;
            com.tencent.mm.sdk.b.a.xef.c(jVar.xFJ);
            com.tencent.mm.sdk.b.a.xef.c(jVar.xFK);
        }
        if (homeUI.xFW) {
            Looper.myQueue().removeIdleHandler(homeUI.xGr);
        }
        if (homeUI.xGp != null) {
            homeUI.xGp.vmB = null;
        }
        z zVar = this.xGT;
        if (!(zVar.mPrepareBitmap == null || zVar.mPrepareBitmap.isRecycled())) {
            zVar.mPrepareBitmap.recycle();
        }
        ag.K(zVar.xLK);
        Looper.myQueue().removeIdleHandler(zVar.xLE);
        cmI();
        x.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bh.fb(this), Integer.valueOf(xGP.size())});
    }

    public void finish() {
        super.finish();
        cmI();
        x.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(xGP.size()), bh.cgy()});
    }

    public void onSwipe(float f) {
        int i = 1;
        if (this.xGV) {
            z zVar = this.xGT;
            x.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", new Object[]{Float.valueOf(f), Long.valueOf(240), Boolean.valueOf(zVar.xLy.cmA())});
            if (zVar.cny()) {
                ImageView imageView;
                boolean z;
                if (f == 0.0f && !zVar.mChattingClosed) {
                    imageView = (ImageView) zVar.qwI.getWindow().getDecorView().findViewById(R.h.cDn);
                    if (imageView != null) {
                        ViewGroup viewGroup = (ViewGroup) imageView.getTag();
                        if (viewGroup != null) {
                            Bitmap magicDrawingCache = zVar.getMagicDrawingCache(viewGroup);
                            if (magicDrawingCache != null) {
                                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView VISIBLE");
                                imageView.setVisibility(0);
                                imageView.setImageBitmap(magicDrawingCache);
                                viewGroup.setVisibility(8);
                            } else {
                                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
                                viewGroup.setVisibility(0);
                                imageView.setVisibility(8);
                                imageView.setImageDrawable(null);
                            }
                        }
                    }
                    if (zVar.mChattingInAnim != null) {
                        zVar.mChattingInAnim.cancel();
                    }
                } else if (f == 1.0f && !zVar.mChattingClosed && zVar.cny()) {
                    zVar.qwI.getWindow().setBackgroundDrawableResource(R.e.btE);
                    imageView = (ImageView) zVar.qwI.getWindow().getDecorView().findViewById(R.h.cDn);
                    if (!(imageView == null || imageView.getVisibility() != 0 || imageView.getTag() == null)) {
                        ((View) imageView.getTag()).setVisibility(0);
                        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
                        imageView.setVisibility(8);
                    }
                }
                if (zVar.xLy.cmA()) {
                    z = true;
                } else if (Float.compare(1.0f, f) > 0) {
                    x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", new Object[]{Boolean.valueOf(false)});
                    i = 0;
                } else {
                    z = false;
                }
                View findViewById = zVar.qwI.findViewById(R.h.csz);
                imageView = (ImageView) zVar.qwI.findViewById(R.h.cDn);
                if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null || zVar.mChattingClosed || f == 1.0f || f == 0.0f)) {
                    imageView.setVisibility(0);
                    x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                }
                x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[resetViewTranX] scrollParent:%s", new Object[]{Float.valueOf(f)});
                if (Float.compare(1.0f, f) <= 0) {
                    com.tencent.mm.ui.tools.j.n(findViewById, 0.0f);
                    com.tencent.mm.ui.tools.j.n(imageView, 0.0f);
                } else if (imageView == null || imageView.getDrawable() == null) {
                    x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[resetViewTranX] container");
                    com.tencent.mm.ui.tools.j.n(findViewById, (((float) (findViewById.getWidth() / 4)) * (1.0f - f)) * -1.0f);
                } else {
                    x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[resetViewTranX] prepareView");
                    com.tencent.mm.ui.tools.j.n(imageView, (((float) (imageView.getWidth() / 4)) * (1.0f - f)) * -1.0f);
                }
                boolean z2 = z;
            }
            if (i == 0) {
                super.onSwipe(f);
            }
        }
    }

    public void onSettle(boolean z, int i) {
        if (this.xGV && !this.xGT.w(z, i)) {
            super.onSettle(z, i);
        }
    }

    public boolean forceRemoveNoMatchOnPath() {
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        int i;
        if (this.xGT.cmM()) {
            z zVar = this.xGT;
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
                ag.K(zVar.xLK);
            }
            if (zVar.isAnimating) {
                z = true;
            } else {
                z = zVar.xLx.onKeyDown(keyEvent.getKeyCode(), keyEvent);
            }
            if (z) {
                return true;
            }
        }
        HomeUI homeUI = this.xGS;
        x.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", new Object[]{Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction())});
        com.tencent.mm.compatible.b.f.xK();
        com.tencent.mm.compatible.b.f.xK();
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && homeUI.xFZ != null && homeUI.xFZ.isShowing()) {
            homeUI.xFZ.dismiss();
            i = 1;
        } else if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1) {
            homeUI.cmx();
            i = 1;
        } else {
            u cng = homeUI.xGh.cng();
            if (cng == null || !cng.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
                if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
                    if (homeUI.xGp == null || homeUI.xGp.getVisibility() != 0) {
                        if (ar.Hj() && g.Dh().gPy && com.tencent.mm.sdk.platformtools.an.isWap(homeUI.xFE)) {
                            Context context = homeUI.xFE;
                            OnClickListener 9 = new 9(homeUI);
                            if (ar.Hj()) {
                                ar.Hg();
                                int intValue = ((Integer) com.tencent.mm.z.c.CU().get(65, Integer.valueOf(0))).intValue();
                                if (intValue >= 5) {
                                    z = false;
                                } else if (ae.Vc("show_wap_adviser")) {
                                    View inflate = View.inflate(context, R.i.doW, null);
                                    ((TextView) inflate.findViewById(R.h.czk)).setText(R.l.exN);
                                    i$a com_tencent_mm_ui_base_i_a = new i$a(context);
                                    com_tencent_mm_ui_base_i_a.Ez(R.l.dGO);
                                    com_tencent_mm_ui_base_i_a.dk(inflate);
                                    com_tencent_mm_ui_base_i_a.EC(R.l.dFU).a(new MMAppMgr$9(intValue));
                                    com_tencent_mm_ui_base_i_a.mi(false);
                                    com_tencent_mm_ui_base_i_a.ED(R.l.exK).b(new MMAppMgr.10());
                                    com_tencent_mm_ui_base_i_a.a(new MMAppMgr.11(9));
                                    com_tencent_mm_ui_base_i_a.akx().show();
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else {
                                z = false;
                            }
                            if (z) {
                                i = 1;
                            }
                        }
                        int backgroundLimitType = com.tencent.mm.sdk.platformtools.an.getBackgroundLimitType(homeUI.xFE);
                        if (ar.Hj() && g.Dh().gPy && com.tencent.mm.sdk.platformtools.an.isLimited(backgroundLimitType)) {
                            ar.Hg();
                            if (com.tencent.mm.platformtools.t.b((Boolean) com.tencent.mm.z.c.CU().get(16385, null)) && MMAppMgr.a(homeUI.xFE, backgroundLimitType, new HomeUI.10(homeUI, backgroundLimitType), new HomeUI$11(homeUI))) {
                                i = 1;
                            }
                        }
                        homeUI.clA();
                    } else {
                        homeUI.xGp.caJ();
                        i = 1;
                    }
                }
                z = false;
            } else {
                i = 1;
            }
        }
        if (i != 0) {
            return true;
        }
        try {
            return super.dispatchKeyEvent(keyEvent);
        } catch (Throwable e) {
            x.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.LauncherUI", e, "", new Object[0]);
            return false;
        }
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.xGT.xLG = bundle.getString("last_restore_talker");
        x.d("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", new Object[]{r0.xLG});
    }

    protected void onSaveInstanceState(Bundle bundle) {
        z zVar = this.xGT;
        if (zVar.xLx != null && !com.tencent.mm.platformtools.t.ov(zVar.xLx.crz())) {
            x.d("MicroMsg.LauncherUI.NewChattingTabUI", "onSaveInstanceState:%s", new Object[]{zVar.xLx.crz()});
            bundle.putString("last_restore_talker", zVar.xLx.crz());
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z = false;
        HomeUI homeUI = this.xGS;
        u currentFragmet = homeUI.xFE.getCurrentFragmet();
        if ((currentFragmet == null || !currentFragmet.isShowing()) && !homeUI.xGf.cmM()) {
            if (menuItem.getItemId() == 2) {
                com.tencent.mm.plugin.report.service.g.pQN.k(10919, "0");
                homeUI.cmx();
            } else if (menuItem.getItemId() == 1) {
                homeUI.cmy();
            }
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.xGT.cmM()) {
            return false;
        }
        HomeUI homeUI = this.xGS;
        if (homeUI.xGf.cmM()) {
            return false;
        }
        int dimensionPixelSize;
        int height = homeUI.xFE.getSupportActionBar().getHeight();
        if (height == 0) {
            DisplayMetrics displayMetrics = homeUI.xFE.getResources().getDisplayMetrics();
            dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? homeUI.xFE.getResources().getDimensionPixelSize(R.f.buF) : homeUI.xFE.getResources().getDimensionPixelSize(R.f.buG);
        } else {
            dimensionPixelSize = height;
        }
        homeUI.xGn = menu.add(0, 1, 0, R.l.eRj);
        homeUI.xGn.setIcon(R.k.dvb);
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(homeUI.xFE, 68);
        homeUI.xGo = menu.add(0, 2, 0, R.l.eRi);
        if (homeUI.xGk == null) {
            LayoutParams layoutParams = new LayoutParams(fromDPToPix, dimensionPixelSize);
            homeUI.xGk = b.DY().a(homeUI.xFE, "R.layout.actionview_with_dot_tips", R.i.cZY);
            homeUI.xGl = (ImageView) homeUI.xGk.findViewById(R.h.icon);
            homeUI.xGm = homeUI.xGk.findViewById(R.h.cRY);
            homeUI.xGk.setLayoutParams(layoutParams);
            homeUI.xGk.setBackgroundResource(R.g.byA);
            homeUI.xGk.setMinimumHeight(dimensionPixelSize);
            homeUI.xGk.setMinimumWidth(fromDPToPix);
            homeUI.xGl.setImageResource(R.k.duO);
            homeUI.xGk.setContentDescription(homeUI.getString(R.l.eRi));
            homeUI.xGk.setOnClickListener(new 25(homeUI));
            homeUI.xGk.post(new HomeUI$2(homeUI));
        }
        com.tencent.mm.blink.b.wo().f(new HomeUI.3(homeUI));
        android.support.v4.view.m.a(homeUI.xGo, homeUI.xGk);
        if (homeUI.xGn != null) {
            android.support.v4.view.m.a(homeUI.xGn, 2);
            homeUI.xGn.setVisible(true);
        }
        if (homeUI.xGo != null) {
            android.support.v4.view.m.a(homeUI.xGo, 2);
            homeUI.xGo.setVisible(true);
        }
        homeUI.xGk.getLayoutParams().width = fromDPToPix;
        homeUI.xGk.getLayoutParams().height = dimensionPixelSize;
        x.v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        HomeUI homeUI = this.xGS;
        e.a(homeUI.xFE, homeUI.contentView);
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        ActionMode actionMode = null;
        z zVar = this.xGT;
        if (!(zVar.xLx == null || zVar.xLx.ywh.yzo == null || !zVar.xLx.isSupportNavigationSwipeBack() || com.tencent.mm.compatible.util.d.fO(22))) {
            ActionMode startActionMode = zVar.xLx.ywh.yzo.startActionMode(callback);
            if (startActionMode != null) {
                actionMode = startActionMode;
            }
        }
        if (actionMode == null) {
            return super.onWindowStartingActionMode(callback);
        }
        return actionMode;
    }

    public u getCurrentFragmet() {
        z zVar = this.xGT;
        u uVar = !zVar.mChattingClosed ? zVar.xLx : null;
        if (uVar == null) {
            return super.getCurrentFragmet();
        }
        return uVar;
    }

    public static void fr(Context context) {
        Intent intent = new Intent(context, LauncherUI.class);
        intent.addFlags(67108864);
        context.startActivity(intent);
    }

    public final void startChatting(String str, Bundle bundle, boolean z) {
        HomeUI homeUI = this.xGS;
        if (q.GA().booleanValue() && (HomeUI.xGa.booleanValue() || HomeUI.xGb.booleanValue())) {
            homeUI.c(Boolean.valueOf(false), Boolean.valueOf(false));
        }
        homeUI.xGh.cni();
        this.xGT.startChatting(str, bundle, z);
    }

    public final void closeChatting(boolean z) {
        boolean z2;
        Runnable 5 = new 5(this);
        z zVar = this.xGT;
        String str = "MicroMsg.LauncherUI.NewChattingTabUI";
        String str2 = "try closeChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(zVar.xLA == null ? false : zVar.xLA.isShown());
        x.i(str, str2, objArr);
        if (!(zVar.xLx == null || zVar.xLx.getView() == null)) {
            zVar.xLx.getView().setImportantForAccessibility(4);
        }
        if (zVar.xLA == null || zVar.xLA.getVisibility() == 8 || zVar.xLx == null || zVar.qwI == null) {
            z2 = false;
        } else {
            if (zVar.xLx != null && zVar.xLx.isSupportNavigationSwipeBack()) {
                l.b(zVar.qwI);
            }
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting]", new Object[]{Boolean.valueOf(z)});
            zVar.pY(4);
            zVar.mChattingClosed = true;
            if (zVar.mChattingOutAnim == null) {
                zVar.mChattingOutAnim = AnimationUtils.loadAnimation(zVar.qwI, com.tencent.mm.ui.MMFragmentActivity.a.xKj);
                zVar.mChattingOutAnim.setAnimationListener(new 8(zVar, 5));
            }
            zVar.xLx.onPause();
            zVar.xLx.csH();
            zVar.xLx.hHG = false;
            com.tencent.mm.ui.base.ac.a(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
            if (zVar.xLx.isSupportNavigationSwipeBack()) {
                ImageView imageView = (ImageView) zVar.qwI.getWindow().getDecorView().findViewById(R.h.cDn);
                if (imageView != null && imageView.getVisibility() == 0) {
                    imageView.setVisibility(8);
                    x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] prepareView GONE");
                    if (imageView.getTag() != null) {
                        ((View) imageView.getTag()).setVisibility(0);
                    }
                }
            }
            if (z) {
                zVar.xLA.startAnimation(zVar.mChattingOutAnim);
            } else {
                zVar.xLA.setVisibility(8);
                zVar.qwI.onSwipe(1.0f);
                zVar.tryResetChattingSwipeStatus();
                if (zVar.xLx.isSupportNavigationSwipeBack()) {
                    y yVar = zVar.xLx.ywb;
                    x.i("MicroMsg.ChattingUI.TextImp", "summerhardcoder hardCoderExitChattingEnd quitStartPerformance[%d], stack[%s]", new Object[]{Integer.valueOf(yVar.yBQ), bh.cgy()});
                    if (yVar.yBQ != 0) {
                        HardCoderJNI.stopPerformace(HardCoderJNI.hcQuitChattingEnable, yVar.yBQ);
                        yVar.yBQ = 0;
                    }
                }
            }
            z2 = true;
        }
        if (z2) {
            HomeUI homeUI = this.xGS;
            if (!this.xGT.xLx.isSupportNavigationSwipeBack()) {
                homeUI.initActionBar();
            }
            homeUI.xFE.supportInvalidateOptionsMenu();
            if (q.GA().booleanValue()) {
                homeUI.cmw();
            }
            w wVar = homeUI.xGh;
            if (wVar.mnk == 0 && g.Di().gPJ.foreground) {
                ar.getNotification().aU(true);
            } else {
                ar.getNotification().aU(false);
            }
            ViewGroup viewGroup = (ViewGroup) wVar.xFE.findViewById(R.h.csz);
            if (viewGroup != null) {
                viewGroup.setImportantForAccessibility(1);
            }
            wVar.cmD();
            k.a(wVar.xFE, 3, wVar.mnk, "prepareCloseChatting");
            j jVar = (j) wVar.xKH.get(Integer.valueOf(0));
            if (jVar != null) {
                jVar.getContentView();
                if (jVar.mController != null) {
                    jVar.mController.onResume();
                }
                jVar.onHiddenChanged(false);
            }
        }
    }
}

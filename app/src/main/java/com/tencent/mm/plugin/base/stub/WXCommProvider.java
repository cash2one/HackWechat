package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Looper;
import android.os.Process;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.g.a.h;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.xwalk.core.R$styleable;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class WXCommProvider extends ContentProvider {
    public static final String PREF_NAME = (ac.getPackageName() + "_comm_preferences");
    private static final String[] kuY = new String[]{DownloadInfoColumns.PACKAGENAME, SlookAirButtonFrequentContactAdapter.DATA};
    private static final UriMatcher kva = new UriMatcher(-1);
    private static volatile boolean kvb = false;
    protected static boolean kvc = false;
    private static final Object lock = new Object();
    private SharedPreferences gZO;
    private af handler;
    protected MatrixCursor kuZ = new MatrixCursor(new String[0]);

    static {
        kva.addURI("com.tencent.mm.sdk.comm.provider", "pref", 1);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "openQRCodeScan", 18);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "batchAddShortcut", 19);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "getUnreadCount", 20);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizProfile", 21);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizTempSession", 27);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "registerMsgListener", 22);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "getAvatar", 23);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "regWatchAppId", 24);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "decodeVoice", 25);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "addCardToWX", 26);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "unReadMsgs", 9);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "to_chatting", 3);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "setReaded", 13);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "voiceControl", 29);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "openRankList", 28);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "openWebview", 30);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "openBusiLuckyMoney", 31);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "createChatroom", 32);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "joinChatroom", 33);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "sendSight", 34);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "redirectToChattingByPhoneNumber", 35);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "redirectToWechatOutByPhoneNumber", 36);
        kva.addURI("com.tencent.mm.sdk.comm.provider", c.NAME, 37);
        kva.addURI("com.tencent.mm.sdk.comm.provider", a.NAME, 38);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "chooseCardFromWX", 39);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "openOfflinePay", 42);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "setWechatSportStep", 40);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "getWechatSportConfig", 41);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "handleScanResult", 44);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "openTypeWebview", 45);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "openCleanUI", 46);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "launchWXMiniprogram", 47);
        kva.addURI("com.tencent.mm.sdk.comm.provider", "qrcodeEvent", 48);
    }

    public boolean onCreate() {
        x.d("MicroMsg.WXCommProvider", "onCreate");
        this.handler = new af();
        x.i("MicroMsg.WXCommProvider", "pid = " + Process.myPid() + ", tid : = " + Process.myTid());
        this.gZO = getContext().getSharedPreferences(PREF_NAME, 0);
        getContext().registerReceiver(new 1(this), new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
        if (this.gZO != null) {
            return true;
        }
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.WXCommProvider", "uri:%s", uri);
        if (uri == null) {
            x.e("MicroMsg.WXCommProvider", "query fail, uri is null return null");
            return null;
        }
        String[] aqW = aqW();
        if (aqW == null || aqW.length <= 0) {
            x.e("MicroMsg.WXCommProvider", "CallingPackages is null return null");
            return null;
        }
        int match = kva.match(uri);
        if (com.tencent.mm.sdk.b.a.xef == null) {
            new ak(Looper.getMainLooper(), new 2(this), true).J(50, 50);
            try {
                synchronized (lock) {
                    x.i("MicroMsg.WXCommProvider", "Lock to wait for the first initialize of the Application.");
                    while (!kvb) {
                        lock.wait();
                    }
                    kvb = false;
                }
            } catch (Throwable e) {
                x.e("MicroMsg.WXCommProvider", "the lock may have some problem," + e.getMessage());
                x.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            }
        }
        return a(uri, strArr, str, strArr2, str2, match, aqW);
    }

    public final Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, String[] strArr3) {
        Cursor matrixCursor;
        b esVar;
        b tiVar;
        switch (i) {
            case 3:
            case 9:
            case 13:
            case 22:
            case 23:
            case 25:
            case 29:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 40:
            case 41:
            case R$styleable.AppCompatTheme_dialogTheme /*42*/:
            case 46:
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                long currentTimeMillis = System.currentTimeMillis();
                if (aqY()) {
                    b eyVar = new ey();
                    eyVar.ftR.ftm = i;
                    eyVar.ftR.uri = uri;
                    eyVar.ftR.selectionArgs = strArr2;
                    eyVar.ftR.context = getContext();
                    eyVar.ftR.fmW = strArr3;
                    if (com.tencent.mm.sdk.b.a.xef.m(eyVar)) {
                        x.i("MicroMsg.WXCommProvider", "[extApiCost] total cost = %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return eyVar.ftS.ftn;
                    }
                    x.e("MicroMsg.WXCommProvider", "ExtCallEvent fail return code = 8");
                    matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.lZI);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(8)});
                    return matrixCursor;
                }
                String ou = bh.ou(uri.getQueryParameter("appid"));
                if ("1".equals(bh.az(uri.getQueryParameter("autoLogin"), "0"))) {
                    x.i("MicroMsg.WXCommProvider", "hy: not login. try to login return code = 9");
                    ap.vfE = new ap(uri, strArr, str, strArr2, str2, i, strArr3);
                    ap.vfF = System.currentTimeMillis();
                    d.b(getContext(), "accountsync", "com.tencent.mm.ui.account.LoginUI", new Intent());
                    matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.lZI);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(9)});
                    return matrixCursor;
                }
                x.i("MicroMsg.WXCommProvider", "not login, appID = %s, apiID = %s return code =%s ", ou, Integer.valueOf(i), Integer.valueOf(3));
                g.pQN.h(10505, bh.ou(strArr3[0]), ou, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.lZI);
                matrixCursor.addRow(new Object[]{Integer.valueOf(3)});
                return matrixCursor;
            case 18:
            case 19:
            case 20:
                if (!aqX()) {
                    return null;
                }
                esVar = new es();
                esVar.ftk.ftm = i;
                esVar.ftk.uri = uri;
                esVar.ftk.selectionArgs = strArr2;
                esVar.ftk.context = getContext();
                esVar.ftk.fmW = strArr3;
                if (com.tencent.mm.sdk.b.a.xef.m(esVar)) {
                    return esVar.ftl.ftn;
                }
                x.e("MicroMsg.WXCommProvider", "ExtCallEvent fail");
                return null;
            case 21:
                esVar = new er();
                esVar.fti.op = 21;
                esVar.fti.cOY = 1;
                esVar.fti.selectionArgs = strArr2;
                esVar.fti.context = getContext();
                esVar.fti.fmW = strArr3;
                if (!com.tencent.mm.sdk.b.a.xef.m(esVar)) {
                    x.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 24:
                if (!aqX()) {
                    return this.kuZ;
                }
                tiVar = new ti();
                tiVar.fLL.ftm = i;
                tiVar.fLL.uri = uri;
                tiVar.fLL.context = getContext();
                for (int i2 = 0; i2 < strArr3.length; i2++) {
                    if (strArr3[i2] != null) {
                        tiVar.fLL.fLN = strArr3[i2];
                        if (!com.tencent.mm.sdk.b.a.xef.m(tiVar)) {
                            return tiVar.fLM.ftn;
                        }
                        x.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                        return null;
                    }
                }
                if (!com.tencent.mm.sdk.b.a.xef.m(tiVar)) {
                    return tiVar.fLM.ftn;
                }
                x.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                return null;
            case 26:
                esVar = new h();
                esVar.fmV.selectionArgs = strArr2;
                esVar.fmV.fmW = strArr3;
                esVar.fmV.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xef.m(esVar)) {
                    x.e("MicroMsg.WXCommProvider", "add card to wx fail");
                }
                return null;
            case 27:
                if (strArr2 == null || strArr2.length < 2) {
                    x.e("MicroMsg.WXCommProvider", "wrong args");
                    return null;
                }
                esVar = new er();
                esVar.fti.op = 27;
                esVar.fti.cOY = 1;
                esVar.fti.selectionArgs = strArr2;
                esVar.fti.context = getContext();
                esVar.fti.fmW = strArr3;
                if (!com.tencent.mm.sdk.b.a.xef.m(esVar)) {
                    x.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 28:
                esVar = new er();
                esVar.fti.op = i;
                esVar.fti.selectionArgs = strArr2;
                esVar.fti.context = getContext();
                esVar.fti.fmW = strArr3;
                if (!com.tencent.mm.sdk.b.a.xef.m(esVar)) {
                    x.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 30:
            case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                tiVar = new oe();
                tiVar.fGa.selectionArgs = strArr2;
                tiVar.fGa.fmW = strArr3;
                tiVar.fGa.context = getContext();
                tiVar.fGa.fGb = i == 45;
                if (i == 30 && strArr2 != null && strArr2.length > 2) {
                    com.tencent.mm.pluginsdk.d.vcf = strArr2[2];
                }
                if (!com.tencent.mm.sdk.b.a.xef.m(tiVar)) {
                    x.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 31:
                esVar = new od();
                esVar.fFZ.selectionArgs = strArr2;
                esVar.fFZ.fmW = strArr3;
                esVar.fFZ.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xef.m(esVar)) {
                    x.e("MicroMsg.WXCommProvider", "open busi luckymoney fail");
                }
                return null;
            case 32:
                esVar = new by();
                esVar.fpZ.action = 1;
                esVar.fpZ.selectionArgs = strArr2;
                esVar.fpZ.fmW = strArr3;
                esVar.fpZ.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xef.m(esVar)) {
                    x.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 33:
                esVar = new by();
                esVar.fpZ.action = 2;
                esVar.fpZ.selectionArgs = strArr2;
                esVar.fpZ.fmW = strArr3;
                esVar.fpZ.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xef.m(esVar)) {
                    x.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 39:
                esVar = new com.tencent.mm.g.a.bh();
                esVar.fpC.selectionArgs = strArr2;
                esVar.fpC.fmW = strArr3;
                esVar.fpC.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xef.m(esVar)) {
                    x.e("MicroMsg.WXCommProvider", "choose card from wx fail");
                }
                return null;
            case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                esVar = new id();
                esVar.fyB.selectionArgs = strArr2;
                esVar.fyB.fmW = strArr3;
                esVar.fyB.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xef.m(esVar)) {
                    x.e("MicroMsg.WXCommProvider", "handle scan result failed try again");
                    ag.h(new 3(this, esVar), 200);
                }
                return null;
            case 47:
                esVar = new oc();
                esVar.fFY.selectionArgs = strArr2;
                esVar.fFY.fmW = strArr3;
                esVar.fFY.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xef.m(esVar)) {
                    x.e("MicroMsg.WXCommProvider", "launch wx miniprogram fail");
                }
                return null;
            default:
                MatrixCursor matrixCursor2 = new MatrixCursor(kuY);
                matrixCursor = (Cursor) new 4(this, uri, i, strArr3, matrixCursor2).b(this.handler);
                if (matrixCursor != null) {
                    return matrixCursor;
                }
                matrixCursor2.close();
                return matrixCursor;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (uri == null) {
            x.e("MicroMsg.WXCommProvider", "delete fail, uri is null");
            return 0;
        }
        return ((Integer) new 5(this, Integer.valueOf(0), uri, kva.match(uri), aqW()).b(this.handler)).intValue();
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private String[] aqW() {
        try {
            int callingUid = Binder.getCallingUid();
            String[] packagesForUid = getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid());
            String str = "MicroMsg.WXCommProvider";
            String str2 = "getCallingPackages, callingUid = %d, packages size = %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(callingUid);
            objArr[1] = Integer.valueOf(packagesForUid == null ? 0 : packagesForUid.length);
            x.i(str, str2, objArr);
            if (packagesForUid == null) {
                x.w("MicroMsg.WXCommProvider", "getCallingPackages fail, packages is null");
                return new String[0];
            }
            int length = packagesForUid.length;
            for (callingUid = 0; callingUid < length; callingUid++) {
                x.i("MicroMsg.WXCommProvider", "getCallingPackages = %s", packagesForUid[callingUid]);
            }
            return packagesForUid;
        } catch (Exception e) {
            x.e("MicroMsg.WXCommProvider", "getCallingPackages, ex = %s", e.getMessage());
            return new String[0];
        }
    }

    private boolean aqX() {
        try {
            x.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (kvc || ((Boolean) new 6(this, Boolean.valueOf(false)).b(this.handler)).booleanValue()) {
                if (ar.Hj() && ar.Hi() && !ar.Cs()) {
                    kvc = true;
                } else {
                    kvc = false;
                }
                x.i("MicroMsg.WXCommProvider", "hasLogin = " + kvc);
                return kvc;
            }
            x.i("MicroMsg.WXCommProvider", "checkIsLogin !syncTaskRet");
            kvc = false;
            return false;
        } catch (Throwable e) {
            x.w("MicroMsg.WXCommProvider", e.getMessage());
            x.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            return false;
        }
    }

    private boolean aqY() {
        try {
            x.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (!kvc) {
                com.tencent.mm.pluginsdk.e.a.b bVar = new com.tencent.mm.pluginsdk.e.a.b();
                bVar.b(4000, new 7(this, bVar));
            }
            if (ar.Hj() && ar.Hi() && !ar.Cs()) {
                kvc = true;
            } else {
                kvc = false;
            }
            x.i("MicroMsg.WXCommProvider", "hasLogin = " + kvc);
            return kvc;
        } catch (Throwable e) {
            x.w("MicroMsg.WXCommProvider", e.getMessage());
            x.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            return false;
        }
    }
}

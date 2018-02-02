package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.HandlerThread;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.a.e;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class WXEntryActivity$EntryReceiver extends BroadcastReceiver {
    private static af handler;
    private String appId;
    private String appName;
    private Context context;
    private int kuP;
    private long kvp;
    private String uC;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(WXEntryActivity$EntryReceiver wXEntryActivity$EntryReceiver, Context context, Intent intent) {
        wXEntryActivity$EntryReceiver.context = context;
        String j = t.j(intent, ConstantsAPI.CONTENT);
        wXEntryActivity$EntryReceiver.kvp = t.i(intent, ConstantsAPI.APP_SUPORT_CONTENT_TYPE);
        wXEntryActivity$EntryReceiver.kuP = t.a(intent, ConstantsAPI.SDK_VERSION, 0);
        if (WXEntryActivity.na(wXEntryActivity$EntryReceiver.kuP)) {
            wXEntryActivity$EntryReceiver.uC = t.j(intent, ConstantsAPI.APP_PACKAGE);
            if (wXEntryActivity$EntryReceiver.uC == null || wXEntryActivity$EntryReceiver.uC.length() <= 0) {
                x.e("MicroMsg.WXEntryActivity", "unknown package, ignore");
                return;
            } else if (!WXEntryActivity.e(t.k(intent, ConstantsAPI.CHECK_SUM), WXEntryActivity.r(j, wXEntryActivity$EntryReceiver.kuP, wXEntryActivity$EntryReceiver.uC))) {
                x.e("MicroMsg.WXEntryActivity", "checksum fail");
                return;
            } else if (j == null) {
                x.e("MicroMsg.WXEntryActivity", "check appid failed, null content");
                return;
            } else {
                Uri parse = Uri.parse(j);
                String authority = parse.getAuthority();
                try {
                    wXEntryActivity$EntryReceiver.appId = parse.getQueryParameter("appid");
                    x.i("MicroMsg.WXEntryActivity", "onReceive, appId = " + wXEntryActivity$EntryReceiver.appId);
                    if (wXEntryActivity$EntryReceiver.appId == null || wXEntryActivity$EntryReceiver.appId.length() <= 0) {
                        x.e("MicroMsg.WXEntryActivity", "invalid appid, ignore");
                        return;
                    } else if (!ar.Hj() || ar.Cs()) {
                        x.w("MicroMsg.WXEntryActivity", "not login, just save the appid : %s", new Object[]{wXEntryActivity$EntryReceiver.appId});
                        p.RL(wXEntryActivity$EntryReceiver.appId);
                        return;
                    } else if (!g.Dh().gPy) {
                        x.w("MicroMsg.WXEntryActivity", "not login accInitializing, just save the appid : %s", new Object[]{wXEntryActivity$EntryReceiver.appId});
                        p.RL(wXEntryActivity$EntryReceiver.appId);
                        return;
                    } else if ("registerapp".equals(authority)) {
                        x.i("MicroMsg.WXEntryActivity", "handle app registeration: " + wXEntryActivity$EntryReceiver.uC + ", sdkver=" + wXEntryActivity$EntryReceiver.kuP);
                        if (ar.Hj()) {
                            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(wXEntryActivity$EntryReceiver.appId, true);
                            if (p.b(wXEntryActivity$EntryReceiver.context, aZ, wXEntryActivity$EntryReceiver.uC)) {
                                if (aZ != null && aZ.Yz()) {
                                    j jVar = a.vcu;
                                    if (jVar != null) {
                                        jVar.o(wXEntryActivity$EntryReceiver.context, wXEntryActivity$EntryReceiver.appId, wXEntryActivity$EntryReceiver.uC);
                                    }
                                }
                                Bitmap bitmap = null;
                                try {
                                    PackageManager packageManager = wXEntryActivity$EntryReceiver.context.getPackageManager();
                                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(wXEntryActivity$EntryReceiver.uC, 0);
                                    if (applicationInfo == null) {
                                        x.e("MicroMsg.WXEntryActivity", "package not installed");
                                        return;
                                    }
                                    boolean z;
                                    wXEntryActivity$EntryReceiver.appName = applicationInfo.loadLabel(packageManager).toString();
                                    Drawable loadIcon = applicationInfo.loadIcon(packageManager);
                                    bitmap = loadIcon instanceof BitmapDrawable ? ((BitmapDrawable) loadIcon).getBitmap() : null;
                                    if (aZ != null) {
                                        an.bin();
                                        j = wXEntryActivity$EntryReceiver.appId;
                                        if (j == null || j.length() == 0) {
                                            x.e("MicroMsg.AppInfoStorage", "hasIcon, appId is null");
                                            z = false;
                                        } else {
                                            z = e.bO(i.cR(j, 1));
                                        }
                                    }
                                    an.bin().t(wXEntryActivity$EntryReceiver.appId, bitmap);
                                    if (aZ == null) {
                                        r0 = new f();
                                        r0.field_appId = wXEntryActivity$EntryReceiver.appId;
                                        r0.field_appName = "";
                                        r0.field_packageName = wXEntryActivity$EntryReceiver.uC;
                                        r0.field_status = 0;
                                        authority = p.aW(wXEntryActivity$EntryReceiver.context, wXEntryActivity$EntryReceiver.uC);
                                        if (authority != null) {
                                            r0.field_signature = authority;
                                        }
                                        r0.field_modifyTime = System.currentTimeMillis();
                                        r0.field_appSupportContentType = wXEntryActivity$EntryReceiver.kvp;
                                        boolean l = an.bin().l(r0);
                                        b.SK(wXEntryActivity$EntryReceiver.appId);
                                        if (l && com.tencent.mm.platformtools.t.ov(r0.field_openId)) {
                                            x.d("MicroMsg.WXEntryActivity", "handleAppRegisteration, trigger getAppSetting, appId = " + wXEntryActivity$EntryReceiver.appId);
                                            an.bip().OI(wXEntryActivity$EntryReceiver.appId);
                                            return;
                                        }
                                        return;
                                    }
                                    if ((aZ.field_appInfoFlag & 8192) != 0) {
                                        z = wXEntryActivity$EntryReceiver.kvp != aZ.field_appSupportContentType;
                                        aZ.field_appSupportContentType = wXEntryActivity$EntryReceiver.kvp;
                                    } else {
                                        z = false;
                                    }
                                    if (aZ.field_status == 2 || aZ.field_status == 3 || aZ.field_status == 4 || r0) {
                                        if (!aZ.Yz()) {
                                            b.SK(wXEntryActivity$EntryReceiver.appId);
                                        }
                                        aZ.field_status = 0;
                                        x.d("MicroMsg.WXEntryActivity", "handleAppRegisteration, updateRet = " + an.bin().a(aZ, new String[0]));
                                    }
                                    if (com.tencent.mm.platformtools.t.ov(aZ.field_openId)) {
                                        x.d("MicroMsg.WXEntryActivity", "handleAppRegisteration, trigger getAppSetting, appId = " + wXEntryActivity$EntryReceiver.appId);
                                        an.bip().OI(wXEntryActivity$EntryReceiver.appId);
                                        return;
                                    }
                                    return;
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.WXEntryActivity", e2, "package not installed", new Object[0]);
                                }
                            } else {
                                x.e("MicroMsg.WXEntryActivity", "reg fail, check app fail");
                                an.bim().RD(wXEntryActivity$EntryReceiver.appId);
                                return;
                            }
                        }
                        x.e("MicroMsg.WXEntryActivity", "no available account");
                        return;
                    } else if ("unregisterapp".equals(authority)) {
                        x.d("MicroMsg.WXEntryActivity", "handle app unregisteration: " + wXEntryActivity$EntryReceiver.uC + ", sdkver=" + wXEntryActivity$EntryReceiver.kuP);
                        if (ar.Hj()) {
                            r0 = com.tencent.mm.pluginsdk.model.app.g.aZ(wXEntryActivity$EntryReceiver.appId, false);
                            if (!p.b(wXEntryActivity$EntryReceiver.context, r0, wXEntryActivity$EntryReceiver.uC)) {
                                x.e("MicroMsg.WXEntryActivity", "unreg fail, check app fail");
                                return;
                            } else if (r0 != null && r0.field_status != 5) {
                                r0.field_status = 4;
                                an.bin().a(r0, new String[0]);
                                b.SL(wXEntryActivity$EntryReceiver.appId);
                                return;
                            } else {
                                return;
                            }
                        }
                        x.e("MicroMsg.WXEntryActivity", "no available account");
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e3) {
                    x.e("MicroMsg.WXEntryActivity", "init: %s", new Object[]{e3.toString()});
                    return;
                }
            }
        }
        x.e("MicroMsg.WXEntryActivity", "sdk version is not supported, sdkVersion = " + wXEntryActivity$EntryReceiver.kuP);
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            d.ccW();
            if (handler == null) {
                HandlerThread Wf = com.tencent.mm.sdk.f.e.Wf("WXEntryReceiver");
                Wf.start();
                handler = new af(Wf.getLooper());
            }
            if (g.Dk().gQE.gQX) {
                handler.post(new 2(this, context, intent));
            } else {
                g.Dk().a(new 1(this, context, intent));
            }
        }
    }
}

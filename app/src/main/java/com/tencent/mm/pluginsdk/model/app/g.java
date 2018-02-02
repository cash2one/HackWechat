package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.q;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g {

    public interface a {
        void cG(boolean z);
    }

    public static f Hg(String str) {
        return aZ(str, true);
    }

    public static f cQ(String str, int i) {
        f fVar = null;
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
        } else if (com.tencent.mm.plugin.y.a.a.a.bis() == null) {
            x.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            fVar = com.tencent.mm.plugin.y.a.a.a.bis().Hg(str);
            Object obj = (fVar == null || fVar.field_appVersion < i) ? 1 : null;
            if (obj != null) {
                com.tencent.mm.plugin.y.a.a.a.bis().Hh(str);
            }
        }
        return fVar;
    }

    public static f aZ(String str, boolean z) {
        f fVar = null;
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
        } else if (com.tencent.mm.plugin.y.a.a.a.bis() == null) {
            x.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            fVar = com.tencent.mm.plugin.y.a.a.a.bis().Hg(str);
            if (z) {
                Object obj = (fVar == null || fVar.field_appName == null || fVar.field_appName.length() == 0) ? 1 : null;
                if (obj != null) {
                    com.tencent.mm.plugin.y.a.a.a.bis().Hh(str);
                }
            }
        }
        return fVar;
    }

    public static Bitmap b(String str, int i, float f) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppInfoLogic", "getAppIcon, appId is null");
            return null;
        } else if (!com.tencent.mm.kernel.g.Dh().Cy()) {
            return null;
        } else {
            Bitmap a;
            if (com.tencent.mm.kernel.g.Dj().isSDCardAvailable()) {
                a = com.tencent.mm.plugin.y.a.a.a.bis().a(str, i, f);
                if (a == null) {
                    x.w("MicroMsg.AppInfoLogic", "getAppIcon, bm does not exist or has been recycled");
                    com.tencent.mm.plugin.y.a.a.a.bis().bR(str, i);
                    return null;
                } else if (a.isRecycled()) {
                    return null;
                } else {
                    return a;
                }
            } else if (ac.getContext() == null || ac.getContext().getResources() == null) {
                return null;
            } else {
                switch (i) {
                    case 1:
                    case 3:
                    case 4:
                    case 5:
                        a = BitmapFactory.decodeResource(ac.getContext().getResources(), d.bGe);
                        if (a == null || a.isRecycled()) {
                            return null;
                        }
                        return a;
                    case 2:
                        return null;
                    default:
                        x.e("MicroMsg.AppInfoLogic", "getAppIcon, unknown iconType = " + i);
                        return null;
                }
            }
        }
    }

    public static List<f> b(Context context, long j, boolean z) {
        List arrayList = new ArrayList();
        i bin = com.tencent.mm.plugin.y.a.bin();
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("select * from AppInfo");
        stringBuilder.append(" where ");
        stringBuilder.append(" ( appSupportContentType & ").append(j).append(" ) != 0");
        stringBuilder.append(" and  ( svrAppSupportContentType & ").append(j).append(" ) != 0");
        stringBuilder.append(" and  ( appInfoFlag & ").append(8192).append(" ) != 0");
        stringBuilder.append(" and status != 4");
        if (!z) {
            stringBuilder.append(" and  ( appInfoFlag & ").append(16384).append(" ) == 0");
        }
        x.v("MicroMsg.AppInfoStorage", "getAppInfoByContentFlag sql %s", new Object[]{stringBuilder.toString()});
        Cursor rawQuery = bin.rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
            rawQuery = null;
        }
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                f fVar = new f();
                fVar.b(rawQuery);
                if (fVar.field_status == 1) {
                    if (!m(context, fVar.field_appId)) {
                        fVar.field_status = 4;
                        com.tencent.mm.plugin.y.a.a.a.bis().e(fVar);
                    } else if (!bh.ov(fVar.field_signature)) {
                        arrayList.add(fVar);
                    }
                } else if (fVar.field_signature != null) {
                    arrayList.add(fVar);
                }
            }
            rawQuery.close();
        }
        return arrayList;
    }

    public static boolean m(Context context, long j) {
        if (b(context, j, true).size() == 0) {
            return false;
        }
        return true;
    }

    public static boolean R(Context context, int i) {
        Long Rc = com.tencent.mm.pluginsdk.b.a.Rc(String.valueOf(i));
        if (Rc == null || b(context, Rc.longValue(), true).size() == 0) {
            return false;
        }
        return true;
    }

    public static List<f> eh(Context context) {
        List arrayList = new ArrayList();
        if (com.tencent.mm.plugin.y.a.a.a.bis() == null) {
            x.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            Cursor uv = com.tencent.mm.plugin.y.a.a.a.bis().uv(5);
            if (uv != null) {
                while (uv.moveToNext()) {
                    f fVar = new f();
                    fVar.b(uv);
                    if (fVar.field_status == 1) {
                        if (!m(context, fVar.field_appId)) {
                            fVar.field_status = 4;
                            com.tencent.mm.plugin.y.a.a.a.bis().e(fVar);
                        } else if (!bh.ov(fVar.field_signature)) {
                            arrayList.add(fVar);
                        }
                    } else if (fVar.field_signature != null) {
                        arrayList.add(fVar);
                    }
                }
                uv.close();
            }
        }
        return arrayList;
    }

    public static List<f> a(Context context, boolean z, int i) {
        List<f> arrayList = new ArrayList();
        if (com.tencent.mm.plugin.y.a.a.a.bis() == null) {
            x.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            arrayList = eu(1, i);
            int[] iArr = null;
            if (z) {
                iArr = new int[]{5};
            }
            if (iArr != null) {
                Cursor k = com.tencent.mm.plugin.y.a.a.a.bis().k(iArr);
                if (k != null) {
                    while (k.moveToNext()) {
                        f fVar = new f();
                        fVar.b(k);
                        if (fVar.field_status == 1) {
                            if (!m(context, fVar.field_appId)) {
                                fVar.field_status = 4;
                                com.tencent.mm.plugin.y.a.a.a.bis().e(fVar);
                            } else if (!bh.ov(fVar.field_signature)) {
                                arrayList.add(fVar);
                            }
                        } else if (fVar.field_signature != null) {
                            arrayList.add(fVar);
                        }
                    }
                    k.close();
                }
            }
        }
        return arrayList;
    }

    private static List<f> eu(int i, int i2) {
        List arrayList = new ArrayList();
        if (com.tencent.mm.plugin.y.a.a.a.bis() == null) {
            x.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
        } else {
            Cursor df = com.tencent.mm.plugin.y.a.a.a.bis().df(1, i2);
            if (df != null) {
                while (df.moveToNext()) {
                    f fVar = new f();
                    fVar.b(df);
                    if (!bh.ov(fVar.field_openId)) {
                        arrayList.add(fVar);
                    }
                }
                df.close();
            }
        }
        return arrayList;
    }

    public static boolean m(Context context, String str) {
        if (context != null && str != null && str.length() != 0) {
            return a(context, aZ(str, true));
        }
        x.e("MicroMsg.AppInfoLogic", "isAppInstalled, invalid arguments");
        return false;
    }

    public static boolean a(Context context, f fVar) {
        if (fVar == null) {
            x.w("MicroMsg.AppInfoLogic", "app is null");
            return false;
        } else if (fVar.field_packageName != null && fVar.field_packageName.length() != 0) {
            return p.m(context, fVar.field_packageName);
        } else {
            x.w("MicroMsg.AppInfoLogic", "field_packageName is null");
            return false;
        }
    }

    public static boolean cz(String str) {
        if (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) {
            return false;
        }
        return true;
    }

    public static String l(Context context, String str) {
        return a(context, aZ(str, true), null);
    }

    public static String a(Context context, f fVar, String str) {
        if (context == null || fVar == null) {
            return str;
        }
        String ei = ei(context);
        String str2 = null;
        if (ei.equalsIgnoreCase("zh_CN")) {
            str2 = fVar.field_appName;
        }
        if (ei.equalsIgnoreCase("en")) {
            str2 = bh.ov(fVar.field_appName_en) ? fVar.field_appName : fVar.field_appName_en;
        }
        if (ei.equalsIgnoreCase("zh_TW") || ei.equalsIgnoreCase("zh_HK")) {
            if (ei.equalsIgnoreCase("zh_HK")) {
                str2 = bh.ov(fVar.field_appName_hk) ? fVar.field_appName_tw : fVar.field_appName_hk;
            }
            if (bh.ov(str2)) {
                str2 = bh.ov(fVar.field_appName_tw) ? fVar.field_appName : fVar.field_appName_tw;
            }
        }
        if (bh.ov(str2)) {
            str2 = bh.ov(fVar.field_appName_en) ? fVar.field_appName : fVar.field_appName_en;
        }
        if (bh.ov(str2)) {
            return str;
        }
        return str2;
    }

    public static String ei(Context context) {
        String d = w.d(context.getSharedPreferences(ac.cfs(), 0));
        if (d == null || d.length() == 0 || d.equalsIgnoreCase("zh_CN")) {
            return "zh_CN";
        }
        return d;
    }

    public static boolean RA(String str) {
        if (bh.ov(str)) {
            return false;
        }
        f aZ = aZ(str, true);
        if (aZ == null) {
            x.w("MicroMsg.AppInfoLogic", "app is null, appId = " + str);
            return false;
        } else if (aZ.field_authFlag == 0) {
            return true;
        } else {
            if ((aZ.field_authFlag & 2) > 0) {
                return true;
            }
            return false;
        }
    }

    public static boolean cA(String str) {
        if (bh.ov(str)) {
            return false;
        }
        f aZ = aZ(str, false);
        if (aZ != null) {
            return aZ.Yz();
        }
        x.w("MicroMsg.AppInfoLogic", "app is null, appId = " + str);
        return false;
    }

    public static boolean g(f fVar) {
        if (fVar == null || bh.ov(fVar.field_appId) || (fVar.field_appInfoFlag & 1) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean h(f fVar) {
        if (fVar == null || (fVar.field_appInfoFlag & 2) == 0) {
            return true;
        }
        return false;
    }

    public static boolean RB(String str) {
        if (bh.ov(str)) {
            return false;
        }
        f aZ = aZ(str, true);
        if (aZ == null || bh.ov(aZ.field_appId)) {
            return false;
        }
        if (aZ.field_appId.equals("wx7fa037cc7dfabad5")) {
            return true;
        }
        if ((aZ.field_appInfoFlag & 8) > 0) {
            return true;
        }
        return false;
    }

    public static boolean i(f fVar) {
        if (fVar == null || bh.ov(fVar.field_appId)) {
            return false;
        }
        boolean z;
        if ((fVar.field_appInfoFlag & 64) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.v("MicroMsg.AppInfoLogic", "canReadMMMsg, appid = %s, ret = %b", new Object[]{fVar.field_appId, Boolean.valueOf(z)});
        return z;
    }

    public static boolean a(f fVar, int i) {
        if (fVar == null || bh.ov(fVar.field_appId)) {
            return false;
        }
        boolean z;
        if ((fVar.field_appInfoFlag & i) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.AppInfoLogic", "isAppHasFlag, appid = %s, flag = %s, ret = %b", new Object[]{fVar.field_appId, Integer.valueOf(i), Boolean.valueOf(z)});
        x.i("MicroMsg.AppInfoLogic", "appInfoFlag = " + fVar.field_appInfoFlag);
        return z;
    }

    public static boolean j(f fVar) {
        if (fVar == null || bh.ov(fVar.field_appId)) {
            return false;
        }
        Object obj;
        if ((fVar.field_appInfoFlag & FileUtils.S_IWUSR) > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (1 != obj) {
            return false;
        }
        String str = fVar.field_appId;
        Map hashMap = new HashMap();
        q.b(327682, hashMap);
        str = hashMap.containsKey(str) ? (String) hashMap.get(str) : null;
        if (str == null || str.equals("0")) {
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str, WXMediaMessage wXMediaMessage, String str2, String str3, int i, a aVar, Bundle bundle) {
        x.d("MicroMsg.AppInfoLogic", "request pkg = " + str + ", openId = " + str3);
        return a(context, str, str2, c(context, wXMediaMessage, str3), i, aVar, bundle);
    }

    public static boolean a(final Context context, final String str, String str2, final Req req, int i, final a aVar, Bundle bundle) {
        if (req == null) {
            x.i("MicroMsg.AppInfoLogic", "launchApp failed, req is null.");
            if (aVar != null) {
                aVar.cG(false);
            }
            return false;
        } else if (TextUtils.isEmpty(str) || !p.m(context, str)) {
            x.i("MicroMsg.AppInfoLogic", "launchApp failed, pkg is null or application has not installed.");
            h.bu(context, context.getString(com.tencent.mm.plugin.comm.a.h.dSQ));
            if (aVar != null) {
                aVar.cG(false);
            }
            return false;
        } else {
            x.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) with appId(%s)", new Object[]{str, str2});
            if (bh.ou(ac.getPackageName()).equals(str)) {
                x.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
                if (aVar != null) {
                    aVar.cG(false);
                }
                return false;
            }
            Runnable anonymousClass1 = new Runnable() {
                public final void run() {
                    Bundle bundle = new Bundle();
                    req.toBundle(bundle);
                    p.ae(bundle);
                    p.af(bundle);
                    Args args = new Args();
                    args.targetPkgName = str;
                    args.bundle = bundle;
                    boolean send = MMessageActV2.send(context, args);
                    if (aVar != null) {
                        aVar.cG(send);
                    }
                }
            };
            if (i == 2) {
                x.i("MicroMsg.AppInfoLogic", "launchApp with show confirm dialog(%s).", new Object[]{str});
                anonymousClass1.run();
                return true;
            }
            String string;
            String string2;
            String string3;
            if (bundle != null) {
                string = bundle.getString("current_page_url", "");
                string2 = bundle.getString("current_page_appid", "");
            } else {
                string = "";
                string2 = "";
            }
            if (aZ(str2, true) != null) {
                string3 = context.getString(com.tencent.mm.plugin.comm.a.h.lpc, new Object[]{a(context, r1, null)});
            } else {
                string3 = context.getString(com.tencent.mm.plugin.comm.a.h.lpb);
            }
            x.i("MicroMsg.AppInfoLogic", "launchApp with args(showType : %s, pkg : %s)", new Object[]{Integer.valueOf(i), str});
            String string4 = context.getString(com.tencent.mm.plugin.comm.a.h.lpa);
            String string5 = context.getString(com.tencent.mm.plugin.comm.a.h.dEn);
            OnClickListener 2 = new 2(str, string, string2, anonymousClass1);
            OnClickListener anonymousClass3 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14102, new Object[]{Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str, string, string2});
                    if (aVar != null) {
                        aVar.cG(false);
                    }
                }
            };
            h.a(context, string3, "", string4, string5, false, 2, anonymousClass3);
            return true;
        }
    }

    public static boolean d(Context context, Uri uri) {
        if (context == null || uri == null) {
            x.i("MicroMsg.AppInfoLogic", "launchApp failed, context or uri is null.");
            return false;
        }
        x.i("MicroMsg.AppInfoLogic", "try to launchApp with uri.");
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        return a(context, intent, null, null, null);
    }

    public static boolean a(Context context, Intent intent, String str) {
        return a(context, intent, str, null, null);
    }

    public static boolean a(Context context, Intent intent, String str, a aVar) {
        return a(context, intent, str, aVar, null);
    }

    public static boolean a(Context context, Intent intent, String str, a aVar, Bundle bundle) {
        return a(context, intent, str, 0, aVar, bundle);
    }

    public static boolean a(Context context, Intent intent, String str, int i, a aVar, Bundle bundle) {
        if (context == null || intent == null) {
            x.i("MicroMsg.AppInfoLogic", "launchApp failed, context or intent is null.");
            if (aVar != null) {
                aVar.cG(false);
            }
            return false;
        }
        String string;
        String string2;
        if (bundle != null) {
            string = bundle.getString("current_page_url", "");
            string2 = bundle.getString("current_page_appid", "");
        } else {
            string = "";
            string2 = "";
        }
        List y = bh.y(context, intent);
        if (y == null || y.isEmpty()) {
            x.w("MicroMsg.AppInfoLogic", "launchApp failed, not activity can resolve the intent.");
            if (aVar != null) {
                aVar.cG(false);
            }
            return false;
        }
        String b;
        if (TextUtils.isEmpty(intent.getPackage()) && y.size() == 1) {
            b = b((ResolveInfo) y.get(0));
        } else {
            b = intent.getPackage();
        }
        x.d("MicroMsg.AppInfoLogic", "launchApp, wxpkg : %s.", new Object[]{ac.getPackageName()});
        if (bh.ou(ac.getPackageName()).equals(b)) {
            x.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
            if (aVar != null) {
                aVar.cG(false);
            }
            return false;
        }
        x.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) by wechat with intent", new Object[]{b});
        if (i == 2) {
            context.startActivity(intent);
            if (aVar != null) {
                aVar.cG(true);
            }
            return true;
        }
        String string3;
        if (TextUtils.isEmpty(str)) {
            string3 = context.getString(com.tencent.mm.plugin.comm.a.h.lpb);
        } else {
            string3 = context.getString(com.tencent.mm.plugin.comm.a.h.lpc, new Object[]{str});
        }
        h.a(context, string3, "", context.getString(com.tencent.mm.plugin.comm.a.h.lpa), context.getString(com.tencent.mm.plugin.comm.a.h.dEn), false, new 4(context, intent, b, string, string2, aVar), new 5(b, string, string2, aVar));
        return true;
    }

    public static Req c(Context context, WXMediaMessage wXMediaMessage, String str) {
        Req req = new Req();
        if (context == null) {
            context = ac.getContext();
        }
        req.message = wXMediaMessage;
        req.transaction = com.tencent.mm.a.g.s((bh.Wp()).getBytes());
        req.openId = str;
        req.lang = w.d(context.getSharedPreferences(ac.cfs(), 0));
        req.country = (String) com.tencent.mm.kernel.g.Dj().CU().get(274436, null);
        return req;
    }

    public static String b(ResolveInfo resolveInfo) {
        if (resolveInfo == null) {
            return null;
        }
        String str = resolveInfo.resolvePackageName;
        if (!TextUtils.isEmpty(str) || resolveInfo.activityInfo == null) {
            return str;
        }
        return resolveInfo.activityInfo.packageName;
    }

    public static void bYG() {
        SharedPreferences cft = ac.cft();
        if (cft != null) {
            cft.edit().putString("key_app_ids_registion_while_not_login", "").commit();
        }
    }
}

package com.tencent.mm.plugin.game.d;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.i;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.ui.GameDetailUI2;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vending.h.h;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c {
    private static int hJx = -1;
    private static volatile ag hmW;
    private static final Object jRO = new Object();
    private static int maxSize = -1;
    private static DisplayMetrics nrR;
    private static int nxb = -1;
    private static Rect rect = new Rect();

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        if (nrR == null) {
            nrR = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(nrR);
        }
        return nrR.widthPixels;
    }

    public static int ac(Context context, String str) {
        return p(context, str, null);
    }

    public static int p(Context context, String str, String str2) {
        if (bh.ov(str)) {
            return 0;
        }
        if (ad(context, str)) {
            return 30;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str2);
        y(intent, context);
        return 7;
    }

    public static boolean ad(Context context, String str) {
        int i = 2;
        String queryParameter = Uri.parse(str).getQueryParameter("weapp");
        if (!bh.ov(queryParameter)) {
            try {
                Uri parse = Uri.parse(queryParameter);
                String authority = parse.getAuthority();
                if (bh.ov(authority)) {
                    x.w("MicroMsg.GameCenterUtil", "targetAppId is null");
                    return false;
                }
                String queryParameter2 = parse.getQueryParameter("env_version");
                String queryParameter3 = parse.getQueryParameter("path");
                queryParameter2 = bh.ou(queryParameter2);
                Object obj = -1;
                switch (queryParameter2.hashCode()) {
                    case 110628630:
                        if (queryParameter2.equals("trial")) {
                            int i2 = 1;
                            break;
                        }
                        break;
                    case 1559690845:
                        if (queryParameter2.equals("develop")) {
                            obj = null;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        i = 1;
                        break;
                    case 1:
                        break;
                    default:
                        i = 0;
                        break;
                }
                x.i("MicroMsg.GameCenterUtil", "jumpWeApp, appId: %s, versionType: %d, path: %s", new Object[]{authority, Integer.valueOf(i), queryParameter3});
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1079;
                ((com.tencent.mm.plugin.appbrand.m.c) g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(context, null, authority, i, 0, queryParameter3, appBrandStatObject);
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.GameCenterUtil", "checkJumpWeApp: " + e.getMessage());
            }
        }
        return false;
    }

    public static void a(Context context, t tVar, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", tVar.ncA.url);
        intent.putExtra("finishviewifloadfailed", true);
        intent.putExtra("show_full_screen", tVar.ncA.nbV);
        intent.putExtra("disable_progress_bar", tVar.ncA.nbV);
        int i = -1;
        switch (tVar.ncA.orientation) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 1001;
                break;
            case 4:
                i = 1002;
                break;
        }
        intent.putExtra("screen_orientation", i);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str);
        b kjVar = new kj();
        kjVar.fBG.type = 1;
        kjVar.fBG.context = context;
        kjVar.fBG.intent = intent;
        a.xef.m(kjVar);
    }

    public static boolean a(View view, Context context) {
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            x.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            return false;
        }
        String str = (String) view.getTag();
        if (bh.ov(str)) {
            x.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        y(intent, context);
        return true;
    }

    public static Dialog cR(Context context) {
        View inflate = View.inflate(context, R.i.dla, null);
        Dialog kVar = new k(context, R.m.eYO);
        kVar.setContentView(inflate);
        kVar.setCancelable(true);
        kVar.setCanceledOnTouchOutside(false);
        kVar.setOnCancelListener(new 1(kVar));
        return kVar;
    }

    public static int Cl(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
            return 0;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = ac.getContext().getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e) {
            x.w("MicroMsg.GameCenterUtil", "Exception: %s", new Object[]{e.toString()});
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static int Cm(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.GameCenterUtil", "Null or Nil path");
            return 0;
        }
        PackageInfo packageArchiveInfo = ac.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.versionCode;
        }
        return 0;
    }

    public static synchronized void Cn(String str) {
        synchronized (c.class) {
            if (!bh.ov(str)) {
                x.d("MicroMsg.GameCenterUtil", "pre download entrance image : %s", new Object[]{str});
                b gsVar = new gs();
                gsVar.fwO.pK = 1;
                gsVar.fwO.url = str;
                a.xef.m(gsVar);
                if (gsVar.fwP.fwR) {
                    String str2 = gsVar.fwP.fwQ + com.tencent.mm.a.g.s(str.getBytes());
                    com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
                    aVar.hDA = true;
                    aVar.hDC = str2;
                    com.tencent.mm.aq.a.a.c PK = aVar.PK();
                    o.PA().a(str, null, PK, new 2(gsVar), new 3(gsVar));
                }
            }
        }
    }

    public static void T(LinkedList<String> linkedList) {
        if (!bh.cA(linkedList)) {
            List linkedList2 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, true);
                if (aZ != null && bh.ov(aZ.field_openId)) {
                    linkedList2.add(str);
                }
            }
            if (!bh.cA(linkedList2)) {
                an.bip().cv(linkedList2);
            }
        }
    }

    public static LinkedList<f> aRU() {
        Cursor bYJ = an.bin().bYJ();
        LinkedList<f> linkedList = new LinkedList();
        if (bYJ == null) {
            x.e("MicroMsg.GameCenterUtil", "getGameAppInfo failed: curosr is null");
        } else {
            if (bYJ.moveToFirst()) {
                do {
                    f fVar = new f();
                    fVar.b(bYJ);
                    linkedList.add(fVar);
                } while (bYJ.moveToNext());
            }
            bYJ.close();
        }
        return linkedList;
    }

    public static int a(Context context, String str, String str2, Bundle bundle) {
        if (!bh.ov(str)) {
            com.tencent.mm.plugin.game.model.b.a br = com.tencent.mm.plugin.game.model.b.br(str, bundle.getInt("game_report_from_scene", 0));
            if (br.fDt == 2 && !bh.ov(br.url)) {
                return p(context, br.url, "game_center_detail");
            }
        }
        if (!bh.ov(str2)) {
            return p(context, str2, "game_center_detail");
        }
        int aQa = com.tencent.mm.plugin.game.model.g.aQa();
        if (aQa == 2) {
            return ae(context, str);
        }
        if (aQa == 1) {
            c(context, bundle);
            return 6;
        }
        String cgv = bh.cgv();
        if (bh.ov(cgv) || cgv.toLowerCase().equals("cn")) {
            return ae(context, str);
        }
        c(context, bundle);
        return 6;
    }

    public static int ae(Context context, String str) {
        if (bh.ov(str)) {
            return 0;
        }
        af aQc = i.aQb().aQc();
        String str2 = aQc != null ? aQc.nfg : "";
        if (bh.ov(str2)) {
            str2 = "game.weixin.qq.com/cgi-bin/h5/static/gamecenter/detail.html?appid=" + str;
        } else {
            str2 = str2 + "?appid=" + str;
        }
        return p(context, str2, "game_center_detail");
    }

    public static void c(Context context, Bundle bundle) {
        Intent intent = new Intent(context, GameDetailUI2.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void y(Intent intent, Context context) {
        b kjVar = new kj();
        kjVar.fBG.type = 0;
        kjVar.fBG.context = context;
        kjVar.fBG.intent = intent;
        a.xef.m(kjVar);
    }

    public static void alJ() {
        if (hmW != null) {
            synchronized (jRO) {
                if (hmW != null) {
                    com.tencent.mm.vending.h.g.aao("SubCoreGameCenter#WorkThread");
                    hmW.oAt.quit();
                    hmW = null;
                }
            }
        }
    }

    public static ag Dm() {
        if (hmW == null) {
            synchronized (jRO) {
                if (hmW == null) {
                    hmW = new ag("SubCoreGameCenter#WorkThread");
                    com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new h(hmW.oAt.getLooper(), "SubCoreGameCenter#WorkThread"));
                }
            }
        }
        return hmW;
    }

    public static void a(t tVar, int i) {
        if (tVar == null) {
            SubCoreGameCenter.aRe();
            tVar = w.aQp();
            if (tVar == null) {
                return;
            }
        }
        tVar.aQm();
        x.i("MicroMsg.GameCenterUtil", "float layer report");
        if (!bh.ov(tVar.ncA.url)) {
            int i2 = tVar.field_msgType;
            if (tVar.field_msgType == 100) {
                i2 = tVar.ncS;
            }
            ap.a(ac.getContext(), 10, 1006, 1, 1, 0, tVar.field_appId, i, i2, tVar.field_gameMsgId, tVar.ncT, null);
            tVar.field_isRead = true;
            SubCoreGameCenter.aRd().c(tVar, new String[0]);
        }
        SubCoreGameCenter.aRe();
        w.aQq();
    }

    public static int parseColor(String str) {
        int i = 0;
        try {
            i = Color.parseColor(str);
        } catch (Exception e) {
            x.e("MicroMsg.GameCenterUtil", "parseColor: " + e.getMessage());
        }
        return i;
    }

    public static boolean cO(String str, String str2) {
        File file = new File(str);
        String i = com.tencent.mm.a.g.i(file);
        if (bh.ov(str2) || bh.ov(i)) {
            x.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 is null");
            return file.exists();
        }
        x.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 = %s, calculateMD5 = %s", new Object[]{str2, i});
        return str2.equalsIgnoreCase(i);
    }
}

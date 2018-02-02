package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.y;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.j;
import com.tencent.mm.ui.base.u;

public final class g {
    public static int bl(Context context, String str) {
        if (bh.ov(str)) {
            return 0;
        }
        int i;
        b jx = y.Mm().jx(str);
        if (jx == null || (jx.field_userFlag & 2) == 0) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return 0;
        }
        if (jx.field_wwExposeTimes < jx.field_wwMaxExposeTimes || p.m(context, "com.tencent.wework")) {
            return 2;
        }
        return 1;
    }

    public static void bm(Context context, String str) {
        if (!bh.ov(str) && !p.m(context, "com.tencent.wework")) {
            y.Mm().jA(str);
        }
    }

    public static void m(Context context, String str, int i) {
        if (p.m(context, "com.tencent.wework")) {
            aa(str, 4, i);
        } else {
            aa(str, 5, i);
        }
    }

    public static void n(Context context, String str, int i) {
        aa(str, 1, i);
        ab(str, 2, i);
        b jy = y.Mm().jy(str);
        if (p.m(context, "com.tencent.wework")) {
            Intent launchIntentForPackage;
            aa(str, 2, i);
            PackageInfo packageInfo = p.getPackageInfo(context, "com.tencent.wework");
            if (bh.ov(packageInfo.versionName) || packageInfo.versionName.compareTo("1.3.3") < 0) {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.wework");
            } else {
                String str2;
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                if (i == 2 || i == 4 || i == 6) {
                    str2 = "wxwork://createconversation";
                } else {
                    str2 = "wxwork://conversationlist";
                }
                intent.setData(Uri.parse(str2));
                launchIntentForPackage = intent;
            }
            a.post(new 4(context, launchIntentForPackage));
        } else if (jy.field_chatOpen || jy.field_use_preset_banner_tips) {
            h.a(context, R.l.ece, 0, R.l.ecd, R.l.dEn, new 1(context, str, i), null);
        } else if (jy.field_show_confirm) {
            j.b bVar = new j.b(context);
            bVar.xZR = context.getString(R.l.dEn);
            bVar.EG(R.l.ecd);
            y.Mm();
            y.Mm();
            bVar.YK(c.hn(1));
            bVar.a(new 2(), new 3(context, str, i)).pyk.show();
        } else {
            o(context, str, i);
        }
    }

    public static void o(Context context, String str, int i) {
        aa(str, 3, i);
        ab(str, 3, i);
        y.Mf();
        String str2 = "https://work.weixin.qq.com/wework_admin/commdownload?from=conv%s";
        Object[] objArr = new Object[1];
        objArr[0] = bh.ov(e.jO(str)) ? "off" : "on";
        String format = String.format(str2, objArr);
        FileDownloadTaskInfo xJ = f.aAd().xJ(format);
        if (xJ != null && xJ.status == 3 && com.tencent.mm.a.e.bO(xJ.path)) {
            com.tencent.mm.loader.stub.b.deleteFile(xJ.path);
        }
        u.makeText(context, context.getString(R.l.ecf), MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN).show();
        com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
        aVar.xL(format);
        aVar.xN(context.getString(R.l.ecb));
        aVar.ox(1);
        aVar.ep(true);
        f.aAd().a(aVar.lsE);
    }

    private static int aa(String str, int i, int i2) {
        d jK = y.Mf().jK(str);
        if (jK.Lf()) {
            str = jK.Lm();
        }
        b jx = y.Mm().jx(str);
        int i3 = jx != null ? jx.field_qyUin : 0;
        int i4 = jx != null ? jx.field_userUin : 0;
        long j = jx != null ? jx.field_wwCorpId : 0;
        long j2 = jx != null ? jx.field_wwUserVid : 0;
        com.tencent.mm.plugin.report.service.g.pQN.h(13656, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        x.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        return i2;
    }

    public static void df(String str, int i) {
        if (i > 0) {
            int i2;
            int i3;
            b jx = y.Mm().jx(str);
            if (jx != null) {
                i2 = jx.field_qyUin;
            } else {
                i2 = 0;
            }
            if (jx != null) {
                i3 = jx.field_userUin;
            } else {
                i3 = 0;
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(13703, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
            x.d("MicroMsg.EnterpriseHelper", "enterprise click report: %s,%s,%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
        }
    }

    public static void ab(String str, int i, int i2) {
        int i3;
        d jK = y.Mf().jK(str);
        if (i2 == 3) {
            i3 = 2;
        } else {
            i3 = i2;
        }
        if (i3 == 4) {
            i3 = 3;
        }
        if (jK.Lf()) {
            str = jK.Lm();
        }
        b jx = y.Mm().jx(str);
        com.tencent.mm.plugin.report.service.g.pQN.h(15162, Long.valueOf(jx.field_wwCorpId), Long.valueOf(jx.field_wwUserVid), Boolean.valueOf(jx.field_chatOpen), Integer.valueOf(jx.field_wwUnreadCnt), Boolean.valueOf(jx.field_show_confirm), Integer.valueOf(jx.field_userType), Integer.valueOf(i), Integer.valueOf(i3));
    }
}

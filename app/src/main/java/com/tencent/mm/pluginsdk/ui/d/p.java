package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.u;
import java.io.File;

public final class p {
    public static boolean ur() {
        boolean z = true;
        if (g.Dh().Cy()) {
            boolean z2;
            if (bh.PT() || f.fdS == 1 || bh.getInt(com.tencent.mm.k.g.zY().getValue("ShowWeixinPBIntro"), 0) != 0 || com.tencent.mm.pluginsdk.model.app.p.m(ac.getContext(), "com.tencent.pb")) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                int a = bh.a((Integer) g.Dj().CU().get(a.xnS, null), 3);
                x.v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", new Object[]{Integer.valueOf(a)});
                if (a <= 0) {
                    return false;
                }
                g.Dj().CU().set(352257, Integer.valueOf(a - 1));
                return true;
            }
            String str = "MicroMsg.WxPhoneBookHelper";
            String str2 = "%b, %b, %b, %b";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(bh.PT());
            if (f.fdS != 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (bh.getInt(com.tencent.mm.k.g.zY().getValue("ShowWeixinPBIntro"), 0) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            if (com.tencent.mm.pluginsdk.model.app.p.m(ac.getContext(), "com.tencent.pb")) {
                z = false;
            }
            objArr[3] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            return false;
        }
        x.e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
        return false;
    }

    public static void d(Context context, Bundle bundle) {
        int i = bundle != null ? bundle.getInt("fromScene") : 0;
        com.tencent.mm.plugin.report.service.g.pQN.h(11621, new Object[]{Integer.valueOf(i), Integer.valueOf(0)});
        FileDownloadTaskInfo xJ = com.tencent.mm.plugin.downloader.model.f.aAd().xJ("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
        if (xJ == null || xJ.status != 3) {
            u.makeText(context, context.getString(R.l.dSu), MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN).show();
            com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
            aVar.xL("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
            aVar.xN(context.getString(R.l.dSA));
            aVar.ox(1);
            aVar.ep(true);
            com.tencent.mm.plugin.downloader.model.f.aAd().a(aVar.lsE);
            return;
        }
        x.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
        if (e.bO(xJ.path)) {
            q.e(context, Uri.fromFile(new File(xJ.path)));
        }
    }
}

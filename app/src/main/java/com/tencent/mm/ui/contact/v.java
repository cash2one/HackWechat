package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.g.b.af;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.snackbar.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.List;

public final class v {
    public static String ZE(String str) {
        String str2;
        h jm = n.JQ().jm(str);
        ar.Hg();
        af WO = c.EY().WO(str);
        int i = WO.fWe;
        if (jm != null) {
            i = jm.fWe;
        }
        d jS = WO.cia() ? f.jS(WO.field_username) : null;
        String str3 = "<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>";
        Object[] objArr = new Object[15];
        objArr[0] = bh.VG(WO.field_username);
        objArr[1] = bh.VG(WO.AP());
        objArr[2] = bh.VG(WO.vN());
        objArr[3] = bh.VG(WO.AP());
        objArr[4] = bh.VG(WO.vQ());
        objArr[5] = Integer.valueOf(i);
        objArr[6] = bh.VG(WO.getProvince());
        objArr[7] = bh.VG(WO.getCity());
        objArr[8] = bh.VG(WO.signature);
        objArr[9] = Integer.valueOf(WO.fWo);
        objArr[10] = Integer.valueOf(WO.fWf);
        objArr[11] = Integer.valueOf(WO.field_verifyFlag);
        objArr[12] = bh.VG(WO.fWu);
        if (jS == null) {
            str2 = "";
        } else {
            str2 = bh.VG(jS.field_brandIconURL);
        }
        objArr[13] = str2;
        objArr[14] = bh.VG(WO.fWv);
        return String.format(str3, objArr);
    }

    public static void a(Activity activity, String str, List<String> list) {
        for (String ZE : list) {
            ar.CG().a(new j(str, ZE(ZE), 42), 0);
        }
        a.h(activity, activity.getString(R.l.epb));
        g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY, new Object[]{str, Integer.valueOf(3), Integer.valueOf(list.size())});
        activity.setResult(-1);
        ag.h(new 1(activity), 1800);
    }
}

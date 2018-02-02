package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.bs.a;
import java.util.Map;

public final class j implements a {
    public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";

    public final void a(d.a aVar) {
        x.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
        b.pY(74);
        if (aVar == null || aVar.hmq == null) {
            x.e(TAG, "onPreAddMessage cmdAM is null");
            return;
        }
        i iVar = new i();
        String a = n.a(aVar.hmq.vGZ);
        iVar.kmW = new StringBuffer();
        Map y = bi.y(a, "sysmsg");
        iVar.qSa.clear();
        if (y == null) {
            x.i("MicroMsg.NewYearSnsTips", "errr for paser %s", new Object[]{a});
            b.pY(75);
        } else {
            int i = 0;
            while (true) {
                String str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr = new Object[2];
                objArr[0] = i == 0 ? "" : String.valueOf(i);
                objArr[1] = "BeginTime";
                long VJ = bh.VJ((String) y.get(String.format(str, objArr)));
                iVar.kmW.append("BeginTime:" + VJ + ";");
                str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr2 = new Object[2];
                objArr2[0] = i == 0 ? "" : String.valueOf(i);
                objArr2[1] = "EndTime";
                long VJ2 = bh.VJ((String) y.get(String.format(str, objArr2)));
                iVar.kmW.append("EndTime:" + VJ2 + ";");
                str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr3 = new Object[2];
                objArr3[0] = i == 0 ? "" : String.valueOf(i);
                objArr3[1] = "ActionID";
                str = bh.az((String) y.get(String.format(str, objArr3)), "");
                iVar.kmW.append("ActionID:" + str + ";");
                if (bh.ov(str)) {
                    break;
                }
                String str2 = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr4 = new Object[2];
                objArr4[0] = i == 0 ? "" : String.valueOf(i);
                objArr4[1] = "TipsMessage";
                String az = bh.az((String) y.get(String.format(str2, objArr4)), "");
                iVar.kmW.append("TipsMessage:" + az + ";\n");
                h hVar = new h();
                hVar.qRX = str;
                hVar.qRn = VJ;
                hVar.ktZ = VJ2;
                hVar.qRY = az;
                iVar.qSa.add(hVar);
                i++;
            }
            if (iVar.qSa.size() == 0) {
                b.pY(76);
            }
        }
        x.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + iVar.kmW.toString());
        g.Dk();
        g.Dj().CU().a(w.a.xqE, a);
        g.Dk();
        g.Dj().CU().lH(true);
    }
}

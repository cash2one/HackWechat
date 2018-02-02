package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class g {
    private final String fEP;
    private a hRv = null;

    public g(String str) {
        this.fEP = str;
    }

    public final a SV() {
        a aVar = null;
        if (this.hRv != null) {
            return this.hRv;
        }
        a aVar2;
        String str = this.fEP + "mobileinfo.ini";
        File file = new File(str);
        if (file.exists()) {
            a aVar3 = new a(str);
            aVar2 = new a();
            aVar2.hRw = bh.e(aVar3.Wb("ispCode"));
            aVar2.ispName = aVar3.getValue("ispName");
            aVar2.fpn = bh.e(aVar3.Wb("subType"));
            aVar2.extraInfo = aVar3.getValue("extraInfo");
            long lastModified = file.lastModified();
            if (CdnLogic.kMediaTypeBeatificFile == r.idt && r.idu > 0) {
                lastModified = bh.Wp() - ((long) r.idu);
                x.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", new Object[]{Integer.valueOf(r.idu), Long.valueOf(lastModified)});
                r.idu = 0;
            }
            if (lastModified > 0 && bh.bz(lastModified) > 259200000) {
                x.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", new Object[]{Long.valueOf(bh.bz(lastModified)), str});
                aVar2.hRx = true;
            }
            x.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", new Object[]{Integer.valueOf(aVar2.fpn), Integer.valueOf(aVar2.hRw), aVar2.ispName, aVar2.extraInfo, Boolean.valueOf(aVar2.hRx)});
        } else {
            x.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", new Object[]{str});
            aVar2 = null;
        }
        this.hRv = aVar2;
        if (this.hRv == null || this.hRv.hRx) {
            Context context = ac.getContext();
            if (context == null) {
                x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
                    } else if (activeNetworkInfo.getType() == 1) {
                        x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
                    } else {
                        aVar = new a();
                        aVar.fpn = activeNetworkInfo.getSubtype();
                        aVar.hRw = an.getISPCode(context);
                        aVar.ispName = an.getISPName(context);
                        aVar.extraInfo = activeNetworkInfo.getExtraInfo();
                        x.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", new Object[]{Integer.valueOf(aVar.fpn), Integer.valueOf(aVar.hRw), aVar.ispName, aVar.extraInfo});
                    }
                }
            }
            if (aVar == null) {
                x.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
                return this.hRv;
            }
            this.hRv = aVar;
            aVar2 = this.hRv;
            if (aVar2 == null) {
                x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
            } else if (bh.ov(str)) {
                x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
            } else {
                a aVar4 = new a(str);
                aVar4.cX("ispCode", aVar2.hRw);
                aVar4.fv("ispName", aVar2.ispName);
                aVar4.cX("subType", aVar2.fpn);
                aVar4.fv("extraInfo", aVar2.extraInfo);
            }
            return this.hRv;
        }
        x.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
        return this.hRv;
    }
}

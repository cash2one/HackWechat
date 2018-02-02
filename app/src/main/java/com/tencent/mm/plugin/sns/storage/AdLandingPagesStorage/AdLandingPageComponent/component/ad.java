package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.AsyncTask;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashSet;
import java.util.Set;
import org.xwalk.core.R$styleable;

public final class ad extends AsyncTask<String, Void, Void> {
    private static Set<String> rlL = new HashSet();
    private static byte[] rlM = new byte[0];
    final String fileName;
    final String filePath;
    final af handler;
    final String rlN;
    final String rlO;
    final String rlP;
    final a rlQ;
    final int rlR;
    private boolean rlS;
    private int rlT;
    private int scene = 0;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return y((String[]) objArr);
    }

    public ad(String str, String str2, boolean z, int i, int i2, af afVar, a aVar) {
        FileOp.mh(str);
        this.rlP = str;
        this.fileName = str2;
        this.filePath = str + "/" + str2;
        this.rlS = z;
        this.rlT = i;
        this.rlO = "temp_" + str2;
        this.rlN = str + "/" + this.rlO;
        this.handler = afVar;
        this.rlR = Downloads.SPLIT_RANGE_SIZE_WAP;
        this.rlQ = new 1(this, afVar, aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Void y(String... strArr) {
        if (FileOp.bO(this.filePath)) {
            this.rlQ.La(this.filePath);
            return null;
        }
        synchronized (rlM) {
            if (rlL.contains(strArr[0])) {
                return null;
            }
            rlL.add(strArr[0]);
        }
        if (r0 != null) {
            r0.disconnect();
        }
        synchronized (rlM) {
            rlL.remove(strArr[0]);
        }
        String UZ = ab.UZ(strArr[0]);
        int bwi = bwi();
        int bz = (int) bh.bz(r8);
        d dVar = new d();
        dVar.q("20UrlMd5", UZ + ",");
        dVar.q("21MediaType", bwi + ",");
        dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
        dVar.q("23CostTime", bz + ",");
        dVar.q("24RetCode", r6 + ",");
        dVar.q("25Scene", this.scene + ",");
        dVar.q("26Size", r2 + ",");
        dVar.q("27StartDownloadTime", (r8 / 1000) + ",");
        x.i("MicroMsg.LandingpageDowloadAsynTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
        g.pQN.h(13572, new Object[]{dVar});
        return null;
    }

    private int bwi() {
        switch (this.rlT) {
            case 41:
            case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
            case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
            case 1000000001:
                return 1;
            case 61:
                return 2;
            case 62:
                return 3;
            default:
                return 0;
        }
    }
}

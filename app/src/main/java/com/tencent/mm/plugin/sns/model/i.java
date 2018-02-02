package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.model.g.2;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class i extends h<String, Integer, Boolean> {
    private String aAM = "";
    private String hKZ;
    private n har = null;
    private int qTD;
    private String qTE;
    private List<aqr> qTF;

    public final /* synthetic */ Object buP() {
        String JD = com.tencent.mm.plugin.sns.data.i.JD(this.hKZ);
        String r = am.r(this.qTE, this.hKZ);
        if (!FileOp.bO(r + JD)) {
            a(this.hKZ, JD, this.qTF);
        }
        this.har = com.tencent.mm.plugin.sns.data.i.JM(r + JD);
        ae.aNT().post(new 2(ae.bvs(), 0, this.hKZ, this.har));
        x.i("MicroMsg.MutiImageLoader", "deocde done bm " + this.har + " requestid " + this.hKZ + " " + r + JD);
        return Boolean.valueOf(true);
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Boolean) obj);
        ae.bvs().qTi.remove(this.aAM);
        ae.bvs().b(this.aAM, this.har);
    }

    public i(String str, String str2, List<aqr> list) {
        ae.bvs().qTi.add(str);
        this.hKZ = str2;
        this.qTE = ae.getAccSnsPath();
        this.qTD = ae.bvD();
        this.qTF = list;
        this.aAM = str;
    }

    public final af buO() {
        return ae.aNR();
    }

    private boolean a(String str, String str2, List<aqr> list) {
        String str3;
        x.i("MicroMsg.MutiImageLoader", "makeMutilMedia " + str + " " + str2);
        List linkedList = new LinkedList();
        int i = 0;
        for (aqr com_tencent_mm_protocal_c_aqr : list) {
            String f = com.tencent.mm.plugin.sns.data.i.f(com_tencent_mm_protocal_c_aqr);
            String e = com.tencent.mm.plugin.sns.data.i.e(com_tencent_mm_protocal_c_aqr);
            String r = am.r(this.qTE, com_tencent_mm_protocal_c_aqr.nGJ);
            if (!FileOp.bO(r + f)) {
                if (!FileOp.bO(r + e)) {
                    String l = com.tencent.mm.plugin.sns.data.i.l(com_tencent_mm_protocal_c_aqr);
                    if (FileOp.bO(r + l)) {
                        str3 = l;
                    } else {
                        str3 = com.tencent.mm.plugin.sns.data.i.m(com_tencent_mm_protocal_c_aqr);
                    }
                    r.a(r, str3, e, (float) ae.bvE());
                }
                r.b(r, e, f, (float) ae.bvD());
            }
            n JM = com.tencent.mm.plugin.sns.data.i.JM(r + f);
            if (JM == null) {
                FileOp.deleteFile(r + f);
                x.e("MicroMsg.MutiImageLoader", "userThumb decode fail !! " + f);
                return false;
            }
            linkedList.add(JM);
            x.i("MicroMsg.MutiImageLoader", "getbitmap from bm " + JM + " " + r + f);
            int i2 = i + 1;
            if (i2 < 4) {
                i = i2;
            }
        }
        try {
            str3 = am.r(this.qTE, str);
            FileOp.mh(str3);
            d.a(com.tencent.mm.plugin.sns.data.i.h(linkedList, this.qTD), 100, CompressFormat.JPEG, str3 + str2, false);
            return true;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MutiImageLoader", e2, "makeMutilMedia failed: " + str2, new Object[0]);
            return false;
        }
    }
}

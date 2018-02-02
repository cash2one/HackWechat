package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.c.byi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class h extends a {
    public final List<Integer> bOG() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(CdnLogic.kMediaTypeExposeImage));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY));
        arrayList.add(Integer.valueOf(11035));
        return arrayList;
    }

    public final boolean bOH() {
        return false;
    }

    protected final byte[] n(int i, byte[] bArr) {
        int i2 = 0;
        String str;
        String str2;
        if (i == CdnLogic.kMediaTypeExposeImage) {
            str = new String(bArr);
            str2 = "";
            try {
                str2 = FileOp.bT(str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e, "handleData", new Object[0]);
            }
            String[] split = str2.split("​​");
            List arrayList = new ArrayList();
            for (int i3 = 0; i3 < split.length; i3++) {
                arrayList.add(split[i3]);
                if (i3 % 50 == 9) {
                    g.pQN.k("WearCrash", arrayList);
                    arrayList.clear();
                }
            }
            if (arrayList.size() > 0) {
                g.pQN.k("WearCrash", arrayList);
                arrayList.clear();
            }
            new File(str).delete();
        } else if (i == TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY) {
            str = new String(bArr);
            str2 = "";
            try {
                str2 = FileOp.bT(str);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e2, "handleData", new Object[0]);
            }
            String[] split2 = str2.split("​​");
            int length = split2.length;
            while (i2 < length) {
                x.i("MicroMsg.Wear.LOG", split2[i2]);
                i2++;
            }
            new File(str).delete();
        } else if (i == 11035) {
            byi com_tencent_mm_protocal_c_byi = new byi();
            try {
                com_tencent_mm_protocal_c_byi.aF(bArr);
            } catch (IOException e3) {
            }
            if (a.bOt().thH.thY.tiP != null) {
                x.v("MicroMsg.Wear.HttpLogServer", "report kv id=%d %s %s %s %s data=%s", Integer.valueOf(com_tencent_mm_protocal_c_byi.nkn), a.bOt().thH.thY.tiP.ksZ, a.bOt().thH.thY.tiP.wYz, Integer.valueOf(a.bOt().thH.thY.tiP.vHT), a.bOt().thH.thY.tiP.wYA, com_tencent_mm_protocal_c_byi.wVi);
                g.pQN.h(com_tencent_mm_protocal_c_byi.nkn, r2.ksZ, r2.wYz, Integer.valueOf(r2.vHT), r2.wYA, com_tencent_mm_protocal_c_byi.wVi);
            }
        }
        return null;
    }
}

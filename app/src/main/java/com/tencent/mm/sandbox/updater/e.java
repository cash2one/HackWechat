package com.tencent.mm.sandbox.updater;

import com.tencent.mm.c.i;
import com.tencent.mm.c.i.a;
import com.tencent.mm.protocal.c.ass;
import com.tencent.mm.protocal.c.bnt;
import com.tencent.mm.protocal.c.bnu;
import com.tencent.mm.protocal.c.bnv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    public final int fileSize;
    public final Integer nBk;
    public HashMap<Integer, LinkedList<ass>> nBl = new HashMap();
    public final Integer nBm;
    public final Integer nBn;
    public final String nBo;
    public final String nBp;
    public final String nBq;
    public String nBr;
    public String nBs;
    public int versionCode;

    public e(bnv com_tencent_mm_protocal_c_bnv) {
        if (com_tencent_mm_protocal_c_bnv == null) {
            this.nBk = Integer.valueOf(1);
            this.nBo = "";
            this.nBp = "";
            this.nBm = Integer.valueOf(-1);
            this.nBn = Integer.valueOf(-1);
            this.nBq = "";
            this.fileSize = 0;
            this.nBr = "";
            this.nBs = "";
            this.versionCode = 0;
            return;
        }
        if (com_tencent_mm_protocal_c_bnv.wQG != null) {
            this.nBp = com_tencent_mm_protocal_c_bnv.wQG.vZU;
            this.nBo = com_tencent_mm_protocal_c_bnv.wQG.nfX;
            this.fileSize = com_tencent_mm_protocal_c_bnv.wQG.vYh;
        } else {
            this.nBp = "";
            this.nBo = "";
            this.fileSize = 0;
        }
        this.nBk = Integer.valueOf(com_tencent_mm_protocal_c_bnv.state);
        this.nBn = Integer.valueOf(com_tencent_mm_protocal_c_bnv.wQF);
        if (!(com_tencent_mm_protocal_c_bnv.wQD == null || com_tencent_mm_protocal_c_bnv.wQD.isEmpty())) {
            int size = com_tencent_mm_protocal_c_bnv.wQD.size();
            for (int i = 0; i < size; i++) {
                bnu com_tencent_mm_protocal_c_bnu = (bnu) com_tencent_mm_protocal_c_bnv.wQD.get(i);
                if (!(com_tencent_mm_protocal_c_bnu.wQC == null || com_tencent_mm_protocal_c_bnu.wQC.isEmpty())) {
                    this.nBl.put(Integer.valueOf(com_tencent_mm_protocal_c_bnu.type), com_tencent_mm_protocal_c_bnu.wQC);
                }
            }
        }
        this.nBm = Integer.valueOf(com_tencent_mm_protocal_c_bnv.wQE);
        this.nBq = com_tencent_mm_protocal_c_bnv.vWt;
        if (com_tencent_mm_protocal_c_bnv.wQI == null || com_tencent_mm_protocal_c_bnv.wQI.isEmpty()) {
            this.nBr = "";
            this.nBs = "";
            this.versionCode = 0;
            return;
        }
        Iterator it = com_tencent_mm_protocal_c_bnv.wQI.iterator();
        while (it.hasNext()) {
            bnt com_tencent_mm_protocal_c_bnt = (bnt) it.next();
            if (!(com_tencent_mm_protocal_c_bnt == null || bh.ov(com_tencent_mm_protocal_c_bnt.aAM))) {
                if (com_tencent_mm_protocal_c_bnt.aAM.equalsIgnoreCase("newApkMd5")) {
                    this.nBr = com_tencent_mm_protocal_c_bnt.value;
                } else if (com_tencent_mm_protocal_c_bnt.aAM.equalsIgnoreCase("oldApkMd5")) {
                    this.nBs = com_tencent_mm_protocal_c_bnt.value;
                } else if (com_tencent_mm_protocal_c_bnt.aAM.equalsIgnoreCase(DownloadInfoColumns.VERSIONCODE)) {
                    this.versionCode = bh.VI(com_tencent_mm_protocal_c_bnt.value);
                }
            }
        }
    }

    public final String cer() {
        String substring = this.nBo.substring(0, this.nBo.lastIndexOf(47) + 1);
        String substring2 = this.nBo.substring(this.nBo.lastIndexOf(47) + 1);
        i iVar = new i(substring, Integer.valueOf(this.versionCode).intValue());
        iVar.a(new a(this.nBs, this.nBr, this.nBp, substring2, this.fileSize));
        return iVar.tr();
    }

    public final String toString() {
        return "responseState:" + this.nBk + "\ncdnUrl:" + this.nBo + "\nfileMd5:" + this.nBp + "\npackageType:" + this.nBm + "\nnetworkType:" + this.nBn + "\npatchId:" + this.nBq;
    }
}

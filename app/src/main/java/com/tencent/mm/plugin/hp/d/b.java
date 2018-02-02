package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.util.Base64;
import com.tencent.mm.protocal.c.ass;
import com.tencent.mm.protocal.c.bnt;
import com.tencent.mm.protocal.c.bnu;
import com.tencent.mm.protocal.c.bnv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
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
    public int nBt;
    public int nBu;
    public int nBv;
    public int nBw;
    public int versionCode;

    public b(bnv com_tencent_mm_protocal_c_bnv) {
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
            this.nBt = Integer.MIN_VALUE;
            this.nBu = 204800;
            this.nBv = 1800;
            this.nBw = 1;
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
            this.nBt = Integer.MIN_VALUE;
            this.nBu = 204800;
            this.nBv = 1800;
            this.nBw = 1;
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
                } else if (com_tencent_mm_protocal_c_bnt.aAM.equalsIgnoreCase("cdnClientNormalSpeed")) {
                    this.nBu = bh.VI(com_tencent_mm_protocal_c_bnt.value);
                } else if (com_tencent_mm_protocal_c_bnt.aAM.equalsIgnoreCase("cdnMaxOutLimit")) {
                    this.nBt = bh.VI(com_tencent_mm_protocal_c_bnt.value);
                } else if (com_tencent_mm_protocal_c_bnt.aAM.equalsIgnoreCase("cdnDeployUseTime")) {
                    this.nBv = bh.VI(com_tencent_mm_protocal_c_bnt.value);
                } else if (com_tencent_mm_protocal_c_bnt.aAM.equalsIgnoreCase("cdnCycleTime")) {
                    this.nBw = bh.VI(com_tencent_mm_protocal_c_bnt.value);
                }
            }
        }
    }

    public final boolean aSH() {
        Context context = ac.getContext();
        if (!an.isConnected(context)) {
            return false;
        }
        if (this.nBn.intValue() == 1 || this.nBn.intValue() != 3) {
            return true;
        }
        return an.isWifi(context);
    }

    public final boolean aSI() {
        return this.nBk.intValue() == 2 || this.nBk.intValue() == 4;
    }

    public final boolean aSJ() {
        if (this.nBl == null || this.nBl.isEmpty() || !this.nBl.containsKey(Integer.valueOf(4))) {
            return false;
        }
        return true;
    }

    public static String a(HashMap<Integer, LinkedList<ass>> hashMap, int i) {
        if (hashMap == null || hashMap.isEmpty()) {
            return "";
        }
        String str = "";
        LinkedList linkedList = (LinkedList) hashMap.get(Integer.valueOf(i));
        if (linkedList == null || linkedList.isEmpty()) {
            return str;
        }
        int size = linkedList.size();
        int i2 = 0;
        while (i2 < size) {
            String str2;
            ass com_tencent_mm_protocal_c_ass = (ass) linkedList.get(i2);
            if (com_tencent_mm_protocal_c_ass.lang.equalsIgnoreCase("default")) {
                str2 = new String(Base64.decode(com_tencent_mm_protocal_c_ass.content, 0));
            } else if (com_tencent_mm_protocal_c_ass.lang.equalsIgnoreCase(w.cfi())) {
                return new String(Base64.decode(com_tencent_mm_protocal_c_ass.content, 0));
            } else {
                str2 = str;
            }
            i2++;
            str = str2;
        }
        return str;
    }

    public final String aSK() {
        if (aSJ()) {
            return a(this.nBl, 4);
        }
        return "";
    }

    public final String toString() {
        return "responseState:" + this.nBk + "\ncdnUrl:" + this.nBo + "\nfileMd5:" + this.nBp + "\npackageType:" + this.nBm + "\nnetworkType:" + this.nBn + "\npatchId:" + this.nBq;
    }
}

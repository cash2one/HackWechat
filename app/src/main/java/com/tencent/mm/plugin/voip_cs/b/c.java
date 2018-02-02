package com.tencent.mm.plugin.voip_cs.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.protocal.c.btv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static int svU = 0;
    public static int svV = 1;
    public static int svW = 2;
    public int bjS;
    public int channelStrategy;
    public String deviceModel;
    public long nDy;
    public long nEV;
    public String nFe;
    public String nFf;
    public int networkType;
    public int saT;
    public int sob;
    public int soo;
    public int sot;
    public int sou;
    public int sov;
    public int spG;
    public int svX;
    public int svY;
    public int svZ;
    public long swA;
    public int swB;
    public int swC;
    public int swD;
    public int swE;
    public String swF;
    public String swG;
    public String swH;
    public int swI;
    public int swJ;
    public int swK;
    public int swL;
    public int swM;
    public int swN;
    public int swa;
    public int swb;
    public int swc;
    public int swd;
    public int swe;
    public int swf;
    public int swg;
    public int swh;
    public int swi;
    public long swj;
    public String swk;
    public int swl;
    public int swm;
    public int swn;
    public int swo;
    public int swp;
    public int swq;
    public int swr;
    public int sws;
    public int swt;
    public int swu;
    public int swv;
    public long sww;
    public int swx;
    public long swy;
    public long swz;
    public int videoFps;

    public c() {
        this.bjS = 0;
        this.svX = 0;
        this.svY = 0;
        this.svZ = 0;
        this.videoFps = 0;
        this.swa = 0;
        this.swb = 0;
        this.swc = 0;
        this.swd = 0;
        this.swe = 0;
        this.swf = 0;
        this.networkType = 0;
        this.swg = 0;
        this.swi = 0;
        this.soo = 0;
        this.swj = 0;
        this.nDy = 0;
        this.swk = "";
        this.sob = 0;
        this.swm = 0;
        this.swn = 0;
        this.swo = 0;
        this.swp = 0;
        this.sou = 0;
        this.sot = 0;
        this.swq = 0;
        this.swr = 1;
        this.sws = 0;
        this.swt = 0;
        this.swu = 0;
        this.swv = 0;
        this.sww = 0;
        this.swy = 0;
        this.swz = 0;
        this.swA = 0;
        this.nEV = 0;
        this.channelStrategy = 1;
        this.spG = 0;
        this.sov = 0;
        this.swD = -1;
        this.swE = 0;
        this.swF = "";
        this.deviceModel = "";
        this.swG = "";
        this.swH = "";
        this.swI = 0;
        this.swJ = 0;
        this.swK = 0;
        this.swL = 0;
        this.swM = 0;
        this.swN = 0;
        this.saT = m.yp();
        this.nFf = "";
        this.nFe = "";
        this.swF = Build.MANUFACTURER;
        if (this.swF.contains(",")) {
            this.swF = this.swF.replace(',', ' ');
        }
        this.deviceModel = Build.MODEL;
        if (this.deviceModel.contains(",")) {
            this.deviceModel = this.deviceModel.replace(',', ' ');
        }
        this.swG = VERSION.SDK;
        if (this.swG.contains(",")) {
            this.swG = this.swG.replace(',', ' ');
        }
        this.swH = VERSION.RELEASE;
        if (this.swH.contains(",")) {
            this.swH = this.swH.replace(',', ' ');
        }
    }

    public final void yY(int i) {
        this.sot = Math.abs(i);
    }

    public final void bIV() {
        x.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
        if (this.swM == 0 && this.swL != 0) {
            this.swM = (int) (System.currentTimeMillis() / 1000);
            this.nEV = (long) (this.swM - this.swL);
        }
    }

    public final btv bIW() {
        btv com_tencent_mm_protocal_c_btv = new btv();
        com_tencent_mm_protocal_c_btv.ktN = 2;
        com_tencent_mm_protocal_c_btv.wVi = this.nFe;
        x.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[]{com_tencent_mm_protocal_c_btv.wVi});
        String[] split = this.nFe.split(",");
        if (split != null && split.length > 0) {
            try {
                this.videoFps = bh.getInt(split[8], 0);
                this.swa = bh.getInt(split[10], 0);
            } catch (Exception e) {
                x.e("MicroMsg.VoipCSReportHelper", "get videoFps and rate fail!!");
            }
        }
        return com_tencent_mm_protocal_c_btv;
    }

    public static int bIX() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ac.getContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo == null) {
                    return svU;
                }
                if (networkInfo.getState() == State.CONNECTED) {
                    return svV;
                }
                return svW;
            }
        } catch (Exception e) {
            x.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
        }
        return svU;
    }

    public static int getNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() != 0) {
                return 0;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 13) {
                return 4;
            }
            if ((activeNetworkInfo.getSubtype() < 3 || activeNetworkInfo.getSubtype() >= 13) && activeNetworkInfo.getSubtype() <= 13) {
                return 2;
            }
            return 3;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoipCSReportHelper", e, "", new Object[0]);
            return 0;
        }
    }
}

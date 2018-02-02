package com.tencent.mm.plugin.scanner.a;

import android.graphics.Point;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class l {
    public static int pSQ = 0;
    public static int pSR = 1;
    public static int pSS = 2;
    public static l pST = new l();
    private boolean hKW = false;
    public int pLa = -1;
    private long pSU = 0;
    public boolean pSV = false;
    public int pSW = 0;
    private long pSX = 0;
    private Point pSY = null;
    public String pSZ;
    public String pTa;
    public String pTb;
    public int pTc;
    public int pTd;
    public String pTe;
    public StringBuilder pTf = new StringBuilder();
    private int pTg;
    public boolean pTh;
    private int retryCount = 0;

    public final void ee(long j) {
        x.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[]{Long.valueOf(j)});
        this.pSU += j;
    }

    public final void boE() {
        x.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
        this.pSV = true;
    }

    public final void boF() {
        x.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[]{Integer.valueOf(this.pSW)});
        this.pSW++;
    }

    public final void vE(int i) {
        x.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[]{Integer.valueOf(i)});
        this.pLa = i;
    }

    public final void dk(int i, int i2) {
        x.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.pSY = new Point(i, i2);
    }

    public final void boG() {
        x.i("MicroMsg.QBarEngineReporter", "addRetryTime, current retry count: %s", new Object[]{Integer.valueOf(this.retryCount)});
        this.retryCount++;
    }

    public final void ef(long j) {
        x.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[]{Long.valueOf(j)});
        this.pSX = j;
    }

    public final void vF(int i) {
        if (this.pTg != 2) {
            this.pTg = i;
        }
    }

    public final void aUb() {
        int i = 0;
        if (this.hKW) {
            x.i("MicroMsg.QBarEngineReporter", "doReport, already report");
            return;
        }
        int i2;
        String str = "MicroMsg.QBarEngineReporter";
        String str2 = "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d";
        Object[] objArr = new Object[16];
        objArr[0] = Integer.valueOf(this.pSW);
        objArr[1] = Long.valueOf(this.pSU);
        objArr[2] = Long.valueOf(this.pSX);
        objArr[3] = Integer.valueOf(this.pLa);
        objArr[4] = this.pSY;
        objArr[5] = Integer.valueOf(this.retryCount);
        objArr[6] = Boolean.valueOf(this.pSV);
        objArr[7] = this.pSZ;
        objArr[8] = this.pTa;
        objArr[9] = this.pTb;
        objArr[10] = Integer.valueOf(this.pTc);
        objArr[11] = Integer.valueOf(this.pTd);
        objArr[12] = this.pTe;
        if (bh.ov(this.pTa)) {
            i2 = 0;
        } else {
            i2 = this.pTa.length();
        }
        objArr[13] = Integer.valueOf(i2);
        objArr[14] = this.pTf.toString();
        objArr[15] = Integer.valueOf(this.pTg);
        x.i(str, str2, objArr);
        String str3 = "";
        if (this.pSY != null) {
            str3 = this.pSY.x + "x" + this.pSY.y;
        }
        g gVar = g.pQN;
        objArr = new Object[17];
        objArr[0] = Integer.valueOf(this.pSW);
        objArr[1] = Long.valueOf(this.pSU);
        objArr[2] = Long.valueOf(this.pSX);
        objArr[3] = Integer.valueOf(this.pLa);
        objArr[4] = str3;
        objArr[5] = Integer.valueOf(this.retryCount);
        if (this.pSV) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = this.pSZ;
        objArr[8] = "";
        objArr[9] = this.pTb;
        objArr[10] = Integer.valueOf(this.pTc);
        objArr[11] = Integer.valueOf(this.pTd);
        objArr[12] = this.pTe;
        if (bh.ov(this.pTa)) {
            i2 = 0;
        } else {
            i2 = this.pTa.length();
        }
        objArr[13] = Integer.valueOf(i2);
        objArr[14] = this.pTf.toString();
        objArr[15] = Integer.valueOf(this.pTg);
        if (this.pTh) {
            i = 1;
        }
        objArr[16] = Integer.valueOf(i);
        gVar.h(13233, objArr);
        this.hKW = true;
    }

    public final void reset() {
        this.pSU = 0;
        this.pSV = false;
        this.pSW = 0;
        this.pLa = -1;
        this.pSY = null;
        this.retryCount = 0;
        this.pSZ = "";
        this.pTa = "";
        this.pTb = "";
        this.pTc = 0;
        this.pTd = 0;
        this.pTe = "";
        this.pSX = 0;
        this.hKW = false;
        this.pTf.delete(0, this.pTf.length());
        this.pTg = 0;
        this.pTh = false;
        x.i("MicroMsg.QBarEngineReporter", "reset");
    }
}

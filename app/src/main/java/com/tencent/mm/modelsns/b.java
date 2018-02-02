package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.blq;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static boolean hLV = false;
    private static AtomicInteger hOO = new AtomicInteger(0);
    public Object hOE = null;
    public int hOF = 1;
    public long hOG;
    public int hOH;
    public int hOI;
    public int hOJ;
    public StringBuffer hOK = new StringBuffer();
    public StringBuffer hOL = new StringBuffer();
    public StringBuffer hOM = new StringBuffer();
    public StringBuffer hON = new StringBuffer();
    public int opType = 0;

    static /* synthetic */ void a(b bVar) {
        d dVar = new d();
        dVar.q("\n\nmodel", bVar.hOF + ",");
        dVar.q("opType", bVar.opType + ",");
        dVar.q("timeStamp", bVar.hOG + ",");
        dVar.q("seq", bVar.hOH + ",");
        dVar.q("netWork", bVar.hOI + ",");
        dVar.q("page", bVar.hOJ + ",");
        dVar.q("StatusDesc1", bVar.hOK.toString() + ",");
        dVar.q("DataFlowSourceInfo", bVar.hOL.toString() + ",");
        dVar.q("DataFlowResultInfo", bVar.hOM.toString() + ",");
        dVar.q("StatusDesc2", bVar.hON.toString() + ", ");
        dVar.hOS.append("bindkey: " + bVar.hOE);
        x.d("MicroMsg.StatisticsOplog", "report logbuffer: " + dVar.Sz());
        d.pPH.h(12645, new Object[]{dVar});
    }

    public static b iu(int i) {
        return new b(i, 1);
    }

    public static b iv(int i) {
        return new b(i, 4);
    }

    public final boolean St() {
        int i = c.hOQ;
        if (i == 0) {
            return false;
        }
        if (i == 1) {
            if (this.opType >= HardCoderJNI.SCENE_DB && this.opType <= 700) {
                return true;
            }
            if (this.opType >= 701 && this.opType <= 1000) {
                return true;
            }
        }
        if (i == 2 && this.opType >= 701 && this.opType <= 1000) {
            return true;
        }
        if (i == 3 && this.opType >= HardCoderJNI.SCENE_DB && this.opType <= 700) {
            return true;
        }
        if (i == 4) {
            if (this.opType >= 701 && this.opType <= 1000) {
                return true;
            }
            if (this.opType >= HardCoderJNI.SCENE_DB && this.opType <= 700) {
                return true;
            }
        }
        return false;
    }

    public b(int i, int i2) {
        this.opType = i;
        this.hOJ = i2;
        if (St()) {
            this.hOG = System.currentTimeMillis();
            if (an.isWifi(ac.getContext())) {
                this.hOI = 4;
            } else if (an.is4G(ac.getContext())) {
                this.hOI = 3;
            } else if (an.is3G(ac.getContext())) {
                this.hOI = 2;
            } else if (an.is2G(ac.getContext())) {
                this.hOI = 1;
            } else {
                this.hOI = 0;
            }
            this.hOH = hOO.incrementAndGet();
        }
    }

    public final boolean iw(int i) {
        this.hOE = Integer.valueOf(i);
        return true;
    }

    public final void update() {
        if (St()) {
            this.hOG = System.currentTimeMillis();
            this.hOH = hOO.incrementAndGet();
        }
    }

    public final b mB(String str) {
        if (St()) {
            if (this.hOK.length() != 0) {
                this.hOK.append("||" + str);
            } else if (bh.ov(str)) {
                this.hOK.append(" ");
            } else {
                this.hOK.append(str);
            }
        }
        return this;
    }

    public final b ix(int i) {
        return mB(String.valueOf(i));
    }

    public final b mC(String str) {
        if (St()) {
            if (this.hOL.length() == 0) {
                this.hOL.append(str);
            } else {
                this.hOL.append("||" + str);
            }
        }
        return this;
    }

    public final b Su() {
        this.hOL = new StringBuffer();
        return this;
    }

    public final b Sv() {
        this.hOK = new StringBuffer();
        return this;
    }

    public final b mD(String str) {
        if (St()) {
            if (this.hOM.length() == 0) {
                this.hOM.append(str);
            } else {
                this.hOM.append("||" + str);
            }
        }
        return this;
    }

    public final b bU(boolean z) {
        return mB(z ? "1" : "0");
    }

    public final b iy(int i) {
        if (St()) {
            if (this.hOL.length() == 0) {
                this.hOL.append(i);
            } else {
                this.hOL.append("||" + i);
            }
        }
        return this;
    }

    public static void Sw() {
        x.i("MicroMsg.StatisticsOplog", "wait op");
    }

    public final boolean Sx() {
        if (!St()) {
            return false;
        }
        e.post(new 1(this), "StatisticsOplog");
        return true;
    }

    public final byte[] KB() {
        blq com_tencent_mm_protocal_c_blq = new blq();
        com_tencent_mm_protocal_c_blq.opType = this.opType;
        com_tencent_mm_protocal_c_blq.hOJ = this.hOJ;
        com_tencent_mm_protocal_c_blq.hOF = this.hOF;
        com_tencent_mm_protocal_c_blq.hOG = this.hOG;
        com_tencent_mm_protocal_c_blq.hOH = this.hOH;
        com_tencent_mm_protocal_c_blq.hOI = this.hOI;
        com_tencent_mm_protocal_c_blq.wPg = this.hOK.toString();
        com_tencent_mm_protocal_c_blq.wPh = this.hON.toString();
        com_tencent_mm_protocal_c_blq.wPi = this.hOL.toString();
        com_tencent_mm_protocal_c_blq.wPj = this.hOM.toString();
        try {
            return com_tencent_mm_protocal_c_blq.toByteArray();
        } catch (Exception e) {
            x.e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            return null;
        }
    }

    public final void b(Intent intent, String str) {
        byte[] KB = KB();
        if (KB != null) {
            intent.putExtra(str, KB);
        }
    }

    public static b m(Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("intent_key_StatisticsOplog");
        return byteArray == null ? null : J(byteArray);
    }

    public static b q(Intent intent) {
        return c(intent, "intent_key_StatisticsOplog");
    }

    public static b c(Intent intent, String str) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return J(byteArrayExtra);
    }

    private static b J(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        blq com_tencent_mm_protocal_c_blq = new blq();
        try {
            com_tencent_mm_protocal_c_blq.aF(bArr);
            b bVar = new b(com_tencent_mm_protocal_c_blq.opType, com_tencent_mm_protocal_c_blq.hOJ);
            bVar.hOF = com_tencent_mm_protocal_c_blq.hOF;
            bVar.hOG = com_tencent_mm_protocal_c_blq.hOG;
            bVar.hOH = com_tencent_mm_protocal_c_blq.hOH;
            bVar.hOI = com_tencent_mm_protocal_c_blq.hOI;
            bVar.hOK = new StringBuffer(com_tencent_mm_protocal_c_blq.wPg);
            bVar.hON = new StringBuffer(com_tencent_mm_protocal_c_blq.wPh);
            bVar.hOL = new StringBuffer(com_tencent_mm_protocal_c_blq.wPi);
            bVar.hOM = new StringBuffer(com_tencent_mm_protocal_c_blq.wPj);
            return bVar;
        } catch (Exception e) {
            x.e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            return null;
        }
    }
}

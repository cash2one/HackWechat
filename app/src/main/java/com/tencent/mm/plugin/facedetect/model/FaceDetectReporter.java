package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class FaceDetectReporter implements Parcelable {
    public static final Creator<FaceDetectReporter> CREATOR = new Creator<FaceDetectReporter>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FaceDetectReporter(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceDetectReporter[i];
        }
    };
    public static FaceDetectReporter mgR = new FaceDetectReporter();
    String appId = "";
    public boolean mgP = false;
    private FaceDetectReportInfo mgQ = null;
    long mgS = 0;
    long mgT = -1;
    public long mgU = -1;
    public int mgV = 0;
    public boolean mgW = false;
    public long mgu = 0;

    protected FaceDetectReporter(Parcel parcel) {
        boolean z = true;
        this.mgu = parcel.readLong();
        this.mgP = parcel.readByte() != (byte) 0;
        this.mgQ = (FaceDetectReportInfo) parcel.readParcelable(FaceDetectReportInfo.class.getClassLoader());
        this.appId = parcel.readString();
        this.mgS = parcel.readLong();
        this.mgT = parcel.readLong();
        this.mgU = parcel.readLong();
        this.mgV = parcel.readInt();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.mgW = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeLong(this.mgu);
        parcel.writeByte((byte) (this.mgP ? 1 : 0));
        parcel.writeParcelable(this.mgQ, i);
        parcel.writeString(this.appId);
        parcel.writeLong(this.mgS);
        parcel.writeLong(this.mgT);
        parcel.writeLong(this.mgU);
        parcel.writeInt(this.mgV);
        if (!this.mgW) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }

    public int describeContents() {
        return 0;
    }

    public static FaceDetectReporter aGK() {
        if (mgR != null) {
            return mgR;
        }
        FaceDetectReporter faceDetectReporter;
        synchronized (FaceDetectReporter.class) {
            if (mgR == null) {
                mgR = new FaceDetectReporter();
            }
            faceDetectReporter = mgR;
        }
        return faceDetectReporter;
    }

    public static void e(long j, int i, int i2) {
        x.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
        g.pQN.h(14121, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    private FaceDetectReporter() {
    }

    public final long aGL() {
        x.v("MicroMsg.FaceDetectReporter", "create report session");
        if (this.mgQ == null) {
            this.mgQ = new FaceDetectReportInfo();
        }
        this.mgQ.reset();
        this.mgP = false;
        this.mgu = System.currentTimeMillis();
        this.mgQ.mgu = this.mgu;
        return this.mgu;
    }

    public final void a(FaceDetectReporter faceDetectReporter) {
        x.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", bh.cgy().toString());
        this.mgQ = faceDetectReporter.mgQ;
        this.mgP = faceDetectReporter.mgP;
        this.mgu = faceDetectReporter.mgu;
        String str = "MicroMsg.FaceDetectReporter";
        String str2 = "alvinluo sessionId: %d, info: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(this.mgu);
        objArr[1] = this.mgQ != null ? this.mgQ.toString() : "null";
        x.v(str, str2, objArr);
    }

    public final void C(int i, boolean z) {
        int i2 = 1;
        x.v("MicroMsg.FaceDetectReporter", "reportStartFaceDetect businessType: %d, isRetry: %b", Integer.valueOf(i), Boolean.valueOf(z));
        g gVar = g.pQN;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(this.mgu);
        if (!z) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        gVar.h(14005, objArr);
    }

    public static int pu(int i) {
        switch (i) {
            case 0:
            case 3:
                return 2;
            case 1:
            case 4:
                return 3;
            case 2:
                return 1;
            case 5:
                return 4;
            default:
                return -1;
        }
    }

    public final void a(int i, boolean z, int i2, int i3, int i4) {
        a(i, z, i2, i3, i4, 0);
    }

    public final void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        x.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", Long.valueOf(this.mgu), Boolean.valueOf(this.mgP), Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.mgQ != null && !this.mgP) {
            int longValue;
            int longValue2;
            x.v("MicroMsg.FaceDetectReporter", "info: %s", this.mgQ.toString());
            this.mgP = true;
            this.mgQ.meT = i5;
            if (this.mgQ.mgK != 0) {
                this.mgQ.mgM = this.mgQ.mgL / this.mgQ.mgK;
            }
            if (this.mgQ.mgN.containsKey(Integer.valueOf(0)) && this.mgQ.mgO.containsKey(Integer.valueOf(0))) {
                longValue = (int) (((Long) this.mgQ.mgO.get(Integer.valueOf(0))).longValue() - ((Long) this.mgQ.mgN.get(Integer.valueOf(0))).longValue());
            } else {
                longValue = 0;
            }
            if (this.mgQ.mgN.containsKey(Integer.valueOf(4)) && this.mgQ.mgO.containsKey(Integer.valueOf(4))) {
                longValue2 = (int) (((Long) this.mgQ.mgO.get(Integer.valueOf(4))).longValue() - ((Long) this.mgQ.mgN.get(Integer.valueOf(4))).longValue());
            } else {
                longValue2 = 0;
            }
            x.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms", Integer.valueOf(longValue), Integer.valueOf(longValue2));
            g gVar = g.pQN;
            Object[] objArr = new Object[26];
            objArr[0] = Long.valueOf(this.mgu);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(z ? 1 : 0);
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(i3);
            objArr[5] = Integer.valueOf(i4);
            objArr[6] = Integer.valueOf(this.mgQ.mgw);
            objArr[7] = Integer.valueOf(this.mgQ.mgx);
            objArr[8] = Integer.valueOf(this.mgQ.mgy);
            objArr[9] = Integer.valueOf(this.mgQ.mgv);
            objArr[10] = Integer.valueOf(this.mgQ.mgz);
            objArr[11] = Integer.valueOf(this.mgQ.mgA);
            objArr[12] = Integer.valueOf(this.mgQ.mgB);
            objArr[13] = Integer.valueOf(this.mgQ.mgC);
            objArr[14] = Integer.valueOf(this.mgQ.mgD);
            objArr[15] = Integer.valueOf(this.mgQ.mgE);
            objArr[16] = Integer.valueOf(this.mgQ.mgF);
            objArr[17] = Integer.valueOf(this.mgQ.mgG);
            objArr[18] = Integer.valueOf(this.mgQ.mgH);
            objArr[19] = Integer.valueOf(this.mgQ.meT);
            objArr[20] = Integer.valueOf(this.mgQ.mgI);
            objArr[21] = Integer.valueOf(this.mgQ.mgJ);
            objArr[22] = Integer.valueOf(this.mgQ.mgM);
            objArr[23] = Integer.valueOf(longValue);
            objArr[24] = Integer.valueOf(longValue2);
            objArr[25] = this.appId;
            gVar.h(14006, objArr);
        }
    }

    public final void bi(String str, int i) {
        long j = -1;
        int i2 = 1;
        if (this.mgT == -1 || this.mgU == -1 || this.mgU < this.mgT) {
            x.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", Long.valueOf(this.mgT), Long.valueOf(this.mgU));
        } else {
            j = this.mgU - this.mgT;
        }
        x.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", Long.valueOf(this.mgS), str, Integer.valueOf(-1), Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(this.mgW), this.appId, Integer.valueOf(this.mgV));
        g gVar = g.pQN;
        Object[] objArr = new Object[8];
        objArr[0] = Long.valueOf(this.mgS);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(-1);
        objArr[3] = Integer.valueOf(i);
        objArr[4] = this.appId;
        if (!this.mgW) {
            i2 = 0;
        }
        objArr[5] = Integer.valueOf(i2);
        objArr[6] = Long.valueOf(j);
        objArr[7] = Integer.valueOf(this.mgV);
        gVar.h(14560, objArr);
    }

    public final void q(int i, long j) {
        if (this.mgQ != null) {
            FaceDetectReportInfo faceDetectReportInfo = this.mgQ;
            faceDetectReportInfo.mgK++;
            faceDetectReportInfo = this.mgQ;
            faceDetectReportInfo.mgL = (int) (((long) faceDetectReportInfo.mgL) + j);
            this.mgQ.pt(i);
        }
    }

    public final void r(int i, long j) {
        if (this.mgQ != null) {
            this.mgQ.mgN.put(Integer.valueOf(i), Long.valueOf(j));
        }
    }

    public final void s(int i, long j) {
        if (this.mgQ != null) {
            this.mgQ.mgO.put(Integer.valueOf(i), Long.valueOf(j));
        }
    }
}

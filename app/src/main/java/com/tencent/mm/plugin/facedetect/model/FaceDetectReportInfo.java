package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import org.xwalk.core.XWalkUpdater;

class FaceDetectReportInfo implements Parcelable {
    public static final Creator<FaceDetectReportInfo> CREATOR = new Creator<FaceDetectReportInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FaceDetectReportInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceDetectReportInfo[i];
        }
    };
    protected int meT = 0;
    protected int mgA = 0;
    protected int mgB = 0;
    protected int mgC = 0;
    protected int mgD = 0;
    protected int mgE = 0;
    protected int mgF = 0;
    protected int mgG = 0;
    protected int mgH = 0;
    protected int mgI = 0;
    protected int mgJ = 0;
    protected int mgK = 0;
    protected int mgL = 0;
    protected int mgM = 0;
    protected HashMap<Integer, Long> mgN = new HashMap();
    protected HashMap<Integer, Long> mgO = new HashMap();
    protected long mgu = 0;
    protected int mgv = 0;
    protected int mgw = 0;
    protected int mgx = 0;
    protected int mgy = 0;
    protected int mgz = 0;

    protected FaceDetectReportInfo(Parcel parcel) {
        this.mgu = parcel.readLong();
        this.mgv = parcel.readInt();
        this.mgw = parcel.readInt();
        this.mgx = parcel.readInt();
        this.mgy = parcel.readInt();
        this.mgz = parcel.readInt();
        this.mgA = parcel.readInt();
        this.mgB = parcel.readInt();
        this.mgC = parcel.readInt();
        this.mgD = parcel.readInt();
        this.mgE = parcel.readInt();
        this.mgF = parcel.readInt();
        this.mgG = parcel.readInt();
        this.mgH = parcel.readInt();
        this.mgI = parcel.readInt();
        this.mgJ = parcel.readInt();
        this.mgK = parcel.readInt();
        this.meT = parcel.readInt();
        this.mgL = parcel.readInt();
        this.mgM = parcel.readInt();
        try {
            this.mgN = parcel.readHashMap(HashMap.class.getClassLoader());
            this.mgO = parcel.readHashMap(HashMap.class.getClassLoader());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceDetectReportInfo", e, "", new Object[0]);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mgu);
        parcel.writeInt(this.mgv);
        parcel.writeInt(this.mgw);
        parcel.writeInt(this.mgx);
        parcel.writeInt(this.mgy);
        parcel.writeInt(this.mgz);
        parcel.writeInt(this.mgA);
        parcel.writeInt(this.mgB);
        parcel.writeInt(this.mgC);
        parcel.writeInt(this.mgD);
        parcel.writeInt(this.mgE);
        parcel.writeInt(this.mgF);
        parcel.writeInt(this.mgG);
        parcel.writeInt(this.mgH);
        parcel.writeInt(this.mgI);
        parcel.writeInt(this.mgJ);
        parcel.writeInt(this.mgK);
        parcel.writeInt(this.meT);
        parcel.writeInt(this.mgL);
        parcel.writeInt(this.mgM);
        parcel.writeMap(this.mgN);
        parcel.writeMap(this.mgO);
    }

    public int describeContents() {
        return 0;
    }

    public final void pt(int i) {
        if (i > 0) {
            if (i == 1) {
                this.mgw++;
            } else if (i == 2) {
                this.mgx++;
            } else {
                this.mgw++;
            }
        } else if (i == 0) {
            this.mgy++;
        } else if (i == -11) {
            this.mgA++;
        } else if (i == -12) {
            this.mgB++;
        } else if (i == -13) {
            this.mgC++;
        } else if (i == XWalkUpdater.ERROR_SET_VERNUM) {
            this.mgG++;
        } else if (i == -102) {
            this.mgD++;
        } else if (i == -103) {
            this.mgE++;
        } else if (i == -105) {
            this.mgF++;
        } else if (i == -106) {
            this.mgz++;
        } else if (i == -107) {
            this.mgH++;
        } else if (i == -108) {
            this.mgI++;
        } else if (i == -109) {
            this.mgJ++;
        } else {
            this.mgv++;
        }
    }

    public final void reset() {
        this.mgu = 0;
        this.mgw = 0;
        this.mgx = 0;
        this.mgy = 0;
        this.mgv = 0;
        this.mgz = 0;
        this.mgA = 0;
        this.mgB = 0;
        this.mgC = 0;
        this.mgD = 0;
        this.mgE = 0;
        this.mgF = 0;
        this.mgG = 0;
        this.mgH = 0;
        this.mgK = 0;
        this.meT = 0;
        this.mgL = 0;
        this.mgM = 0;
        this.mgN.clear();
        this.mgO.clear();
    }

    public String toString() {
        return "detectOk: " + this.mgw + ", motionOk: " + this.mgx + ", noFace: " + this.mgy + ", systemErr: " + this.mgv + ", noLiveFace: " + this.mgz + ", tooDark: " + this.mgA + ", tooLight: " + this.mgB + ", backLight: " + this.mgC + ", tooSmall: " + this.mgD + ", tooBig: " + this.mgE + ", tooActive: " + this.mgF + ", poseNotValid: " + this.mgG + ", timeOut: " + this.mgH + ", totalFrame: " + this.mgK + ", verifyTime: " + this.meT + ", processTimePerFrame: " + this.mgM;
    }
}

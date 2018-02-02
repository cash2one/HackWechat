package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MallNews implements Parcelable {
    public static final Creator<MallNews> CREATOR = new 1();
    public String frP;
    public String rVK;
    public int sOA;
    public String sQA = "0";
    public String sQB;
    public String sQC;
    public String sQD;
    public String sQE;
    public int sQF;
    public String sQG;
    public int sQH;
    public String sQI;
    public String sQJ;
    public String sQz = "0";
    public int showType;
    public String type;

    public MallNews(String str) {
        this.sQB = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MallNews)) {
            return false;
        }
        MallNews mallNews = (MallNews) obj;
        if (this.sQB == null || !this.sQB.equals(mallNews.sQB) || this.rVK == null || !this.rVK.equals(mallNews.rVK)) {
            return false;
        }
        return true;
    }

    public MallNews(Parcel parcel) {
        this.sQB = parcel.readString();
        this.rVK = parcel.readString();
        this.frP = parcel.readString();
        this.sQC = parcel.readString();
        this.sQD = parcel.readString();
        this.sQE = parcel.readString();
        this.sQF = parcel.readInt();
        this.sQG = parcel.readString();
        this.sQz = parcel.readString();
        this.sQA = parcel.readString();
        this.showType = parcel.readInt();
        this.sQI = parcel.readString();
        this.sOA = parcel.readInt();
        this.sQJ = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sQB);
        parcel.writeString(this.rVK);
        parcel.writeString(this.frP);
        parcel.writeString(this.sQC);
        parcel.writeString(this.sQD);
        parcel.writeString(this.sQE);
        parcel.writeInt(this.sQF);
        parcel.writeString(this.sQG);
        parcel.writeString(this.sQz);
        parcel.writeString(this.sQA);
        parcel.writeInt(this.showType);
        parcel.writeString(this.sQI);
        parcel.writeInt(this.sOA);
        parcel.writeString(this.sQJ);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", new Object[]{this.sQB, this.rVK, this.frP, this.sQC, this.sQD, this.sQE, this.sQz, this.sQI, this.sQG, Integer.valueOf(this.sOA), this.sQJ});
    }
}

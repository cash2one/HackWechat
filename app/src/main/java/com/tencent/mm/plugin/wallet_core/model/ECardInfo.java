package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class ECardInfo implements Parcelable {
    public static final Creator<ECardInfo> CREATOR = new Creator<ECardInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ECardInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ECardInfo[i];
        }
    };
    public String fKT;
    public String fqF;
    public int sMe;
    public int sMf;
    public int sMg;
    public String sMh;
    public String sMi;
    public String sMj;
    public int sMk;
    public ArrayList<String> sMl = new ArrayList();
    public String sMm;
    public String sMn;
    public String sMo;
    public String sMp;
    public String title;

    public ECardInfo(Parcel parcel) {
        this.sMe = parcel.readInt();
        this.fqF = parcel.readString();
        this.sMf = parcel.readInt();
        this.sMg = parcel.readInt();
        this.sMh = parcel.readString();
        this.sMi = parcel.readString();
        this.sMj = parcel.readString();
        this.sMk = parcel.readInt();
        this.title = parcel.readString();
        parcel.readStringList(this.sMl);
        this.sMm = parcel.readString();
        this.sMn = parcel.readString();
        this.sMo = parcel.readString();
        this.sMp = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.sMe);
        parcel.writeString(this.fqF);
        parcel.writeInt(this.sMf);
        parcel.writeInt(this.sMg);
        parcel.writeString(this.sMh);
        parcel.writeString(this.sMi);
        parcel.writeString(this.sMj);
        parcel.writeInt(this.sMk);
        parcel.writeString(this.title);
        parcel.writeStringList(this.sMl);
        parcel.writeString(this.sMm);
        parcel.writeString(this.sMn);
        parcel.writeString(this.sMo);
        parcel.writeString(this.sMp);
    }
}

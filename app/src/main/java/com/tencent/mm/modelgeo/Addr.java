package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bh;

public class Addr implements Parcelable {
    public static final Creator<Addr> CREATOR = new 1();
    public String country;
    public String hxA;
    public String hxB;
    public String hxC;
    public String hxD;
    public String hxE;
    public float hxF;
    public float hxG;
    public String hxu;
    public String hxv;
    public String hxw;
    public String hxx;
    public String hxy;
    public String hxz;
    public Object tag = "";

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("address='" + this.hxu + '\'');
        stringBuilder.append(", country='" + this.country + '\'');
        stringBuilder.append(", administrative_area_level_1='" + this.hxv + '\'');
        stringBuilder.append(", locality='" + this.hxw + '\'');
        stringBuilder.append(", locality_shi='" + this.hxx + '\'');
        stringBuilder.append(", sublocality='" + this.hxy + '\'');
        stringBuilder.append(", neighborhood='" + this.hxz + '\'');
        stringBuilder.append(", route='" + this.hxA + '\'');
        stringBuilder.append(", streetNum='" + this.hxB + '\'');
        stringBuilder.append(", roughAddr='" + this.hxC + '\'');
        stringBuilder.append(", poi_name='" + this.hxD + '\'');
        stringBuilder.append(", lat=" + this.hxF);
        stringBuilder.append(", lng=" + this.hxG);
        stringBuilder.append(", tag=" + this.tag);
        return stringBuilder.toString();
    }

    public final String OM() {
        return bh.az(this.hxx, "") + bh.az(this.hxy, "") + bh.az(this.hxz, "") + bh.az(this.hxA, "") + bh.az(this.hxB, "");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bh.az(this.hxu, ""));
        parcel.writeString(bh.az(this.country, ""));
        parcel.writeString(bh.az(this.hxv, ""));
        parcel.writeString(bh.az(this.hxw, ""));
        parcel.writeString(bh.az(this.hxx, ""));
        parcel.writeString(bh.az(this.hxy, ""));
        parcel.writeString(bh.az(this.hxz, ""));
        parcel.writeString(bh.az(this.hxA, ""));
        parcel.writeString(bh.az(this.hxB, ""));
        parcel.writeString(bh.az(this.hxC, ""));
        parcel.writeString(bh.az(this.hxD, ""));
        parcel.writeFloat(this.hxF);
        parcel.writeFloat(this.hxG);
    }
}

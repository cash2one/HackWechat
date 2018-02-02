package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelgeo.Addr;

public class LocationIntent implements Parcelable {
    public static final Creator<LocationIntent> CREATOR = new 1();
    public int fzv = 0;
    public Addr hxN = null;
    public String label = "";
    public double lat;
    public double lng;
    public String nQB;
    public String nTe = "";
    public String vcT = "";
    public int vcU = 0;

    public final String bDI() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("lat " + this.lat + ";");
        stringBuffer.append("lng " + this.lng + ";");
        stringBuffer.append("scale " + this.fzv + ";");
        stringBuffer.append("label " + this.label + ";");
        stringBuffer.append("poiname " + this.nTe + ";");
        stringBuffer.append("infourl " + this.vcT + ";");
        stringBuffer.append("locTypeId " + this.nQB + ";");
        stringBuffer.append("poiType " + this.vcU + ";");
        if (this.hxN != null) {
            stringBuffer.append("addr " + this.hxN.toString() + ";");
        }
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
        parcel.writeInt(this.fzv);
        parcel.writeString(this.label);
        parcel.writeString(this.nTe);
        parcel.writeString(this.vcT);
        parcel.writeString(this.nQB);
        parcel.writeInt(this.vcU);
        parcel.writeParcelable(this.hxN, i);
    }
}

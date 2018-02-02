package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBrandInitConfig implements Parcelable {
    public static final Creator<AppBrandInitConfig> CREATOR = new Creator<AppBrandInitConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandInitConfig(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandInitConfig[i];
        }
    };
    public String appId;
    public String extInfo;
    public int fnv;
    public String frn;
    public String hjA;
    public String hjz;
    public int iGA;
    public boolean iNR;
    public boolean iNS;
    public String iNT;
    public String iNU;
    public boolean iNV;
    public String iNW;
    public boolean iNX;
    public boolean iNY;
    public final AppBrandLaunchReferrer iNZ;
    public String iconUrl;
    public String irG;
    public long startTime;
    public String username;

    AppBrandInitConfig() {
        this.iNZ = new AppBrandLaunchReferrer();
    }

    public final void abT() {
        this.irG = "SessionId@" + hashCode() + "#" + bh.Wp();
    }

    public final boolean Yz() {
        return 4 == this.fnv;
    }

    private AppBrandInitConfig(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.iNZ = new AppBrandLaunchReferrer();
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.frn = parcel.readString();
        this.iconUrl = parcel.readString();
        this.iGA = parcel.readInt();
        this.fnv = parcel.readInt();
        this.iNR = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iNS = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iNV = z;
        this.iNT = parcel.readString();
        this.iNU = parcel.readString();
        this.extInfo = parcel.readString();
        this.iNW = parcel.readString();
        this.hjz = parcel.readString();
        this.hjA = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iNX = z;
        this.startTime = parcel.readLong();
        this.iNZ.g(parcel);
        this.irG = parcel.readString();
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.iNY = z2;
    }

    public final String toString() {
        return "AppBrandInitConfig{visitingSessionId='" + this.irG + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.frn + '\'' + ", debugType=" + this.iGA + ", isPluginApp=" + this.iNR + ", preferRunInTools=" + this.iNS + ", orientation='" + this.iNT + '\'' + ", enterPath='" + this.iNW + '\'' + ", shareName='" + this.hjz + '\'' + ", shareKey='" + this.hjA + '\'' + ", isStick=" + this.iNX + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.iNY + ", referrer=" + this.iNZ + ", extInfo=" + this.extInfo + '}';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b;
        int i2 = 1;
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeString(this.frn);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.iGA);
        parcel.writeInt(this.fnv);
        parcel.writeByte(this.iNR ? (byte) 1 : (byte) 0);
        if (this.iNS) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.iNV) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeString(this.iNT);
        parcel.writeString(this.iNU);
        parcel.writeString(this.extInfo);
        parcel.writeString(this.iNW);
        parcel.writeString(this.hjz);
        parcel.writeString(this.hjA);
        if (this.iNX) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeLong(this.startTime);
        this.iNZ.writeToParcel(parcel, i);
        parcel.writeString(this.irG);
        if (!this.iNY) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }

    public final int describeContents() {
        return 0;
    }

    public final JSONObject abU() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("shareKey", this.hjA);
            jSONObject.put("shareName", this.hjz);
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}

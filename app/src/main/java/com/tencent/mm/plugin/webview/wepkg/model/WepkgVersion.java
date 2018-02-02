package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.a.c;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgVersion implements Parcelable {
    public static final Creator<WepkgVersion> CREATOR = new 1();
    public String appId;
    public String charset;
    public String downloadUrl;
    public String fMh;
    public String fqR;
    public long hVE;
    public String iEa;
    public int tMZ;
    public boolean tNC;
    public long tND;
    public long tNE;
    public int tNF;
    public int tNG;
    public long tNH;
    public boolean tNI;
    public boolean tNJ;
    public boolean tNK;
    public int tNL;
    public String tNm;
    public String version;

    public WepkgVersion(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.tNm = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readString();
        this.iEa = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.tNC = z;
        this.tND = parcel.readLong();
        this.tNE = parcel.readLong();
        this.tNF = parcel.readInt();
        this.fMh = parcel.readString();
        this.fqR = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.tNG = parcel.readInt();
        this.tMZ = parcel.readInt();
        this.tNH = parcel.readLong();
        this.hVE = parcel.readLong();
        this.charset = parcel.readString();
        this.tNI = parcel.readByte() != (byte) 0;
        this.tNJ = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.tNK = z2;
        this.tNL = parcel.readInt();
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.tNm = cVar.field_pkgId;
            this.appId = cVar.field_appId;
            this.version = cVar.field_version;
            this.iEa = cVar.field_pkgPath;
            this.tNC = cVar.field_disableWvCache;
            this.tND = cVar.field_clearPkgTime;
            this.tNE = cVar.field_checkIntervalTime;
            this.tNF = cVar.field_packMethod;
            this.fMh = cVar.field_domain;
            this.fqR = cVar.field_md5;
            this.downloadUrl = cVar.field_downloadUrl;
            this.tNG = cVar.field_pkgSize;
            this.tMZ = cVar.field_downloadNetType;
            this.tNH = cVar.field_nextCheckTime;
            this.hVE = cVar.field_createTime;
            this.charset = cVar.field_charset;
            this.tNI = cVar.field_bigPackageReady;
            this.tNJ = cVar.field_preloadFilesReady;
            this.tNK = cVar.field_preloadFilesAtomic;
            this.tNL = cVar.field_totalDownloadCount;
        }
    }

    public final JSONObject bVk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.appId);
            jSONObject.put("version", this.version);
            jSONObject.put("pkgPath", this.iEa);
            jSONObject.put("disableWvCache", this.tNC);
            jSONObject.put("clearPkgTime", this.tND);
            jSONObject.put("checkIntervalTime", this.tNE);
            jSONObject.put("packMethod", this.tNF);
            jSONObject.put("domain", this.fMh);
            jSONObject.put("md5", this.fqR);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("pkgSize", this.tNG);
            jSONObject.put("downloadNetType", this.tMZ);
            jSONObject.put("nextCheckTime", this.tNH);
            jSONObject.put("charset", this.charset);
            jSONObject.put("bigPackageReady", this.tNI);
            jSONObject.put("preloadFilesReady", this.tNJ);
            jSONObject.put("preloadFilesAtomic", this.tNK);
            jSONObject.put("totalDownloadCount", this.tNL);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.tNm);
        parcel.writeString(this.appId);
        parcel.writeString(this.version);
        parcel.writeString(this.iEa);
        parcel.writeByte((byte) (this.tNC ? 1 : 0));
        parcel.writeLong(this.tND);
        parcel.writeLong(this.tNE);
        parcel.writeInt(this.tNF);
        parcel.writeString(this.fMh);
        parcel.writeString(this.fqR);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.tNG);
        parcel.writeInt(this.tMZ);
        parcel.writeLong(this.tNH);
        parcel.writeLong(this.hVE);
        parcel.writeString(this.charset);
        parcel.writeByte((byte) (this.tNI ? 1 : 0));
        if (this.tNJ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.tNK) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.tNL);
    }
}

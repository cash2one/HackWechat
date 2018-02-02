package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.a.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgPreloadFile implements Parcelable {
    public static final Creator<WepkgPreloadFile> CREATOR = new 1();
    public String aAM;
    public String downloadUrl;
    public String filePath;
    public String fqR;
    public long hVE;
    public String mimeType;
    public int size;
    public String tMX;
    public int tMZ;
    public String tNm;
    public boolean tNn;
    public String version;

    public WepkgPreloadFile(Parcel parcel) {
        this.aAM = parcel.readString();
        this.tNm = parcel.readString();
        this.version = parcel.readString();
        this.filePath = parcel.readString();
        this.tMX = parcel.readString();
        this.mimeType = parcel.readString();
        this.fqR = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.size = parcel.readInt();
        this.tMZ = parcel.readInt();
        this.tNn = parcel.readByte() != (byte) 0;
        this.hVE = parcel.readLong();
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.aAM = aVar.field_key;
            this.tNm = aVar.field_pkgId;
            this.version = aVar.field_version;
            this.filePath = aVar.field_filePath;
            this.tMX = aVar.field_rid;
            this.mimeType = aVar.field_mimeType;
            this.fqR = aVar.field_md5;
            this.downloadUrl = aVar.field_downloadUrl;
            this.size = aVar.field_size;
            this.tMZ = aVar.field_downloadNetType;
            this.tNn = aVar.field_completeDownload;
            this.hVE = aVar.field_createTime;
        }
    }

    public final JSONObject bVk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.aAM);
            jSONObject.put("pkgId", this.tNm);
            jSONObject.put("version", this.version);
            jSONObject.put(DownloadInfoColumns.FILEPATH, this.filePath);
            jSONObject.put("rid", this.tMX);
            jSONObject.put("mimeType", this.mimeType);
            jSONObject.put("md5", this.fqR);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("size", this.size);
            jSONObject.put("downloadNetType", this.tMZ);
            jSONObject.put("completeDownload", this.tNn);
            jSONObject.put("createTime", this.hVE);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aAM);
        parcel.writeString(this.tNm);
        parcel.writeString(this.version);
        parcel.writeString(this.filePath);
        parcel.writeString(this.tMX);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.fqR);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.size);
        parcel.writeInt(this.tMZ);
        parcel.writeByte((byte) (this.tNn ? 1 : 0));
        parcel.writeLong(this.hVE);
    }
}

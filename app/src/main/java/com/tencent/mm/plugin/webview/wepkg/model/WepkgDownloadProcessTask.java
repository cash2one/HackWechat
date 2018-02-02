package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.bh;

public class WepkgDownloadProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgDownloadProcessTask> CREATOR = new 2();
    public String downloadUrl;
    public String fME;
    public int fileType;
    public String fqR;
    public String iEa;
    public Runnable jcI;
    public String tMX;
    public long tMY;
    public int tMZ;
    public RetCode tNa;
    public String version;

    private WepkgDownloadProcessTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        afi();
        WePkgDownloader.bVg().a(this.fileType, bh.ou(this.fME), bh.ou(this.tMX), bh.ou(this.downloadUrl), this.tMY, bh.ou(this.version), bh.ou(this.fqR), this.tMZ, new 1(this));
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    public final void j(Parcel parcel) {
        this.fileType = parcel.readInt();
        this.fME = parcel.readString();
        this.tMX = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.tMY = parcel.readLong();
        this.version = parcel.readString();
        this.fqR = parcel.readString();
        this.tMZ = parcel.readInt();
        this.iEa = parcel.readString();
        this.tNa = (RetCode) parcel.readParcelable(RetCode.class.getClassLoader());
    }

    public final void v(Parcel parcel, int i) {
        parcel.writeInt(this.fileType);
        parcel.writeString(this.fME);
        parcel.writeString(this.tMX);
        parcel.writeString(this.downloadUrl);
        parcel.writeLong(this.tMY);
        parcel.writeString(this.version);
        parcel.writeString(this.fqR);
        parcel.writeInt(this.tMZ);
        parcel.writeString(this.iEa);
        parcel.writeParcelable(this.tNa, i);
    }
}

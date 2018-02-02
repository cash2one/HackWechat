package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.protocal.c.acn;
import com.tencent.mm.protocal.c.cz;
import java.util.ArrayList;

public class AppBrandSysConfig implements Parcelable {
    public static final Creator<AppBrandSysConfig> CREATOR = new 1();
    public String appId;
    public String fnl;
    public String frn;
    public boolean iNV;
    public ArrayList<String> iOA;
    public ArrayList<String> iOB;
    public ArrayList<String> iOC;
    public ArrayList<String> iOD;
    public boolean iOE;
    public int iOF;
    public int iOG;
    public int iOH;
    public final WxaPkgWrappingInfo iOI;
    public AppBrandGlobalSystemConfig iOJ;
    cz iOK;
    public acn iOL;
    public String iOg;
    public String iOh;
    public boolean iOi;
    public boolean iOj;
    public boolean iOk;
    public boolean iOl;
    public AppRuntimeApiPermissionBundle iOm;
    public boolean iOn;
    public int iOo;
    public int iOp;
    public int iOq;
    public int iOr;
    public int iOs;
    public int iOt;
    public int iOu;
    public boolean iOv;
    public long iOw;
    public int iOx;
    public boolean iOy;
    public boolean iOz;
    public int uin;

    public final long abX() {
        return this.iOK == null ? 0 : this.iOK.vId;
    }

    public AppBrandSysConfig() {
        this.iOi = false;
        this.iOj = false;
        this.iOk = false;
        this.iOl = false;
        this.iNV = false;
        this.iOI = new WxaPkgWrappingInfo();
    }

    public String toString() {
        return "AppBrandSysConfig{uin=" + this.uin + ", brandId='" + this.fnl + '\'' + ", brandName='" + this.frn + '\'' + ", appId='" + this.appId + '\'' + ", appIconUrl='" + this.iOg + '\'' + ", debugEnabled=" + this.iOi + ", performancePanelEnabled=" + this.iOj + ", maxWebViewDepth=" + this.iOo + ", maxBackgroundLifeSpan=" + this.iOp + ", maxRequestConcurrent=" + this.iOq + ", maxUploadConcurrent=" + this.iOr + ", maxDownloadConcurrent=" + this.iOs + ", maxWebsocketConnect=" + this.iOt + ", websocketSkipPortCheck=" + this.iOv + ", requestDomains=" + this.iOA + ", socketDomains=" + this.iOB + ", uploadDomains=" + this.iOC + ", downloadDomains=" + this.iOD + ", appPkgInfo=" + this.iOI + ", systemSettings=" + this.iOJ + ", runningFlag=" + n.a(this.iOK) + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        int i2;
        byte b2 = (byte) 1;
        parcel.writeInt(this.uin);
        parcel.writeString(this.fnl);
        parcel.writeString(this.frn);
        parcel.writeString(this.appId);
        parcel.writeString(this.iOg);
        parcel.writeString(this.iOh);
        parcel.writeByte(this.iOi ? (byte) 1 : (byte) 0);
        if (this.iOj) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.iOk) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeParcelable(this.iOm, i);
        if (this.iOn) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.iOo);
        parcel.writeInt(this.iOp);
        parcel.writeInt(this.iOq);
        parcel.writeInt(this.iOr);
        parcel.writeInt(this.iOs);
        parcel.writeInt(this.iOt);
        parcel.writeInt(this.iOu);
        if (this.iOv) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeLong(this.iOw);
        parcel.writeInt(this.iOx);
        if (this.iOy) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.iOz) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeStringList(this.iOA);
        parcel.writeStringList(this.iOB);
        parcel.writeStringList(this.iOC);
        parcel.writeStringList(this.iOD);
        parcel.writeParcelable(this.iOI, i);
        parcel.writeParcelable(this.iOJ, i);
        if (!this.iOE) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
        parcel.writeInt(this.iOF);
        parcel.writeInt(this.iOG);
        parcel.writeInt(this.iOH);
        c.fm(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName()).a(this.iOL, parcel);
        c.a(this.iOK, parcel);
    }

    protected AppBrandSysConfig(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.iOi = false;
        this.iOj = false;
        this.iOk = false;
        this.iOl = false;
        this.iNV = false;
        this.uin = parcel.readInt();
        this.fnl = parcel.readString();
        this.frn = parcel.readString();
        this.appId = parcel.readString();
        this.iOg = parcel.readString();
        this.iOh = parcel.readString();
        this.iOi = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iOj = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iOk = z;
        this.iOm = (AppRuntimeApiPermissionBundle) parcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader());
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iOn = z;
        this.iOo = parcel.readInt();
        this.iOp = parcel.readInt();
        this.iOq = parcel.readInt();
        this.iOr = parcel.readInt();
        this.iOs = parcel.readInt();
        this.iOt = parcel.readInt();
        this.iOu = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iOv = z;
        this.iOw = parcel.readLong();
        this.iOx = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iOy = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iOz = z;
        this.iOA = parcel.createStringArrayList();
        this.iOB = parcel.createStringArrayList();
        this.iOC = parcel.createStringArrayList();
        this.iOD = parcel.createStringArrayList();
        this.iOI = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
        this.iOJ = (AppBrandGlobalSystemConfig) parcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader());
        if (parcel.readByte() <= (byte) 0) {
            z2 = false;
        }
        this.iOE = z2;
        this.iOF = parcel.readInt();
        this.iOG = parcel.readInt();
        this.iOH = parcel.readInt();
        this.iOL = (acn) c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), parcel);
        this.iOK = (cz) c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), parcel);
    }
}

package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class WxaPkgWrappingInfo extends ModulePkgInfo implements Parcelable {
    public static final Creator<WxaPkgWrappingInfo> CREATOR = new Creator<WxaPkgWrappingInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WxaPkgWrappingInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaPkgWrappingInfo[i];
        }
    };
    public int iGK;
    public int iGL;
    public long iGM;
    public boolean iGN;
    public final LinkedList<ModulePkgInfo> iGO;
    public final Map<String, String> iGP;

    final void aaq() {
        Iterator it = this.iGO.iterator();
        while (it.hasNext()) {
            ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
            String py = a.py(modulePkgInfo.name);
            this.iGP.put(py, modulePkgInfo.name);
            modulePkgInfo.name = py;
        }
    }

    public static WxaPkgWrappingInfo pO(String str) {
        if (bh.ov(str)) {
            return null;
        }
        z zVar = new z(new File(str));
        if (!zVar.iFn) {
            x.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", str);
            zVar.close();
            return null;
        } else if (zVar.ZX()) {
            zVar.close();
            WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
            wxaPkgWrappingInfo.iEa = str;
            wxaPkgWrappingInfo.iGN = false;
            wxaPkgWrappingInfo.fqR = g.bV(str);
            return wxaPkgWrappingInfo;
        } else {
            x.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg read info failed, path = %s ", str);
            zVar.close();
            return null;
        }
    }

    public WxaPkgWrappingInfo() {
        this.iGO = new LinkedList();
        this.iGP = new HashMap();
        this.name = "__APP__";
    }

    public WxaPkgWrappingInfo(Parcel parcel) {
        this();
        readFromParcel(parcel);
    }

    public final void a(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        wxaPkgWrappingInfo.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        readFromParcel(obtain);
        obtain.recycle();
    }

    public final String toString() {
        return "WxaPkgWrappingInfo{pkgDebugType=" + this.iGK + ", pkgVersion=" + this.iGL + ", pkgCreateTime=" + this.iGM + ", localPkg=" + this.iGN + ", md5='" + this.fqR + '\'' + ", pkgPath='" + this.iEa + '\'' + '}';
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.iGK);
        parcel.writeInt(this.iGL);
        parcel.writeLong(this.iGM);
        parcel.writeByte(this.iGN ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.iGO);
    }

    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.iGK = parcel.readInt();
        this.iGL = parcel.readInt();
        this.iGM = parcel.readLong();
        this.iGN = parcel.readByte() != (byte) 0;
        parcel.readTypedList(this.iGO, ModulePkgInfo.CREATOR);
    }
}

package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import junit.framework.Assert;

public final class WxaWidgetInitializer {

    private static class WxaWidgetContextImpl implements WxaWidgetContext {
        public static final Creator<WxaWidgetContextImpl> CREATOR = new 1();
        String gOP;
        WxaPkgWrappingInfo iSp;
        WxaPkgWrappingInfo iSq;
        byte[] iSr;
        int iSs;
        DebuggerInfo iSt;
        WidgetSysConfig iSu;
        WidgetRuntimeConfig iSv;
        String mAppId;

        public WxaWidgetContextImpl(Parcel parcel) {
            ClassLoader classLoader = getClass().getClassLoader();
            this.gOP = parcel.readString();
            this.mAppId = parcel.readString();
            this.iSq = (WxaPkgWrappingInfo) parcel.readParcelable(classLoader);
            this.iSp = (WxaPkgWrappingInfo) parcel.readParcelable(classLoader);
            this.iSr = parcel.createByteArray();
            this.iSs = parcel.readInt();
            this.iSt = (DebuggerInfo) parcel.readParcelable(classLoader);
            this.iSu = (WidgetSysConfig) parcel.readParcelable(classLoader);
            this.iSv = (WidgetRuntimeConfig) parcel.readParcelable(classLoader);
        }

        public WxaWidgetContextImpl(WxaPkgWrappingInfo wxaPkgWrappingInfo, WxaPkgWrappingInfo wxaPkgWrappingInfo2) {
            Assert.assertNotNull(wxaPkgWrappingInfo);
            Assert.assertNotNull(wxaPkgWrappingInfo2);
            this.iSq = wxaPkgWrappingInfo;
            this.iSp = wxaPkgWrappingInfo2;
        }

        public final WxaPkgWrappingInfo acH() {
            return this.iSp;
        }

        public final WxaPkgWrappingInfo acI() {
            return this.iSq;
        }

        public final String getId() {
            return this.gOP;
        }

        public final String getAppId() {
            return this.mAppId;
        }

        public final int acJ() {
            return this.iSp != null ? this.iSp.iGK : 0;
        }

        public final int acK() {
            return this.iSp != null ? this.iSp.iGL : 0;
        }

        public final byte[] acL() {
            return this.iSr;
        }

        public final int acM() {
            return this.iSs;
        }

        public final DebuggerInfo acN() {
            return this.iSt;
        }

        public final WidgetSysConfig acO() {
            return this.iSu;
        }

        public final WidgetRuntimeConfig acP() {
            return this.iSv;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.gOP);
            parcel.writeString(this.mAppId);
            parcel.writeParcelable(this.iSq, i);
            parcel.writeParcelable(this.iSp, i);
            parcel.writeByteArray(this.iSr);
            parcel.writeInt(this.iSs);
            parcel.writeParcelable(this.iSt, i);
            parcel.writeParcelable(this.iSu, i);
            parcel.writeParcelable(this.iSv, i);
        }
    }

    static WxaWidgetContextImpl a(String str, String str2, WxaPkgWrappingInfo wxaPkgWrappingInfo, d dVar) {
        int i = 1;
        x.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[]{str});
        WxaPkgWrappingInfo ZP = v.ZP();
        if (ZP == null) {
            x.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
            return null;
        }
        WxaWidgetContextImpl wxaWidgetContextImpl = new WxaWidgetContextImpl(ZP, wxaPkgWrappingInfo);
        wxaWidgetContextImpl.gOP = str;
        wxaWidgetContextImpl.mAppId = str2;
        wxaWidgetContextImpl.iSt = dVar.iUR;
        if (wxaWidgetContextImpl.iSt == null) {
            wxaWidgetContextImpl.iSt = new DebuggerInfo();
        }
        wxaWidgetContextImpl.iSu = dVar.iUS;
        wxaWidgetContextImpl.iSv = dVar.iUT;
        try {
            byte[] toByteArray = (dVar.iUV == null || dVar.iUV.vVV == null) ? new byte[0] : dVar.iUV.vVV.toByteArray();
            wxaWidgetContextImpl.iSr = toByteArray;
        } catch (Throwable e) {
            x.e("MicroMsg.WxaWidgetInitializer", bh.i(e));
        }
        if (wxaWidgetContextImpl.iSt.iST) {
            wxaWidgetContextImpl.iSs = 2;
            f.acG().au(str, TXLiveConstants.PLAY_WARNING_VIDEO_DECODE_FAIL);
        } else {
            if (dVar.iUU != null) {
                i = dVar.iUU.vEe;
            }
            wxaWidgetContextImpl.iSs = i;
        }
        return wxaWidgetContextImpl;
    }

    public static String aZ(String str, String str2) {
        return str + "#" + str2;
    }
}

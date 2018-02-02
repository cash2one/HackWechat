package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.i.a.b.b;
import com.tencent.mm.pluginsdk.i.a.b.b.c;
import com.tencent.mm.pluginsdk.i.a.b.i;
import com.tencent.mm.pluginsdk.i.a.d.o.a;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig implements Parcelable {
    public static final Creator<AppBrandGlobalSystemConfig> CREATOR = new Creator<AppBrandGlobalSystemConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandGlobalSystemConfig(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandGlobalSystemConfig[i];
        }
    };
    private static volatile AppBrandGlobalSystemConfig iNm;
    private static final AppBrandGlobalSystemConfig iNn;
    public int iNA;
    public int iNB;
    public int iNC;
    public int iND;
    public int iNE;
    public String[] iNF;
    public double iNG;
    public int iNH;
    public int iNo = Integer.MAX_VALUE;
    public int iNp;
    public int iNq;
    public int iNr;
    public int iNs;
    public String iNt;
    public HttpSetting iNu;
    public int[] iNv;
    public int iNw;
    public int iNx;
    public int iNy;
    public int iNz;

    public static final class HttpSetting implements Parcelable {
        public static final Creator<HttpSetting> CREATOR = new Creator<HttpSetting>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new HttpSetting(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new HttpSetting[i];
            }
        };
        public ArrayList<String> iNK;
        public ArrayList<String> iNL;
        public int iNM;
        public int iNN;
        public int iNO;
        public int iNP;
        public String iNQ;
        public int mode;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mode);
            parcel.writeStringList(this.iNK);
            parcel.writeStringList(this.iNL);
            parcel.writeInt(this.iNM);
            parcel.writeInt(this.iNN);
            parcel.writeInt(this.iNO);
            parcel.writeInt(this.iNP);
            parcel.writeString(this.iNQ);
        }

        HttpSetting(Parcel parcel) {
            this.mode = parcel.readInt();
            this.iNK = parcel.createStringArrayList();
            this.iNL = parcel.createStringArrayList();
            this.iNM = parcel.readInt();
            this.iNN = parcel.readInt();
            this.iNO = parcel.readInt();
            this.iNP = parcel.readInt();
            this.iNQ = parcel.readString();
        }
    }

    static {
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
        iNn = appBrandGlobalSystemConfig;
        appBrandGlobalSystemConfig.iNp = 5;
        iNn.iNq = 300;
        iNn.iNr = 10;
        iNn.iNs = 1048576;
        iNn.iNv = a.iNI;
        iNn.iNw = 10;
        iNn.iNx = 11;
        iNn.iNy = 1800;
        iNn.iNz = 307200;
        iNn.iNA = 25;
        iNn.iNB = 10485760;
        iNn.iNC = 314572800;
        iNn.iND = 1;
        iNn.iNE = 50;
        iNn.iNF = a.iNJ;
        iNn.iNG = 0.0d;
        iNn.iNH = 60;
    }

    static synchronized void abP() {
        synchronized (AppBrandGlobalSystemConfig.class) {
            iNm = null;
        }
    }

    static String abQ() {
        File file = new File(e.gZL.replace("/data/user/0", "/data/data"), "wxaapp/res/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "AppService.conf").getAbsolutePath();
    }

    private static synchronized AppBrandGlobalSystemConfig abR() {
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = null;
        int i = 0;
        synchronized (AppBrandGlobalSystemConfig.class) {
            if (iNm == null) {
                String bT;
                try {
                    bT = com.tencent.mm.a.e.bT(abQ());
                } catch (FileNotFoundException e) {
                    b bZm = c.bZm();
                    c.bZm();
                    r6 = a.bZC().RW(i.ey(38, 1));
                    q RW;
                    if (RW != null) {
                        i = bh.getInt(RW.field_fileVersion, 0);
                    }
                    bZm.e(38, 1, i, false);
                    bT = null;
                } catch (IOException e2) {
                    x.e("MicroMsg.AppBrandGlobalSystemConfig", "read config file, exp = %s", new Object[]{e2});
                    bT = null;
                }
                if (!bh.ov(bT)) {
                    iNm = qD(bT);
                }
            }
            appBrandGlobalSystemConfig = iNm;
        }
        return appBrandGlobalSystemConfig;
    }

    public static AppBrandGlobalSystemConfig abS() {
        AppBrandGlobalSystemConfig abR = abR();
        return abR == null ? iNn : abR;
    }

    private static AppBrandGlobalSystemConfig qD(String str) {
        x.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[]{str});
        try {
            int i;
            JSONObject jSONObject = new JSONObject(str);
            AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
            JSONObject optJSONObject = jSONObject.optJSONObject("HTTPSetting");
            if (optJSONObject != null) {
                appBrandGlobalSystemConfig.iNu = new HttpSetting();
                String optString = optJSONObject.optString("HTTPHeaderMode", "");
                if (optString.equals("BlackList")) {
                    appBrandGlobalSystemConfig.iNu.mode = 1;
                } else if (optString.equals("WhiteList")) {
                    appBrandGlobalSystemConfig.iNu.mode = 2;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("HeaderBlackList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.iNu.iNK = new ArrayList();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        appBrandGlobalSystemConfig.iNu.iNK.add(optJSONArray.getString(i));
                    }
                }
                optJSONArray = optJSONObject.optJSONArray("HeaderWhiteList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.iNu.iNL = new ArrayList();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        appBrandGlobalSystemConfig.iNu.iNL.add(optJSONArray.getString(i));
                    }
                }
                appBrandGlobalSystemConfig.iNu.iNM = optJSONObject.optInt("WebsocketMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.iNu.iNN = optJSONObject.optInt("UploadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.iNu.iNO = optJSONObject.optInt("DownloadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.iNu.iNP = optJSONObject.optInt("RequestMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.iNu.iNQ = optJSONObject.optString("HTTPHeaderReferer");
            }
            appBrandGlobalSystemConfig.iNt = jSONObject.optString("CDNBaseURL");
            appBrandGlobalSystemConfig.iNp = jSONObject.optInt("AppMaxRunningCount", 5);
            appBrandGlobalSystemConfig.iNq = jSONObject.optInt("TempFileSizeLimitTotal", 300);
            appBrandGlobalSystemConfig.iNr = jSONObject.optInt("DownloadFileSizeLimit", 10);
            appBrandGlobalSystemConfig.iNs = jSONObject.optInt("MaxLocalStorageItemSize", 1048576);
            appBrandGlobalSystemConfig.iNB = jSONObject.optInt("NativeBufferSizeLimitByte", 10485760);
            appBrandGlobalSystemConfig.iNC = jSONObject.optInt("NativeBufferQueueLimitByte", 314572800);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("SyncLaunchSceneList");
            if (optJSONArray2 != null) {
                appBrandGlobalSystemConfig.iNv = new int[optJSONArray2.length()];
                for (i = 0; i < optJSONArray2.length(); i++) {
                    appBrandGlobalSystemConfig.iNv[i] = optJSONArray2.optInt(i, 0);
                }
            }
            if (appBrandGlobalSystemConfig.iNv == null) {
                appBrandGlobalSystemConfig.iNv = a.iNI;
            }
            appBrandGlobalSystemConfig.iNw = jSONObject.optInt("StarNumberLimitation", 10);
            appBrandGlobalSystemConfig.iNx = jSONObject.optInt("TaskBarItemCountLimitation", 11);
            appBrandGlobalSystemConfig.iNy = jSONObject.optInt("WidgetImageFlowLimitDuration", 1800);
            appBrandGlobalSystemConfig.iNz = jSONObject.optInt("WidgetImageFlowLimitMaxSize", 307200);
            appBrandGlobalSystemConfig.iNA = jSONObject.optInt("WidgetDrawMinInterval", 25);
            appBrandGlobalSystemConfig.iND = jSONObject.optInt("GameMaxRunningCount", 1);
            appBrandGlobalSystemConfig.iNE = jSONObject.optInt("GameDownloadFileSizeLimit", 50);
            optJSONArray2 = jSONObject.optJSONArray("SubContextImgDomain");
            if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                appBrandGlobalSystemConfig.iNF = a.iNJ;
            } else {
                appBrandGlobalSystemConfig.iNF = new String[optJSONArray2.length()];
                for (i = 0; i < optJSONArray2.length(); i++) {
                    appBrandGlobalSystemConfig.iNF[i] = optJSONArray2.optString(i, null);
                }
            }
            appBrandGlobalSystemConfig.iNG = jSONObject.optDouble("GamePerfCollectSamplePercentage", 0.0d);
            appBrandGlobalSystemConfig.iNH = jSONObject.optInt("GamePerfCollectInterval", 60);
            return appBrandGlobalSystemConfig;
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[]{bh.i(e)});
            return null;
        }
    }

    private AppBrandGlobalSystemConfig() {
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.iNo);
        parcel.writeInt(this.iNp);
        parcel.writeInt(this.iNq);
        parcel.writeInt(this.iNr);
        parcel.writeInt(this.iNs);
        parcel.writeString(this.iNt);
        parcel.writeParcelable(this.iNu, i);
        parcel.writeIntArray(this.iNv);
        parcel.writeInt(this.iNw);
        parcel.writeInt(this.iNx);
        parcel.writeInt(this.iNy);
        parcel.writeInt(this.iNz);
        parcel.writeInt(this.iNA);
        parcel.writeInt(this.iNB);
        parcel.writeInt(this.iNC);
        parcel.writeInt(this.iND);
        parcel.writeInt(this.iNE);
        parcel.writeStringArray(this.iNF);
        parcel.writeDouble(this.iNG);
        parcel.writeInt(this.iNH);
    }

    protected AppBrandGlobalSystemConfig(Parcel parcel) {
        this.iNo = parcel.readInt();
        this.iNp = parcel.readInt();
        this.iNq = parcel.readInt();
        this.iNr = parcel.readInt();
        this.iNs = parcel.readInt();
        this.iNt = parcel.readString();
        this.iNu = (HttpSetting) parcel.readParcelable(HttpSetting.class.getClassLoader());
        this.iNv = parcel.createIntArray();
        this.iNw = parcel.readInt();
        this.iNx = parcel.readInt();
        this.iNy = parcel.readInt();
        this.iNz = parcel.readInt();
        this.iNA = parcel.readInt();
        this.iNB = parcel.readInt();
        this.iNC = parcel.readInt();
        this.iND = parcel.readInt();
        this.iNE = parcel.readInt();
        this.iNF = parcel.createStringArray();
        this.iNG = parcel.readDouble();
        this.iNH = parcel.readInt();
    }
}

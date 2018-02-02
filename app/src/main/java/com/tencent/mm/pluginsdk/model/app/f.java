package com.tencent.mm.pluginsdk.model.app;

import android.content.ContentValues;
import com.tencent.mm.g.b.n;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

public class f extends n {
    protected static a gJc;
    public static String vef = "wxce6f23b478a3a2a2";
    public static String veg = "wx7302cee7c7d6d7d6";
    public static String veh = "wx6fa7e3bab7e15415";
    public static String vei = "wx3cc22b542de028d4";

    static {
        a aVar = new a();
        aVar.hSY = new Field[26];
        aVar.columns = new String[27];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xjA.put("appId", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" appId TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "appId";
        aVar.columns[1] = "appName";
        aVar.xjA.put("appName", "TEXT");
        stringBuilder.append(" appName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appDiscription";
        aVar.xjA.put("appDiscription", "TEXT");
        stringBuilder.append(" appDiscription TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "appIconUrl";
        aVar.xjA.put("appIconUrl", "TEXT");
        stringBuilder.append(" appIconUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "appStoreUrl";
        aVar.xjA.put("appStoreUrl", "TEXT");
        stringBuilder.append(" appStoreUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "appVersion";
        aVar.xjA.put("appVersion", "INTEGER");
        stringBuilder.append(" appVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "appWatermarkUrl";
        aVar.xjA.put("appWatermarkUrl", "TEXT");
        stringBuilder.append(" appWatermarkUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = DownloadInfoColumns.PACKAGENAME;
        aVar.xjA.put(DownloadInfoColumns.PACKAGENAME, "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "signature";
        aVar.xjA.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "modifyTime";
        aVar.xjA.put("modifyTime", "LONG");
        stringBuilder.append(" modifyTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "appName_en";
        aVar.xjA.put("appName_en", "TEXT");
        stringBuilder.append(" appName_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "appName_tw";
        aVar.xjA.put("appName_tw", "TEXT");
        stringBuilder.append(" appName_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "appName_hk";
        aVar.xjA.put("appName_hk", "TEXT");
        stringBuilder.append(" appName_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "appDiscription_en";
        aVar.xjA.put("appDiscription_en", "TEXT");
        stringBuilder.append(" appDiscription_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "appDiscription_tw";
        aVar.xjA.put("appDiscription_tw", "TEXT");
        stringBuilder.append(" appDiscription_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "appType";
        aVar.xjA.put("appType", "TEXT");
        stringBuilder.append(" appType TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "openId";
        aVar.xjA.put("openId", "TEXT");
        stringBuilder.append(" openId TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "authFlag";
        aVar.xjA.put("authFlag", "INTEGER");
        stringBuilder.append(" authFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "appInfoFlag";
        aVar.xjA.put("appInfoFlag", "INTEGER default '-1' ");
        stringBuilder.append(" appInfoFlag INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "lvbuff";
        aVar.xjA.put("lvbuff", "BLOB");
        stringBuilder.append(" lvbuff BLOB");
        stringBuilder.append(", ");
        aVar.columns[21] = "serviceAppType";
        aVar.xjA.put("serviceAppType", "INTEGER default '0' ");
        stringBuilder.append(" serviceAppType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[22] = "serviceAppInfoFlag";
        aVar.xjA.put("serviceAppInfoFlag", "INTEGER default '0' ");
        stringBuilder.append(" serviceAppInfoFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[23] = "serviceShowFlag";
        aVar.xjA.put("serviceShowFlag", "INTEGER default '0' ");
        stringBuilder.append(" serviceShowFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[24] = "appSupportContentType";
        aVar.xjA.put("appSupportContentType", "LONG default '0' ");
        stringBuilder.append(" appSupportContentType LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[25] = "svrAppSupportContentType";
        aVar.xjA.put("svrAppSupportContentType", "LONG default '0' ");
        stringBuilder.append(" svrAppSupportContentType LONG default '0' ");
        aVar.columns[26] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public f() {
        this.field_appId = "";
        this.field_appName = "";
        this.field_appDiscription = "";
        this.field_appIconUrl = "";
        this.field_appStoreUrl = "";
        this.field_appVersion = 0;
        this.field_appWatermarkUrl = "";
        this.field_packageName = "";
        this.field_status = 4;
        this.field_signature = "";
        this.field_modifyTime = 0;
        this.field_appName_en = "";
        this.field_appName_tw = "";
        this.field_appName_hk = "";
        this.field_appDiscription_en = "";
        this.field_appDiscription_tw = "";
        this.field_appInfoFlag = 0;
        this.field_appType = "";
        this.field_openId = "";
        this.field_authFlag = 0;
        this.field_appInfoFlag = 0;
        cN("");
        cM("");
        cO("");
        cS("");
        cT("");
        cU("");
    }

    public final boolean Yz() {
        if (bh.ov(this.field_appType)) {
            return false;
        }
        String[] split = this.field_appType.split(",");
        if (split == null || split.length == 0) {
            return false;
        }
        for (String equals : split) {
            if (equals.equals("1")) {
                return true;
            }
        }
        return false;
    }

    public final boolean bYD() {
        if (this.field_serviceAppType == 0) {
            return false;
        }
        return true;
    }

    public final boolean bYE() {
        if ((this.field_serviceAppInfoFlag & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean bYF() {
        if (veg.equals(this.field_appId)) {
            return true;
        }
        return false;
    }

    public final ContentValues vI() {
        if (!bh.ov(this.field_appType) && (this.field_appType.startsWith("1") || this.field_appType.startsWith("6"))) {
            this.field_appType = "," + this.field_appType;
        }
        return super.vI();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return ((f) obj).field_appId.equals(this.field_appId);
        }
        return false;
    }

    public int hashCode() {
        if (bh.ov(this.field_appId)) {
            return super.hashCode();
        }
        return this.field_appId.hashCode();
    }
}

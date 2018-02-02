package com.tencent.mm.plugin.welab.c.a;

import android.text.TextUtils;
import com.tencent.mm.g.b.cb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a extends cb {
    public static com.tencent.mm.sdk.e.c.a gJc;
    private static final List<String> tPE = Arrays.asList(new String[]{"_cn", "_hk", "_tw", "_en"});
    private Map<String, Field> tPD = new HashMap();

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[45];
        aVar.columns = new String[46];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "LabsAppId";
        aVar.xjA.put("LabsAppId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" LabsAppId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "LabsAppId";
        aVar.columns[1] = "expId";
        aVar.xjA.put("expId", "TEXT default '' ");
        stringBuilder.append(" expId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "Type";
        aVar.xjA.put("Type", "INTEGER default '0' ");
        stringBuilder.append(" Type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "BizType";
        aVar.xjA.put("BizType", "INTEGER default '0' ");
        stringBuilder.append(" BizType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "Switch";
        aVar.xjA.put("Switch", "INTEGER default '0' ");
        stringBuilder.append(" Switch INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "AllVer";
        aVar.xjA.put("AllVer", "INTEGER default '0' ");
        stringBuilder.append(" AllVer INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "DetailURL";
        aVar.xjA.put("DetailURL", "TEXT");
        stringBuilder.append(" DetailURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "WeAppUser";
        aVar.xjA.put("WeAppUser", "TEXT");
        stringBuilder.append(" WeAppUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "WeAppPath";
        aVar.xjA.put("WeAppPath", "TEXT");
        stringBuilder.append(" WeAppPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "Pos";
        aVar.xjA.put("Pos", "INTEGER default '0' ");
        stringBuilder.append(" Pos INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "TitleKey_android";
        aVar.xjA.put("TitleKey_android", "TEXT");
        stringBuilder.append(" TitleKey_android TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "Title_cn";
        aVar.xjA.put("Title_cn", "TEXT");
        stringBuilder.append(" Title_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "Title_hk";
        aVar.xjA.put("Title_hk", "TEXT");
        stringBuilder.append(" Title_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "Title_tw";
        aVar.xjA.put("Title_tw", "TEXT");
        stringBuilder.append(" Title_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "Title_en";
        aVar.xjA.put("Title_en", "TEXT");
        stringBuilder.append(" Title_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "Desc_cn";
        aVar.xjA.put("Desc_cn", "TEXT");
        stringBuilder.append(" Desc_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "Desc_hk";
        aVar.xjA.put("Desc_hk", "TEXT");
        stringBuilder.append(" Desc_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "Desc_tw";
        aVar.xjA.put("Desc_tw", "TEXT");
        stringBuilder.append(" Desc_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "Desc_en";
        aVar.xjA.put("Desc_en", "TEXT");
        stringBuilder.append(" Desc_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "Introduce_cn";
        aVar.xjA.put("Introduce_cn", "TEXT");
        stringBuilder.append(" Introduce_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "Introduce_hk";
        aVar.xjA.put("Introduce_hk", "TEXT");
        stringBuilder.append(" Introduce_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "Introduce_tw";
        aVar.xjA.put("Introduce_tw", "TEXT");
        stringBuilder.append(" Introduce_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "Introduce_en";
        aVar.xjA.put("Introduce_en", "TEXT");
        stringBuilder.append(" Introduce_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "starttime";
        aVar.xjA.put("starttime", "LONG");
        stringBuilder.append(" starttime LONG");
        stringBuilder.append(", ");
        aVar.columns[24] = "endtime";
        aVar.xjA.put("endtime", "LONG");
        stringBuilder.append(" endtime LONG");
        stringBuilder.append(", ");
        aVar.columns[25] = "sequence";
        aVar.xjA.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.columns[26] = "prioritylevel";
        aVar.xjA.put("prioritylevel", "INTEGER");
        stringBuilder.append(" prioritylevel INTEGER");
        stringBuilder.append(", ");
        aVar.columns[27] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[28] = "ThumbUrl_cn";
        aVar.xjA.put("ThumbUrl_cn", "TEXT");
        stringBuilder.append(" ThumbUrl_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[29] = "ThumbUrl_hk";
        aVar.xjA.put("ThumbUrl_hk", "TEXT");
        stringBuilder.append(" ThumbUrl_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[30] = "ThumbUrl_tw";
        aVar.xjA.put("ThumbUrl_tw", "TEXT");
        stringBuilder.append(" ThumbUrl_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[31] = "ThumbUrl_en";
        aVar.xjA.put("ThumbUrl_en", "TEXT");
        stringBuilder.append(" ThumbUrl_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "ImgUrl_android_cn";
        aVar.xjA.put("ImgUrl_android_cn", "TEXT");
        stringBuilder.append(" ImgUrl_android_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "ImgUrl_android_hk";
        aVar.xjA.put("ImgUrl_android_hk", "TEXT");
        stringBuilder.append(" ImgUrl_android_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "ImgUrl_android_tw";
        aVar.xjA.put("ImgUrl_android_tw", "TEXT");
        stringBuilder.append(" ImgUrl_android_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[35] = "ImgUrl_android_en";
        aVar.xjA.put("ImgUrl_android_en", "TEXT");
        stringBuilder.append(" ImgUrl_android_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[36] = "RedPoint";
        aVar.xjA.put("RedPoint", "INTEGER");
        stringBuilder.append(" RedPoint INTEGER");
        stringBuilder.append(", ");
        aVar.columns[37] = "WeAppDebugMode";
        aVar.xjA.put("WeAppDebugMode", "INTEGER");
        stringBuilder.append(" WeAppDebugMode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[38] = "idkey";
        aVar.xjA.put("idkey", "INTEGER");
        stringBuilder.append(" idkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[39] = "idkeyValue";
        aVar.xjA.put("idkeyValue", "INTEGER");
        stringBuilder.append(" idkeyValue INTEGER");
        stringBuilder.append(", ");
        aVar.columns[40] = "Icon";
        aVar.xjA.put("Icon", "TEXT");
        stringBuilder.append(" Icon TEXT");
        stringBuilder.append(", ");
        aVar.columns[41] = "ImgUrl_cn";
        aVar.xjA.put("ImgUrl_cn", "TEXT");
        stringBuilder.append(" ImgUrl_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[42] = "ImgUrl_hk";
        aVar.xjA.put("ImgUrl_hk", "TEXT");
        stringBuilder.append(" ImgUrl_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[43] = "ImgUrl_tw";
        aVar.xjA.put("ImgUrl_tw", "TEXT");
        stringBuilder.append(" ImgUrl_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[44] = "ImgUrl_en";
        aVar.xjA.put("ImgUrl_en", "TEXT");
        stringBuilder.append(" ImgUrl_en TEXT");
        aVar.columns[45] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }

    public int hashCode() {
        return this.field_LabsAppId.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            return ((a) obj).field_LabsAppId.equals(this.field_LabsAppId);
        }
        return false;
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.field_LabsAppId) || this.field_LabsAppId.equals("labs1de6f3")) ? false : true;
    }

    public final boolean isRunning() {
        return isValid() && System.currentTimeMillis() / 1000 > this.field_starttime && System.currentTimeMillis() / 1000 < this.field_endtime;
    }

    public final boolean bPi() {
        return isValid() && System.currentTimeMillis() / 1000 >= this.field_endtime;
    }

    public String toString() {
        return "[appid " + this.field_LabsAppId + ",title " + this.field_Title_cn + "]";
    }

    public final String QD(String str) {
        Object uM = uM(str + "Key_android");
        if (!TextUtils.isEmpty(uM)) {
            uM = ac.getResources().getString(ac.getResources().getIdentifier(uM, "string", ac.getPackageName()));
            if (!TextUtils.isEmpty(uM)) {
                return uM;
            }
        }
        String eL = w.eL(ac.getContext());
        if (w.cff()) {
            return eZ(str, "_cn");
        }
        if ("zh_HK".equals(eL)) {
            return eZ(str, "_hk");
        }
        if ("zh_TW".equals(eL)) {
            return eZ(str, "_tw");
        }
        return eZ(str, "_en");
    }

    private String eZ(String str, String str2) {
        Object uM = uM(str + str2);
        return !TextUtils.isEmpty(uM) ? uM : QE(str);
    }

    private String QE(String str) {
        for (String str2 : tPE) {
            String str22 = uM(str + str22);
            if (!TextUtils.isEmpty(str22)) {
                return str22;
            }
        }
        return "";
    }

    private String uM(String str) {
        Throwable e;
        Field field = (Field) this.tPD.get(str);
        Field field2;
        if (field == null) {
            try {
                field2 = a.class.getField(str);
                try {
                    this.tPD.put(str, field2);
                } catch (NoSuchFieldException e2) {
                    e = e2;
                    x.w("LabAppInfo", bh.i(e));
                    if (field2 != null) {
                        try {
                            return (String) field2.get(this);
                        } catch (Throwable e3) {
                            x.w("LabAppInfo", bh.i(e3));
                        }
                    }
                    return "";
                }
            } catch (Throwable e4) {
                Throwable th = e4;
                field2 = field;
                e3 = th;
                x.w("LabAppInfo", bh.i(e3));
                if (field2 != null) {
                    return (String) field2.get(this);
                }
                return "";
            }
        }
        field2 = field;
        if (field2 != null) {
            return (String) field2.get(this);
        }
        return "";
    }

    public final boolean bVF() {
        return isRunning() && (this.field_Switch == 2 || this.field_Switch == 1);
    }
}

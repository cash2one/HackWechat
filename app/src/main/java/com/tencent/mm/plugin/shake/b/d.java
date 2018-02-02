package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.tencent.mm.g.b.cx;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.reflect.Field;

public final class d extends cx {
    protected static a gJc;
    public int fDt;
    private bdn qnK;
    public int scene;

    static {
        a aVar = new a();
        aVar.hSY = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "shakeItemID";
        aVar.xjA.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "shakeItemID";
        aVar.columns[1] = "username";
        aVar.xjA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "nickname";
        aVar.xjA.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "province";
        aVar.xjA.put("province", "TEXT");
        stringBuilder.append(" province TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "city";
        aVar.xjA.put("city", "TEXT");
        stringBuilder.append(" city TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "signature";
        aVar.xjA.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "distance";
        aVar.xjA.put("distance", "TEXT");
        stringBuilder.append(" distance TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "sex";
        aVar.xjA.put("sex", "INTEGER");
        stringBuilder.append(" sex INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "imgstatus";
        aVar.xjA.put("imgstatus", "INTEGER");
        stringBuilder.append(" imgstatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "hasHDImg";
        aVar.xjA.put("hasHDImg", "INTEGER");
        stringBuilder.append(" hasHDImg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "insertBatch";
        aVar.xjA.put("insertBatch", "INTEGER");
        stringBuilder.append(" insertBatch INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved1";
        aVar.xjA.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved2";
        aVar.xjA.put("reserved2", "INTEGER");
        stringBuilder.append(" reserved2 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "reserved3";
        aVar.xjA.put("reserved3", "TEXT");
        stringBuilder.append(" reserved3 TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "reserved4";
        aVar.xjA.put("reserved4", "TEXT");
        stringBuilder.append(" reserved4 TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "lvbuffer";
        aVar.xjA.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        aVar.columns[17] = "regionCode";
        aVar.xjA.put("regionCode", "TEXT");
        stringBuilder.append(" regionCode TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "snsFlag";
        aVar.xjA.put("snsFlag", "INTEGER");
        stringBuilder.append(" snsFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "sns_bgurl";
        aVar.xjA.put("sns_bgurl", "TEXT");
        stringBuilder.append(" sns_bgurl TEXT");
        aVar.columns[20] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public d() {
        this.fDt = -1;
        this.field_insertBatch = 2;
    }

    public d(bhp com_tencent_mm_protocal_c_bhp) {
        this.fDt = -1;
        this.field_username = com_tencent_mm_protocal_c_bhp.ksU;
        this.field_nickname = com_tencent_mm_protocal_c_bhp.kub;
        this.field_signature = com_tencent_mm_protocal_c_bhp.hvw;
        this.field_distance = com_tencent_mm_protocal_c_bhp.wve;
        this.field_reserved4 = String.valueOf(com_tencent_mm_protocal_c_bhp.wLh);
        this.field_sex = com_tencent_mm_protocal_c_bhp.hvt;
        this.field_imgstatus = com_tencent_mm_protocal_c_bhp.vHa;
        this.field_hasHDImg = com_tencent_mm_protocal_c_bhp.wLf;
        this.field_reserved1 = com_tencent_mm_protocal_c_bhp.wvf;
        this.field_reserved3 = com_tencent_mm_protocal_c_bhp.wvg;
        this.field_insertBatch = 2;
        if (com_tencent_mm_protocal_c_bhp.wvl != null) {
            this.field_snsFlag = com_tencent_mm_protocal_c_bhp.wvl.hvE;
            this.field_sns_bgurl = com_tencent_mm_protocal_c_bhp.wvl.hvF;
        }
        this.qnK = com_tencent_mm_protocal_c_bhp.wLg;
        this.field_province = com_tencent_mm_protocal_c_bhp.hvu;
        this.field_city = com_tencent_mm_protocal_c_bhp.hvv;
        this.field_regionCode = RegionCodeDecoder.ah(com_tencent_mm_protocal_c_bhp.hvC, this.field_province, this.field_city);
    }

    public final String getProvince() {
        if (!bh.ov(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length <= 2 || !split[0].equalsIgnoreCase("cn")) {
                    this.field_province = RegionCodeDecoder.cjP().XF(split[0]);
                } else {
                    this.field_province = RegionCodeDecoder.cjP().fE(split[0], split[1]);
                }
            }
        }
        return this.field_province;
    }

    public final String getCity() {
        if (!bh.ov(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length > 2) {
                    this.field_city = RegionCodeDecoder.cjP().ai(split[0], split[1], split[2]);
                } else if (split.length == 2) {
                    this.field_city = RegionCodeDecoder.cjP().fE(split[0], split[1]);
                } else {
                    this.field_city = "";
                }
            }
        }
        return this.field_city;
    }

    private int brq() {
        try {
            return Integer.valueOf(this.field_reserved4).intValue();
        } catch (Throwable th) {
            return 0;
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 2) != 0) {
            contentValues.put("username", this.field_username);
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("nickname", this.field_nickname);
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("province", getProvince());
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("city", getCity());
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("signature", this.field_signature);
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put("distance", this.field_distance);
        }
        if ((this.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if ((this.fDt & 256) != 0) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if ((this.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if ((this.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if ((this.fDt & 2048) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if ((this.fDt & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if ((this.fDt & 8192) != 0) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if ((this.fDt & 16384) != 0) {
            contentValues.put("reserved4", Integer.valueOf(brq()));
        }
        if ((this.fDt & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if ((this.fDt & 65536) != 0) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if ((this.fDt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if ((this.fDt & 262144) != 0) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if ((this.fDt & SQLiteGlobal.journalSizeLimit) != 0) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        return contentValues;
    }
}

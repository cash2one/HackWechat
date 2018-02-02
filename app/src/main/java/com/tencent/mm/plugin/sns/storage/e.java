package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e extends com.tencent.mm.g.b.e {
    protected static a gJc;
    protected static Map<String, b> roK = new ConcurrentHashMap();
    protected static Map<String, a> roL = new ConcurrentHashMap();
    public String roI = null;
    protected int roJ;

    static {
        a aVar = new a();
        aVar.hSY = new Field[22];
        aVar.columns = new String[23];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "snsId";
        aVar.xjA.put("snsId", "LONG");
        stringBuilder.append(" snsId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "userName";
        aVar.xjA.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "localFlag";
        aVar.xjA.put("localFlag", "INTEGER");
        stringBuilder.append(" localFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.xjA.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "head";
        aVar.xjA.put("head", "INTEGER");
        stringBuilder.append(" head INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "localPrivate";
        aVar.xjA.put("localPrivate", "INTEGER");
        stringBuilder.append(" localPrivate INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "sourceType";
        aVar.xjA.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "likeFlag";
        aVar.xjA.put("likeFlag", "INTEGER");
        stringBuilder.append(" likeFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "pravited";
        aVar.xjA.put("pravited", "INTEGER");
        stringBuilder.append(" pravited INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "stringSeq";
        aVar.xjA.put("stringSeq", "TEXT");
        stringBuilder.append(" stringSeq TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "content";
        aVar.xjA.put("content", "BLOB");
        stringBuilder.append(" content BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "attrBuf";
        aVar.xjA.put("attrBuf", "BLOB");
        stringBuilder.append(" attrBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "postBuf";
        aVar.xjA.put("postBuf", "BLOB");
        stringBuilder.append(" postBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "adinfo";
        aVar.xjA.put("adinfo", "TEXT");
        stringBuilder.append(" adinfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "adxml";
        aVar.xjA.put("adxml", "TEXT");
        stringBuilder.append(" adxml TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "createAdTime";
        aVar.xjA.put("createAdTime", "INTEGER");
        stringBuilder.append(" createAdTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "exposureTime";
        aVar.xjA.put("exposureTime", "INTEGER");
        stringBuilder.append(" exposureTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[18] = "firstControlTime";
        aVar.xjA.put("firstControlTime", "INTEGER");
        stringBuilder.append(" firstControlTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "recxml";
        aVar.xjA.put("recxml", "TEXT");
        stringBuilder.append(" recxml TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "subType";
        aVar.xjA.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[21] = "exposureCount";
        aVar.xjA.put("exposureCount", "INTEGER");
        stringBuilder.append(" exposureCount INTEGER");
        aVar.columns[22] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final b bxR() {
        b bVar;
        if (this.field_adxml == null) {
            bVar = null;
        } else if (roK.containsKey(this.field_adxml)) {
            return (b) roK.get(this.field_adxml);
        } else {
            bVar = new b(this.field_adxml);
            roK.put(this.field_adxml, bVar);
        }
        return bVar == null ? new b(null) : bVar;
    }

    public final b bxS() {
        b bVar;
        if (this.field_recxml == null) {
            bVar = null;
        } else if (roK.containsKey(this.field_recxml)) {
            return (b) roK.get(this.field_recxml);
        } else {
            bVar = new b(this.field_recxml);
            roK.put(this.field_recxml, bVar);
        }
        return bVar == null ? new b(null) : bVar;
    }

    public final a bxT() {
        a aVar;
        if (this.field_adinfo == null) {
            aVar = null;
        } else if (roL.containsKey(this.field_adinfo)) {
            return (a) roL.get(this.field_adinfo);
        } else {
            aVar = new a(this.field_adinfo);
            roL.put(this.field_adinfo, aVar);
        }
        return aVar == null ? new a(null) : aVar;
    }

    public final boolean Lj(String str) {
        if (str == null || str.length() <= 0 || str.equals(this.field_adinfo)) {
            return false;
        }
        roL.remove(this.field_adinfo);
        this.field_adinfo = str;
        return true;
    }

    public final boolean bwE() {
        b bxR = bxR();
        if (bxR != null) {
            return bxR.bwE();
        }
        return false;
    }

    public final int bxU() {
        b bxS = bxS();
        return bxS == null ? 0 : bxS.reQ;
    }

    public final int getSource() {
        b bxS = bxS();
        return bxS == null ? 0 : bxS.reQ;
    }

    public final void c(bnp com_tencent_mm_protocal_c_bnp) {
        try {
            this.field_content = com_tencent_mm_protocal_c_bnp.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AdSnsInfo", e, "", new Object[0]);
        }
    }

    public final boolean Lk(String str) {
        try {
            this.field_content = com.tencent.mm.modelsns.e.mG(str).toByteArray();
            this.roI = g.s(this.field_content) + g.s(this.field_attrBuf);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AdSnsInfo", e, "", new Object[0]);
            return false;
        }
    }

    public final bnp bxV() {
        if (this.field_content == null) {
            return com.tencent.mm.modelsns.e.SA();
        }
        bnp com_tencent_mm_protocal_c_bnp;
        if (this.roI == null) {
            this.roI = g.s(this.field_content) + g.s(this.field_attrBuf);
        }
        if (m.roQ.containsKey(this.roI)) {
            com_tencent_mm_protocal_c_bnp = (bnp) m.roQ.get(this.roI);
            if (com_tencent_mm_protocal_c_bnp != null) {
                return com_tencent_mm_protocal_c_bnp;
            }
        }
        try {
            com_tencent_mm_protocal_c_bnp = (bnp) new bnp().aF(this.field_content);
            m.roQ.put(this.roI, com_tencent_mm_protocal_c_bnp);
            return com_tencent_mm_protocal_c_bnp;
        } catch (Exception e) {
            x.e("MicroMsg.AdSnsInfo", "error get snsinfo timeline!");
            return com.tencent.mm.modelsns.e.SA();
        }
    }

    public final void aJ(byte[] bArr) {
        this.field_attrBuf = bArr;
        this.roI = g.s(this.field_content) + g.s(this.field_attrBuf);
    }

    public final void xj(int i) {
        this.field_sourceType |= i;
    }

    public final String bxW() {
        return u.ab("ad_table_", this.field_snsId);
    }

    public final m bxX() {
        m mVar = new m();
        mVar.c(bxV());
        x.d("MicroMsg.AdSnsInfo", "from server xml ok %d", new Object[]{Long.valueOf(this.field_snsId)});
        mVar.roJ = this.roJ;
        mVar.field_userName = this.field_userName;
        mVar.hK(this.field_createTime);
        mVar.field_likeFlag = this.field_likeFlag;
        mVar.eN(this.field_snsId);
        mVar.field_sourceType = this.field_sourceType;
        mVar.field_content = this.field_content;
        mVar.xj(2);
        mVar.xj(32);
        mVar.field_attrBuf = this.field_attrBuf;
        bnp bxV = mVar.bxV();
        bxV.ksU = this.field_userName;
        mVar.field_pravited = bxV.wxG;
        mVar.byn();
        mVar.c(bxV);
        if (bxV.wQo != null) {
            mVar.field_type = bxV.wQo.vYc;
            mVar.field_subType = bxV.wQo.vYe;
        }
        mVar.roT = this;
        return mVar;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.roJ = (int) this.xjy;
    }

    public final Bundle bxY() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.vI());
        bundle.putInt("localid", this.roJ);
        return bundle;
    }

    public final void E(Bundle bundle) {
        if (bundle != null) {
            ContentValues contentValues = (ContentValues) bundle.getParcelable("values");
            this.field_snsId = contentValues.getAsLong("snsId").longValue();
            this.field_userName = contentValues.getAsString("userName");
            this.field_localFlag = contentValues.getAsInteger("localFlag").intValue();
            this.field_createTime = contentValues.getAsInteger("createTime").intValue();
            this.field_head = contentValues.getAsInteger("head").intValue();
            this.field_localPrivate = contentValues.getAsInteger("localPrivate").intValue();
            this.field_type = contentValues.getAsInteger(DownloadSettingTable$Columns.TYPE).intValue();
            this.field_sourceType = contentValues.getAsInteger("sourceType").intValue();
            this.field_likeFlag = contentValues.getAsInteger("likeFlag").intValue();
            this.field_pravited = contentValues.getAsInteger("pravited").intValue();
            this.field_stringSeq = contentValues.getAsString("stringSeq");
            this.field_content = contentValues.getAsByteArray("content");
            this.field_attrBuf = contentValues.getAsByteArray("attrBuf");
            this.field_postBuf = contentValues.getAsByteArray("postBuf");
            this.field_adinfo = contentValues.getAsString("adinfo");
            this.field_adxml = contentValues.getAsString("adxml");
            this.field_createAdTime = contentValues.getAsInteger("createAdTime").intValue();
            this.field_exposureTime = contentValues.getAsInteger("exposureTime").intValue();
            this.field_firstControlTime = contentValues.getAsInteger("firstControlTime").intValue();
            this.field_recxml = contentValues.getAsString("recxml");
            this.field_subType = contentValues.getAsInteger("subType").intValue();
            this.xjy = contentValues.getAsLong("rowid").longValue();
            this.roJ = bundle.getInt("localid");
        }
    }
}

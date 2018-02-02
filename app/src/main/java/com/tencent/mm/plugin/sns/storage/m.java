package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.g.b.dg;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class m extends dg {
    protected static a gJc;
    protected static Map<String, bnp> roQ = new ConcurrentHashMap();
    protected static Map<String, aqs> roR = new ConcurrentHashMap();
    private boolean qQH = false;
    public String roI = null;
    public int roJ;
    public String roS = null;
    public e roT;
    private aqs roU = null;

    static {
        a aVar = new a();
        aVar.hSY = new Field[15];
        aVar.columns = new String[16];
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
        aVar.columns[14] = "subType";
        aVar.xjA.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        aVar.columns[15] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final aqs byi() {
        if (this.field_postBuf == null) {
            return new aqs();
        }
        if (this.roS == null) {
            this.roS = g.s(this.field_postBuf);
        }
        if (roR.containsKey(this.roS)) {
            this.roU = (aqs) roR.get(this.roS);
            if (this.roU != null) {
                return this.roU;
            }
        }
        try {
            this.roU = (aqs) new aqs().aF(this.field_postBuf);
            roR.put(this.roS, this.roU);
            return this.roU;
        } catch (Exception e) {
            x.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            return new aqs();
        }
    }

    public m(byte b) {
        eN(0);
    }

    public static m x(m mVar) {
        m mVar2 = new m();
        mVar2.roJ = mVar.roJ;
        mVar2.field_snsId = mVar.field_snsId;
        mVar2.field_userName = mVar.field_userName;
        mVar2.field_localFlag = mVar.field_localFlag;
        mVar2.field_createTime = mVar.field_createTime;
        mVar2.field_head = mVar.field_head;
        mVar2.field_localPrivate = mVar.field_localPrivate;
        mVar2.field_type = mVar.field_type;
        mVar2.field_sourceType = mVar.field_sourceType;
        mVar2.field_likeFlag = mVar.field_likeFlag;
        mVar2.field_pravited = mVar.field_pravited;
        mVar2.field_stringSeq = mVar.field_stringSeq;
        mVar2.field_content = mVar.field_content;
        mVar2.field_attrBuf = mVar.field_attrBuf;
        return mVar2;
    }

    public final void eN(long j) {
        this.field_snsId = j;
        if (j != 0) {
            eP(j);
        }
    }

    public final String bxW() {
        if (xl(32)) {
            return u.ab("ad_table_", this.field_snsId);
        }
        return u.ab("sns_table_", this.field_snsId);
    }

    public final String getUserName() {
        return this.field_userName;
    }

    private static int eO(long j) {
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date(1000 * j));
        try {
            return Integer.valueOf(format).intValue();
        } catch (Exception e) {
            x.e("MicroMsg.SnsInfo", "error valueOf  " + format);
            return (int) (j / 86400);
        }
    }

    public final void hK(int i) {
        if (i - this.field_createTime >= 180 || i - this.field_createTime < 0) {
            this.field_createTime = i;
            this.field_head = eO((long) i);
        } else if (this.field_head == 0) {
            this.field_head = eO((long) this.field_createTime);
        }
    }

    public final int byj() {
        return this.field_createTime;
    }

    public final void byk() {
        this.field_localPrivate |= 1;
    }

    public final int byl() {
        return this.field_localPrivate;
    }

    public final boolean bym() {
        return (this.field_localFlag & FileUtils.S_IWUSR) > 0;
    }

    public final void byn() {
        this.field_localFlag |= 2;
    }

    public final void byo() {
        this.field_localFlag &= -3;
    }

    public final boolean byp() {
        return (this.field_localFlag & 2) > 0;
    }

    public final String byq() {
        if (xl(32)) {
            return u.ab("ad_table_", (long) this.roJ);
        }
        return u.ab("sns_table_", (long) this.roJ);
    }

    public final void aJ(byte[] bArr) {
        this.field_attrBuf = bArr;
        this.roI = g.s(this.field_content) + g.s(this.field_attrBuf);
    }

    public final void eP(long j) {
        this.field_stringSeq = i.eq(j);
        this.field_stringSeq = i.JN(this.field_stringSeq);
        x.d("MicroMsg.SnsInfo", j + " stringSeq " + this.field_stringSeq);
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.roJ = (int) this.xjy;
    }

    public static synchronized void release() {
        synchronized (m.class) {
            roQ.clear();
            roR.clear();
        }
    }

    public final bnp bxV() {
        if (this.field_content == null) {
            return e.SA();
        }
        bnp com_tencent_mm_protocal_c_bnp;
        if (this.roI == null) {
            this.roI = g.s(this.field_content) + g.s(this.field_attrBuf);
        }
        if (roQ.containsKey(this.roI)) {
            com_tencent_mm_protocal_c_bnp = (bnp) roQ.get(this.roI);
            if (com_tencent_mm_protocal_c_bnp != null) {
                return com_tencent_mm_protocal_c_bnp;
            }
        }
        try {
            com_tencent_mm_protocal_c_bnp = (bnp) new bnp().aF(this.field_content);
            roQ.put(this.roI, com_tencent_mm_protocal_c_bnp);
            return com_tencent_mm_protocal_c_bnp;
        } catch (Exception e) {
            x.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            return e.SA();
        }
    }

    public final void c(bnp com_tencent_mm_protocal_c_bnp) {
        try {
            this.field_content = com_tencent_mm_protocal_c_bnp.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsInfo", e, "", new Object[0]);
        }
        this.roI = g.s(this.field_content) + g.s(this.field_attrBuf);
    }

    public final boolean Lk(String str) {
        try {
            this.field_content = e.mG(str).toByteArray();
            this.roI = g.s(this.field_content) + g.s(this.field_attrBuf);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsInfo", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean byr() {
        return (this.field_localFlag & 16) > 0;
    }

    public final boolean bys() {
        return (this.field_localFlag & 32) > 0 && this.field_snsId == 0;
    }

    public final void byt() {
        this.field_localFlag &= -33;
    }

    public final void byu() {
        this.field_localFlag |= 32;
    }

    public static boolean eQ(long j) {
        if (bh.by(j / 1000) > 1200) {
            return true;
        }
        return false;
    }

    public final boolean xl(int i) {
        return (this.field_sourceType & i) > 0;
    }

    public final void xj(int i) {
        this.field_sourceType |= i;
    }

    public final void xm(int i) {
        this.field_sourceType &= i ^ -1;
    }

    public final b bxR() {
        if (this.roT == null) {
            this.roT = ae.bvy().eK(this.field_snsId);
        }
        return this.roT == null ? new b(null) : this.roT.bxR();
    }

    public final a bxT() {
        if (this.roT == null) {
            this.roT = ae.bvy().eK(this.field_snsId);
        }
        return this.roT == null ? new a(null) : this.roT.bxT();
    }

    public final String byv() {
        a bxT = bxT();
        return bxT == null ? "" : bxT.reb;
    }

    public final String byw() {
        a bxT = bxT();
        return bxT == null ? "" : bxT.rea;
    }

    public final String byx() {
        b bxR = bxR();
        if (bxR != null) {
            return bxR.rdQ;
        }
        return "";
    }

    public final String byy() {
        a bxT = bxT();
        if (bxT != null) {
            return bxT.rdQ;
        }
        return "";
    }

    public final String byz() {
        a bxT = bxT();
        if (bxT != null) {
            return bxT.iTh;
        }
        return "";
    }

    public final String byA() {
        a bxT = bxT();
        if (bxT != null) {
            return bxT.qZM;
        }
        return "";
    }

    public final e byB() {
        if (this.roT == null) {
            this.roT = ae.bvy().eK(this.field_snsId);
        }
        if (this.roT != null) {
            this.roT.field_createTime = this.field_createTime;
            this.roT.field_userName = this.field_userName;
            this.roT.field_likeFlag = this.field_likeFlag;
            this.roT.field_attrBuf = this.field_attrBuf;
        }
        return this.roT;
    }

    public final boolean kf() {
        return xl(32);
    }

    public final int byC() {
        b bxR = bxR();
        if (bxR != null) {
            return bxR.reQ;
        }
        return 0;
    }

    public final boolean bwE() {
        b bxR = bxR();
        if (bxR != null) {
            return bxR.bwE();
        }
        return false;
    }

    public final boolean isValid() {
        return this.field_snsId != 0;
    }

    public final boolean bve() {
        return this.field_snsId == 0;
    }

    public final int byD() {
        if (!xl(32)) {
            return -1;
        }
        b bxR = bxR();
        bnp bxV = bxV();
        if (bxR.bwx()) {
            return 3;
        }
        if (bxV != null && bxV.wQo.vYc == 27) {
            return 6;
        }
        if (bxR.bwy()) {
            if (bxV == null || bxV.wQo.vYc != 15 || bxV.wQv == 1) {
                return 4;
            }
            return 5;
        } else if (this.field_type != 1) {
            return 2;
        } else {
            return 1;
        }
    }

    public final boolean byE() {
        return byD() == 6;
    }

    public final boolean bwy() {
        int byD = byD();
        return byD == 5 || byD == 4;
    }

    public final Bundle bxY() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.vI());
        bundle.putInt("localid", this.roJ);
        if (byB() != null) {
            bundle.putBundle("adValues", byB().bxY());
        }
        return bundle;
    }
}

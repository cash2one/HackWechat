package com.tencent.mm.l;

import android.database.Cursor;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.a.o;
import com.tencent.mm.g.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.reflect.Field;

public class a extends af {
    public static com.tencent.mm.sdk.e.c.a gJc;
    private static a gJe = null;
    public long gJd;
    public int versionCode;

    public interface a {
        String cE(String str);

        String cF(String str);
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hSY = new Field[19];
        aVar.columns = new String[20];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xjA.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "username";
        aVar.columns[1] = "alias";
        aVar.xjA.put("alias", "TEXT default '' ");
        stringBuilder.append(" alias TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "conRemark";
        aVar.xjA.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "domainList";
        aVar.xjA.put("domainList", "TEXT default '' ");
        stringBuilder.append(" domainList TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "nickname";
        aVar.xjA.put("nickname", "TEXT default '' ");
        stringBuilder.append(" nickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "pyInitial";
        aVar.xjA.put("pyInitial", "TEXT default '' ");
        stringBuilder.append(" pyInitial TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "quanPin";
        aVar.xjA.put("quanPin", "TEXT default '' ");
        stringBuilder.append(" quanPin TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "showHead";
        aVar.xjA.put("showHead", "INTEGER default '0' ");
        stringBuilder.append(" showHead INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "weiboFlag";
        aVar.xjA.put("weiboFlag", "INTEGER default '0' ");
        stringBuilder.append(" weiboFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "weiboNickname";
        aVar.xjA.put("weiboNickname", "TEXT default '' ");
        stringBuilder.append(" weiboNickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "conRemarkPYFull";
        aVar.xjA.put("conRemarkPYFull", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYFull TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "conRemarkPYShort";
        aVar.xjA.put("conRemarkPYShort", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYShort TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "lvbuff";
        aVar.xjA.put("lvbuff", "BLOB");
        stringBuilder.append(" lvbuff BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "verifyFlag";
        aVar.xjA.put("verifyFlag", "INTEGER default '0' ");
        stringBuilder.append(" verifyFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "encryptUsername";
        aVar.xjA.put("encryptUsername", "TEXT default '' ");
        stringBuilder.append(" encryptUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "chatroomFlag";
        aVar.xjA.put("chatroomFlag", "INTEGER");
        stringBuilder.append(" chatroomFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "deleteFlag";
        aVar.xjA.put("deleteFlag", "INTEGER default '0' ");
        stringBuilder.append(" deleteFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "contactLabelIds";
        aVar.xjA.put("contactLabelIds", "TEXT default '' ");
        stringBuilder.append(" contactLabelIds TEXT default '' ");
        aVar.columns[19] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    public final com.tencent.mm.sdk.e.c.a Ac() {
        return gJc;
    }

    public a(String str) {
        this();
        if (str == null) {
            str = "";
        }
        setUsername(str);
    }

    public a() {
        this.versionCode = 0;
        super.setUsername("");
        super.dc("");
        super.dd("");
        super.de("");
        super.cZ("");
        super.da("");
        super.dh("");
        super.dg("");
        super.db("");
        super.ey(0);
        super.df("");
        super.ex(0);
        super.setType(0);
        super.ez(0);
        super.eA(0);
        super.dj("");
        super.eD(0);
        super.ds("");
        super.eJ(0);
        super.eE(0);
        super.dl("");
        super.dm("");
        super.eF(0);
        super.eG(0);
        super.dn("");
        super.do("");
        super.eH(1);
        super.eC(0);
        super.eI(0);
        super.dp("");
        super.dq("");
        super.dr("");
        super.setSource(0);
        super.du("");
        super.dt("");
        super.ai(0);
        super.dk("");
        super.dv("");
        super.eK(0);
        super.dy("");
        super.dz("");
        super.dA("");
        super.dD("");
        this.versionCode = 0;
    }

    public static void a(a aVar) {
        gJe = aVar;
    }

    public static String fa(String str) {
        return gJe != null ? gJe.cE(str) : null;
    }

    public final int Ad() {
        int i = 32;
        if (this.field_conRemarkPYShort != null && !this.field_conRemarkPYShort.equals("")) {
            i = this.field_conRemarkPYShort.charAt(0);
        } else if (this.field_conRemarkPYFull != null && !this.field_conRemarkPYFull.equals("")) {
            i = this.field_conRemarkPYFull.charAt(0);
        } else if (super.vQ() != null && !super.vQ().equals("")) {
            i = super.vQ().charAt(0);
        } else if (super.vR() != null && !super.vR().equals("")) {
            i = super.vR().charAt(0);
        } else if (this.field_nickname != null && !this.field_nickname.equals("") && isLetter(this.field_nickname.charAt(0))) {
            i = this.field_nickname.charAt(0);
        } else if (!(this.field_username == null || this.field_username.equals("") || !isLetter(this.field_username.charAt(0)))) {
            i = this.field_username.charAt(0);
        }
        if (i >= 97 && i <= 122) {
            return (char) (i - 32);
        }
        if (i < 65 || i > 90) {
            return 123;
        }
        return i;
    }

    public final void Ae() {
        setType(0);
    }

    public final void Af() {
        setType(this.field_type | 4);
    }

    public final void Ag() {
        setType(this.field_type | 1);
    }

    public final void Ah() {
        x.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", this.field_username, Integer.valueOf(this.field_type), bh.cgy());
        setType(this.field_type & -2);
    }

    public final void Ai() {
        setType(this.field_type | 8);
    }

    public final void Aj() {
        setType(this.field_type & -9);
    }

    public final void Ak() {
        setType(this.field_type | SQLiteGlobal.journalSizeLimit);
    }

    public final void Al() {
        setType(this.field_type & -524289);
    }

    public final void Am() {
        setType(this.field_type | 2);
    }

    public final void An() {
        setType(this.field_type & -3);
    }

    public final void Ao() {
        setType(this.field_type & -2049);
    }

    public final void Ap() {
        setType(this.field_type | 32);
    }

    public final void Aq() {
        setType(this.field_type & -33);
    }

    public final void Ar() {
        setType(this.field_type | 64);
    }

    public final void As() {
        setType(this.field_type & -65);
    }

    public final void At() {
        setType(this.field_type | WXMediaMessage.TITLE_LENGTH_LIMIT);
    }

    public final void Au() {
        setType(this.field_type & -513);
    }

    public final void Av() {
        setType(this.field_type | 256);
    }

    public final void Aw() {
        setType(this.field_type & -257);
    }

    public static int Ax() {
        return 1;
    }

    public static int Ay() {
        return 8;
    }

    public static int Az() {
        return SQLiteGlobal.journalSizeLimit;
    }

    public static int AA() {
        return 16;
    }

    public static int AB() {
        return 32;
    }

    public final boolean AC() {
        return fZ(this.field_type);
    }

    public static boolean fZ(int i) {
        if ((i & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean AD() {
        if ((this.field_type & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isHidden() {
        return (this.field_type & 32) != 0;
    }

    public final boolean AE() {
        return (this.field_type & 4) != 0;
    }

    public final boolean AF() {
        return (this.field_type & 8) != 0;
    }

    public final boolean AG() {
        return (SQLiteGlobal.journalSizeLimit & this.field_type) != 0;
    }

    public final boolean AH() {
        return (this.field_type & 64) != 0;
    }

    public final boolean AI() {
        return (this.field_type & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0;
    }

    public final boolean AJ() {
        return (this.field_type & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0;
    }

    public final boolean AK() {
        return (this.field_type & 256) != 0;
    }

    public final boolean AL() {
        return (this.field_type & 2048) != 0;
    }

    public final boolean AM() {
        return (WXMediaMessage.THUMB_LENGTH_LIMIT & this.field_type) != 0;
    }

    public final void AN() {
        setType(this.field_type | WXMediaMessage.THUMB_LENGTH_LIMIT);
    }

    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public final int AO() {
        return (int) this.gJd;
    }

    public final String vQ() {
        return (super.vQ() == null || super.vQ().length() < 0) ? vR() : super.vQ();
    }

    public final String vR() {
        return (super.vR() == null || super.vR().length() < 0) ? this.field_nickname : super.vR();
    }

    public final String vN() {
        String cF = gJe != null ? gJe.cF(this.field_username) : null;
        return cF == null ? super.vN() : cF;
    }

    public final String AP() {
        String cE = gJe != null ? gJe.cE(this.field_username) : null;
        if (cE != null) {
            return cE;
        }
        if (this.field_nickname == null || this.field_nickname.length() <= 0) {
            return AR();
        }
        return this.field_nickname;
    }

    public final String AQ() {
        if (this.field_conRemark == null || this.field_conRemark.trim().equals("")) {
            return AP();
        }
        return this.field_conRemark;
    }

    public final String AR() {
        String vN = vN();
        if (!bh.ov(vN)) {
            return vN;
        }
        vN = fb(this.field_username);
        return (vN == null || vN.length() == 0) ? this.field_username : vN;
    }

    public final int getSource() {
        return super.getSource() % Constants.MAX_BUFFER_SIZE;
    }

    public final int AS() {
        return super.getSource();
    }

    public static String fb(String str) {
        if (str == null) {
            return null;
        }
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            return "@" + str.replace("@t.qq.com", "");
        }
        if (!str.toLowerCase().endsWith("@qqim")) {
            return str;
        }
        str = str.replace("@qqim", "");
        long longValue = Long.valueOf(str).longValue();
        if (longValue < 0) {
            return new o(longValue).toString();
        }
        return str;
    }

    public final void ga(int i) {
        eA((this.field_chatroomFlag & -2) | (i & 1));
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.gJd = this.xjy;
        super.z(null);
    }

    private int AT() {
        int i = this.versionCode + 1;
        this.versionCode = i;
        return i;
    }

    public final void setUsername(String str) {
        if (!bh.fu(this.field_username, str)) {
            super.setUsername(str);
            AT();
        }
    }

    public final void cZ(String str) {
        if (!bh.fu(vN(), str)) {
            super.cZ(str);
            AT();
        }
    }

    public final void da(String str) {
        if (!bh.fu(this.field_conRemark, str)) {
            super.da(str);
            AT();
        }
    }

    public final void db(String str) {
        if (!bh.fu(this.field_domainList, str)) {
            super.db(str);
            AT();
        }
    }

    public final void dc(String str) {
        if (!bh.fu(this.field_nickname, str)) {
            super.dc(str);
            AT();
        }
    }

    public final void dd(String str) {
        if (!bh.fu(vQ(), str)) {
            super.dd(str);
            AT();
        }
    }

    public final void de(String str) {
        if (!bh.fu(vR(), str)) {
            super.de(str);
            AT();
        }
    }

    public final void ex(int i) {
        if (!bh.eG(this.field_showHead, i)) {
            super.ex(i);
            AT();
        }
    }

    public final void setType(int i) {
        if (!bh.eG(this.field_type, i)) {
            super.setType(i);
            AT();
        }
    }

    public final void ey(int i) {
        if (!bh.eG(this.field_weiboFlag, i)) {
            super.ey(i);
            AT();
        }
    }

    public final void df(String str) {
        if (!bh.fu(this.field_weiboNickname, str)) {
            super.df(str);
            AT();
        }
    }

    public final void dg(String str) {
        if (!bh.fu(this.field_conRemarkPYFull, str)) {
            super.dg(str);
            AT();
        }
    }

    public final void dh(String str) {
        if (!bh.fu(this.field_conRemarkPYShort, str)) {
            super.dh(str);
            AT();
        }
    }

    public final void z(byte[] bArr) {
        if (!bh.isEqual(this.field_lvbuff, bArr)) {
            super.z(bArr);
            AT();
        }
    }

    public final void ez(int i) {
        if (!bh.eG(this.field_verifyFlag, i)) {
            super.ez(i);
            AT();
        }
    }

    public final void di(String str) {
        if (!bh.fu(this.field_encryptUsername, str)) {
            super.di(str);
            AT();
        }
    }

    public final void eA(int i) {
        if (!bh.eG(this.field_chatroomFlag, i)) {
            super.eA(i);
            AT();
        }
    }

    public final void eB(int i) {
        if (!bh.eG(this.field_deleteFlag, i)) {
            super.eB(i);
            AT();
        }
    }

    public final void dj(String str) {
        if (!bh.fu(this.field_contactLabelIds, str)) {
            super.dj(str);
            AT();
        }
    }

    public final void eC(int i) {
        if (!bh.eG(this.fWe, i)) {
            super.eC(i);
            AT();
        }
    }

    public final void eD(int i) {
        if (!bh.eG(this.fWf, i)) {
            super.eD(i);
            AT();
        }
    }

    public final void dk(String str) {
        if (!bh.fu(this.fWg, str)) {
            super.dk(str);
            AT();
        }
    }

    public final void ai(long j) {
        if (!bh.K(this.fWh, j)) {
            super.ai(j);
            AT();
        }
    }

    public final void eE(int i) {
        if (!bh.eG(this.uin, i)) {
            super.eE(i);
            AT();
        }
    }

    public final void dl(String str) {
        if (!bh.fu(this.fWi, str)) {
            super.dl(str);
            AT();
        }
    }

    public final void dm(String str) {
        if (!bh.fu(this.fAf, str)) {
            super.dm(str);
            AT();
        }
    }

    public final void eF(int i) {
        if (!bh.eG(this.fWj, i)) {
            super.eF(i);
            AT();
        }
    }

    public final void eG(int i) {
        if (!bh.eG(this.fWk, i)) {
            super.eG(i);
            AT();
        }
    }

    public final void dn(String str) {
        if (!bh.fu(this.fWl, str)) {
            super.dn(str);
            AT();
        }
    }

    public final void do(String str) {
        if (!bh.fu(this.fWm, str)) {
            super.do(str);
            AT();
        }
    }

    public final void eH(int i) {
        if (!bh.eG(this.fWn, i)) {
            super.eH(i);
            AT();
        }
    }

    public final void eI(int i) {
        if (!bh.eG(this.fWo, i)) {
            super.eI(i);
            AT();
        }
    }

    public final void dp(String str) {
        if (!bh.fu(this.signature, str)) {
            super.dp(str);
            AT();
        }
    }

    public void dq(String str) {
        if (!bh.fu(getProvince(), str)) {
            super.dq(str);
            AT();
        }
    }

    public void dr(String str) {
        if (!bh.fu(getCity(), str)) {
            super.dr(str);
            AT();
        }
    }

    public final void ds(String str) {
        if (!bh.fu(this.fWr, str)) {
            super.ds(str);
            AT();
        }
    }

    public final void eJ(int i) {
        if (!bh.eG(this.fWs, i)) {
            super.eJ(i);
            AT();
        }
    }

    public final void setSource(int i) {
        if (!bh.eG(super.getSource(), i)) {
            super.setSource(i);
            AT();
        }
    }

    public final void dt(String str) {
        if (!bh.fu(this.fWt, str)) {
            super.dt(str);
            AT();
        }
    }

    public final void du(String str) {
        if (!bh.fu(this.fWu, str)) {
            super.du(str);
            AT();
        }
    }

    public void dv(String str) {
        if (!bh.fu(this.fWv, str)) {
            super.dv(str);
            AT();
        }
    }

    public final void eK(int i) {
        if (!bh.eG(this.fWw, i)) {
            super.eK(i);
            AT();
        }
    }

    public final void eL(int i) {
        if (!bh.eG(this.fWx, i)) {
            super.eL(i);
            AT();
        }
    }

    public final void dw(String str) {
        if (!bh.fu(this.fWy, str)) {
            super.dw(str);
            AT();
        }
    }

    public final void dx(String str) {
        if (!bh.fu(this.fWz, str)) {
            super.dx(str);
            AT();
        }
    }

    public final void dy(String str) {
        if (!bh.fu(this.fWA, str)) {
            super.dy(str);
            AT();
        }
    }

    public final void dz(String str) {
        if (!bh.fu(this.fWB, str)) {
            super.dz(str);
            AT();
        }
    }

    public final void dA(String str) {
        if (!bh.fu(this.fWC, str)) {
            super.dA(str);
            AT();
        }
    }

    public final void dB(String str) {
        if (!bh.fu(this.fWD, str)) {
            super.dB(str);
            AT();
        }
    }

    public final void dC(String str) {
        if (!bh.fu(this.fWE, str)) {
            super.dC(str);
            AT();
        }
    }

    public final void dD(String str) {
        if (!bh.fu(this.fWF, str)) {
            super.dD(str);
            AT();
        }
    }
}

package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.g.a.px;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.FileUtils;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class n extends i<m> implements g {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS serverSnsNameIndex ON SnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverSnsTimeHeadIndex ON SnsInfo ( head )", "DROP INDEX IF EXISTS serverSnsTimeIndex", "DROP INDEX IF EXISTS serverSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS snsMultiIndex1 ON SnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS snsMultiIndex2 ON SnsInfo ( sourceType,type,userName)", "CREATE INDEX IF NOT EXISTS snsLocalflagIndex ON SnsInfo ( localFlag )"};
    public static final String[] gJN = new String[]{i.a(m.gJc, "SnsInfo")};
    private static String[] roX = new String[]{"snsId", "userName", "localFlag", "createTime", "head", "localPrivate", DownloadSettingTable$Columns.TYPE, "sourceType", "likeFlag", "pravited", "stringSeq", "content", "attrBuf", "postBuf", "rowid"};
    public static String roY;
    public static String roZ = " order by SnsInfo.createTime desc ,snsId desc";
    public static String rpa = " order by SnsInfo.createTime asc ,snsId asc";
    private static String rpb = " order by SnsInfo.createTime asc ,snsId asc";
    private static String rpc = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
    private static String rpd = " order by SnsInfo.head desc ,snsId desc";
    public static String rpe;
    public static String rpf;
    protected static String rpg;
    protected static String rph = " (sourceType & 2 != 0 ) and type < 21";
    private static String rpi;
    private static String rpj;
    private static String rpk;
    private static ArrayList<Integer> rpl = bQ(Arrays.asList(new Integer[]{Integer.valueOf(16), Integer.valueOf(32), Integer.valueOf(2), Integer.valueOf(8), Integer.valueOf(64), Integer.valueOf(FileUtils.S_IWUSR)}));
    private static ArrayList<Integer> rpm = bQ(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8)}));
    public e gJP;
    private boolean roV;
    private int roW;

    public final /* synthetic */ boolean a(long j, c cVar) {
        return b(j, (m) cVar);
    }

    public final /* synthetic */ boolean a(c cVar) {
        return z((m) cVar);
    }

    static {
        int i;
        roY = "";
        rpe = null;
        rpf = null;
        rpg = " (sourceType & 2 != 0 ) ";
        rpi = null;
        rpj = null;
        rpk = null;
        roY = "select ";
        for (i = 0; i < roX.length; i++) {
            if (i < roX.length - 1) {
                roY += " " + roX[i] + ",";
            } else {
                roY += " " + roX[i] + " ";
            }
        }
        x.i("MicroMsg.SnsInfoStorage", "TIMELINE_SELECT_BEGIN " + roY);
        List arrayList = new ArrayList();
        Iterator it = rpl.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 16) != 0 && (i & 32) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rpe = h(arrayList, "localFlag");
        x.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{rpe});
        arrayList.clear();
        it = rpl.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 32) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rpf = h(arrayList, "localFlag");
        x.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{rpf});
        arrayList.clear();
        it = rpl.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 64) == 0 && (i & 32) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rpk = h(arrayList, "localFlag");
        arrayList.clear();
        it = rpm.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 8) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rpj = h(arrayList, "sourceType");
        x.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{rpj});
        arrayList.clear();
        it = rpm.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 2) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rpg = h(arrayList, "sourceType");
        x.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{rpg});
        arrayList.clear();
        it = rpm.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 4) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rpi = h(arrayList, "sourceType");
        x.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{rpi});
    }

    private static boolean byF() {
        b pxVar = new px();
        a.xef.m(pxVar);
        return pxVar.fHD.fHE;
    }

    public static String byG() {
        if (byF()) {
            return " (sourceType & 2 != 0 ) and type < 21";
        }
        return " (sourceType & 2 != 0 ) ";
    }

    private static String h(List<Integer> list, String str) {
        StringBuilder stringBuilder = new StringBuilder("(");
        stringBuilder.append(str + " in (");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuilder.append(it.next());
            if (it.hasNext()) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private static ArrayList<Integer> bQ(List<Integer> list) {
        ArrayList arrayList = new ArrayList(list);
        Collection hashSet = new HashSet();
        ArrayList<Integer> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Collection arrayList3 = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Integer.valueOf(((Integer) it2.next()).intValue() | num.intValue()));
            }
            hashSet.addAll(new HashSet(arrayList3));
            hashSet.add(num);
        }
        hashSet.add(Integer.valueOf(0));
        arrayList2.addAll(hashSet);
        return arrayList2;
    }

    public n(e eVar) {
        boolean z;
        boolean z2 = true;
        super(eVar, m.gJc, "SnsInfo", fMK);
        this.gJP = eVar;
        Cursor a = this.gJP.a("select count(*) from SnsInfo where snsId > 0;", null, 2);
        if (!a.moveToFirst() || a.getInt(0) <= 0) {
            a.close();
            z = false;
        } else {
            x.i("MicroMsg.SnsInfoStorage", "exsits snsId > 0  ,count is %d", new Object[]{Integer.valueOf(a.getInt(0))});
            a.close();
            z = true;
        }
        if (z) {
            z2 = false;
        }
        this.roV = z2;
        this.roW = 0;
        if (this.roV) {
            x.i("MicroMsg.SnsInfoStorage", "all sndId < 0 ,so optimalizeForSnsId");
            return;
        }
        roZ = " order by SnsInfo.createTime desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
        rpa = " order by SnsInfo.createTime asc ,case when snsId < 0 then 0 else 1 end ,  snsId asc";
        rpc = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
        rpd = " order by SnsInfo.head desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
    }

    public final int y(m mVar) {
        x.d("MicroMsg.SnsInfoStorage", "SnsInfo Insert");
        if (mVar == null) {
            return -1;
        }
        int insert = (int) this.gJP.insert("SnsInfo", "", mVar.vI());
        x.d("MicroMsg.SnsInfoStorage", "SnsInfo Insert result " + insert);
        return insert;
    }

    public final void a(String str, boolean z, String str2) {
        String str3 = aG(str, z) + " AND  (snsId != 0  ) ";
        if (Lu(str2)) {
            str3 = str3 + " AND " + Ly(str2);
        }
        i(z, str3);
    }

    public final void i(boolean z, String str) {
        String str2 = "UPDATE SnsInfo SET sourceType = sourceType & " + ((z ? 4 : 8) ^ -1) + str;
        x.d("MicroMsg.SnsInfoStorage", "updateFilterUserName sql " + str2);
        this.gJP.fx("SnsInfo", str2);
    }

    public final void byH() {
        Lt(" where " + byG() + " AND  (snsId != 0  ) ");
    }

    public final void Lr(String str) {
        if (Lu(str)) {
            Lt(" where " + Ly(str) + " and " + byG() + " and  (snsId != 0  ) ");
        }
    }

    public final void Ls(String str) {
        if (Lu(str)) {
            Lt(" where " + Lx(str) + " and " + byG() + " and  (snsId != 0  ) ");
        }
    }

    private void Lt(String str) {
        String str2 = "UPDATE SnsInfo SET sourceType = sourceType & -3" + str;
        x.d("MicroMsg.SnsInfoStorage", "updateFilterTimeLine sql " + str2);
        this.gJP.fx("SnsInfo", str2);
    }

    public final boolean eL(long j) {
        Cursor rawQuery = this.gJP.rawQuery("select *,rowid from SnsInfo  where SnsInfo.snsId=" + j, null);
        int count = rawQuery.getCount();
        rawQuery.close();
        return count > 0;
    }

    public final boolean a(long j, m mVar) {
        if (eL(j)) {
            return b(j, mVar);
        }
        return y(mVar) != -1;
    }

    public static boolean Lu(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return true;
    }

    public final String Lv(String str) {
        if (str == null || str.equals("")) {
            return " ";
        }
        if (this.roV) {
            return " (snsId >= " + Lw(bh.ot(str)) + " ) ";
        }
        return " (stringSeq >=\"" + bh.ot(str) + "\"  ) ";
    }

    private static long Lw(String str) {
        x.i("MicroMsg.SnsInfoStorage", "seq %s to snsId %d ", new Object[]{str, Long.valueOf(new BigInteger(str).longValue())});
        return new BigInteger(str).longValue();
    }

    public final String Lx(String str) {
        if (str == null || str.equals("")) {
            return " ";
        }
        if (this.roV) {
            return " (snsId > " + Lw(bh.ot(str)) + " ) ";
        }
        return " (stringSeq >\"" + bh.ot(str) + "\"  ) ";
    }

    public final String Ly(String str) {
        if (str == null || str.equals("")) {
            return " ";
        }
        if (this.roV) {
            return " (snsId < " + Lw(bh.ot(str)) + " ) ";
        }
        return " (stringSeq <\"" + bh.ot(str) + "\"  ) ";
    }

    public static String aG(String str, boolean z) {
        String str2 = "";
        if (z) {
            return str2 + " WHERE " + rpi;
        }
        return (str2 + " WHERE SnsInfo.userName=\"" + bh.ot(str) + "\"") + " AND " + rpj;
    }

    public static String d(boolean z, String str, boolean z2) {
        return ("select *,rowid from SnsInfo " + aG(str, z2)) + " AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26)";
    }

    public final long d(long j, int i, boolean z) {
        return c(byJ(), j, i, z);
    }

    public final long a(long j, int i, String str, boolean z) {
        return c(d(false, str, z), j, i, false);
    }

    private long c(String str, long j, int i, boolean z) {
        String str2;
        if (j != 0) {
            str2 = str + " AND SnsInfo.stringSeq < '" + com.tencent.mm.plugin.sns.data.i.JN(com.tencent.mm.plugin.sns.data.i.eq(j)) + "'";
        } else {
            str2 = str;
        }
        if (z) {
            str2 = str2 + " AND  (snsId != 0 ) ";
        }
        Cursor rawQuery = this.gJP.rawQuery((str2 + roZ) + " limit " + i, null);
        if (rawQuery.moveToLast()) {
            m mVar = new m();
            mVar.b(rawQuery);
            rawQuery.close();
            return mVar.field_snsId;
        }
        rawQuery.close();
        return 0;
    }

    public static String byI() {
        return "select *,rowid from SnsInfo  where " + " (sourceType & 2 != 0 ) ";
    }

    public static String byJ() {
        return "select *,rowid from SnsInfo  where " + byG();
    }

    public static String byK() {
        return "select *,rowid from SnsInfo  where " + (byF() ? rph : rpg);
    }

    public static String xn(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo  where ").append(byG()).append(" limit 3");
        return stringBuilder.toString();
    }

    public final Cursor a(boolean z, String str, int i, boolean z2, String str2) {
        String d = d(z, str, z2);
        if (Lu(str2)) {
            d = d + " AND " + Lv(str2);
        }
        if (z2) {
            d = d + rpc;
        } else {
            d = d + rpd;
        }
        if (i > 0) {
            d = d + " LIMIT " + i;
        }
        x.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery " + d);
        return this.gJP.rawQuery(d, null);
    }

    public final Cursor JA(String str) {
        String byJ = byJ();
        if (Lu(str)) {
            byJ = byJ + " AND " + Lv(str);
        }
        byJ = byJ + roZ;
        x.d("MicroMsg.SnsInfoStorage", "getCursorForTimeLine " + byJ);
        return this.gJP.rawQuery(byJ, null);
    }

    public final List<m> aH(String str, boolean z) {
        Cursor a = this.gJP.a("select *,rowid from SnsInfo " + aG(str, z) + " AND type = 4", null, 2);
        List<m> arrayList = new ArrayList();
        while (a.moveToNext()) {
            m mVar = new m();
            mVar.b(a);
            arrayList.add(mVar);
        }
        a.close();
        return arrayList;
    }

    public final int Lz(String str) {
        String byJ = byJ();
        if (Lu(str)) {
            byJ = byJ + " AND " + Lv(str);
        }
        String str2 = (byJ + " AND  (snsId != 0 ) ") + rpa + " limit 1";
        Cursor a = this.gJP.a(str2, null, 2);
        int i = 0;
        if (a.moveToFirst()) {
            m mVar = new m();
            mVar.b(a);
            i = mVar.field_createTime;
        }
        a.close();
        x.i("MicroMsg.SnsInfoStorage", "getLastTime " + str2 + " createtime " + i);
        return i;
    }

    public final Cursor cg(String str, int i) {
        String str2 = (roY + " from SnsInfo where ") + byG();
        if (Lu(str)) {
            str2 = str2 + " AND " + Lv(str);
        }
        str2 = (((str2 + " AND createTime >= " + i) + " UNION ") + roY + " from AdSnsInfo where createTime" + " > " + i) + roZ;
        x.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str2 + " limtiSeq: " + str);
        return this.gJP.rawQuery(str2, null);
    }

    public final void em(long j) {
        int i;
        ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putLong("check_trim_time", 0).commit();
        h EV = ae.EV();
        long dz = EV.dz(Thread.currentThread().getId());
        for (i = 0; ((long) i) < j; i++) {
            EV.fx("SnsInfo", "INSERT INTO SnsInfo VALUES(-69999999991777434909,'miaochanchan',2,1402026897,20140606,0,2,2,0,0,'0',X'0A143131373631303534303431393332313136373037120C6D69616F6368616E6368616E18002091F7C49C052A36E8A681E6849FE8B0A2E8BF99E4BBBDE5B7A5EFBC8CE8AEA9E68891E4B88DE4BC9AE69C89E5A29EE882A5E79A84E8BFB9E8B1A1E3808232180D0000000015000000001A0022002A0032003800480050003A0A0A0012001A0022002A0042080A0010021A0022004A0052005A006000680272007A2408001200180022002A0032003A080A0012001A00220042004A040800100052040A001200',X'08E3E5A48CEA8AEA9BA301120C6D69616F6368616E6368616E1A09E88B97E7B1B3E7B1B32091F7C49C052A04080012003000380040005000580068007000800101880100900100A00101B00100B80100',NULL);");
        }
        for (i = 0; ((long) i) < 20000; i++) {
            EV.fx("snsExtInfo3", String.format("INSERT INTO snsExtInfo3 VALUES('zeustest%d','afd',2,1402026897,'d', 0,1, 1, 1, 1, 'a', 'a', NULL);", new Object[]{Integer.valueOf(i)}));
        }
        for (i = 0; ((long) i) < 20000; i++) {
            EV.fx("snsComment", String.format("INSERT INTO snsComment VALUES(-69999999991777434909,0,2,1402026897,'d', 2,1, 'a', 'b', 1, NULL);", new Object[0]));
        }
        EV.fS(dz);
    }

    public final ArrayList<Long> buh() {
        ArrayList<Long> arrayList = new ArrayList();
        Cursor a = this.gJP.a("SnsInfo", new String[]{"*", "rowid"}, "createTime >=? AND " + rpk, new String[]{String.valueOf(((int) (System.currentTimeMillis() / 1000)) - 172800)}, null, null, "createTime ASC", 2);
        while (a.moveToNext()) {
            try {
                m mVar = new m();
                mVar.b(a);
                if (mVar.roJ != -1 && mVar.field_userName.equals(q.FS())) {
                    arrayList.add(Long.valueOf((long) mVar.roJ));
                    x.d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, add snsInfo: " + mVar.byq());
                }
            } finally {
                a.close();
            }
        }
        x.d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, resendList.size:%d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }

    public final boolean ws(int i) {
        return xo(i) != null;
    }

    public final boolean z(m mVar) {
        if (mVar.xl(32)) {
            return ae.bvy().a(mVar.byB());
        }
        boolean z = this.gJP.replace("SnsInfo", "", mVar.vI()) > 0;
        x.d("MicroMsg.SnsInfoStorage", "SnsInfo replace result " + z);
        return z;
    }

    public final m eR(long j) {
        m mVar = new m();
        Cursor a = this.gJP.a("select *,rowid from SnsInfo  where SnsInfo.snsId=" + j + " limit 1", null, 2);
        if (a.moveToFirst()) {
            mVar.b(a);
            a.close();
            return mVar;
        }
        a.close();
        return null;
    }

    public final m Ll(String str) {
        if (u.Jv(str)) {
            return eR(u.LF(str));
        }
        e eK = ae.bvy().eK(u.LF(str));
        if (eK != null) {
            return eK.bxX();
        }
        return null;
    }

    public final m xo(int i) {
        m mVar = new m();
        Cursor a = this.gJP.a("select *,rowid from SnsInfo  where SnsInfo.rowid=" + i, null, 2);
        if (a.moveToFirst()) {
            mVar.b(a);
            a.close();
            return mVar;
        }
        a.close();
        return null;
    }

    public final m Lm(String str) {
        if (u.Jv(str)) {
            return xo(u.LG(str));
        }
        e xk = ae.bvy().xk(u.LG(str));
        if (xk != null) {
            return xk.bxX();
        }
        return null;
    }

    public final boolean b(long j, m mVar) {
        ContentValues vI = mVar.vI();
        vI.remove("rowid");
        if (this.gJP.update("SnsInfo", vI, "snsId=?", new String[]{String.valueOf(j)}) > 0) {
            return true;
        }
        return false;
    }

    public final int b(int i, m mVar) {
        ContentValues vI = mVar.vI();
        vI.remove("rowid");
        return this.gJP.update("SnsInfo", vI, "rowid=?", new String[]{String.valueOf(i)});
    }

    public final boolean delete(long j) {
        int delete = this.gJP.delete("SnsInfo", "snsId=?", new String[]{String.valueOf(j)});
        x.d("MicroMsg.SnsInfoStorage", "del msg " + j + " res " + delete);
        if (delete > 0) {
            return true;
        }
        return false;
    }

    public final boolean xp(int i) {
        if (this.gJP.delete("SnsInfo", "rowid=?", new String[]{String.valueOf(i)}) > 0) {
            return true;
        }
        return false;
    }

    public final int en(long j) {
        m eR = ae.bvv().eR(j);
        return eR == null ? 0 : eR.byC();
    }

    public final int JB(String str) {
        m Ll = ae.bvv().Ll(str);
        return Ll == null ? 0 : Ll.byC();
    }
}

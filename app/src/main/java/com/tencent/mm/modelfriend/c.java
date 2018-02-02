package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.by.h;
import com.tencent.mm.pluginsdk.q.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class c extends m implements b {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS addr_upload2 ( id int  PRIMARY KEY , md5 text  , peopleid text  , uploadtime long  , realname text  , realnamepyinitial text  , realnamequanpin text  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , type int  , moblie text  , email text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int , lvbuf BLOG , showhead int  ) ", "CREATE INDEX IF NOT EXISTS upload_time_index ON addr_upload2 ( uploadtime ) ", "CREATE INDEX IF NOT EXISTS addr_upload_user_index ON addr_upload2 ( username ) "};
    public final h hhp;

    public c(h hVar) {
        Object obj = null;
        this.hhp = hVar;
        String str = "addr_upload2";
        Cursor a = hVar.a("PRAGMA table_info( " + str + " )", null, 2);
        int columnIndex = a.getColumnIndex("name");
        Object obj2 = null;
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("lvbuf".equalsIgnoreCase(string)) {
                    obj2 = 1;
                } else if ("showhead".equalsIgnoreCase(string)) {
                    obj = 1;
                }
            }
        }
        a.close();
        if (obj2 == null) {
            hVar.fx(str, "Alter table " + str + " add lvbuf BLOB ");
        }
        if (obj == null) {
            hVar.fx(str, "Alter table " + str + " add showhead int ");
        }
    }

    public final boolean I(List<String> list) {
        if (list.size() <= 0) {
            return false;
        }
        boolean z;
        bf bfVar = new bf("MicroMsg.AddrUploadStorage", "delete transaction");
        bfVar.addSplit("begin");
        long dz = this.hhp.dz(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    int delete = this.hhp.delete("addr_upload2", "id =?", new String[]{b.kP(str)});
                    x.d("MicroMsg.AddrUploadStorage", "delete addr_upload2 md5 :" + str + ", res:" + delete);
                    if (delete > 0) {
                        b(5, this, str);
                    }
                }
            }
            z = true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AddrUploadStorage", e, "", new Object[0]);
            z = false;
        }
        this.hhp.fS(dz);
        bfVar.addSplit("end");
        bfVar.dumpToLog();
        return z;
    }

    public final boolean H(List<b> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        boolean z;
        bf bfVar = new bf("MicroMsg.AddrUploadStorage", "transaction");
        bfVar.addSplit("transation begin");
        long dz = this.hhp.dz(Thread.currentThread().getId());
        for (int i = 0; i < list.size(); i++) {
            b bVar = (b) list.get(i);
            if (bVar != null) {
                boolean z2;
                Cursor a = this.hhp.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where addr_upload2.id = \"" + b.kP(bVar.Nr()) + "\"", null, 2);
                if (a == null) {
                    z2 = false;
                } else {
                    try {
                        z2 = a.moveToFirst();
                        a.close();
                    } catch (Exception e) {
                        x.e("MicroMsg.AddrUploadStorage", e.getMessage());
                        z = false;
                    }
                }
                if (z2) {
                    int kP = b.kP(bVar.Nr());
                    ContentValues vI = bVar.vI();
                    int i2 = 0;
                    if (vI.size() > 0) {
                        i2 = this.hhp.update("addr_upload2", vI, "id=?", new String[]{String.valueOf(kP)});
                    }
                    if (i2 == 0) {
                        x.i("MicroMsg.AddrUploadStorage", "batchSet update result=0, num:%s email:%s", new Object[]{bVar.Nz(), bVar.NA()});
                    } else if (i2 < 0) {
                        x.i("MicroMsg.AddrUploadStorage", "batchSet update failed, num:%s email:%s", new Object[]{bVar.Nz(), bVar.NA()});
                        z = true;
                        break;
                    } else {
                        b(3, this, bVar.Nr());
                    }
                } else {
                    bVar.fDt = -1;
                    if (((int) this.hhp.insert("addr_upload2", SlookAirButtonFrequentContactAdapter.ID, bVar.vI())) == -1) {
                        x.i("MicroMsg.AddrUploadStorage", "batchSet insert failed, num:%s email:%s", new Object[]{bVar.Nz(), bVar.NA()});
                        z = true;
                        break;
                    }
                    b(2, this, bVar.Nr());
                }
            }
        }
        z = true;
        this.hhp.fS(dz);
        bfVar.addSplit("transation end");
        bfVar.dumpToLog();
        return z;
    }

    public final boolean J(List<String> list) {
        boolean z;
        bf bfVar = new bf("MicroMsg.AddrUploadStorage", "set uploaded transaction");
        bfVar.addSplit("transation begin");
        long dz = this.hhp.dz(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    b bVar = new b();
                    bVar.fDt = 8;
                    bVar.hvj = bh.Wo();
                    ContentValues vI = bVar.vI();
                    int i = 0;
                    if (vI.size() > 0) {
                        i = this.hhp.update("addr_upload2", vI, "id=?", new String[]{b.kP(str)});
                    }
                    x.i("MicroMsg.AddrUploadStorage", "local contact uploaded : " + str + ", update result: " + i);
                }
            }
            z = true;
        } catch (Exception e) {
            x.e("MicroMsg.AddrUploadStorage", e.getMessage());
            z = false;
        }
        this.hhp.fS(dz);
        bfVar.addSplit("transation end");
        bfVar.dumpToLog();
        if (z) {
            b(3, this, null);
        }
        return z;
    }

    public final int a(String str, b bVar) {
        int i = 0;
        ContentValues vI = bVar.vI();
        if (vI.size() > 0) {
            i = this.hhp.update("addr_upload2", vI, "id=?", new String[]{b.kP(str)});
        }
        if (i > 0) {
            if (bVar.Nr().equals(str)) {
                b(3, this, str);
            } else {
                b(5, this, str);
                b(2, this, bVar.Nr());
            }
        }
        return i;
    }

    public final b kR(String str) {
        if (bh.ov(str)) {
            return null;
        }
        b bVar = new b();
        Cursor a = this.hhp.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.username=\"" + bh.ot(str) + "\"", null, 2);
        x.d("MicroMsg.AddrUploadStorage", "get addrUpload :" + str);
        if (a.moveToFirst()) {
            bVar.b(a);
        }
        a.close();
        return bVar;
    }

    public final b bd(long j) {
        b bVar = new b();
        Cursor a = this.hhp.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + Long.toString(j) + ';', null, 2);
        if (a.moveToFirst()) {
            bVar.b(a);
        }
        a.close();
        return bVar;
    }

    public final b kS(String str) {
        b bVar = null;
        if (str != null && str.length() > 0) {
            Cursor a = this.hhp.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.id=\"" + b.kP(str) + "\"", null, 2);
            if (a.moveToFirst()) {
                bVar = new b();
                bVar.b(a);
            }
            x.d("MicroMsg.AddrUploadStorage", "get addrUpload :" + str + ", resCnt:" + (bVar != null ? 1 : 0));
            a.close();
        }
        return bVar;
    }

    public final List<String[]> ND() {
        Cursor a = this.hhp.a("select addr_upload2.moblie , addr_upload2.md5 from addr_upload2 where addr_upload2.type = 0", null, 2);
        List<String[]> arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(new String[]{a.getString(0), a.getString(1)});
        }
        a.close();
        return arrayList;
    }

    public final List<b> kT(String str) {
        x.d("MicroMsg.AddrUploadStorage", "sql : " + str);
        List<b> arrayList = new ArrayList();
        x.d("MicroMsg.AddrUploadStorage", "sql : " + str);
        Cursor a = this.hhp.a(str, null, 2);
        while (a.moveToNext()) {
            b bVar = new b();
            bVar.b(a);
            arrayList.add(bVar);
        }
        a.close();
        return arrayList;
    }

    protected final boolean NE() {
        if (this.hhp != null && !this.hhp.cgM()) {
            return true;
        }
        String str = "MicroMsg.AddrUploadStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.hhp == null ? "null" : Boolean.valueOf(this.hhp.cgM());
        x.w(str, str2, objArr);
        return false;
    }

    public final String kU(String str) {
        b kS = kS(str);
        if (kS != null) {
            return kS.getUsername();
        }
        return null;
    }

    public final String kV(String str) {
        Exception e;
        Throwable th;
        if (!bh.ov(str)) {
            Cursor a;
            try {
                a = this.hhp.a("addr_upload2", null, "peopleid=?", new String[]{str}, null, null, null, 2);
                try {
                    if (a.moveToFirst()) {
                        b bVar = new b();
                        bVar.b(a);
                        String username = bVar.getUsername();
                        if (a == null) {
                            return username;
                        }
                        a.close();
                        return username;
                    } else if (a != null) {
                        a.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.AddrUploadStorage", "getFriendUsernameBySystemAddrBookPeopleId, error:%s", new Object[]{e.getMessage()});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                a = null;
                x.e("MicroMsg.AddrUploadStorage", "getFriendUsernameBySystemAddrBookPeopleId, error:%s", new Object[]{e.getMessage()});
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                a = null;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }
        return null;
    }
}

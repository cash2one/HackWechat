package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class at extends m {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS  MediaDuplication  (md5 text , size int , path text , createtime long, remuxing text, duration int, status int);", "DROP INDEX IF EXISTS MediaDuplicationMD5Index ", "CREATE INDEX IF NOT EXISTS MD5Index ON MediaDuplication ( md5 )"};
    public e gJP;

    protected final boolean NE() {
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public at(h hVar) {
        Cursor a;
        int i;
        Throwable e;
        long j;
        Cursor a2;
        Cursor cursor = null;
        this.gJP = hVar;
        String str = "MediaDuplication";
        try {
            a = this.gJP.a("PRAGMA table_info( " + str + " )", null, 2);
            try {
                int columnIndex = a.getColumnIndex("name");
                i = 0;
                int i2 = 0;
                int i3 = 0;
                while (a.moveToNext()) {
                    if (columnIndex >= 0) {
                        String string = a.getString(columnIndex);
                        if ("remuxing".equalsIgnoreCase(string)) {
                            i3 = 1;
                        } else if (FFmpegMetadataRetriever.METADATA_KEY_DURATION.equalsIgnoreCase(string)) {
                            i2 = 1;
                        } else if (DownloadInfo.STATUS.equalsIgnoreCase(string)) {
                            i = 1;
                        }
                    }
                }
                a.close();
                long dz = g.Dj().gQj.dz(Thread.currentThread().getId());
                if (i3 == 0) {
                    x.i("MicroMsg.MediaCheckDuplicationStorage", "it had no [remuxing] column, alter table now");
                    this.gJP.fx(str, "alter table MediaDuplication add remuxing text ");
                }
                if (i2 == 0) {
                    x.i("MicroMsg.MediaCheckDuplicationStorage", "it had no [duration] column, alter table now");
                    this.gJP.fx(str, "alter table MediaDuplication add duration int ");
                }
                if (i == 0) {
                    x.i("MicroMsg.MediaCheckDuplicationStorage", "it had no [status] column, alter table now");
                    this.gJP.fx(str, "alter table MediaDuplication add status int ");
                }
                if (dz > 0) {
                    g.Dj().gQj.fS(dz);
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e, "", new Object[0]);
                    x.e("MicroMsg.MediaCheckDuplicationStorage", "tryAddDBCol error: " + e.toString());
                    if (a != null) {
                        a.close();
                    }
                    str = "MediaDuplication";
                    j = 0;
                    a2 = this.gJP.a("SELECT count(*) from " + str, null, 2);
                    try {
                        if (a2.moveToFirst()) {
                            i = a2.getInt(0);
                        } else {
                            i = 0;
                        }
                    } catch (Throwable e3) {
                        r4 = e3;
                        i = 0;
                        try {
                            Throwable th;
                            x.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", th, "", new Object[0]);
                            x.e("MicroMsg.MediaCheckDuplicationStorage", "check to delete MediaDuplication. error : " + th.toString());
                            if (a2 != null) {
                                a2.close();
                            }
                            x.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j)});
                        } catch (Throwable th2) {
                            e3 = th2;
                            if (a2 != null) {
                                a2.close();
                            }
                            throw e3;
                        }
                    }
                    try {
                        a2.close();
                        if (i >= 5000) {
                            j = (long) this.gJP.delete(str, null, null);
                        }
                    } catch (Exception e4) {
                        th = e4;
                        x.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", th, "", new Object[0]);
                        x.e("MicroMsg.MediaCheckDuplicationStorage", "check to delete MediaDuplication. error : " + th.toString());
                        if (a2 != null) {
                            a2.close();
                        }
                        x.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j)});
                    }
                    x.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j)});
                } catch (Throwable th3) {
                    e3 = th3;
                    cursor = a;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw e3;
                }
            }
        } catch (Exception e5) {
            e3 = e5;
            a = null;
            x.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e3, "", new Object[0]);
            x.e("MicroMsg.MediaCheckDuplicationStorage", "tryAddDBCol error: " + e3.toString());
            if (a != null) {
                a.close();
            }
            str = "MediaDuplication";
            j = 0;
            a2 = this.gJP.a("SELECT count(*) from " + str, null, 2);
            if (a2.moveToFirst()) {
                i = 0;
            } else {
                i = a2.getInt(0);
            }
            a2.close();
            if (i >= 5000) {
                j = (long) this.gJP.delete(str, null, null);
            }
            x.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j)});
        } catch (Throwable th4) {
            e3 = th4;
            if (cursor != null) {
                cursor.close();
            }
            throw e3;
        }
        str = "MediaDuplication";
        j = 0;
        try {
            a2 = this.gJP.a("SELECT count(*) from " + str, null, 2);
            if (a2.moveToFirst()) {
                i = a2.getInt(0);
            } else {
                i = 0;
            }
            a2.close();
            if (i >= 5000) {
                j = (long) this.gJP.delete(str, null, null);
            }
        } catch (Throwable e6) {
            Throwable th5 = e6;
            a2 = null;
            th = th5;
            x.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", th, "", new Object[0]);
            x.e("MicroMsg.MediaCheckDuplicationStorage", "check to delete MediaDuplication. error : " + th.toString());
            if (a2 != null) {
                a2.close();
            }
            x.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j)});
        } catch (Throwable th6) {
            e3 = th6;
            a2 = null;
            if (a2 != null) {
                a2.close();
            }
            throw e3;
        }
        x.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j)});
    }

    public final boolean y(String str, int i, String str2) {
        if (bh.ov(str2)) {
            x.e("MicroMsg.MediaCheckDuplicationStorage", "insert path is null");
            return false;
        }
        if (i <= 0) {
            int bN = com.tencent.mm.a.e.bN(str2);
            if (bN <= 0) {
                x.e("MicroMsg.MediaCheckDuplicationStorage", "insert path insize:%d size:%d  path:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(bN), str2});
                return false;
            }
            i = bN;
        }
        if (bh.ov(str)) {
            str = com.tencent.mm.a.g.bV(str2);
            if (bh.ov(str)) {
                x.e("MicroMsg.MediaCheckDuplicationStorage", "insert path read md5 failed  path:%s", new Object[]{str2});
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", str);
        contentValues.put("size", Integer.valueOf(i));
        contentValues.put("path", str2);
        contentValues.put("createtime", Long.valueOf(bh.Wp()));
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(101));
        x.i("MicroMsg.MediaCheckDuplicationStorage", "insert Ret:%d size:%d md5:%s path:%s", new Object[]{Long.valueOf(this.gJP.insert("MediaDuplication", "", contentValues)), Integer.valueOf(i), str, str2});
        return this.gJP.insert("MediaDuplication", "", contentValues) > 0;
    }

    public final String dc(String str, int i) {
        if (bh.ov(str) || i <= 0) {
            x.e("MicroMsg.MediaCheckDuplicationStorage", "check  md5:%s size:%d", new Object[]{str, Integer.valueOf(i)});
            return "";
        }
        Cursor a = this.gJP.a("select path from MediaDuplication where md5 = '" + str + "' and  size = " + i + " and status != 100", null, 2);
        if (a == null) {
            x.e("MicroMsg.MediaCheckDuplicationStorage", "check query return null sql:%s", new Object[]{r1});
            return null;
        }
        String str2 = "";
        if (a.moveToNext()) {
            str2 = a.getString(0);
        }
        a.close();
        if (bh.ov(str2) || com.tencent.mm.a.e.bN(str2) > 0) {
            return str2;
        }
        x.w("MicroMsg.MediaCheckDuplicationStorage", "check file size is zero, delete db record now. path[%s], fileSize[%d], size[%d]", new Object[]{str2, Integer.valueOf(com.tencent.mm.a.e.bN(str2)), Integer.valueOf(i)});
        this.gJP.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str, String.valueOf(i), "100"});
        return "";
    }

    public final boolean G(String str, String str2, int i) {
        if (bh.ov(str) || bh.ov(str2)) {
            x.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but path is null. [%s, %s] ", new Object[]{str, str2});
            return false;
        }
        int bN = com.tencent.mm.a.e.bN(str);
        int bN2 = com.tencent.mm.a.e.bN(str2);
        if (bN <= 0 || bN2 <= 0) {
            x.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but file size is zero.[%d, %d]", new Object[]{Integer.valueOf(bN), Integer.valueOf(bN2)});
            return false;
        }
        String bV = com.tencent.mm.a.g.bV(str);
        if (bh.ov(bV)) {
            x.w("MicroMsg.MediaCheckDuplicationStorage", "import file is not null, but md5 is null, path " + str + " size : " + bN);
            return false;
        }
        long Wq = bh.Wq();
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", bV);
        contentValues.put("size", Integer.valueOf(bN));
        contentValues.put("createtime", Long.valueOf(bh.Wp()));
        contentValues.put("remuxing", str2);
        contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(100));
        x.i("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing ret[%d], size[%d], md5[%s], remuxingPath[%s], importPath[%s], duration[%d], cost time[%d]", new Object[]{Long.valueOf(this.gJP.insert("MediaDuplication", "", contentValues)), Integer.valueOf(bN), bV, str2, str, Integer.valueOf(i), Long.valueOf(bh.bA(Wq))});
        return this.gJP.insert("MediaDuplication", "", contentValues) > 0;
    }

    public final boolean a(String str, PString pString, PInt pInt) {
        if (bh.ov(str)) {
            x.d("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but import path is null.");
            return false;
        }
        int bN = com.tencent.mm.a.e.bN(str);
        if (bN <= 0) {
            x.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but file size is zero. path : " + str);
            return false;
        }
        String bV = com.tencent.mm.a.g.bV(str);
        if (bh.ov(bV)) {
            x.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but md5 is null. path : " + str);
            return false;
        }
        String str2 = "select remuxing, duration from MediaDuplication  where md5 = '" + bV + "' AND  size = " + bN + " AND status = 100";
        long Wq = bh.Wq();
        Cursor cursor = null;
        try {
            cursor = this.gJP.a(str2, null, 2);
            if (cursor != null && cursor.moveToFirst()) {
                pString.value = cursor.getString(0);
                pInt.value = cursor.getInt(1);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e, "", new Object[0]);
            x.e("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing error: " + e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        if (bh.ov(pString.value)) {
            x.d("MicroMsg.MediaCheckDuplicationStorage", "it has no remuxing path.");
            return false;
        } else if (com.tencent.mm.a.e.bN(pString.value) <= 0) {
            x.w("MicroMsg.MediaCheckDuplicationStorage", "remuxing file size is zero, delete db record now. remuxing path : " + pString.value);
            this.gJP.delete("MediaDuplication", "md5=? AND size=? AND status=?", new String[]{bV, String.valueOf(bN), "100"});
            pString.value = null;
            return false;
        } else {
            x.i("MicroMsg.MediaCheckDuplicationStorage", "check remuxing file success. remuxing path[%s], duration [%d], cost time[%d]", new Object[]{pString.value, Integer.valueOf(pInt.value), Long.valueOf(bh.bA(Wq))});
            return true;
        }
    }
}

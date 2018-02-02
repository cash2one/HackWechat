package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class w {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS VideoPlayHistory ( filename text PRIMARY KEY, starttime int, playduration int, downloadway int );"};
    e gJP;

    public w(h hVar) {
        this.gJP = hVar;
    }

    public final boolean nL(String str) {
        Throwable e;
        if (bh.ov(str)) {
            return false;
        }
        Cursor cursor = null;
        Cursor query;
        try {
            query = this.gJP.query("VideoPlayHistory", new String[]{FFmpegMetadataRetriever.METADATA_KEY_FILENAME}, "filename=?", new String[]{bh.ot(str)}, "", "", "");
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        if (query != null) {
                            query.close();
                        }
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.VideoPlayHistoryStorage", e, "", new Object[0]);
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            x.printErrStackTrace("MicroMsg.VideoPlayHistoryStorage", e, "", new Object[0]);
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th2) {
            e = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
        return false;
    }

    public final boolean b(String str, PInt pInt, PInt pInt2) {
        Cursor a;
        boolean z;
        Throwable e;
        Cursor cursor = null;
        try {
            a = this.gJP.a("VideoPlayHistory", new String[]{"starttime", "playduration"}, "filename=?", new String[]{bh.ot(str)}, "", "", "", 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        pInt.value = a.getInt(a.getColumnIndex("starttime"));
                        pInt2.value = a.getInt(a.getColumnIndex("playduration"));
                        z = true;
                        if (a != null) {
                            a.close();
                        }
                        x.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
                        return z;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.VideoPlayHistoryStorage", e, "", new Object[0]);
                        if (a == null) {
                            z = false;
                        } else {
                            a.close();
                            z = false;
                        }
                        x.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
                        return z;
                    } catch (Throwable th) {
                        e = th;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw e;
                    }
                }
            }
            z = false;
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.printErrStackTrace("MicroMsg.VideoPlayHistoryStorage", e, "", new Object[0]);
            if (a == null) {
                a.close();
                z = false;
            } else {
                z = false;
            }
            x.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
            return z;
        } catch (Throwable th2) {
            e = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
        x.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
        return z;
    }
}

package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;

public final class r extends i<q> implements a {
    public static final String[] gJN = new String[]{i.a(q.gJc, "SmileyInfo")};
    private static final String[] xAG = new String[]{"key", "cnValue", "qqValue", "enValue", "twValue", "thValue", "eggIndex", DownloadInfo.FILENAME};
    private static final String[] xAH = new String[]{"key"};
    public e gJP;

    public r(e eVar) {
        this(eVar, q.gJc, "SmileyInfo");
    }

    private r(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gJP = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final ArrayList<String> aAW() {
        Cursor a;
        Throwable e;
        ArrayList<String> arrayList = new ArrayList();
        try {
            a = this.gJP.a("SmileyInfo", xAH, "flag=?", new String[]{"0"}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            arrayList.add(a.getString(0));
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.NewSmileyInfoStorage", bh.i(e));
                        if (a != null) {
                            a.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.e("MicroMsg.emoji.NewSmileyInfoStorage", bh.i(e));
            if (a != null) {
                a.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return arrayList;
    }

    public final ArrayList<q> aAV() {
        Cursor a;
        Throwable e;
        ArrayList<q> arrayList = new ArrayList();
        try {
            a = this.gJP.a("SmileyInfo", xAG, "flag=?", new String[]{"0"}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            q qVar = new q();
                            qVar.b(a);
                            qVar.field_position = -1;
                            arrayList.add(qVar);
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.NewSmileyInfoStorage", bh.i(e));
                        if (a != null) {
                            a.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.e("MicroMsg.emoji.NewSmileyInfoStorage", bh.i(e));
            if (a != null) {
                a.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return arrayList;
    }
}

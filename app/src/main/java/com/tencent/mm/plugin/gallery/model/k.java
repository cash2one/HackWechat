package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.g.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class k implements g {
    private static int mRh = 100;
    public static String mRp = "date_added";
    public static String mRq = "datetaken";
    public static String mRr = "date_mix";
    protected ContentResolver hMz = this.mContext.getContentResolver();
    protected Context mContext = ac.getContext();
    private boolean mRs = false;
    boolean mRt = false;
    long start = 0;

    protected abstract String Bu(String str);

    protected abstract Uri aOa();

    protected abstract String[] aOb();

    protected abstract String aOc();

    protected abstract String aOd();

    protected abstract String[] getProjection();

    protected abstract String getSelection();

    protected abstract int getType();

    protected k() {
    }

    public ArrayList<AlbumItem> aNY() {
        Cursor query;
        ArrayList<AlbumItem> arrayList = new ArrayList();
        try {
            query = this.hMz.query(aOa(), getProjection(), getSelection(), null, aOc());
        } catch (Exception e) {
            x.e("MicroMsg.MediaQueryBase", "query album list failed : [%s]", new Object[]{e.getMessage()});
            query = null;
        }
        if (query == null) {
            x.d("MicroMsg.MediaQueryBase", "no media folder now");
            return arrayList;
        }
        if (query.moveToFirst()) {
            do {
                Long valueOf = Long.valueOf(0);
                try {
                    valueOf = Long.valueOf(bh.getLong(query.getString(query.getColumnIndexOrThrow("_id")), 0));
                } catch (NumberFormatException e2) {
                } catch (IllegalArgumentException e3) {
                }
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                String string2 = query.getString(query.getColumnIndexOrThrow(aOd()));
                if (bh.ov(string2) && getType() == 2) {
                    x.e("MicroMsg.MediaQueryBase", "null or nill album name, ignore this folder");
                } else {
                    int i = query.getInt(3);
                    x.i("MicroMsg.MediaQueryBase", string + "====" + string2 + "=====" + valueOf + ", " + i);
                    if (i == 0 || (bh.ov(string) && bh.ov(null))) {
                        x.e("MicroMsg.MediaQueryBase", "query album failed, " + i + ", " + string + "," + null);
                    } else {
                        if (bh.ov(string) || !e.bO(string)) {
                            string = null;
                        }
                        if (!bh.ov(null)) {
                            e.bO(null);
                        }
                        if (string == null) {
                            x.e("MicroMsg.MediaQueryBase", "this item has no thumb path and orignal path");
                        } else {
                            MediaItem a = MediaItem.a(getType(), valueOf.longValue(), string, null, query.getString(query.getColumnIndexOrThrow("mime_type")));
                            AlbumItem albumItem = new AlbumItem(string2, i);
                            albumItem.mRc = a;
                            arrayList.add(albumItem);
                        }
                    }
                }
            } while (query.moveToNext());
        }
        query.close();
        return arrayList;
    }

    public final void aNZ() {
        synchronized (this) {
            if (this.mRs) {
                this.mRt = true;
            }
        }
    }

    protected final synchronized boolean aOf() {
        return this.mRt;
    }

    public final ArrayList<MediaItem> a(String str, int i, c cVar, long j) {
        this.start = System.currentTimeMillis();
        synchronized (this) {
            this.mRs = true;
        }
        ArrayList<MediaItem> b = b(str, i, cVar, j);
        synchronized (this) {
            this.mRs = false;
        }
        x.i("MicroMsg.MediaQueryBase", "[queryEnd] cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.start)});
        return b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ArrayList<MediaItem> b(String str, int i, c cVar, long j) {
        Cursor query;
        ArrayList<MediaItem> arrayList = new ArrayList();
        try {
            query = this.hMz.query(aOa(), aOb(), Bu(str), null, aOc());
        } catch (Exception e) {
            x.e("MicroMsg.MediaQueryBase", "query media items in album failed : [%s]", new Object[]{e.getMessage()});
            query = null;
        }
        if (query == null) {
            x.d("MicroMsg.MediaQueryBase", "query album failed: " + str);
            if (cVar != null) {
                cVar.a(arrayList, j);
            }
            return arrayList;
        }
        Object obj = null;
        if (query.moveToFirst()) {
            do {
                MediaItem w;
                String string;
                Long valueOf = Long.valueOf(0);
                try {
                    valueOf = Long.valueOf(bh.getLong(query.getString(query.getColumnIndexOrThrow("_id")), 0));
                } catch (NumberFormatException e2) {
                } catch (IllegalArgumentException e3) {
                }
                String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                String string3 = query.getString(query.getColumnIndexOrThrow(mRr));
                long j2 = query.getLong(query.getColumnIndexOrThrow(mRr));
                String string4 = query.getString(query.getColumnIndexOrThrow(mRp));
                String string5 = query.getString(query.getColumnIndexOrThrow(mRq));
                if (string3 != null) {
                    if (!string3.equals("")) {
                        if (!string3.equals(Integer.valueOf(0))) {
                            if (string5 != null) {
                                if (!string5.equals("")) {
                                    if (!string5.equals(Integer.valueOf(0))) {
                                        if (string4 != null) {
                                            if (!string4.equals("")) {
                                            }
                                        }
                                        g.pQN.a(363, 5, 1, true);
                                        w = MediaItem.w(getType(), valueOf.longValue());
                                        if (!bh.ov(string2) && new File(string2).exists()) {
                                            w.hOo = string2;
                                        }
                                        w.mRg = cF(string3, string4);
                                        if (bh.ov(w.hOo) || !bh.ov(w.mld)) {
                                            string = query.getString(query.getColumnIndexOrThrow("mime_type"));
                                            if (bh.ov(string)) {
                                                string = "";
                                            }
                                            w.mMimeType = string;
                                            arrayList.add(w);
                                            if (arrayList.size() % mRh == 0 || cVar == null) {
                                                obj = null;
                                            } else {
                                                cVar.a(arrayList, j);
                                                arrayList.clear();
                                                obj = 1;
                                            }
                                        } else {
                                            x.e("MicroMsg.MediaQueryBase", "thumb file and orignal file both not exist");
                                            obj = null;
                                        }
                                    }
                                }
                            }
                            g.pQN.a(363, 6, 1, true);
                            w = MediaItem.w(getType(), valueOf.longValue());
                            w.hOo = string2;
                            w.mRg = cF(string3, string4);
                            if (bh.ov(w.hOo)) {
                            }
                            string = query.getString(query.getColumnIndexOrThrow("mime_type"));
                            if (bh.ov(string)) {
                                string = "";
                            }
                            w.mMimeType = string;
                            arrayList.add(w);
                            if (arrayList.size() % mRh == 0) {
                            }
                            obj = null;
                        }
                    }
                }
                g.pQN.a(363, 1, 1, true);
                if (0 != j2) {
                    g.pQN.a(363, 4, 1, true);
                }
                if (string4 != null) {
                    if (!string4.equals("")) {
                    }
                }
                if (string5 != null) {
                    if (!string5.equals("")) {
                        if (!string5.equals(Integer.valueOf(0))) {
                            g.pQN.a(363, 3, 1, true);
                        }
                    }
                }
                if (string5 != null) {
                    if (!string5.equals("")) {
                    }
                }
                if (string4 != null) {
                    if (!string4.equals("")) {
                        if (!string4.equals(Integer.valueOf(0))) {
                            g.pQN.a(363, 2, 1, true);
                        }
                    }
                }
                w = MediaItem.w(getType(), valueOf.longValue());
                w.hOo = string2;
                w.mRg = cF(string3, string4);
                if (bh.ov(w.hOo)) {
                }
                string = query.getString(query.getColumnIndexOrThrow("mime_type"));
                if (bh.ov(string)) {
                    string = "";
                }
                w.mMimeType = string;
                arrayList.add(w);
                if (arrayList.size() % mRh == 0) {
                }
                obj = null;
            } while (query.moveToNext());
        }
        query.close();
        if (obj == null && cVar != null) {
            cVar.a(arrayList, j);
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static long cF(String str, String str2) {
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (!bh.ov(str)) {
            try {
                j = TimeUnit.MILLISECONDS.convert(bh.getLong(str, 0), TimeUnit.MILLISECONDS);
                if (j <= currentTimeMillis) {
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MediaQueryBase", e, "", new Object[0]);
            }
        }
        if (!bh.ov(str2)) {
            try {
                j = TimeUnit.MILLISECONDS.convert(bh.getLong(str2, 0), TimeUnit.SECONDS);
                if (j <= currentTimeMillis) {
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MediaQueryBase", e2, "", new Object[0]);
            }
        }
        return j;
    }
}

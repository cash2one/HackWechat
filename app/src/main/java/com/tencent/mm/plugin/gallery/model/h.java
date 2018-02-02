package com.tencent.mm.plugin.gallery.model;

import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Media;
import com.tencent.mm.R;
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

public final class h extends k {
    private static int mRh = 100;
    private i mRi = new i();
    private n mRj = new n();
    private MediaMetadataRetriever mRk = new MediaMetadataRetriever();
    int mRl = 0;

    public final ArrayList<AlbumItem> aNY() {
        Cursor query;
        Cursor cursor = null;
        ArrayList<AlbumItem> arrayList = new ArrayList();
        try {
            query = this.hMz.query(Media.EXTERNAL_CONTENT_URI, this.mRj.getProjection(), "0==0) GROUP BY (bucket_display_name", null, this.mRj.aOc());
        } catch (Exception e) {
            x.e("MicroMsg.ImageAndVideoQuery", "query video album list failed : [%s]", new Object[]{e.getMessage()});
            query = cursor;
        }
        if (query == null) {
            x.d("MicroMsg.ImageAndVideoQuery", "no video folder now");
        } else {
            if (query.moveToFirst()) {
                AlbumItem b;
                MediaItem mediaItem = cursor;
                int i = 0;
                do {
                    b = b(query, 2, "bucket_display_name");
                    if (b != null) {
                        i += b.ftF;
                        if (mediaItem == null) {
                            mediaItem = b.mRc;
                        }
                    }
                } while (query.moveToNext());
                b = new AlbumItem(ac.getContext().getString(R.l.ekX), i);
                b.mRc = mediaItem;
                arrayList.add(b);
            }
            query.close();
        }
        try {
            cursor = this.hMz.query(Images.Media.EXTERNAL_CONTENT_URI, this.mRi.getProjection(), "0==0) GROUP BY (bucket_display_name", null, this.mRi.aOc());
        } catch (Exception e2) {
            x.e("MicroMsg.ImageAndVideoQuery", "query image album list failed : [%s]", new Object[]{e2.getMessage()});
        }
        if (cursor == null) {
            x.d("MicroMsg.ImageAndVideoQuery", "no image folder now");
        } else {
            if (cursor.moveToFirst()) {
                do {
                    AlbumItem b2 = b(cursor, 1, "bucket_display_name");
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return arrayList;
    }

    public final ArrayList<MediaItem> b(String str, int i, c cVar, long j) {
        Cursor query;
        Cursor cursor;
        Cursor cursor2;
        x.i("MicroMsg.ImageAndVideoQuery", "queryMediaItemsInAlbum: %s", new Object[]{str});
        ArrayList<MediaItem> arrayList = new ArrayList();
        if (i == 1 || i == 3) {
            try {
                query = this.hMz.query(Images.Media.EXTERNAL_CONTENT_URI, this.mRi.aOb(), this.mRi.Bu(str), null, this.mRi.aOc());
            } catch (Exception e) {
                x.e("MicroMsg.ImageAndVideoQuery", "query image items in album failed : [%s]", new Object[]{e.getMessage()});
                cursor = null;
            }
        } else {
            query = null;
        }
        cursor = query;
        if (i == 2 || i == 3) {
            try {
                query = this.hMz.query(Media.EXTERNAL_CONTENT_URI, this.mRj.aOb(), this.mRj.Bu(str), null, this.mRj.aOc());
            } catch (Exception e2) {
                x.e("MicroMsg.ImageAndVideoQuery", "query video items in album failed : [%s]", new Object[]{e2.getMessage()});
                cursor2 = null;
            }
        } else {
            query = null;
        }
        cursor2 = query;
        boolean z = cursor != null && cursor.moveToFirst();
        boolean z2 = cursor2 != null && cursor2.moveToFirst();
        if (z || z2) {
            MediaItem mediaItem = null;
            Object obj = null;
            boolean z3 = z2;
            boolean z4 = z;
            MediaItem mediaItem2 = null;
            boolean z5 = z4;
            while (true) {
                if (!z5 && !z3 && mediaItem == null && mediaItem2 == null) {
                    break;
                } else if (aOf()) {
                    break;
                } else {
                    MediaItem b;
                    if (mediaItem == null && z5) {
                        mediaItem = b(cursor, 1);
                        z2 = cursor.moveToNext();
                    } else {
                        z2 = z5;
                    }
                    if (mediaItem2 == null && z3) {
                        b = b(cursor2, 2);
                        z = cursor2.moveToNext();
                    } else {
                        b = mediaItem2;
                        z = z3;
                    }
                    if (mediaItem != null) {
                        if (b == null || mediaItem.a(b) > 0) {
                            x.d("MicroMsg.ImageAndVideoQuery", "image_id:%s mix_date:%s", new Object[]{Long.valueOf(bh.c(Long.valueOf(mediaItem.mRf))), Long.valueOf(bh.c(Long.valueOf(mediaItem.mRg)))});
                            arrayList.add(mediaItem);
                            mediaItem = null;
                        } else {
                            arrayList.add(b);
                            b = null;
                        }
                    } else if (b != null) {
                        arrayList.add(b);
                        b = null;
                    } else {
                        x.w("MicroMsg.ImageAndVideoQuery", "Image item and video item are all null");
                    }
                    if (arrayList.size() % mRh != 0 || cVar == null) {
                        z3 = z;
                        obj = null;
                        mediaItem2 = b;
                        z5 = z2;
                    } else {
                        cVar.a(arrayList, j);
                        arrayList.clear();
                        obj = 1;
                        z3 = z;
                        mediaItem2 = b;
                        z5 = z2;
                    }
                }
            }
            synchronized (this) {
                this.mRt = false;
            }
            if (this.mRl > 1) {
                g.pQN.a(363, 0, (long) this.mRl, true);
                g.pQN.a(363, 7, 1, true);
                this.mRl = 0;
            }
            if (cursor != null) {
                cursor.close();
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            if (obj == null && cVar != null) {
                cVar.a(arrayList, j);
            }
            return arrayList;
        }
        x.d("MicroMsg.ImageAndVideoQuery", "query album failed: " + str);
        if (cVar != null) {
            cVar.a(arrayList, j);
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static AlbumItem b(Cursor cursor, int i, String str) {
        Long valueOf = Long.valueOf(0);
        try {
            valueOf = Long.valueOf(bh.getLong(cursor.getString(cursor.getColumnIndexOrThrow("_id")), 0));
        } catch (NumberFormatException e) {
        } catch (IllegalArgumentException e2) {
        }
        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(str));
        String string3 = cursor.getString(cursor.getColumnIndexOrThrow(k.mRr));
        long j = cursor.getLong(cursor.getColumnIndexOrThrow(k.mRr));
        String string4 = cursor.getString(cursor.getColumnIndexOrThrow(k.mRp));
        String string5 = cursor.getString(cursor.getColumnIndexOrThrow(k.mRq));
        if (string3 == null || string3.equals("") || string3.equals(Integer.valueOf(0))) {
            g.pQN.a(363, 1, 1, true);
            if (0 != j) {
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
        } else {
            if (string5 != null) {
                if (!string5.equals("")) {
                    if (!string5.equals(Integer.valueOf(0))) {
                        if (string4 != null) {
                            if (!string4.equals("")) {
                            }
                        }
                        g.pQN.a(363, 5, 1, true);
                    }
                }
            }
            g.pQN.a(363, 6, 1, true);
        }
        if (bh.ov(string2)) {
            x.e("MicroMsg.ImageAndVideoQuery", "null or nill album name, ignore this folder");
            return null;
        }
        int i2 = cursor.getInt(3);
        x.i("MicroMsg.ImageAndVideoQuery", string + "====" + string2 + "=====" + valueOf + ", " + i2);
        if (i2 == 0 || (bh.ov(string) && bh.ov(null))) {
            x.e("MicroMsg.ImageAndVideoQuery", "query album failed, " + i2 + ", " + string + "," + null);
            return null;
        }
        String str2;
        if (bh.ov(string) || !e.bO(string)) {
            str2 = null;
        } else {
            str2 = string;
        }
        if (!bh.ov(null)) {
            e.bO(null);
        }
        if (str2 == null) {
            x.e("MicroMsg.ImageAndVideoQuery", "this item has no thumb path and original path");
            return null;
        }
        String string6 = cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
        MediaItem a = MediaItem.a(i, valueOf.longValue(), str2, null, string6);
        a.mRg = cF(string3, string4);
        AlbumItem albumItem = new AlbumItem(string2, i2);
        albumItem.mRc = a;
        return albumItem;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static MediaItem b(Cursor cursor, int i) {
        Long valueOf = Long.valueOf(0);
        try {
            valueOf = Long.valueOf(bh.getLong(cursor.getString(cursor.getColumnIndexOrThrow("_id")), 0));
        } catch (NumberFormatException e) {
        } catch (IllegalArgumentException e2) {
        }
        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(k.mRr));
        long j = cursor.getLong(cursor.getColumnIndexOrThrow(k.mRr));
        String string3 = cursor.getString(cursor.getColumnIndexOrThrow(k.mRp));
        String string4 = cursor.getString(cursor.getColumnIndexOrThrow(k.mRq));
        if (string2 == null || string2.equals("") || string2.equals(Integer.valueOf(0))) {
            g.pQN.a(363, 1, 1, true);
            if (0 != j) {
                g.pQN.a(363, 4, 1, true);
            }
            if ((string3 == null || string3.equals("") || string3.equals(Integer.valueOf(0))) && string4 != null) {
                if (!string4.equals("")) {
                    if (!string4.equals(Integer.valueOf(0))) {
                        g.pQN.a(363, 3, 1, true);
                    }
                }
            }
            if (string4 != null) {
                if (!string4.equals("")) {
                }
            }
            if (!(string3 == null || string3.equals("") || string3.equals(Integer.valueOf(0)))) {
                g.pQN.a(363, 2, 1, true);
            }
        } else {
            if (string4 != null) {
                if (!string4.equals("")) {
                    if (!string4.equals(Integer.valueOf(0))) {
                        if (string3 == null || string3.equals("") || string3.equals(Integer.valueOf(0))) {
                            g.pQN.a(363, 5, 1, true);
                        }
                    }
                }
            }
            g.pQN.a(363, 6, 1, true);
        }
        MediaItem w = MediaItem.w(i, valueOf.longValue());
        if (!bh.ov(string) && new File(string).exists()) {
            w.hOo = string;
        }
        w.mRg = cF(string2, string3);
        if (bh.ov(w.hOo) && bh.ov(w.mld)) {
            x.w("MicroMsg.ImageAndVideoQuery", "thumb file and orignal file both not exist");
            return null;
        }
        String string5 = cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
        if (bh.ov(string5)) {
            string5 = "";
        }
        w.mMimeType = string5;
        return w;
    }

    protected final int getType() {
        return 3;
    }

    protected final Uri aOa() {
        return Images.Media.EXTERNAL_CONTENT_URI;
    }

    protected final String[] getProjection() {
        return null;
    }

    protected final String[] aOb() {
        return null;
    }

    protected final String getSelection() {
        return null;
    }

    protected final String aOc() {
        return null;
    }

    protected final String aOd() {
        return null;
    }

    protected final String Bu(String str) {
        return null;
    }
}

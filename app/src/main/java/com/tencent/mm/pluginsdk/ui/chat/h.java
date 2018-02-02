package com.tencent.mm.pluginsdk.ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

final class h {
    private ContentResolver hMz = this.mContext.getContentResolver();
    protected Context mContext;

    protected h(Context context) {
        this.mContext = context;
    }

    private String SC(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
            return null;
        }
        try {
            Cursor query = this.hMz.query(Thumbnails.EXTERNAL_CONTENT_URI, null, "image_id=\"" + str + "\"", null, null);
            if (query == null) {
                x.e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:" + str);
                return null;
            }
            String string;
            if (query.moveToFirst()) {
                do {
                    string = query.getString(query.getColumnIndexOrThrow("_data"));
                } while (query.moveToNext());
            } else {
                string = null;
            }
            query.close();
            return string;
        } catch (Exception e) {
            x.e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", new Object[]{e.toString()});
            return null;
        }
    }

    public final ArrayList<g> cbZ() {
        ArrayList<g> arrayList = new ArrayList();
        String stringBuilder = new StringBuilder("date_added desc limit 1").toString();
        String[] strArr = new String[]{"_id", "_data", "date_added"};
        bh.Wp();
        try {
            Cursor query = this.hMz.query(Media.EXTERNAL_CONTENT_URI, strArr, null, null, stringBuilder);
            if (query == null) {
                return arrayList;
            }
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(query.getColumnIndexOrThrow("_id"));
                    String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                    String string3 = query.getString(query.getColumnIndexOrThrow("date_added"));
                    String SC = SC(string);
                    if (bh.ov(string2) || !e.bO(string2)) {
                        x.e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
                    } else if (string2.startsWith(com.tencent.mm.compatible.util.e.gHu)) {
                        x.i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
                    } else {
                        g gVar = new g();
                        gVar.vrq = bh.getLong(string, 0);
                        gVar.mRg = bh.getLong(string3, 0);
                        if (!bh.ov(SC) && e.bO(SC)) {
                            gVar.fvC = SC;
                        }
                        if (!bh.ov(string2) && e.bO(string2)) {
                            gVar.vrr = string2;
                        }
                        if (bh.ov(gVar.vrr) && bh.ov(gVar.vrr)) {
                            x.e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
                        } else {
                            arrayList.add(gVar);
                        }
                    }
                } while (query.moveToNext());
            }
            query.close();
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", new Object[]{e.toString()});
            return null;
        }
    }
}

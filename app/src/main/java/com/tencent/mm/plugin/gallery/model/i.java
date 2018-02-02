package com.tencent.mm.plugin.gallery.model;

import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class i extends k {
    private String[] mRm = new String[]{"camera", "screenshot", "download"};

    protected final int getType() {
        return 1;
    }

    public final ArrayList<AlbumItem> aNY() {
        return super.aNY();
    }

    public final Uri aOa() {
        return Media.EXTERNAL_CONTENT_URI;
    }

    public final String[] getProjection() {
        return new String[]{"_id", "_data", "bucket_display_name", "count(*)", "COALESCE(" + k.mRq, k.mRp + ",0) AS " + mRr, k.mRq, k.mRp, "mime_type"};
    }

    public final String getSelection() {
        return "0==0) GROUP BY (bucket_display_name";
    }

    public final String aOc() {
        return k.mRr + " desc,_id desc";
    }

    protected final String aOd() {
        return "bucket_display_name";
    }

    protected final String[] aOb() {
        return new String[]{"_id", "_data", "COALESCE(" + k.mRq, k.mRp + ",0) AS " + mRr, k.mRq, k.mRp, "mime_type"};
    }

    protected final String Bu(String str) {
        if (!bh.ov(str)) {
            return "bucket_display_name=\"" + str + "\"";
        }
        x.w("MicroMsg.ImageQuery", "get media item selection, but album name is null, do select all");
        String stringBuilder = new StringBuilder("_size>10240").toString();
        String[] strArr = this.mRm;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            i++;
            stringBuilder = stringBuilder + " or lower(_data) like '%" + strArr[i] + "%'";
        }
        x.d("MicroMsg.ImageQuery", "where %s", new Object[]{stringBuilder});
        return stringBuilder;
    }
}

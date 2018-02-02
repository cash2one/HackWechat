package com.tencent.mm.plugin.gallery.model;

import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class n extends k {
    protected final int getType() {
        return 2;
    }

    public final ArrayList<AlbumItem> aNY() {
        return super.aNY();
    }

    protected final Uri aOa() {
        return Media.EXTERNAL_CONTENT_URI;
    }

    protected final String[] getProjection() {
        return new String[]{"_id", "_data", "bucket_display_name", "count(*)", "COALESCE(" + k.mRq, k.mRp + ",0) AS " + mRr, k.mRq, k.mRp, "mime_type"};
    }

    protected final String getSelection() {
        return "0==0) GROUP BY (bucket_display_name";
    }

    protected final String aOc() {
        return k.mRq + " desc,_id desc";
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
        x.w("MicroMsg.VideoQuery", "get media item selection, but album name is null, do select all");
        return null;
    }
}

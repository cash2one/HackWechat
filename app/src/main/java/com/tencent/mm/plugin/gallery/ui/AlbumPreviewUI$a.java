package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class AlbumPreviewUI$a implements Runnable {
    public WeakReference<a> mSX;
    public WeakReference<ProgressDialog> mSY;
    public ArrayList<GalleryItem$MediaItem> mSZ;

    private AlbumPreviewUI$a() {
    }

    public final void run() {
        String str = "MicroMsg.AlbumPreviewUI";
        String str2 = "on NotifyMediaItemsChanged, size %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.mSZ == null ? -1 : this.mSZ.size());
        x.d(str, str2, objArr);
        if (this.mSX != null) {
            a aVar = (a) this.mSX.get();
            if (aVar != null) {
                AlbumPreviewUI.A(this.mSZ);
                aVar.mRK.addAll(this.mSZ);
                aVar.notifyDataSetChanged();
                if (this.mSY != null) {
                    ProgressDialog progressDialog = (ProgressDialog) this.mSY.get();
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        x.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start)});
                    }
                }
            }
        }
    }

    public final String toString() {
        return super.toString() + "|notifyRunnable";
    }
}

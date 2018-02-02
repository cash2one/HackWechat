package com.tencent.mm.plugin.gallery.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.2;
import com.tencent.mm.sdk.platformtools.x;

class AlbumPreviewUI$2$1 implements OnClickListener {
    final /* synthetic */ int kI;
    final /* synthetic */ 2 mSR;

    AlbumPreviewUI$2$1(2 2, int i) {
        this.mSR = 2;
        this.kI = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MediaItem qs = AlbumPreviewUI.a(this.mSR.mSQ).qs(this.kI);
        if (qs == null) {
            x.w("MicroMsg.AlbumPreviewUI", "get item for video error, null, position %d", new Object[]{Integer.valueOf(this.kI)});
            this.mSR.mSQ.setResult(0);
        } else {
            x.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
            Intent intent = new Intent();
            intent.setData(Uri.parse("file://" + Uri.encode(qs.hOo)));
            this.mSR.mSQ.setResult(-1, intent);
        }
        this.mSR.mSQ.finish();
    }
}

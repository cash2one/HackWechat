package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.h;
import java.util.Set;

class ImageGalleryGridUI$9 implements OnClickListener {
    final /* synthetic */ ImageGalleryGridUI yEd;
    final /* synthetic */ Set yEi;

    ImageGalleryGridUI$9(ImageGalleryGridUI imageGalleryGridUI, Set set) {
        this.yEd = imageGalleryGridUI;
        this.yEi = set;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.GalleryGridUI", "delete message");
        h.a(this.yEd, this.yEi, this.yEd);
        this.yEd.cuj();
    }
}

package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

class ImageGalleryGridUI$2 implements OnClickListener {
    final /* synthetic */ ImageGalleryGridUI yEd;
    final /* synthetic */ List yEe;

    ImageGalleryGridUI$2(ImageGalleryGridUI imageGalleryGridUI, List list) {
        this.yEd = imageGalleryGridUI;
        this.yEe = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.c(this.yEd.mController.xIM, this.yEe);
        this.yEd.cuj();
    }
}

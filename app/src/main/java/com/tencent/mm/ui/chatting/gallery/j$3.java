package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class j$3 implements OnClickListener {
    final /* synthetic */ j yGA;

    j$3(j jVar) {
        this.yGA = jVar;
    }

    public final void onClick(View view) {
        if (this.yGA.yDo != null) {
            x.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", new Object[]{Integer.valueOf(this.yGA.hashCode()), Integer.valueOf(this.yGA.mPosition)});
            this.yGA.yDo.FQ(this.yGA.mPosition);
        }
    }
}

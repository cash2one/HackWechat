package com.tencent.mm.plugin.exdevice.f.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;

class e$2 implements d {
    final /* synthetic */ MMActivity lOS;

    e$2(MMActivity mMActivity) {
        this.lOS = mMActivity;
    }

    public final void cn(int i, int i2) {
        switch (i2) {
            case 0:
                Context context = this.lOS;
                Intent intent = new Intent();
                intent.putExtra("query_source_type", 9);
                intent.putExtra("query_media_type", 1);
                intent.putExtra("max_select_count", 1);
                com.tencent.mm.bm.d.b(context, "gallery", ".ui.AlbumPreviewUI", intent, 1001);
                return;
            default:
                return;
        }
    }
}

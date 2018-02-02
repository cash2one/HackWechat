package com.tencent.mm.plugin.music.model.notification;

import android.graphics.Bitmap;
import com.tencent.mm.aq.a.c.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.av.a;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements c {
    final /* synthetic */ a oJy;
    final /* synthetic */ a oLX;
    final /* synthetic */ String oLY;

    a$3(a aVar, a aVar2, String str) {
        this.oLX = aVar;
        this.oJy = aVar2;
        this.oLY = str;
    }

    public final void a(boolean z, Object... objArr) {
        x.i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", new Object[]{this.oJy.field_songAlbumUrl, Boolean.valueOf(z)});
        if (z) {
            Bitmap decodeFile = d.decodeFile(this.oLY, null);
            if (decodeFile == null) {
                x.e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
                return;
            }
            o.PA().i(this.oJy.field_songAlbumUrl, decodeFile);
            this.oLX.oLT.refresh();
        }
    }
}

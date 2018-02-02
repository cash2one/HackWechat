package com.tencent.mm.plugin.music.model.d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.source.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

class a$d implements a {
    final /* synthetic */ a oLJ;

    private a$d(a aVar) {
        this.oLJ = aVar;
    }

    public final void a(i iVar, Format format, IOException iOException) {
        a.a(this.oLJ, "loadError", iOException);
        if (!(iVar == null || format == null)) {
            x.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", new Object[]{iVar.uri, format.toString()});
        }
        this.oLJ.cU(-4004, -40);
    }

    public final void jU() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
    }

    public final void jV() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
        this.oLJ.auM = true;
    }
}

package com.tencent.mm.plugin.music.model;

import com.tencent.mm.g.a.js;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class e$b implements Runnable {
    final /* synthetic */ e oJL;
    List<String> oJM;

    private e$b(e eVar) {
        this.oJL = eVar;
    }

    public final void run() {
        String i = g.i(this.oJL.bdp());
        int i2 = this.oJL.oJA;
        int i3 = 0;
        for (int i4 = 0; i4 < this.oJM.size(); i4++) {
            if (((String) this.oJM.get(i4)).equals(i)) {
                i2 = i4;
                i3 = 1;
            }
        }
        if (i3 != 0) {
            int i5;
            for (i5 = i2 + 1; i5 < this.oJM.size(); i5++) {
                this.oJL.oJB.add(this.oJM.get(i5));
            }
            for (i5 = 0; i5 < i2; i5++) {
                this.oJL.oJB.add(this.oJM.get(i5));
            }
            x.i("MicroMsg.Music.MusicPlayerManager", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[]{Integer.valueOf(this.oJL.oJB.size()), Integer.valueOf(this.oJL.oJA)});
            b jsVar = new js();
            jsVar.fAz.action = 5;
            a.xef.m(jsVar);
        }
    }
}

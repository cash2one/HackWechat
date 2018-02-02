package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.i;
import com.tencent.mm.sdk.platformtools.x;

class a$i$1 implements OnErrorListener {
    final /* synthetic */ i rmo;

    a$i$1(i iVar) {
        this.rmo = iVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[]{a.a(this.rmo.rmk), Integer.valueOf(i), Integer.valueOf(i2)});
        this.rmo.rmk.clear();
        if (a.b(this.rmo.rmk) != null) {
            a.b(this.rmo.rmk).xb(-1);
        }
        return true;
    }
}

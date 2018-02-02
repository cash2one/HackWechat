package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.sdk.platformtools.x;

class GameGestureGalleryUI$2 implements OnItemSelectedListener {
    final /* synthetic */ GameGestureGalleryUI nrc;

    GameGestureGalleryUI$2(GameGestureGalleryUI gameGestureGalleryUI) {
        this.nrc = gameGestureGalleryUI;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        GameGestureGalleryUI.a(this.nrc, i);
        this.nrc.setMMTitle((GameGestureGalleryUI.a(this.nrc) + 1) + " / " + GameGestureGalleryUI.b(this.nrc).size());
        x.d("MicroMsg.GameGestureGalleryUI", "pos:" + i);
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}

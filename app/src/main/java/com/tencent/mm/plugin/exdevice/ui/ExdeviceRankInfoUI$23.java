package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.exdevice.f.a.e;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceRankInfoUI$23 implements OnClickListener {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$23(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap: start change cover");
        e.b(this.lXj);
    }
}

package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class ReadMailUI$8 implements OnClickListener {
    final /* synthetic */ ReadMailUI puG;

    ReadMailUI$8(ReadMailUI readMailUI) {
        this.puG = readMailUI;
    }

    public final void onClick(View view) {
        if (ReadMailUI.G(this.puG).getVisibility() == 8) {
            ReadMailUI.H(this.puG).setText(R.l.eCb);
            ReadMailUI.G(this.puG).setVisibility(0);
            ReadMailUI.G(this.puG).post(new 1(this));
            ReadMailUI.h(this.puG).setVisibility(0);
            return;
        }
        ReadMailUI.H(this.puG).setText(R.l.eCc);
        ReadMailUI.G(this.puG).setVisibility(8);
        ReadMailUI.h(this.puG).setVisibility(8);
    }
}

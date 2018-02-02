package com.tencent.mm.pluginsdk.ui.chat;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;

class ChatFooter$9 implements OnKeyListener {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$9(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (keyEvent.getAction()) {
            case 0:
                if (!((i != 23 && i != 66) || ChatFooter.u(this.vra) || ChatFooter.t(this.vra))) {
                    ChatFooter.d(this.vra, true);
                    ChatFooter.r(this.vra).setBackgroundDrawable(a.b(this.vra.getContext(), R.g.bFh));
                    ChatFooter.r(this.vra).setText(R.l.dQu);
                    ChatFooter.j(this.vra).aYI();
                    ChatFooter.r(this.vra).setContentDescription(this.vra.getContext().getString(R.l.dPY));
                    break;
                }
            case 1:
                if (i == 23 || i == 66) {
                    ChatFooter.r(this.vra).setBackgroundDrawable(a.b(this.vra.getContext(), R.g.bFg));
                    ChatFooter.r(this.vra).setText(R.l.dQt);
                    ChatFooter.j(this.vra).aYF();
                    ChatFooter.d(this.vra, false);
                    break;
                }
        }
        return false;
    }
}

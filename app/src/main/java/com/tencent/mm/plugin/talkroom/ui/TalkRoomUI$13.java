package com.tencent.mm.plugin.talkroom.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class TalkRoomUI$13 implements OnTouchListener {
    final /* synthetic */ TalkRoomUI scT;

    TalkRoomUI$13(TalkRoomUI talkRoomUI) {
        this.scT = talkRoomUI;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                TalkRoomUI.b(this.scT, TalkRoomUI.a(this.scT, motionEvent));
                if (TalkRoomUI.k(this.scT)) {
                    TalkRoomUI.l(this.scT).setImageResource(R.g.bGJ);
                    ar.b(ac.getContext(), R.l.eQT, new a(this) {
                        final /* synthetic */ TalkRoomUI$13 scV;

                        {
                            this.scV = r1;
                        }

                        public final void vh() {
                            x.i("MicroMsg.TalkRoomUI", "play press sound end");
                        }
                    });
                    TalkRoomUI.a(this.scT, 1);
                    TalkRoomUI.d(this.scT);
                    x.i("MicroMsg.TalkRoomUI", "micBtn pressed down");
                    TalkRoomUI.a(this.scT, bh.Wq());
                    b.bEC().bEP();
                    TalkRoomUI.m(this.scT);
                    break;
                }
                break;
            case 2:
                if (TalkRoomUI.k(this.scT)) {
                    break;
                }
                break;
            case 1:
            case 3:
                if (TalkRoomUI.k(this.scT)) {
                    TalkRoomUI.b(this.scT, false);
                    if (TalkRoomUI.b(this.scT) == 5) {
                        x.i("MicroMsg.TalkRoomUI", "cancel during seize-success prepare time");
                        TalkRoomUI.n(this.scT).TG();
                        TalkRoomUI.o(this.scT).TG();
                    }
                    TalkRoomUI.l(this.scT).setImageResource(R.g.bGI);
                    TalkRoomUI.a(this.scT, 0);
                    TalkRoomUI.d(this.scT);
                    TalkRoomUI.p(this.scT).TG();
                    b.bEC().bEQ();
                    ar.b(ac.getContext(), R.l.eQV, new 2(this));
                    TalkRoomUI.m(this.scT);
                    break;
                }
                break;
        }
        return false;
    }
}

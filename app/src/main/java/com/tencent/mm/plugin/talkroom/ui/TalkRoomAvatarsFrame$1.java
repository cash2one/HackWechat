package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.mm.ui.base.MMHorList.a;

class TalkRoomAvatarsFrame$1 implements a {
    final /* synthetic */ TalkRoomAvatarsFrame scA;

    TalkRoomAvatarsFrame$1(TalkRoomAvatarsFrame talkRoomAvatarsFrame) {
        this.scA = talkRoomAvatarsFrame;
    }

    public final void bFa() {
        TalkRoomAvatarsFrame.a(this.scA).TG();
    }

    public final void bFb() {
        TalkRoomAvatarsFrame.a(this.scA).J(2000, 2000);
    }

    public final void aXw() {
        TalkRoomAvatarsFrame.c(this.scA).post(new Runnable(this) {
            final /* synthetic */ TalkRoomAvatarsFrame$1 scB;

            {
                this.scB = r1;
            }

            public final void run() {
                TalkRoomAvatarsFrame.b(this.scB.scA).notifyDataSetChanged();
            }
        });
    }
}

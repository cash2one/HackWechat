package com.tencent.mm.plugin.talkroom.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.a;
import com.tencent.mm.sdk.platformtools.bh;

class TalkRoomUI$15 implements OnTouchListener {
    final /* synthetic */ TalkRoomUI scT;
    final /* synthetic */ a scW;

    TalkRoomUI$15(TalkRoomUI talkRoomUI, a aVar) {
        this.scT = talkRoomUI;
        this.scW = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        a aVar = this.scW;
        int action = motionEvent.getAction();
        if (action == 0) {
            aVar.iQK = motionEvent.getX();
            aVar.iQL = motionEvent.getY();
            aVar.scX = bh.Wq();
            return true;
        }
        if (action == 1 || action == 3) {
            float abs = Math.abs(motionEvent.getX() - aVar.iQK);
            float y = aVar.iQL - motionEvent.getY();
            if (y >= 100.0f && y / abs > 2.0f && y / ((float) bh.bA(aVar.scX)) > 0.6f) {
                aVar.bFg();
                return true;
            }
        }
        return false;
    }
}

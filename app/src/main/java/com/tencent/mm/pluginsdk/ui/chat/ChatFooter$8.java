package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

class ChatFooter$8 implements OnTouchListener {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$8(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == ChatFooter.r(this.vra)) {
            x.v("RcdBtnEvent", "event.getAction():" + motionEvent.getAction());
            switch (motionEvent.getAction()) {
                case 0:
                    x.i("RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", Integer.valueOf(ChatFooter.cbX()));
                    if (ChatFooter.s(this.vra) instanceof Activity) {
                        ((Activity) ChatFooter.s(this.vra)).getWindow().addFlags(FileUtils.S_IWUSR);
                    }
                    if (!(ChatFooter.t(this.vra) || ChatFooter.u(this.vra))) {
                        ChatFooter.c(this.vra, true);
                        ChatFooter.r(this.vra).setBackgroundDrawable(a.b(this.vra.getContext(), R.g.bFh));
                        ChatFooter.r(this.vra).setText(R.l.dQu);
                        ChatFooter.j(this.vra).aYI();
                        ChatFooter.r(this.vra).setContentDescription(this.vra.getContext().getString(R.l.dPY));
                        break;
                    }
                case 1:
                case 3:
                    if (ChatFooter.s(this.vra) instanceof Activity) {
                        ((Activity) ChatFooter.s(this.vra)).getWindow().clearFlags(FileUtils.S_IWUSR);
                    }
                    x.i("RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", Integer.valueOf(ChatFooter.cbX()));
                    ChatFooter.y(this.vra);
                    x.i("RcdBtnEvent", "outer on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", Integer.valueOf(ChatFooter.cbY()));
                    break;
                case 2:
                    if (ChatFooter.v(this.vra) == null || ChatFooter.w(this.vra) == null) {
                        x.e("MicroMsg.ChatFooter", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", ChatFooter.v(this.vra), ChatFooter.w(this.vra));
                    }
                    if (motionEvent.getX() > 0.0f && motionEvent.getY() > ((float) ((-ChatFooter.x(this.vra)) / 2)) && motionEvent.getX() < ((float) ChatFooter.r(this.vra).getWidth())) {
                        if (ChatFooter.v(this.vra) != null) {
                            ChatFooter.v(this.vra).setVisibility(0);
                        }
                        if (ChatFooter.w(this.vra) != null) {
                            ChatFooter.r(this.vra).setText(R.l.dQu);
                            ChatFooter.w(this.vra).setVisibility(8);
                            break;
                        }
                    }
                    x.i("MicroMsg.ChatFooter", "show cancel Tips, ACTION_MOVE (x:%f y:%f) rcdHintPopUpMarginTop:%d voiceRcdBtn.getWidth():%d voiceRcdBtn.getHeight():%d", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(ChatFooter.x(this.vra)), Integer.valueOf(ChatFooter.r(this.vra).getWidth()), Integer.valueOf(ChatFooter.r(this.vra).getHeight()));
                    if (ChatFooter.v(this.vra) != null) {
                        ChatFooter.v(this.vra).setVisibility(8);
                    }
                    if (ChatFooter.w(this.vra) != null) {
                        ChatFooter.r(this.vra).setText(R.l.dQe);
                        ChatFooter.w(this.vra).setVisibility(0);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}

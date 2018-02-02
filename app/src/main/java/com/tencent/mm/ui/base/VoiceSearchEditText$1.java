package com.tencent.mm.ui.base;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class VoiceSearchEditText$1 implements OnTouchListener {
    final /* synthetic */ VoiceSearchEditText yhM;

    VoiceSearchEditText$1(VoiceSearchEditText voiceSearchEditText) {
        this.yhM = voiceSearchEditText;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View view2 = this.yhM;
        if (view2.getCompoundDrawables()[2] == null) {
            return false;
        }
        if (motionEvent.getAction() != 1) {
            return true;
        }
        VoiceSearchEditText.a(this.yhM, true);
        if (VoiceSearchEditText.a(this.yhM) && VoiceSearchEditText.b(this.yhM) && view2.getText().toString().equals("")) {
            if (motionEvent.getX() <= ((float) (((view2.getWidth() - view2.getPaddingRight()) - this.yhM.yhG.getIntrinsicWidth()) - a.fromDPToPix(VoiceSearchEditText.c(view2), 25)))) {
                view2.requestFocus();
                if (this.yhM.getContext() instanceof Activity) {
                    MMActivity.showVKB((Activity) this.yhM.getContext());
                }
                if (VoiceSearchEditText.d(this.yhM) != null) {
                    VoiceSearchEditText.d(this.yhM).onClick(null);
                }
            } else if (VoiceSearchEditText.d(this.yhM) != null) {
                x.i("MicroMsg.VoiceSearchEditText", "user clicked voice button");
                if (this.yhM.getContext() instanceof MMActivity) {
                    ((MMActivity) this.yhM.getContext()).df(view2);
                }
                VoiceSearchEditText.d(this.yhM).onClick(this.yhM);
                return true;
            }
        } else if (view2.getText().toString().length() > 0) {
            if (motionEvent.getX() > ((float) (((view2.getWidth() - view2.getPaddingRight()) - this.yhM.yhI.getIntrinsicWidth()) - a.fromDPToPix(VoiceSearchEditText.c(view2), 25)))) {
                view2.setText("");
                VoiceSearchEditText.e(this.yhM);
            } else if (!view2.isFocused()) {
                view2.requestFocus();
                if (this.yhM.getContext() instanceof Activity) {
                    MMActivity.showVKB((Activity) this.yhM.getContext());
                }
            }
        } else if (VoiceSearchEditText.d(this.yhM) != null) {
            VoiceSearchEditText.d(this.yhM).onClick(null);
        }
        return false;
    }
}

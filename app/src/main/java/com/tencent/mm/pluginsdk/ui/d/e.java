package com.tencent.mm.pluginsdk.ui.d;

import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.b;

public final class e extends b {
    private l vur;

    public e(NeatTextView neatTextView, l lVar) {
        super(neatTextView.getContext(), neatTextView);
        this.vur = lVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        view.setTag(com.tencent.mm.plugin.comm.a.e.cSF, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        if (view instanceof NeatTextView) {
            NeatTextView neatTextView = (NeatTextView) view;
            if (!neatTextView.cyM() || neatTextView.zwR) {
                if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    neatTextView.zLq.setPressed(false);
                } else if (motionEvent.getAction() == 0) {
                    neatTextView.zLq.setPressed(true);
                }
                return this.vur.onTouch(neatTextView.zLq, motionEvent);
            }
        }
        return super.onTouch(view, motionEvent);
    }

    public final boolean onDown(MotionEvent motionEvent) {
        boolean onDown = super.onDown(motionEvent);
        if (this.zLF != null) {
            CharacterStyle characterStyle = this.zLF.zKr;
            if (characterStyle instanceof m) {
                ((m) characterStyle).ozA = true;
            }
        }
        return onDown;
    }

    protected final void cancel(int i) {
        if (this.zLF != null) {
            CharacterStyle characterStyle = this.zLF.zKr;
            if (characterStyle instanceof m) {
                ((m) characterStyle).ozA = false;
                if (i == 1) {
                    this.mView.performLongClick();
                }
            }
        }
        super.cancel(i);
    }
}

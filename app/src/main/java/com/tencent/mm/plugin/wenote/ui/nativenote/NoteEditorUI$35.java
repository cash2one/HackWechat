package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;

class NoteEditorUI$35 implements OnTouchListener {
    final /* synthetic */ NoteEditorUI tXd;

    NoteEditorUI$35(NoteEditorUI noteEditorUI) {
        this.tXd = noteEditorUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            NoteEditorUI.a(this.tXd, motionEvent.getX());
            NoteEditorUI.b(this.tXd, motionEvent.getY());
        }
        float abs;
        float abs2;
        if (motionEvent.getAction() == 1 && NoteEditorUI.K(this.tXd).j(motionEvent.getX(), motionEvent.getY()) == null) {
            abs = Math.abs(NoteEditorUI.N(this.tXd) - motionEvent.getX());
            abs2 = Math.abs(NoteEditorUI.O(this.tXd) - motionEvent.getY());
            if (abs < 30.0f && abs2 < 30.0f) {
                if (NoteEditorUI.b(this.tXd).getVisibility() != 8) {
                    if (NoteEditorUI.a(this.tXd) != null) {
                        NoteEditorUI.a(this.tXd).tTh.dismiss();
                    }
                    NoteEditorUI.b(this.tXd).setVisibility(8);
                } else {
                    int size = c.bWp().size();
                    b Bt = c.bWp().Bt(size - 1);
                    if (Bt != null) {
                        boolean z = Bt.tRt;
                        c.bWp().bWs();
                        Bt.tRt = true;
                        Bt.tRz = false;
                        Bt.tRv = -1;
                        NoteEditorUI.P(this.tXd).bj(size - 1);
                        this.tXd.f(true, 50);
                        this.tXd.P(1, 0);
                        if (NoteEditorUI.G(this.tXd) && z) {
                            NoteEditorUI.w(this.tXd).postDelayed(new Runnable(this) {
                                final /* synthetic */ NoteEditorUI$35 tXr;

                                {
                                    this.tXr = r1;
                                }

                                public final void run() {
                                    e.bXf().kN(true);
                                    e.bXf().kM(true);
                                }
                            }, 100);
                        }
                    }
                }
            }
        } else if (motionEvent.getAction() == 2) {
            abs = Math.abs(NoteEditorUI.N(this.tXd) - motionEvent.getX());
            abs2 = Math.abs(NoteEditorUI.O(this.tXd) - motionEvent.getY());
            if (abs > 120.0f || abs2 > 120.0f) {
                if (NoteEditorUI.G(this.tXd)) {
                    if (e.bXf().bXe() == 1) {
                        this.tXd.bWe();
                        e.bXf().bXj();
                    }
                } else if (!NoteEditorUI.Q(this.tXd)) {
                    this.tXd.bWe();
                }
            }
        }
        return false;
    }
}

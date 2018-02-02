package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.support.v4.view.z;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;

class NoteEditorUI$22 implements Runnable {
    final /* synthetic */ NoteEditorUI tXd;
    final /* synthetic */ Context val$context;

    NoteEditorUI$22(NoteEditorUI noteEditorUI, Context context) {
        this.tXd = noteEditorUI;
        this.val$context = context;
    }

    public final void run() {
        int size = c.bWp().size();
        int childCount = NoteEditorUI.K(this.tXd).getChildCount();
        if (size == childCount) {
            size = childCount - 1;
            float f = 0.0f;
            int i = size;
            while (i >= 0) {
                View childAt = NoteEditorUI.K(this.tXd).getChildAt(i);
                float R = z.R(childAt);
                i--;
                f = f > ((float) childAt.getBottom()) + R ? f : ((float) childAt.getBottom()) + R;
            }
            if (f < ((float) j.aT(this.val$context)[1]) && f > 0.0f) {
                LayoutParams layoutParams = (LayoutParams) NoteEditorUI.b(this.tXd).getLayoutParams();
                layoutParams.height = (int) f;
                NoteEditorUI.b(this.tXd).setLayoutParams(layoutParams);
            }
        }
        NoteEditorUI.b(this.tXd).setVisibility(0);
        if (NoteEditorUI.a(this.tXd) != null) {
            g a = NoteEditorUI.a(this.tXd);
            int[] iArr = new int[]{0, 0};
            a.mParentView.getLocationOnScreen(iArr);
            a.tTh.showAtLocation(a.mParentView, 49, 0, iArr[1] + 50);
        }
    }
}

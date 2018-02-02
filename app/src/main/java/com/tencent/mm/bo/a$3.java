package com.tencent.mm.bo;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import com.tencent.mm.bj.a.e;
import com.tencent.mm.view.footer.SelectColorBar;

class a$3 implements AnimationListener {
    final /* synthetic */ a vAf;

    a$3(a aVar) {
        this.vAf = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.vAf.vzW.cAi().setVisibility(0);
        EditText editText = (EditText) this.vAf.vzW.cAi().findViewById(e.gWv);
        editText.requestFocus();
        editText.setSelection(editText.length());
        this.vAf.vzW.fds.aD(true);
        ((SelectColorBar) this.vAf.vzW.findViewById(e.vbC)).Hu(editText.getCurrentTextColor());
        this.vAf.vzW.cAh().post(new 1(this));
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}

package android.support.design.widget;

import android.view.View;
import android.view.View.OnClickListener;

class c$1 implements OnClickListener {
    final /* synthetic */ c fB;

    c$1(c cVar) {
        this.fB = cVar;
    }

    public final void onClick(View view) {
        if (this.fB.isShowing()) {
            this.fB.cancel();
        }
    }
}

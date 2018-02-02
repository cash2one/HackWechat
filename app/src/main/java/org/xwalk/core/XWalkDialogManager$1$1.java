package org.xwalk.core;

import android.view.View;
import android.view.View.OnClickListener;
import org.xwalk.core.XWalkDialogManager.1;

class XWalkDialogManager$1$1 implements OnClickListener {
    final /* synthetic */ 1 this$1;
    final /* synthetic */ Runnable val$command;

    XWalkDialogManager$1$1(1 1, Runnable runnable) {
        this.this$1 = 1;
        this.val$command = runnable;
    }

    public void onClick(View view) {
        this.this$1.this$0.dismissDialog();
        this.val$command.run();
    }
}

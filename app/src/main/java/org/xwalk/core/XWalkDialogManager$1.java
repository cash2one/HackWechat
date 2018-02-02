package org.xwalk.core;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Iterator;
import org.xwalk.core.XWalkDialogManager.ButtonAction;

class XWalkDialogManager$1 implements OnShowListener {
    final /* synthetic */ XWalkDialogManager this$0;
    final /* synthetic */ ArrayList val$actions;
    final /* synthetic */ AlertDialog val$dialog;

    XWalkDialogManager$1(XWalkDialogManager xWalkDialogManager, ArrayList arrayList, AlertDialog alertDialog) {
        this.this$0 = xWalkDialogManager;
        this.val$actions = arrayList;
        this.val$dialog = alertDialog;
    }

    public void onShow(DialogInterface dialogInterface) {
        Iterator it = this.val$actions.iterator();
        while (it.hasNext()) {
            ButtonAction buttonAction = (ButtonAction) it.next();
            Button button = this.val$dialog.getButton(buttonAction.mWhich);
            if (button == null) {
                if (buttonAction.mMandatory) {
                    throw new RuntimeException("Button " + buttonAction.mWhich + " is mandatory");
                }
            } else if (buttonAction.mClickAction != null) {
                button.setOnClickListener(new 1(this, buttonAction.mClickAction));
            }
        }
    }
}

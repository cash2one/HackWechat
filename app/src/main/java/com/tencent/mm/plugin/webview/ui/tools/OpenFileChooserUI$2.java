package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class OpenFileChooserUI$2 implements OnCancelListener {
    final /* synthetic */ OpenFileChooserUI twU;

    OpenFileChooserUI$2(OpenFileChooserUI openFileChooserUI) {
        this.twU = openFileChooserUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.twU.setResult(0);
        this.twU.finish();
    }
}

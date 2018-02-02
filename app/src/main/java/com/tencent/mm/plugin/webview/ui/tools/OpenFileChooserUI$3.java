package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class OpenFileChooserUI$3 implements OnClickListener {
    final /* synthetic */ OpenFileChooserUI twU;

    OpenFileChooserUI$3(OpenFileChooserUI openFileChooserUI) {
        this.twU = openFileChooserUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.twU.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}

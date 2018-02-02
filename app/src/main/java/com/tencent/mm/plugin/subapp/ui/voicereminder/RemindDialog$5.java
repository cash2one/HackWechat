package com.tencent.mm.plugin.subapp.ui.voicereminder;

import com.tencent.mm.sdk.platformtools.bh;

class RemindDialog$5 implements Runnable {
    final /* synthetic */ RemindDialog rYR;

    RemindDialog$5(RemindDialog remindDialog) {
        this.rYR = remindDialog;
    }

    public final void run() {
        CharSequence stringBuffer = new StringBuffer();
        for (String str : RemindDialog.a(this.rYR)) {
            if (bh.ov(str)) {
                stringBuffer.append("\n\n");
            } else {
                stringBuffer.append(str + "\n\n");
            }
        }
        if (RemindDialog.d(this.rYR) != null) {
            RemindDialog.d(this.rYR).setMessage(stringBuffer);
        }
    }
}

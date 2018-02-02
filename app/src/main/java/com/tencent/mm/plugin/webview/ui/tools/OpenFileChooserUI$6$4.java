package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6;
import com.tencent.mm.sdk.platformtools.x;

class OpenFileChooserUI$6$4 implements Runnable {
    final /* synthetic */ String jjz;
    final /* synthetic */ 6 twV;
    final /* synthetic */ String twY;

    OpenFileChooserUI$6$4(6 6, String str, String str2) {
        this.twV = 6;
        this.jjz = str;
        this.twY = str2;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_media_callback_type", 1);
        intent.putExtra("key_pick_local_media_local_id", this.jjz);
        intent.putExtra("key_pick_local_media_thumb_local_id", this.twY);
        x.i("MicroMsg.OpenFileChooserUI", "thumbLocalId:%s", new Object[]{this.twY});
        this.twV.twU.setResult(-1, intent);
        this.twV.twU.finish();
    }
}

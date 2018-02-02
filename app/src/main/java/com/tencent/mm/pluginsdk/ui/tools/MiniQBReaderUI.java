package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.xweb.x5.sdk.d;

@a(3)
public class MiniQBReaderUI extends MMActivity {
    private int ret = -1;
    private String vxJ = Integer.toString(hashCode());

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        x.i("MicroMsg.MiniQBReaderUI", "onCreate");
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("file_path");
        String stringExtra2 = intent.getStringExtra("file_ext");
        this.ret = s.a(this, stringExtra, stringExtra2, this.vxJ, new 1(this));
        x.i("MicroMsg.MiniQBReaderUI", "tryOpenByQbSdk , ret:%b", new Object[]{Integer.valueOf(this.ret)});
        new StringBuilder("tryOpenByQbSdk , ret:").append(this.ret);
        Intent intent2 = new Intent();
        intent2.setAction("MINIQB_OPEN_RET");
        intent2.putExtra("file_path", stringExtra);
        intent2.putExtra("file_ext", stringExtra2);
        stringExtra2 = "MINIQB_OPEN_RET_VAL";
        if (this.ret != 0) {
            z = false;
        }
        intent2.putExtra(stringExtra2, z);
        sendBroadcast(intent2, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
        if (this.ret != 0) {
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        x.i("MicroMsg.MiniQBReaderUI", "onNewIntent");
    }

    protected void onDestroy() {
        x.i("MicroMsg.MiniQBReaderUI", "onDestroy");
        if (this.ret == 0) {
            try {
                d.closeFileReader(this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MiniQBReaderUI", e, "", new Object[0]);
            }
        }
        super.onDestroy();
    }
}

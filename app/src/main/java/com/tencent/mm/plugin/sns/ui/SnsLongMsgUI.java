package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;

public class SnsLongMsgUI extends MMActivity {
    private Button rjv;

    public void onDestroy() {
        super.onDestroy();
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(8);
        this.rjv = (Button) findViewById(f.qCC);
        this.rjv.setOnClickListener(new 1(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        Intent intent = new Intent();
        intent.setClass(this, SnsUploadUI.class);
        intent.putExtra("KSnsPostManu", true);
        intent.putExtra("KTouchCameraTime", bh.Wo());
        intent.putExtra("sns_comment_type", 1);
        intent.putExtra("Ksnsupload_type", 9);
        startActivity(intent);
        finish();
        return true;
    }

    protected final int getLayoutId() {
        return g.qGw;
    }
}

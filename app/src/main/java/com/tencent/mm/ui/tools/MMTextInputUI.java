package com.tencent.mm.ui.tools;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.k;

public class MMTextInputUI extends MMActivity {
    private int gBI;
    private int kDC;
    private EditText yig;
    private TextView zlB;
    private int zlC;
    private boolean zlD;

    public int getLayoutId() {
        return h.gXl;
    }

    private void goBack() {
        if (getIntent().getBooleanExtra("key_show_confirm", false)) {
            com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(k.gYG), "", new 1(this), null);
            return;
        }
        aWs();
        setResult(0);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyDown(i, keyEvent);
        }
        x.i("MicroMsg.MMTextInputUI", "on back key down");
        goBack();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.yig = (EditText) findViewById(g.gWv);
        this.zlB = (TextView) findViewById(g.gWp);
        this.yig.setHint(bh.az(getIntent().getStringExtra("key_hint"), ""));
        this.yig.append(bh.az(getIntent().getStringExtra("key_value"), ""));
        this.gBI = getIntent().getIntExtra("key_max_count", -1) << 1;
        this.kDC = 0;
        this.zlC = Math.max(this.gBI - 120, (this.gBI * 9) / 10);
        this.zlD = getIntent().getBooleanExtra("key_nullable", false);
        setBackBtn(new 2(this));
        a(0, getString(k.dFl), new 3(this), b.xJz);
        enableOptionMenu(this.zlD);
        if (!this.zlD || this.gBI > 0) {
            this.yig.addTextChangedListener(new 4(this));
        }
    }

    public void y(CharSequence charSequence) {
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}

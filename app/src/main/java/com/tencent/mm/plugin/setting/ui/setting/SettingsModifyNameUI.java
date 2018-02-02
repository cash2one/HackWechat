package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

public class SettingsModifyNameUI extends MMActivity implements a {
    private r ilH = null;
    private boolean laa = false;
    private c lae = new 1(this);
    private MMEditText lbj;
    private b qgQ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xef.b(this.lae);
        initView();
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.xef.c(this.lae);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dse;
    }

    protected final void initView() {
        setMMTitle(R.l.dse);
        this.lbj = (MMEditText) findViewById(R.h.cMw);
        MMEditText mMEditText = this.lbj;
        ar.Hg();
        mMEditText.setText(i.b(this, (String) com.tencent.mm.z.c.CU().get(4, null), this.lbj.getTextSize()));
        this.lbj.setSelection(this.lbj.getText().length());
        this.lbj.addTextChangedListener(new 2(this));
        com.tencent.mm.ui.tools.a.c fi = com.tencent.mm.ui.tools.a.c.d(this.lbj).fi(1, 32);
        fi.znM = false;
        fi.a(null);
        a(0, getString(R.l.dGx), new 3(this), p.b.xJz);
        enableOptionMenu(false);
        setBackBtn(new 4(this));
    }

    public final void uY(String str) {
        x.i("MiroMsg.SettingsModifyNameUI", "Set New NickName : " + str);
        this.laa = true;
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.ilH = h.a(context, getString(R.l.dUD), false, null);
        this.qgQ = q.q(2, str);
    }

    public final void amI() {
        h.h(this, R.l.eLR, R.l.eLT);
    }

    public final void aem() {
        h.h(this, R.l.eLS, R.l.eLT);
    }
}

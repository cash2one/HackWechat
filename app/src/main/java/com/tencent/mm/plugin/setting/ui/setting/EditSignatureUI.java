package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;

public class EditSignatureUI extends MMActivity {
    private r ilH = null;
    private boolean laa = false;
    private c lae = new 1(this);
    private TextView qgF;
    private MMEditText qgP;
    private b qgQ;
    final bi qgR = bi.HQ();

    private class a implements TextWatcher {
        final /* synthetic */ EditSignatureUI qgS;
        private int qgT;

        private a(EditSignatureUI editSignatureUI) {
            this.qgS = editSignatureUI;
            this.qgT = 60;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.qgS.enableOptionMenu(true);
        }

        public final void afterTextChanged(Editable editable) {
            this.qgT = h.aY(60, editable.toString());
            if (this.qgT < 0) {
                this.qgT = 0;
            }
            if (this.qgS.qgF != null) {
                this.qgS.qgF.setText(this.qgT);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dfA;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xef.b(this.lae);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xef.c(this.lae);
    }

    protected final void initView() {
        setMMTitle(R.l.eMY);
        this.qgP = (MMEditText) findViewById(R.h.content);
        this.qgF = (TextView) findViewById(R.h.cZH);
        ar.Hg();
        this.qgP.setText(i.b(this, bh.ou((String) com.tencent.mm.z.c.CU().get(12291, null)), this.qgP.getTextSize()));
        this.qgP.setSelection(this.qgP.getText().length());
        this.qgF.setText(h.aY(60, this.qgP.getEditableText().toString()));
        com.tencent.mm.ui.tools.a.c.d(this.qgP).fi(0, 60).a(null);
        this.qgP.addTextChangedListener(new a());
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ EditSignatureUI qgS;

            {
                this.qgS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qgS.aWs();
                this.qgS.finish();
                return true;
            }
        });
        a(0, getString(R.l.dGx), new 3(this), p.b.xJz);
        enableOptionMenu(false);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}

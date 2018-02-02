package com.tencent.mm.ui.bindmobile;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class BindMContactStatusUI extends MMWizardActivity {
    private Button krY;
    private ImageView xSW;
    private TextView xSX;
    private TextView ylO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dLm);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dbh;
    }

    protected final void initView() {
        this.xSW = (ImageView) findViewById(R.h.bNm);
        this.ylO = (TextView) findViewById(R.h.bNk);
        this.xSX = (TextView) findViewById(R.h.bNi);
        this.krY = (Button) findViewById(R.h.bNl);
        if (m.NN() == a.hwi) {
            this.xSW.setImageResource(R.k.dyZ);
            ar.Hg();
            String str = (String) c.CU().get(6, null);
            if (str == null || str.equals("")) {
                ar.Hg();
                str = (String) c.CU().get(4097, null);
            }
            this.xSX.setText(getString(R.l.dLj));
            this.ylO.setText(getString(R.l.dLD, new Object[]{str}));
        } else {
            this.xSW.setImageResource(R.k.dza);
            this.xSX.setText(R.l.dLt);
            this.ylO.setText(R.l.dLt);
            this.xSX.setVisibility(8);
        }
        this.krY.setOnClickListener(new 1(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        DU(1);
        return true;
    }
}

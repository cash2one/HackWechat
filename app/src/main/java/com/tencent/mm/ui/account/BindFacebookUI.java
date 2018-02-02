package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.i.a;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

public class BindFacebookUI extends MMWizardActivity implements e {
    private OnCancelListener jWm;
    private c xNv;
    private ProgressDialog xNw;
    private g xNx;

    static /* synthetic */ void lZ(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new a(32, z ? "0" : "1"));
        ar.Hg();
        com.tencent.mm.z.c.EX().b(new i(arrayList));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(183, this);
        initView();
    }

    protected void onPause() {
        super.onPause();
        ar.CG().b(183, this);
    }

    protected final int getLayoutId() {
        return R.i.dbb;
    }

    protected final void initView() {
        this.xNv = new c("290293790992170");
        this.jWm = new 1(this);
        addTextOptionMenu(0, getString(R.l.dFu), new 2(this));
        setMMTitle(R.l.dKy);
        TextView textView = (TextView) findViewById(R.h.cLO);
        textView.setVisibility(4);
        textView.setText(R.l.dKx);
        Button button = (Button) findViewById(R.h.bNc);
        button.setVisibility(0);
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindFacebookUI xNy;

            {
                this.xNy = r1;
            }

            public final void onClick(View view) {
                this.xNy.xNv.a(this.xNy, FacebookAuthUI.xNO, new a(this.xNy, (byte) 0));
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 183) {
            if (this.xNw != null) {
                this.xNw.dismiss();
            }
            if (!com.tencent.mm.plugin.c.a.ift.a(this.mController.xIM, i, i2, str)) {
                int i3 = ((g) kVar).opType;
                if (i == 0 && i2 == 0) {
                    if (i3 == 1) {
                        ar.Hg();
                        com.tencent.mm.z.c.Fd().WX("facebookapp");
                        ar.Hg();
                        com.tencent.mm.z.c.Fa().ED("facebookapp");
                    }
                    DU(1);
                } else if (i == 4 && i2 == -67) {
                    Toast.makeText(this, R.l.eef, 1).show();
                } else if (i == 4 && i2 == -5) {
                    Toast.makeText(this, i3 == 1 ? R.l.eeb : R.l.eeg, 1).show();
                } else {
                    Toast.makeText(this, i3 == 0 ? R.l.dUV : R.l.dUS, 1).show();
                }
            }
        }
    }
}

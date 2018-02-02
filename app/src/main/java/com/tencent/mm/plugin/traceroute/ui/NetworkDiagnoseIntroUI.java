package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class NetworkDiagnoseIntroUI extends MMActivity {
    private TextView sfA;
    private Button sfz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.sfz = (Button) findViewById(R.h.cPf);
        this.sfz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NetworkDiagnoseIntroUI sfB;

            {
                this.sfB = r1;
            }

            public final void onClick(View view) {
                ar.Hg();
                if (!c.isSDCardAvailable()) {
                    u.fI(this.sfB);
                } else if (ar.CG().Km() == 0) {
                    Toast.makeText(this.sfB, this.sfB.getString(R.l.eiE), 0).show();
                } else {
                    this.sfB.startActivity(new Intent(this.sfB, NetworkDiagnoseUI.class));
                    this.sfB.finish();
                }
            }
        });
        this.sfA = (TextView) findViewById(R.h.czi);
        this.sfA.setOnClickListener(new 2(this));
        setMMTitle("");
        setBackBtn(new 3(this));
    }

    protected final int getLayoutId() {
        return R.i.doT;
    }
}

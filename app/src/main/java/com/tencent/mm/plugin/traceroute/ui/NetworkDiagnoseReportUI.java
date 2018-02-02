package com.tencent.mm.plugin.traceroute.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public class NetworkDiagnoseReportUI extends MMActivity {
    private static String seO;
    private boolean sfC = false;
    private Button sfD;
    private Button sfE;
    private ImageView sfF;
    private TextView sfG;
    private TextView sfH;
    private TextView sfI;

    static /* synthetic */ String a(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        String string = networkDiagnoseReportUI.getString(R.l.eEz);
        File file = new File(seO);
        if (!file.exists()) {
            return string;
        }
        String name = file.getName();
        if (bh.ov(name)) {
            return string;
        }
        int indexOf = name.indexOf(".");
        StringBuilder append = new StringBuilder().append(string).append("_");
        if (indexOf <= 0) {
            indexOf = name.length();
        }
        return append.append(name.substring(0, indexOf)).toString();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle("");
        this.sfF = (ImageView) findViewById(R.h.cHE);
        this.sfG = (TextView) findViewById(R.h.cHH);
        this.sfH = (TextView) findViewById(R.h.cHG);
        this.sfC = getIntent().getBooleanExtra("diagnose_result", false);
        if (this.sfC) {
            this.sfF.setImageResource(R.g.bEe);
            this.sfG.setText(getString(R.l.eSi));
            this.sfH.setVisibility(0);
            addTextOptionMenu(0, getString(R.l.dYD), new OnMenuItemClickListener(this) {
                final /* synthetic */ NetworkDiagnoseReportUI sfJ;

                {
                    this.sfJ = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.sfJ.finish();
                    return false;
                }
            });
            return;
        }
        setBackBtn(new 2(this));
        seO = getIntent().getStringExtra("diagnose_log_file_path");
        this.sfF.setImageResource(R.g.bEd);
        this.sfG.setText(getString(R.l.eSh));
        if (seO != null && e.bN(seO) > 0) {
            this.sfI = (TextView) findViewById(R.h.cHF);
            this.sfI.setText(getString(R.l.eEA, new Object[]{seO.replace("mnt/", "")}));
            findViewById(R.h.cHF).setVisibility(0);
            findViewById(R.h.cLt).setVisibility(0);
            this.sfD = (Button) findViewById(R.h.cLu);
            this.sfD.setVisibility(0);
            this.sfD.setOnClickListener(new 3(this));
            this.sfE = (Button) findViewById(R.h.cVM);
            this.sfE.setVisibility(0);
            this.sfE.setOnClickListener(new 4(this));
        }
    }

    protected final int getLayoutId() {
        return R.i.doU;
    }
}

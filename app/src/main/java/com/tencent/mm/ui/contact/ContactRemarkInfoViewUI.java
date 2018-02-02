package com.tencent.mm.ui.contact;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;

public class ContactRemarkInfoViewUI extends MMActivity {
    private String bgp;
    private String fWy;
    private String hKt;
    private x jLe;
    private int phF;
    private String username;
    private TextView yRG;
    private TextView yRH;
    private ImageView yRK;
    private boolean yRQ = false;
    private View ySi;
    private View ySj;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.phF = getIntent().getIntExtra("Contact_Scene", 9);
        this.username = getIntent().getStringExtra("Contact_User");
        if (t.ov(this.username)) {
            finish();
            return;
        }
        WT();
        initView();
    }

    public void onResume() {
        super.onResume();
        WT();
        this.yRG.setText(i.b(this, t.ou(this.bgp), this.yRG.getTextSize()));
        if (t.ov(this.fWy)) {
            this.ySi.setVisibility(8);
        } else {
            this.ySi.setVisibility(0);
            this.yRH.setText(t.ou(this.fWy));
        }
        if (t.ov(this.hKt)) {
            this.ySj.setVisibility(8);
            return;
        }
        this.ySj.setVisibility(0);
        c.QL();
        if (c.lP(this.username)) {
            cvO();
        } else {
            c.QL().a(this.username, this.hKt, new 4(this));
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.deX;
    }

    private void WT() {
        ar.Hg();
        this.jLe = com.tencent.mm.z.c.EY().WO(this.username);
        this.bgp = this.jLe.AQ();
        this.fWy = this.jLe.fWy;
        this.hKt = this.jLe.fWz;
    }

    protected final void initView() {
        this.yRG = (TextView) findViewById(R.h.bXP);
        this.yRH = (TextView) findViewById(R.h.bXN);
        this.yRK = (ImageView) findViewById(R.h.cHB);
        this.ySi = findViewById(R.h.bYo);
        this.ySj = findViewById(R.h.bYp);
        setMMTitle(R.l.dVF);
        this.yRK.setOnClickListener(new 1(this));
        addTextOptionMenu(0, getString(R.l.dEF), new 2(this));
        setBackBtn(new 3(this));
    }

    private void cvO() {
        Bitmap lR = c.QL().lR(this.username);
        if (lR != null) {
            this.yRK.setImageBitmap(lR);
            this.yRQ = true;
        }
    }
}

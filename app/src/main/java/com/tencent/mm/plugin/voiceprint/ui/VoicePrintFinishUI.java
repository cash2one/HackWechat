package com.tencent.mm.plugin.voiceprint.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class VoicePrintFinishUI extends MMActivity {
    private TextView jJn;
    private TextView shX;
    private Button shY;
    private ImageView shZ;
    private int sia;

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.sia = getIntent().getIntExtra("kscene_type", 73);
        x.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", Integer.valueOf(this.sia));
        this.jJn = (TextView) findViewById(R.h.cWE);
        this.shX = (TextView) findViewById(R.h.cWG);
        this.shY = (Button) findViewById(R.h.cId);
        this.shZ = (ImageView) findViewById(R.h.cWD);
        switch (this.sia) {
            case 72:
                this.jJn.setText(R.l.eTL);
                this.shX.setText(R.l.eTM);
                this.shZ.setVisibility(0);
                this.shY.setText(R.l.eNR);
                break;
            case 73:
                this.jJn.setVisibility(8);
                this.shX.setText(R.l.eTY);
                this.shZ.setVisibility(0);
                this.shY.setText(R.l.eNS);
                break;
        }
        this.shY.setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dtC;
    }
}

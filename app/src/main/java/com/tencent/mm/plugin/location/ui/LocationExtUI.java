package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p.b;
import java.util.ArrayList;

public class LocationExtUI extends MMActivity {
    private ArrayList<String> lHG = new ArrayList();
    private TextView nSC;
    private TextView nSD;
    private String nSE;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CharSequence stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (bh.ov(stringExtra)) {
            findViewById(R.h.ctR).setVisibility(8);
        } else {
            ((TextView) findViewById(R.h.cud)).setText(stringExtra);
        }
        this.nSC = (TextView) findViewById(R.h.cQf);
        this.nSD = (TextView) findViewById(R.h.cHz);
        this.nSC.setOnClickListener(new 1(this));
        this.nSD.setOnClickListener(new 2(this));
        a(0, getString(R.l.dFl), new 3(this), b.xJz);
        setBackBtn(new 4(this));
    }

    protected final int getLayoutId() {
        return R.i.dmG;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (4097 == i) {
            if (-1 == i2 && intent != null) {
                CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
                this.nSE = charSequenceExtra == null ? "" : charSequenceExtra.toString();
                this.nSD.setText(this.nSE);
            }
        } else if (4098 != i) {
            super.onActivityResult(i, i2, intent);
        } else if (-1 == i2 && intent != null) {
            this.lHG.clear();
            String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                CharSequence charSequence = stringArrayExtra[0];
                this.lHG.add(stringArrayExtra[0]);
                String string = getResources().getString(R.l.egK);
                for (int i3 = 1; i3 < stringArrayExtra.length; i3++) {
                    this.lHG.add(stringArrayExtra[i3]);
                    charSequence = charSequence + string + stringArrayExtra[i3];
                }
                this.nSC.setText(charSequence);
            }
        }
    }
}

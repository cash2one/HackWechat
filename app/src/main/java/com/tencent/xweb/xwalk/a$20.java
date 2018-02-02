package com.tencent.xweb.xwalk;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.xweb.k;

class a$20 implements OnCheckedChangeListener {
    final /* synthetic */ a Asx;

    a$20(a aVar) {
        this.Asx = aVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        k cIo = k.cIo();
        if (z != cIo.Aqi) {
            cIo.Aqi = z;
            cIo.Aqf.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", cIo.Aqi).commit();
        }
        if (z) {
            this.Asx.cIW();
            this.Asx.Ass.setVisibility(0);
        } else if (this.Asx.Ass != null) {
            this.Asx.Ass.setVisibility(8);
        }
    }
}

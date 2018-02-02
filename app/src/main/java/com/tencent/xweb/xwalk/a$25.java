package com.tencent.xweb.xwalk;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.xweb.g.a;
import com.tencent.xweb.k;
import org.xwalk.core.Log;
import org.xwalk.core.R;

class a$25 implements OnCheckedChangeListener {
    final /* synthetic */ a Asx;

    a$25(a aVar) {
        this.Asx = aVar;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        a aVar = a.ApS;
        if (i == R.id.v8_auto) {
            aVar = a.ApS;
        } else if (i == R.id.v8_sys) {
            aVar = a.ApT;
        } else if (i == R.id.v8_x5) {
            aVar = a.ApX;
        } else if (i == R.id.v8_nativescript) {
            aVar = a.ApZ;
        } else if (i == R.id.v8_mmv8) {
            aVar = a.Aqa;
        }
        k.cIo().a(aVar);
        Log.d("WebDebugPage", "v8 type change to=" + aVar);
    }
}

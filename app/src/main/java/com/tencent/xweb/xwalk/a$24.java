package com.tencent.xweb.xwalk;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.k;
import org.xwalk.core.Log;
import org.xwalk.core.R;
import org.xwalk.core.R$array;

class a$24 implements OnCheckedChangeListener {
    final /* synthetic */ a Asx;

    a$24(a aVar) {
        this.Asx = aVar;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (!this.Asx.Asv) {
            c cVar = c.AqA;
            if (i == R.id.WV_AUTO) {
                cVar = c.AqA;
            } else if (i == R.id.WV_XWALK) {
                cVar = c.AqB;
            } else if (i == R.id.WV_X5) {
                cVar = c.AqC;
            } else if (i == R.id.WV_SYS) {
                cVar = c.AqD;
            }
            if (this.Asx.Asw.equals("all")) {
                String[] stringArray = this.Asx.Aqf.getResources().getStringArray(R$array.webviewmodules);
                for (int i2 = 0; i2 < stringArray.length; i2++) {
                    k.cIo().a(stringArray[i2], cVar);
                    Log.d("WebDebugPage", "webview " + stringArray[i2] + " change to=" + cVar);
                }
                return;
            }
            k.cIo().a(this.Asx.Asw, cVar);
            Log.d("WebDebugPage", "webview change to=" + cVar);
        }
    }
}

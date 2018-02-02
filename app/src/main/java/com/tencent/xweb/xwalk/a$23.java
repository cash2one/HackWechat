package com.tencent.xweb.xwalk;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioButton;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.k;
import org.xwalk.core.R;
import org.xwalk.core.R$array;

class a$23 implements OnItemSelectedListener {
    final /* synthetic */ a Asx;

    a$23(a aVar) {
        this.Asx = aVar;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 1;
        String[] stringArray = this.Asx.Aqf.getResources().getStringArray(R$array.webviewuimodules);
        this.Asx.Asw = stringArray[i];
        a aVar = this.Asx;
        aVar.Asv = true;
        if (aVar.Asw.equals("all")) {
            String[] stringArray2 = aVar.Aqf.getResources().getStringArray(R$array.webviewmodules);
            c aco = k.cIo().aco(stringArray2[0]);
            while (i2 < stringArray2.length) {
                if (k.cIo().aco(stringArray2[i2]) != aco) {
                    ((RadioButton) aVar.Asu.findViewById(R.id.WV_AUTO)).setChecked(false);
                    ((RadioButton) aVar.Asu.findViewById(R.id.WV_XWALK)).setChecked(false);
                    ((RadioButton) aVar.Asu.findViewById(R.id.WV_X5)).setChecked(false);
                    ((RadioButton) aVar.Asu.findViewById(R.id.WV_SYS)).setChecked(false);
                    break;
                }
                i2++;
            }
            aVar.e(aco);
        } else {
            aVar.e(k.cIo().aco(aVar.Asw));
        }
        aVar.Asv = false;
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}

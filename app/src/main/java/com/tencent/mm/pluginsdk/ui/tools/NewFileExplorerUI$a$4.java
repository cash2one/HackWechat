package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.R;
import com.tencent.mm.k.b;
import com.tencent.mm.k.g;
import com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import java.io.File;

class NewFileExplorerUI$a$4 implements OnClickListener {
    final /* synthetic */ a vxU;

    NewFileExplorerUI$a$4(a aVar) {
        this.vxU = aVar;
    }

    public final void onClick(View view) {
        File file = this.vxU.vwN[((Integer) view.getTag()).intValue()];
        CheckBox checkBox = (CheckBox) view.findViewById(R.h.crK);
        if (a.a(this.vxU).contains(file)) {
            a.a(this.vxU).remove(file);
            checkBox.setChecked(false);
        } else if (a.a(this.vxU).size() >= 9) {
            u.makeText(this.vxU.vxQ.mController.xIM, this.vxU.vxQ.getString(R.l.eho, new Object[]{Integer.valueOf(9)}), 0).show();
            checkBox.setChecked(false);
            return;
        } else {
            if (file.length() >= ((long) bh.getInt(g.zY().getValue("InputLimitFileSize"), JceStruct.JCE_MAX_STRING_LENGTH))) {
                u.makeText(this.vxU.vxQ.mController.xIM, this.vxU.vxQ.getString(R.l.ehn, new Object[]{bh.bx(r2)}), 0).show();
                checkBox.setChecked(false);
                return;
            }
            if (a.aa(file.getName())) {
                com.tencent.mm.pluginsdk.ui.c.a SD = com.tencent.mm.pluginsdk.ui.c.a.SD(file.getPath());
                SD.hX = b.zH();
                if (SD.cci() == 1) {
                    h.h(this.vxU.vxQ.mController.xIM, R.l.eTq, R.l.dGO);
                    checkBox.setChecked(false);
                    return;
                }
            }
            checkBox.setChecked(true);
            a.a(this.vxU).add(file);
        }
        NewFileExplorerUI.h(this.vxU.vxQ);
    }
}

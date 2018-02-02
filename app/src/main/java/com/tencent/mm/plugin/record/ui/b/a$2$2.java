package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.plugin.record.ui.b.a.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.z.u;

class a$2$2 implements d {
    final /* synthetic */ 2 pGI;

    a$2$2(2 2) {
        this.pGI = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 1:
                intent = new Intent();
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", 2.d(this.pGI));
                String hz = u.hz("fav_");
                u.GK().t(hz, true).o("prePublishId", "fav_");
                intent.putExtra("reportSessionId", hz);
                com.tencent.mm.bm.d.b(2.c(this.pGI), "sns", ".ui.SnsUploadUI", intent);
                return;
            case 2:
                intent = new Intent();
                intent.putExtra("Retr_File_Name", 2.d(this.pGI));
                intent.putExtra("Retr_Compress_Type", 0);
                intent.putExtra("Retr_Msg_Type", 0);
                com.tencent.mm.bm.d.a(2.c(this.pGI), ".ui.transmit.MsgRetransmitUI", intent);
                return;
            case 3:
                if (!com.tencent.mm.platformtools.d.a(2.d(this.pGI), 2.c(this.pGI), R.l.dXO)) {
                    Toast.makeText(2.c(this.pGI), 2.c(this.pGI).getString(R.l.egt), 1).show();
                    return;
                }
                return;
            case 4:
                mr mrVar = (mr) this.pGI.pGF.msp.get(2.d(this.pGI));
                if (mrVar != null) {
                    b bzVar = new bz();
                    bzVar.fqa.activity = (Activity) 2.c(this.pGI);
                    bzVar.fqa.fov = mrVar.fED.result;
                    bzVar.fqa.fqb = mrVar.fED.fqb;
                    bzVar.fqa.fqc = mrVar.fED.fqc;
                    a.xef.m(bzVar);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

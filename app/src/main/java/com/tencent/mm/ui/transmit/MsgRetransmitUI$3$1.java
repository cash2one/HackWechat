package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.g;
import com.tencent.mm.aq.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.3;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class MsgRetransmitUI$3$1 implements OnClickListener {
    final /* synthetic */ 3 zoH;

    MsgRetransmitUI$3$1(3 3) {
        this.zoH = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (MsgRetransmitUI.e(this.zoH.zoG) != null) {
            ar.CG().c(MsgRetransmitUI.e(this.zoH.zoG));
            int i2 = (int) MsgRetransmitUI.e(this.zoH.zoG).hBk;
            e hQ = o.Pw().hQ(i2);
            if (hQ != null) {
                g Pw = o.Pw();
                e hQ2 = Pw.hQ(i2);
                if (hQ2 != null && hQ2.hzP == ((long) i2)) {
                    FileOp.deleteFile(Pw.m(hQ2.hzQ, "", ""));
                    FileOp.deleteFile(Pw.m(hQ2.hzS, "", ""));
                    FileOp.deleteFile(Pw.m(hQ2.hzS, "", "") + "hd");
                    Pw.hhp.delete("ImgInfo2", "id=?", new String[]{String.valueOf(i2)});
                    if (hQ2.Pe()) {
                        e hQ3 = Pw.hQ(hQ2.hzZ);
                        if (hQ3 != null) {
                            FileOp.deleteFile(Pw.m(hQ3.hzQ, "", ""));
                            FileOp.deleteFile(Pw.m(hQ3.hzS, "", ""));
                            FileOp.deleteFile(Pw.m(hQ3.hzS, "", "") + "hd");
                            Pw.hhp.delete("ImgInfo2", "id=?", new String[]{hQ3.hzP});
                        }
                    }
                }
                ar.Hg();
                c.Fa().dI(hQ.hzX);
            }
        }
        Toast.makeText(this.zoH.zoG, R.l.evL, 1).show();
        this.zoH.zoG.finish();
    }
}

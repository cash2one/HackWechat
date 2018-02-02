package com.tencent.mm.plugin.wenote.model;

import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.e.b.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;

public final class k {
    private static k tRn = null;
    public long duration;
    public b hXN = new b(ac.getContext());
    public long kEb = -1;
    private Toast kEc;
    public boolean kEo;
    public boolean kEp;
    public final ak kEv = new ak(new a(this) {
        final /* synthetic */ k tRs;

        {
            this.tRs = r1;
        }

        public final boolean uF() {
            if (this.tRs.kEb == -1) {
                this.tRs.kEb = bh.Wq();
            }
            long bA = bh.bA(this.tRs.kEb);
            if (bA >= 3590000 && bA <= 3600000) {
                if (this.tRs.kEc == null) {
                    this.tRs.kEc = Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.duo, new Object[]{Integer.valueOf((int) ((3600000 - bA) / 1000))}), 0);
                } else {
                    this.tRs.kEc.setText(ac.getContext().getString(R.l.duo, new Object[]{Integer.valueOf((int) ((3600000 - bA) / 1000))}));
                }
                this.tRs.kEc.show();
            }
            if (bA < 3600000) {
                return true;
            }
            x.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
            this.tRs.kEp = true;
            this.tRs.aJN();
            if (this.tRs.tRp != null) {
                this.tRs.tRp.bVV();
            }
            return false;
        }
    }, true);
    private final af kEx = new af(this) {
        final /* synthetic */ k tRs;

        {
            this.tRs = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.tRs.kEo = false;
        }
    };
    public TextView mvP;
    public long myE;
    public j myL;
    public String path = "";
    public com.tencent.mm.modelvoice.k tRl;
    public String tRm = "";
    public int tRo = 0;
    public com.tencent.mm.plugin.wenote.model.b.a tRp;
    public com.tencent.mm.plugin.wenote.model.a.k tRq = null;
    public final af tRr = new 4(this);

    private k() {
    }

    public static k bVQ() {
        if (tRn == null) {
            tRn = new k();
        }
        return tRn;
    }

    public final void aJN() {
        if (this.kEo) {
            boolean z;
            this.tRr.removeMessages(Downloads.RECV_BUFFER_SIZE);
            if (this.tRm.equals("speex")) {
                this.tRl.vi();
            } else {
                this.myL.vi();
            }
            if (this.hXN != null) {
                this.hXN.zd();
            }
            this.duration = getDuration();
            if (this.duration < 800) {
                z = true;
            } else {
                z = false;
            }
            this.kEv.TG();
            if (z) {
                File file = new File(this.path);
                if (file.exists()) {
                    file.delete();
                }
                this.kEx.sendEmptyMessageDelayed(0, 500);
            }
            this.kEo = false;
        }
    }

    private long getDuration() {
        if (this.myE == 0) {
            return 0;
        }
        return bh.bA(this.myE);
    }

    public static void destroy() {
        tRn = null;
    }

    public static k bVR() {
        return tRn;
    }
}

package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Base64;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.ui.tools.f$a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class RecordMsgFileUI$12 implements f$a {
    final /* synthetic */ RecordMsgFileUI pGq;

    RecordMsgFileUI$12(RecordMsgFileUI recordMsgFileUI) {
        this.pGq = recordMsgFileUI;
    }

    public final void hX() {
        x.d("MicroMsg.RecordMsgFileUI", g.zg() + " onPrepared");
        RecordMsgFileUI.i(this.pGq).cP(true);
        RecordMsgFileUI.i(this.pGq).start();
    }

    public final void onError(int i, int i2) {
        RecordMsgFileUI.i(this.pGq).stop();
        if (!RecordMsgFileUI.j(this.pGq)) {
            RecordMsgFileUI.k(this.pGq);
            final Bitmap b = RecordMsgFileUI.l(this.pGq).b(RecordMsgFileUI.a(this.pGq), RecordMsgFileUI.b(this.pGq));
            final String Ur = RecordMsgFileUI.i(this.pGq).Ur();
            b.z(Base64.encodeToString((d.bsC() + "[RecordMsgFileUI] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + bh.az(Ur, "")).getBytes(), 2), "FullScreenPlaySight");
            ag.y(new Runnable(this) {
                final /* synthetic */ RecordMsgFileUI$12 pGv;

                public final void run() {
                    ImageView imageView = (ImageView) this.pGv.pGq.findViewById(R.h.cVH);
                    imageView.setImageBitmap(b);
                    imageView.setVisibility(0);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(Ur)), "video/*");
                    try {
                        this.pGv.pGq.startActivity(Intent.createChooser(intent, this.pGv.pGq.getString(R.l.egS)));
                    } catch (Exception e) {
                        x.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                        h.h(this.pGv.pGq.mController.xIM, R.l.efS, R.l.efT);
                    }
                }
            });
        }
    }

    public final void vh() {
    }

    public final int cf(int i, int i2) {
        return 0;
    }

    public final void cg(int i, int i2) {
    }
}

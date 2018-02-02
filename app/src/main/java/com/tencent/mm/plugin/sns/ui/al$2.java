package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.ui.c;
import com.tencent.mm.sdk.platformtools.x;

class al$2 implements OnClickListener {
    final /* synthetic */ al rxo;

    al$2(al alVar) {
        this.rxo = alVar;
    }

    public final void onClick(View view) {
        if (FileOp.bO(this.rxo.videoPath)) {
            if (this.rxo.rxn != null) {
                this.rxo.rxn.dismiss();
                this.rxo.rxn = null;
            }
            this.rxo.rxn = new c(this.rxo.fmM);
            c cVar = this.rxo.rxn;
            String str = this.rxo.videoPath;
            String str2 = this.rxo.fvC;
            cVar.hDC = str;
            cVar.imagePath = str2;
            cVar = this.rxo.rxn;
            cVar.fJB = 0;
            cVar.qtX = 0;
            cVar.msn = 1;
            this.rxo.rxn.show();
            return;
        }
        x.i("MicroMsg.SightWidget", "click videopath is not exist " + this.rxo.videoPath);
    }
}

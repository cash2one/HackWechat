package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.g.a;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;

class ArtistUI$3 implements a {
    final /* synthetic */ ArtistUI rqX;

    ArtistUI$3(ArtistUI artistUI) {
        this.rqX = artistUI;
    }

    public final void a(dp dpVar) {
        if (ArtistUI.b(this.rqX) != null) {
            ArtistUI.b(this.rqX).setVisibility(0);
            ArtistHeader b = ArtistUI.b(this.rqX);
            if (dpVar == null) {
                x.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
            } else {
                b.rqI = dpVar;
                ae.bvs().b(dpVar.vIP.vIQ, b.rqN.ihQ, b.context.hashCode(), an.xyY);
                b.rqN.rqS.setText(dpVar.nfp);
                b.rqN.iXX.setText(dpVar.vIO);
                b.rqN.ihS.setText(dpVar.fon);
                b.rqN.rqT.setText(dpVar.vIN);
            }
            String str = dpVar.nfp;
            if (!(str == null || str.equals(""))) {
                ArtistUI.c(this.rqX).edit().putString("artist_name", str).commit();
            }
            if (ArtistUI.d(this.rqX) != null) {
                ArtistUI.d(this.rqX).notifyDataSetChanged();
            }
        }
        ArtistUI.e(this.rqX).dismiss();
    }

    public final void byV() {
        if (ArtistUI.f(this.rqX) == null && ArtistUI.e(this.rqX) != null) {
            x.d("MicroMsg.ArtistUI", "onNothingBgGet");
            com.tencent.mm.plugin.sns.c.a.ift.aH(true);
        }
    }
}

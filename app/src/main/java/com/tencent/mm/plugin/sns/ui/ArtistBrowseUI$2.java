package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.ui.s.a;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

class ArtistBrowseUI$2 implements a {
    final /* synthetic */ ArtistBrowseUI rqM;

    ArtistBrowseUI$2(ArtistBrowseUI artistBrowseUI) {
        this.rqM = artistBrowseUI;
    }

    public final void byW() {
        aqr bzo = this.rqM.ryY.bzo();
        if (bzo != null) {
            x.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + bzo.nGJ);
            b iu = b.iu(723);
            iu.mB(bzo.nfX);
            iu.Sx();
            if (FileOp.bO(am.r(ae.getAccSnsPath(), bzo.nGJ) + i.l(bzo))) {
                av bvr = ae.bvr();
                if (!(bvr.bvb() == null || bvr.bvb().equals(""))) {
                    String str = am.r(ae.getAccSnsPath(), bzo.nGJ) + i.l(bzo);
                    String r = am.r(ae.getAccSnsPath(), bvr.bvb());
                    if (FileOp.bO(str)) {
                        x.d("MicroMsg.UploadManager", "bg file is exist!'");
                        FileOp.mh(r);
                        FileOp.deleteFile(r + bvr.bvb() + "bg_");
                        FileOp.deleteFile(r + bvr.bvb() + "tbg_");
                        FileOp.x(str, r + bvr.bvb() + "bg_");
                    } else {
                        FileOp.deleteFile(r + bvr.bvb() + "bg_");
                        FileOp.deleteFile(r + bvr.bvb() + "tbg_");
                        x.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
                    }
                    l bvz = ae.bvz();
                    r = bvr.bvb();
                    String str2 = bzo.nGJ;
                    k Lq = bvz.Lq(r);
                    Lq.field_bgId = str2;
                    bvz.c(Lq);
                }
                bvr.bwd();
                aw awVar = new aw(7);
                bzo.wxK = 1;
                awVar.qYq.wQo.vYd.add(bzo);
                awVar.wN(2);
                awVar.commit();
                Intent intent = new Intent();
                intent.setClass(this.rqM, SettingSnsBackgroundUI.class);
                intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.addFlags(67108864);
                this.rqM.startActivity(intent);
                this.rqM.finish();
            }
        }
    }
}

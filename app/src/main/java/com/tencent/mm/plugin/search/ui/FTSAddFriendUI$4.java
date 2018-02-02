package com.tencent.mm.plugin.search.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.search.a;
import com.tencent.mm.pluginsdk.ui.tools.c;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

class FTSAddFriendUI$4 implements e {
    final /* synthetic */ FTSAddFriendUI qbQ;

    FTSAddFriendUI$4(FTSAddFriendUI fTSAddFriendUI) {
        this.qbQ = fTSAddFriendUI;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(106, this);
        if (i == 0 && i2 == 0) {
            FTSAddFriendUI.a(this.qbQ, ((ac) kVar).So());
            if (FTSAddFriendUI.e(this.qbQ).wkk > 0) {
                if (FTSAddFriendUI.e(this.qbQ).wkl.isEmpty()) {
                    h.a(this.qbQ, R.l.dDd, 0, true, null);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("add_more_friend_search_scene", 3);
                if (FTSAddFriendUI.e(this.qbQ).wkl.size() > 1) {
                    try {
                        intent.putExtra("result", FTSAddFriendUI.e(this.qbQ).toByteArray());
                        a.ifs.w(intent, this.qbQ.mController.xIM);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.FTS.FTSAddFriendUI", e, "", new Object[0]);
                    }
                } else {
                    c.a(intent, (bek) FTSAddFriendUI.e(this.qbQ).wkl.getFirst(), this.qbQ.qbP);
                }
            }
            FTSAddFriendUI.a(this.qbQ, 1);
            FTSAddFriendUI.f(this.qbQ);
        } else {
            switch (i2) {
                case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                    com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                    if (eA == null) {
                        FTSAddFriendUI.d(this.qbQ).setText(R.l.eya);
                        break;
                    } else {
                        FTSAddFriendUI.d(this.qbQ).setText(eA.desc);
                        break;
                    }
                case -4:
                    if (i != 4) {
                        FTSAddFriendUI.d(this.qbQ).setText(this.qbQ.getString(R.l.ejf));
                        break;
                    }
                default:
                    FTSAddFriendUI.d(this.qbQ).setText(R.l.eya);
                    break;
            }
            FTSAddFriendUI.a(this.qbQ, -1);
            FTSAddFriendUI.b(this.qbQ, 1);
        }
        FTSAddFriendUI.g(this.qbQ);
    }
}

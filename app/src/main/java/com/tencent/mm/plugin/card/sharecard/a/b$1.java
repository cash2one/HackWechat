package com.tencent.mm.plugin.card.sharecard.a;

import android.database.Cursor;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class b$1 implements Runnable {
    final /* synthetic */ String kMZ;
    final /* synthetic */ af kNa;

    b$1(String str, af afVar) {
        this.kMZ = str;
        this.kNa = afVar;
    }

    public final void run() {
        ArrayList arrayList = null;
        x.i("MicroMsg.ShareCardDataMgr", "begin to getShareUserInfo()");
        k auI = am.auI();
        String str = this.kMZ;
        x.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        Cursor a = auI.gJP.a("select * from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            x.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo(), cursor == null");
        } else {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            while (a.moveToNext()) {
                ShareCardInfo shareCardInfo = new ShareCardInfo();
                shareCardInfo.b(a);
                r rVar;
                if (arrayList3.contains(shareCardInfo.field_from_username)) {
                    int i = 0;
                    rVar = null;
                    while (i < arrayList2.size()) {
                        rVar = (r) arrayList2.get(i);
                        if (shareCardInfo.field_from_username != null && shareCardInfo.field_from_username.equals(rVar.kNz)) {
                            break;
                        }
                        i++;
                    }
                    i = 0;
                    if (rVar != null) {
                        rVar.kNA.add(0, shareCardInfo.field_card_id);
                        rVar.cNH++;
                        arrayList2.set(i, rVar);
                    }
                } else {
                    rVar = new r();
                    rVar.kJN = shareCardInfo.field_card_tp_id;
                    rVar.kNz = shareCardInfo.field_from_username;
                    rVar.kNA = new ArrayList();
                    rVar.kNA.add(shareCardInfo.field_card_id);
                    rVar.cNH = 1;
                    arrayList2.add(rVar);
                    arrayList3.add(shareCardInfo.field_from_username);
                }
            }
            a.close();
            arrayList = arrayList2;
        }
        x.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 1");
        if (arrayList == null || arrayList.size() == 0) {
            x.e("MicroMsg.ShareCardDataMgr", "getShareUserInfo(), share_user_list is null");
            return;
        }
        if (arrayList.get(0) != null) {
            ((r) arrayList.get(0)).kNB = true;
        }
        x.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 2");
        this.kNa.post(new 1(this, arrayList));
    }
}

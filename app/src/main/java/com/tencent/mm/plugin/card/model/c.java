package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class c extends i<CardInfo> {
    public static final String[] gJN = new String[]{i.a(CardInfo.gJc, "UserCardInfo"), "CREATE INDEX IF NOT EXISTS  stickyIndexIndex ON UserCardInfo ( stickyIndex ) "};
    public e gJP;

    public c(e eVar) {
        super(eVar, CardInfo.gJc, "UserCardInfo", null);
        this.gJP = eVar;
    }

    public final Cursor nH(int i) {
        this.gJP.fx("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 where stickyIndex>0 and (" + bh.Wo() + ">stickyEndTime and stickyEndTime" + "<>0)");
        StringBuilder stringBuilder = new StringBuilder("select * from UserCardInfo");
        switch (1.kKX[i - 1]) {
            case 1:
                stringBuilder.append(" where (status=0 OR ").append("status=5)");
                break;
            case 2:
            case 3:
                stringBuilder.append(" where (status=0 OR ").append("status=5) AND ").append("card_type=10");
                break;
            case 4:
                stringBuilder.append(" where (status=0 OR ").append("status=5) AND ").append("card_type!=10");
                break;
            case 5:
                stringBuilder.append(" where (status=1 OR ").append("status=2 OR status").append("=3 OR status=4").append(" OR status=6)");
                break;
            case 6:
                stringBuilder.append(" where (status=0 OR ").append("status=5) and (block_mask").append("= '1' OR block_mask= '0' ").append(")");
                break;
        }
        stringBuilder.append(" order by stickyIndex desc, status asc , updateTime desc");
        if (i == a.kLL) {
            stringBuilder.append(" LIMIT 3");
        }
        return this.gJP.rawQuery(stringBuilder.toString(), null);
    }

    public final CardInfo wf(String str) {
        com.tencent.mm.sdk.e.c cardInfo = new CardInfo();
        cardInfo.field_card_id = str;
        return super.b(cardInfo, new String[0]) ? cardInfo : null;
    }

    public final List<CardInfo> aup() {
        Cursor rawQuery = this.gJP.rawQuery("select * from UserCardInfo where is_dynamic=?", new String[]{"1"});
        if (rawQuery == null) {
            x.e("MicroMsg.CardInfoStorage", "getCardInfoList by is_dynamic is failure! cu is null!");
            return null;
        }
        List<CardInfo> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            try {
                CardInfo cardInfo = new CardInfo();
                cardInfo.b(rawQuery);
                arrayList.add(cardInfo);
            } catch (Exception e) {
                x.e("MicroMsg.CardInfoStorage", new StringBuilder("getCardInfoList by is_dynamic is failure! is_dynamic = true").toString(), new Object[]{e.getMessage()});
                return arrayList;
            } finally {
                rawQuery.close();
            }
        }
        return arrayList;
    }
}

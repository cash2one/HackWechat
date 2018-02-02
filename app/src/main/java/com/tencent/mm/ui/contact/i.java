package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.e.a;
import com.tencent.mm.ag.e.a.b;
import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i extends LinearLayout implements a {
    private Context context;
    private LinearLayout muI = null;
    private List<String> ySr;
    private Map<String, View> ySs;
    private a ySt;

    public i(Context context, a aVar) {
        super(context);
        this.context = context;
        this.ySt = aVar;
        init();
    }

    public final int cvT() {
        if (this.ySr == null) {
            return 0;
        }
        return this.ySr.size();
    }

    private void init() {
        int i = 0;
        e Mf = y.Mf();
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        e.a(stringBuilder);
        e.c(stringBuilder);
        stringBuilder.append(" and bizinfo.type").append(" = 2 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(e.LI());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", stringBuilder.toString());
        Cursor rawQuery = Mf.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        this.ySr = arrayList;
        if (this.ySr == null || this.ySr.size() <= 0) {
            x.e("MicroMsg.EnterpriseBizView", "bizList is null");
            return;
        }
        x.i("MicroMsg.EnterpriseBizView", "biz list size = %s", Integer.valueOf(this.ySr.size()));
        this.ySs = new HashMap();
        if (this.muI == null) {
            View.inflate(getContext(), R.i.dgk, this);
            this.muI = (LinearLayout) findViewById(R.h.bYF);
        }
        while (i < this.ySr.size()) {
            String str = (String) this.ySr.get(i);
            View jVar = new j(getContext(), str);
            this.muI.addView(jVar);
            this.ySs.put(str, jVar);
            if (i == this.ySr.size() - 1) {
                jVar.findViewById(R.h.ceB).setBackgroundResource(R.g.bDJ);
            }
            i++;
        }
    }

    public final void a(b bVar) {
        if (bVar.hpE != null) {
            if (bVar.hpE.Le()) {
                ag.y(new 1(this, bVar));
            } else {
                x.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
            }
        }
    }
}

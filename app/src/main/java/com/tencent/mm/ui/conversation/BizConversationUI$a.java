package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.w;
import com.tencent.mm.ag.y;
import com.tencent.mm.bq.a;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.qa;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.Map.Entry;

public class BizConversationUI$a extends BaseConversationUI$b {
    private ae conversation;
    private TextView emptyTipTv;
    private String hog;
    private boolean isDeleteCancel = false;
    private int kGp = 0;
    private int kGq = 0;
    private i kGt;
    private d onK = new 8(this);
    private c pRe = new 9(this);
    private String talker = "";
    private r tipDialog = null;
    private ListView yWg;
    private a yWh;
    private String yWi;
    private long yWj = 0;

    static /* synthetic */ void a(BizConversationUI$a bizConversationUI$a) {
        if (ar.Hj() && "officialaccounts".equals(bizConversationUI$a.hog)) {
            int i;
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            long j = 0;
            StringBuilder stringBuilder = new StringBuilder("");
            ar.Hg();
            Cursor c = com.tencent.mm.z.c.Fd().c(s.hfk, null, bizConversationUI$a.hog);
            if (c != null) {
                int columnIndex = c.getColumnIndex("unReadCount");
                int columnIndex2 = c.getColumnIndex("conversationTime");
                int columnIndex3 = c.getColumnIndex("flag");
                int count = c.getCount();
                ae aeVar = new ae();
                while (c.moveToNext()) {
                    aeVar.ak(c.getLong(columnIndex3));
                    i = c.getInt(columnIndex);
                    if (i > 0) {
                        j = c.getLong(columnIndex2);
                        i3++;
                        i2 += i;
                    } else {
                        i = 0;
                    }
                    stringBuilder.append(c.isFirst() ? "" : ".").append(i);
                    ar.Hg();
                    if (com.tencent.mm.z.c.Fd().g(aeVar)) {
                        i4++;
                    }
                }
                c.close();
                i = i2;
                i2 = i3;
                i3 = i4;
                i4 = count;
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            g.pQN.h(13771, new Object[]{Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j / 1000), Integer.valueOf(i3), stringBuilder.toString()});
            x.v("MicroMsg.BizConversationUI", "report use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }

    static /* synthetic */ void a(BizConversationUI$a bizConversationUI$a, int i) {
        if (i <= 0) {
            bizConversationUI$a.emptyTipTv.setVisibility(0);
            bizConversationUI$a.yWg.setVisibility(8);
            return;
        }
        bizConversationUI$a.emptyTipTv.setVisibility(8);
        bizConversationUI$a.yWg.setVisibility(0);
    }

    static /* synthetic */ void b(BizConversationUI$a bizConversationUI$a) {
        if (bizConversationUI$a.yWj != 0 && "officialaccounts".equals(bizConversationUI$a.hog)) {
            g.pQN.h(13932, new Object[]{Integer.valueOf(((int) (System.currentTimeMillis() - bizConversationUI$a.yWj)) / 1000)});
        }
    }

    static /* synthetic */ void b(BizConversationUI$a bizConversationUI$a, String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.BizConversationUI", "Delete Conversation and messages fail because username is null or nil.");
            return;
        }
        if ("officialaccounts".equals(bizConversationUI$a.hog)) {
            g.pQN.h(13773, new Object[]{Integer.valueOf(0), Integer.valueOf(bizConversationUI$a.conversation.field_unReadCount), Integer.valueOf(0), bizConversationUI$a.conversation.field_username});
        }
        ar.Hg();
        cf Ew = com.tencent.mm.z.c.Fa().Ew(str);
        a qaVar = new qa();
        qaVar.vYI = new bdo().UA(bh.ou(str));
        qaVar.vHe = Ew.field_msgSvrId;
        ar.Hg();
        com.tencent.mm.z.c.EX().b(new e.a(8, qaVar));
        bizConversationUI$a.isDeleteCancel = false;
        Context thisActivity = bizConversationUI$a.thisActivity();
        bizConversationUI$a.getString(R.l.dGO);
        ba.a(str, new 7(bizConversationUI$a, h.a(thisActivity, bizConversationUI$a.getString(R.l.dHc), true, new 6(bizConversationUI$a))));
        ar.Hg();
        af WO = com.tencent.mm.z.c.EY().WO(str);
        ar.Hg();
        aj WY = com.tencent.mm.z.c.Fd().WY(str);
        ar.Hg();
        com.tencent.mm.z.c.Fd().WX(str);
        if (WY == null) {
            return;
        }
        if (WY.gc(4194304) || (WO != null && WO.cia() && !com.tencent.mm.l.a.fZ(WO.field_type) && WY.field_conversationTime < y.Mr())) {
            ar.CG().a(new com.tencent.mm.modelsimple.i(str), 0);
        }
    }

    static /* synthetic */ void c(BizConversationUI$a bizConversationUI$a) {
        if (bizConversationUI$a.yWh != null) {
            LinkedList linkedList = new LinkedList();
            for (Entry entry : bizConversationUI$a.yWh.yWl.entrySet()) {
                b bVar = (b) entry.getValue();
                bcd com_tencent_mm_protocal_c_bcd = new bcd();
                com_tencent_mm_protocal_c_bcd.vNg = (String) entry.getKey();
                com_tencent_mm_protocal_c_bcd.wIq = bVar.wIq;
                com_tencent_mm_protocal_c_bcd.wIr = bVar.wIr;
                com_tencent_mm_protocal_c_bcd.njV = bVar.njV;
                com_tencent_mm_protocal_c_bcd.wIt = bVar.yWm > 0;
                com_tencent_mm_protocal_c_bcd.wIv = bVar.wIv;
                com_tencent_mm_protocal_c_bcd.wIs = bVar.wIs;
                com_tencent_mm_protocal_c_bcd.wIu = bVar.wIu;
                linkedList.add(com_tencent_mm_protocal_c_bcd);
            }
            com.tencent.mm.kernel.g.Di().gPJ.a(new w(linkedList), 0);
            x.d("MicroMsg.BizConversationUI", "reportExpose size:%d", new Object[]{Integer.valueOf(linkedList.size())});
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hog = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
        if (bh.ov(this.hog)) {
            this.hog = "officialaccounts";
        }
        if (bh.ou(this.hog).equals("officialaccounts")) {
            g.pQN.k(11404, "");
        }
        this.yWi = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
        if (bh.ov(this.yWi)) {
            this.yWi = getString(R.l.dMj);
        }
        setMMTitle(this.yWi);
        this.yWg = (ListView) findViewById(R.h.cSv);
        this.emptyTipTv = (TextView) findViewById(R.h.cem);
        this.emptyTipTv.setText(R.l.ebz);
        setBackBtn(new 11(this));
        setToTop(new 12(this));
        this.yWh = new a(thisActivity(), this.hog, new 13(this));
        this.yWh.a(new 14(this));
        this.yWh.a(new 15(this));
        this.yWg.setAdapter(this.yWh);
        this.kGt = new i(thisActivity());
        this.yWg.setOnItemClickListener(new 16(this));
        this.yWg.setOnTouchListener(new 17(this));
        this.yWg.setOnItemLongClickListener(new 2(this));
        this.yWh.a(new 3(this));
        this.yWh.a(new 4(this));
        this.yWh.a(new 5(this));
        if ("officialaccounts".equals(this.hog)) {
            com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100045");
            boolean z = fn.isValid() && "1".equals(fn.chI().get("isOpenSearch"));
            x.d("MicroMsg.BizConversationUI", "open search entrance:%b", new Object[]{Boolean.valueOf(z)});
            if (z) {
                addIconOptionMenu(1, R.l.eRj, R.k.dva, new 1(this));
            }
        }
        ar.Hg();
        com.tencent.mm.z.c.Fd().a(this.yWh);
        this.yWj = System.currentTimeMillis();
        com.tencent.mm.sdk.b.a.xef.b(this.pRe);
    }

    protected final int getLayoutId() {
        return R.i.dsZ;
    }

    public final String getUserName() {
        return this.hog;
    }

    public final void onDestroy() {
        ar.Dm().F(new 10(this));
        com.tencent.mm.sdk.b.a.xef.c(this.pRe);
        if (ar.Hj()) {
            ar.Hg();
            com.tencent.mm.z.c.Fd().b(this.yWh);
        }
        if (this.yWh != null) {
            this.yWh.onDestroy();
        }
        super.onDestroy();
    }

    public final void onResume() {
        x.v("MicroMsg.BizConversationUI", "on resume");
        if (this.yWh != null) {
            this.yWh.onResume();
        }
        super.onResume();
    }

    public final void onPause() {
        x.i("MicroMsg.BizConversationUI", "on pause");
        ar.Hg();
        com.tencent.mm.z.c.Fd().Xa(this.hog);
        if (this.yWh != null) {
            this.yWh.onPause();
        }
        super.onPause();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!(this.talker == null || this.talker.isEmpty())) {
            this.talker = "";
        }
        if (i2 == -1) {
        }
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ar.Hg();
        af WO = com.tencent.mm.z.c.EY().WO(this.talker);
        if (WO == null) {
            x.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
            return;
        }
        CharSequence AQ = WO.AQ();
        if (AQ.toLowerCase().endsWith("@chatroom") && bh.ov(WO.field_nickname)) {
            AQ = getString(R.l.dSN);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(thisActivity(), AQ));
        if (com.tencent.mm.l.a.fZ(WO.field_type)) {
            if (WO.AL()) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.eum);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.dXb);
            }
            contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.eui);
        }
        contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.eup);
    }
}

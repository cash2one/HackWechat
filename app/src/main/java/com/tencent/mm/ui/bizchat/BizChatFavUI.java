package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.a.b.a;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.s;
import com.tencent.mm.ag.n;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.hj;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.ar;

public class BizChatFavUI extends MMActivity implements n {
    private TextView emptyTipTv;
    private boolean isCurrentActivity;
    private r jLf;
    private ListView kBO;
    private d kBR;
    private long kGB;
    private String kGH;
    private a ynG;
    private com.tencent.mm.ag.a.d.a ynH;
    private c ynM;

    static /* synthetic */ void a(BizChatFavUI bizChatFavUI, long j) {
        x.i("MicroMsg.BizChatFavUI", "deleteFromFav");
        c ag = y.Mh().ag(j);
        ag.field_bitFlag &= -9;
        x.i("MicroMsg.BizChatFavUI", "deleteFromFav:bitFlag %s", Integer.valueOf(ag.field_bitFlag));
        hj hjVar = new hj();
        hjVar.vNk = ag.field_bizChatServId;
        hjVar.vNm = ag.field_bitFlag;
        y.Ml();
        bizChatFavUI.jLf = h.a(bizChatFavUI, "", false, new 4(bizChatFavUI, com.tencent.mm.ag.a.h.a(ag.field_brandUserName, hjVar, (n) bizChatFavUI)));
    }

    static /* synthetic */ void b(BizChatFavUI bizChatFavUI, long j) {
        Intent intent = new Intent(bizChatFavUI, ChattingUI.class);
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", bizChatFavUI.kGH);
        intent.putExtra("key_biz_chat_id", j);
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_need_send_video", false);
        intent.putExtra("key_is_biz_chat", true);
        bizChatFavUI.startActivity(intent);
        ag.h(new 5(bizChatFavUI), 500);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kGH = getIntent().getStringExtra("Contact_User");
        x.i("MicroMsg.BizChatFavUI", "[regitListener]");
        this.ynG = new 1(this);
        this.ynH = new 6(this);
        y.Mi().a(this.ynG, getMainLooper());
        y.Mh().a(this.ynH, getMainLooper());
        initView();
        y.Ml();
        g.Di().gPJ.a(new s(this.kGH), 0);
    }

    protected final int getLayoutId() {
        return R.i.dgs;
    }

    public void onDestroy() {
        x.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
        y.Mi().a(this.ynG);
        y.Mh().a(this.ynH);
        this.ynM.aUn();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        ar.Hg();
        af WO = com.tencent.mm.z.c.EY().WO(this.kGH);
        if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type)) {
            finish();
            return;
        }
        setTitleMuteIconVisibility(8);
        this.isCurrentActivity = true;
        this.ynM.a(null, null);
        ar.getNotification().eo(this.kGH);
    }

    public void onPause() {
        this.ynM.onPause();
        this.isCurrentActivity = false;
        ar.getNotification().eo("");
        super.onPause();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.kGB = ((c) this.ynM.getItem(adapterContextMenuInfo.position)).field_bizChatLocalId;
        contextMenu.add(adapterContextMenuInfo.position, 0, 1, R.l.dMr);
    }

    public final void a(int i, k kVar) {
        if (this.jLf != null) {
            this.jLf.dismiss();
        }
    }

    protected final void initView() {
        this.kBO = (ListView) findViewById(R.h.cSv);
        this.emptyTipTv = (TextView) findViewById(R.h.cem);
        this.emptyTipTv.setText(R.l.dMq);
        this.kBO.setOnScrollListener(new 8(this));
        this.ynM = new c(this, new 9(this), this.kGH);
        this.ynM.a(new MMSlideDelView.c(this) {
            final /* synthetic */ BizChatFavUI ynN;

            {
                this.ynN = r1;
            }

            public final int ci(View view) {
                return this.ynN.kBO.getPositionForView(view);
            }
        });
        this.ynM.a(new f(this) {
            final /* synthetic */ BizChatFavUI ynN;

            {
                this.ynN = r1;
            }

            public final void t(View view, int i) {
                this.ynN.kBO.performItemClick(view, i, 0);
            }
        });
        this.ynM.a(new e(this) {
            final /* synthetic */ BizChatFavUI ynN;

            {
                this.ynN = r1;
            }

            public final void bo(Object obj) {
                if (obj == null) {
                    x.e("MicroMsg.BizChatFavUI", "onItemDel object null");
                }
            }
        });
        this.kBO.setAdapter(this.ynM);
        this.kBR = new d(this) {
            final /* synthetic */ BizChatFavUI ynN;

            {
                this.ynN = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        BizChatFavUI.a(this.ynN, this.ynN.kGB);
                        return;
                    default:
                        return;
                }
            }
        };
        this.kBO.setOnItemLongClickListener(new 2(this, new l(this)));
        this.kBO.setOnItemClickListener(new 3(this));
        setBackBtn(new 7(this));
    }
}

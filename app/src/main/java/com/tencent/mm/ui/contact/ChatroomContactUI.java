package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;

public class ChatroomContactUI extends MMActivity implements e, a {
    private int kGp = 0;
    private int kGq = 0;
    private i kGt;
    private d kZW = new d(new OnScrollListener(this) {
        final /* synthetic */ ChatroomContactUI yRt;

        {
            this.yRt = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    private p.d lVO = new p.d(this) {
        final /* synthetic */ ChatroomContactUI yRt;

        {
            this.yRt = r1;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                    ChatroomContactUI.Zz(this.yRt.yQl);
                    return;
                default:
                    return;
            }
        }
    };
    private TextView mrJ;
    private ListView nPx;
    private VoiceSearchLayout xGp;
    private b yQj;
    private String yQl;
    private ContactCountView yQw;
    private com.tencent.mm.pluginsdk.ui.tools.p yRr;
    private d yRs;

    static /* synthetic */ void Zz(String str) {
        ar.Hg();
        x WO = c.EY().WO(str);
        WO.Ah();
        s.t(WO);
        if (s.eV(str)) {
            ar.Hg();
            c.EY().WU(str);
            ar.Hg();
            c.Fh().hJ(str);
            return;
        }
        ar.Hg();
        c.EY().a(str, WO);
    }

    static /* synthetic */ void a(ChatroomContactUI chatroomContactUI, String str) {
        if (str == null || str.length() <= 0) {
            if (chatroomContactUI.yQw != null) {
                chatroomContactUI.yQw.setVisible(true);
            }
        } else if (chatroomContactUI.yQw != null) {
            chatroomContactUI.yQw.setVisible(false);
        }
        if (str == null || str.length() == 0) {
            chatroomContactUI.nPx.setAdapter(chatroomContactUI.yRs);
            chatroomContactUI.nPx.setBackgroundColor(chatroomContactUI.getResources().getColor(R.e.btP));
            chatroomContactUI.yRs.notifyDataSetChanged();
            chatroomContactUI.yQj.ny(false);
            chatroomContactUI.yRs.Xy();
            return;
        }
        chatroomContactUI.nPx.setAdapter(chatroomContactUI.yQj);
        chatroomContactUI.nPx.setBackgroundColor(chatroomContactUI.getResources().getColor(R.e.white));
        chatroomContactUI.yQj.ny(true);
        b bVar = chatroomContactUI.yQj;
        String aah = b.aah(str);
        if (!(aah == null || aah.equals(bVar.zqy))) {
            bVar.ac(new b$10(bVar));
        }
        bVar.zqy = aah;
        bVar.ynf = null;
        if (bVar.zqy == null) {
            bVar.zqy = "";
        }
        bVar.aUn();
        bVar.Xy();
        chatroomContactUI.yQj.notifyDataSetChanged();
    }

    static /* synthetic */ void b(ChatroomContactUI chatroomContactUI, String str) {
        if (str != null && str.length() > 0) {
            if (s.hd(str)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomContactUI", "error, 4.5 do not contain this contact %s", str);
                return;
            }
            Intent intent = new Intent(chatroomContactUI.mController.xIM, ChattingUI.class);
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", str);
            intent.putExtra("Chat_Mode", 1);
            chatroomContactUI.mController.xIM.startActivity(intent);
            if (str != null && str.length() > 0) {
                e.a(intent, str);
                chatroomContactUI.startActivity(intent);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dcM;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dCN);
        initView();
        ar.CG().a(138, (e) this);
        ar.Hg();
        c.EY().a(this.yRs);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        ar.Hg();
        if (c.EY().WO(this.yQl) == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.yQl);
        } else if (s.gC(this.yQl)) {
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(view.getContext(), r.gu(this.yQl)));
            contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.dCR);
        }
    }

    public final void initView() {
        ((TextView) findViewById(R.h.cex)).setVisibility(8);
        this.nPx = (ListView) findViewById(R.h.bJe);
        this.nPx.setAdapter(null);
        this.mrJ = (TextView) findViewById(R.h.cex);
        this.mrJ.setText(R.l.dCT);
        String str = "@all.chatroom.contact";
        this.yRs = new d(this, str);
        this.yRs.lU(true);
        this.yQj = new b(this.mController.xIM, 1);
        this.yQj.yPI = str;
        this.yRr = new com.tencent.mm.pluginsdk.ui.tools.p((byte) 0);
        this.yRr.a(new 7(this));
        a(this.yRr);
        this.yRs.a(new 8(this));
        this.yRs.a(new 9(this));
        this.yRs.a(new 10(this));
        this.nPx.setOnScrollListener(this.kZW);
        this.yRs.vnS = this.kZW;
        this.kGt = new i(this.mController.xIM);
        this.nPx.setOnItemClickListener(new 11(this));
        this.nPx.setOnItemLongClickListener(new 12(this));
        this.nPx.setOnTouchListener(new 13(this));
        ListView listView = this.nPx;
        View contactCountView = new ContactCountView(this);
        this.yQw = contactCountView;
        listView.addFooterView(contactCountView, null, false);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ChatroomContactUI yRt;

            {
                this.yRt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.yRt.finish();
                return false;
            }
        });
        addIconOptionMenu(0, R.l.dCm, R.k.duO, new OnMenuItemClickListener(this) {
            final /* synthetic */ ChatroomContactUI yRt;

            {
                this.yRt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(this.yRt, SelectContactUI.class);
                intent.putExtra("titile", this.yRt.getString(R.l.dDn));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", s.p(new int[]{s.yTF, 256, WXMediaMessage.TITLE_LENGTH_LIMIT}));
                this.yRt.mController.xIM.startActivity(intent);
                return false;
            }
        });
        4 4 = new 4(this);
        this.nPx.setAdapter(this.yRs);
        this.yQj.ny(false);
        this.nPx.setVisibility(0);
        this.xGp = new VoiceSearchLayout(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.xGp.setLayoutParams(layoutParams);
        this.xGp.BV(BackwardSupportUtil.b.b((Context) this, 100.0f));
        this.xGp.setVisibility(8);
        ((ViewGroup) findViewById(R.h.cXh)).addView(this.xGp);
        if (this.xGp != null) {
            this.xGp.vmB = new 5(this);
        }
        if (this.yRs.getCount() == 0) {
            this.mrJ.setSingleLine(false);
            this.mrJ.setPadding(40, 0, 40, 0);
            this.mrJ.setVisibility(0);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.yQw != null) {
            this.yQw.yRv = 2;
            this.yQw.cvM();
        }
        ar.Hg();
        c.Fh().c(this);
        if (!(this.yRr == null || this.xGp == null)) {
            com.tencent.mm.bm.d.ccW();
            if (com.tencent.mm.ar.b.PT() || !w.cfi().equals("zh_CN")) {
                this.yRr.vyU = false;
            } else {
                this.yRr.vyU = true;
                this.yRr.o(this.xGp);
            }
        }
        if (this.yQj != null) {
            this.yQj.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        ar.Hg();
        c.Fh().j(this);
        if (this.yRr != null) {
            com.tencent.mm.pluginsdk.ui.tools.p pVar = this.yRr;
            pVar.cxX();
            pVar.cancel();
        }
        if (this.yQj != null) {
            this.yQj.onPause();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(138, (e) this);
        ar.Hg();
        c.EY().b(this.yRs);
        d dVar = this.yRs;
        if (dVar.hvU != null) {
            dVar.hvU.detach();
            dVar.hvU = null;
        }
        this.yRs.aUn();
        this.yRs.xIi = null;
        this.yQj.detach();
        this.yQj.aUn();
    }

    private void aVf() {
        if (this.yRs != null) {
            this.yRs.a(null, null);
        }
        if (this.yQj != null) {
            this.yQj.a(null, null);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (t.bF(this) && !com.tencent.mm.ui.t.a.a(this, i, i2, str, 4) && i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 138:
                    aVf();
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(String str, l lVar) {
        if (this.yQw != null) {
            this.yQw.yRv = 2;
            this.yQw.cvM();
        }
    }
}

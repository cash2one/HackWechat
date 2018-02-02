package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o$a;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.k;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class BottleConversationUI extends MMActivity {
    private TextView emptyTipTv;
    private boolean isDeleteCancel = false;
    private ListView kBO;
    private a kBP;
    private String kBQ;
    private d kBR = new 2(this);
    private String talker;
    private r tipDialog = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dsZ;
    }

    public void onDestroy() {
        this.kBP.aUn();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        ar.Hg();
        c.EY().a(this.kBP);
        ar.Hg();
        c.Fd().a(this.kBP);
        this.kBP.a(null, null);
    }

    public void onPause() {
        ar.Hg();
        c.EY().b(this.kBP);
        ar.Hg();
        c.Fd().b(this.kBP);
        ar.Hg();
        cf su = c.Fa().su(8);
        if (su != null && su.field_msgId > 0) {
            x.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + su.field_createTime);
            ar.Hg();
            c.CU().set(12306, Long.valueOf(su.field_createTime));
        }
        ar.Hg();
        aj WY = c.Fd().WY("floatbottle");
        if (WY == null || bh.ou(WY.field_username).length() <= 0) {
            x.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
        } else {
            WY.eO(0);
            ar.Hg();
            if (c.Fd().a(WY, WY.field_username) == -1) {
                x.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
            }
        }
        this.kBP.onPause();
        super.onPause();
    }

    protected final void initView() {
        int FW = q.FW() | Downloads.RECV_BUFFER_SIZE;
        int Gd = q.Gd() & -65;
        ar.Hg();
        c.CU().set(7, Integer.valueOf(FW));
        ar.Hg();
        c.CU().set(34, Integer.valueOf(Gd));
        this.kBO = (ListView) findViewById(R.h.cSv);
        this.emptyTipTv = (TextView) findViewById(R.h.cem);
        this.emptyTipTv.setText(R.l.dMK);
        this.kBP = new a(this, new o$a(this) {
            final /* synthetic */ BottleConversationUI kBS;

            {
                this.kBS = r1;
            }

            public final void Xv() {
                BottleConversationUI bottleConversationUI = this.kBS;
                String string = this.kBS.getString(R.l.dMN);
                int FO = k.FO();
                if (FO <= 0) {
                    bottleConversationUI.setMMTitle(string);
                } else {
                    bottleConversationUI.setMMTitle(string + "(" + FO + ")");
                }
                if (this.kBS.kBP.getCount() <= 0) {
                    this.kBS.emptyTipTv.setVisibility(0);
                    this.kBS.kBO.setVisibility(8);
                    return;
                }
                this.kBS.emptyTipTv.setVisibility(8);
                this.kBS.kBO.setVisibility(0);
            }

            public final void Xw() {
            }
        });
        this.kBP.a(new 4(this));
        this.kBP.a(new 5(this));
        this.kBP.a(new 6(this));
        this.kBO.setAdapter(this.kBP);
        final l lVar = new l(this);
        this.kBO.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ BottleConversationUI kBS;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.kBS.kBO.getHeaderViewsCount()) {
                    x.w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.kBS, this.kBS.kBR);
                }
                return true;
            }
        });
        this.kBO.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BottleConversationUI kBS;

            {
                this.kBS = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ae aeVar = (ae) this.kBS.kBP.getItem(i);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", aeVar.field_username);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                a.ifs.e(intent, this.kBS);
            }
        });
        a.ift.um();
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleConversationUI kBS;

            {
                this.kBS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kBS.finish();
                return true;
            }
        });
        String stringExtra = getIntent().getStringExtra("conversation_from");
        if (bh.ov(stringExtra) && bh.ov(this.kBQ)) {
            addTextOptionMenu(0, getString(R.l.dXj), new 10(this));
        } else if (!bh.ov(stringExtra)) {
            this.kBQ = stringExtra;
        }
        11 11 = new 11(this);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.talker = ((ae) this.kBP.getItem(adapterContextMenuInfo.position)).field_username;
        int i = R.l.dMG;
        Object[] objArr = new Object[1];
        a aVar = this.kBP;
        ar.Hg();
        objArr[0] = aVar.A(c.EY().WO(this.talker));
        contextMenu.setHeaderTitle(getString(i, objArr));
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dMH);
    }
}

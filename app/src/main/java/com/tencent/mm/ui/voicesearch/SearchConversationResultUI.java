package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.o.a;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.LinkedList;

public class SearchConversationResultUI extends MMActivity {
    private TextView lgL;
    private String username;
    private ListView zqu;
    private a zqv;
    private String zqw = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.zqu = (ListView) findViewById(R.h.cWX);
        this.lgL = (TextView) findViewById(R.h.cex);
        this.zqv = new a(getApplicationContext(), new a(this) {
            final /* synthetic */ SearchConversationResultUI zqx;

            {
                this.zqx = r1;
            }

            public final void Xw() {
            }

            public final void Xv() {
            }
        });
        if (this.zqv != null) {
            this.zqv.dr(new LinkedList());
        }
        this.zqu.setAdapter(this.zqv);
        this.lgL.setVisibility(8);
        this.username = getIntent().getStringExtra("SearchConversationResult_User");
        this.zqw = getIntent().getStringExtra("SearchConversationResult_Error");
        setMMTitle(getString(R.l.dtH));
        setBackBtn(new 2(this));
        this.zqu.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SearchConversationResultUI zqx;

            {
                this.zqx = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.zqx.zqu.getHeaderViewsCount()) {
                    int headerViewsCount = i - this.zqx.zqu.getHeaderViewsCount();
                    ae aeVar = (ae) this.zqx.zqv.getItem(headerViewsCount);
                    if (aeVar == null) {
                        x.e("MicroMsg.VoiceSearchResultUI", "null user at position = " + headerViewsCount);
                        return;
                    }
                    x.d("MicroMsg.VoiceSearchResultUI", "username " + aeVar.field_username);
                    if (s.gK(aeVar.field_username)) {
                        if (q.Gl()) {
                            d.b(this.zqx.mController.xIM, "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                            return;
                        }
                        d.b(this.zqx, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (s.gM(aeVar.field_username)) {
                        if (q.Gi()) {
                            d.b(this.zqx.mController.xIM, "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                            return;
                        }
                        d.b(this.zqx, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (s.gL(aeVar.field_username)) {
                        d.b(this.zqx, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (s.gQ(aeVar.field_username)) {
                        MMAppMgr.cancelNotification(aeVar.field_username);
                        d.b(this.zqx, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (s.gI(aeVar.field_username)) {
                        if (q.Gu()) {
                            this.zqx.a(ChattingUI.class, new Intent().putExtra("Chat_User", aeVar.field_username).putExtra("finish_direct", true));
                        } else {
                            d.b(this.zqx, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        }
                    } else if (s.gV(aeVar.field_username)) {
                        if (q.Gp()) {
                            r0 = new Intent();
                            r0.putExtra(DownloadSettingTable$Columns.TYPE, 20);
                            d.b(this.zqx, "readerapp", ".ui.ReaderAppUI", r0);
                            return;
                        }
                        d.b(this.zqx, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (s.hc(aeVar.field_username)) {
                        if (q.Gq()) {
                            r0 = new Intent();
                            r0.putExtra(DownloadSettingTable$Columns.TYPE, 11);
                            d.b(this.zqx, "readerapp", ".ui.ReaderAppUI", r0);
                            return;
                        }
                        d.b(this.zqx, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (s.gN(aeVar.field_username)) {
                        d.b(this.zqx, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (s.gO(aeVar.field_username)) {
                        if (q.Gs()) {
                            d.b(this.zqx, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                            return;
                        }
                        d.b(this.zqx, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else if (s.gU(aeVar.field_username)) {
                        if (q.Gm()) {
                            this.zqx.a(ChattingUI.class, new Intent().putExtra("Chat_User", aeVar.field_username).putExtra("finish_direct", true));
                        } else {
                            d.b(this.zqx, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        }
                    } else if (s.gS(this.zqx.username) || s.gT(this.zqx.username) || s.gP(this.zqx.username) || s.gW(this.zqx.username) || s.gX(this.zqx.username) || s.gJ(this.zqx.username) || s.hf(this.zqx.username)) {
                        d.b(this.zqx, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    } else {
                        this.zqx.a(ChattingUI.class, new Intent().putExtra("Chat_User", aeVar.field_username).putExtra("finish_direct", true));
                    }
                }
            }
        });
        String str = this.username;
        this.lgL.setVisibility(8);
        if (this.zqv != null) {
            this.zqv.CN(str);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.zqv.aUn();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final int getLayoutId() {
        return R.i.dtH;
    }
}

package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;

public class SelectSpecialContactUI extends MMBaseSelectContactUI {
    private int ldq;
    private String title;

    protected final void WT() {
        super.WT();
        this.title = getIntent().getStringExtra("titile");
        this.ldq = getIntent().getIntExtra("list_attr", 0);
    }

    public final void ja(int i) {
        a Gm = cvZ().Gm(i);
        if (Gm != null && Gm.jLe != null) {
            String str = Gm.jLe.field_username;
            x.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", str);
            Intent intent = new Intent();
            if (s.fa(this.ldq, 16384)) {
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
            } else if (s.fa(this.ldq, WXMediaMessage.THUMB_LENGTH_LIMIT)) {
                intent.putExtra("Contact_User", str);
                d.b(this, "profile", ".ui.ContactInfoUI", intent);
                finish();
            } else {
                intent.setClass(this, ChattingUI.class);
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                startActivity(intent);
                finish();
            }
        }
    }

    protected final boolean WU() {
        return false;
    }

    protected final boolean WV() {
        return false;
    }

    protected final String WW() {
        return this.title;
    }

    protected final o WX() {
        return new w(this, getIntent().getStringExtra("filter_type"));
    }

    protected final m WY() {
        return null;
    }
}

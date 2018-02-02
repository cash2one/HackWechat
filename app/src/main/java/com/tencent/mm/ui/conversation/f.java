package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.l.a;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public final class f implements OnCreateContextMenuListener, OnItemLongClickListener {
    private Activity activity;
    private ae conversation = null;
    private p$d onK = new 1(this);
    private String talker = "";
    private ListView yVR;
    private g yWw;
    private int[] yXp = new int[2];

    public f(g gVar, ListView listView, Activity activity, int[] iArr) {
        this.yWw = gVar;
        this.yVR = listView;
        this.activity = activity;
        this.yXp = iArr;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < this.yVR.getHeaderViewsCount()) {
            x.d("MicroMsg.ConversationClickListener", "on long click header view");
            return true;
        }
        this.conversation = (ae) this.yWw.DC(i - this.yVR.getHeaderViewsCount());
        if (this.conversation == null) {
            x.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", new Object[]{Integer.valueOf(this.yVR.getHeaderViewsCount()), Integer.valueOf(i)});
            return true;
        }
        this.talker = this.conversation.field_username;
        new i(this.activity).a(view, i, j, this, this.onK, this.yXp[0], this.yXp[1]);
        if (s.eV(this.talker)) {
            g.pQN.h(14553, new Object[]{Integer.valueOf(1), Integer.valueOf(0), this.talker});
        } else {
            g.pQN.h(14553, new Object[]{Integer.valueOf(0), Integer.valueOf(0), this.talker});
        }
        return true;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = 1;
        ar.Hg();
        af WO = c.EY().WO(this.talker);
        if (WO == null) {
            x.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
            return;
        }
        CharSequence AQ = WO.AQ();
        if (AQ.toLowerCase().endsWith("@chatroom") && t.ov(WO.field_nickname)) {
            AQ = this.activity.getString(R.l.dSN);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(this.activity, AQ));
        if (((this.conversation != null ? 1 : 0) & s.b(this.conversation)) != 0) {
            String str = this.talker;
            ar.Hg();
            aj WY = c.Fd().WY(str);
            if (WY == null) {
                i = 0;
            } else if (WY.field_unReadCount > 0 || WY.gc(1048576)) {
                i = 0;
            }
            if (i != 0) {
                contextMenu.add(adapterContextMenuInfo.position, 8, 0, R.l.eul);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.l.euj);
            }
        }
        if (this.conversation != null && s.a(this.conversation)) {
            ar.Hg();
            if (c.Fd().Xf(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 6, 0, R.l.eum);
            } else if (WO.cia()) {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.l.dXb);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.l.euk);
            }
        }
        if (WO.cia() && a.fZ(WO.field_type) && !s.ho(WO.field_username) && !s.gR(WO.field_username)) {
            d jS = com.tencent.mm.ag.f.jS(WO.field_username);
            if (jS != null && jS.Lb()) {
                contextMenu.add(adapterContextMenuInfo.position, 10, 0, R.l.eui);
            }
        }
        if (this.conversation != null && this.conversation.field_conversationTime != -1) {
            if (s.gK(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.l.eur);
            } else if (s.gL(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.l.euq);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.l.eup);
            }
        }
    }
}

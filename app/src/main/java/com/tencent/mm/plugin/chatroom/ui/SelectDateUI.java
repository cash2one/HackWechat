package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashMap;

public class SelectDateUI extends MMActivity implements a {
    private String jRw;
    private r jmO = null;
    private long laL = -1;
    private DayPickerView ldl;
    private HashMap<String, com.tencent.mm.plugin.chatroom.d.a> ldm;
    private TextView ldn;
    private af mHandler;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(SelectDateUI selectDateUI) {
        long currentTimeMillis = System.currentTimeMillis();
        ar.Hg();
        Cursor Ev = c.Fa().Ev(selectDateUI.jRw);
        try {
            if (Ev.moveToFirst()) {
                while (!Ev.isAfterLast()) {
                    if (-1 == selectDateUI.laL) {
                        selectDateUI.laL = Ev.getLong(0);
                    }
                    com.tencent.mm.plugin.chatroom.d.a aVar = new com.tencent.mm.plugin.chatroom.d.a(Ev.getLong(0));
                    aVar.fqm = Ev.getLong(1);
                    String aVar2 = aVar.toString();
                    if (!selectDateUI.ldm.containsKey(aVar2)) {
                        selectDateUI.ldm.put(aVar2, aVar);
                    }
                    Ev.moveToNext();
                }
            }
            Ev.close();
        } catch (Exception e) {
            x.e("MicroMsg.SelectDateUI", e.toString());
        } catch (Throwable th) {
            Ev.close();
        }
        x.i("MicroMsg.SelectDateUI", "[prepareData] time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eGb);
        this.ldl = (DayPickerView) findViewById(R.h.cCA);
        this.ldn = (TextView) findViewById(R.h.cJR);
        this.ldm = new HashMap();
        this.mHandler = new af(getMainLooper());
        this.jRw = getIntent().getStringExtra("detail_username");
        e.post(new 1(this), "prepare_data");
        setBackBtn(new 2(this));
    }

    protected final int getLayoutId() {
        return R.i.drC;
    }

    public final long axx() {
        return System.currentTimeMillis();
    }

    public final void a(com.tencent.mm.plugin.chatroom.d.a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.SelectDateUI", "null == calendarDay");
            return;
        }
        x.i("MicroMsg.SelectDateUI", "Day Selected timestamp:%s day:%s month:%s year:%s", new Object[]{Long.valueOf(aVar.kZk), Integer.valueOf(aVar.kCC), Integer.valueOf(aVar.month), Integer.valueOf(aVar.year)});
        x.i("MicroMsg.SelectDateUI", "[goToChattingUI] msgLocalId:%s", new Object[]{Long.valueOf(aVar.fqm)});
        com.tencent.mm.plugin.chatroom.a.ifs.e(new Intent().putExtra("Chat_User", this.jRw).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", r0), this);
    }
}

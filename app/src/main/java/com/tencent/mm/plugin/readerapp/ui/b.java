package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ay.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Timer;
import junit.framework.Assert;

public final class b implements a, com.tencent.mm.sdk.e.m.b {
    Context context;
    private f ilB;
    private x jLe;

    public b(Context context) {
        this.context = context;
    }

    static void hw(boolean z) {
        int FY = q.FY();
        if (z) {
            FY &= -1025;
        } else {
            FY |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        ar.Hg();
        c.CU().set(40, Integer.valueOf(FY));
        FY = z ? 2 : 1;
        ar.Hg();
        c.EX().b(new g(26, FY));
    }

    public final boolean vQ(String str) {
        boolean z = false;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = " + str);
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_readerappnews_view")) {
            Intent intent = new Intent(this.context, ReaderAppUI.class);
            intent.addFlags(67108864);
            intent.putExtra(DownloadSettingTable$Columns.TYPE, 20);
            this.context.startActivity(intent);
            ((Activity) this.context).finish();
            com.tencent.mm.plugin.readerapp.a.a.ift.um();
            return true;
        } else if (str.equals("contact_info_readerappnews_subscribe")) {
            this.context.startActivity(new Intent(this.context, ReaderAppSubscribeUI.class));
            return true;
        } else if (str.equals("contact_info_readerappnews_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUH), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 1(this), null);
            return true;
        } else if (str.equals("contact_info_readerappnews_recv_remind")) {
            boolean z2;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN(str);
            boolean bmn = com.tencent.mm.plugin.readerapp.b.c.bmn();
            if (bmn) {
                z2 = false;
            } else {
                z2 = true;
            }
            checkBoxPreference.tSw = z2;
            if (!bmn) {
                z = true;
            }
            hw(z);
            return true;
        } else if (str.equals("contact_info_readerappnews_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_readerappnews_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 2(this), null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.gV(xVar.field_username));
        ar.Hg();
        c.CU().a(this);
        this.jLe = xVar;
        this.ilB = fVar;
        arR();
        return true;
    }

    private void arR() {
        int i = 1;
        int i2 = (q.Gd() & SQLiteGlobal.journalSizeLimit) == 0 ? 1 : 0;
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fbB);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ilB.YN("contact_info_header_helper");
        helperHeaderPreference.ae(this.jLe.field_username, this.jLe.AQ(), this.context.getString(R.l.dWb));
        if (i2 == 0) {
            i = 0;
        }
        helperHeaderPreference.nx(i);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_info_readerappnews_recv_remind");
        boolean bmn = com.tencent.mm.plugin.readerapp.b.c.bmn();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = " + bmn);
        checkBoxPreference.tSw = bmn;
        if (i2 != 0) {
            this.ilB.YO("contact_info_readerappnews_install");
            return;
        }
        this.ilB.YO("contact_info_readerappnews_subscribe");
        this.ilB.YO("contact_info_readerappnews_view");
        this.ilB.YO("contact_info_readerappnews_clear_data");
        this.ilB.YO("contact_info_readerappnews_uninstall");
        this.ilB.YO("contact_info_readerappnews_recv_remind");
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMA) : context.getString(R.l.eMH);
        context.getString(R.l.dGO);
        new Timer().schedule(new 4(h.a(context, string, true, null), new 3(z, context, null)), 5000);
    }

    public final boolean arS() {
        ar.Hg();
        c.CU().b(this);
        com.tencent.mm.plugin.readerapp.a.a.ift.um();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int o = bh.o(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(o), mVar});
        ar.Hg();
        if (mVar != c.CU() || o <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(o), mVar});
        } else if (o == 40 || o == 34 || o == 7) {
            arR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}

package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.readerapp.b.g;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bf;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class ReaderAppUI extends MMActivity implements a {
    private static float density;
    private int fEj = 0;
    private i kGt;
    private String nUy = "";
    private View oim;
    private ListView onD;
    private MMPullDownView onH;
    private d onK = new 3(this);
    private a<Long> pAT;
    private e pAU = null;
    private af pAV = new af();
    private int pAW = 0;

    static /* synthetic */ String a(ReaderAppUI readerAppUI, String str) {
        int i = 1;
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ReaderAppUI", "appendArgs fail, srcUrl is null");
            return "";
        }
        int i2;
        List linkedList;
        String format;
        PackageInfo Ic = readerAppUI.Ic("com.tencent.news");
        if (Ic == null) {
            x.i("MicroMsg.ReaderAppUI", "isNewsInstallAndSupport false, pkgInfo is null");
        } else if (Ic.versionCode >= 220) {
            i2 = 1;
            if (i2 == 0) {
                i = 0;
            }
            x.i("MicroMsg.ReaderAppUI", "appendArgsForNews, isNewsInstallAndSupport = " + i);
            linkedList = new LinkedList();
            linkedList.add(new BasicNameValuePair("isappinstalled", String.valueOf(i)));
            format = URLEncodedUtils.format(linkedList, ProtocolPackage.ServerEncoding);
            return str.contains("?") ? str + "&" + format : str + "?" + format;
        }
        i2 = 0;
        if (i2 == 0) {
            i = 0;
        }
        x.i("MicroMsg.ReaderAppUI", "appendArgsForNews, isNewsInstallAndSupport = " + i);
        linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("isappinstalled", String.valueOf(i)));
        format = URLEncodedUtils.format(linkedList, ProtocolPackage.ServerEncoding);
        if (str.contains("?")) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fEj = getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0);
        density = com.tencent.mm.bv.a.getDensity(this);
        initView();
        this.nUy = bf.gT(this.fEj);
    }

    public void onDestroy() {
        if (this.pAT != null) {
            this.pAT.aUn();
            this.pAT.xIi = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dpX;
    }

    protected void onResume() {
        super.onResume();
        j.b(this);
        if (this.fEj == 20) {
            setMMTitle(R.l.eoI);
        } else {
            setMMTitle(R.l.eoL);
        }
        ar.getNotification().eo(this.nUy);
        ar.getNotification().cancelNotification(this.nUy);
        ar.Hg();
        c.Fd().Xa(this.nUy);
        g.bmp().c(this.pAT);
        this.pAT.a(null, null);
        refresh();
    }

    protected void onPause() {
        super.onPause();
        ar.getNotification().eo("");
        g.bmp().j(this.pAT);
        j.c(this);
        ar.Hg();
        c.Fd().Xa(this.nUy);
    }

    public final void refresh() {
        TextView textView = (TextView) findViewById(R.h.cem);
        textView.setText(this.fEj == 20 ? R.l.bFe : R.l.eCa);
        if (this.pAT.getCount() == 0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    protected final void initView() {
        try {
            this.pAU = new e(bh.convertStreamToString(getAssets().open("chatting/default_chat.xml")));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReaderAppUI", e, "", new Object[0]);
        }
        this.onD = (ListView) findViewById(R.h.cFH);
        this.onH = (MMPullDownView) findViewById(R.h.cFK);
        this.oim = getLayoutInflater().inflate(R.i.dqa, null);
        this.onD.addHeaderView(this.oim);
        ((TextView) findViewById(R.h.cem)).setText(R.l.eBP);
        if (this.fEj == 20) {
            this.pAT = new a(this, this, Long.valueOf(0));
        } else if (this.fEj == 11) {
            this.pAT = new b(this, this, Long.valueOf(0));
        }
        this.onD.setOnScrollListener(this.pAT);
        this.onD.setAdapter(this.pAT);
        this.onD.setTranscriptMode(0);
        registerForContextMenu(this.onD);
        this.kGt = new i(this);
        if (this.pAT.getCount() == 0) {
            Intent intent = new Intent(this, ReaderAppIntroUI.class);
            intent.putExtra(DownloadSettingTable$Columns.TYPE, this.fEj);
            startActivity(intent);
            finish();
            return;
        }
        this.onH.ycp = new 4(this);
        this.onH.mp(true);
        this.onH.ycB = new 5(this);
        this.onH.ycC = new 6(this);
        this.onH.mn(true);
        this.pAT.xIi = new 7(this);
        setBackBtn(new 8(this));
        addIconOptionMenu(0, R.l.dCj, R.k.dvc, new 9(this));
        this.onD.setSelection((this.pAT.bmq() - 1) + this.onD.getHeaderViewsCount());
    }

    public final OnClickListener a(bf bfVar, int i, int i2) {
        return new 10(this, i, bfVar, i2);
    }

    public final void l(String str, Bitmap bitmap) {
        x.d("MicroMsg.ReaderAppUI", "onUpdate");
        if (this == null || isFinishing() || bitmap == null) {
            x.d("MicroMsg.ReaderAppUI", "readerappui is finish");
        } else {
            this.pAV.post(new 2(this));
        }
    }

    private PackageInfo Ic(String str) {
        PackageInfo packageInfo = null;
        if (str.length() != 0) {
            try {
                packageInfo = this.mController.xIM.getPackageManager().getPackageInfo(str, 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ReaderAppUI", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }
}

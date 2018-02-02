package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AttachDownloadPage extends MMActivity {
    private long fwg;
    private int hTx = 0;
    private long hUh = 0;
    private TextView ihV;
    private TextView jLd;
    private ProgressBar lAk;
    private Button mvW;
    private Button mvY;
    private View mwb;
    private String poS;
    private String pod;
    private long ppZ;
    private MMImageView pqk;
    private ImageView pql;
    private ImageView pqm;
    private TextView pqn;
    private String pqo;
    private int pqp;
    private boolean pqq = false;
    private String pqr;
    private boolean pqs = true;
    private int retryCount = 0;

    static /* synthetic */ void a(AttachDownloadPage attachDownloadPage, String str) {
        b cfVar = new cf();
        f.a(cfVar, 9, str, e.bR(str), "");
        cfVar.fqp.activity = attachDownloadPage;
        cfVar.fqp.fqw = 6;
        a.xef.m(cfVar);
    }

    static /* synthetic */ void b(AttachDownloadPage attachDownloadPage, String str) {
        String bQ = e.bQ(str);
        if (bQ != null && bQ.length() != 0) {
            com.tencent.mm.pluginsdk.ui.tools.a.b(attachDownloadPage, str, bQ, 3);
        }
    }

    static /* synthetic */ void g(AttachDownloadPage attachDownloadPage) {
        if (attachDownloadPage.pqq) {
            Intent intent = new Intent(attachDownloadPage.mController.xIM, CompressPreviewUI.class);
            intent.putExtra("mail_id", attachDownloadPage.pod);
            intent.putExtra("attach_id", attachDownloadPage.poS);
            intent.putExtra("attach_size", attachDownloadPage.fwg);
            intent.putExtra("attach_name", attachDownloadPage.pqr);
            attachDownloadPage.mController.xIM.startActivity(intent);
            return;
        }
        String[] strArr = new String[]{"mailid=" + attachDownloadPage.pod, "attachid=" + attachDownloadPage.poS, "texttype=html"};
        Intent intent2 = new Intent();
        intent2.putExtra("uri", "/cgi-bin/viewdocument");
        intent2.putExtra("params", strArr);
        intent2.putExtra("baseurl", p.bkn());
        intent2.putExtra("method", "get");
        intent2.putExtra("singleColumn", FileExplorerUI.SN(attachDownloadPage.pqr));
        intent2.putExtra("title", attachDownloadPage.pqr);
        intent2.setClass(attachDownloadPage, MailWebViewUI.class);
        attachDownloadPage.startActivity(intent2);
    }

    static /* synthetic */ void j(AttachDownloadPage attachDownloadPage) {
        long length = new File(attachDownloadPage.hn(true)).length();
        x.d("MicroMsg.AttachDownloadPage", "cur download size:" + length);
        attachDownloadPage.hUh = length;
        attachDownloadPage.lAk.setProgress((int) ((100 * length) / attachDownloadPage.fwg));
        attachDownloadPage.pqn.setText(attachDownloadPage.getString(R.l.etS, new Object[]{bh.bx(length), bh.bx(attachDownloadPage.fwg)}));
        if (attachDownloadPage.hTx != 1 || attachDownloadPage.ppZ == 0) {
            attachDownloadPage.pqn.setVisibility(8);
        } else {
            attachDownloadPage.pqn.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return R.i.daD;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pqp = getIntent().getIntExtra("is_preview", 0);
        this.pqq = getIntent().getBooleanExtra("is_compress", false);
        this.pqr = getIntent().getStringExtra("attach_name");
        this.pod = getIntent().getStringExtra("mail_id");
        this.poS = getIntent().getStringExtra("attach_id");
        this.fwg = getIntent().getLongExtra("total_size", 0);
        w.bks();
        this.pqo = p.getDownloadPath();
        setMMTitle(this.pqr);
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        w.bks().cancel(this.ppZ);
    }

    protected final void initView() {
        this.pqk = (MMImageView) findViewById(R.h.ccT);
        this.mwb = findViewById(R.h.ccK);
        this.lAk = (ProgressBar) findViewById(R.h.ccJ);
        this.pql = (ImageView) findViewById(R.h.ccO);
        this.pqm = (ImageView) findViewById(R.h.ccM);
        this.pqn = (TextView) findViewById(R.h.bLn);
        this.mvW = (Button) findViewById(R.h.bLp);
        this.mvY = (Button) findViewById(R.h.bLm);
        this.ihV = (TextView) findViewById(R.h.bLo);
        this.jLd = (TextView) findViewById(R.h.bLq);
        if (FileExplorerUI.SN(this.pqr)) {
            this.pqk.setBackgroundResource(R.k.dyt);
        } else if (FileExplorerUI.SO(this.pqr)) {
            this.pqk.setImageResource(R.k.dvA);
        } else {
            int Ry = r.Ry(e.bQ(this.pqr));
            if (Ry > 0) {
                this.pqk.setImageResource(Ry);
            } else {
                this.pqk.setImageResource(R.k.dvx);
            }
        }
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ AttachDownloadPage pqt;

            {
                this.pqt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pqt.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.k.dzQ, new 2(this));
        enableOptionMenu(false);
        bkD();
        if (this.hTx == 1) {
            bky();
        } else {
            bkz();
        }
    }

    private void bky() {
        this.mwb.setVisibility(0);
        this.mvW.setVisibility(8);
        this.mvY.setVisibility(8);
        this.pql.setVisibility(0);
        this.pqm.setVisibility(8);
        this.pqn.setVisibility(8);
        this.ihV.setVisibility(8);
        this.jLd.setVisibility(8);
        this.pql.setOnClickListener(new 3(this));
        this.pqm.setOnClickListener(new 4(this));
    }

    private void bkz() {
        if (this.pqp == 1) {
            if (FileExplorerUI.SN(this.pqr)) {
                if (this.hTx == 3) {
                    Intent intent = new Intent();
                    intent.putExtra("key_favorite", true);
                    intent.putExtra("key_favorite_source_type", 9);
                    intent.putExtra("key_image_path", hn(false));
                    com.tencent.mm.plugin.qqmail.a.a.ifs.d(this.mController.xIM, intent);
                    finish();
                    return;
                } else if (this.hTx == 0 || this.pqs) {
                    this.retryCount = 0;
                    this.pqs = false;
                    bkA();
                    bky();
                    return;
                }
            }
            this.mwb.setVisibility(8);
            this.ihV.setVisibility(0);
            this.pqn.setVisibility(8);
            this.mvW.setVisibility(0);
            this.mvY.setVisibility(8);
            this.jLd.setVisibility(0);
            this.mvW.setOnClickListener(new 5(this));
            if (this.hTx == 3) {
                this.ihV.setText(R.l.etW);
                this.jLd.setText(R.l.etT);
                this.jLd.setOnClickListener(new 6(this));
                enableOptionMenu(true);
                return;
            }
            this.ihV.setText(R.l.etW);
            if (this.hTx == 2) {
                this.jLd.setText(R.l.etV);
            } else {
                this.jLd.setText(R.l.etU);
            }
            this.jLd.setOnClickListener(new 7(this));
        } else if (this.pqp == 0) {
            this.mwb.setVisibility(8);
            this.mvW.setVisibility(8);
            this.mvY.setVisibility(0);
            this.pqn.setVisibility(8);
            this.ihV.setVisibility(0);
            this.jLd.setVisibility(8);
            if (this.hTx == 3) {
                this.mvY.setText(R.l.etR);
                enableOptionMenu(true);
            } else if (this.hTx == 2) {
                this.mvY.setText(R.l.etX);
            } else {
                this.mvY.setText(R.l.etP);
            }
            this.ihV.setText(R.l.etQ);
            this.mvY.setOnClickListener(new 8(this));
        }
    }

    private void bkA() {
        bkD();
        if (this.hTx == 4) {
            if (this.retryCount < 5) {
                this.retryCount++;
                bkA();
            } else {
                bkz();
            }
        } else if (this.hTx == 3) {
            e.g(this.pqo, bkB() + ".temp", bkB());
            this.hTx = 3;
            bkz();
        }
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.pod);
        hashMap.put("attachid", this.poS);
        hashMap.put("username", "");
        hashMap.put("offset", this.hUh);
        hashMap.put("datalen", this.fwg);
        hashMap.put("default_attach_name", bkB() + ".temp");
        c cVar = new c();
        cVar.ppk = false;
        cVar.ppl = false;
        this.ppZ = w.bks().a("/cgi-bin/mmdownload", hashMap, cVar, new 9(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, R.l.dZc, R.l.dZd, 3);
    }

    private String bkB() {
        String substring;
        int hashCode = this.poS.hashCode() & 65535;
        int lastIndexOf = this.pqr.lastIndexOf(".");
        String str = "";
        if (lastIndexOf != -1) {
            substring = this.pqr.substring(0, lastIndexOf);
            str = this.pqr.substring(lastIndexOf, this.pqr.length());
        } else {
            substring = this.pqr;
        }
        return String.format("%s_%d%s", new Object[]{substring, Integer.valueOf(hashCode), str});
    }

    private String hn(boolean z) {
        return this.pqo + bkB() + (!z ? "" : ".temp");
    }

    private String bkC() {
        return this.pqo + this.pqr;
    }

    private void bkD() {
        if (e.bO(hn(true))) {
            this.hUh = (long) e.bN(hn(true));
            this.hTx = 2;
        } else if (e.bO(hn(false))) {
            this.hTx = 3;
        } else if (!e.bO(bkC())) {
            this.hUh = 0;
            this.hTx = 0;
        } else if (((long) e.bN(bkC())) == this.fwg) {
            e.g(this.pqo, this.pqr, bkB());
            this.hTx = 3;
        } else if (((long) e.bN(bkC())) > this.fwg) {
            com.tencent.mm.loader.stub.b.deleteFile(bkC());
            this.hUh = 0;
            this.hTx = 4;
        } else {
            this.hUh = 0;
            this.hTx = 0;
        }
    }
}

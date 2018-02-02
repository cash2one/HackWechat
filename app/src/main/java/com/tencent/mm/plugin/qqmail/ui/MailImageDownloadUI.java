package com.tencent.mm.plugin.qqmail.ui;

import android.os.Bundle;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.aq.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class MailImageDownloadUI extends MMActivity implements e, f {
    private long fFo = 0;
    private long fqm = 0;
    private af handler = new af(Looper.getMainLooper());
    private int hzT;
    private k ptA;
    private ImageView ptB;
    private LinearLayout ptC;
    private ProgressBar ptt;
    private TextView ptu;
    private TextView ptv;
    private TextView ptw;
    private TextView ptx;
    private RelativeLayout pty;
    private com.tencent.mm.aq.e ptz;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fqm = getIntent().getLongExtra("img_msg_id", 0);
        this.fFo = getIntent().getLongExtra("img_server_id", 0);
        this.hzT = getIntent().getIntExtra("img_download_compress_type", 0);
        this.username = getIntent().getStringExtra("img_download_username");
        initView();
        if (this.fqm > 0) {
            this.ptz = o.Pw().bi(this.fqm);
        }
        if ((this.ptz == null || this.ptz.hzP <= 0) && this.fFo > 0) {
            this.ptz = o.Pw().bh(this.fFo);
        }
        if (this.ptz == null || this.ptz.hzP <= 0) {
            x.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.fqm + ", or msgSvrId = " + this.fFo);
            return;
        }
        if (this.fqm <= 0 && this.fFo > 0) {
            ar.Hg();
            this.fqm = c.Fa().F(this.username, this.fFo).field_msgId;
        }
        String str = this.ptz.hzQ;
        String m = o.Pw().m(str, null, null);
        if (bh.ov(str) || !com.tencent.mm.a.e.bO(m)) {
            this.ptA = new k(this.ptz.hzP, this.fqm, this.hzT, this);
            ar.CG().a(this.ptA, 0);
            return;
        }
        x.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[]{str, Boolean.valueOf(this.ptz.Pe()), m});
        if (m == null || m.equals("") || !com.tencent.mm.a.e.bO(m)) {
            x.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
            return;
        }
        this.ptC.setVisibility(8);
        this.ptt.setVisibility(8);
        this.ptB.setVisibility(0);
        this.ptB.setImageBitmap(d.UN(m));
        this.pty.invalidate();
    }

    protected final int getLayoutId() {
        return R.i.dmS;
    }

    protected void onPause() {
        super.onPause();
        ar.CG().b(109, this);
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(109, this);
    }

    protected final void initView() {
        this.ptu = (TextView) findViewById(R.h.coV);
        this.ptv = (TextView) findViewById(R.h.coV);
        this.ptw = (TextView) findViewById(R.h.coW);
        this.ptx = (TextView) findViewById(R.h.coT);
        this.ptB = (ImageView) findViewById(R.h.cuH);
        this.ptu.setVisibility(0);
        this.ptC = (LinearLayout) findViewById(R.h.coS);
        this.pty = (RelativeLayout) findViewById(R.h.cuI);
        this.ptv.setVisibility(8);
        this.ptw.setVisibility(8);
        this.ptx.setVisibility(8);
        setTitleVisibility(8);
        setBackBtn(new 1(this));
        this.ptt = (ProgressBar) findViewById(R.h.coU);
    }

    private void ve(int i) {
        this.ptu.setText(getString(R.l.eiR, new Object[]{Integer.valueOf(i)}));
        if (i >= this.ptt.getMax()) {
            com.tencent.mm.aq.e b = o.Pw().b(Long.valueOf(this.ptA.hBk));
            if (this.hzT == 1) {
                com.tencent.mm.aq.f.c(b);
            }
            finish();
            startActivity(getIntent());
        }
    }

    public final void a(int i, int i2, com.tencent.mm.ae.k kVar) {
        x.d("MicroMsg.MailImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (kVar.getType() == 109) {
            ve(Math.max(0, i2 != 0 ? ((i * 100) / i2) - 1 : 0));
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (kVar.getType() == 109) {
            if (i == 0 && i2 == 0) {
                ve(this.ptt.getMax());
                return;
            }
            x.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, R.l.epo, 1).show();
        }
    }
}

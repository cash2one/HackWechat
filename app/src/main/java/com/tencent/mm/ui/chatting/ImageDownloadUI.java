package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.aq.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class ImageDownloadUI extends MMActivity implements e, f {
    private long fFo = 0;
    private long fqm = 0;
    private int hzT;
    private k ptA;
    private ProgressBar ptt;
    private TextView ptu;
    private TextView ptv;
    private TextView ptw;
    private TextView ptx;
    private com.tencent.mm.aq.e ptz;
    private String username;
    private ImageView yxg;

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
            x.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.fqm + ", or msgSvrId = " + this.fFo);
            return;
        }
        if (this.fqm <= 0 && this.fFo > 0) {
            ar.Hg();
            this.fqm = c.Fa().F(this.username, this.fFo).field_msgId;
        }
        this.ptA = new k(this.ptz.hzP, this.fqm, this.hzT, this);
        ar.CG().a(this.ptA, 0);
    }

    protected final int getLayoutId() {
        return R.i.dts;
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
        this.ptv = (TextView) findViewById(R.h.cUP);
        this.ptw = (TextView) findViewById(R.h.cUQ);
        this.ptx = (TextView) findViewById(R.h.cUN);
        this.yxg = (ImageView) findViewById(R.h.ccu);
        this.yxg.setImageResource(R.k.dyt);
        this.ptu.setVisibility(0);
        this.ptv.setVisibility(8);
        this.ptw.setVisibility(8);
        this.ptx.setVisibility(8);
        setBackBtn(new 1(this));
        this.ptt = (ProgressBar) findViewById(R.h.cUO);
    }

    public final void a(int i, int i2, com.tencent.mm.ae.k kVar) {
        x.d("ImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (kVar.getType() == 109) {
            int i3;
            if (i2 != 0) {
                i3 = ((i * 100) / i2) - 1;
            } else {
                i3 = 0;
            }
            ve(Math.max(0, i3));
        }
    }

    private void ve(int i) {
        this.ptt.setProgress(i);
        this.ptu.setText(getString(R.l.eiR, new Object[]{Integer.valueOf(i)}));
        if (i >= this.ptt.getMax()) {
            com.tencent.mm.aq.e b = o.Pw().b(Long.valueOf(this.ptA.hBk));
            String str = b.hzQ;
            if (this.hzT == 1) {
                str = com.tencent.mm.aq.f.c(b);
            }
            str = o.Pw().m(str, null, null);
            if (str == null || str.equals("") || !com.tencent.mm.a.e.bO(str)) {
                x.d("ImageDownloadUI", "showImg : imgPath is null");
                return;
            }
            Intent intent = new Intent(this, ImageGalleryUI.class);
            intent.putExtra("key_message_id", this.fqm);
            intent.putExtra("key_image_path", str);
            intent.putExtra("key_compress_type", this.hzT);
            intent.putExtra("key_favorite", true);
            intent.putExtra("img_gallery_msg_id", this.fqm);
            intent.putExtra("img_gallery_talker", this.username);
            finish();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (kVar.getType() == 109) {
            if (i == 0 && i2 == 0) {
                ve(this.ptt.getMax());
                return;
            }
            x.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, R.l.epo, 1).show();
        }
    }
}

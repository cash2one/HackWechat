package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class ArtistBrowseUI extends SnsBaseGalleryUI implements a {
    private String nQA = "";
    private String rqL = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        if (this.ryY != null) {
            this.ryY.bAY();
            this.ryY.onDestroy();
        }
        ae.bvs().K(this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.ryY != null) {
            this.ryY.aHq();
        }
    }

    protected final int getLayoutId() {
        return g.qHo;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.ryV.rti);
        setResult(-1, intent);
        finish();
        return true;
    }

    protected final void initView() {
        this.nQA = getIntent().getStringExtra("sns_gallery_artist_lan");
        int intExtra = getIntent().getIntExtra("sns_gallery_position", 0);
        r.QH();
        this.rqL = n.QE();
        u(false, 2);
        this.ryY = new SnsInfoFlip(this);
        List ea = ai.ea(this.nQA, this.rqL);
        this.ryY.rCc = true;
        this.ryY.a(ea, "", intExtra, this.ryT, this);
        addView(this.ryY);
        setBackBtn(new 1(this));
        setMMTitle(j.qME);
        showOptionMenu(false);
        this.ryT.rsN = new 2(this);
    }

    protected void onPause() {
        if (this.ryY != null) {
            this.ryY.onPause();
        }
        super.onPause();
    }

    public final void ch(String str, int i) {
        if (this.ryY != null) {
            this.ryY.aHq();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            this.ryV.xr(intent.getIntExtra("sns_gallery_op_id", 0));
        }
    }

    public final void ci(String str, int i) {
    }
}

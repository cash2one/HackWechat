package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnsUploadBrowseUI extends SnsBaseGalleryUI implements a {
    private ArrayList<String> rLo = new ArrayList();
    private HashMap<Integer, Boolean> rLp = new HashMap();
    private int rza = 0;

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

    protected void onPause() {
        if (this.ryY != null) {
            this.ryY.onPause();
        }
        super.onPause();
    }

    protected final int getLayoutId() {
        return i$g.qHe;
    }

    public final void bBY() {
        Intent intent = new Intent();
        List<b> list = this.ryY.hiv;
        if (list != null) {
            this.rLo.clear();
            for (b bVar : list) {
                Object substring;
                String str = ae.getAccSnsTmpPath() + bVar.fHC.nGJ;
                if (bVar.fHC.nGJ.startsWith("pre_temp_extend_pic")) {
                    substring = bVar.fHC.nGJ.substring(19);
                } else {
                    String str2 = str;
                }
                this.rLo.add(substring);
            }
            intent.putExtra("sns_gallery_temp_paths", this.rLo);
            intent.putExtra("sns_update_preview_image_count", this.rLp.size());
            this.rLp.clear();
            setResult(-1, intent);
            finish();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
        bBY();
        return true;
    }

    protected final void initView() {
        String az = bh.az(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.rLo = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
        if (this.rLo != null) {
            this.rza = getIntent().getIntExtra("sns_gallery_position", 0);
            this.ryY = new SnsInfoFlip(this);
            this.ryY.rCd = false;
            this.ryY.rCc = true;
            ae.getAccSnsTmpPath();
            this.ryY.a(ai.bL(this.rLo), az, this.rza, this.ryT, this);
            this.ryY.rCt = new 1(this);
            addView(this.ryY);
            setBackBtn(new OnMenuItemClickListener(this) {
                final /* synthetic */ SnsUploadBrowseUI rLq;

                {
                    this.rLq = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.rLq.bBY();
                    return true;
                }
            });
            addIconOptionMenu(0, j.dEw, e.qzp, new OnMenuItemClickListener(this) {
                final /* synthetic */ SnsUploadBrowseUI rLq;

                {
                    this.rLq = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    h.a(this.rLq, j.qKU, j.dGO, new 1(this), new 2(this));
                    return true;
                }
            });
        }
    }

    public final void ch(String str, int i) {
        if (this.ryY != null) {
            this.ryY.aHq();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
        }
    }

    protected final int getForceOrientation() {
        return 4;
    }

    public final void ci(String str, int i) {
    }
}

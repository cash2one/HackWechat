package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.e;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@a(19)
public class MusicMainUI extends MMActivity implements e, com.tencent.mm.ae.e {
    private af gAy = new af(Looper.getMainLooper());
    private c jeX = new 2(this);
    private long kCU;
    private int mode;
    private com.tencent.mm.plugin.music.model.g.c.a oKB = new 7(this);
    private boolean oLO;
    private CheckBox oNF;
    private ImageButton oNG;
    private ImageButton oNH;
    private MusicViewPager oNI;
    private com.tencent.mm.pluginsdk.k.c oNJ;
    private b oNK;
    private boolean oNL;
    private int oNM = 0;
    private Timer oNN;
    private int oNO = -1;
    private int scene;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.mode = getIntent().getIntExtra("key_mode", 2);
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.oLO = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
        this.oNI = (MusicViewPager) findViewById(R.h.cVN);
        this.oNK = new b(this, this.scene, this.oLO);
        this.oNI.a(this.oNK);
        this.oNI.b(this);
        this.oNI.setSystemUiVisibility(Downloads.RECV_BUFFER_SIZE);
        this.oNG = (ImageButton) findViewById(R.h.bLT);
        this.oNH = (ImageButton) findViewById(R.h.cLs);
        this.oNF = (CheckBox) findViewById(R.h.cyr);
        this.oNF.setChecked(!h.bdz().bdn().Qq());
        this.oNJ = new com.tencent.mm.pluginsdk.k.c(this);
        this.oNF.setOnClickListener(new 1(this));
        com.tencent.mm.sdk.b.a.xef.b(this.jeX);
        if (!this.oNJ.bZN()) {
            x.w("MicroMsg.Music.MusicMainUI", "not support shake");
        }
        beL();
        this.oNI.ah(100000 + h.bdz().oJA);
        beN();
        int i = this.scene;
        if (h.bdz().bdo() != null) {
            x.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", new Object[]{Integer.valueOf(13041), Integer.valueOf(i), h.bdz().bdo().field_musicId, h.bdz().bdo().field_songName, h.bdz().bdo().field_songAlbum, Integer.valueOf(h.bdz().bdo().field_songId), h.bdz().bdo().field_songSinger, h.bdz().bdo().field_appId});
            g.pQN.h(13041, new Object[]{Integer.valueOf(i), r1.field_musicId, r1.field_songName, r1.field_songAlbum, Integer.valueOf(r1.field_songId), r1.field_songSinger, r1.field_appId});
        }
        g.pQN.a(285, 1, 1, false);
        com.tencent.mm.av.a bdo = h.bdz().bdo();
        if (bdo == null) {
            finish();
            return;
        }
        if (this.scene == 4 && h.bdz().mode == 2) {
            ar.Hg();
            int i2 = com.tencent.mm.z.c.CU().getInt(83, 0);
            if (i2 < 3) {
                Toast.makeText(this, R.l.ekL, 0).show();
                i2++;
                ar.Hg();
                com.tencent.mm.z.c.CU().set(83, Integer.valueOf(i2));
            }
        }
        if (this.scene == 5) {
            f.a(0, bdo);
        }
        p(bdo);
        if (this.mode == 1) {
            if (this.oNN == null) {
                this.oNN = new Timer();
            }
            this.oNN.schedule(new 3(this), 0, 500);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    protected void onResume() {
        int i;
        super.onResume();
        com.tencent.mm.av.a bdo = h.bdz().bdo();
        if (bdo != null) {
            switch (bdo.field_musicType) {
                case 1:
                case 4:
                case 6:
                case 8:
                case 9:
                    i = 1;
                    break;
            }
        }
        i = (byte) 0;
        if (i == 0) {
            x.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
            h.bdz().mode = 1;
        } else if (!this.oLO) {
            if (!(this.oNJ == null || !this.oNJ.bZN() || this.oNJ.bZL())) {
                this.oNJ.a(new b(this, (byte) 0));
            }
            this.kCU = bh.Wq();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.oNJ != null) {
            this.oNJ.aPV();
        }
    }

    private void beL() {
        h.bdz();
        this.oNK.count = 200000;
        this.oNK.notifyDataSetChanged();
        if (h.bdz().bdt()) {
            this.oNI.DN = true;
        } else {
            this.oNI.DN = false;
        }
    }

    private void beM() {
        if (this.oNN != null) {
            this.oNN.cancel();
        }
        this.oNN = null;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.oNJ != null) {
            this.oNJ.aPV();
        }
        if (this.oNK != null) {
            b bVar = this.oNK;
            bVar.oJw.removeCallbacksAndMessages(null);
            d dVar = bVar.oNn;
            dVar.oJw.removeCallbacksAndMessages(null);
            dVar.gzu.clear();
        }
        beM();
        com.tencent.mm.sdk.b.a.xef.c(this.jeX);
        beO();
        if (!h.bdz().bdn().Qq()) {
            h.bdz().bdn().stopPlay();
        }
        com.tencent.mm.plugin.music.model.e bdz = h.bdz();
        if (!bdz.oJC.Qq() && !bdz.oJD.Qq()) {
            x.i("MicroMsg.Music.MusicPlayerManager", "really exit music");
            bdz.mode = 1;
        }
    }

    public void onClickBack(View view) {
        finish();
    }

    public void onClickSend(View view) {
        asv bdp = h.bdz().bdp();
        x.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", new Object[]{Integer.valueOf(bdp.wAi), bdp.wAq});
        if (bdp.wAi == 11) {
            b fwVar = new fw();
            com.tencent.mm.sdk.b.a.xef.m(fwVar);
            String str = fwVar.fvK.appId;
            CharSequence charSequence = fwVar.fvK.frn;
            String str2 = fwVar.fvK.fvL;
            int i = fwVar.fvK.fvM;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            x.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[]{str, charSequence, Integer.valueOf(i), str2});
            String string = getString(R.l.enC, new Object[]{charSequence});
            if (TextUtils.isEmpty(bdp.wAq)) {
                String[] strArr = new String[]{string};
                new ArrayList().add(Integer.valueOf(0));
                com.tencent.mm.ui.base.h.a((Context) this, "", strArr, "", new 5(this, str, str2, i));
                return;
            }
            List arrayList = new ArrayList();
            String[] strArr2 = new String[]{getString(R.l.eYd), getString(R.l.eYe), getString(R.l.dQP), string};
            arrayList.add(Integer.valueOf(0));
            arrayList.add(Integer.valueOf(1));
            arrayList.add(Integer.valueOf(2));
            arrayList.add(Integer.valueOf(3));
            com.tencent.mm.ui.base.h.a((Context) this, "", strArr2, "", new 4(this, bdp, str, str2, i));
        } else if (!TextUtils.isEmpty(bdp.wAq)) {
            List arrayList2 = new ArrayList();
            String[] strArr3 = new String[]{getString(R.l.eYd), getString(R.l.eYe), getString(R.l.dQP), getString(R.l.eeD)};
            arrayList2.add(Integer.valueOf(0));
            arrayList2.add(Integer.valueOf(1));
            arrayList2.add(Integer.valueOf(2));
            arrayList2.add(Integer.valueOf(3));
            com.tencent.mm.ui.base.h.a((Context) this, "", strArr3, "", new 6(this, bdp));
        }
    }

    protected final int getLayoutId() {
        return R.i.doB;
    }

    public final void a(int i, float f, int i2) {
    }

    private void p(com.tencent.mm.av.a aVar) {
        if (!com.tencent.mm.plugin.music.model.g.d(aVar) || this.oLO) {
            this.oNF.setVisibility(8);
            this.oNH.setVisibility(8);
            return;
        }
        this.oNF.setVisibility(0);
        this.oNH.setVisibility(0);
    }

    public final void ae(int i) {
        x.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", new Object[]{Integer.valueOf(i)});
        if (h.bdz().bdt()) {
            this.oNI.DN = false;
        }
        this.gAy.removeCallbacksAndMessages(null);
        this.gAy.postDelayed(new a(this, i), 500);
        if (this.oNO == -1) {
            this.oNO = i;
        }
        if (this.oNO != i) {
            this.oNO = i;
            f.oJN = true;
            g.pQN.a(285, 3, 1, false);
            f.cS(1, this.scene);
        }
    }

    public final void af(int i) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2 && 1 == i) {
            com.tencent.mm.plugin.music.model.g.a(h.bdz().bdp(), intent, this);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    public final void beN() {
        h.bdz().bdn().a(this.oKB);
    }

    public static void beO() {
        h.bdz().bdn().a(null);
    }

    public final void q(com.tencent.mm.av.a aVar) {
        com.tencent.mm.av.a bdo = h.bdz().bdo();
        if (bdo != null && bdo.a(aVar) && this.oNH != null && this.oNG != null && this.oNF != null && this.oNH.getBackground() != null && this.oNG.getBackground() != null && this.oNF.getBackground() != null) {
            if (aVar.Ql()) {
                int i = aVar.field_songLyricColor;
                this.oNH.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.oNG.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.oNF.getBackground().setColorFilter(i, Mode.MULTIPLY);
                return;
            }
            this.oNH.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.oNG.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.oNF.getBackground().setColorFilter(-1, Mode.MULTIPLY);
        }
    }
}

package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.IOException;

public class AppMsgEmojiDownloadUI extends MMActivity implements e, a {
    private String appName;
    private String fDP;
    private au fEJ;
    private String fFm;
    private String fny;
    private long fqm;
    private String fvC;
    private String hbd;
    private ab lAj;
    private ProgressBar lAk;
    private f lAl;
    private TextView lAm;
    private String lAn;
    private PreViewEmojiView lAo;

    protected final int getLayoutId() {
        return R.i.dat;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.lAn = "da_" + bh.Wp();
        this.fqm = getIntent().getLongExtra("msgid", -1);
        if (this.fqm == -1) {
            z = false;
        } else {
            ar.Hg();
            this.fEJ = c.Fa().dH(this.fqm);
            if (this.fEJ == null || this.fEJ.field_msgId == 0 || this.fEJ.field_content == null) {
                z = false;
            } else {
                this.fDP = this.fEJ.field_content;
                g.a fT = g.a.fT(this.fDP);
                if (fT == null) {
                    z = false;
                } else {
                    this.hbd = fT.hbd;
                    this.fny = fT.fny;
                    this.fFm = fT.appId;
                    this.appName = com.tencent.mm.pluginsdk.model.app.g.a(this.mController.xIM, com.tencent.mm.pluginsdk.model.app.g.aZ(this.fFm, true), null);
                    this.fvC = this.fEJ.field_imgPath;
                }
            }
        }
        if (z) {
            an.aqd().c(this);
            initView();
            this.lAl = new f(this) {
                final /* synthetic */ AppMsgEmojiDownloadUI lAp;

                {
                    this.lAp = r1;
                }

                public final void a(int i, int i2, k kVar) {
                    float f;
                    if (i2 == 0) {
                        f = 0.0f;
                    } else {
                        f = (((float) i) * 100.0f) / ((float) i2);
                    }
                    this.lAp.oM((int) f);
                }
            };
            if (an.aqd().Rz(this.fny) == null) {
                long j = this.fqm;
                String str = this.fDP;
                StringBuilder stringBuilder = new StringBuilder();
                ar.Hg();
                l.c(j, str, stringBuilder.append(c.Fp()).append(this.lAn).toString());
            }
            this.lAj = new ab(this.fny, this.lAl, 8);
            ar.CG().a(this.lAj, 0);
            return;
        }
        finish();
    }

    protected final void initView() {
        this.lAo = (PreViewEmojiView) findViewById(R.h.caj);
        this.lAo.setImageBitmap(o.Pw().a(this.fvC, 1.0f, true));
        setMMTitle("");
        this.lAm = (TextView) findViewById(R.h.ccP);
        TextView textView = (TextView) findViewById(R.h.bLh);
        this.appName = com.tencent.mm.pluginsdk.model.app.g.a(this.mController.xIM, com.tencent.mm.pluginsdk.model.app.g.aZ(this.fFm, true), null);
        if (this.fFm != null && this.fFm.length() > 0) {
            String str = this.appName;
            boolean z = (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) ? false : true;
            if (z) {
                textView.setText(getString(R.l.dTb, new Object[]{this.appName}));
                textView.setVisibility(0);
                str = this.fFm;
                b bVar = new b();
                bVar.appId = str;
                bVar.fEL = "message";
                textView.setTag(bVar);
                textView.setOnClickListener(new com.tencent.mm.pluginsdk.ui.chat.l(this));
                Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(this.fFm, 2, com.tencent.mm.bv.a.getDensity(this));
                if (b == null || b.isRecycled()) {
                    a(this, textView, BitmapFactory.decodeResource(getResources(), R.g.bEm));
                } else {
                    a(this, textView, b);
                }
                this.lAk = (ProgressBar) findViewById(R.h.cdu);
                this.lAk.setMax(100);
                setBackBtn(new 2(this));
            }
        }
        textView.setVisibility(8);
        this.lAk = (ProgressBar) findViewById(R.h.cdu);
        this.lAk.setMax(100);
        setBackBtn(new 2(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 221) {
            if (i == 0 && i2 == 0) {
                oM(this.lAk.getMax());
                return;
            }
            Toast.makeText(this, R.l.dYZ, 0).show();
            this.lAk.setVisibility(8);
            this.lAm.setVisibility(8);
            x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "onSceneEnd, download fail, errType = " + i + ", errCode = " + i2);
        }
    }

    protected void onPause() {
        super.onPause();
        ar.CG().b(221, this);
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(221, this);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        com.tencent.mm.pluginsdk.model.app.b Rz = an.aqd().Rz(this.fny);
        if (Rz == null) {
            x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "updateProgress fail");
            return;
        }
        long j = Rz.field_totalLen;
        long j2 = Rz.field_offset;
        this.lAm.setText(getString(R.l.dZb) + " " + getString(R.l.dYY, new Object[]{bh.bx(j2), bh.bx(j)}));
        int i = (int) ((Rz.field_offset * 100) / Rz.field_totalLen);
        x.v("MicroMsg.emoji.AppMsgEmojiDownloadUI", "attach progress:" + i + " offset:" + j2 + " totallen:" + j);
        oM(i);
    }

    private void oM(int i) {
        this.lAk.setProgress(i);
        if (i >= 100) {
            ar.Hg();
            String Fp = c.Fp();
            com.tencent.mm.sdk.e.c Rz = an.aqd().Rz(this.fny);
            if (Rz == null) {
                x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "saveImageAndPreview fail, info is null, attachid = " + this.fny + ", msgContent = " + this.fDP);
            } else {
                int bN = com.tencent.mm.a.e.bN(Rz.field_fileFullPath);
                Object d = com.tencent.mm.a.e.d(Rz.field_fileFullPath, 0, bN);
                String s = com.tencent.mm.a.g.s(d);
                if (!bh.ov(s)) {
                    if (s == null || this.hbd == null || s.equalsIgnoreCase(this.hbd)) {
                        com.tencent.mm.a.e.g(Fp, this.lAn, s);
                        Rz.field_fileFullPath = Fp + s;
                        an.aqd().a(Rz.field_msgInfoId, Rz);
                        Bitmap a = o.Pw().a(this.fvC, 1.0f, true);
                        if (a != null) {
                            m(Fp + s + "_thumb", a);
                        }
                        EmojiInfo a2 = p.bo(d) ? i.aBE().lwL.a(s, "", EmojiInfo.xAe, EmojiInfo.xAo, bN, this.fFm, "") : i.aBE().lwL.a(s, "", EmojiInfo.xAe, EmojiInfo.xAp, bN, this.fFm, "");
                        this.lAk.setVisibility(8);
                        this.lAm.setVisibility(8);
                        if (a2 != null) {
                            this.lAo.cR(a2.ckB(), null);
                            this.lAo.resume();
                        }
                    } else {
                        x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "md5 not match!! emoticonmd5 is=" + this.hbd + ", gen md5 is=" + s);
                        x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "fileFullPath = " + Rz.field_fileFullPath + ", fileLength = " + bN + ", bufLength = " + d.length + ", buf = " + d);
                        Toast.makeText(this, getString(R.l.dYZ), 0).show();
                        finish();
                    }
                }
            }
            an.aqd().j(this);
            ar.CG().b(221, this);
        }
    }

    private static boolean m(String str, Bitmap bitmap) {
        try {
            d.a(bitmap, 100, CompressFormat.PNG, str, true);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static void a(AppMsgEmojiDownloadUI appMsgEmojiDownloadUI, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) appMsgEmojiDownloadUI.getResources().getDimension(R.f.bvs);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().c(this.lAj);
        an.aqd().j(this);
    }
}

package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class VoiceTransTextUI extends MMActivity implements OnClickListener, e {
    private final String TAG = "MicroMsg.VoiceTransTextUI";
    private long gAc;
    private int iN;
    private int jEE;
    private int jEF;
    private ScrollView jjn = null;
    private View ltB = null;
    private af mHandler = new 6(this);
    private Button miR = null;
    private long pzr = 0;
    private bl rUV;
    private a rVb;
    private c rVc;
    private b rVd;
    private com.tencent.mm.modelvoice.b rVe;
    private volatile boolean rVg = false;
    private boolean rVh = false;
    private ak rVi;
    private View rZg = null;
    private View rZh = null;
    private LinearLayout rZi = null;
    private TextView rZj = null;
    private int rZk = 6;
    private boolean rZl = false;
    private p rZm;
    private au rZn;
    private c rZo;
    private boolean rZp = false;
    private boolean rZq = false;
    private int rZr;
    private OnTouchListener rZs;
    private OnClickListener rZt = new 1(this);
    private ClipboardManager rZu;
    private OnLongClickListener rZv = new OnLongClickListener(this) {
        final /* synthetic */ VoiceTransTextUI rZw;

        {
            this.rZw = r1;
        }

        public final boolean onLongClick(View view) {
            x.d("MicroMsg.VoiceTransTextUI", "onLongClick");
            h.a(this.rZw, "", new String[]{this.rZw.getString(R.l.dEs)}, "", new 1(this));
            return false;
        }
    };

    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] rZA = new int[a.bEr().length];
        static final /* synthetic */ int[] rZB = new int[b.bEs().length];

        static {
            try {
                rZB[b.rZH - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                rZB[b.rZI - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                rZB[b.rZJ - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                rZA[a.rZC - 1] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                rZA[a.rZD - 1] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                rZA[a.rZE - 1] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                rZA[a.rZF - 1] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private enum b {
        ;

        public static int[] bEs() {
            return (int[]) rZK.clone();
        }

        static {
            rZH = 1;
            rZI = 2;
            rZJ = 3;
            rZK = new int[]{rZH, rZI, rZJ};
        }
    }

    static /* synthetic */ void l(VoiceTransTextUI voiceTransTextUI) {
        voiceTransTextUI.jEE = 0;
        voiceTransTextUI.jEF = 0;
        voiceTransTextUI.rZp = false;
        voiceTransTextUI.rZq = false;
        voiceTransTextUI.mHandler.removeMessages(0);
    }

    public void onCreate(Bundle bundle) {
        int i;
        bl blVar = null;
        super.onCreate(bundle);
        this.iN = ViewConfiguration.get(this.mController.xIM).getScaledTouchSlop();
        this.rZu = (ClipboardManager) getSystemService("clipboard");
        this.ltB = findViewById(R.h.cXf);
        this.rZg = findViewById(R.h.cXa);
        this.rZh = findViewById(R.h.cXe);
        this.rZj = (TextView) findViewById(R.h.cXc);
        this.miR = (Button) findViewById(R.h.cXb);
        this.rZi = (LinearLayout) findViewById(R.h.cXd);
        this.jjn = (ScrollView) findViewById(R.h.ckn);
        this.rZs = new 3(this);
        this.rZj.setOnLongClickListener(this.rZv);
        this.rZj.setOnClickListener(this.rZt);
        this.gAc = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1);
        if (this.gAc < 0) {
            i = 0;
        } else {
            x.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", new Object[]{Long.valueOf(this.gAc)});
            bm UE = m.UE();
            if (this.gAc >= 0) {
                bl blVar2 = new bl();
                Cursor a = UE.gJP.a("VoiceTransText", null, "msgId=?", new String[]{String.valueOf(r6)}, null, null, null, 2);
                if (a.moveToFirst()) {
                    blVar2.b(a);
                }
                a.close();
                blVar = blVar2;
            }
            this.rUV = blVar;
            if (this.rUV == null || bh.ov(this.rUV.field_content)) {
                String string = getIntent().getExtras().getString("voice_trans_text_img_path");
                if (bh.ov(string)) {
                    i = 0;
                } else {
                    this.rZm = m.UD().of(string);
                    if (this.rZm != null) {
                        x.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
                        i = 1;
                    } else {
                        ar.Hg();
                        this.rZn = com.tencent.mm.z.c.Fa().dH(this.gAc);
                        if (this.rZn != null) {
                            x.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                }
            } else {
                x.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
                i = 1;
            }
        }
        if (i == 0) {
            x.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
            return;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dtJ;
    }

    protected final void initView() {
        Object obj;
        setMMTitle(R.l.eTX);
        this.miR.setOnClickListener(this);
        if (this.rUV == null || bh.ov(this.rUV.field_content)) {
            obj = null;
        } else {
            aI(b.rZH, this.rUV.field_content);
            if (!(this.jjn == null || this.rZi == null)) {
                this.mHandler.postDelayed(new 8(this), 5);
            }
            obj = 1;
        }
        if (obj == null) {
            aI(b.rZI, null);
            yj(a.rZC);
        }
    }

    private void yj(int i) {
        bEn();
        switch (AnonymousClass9.rZA[i - 1]) {
            case 1:
                x.i("MicroMsg.VoiceTransTextUI", "net check");
                if (wa() > 0) {
                    x.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", new Object[]{Long.valueOf(wa())});
                    this.rVb = new a(bEo(), bEp(), bEq().getFormat(), wa(), getFileName());
                } else {
                    x.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", new Object[]{Long.valueOf(wa())});
                    this.rVb = new a(bEo(), bEp(), getFileName());
                }
                ar.CG().a(this.rVb, 0);
                ar.CG().a(this.rVb.getType(), this);
                if (this.rZo == null) {
                    if (this.rZo == null) {
                        this.rZo = new 5(this);
                    }
                    a.xef.b(this.rZo);
                    return;
                }
                return;
            case 2:
                x.i("MicroMsg.VoiceTransTextUI", "net upload");
                if (this.rVb == null) {
                    x.d("MicroMsg.VoiceTransTextUI", "request upload must after check!");
                    return;
                } else if (bEq() == null) {
                    x.d("MicroMsg.VoiceTransTextUI", "can't get FileOperator!");
                    return;
                } else {
                    this.rVc = new c(bEo(), this.rVb.rZc, bEq().getFormat(), getFileName());
                    ar.CG().a(this.rVc, 0);
                    ar.CG().a(this.rVc.getType(), this);
                    return;
                }
            case 3:
                x.i("MicroMsg.VoiceTransTextUI", "net upload more");
                if (this.rVc == null) {
                    x.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
                    return;
                }
                this.rVc = new c(this.rVc);
                ar.CG().a(this.rVc, 0);
                ar.CG().a(this.rVc.getType(), this);
                return;
            case 4:
                this.rZl = false;
                if (this.rVg) {
                    x.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
                    return;
                }
                x.i("MicroMsg.VoiceTransTextUI", "net get");
                if (this.rVb == null) {
                    x.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
                    return;
                }
                this.rVg = true;
                this.rVd = new b(bEo());
                ar.CG().a(this.rVd, 0);
                ar.CG().a(this.rVd.getType(), this);
                return;
            default:
                return;
        }
    }

    private void aI(int i, String str) {
        while (true) {
            switch (AnonymousClass9.rZB[i - 1]) {
                case 1:
                    if (!bh.ov(str)) {
                        this.rZi.setVisibility(0);
                        this.rZg.setVisibility(8);
                        this.miR.setVisibility(4);
                        this.rZh.setVisibility(8);
                        this.rZj.setText(str);
                        iT(true);
                        break;
                    }
                    i = b.rZJ;
                    str = null;
                case 2:
                    this.rZi.setVisibility(0);
                    this.rZg.setVisibility(0);
                    this.miR.setVisibility(0);
                    if (str != null) {
                        this.rZj.setText(str);
                        iT(false);
                        break;
                    }
                    break;
                case 3:
                    this.rZi.setVisibility(8);
                    this.rZg.setVisibility(8);
                    this.miR.setHeight(0);
                    this.miR.setVisibility(8);
                    this.rZh.setVisibility(0);
                    break;
                default:
                    break;
            }
            if (i == b.rZH || i == b.rZJ) {
                this.jjn.setOnTouchListener(this.rZs);
                this.ltB.setOnClickListener(this.rZt);
                return;
            }
            this.jjn.setOnTouchListener(null);
            this.ltB.setOnClickListener(null);
            return;
        }
    }

    private void bEn() {
        x.d("MicroMsg.VoiceTransTextUI", "cancel all net");
        if (this.rVb != null) {
            ar.CG().c(this.rVb);
            ar.CG().b(this.rVb.getType(), this);
        }
        if (this.rVc != null) {
            ar.CG().c(this.rVc);
            ar.CG().b(this.rVc.getType(), this);
        }
        if (this.rVd != null) {
            ar.CG().c(this.rVd);
            ar.CG().b(this.rVd.getType(), this);
        }
    }

    private String bEo() {
        if (this.rZm != null) {
            return this.rZm.clientId;
        }
        return this.rZn.field_talker + this.rZn.field_msgId + "T" + this.rZn.field_createTime;
    }

    private int bEp() {
        if (this.rZm != null) {
            return this.rZm.hlp;
        }
        return o.nv(this.rZn.field_imgPath);
    }

    private long wa() {
        return this.rZm == null ? -1 : this.rZm.fFo;
    }

    private String getFileName() {
        if (this.rZm != null) {
            return this.rZm.fileName;
        }
        return this.rZn.field_imgPath;
    }

    private com.tencent.mm.modelvoice.b bEq() {
        if (this.rVe == null) {
            if (this.rZm != null) {
                this.rVe = q.nT(this.rZm.fileName);
            } else if (this.rZn != null) {
                this.rVe = q.nT(this.rZn.field_imgPath);
            } else {
                x.d("MicroMsg.VoiceTransTextUI", "error why get fileOperator, already has transContent. ");
            }
        }
        return this.rVe;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = null;
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 546:
                    if (this.rVb.mState == a.rZa) {
                        x.i("MicroMsg.VoiceTransTextUI", "check result: done");
                        if (this.rVb.bEk()) {
                            str2 = this.rVb.rZb.wUh;
                        }
                        Mo(str2);
                        return;
                    } else if (this.rVb.mState == a.rYZ) {
                        if (this.rVb.rZb != null && bh.ov(this.rVb.rZb.wUh)) {
                            aI(b.rZI, this.rVb.rZb.wUh);
                        }
                        x.i("MicroMsg.VoiceTransTextUI", "check result: processing");
                        yj(a.rZF);
                        return;
                    } else if (this.rVb.mState == a.rYY) {
                        x.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
                        yj(a.rZD);
                        return;
                    } else if (this.rVb.rZd != null) {
                        this.rZk = this.rVb.rZd.wHb;
                        return;
                    } else {
                        return;
                    }
                case 547:
                    if (this.rVc.bEm()) {
                        x.i("MicroMsg.VoiceTransTextUI", "succeed upload");
                        yj(a.rZF);
                        return;
                    }
                    x.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", new Object[]{Integer.valueOf(this.rVc.rZc.vIC), Integer.valueOf(this.rVc.rZc.vID)});
                    yj(a.rZE);
                    return;
                case 548:
                    this.rZk = this.rVd.rZf;
                    this.rVg = false;
                    if (!this.rVd.isComplete() && this.rVd.bEk()) {
                        aI(b.rZI, this.rVd.rZb.wUh);
                        x.d("MicroMsg.VoiceTransTextUI", "result valid:%s", new Object[]{this.rVd.rZb.wUh});
                    } else if (!this.rVd.bEk()) {
                        x.d("MicroMsg.VoiceTransTextUI", "result not valid");
                    }
                    if (this.rVd.isComplete()) {
                        x.i("MicroMsg.VoiceTransTextUI", "succeed get");
                        if (this.rVd.bEk()) {
                            str2 = this.rVd.rZb.wUh;
                        }
                        Mo(str2);
                        return;
                    } else if (this.rZl) {
                        x.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
                        yj(a.rZF);
                        return;
                    } else {
                        x.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", new Object[]{Integer.valueOf(this.rZk)});
                        int i3 = this.rZk;
                        if (!this.rVh) {
                            if (this.rVi == null) {
                                this.rVi = new ak(new 4(this, i3), false);
                            }
                            long j = (long) (i3 * 1000);
                            this.rVi.J(j, j);
                            return;
                        }
                        return;
                    }
                default:
                    return;
            }
        }
        this.rVh = true;
        aI(b.rZJ, null);
    }

    private void Mo(String str) {
        this.rVh = true;
        if (!bh.ov(str)) {
            bm UE = m.UE();
            bl blVar = new bl();
            blVar.field_msgId = this.gAc;
            blVar.XN(bEo());
            blVar.field_content = str;
            UE.a(blVar);
        }
        aI(b.rZH, str);
    }

    protected void onDestroy() {
        bEn();
        if (this.rVi != null) {
            this.rVi.TG();
        }
        if (this.rZo != null) {
            a.xef.c(this.rZo);
            this.rZo = null;
        }
        super.onDestroy();
    }

    public void onClick(View view) {
        finish();
    }

    private void iT(boolean z) {
        if (this.jjn != null && this.rZi != null) {
            this.mHandler.postDelayed(new 7(this, z), 5);
        }
    }
}

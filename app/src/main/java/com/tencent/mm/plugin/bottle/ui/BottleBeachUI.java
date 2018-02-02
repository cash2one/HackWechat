package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.y;
import com.tencent.mm.ay.g;
import com.tencent.mm.g.b.af;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.contact.d;
import com.tencent.mm.plugin.bottle.ui.OpenBottleUI.4;
import com.tencent.mm.plugin.bottle.ui.ThrowBottleUI.1;
import com.tencent.mm.plugin.bottle.ui.ThrowBottleUI.2;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

@a(1)
public class BottleBeachUI extends MMActivity implements OnClickListener, e, m.a.a, b {
    private View kBh;
    private FrameLayout kBi;
    private ThrowBottleUI kBj;
    private PickBottleUI kBk;
    private OpenBottleUI kBl;
    private BallonImageView kBm;
    private LightHouseImageView kBn;
    private ImageView kBo;
    private MoonImageView kBp;
    private ImageView kBq;
    private int kBr = 0;
    boolean kBs = true;
    private ImageView kBt;
    private ImageView kBu;
    private ImageView kBv;
    private TextView kBw;
    private d kBx;
    private b kBy;
    private boolean kBz = true;
    private r tipDialog = null;

    protected final int getLayoutId() {
        return R.i.dbt;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!q.Gj()) {
            ar.Hg();
            c.EX().b(new g(11, 1));
        }
        initView();
        ar.CG().a(d.CTRL_INDEX, this);
        ar.CG().a(new com.tencent.mm.plugin.bottle.a.d(), 0);
    }

    protected void onResume() {
        super.onResume();
        arK();
        this.mController.xIy.postDelayed(new 1(this), 1000);
        if (this.kBr == 3 && this.kBl != null) {
            OpenBottleUI openBottleUI = this.kBl;
            if (openBottleUI.fnB != null && openBottleUI.fnB.ciW()) {
                OpenBottleUI.kCP.a(openBottleUI);
            }
            openBottleUI.setScreenEnable(true);
            openBottleUI.kCY = bh.Wq();
        }
        ar.Hg();
        c.Fd().a(this);
        y.Mn().a(this);
        ar.CG().a(106, this);
    }

    protected void onPause() {
        super.onPause();
        if (this.kBr == 1 && this.kBj != null) {
            this.kBj.asf();
        }
        if (this.kBr == 3 && this.kBl != null) {
            this.kBl.onPause();
        }
        if (ar.Hj()) {
            ar.Hg();
            c.Fd().b(this);
            ar.CG().b(106, this);
        }
        y.Mn().b(this);
    }

    public void onDestroy() {
        if (this.kBj != null) {
            ThrowBottleUI throwBottleUI = this.kBj;
            throwBottleUI.kDZ = null;
            throwBottleUI.kEc = null;
            if (throwBottleUI.kEd != null) {
                throwBottleUI.kEd.cancel();
                throwBottleUI.kEd = null;
            }
            if (throwBottleUI.kEe != null) {
                throwBottleUI.kEe.release();
            }
            throwBottleUI.kEe = null;
            throwBottleUI.kEf = null;
            throwBottleUI.kCH = null;
            if (throwBottleUI.kEa != null) {
                throwBottleUI.kEa.release();
            }
            this.kBj = null;
        }
        if (this.kBk != null) {
            PickBottleUI pickBottleUI = this.kBk;
            pickBottleUI.handler.removeCallbacks(pickBottleUI.kDg);
            pickBottleUI.handler.removeCallbacks(pickBottleUI.kDh);
            pickBottleUI.kCH = null;
            pickBottleUI.kDc = null;
            pickBottleUI.kDd = null;
            this.kBk = null;
        }
        if (this.kBx != null) {
            this.kBx.cancel();
            this.kBx.context = null;
            this.kBx = null;
        }
        if (this.kBl != null) {
            b bVar = this.kBl;
            if (bVar.fnB != null && bVar.fnB.ciW()) {
                bVar.arT();
            }
            bVar.kCH = null;
            if (bVar.kCQ != null) {
                bVar.kCQ.release();
                bVar.kCQ = null;
            }
            OpenBottleUI.kCP = null;
            ar.Hg();
            c.EY().b(bVar);
            this.kBl = null;
        }
        this.kBm = null;
        this.kBn = null;
        this.kBp = null;
        if (this.kBy != null) {
            this.kBy.dismiss();
            this.kBy = null;
        }
        ar.CG().b(d.CTRL_INDEX, this);
        super.onDestroy();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        int i = 8;
        setMMTitle(R.l.dMD);
        addIconOptionMenu(0, R.l.dCn, R.k.dvc, new 2(this));
        setBackBtn(new 3(this));
        boolean cgq = bh.cgq();
        if (this.kBm == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.h.bNZ);
            ((FrameLayout) frameLayout.getParent()).removeView(frameLayout);
            ((FrameLayout) getWindow().getDecorView()).addView(frameLayout, 0);
            frameLayout.setBackgroundResource(cgq ? R.g.bzG : R.g.bzO);
            frameLayout.setVisibility(0);
            this.kBm = (BallonImageView) findViewById(R.h.bNY);
            this.kBn = (LightHouseImageView) findViewById(R.h.bOf);
            this.kBo = (ImageView) findViewById(R.h.bOD);
            this.kBp = (MoonImageView) findViewById(R.h.bOh);
        }
        this.kBm.setVisibility(cgq ? 0 : 8);
        this.kBn.setVisibility(cgq ? 8 : 0);
        this.kBp.kBo = this.kBo;
        MoonImageView moonImageView = this.kBp;
        if (!cgq) {
            i = 0;
        }
        moonImageView.setVisibility(i);
        this.kBh = findViewById(R.h.bOa);
        this.kBh.setOnClickListener(new 4(this));
        this.kBt = (ImageView) findViewById(R.h.bOu);
        this.kBu = (ImageView) findViewById(R.h.bOt);
        this.kBv = (ImageView) findViewById(R.h.bOs);
        this.kBt.setOnClickListener(this);
        this.kBu.setOnClickListener(this);
        this.kBv.setOnClickListener(this);
        this.kBq = (ImageView) findViewById(R.h.bOb);
        this.kBq.setOnClickListener(this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MM.UI.BottleUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (i2 == -2002 && this.kBr == 0) {
            nl(R.l.dMC);
            return;
        }
        switch (kVar.getType()) {
            case 106:
                x.i("MM.UI.BottleUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (!com.tencent.mm.plugin.bottle.a.ift.a(this.mController.xIM, i, i2, str)) {
                    if (i == 4 && i2 == -4) {
                        h.h(this.mController.xIM, R.l.dDd, R.l.dGO);
                        return;
                    } else if (i == 0 && i2 == 0) {
                        bem So = ((ac) kVar).So();
                        String a = n.a(So.vYI);
                        com.tencent.mm.ad.n.Jz().f(a, n.a(So.vHb));
                        Intent intent = new Intent();
                        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, So, 25);
                        if (bh.ou(a).length() > 0) {
                            if ((So.wvf & 8) > 0) {
                                com.tencent.mm.plugin.report.service.g.pQN.k(10298, a + ",25");
                            }
                            com.tencent.mm.plugin.bottle.a.ifs.d(intent, this.mController.xIM);
                            return;
                        }
                        return;
                    } else {
                        Toast.makeText(this.mController.xIM, this.mController.xIM.getString(R.l.eje, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                }
                return;
            case d.CTRL_INDEX /*152*/:
                arK();
                return;
            default:
                nk(R.l.dML);
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            if (this.kBr == 3) {
                x.v("MM.UI.BottleUI", "on key dwon");
                if (i == 25 && this.kBl.arV()) {
                    ar.Hh().fz(0);
                    return true;
                } else if (i == 24 && this.kBl.arV()) {
                    ar.Hh().fy(0);
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        } else if (!this.kBs) {
            return true;
        } else {
            if (this.kBr == 0) {
                finish();
                return true;
            }
            nm(0);
            return true;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (R.h.bOu == id) {
            if (com.tencent.mm.plugin.bottle.a.c.ary() > 0) {
                nm(1);
            } else {
                nl(R.l.dMF);
            }
        } else if (R.h.bOt == id) {
            if (com.tencent.mm.plugin.bottle.a.c.arz() > 0) {
                nm(2);
            } else {
                nl(R.l.dME);
            }
        } else if (R.h.bOs == id) {
            if (!this.kBz) {
                arJ();
            }
            r0 = new Intent();
            r0.setClass(this, BottleConversationUI.class);
            r0.putExtra("conversation_from", "from_beach");
            startActivity(r0);
        } else if (R.h.bOb == id) {
            if (this.kBr == 3) {
                this.kBl.onPause();
                this.kBl.arT();
            }
            nm(0);
            k(0, 8, 8, 8);
        } else if (R.h.bOw == id) {
            String str = ((PickedBottleImageView) view).kCR;
            String str2 = ((PickedBottleImageView) view).kAQ;
            if (str2 != null && str2.length() > 0) {
                nm(0);
                ar.Hg();
                af WO = c.EY().WO(str2);
                if (WO == null || ((int) WO.gJd) == 0 || !com.tencent.mm.l.a.fZ(WO.field_type)) {
                    k acVar = new ac(str2);
                    ar.CG().a(acVar, 0);
                    Context context = this.mController.xIM;
                    getString(R.l.dGO);
                    this.tipDialog = h.a(context, getString(R.l.dDg), true, new 5(this, acVar));
                    return;
                }
                r0 = new Intent();
                r0.putExtra("Contact_User", WO.field_username);
                if (WO.cia()) {
                    com.tencent.mm.plugin.report.service.g.pQN.k(10298, WO.field_username + ",25");
                    r0.putExtra("Contact_Scene", 25);
                }
                com.tencent.mm.plugin.bottle.a.ifs.d(r0, this.mController.xIM);
            } else if (str != null) {
                nm(3);
                OpenBottleUI openBottleUI = this.kBl;
                if (openBottleUI.kCQ == null) {
                    openBottleUI.kCQ = (ThrowBottleAnimUI) openBottleUI.kCH.findViewById(R.h.bOF);
                    openBottleUI.kCQ.kDS = new OpenBottleUI$1(openBottleUI);
                }
                if (openBottleUI.kCI == null) {
                    openBottleUI.kCI = (TextView) openBottleUI.findViewById(R.h.bOm);
                    openBottleUI.kCJ = (LinearLayout) openBottleUI.findViewById(R.h.bOp);
                    openBottleUI.kCK = (FrameLayout) openBottleUI.findViewById(R.h.bOr);
                    openBottleUI.kCL = (ImageView) openBottleUI.findViewById(R.h.bOo);
                    openBottleUI.kCM = (TextView) openBottleUI.findViewById(R.h.bOq);
                    openBottleUI.kCN = (TextView) openBottleUI.findViewById(R.h.bOj);
                    openBottleUI.kCO = (TextView) openBottleUI.findViewById(R.h.bOk);
                    openBottleUI.kCK.setOnClickListener(openBottleUI);
                }
                openBottleUI.kCR = str;
                x.d("MM.Bottle_OpenBottleUI", str);
                ar.Hg();
                openBottleUI.fnB = c.Fa().Ex(str);
                if (openBottleUI.fnB.ciW()) {
                    float bv;
                    openBottleUI.kCI.setVisibility(8);
                    openBottleUI.kCJ.setVisibility(0);
                    openBottleUI.kCK.setMinimumWidth(com.tencent.mm.bv.a.fromDPToPix(openBottleUI.kCH, OpenBottleUI.nr((int) com.tencent.mm.modelvoice.q.B(openBottleUI.fnB))));
                    openBottleUI.kCM.setText(openBottleUI.kCH.getString(R.l.ejo, new Object[]{Integer.valueOf((int) bv)}));
                    OpenBottleUI.kCP.a(openBottleUI);
                    if (openBottleUI.fnB != null) {
                        bv = com.tencent.mm.modelvoice.q.bv(new com.tencent.mm.modelvoice.n(openBottleUI.fnB.field_content).time);
                        FrameLayout frameLayout = openBottleUI.kCK;
                        openBottleUI.getResources().getString(R.l.dNa);
                        frameLayout.setContentDescription(String.format("%d", new Object[]{Integer.valueOf((int) bv)}));
                    }
                } else {
                    openBottleUI.kCI.setVisibility(0);
                    openBottleUI.kCJ.setVisibility(8);
                    openBottleUI.kCI.setText(openBottleUI.fnB.field_content);
                    i.f(openBottleUI.kCI, 1);
                }
                openBottleUI.arU();
                if (openBottleUI.kCW == null) {
                    openBottleUI.kCW = (TextView) openBottleUI.findViewById(R.h.cfJ);
                    openBottleUI.kCW.setOnClickListener(new 4(openBottleUI));
                }
            } else {
                nm(0);
            }
        }
    }

    private void arJ() {
        boolean z = this.kBz;
        fullScreenNoTitleBar(z);
        this.kBz = !z;
    }

    private void nk(int i) {
        CharSequence string = i > 0 ? this.mController.xIM.getString(i) : null;
        if (this.kBx == null) {
            this.kBx = new d(this);
        }
        this.kBx.cancel();
        if (string != null) {
            this.kBx.setDuration(0);
            this.kBx.setText(string);
            this.kBx.show();
        }
    }

    public final void nl(int i) {
        if (this.kBy == null) {
            this.kBy = new b(this);
        }
        b bVar = this.kBy;
        bVar.imw.setText(getString(i));
        this.kBy.show();
    }

    public final void nm(int i) {
        this.kBr = i;
        nk(0);
        if (this.kBz) {
            arJ();
        }
        switch (i) {
            case 0:
                this.kBs = true;
                k(0, 8, 8, 8);
                return;
            case 1:
                k(8, 0, 8, 8);
                return;
            case 2:
                k(8, 8, 0, 8);
                return;
            case 3:
                k(8, 8, 8, 0);
                return;
            default:
                k(8, 8, 8, 8);
                return;
        }
    }

    private void k(int i, int i2, int i3, int i4) {
        x.v("MM.UI.BottleUI", "set frame visible");
        if (this.kBi == null) {
            this.kBi = (FrameLayout) findViewById(R.h.bOe);
        }
        this.kBh.setVisibility(i);
        if (i == 0) {
            arK();
            this.kBq.setVisibility(8);
            aWs();
        }
        if (i2 == 0 && this.kBj == null) {
            this.kBj = (ThrowBottleUI) View.inflate(this, R.i.dbx, null);
            this.kBi.addView(this.kBj);
            ThrowBottleUI throwBottleUI = this.kBj;
            throwBottleUI.kEa = new ToneGenerator(1, 60);
            throwBottleUI.kEd = (Vibrator) throwBottleUI.kCH.getSystemService("vibrator");
            throwBottleUI.kEg = (ImageView) throwBottleUI.findViewById(R.h.bOy);
            throwBottleUI.kEh = (TextView) throwBottleUI.findViewById(R.h.bNX);
            throwBottleUI.kEh.setVisibility(8);
            throwBottleUI.kEi = (ImageView) throwBottleUI.findViewById(R.h.bOx);
            throwBottleUI.kEj = (MMEditText) throwBottleUI.findViewById(R.h.bOL);
            throwBottleUI.kEk = throwBottleUI.findViewById(R.h.bOH);
            throwBottleUI.kEn = (ThrowBottleFooter) throwBottleUI.findViewById(R.h.bOM);
            throwBottleUI.kDe = (ImageView) throwBottleUI.kCH.findViewById(R.h.bOb);
            throwBottleUI.kEm = (ImageButton) throwBottleUI.findViewById(R.h.bNW);
            throwBottleUI.kEm.setOnClickListener(throwBottleUI);
            throwBottleUI.kEl = (Button) throwBottleUI.findViewById(R.h.bOI);
            throwBottleUI.kEl.setOnTouchListener(new 2(throwBottleUI));
            throwBottleUI.setOnClickListener(throwBottleUI);
            if (throwBottleUI.kEq == null) {
                throwBottleUI.kEq = (LayoutParams) throwBottleUI.kEj.getLayoutParams();
                throwBottleUI.kEs = throwBottleUI.kEq.topMargin;
            }
            throwBottleUI.kEn.kDW = new 1(throwBottleUI);
        }
        if (this.kBj != null) {
            this.kBj.setVisibility(i2);
        }
        if (i3 == 0 && this.kBk == null) {
            this.kBk = (PickBottleUI) View.inflate(this, R.i.dbw, null);
            this.kBi.addView(this.kBk);
            this.kBk.initView();
        }
        if (this.kBk != null) {
            this.kBk.setVisibility(i3);
        }
        if (i3 == 0) {
            this.kBk.density = com.tencent.mm.bv.a.getDensity(this);
            PickBottleUI pickBottleUI = this.kBk;
            pickBottleUI.kDd.setVisibility(8);
            pickBottleUI.kDc.G(Integer.MAX_VALUE, -1, -1);
            pickBottleUI.kDe.setVisibility(8);
            pickBottleUI.kCH.kBs = false;
            pickBottleUI.handler.postDelayed(pickBottleUI.kDg, 1000);
        }
        if (i4 == 0 && this.kBl == null) {
            this.kBl = (OpenBottleUI) View.inflate(this, R.i.dbv, null);
            this.kBi.addView(this.kBl);
            Object obj = this.kBl;
            ((Button) obj.findViewById(R.h.bOn)).setOnClickListener(obj);
            ((Button) obj.findViewById(R.h.bOl)).setOnClickListener(obj);
            obj.kCX = this;
        }
        if (this.kBl != null) {
            this.kBl.setVisibility(i4);
        }
    }

    private void arK() {
        if (this.kBw == null) {
            this.kBw = (TextView) findViewById(R.h.bOg);
            this.kBw.setBackgroundResource(s.gd(this.mController.xIM));
        }
        int arA = com.tencent.mm.plugin.bottle.a.c.arA();
        this.kBw.setText(String.valueOf(arA));
        this.kBw.setVisibility(arA > 0 ? 0 : 8);
    }

    public final void ki(String str) {
        if (this.kBk != null) {
            PickBottleUI pickBottleUI = this.kBk;
            if (pickBottleUI.kDd != null) {
                PickedBottleImageView pickedBottleImageView = pickBottleUI.kDd;
                if (str.equals(pickedBottleImageView.kAQ)) {
                    pickedBottleImageView.kDk = m.d(pickedBottleImageView.kAQ, pickedBottleImageView.iconUrl, R.g.bEk);
                    pickedBottleImageView.update();
                    pickedBottleImageView.invalidate();
                }
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        arK();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MM.UI.BottleUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    h.a(this, getString(R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 6(this), null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

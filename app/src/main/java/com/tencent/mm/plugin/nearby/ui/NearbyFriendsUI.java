package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.bf.l;
import com.tencent.mm.k.g;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.nearby.a.b;
import com.tencent.mm.plugin.nearby.a.d;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.protocal.c.aoe;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import java.util.List;

public class NearbyFriendsUI extends MMActivity implements e {
    private a gyF = new 8(this);
    private c gyH = new 1(this);
    private com.tencent.mm.modelgeo.c gyy;
    boolean hnr = false;
    private List<aoe> maE = new LinkedList();
    private boolean nWa = false;
    private List<aoe> nXr = new LinkedList();
    private b oOB;
    private ListView oOC;
    private com.tencent.mm.plugin.nearby.a.c oOD;
    private d oOE;
    private boolean oOF = false;
    private String[] oOG;
    private int oOH = 1;
    private BindMobileOrQQHeaderView oOI;
    private ViewGroup oOJ;
    private View oOK;
    private View oOL;
    private boolean oOM = false;
    private int oON;
    private boolean oOO = false;
    private int oOP = 0;
    private View oOQ = null;
    private a oOR;
    private com.tencent.mm.plugin.nearby.a.c oOp;
    private r tipDialog = null;

    static /* synthetic */ void l(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.NearbyFriend", "setImgBmp url is empty");
            return;
        }
        imageView.setImageBitmap(null);
        com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
        ar.Hg();
        aVar.hDD = com.tencent.mm.z.c.Fi();
        aVar.hDA = true;
        aVar.hDX = true;
        o.PA().a(str, imageView, aVar.PK());
    }

    static /* synthetic */ void w(NearbyFriendsUI nearbyFriendsUI) {
        if (nearbyFriendsUI.oOR != null) {
            nearbyFriendsUI.oOE = new d(nearbyFriendsUI.oOR.hxG, nearbyFriendsUI.oOR.hxF, nearbyFriendsUI.oOR.accuracy, "", "");
            Context context = nearbyFriendsUI.mController.xIM;
            nearbyFriendsUI.getString(R.l.dGO);
            nearbyFriendsUI.tipDialog = h.a(context, nearbyFriendsUI.getString(R.l.ext), true, new OnCancelListener(nearbyFriendsUI) {
                final /* synthetic */ NearbyFriendsUI oOS;

                {
                    this.oOS = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    ar.CG().c(this.oOS.oOE);
                }
            });
            b.tN(3);
            ar.CG().a(nearbyFriendsUI.oOE, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        f.vz(11);
        super.onCreate(bundle);
        setMMTitle(R.l.exr);
        ar.CG().a(JsApiScanCode.CTRL_INDEX, this);
        ar.CG().a(376, this);
        ar.CG().a(1087, this);
        this.gyy = com.tencent.mm.modelgeo.c.OP();
        initView();
        this.oOG = new String[]{getResources().getString(R.l.exl), getResources().getString(R.l.exk), getResources().getString(R.l.exj), getResources().getString(R.l.eHk)};
        ar.Hg();
        this.oOH = bh.a((Integer) com.tencent.mm.z.c.CU().get(16386, null), 1);
        if (this.oOH == 3) {
            DQ(R.k.dyN);
        } else if (this.oOH == 4) {
            DQ(R.k.dyM);
        } else {
            DQ(0);
            this.oOH = 1;
        }
        beX();
    }

    private void beX() {
        this.nWa = false;
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.tipDialog = h.a(context, getString(R.l.exi), true, new 7(this));
        this.hnr = false;
        if (this.gyy != null) {
            this.gyy.a(this.gyF, true);
        }
    }

    protected final int getLayoutId() {
        return R.i.doJ;
    }

    private void beY() {
        if (com.tencent.mm.bk.a.bXU()) {
            View view;
            if (this.oOQ != null) {
                this.oOC.removeHeaderView(this.oOQ);
                this.oOQ = null;
            }
            View inflate = View.inflate(this, R.i.doN, null);
            TextView textView = (TextView) inflate.findViewById(R.h.cIH);
            int Tq = l.Ty().Tq();
            if (Tq == 0) {
                inflate.setVisibility(8);
                view = null;
            } else {
                inflate.setVisibility(0);
                textView.setText(getResources().getQuantityString(R.j.duK, Tq, new Object[]{Integer.valueOf(Tq)}));
                ImageView imageView = (ImageView) inflate.findViewById(R.h.cvt);
                com.tencent.mm.bf.h Tr = l.Ty().Tr();
                if (Tr != null) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, Tr.field_sayhiuser);
                }
                inflate.setOnClickListener(new 9(this));
                view = inflate;
            }
            this.oOQ = view;
            if (this.oOQ != null) {
                this.oOC.addHeaderView(this.oOQ);
            }
        }
    }

    protected final void initView() {
        this.oOC = (ListView) findViewById(R.h.cyW);
        this.oOB = new b(this, this);
        ListView listView = this.oOC;
        if (this.oOJ == null) {
            this.oOJ = new LinearLayout(this);
            this.oOJ.setLayoutParams(new LayoutParams(-1, -2));
            ((LinearLayout) this.oOJ).setGravity(17);
        }
        this.oOM = true;
        listView.addHeaderView(this.oOJ);
        String value = g.zY().getValue("LBSShowBindPhone");
        if (value != null && value.length() > 0) {
            try {
                this.oON = Integer.valueOf(value).intValue();
            } catch (Exception e) {
                this.oON = 0;
            }
        }
        ar.Hg();
        value = (String) com.tencent.mm.z.c.CU().get(6, null);
        if (value != null && value.length() > 0) {
            this.oON = 0;
        }
        this.oOP = 0;
        if (com.tencent.mm.z.a.g.Ij().ie(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
            value = com.tencent.mm.z.a.g.Ij().ie(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).value;
            m.a NN = m.NN();
            if (value.equals("0")) {
                this.oOP = 0;
            } else if (value.equals("2")) {
                if (NN == m.a.hwj) {
                    this.oOP = 2;
                    com.tencent.mm.z.a.f.ii(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                }
            } else if (value.equals("1") && NN == m.a.hwg) {
                this.oOP = 2;
                com.tencent.mm.z.a.f.ii(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            }
        }
        if ((this.oON > 0 || this.oOP > 0) && this.oOP != 1) {
            this.oOI = new BindMobileOrQQHeaderView(this);
            this.oOC.addHeaderView(this.oOI);
        }
        this.oOC.setAdapter(this.oOB);
        this.oOC.setOnItemClickListener(new 10(this));
        this.oOC.setOnTouchListener(new 11(this));
        setBackBtn(new 12(this));
        13 13 = new 13(this);
        addIconOptionMenu(0, R.g.bDI, new 14(this));
    }

    private void beZ() {
        com.tencent.mm.plugin.nearby.a.ifs.as(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.oOF = false;
                    beX();
                    return;
                }
                return;
            case TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION /*2009*/:
                if (i2 == -1) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.gyy != null) {
            this.gyy.c(this.gyF);
        }
        com.tencent.mm.sdk.b.a.xef.c(this.gyH);
    }

    protected void onResume() {
        super.onResume();
        if (this.gyy != null) {
            this.gyy.a(this.gyF, true);
        }
        beY();
        this.oOB.notifyDataSetChanged();
        if (l.Ty().Tq() == 0) {
            this.oOC.removeHeaderView(this.oOL);
        }
        com.tencent.mm.sdk.b.a.xef.b(this.gyH);
    }

    protected void onDestroy() {
        if (this.oOP > 0) {
            com.tencent.mm.z.a.f.ij(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        }
        f.vB(11);
        ar.CG().b(JsApiScanCode.CTRL_INDEX, this);
        ar.CG().b(376, this);
        ar.CG().b(1087, this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (this.gyy != null) {
            this.gyy.c(this.gyF);
        }
        n.JS().cancel();
        if (this.oOB != null) {
            b bVar = this.oOB;
            if (bVar.hvU != null) {
                bVar.hvU.detach();
                bVar.hvU = null;
            }
        }
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == JsApiScanCode.CTRL_INDEX) {
            int IS = ((com.tencent.mm.plugin.nearby.a.c) kVar).IS();
            if (this.oOD != null || (IS != 1 && IS != 3 && IS != 4)) {
                if ((IS == 1 || IS == 3 || IS == 4) && this.oOF) {
                    x.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[]{Integer.valueOf(IS)});
                } else if (this.oOp != null || IS != 2) {
                    x.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (kVar.getType() == JsApiScanCode.CTRL_INDEX) {
                        if (this.tipDialog != null) {
                            this.tipDialog.dismiss();
                            this.tipDialog = null;
                        }
                        if (i == 0 && i2 == 0) {
                            if (IS == 1 || IS == 3 || IS == 4) {
                                this.maE = ((com.tencent.mm.plugin.nearby.a.c) kVar).beV();
                                if (this.maE == null || this.maE.size() == 0) {
                                    findViewById(R.h.cyY).setVisibility(0);
                                    this.oOC.setVisibility(8);
                                    beZ();
                                    f.vB(11);
                                } else {
                                    findViewById(R.h.cyY).setVisibility(8);
                                    List linkedList = new LinkedList();
                                    int i3 = 0;
                                    for (aoe com_tencent_mm_protocal_c_aoe : this.maE) {
                                        ar.Hg();
                                        if (com.tencent.mm.z.c.EY().WK(com_tencent_mm_protocal_c_aoe.ksU)) {
                                            linkedList.add(i3, com_tencent_mm_protocal_c_aoe);
                                            i3++;
                                        } else {
                                            linkedList.add(com_tencent_mm_protocal_c_aoe);
                                        }
                                    }
                                    this.maE.clear();
                                    this.maE = linkedList;
                                    if (this.nXr != null) {
                                        for (IS = this.nXr.size() - 1; IS >= 0; IS--) {
                                            if (this.nXr.get(IS) != null) {
                                                this.maE.add(0, this.nXr.get(IS));
                                            }
                                        }
                                    }
                                    this.oOB.notifyDataSetChanged();
                                    if (this.oOB.getCount() > 0) {
                                        this.oOC.setSelection(0);
                                    }
                                    this.oOC.post(new Runnable(this) {
                                        final /* synthetic */ NearbyFriendsUI oOS;

                                        {
                                            this.oOS = r1;
                                        }

                                        public final void run() {
                                            f.vA(11);
                                        }
                                    });
                                }
                                if (this.oOH == 3) {
                                    DQ(R.k.dyN);
                                } else if (this.oOH == 4) {
                                    DQ(R.k.dyM);
                                } else {
                                    DQ(0);
                                    this.oOH = 1;
                                }
                                this.oOF = true;
                                this.oOD = null;
                            }
                            if (((com.tencent.mm.plugin.nearby.a.c) kVar).IS() == 2) {
                                h.a(this.mController.xIM, getString(R.l.exb), "", new OnClickListener(this) {
                                    final /* synthetic */ NearbyFriendsUI oOS;

                                    {
                                        this.oOS = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.oOS.finish();
                                    }
                                });
                                this.oOp = null;
                            }
                            if (((com.tencent.mm.plugin.nearby.a.c) kVar).beT()) {
                                CharSequence string = getString(R.l.exu);
                                int beU = ((com.tencent.mm.plugin.nearby.a.c) kVar).beU();
                                if (this.oOJ != null) {
                                    if (this.oOK == null) {
                                        this.oOK = View.inflate(this, R.i.doO, null);
                                        this.oOJ.addView(this.oOK);
                                        this.oOK.setOnClickListener(new 2(this));
                                    } else {
                                        this.oOK.setVisibility(0);
                                    }
                                    ((TextView) this.oOK.findViewById(R.h.cze)).setText(string);
                                    if (beU != 0) {
                                        ((TextView) this.oOK.findViewById(R.h.czd)).setText(String.format(getResources().getQuantityString(R.j.duD, beU, new Object[]{Integer.valueOf(beU)}), new Object[0]));
                                    }
                                }
                            } else if (!(this.oOK == null || this.oOJ == null)) {
                                this.oOK.setVisibility(8);
                            }
                            this.oOO = true;
                            return;
                        }
                        if (IS == 1 || IS == 3 || IS == 4) {
                            com.tencent.mm.h.a aVar;
                            TextView textView = (TextView) findViewById(R.h.cyY);
                            textView.setVisibility(0);
                            beZ();
                            if (str == null || str.length() <= 0) {
                                aVar = null;
                            } else {
                                aVar = com.tencent.mm.h.a.eA(str);
                            }
                            if (aVar != null && aVar.desc != null && aVar.desc.length() > 0) {
                                textView.setText(aVar.desc);
                            } else if (i2 == -2001) {
                                textView.setText(getString(R.l.exd));
                            } else {
                                textView.setText(getString(R.l.exg));
                            }
                            this.oOC.setVisibility(8);
                            this.oOD = null;
                        }
                        if (((com.tencent.mm.plugin.nearby.a.c) kVar).IS() == 2) {
                            Toast.makeText(this, R.l.exa, 1).show();
                            this.oOp = null;
                        }
                    }
                }
            }
        } else if (kVar.getType() == 376 && ((d) kVar).IS() == 1) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i == 0 && i2 == 0 && ((d) kVar).oNY != null) {
                String str2 = ((d) kVar).oNY;
                b.dz(str2, ((d) kVar).oNZ);
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str2);
                com.tencent.mm.plugin.nearby.a.ifs.f(intent, this);
                return;
            }
            h.a(this.mController.xIM, R.l.exs, R.l.dGO, new OnClickListener(this) {
                final /* synthetic */ NearbyFriendsUI oOS;

                {
                    this.oOS = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}

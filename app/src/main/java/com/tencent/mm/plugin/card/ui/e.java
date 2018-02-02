package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g$a;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.a.h;
import com.tencent.mm.plugin.card.ui.view.d;
import com.tencent.mm.plugin.card.ui.view.i;
import com.tencent.mm.plugin.card.ui.view.j;
import com.tencent.mm.plugin.card.ui.view.k;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.plugin.card.ui.view.u;
import com.tencent.mm.plugin.card.ui.view.w;
import com.tencent.mm.plugin.card.ui.view.y;
import com.tencent.mm.plugin.card.ui.view.z;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.protocal.c.qz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.z.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class e implements g$a, n, a {
    ListView Fv;
    private final String TAG = "MicroMsg.CardDetailUIContoller";
    LinearLayout ee;
    boolean fvI = false;
    OnClickListener inN = new 4(this);
    b kIK;
    List<com.tencent.mm.plugin.card.model.b> kIO = new ArrayList();
    ArrayList<kj> kIQ;
    private View kND;
    public int kOu = 0;
    String kOv = "";
    String kOw = "";
    public ArrayList<String> kOx = new ArrayList();
    public ArrayList<String> kOy = new ArrayList();
    CardDetailBaseUI kQM;
    g kQN;
    i kQO;
    boolean kQP = false;
    i kQQ;
    i kQR;
    com.tencent.mm.plugin.card.widget.g kQS;
    com.tencent.mm.plugin.card.ui.view.g kQT;
    m kQU;
    i kQV;
    i kQW;
    i kQX;
    i kQY;
    i kQZ;
    i kRa;
    i kRb;
    i kRc;
    d kRd;
    i kRe;
    j kRf;
    boolean kRg = true;
    f kRh;
    public String kRi = "";
    public String kRj = "";
    HashMap<Integer, String> kRk = new HashMap();
    HashMap<String, String> kRl = new HashMap();
    ArrayList<String> kRm = new ArrayList();
    d kRn;
    a kRo;
    private af kRp = new 3(this);
    c kRq = new 7(this);

    static /* synthetic */ void a(e eVar) {
        Intent intent = new Intent();
        if (eVar.kIK instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) eVar.kIK);
        } else if (eVar.kIK instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) eVar.kIK);
        }
        intent.putExtra("key_from_appbrand_type", eVar.kRo.kRu);
        intent.setClass(eVar.kQM, CardShopUI.class);
        eVar.kQM.startActivity(intent);
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[9];
        objArr[0] = "UsedStoresView";
        objArr[1] = Integer.valueOf(eVar.kIK.atB().kJO);
        objArr[2] = eVar.kIK.atG();
        objArr[3] = eVar.kIK.atF();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(eVar.kRo.kNT);
        objArr[6] = eVar.kRo.kQw;
        objArr[7] = Integer.valueOf(eVar.kIK.atz() ? 1 : 0);
        objArr[8] = "";
        gVar.h(11324, objArr);
    }

    static /* synthetic */ void b(e eVar) {
        com.tencent.mm.plugin.card.b.b.a(eVar.kQM, 0, eVar);
        eVar.kQM.jwN = eVar;
    }

    public e(CardDetailBaseUI cardDetailBaseUI, View view) {
        this.kQM = cardDetailBaseUI;
        this.kND = view;
    }

    public final void a(b bVar, a aVar, ArrayList<kj> arrayList) {
        this.kIK = bVar;
        this.kRo = aVar;
        this.kIQ = arrayList;
    }

    public final View findViewById(int i) {
        return this.kND.findViewById(i);
    }

    public final b avI() {
        return this.kIK;
    }

    public final void d(b bVar) {
        if (bVar != null) {
            this.kIK = bVar;
            if (this.kRn != null) {
                this.kRn.d(bVar);
            }
            ava();
        }
    }

    public final boolean avJ() {
        return this.kQP;
    }

    public final void avK() {
        this.kQP = false;
    }

    public final MMActivity avL() {
        return this.kQM;
    }

    public final OnClickListener avM() {
        return this.inN;
    }

    public final g avN() {
        return this.kQN;
    }

    public final d avO() {
        return this.kRn;
    }

    public final a avP() {
        return this.kRo;
    }

    public final f avQ() {
        return this.kRh;
    }

    public final j avR() {
        return this.kRf;
    }

    public final String getString(int i) {
        return this.kQM.getString(i);
    }

    public final void ava() {
        if (this.kIK == null) {
            x.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
            if (this.kRn != null) {
                this.kRn.avF();
            }
        } else if (this.kIK.atB() == null) {
            x.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
            if (this.kRn != null) {
                this.kRn.avF();
            }
        } else if (this.kIK.atC() == null) {
            x.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
            if (this.kRn != null) {
                this.kRn.avF();
            }
        } else if (this.kIK.atn()) {
            int i;
            x.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
            x.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.kIK.atB().vSj);
            f fVar = this.kRh;
            b bVar = this.kIK;
            ArrayList arrayList = this.kIQ;
            int i2 = this.kRo.kFm;
            fVar.kIK = bVar;
            fVar.kIQ = arrayList;
            fVar.kFm = i2;
            boolean z = this.kQN == null ? false : this.kIK.ath() ? !(this.kQN instanceof h) : this.kIK.ati() ? !(this.kQN instanceof com.tencent.mm.plugin.card.ui.a.e) : this.kIK.atl() ? !(this.kQN instanceof com.tencent.mm.plugin.card.ui.a.b) : this.kIK.atj() ? !(this.kQN instanceof com.tencent.mm.plugin.card.ui.a.c) : this.kIK.atk() ? !(this.kQN instanceof com.tencent.mm.plugin.card.ui.a.f) : this.kIK.atm() ? !(this.kQN instanceof com.tencent.mm.plugin.card.ui.a.d) : !(this.kQN instanceof com.tencent.mm.plugin.card.ui.a.a);
            if (z) {
                this.kQN.release();
                this.kQN = null;
                x.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[]{Integer.valueOf(this.kIK.atB().kJO)});
            }
            if (this.kQN == null) {
                x.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[]{Integer.valueOf(this.kIK.atB().kJO)});
                x.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[]{Integer.valueOf(this.kIK.atB().kJO)});
                if (!this.kIK.ath()) {
                    switch (this.kIK.atB().kJO) {
                        case 0:
                            this.kQN = new com.tencent.mm.plugin.card.ui.a.c(this.kQM);
                            break;
                        case 10:
                            this.kQN = new com.tencent.mm.plugin.card.ui.a.e(this.kQM);
                            break;
                        case 11:
                            this.kQN = new com.tencent.mm.plugin.card.ui.a.b(this.kQM);
                            break;
                        case 20:
                            this.kQN = new com.tencent.mm.plugin.card.ui.a.f(this.kQM);
                            break;
                        case 30:
                            this.kQN = new com.tencent.mm.plugin.card.ui.a.d(this.kQM);
                            break;
                        default:
                            this.kQN = new com.tencent.mm.plugin.card.ui.a.a(this.kQM);
                            break;
                    }
                }
                this.kQN = new h(this.kQM);
            }
            x.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", new Object[]{Integer.valueOf(this.kIK.atB().kJO)});
            this.kQN.a(this.kIK, this.kRo);
            this.kQN.awV();
            x.i("MicroMsg.CardDetailUIContoller", "");
            if (this.kQN.awD()) {
                this.kQM.setMMTitle(this.kRh.getTitle());
            } else {
                this.kQM.setMMTitle("");
            }
            if (this.kIK == null) {
                x.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
            } else {
                View axl;
                LinearLayout linearLayout;
                if (this.kQS != null) {
                    if (this.kIK.ati()) {
                        if (!(this.kQS instanceof com.tencent.mm.plugin.card.widget.e)) {
                            z = true;
                            if (z) {
                                axl = this.kQS.axl();
                                if (axl != null) {
                                    this.ee.removeView(axl);
                                }
                                this.ee.removeAllViews();
                                this.ee.invalidate();
                                this.kQS.release();
                                this.kQS = null;
                            }
                            if (this.kQS == null) {
                                if (this.kIK.ati()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.e(this.kQM);
                                } else if (this.kIK.atl()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.c(this.kQM);
                                } else if (this.kIK.atj()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.b(this.kQM);
                                } else if (this.kIK.atk()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.f(this.kQM);
                                } else if (this.kIK.atm()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.b(this.kQM);
                                } else {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.d(this.kQM);
                                }
                                this.kQS.k(this.kIK);
                                axl = this.kQS.axl();
                                if (axl != null) {
                                    linearLayout = this.ee;
                                    axl.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(axl);
                                }
                                this.ee.invalidate();
                                this.kQS.setOnClickListener(this.inN);
                                r(false, false);
                            }
                            if (this.kQS != null) {
                                if (this.kIK.atk()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.kQS).kIQ = this.kIQ;
                                }
                                this.kQS.f(this.kIK);
                            }
                        }
                    } else if (this.kIK.atl()) {
                        if (!(this.kQS instanceof com.tencent.mm.plugin.card.widget.c)) {
                            z = true;
                            if (z) {
                                axl = this.kQS.axl();
                                if (axl != null) {
                                    this.ee.removeView(axl);
                                }
                                this.ee.removeAllViews();
                                this.ee.invalidate();
                                this.kQS.release();
                                this.kQS = null;
                            }
                            if (this.kQS == null) {
                                if (this.kIK.ati()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.e(this.kQM);
                                } else if (this.kIK.atl()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.c(this.kQM);
                                } else if (this.kIK.atj()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.b(this.kQM);
                                } else if (this.kIK.atk()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.f(this.kQM);
                                } else if (this.kIK.atm()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.b(this.kQM);
                                } else {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.d(this.kQM);
                                }
                                this.kQS.k(this.kIK);
                                axl = this.kQS.axl();
                                if (axl != null) {
                                    linearLayout = this.ee;
                                    axl.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(axl);
                                }
                                this.ee.invalidate();
                                this.kQS.setOnClickListener(this.inN);
                                r(false, false);
                            }
                            if (this.kQS != null) {
                                if (this.kIK.atk()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.kQS).kIQ = this.kIQ;
                                }
                                this.kQS.f(this.kIK);
                            }
                        }
                    } else if (this.kIK.atj()) {
                        if (!(this.kQS instanceof com.tencent.mm.plugin.card.widget.b)) {
                            z = true;
                            if (z) {
                                axl = this.kQS.axl();
                                if (axl != null) {
                                    this.ee.removeView(axl);
                                }
                                this.ee.removeAllViews();
                                this.ee.invalidate();
                                this.kQS.release();
                                this.kQS = null;
                            }
                            if (this.kQS == null) {
                                if (this.kIK.ati()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.e(this.kQM);
                                } else if (this.kIK.atl()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.c(this.kQM);
                                } else if (this.kIK.atj()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.b(this.kQM);
                                } else if (this.kIK.atk()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.f(this.kQM);
                                } else if (this.kIK.atm()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.d(this.kQM);
                                } else {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.b(this.kQM);
                                }
                                this.kQS.k(this.kIK);
                                axl = this.kQS.axl();
                                if (axl != null) {
                                    linearLayout = this.ee;
                                    axl.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(axl);
                                }
                                this.ee.invalidate();
                                this.kQS.setOnClickListener(this.inN);
                                r(false, false);
                            }
                            if (this.kQS != null) {
                                if (this.kIK.atk()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.kQS).kIQ = this.kIQ;
                                }
                                this.kQS.f(this.kIK);
                            }
                        }
                    } else if (this.kIK.atk()) {
                        if (!(this.kQS instanceof com.tencent.mm.plugin.card.widget.f)) {
                            z = true;
                            if (z) {
                                axl = this.kQS.axl();
                                if (axl != null) {
                                    this.ee.removeView(axl);
                                }
                                this.ee.removeAllViews();
                                this.ee.invalidate();
                                this.kQS.release();
                                this.kQS = null;
                            }
                            if (this.kQS == null) {
                                if (this.kIK.ati()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.e(this.kQM);
                                } else if (this.kIK.atl()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.c(this.kQM);
                                } else if (this.kIK.atj()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.b(this.kQM);
                                } else if (this.kIK.atk()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.f(this.kQM);
                                } else if (this.kIK.atm()) {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.b(this.kQM);
                                } else {
                                    this.kQS = new com.tencent.mm.plugin.card.widget.d(this.kQM);
                                }
                                this.kQS.k(this.kIK);
                                axl = this.kQS.axl();
                                if (axl != null) {
                                    linearLayout = this.ee;
                                    axl.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(axl);
                                }
                                this.ee.invalidate();
                                this.kQS.setOnClickListener(this.inN);
                                r(false, false);
                            }
                            if (this.kQS != null) {
                                if (this.kIK.atk()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.kQS).kIQ = this.kIQ;
                                }
                                this.kQS.f(this.kIK);
                            }
                        }
                    } else if (this.kIK.atm() && !(this.kQS instanceof com.tencent.mm.plugin.card.widget.d)) {
                        z = true;
                        if (z) {
                            axl = this.kQS.axl();
                            if (axl != null) {
                                this.ee.removeView(axl);
                            }
                            this.ee.removeAllViews();
                            this.ee.invalidate();
                            this.kQS.release();
                            this.kQS = null;
                        }
                        if (this.kQS == null) {
                            if (this.kIK.ati()) {
                                this.kQS = new com.tencent.mm.plugin.card.widget.e(this.kQM);
                            } else if (this.kIK.atl()) {
                                this.kQS = new com.tencent.mm.plugin.card.widget.c(this.kQM);
                            } else if (this.kIK.atj()) {
                                this.kQS = new com.tencent.mm.plugin.card.widget.b(this.kQM);
                            } else if (this.kIK.atk()) {
                                this.kQS = new com.tencent.mm.plugin.card.widget.f(this.kQM);
                            } else if (this.kIK.atm()) {
                                this.kQS = new com.tencent.mm.plugin.card.widget.d(this.kQM);
                            } else {
                                this.kQS = new com.tencent.mm.plugin.card.widget.b(this.kQM);
                            }
                            this.kQS.k(this.kIK);
                            axl = this.kQS.axl();
                            if (axl != null) {
                                linearLayout = this.ee;
                                axl.setLayoutParams(new LayoutParams(-1, -2));
                                linearLayout.addView(axl);
                            }
                            this.ee.invalidate();
                            this.kQS.setOnClickListener(this.inN);
                            r(false, false);
                        }
                        if (this.kQS != null) {
                            if (this.kIK.atk()) {
                                ((com.tencent.mm.plugin.card.widget.f) this.kQS).kIQ = this.kIQ;
                            }
                            this.kQS.f(this.kIK);
                        }
                    }
                }
                z = false;
                if (z) {
                    axl = this.kQS.axl();
                    if (axl != null) {
                        this.ee.removeView(axl);
                    }
                    this.ee.removeAllViews();
                    this.ee.invalidate();
                    this.kQS.release();
                    this.kQS = null;
                }
                if (this.kQS == null) {
                    if (this.kIK.ati()) {
                        this.kQS = new com.tencent.mm.plugin.card.widget.e(this.kQM);
                    } else if (this.kIK.atl()) {
                        this.kQS = new com.tencent.mm.plugin.card.widget.c(this.kQM);
                    } else if (this.kIK.atj()) {
                        this.kQS = new com.tencent.mm.plugin.card.widget.b(this.kQM);
                    } else if (this.kIK.atk()) {
                        this.kQS = new com.tencent.mm.plugin.card.widget.f(this.kQM);
                    } else if (this.kIK.atm()) {
                        this.kQS = new com.tencent.mm.plugin.card.widget.b(this.kQM);
                    } else {
                        this.kQS = new com.tencent.mm.plugin.card.widget.d(this.kQM);
                    }
                    this.kQS.k(this.kIK);
                    axl = this.kQS.axl();
                    if (axl != null) {
                        linearLayout = this.ee;
                        axl.setLayoutParams(new LayoutParams(-1, -2));
                        linearLayout.addView(axl);
                    }
                    this.ee.invalidate();
                    this.kQS.setOnClickListener(this.inN);
                    r(false, false);
                }
                if (this.kQS != null) {
                    if (this.kIK.atk()) {
                        ((com.tencent.mm.plugin.card.widget.f) this.kQS).kIQ = this.kIQ;
                    }
                    this.kQS.f(this.kIK);
                }
            }
            if (this.kQN.awE()) {
                x.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
                this.kQO.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
                this.kQO.awW();
            }
            if (this.kQN.awv()) {
                if (this.kRe == null) {
                    this.kRe = new com.tencent.mm.plugin.card.ui.view.b();
                    this.kRe.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
                this.kRe.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
                if (this.kRe != null) {
                    this.kRe.awW();
                }
            }
            this.kQM.ea(this.kQN.awz());
            if (this.kQN.awA()) {
                this.kRk.clear();
                this.kRm.clear();
                if (this.kIK.atp()) {
                    this.kRm.add(getString(R.l.eYf));
                    this.kRk.put(Integer.valueOf(0), "menu_func_share_friend");
                    this.kRm.add(getString(R.l.eYe));
                    this.kRk.put(Integer.valueOf(1), "menu_func_share_timeline");
                    i = 2;
                } else {
                    i = 0;
                }
                if (!TextUtils.isEmpty(this.kIK.atC().vRi)) {
                    this.kRm.add(getString(R.l.dOM));
                    this.kRk.put(Integer.valueOf(i), "menu_func_report");
                    i++;
                }
                nT(i);
                if (this.kRm.size() > 0) {
                    this.kQM.ea(true);
                }
            }
            if (this.kQN.awB()) {
                this.kRk.clear();
                this.kRm.clear();
                if (this.kIK.atg() && this.kIK.ato()) {
                    this.kRm.add(getString(R.l.dOL));
                    this.kRk.put(Integer.valueOf(0), "menu_func_gift");
                    i = 1;
                } else {
                    i = 0;
                }
                if (!TextUtils.isEmpty(this.kIK.atC().vRi)) {
                    this.kRm.add(getString(R.l.dOM));
                    this.kRk.put(Integer.valueOf(i), "menu_func_report");
                    i++;
                }
                if (this.kIK.atg()) {
                    this.kRm.add(getString(R.l.dEw));
                    this.kRk.put(Integer.valueOf(i), "menu_func_delete");
                    i++;
                } else if (this.kIK.ath()) {
                    String FS = q.FS();
                    String atH = this.kIK.atH();
                    if (FS == null || !FS.equals(atH)) {
                        x.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
                    } else {
                        this.kRm.add(getString(R.l.dEw));
                        this.kRk.put(Integer.valueOf(i), "menu_func_delete_share_card");
                        i++;
                    }
                }
                nT(i);
                if (this.kRm.size() > 0) {
                    this.kQM.ea(true);
                }
            }
            if (this.kQN.awC()) {
                this.kRk.clear();
                this.kRm.clear();
                if (TextUtils.isEmpty(this.kIK.atC().vRi)) {
                    i = 0;
                } else {
                    this.kRm.add(getString(R.l.dOM));
                    this.kRk.put(Integer.valueOf(0), "menu_func_report");
                    i = 1;
                }
                nT(i);
                if (this.kRm.size() > 0) {
                    this.kQM.ea(true);
                }
            }
            if (this.kQS != null && (this.kQS instanceof com.tencent.mm.plugin.card.widget.b)) {
                ((com.tencent.mm.plugin.card.widget.b) this.kQS).axr();
            }
            r(this.kQN.awx(), this.kQN.awy());
            if (!this.kIK.ati() && this.kQN.awG()) {
                x.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
                this.kQQ.update();
            } else if (this.kIK.ati() && this.kQN.awG()) {
                x.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
                this.kQR.update();
            } else if (this.kQN.awH()) {
                x.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
                this.kQR.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
                this.kQR.awW();
                this.kQQ.awW();
            }
            if (this.kQS != null) {
                this.kQS.eg(this.kQN.avT());
            }
            if (this.fvI) {
                x.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
            } else {
                View findViewById;
                LayoutParams layoutParams;
                if (this.kIK.atg() && this.kIK.ati()) {
                    this.kND.findViewById(R.h.bQv).setBackgroundColor(this.kQM.getResources().getColor(R.e.brI));
                    com.tencent.mm.ui.statusbar.a.d(this.kND, -1, true);
                    this.kQM.A(-1, true);
                } else {
                    i = l.wO(this.kIK.atB().hbM);
                    this.kND.findViewById(R.h.bQv).setBackgroundColor(i);
                    com.tencent.mm.ui.statusbar.a.d(this.kND, i, true);
                    this.kQM.A(i, false);
                }
                View findViewById2 = this.kND.findViewById(R.h.cbn);
                View findViewById3 = this.kND.findViewById(R.h.coy);
                View findViewById4 = this.kND.findViewById(R.h.cbl);
                if (this.kIK.atg() && this.kQN.awG()) {
                    if (this.kIK.atj()) {
                        findViewById2.setBackgroundResource(R.g.bAA);
                        this.kND.findViewById(R.h.cke).setBackgroundResource(R.g.bAo);
                        findViewById4.setBackgroundResource(0);
                    } else if (this.kIK.ati()) {
                        this.kND.findViewById(R.h.cke).setBackgroundResource(0);
                        findViewById4.setBackgroundColor(this.kQM.getResources().getColor(R.e.brI));
                    } else if (this.kIK.atk()) {
                        findViewById2.setBackgroundResource(R.g.bAA);
                        this.kND.findViewById(R.h.cke).setBackgroundResource(R.g.bAo);
                        findViewById4.setBackgroundResource(0);
                    } else if (!this.kIK.atl() && this.kIK.atm()) {
                        findViewById4.setBackgroundColor(this.kQM.getResources().getColor(R.e.brI));
                    }
                } else if (this.kIK.ath()) {
                    if (this.kQN.awE() && this.kQP) {
                        findViewById2.setBackgroundResource(R.g.bAA);
                        findViewById4.setBackgroundResource(0);
                    } else if (!this.kQN.awE() || this.kQP) {
                        findViewById2.setBackgroundResource(0);
                        if (this.kQN.avT()) {
                            findViewById4.setBackgroundResource(R.g.bAy);
                        } else {
                            findViewById4.setBackgroundResource(R.g.bAA);
                        }
                    } else {
                        findViewById2.setBackgroundResource(R.g.bAy);
                        findViewById4.setBackgroundResource(0);
                    }
                } else if (this.kIK.atj()) {
                    findViewById2.setBackgroundResource(0);
                    if (this.kQN.avT()) {
                        findViewById4.setBackgroundResource(R.g.bAy);
                    } else {
                        findViewById4.setBackgroundResource(R.g.bAA);
                    }
                } else if (this.kIK.atk()) {
                    findViewById2.setBackgroundResource(R.g.bAC);
                    findViewById4.setBackgroundResource(0);
                } else {
                    findViewById2.setBackgroundResource(0);
                    findViewById4.setBackgroundColor(this.kQM.getResources().getColor(R.e.brI));
                }
                if (this.kIK.atm()) {
                    TextView textView = (TextView) this.kND.findViewById(R.h.bOU);
                    Drawable bitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.CZ(R.g.bAx));
                    bitmapDrawable.setTileModeX(TileMode.REPEAT);
                    textView.setBackgroundDrawable(bitmapDrawable);
                    textView.setVisibility(0);
                }
                Rect rect = new Rect(0, 0, 0, 0);
                findViewById2.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                findViewById2.invalidate();
                findViewById4.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                findViewById4.invalidate();
                if (this.kIK.ath() && this.kQN.awE() && this.kQP) {
                    findViewById = this.kND.findViewById(R.h.cNU);
                    findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    findViewById.invalidate();
                }
                if (this.kIK.atg() && this.kQN.awG()) {
                    findViewById = this.kND.findViewById(R.h.cke);
                    rect.left = this.kQM.getResources().getDimensionPixelOffset(R.f.bvv);
                    rect.right = this.kQM.getResources().getDimensionPixelOffset(R.f.bvv);
                    findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    findViewById.invalidate();
                    if (this.kIK.atk()) {
                        findViewById = this.kND.findViewById(R.h.ckf);
                        layoutParams = (LayoutParams) findViewById.getLayoutParams();
                        int dimensionPixelSize = this.kQM.getResources().getDimensionPixelSize(R.f.bvS);
                        layoutParams.rightMargin = dimensionPixelSize;
                        layoutParams.leftMargin = dimensionPixelSize;
                        findViewById.setLayoutParams(layoutParams);
                    }
                }
                if (this.kQN.awG() || this.kQN.awE()) {
                    if (this.kQS != null && ((this.kIK.atg() && this.kIK.atj()) || this.kIK.ath())) {
                        this.kQS.ob(0);
                    }
                } else if (this.kQS != null && ((this.kIK.atg() && this.kIK.atj()) || this.kIK.ath())) {
                    if (this.kQN.avT()) {
                        this.kQS.ob(R.g.bAB);
                    } else {
                        this.kQS.ob(R.g.bAz);
                    }
                }
                if (this.kQS != null && this.kIK.atg() && this.kIK.ati()) {
                    this.kQS.a(l.ch(l.wO(this.kIK.atB().hbM), this.kQM.getResources().getDimensionPixelOffset(R.f.bwx)));
                }
                if (this.kIK.atg() && this.kIK.ati()) {
                    layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.leftMargin = 0;
                    if (TextUtils.isEmpty(this.kIK.atB().vRT)) {
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams.weight = 0.0f;
                        layoutParams.height = -2;
                    }
                    findViewById2.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) findViewById3.getLayoutParams();
                    int dimensionPixelSize2 = this.kQM.getResources().getDimensionPixelSize(R.f.bvB);
                    layoutParams.rightMargin = dimensionPixelSize2;
                    layoutParams.leftMargin = dimensionPixelSize2;
                    if (this.kIK.ati()) {
                        layoutParams.topMargin = this.kQM.getResources().getDimensionPixelSize(R.f.bvy);
                        layoutParams.bottomMargin = this.kQM.getResources().getDimensionPixelSize(R.f.bvz);
                        dimensionPixelSize2 = this.kQM.getResources().getDimensionPixelSize(R.f.bvw);
                        layoutParams.rightMargin = dimensionPixelSize2;
                        layoutParams.leftMargin = dimensionPixelSize2;
                    } else {
                        dimensionPixelSize2 = this.kQM.getResources().getDimensionPixelSize(R.f.buv);
                        layoutParams.bottomMargin = dimensionPixelSize2;
                        layoutParams.topMargin = dimensionPixelSize2;
                    }
                    findViewById3.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) findViewById4.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.leftMargin = 0;
                    if (this.kIK.ati()) {
                        layoutParams.bottomMargin = this.kQM.getResources().getDimensionPixelSize(R.f.bvw);
                    }
                    if (TextUtils.isEmpty(this.kIK.atB().vRT)) {
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams.weight = 0.0f;
                        layoutParams.height = -2;
                    }
                    findViewById4.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(this.kIK.atB().vRT)) {
                        findViewById2 = findViewById(R.h.bJA);
                        layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                        findViewById2.setLayoutParams(layoutParams);
                    }
                }
                this.kND.invalidate();
            }
            if (this.kQN.awL()) {
                if (this.kQW == null) {
                    this.kQW = new y();
                    this.kQW.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
                this.kQW.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
                if (this.kQW != null) {
                    this.kQW.awW();
                }
            }
            if (this.kQN.awU()) {
                if (this.kQV == null) {
                    this.kQV = new com.tencent.mm.plugin.card.ui.view.c();
                    this.kQV.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
                this.kQV.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
                if (this.kQV != null) {
                    this.kQV.awW();
                }
            }
            if (this.kQN.awM()) {
                if (this.kQX == null) {
                    this.kQX = new k();
                    this.kQX.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
                this.kQX.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
                if (this.kQX != null) {
                    this.kQX.awW();
                }
            }
            if (this.kQN.awN()) {
                if (this.kQY == null) {
                    this.kQY = new w();
                    this.kQY.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
                this.kQY.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
                if (this.kQY != null) {
                    this.kQY.awW();
                }
            }
            if (this.kQN.awO()) {
                if (this.kQZ == null) {
                    this.kQZ = new com.tencent.mm.plugin.card.ui.view.l();
                    this.kQZ.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
                this.kQZ.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
                if (this.kQZ != null) {
                    this.kQZ.awW();
                }
            }
            if (this.kQN.awP()) {
                if (this.kRa == null) {
                    this.kRa = new z();
                    this.kRa.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
                this.kRa.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
                if (this.kRa != null) {
                    this.kRa.awW();
                }
            }
            if (this.kQN.awR()) {
                if (this.kRb == null) {
                    this.kRb = new com.tencent.mm.plugin.card.ui.view.e();
                    this.kRb.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
                this.kRb.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
                if (this.kRb != null) {
                    this.kRb.awW();
                }
            }
            if (this.kQN.awQ()) {
                if (this.kRc == null) {
                    this.kRc = new u();
                    this.kRc.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
                this.kRc.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
                if (this.kRc != null) {
                    this.kRc.awW();
                }
            }
            if (this.kQN.awI()) {
                com.tencent.mm.plugin.card.model.b bVar2;
                this.kIO.clear();
                List list = this.kIO;
                f fVar2 = this.kRh;
                fVar2.kIO.clear();
                if (!(fVar2.kIK.atC().vRq == null || bh.ov(fVar2.kIK.atC().vRq.title))) {
                    bVar2 = new com.tencent.mm.plugin.card.model.b();
                    bVar2.kKa = 1;
                    bVar2.title = fVar2.kIK.atC().vRq.title;
                    bVar2.kNs = "";
                    bVar2.url = "card://jump_card_gift";
                    bVar2.oZC = fVar2.kIK.atC().vRq.oZC;
                    fVar2.kIO.add(bVar2);
                }
                if (fVar2.kIK.atC().vQZ != null && fVar2.kIK.atC().vQZ.size() > 0) {
                    Collection am = l.am(fVar2.kIK.atC().vQZ);
                    if (am != null) {
                        ((com.tencent.mm.plugin.card.model.b) am.get(0)).kKb = false;
                        fVar2.kIO.addAll(am);
                    }
                }
                if (((fVar2.kFm == 6 && fVar2.kIK.atC().vRd <= 0) || l.oa(fVar2.kFm)) && fVar2.kIK.atx() && fVar2.kIK.atg() && fVar2.kIK.ato()) {
                    bVar2 = new com.tencent.mm.plugin.card.model.b();
                    bVar2.kKa = 1;
                    bVar2.title = ac.getContext().getString(R.l.dOL);
                    bVar2.kNs = "";
                    bVar2.url = "card://jump_gift";
                    fVar2.kIO.add(bVar2);
                }
                if (!(fVar2.kIK.atC().status == 0 || fVar2.kIK.atC().status == 1)) {
                    i = fVar2.kIK.atC().status;
                }
                if (fVar2.kFm != 3 && fVar2.kFm == 6) {
                    i = fVar2.kIK.atC().vRd;
                }
                qz qzVar = fVar2.kIK.atB().vSa;
                if (fVar2.kIK.atC().vRj != null) {
                    TextUtils.isEmpty(fVar2.kIK.atC().vRj.title);
                }
                com.tencent.mm.plugin.card.model.b bVar3 = new com.tencent.mm.plugin.card.model.b();
                z = fVar2.kIK.atm() ? false : qzVar == null || qzVar.vZa == null || qzVar.vZa.size() <= 0 || TextUtils.isEmpty((CharSequence) qzVar.vZa.get(0));
                bVar3.kKb = false;
                bVar3.kKa = 1;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(fVar2.getTitle());
                stringBuilder.append(fVar2.getString(R.l.dNZ));
                bVar3.title = stringBuilder.toString();
                bVar3.kJQ = "";
                bVar3.kNs = "";
                bVar3.url = "card://jump_detail";
                if (z) {
                    fVar2.kIO.add(bVar3);
                }
                if (!fVar2.kIK.atk() || fVar2.kIK.atB().vRM <= 0) {
                    kj kjVar;
                    if (!fVar2.kIK.ati() || fVar2.kIK.atB().vRM <= 0) {
                        if (fVar2.kIK.atB().vRM > 0) {
                            x.e("MicroMsg.CardDetailDataMgr", "shop_count:" + fVar2.kIK.atB().vRM);
                            if (fVar2.kIK.atB().vRM > 0 && fVar2.kIQ != null && fVar2.kIQ.size() > 0) {
                                kjVar = (kj) fVar2.kIQ.get(0);
                                if (kjVar != null && kjVar.vRw < 50000.0f) {
                                    bVar3 = new com.tencent.mm.plugin.card.model.b();
                                    bVar3.kKa = 2;
                                    bVar3.title = kjVar.name;
                                    bVar3.kJQ = fVar2.kaY.getString(R.l.dPt, new Object[]{l.f(fVar2.kaY, kjVar.vRw), kjVar.hxu});
                                    bVar3.kNs = "";
                                    bVar3.url = "card://jump_shop";
                                    bVar3.kKe = kjVar.kKe;
                                    bVar3.hbM = fVar2.kIK.atB().hbM;
                                    fVar2.kIO.add(bVar3);
                                } else if (kjVar != null) {
                                    x.e("MicroMsg.CardDetailDataMgr", "distance:" + kjVar.vRw);
                                }
                            }
                        }
                    }
                    if (fVar2.kIK.atB().vRM > 0 && fVar2.kIQ == null) {
                        bVar2 = new com.tencent.mm.plugin.card.model.b();
                        bVar2.kKa = 1;
                        if (TextUtils.isEmpty(fVar2.kIK.atB().vSl)) {
                            bVar2.title = fVar2.getString(R.l.dNF);
                        } else {
                            bVar2.title = fVar2.kIK.atB().vSl;
                        }
                        bVar2.kJQ = "";
                        bVar2.kNs = "";
                        bVar2.url = "card://jump_shop_list";
                        fVar2.kIO.add(bVar2);
                    } else if (fVar2.kIK.atB().vRM > 0 && fVar2.kIQ != null && fVar2.kIQ.size() > 0) {
                        bVar3 = new com.tencent.mm.plugin.card.model.b();
                        bVar3.kKa = 1;
                        kjVar = (kj) fVar2.kIQ.get(0);
                        if (!TextUtils.isEmpty(fVar2.kIK.atB().vSl)) {
                            bVar3.title = fVar2.kIK.atB().vSl;
                        } else if (fVar2.kIK.ati() || kjVar.vRw >= 5000.0f) {
                            bVar3.title = fVar2.getString(R.l.dNF);
                        } else if (fVar2.kIK.atB().vRM == 1 || fVar2.kIQ.size() == 1) {
                            x.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
                        } else {
                            bVar3.title = fVar2.getString(R.l.dNL);
                        }
                        if (!fVar2.kIK.ati() || kjVar.vRw >= 2000.0f) {
                            bVar3.kJQ = "";
                        } else if (fVar2.kIK.atB().vRM > 1 || (fVar2.kIQ != null && fVar2.kIQ.size() > 1)) {
                            bVar3.kJQ = fVar2.kaY.getString(R.l.dOH, new Object[]{l.f(fVar2.kaY, kjVar.vRw)});
                        } else {
                            bVar3.kJQ = l.f(fVar2.kaY, kjVar.vRw);
                        }
                        bVar3.kNs = "";
                        bVar3.url = "card://jump_shop_list";
                        fVar2.kIO.add(bVar3);
                    }
                }
                if (!((fVar2.kIK.atm() && fVar2.kIK.atC().status == 3) || TextUtils.isEmpty(fVar2.kIK.atB().vRF))) {
                    fVar2.kIO.add(fVar2.aua());
                }
                list.addAll(fVar2.kIO);
                m mVar = this.kQU;
                Collection collection = this.kIO;
                mVar.kIO.clear();
                mVar.kIO.addAll(collection);
                this.kQU.kVN = this.kIK.atm();
                this.kQU.notifyDataSetChanged();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
            }
            if (this.kQN.awJ()) {
                this.kIK.a(this.kIK.atC());
                l.j(this.kIK);
                if (this.kQN.awK()) {
                    if (this.kQT == null) {
                        if (this.kIK.atB().vSn != null && this.kIK.atB().vSn.vZD) {
                            this.kQT = new m();
                            com.tencent.mm.plugin.card.a.g auQ = am.auQ();
                            if (auQ.kIv == null) {
                                auQ.kIv = new ArrayList();
                            }
                            if (this != null) {
                                auQ.kIv.add(new WeakReference(this));
                            }
                        } else if (this.kIK.atB().kJO == 10) {
                            this.kQT = new com.tencent.mm.plugin.card.ui.view.q();
                        } else {
                            this.kQT = new j();
                        }
                        this.kQT.a(this);
                        this.kQT.update();
                    } else if (this.kQT.h(this.kIK)) {
                        this.kQT.d(this.kIK);
                        this.kQT.update();
                    }
                } else if (this.kQT != null) {
                    this.kQT.awW();
                }
                if (this.kQS != null) {
                    this.kQS.ef(true);
                }
            } else {
                x.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
                if (this.kQT != null) {
                    this.kQT.awW();
                }
                if (this.kQS != null) {
                    this.kQS.ef(false);
                }
            }
            if (this.kQN.awS()) {
                x.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
                this.kRd.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
                this.kRd.awW();
            }
            this.kRf.kIK = this.kIK;
        } else {
            x.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[]{Integer.valueOf(this.kIK.atB().kJO)});
            if (TextUtils.isEmpty(this.kIK.atB().vRO)) {
                com.tencent.mm.ui.base.h.a(this.kQM, getString(R.l.dOR), null, false, new 2(this));
                return;
            }
            com.tencent.mm.plugin.card.b.b.a(this.kQM, this.kIK.atB().vRO, 0);
            if (this.kRn != null) {
                this.kRn.avF();
            }
        }
    }

    public final void c(com.tencent.mm.plugin.card.b.c cVar) {
        x.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
        Message obtain = Message.obtain();
        c cVar2 = new c((byte) 0);
        cVar2.kRA = b.kRv;
        cVar2.kRB = cVar;
        obtain.obj = cVar2;
        this.kRp.sendMessage(obtain);
    }

    public final void S(int i, String str) {
        String string;
        x.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", new Object[]{Integer.valueOf(i), str});
        Message obtain = Message.obtain();
        c cVar = new c((byte) 0);
        cVar.kRA = b.kRy;
        cVar.errCode = i;
        if (i == -1) {
            string = getString(R.l.dOe);
        } else if (i == 2) {
            string = getString(R.l.dNP);
        } else {
            string = getString(R.l.dOd);
        }
        cVar.fnL = string;
        obtain.obj = cVar;
        this.kRp.sendMessage(obtain);
    }

    public final void aub() {
        x.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
        Message obtain = Message.obtain();
        c cVar = new c((byte) 0);
        cVar.kRA = b.kRw;
        obtain.obj = cVar;
        this.kRp.sendMessage(obtain);
    }

    public final void b(com.tencent.mm.plugin.card.b.c cVar) {
        x.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
        Message obtain = Message.obtain();
        c cVar2 = new c((byte) 0);
        cVar2.kRA = b.kRx;
        cVar2.kRB = cVar;
        obtain.obj = cVar2;
        this.kRp.sendMessage(obtain);
    }

    public final void a(boolean z, com.tencent.mm.plugin.card.a.j.b bVar, boolean z2) {
        int i = 1;
        if (z) {
            oq oqVar = this.kIK.atC().vRm;
            if (this.kIK.atu()) {
                com.tencent.mm.plugin.card.b.b.a(this.kQM, bVar.kJD, bVar.kJE, z2, this.kIK);
                com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(17), this.kIK.atF(), this.kIK.atG(), "", this.kIK.atC().vRm.title});
                return;
            } else if (oqVar != null && !TextUtils.isEmpty(oqVar.vRx) && !TextUtils.isEmpty(oqVar.vRy)) {
                com.tencent.mm.plugin.card.b.b.a(this.kIK.atF(), oqVar, this.kRo.kNT, this.kRo.kRu);
                r3 = com.tencent.mm.plugin.report.service.g.pQN;
                r5 = new Object[5];
                r5[0] = Integer.valueOf(6);
                r5[1] = this.kIK.atF();
                r5[2] = this.kIK.atG();
                r5[3] = "";
                r5[4] = oqVar.title != null ? oqVar.title : "";
                r3.h(11941, r5);
                return;
            } else if (oqVar == null || TextUtils.isEmpty(oqVar.url)) {
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                Object[] objArr = new Object[9];
                objArr[0] = "CardConsumedCodeUI";
                objArr[1] = Integer.valueOf(this.kIK.atB().kJO);
                objArr[2] = this.kIK.atG();
                objArr[3] = this.kIK.atF();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.kRo.kNT);
                objArr[6] = this.kRo.kQw;
                if (!this.kIK.atz()) {
                    i = 0;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                gVar.h(11324, objArr);
                wB(bVar.kJA);
                return;
            } else {
                com.tencent.mm.plugin.card.b.b.a(this.kQM, l.v(oqVar.url, oqVar.vSM), 1);
                r3 = com.tencent.mm.plugin.report.service.g.pQN;
                r5 = new Object[5];
                r5[0] = Integer.valueOf(6);
                r5[1] = this.kIK.atF();
                r5[2] = this.kIK.atG();
                r5[3] = "";
                r5[4] = oqVar.title != null ? oqVar.title : "";
                r3.h(11941, r5);
                return;
            }
        }
        gVar = com.tencent.mm.plugin.report.service.g.pQN;
        objArr = new Object[9];
        objArr[0] = "CardConsumedCodeUI";
        objArr[1] = Integer.valueOf(this.kIK.atB().kJO);
        objArr[2] = this.kIK.atG();
        objArr[3] = this.kIK.atF();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(this.kRo.kNT);
        objArr[6] = this.kRo.kQw;
        if (!this.kIK.atz()) {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        objArr[8] = "";
        gVar.h(11324, objArr);
        wB(bVar.kJA);
    }

    private void r(boolean z, boolean z2) {
        if (this.kQS != null) {
            this.kQS.r(z, z2);
        }
    }

    private void nT(int i) {
        LinkedList linkedList = this.kIK.atC().vRk;
        if (linkedList != null) {
            this.kRl.clear();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                av avVar = (av) linkedList.get(i2);
                if (!(bh.ov(avVar.text) || bh.ov(avVar.url))) {
                    this.kRm.add(avVar.text);
                    this.kRk.put(Integer.valueOf(i), avVar.text);
                    this.kRl.put(avVar.text, avVar.url);
                    i++;
                }
            }
        }
    }

    public final void b(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
            case 1:
            case 4:
                if (i2 == -1) {
                    this.kRi = intent.getStringExtra("Select_Conv_User");
                    String str = this.kRi;
                    if (this.kIK.atB() == null) {
                        x.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    if (i == 0) {
                        if (TextUtils.isEmpty(this.kIK.atD().wLJ)) {
                            stringBuilder.append(getString(R.l.ePW));
                        } else {
                            stringBuilder.append(this.kIK.atD().wLJ);
                        }
                    } else if (i == 1) {
                        stringBuilder.append(getString(R.l.dPs) + this.kRh.getTitle());
                    } else if (i == 4) {
                        stringBuilder.append(getString(R.l.dOU) + this.kRh.getTitle());
                    }
                    com.tencent.mm.pluginsdk.ui.applet.e.a(this.kQM.mController, stringBuilder.toString(), this.kIK.atB().kJP, this.kIK.atB().title + "\n" + this.kIK.atB().kLa, null, true, this.kQM.getResources().getString(R.l.dGA), new 6(this, i, str));
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    this.kOu = intent.getIntExtra("Ktag_range_index", 0);
                    x.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[]{Integer.valueOf(this.kOu)});
                    if (this.kOu >= 2) {
                        this.kOv = intent.getStringExtra("Klabel_name_list");
                        this.kOw = intent.getStringExtra("Kother_user_name_list");
                        x.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[]{Integer.valueOf(this.kOu), this.kOv});
                        if (TextUtils.isEmpty(this.kOv) && TextUtils.isEmpty(this.kOw)) {
                            x.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
                            return;
                        }
                        List asList = Arrays.asList(this.kOv.split(","));
                        this.kOy = l.ao(asList);
                        this.kOx = l.an(asList);
                        if (this.kOw != null && this.kOw.length() > 0) {
                            this.kOx.addAll(Arrays.asList(this.kOw.split(",")));
                        }
                        if (this.kOy != null) {
                            x.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.kOy.size());
                        }
                        if (this.kOx != null) {
                            x.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.kOx.size());
                            Iterator it = this.kOx.iterator();
                            while (it.hasNext()) {
                                x.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[]{(String) it.next()});
                            }
                        }
                        if (this.kOu == 2) {
                            this.kRd.wE(this.kQM.getString(R.l.dPk, new Object[]{avc()}));
                            return;
                        } else if (this.kOu == 3) {
                            this.kRd.wE(this.kQM.getString(R.l.dPj, new Object[]{avc()}));
                            return;
                        } else {
                            this.kRd.wE(this.kQM.getString(R.l.dPi));
                            return;
                        }
                    }
                    this.kRd.wE(this.kQM.getString(R.l.dPi));
                    return;
                }
                return;
            case 3:
                if (this.kRn != null) {
                    this.kRn.avH();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String avc() {
        if (!TextUtils.isEmpty(this.kOv) && !TextUtils.isEmpty(this.kOw)) {
            return this.kOv + "," + l.wS(this.kOw);
        }
        if (!TextUtils.isEmpty(this.kOv)) {
            return this.kOv;
        }
        if (TextUtils.isEmpty(this.kOw)) {
            return "";
        }
        return l.wS(this.kOw);
    }

    private void wB(String str) {
        Intent intent = new Intent();
        if (this.kIK instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) this.kIK);
        } else if (this.kIK instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) this.kIK);
        }
        intent.setClass(this.kQM, CardConsumeCodeUI.class);
        intent.putExtra("key_from_scene", this.kRo.kFm);
        intent.putExtra("key_previous_scene", this.kRo.kNT);
        intent.putExtra("key_mark_user", str);
        intent.putExtra("key_from_appbrand_type", this.kRo.kRu);
        this.kQM.startActivityForResult(intent, 3);
        this.kQM.jwN = this;
    }

    public final int avS() {
        if (this.kRh == null) {
            return 0;
        }
        f fVar = this.kRh;
        if (fVar.kIP == null ? false : fVar.kIP.kKd) {
            return 1;
        }
        return 0;
    }

    public final boolean avT() {
        return this.kQN == null ? false : this.kQN.avT();
    }
}

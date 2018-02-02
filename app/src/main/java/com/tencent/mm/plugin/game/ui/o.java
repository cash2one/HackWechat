package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.d.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t.h;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

public final class o extends com.tencent.mm.ui.o<t> {
    private static y nsW;
    private int fnm = 0;
    int hKb = 0;
    int kUH = 15;
    private Context mContext;
    private int ndn = 0;
    private OnClickListener nsX;
    private OnClickListener nsY;
    private x nsZ;
    private x nta;
    private long ntb = 0;
    private int ntc = 0;
    private u ntd;
    private f<String, Bitmap> nte;

    protected final /* bridge */ /* synthetic */ Object aRG() {
        return (t) this.xIg;
    }

    public final /* synthetic */ Object getItem(int i) {
        return qZ(i);
    }

    public o(Context context, t tVar, int i) {
        int i2 = 0;
        super(context, tVar);
        this.mContext = context;
        this.ndn = i;
        Cursor rawQuery = SubCoreGameCenter.aRd().rawQuery("select count(*) from GameRawMessage where " + x.j(new int[]{2, 5, 6, 10, 11, 100}) + " and showInMsgList = 1" + " and isHidden = 0", new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        this.hKb = i2;
        this.fnm = SubCoreGameCenter.aRd().aQx();
        nsW = new y();
        this.nsX = new p(context, i);
        this.nsY = new q(context, i);
        this.nsZ = new x(context);
        this.nsZ.cG(i, 1);
        this.nta = new x(context);
        this.nta.cG(i, 2);
        this.ntd = new u(context, this.ndn);
        i2 = c.getScreenWidth(this.mContext);
        this.ntc = a.ad(this.mContext, ((i2 - (this.mContext.getResources().getDimensionPixelSize(R.f.buv) * 2)) - this.mContext.getResources().getDimensionPixelSize(R.f.bvl)) - this.mContext.getResources().getDimensionPixelSize(R.f.bvB)) / 34;
        this.nte = new f(30);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = View.inflate(this.context, R.i.dkT, null);
            aVar.nth = (ImageView) view.findViewById(R.h.coO);
            aVar.ntg = (LinearLayout) view.findViewById(R.h.cxv);
            aVar.nti = (LinearLayout) view.findViewById(R.h.cxy);
            aVar.kBH = (TextView) view.findViewById(R.h.cAn);
            aVar.ntj = (ImageView) view.findViewById(R.h.bMq);
            aVar.jCQ = (TextView) view.findViewById(R.h.cSe);
            aVar.ntk = (TextView) view.findViewById(R.h.cxA);
            aVar.ntl = (LinearLayout) view.findViewById(R.h.cxC);
            aVar.ntm = (TextView) view.findViewById(R.h.cxE);
            aVar.ntn = (ImageView) view.findViewById(R.h.cxD);
            aVar.nto = (ImageView) view.findViewById(R.h.cxB);
            aVar.ntp = (TextView) view.findViewById(R.h.cxG);
            aVar.ntq = (TextView) view.findViewById(R.h.cxF);
            aVar.nts = (GameMessageListContainerView) view.findViewById(R.h.cxI);
            aVar.ntr = (LinearLayout) view.findViewById(R.h.cxz);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        t qZ = qZ(i);
        if (qZ == null || !qZ.ncW) {
            if (qZ != null) {
                qZ.aQm();
                aVar.ntg.setVisibility(0);
                aVar.ntr.setVisibility(8);
                aVar.ntp.setText(b.f(this.context, qZ.field_createTime * 1000));
                CharSequence charSequence;
                h hVar;
                if (qZ.field_msgType != 100) {
                    Object obj;
                    int size;
                    String str;
                    aVar.jCQ.setVisibility(8);
                    aVar.ntk.setVisibility(8);
                    aVar.ntl.setVisibility(8);
                    aVar.ntn.setVisibility(8);
                    aVar.nto.setVisibility(8);
                    aVar.ntq.setVisibility(8);
                    aVar.ntq.setEnabled(false);
                    aVar.nto.setEnabled(false);
                    aVar.nth.setEnabled(false);
                    aVar.kBH.setEnabled(false);
                    aVar.nts.setVisibility(8);
                    aVar.ntj.setVisibility(8);
                    charSequence = null;
                    if (!bh.cA(qZ.ncj)) {
                        hVar = (h) qZ.ncj.get(0);
                        ar.Hg();
                        com.tencent.mm.storage.x WO = com.tencent.mm.z.c.EY().WO(hVar.userName);
                        if (WO != null) {
                            charSequence = WO.AQ();
                        }
                        if (bh.ov(charSequence)) {
                            charSequence = hVar.bgo;
                        }
                        if (!bh.ov(hVar.ndi)) {
                            obj = 1;
                            size = qZ.ncj.size();
                            if (!bh.ov(qZ.nch) && (qZ.ncx & 1) == 0) {
                                aVar.ntq.setText(qZ.nch);
                                aVar.ntq.setVisibility(0);
                                if ((qZ.ncx & 2) <= 0) {
                                    aVar.ntq.setTextColor(this.context.getResources().getColor(R.e.bsB));
                                    aVar.ntq.setBackgroundResource(R.g.bCA);
                                    aVar.ntq.setOnClickListener(this.nsX);
                                    aVar.ntq.setTag(qZ);
                                    aVar.ntq.setEnabled(true);
                                } else {
                                    aVar.ntq.setTextColor(this.context.getResources().getColor(R.e.bst));
                                    aVar.ntq.setBackgroundResource(0);
                                    aVar.ntq.setOnClickListener(null);
                                    aVar.ntq.setEnabled(false);
                                }
                            }
                            if (qZ.field_msgType != 10 || qZ.field_msgType == 11) {
                                if (!bh.ov(qZ.mAppName)) {
                                    aVar.kBH.setText(i.b(this.context, qZ.mAppName, aVar.kBH.getTextSize()), BufferType.SPANNABLE);
                                    aVar.kBH.setVisibility(0);
                                } else if (bh.ov(charSequence)) {
                                    aVar.kBH.setText(i.b(this.context, charSequence, aVar.kBH.getTextSize()));
                                    aVar.kBH.setVisibility(0);
                                } else {
                                    aVar.kBH.setVisibility(8);
                                }
                            } else if (bh.ov(charSequence)) {
                                aVar.kBH.setVisibility(8);
                            } else {
                                aVar.kBH.setText(i.b(this.context, charSequence, aVar.kBH.getTextSize()));
                                aVar.kBH.setVisibility(0);
                                if (obj != null) {
                                    aVar.kBH.setOnClickListener(this.nsZ);
                                    aVar.kBH.setTag(qZ);
                                    aVar.kBH.setEnabled(true);
                                }
                            }
                            switch (qZ.field_msgType) {
                                case 2:
                                    e(aVar.nth, qZ.ncd);
                                    str = "礼物";
                                    if (qZ.ncu.contains("爱心")) {
                                        str = "爱心";
                                    } else if (qZ.ncu.contains("体力")) {
                                        str = "体力";
                                    }
                                    if (size <= 1) {
                                        aVar.jCQ.setText(this.context.getResources().getString(R.l.emM, new Object[]{String.valueOf(size), str}));
                                    } else {
                                        aVar.jCQ.setText(this.context.getResources().getString(R.l.emN, new Object[]{str}));
                                    }
                                    aVar.jCQ.setVisibility(0);
                                    a(qZ, aVar);
                                    break;
                                case 5:
                                    if (bh.cA(qZ.ncj)) {
                                        aVar.nth.setVisibility(0);
                                        if (bh.ov(((h) qZ.ncj.get(0)).ndh)) {
                                            e(aVar.nth, ((h) qZ.ncj.get(0)).ndh);
                                        } else {
                                            c(aVar.nth, ((h) qZ.ncj.get(0)).userName);
                                        }
                                        if (!bh.ov(((h) qZ.ncj.get(0)).ndi)) {
                                            aVar.nth.setOnClickListener(this.nta);
                                            aVar.nth.setTag(qZ);
                                            aVar.nth.setEnabled(true);
                                        }
                                    } else {
                                        aVar.nth.setVisibility(8);
                                    }
                                    if (size <= 1) {
                                        aVar.jCQ.setText(this.context.getResources().getString(R.l.emK, new Object[]{String.valueOf(size)}));
                                        a(qZ, aVar);
                                    } else {
                                        aVar.jCQ.setText(this.context.getResources().getString(R.l.emL));
                                    }
                                    aVar.ntl.setVisibility(0);
                                    aVar.jCQ.setVisibility(0);
                                    aVar.ntm.setText(qZ.ncF);
                                    aVar.ntl.setOnClickListener(this.nsY);
                                    aVar.ntl.setTag(Long.valueOf(qZ.field_msgId));
                                    if (!bh.ov(qZ.ncH)) {
                                        aVar.ntn.setVisibility(0);
                                        e(aVar.ntn, qZ.ncH);
                                        break;
                                    }
                                    break;
                                case 6:
                                    if (bh.cA(qZ.ncj)) {
                                        aVar.nth.setVisibility(0);
                                        if (bh.ov(((h) qZ.ncj.get(0)).ndh)) {
                                            e(aVar.nth, ((h) qZ.ncj.get(0)).ndh);
                                        } else {
                                            c(aVar.nth, ((h) qZ.ncj.get(0)).userName);
                                        }
                                        if (!bh.ov(((h) qZ.ncj.get(0)).ndi)) {
                                            aVar.nth.setOnClickListener(this.nta);
                                            aVar.nth.setTag(qZ);
                                            aVar.nth.setEnabled(true);
                                        }
                                    } else {
                                        aVar.nth.setVisibility(8);
                                    }
                                    aVar.ntl.setVisibility(0);
                                    aVar.ntl.setOnClickListener(this.nsY);
                                    aVar.ntl.setTag(Long.valueOf(qZ.field_msgId));
                                    if (qZ.ncR == 1) {
                                        if (qZ.ncR == 2) {
                                            if (qZ.ncR == 3) {
                                                aVar.jCQ.setVisibility(0);
                                                if (size <= 1) {
                                                    aVar.jCQ.setText(this.context.getResources().getString(R.l.emI, new Object[]{String.valueOf(size)}));
                                                    a(qZ, aVar);
                                                } else {
                                                    aVar.jCQ.setText(this.context.getResources().getString(R.l.emJ));
                                                }
                                                aVar.ntm.setText(qZ.ncE);
                                                break;
                                            }
                                        }
                                        aVar.ntk.setVisibility(0);
                                        aVar.ntk.setText(i.b(this.context, qZ.ncB, aVar.ntk.getTextSize()));
                                        aVar.ntm.setText(qZ.ncC);
                                        break;
                                    }
                                    aVar.ntk.setVisibility(0);
                                    aVar.ntk.setText(i.b(this.context, qZ.ncB, aVar.ntk.getTextSize()));
                                    aVar.ntm.setText(qZ.ncE);
                                    break;
                                    break;
                                case 10:
                                case 11:
                                    if (bh.ov(qZ.ncd)) {
                                        e(aVar.nth, qZ.ncd);
                                        aVar.nth.setVisibility(0);
                                    } else {
                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
                                        aVar.nth.setVisibility(8);
                                    }
                                    if (!bh.ov(qZ.lBk)) {
                                        if (bh.ov(qZ.ncp)) {
                                            aVar.ntk.setText(qZ.lBk);
                                            aVar.ntk.setVisibility(0);
                                        } else {
                                            aVar.ntl.setVisibility(0);
                                            aVar.ntm.setText(qZ.lBk);
                                            aVar.ntl.setOnClickListener(this.nsY);
                                            aVar.ntl.setTag(Long.valueOf(qZ.field_msgId));
                                        }
                                    }
                                    if (!bh.ov(qZ.ncp)) {
                                        e(aVar.nto, qZ.ncp);
                                        aVar.nto.setTag(Long.valueOf(qZ.field_msgId));
                                        aVar.nto.setOnTouchListener(nsW);
                                        aVar.nto.setOnClickListener(this.nsY);
                                        aVar.nto.setVisibility(0);
                                        aVar.nto.setEnabled(true);
                                        break;
                                    }
                                    break;
                                default:
                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GameMessageAdapter", "error msgtype: " + qZ.field_msgType);
                                    break;
                            }
                        }
                    }
                    obj = null;
                    size = qZ.ncj.size();
                    aVar.ntq.setText(qZ.nch);
                    aVar.ntq.setVisibility(0);
                    if ((qZ.ncx & 2) <= 0) {
                        aVar.ntq.setTextColor(this.context.getResources().getColor(R.e.bst));
                        aVar.ntq.setBackgroundResource(0);
                        aVar.ntq.setOnClickListener(null);
                        aVar.ntq.setEnabled(false);
                    } else {
                        aVar.ntq.setTextColor(this.context.getResources().getColor(R.e.bsB));
                        aVar.ntq.setBackgroundResource(R.g.bCA);
                        aVar.ntq.setOnClickListener(this.nsX);
                        aVar.ntq.setTag(qZ);
                        aVar.ntq.setEnabled(true);
                    }
                    if (qZ.field_msgType != 10) {
                    }
                    if (!bh.ov(qZ.mAppName)) {
                        aVar.kBH.setText(i.b(this.context, qZ.mAppName, aVar.kBH.getTextSize()), BufferType.SPANNABLE);
                        aVar.kBH.setVisibility(0);
                    } else if (bh.ov(charSequence)) {
                        aVar.kBH.setVisibility(8);
                    } else {
                        aVar.kBH.setText(i.b(this.context, charSequence, aVar.kBH.getTextSize()));
                        aVar.kBH.setVisibility(0);
                    }
                    switch (qZ.field_msgType) {
                        case 2:
                            e(aVar.nth, qZ.ncd);
                            str = "礼物";
                            if (qZ.ncu.contains("爱心")) {
                                str = "爱心";
                            } else if (qZ.ncu.contains("体力")) {
                                str = "体力";
                            }
                            if (size <= 1) {
                                aVar.jCQ.setText(this.context.getResources().getString(R.l.emN, new Object[]{str}));
                            } else {
                                aVar.jCQ.setText(this.context.getResources().getString(R.l.emM, new Object[]{String.valueOf(size), str}));
                            }
                            aVar.jCQ.setVisibility(0);
                            a(qZ, aVar);
                            break;
                        case 5:
                            if (bh.cA(qZ.ncj)) {
                                aVar.nth.setVisibility(8);
                            } else {
                                aVar.nth.setVisibility(0);
                                if (bh.ov(((h) qZ.ncj.get(0)).ndh)) {
                                    c(aVar.nth, ((h) qZ.ncj.get(0)).userName);
                                } else {
                                    e(aVar.nth, ((h) qZ.ncj.get(0)).ndh);
                                }
                                if (bh.ov(((h) qZ.ncj.get(0)).ndi)) {
                                    aVar.nth.setOnClickListener(this.nta);
                                    aVar.nth.setTag(qZ);
                                    aVar.nth.setEnabled(true);
                                }
                            }
                            if (size <= 1) {
                                aVar.jCQ.setText(this.context.getResources().getString(R.l.emL));
                            } else {
                                aVar.jCQ.setText(this.context.getResources().getString(R.l.emK, new Object[]{String.valueOf(size)}));
                                a(qZ, aVar);
                            }
                            aVar.ntl.setVisibility(0);
                            aVar.jCQ.setVisibility(0);
                            aVar.ntm.setText(qZ.ncF);
                            aVar.ntl.setOnClickListener(this.nsY);
                            aVar.ntl.setTag(Long.valueOf(qZ.field_msgId));
                            if (bh.ov(qZ.ncH)) {
                                aVar.ntn.setVisibility(0);
                                e(aVar.ntn, qZ.ncH);
                                break;
                            }
                            break;
                        case 6:
                            if (bh.cA(qZ.ncj)) {
                                aVar.nth.setVisibility(8);
                            } else {
                                aVar.nth.setVisibility(0);
                                if (bh.ov(((h) qZ.ncj.get(0)).ndh)) {
                                    c(aVar.nth, ((h) qZ.ncj.get(0)).userName);
                                } else {
                                    e(aVar.nth, ((h) qZ.ncj.get(0)).ndh);
                                }
                                if (bh.ov(((h) qZ.ncj.get(0)).ndi)) {
                                    aVar.nth.setOnClickListener(this.nta);
                                    aVar.nth.setTag(qZ);
                                    aVar.nth.setEnabled(true);
                                }
                            }
                            aVar.ntl.setVisibility(0);
                            aVar.ntl.setOnClickListener(this.nsY);
                            aVar.ntl.setTag(Long.valueOf(qZ.field_msgId));
                            if (qZ.ncR == 1) {
                                if (qZ.ncR == 2) {
                                    if (qZ.ncR == 3) {
                                        aVar.jCQ.setVisibility(0);
                                        if (size <= 1) {
                                            aVar.jCQ.setText(this.context.getResources().getString(R.l.emJ));
                                        } else {
                                            aVar.jCQ.setText(this.context.getResources().getString(R.l.emI, new Object[]{String.valueOf(size)}));
                                            a(qZ, aVar);
                                        }
                                        aVar.ntm.setText(qZ.ncE);
                                        break;
                                    }
                                }
                                aVar.ntk.setVisibility(0);
                                aVar.ntk.setText(i.b(this.context, qZ.ncB, aVar.ntk.getTextSize()));
                                aVar.ntm.setText(qZ.ncC);
                                break;
                            }
                            aVar.ntk.setVisibility(0);
                            aVar.ntk.setText(i.b(this.context, qZ.ncB, aVar.ntk.getTextSize()));
                            aVar.ntm.setText(qZ.ncE);
                            break;
                            break;
                        case 10:
                        case 11:
                            if (bh.ov(qZ.ncd)) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
                                aVar.nth.setVisibility(8);
                            } else {
                                e(aVar.nth, qZ.ncd);
                                aVar.nth.setVisibility(0);
                            }
                            if (bh.ov(qZ.lBk)) {
                                if (bh.ov(qZ.ncp)) {
                                    aVar.ntl.setVisibility(0);
                                    aVar.ntm.setText(qZ.lBk);
                                    aVar.ntl.setOnClickListener(this.nsY);
                                    aVar.ntl.setTag(Long.valueOf(qZ.field_msgId));
                                } else {
                                    aVar.ntk.setText(qZ.lBk);
                                    aVar.ntk.setVisibility(0);
                                }
                            }
                            if (bh.ov(qZ.ncp)) {
                                e(aVar.nto, qZ.ncp);
                                aVar.nto.setTag(Long.valueOf(qZ.field_msgId));
                                aVar.nto.setOnTouchListener(nsW);
                                aVar.nto.setOnClickListener(this.nsY);
                                aVar.nto.setVisibility(0);
                                aVar.nto.setEnabled(true);
                                break;
                            }
                            break;
                        default:
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GameMessageAdapter", "error msgtype: " + qZ.field_msgType);
                            break;
                    }
                }
                if (qZ.ncN != null) {
                    e(aVar.nth, qZ.ncN.nde);
                    aVar.nth.setVisibility(0);
                    if (bh.ov(qZ.ncN.ndd)) {
                        aVar.kBH.setVisibility(8);
                    } else {
                        aVar.kBH.setText(qZ.ncN.ndd);
                        aVar.kBH.setVisibility(0);
                    }
                    if (bh.ov(qZ.ncN.ndf)) {
                        aVar.ntj.setVisibility(8);
                    } else {
                        e(aVar.ntj, qZ.ncN.ndf);
                        aVar.ntj.setVisibility(0);
                    }
                    if (bh.ov(qZ.ncN.ncZ)) {
                        aVar.kBH.setEnabled(false);
                        aVar.nth.setEnabled(false);
                    } else {
                        aVar.kBH.setEnabled(true);
                        aVar.nth.setEnabled(true);
                        u.a aVar2 = new u.a(qZ, qZ.ncN.ncZ, 1);
                        u.a aVar3 = new u.a(qZ, qZ.ncN.ncZ, 2);
                        aVar.kBH.setTag(aVar2);
                        aVar.kBH.setOnClickListener(this.ntd);
                        aVar.nth.setTag(aVar3);
                        aVar.nth.setOnClickListener(this.ntd);
                    }
                } else if (bh.cA(qZ.ncj)) {
                    aVar.nth.setVisibility(8);
                    aVar.kBH.setVisibility(8);
                    aVar.ntj.setVisibility(8);
                } else {
                    hVar = (h) qZ.ncj.get(0);
                    if (bh.ov(hVar.bgo)) {
                        ar.Hg();
                        com.tencent.mm.storage.x WO2 = com.tencent.mm.z.c.EY().WO(hVar.userName);
                        charSequence = (WO2 == null || bh.ov(WO2.AQ())) ? hVar.userName : WO2.AQ();
                    } else {
                        charSequence = hVar.bgo;
                    }
                    if (bh.ov(hVar.ndk)) {
                        aVar.kBH.setEnabled(false);
                        aVar.nth.setEnabled(false);
                    } else {
                        aVar.kBH.setEnabled(true);
                        aVar.nth.setEnabled(true);
                        u.a aVar4 = new u.a(qZ, hVar.ndk, 1);
                        u.a aVar5 = new u.a(qZ, hVar.ndk, 2);
                        aVar.kBH.setTag(aVar4);
                        aVar.kBH.setOnClickListener(this.ntd);
                        aVar.nth.setTag(aVar5);
                        aVar.nth.setOnClickListener(this.ntd);
                    }
                    if (bh.ov(charSequence)) {
                        aVar.kBH.setVisibility(8);
                    } else {
                        aVar.kBH.setText(i.b(this.context, charSequence, aVar.kBH.getTextSize()), BufferType.SPANNABLE);
                        aVar.kBH.setVisibility(0);
                    }
                    aVar.nth.setVisibility(0);
                    if (bh.ov(hVar.ndh)) {
                        c(aVar.nth, hVar.userName);
                    } else {
                        e(aVar.nth, hVar.ndh);
                    }
                    if (bh.ov(hVar.ndj)) {
                        aVar.ntj.setVisibility(8);
                    } else {
                        e(aVar.ntj, hVar.ndj);
                        aVar.ntj.setVisibility(0);
                    }
                }
                if (bh.ov(qZ.ncJ)) {
                    aVar.jCQ.setVisibility(8);
                } else {
                    if (qZ.ncj.size() > 1) {
                        aVar.jCQ.setText(this.context.getResources().getString(R.l.emO, new Object[]{Integer.valueOf(qZ.ncj.size())}) + qZ.ncJ);
                    } else {
                        aVar.jCQ.setText(qZ.ncJ);
                    }
                    aVar.jCQ.setVisibility(0);
                }
                if (bh.ov(qZ.ncK)) {
                    aVar.ntk.setVisibility(8);
                } else {
                    aVar.ntk.setText(i.b(this.context, qZ.ncK, aVar.ntk.getTextSize()));
                    aVar.ntk.setVisibility(0);
                }
                a(qZ, aVar);
                if (bh.ov(qZ.ncO.ndc)) {
                    aVar.ntl.setVisibility(8);
                } else {
                    aVar.ntl.setVisibility(0);
                    if (bh.ov(qZ.ncO.ncZ)) {
                        aVar.ntl.setEnabled(false);
                    } else {
                        aVar.ntl.setTag(new u.a(qZ, qZ.ncO.ncZ, 3));
                        aVar.ntl.setOnClickListener(this.ntd);
                        aVar.ntl.setEnabled(true);
                    }
                    aVar.ntm.setText(i.b(this.context, qZ.ncO.ndc, aVar.ntm.getTextSize()));
                    if (bh.ov(qZ.ncO.ncY)) {
                        aVar.ntn.setVisibility(8);
                    } else {
                        e(aVar.ntn, qZ.ncO.ncY);
                        aVar.ntn.setVisibility(0);
                    }
                }
                if (bh.ov(qZ.ncL)) {
                    aVar.nto.setVisibility(8);
                } else {
                    e(aVar.nto, qZ.ncL);
                    aVar.nto.setVisibility(0);
                    if (bh.ov(qZ.ncM)) {
                        aVar.nto.setEnabled(false);
                    } else {
                        aVar.nto.setTag(new u.a(qZ, qZ.ncM, 3));
                        aVar.nto.setOnClickListener(this.ntd);
                        aVar.nto.setEnabled(true);
                    }
                }
                if (bh.ov(qZ.ncP.mName)) {
                    aVar.ntq.setVisibility(8);
                } else {
                    aVar.ntq.setText(qZ.ncP.mName);
                    aVar.ntq.setVisibility(0);
                    if (bh.ov(qZ.ncP.ncZ)) {
                        aVar.ntq.setEnabled(false);
                    } else {
                        aVar.ntq.setTag(new u.a(qZ, qZ.ncP.ncZ, 5));
                        aVar.ntq.setOnClickListener(this.ntd);
                        aVar.ntq.setEnabled(true);
                    }
                }
            }
        } else {
            aVar.ntg.setVisibility(8);
            aVar.ntr.setVisibility(0);
        }
        return view;
    }

    private void a(t tVar, a aVar) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i < tVar.ncj.size(); i++) {
            linkedList.add(tVar.ncj.get(i));
        }
        aVar.nts.a(tVar, linkedList, this.ntc, this.ndn, this.nte);
    }

    private void c(ImageView imageView, String str) {
        if (bh.ov(str)) {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        } else if (this.nte.bt(str)) {
            Bitmap bitmap = (Bitmap) this.nte.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                d(imageView, str);
            } else {
                imageView.setImageBitmap(bitmap);
            }
        } else {
            d(imageView, str);
        }
    }

    private void d(ImageView imageView, String str) {
        Bitmap i = e.aRV().i(imageView, str);
        if (i != null) {
            this.nte.put(str, i);
        }
    }

    private void e(ImageView imageView, String str) {
        if (this.nte.bt(str)) {
            Bitmap bitmap = (Bitmap) this.nte.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                f(imageView, str);
                return;
            } else {
                imageView.setImageBitmap(bitmap);
                return;
            }
        }
        f(imageView, str);
    }

    private void f(ImageView imageView, final String str) {
        e.a.a aVar = new e.a.a();
        aVar.hDy = false;
        e.aRV().a(imageView, str, aVar.aRW(), new e.b(this) {
            final /* synthetic */ o ntf;

            public final void a(View view, Bitmap bitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.ntf.nte.put(str, bitmap);
                }
            }
        });
    }

    public final void Xy() {
        setCursor(SubCoreGameCenter.aRd().rawQuery("select * from GameRawMessage where " + x.j(new int[]{2, 5, 6, 10, 11, 100}) + " and showInMsgList = 1" + " and isHidden = 0" + " order by isRead, createTime desc limit " + this.kUH, new String[0]));
        this.kUH = getCount();
        if (this.xIi != null) {
            this.xIi.Xv();
        }
        super.notifyDataSetChanged();
    }

    protected final void Xz() {
        aUn();
        Xy();
    }

    private static t a(t tVar, Cursor cursor) {
        if (tVar == null) {
            tVar = new t();
        }
        tVar.b(cursor);
        return tVar;
    }

    public final boolean awe() {
        return this.kUH >= this.hKb;
    }

    public final int getCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        if (this.count <= 0) {
            return 0;
        }
        return this.count + aRF();
    }

    public final boolean qY(int i) {
        return this.hKb > this.fnm && this.fnm > 0 && i == this.fnm;
    }

    protected final int aRF() {
        return (this.hKb <= this.fnm || this.fnm <= 0) ? 0 : 1;
    }

    private t qZ(int i) {
        if (qY(i)) {
            return (t) this.xIg;
        }
        t tVar;
        if (this.xIh != null) {
            tVar = (t) this.xIh.get(Integer.valueOf(i));
            if (tVar != null) {
                return tVar;
            }
        }
        Object obj = (this.hKb <= this.fnm || this.fnm <= 0 || i <= this.fnm) ? null : 1;
        int i2;
        if (obj != null) {
            i2 = i - 1;
        } else {
            i2 = i;
        }
        if (i < 0 || !getCursor().moveToPosition(r0)) {
            return null;
        }
        if (this.xIh == null) {
            return a((t) this.xIg, getCursor());
        }
        tVar = a(null, getCursor());
        this.xIh.put(Integer.valueOf(i), tVar);
        return tVar;
    }
}

package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.viewitems.ag.d;
import com.tencent.mm.ui.chatting.viewitems.as;
import com.tencent.mm.ui.chatting.viewitems.b;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

public final class q extends o<au> implements e, a, j.a {
    private static HashMap<String, com.tencent.mm.pluginsdk.ui.e> ytB = new HashMap();
    boolean ffC;
    private int fyV;
    public int hKb;
    public String hlJ;
    public long kGB;
    af lFk;
    public c lcT;
    public int ldH;
    private LayoutInflater nny;
    private short[] onq;
    public com.tencent.mm.pluginsdk.ui.e pAU;
    public String talker;
    private boolean vnK;
    f ypU;
    public long ysP;
    private HashSet<Long> ysQ;
    public d ysR;
    String ysS;
    private final int ysT;
    private final int ysU;
    public r.f ysV;
    r.f ysW;
    public r.e ysX;
    public l ysY;
    l ysZ;
    public ChattingUI$a ysg;
    OnClickListener ytA;
    public a yta;
    a ytb;
    public c ytc;
    c ytd;
    private long yte;
    private long ytf;
    private long ytg;
    private int yth;
    private int yti;
    boolean ytj;
    boolean ytk;
    private boolean ytl;
    public boolean ytm;
    boolean ytn;
    boolean yto;
    public TreeSet<Long> ytp;
    public long ytq;
    public Map<Long, View> ytr;
    public Map<Long, Integer> yts;
    private Map<Long, Long> ytt;
    private ArrayList<b> ytu;
    public au ytv;
    private boolean ytw;
    private boolean ytx;
    public boolean yty;
    protected com.tencent.mm.plugin.messenger.foundation.a.a.c.a ytz;

    static /* synthetic */ void a(q qVar, k kVar) {
        int lastIndexOf;
        LinkedList linkedList = new LinkedList();
        if (s.eV(qVar.talker)) {
            lastIndexOf = kVar.url.lastIndexOf("/");
            if (lastIndexOf >= 0) {
                linkedList.add(kVar.url.substring(lastIndexOf + 1));
            } else {
                return;
            }
        }
        linkedList.add(qVar.talker);
        LinkedList linkedList2 = new LinkedList();
        for (lastIndexOf = 0; lastIndexOf < linkedList.size(); lastIndexOf++) {
            linkedList2.add(Integer.valueOf(6));
        }
        new com.tencent.mm.pluginsdk.ui.applet.q(qVar.ysg.getContext(), new 2(qVar)).g(linkedList, linkedList2);
    }

    public q(ChattingUI$a chattingUI$a, au auVar, String str) {
        super(chattingUI$a.getContext(), auVar);
        this.ysP = -1;
        this.ffC = true;
        this.ysQ = new HashSet();
        this.yte = -1;
        this.ytf = -1;
        this.ytg = -1;
        this.yth = 0;
        this.yti = 0;
        this.ytj = false;
        this.ytk = false;
        this.ytl = false;
        this.ytm = false;
        this.ytn = false;
        this.yto = false;
        this.ytq = -1;
        this.ytu = new ArrayList();
        this.ytv = new au();
        this.vnK = false;
        this.ytw = false;
        this.ytx = false;
        this.yty = false;
        this.ytz = new 3(this);
        this.ytA = null;
        this.pAU = null;
        this.lcT = null;
        this.ytq = -1;
        this.ysg = chattingUI$a;
        this.fyV = h.CTRL_INDEX;
        this.ysT = chattingUI$a.getResources().getDimensionPixelSize(R.f.bvV);
        this.ysU = chattingUI$a.getResources().getDimensionPixelSize(R.f.bvz);
        this.ypU = new 1(this, chattingUI$a, str);
        r.f fVar = new r.f();
        this.ysW = fVar;
        this.ysV = fVar;
        this.ysX = new r.e(chattingUI$a);
        l lVar = new l(chattingUI$a.getContext());
        this.ysZ = lVar;
        this.ysY = lVar;
        a aVar = new a(this);
        this.ytb = aVar;
        this.yta = aVar;
        c cVar = new c(chattingUI$a);
        this.ytd = cVar;
        this.ytc = cVar;
        Iterator it = this.ytu.iterator();
        while (it.hasNext()) {
            ((b) it.next()).ypn = chattingUI$a.ypn;
        }
        this.ytr = new HashMap();
        this.yts = new HashMap();
        this.ytt = new HashMap(5);
        if (this.lcT == null) {
            c.a aVar2 = new c.a();
            aVar2.hDD = com.tencent.mm.ag.a.e.ku(this.ysg.crz());
            aVar2.hDA = true;
            aVar2.hDX = true;
            aVar2.hDP = R.k.bBB;
            this.lcT = aVar2.PK();
        }
    }

    public final void crI() {
        if (this.ytp != null) {
            this.ytp.clear();
        }
        this.hKb = 0;
        this.ldH = -1;
        this.yte = -1;
        this.ytf = -1;
        this.ytg = -1;
        this.ysP = -1;
        this.yth = 0;
        this.yti = 0;
        this.ytj = false;
        this.ytk = false;
        this.ytl = false;
        this.ytm = false;
    }

    public final int r(long j, boolean z) {
        ar.Hg();
        cf dH = com.tencent.mm.z.c.Fa().dH(j);
        if (dH.field_msgId != j) {
            x.w("MicroMsg.ChattingListAdapter", "get msg info by id %d error", new Object[]{Long.valueOf(j)});
            return 0;
        }
        int m;
        long j2 = dH.field_createTime;
        if (j2 < this.yte || j2 > this.ytf) {
            this.yte = j2;
            this.ytg = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().ES(this.talker);
            if (z) {
                this.ytf = this.ytg;
            } else {
                ar.Hg();
                this.ytf = com.tencent.mm.z.c.Fa().S(this.talker, j2);
            }
            this.ytl = true;
            ar.Hg();
            x.v("MicroMsg.ChattingListAdapter", "reset position, reload count %d", new Object[]{Integer.valueOf(com.tencent.mm.z.c.Fa().m(this.talker, this.yte, this.ytf))});
            if (com.tencent.mm.z.c.Fa().m(this.talker, this.yte, this.ytf) < 18) {
                x.d("MicroMsg.ChattingListAdapter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[]{Long.valueOf(this.yte), Integer.valueOf(0)});
                ar.Hg();
                this.yte = com.tencent.mm.z.c.Fa().R(this.talker, this.yte);
                ar.Hg();
                m = com.tencent.mm.z.c.Fa().m(this.talker, this.yte, j2);
            } else {
                m = 0;
            }
        } else {
            ar.Hg();
            m = com.tencent.mm.z.c.Fa().m(this.talker, this.yte, j2);
        }
        x.v("MicroMsg.ChattingListAdapter", "set local message id, id[%d] top create time[%d] bottom create time[%d] last create time[%d] selection[%d]", new Object[]{Long.valueOf(j), Long.valueOf(this.yte), Long.valueOf(this.ytf), Long.valueOf(this.ytg), Integer.valueOf(m)});
        return m;
    }

    public static au a(au auVar, Cursor cursor) {
        if (auVar == null) {
            auVar = new au();
        }
        auVar.b(cursor);
        return auVar;
    }

    public final boolean crJ() {
        if (this.ytl) {
            this.ytg = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().ES(this.talker);
            if (this.ytg >= this.ytf) {
                this.ytf = this.ytg;
                Xy();
                return true;
            }
        }
        return false;
    }

    protected final void Xz() {
        ar.Hg();
        setCursor(com.tencent.mm.z.c.Fa().aZs());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Xy() {
        long Es = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).FJ().Es(this.talker);
        if (this.kGB == -1 || !this.ysg.ywd.vnK) {
            this.vnK = false;
        } else {
            this.vnK = true;
        }
        long u;
        if (this.ytl) {
            long t;
            x.i("MicroMsg.ChattingListAdapter", "topLoadMore[%B] downLoadMore[%B]", new Object[]{Boolean.valueOf(this.ytj), Boolean.valueOf(this.ytk)});
            if (!(this.ytj || this.ytk || this.ytf < this.ytg)) {
                if (this.vnK) {
                    ar.Hg();
                    this.ytg = com.tencent.mm.z.c.Fb().ar(this.talker, this.kGB);
                    ar.Hg();
                    this.yti = Math.max(0, com.tencent.mm.z.c.Fb().b(this.talker, this.kGB, this.ytf, this.ytg) - 1);
                } else {
                    this.ytg = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().ES(this.talker);
                    ar.Hg();
                    this.yti = Math.max(0, com.tencent.mm.z.c.Fa().m(this.talker, this.ytf, this.ytg) - 1);
                }
                this.ytf = this.ytg;
            }
            if (this.ytj) {
                this.ytj = false;
                if (this.vnK) {
                    ar.Hg();
                    t = com.tencent.mm.z.c.Fb().t(this.talker, this.kGB, this.yte);
                    ar.Hg();
                    this.yth = Math.max(0, com.tencent.mm.z.c.Fb().b(this.talker, this.kGB, t, this.yte) - 1);
                } else {
                    ar.Hg();
                    Es = com.tencent.mm.z.c.Fa().R(this.talker, this.yte);
                    ar.Hg();
                    this.yth = Math.max(0, com.tencent.mm.z.c.Fa().m(this.talker, Es, this.yte) - 1);
                    t = Es;
                }
                this.yte = t;
            }
            if (this.ytk) {
                this.ytk = false;
                if (this.vnK) {
                    ar.Hg();
                    u = com.tencent.mm.z.c.Fb().u(this.talker, this.kGB, this.ytf);
                    ar.Hg();
                    this.yti = Math.max(0, com.tencent.mm.z.c.Fb().b(this.talker, this.kGB, this.ytf, u) - 1);
                } else {
                    ar.Hg();
                    t = com.tencent.mm.z.c.Fa().S(this.talker, this.ytf);
                    ar.Hg();
                    this.yti = Math.max(0, com.tencent.mm.z.c.Fa().m(this.talker, this.ytf, t) - 1);
                    u = t;
                }
                this.ytf = u;
            }
            x.v("MicroMsg.ChattingListAdapter", "query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", new Object[]{Long.valueOf(this.yte), Long.valueOf(this.ytf), Long.valueOf(this.ytg), Integer.valueOf(this.yth), Integer.valueOf(this.yti)});
            if (this.vnK) {
                Object[] objArr = new Object[1];
                ar.Hg();
                objArr[0] = Integer.valueOf(com.tencent.mm.z.c.Fb().b(this.talker, this.kGB, this.yte, this.ytf));
                x.v("MicroMsg.ChattingListAdapter", "count([top, down]) = %d", objArr);
                ar.Hg();
                setCursor(com.tencent.mm.z.c.Fb().c(this.talker, this.kGB, this.yte, this.ytf));
            } else {
                Object[] objArr2 = new Object[1];
                ar.Hg();
                objArr2[0] = Integer.valueOf(com.tencent.mm.z.c.Fa().m(this.talker, this.yte, this.ytf));
                x.v("MicroMsg.ChattingListAdapter", "count([top, down]) = %d", objArr2);
                ar.Hg();
                setCursor(com.tencent.mm.z.c.Fa().n(this.talker, this.yte, this.ytf));
            }
        } else {
            Cursor i;
            if (this.vnK) {
                ar.Hg();
                this.hKb = com.tencent.mm.z.c.Fb().ao(this.talker, this.kGB);
            } else {
                ar.Hg();
                this.hKb = com.tencent.mm.z.c.Fa().EM(this.talker);
            }
            boolean z = false;
            if (this.ldH < 0 || this.ldH > this.hKb) {
                z = true;
                this.ldH = this.hKb - 18;
            }
            x.i("MicroMsg.ChattingListAdapter", "summerbadcr summerdel resetCursor restart:%b fromCount:%d totalcount:%d limit:%d, talker:%s isBizChat:%b, createTime:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.ldH), Integer.valueOf(this.hKb), Integer.valueOf(this.hKb - this.ldH), this.talker, Boolean.valueOf(this.vnK), Long.valueOf(Es)});
            if (this.vnK) {
                ar.Hg();
                i = com.tencent.mm.z.c.Fb().i(this.talker, this.kGB, this.hKb - this.ldH);
            } else if (this.ysg.ysk) {
                ar.Hg();
                i = com.tencent.mm.z.c.Fa().f(this.talker, this.hKb - this.ldH, Es);
                if (this.ysg.yvO.yBl) {
                    x.i("MicroMsg.ChattingListAdapter", "summerbadcr resetCursor check fault count[%d], talker[%s]", new Object[]{Integer.valueOf(i == null ? -1 : i.getCount()), this.talker});
                    if ((i == null ? -1 : i.getCount()) > 0) {
                        if (z) {
                        }
                        u = System.currentTimeMillis();
                        ar.Hg();
                        aj WY = com.tencent.mm.z.c.Fd().WY(this.talker);
                        x.i("MicroMsg.ChattingListAdapter", "summerbadcr revisedCursor check fault first/last seq[%d], restart[%b], undeliver[%d]", new Object[]{Integer.valueOf(i.getInt(i.getColumnIndex("msgSeq"))), Boolean.valueOf(z), Integer.valueOf(WY == null ? 0 : WY.field_UnDeliverCount)});
                        int i2 = 0;
                        while (true) {
                            int i3 = i.getInt(i.getColumnIndex("flag"));
                            if ((i3 & 2) != 0 || i.getInt(i.getColumnIndex("isSend")) == 0) {
                                if (r1 != 0 || (i3 & 2) != 0) {
                                    if ((i3 & 1) != 0) {
                                        if (i2 != 0) {
                                            break;
                                        }
                                        i2++;
                                        x.i("MicroMsg.ChattingListAdapter", "summerbadcr revisedCursor check fault index == 0 continue");
                                    } else {
                                        i2++;
                                    }
                                } else {
                                    i3 = i.getInt(i.getColumnIndex(DownloadSettingTable$Columns.TYPE));
                                    if (i3 <= 50 && i3 >= 0) {
                                        break;
                                    }
                                    i2++;
                                }
                            } else {
                                i2++;
                            }
                            if (z) {
                                if (!i.moveToPrevious()) {
                                    break;
                                }
                            } else if (!i.moveToNext()) {
                                break;
                            }
                        }
                        Object obj = 1;
                        Cursor cursor = i;
                        if (obj != null) {
                            x.i("MicroMsg.ChattingListAdapter", "summerbadcr resetCursor check fault traversal all not found take time[%d]ms, cursor index:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - u), Integer.valueOf(i2)});
                        }
                        i = cursor;
                    }
                }
            } else {
                ar.Hg();
                i = com.tencent.mm.z.c.Fa().f(this.talker, this.hKb - this.ldH, Es);
            }
            if (i == null || i.isClosed()) {
                x.w("MicroMsg.ChattingListAdapter", "update pos fail, cursor is null");
            } else {
                if (i.moveToLast()) {
                    this.ytv = a(this.ytv, i);
                    this.ytf = this.ytv.field_createTime;
                }
                this.ytq = -1;
                if (i.moveToFirst()) {
                    this.ytv = a(this.ytv, i);
                    this.yte = this.ytv.field_createTime;
                }
                x.d("MicroMsg.ChattingListAdapter", "update pos topCreateTime[%d] downCreateTime[%d]", new Object[]{Long.valueOf(this.yte), Long.valueOf(this.ytf)});
            }
            setCursor(i);
        }
        int count = getCount();
        if (count > 0) {
            this.onq = new short[count];
        }
        this.ytr.clear();
        this.yts.clear();
        this.ytt.clear();
        super.notifyDataSetChanged();
        if (this.yto) {
            com.tencent.mm.bf.l.Ty().Ts();
        }
    }

    public final void mF(boolean z) {
        this.ytw = z;
        if (!z) {
            this.yty = false;
        }
        if (!z && this.ytx) {
            a(null, null);
            this.ytx = false;
        }
    }

    public final void crK() {
        this.ytx = false;
        this.ytw = false;
        this.yty = false;
        a(null, null);
    }

    protected final void crL() {
        if (this.yty) {
            this.yty = false;
        } else if (this.ytw) {
            this.ytx = true;
        } else if (this.talker == null) {
        } else {
            if (this.ffC) {
                super.a(null, null);
            } else {
                x.i("MicroMsg.ChattingListAdapter", "is not resumeState ");
            }
        }
    }

    public final int getItemViewType(int i) {
        return as.bt((au) getItem(i));
    }

    public final int getViewTypeCount() {
        return as.cvD();
    }

    public final int Fv(int i) {
        if (this.ytl) {
            return this.yth;
        }
        if (i <= 0) {
            return 0;
        }
        if (this.ldH < i) {
            i = this.ldH;
            this.ldH = 0;
            return i;
        }
        this.ldH -= i;
        return i;
    }

    public final boolean crM() {
        if (this.ytl) {
            return this.yte <= ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().ER(this.talker);
        } else if (this.ldH <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean crN() {
        if (!this.ytl) {
            return true;
        }
        return this.ytf >= ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().ES(this.talker);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        b.a aVar;
        au auVar = (au) getItem(i);
        x.i("MicroMsg.ChattingListAdapter", "shwen getview:%d, msgId %d, svrId %d, type:%d, send:%d, talker:%s, flag%s", new Object[]{Integer.valueOf(i), Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), Integer.valueOf(auVar.getType()), Integer.valueOf(auVar.field_isSend), auVar.field_talker, Integer.valueOf(auVar.field_flag)});
        if (i == 0) {
            this.ysg.csK();
        }
        if (i != 0 && this.onq[i] == (short) 0) {
            long j = ((au) getItem(i - 1)).field_createTime;
            long j2 = auVar.field_createTime;
            Object obj2 = j2 - j < 60000 ? 1 : null;
            obj = (j2 - j) / 180000 < 1 ? 1 : null;
            if (obj2 == null && obj == null) {
                this.onq[i] = (short) 1;
            } else {
                this.onq[i] = (short) 2;
            }
        }
        obj = ((this.onq[i] == (short) 1 || i == 0 || this.ysQ.contains(Long.valueOf(auVar.field_msgId))) && auVar.field_createTime > 1000) ? 1 : null;
        Object obj3 = auVar.field_msgId == this.ysP ? 1 : null;
        if (view == null) {
            if (this.nny == null) {
                this.nny = v.fv(this.ysg.getContext());
            }
            b bs = as.bs(auVar);
            view = bs.a(this.nny, view);
            b.a aVar2 = (b.a) view.getTag();
            aVar2.yIB = bs;
            aVar = aVar2;
        } else {
            aVar = (b.a) view.getTag();
        }
        if (obj != null) {
            aVar.ldK.setVisibility(0);
            aVar.ldK.setText(n.c(this.ysg.getContext(), auVar.field_createTime, false));
            if (aVar.ldK.getTextSize() > ((float) com.tencent.mm.bv.a.fromDPToPix(this.ysg.getContext(), 25))) {
                x.e("MicroMsg.ChattingListAdapter", "WDF!!! TextSize:%s", new Object[]{Float.valueOf(aVar.ldK.getTextSize())});
            }
        } else {
            aVar.ldK.setVisibility(8);
        }
        if (aVar.yIx != null) {
            if (obj3 != null) {
                aVar.yIx.setVisibility(0);
            } else {
                aVar.yIx.setVisibility(8);
            }
        }
        b bVar = aVar.yIB;
        if (this.xIg != null) {
            aVar.yIA = null;
            asv Qs = com.tencent.mm.av.b.Qs();
            if (Qs != null && Qs.vVZ != null && Qs.wAi == 0 && com.tencent.mm.av.b.Qq()) {
                aVar.yIA = Qs.vVZ;
            }
            bVar.a(aVar, i, this.ysg, auVar);
        }
        if (aVar.ldK.getVisibility() == 0 && this.pAU != null) {
            aVar.ldK.setTextColor(this.pAU.vjt);
            if (this.pAU.vju) {
                aVar.ldK.setShadowLayer(2.0f, 1.2f, 1.2f, this.pAU.vjv);
            } else {
                aVar.ldK.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            if (this.pAU.vjw) {
                aVar.ldK.setBackgroundResource(R.g.bAO);
                aVar.ldK.setPadding(this.ysU, this.ysT, this.ysU, this.ysT);
            } else {
                aVar.ldK.setBackgroundColor(0);
            }
        }
        if (!(aVar.qhg == null || aVar.qhg.getVisibility() != 0 || this.pAU == null || this.talker.equals("qqmail") || auVar.getType() == 318767153)) {
            aVar.qhg.setTextColor(this.pAU.vjx);
            aVar.qhg.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
        if (this.ytm) {
        }
        if (!this.ytn) {
            aVar.mW(false);
            for (Entry entry : this.ytr.entrySet()) {
                if (entry.getValue() == view) {
                    this.ytr.remove(entry.getKey());
                    this.yts.remove(entry.getKey());
                    break;
                }
            }
            this.ytr.put(Long.valueOf(auVar.field_msgId), view);
            if (auVar.cje()) {
                this.yts.put(Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.field_isSend));
            }
            if (this.ysg.ysk && (auVar.field_flag & 1) != 0 && this.ytt.get(Long.valueOf(auVar.field_msgId)) == null) {
                g.Dm().g(new 4(this, auVar), 500);
            }
            return view;
        }
        if (aVar.mSc != null) {
            aVar.mSc.setChecked(this.ytp.contains(Long.valueOf(auVar.field_msgId)));
        }
        if (aVar.jWc != null) {
            aVar.jWc.setTag(Long.valueOf(auVar.field_msgId));
            aVar.jWc.setOnClickListener(this.ytA);
        }
        aVar.mW(true);
        for (Entry entry2 : this.ytr.entrySet()) {
            if (entry2.getValue() == view) {
                this.ytr.remove(entry2.getKey());
                this.yts.remove(entry2.getKey());
                break;
            }
        }
        this.ytr.put(Long.valueOf(auVar.field_msgId), view);
        if (auVar.cje()) {
            this.yts.put(Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.field_isSend));
        }
        g.Dm().g(new 4(this, auVar), 500);
        return view;
    }

    public final boolean fW(long j) {
        if (this.ytp.contains(Long.valueOf(j))) {
            x.d("MicroMsg.ChattingListAdapter", "remove select item, msgId = %d", new Object[]{Long.valueOf(j)});
            this.ytp.remove(Long.valueOf(j));
        } else {
            x.d("MicroMsg.ChattingListAdapter", "add select item, msgId = %d", new Object[]{Long.valueOf(j)});
            if (this.ytp.size() >= 100) {
                com.tencent.mm.ui.base.h.b(this.ysg.getContext(), this.ysg.getString(R.l.ecm, new Object[]{Integer.valueOf(100)}), "", true);
                return false;
            }
            this.ytp.add(Long.valueOf(j));
        }
        a(null, null);
        return true;
    }

    public final void crO() {
        if (this.ytp != null) {
            this.ytp.clear();
        }
    }

    final void crP() {
        x.d("MicroMsg.ChattingListAdapter", "disable clickListener");
        this.ysV = null;
        this.ysX = null;
        this.ysY = null;
        this.yta = null;
        this.ytc = null;
    }

    public final void Fw(int i) {
        au auVar = (au) getItem(i);
        if (auVar != null && auVar.field_msgId != 0) {
            this.ysQ.add(Long.valueOf(auVar.field_msgId));
        }
    }

    public final boolean Za(String str) {
        try {
            this.pAU = new com.tencent.mm.pluginsdk.ui.e(bh.convertStreamToString(new FileInputStream(str)));
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingListAdapter", e, "", new Object[0]);
            this.pAU = null;
            return false;
        }
    }

    public final boolean bw(Context context, String str) {
        if (ytB.containsKey(str)) {
            this.pAU = (com.tencent.mm.pluginsdk.ui.e) ytB.get(str);
            return true;
        }
        try {
            this.pAU = new com.tencent.mm.pluginsdk.ui.e(bh.convertStreamToString(context.getAssets().open(str)));
            ytB.put(str, this.pAU);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingListAdapter", e, "", new Object[0]);
            return false;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (this.lFk != null) {
            this.lFk.post(new Runnable(this) {
                final /* synthetic */ q ytD;

                {
                    this.ytD = r1;
                }

                public final void run() {
                    this.ytD.notifyDataSetChanged();
                }
            });
        }
    }

    public final void a(long j, au auVar, boolean z) {
        if (this.ytr.containsKey(Long.valueOf(j)) && this.yts.containsKey(Long.valueOf(j))) {
            com.tencent.mm.ui.chatting.viewitems.x.a.a(this.ysg.getContext(), (b.a) ((View) this.ytr.get(Long.valueOf(j))).getTag(), auVar, z);
            return;
        }
        x.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
    }

    public final void bYL() {
        if (this.lFk != null) {
            this.lFk.post(new 6(this));
        }
    }

    public final void a(a.a aVar) {
        boolean z = false;
        if (!(aVar == null || aVar.hVO == 3 || (aVar.hVO != 2 && aVar.hVO != -1 && aVar.hVO != 1))) {
            z = d.b(aVar);
        }
        if (!z) {
            ag.y(new 7(this));
        }
    }

    public static void ad(String str, int i, int i2) {
        com.tencent.mm.ui.chatting.viewitems.h.b.j(str, i, i2);
    }
}

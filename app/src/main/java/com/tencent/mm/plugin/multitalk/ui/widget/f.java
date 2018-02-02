package com.tencent.mm.plugin.multitalk.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.n;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.j;
import com.tencent.mm.plugin.multitalk.a.j.1;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.q;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.g;
import com.tencent.wecall.talkroom.model.TalkRoom;
import com.tencent.wecall.talkroom.model.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class f implements OnClickListener, com.tencent.mm.ad.d.a, com.tencent.mm.plugin.voip.video.f {
    i iol = null;
    public TextView ldK;
    public FrameLayout oIC;
    public FrameLayout oID;
    public View oIE;
    private View oIF;
    private View oIG;
    public View oIH;
    public MMCheckBox oII;
    public MMCheckBox oIJ;
    public MMCheckBox oIK;
    private int oIL;
    private int oIM;
    public ArrayList<RelativeLayout> oIN = new ArrayList(9);
    private RelativeLayout oIO;
    public com.tencent.mm.plugin.voip.video.a oIP;
    private j oIQ;
    private ObservableTextureView oIR;
    public String oIS;
    private int oIT;
    public long oIU;
    c oIV = new c(this, (byte) 0);
    private MultiTalkMainUI oIg;
    private ImageButton oIm;

    public static class a {
        View jWc;
        public MultiTalkVideoView oIX;
        public ImageView oIY;
        public ImageView oIZ;
        public TextView oJa;
        ImageView oJb;
    }

    private class b implements Runnable {
        final /* synthetic */ f oIW;
        a oJc;

        public b(f fVar, a aVar) {
            this.oIW = fVar;
            this.oJc = aVar;
        }

        public final void run() {
            this.oJc.oJa.setVisibility(8);
        }
    }

    public f(MultiTalkMainUI multiTalkMainUI) {
        this.oIg = multiTalkMainUI;
        this.ldK = (TextView) multiTalkMainUI.findViewById(R.h.cRs);
        this.oIE = multiTalkMainUI.findViewById(R.h.cQv);
        this.oIm = (ImageButton) multiTalkMainUI.findViewById(R.h.cQu);
        this.oIC = (FrameLayout) multiTalkMainUI.findViewById(R.h.cQw);
        this.oID = (FrameLayout) multiTalkMainUI.findViewById(R.h.cQt);
        this.oIF = multiTalkMainUI.findViewById(R.h.cxV);
        this.oIG = multiTalkMainUI.findViewById(R.h.cxN);
        this.oII = (MMCheckBox) multiTalkMainUI.findViewById(R.h.cye);
        this.oIJ = (MMCheckBox) multiTalkMainUI.findViewById(R.h.cxW);
        this.oIK = (MMCheckBox) multiTalkMainUI.findViewById(R.h.cxS);
        this.oIH = multiTalkMainUI.findViewById(R.h.cxQ);
        this.oIJ.setChecked(o.bcV().kTc);
        this.oIK.setChecked(o.bcV().oGd);
        this.oII.setChecked(o.bcV().bcr());
        this.oIL = com.tencent.mm.bv.a.eA(multiTalkMainUI.mController.xIM);
        this.oIM = b.dg(multiTalkMainUI.mController.xIM);
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[]{Integer.valueOf(this.oIM)});
        this.oIm.setOnClickListener(this);
        this.oIF.setOnClickListener(this);
        this.oII.setOnClickListener(this);
        this.oIJ.setOnClickListener(this);
        this.oIK.setOnClickListener(this);
        this.oIG.setOnClickListener(this);
        this.oIH.setOnClickListener(this);
        n.Jz().a(this);
        for (int i = 8; i >= 0; i--) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(multiTalkMainUI).inflate(R.i.dmW, null);
            a aVar = new a();
            aVar.oIX = (MultiTalkVideoView) relativeLayout.findViewById(R.h.cQx);
            aVar.oIX.index = i;
            aVar.oIX.setOnClickListener(this);
            aVar.jWc = relativeLayout.findViewById(R.h.cuY);
            aVar.oIY = (ImageView) relativeLayout.findViewById(R.h.cWl);
            aVar.oIZ = (ImageView) relativeLayout.findViewById(R.h.cyf);
            aVar.oJa = (TextView) relativeLayout.findViewById(R.h.cPR);
            aVar.oJb = (ImageView) relativeLayout.findViewById(R.h.ctu);
            relativeLayout.setTag(aVar);
            relativeLayout.setVisibility(8);
            this.oIN.add(relativeLayout);
            this.oIC.addView(relativeLayout);
        }
        if (this.oID != null) {
            relativeLayout = (RelativeLayout) LayoutInflater.from(multiTalkMainUI).inflate(R.i.dmW, null);
            a aVar2 = new a();
            aVar2.oIX = (MultiTalkVideoView) relativeLayout.findViewById(R.h.cQx);
            aVar2.oIX.index = 0;
            aVar2.oIX.setOnClickListener(this);
            aVar2.jWc = relativeLayout.findViewById(R.h.cuY);
            aVar2.oIY = (ImageView) relativeLayout.findViewById(R.h.cWl);
            aVar2.oIZ = (ImageView) relativeLayout.findViewById(R.h.cyf);
            aVar2.oJa = (TextView) relativeLayout.findViewById(R.h.cPR);
            aVar2.oJb = (ImageView) relativeLayout.findViewById(R.h.ctu);
            relativeLayout.setTag(aVar2);
            relativeLayout.setVisibility(8);
            this.oIO = relativeLayout;
            this.oID.addView(relativeLayout);
        }
        this.oID.setVisibility(8);
        if (o.bcV().bcr()) {
            this.oIH.setVisibility(0);
        } else {
            this.oIH.setVisibility(8);
        }
        this.oIS = "";
    }

    public final void o(MultiTalkGroup multiTalkGroup) {
        this.oIE.setVisibility(0);
        LinkedList linkedList = new LinkedList();
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.zQu) {
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                linkedList.add(multiTalkGroupMember);
            }
        }
        Y(linkedList);
    }

    private void Y(LinkedList<MultiTalkGroupMember> linkedList) {
        int i;
        int i2;
        int i3;
        float[] fArr;
        this.oIT = linkedList.size();
        LayoutParams layoutParams = this.oIC.getLayoutParams();
        if (this.oIT <= 4) {
            i = this.oIL / 2;
            i2 = this.oIM / 2 > i ? i : this.oIM / 2;
            layoutParams.height = i2 * 2;
            i3 = i;
            i = i2;
        } else if (this.oIT <= 9) {
            i = this.oIL / 3;
            i2 = this.oIM / 3 > i ? i : this.oIM / 3;
            layoutParams.height = i2 * 3;
            i3 = i;
            i = i2;
        } else {
            x.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onlineUserSize larger than 9, %s", new Object[]{Integer.valueOf(this.oIT)});
            return;
        }
        this.oIC.setLayoutParams(layoutParams);
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarWidth: %d | talkingAvatarHeight: %d | size %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(this.oIT)});
        HashSet hashSet = new HashSet();
        hashSet.addAll(o.bcV().oGg);
        if (o.bcV().bcr()) {
            hashSet.add(q.FS());
        }
        if (this.oIT <= 4) {
            fArr = com.tencent.mm.plugin.multitalk.a.i.oGO[this.oIT];
        } else {
            fArr = com.tencent.mm.plugin.multitalk.a.i.oGO[5];
        }
        if (fArr != null) {
            for (int i4 = 0; i4 < fArr.length; i4 += 2) {
                MultiTalkGroupMember multiTalkGroupMember;
                int i5;
                if (this.oIT > i4 / 2) {
                    multiTalkGroupMember = (MultiTalkGroupMember) linkedList.get(i4 / 2);
                } else {
                    multiTalkGroupMember = null;
                }
                i2 = (int) (fArr[i4] * ((float) i3));
                int i6 = (int) (fArr[i4 + 1] * ((float) i));
                if (this.oIT == 2 && i2 == 0) {
                    i2 = 1;
                }
                if (this.oIT == 4 && i2 == 0) {
                    i5 = 1;
                } else {
                    i5 = i2;
                }
                RelativeLayout relativeLayout = (RelativeLayout) this.oIN.get(i4 / 2);
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.width = i3;
                layoutParams2.height = i;
                layoutParams2.leftMargin = i5;
                layoutParams2.topMargin = i6;
                relativeLayout.setLayoutParams(layoutParams2);
                a(relativeLayout, multiTalkGroupMember, false, hashSet);
                relativeLayout.setVisibility(0);
            }
        }
        if (this.oIT <= 4) {
            for (i = this.oIT; i < 9; i++) {
                ((RelativeLayout) this.oIN.get(i)).setVisibility(8);
            }
        }
        if (o.bcV().bcu() && this.oII != null && !this.oII.isChecked()) {
            o.bcV().tg(1);
        }
    }

    private static void a(RelativeLayout relativeLayout, MultiTalkGroupMember multiTalkGroupMember, boolean z, HashSet<String> hashSet) {
        a aVar = (a) relativeLayout.getTag();
        if (multiTalkGroupMember != null) {
            aVar.oIX.FI(multiTalkGroupMember.zQv);
            aVar.oIX.position = aVar.oIX.index;
            if (multiTalkGroupMember.status != 10) {
                aVar.jWc.setVisibility(0);
                if (aVar.oJb.getBackground() != null) {
                    aVar.oJb.setVisibility(0);
                    ((AnimationDrawable) aVar.oJb.getBackground()).stop();
                    ((AnimationDrawable) aVar.oJb.getBackground()).start();
                }
            } else {
                aVar.jWc.setVisibility(8);
                a(aVar);
            }
            if (!hashSet.contains(multiTalkGroupMember.zQv) || z) {
                aVar.oIX.bdf();
                return;
            } else {
                aVar.oIX.bdg();
                return;
            }
        }
        aVar.jWc.setVisibility(8);
        a(aVar);
        aVar.oIX.bdh();
    }

    public final RelativeLayout FH(String str) {
        Iterator it = this.oIN.iterator();
        while (it.hasNext()) {
            RelativeLayout relativeLayout = (RelativeLayout) it.next();
            if (str.equals(((a) relativeLayout.getTag()).oIX.username)) {
                return relativeLayout;
            }
        }
        return null;
    }

    private static int p(boolean z, int i) {
        int i2;
        if (z) {
            i2 = i;
        } else {
            i2 = -1;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(i2);
        int appCmd = o.bcU().oFQ.setAppCmd(22, allocate.array(), 4);
        if (appCmd >= 0) {
            return appCmd;
        }
        x.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:set netBigVideo failed or NO need!, ret:%d, vID:%d, memberId:%d", new Object[]{Integer.valueOf(appCmd), Integer.valueOf(i2), Integer.valueOf(i)});
        return -1;
    }

    public final void onClick(View view) {
        MultiTalkGroupMember multiTalkGroupMember = null;
        boolean z = true;
        if (view instanceof MultiTalkVideoView) {
            MultiTalkVideoView multiTalkVideoView = (MultiTalkVideoView) view;
            a aVar;
            if (this.oID.getVisibility() != 8) {
                if (!multiTalkVideoView.username.equals(q.FS())) {
                    x.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
                    o.bcV().Fq("");
                    p(false, -1);
                }
                this.oID.setVisibility(8);
                this.oIC.setVisibility(0);
                if (this.oIO != null) {
                    aVar = (a) this.oIO.getTag();
                    if (aVar != null) {
                        aVar.oIX.bdh();
                    }
                }
                this.oIS = "";
                d.bcq();
            } else if (multiTalkVideoView.bdk()) {
                int i;
                this.oID.setVisibility(0);
                this.oIC.setVisibility(8);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.width = this.oIL;
                layoutParams.height = this.oIL;
                layoutParams.leftMargin = 0;
                layoutParams.topMargin = 0;
                this.oIO.setLayoutParams(layoutParams);
                String str = multiTalkVideoView.username;
                for (MultiTalkGroupMember multiTalkGroupMember2 : o.bcV().oGi.zQu) {
                    MultiTalkGroupMember multiTalkGroupMember22;
                    if ((multiTalkGroupMember22.status != 10 && multiTalkGroupMember22.status != 1) || !multiTalkGroupMember22.zQv.equals(str)) {
                        multiTalkGroupMember22 = multiTalkGroupMember;
                    }
                    multiTalkGroupMember = multiTalkGroupMember22;
                }
                TalkRoom abU = c.cHH().abU(o.bcV().oGi.zQq);
                if (abU != null) {
                    for (av avVar : abU.cHE()) {
                        if (avVar.zOC.equals(str)) {
                            i = avVar.nEd;
                            break;
                        }
                    }
                }
                i = 0;
                if (!str.equals(q.FS())) {
                    x.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:click memberId:%d", new Object[]{Integer.valueOf(i)});
                    o.bcV().Fq(str);
                    p(true, i);
                }
                if (!(an.is2G(this.oIg) || an.is3G(this.oIg))) {
                    z = false;
                }
                HashSet hashSet = new HashSet();
                hashSet.addAll(o.bcV().oGg);
                if (o.bcV().bcr()) {
                    hashSet.add(q.FS());
                }
                aVar = (a) this.oIO.getTag();
                aVar.oIX.FI(str);
                aVar.oIX.bdh();
                this.oIO.setTag(aVar);
                a(this.oIO, multiTalkGroupMember, z, hashSet);
                this.oIO.setVisibility(0);
                this.oIS = str;
                d.bcp();
            }
        } else if (view.getId() == R.h.cQu) {
            o.bcV().c(true, false, false);
        } else if (view.getId() == R.h.cxV) {
            d.oFX++;
            o.bcV().gR(true);
            d.bco();
        } else if (view.getId() == R.h.cxS) {
            d.oFZ++;
            o.bcV().gS(this.oIK.isChecked());
            if (this.oIK.isChecked()) {
                d.bcj();
            } else {
                d.bck();
            }
        } else if (view.getId() == R.h.cxW) {
            d.oFY++;
            e bcV = o.bcV();
            boolean isChecked = this.oIJ.isChecked();
            o.bcU().oFQ.nL(isChecked);
            bcV.gM(isChecked);
            if (this.oIJ.isChecked()) {
                d.bch();
            } else {
                d.bci();
            }
        } else if (view.getId() == R.h.cxQ) {
            if (this.oIP != null) {
                this.oIP.bIu();
            }
            d.bcn();
        } else if (view.getId() == R.h.cye) {
            d.oGa++;
            if (!com.tencent.mm.compatible.e.b.za()) {
                com.tencent.mm.au.a.a(this.oIg, R.l.eVA, null);
                this.oII.setChecked(false);
            } else if (!o.bcV().bcu()) {
                this.oII.setChecked(false);
            } else if (!an.isNetworkConnected(this.oIg)) {
                com.tencent.mm.au.a.a(this.oIg, R.l.eVz, null);
                this.oII.setChecked(false);
            } else if (com.tencent.mm.plugin.multitalk.a.i.bcO()) {
                if (this.oII.isChecked()) {
                    a(null, false);
                    d.bcl();
                } else {
                    gU(false);
                    o.bcV().tg(1);
                    d.bcm();
                }
                this.oII.setChecked(o.bcV().bcr());
            } else {
                Toast.makeText(this.oIg, R.l.evW, 1).show();
                this.oII.setChecked(false);
            }
        } else if (view.getId() == R.h.cxN) {
            d.oGb++;
            this.oIg.bda();
        }
    }

    public final void c(HashSet<String> hashSet) {
        Iterator it = this.oIN.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((RelativeLayout) it.next()).getTag();
            if (!q.FS().equals(aVar.oIX.username)) {
                if (hashSet.contains(aVar.oIX.username)) {
                    if (!aVar.oIX.bdk()) {
                        aVar.oIX.bdg();
                    }
                } else if (aVar.oIX.bdk()) {
                    aVar.oIX.bdf();
                    if (this.oIS.equals(aVar.oIX.username) && this.oID.getVisibility() == 0) {
                        this.oIS = "";
                        this.oID.setVisibility(8);
                        this.oIC.setVisibility(0);
                    }
                }
            }
        }
    }

    public final void bdc() {
        Iterator it = this.oIN.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((RelativeLayout) it.next()).getTag();
            if (!q.FS().equals(aVar.oIX.username) && aVar.oIX.bdk()) {
                aVar.oIX.bdf();
            }
        }
    }

    public final void a(RelativeLayout relativeLayout, boolean z) {
        ViewGroup FH;
        if (!z) {
            this.oIU = System.currentTimeMillis();
        }
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
        if (this.oID == null || this.oID.getVisibility() != 0) {
            FH = FH(q.FS());
        } else {
            FH = (ViewGroup) this.oIg.findViewById(R.h.cIA);
        }
        if (FH != null) {
            if (this.oIR == null) {
                x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
                this.oIR = new ObservableTextureView(this.oIg);
                this.oIR.setLayoutParams(new RelativeLayout.LayoutParams(1, 1));
                FH.addView(this.oIR);
                this.oIR.setVisibility(0);
            }
            if (this.oIP == null) {
                x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
                this.oIP = new com.tencent.mm.plugin.voip.video.a(320, 240);
                this.oIP.a(this, true);
                this.oIP.a(this.oIR);
                this.oIP.bIv();
                if (!o.bcV().oGf) {
                    this.oIP.bIu();
                }
                x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[]{Boolean.valueOf(this.oIP.bIy()), Boolean.valueOf(this.oIP.bIz())});
            }
            if (this.oIQ == null) {
                this.oIQ = new j(this.oIg);
                com.tencent.mm.sdk.f.e.d(new 1(this.oIQ), "MultiTalkVideoTaskManager_native_drawer_handler", 1).start();
            }
        }
    }

    public final void gU(boolean z) {
        if (!z && this.oIU != 0 && System.currentTimeMillis() - this.oIU > 0 && o.bcV().bcv()) {
            d.n(System.currentTimeMillis() - this.oIU, com.tencent.mm.plugin.multitalk.a.i.bcK());
            this.oIU = 0;
        }
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
        if (this.oIR != null) {
            ViewParent parent = this.oIR.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.oIR);
            }
            this.oIR = null;
        }
        if (this.oIP != null) {
            this.oIP.bIw();
            com.tencent.mm.plugin.voip.video.a.bIx();
            this.oIP = null;
        }
        if (this.oIQ != null) {
            j jVar = this.oIQ;
            jVar.oGq = null;
            jVar.oGV.maM = false;
            jVar.oGV.oGZ = null;
            if (jVar.oGU != null) {
                jVar.oGU.removeCallbacksAndMessages(null);
                jVar.oGU.getLooper().quit();
                jVar.oGU = null;
            }
            this.oIQ = null;
        }
    }

    public final void gV(boolean z) {
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
        this.oIT = 0;
        if (!z) {
            ag.y(new 1(this));
        }
        gU(false);
        Iterator it = this.oIN.iterator();
        while (it.hasNext()) {
            ((a) ((RelativeLayout) it.next()).getTag()).oIX.setSurfaceTextureListener(null);
        }
        n.Jz().b(this);
    }

    public final void c(byte[] bArr, long j, int i, int i2, int i3) {
        if (o.bcV().bcu()) {
            if (this.oIV.oGZ == null) {
                this.oIV.w = i;
                this.oIV.h = i2;
                this.oIV.oGZ = new int[(this.oIV.w * this.oIV.h)];
            }
            if (!o.bcV().bcr()) {
                com.tencent.mm.plugin.multitalk.a.i.bcM();
                o.bcV().tg(3);
            }
            long currentTimeMillis = System.currentTimeMillis();
            o.bcV().oGf = this.oIP.bIy();
            int i4 = this.oIP.bIy() ? OpenGlRender.suk : 0;
            int i5 = this.oIP.bIz() ? OpenGlRender.suj : OpenGlRender.sui;
            g a = o.bcU().oFQ.a(bArr, (int) j, this.oIV.w, this.oIV.h, i3 & 31, this.oIV.oGZ);
            if (a.ret < 0 || this.oIV.oGZ == null || a.zQD == 0 || a.zQE == 0) {
                x.e("MicroMsg.MT.MultiTalkTalkingUILogic", "ret: %d", new Object[]{Integer.valueOf(a.ret)});
                return;
            }
            int i6;
            long currentTimeMillis2 = System.currentTimeMillis();
            int i7 = i4 == OpenGlRender.suk ? 257 : 1;
            if (o.bcV().oGs) {
                i6 = i4 == OpenGlRender.suk ? 259 : 3;
            } else {
                i6 = i7;
            }
            i7 = o.bcU().oFQ.a(bArr, (short) ((int) j), i, i2, i3, i6);
            if (System.currentTimeMillis() - currentTimeMillis > 30) {
                x.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", new Object[]{Integer.valueOf(a.zQD), Integer.valueOf(a.zQE), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
            }
            if (i7 <= 0) {
                x.v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", new Object[]{Integer.valueOf(i7)});
            }
            if (this.oIQ != null && this.oIV.oGZ != null) {
                j jVar = this.oIQ;
                int[] iArr = this.oIV.oGZ;
                i7 = a.zQD;
                int i8 = a.zQE;
                if (iArr == null) {
                    x.e("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady pBuffer is null");
                    return;
                } else if (jVar.oGV.maM) {
                    x.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady busy!!!!");
                    return;
                } else {
                    if (jVar.oGV.oGZ == null) {
                        jVar.oGV.oGZ = new int[iArr.length];
                    }
                    jVar.oGV.w = i7;
                    jVar.oGV.h = i8;
                    jVar.oGV.oGX = i3;
                    jVar.oGV.oGY = i4;
                    jVar.oGV.angle = i5;
                    long currentTimeMillis3 = System.currentTimeMillis();
                    i6 = jVar.oGV.h;
                    if (jVar.oGV.h > jVar.oGV.w) {
                        i6 = jVar.oGV.w;
                    }
                    if (jVar.oGV.mTJ == null) {
                        jVar.oGV.mTJ = Bitmap.createBitmap(i6, i6, Config.RGB_565);
                    }
                    if (jVar.oGV.mTJ != null) {
                        jVar.oGV.mTJ.setPixels(iArr, jVar.oGV.w - jVar.oGV.h, jVar.oGV.w, 0, 0, i6, i6);
                    }
                    if (System.currentTimeMillis() - currentTimeMillis3 > 30) {
                        x.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: createBitmap: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis3)});
                    }
                    if (jVar.oGU != null) {
                        jVar.oGU.post(new com.tencent.mm.plugin.multitalk.a.j.b(jVar));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        gU(false);
    }

    public final synchronized void a(String str, int[] iArr, int i, int i2, int i3, int i4) {
        if (this.oID.getVisibility() == 0) {
            a aVar = (a) this.oIO.getTag();
            if (str.equals(aVar.oIX.username)) {
                aVar.oIX.a(iArr, i, i2, 0, i4);
            }
        } else {
            RelativeLayout FH = FH(str);
            if (FH != null) {
                ((a) FH.getTag()).oIX.a(iArr, i, i2, 0, i4);
            }
        }
    }

    public final synchronized void a(String str, Bitmap bitmap, int i, int i2) {
        if (this.oID.getVisibility() == 0) {
            a aVar = (a) this.oIO.getTag();
            if (str.equals(aVar.oIX.username)) {
                aVar.oIX.b(bitmap, i2, i);
            }
        } else {
            RelativeLayout FH = FH(str);
            if (FH != null) {
                ((a) FH.getTag()).oIX.b(bitmap, i2, i);
            }
        }
    }

    public final void bdd() {
        x.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
        if (this.iol == null) {
            this.iol = com.tencent.mm.au.a.a(this.oIg, R.l.eVA, new Runnable(this) {
                final /* synthetic */ f oIW;

                {
                    this.oIW = r1;
                }

                public final void run() {
                    this.oIW.gU(false);
                }
            });
        }
        if (!this.iol.isShowing()) {
            this.iol.show();
        }
        o.bcV().tg(1);
    }

    public final void jh(String str) {
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[]{str});
        RelativeLayout FH = FH(str);
        if (FH != null) {
            ((a) FH.getTag()).oIX.bde();
        }
    }

    private static void a(a aVar) {
        if (aVar.oJb.getBackground() != null) {
            ((AnimationDrawable) aVar.oJb.getBackground()).stop();
        }
        aVar.oJb.setVisibility(8);
    }
}

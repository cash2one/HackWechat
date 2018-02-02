package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.k.a;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private String clientId = null;
    private String fzO;
    private b gJQ;
    private e gJT;
    private f hBj;
    private int hlp = 0;
    private int hlq = 0;
    private String poU = null;
    private String poV;
    private int poW = 0;

    public m(java.lang.String r7, java.lang.String r8, java.lang.String[] r9, int r10, com.tencent.mm.ae.f r11) {
        /* JADX: method processing error */
/*
Error: java.lang.IndexOutOfBoundsException: bitIndex < 0: -1
	at java.util.BitSet.get(BitSet.java:623)
	at jadx.core.dex.visitors.CodeShrinker$ArgsInfo.usedArgAssign(CodeShrinker.java:138)
	at jadx.core.dex.visitors.CodeShrinker$ArgsInfo.access$300(CodeShrinker.java:43)
	at jadx.core.dex.visitors.CodeShrinker.canMoveBetweenBlocks(CodeShrinker.java:282)
	at jadx.core.dex.visitors.CodeShrinker.shrinkBlock(CodeShrinker.java:230)
	at jadx.core.dex.visitors.CodeShrinker.shrinkMethod(CodeShrinker.java:38)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkArrayForEach(LoopRegionVisitor.java:196)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkForIndexedLoop(LoopRegionVisitor.java:119)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:65)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = 0;
        r6.<init>();
        r6.poU = r0;
        r6.hlp = r1;
        r6.clientId = r0;
        r6.hlq = r1;
        r6.poW = r1;
        r6.poU = r7;
        r6.poW = r10;
        r6.hBj = r11;
        r0 = com.tencent.mm.sdk.platformtools.bh.ov(r7);
        if (r0 != 0) goto L_0x005e;
    L_0x001b:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = r7.getBytes();
        r2 = com.tencent.mm.a.g.s(r2);
        r0 = r0.append(r2);
        r2 = "_";
        r0 = r0.append(r2);
        r2 = java.lang.System.nanoTime();
        r0 = r0.append(r2);
        r2 = "_";
        r0 = r0.append(r2);
        r2 = new java.util.Random;
        r2.<init>();
        r2 = r2.nextInt();
        r0 = r0.append(r2);
        r0 = r0.toString();
        r6.clientId = r0;
        r0 = r7.getBytes();
        r0 = r0.length;
        r6.hlp = r0;
        r6.hlq = r1;
    L_0x005e:
        r0 = com.tencent.mm.sdk.platformtools.bh.ov(r8);
        if (r0 != 0) goto L_0x0066;
    L_0x0064:
        r6.fzO = r8;
    L_0x0066:
        if (r9 == 0) goto L_0x00a2;
    L_0x0068:
        r0 = "";
        r6.poV = r0;
        r2 = r9.length;
        r0 = r1;
    L_0x006f:
        if (r0 >= r2) goto L_0x0092;
    L_0x0071:
        r3 = r9[r0];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r6.poV;
        r4 = r4.append(r5);
        r3 = r4.append(r3);
        r4 = ",";
        r3 = r3.append(r4);
        r3 = r3.toString();
        r6.poV = r3;
        r0 = r0 + 1;
        goto L_0x006f;
    L_0x0092:
        r0 = r6.poV;
        r2 = r6.poV;
        r2 = r2.length();
        r2 = r2 + -1;
        r0 = r0.substring(r1, r2);
        r6.poV = r0;
    L_0x00a2:
        r0 = "MicroMsg.NetSceneComposeSend";
        r2 = "NetSceneComposeSend, clientId: %s, totalLen: %d";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = r6.clientId;
        r3[r1] = r4;
        r1 = 1;
        r4 = r6.hlp;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r1] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qqmail.b.m.<init>(java.lang.String, java.lang.String, java.lang.String[], int, com.tencent.mm.ae.f):void");
    }

    protected final int Bh() {
        return 100;
    }

    protected final int a(q qVar) {
        if (!bh.ov(this.poU)) {
            return k.b.hmP;
        }
        x.e("MicroMsg.NetSceneComposeSend", "securityVerificationChecked failed, content is null");
        return k.b.hmQ;
    }

    protected final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.hlq = ((ot) ((b) qVar).hmh.hmo).vIC;
            if (this.gJT != null) {
                this.gJT.a(i2, i3, str, this);
            }
            if (this.hBj != null) {
                this.hBj.a(this.hlq, this.hlp, this);
            }
            if (this.hlq < this.hlp) {
                x.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[]{Integer.valueOf(this.hlq), Integer.valueOf(this.hlp)});
                if (a(this.hmA, this.gJT) < 0) {
                    x.e("MicroMsg.NetSceneComposeSend", "continue to upload fail");
                    return;
                }
                return;
            }
            x.i("MicroMsg.NetSceneComposeSend", "finished upload");
        } else if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 485;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        if (bh.ov(this.poU)) {
            x.e("MicroMsg.NetSceneComposeSend", "doScene, sendContent is null");
            return -1;
        }
        int min = Math.min(this.hlp - this.hlq, WXMediaMessage.THUMB_LENGTH_LIMIT);
        x.i("MicroMsg.NetSceneComposeSend", "doScene, dataLen: %d", new Object[]{Integer.valueOf(min)});
        byte[] bArr = new byte[min];
        byte[] bytes = this.poU.getBytes();
        int i = 0;
        for (int i2 = this.hlq; i2 < this.hlq + min; i2++) {
            bArr[i] = bytes[i2];
            i++;
        }
        if (bh.bw(bArr)) {
            x.e("MicroMsg.NetSceneComposeSend", "doScene, sendData is null");
            return -1;
        }
        b.a aVar = new b.a();
        aVar.hmj = new os();
        aVar.hmk = new ot();
        aVar.uri = "/cgi-bin/micromsg-bin/composesend";
        aVar.hmi = 485;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        os osVar = (os) this.gJQ.hmg.hmo;
        osVar.vGQ = this.clientId;
        osVar.vIB = this.hlp;
        osVar.vIC = this.hlq;
        osVar.vID = min;
        osVar.vXA = this.fzO;
        osVar.vXB = this.poV;
        osVar.vXC = (int) (((float) this.hlp) + (((float) this.poW) * 1.3333334f));
        x.i("MicroMsg.NetSceneComposeSend", "doScene, realSize: %d", new Object[]{Integer.valueOf(osVar.vXC)});
        osVar.vXz = n.N(bArr);
        x.i("MicroMsg.NetSceneComposeSend", "doScene, ret: %d", new Object[]{Integer.valueOf(a(eVar, this.gJQ, this))});
        return a(eVar, this.gJQ, this);
    }
}

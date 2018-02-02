package com.tencent.mm.plugin.sns.a.b;

import android.os.SystemClock;
import com.tencent.mm.plugin.sns.a.b.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class h {
    public String TAG = "MicroMsg.SnsAdVideoStatistic";
    public long hOC = 0;
    public long hOD = 0;
    public int qPl = 0;
    public int qPm = 0;
    public long qPn = 0;
    public int qPo = 0;
    public int qPp = 0;
    public int qPq = 0;
    public int qPr = 0;
    public boolean qPs = false;
    public a qPt = new a();
    public LinkedList<a> qPu = new LinkedList();
    public long qPv = 0;

    public h(String str) {
        this.TAG = "MicroMsg.SnsAdVideoStatistic:" + str;
    }

    public final void wr(int i) {
        if (this.qPt.qQr <= 0) {
            this.qPt.qQr = this.qPt.qQv == 0 ? 0 : (int) bh.bA(this.qPt.qQv);
        }
        if (i != 0) {
            this.qPt.qQs = i;
            this.qPv = (long) i;
        }
        x.i(this.TAG, "pushplayitem duration " + this.qPt.qQr + " " + this.qPt.qQu);
        this.qPu.add(this.qPt);
        this.qPt = new a();
    }

    public final String btZ() {
        int i;
        LinkedList linkedList;
        a aVar;
        if (this.qPn == 0) {
            i = 0;
        } else {
            i = (int) bh.bA(this.qPn);
        }
        this.qPm = i;
        x.d(this.TAG, "__staytotaltime " + this.qPn + " " + this.qPm + " clock: " + SystemClock.elapsedRealtime());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<viewinfo>");
        stringBuffer.append("<downloadstatus>");
        stringBuffer.append(this.qPl);
        stringBuffer.append("</downloadstatus>");
        stringBuffer.append("<staytotaltime>");
        stringBuffer.append(this.qPm);
        stringBuffer.append("</staytotaltime>");
        if (this.qPo > 0) {
            stringBuffer.append("<masktotaltime>");
            stringBuffer.append(this.qPo);
            stringBuffer.append("</masktotaltime>");
        }
        LinkedList linkedList2 = this.qPu;
        if (!this.qPs || this.qPu.size() <= 1) {
            linkedList = linkedList2;
        } else {
            a aVar2 = new a();
            for (int i2 = 0; i2 < this.qPu.size(); i2++) {
                aVar = (a) this.qPu.get(i2);
                if (i2 == 0) {
                    aVar2.qQs = aVar.qQs;
                    aVar2.qQt = aVar.qQt;
                    aVar2.qQu = aVar.qQu;
                }
                aVar2.qQq += aVar.qQq;
                aVar2.qQr = aVar.qQr + aVar2.qQr;
            }
            linkedList2 = new LinkedList();
            linkedList2.add(aVar2);
            linkedList = linkedList2;
        }
        stringBuffer.append(String.format("<playitemlist count=\"%d\">", new Object[]{Integer.valueOf(linkedList.size())}));
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            aVar = (a) linkedList.get(i3);
            stringBuffer.append("<playitem>");
            stringBuffer.append(String.format("<playcount>%d</playcount>", new Object[]{Integer.valueOf(aVar.qQq)}));
            stringBuffer.append(String.format("<playtotaltime>%d</playtotaltime>", new Object[]{Integer.valueOf(aVar.qQr)}));
            stringBuffer.append(String.format("<videototaltime>%d</videototaltime>", new Object[]{Integer.valueOf(aVar.qQs * 1000)}));
            stringBuffer.append(String.format("<playmode>%d</playmode>", new Object[]{Integer.valueOf(aVar.qQt)}));
            stringBuffer.append(String.format("<playorientation>%d</playorientation>", new Object[]{Integer.valueOf(aVar.qQu)}));
            stringBuffer.append("</playitem>");
        }
        stringBuffer.append("</playitemlist>");
        stringBuffer.append("</viewinfo>");
        String stringBuffer2 = stringBuffer.toString();
        x.i(this.TAG, "xml " + stringBuffer2);
        return stringBuffer2;
    }

    public final void bua() {
        this.qPp = 0;
        this.qPq = 0;
        this.qPr = 0;
        Iterator it = this.qPu.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            this.qPp += aVar.qQp;
            this.qPq += aVar.qQq;
            this.qPr = aVar.qQr + this.qPr;
        }
        if (this.qPt != null && !this.qPu.contains(this.qPt)) {
            this.qPp += this.qPt.qQp;
            this.qPq += this.qPt.qQq;
            this.qPr += this.qPt.qQr;
        }
    }

    public final void onResume() {
        if (this.hOC != 0) {
            long bA = bh.bA(this.hOC);
            this.hOD += bA;
            this.hOC = 0;
            if (this.qPt != null) {
                a aVar = this.qPt;
                aVar.qQw = bA + aVar.qQw;
            }
        }
    }
}

package com.tencent.mm.bg;

import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bta;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class g {
    String hYG;
    LinkedHashMap<String, a> hYH = new LinkedHashMap();
    final ReadWriteLock hYI = new ReentrantReadWriteLock();
    private StringBuilder hYJ = new StringBuilder();

    public class a {
        public String data;
        public String hYK;
        public boolean hYL;
        public boolean hYM;
        public int hYN;
        public int hYO;
        public int hYP;
        public boolean hYQ;
        final /* synthetic */ g hYR;

        public a(g gVar) {
            this.hYR = gVar;
            long nextInt = 4294967295L & ((long) new Random(System.currentTimeMillis()).nextInt());
            long currentTimeMillis = ((4294967295L & System.currentTimeMillis()) << 32) | nextInt;
            if (currentTimeMillis < 0) {
                currentTimeMillis = Math.abs(currentTimeMillis);
            }
            x.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", Long.valueOf(nextInt), Long.toBinaryString(nextInt), Long.valueOf(r2), Long.toBinaryString(r2), Long.valueOf(currentTimeMillis), Long.toBinaryString(currentTimeMillis), this.hYR.hYG, this.hYR.hYG + String.valueOf(currentTimeMillis));
            this.hYK = r6;
            this.hYL = false;
            this.hYM = false;
            this.hYN = Integer.MAX_VALUE;
            this.hYO = 0;
            this.hYP = -1;
            this.data = null;
            this.hYQ = false;
        }
    }

    public g(String str) {
        this.hYG = str;
    }

    public final LinkedList<bdo> UY() {
        LinkedList<bdo> linkedList = new LinkedList();
        this.hYI.readLock().lock();
        for (a aVar : this.hYH.values()) {
            if (aVar.hYL) {
                linkedList.add(new bdo().UA(aVar.hYK));
            }
        }
        this.hYI.readLock().unlock();
        return linkedList;
    }

    public final String getResult() {
        this.hYJ.setLength(0);
        this.hYI.readLock().lock();
        for (a aVar : this.hYH.values()) {
            if (aVar.data != null) {
                this.hYJ.append(aVar.data);
            }
        }
        this.hYI.readLock().unlock();
        return this.hYJ.toString();
    }

    public final boolean UZ() {
        this.hYI.readLock().lock();
        if (this.hYH.size() == 0) {
            x.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
            return false;
        }
        boolean z;
        for (a aVar : this.hYH.values()) {
            x.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", aVar.hYK, Boolean.valueOf(aVar.hYM), Boolean.valueOf(aVar.hYQ));
            if (!((a) r3.next()).hYQ) {
                z = false;
                break;
            }
        }
        z = true;
        this.hYI.readLock().unlock();
        return z;
    }

    public final void X(List<bta> list) {
        String str;
        String str2 = "MicroMsg.ShortSentenceContainer";
        String str3 = "updateVoiceInfoResult respVTList size %s innerContainer %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
        this.hYI.readLock().lock();
        if (this.hYH.size() == 0) {
            this.hYI.readLock().unlock();
            str = "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (a aVar : this.hYH.values()) {
                stringBuilder.append(aVar.hYK).append(", ");
            }
            if (stringBuilder.length() <= 3) {
                this.hYI.readLock().unlock();
                str = stringBuilder.append("]").toString();
            } else {
                stringBuilder.setLength(stringBuilder.length() - 2);
                this.hYI.readLock().unlock();
                str = stringBuilder.append("]").toString();
            }
        }
        objArr[1] = str;
        x.d(str2, str3, objArr);
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.ShortSentenceContainer", "respList == null");
            return;
        }
        this.hYI.readLock().lock();
        for (bta com_tencent_mm_protocal_c_bta : list) {
            if (com_tencent_mm_protocal_c_bta == null) {
                x.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
            } else {
                a aVar2 = (a) this.hYH.get(com_tencent_mm_protocal_c_bta.vWC);
                if (aVar2 == null) {
                    x.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", com_tencent_mm_protocal_c_bta.vWC);
                } else if (com_tencent_mm_protocal_c_bta == null) {
                    x.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
                } else {
                    String str4 = "MicroMsg.ShortSentenceContainer";
                    String str5 = "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s";
                    Object[] objArr2 = new Object[12];
                    objArr2[0] = com_tencent_mm_protocal_c_bta.vWC;
                    objArr2[1] = Integer.valueOf(com_tencent_mm_protocal_c_bta.wUd);
                    Integer valueOf = (com_tencent_mm_protocal_c_bta.wRU == null || com_tencent_mm_protocal_c_bta.wRU.wJD == null) ? null : Integer.valueOf(com_tencent_mm_protocal_c_bta.wRU.wJB);
                    objArr2[2] = valueOf;
                    objArr2[3] = Boolean.valueOf(com_tencent_mm_protocal_c_bta.vLj != 0);
                    objArr2[4] = Integer.valueOf(com_tencent_mm_protocal_c_bta.vLj);
                    objArr2[5] = aVar2.hYK;
                    objArr2[6] = Boolean.valueOf(aVar2.hYL);
                    objArr2[7] = Boolean.valueOf(aVar2.hYM);
                    objArr2[8] = Integer.valueOf(aVar2.hYN);
                    objArr2[9] = Integer.valueOf(aVar2.hYP);
                    objArr2[10] = aVar2.data == null ? null : Integer.valueOf(aVar2.data.length());
                    objArr2[11] = Boolean.valueOf(aVar2.hYQ);
                    x.d(str4, str5, objArr2);
                    if (com_tencent_mm_protocal_c_bta.wUd < aVar2.hYP || aVar2.hYQ) {
                        x.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
                    } else {
                        aVar2.hYP = com_tencent_mm_protocal_c_bta.wUd;
                        str3 = (com_tencent_mm_protocal_c_bta.wRU == null || com_tencent_mm_protocal_c_bta.wRU.wJD == null) ? null : com_tencent_mm_protocal_c_bta.wRU.wJD.cdp();
                        aVar2.data = str3;
                        aVar2.hYQ = com_tencent_mm_protocal_c_bta.vLj != 0;
                        str3 = "MicroMsg.ShortSentenceContainer";
                        str4 = "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s";
                        Object[] objArr3 = new Object[4];
                        objArr3[0] = com_tencent_mm_protocal_c_bta.vWC;
                        objArr3[1] = Integer.valueOf(aVar2.hYP);
                        objArr3[2] = Boolean.valueOf(aVar2.hYQ);
                        objArr3[3] = Integer.valueOf(aVar2.data == null ? -1 : aVar2.data.length());
                        x.i(str3, str4, objArr3);
                        if (com_tencent_mm_protocal_c_bta.vLj == 2) {
                            x.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", com_tencent_mm_protocal_c_bta.vWC);
                        }
                    }
                }
            }
        }
        this.hYI.readLock().unlock();
    }

    public final void iN(int i) {
        x.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", Integer.valueOf(i));
        if (i < 0) {
            throw new IllegalStateException("splitShortSentence file mark less than zero. mark: " + i);
        }
        this.hYI.readLock().lock();
        if (this.hYH.size() == 0) {
            x.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
            return;
        }
        a aVar = null;
        for (a aVar2 : this.hYH.values()) {
        }
        if (aVar == null) {
            throw new IllegalStateException("splitShortSentence last info is null");
        }
        x.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", Integer.valueOf(aVar.hYN), aVar.hYK, Integer.valueOf(i));
        aVar.hYN = i;
        this.hYI.readLock().unlock();
    }

    public final a iO(int i) {
        this.hYI.readLock().lock();
        if (this.hYH.size() == 0) {
            return null;
        }
        for (a aVar : this.hYH.values()) {
            x.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", Integer.valueOf(i), Integer.valueOf(aVar.hYN), Boolean.valueOf(aVar.hYM));
            if (!aVar.hYM && i <= aVar.hYN) {
                break;
            }
        }
        a aVar2 = null;
        this.hYI.readLock().unlock();
        return aVar2;
    }
}

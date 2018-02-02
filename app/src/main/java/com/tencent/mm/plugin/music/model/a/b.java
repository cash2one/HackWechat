package com.tencent.mm.plugin.music.model.a;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ac.a;
import com.tencent.mm.ac.c;
import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.music.model.g.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    Object lKI = new Object();
    private LinkedList<String> oKe = new LinkedList();
    private HashMap<String, e> oKf = new HashMap();
    private LinkedList<String> oKg = new LinkedList();
    private HashMap<String, e> oKh = new HashMap();
    private LinkedList<String> oKi = new LinkedList();
    LinkedList<String> oKj = new LinkedList();
    HashMap<String, String> oKk = new HashMap();
    private HashMap<String, LinkedList<String>> oKl = new HashMap();
    HashMap<String, a> oKm = new HashMap();
    private HashMap<String, c> oKn = new HashMap();
    private LinkedList<String> oKo = new LinkedList();
    HashMap<String, Integer> oKp = new HashMap();
    private LinkedList<String> oKq = new LinkedList();
    boolean oKr = false;
    private boolean oKs = false;
    long oKt = 0;
    private long oKu = 0;
    private a oKv = new 1(this);
    private Runnable oKw = new 2(this);
    Runnable oKx = new Runnable(this) {
        final /* synthetic */ b oKy;

        {
            this.oKy = r1;
        }

        public final void run() {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
            Iterator it = this.oKy.oKj.iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object obj2;
                String str = (String) it.next();
                if (this.oKy.FU(str) == 0) {
                    this.oKy.FY(str);
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
                obj = obj2;
            }
            if (obj == null) {
                synchronized (this.oKy.lKI) {
                    this.oKy.oKr = true;
                }
                this.oKy.oKt = System.currentTimeMillis();
                ag.h(this.oKy.oKx, 1800000);
            }
        }
    };

    static /* synthetic */ void a(b bVar) {
        if (bVar.bdI() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!bVar.oKs || currentTimeMillis - bVar.oKu >= 10000) {
                synchronized (bVar.lKI) {
                    bVar.oKs = true;
                }
                bVar.oKu = currentTimeMillis;
                x.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayIfPaused, delay_ms:%d", new Object[]{Integer.valueOf(600000)});
                ag.K(bVar.oKw);
                ag.h(bVar.oKw, 600000);
                return;
            }
            return;
        }
        synchronized (bVar.lKI) {
            bVar.oKs = false;
        }
        ag.K(bVar.oKw);
    }

    public b() {
        bdF();
    }

    public final void bdF() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "_release");
        this.oKe.clear();
        synchronized (this.lKI) {
            Iterator it = this.oKg.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                c(str, (e) this.oKf.remove(str));
            }
            this.oKg.clear();
            this.oKf.clear();
            it = this.oKi.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                c(str, (e) this.oKh.remove(str));
            }
            this.oKi.clear();
            this.oKh.clear();
        }
        Iterator it2 = this.oKj.iterator();
        while (it2.hasNext()) {
            LinkedList linkedList = (LinkedList) this.oKl.remove((String) it2.next());
            if (linkedList != null) {
                linkedList.clear();
            }
        }
        this.oKj.clear();
        this.oKk.clear();
        this.oKl.clear();
        this.oKm.clear();
        this.oKn.clear();
        this.oKp.clear();
        this.oKq.clear();
        ag.K(this.oKw);
        ag.K(this.oKx);
        this.oKr = false;
        this.oKs = false;
    }

    private void du(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", new Object[]{str, str2});
            if (!this.oKj.contains(str)) {
                this.oKj.add(str);
            }
            if (!this.oKe.contains(str2)) {
                this.oKe.add(str2);
            }
            LinkedList linkedList = (LinkedList) this.oKl.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList();
            }
            if (!linkedList.contains(str2)) {
                linkedList.add(str2);
            }
            this.oKl.put(str, linkedList);
        }
    }

    public final String dv(String str, String str2) {
        int i;
        x.i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
        LinkedList linkedList = (LinkedList) this.oKl.get(str);
        synchronized (this.lKI) {
            if (linkedList != null) {
                if (linkedList.contains(str2) && (this.oKg.contains(str2) || this.oKi.contains(str2))) {
                    i = 1;
                }
            }
            i = 0;
        }
        int FU = FU(str);
        if (TextUtils.isEmpty(str2)) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
            at(604, str2);
            return null;
        } else if (FU >= 10) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", new Object[]{Integer.valueOf(FU)});
            du(str, str2);
            return null;
        } else if (i != 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
            at(603, str2);
            return null;
        } else {
            Ga(str2);
            e bdG = bdG();
            bdG.a(this.oKv);
            bdG.Gg(str2);
            du(str, str2);
            f(str2, bdG);
            x.i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", new Object[]{str, str2});
            return str2;
        }
    }

    public final boolean b(a aVar) {
        boolean z = false;
        if (aVar == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
            at(605, "");
            return false;
        } else if (TextUtils.isEmpty(aVar.fnF)) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
            at(604, aVar.fnF);
            return false;
        } else if (this.oKe.contains(aVar.fnF)) {
            e FV;
            x.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
            String FZ = FZ(aVar.fnF);
            a iN = iN(aVar.fnF);
            if (FU(FZ) >= 10) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", new Object[]{Integer.valueOf(FU(FZ))});
                this.oKm.put(aVar.fnF, aVar);
                x.i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", new Object[]{Boolean.valueOf(aVar.hkv)});
                if (aVar.hkv && Gc(aVar.fnF)) {
                    bdL();
                } else if (aVar.hkv) {
                    at(600, aVar.fnF);
                    return false;
                } else {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
                    FV = FV(aVar.fnF);
                    if (FV != null) {
                        FV.c(aVar);
                        FV.bdS();
                    }
                    return true;
                }
            }
            Ga(aVar.fnF);
            e FV2 = FV(aVar.fnF);
            if (FV2 == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", new Object[]{aVar.fnF});
                FV = bdG();
                FV.a(this.oKv);
                FV.Gg(aVar.fnF);
                FV.c(aVar);
                if (aVar.hkv) {
                    e(aVar.fnF, FV);
                    aVar.hkx = System.currentTimeMillis();
                    FV.d(aVar);
                } else {
                    f(aVar.fnF, FV);
                    FV.bdS();
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
                }
            } else {
                x.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", new Object[]{aVar.fnF});
                if (aVar.hkv) {
                    e(aVar.fnF, FV2);
                    aVar.hkx = System.currentTimeMillis();
                    FV2.c(aVar);
                    if (iN != null && !iN.a(aVar)) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
                        if (FV2.Qq() || FV2.Qr() || FV2.bec() || FV2.isPrepared() || FV2.isPaused()) {
                            FV2.stopPlay();
                        }
                        FV2.d(aVar);
                    } else if (FV2.Qq()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
                    } else if (FV2.Qr() && FV2.isPaused()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
                        FV2.resume();
                    } else if (FV2.isPrepared()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
                        FV2.resume();
                    } else if (FV2.bec()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
                    } else {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
                        FV2.d(aVar);
                    }
                } else {
                    synchronized (this.lKI) {
                        if (this.oKg.contains(aVar.fnF)) {
                            z = true;
                        }
                    }
                    if (z) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
                    } else {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
                        f(aVar.fnF, FV2);
                    }
                    FV2.c(aVar);
                    if (!(iN == null || iN.a(aVar))) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
                        if (FV2.Qq() || FV2.Qr() || FV2.bec() || FV2.isPrepared() || FV2.isPaused()) {
                            FV2.stopPlay();
                        }
                    }
                    FV2.bdS();
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
                }
            }
            this.oKk.put(FZ, aVar.processName);
            this.oKm.put(aVar.fnF, aVar);
            return true;
        } else {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
            at(601, aVar.fnF);
            return false;
        }
    }

    public final boolean a(String str, a aVar) {
        a aVar2 = (a) this.oKm.get(str);
        if ((!this.oKe.contains(str) || aVar2 == null) && aVar != null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", new Object[]{str});
            if (aVar == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", new Object[]{str});
            } else {
                x.i("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", new Object[]{str});
                this.oKk.put(aVar.appId, aVar.processName);
                this.oKm.put(aVar.fnF, aVar);
                du(aVar.appId, str);
                this.oKp.remove(str);
            }
            if (aVar2 == null) {
                aVar2 = aVar;
            }
        } else if (!this.oKe.contains(str)) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
            at(601, str);
            return false;
        } else if (aVar2 == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
            at(602, str);
            return false;
        }
        x.i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", new Object[]{str});
        if (FU(FZ(str)) >= 10) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", new Object[]{Integer.valueOf(FU(FZ(str)))});
            if (Gc(str)) {
                bdL();
            } else {
                at(600, str);
                return false;
            }
        }
        e FV = FV(str);
        if (FV == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
            Ga(str);
            x.i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", new Object[]{str});
            FV = bdG();
            FV.a(this.oKv);
            FV.Gg(str);
            e(str, FV);
            aVar2.hkv = true;
            aVar2.hkt = 0;
            aVar2.hkx = System.currentTimeMillis();
            FV.d(aVar2);
            return true;
        }
        e(str, FV);
        this.oKm.put(str, aVar2);
        if (FV.Qr() && !FV.Qq()) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
            FV.resume();
        } else if (FV.isPrepared()) {
            aVar2.hkv = true;
            aVar2.hkx = System.currentTimeMillis();
            x.i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
            FV.resume();
            aVar2.hkt = 0;
            FV.c(aVar2);
        } else if (FV.bec()) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
            aVar2.hkv = true;
            aVar2.hkx = System.currentTimeMillis();
            FV.c(aVar2);
        } else if (FV.Qr()) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
            return false;
        } else {
            aVar2.hkv = true;
            aVar2.hkx = System.currentTimeMillis();
            x.i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
            FV.d(aVar2);
            aVar2.hkt = 0;
        }
        return true;
    }

    public final boolean FR(String str) {
        e FV = FV(str);
        if (FV == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
            return false;
        }
        x.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", new Object[]{str});
        FV.stopPlay();
        a aVar = (a) this.oKm.get(str);
        if (aVar != null) {
            aVar.hkt = 0;
            aVar.hkv = true;
        }
        b(str, FV);
        f(str, FV);
        return true;
    }

    public final boolean FS(String str) {
        e FV = FV(str);
        if (FV == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
            return false;
        }
        x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", new Object[]{str});
        c(str, FV);
        synchronized (this.lKI) {
            this.oKf.remove(str);
            this.oKg.remove(str);
            this.oKh.remove(str);
            this.oKi.remove(str);
        }
        this.oKe.remove(str);
        Iterator it = this.oKj.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            LinkedList linkedList = (LinkedList) this.oKl.get(str2);
            if (linkedList != null && linkedList.contains(str)) {
                linkedList.remove(str);
                if (linkedList.size() == 0) {
                    this.oKl.remove(str2);
                    this.oKj.remove(str2);
                    this.oKk.remove(str2);
                }
                this.oKm.remove(str);
                this.oKn.remove(str);
                return true;
            }
        }
        this.oKm.remove(str);
        this.oKn.remove(str);
        return true;
    }

    final boolean bI(String str, int i) {
        a aVar = (a) this.oKm.get(str);
        if (aVar == null) {
            return false;
        }
        aVar.hkt = i;
        return true;
    }

    public final c FT(String str) {
        e FV = FV(str);
        if (FV != null) {
            return FV.bef();
        }
        return (c) this.oKn.get(str);
    }

    public final int FU(String str) {
        int size;
        int bdI = bdI();
        synchronized (this.lKI) {
            int size2 = this.oKe.size();
            size = this.oKf.size();
            int size3 = this.oKh.size();
            LinkedList linkedList = (LinkedList) this.oKl.get(str);
            int size4 = linkedList == null ? 0 : linkedList.size();
            x.i("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", new Object[]{Integer.valueOf(size2), Integer.valueOf(size), Integer.valueOf(size3), Integer.valueOf(size4), Integer.valueOf(bdI)});
        }
        return size;
    }

    public final a iN(String str) {
        if (this.oKm.containsKey(str)) {
            return (a) this.oKm.get(str);
        }
        return null;
    }

    final e FV(String str) {
        if (this.oKf.containsKey(str)) {
            return (e) this.oKf.get(str);
        }
        if (this.oKh.containsKey(str)) {
            return (e) this.oKh.get(str);
        }
        return null;
    }

    public final void FW(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", new Object[]{str});
        LinkedList linkedList = (LinkedList) this.oKl.get(str);
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
        } else if (this.oKf.isEmpty() && this.oKh.isEmpty()) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                e eVar = (e) this.oKh.get(str2);
                if (eVar != null) {
                    a(str2, eVar);
                }
            }
            x.i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", new Object[]{Integer.valueOf(this.oKf.size())});
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                String str3 = (String) it2.next();
                e eVar2 = (e) this.oKf.get(str3);
                if (eVar2 != null) {
                    a(str3, eVar2);
                    f(str3, eVar2);
                }
            }
        }
    }

    public final void FX(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", new Object[]{str});
        LinkedList linkedList = (LinkedList) this.oKl.remove(str);
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            return;
        }
        synchronized (this.lKI) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                e eVar = (e) this.oKf.remove(str2);
                this.oKg.remove(str2);
                x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
                c(str2, eVar);
                this.oKm.remove(str2);
                this.oKn.remove(str2);
            }
            it = linkedList.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                eVar = (e) this.oKh.remove(str2);
                this.oKi.remove(str2);
                x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                c(str2, eVar);
                this.oKm.remove(str2);
                this.oKn.remove(str2);
            }
        }
        this.oKe.removeAll(linkedList);
        this.oKj.remove(str);
        this.oKk.remove(str);
    }

    public final void FY(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", new Object[]{str});
        LinkedList linkedList = (LinkedList) this.oKl.get(str);
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            return;
        }
        synchronized (this.lKI) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                e eVar = (e) this.oKf.remove(str2);
                this.oKg.remove(str2);
                if (eVar != null) {
                    b(str2, eVar);
                    x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
                    if (eVar.hkB) {
                        d(str2, eVar);
                    } else {
                        c(str2, eVar);
                    }
                }
            }
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                String str3 = (String) it2.next();
                e eVar2 = (e) this.oKh.remove(str3);
                this.oKi.remove(str3);
                if (eVar2 != null) {
                    b(str3, eVar2);
                    x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                    if (eVar2.hkB) {
                        d(str3, eVar2);
                    } else {
                        c(str3, eVar2);
                    }
                }
            }
        }
    }

    private void at(int i, String str) {
        x.e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", new Object[]{Integer.valueOf(i), str});
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
            str = com.tencent.mm.ac.b.Jx();
        }
        com.tencent.mm.sdk.b.b tVar = new t();
        tVar.fnK.action = 4;
        tVar.fnK.state = "error";
        tVar.fnK.errCode = h.tI(i);
        tVar.fnK.fnL = h.tJ(i);
        tVar.fnK.fnF = str;
        tVar.fnK.appId = FZ(str);
        com.tencent.mm.sdk.b.a.xef.a(tVar, Looper.getMainLooper());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private e bdG() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "createOrReusePlayer");
        synchronized (this.lKI) {
            if (this.oKh.size() == 0) {
                e eVar = new e();
                return eVar;
            }
            eVar = null;
            Object obj = "";
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = this.oKi.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                e eVar2 = (e) this.oKh.get(str);
                if (eVar2 != null) {
                    String str2;
                    e eVar3;
                    long j2;
                    if (!(eVar2.hkB || eVar2.isCompleted() || eVar2.isStopped())) {
                        Object obj2 = eVar2.oKD != null ? eVar2.oKD.getPlayerState() == 9 ? 1 : null : null;
                    }
                    if (j == 0 || eVar2.gKo < j) {
                        str2 = str;
                        eVar3 = eVar2;
                        j2 = eVar2.gKo;
                        obj = str2;
                        eVar = eVar3;
                        j = j2;
                    }
                    j2 = j;
                    str2 = obj;
                    eVar3 = eVar;
                    obj = str2;
                    eVar = eVar3;
                    j = j2;
                }
            }
            if (eVar == null || currentTimeMillis - j <= 500) {
            } else {
                x.i("MicroMsg.Audio.AudioPlayerMgr", "player is be reuse to play again with other audio");
                x.i("MicroMsg.Audio.AudioPlayerMgr", "unmarkPlayer, unmark player by audioId:%s", new Object[]{obj});
                synchronized (this.lKI) {
                    if (this.oKi.contains(obj)) {
                        this.oKh.remove(obj);
                        this.oKi.remove(obj);
                    }
                    if (this.oKg.contains(obj)) {
                        this.oKg.remove(obj);
                        this.oKf.remove(obj);
                    }
                }
                return eVar;
            }
        }
    }

    private String FZ(String str) {
        Iterator it = this.oKj.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            LinkedList linkedList = (LinkedList) this.oKl.get(str2);
            if (linkedList != null && linkedList.contains(str)) {
                return str2;
            }
        }
        return "";
    }

    private void a(String str, e eVar) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", new Object[]{str});
        a aVar = (a) this.oKm.get(str);
        if (aVar != null && eVar.Qq() && eVar.Qr()) {
            aVar.hkv = true;
            aVar.hkt = eVar.bee();
        } else if (aVar != null && eVar.Qr()) {
            aVar.hkv = true;
            aVar.hkt = eVar.bee();
        } else if (aVar != null) {
            aVar.hkv = true;
            aVar.hkt = 0;
        }
        b(str, eVar);
        c FT = FT(str);
        if (FT != null && eVar.Qq()) {
            FT.hkA = true;
        }
        if (eVar.Qq() || eVar.Qr() || eVar.bec() || eVar.isPrepared() || eVar.isPaused()) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
            eVar.hkB = true;
            eVar.bed();
            return;
        }
        x.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
        eVar.hkB = true;
        eVar.oKG = true;
    }

    final void b(String str, e eVar) {
        this.oKn.put(str, eVar.bef());
    }

    private static void c(String str, e eVar) {
        if (eVar == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", new Object[]{str});
            return;
        }
        if (eVar.Qq() || eVar.Qr() || eVar.bec() || eVar.isPrepared() || eVar.isPaused()) {
            eVar.stopPlay();
        }
        eVar.release();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", new Object[]{str});
    }

    private static void d(String str, e eVar) {
        x.d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
        c(str, eVar);
    }

    final void e(String str, e eVar) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", new Object[]{str});
        synchronized (this.lKI) {
            if (this.oKi.contains(str)) {
                this.oKh.remove(str);
                this.oKi.remove(str);
            }
            if (!this.oKg.contains(str)) {
                this.oKg.add(str);
                this.oKf.put(str, eVar);
            }
        }
    }

    final void f(String str, e eVar) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", new Object[]{str});
        synchronized (this.lKI) {
            if (this.oKg.contains(str)) {
                this.oKf.remove(str);
                this.oKg.remove(str);
            }
            if (!this.oKi.contains(str)) {
                this.oKi.add(str);
                this.oKh.put(str, eVar);
            }
        }
    }

    public final void bdH() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.oKr || currentTimeMillis - this.oKt >= 10000) {
            this.oKt = currentTimeMillis;
            synchronized (this.lKI) {
                this.oKr = true;
            }
            x.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", new Object[]{Integer.valueOf(1800000)});
            ag.K(this.oKx);
            ag.h(this.oKx, 1800000);
        }
    }

    private int bdI() {
        int i;
        synchronized (this.lKI) {
            Iterator it = this.oKi.iterator();
            i = 0;
            while (it.hasNext()) {
                boolean z;
                int i2;
                String str = (String) it.next();
                e FV = FV(str);
                if (FV == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
                    c FT = FT(str);
                    z = FT != null ? FT.hkA : false;
                } else {
                    z = FV.isPaused();
                }
                if (z) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        return i;
    }

    private void Ga(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
        int size = this.oKf.size();
        int size2 = this.oKh.size();
        int bdI = bdI();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", new Object[]{Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(bdI)});
        if (size >= 10) {
            bdJ();
        } else if (bdI >= 6) {
            bdJ();
        } else if (size + bdI >= 8) {
            bdJ();
        }
        String FZ = FZ(str);
        bdI = this.oKf.size();
        size = this.oKh.size();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[]{Integer.valueOf(bdI), Integer.valueOf(size)});
        Iterator it;
        String str2;
        if (size >= 50) {
            it = this.oKj.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                if (!(str2 == null || str2.equalsIgnoreCase(FZ))) {
                    Gb(str2);
                }
            }
        } else if (size + bdI >= 50) {
            it = this.oKj.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                if (!(str2 == null || str2.equalsIgnoreCase(FZ))) {
                    Gb(str2);
                }
            }
        } else {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleStopPlayerByAppId");
        }
        size = this.oKh.size();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[]{Integer.valueOf(bdI), Integer.valueOf(size)});
        if (size >= 50) {
            bdK();
        } else if (size + bdI >= 50) {
            bdK();
        } else {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleAllStopPlayer");
        }
    }

    private void bdJ() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
        synchronized (this.lKI) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.oKi);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                e eVar = (e) this.oKh.get(str);
                if (eVar != null && eVar.isPaused()) {
                    a(str, eVar);
                }
            }
        }
    }

    private void bdK() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
        synchronized (this.lKI) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.oKi);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                e eVar = (e) this.oKh.remove(str);
                this.oKi.remove(str);
                if (eVar != null) {
                    if (eVar.hkB) {
                        b(str, eVar);
                        d(str, eVar);
                    } else if (!eVar.isPaused()) {
                        b(str, eVar);
                        c(str, eVar);
                    }
                }
            }
        }
    }

    private void Gb(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
        FY(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean Gc(String str) {
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.lKI) {
            int size = this.oKf.size();
            if (size < 10) {
                this.oKo.clear();
                x.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove", new Object[]{Integer.valueOf(size)});
                return false;
            }
            Iterator it = this.oKg.iterator();
            while (it.hasNext()) {
                a aVar = (a) this.oKm.get((String) it.next());
                if (!(aVar == null || aVar.hks == null)) {
                    ArrayList arrayList2;
                    if (hashMap.containsKey(aVar.hks)) {
                        hashMap.put(aVar.hks, Integer.valueOf(((Integer) hashMap.get(aVar.hks)).intValue() + 1));
                        arrayList2 = (ArrayList) hashMap2.get(aVar.hks);
                        if (!arrayList2.contains(aVar.fnF)) {
                            arrayList2.add(aVar.fnF);
                        }
                        hashMap2.put(aVar.hks, arrayList2);
                    } else {
                        hashMap.put(aVar.hks, Integer.valueOf(1));
                        arrayList2 = new ArrayList();
                        arrayList2.add(aVar.fnF);
                        hashMap2.put(aVar.hks, arrayList2);
                    }
                    if (!arrayList.contains(aVar.hks)) {
                        arrayList.add(aVar.hks);
                    }
                }
            }
        }
    }

    final void bdL() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
        Iterator it = this.oKo.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", new Object[]{(String) it.next()});
            FR(r0);
        }
        it = this.oKq.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", new Object[]{(String) it.next()});
            FR(r0);
        }
        this.oKo.clear();
        this.oKq.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean Gd(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "canRemoveAudioPlayerInPlayingListForTry");
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.lKI) {
            if (this.oKf.size() <= 5) {
                x.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove for try", new Object[]{Integer.valueOf(this.oKf.size())});
                return false;
            }
            Iterator it = this.oKg.iterator();
            while (it.hasNext()) {
                a aVar = (a) this.oKm.get((String) it.next());
                if (!(aVar == null || aVar.hks == null)) {
                    ArrayList arrayList2;
                    if (hashMap.containsKey(aVar.hks)) {
                        hashMap.put(aVar.hks, Integer.valueOf(((Integer) hashMap.get(aVar.hks)).intValue() + 1));
                        arrayList2 = (ArrayList) hashMap2.get(aVar.hks);
                        if (!arrayList2.contains(aVar.fnF)) {
                            arrayList2.add(aVar.fnF);
                        }
                        hashMap2.put(aVar.hks, arrayList2);
                    } else {
                        hashMap.put(aVar.hks, Integer.valueOf(1));
                        arrayList2 = new ArrayList();
                        arrayList2.add(aVar.fnF);
                        hashMap2.put(aVar.hks, arrayList2);
                    }
                    if (!arrayList.contains(aVar.hks)) {
                        arrayList.add(aVar.hks);
                    }
                }
            }
        }
    }
}

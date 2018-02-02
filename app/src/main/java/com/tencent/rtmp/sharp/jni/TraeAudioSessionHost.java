package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost {
    private ArrayList<a> _sessionInfoList = new ArrayList();
    private ReentrantLock mLock = new ReentrantLock();

    public a find(long j) {
        a aVar;
        this.mLock.lock();
        for (int i = 0; i < this._sessionInfoList.size(); i++) {
            aVar = (a) this._sessionInfoList.get(i);
            if (aVar.a == j) {
                break;
            }
        }
        aVar = null;
        this.mLock.unlock();
        return aVar;
    }

    public void add(long j, Context context) {
        if (find(j) == null) {
            a aVar = new a(this);
            aVar.a = j;
            this.mLock.lock();
            this._sessionInfoList.add(aVar);
            this.mLock.unlock();
        }
    }

    public void remove(long j) {
        this.mLock.lock();
        for (int i = 0; i < this._sessionInfoList.size(); i++) {
            if (((a) this._sessionInfoList.get(i)).a == j) {
                this._sessionInfoList.remove(i);
                break;
            }
        }
        this.mLock.unlock();
    }
}

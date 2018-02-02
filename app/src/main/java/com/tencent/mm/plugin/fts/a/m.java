package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.j;

public interface m extends d {
    void addSOSHistory(String str);

    void cancelSearchTask(a aVar);

    void deleteSOSHistory();

    void deleteSOSHistory(String str);

    g getFTSIndexDB();

    h getFTSIndexStorage(int i);

    i getFTSMainDB();

    l getFTSTaskDaemon();

    boolean isFTSContextReady();

    boolean isFTSIndexReady();

    void registerIndexStorage(h hVar);

    void registerNativeLogic(int i, j jVar);

    a search(int i, g gVar);

    int stringCompareUtfBinary(String str, String str2);

    void unregisterIndexStorage(int i);

    void unregisterNativeLogic(int i);

    void updateTopHitsRank(String str, j jVar, int i);
}

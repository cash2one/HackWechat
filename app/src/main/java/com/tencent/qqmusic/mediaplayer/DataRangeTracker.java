package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DataRangeTracker {
    private static final String TAG = "DataRangeTracker";
    private Comparator<Range> mComparator = new 1(this);
    private final ArrayList<Range> mDownloadDataList = new ArrayList();

    public void addRange(long j, long j2) {
        int i = 1;
        if (j > j2) {
            Logger.e(TAG, "[addRange] illegal arguments! beginPos(%s) > endPos(%s)", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        Logger.d(TAG, String.format("[addRange] [%d, %d]", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        Collection arrayList = new ArrayList();
        this.mDownloadDataList.add(new Range(j, j2, null));
        Collections.sort(this.mDownloadDataList, this.mComparator);
        int size = this.mDownloadDataList.size() - 1;
        Range range = (Range) this.mDownloadDataList.get(0);
        if (size > 0) {
            Range range2 = range;
            while (i <= size) {
                Range range3;
                range = (Range) this.mDownloadDataList.get(i);
                if (Range.access$100(range2) + 1 < Range.access$200(range)) {
                    arrayList.add(new Range(Range.access$200(range2), Range.access$100(range2), null));
                    range3 = new Range(Range.access$200(range), Range.access$100(range), null);
                } else {
                    range3 = new Range(Range.access$200(range2), Range.access$100(range2) > Range.access$100(range) ? Range.access$100(range2) : Range.access$100(range), null);
                }
                if (i >= size) {
                    arrayList.add(range3);
                }
                i++;
                range2 = range3;
            }
            this.mDownloadDataList.clear();
            this.mDownloadDataList.addAll(arrayList);
        }
    }

    public long findStart(long j) {
        int i = 0;
        int size = this.mDownloadDataList.size();
        if (size == 0) {
            return -1;
        }
        long access$100 = Range.access$100((Range) this.mDownloadDataList.get(0)) + 1;
        while (i < size) {
            if (j < Range.access$200((Range) this.mDownloadDataList.get(i))) {
                return access$100;
            }
            access$100 = Range.access$100((Range) this.mDownloadDataList.get(i)) + 1;
            if (j <= Range.access$100((Range) this.mDownloadDataList.get(i))) {
                return Range.access$100((Range) this.mDownloadDataList.get(i)) + 1;
            }
            i++;
        }
        return Range.access$100((Range) this.mDownloadDataList.get(this.mDownloadDataList.size() - 1)) + 1;
    }

    public long findEnd(long j) {
        int size = this.mDownloadDataList.size();
        if (size == 0) {
            return -1;
        }
        int i = 0;
        while (i < size) {
            if (j < Range.access$200((Range) this.mDownloadDataList.get(i))) {
                return Range.access$200((Range) this.mDownloadDataList.get(i)) - 1;
            }
            if (j <= Range.access$100((Range) this.mDownloadDataList.get(i)) && i + 1 < size) {
                return Range.access$200((Range) this.mDownloadDataList.get(i + 1)) - 1;
            }
            i++;
        }
        return 0;
    }

    public boolean isCached(long j, int i) {
        long findStart = findStart(j);
        long findStart2 = findStart(((long) i) + j);
        long findEnd = findEnd(j);
        long findEnd2 = findEnd(((long) i) + j);
        if (findStart != findStart2 || findEnd != findEnd2 || findEnd == -1 || ((long) i) + j > findStart) {
            return false;
        }
        return true;
    }

    public long getContinuousEnd() {
        if (this.mDownloadDataList.size() == 0) {
            return -1;
        }
        return Range.access$100((Range) this.mDownloadDataList.get(0));
    }

    synchronized List<Range> getEmptyContentPairList(long j) {
        List<Range> arrayList;
        arrayList = new ArrayList();
        long j2 = 0;
        synchronized (this.mDownloadDataList) {
            Iterator it = this.mDownloadDataList.iterator();
            while (it.hasNext()) {
                Range range = (Range) it.next();
                if (j2 < Range.access$200(range)) {
                    arrayList.add(new Range(j2, Range.access$200(range) - 1, null));
                }
                j2 = Range.access$100(range) + 1;
            }
        }
        if (j2 < j) {
            arrayList.add(new Range(j2, j - 1, null));
        }
        return arrayList;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.mDownloadDataList.size(); i++) {
            stringBuilder.append(((Range) this.mDownloadDataList.get(i)).toString());
        }
        return stringBuilder.toString();
    }
}

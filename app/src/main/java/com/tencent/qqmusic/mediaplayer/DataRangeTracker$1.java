package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.DataRangeTracker.Range;
import java.util.Comparator;

class DataRangeTracker$1 implements Comparator<Range> {
    final /* synthetic */ DataRangeTracker this$0;

    DataRangeTracker$1(DataRangeTracker dataRangeTracker) {
        this.this$0 = dataRangeTracker;
    }

    public int compare(Range range, Range range2) {
        return (int) (Range.access$200(range) - Range.access$200(range2));
    }
}

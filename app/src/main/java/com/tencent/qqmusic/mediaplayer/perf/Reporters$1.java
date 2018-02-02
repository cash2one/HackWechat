package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.OverallInfo;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.SpeedCheck;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.Visitor;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Reporters$1 implements Visitor {
    final /* synthetic */ AudioInformation val$audioInformation;
    final /* synthetic */ Map val$extra;

    Reporters$1(AudioInformation audioInformation, Map map) {
        this.val$audioInformation = audioInformation;
        this.val$extra = map;
    }

    public final void visitSpeedCheck(List<SpeedCheck> list, OverallInfo overallInfo) {
        File file = overallInfo.mediaFile;
        long round = Math.round(((double) overallInfo.totalPcmToBePlayed) / ((double) overallInfo.timeCostInMs));
        double channels = ((double) (((long) (this.val$audioInformation.getBitDept() == 1 ? 1 : 2)) * (((long) this.val$audioInformation.getChannels()) * this.val$audioInformation.getPlaySample()))) / 1000.0d;
        double d = ((double) round) / channels;
        StringBuilder stringBuilder = new StringBuilder("\n============== Info start ==============\n");
        stringBuilder.append("媒体文件信息:\n");
        stringBuilder.append("\t播放时间: ").append(new Date().toString()).append("\n");
        stringBuilder.append("\t文件路径: ").append(file.getAbsolutePath()).append("\n");
        stringBuilder.append("\t文件大小: ").append(file.length()).append("\n");
        stringBuilder.append("\t音频类型: ").append(this.val$audioInformation.getAudioType().toString()).append("\n");
        stringBuilder.append("\t文件采样率: ").append(this.val$audioInformation.getSampleRate()).append("\n");
        stringBuilder.append("\t播放采样率: ").append(this.val$audioInformation.getPlaySample()).append("\n");
        stringBuilder.append("\t位深: ").append(this.val$audioInformation.getBitDept()).append("\n");
        stringBuilder.append("\t声道数: ").append(this.val$audioInformation.getChannels()).append("\n");
        stringBuilder.append("\t时长: ").append(this.val$audioInformation.getDuration()).append("\n");
        stringBuilder.append("\t平均码率: ").append((file.length() / this.val$audioInformation.getDuration()) * 8).append("\n");
        stringBuilder.append("\n整体性能\n");
        stringBuilder.append("\t总耗时 (ms): ").append(overallInfo.timeCostInMs).append("\n");
        stringBuilder.append("\t播放PCM数据量 (byte): ").append(overallInfo.totalPcmToBePlayed).append("\n");
        stringBuilder.append("\t总速度 (byte/ms): ").append(round).append(" (").append(Math.round(d)).append(" 倍于最低要求速度)\n");
        stringBuilder.append("\t最低要求速度 (byte/ms): ").append(channels).append("\n");
        stringBuilder.append("\n额外信息:");
        for (Entry entry : this.val$extra.entrySet()) {
            stringBuilder.append("\n\t").append((String) entry.getKey()).append(": ").append((String) entry.getValue());
        }
        stringBuilder.append("\n");
        Reporters.access$000(list, stringBuilder, overallInfo.timeCostInMs);
        stringBuilder.append("============== Info end ==============");
        FileLogger.write(stringBuilder, new File(file.getAbsolutePath() + ".perf"), false);
    }
}

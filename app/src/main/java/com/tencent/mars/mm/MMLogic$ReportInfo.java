package com.tencent.mars.mm;

public class MMLogic$ReportInfo {
    public long actionId = 0;
    public long beginTime = 0;
    public String clientIp = "";
    public long connCostTime = 0;
    public long connTotalCostTime = 0;
    public long dnsCostTime = 0;
    public int dnsErrType = 0;
    public String dnsSvrIp = "";
    public int endFlag = 0;
    public int endStep = 0;
    public long endTime = 0;
    public int errCode = 0;
    public int errType = 0;
    public long expand1 = 0;
    public long expand2 = 0;
    public String extraInfo = "";
    public long firstPkgTime = 0;
    public String host = "";
    public String ip = "";
    public int ipType = 0;
    public boolean isSocket = false;
    public int localIp = 0;
    public long netSignal = 0;
    public int netType = 0;
    public int newNetType = 0;
    public long newdnsCostTime = 0;
    public int newdnsErrCode = 0;
    public int newdnsErrType = 0;
    public int port = 0;
    public long recvSize = 0;
    public int refTime1 = 0;
    public int refTime2 = 0;
    public int refTime3 = 0;
    public int retryCount = 0;
    public long rtType = 0;
    public long sendSize = 0;
    public int subNetType = 0;
    public int usedIpIndex = 0;

    public String toString() {
        return String.format("actionId:%d, rtType:%d, begin:%d, end:%d, cost:%d, ip:%s, port:%d, isSocket:%b, netType:%d, ipType:%d, sendSize:%d, recvSize:%d, errType:%d, errCode:%d, netSignal:%d, retryCount:%d, expand1:%d, clientip:%s, expand2:%d, newNetType:%d, subNetType:%d, extraInfo:%s, host:%s, endStep:%d, endFlag:%d", new Object[]{Long.valueOf(this.actionId), Long.valueOf(this.rtType), Long.valueOf(this.beginTime), Long.valueOf(this.endTime), Long.valueOf(this.endTime - this.beginTime), this.ip, Integer.valueOf(this.port), Boolean.valueOf(this.isSocket), Integer.valueOf(this.netType), Integer.valueOf(this.ipType), Long.valueOf(this.sendSize), Long.valueOf(this.recvSize), Integer.valueOf(this.errType), Integer.valueOf(this.errCode), Long.valueOf(this.netSignal), Integer.valueOf(this.retryCount), Long.valueOf(this.expand1), this.clientIp, Long.valueOf(this.expand2), Integer.valueOf(this.newNetType), Integer.valueOf(this.subNetType), this.extraInfo, this.host, Integer.valueOf(this.endStep), Integer.valueOf(this.endFlag)});
    }
}

package com.tencent.mm.network.a;

public class a$a {
    public long beginTime = 0;
    public String clientIp = "";
    public long endTime = 0;
    public int errCode = 0;
    public int errType = 0;
    public long expand1 = 0;
    public long expand2 = 0;
    public long hRA = 0;
    public long ibA = 0;
    public c ibr;
    public boolean ibs = false;
    public long ibt = 0;
    public long ibu = 0;
    public long ibv = 0;
    public int ibw = 0;
    public int ibx = 0;
    public long iby = 0;
    public long ibz = 0;
    public long netSignal = 0;
    public int netType = 0;
    public int retryCount = 0;
    public long rtType = 0;

    public final String toString() {
        String str = "rtType:%d begin:%d, end:%d time:%d cost:%d count:%d ipInfo:%s socket:%b netType:%d err:(%d,%d) tx:%d rx:%d";
        Object[] objArr = new Object[13];
        objArr[0] = Long.valueOf(this.rtType);
        objArr[1] = Long.valueOf(this.beginTime);
        objArr[2] = Long.valueOf(this.endTime);
        objArr[3] = Long.valueOf(this.endTime - this.beginTime);
        objArr[4] = Long.valueOf(this.hRA);
        objArr[5] = Long.valueOf(this.ibv);
        objArr[6] = this.ibr == null ? "null" : this.ibr.toString();
        objArr[7] = Boolean.valueOf(this.ibs);
        objArr[8] = Integer.valueOf(this.netType);
        objArr[9] = Integer.valueOf(this.errType);
        objArr[10] = Integer.valueOf(this.errCode);
        objArr[11] = Long.valueOf(this.ibt);
        objArr[12] = Long.valueOf(this.ibu);
        return String.format(str, objArr);
    }
}

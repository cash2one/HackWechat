package com.tencent.mm.aj;

public class a$a implements Comparable<a$a> {
    public long endTime = 0;
    public long huA = 0;
    public long huB = 0;
    public long huu = 0;
    public int huv = 0;
    public boolean huw = true;
    public boolean hux = false;
    public int huy = 0;
    public long huz = 0;
    public int pid = 0;
    public long startTime = 0;
    public int type = 0;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        a$a com_tencent_mm_aj_a_a = (a$a) obj;
        return (this.huu == 0 || com_tencent_mm_aj_a_a.huu == 0) ? (int) (this.startTime - com_tencent_mm_aj_a_a.startTime) : (int) (this.huu - com_tencent_mm_aj_a_a.huu);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        switch (this.type) {
            case 0:
                stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", new Object[]{a.bc(this.huu), a.bc(this.startTime), a.bc(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.huw)}));
                break;
            case 1:
                stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", new Object[]{a.bc(this.huu), a.bc(this.startTime), a.bc(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.huv), Boolean.valueOf(this.huw)}));
                break;
            case 2:
                stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", new Object[]{a.bc(this.huu), a.bc(this.startTime), a.bc(this.endTime), Integer.valueOf(this.huy)}));
                break;
            case 3:
                stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", new Object[]{a.bc(this.huu), a.bc(this.startTime), a.bc(this.endTime), Integer.valueOf(this.huy)}));
                break;
            case 4:
                stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,delayed msg pid:%s, msg server time:%s,interval time:%s, msg server id:%s", new Object[]{a.bc(this.huu), a.bc(this.startTime), a.bc(this.endTime), Integer.valueOf(this.pid), a.bc(this.huz), Long.valueOf(this.huA), Long.valueOf(this.huB)}));
                break;
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}

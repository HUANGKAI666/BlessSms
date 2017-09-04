package cn.studyjams.s2.sj0147.huangkai.bean;



public class Msg {
    private int id;
    private int festvaId;
    private String content;
public Msg(int id,int festvaId,String content)
{
    this.id = id;
    this.festvaId = festvaId ;
    this.content = content;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFestvaId() {
        return festvaId;
    }

    public void setFestvaId(int festvaId) {
        this.festvaId = festvaId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

package com.example.thinkpad.assets;

/**
 * Created by 宋德慧
 * time: 2018/7/19-20:17.
 * email: m18201222438@163.com
 * tel: 15836320932
 */
public class CheatsBean {
    private String title;

    private String simleContent;

    private String imageName;

    private String htmlName;

    public CheatsBean() {
    }

    public CheatsBean(String title, String simleContent, String imageName, String htmlName) {
        super();
        this.title = title;
        this.simleContent = simleContent;
        this.imageName = imageName;
        this.htmlName = htmlName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSimleContent() {
        return simleContent;
    }

    public void setSimleContent(String simleContent) {
        this.simleContent = simleContent;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getHtmlName() {
        return htmlName;
    }

    public void setHtmlName(String htmlName) {
        this.htmlName = htmlName;
    }

}

package com.WZYHome.Study.Demo.Unit13_NetWork.Bean;

/**
 * Created by Administrator on 2017/10/12.
 */

public class ErrorInfo {

    /**
     * Category :
     * Message :
     * Status : false
     */

    private String Category;
    private String Message;
    private boolean Status;

    public ErrorInfo(String category, String message, boolean status) {
        Category = category;
        Message = message;
        Status = status;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "Category='" + Category + '\'' +
                ", Message='" + Message + '\'' +
                ", Status=" + Status +
                '}';
    }

}

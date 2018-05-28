package com.WZYHome.Study.Demo.Entity;

/**
 * Created by Administrator on 2018/4/8.
 */

public class Book {
    //以下Book类与上面的代码无关

        private String tvBookName;
        private String tvAuthor;
        private String content;


        public Book(String tvBookName, String tvAuthor) {
            this.tvBookName = tvBookName;
            this.tvAuthor = tvAuthor;
        }

        public String getTvBookName() {
            return tvBookName;
        }

        public void setTvBookName(String tvBookName) {
            this.tvBookName = tvBookName;
        }

        public String getTvAuthor() {
            return tvAuthor;
        }

        public void setTvAuthor(String tvAuthor) {
            this.tvAuthor = tvAuthor;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

}

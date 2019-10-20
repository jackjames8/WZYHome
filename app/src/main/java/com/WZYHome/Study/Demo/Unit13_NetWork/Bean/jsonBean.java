package com.WZYHome.Study.Demo.Unit13_NetWork.Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/12/13.
 */

public class jsonBean {


    private List<个人信息Bean> 个人信息;
    private List<企业信息Bean> 企业信息;
    private List<入会申请Bean> 入会申请;
    private List<合同管理Bean> 合同管理;
    private List<支付管理Bean> 支付管理;
    private List<诚信档案Bean> 诚信档案;
    private List<项目发布Bean> 项目发布;

    public List<个人信息Bean> get个人信息() {
        return 个人信息;
    }

    public void set个人信息(List<个人信息Bean> 个人信息) {
        this.个人信息 = 个人信息;
    }

    public List<企业信息Bean> get企业信息() {
        return 企业信息;
    }

    public void set企业信息(List<企业信息Bean> 企业信息) {
        this.企业信息 = 企业信息;
    }

    public List<入会申请Bean> get入会申请() {
        return 入会申请;
    }

    public void set入会申请(List<入会申请Bean> 入会申请) {
        this.入会申请 = 入会申请;
    }

    public List<合同管理Bean> get合同管理() {
        return 合同管理;
    }

    public void set合同管理(List<合同管理Bean> 合同管理) {
        this.合同管理 = 合同管理;
    }

    public List<支付管理Bean> get支付管理() {
        return 支付管理;
    }

    public void set支付管理(List<支付管理Bean> 支付管理) {
        this.支付管理 = 支付管理;
    }

    public List<诚信档案Bean> get诚信档案() {
        return 诚信档案;
    }

    public void set诚信档案(List<诚信档案Bean> 诚信档案) {
        this.诚信档案 = 诚信档案;
    }

    public List<项目发布Bean> get项目发布() {
        return 项目发布;
    }

    public void set项目发布(List<项目发布Bean> 项目发布) {
        this.项目发布 = 项目发布;
    }

    public static class 个人信息Bean {
        /**
         * icon :
         * menuid : 0201
         * menuname : 帐号信息修改
         * menupid : 02
         * name : PERSON_ACCOUNT
         * no : 4
         * url : /fore/mine/person
         */

        private String icon;
        private String menuid;
        private String menuname;
        private String menupid;
        private String name;
        private int no;
        private String url;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getMenuid() {
            return menuid;
        }

        public void setMenuid(String menuid) {
            this.menuid = menuid;
        }

        public String getMenuname() {
            return menuname;
        }

        public void setMenuname(String menuname) {
            this.menuname = menuname;
        }

        public String getMenupid() {
            return menupid;
        }

        public void setMenupid(String menupid) {
            this.menupid = menupid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class 企业信息Bean {
        /**
         * icon :
         * menuid : 0301
         * menuname : 企业基本信息
         * menupid : 03
         * name : ENTERPRISE_INFO
         * no : 7
         * url : /fore/mine/enterprise
         */

        private String icon;
        private String menuid;
        private String menuname;
        private String menupid;
        private String name;
        private int no;
        private String url;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getMenuid() {
            return menuid;
        }

        public void setMenuid(String menuid) {
            this.menuid = menuid;
        }

        public String getMenuname() {
            return menuname;
        }

        public void setMenuname(String menuname) {
            this.menuname = menuname;
        }

        public String getMenupid() {
            return menupid;
        }

        public void setMenupid(String menupid) {
            this.menupid = menupid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class 入会申请Bean {
        /**
         * icon :
         * menuid : 0101
         * menuname : 填写入会申请资料
         * menupid : 01
         * name : MEMBER_APPLY
         * no : 1
         * url : /fore/mine/memberApply
         */

        private String icon;
        private String menuid;
        private String menuname;
        private String menupid;
        private String name;
        private int no;
        private String url;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getMenuid() {
            return menuid;
        }

        public void setMenuid(String menuid) {
            this.menuid = menuid;
        }

        public String getMenuname() {
            return menuname;
        }

        public void setMenuname(String menuname) {
            this.menuname = menuname;
        }

        public String getMenupid() {
            return menupid;
        }

        public void setMenupid(String menupid) {
            this.menupid = menupid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class 合同管理Bean {
        /**
         * icon :
         * menuid : 0601
         * menuname : 购买合同
         * menupid : 06
         * name : ORDER_BUY
         * no : 18
         * url : /fore/mine/buyOrders
         */

        private String icon;
        private String menuid;
        private String menuname;
        private String menupid;
        private String name;
        private int no;
        private String url;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getMenuid() {
            return menuid;
        }

        public void setMenuid(String menuid) {
            this.menuid = menuid;
        }

        public String getMenuname() {
            return menuname;
        }

        public void setMenuname(String menuname) {
            this.menuname = menuname;
        }

        public String getMenupid() {
            return menupid;
        }

        public void setMenupid(String menupid) {
            this.menupid = menupid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class 支付管理Bean {
        /**
         * icon :
         * menuid : 0701
         * menuname : 支付密码
         * menupid : 07
         * name : PAYMENT_PAYPWD
         * no : 22
         * url : /fore/login/payPassword
         */

        private String icon;
        private String menuid;
        private String menuname;
        private String menupid;
        private String name;
        private int no;
        private String url;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getMenuid() {
            return menuid;
        }

        public void setMenuid(String menuid) {
            this.menuid = menuid;
        }

        public String getMenuname() {
            return menuname;
        }

        public void setMenuname(String menuname) {
            this.menuname = menuname;
        }

        public String getMenupid() {
            return menupid;
        }

        public void setMenupid(String menupid) {
            this.menupid = menupid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class 诚信档案Bean {
        /**
         * icon :
         * menuid : 0401
         * menuname : 自己上传的档案
         * menupid : 04
         * name : ARCHIVE_SELF
         * no : 10
         * url : /fore/mine/archives
         */

        private String icon;
        private String menuid;
        private String menuname;
        private String menupid;
        private String name;
        private int no;
        private String url;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getMenuid() {
            return menuid;
        }

        public void setMenuid(String menuid) {
            this.menuid = menuid;
        }

        public String getMenuname() {
            return menuname;
        }

        public void setMenuname(String menuname) {
            this.menuname = menuname;
        }

        public String getMenupid() {
            return menupid;
        }

        public void setMenupid(String menupid) {
            this.menupid = menupid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class 项目发布Bean {
        /**
         * icon :
         * menuid : 0501
         * menuname : 我发布的项目
         * menupid : 05
         * name : PROJECT_RELEASE
         * no : 15
         * url : /fore/myItem/items
         */

        private String icon;
        private String menuid;
        private String menuname;
        private String menupid;
        private String name;
        private int no;
        private String url;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getMenuid() {
            return menuid;
        }

        public void setMenuid(String menuid) {
            this.menuid = menuid;
        }

        public String getMenuname() {
            return menuname;
        }

        public void setMenuname(String menuname) {
            this.menuname = menuname;
        }

        public String getMenupid() {
            return menupid;
        }

        public void setMenupid(String menupid) {
            this.menupid = menupid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}

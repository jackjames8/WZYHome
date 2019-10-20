package com.WZYHome.Study.Demo;

import android.app.Activity;

/**
 * Created by Administrator on 2017/7/10.
 */

public class until extends Activity {
   public static final String MyService="MyService";

    public static final String myMenu="{\n" +
            "            \"个人信息\": [\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0201\",\n" +
            "                    \"menuname\": \"帐号信息修改\",\n" +
            "                    \"menupid\": \"02\",\n" +
            "                    \"name\": \"PERSON_ACCOUNT\",\n" +
            "                    \"no\": 4,\n" +
            "                    \"url\": \"/fore/mine/person\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0202\",\n" +
            "                    \"menuname\": \"重置密码\",\n" +
            "                    \"menupid\": \"02\",\n" +
            "                    \"name\": \"PERSON_FINDPWD\",\n" +
            "                    \"no\": 5,\n" +
            "                    \"url\": \"/fore/login/findPassword\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"企业信息\": [\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0301\",\n" +
            "                    \"menuname\": \"企业基本信息\",\n" +
            "                    \"menupid\": \"03\",\n" +
            "                    \"name\": \"ENTERPRISE_INFO\",\n" +
            "                    \"no\": 7,\n" +
            "                    \"url\": \"/fore/mine/enterprise\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0301\",\n" +
            "                    \"menuname\": \"企业网站发布\",\n" +
            "                    \"menupid\": \"03\",\n" +
            "                    \"name\": \"ENTERPRISE_SITE\",\n" +
            "                    \"no\": 8,\n" +
            "                    \"url\": \"/fore/mine/site\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"入会申请\": [\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0101\",\n" +
            "                    \"menuname\": \"填写入会申请资料\",\n" +
            "                    \"menupid\": \"01\",\n" +
            "                    \"name\": \"MEMBER_APPLY\",\n" +
            "                    \"no\": 1,\n" +
            "                    \"url\": \"/fore/mine/memberApply\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0102\",\n" +
            "                    \"menuname\": \"查看入会申请表\",\n" +
            "                    \"menupid\": \"01\",\n" +
            "                    \"name\": \"MEMBER_APPLYTABLE\",\n" +
            "                    \"no\": 2,\n" +
            "                    \"url\": \"/fore/mine/memberApplyTable\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"合同管理\": [\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0601\",\n" +
            "                    \"menuname\": \"购买合同\",\n" +
            "                    \"menupid\": \"06\",\n" +
            "                    \"name\": \"ORDER_BUY\",\n" +
            "                    \"no\": 18,\n" +
            "                    \"url\": \"/fore/mine/buyOrders\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0602\",\n" +
            "                    \"menuname\": \"销售合同\",\n" +
            "                    \"menupid\": \"06\",\n" +
            "                    \"name\": \"ORDER_SELLER\",\n" +
            "                    \"no\": 19,\n" +
            "                    \"url\": \"/fore/mine/sellerOrders\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0603\",\n" +
            "                    \"menuname\": \"投诉\",\n" +
            "                    \"menupid\": \"06\",\n" +
            "                    \"name\": \"ORDER_COMPLAIN\",\n" +
            "                    \"no\": 20,\n" +
            "                    \"url\": \"/fore/mine/orderComplaintList\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"支付管理\": [\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0701\",\n" +
            "                    \"menuname\": \"支付密码\",\n" +
            "                    \"menupid\": \"07\",\n" +
            "                    \"name\": \"PAYMENT_PAYPWD\",\n" +
            "                    \"no\": 22,\n" +
            "                    \"url\": \"/fore/login/payPassword\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0702\",\n" +
            "                    \"menuname\": \"会员费\",\n" +
            "                    \"menupid\": \"07\",\n" +
            "                    \"name\": \"PAYMENT_MEMFEE\",\n" +
            "                    \"no\": 23,\n" +
            "                    \"url\": \"/fore/mine/memberFee\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0703\",\n" +
            "                    \"menuname\": \"价值币\",\n" +
            "                    \"menupid\": \"07\",\n" +
            "                    \"name\": \"PAYMENT_WALLET\",\n" +
            "                    \"no\": 24,\n" +
            "                    \"url\": \"/fore/mine/wallet\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"诚信档案\": [\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0401\",\n" +
            "                    \"menuname\": \"自己上传的档案\",\n" +
            "                    \"menupid\": \"04\",\n" +
            "                    \"name\": \"ARCHIVE_SELF\",\n" +
            "                    \"no\": 10,\n" +
            "                    \"url\": \"/fore/mine/archives\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0402\",\n" +
            "                    \"menuname\": \"联络处发布档案\",\n" +
            "                    \"menupid\": \"04\",\n" +
            "                    \"name\": \"ARCHIVE_LIAISON\",\n" +
            "                    \"no\": 11,\n" +
            "                    \"url\": \"/fore/mine/liaisonArchives\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0403\",\n" +
            "                    \"menuname\": \"交易被评价档案\",\n" +
            "                    \"menupid\": \"04\",\n" +
            "                    \"name\": \"ARCHIVE_EVALUATE\",\n" +
            "                    \"no\": 12,\n" +
            "                    \"url\": \"/fore/mine/evalArchives\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0404\",\n" +
            "                    \"menuname\": \"交易被投诉档案\",\n" +
            "                    \"menupid\": \"04\",\n" +
            "                    \"name\": \"ARCHIVE_COMPLAIN\",\n" +
            "                    \"no\": 13,\n" +
            "                    \"url\": \"/fore/mine/compArchives\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"项目发布\": [\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0501\",\n" +
            "                    \"menuname\": \"我发布的项目\",\n" +
            "                    \"menupid\": \"05\",\n" +
            "                    \"name\": \"PROJECT_RELEASE\",\n" +
            "                    \"no\": 15,\n" +
            "                    \"url\": \"/fore/myItem/items\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"icon\": \"\",\n" +
            "                    \"menuid\": \"0502\",\n" +
            "                    \"menuname\": \"项目收藏夹\",\n" +
            "                    \"menupid\": \"05\",\n" +
            "                    \"name\": \"PROJECT_FAVORITE\",\n" +
            "                    \"no\": 16,\n" +
            "                    \"url\": \"/fore/mine/favorite\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }";



    public static final String ReturnValue="[\n" +
            "    {\n" +
            "        \"LoadCapacity\": 2.8,\n" +
            "        \"LoadHeight\": 1.2,\n" +
            "        \"LoadLength\": 1.8,\n" +
            "        \"LoadWeight\": 0.5,\n" +
            "        \"LoadWidth\": 1.3,\n" +
            "        \"SpecialSpecItems\": [\n" +
            "            {\n" +
            "                \"SpecialSpec\": \"RemoveAllSeats\",\n" +
            "                \"SpecialSpecName\": \"全拆座\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"VehicleImageUrl\": \"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150346Ie2bd0a25729248adb04c6b27bd5e4496\",\n" +
            "        \"VehicleTypeInfoCode\": \"VMS2017090517131888a078cae0a34cba981d657842e850ab\",\n" +
            "        \"VehicleTypeName\": \"小面包车\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"LoadCapacity\": 4.5,\n" +
            "        \"LoadHeight\": 1.2,\n" +
            "        \"LoadLength\": 2.7,\n" +
            "        \"LoadWeight\": 1,\n" +
            "        \"LoadWidth\": 1.4,\n" +
            "        \"SpecialSpecItems\": [],\n" +
            "        \"VehicleImageUrl\": \"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150155I2851a5e5f1df4e93b93e041e35f6460c\",\n" +
            "        \"VehicleTypeInfoCode\": \"VMS20170905171417efbe83fcaadb4ac98fdf980475dccef0\",\n" +
            "        \"VehicleTypeName\": \"中面包车\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"LoadCapacity\": 6.1,\n" +
            "        \"LoadHeight\": 1.5,\n" +
            "        \"LoadLength\": 2.7,\n" +
            "        \"LoadWeight\": 1,\n" +
            "        \"LoadWidth\": 1.5,\n" +
            "        \"SpecialSpecItems\": [],\n" +
            "        \"VehicleImageUrl\": \"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150712Ic360a814652f4062aeff018791d0dec5\",\n" +
            "        \"VehicleTypeInfoCode\": \"VMS20170906102724882967ef11dd458588eb7df1957f8009\",\n" +
            "        \"VehicleTypeName\": \"小货车\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"LoadCapacity\": 6.9,\n" +
            "        \"LoadHeight\": 1.7,\n" +
            "        \"LoadLength\": 2.7,\n" +
            "        \"LoadWeight\": 1,\n" +
            "        \"LoadWidth\": 1.5,\n" +
            "        \"SpecialSpecItems\": [],\n" +
            "        \"VehicleImageUrl\": \"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150712Ic360a814652f4062aeff018791d0dec5\",\n" +
            "        \"VehicleTypeInfoCode\": \"VMS2017090611252576ffa7c98fc44ca59bb1f00ef10607dc\",\n" +
            "        \"VehicleTypeName\": \"小型厢货\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"LoadCapacity\": 5.7,\n" +
            "        \"LoadHeight\": 1.6,\n" +
            "        \"LoadLength\": 2.1,\n" +
            "        \"LoadWeight\": 1,\n" +
            "        \"LoadWidth\": 1.7,\n" +
            "        \"SpecialSpecItems\": [],\n" +
            "        \"VehicleImageUrl\": \"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906151001I5115fa8a21264ca985ef95f108482954\",\n" +
            "        \"VehicleTypeInfoCode\": \"VMS201709061128172e90c6c861e04390aa02a0d003c25441\",\n" +
            "        \"VehicleTypeName\": \"小型平板\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"LoadCapacity\": 13.6,\n" +
            "        \"LoadHeight\": 1.8,\n" +
            "        \"LoadLength\": 4.2,\n" +
            "        \"LoadWeight\": 1.8,\n" +
            "        \"LoadWidth\": 1.8,\n" +
            "        \"SpecialSpecItems\": [\n" +
            "            {\n" +
            "                \"SpecialSpec\": \"TailBoard\",\n" +
            "                \"SpecialSpecName\": \"车辆尾板\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"VehicleImageUrl\": \"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906151001I5115fa8a21264ca985ef95f108482954\",\n" +
            "        \"VehicleTypeInfoCode\": \"VMS20170906112952d9096c5ae36c4e5181c2b32c8f6fd595\",\n" +
            "        \"VehicleTypeName\": \"中货车\"\n" +
            "    }\n" +
            "]";



    public static final String url="{\n" +
            "    \"ErrorInfo\": {\n" +
            "        \"Status\": false,\n" +
            "        \"Message\": \"\",\n" +
            "        \"Category\": \"\"\n" +
            "    },\n" +
            "    \"ReturnValue\": [\n" +
            "        {\n" +
            "            \"VehicleTypeInfoCode\": \"VMS2017090517131888a078cae0a34cba981d657842e850ab\",\n" +
            "            \"VehicleTypeName\": \"小面包车\",\n" +
            "            \"LoadLength\": 1.8,\n" +
            "            \"LoadWidth\": 1.3,\n" +
            "            \"LoadHeight\": 1.2,\n" +
            "            \"LoadCapacity\": 2.8,\n" +
            "            \"LoadWeight\": 0.5,\n" +
            "            \"VehicleImageUrl\": \"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150346Ie2bd0a25729248adb04c6b27bd5e4496\",\n" +
            "            \"SpecialSpecItems\": [\n" +
            "                {\n" +
            "                    \"SpecialSpec\": \"RemoveAllSeats\",\n" +
            "                    \"SpecialSpecName\": \"全拆座\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"VehicleTypeInfoCode\": \"VMS20170905171417efbe83fcaadb4ac98fdf980475dccef0\",\n" +
            "            \"VehicleTypeName\": \"中面包车\",\n" +
            "            \"LoadLength\": 2.7,\n" +
            "            \"LoadWidth\": 1.4,\n" +
            "            \"LoadHeight\": 1.2,\n" +
            "            \"LoadCapacity\": 4.5,\n" +
            "            \"LoadWeight\": 1,\n" +
            "            \"VehicleImageUrl\": \"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150155I2851a5e5f1df4e93b93e041e35f6460c\",\n" +
            "            \"SpecialSpecItems\": []\n" +
            "        },\n" +
            "        {\n" +
            "            \"VehicleTypeInfoCode\": \"VMS20170906102724882967ef11dd458588eb7df1957f8009\",\n" +
            "            \"VehicleTypeName\": \"小货车\",\n" +
            "            \"LoadLength\": 2.7,\n" +
            "            \"LoadWidth\": 1.5,\n" +
            "            \"LoadHeight\": 1.5,\n" +
            "            \"LoadCapacity\": 6.1,\n" +
            "            \"LoadWeight\": 1,\n" +
            "            \"VehicleImageUrl\": \"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150712Ic360a814652f4062aeff018791d0dec5\",\n" +
            "            \"SpecialSpecItems\": []\n" +
            "        },\n" +
            "        {\n" +
            "            \"VehicleTypeInfoCode\": \"VMS2017090611252576ffa7c98fc44ca59bb1f00ef10607dc\",\n" +
            "            \"VehicleTypeName\": \"小型厢货\",\n" +
            "            \"LoadLength\": 2.7,\n" +
            "            \"LoadWidth\": 1.5,\n" +
            "            \"LoadHeight\": 1.7,\n" +
            "            \"LoadCapacity\": 6.9,\n" +
            "            \"LoadWeight\": 1,\n" +
            "            \"VehicleImageUrl\": \"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150712Ic360a814652f4062aeff018791d0dec5\",\n" +
            "            \"SpecialSpecItems\": []\n" +
            "        },\n" +
            "        {\n" +
            "            \"VehicleTypeInfoCode\": \"VMS201709061128172e90c6c861e04390aa02a0d003c25441\",\n" +
            "            \"VehicleTypeName\": \"小型平板\",\n" +
            "            \"LoadLength\": 2.1,\n" +
            "            \"LoadWidth\": 1.7,\n" +
            "            \"LoadHeight\": 1.6,\n" +
            "            \"LoadCapacity\": 5.7,\n" +
            "            \"LoadWeight\": 1,\n" +
            "            \"VehicleImageUrl\": \"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906151001I5115fa8a21264ca985ef95f108482954\",\n" +
            "            \"SpecialSpecItems\": []\n" +
            "        },\n" +
            "        {\n" +
            "            \"VehicleTypeInfoCode\": \"VMS20170906112952d9096c5ae36c4e5181c2b32c8f6fd595\",\n" +
            "            \"VehicleTypeName\": \"中货车\",\n" +
            "            \"LoadLength\": 4.2,\n" +
            "            \"LoadWidth\": 1.8,\n" +
            "            \"LoadHeight\": 1.8,\n" +
            "            \"LoadCapacity\": 13.6,\n" +
            "            \"LoadWeight\": 1.8,\n" +
            "            \"VehicleImageUrl\": \"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906151001I5115fa8a21264ca985ef95f108482954\",\n" +
            "            \"SpecialSpecItems\": [\n" +
            "                {\n" +
            "                    \"SpecialSpec\": \"TailBoard\",\n" +
            "                    \"SpecialSpecName\": \"车辆尾板\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}

package com.WZYHome.Study.Demo;

import android.app.Activity;

/**
 * Created by Administrator on 2017/7/10.
 */

public class until extends Activity {
   public static final String MyService="MyService";
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

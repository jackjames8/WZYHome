package com.WZYHome.Study.Demo.Unit13_NetWork.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */

public class VehicleTypeInfo {

    @Override
    public String toString() {
        return "VehicleTypeInfo{" +
                "ErrorInfo=" + ErrorInfo +
                ", ReturnValue=" + ReturnValue +
                '}';
    }
    /**
     * ErrorInfo : {"Category":"","Message":"","Status":false}
     * ReturnValue : [{"LoadCapacity":2.8,"LoadHeight":1.2,"LoadLength":1.8,"LoadWeight":0.5,"LoadWidth":1.3,"SpecialSpecItems":[{"SpecialSpec":"RemoveAllSeats","SpecialSpecName":"全拆座"}],"VehicleImageUrl":"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150346Ie2bd0a25729248adb04c6b27bd5e4496","VehicleTypeInfoCode":"VMS2017090517131888a078cae0a34cba981d657842e850ab","VehicleTypeName":"小面包车"},{"LoadCapacity":4.5,"LoadHeight":1.2,"LoadLength":2.7,"LoadWeight":1,"LoadWidth":1.4,"SpecialSpecItems":[],"VehicleImageUrl":"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150155I2851a5e5f1df4e93b93e041e35f6460c","VehicleTypeInfoCode":"VMS20170905171417efbe83fcaadb4ac98fdf980475dccef0","VehicleTypeName":"中面包车"},{"LoadCapacity":6.1,"LoadHeight":1.5,"LoadLength":2.7,"LoadWeight":1,"LoadWidth":1.5,"SpecialSpecItems":[],"VehicleImageUrl":"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150712Ic360a814652f4062aeff018791d0dec5","VehicleTypeInfoCode":"VMS20170906102724882967ef11dd458588eb7df1957f8009","VehicleTypeName":"小货车"},{"LoadCapacity":6.9,"LoadHeight":1.7,"LoadLength":2.7,"LoadWeight":1,"LoadWidth":1.5,"SpecialSpecItems":[],"VehicleImageUrl":"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150712Ic360a814652f4062aeff018791d0dec5","VehicleTypeInfoCode":"VMS2017090611252576ffa7c98fc44ca59bb1f00ef10607dc","VehicleTypeName":"小型厢货"},{"LoadCapacity":5.7,"LoadHeight":1.6,"LoadLength":2.1,"LoadWeight":1,"LoadWidth":1.7,"SpecialSpecItems":[],"VehicleImageUrl":"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906151001I5115fa8a21264ca985ef95f108482954","VehicleTypeInfoCode":"VMS201709061128172e90c6c861e04390aa02a0d003c25441","VehicleTypeName":"小型平板"},{"LoadCapacity":13.6,"LoadHeight":1.8,"LoadLength":4.2,"LoadWeight":1.8,"LoadWidth":1.8,"SpecialSpecItems":[{"SpecialSpec":"TailBoard","SpecialSpecName":"车辆尾板"}],"VehicleImageUrl":"http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906151001I5115fa8a21264ca985ef95f108482954","VehicleTypeInfoCode":"VMS20170906112952d9096c5ae36c4e5181c2b32c8f6fd595","VehicleTypeName":"中货车"}]
     */

    private ErrorInfoBean ErrorInfo;
    private List<ReturnValueBean> ReturnValue;

    public ErrorInfoBean getErrorInfo() {
        return ErrorInfo;
    }

    public void setErrorInfo(ErrorInfoBean ErrorInfo) {
        this.ErrorInfo = ErrorInfo;
    }

    public List<ReturnValueBean> getReturnValue() {
        return ReturnValue;
    }

    public void setReturnValue(List<ReturnValueBean> ReturnValue) {
        this.ReturnValue = ReturnValue;
    }

    public static class ErrorInfoBean {
        @Override
        public String toString() {
            return "ErrorInfoBean{" +
                    "Category='" + Category + '\'' +
                    ", Message='" + Message + '\'' +
                    ", Status=" + Status +
                    '}';
        }

        public ErrorInfoBean() {
        }

        public ErrorInfoBean(String category, String message, boolean status) {
            Category = category;
            Message = message;
            Status = status;
        }

        /**
         * Category :
         * Message :
         * Status : false
         */

        private String Category;
        private String Message;
        private boolean Status;

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
    }

    public static class ReturnValueBean {
        public ReturnValueBean() {
        }

        @Override
        public String toString() {
            return "ReturnValueBean{" +
                    "LoadCapacity=" + LoadCapacity +
                    ", LoadHeight=" + LoadHeight +
                    ", LoadLength=" + LoadLength +
                    ", LoadWeight=" + LoadWeight +
                    ", LoadWidth=" + LoadWidth +
                    ", VehicleImageUrl='" + VehicleImageUrl + '\'' +
                    ", VehicleTypeInfoCode='" + VehicleTypeInfoCode + '\'' +
                    ", VehicleTypeName='" + VehicleTypeName + '\'' +
                    ", SpecialSpecItems=" + SpecialSpecItems +
                    '}';
        }

        public ReturnValueBean(double loadCapacity, double loadHeight, double loadLength, double loadWeight, double loadWidth, String vehicleImageUrl, String vehicleTypeInfoCode, String vehicleTypeName, List<SpecialSpecItemsBean> specialSpecItems) {
            LoadCapacity = loadCapacity;
            LoadHeight = loadHeight;
            LoadLength = loadLength;
            LoadWeight = loadWeight;
            LoadWidth = loadWidth;
            VehicleImageUrl = vehicleImageUrl;
            VehicleTypeInfoCode = vehicleTypeInfoCode;
            VehicleTypeName = vehicleTypeName;
            SpecialSpecItems = specialSpecItems;
        }

        /**
         * LoadCapacity : 2.8
         * LoadHeight : 1.2
         * LoadLength : 1.8
         * LoadWeight : 0.5
         * LoadWidth : 1.3
         * SpecialSpecItems : [{"SpecialSpec":"RemoveAllSeats","SpecialSpecName":"全拆座"}]
         * VehicleImageUrl : http://39.108.161.138:9859/BaseFMS/api/image/?ic=FMS20170906150346Ie2bd0a25729248adb04c6b27bd5e4496
         * VehicleTypeInfoCode : VMS2017090517131888a078cae0a34cba981d657842e850ab
         * VehicleTypeName : 小面包车
         */

        private double LoadCapacity;
        private double LoadHeight;
        private double LoadLength;
        private double LoadWeight;
        private double LoadWidth;
        private String VehicleImageUrl;
        private String VehicleTypeInfoCode;
        private String VehicleTypeName;
        private List<SpecialSpecItemsBean> SpecialSpecItems;

        public double getLoadCapacity() {
            return LoadCapacity;
        }

        public void setLoadCapacity(double LoadCapacity) {
            this.LoadCapacity = LoadCapacity;
        }

        public double getLoadHeight() {
            return LoadHeight;
        }

        public void setLoadHeight(double LoadHeight) {
            this.LoadHeight = LoadHeight;
        }

        public double getLoadLength() {
            return LoadLength;
        }

        public void setLoadLength(double LoadLength) {
            this.LoadLength = LoadLength;
        }

        public double getLoadWeight() {
            return LoadWeight;
        }

        public void setLoadWeight(double LoadWeight) {
            this.LoadWeight = LoadWeight;
        }

        public double getLoadWidth() {
            return LoadWidth;
        }

        public void setLoadWidth(double LoadWidth) {
            this.LoadWidth = LoadWidth;
        }

        public String getVehicleImageUrl() {
            return VehicleImageUrl;
        }

        public void setVehicleImageUrl(String VehicleImageUrl) {
            this.VehicleImageUrl = VehicleImageUrl;
        }

        public String getVehicleTypeInfoCode() {
            return VehicleTypeInfoCode;
        }

        public void setVehicleTypeInfoCode(String VehicleTypeInfoCode) {
            this.VehicleTypeInfoCode = VehicleTypeInfoCode;
        }

        public String getVehicleTypeName() {
            return VehicleTypeName;
        }

        public void setVehicleTypeName(String VehicleTypeName) {
            this.VehicleTypeName = VehicleTypeName;
        }

        public List<SpecialSpecItemsBean> getSpecialSpecItems() {
            return SpecialSpecItems;
        }

        public void setSpecialSpecItems(List<SpecialSpecItemsBean> SpecialSpecItems) {
            this.SpecialSpecItems = SpecialSpecItems;
        }

        public static class SpecialSpecItemsBean {
            public SpecialSpecItemsBean() {
            }

            @Override
            public String toString() {
                return "SpecialSpecItemsBean{" +
                        "SpecialSpec='" + SpecialSpec + '\'' +
                        ", SpecialSpecName='" + SpecialSpecName + '\'' +
                        '}';
            }

            /**
             * SpecialSpec : RemoveAllSeats
             * SpecialSpecName : 全拆座
             */

            private String SpecialSpec;
            private String SpecialSpecName;

            public String getSpecialSpec() {
                return SpecialSpec;
            }

            public void setSpecialSpec(String SpecialSpec) {
                this.SpecialSpec = SpecialSpec;
            }

            public String getSpecialSpecName() {
                return SpecialSpecName;
            }

            public void setSpecialSpecName(String SpecialSpecName) {
                this.SpecialSpecName = SpecialSpecName;
            }
        }
    }
}

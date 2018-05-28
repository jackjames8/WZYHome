package com.WZYHome.Study.Demo.Unit13_NetWork.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */

public class ReturnValue {
    @Override
    public String toString() {
        return "ReturnValue{" +
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

    public ReturnValue(double loadCapacity, double loadHeight, double loadLength, double loadWeight, double loadWidth, String vehicleImageUrl, String vehicleTypeInfoCode, String vehicleTypeName, List<SpecialSpecItemsBean> specialSpecItems) {
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

        @Override
        public String toString() {
            return "SpecialSpecItemsBean{" +
                    "SpecialSpec='" + SpecialSpec + '\'' +
                    ", SpecialSpecName='" + SpecialSpecName + '\'' +
                    '}';
        }
    }
}

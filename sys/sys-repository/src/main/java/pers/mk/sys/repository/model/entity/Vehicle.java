package pers.mk.sys.repository.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 车辆信息表
 * </p>
 *
 * @author wwq
 * @since 2022-04-11
 */
@TableName("vehicle")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * vehicleSid
     */
    @TableField("sid")
    private String sid;

    /**
     * vin码
     */
    @TableField("vin_code")
    private String vinCode;

    /**
     * 品牌
     */
    @TableField("brand")
    private String brand;

    /**
     * 编号，格式：年月日时分+两位随机数，例如：20140627093601
     */
    @TableField("`code`")
    private String code;

    /**
     * 车系:途安
     */
    @TableField("brand_series")
    private String brandSeries;

    /**
     * 销售名称
     */
    @TableField("selled_name")
    private String selledName;

    /**
     * 车辆名称
     */
    @TableField("vehicle_name")
    private String vehicleName;

    /**
     * 车型:途安
     */
    @TableField("vehicle_model")
    private String vehicleModel;

    /**
     * 年款
     */
    @TableField("model_year")
    private String modelYear;

    /**
     * 是否上牌
     */
    @TableField("is_vehicle_card")
    private Boolean vehicleCard;

    /**
     * 上牌日期
     */
    @TableField("register_license_years")
    private String registerLicenseYears;

    /**
     * 排量
     */
    @TableField("swept_volume")
    private BigDecimal sweptVolume;

    /**
     * 排量类型（L、T）
     */
    @TableField("swept_volume_type")
    private String sweptVolumeType;

    /**
     * 排量标准/环保标准
     */
    @TableField("swept_volume_standard")
    private String sweptVolumeStandard;

    /**
     * 上牌省份
     */
    @TableField("register_province")
    private String registerProvince;

    /**
     * 上牌城市
     */
    @TableField("register_city")
    private String registerCity;

    /**
     * 车辆所在省份
     */
    @TableField("current_province")
    private String currentProvince;

    /**
     * 车辆所在城市
     */
    @TableField("current_city")
    private String currentCity;

    /**
     * 车牌号
     */
    @TableField("license_code")
    private String licenseCode;

    /**
     * 车辆颜色
     */
    @TableField("body_color")
    private String bodyColor;

    /**
     * 表显里程是否清晰
     */
    @TableField("is_clear_display_mileage")
    private Boolean clearDisplayMileage;

    /**
     * 表显里程 单位：公里
     */
    @TableField("display_mileage")
    private BigDecimal displayMileage;

    /**
     * 车型分类：轿车、SUV、MPV、跑车、商务车
     */
    @TableField("vehicle_type")
    private String vehicleType;

    /**
     * 起拍价
     */
    @TableField("start_bid_price")
    private BigDecimal startBidPrice;

    /**
     * 保留价
     */
    @TableField("reserve_price")
    private BigDecimal reservePrice;

    /**
     * 新车指导价
     */
    @TableField("new_vehicle_suggestion_price")
    private BigDecimal newVehicleSuggestionPrice;

    /**
     * 0拍卖 1 展厅
     */
    @TableField("requirement_type")
    private Boolean requirementType;

    /**
     * 来源：电脑，ipad,av(临时拍品)
     */
    @TableField("`source`")
    private String source;

    /**
     * 销售状态：0、待售；1、 出售中；2、已出售
     */
    @TableField("sale_status")
    private Integer saleStatus;

    /**
     * 车辆性质：评估、置换、退役试驾车、收购、退役公务车
     */
    @TableField("vehicle_ppe")
    private String vehiclePpe;

    /**
     * 评估师ID
     */
    @TableField("appraiser_id")
    private Integer appraiserId;

    /**
     * 评估师
     */
    @TableField("vehicle_appraiser")
    private String vehicleAppraiser;

    /**
     * 评估部门ID
     */
    @TableField("eval_org_id")
    private Integer evalOrgId;

    /**
     * 评估部门
     */
    @TableField("evaluation_dept")
    private String evaluationDept;

    /**
     * 车辆45度照片
     */
    @TableField("first_photo_url")
    private String firstPhotoUrl;

    /**
     * 车辆描述
     */
    @TableField("vehicle_desc")
    private String vehicleDesc;

    /**
     * 车辆来源类型：1集团客户 2大客户 3 个人
     */
    @TableField("vehicle_src_type")
    private Integer vehicleSrcType;

    /**
     * membersid或organizationsid，根据vehicle_src_type的值区分，集团客户为organizationsid，大客户和个人为membersid
     */
    @TableField("vehicle_src_id")
    private Integer vehicleSrcId;

    /**
     * 是否认证二手车
     */
    @TableField("is_certified")
    private Boolean certified;

    /**
     * 是否质保二手车
     */
    @TableField("is_guaranteed")
    private Boolean guaranteed;

    /**
     * 更新时间
     */
    @TableField("modify_time")
    private LocalDateTime modifyTime;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private LocalDateTime createdTime;

    /**
     * 审核标示，0 普通审核, 1 复审商家审核
     */
    @TableField("audit_flag")
    private Boolean auditFlag;

    /**
     * 商家是否定价，0 未定价, 1 已定价
     */
    @TableField("is_pricing")
    private Boolean pricing;

    /**
     * 是否需要评估（1：是；0：否）
     */
    @TableField("need_check")
    private Boolean needCheck;

    /**
     * 品牌ID
     */
    @TableField("brand_id")
    private String brandId;

    /**
     * 厂商Id
     */
    @TableField("manufacturer_id")
    private String manufacturerId;

    /**
     * 车系ID
     */
    @TableField("series_id")
    private String seriesId;

    /**
     * 车型ID
     */
    @TableField("model_id")
    private String modelId;

    /**
     * 品牌ID
     */
    @TableField("vd_brand_id")
    private Integer vdBrandId;

    /**
     * 厂商ID
     */
    @TableField("vd_manufacturer_id")
    private Integer vdManufacturerId;

    /**
     * 车系ID
     */
    @TableField("vd_series_id")
    private Integer vdSeriesId;

    /**
     * 车型ID
     */
    @TableField("vd_model_id")
    private Integer vdModelId;

    /**
     * 经销商id
     */
    @TableField("dealer_id")
    private Integer dealerId;

    /**
     * 车赢系统-车辆ID
     */
    @TableField("carid")
    private Integer carid;

    /**
     * 是否通知第三方平台成功:0未通知 1已通知
     */
    @TableField("is_notice")
    private Boolean notice;

    /**
     * eqs车辆状态(1：状态正常  2：VIN去重  3：审核不通过)
     */
    @TableField("eqs_status")
    private Integer eqsStatus;

    /**
     * 版本号
     */
    @TableField("version")
    private Integer version;

    /**
     * 骨架评星
     */
    @TableField("star_skeleton")
    private BigDecimal starSkeleton;

    /**
     * 内饰评星
     */
    @TableField("star_interior")
    private BigDecimal starInterior;

    /**
     * 外观评星
     */
    @TableField("star_facade")
    private BigDecimal starFacade;

    /**
     * 现所有人:个人、企业、租赁公司、出租公司
     */
    @TableField("owner_current")
    private String ownerCurrent;

    /**
     * 使用性质（运营，非运营）
     */
    @TableField("using_model")
    private String usingModel;

    /**
     * 特殊牌照
     */
    @TableField("special_license")
    private String specialLicense;

    /**
     * 有无报告（0：无报告，1：有报告）
     */
    @TableField("has_report_maintenance")
    private Boolean hasReportMaintenance;

    /**
     * 维保查询订单ID
     */
    @TableField("maintenance_id")
    private Integer maintenanceId;

    /**
     * 上架类型（1：EQS  2：BOS  3：third）
     */
    @TableField("up_type")
    private Integer upType;

    /**
     * 交易备注
     */
    @TableField("deal_remark")
    private String dealRemark;

    /**
     * 是否汽车街的评估报告（1：汽车街  0：第三方）
     */
    @TableField("autost_flag")
    private Boolean autostFlag;

    /**
     * 第三方评估报告链接
     */
    @TableField("report_url")
    private String reportUrl;

    /**
     * 商家收车价最小值
     */
    @TableField("dealer_buy_price_min")
    private BigDecimal dealerBuyPriceMin;

    /**
     * 商家销售价最小值
     */
    @TableField("dealer_price_min")
    private BigDecimal dealerPriceMin;

    /**
     * 估值id
     */
    @TableField("evaluate_id")
    private Integer evaluateId;

    /**
     * 车况等级  1：优秀 2：良好  3一般
     */
    @TableField("condition_Level")
    private Integer conditionLevel;

    /**
     * 出险id
     */
    @TableField("accident_id")
    private Integer accidentId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrandSeries() {
        return brandSeries;
    }

    public void setBrandSeries(String brandSeries) {
        this.brandSeries = brandSeries;
    }

    public String getSelledName() {
        return selledName;
    }

    public void setSelledName(String selledName) {
        this.selledName = selledName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public Boolean getVehicleCard() {
        return vehicleCard;
    }

    public void setVehicleCard(Boolean vehicleCard) {
        this.vehicleCard = vehicleCard;
    }

    public String getRegisterLicenseYears() {
        return registerLicenseYears;
    }

    public void setRegisterLicenseYears(String registerLicenseYears) {
        this.registerLicenseYears = registerLicenseYears;
    }

    public BigDecimal getSweptVolume() {
        return sweptVolume;
    }

    public void setSweptVolume(BigDecimal sweptVolume) {
        this.sweptVolume = sweptVolume;
    }

    public String getSweptVolumeType() {
        return sweptVolumeType;
    }

    public void setSweptVolumeType(String sweptVolumeType) {
        this.sweptVolumeType = sweptVolumeType;
    }

    public String getSweptVolumeStandard() {
        return sweptVolumeStandard;
    }

    public void setSweptVolumeStandard(String sweptVolumeStandard) {
        this.sweptVolumeStandard = sweptVolumeStandard;
    }

    public String getRegisterProvince() {
        return registerProvince;
    }

    public void setRegisterProvince(String registerProvince) {
        this.registerProvince = registerProvince;
    }

    public String getRegisterCity() {
        return registerCity;
    }

    public void setRegisterCity(String registerCity) {
        this.registerCity = registerCity;
    }

    public String getCurrentProvince() {
        return currentProvince;
    }

    public void setCurrentProvince(String currentProvince) {
        this.currentProvince = currentProvince;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public Boolean getClearDisplayMileage() {
        return clearDisplayMileage;
    }

    public void setClearDisplayMileage(Boolean clearDisplayMileage) {
        this.clearDisplayMileage = clearDisplayMileage;
    }

    public BigDecimal getDisplayMileage() {
        return displayMileage;
    }

    public void setDisplayMileage(BigDecimal displayMileage) {
        this.displayMileage = displayMileage;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public BigDecimal getStartBidPrice() {
        return startBidPrice;
    }

    public void setStartBidPrice(BigDecimal startBidPrice) {
        this.startBidPrice = startBidPrice;
    }

    public BigDecimal getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(BigDecimal reservePrice) {
        this.reservePrice = reservePrice;
    }

    public BigDecimal getNewVehicleSuggestionPrice() {
        return newVehicleSuggestionPrice;
    }

    public void setNewVehicleSuggestionPrice(BigDecimal newVehicleSuggestionPrice) {
        this.newVehicleSuggestionPrice = newVehicleSuggestionPrice;
    }

    public Boolean getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(Boolean requirementType) {
        this.requirementType = requirementType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getVehiclePpe() {
        return vehiclePpe;
    }

    public void setVehiclePpe(String vehiclePpe) {
        this.vehiclePpe = vehiclePpe;
    }

    public Integer getAppraiserId() {
        return appraiserId;
    }

    public void setAppraiserId(Integer appraiserId) {
        this.appraiserId = appraiserId;
    }

    public String getVehicleAppraiser() {
        return vehicleAppraiser;
    }

    public void setVehicleAppraiser(String vehicleAppraiser) {
        this.vehicleAppraiser = vehicleAppraiser;
    }

    public Integer getEvalOrgId() {
        return evalOrgId;
    }

    public void setEvalOrgId(Integer evalOrgId) {
        this.evalOrgId = evalOrgId;
    }

    public String getEvaluationDept() {
        return evaluationDept;
    }

    public void setEvaluationDept(String evaluationDept) {
        this.evaluationDept = evaluationDept;
    }

    public String getFirstPhotoUrl() {
        return firstPhotoUrl;
    }

    public void setFirstPhotoUrl(String firstPhotoUrl) {
        this.firstPhotoUrl = firstPhotoUrl;
    }

    public String getVehicleDesc() {
        return vehicleDesc;
    }

    public void setVehicleDesc(String vehicleDesc) {
        this.vehicleDesc = vehicleDesc;
    }

    public Integer getVehicleSrcType() {
        return vehicleSrcType;
    }

    public void setVehicleSrcType(Integer vehicleSrcType) {
        this.vehicleSrcType = vehicleSrcType;
    }

    public Integer getVehicleSrcId() {
        return vehicleSrcId;
    }

    public void setVehicleSrcId(Integer vehicleSrcId) {
        this.vehicleSrcId = vehicleSrcId;
    }

    public Boolean getCertified() {
        return certified;
    }

    public void setCertified(Boolean certified) {
        this.certified = certified;
    }

    public Boolean getGuaranteed() {
        return guaranteed;
    }

    public void setGuaranteed(Boolean guaranteed) {
        this.guaranteed = guaranteed;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Boolean getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Boolean auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Boolean getPricing() {
        return pricing;
    }

    public void setPricing(Boolean pricing) {
        this.pricing = pricing;
    }

    public Boolean getNeedCheck() {
        return needCheck;
    }

    public void setNeedCheck(Boolean needCheck) {
        this.needCheck = needCheck;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Integer getVdBrandId() {
        return vdBrandId;
    }

    public void setVdBrandId(Integer vdBrandId) {
        this.vdBrandId = vdBrandId;
    }

    public Integer getVdManufacturerId() {
        return vdManufacturerId;
    }

    public void setVdManufacturerId(Integer vdManufacturerId) {
        this.vdManufacturerId = vdManufacturerId;
    }

    public Integer getVdSeriesId() {
        return vdSeriesId;
    }

    public void setVdSeriesId(Integer vdSeriesId) {
        this.vdSeriesId = vdSeriesId;
    }

    public Integer getVdModelId() {
        return vdModelId;
    }

    public void setVdModelId(Integer vdModelId) {
        this.vdModelId = vdModelId;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Boolean getNotice() {
        return notice;
    }

    public void setNotice(Boolean notice) {
        this.notice = notice;
    }

    public Integer getEqsStatus() {
        return eqsStatus;
    }

    public void setEqsStatus(Integer eqsStatus) {
        this.eqsStatus = eqsStatus;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BigDecimal getStarSkeleton() {
        return starSkeleton;
    }

    public void setStarSkeleton(BigDecimal starSkeleton) {
        this.starSkeleton = starSkeleton;
    }

    public BigDecimal getStarInterior() {
        return starInterior;
    }

    public void setStarInterior(BigDecimal starInterior) {
        this.starInterior = starInterior;
    }

    public BigDecimal getStarFacade() {
        return starFacade;
    }

    public void setStarFacade(BigDecimal starFacade) {
        this.starFacade = starFacade;
    }

    public String getOwnerCurrent() {
        return ownerCurrent;
    }

    public void setOwnerCurrent(String ownerCurrent) {
        this.ownerCurrent = ownerCurrent;
    }

    public String getUsingModel() {
        return usingModel;
    }

    public void setUsingModel(String usingModel) {
        this.usingModel = usingModel;
    }

    public String getSpecialLicense() {
        return specialLicense;
    }

    public void setSpecialLicense(String specialLicense) {
        this.specialLicense = specialLicense;
    }

    public Boolean getHasReportMaintenance() {
        return hasReportMaintenance;
    }

    public void setHasReportMaintenance(Boolean hasReportMaintenance) {
        this.hasReportMaintenance = hasReportMaintenance;
    }

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public Integer getUpType() {
        return upType;
    }

    public void setUpType(Integer upType) {
        this.upType = upType;
    }

    public String getDealRemark() {
        return dealRemark;
    }

    public void setDealRemark(String dealRemark) {
        this.dealRemark = dealRemark;
    }

    public Boolean getAutostFlag() {
        return autostFlag;
    }

    public void setAutostFlag(Boolean autostFlag) {
        this.autostFlag = autostFlag;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public BigDecimal getDealerBuyPriceMin() {
        return dealerBuyPriceMin;
    }

    public void setDealerBuyPriceMin(BigDecimal dealerBuyPriceMin) {
        this.dealerBuyPriceMin = dealerBuyPriceMin;
    }

    public BigDecimal getDealerPriceMin() {
        return dealerPriceMin;
    }

    public void setDealerPriceMin(BigDecimal dealerPriceMin) {
        this.dealerPriceMin = dealerPriceMin;
    }

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Integer getConditionLevel() {
        return conditionLevel;
    }

    public void setConditionLevel(Integer conditionLevel) {
        this.conditionLevel = conditionLevel;
    }

    public Integer getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(Integer accidentId) {
        this.accidentId = accidentId;
    }

    public static final String ID = "id";

    public static final String SID = "sid";

    public static final String VIN_CODE = "vin_code";

    public static final String BRAND = "brand";

    public static final String CODE = "code";

    public static final String BRAND_SERIES = "brand_series";

    public static final String SELLED_NAME = "selled_name";

    public static final String VEHICLE_NAME = "vehicle_name";

    public static final String VEHICLE_MODEL = "vehicle_model";

    public static final String MODEL_YEAR = "model_year";

    public static final String IS_VEHICLE_CARD = "is_vehicle_card";

    public static final String REGISTER_LICENSE_YEARS = "register_license_years";

    public static final String SWEPT_VOLUME = "swept_volume";

    public static final String SWEPT_VOLUME_TYPE = "swept_volume_type";

    public static final String SWEPT_VOLUME_STANDARD = "swept_volume_standard";

    public static final String REGISTER_PROVINCE = "register_province";

    public static final String REGISTER_CITY = "register_city";

    public static final String CURRENT_PROVINCE = "current_province";

    public static final String CURRENT_CITY = "current_city";

    public static final String LICENSE_CODE = "license_code";

    public static final String BODY_COLOR = "body_color";

    public static final String IS_CLEAR_DISPLAY_MILEAGE = "is_clear_display_mileage";

    public static final String DISPLAY_MILEAGE = "display_mileage";

    public static final String VEHICLE_TYPE = "vehicle_type";

    public static final String START_BID_PRICE = "start_bid_price";

    public static final String RESERVE_PRICE = "reserve_price";

    public static final String NEW_VEHICLE_SUGGESTION_PRICE = "new_vehicle_suggestion_price";

    public static final String REQUIREMENT_TYPE = "requirement_type";

    public static final String SOURCE = "source";

    public static final String SALE_STATUS = "sale_status";

    public static final String VEHICLE_PPE = "vehicle_ppe";

    public static final String APPRAISER_ID = "appraiser_id";

    public static final String VEHICLE_APPRAISER = "vehicle_appraiser";

    public static final String EVAL_ORG_ID = "eval_org_id";

    public static final String EVALUATION_DEPT = "evaluation_dept";

    public static final String FIRST_PHOTO_URL = "first_photo_url";

    public static final String VEHICLE_DESC = "vehicle_desc";

    public static final String VEHICLE_SRC_TYPE = "vehicle_src_type";

    public static final String VEHICLE_SRC_ID = "vehicle_src_id";

    public static final String IS_CERTIFIED = "is_certified";

    public static final String IS_GUARANTEED = "is_guaranteed";

    public static final String MODIFY_TIME = "modify_time";

    public static final String CREATED_TIME = "created_time";

    public static final String AUDIT_FLAG = "audit_flag";

    public static final String IS_PRICING = "is_pricing";

    public static final String NEED_CHECK = "need_check";

    public static final String BRAND_ID = "brand_id";

    public static final String MANUFACTURER_ID = "manufacturer_id";

    public static final String SERIES_ID = "series_id";

    public static final String MODEL_ID = "model_id";

    public static final String VD_BRAND_ID = "vd_brand_id";

    public static final String VD_MANUFACTURER_ID = "vd_manufacturer_id";

    public static final String VD_SERIES_ID = "vd_series_id";

    public static final String VD_MODEL_ID = "vd_model_id";

    public static final String DEALER_ID = "dealer_id";

    public static final String CARID = "carid";

    public static final String IS_NOTICE = "is_notice";

    public static final String EQS_STATUS = "eqs_status";

    public static final String VERSION = "version";

    public static final String STAR_SKELETON = "star_skeleton";

    public static final String STAR_INTERIOR = "star_interior";

    public static final String STAR_FACADE = "star_facade";

    public static final String OWNER_CURRENT = "owner_current";

    public static final String USING_MODEL = "using_model";

    public static final String SPECIAL_LICENSE = "special_license";

    public static final String HAS_REPORT_MAINTENANCE = "has_report_maintenance";

    public static final String MAINTENANCE_ID = "maintenance_id";

    public static final String UP_TYPE = "up_type";

    public static final String DEAL_REMARK = "deal_remark";

    public static final String AUTOST_FLAG = "autost_flag";

    public static final String REPORT_URL = "report_url";

    public static final String DEALER_BUY_PRICE_MIN = "dealer_buy_price_min";

    public static final String DEALER_PRICE_MIN = "dealer_price_min";

    public static final String EVALUATE_ID = "evaluate_id";

    public static final String CONDITION_LEVEL = "condition_Level";

    public static final String ACCIDENT_ID = "accident_id";

    @Override
    public String toString() {
        return "Vehicle{" +
        "id=" + id +
        ", sid=" + sid +
        ", vinCode=" + vinCode +
        ", brand=" + brand +
        ", code=" + code +
        ", brandSeries=" + brandSeries +
        ", selledName=" + selledName +
        ", vehicleName=" + vehicleName +
        ", vehicleModel=" + vehicleModel +
        ", modelYear=" + modelYear +
        ", vehicleCard=" + vehicleCard +
        ", registerLicenseYears=" + registerLicenseYears +
        ", sweptVolume=" + sweptVolume +
        ", sweptVolumeType=" + sweptVolumeType +
        ", sweptVolumeStandard=" + sweptVolumeStandard +
        ", registerProvince=" + registerProvince +
        ", registerCity=" + registerCity +
        ", currentProvince=" + currentProvince +
        ", currentCity=" + currentCity +
        ", licenseCode=" + licenseCode +
        ", bodyColor=" + bodyColor +
        ", clearDisplayMileage=" + clearDisplayMileage +
        ", displayMileage=" + displayMileage +
        ", vehicleType=" + vehicleType +
        ", startBidPrice=" + startBidPrice +
        ", reservePrice=" + reservePrice +
        ", newVehicleSuggestionPrice=" + newVehicleSuggestionPrice +
        ", requirementType=" + requirementType +
        ", source=" + source +
        ", saleStatus=" + saleStatus +
        ", vehiclePpe=" + vehiclePpe +
        ", appraiserId=" + appraiserId +
        ", vehicleAppraiser=" + vehicleAppraiser +
        ", evalOrgId=" + evalOrgId +
        ", evaluationDept=" + evaluationDept +
        ", firstPhotoUrl=" + firstPhotoUrl +
        ", vehicleDesc=" + vehicleDesc +
        ", vehicleSrcType=" + vehicleSrcType +
        ", vehicleSrcId=" + vehicleSrcId +
        ", certified=" + certified +
        ", guaranteed=" + guaranteed +
        ", modifyTime=" + modifyTime +
        ", createdTime=" + createdTime +
        ", auditFlag=" + auditFlag +
        ", pricing=" + pricing +
        ", needCheck=" + needCheck +
        ", brandId=" + brandId +
        ", manufacturerId=" + manufacturerId +
        ", seriesId=" + seriesId +
        ", modelId=" + modelId +
        ", vdBrandId=" + vdBrandId +
        ", vdManufacturerId=" + vdManufacturerId +
        ", vdSeriesId=" + vdSeriesId +
        ", vdModelId=" + vdModelId +
        ", dealerId=" + dealerId +
        ", carid=" + carid +
        ", notice=" + notice +
        ", eqsStatus=" + eqsStatus +
        ", version=" + version +
        ", starSkeleton=" + starSkeleton +
        ", starInterior=" + starInterior +
        ", starFacade=" + starFacade +
        ", ownerCurrent=" + ownerCurrent +
        ", usingModel=" + usingModel +
        ", specialLicense=" + specialLicense +
        ", hasReportMaintenance=" + hasReportMaintenance +
        ", maintenanceId=" + maintenanceId +
        ", upType=" + upType +
        ", dealRemark=" + dealRemark +
        ", autostFlag=" + autostFlag +
        ", reportUrl=" + reportUrl +
        ", dealerBuyPriceMin=" + dealerBuyPriceMin +
        ", dealerPriceMin=" + dealerPriceMin +
        ", evaluateId=" + evaluateId +
        ", conditionLevel=" + conditionLevel +
        ", accidentId=" + accidentId +
        "}";
    }
}

package com.lamark.data.triyakom.constants;

public class Constants {

    public final  static  String REG = "REG";
    public final  static  String UNREG = "UNREG,OFF";

    //Proveedor de campañas adNetNov20

    public final  static String  operationSubs_AdNetNov20 = "S";
    public final  static String  operationDelivery_AdNetNov20 = "D";
    public final  static String paramTypeName = "type";
    public final  static String paramTypeValue = "mt";

    //pbp

    public static String USER_TYPE = "MSISDN";
    public static String PARTNER_PRODUCT_CODE_1RA_OPCION_PROD = "LM100MB3D";
    public static String PARTNER_PRODUCT_CODE_3RA_OPCION_PROD = "LM400MB3D";
    public static final String ZONE = "Asia/Jakarta";
    public static final String ZONE_LIMA = "America/Lima";
    public static final String INTEGRATOR_TRIYACOM = "TRY";
    public static final Integer STATUS_PRESENT_ACTIVE = 1;
    public static final Integer INTEGRATION_TYPE_IN_SUBSCRIPTION_TRIYACOM = 1;
    public static final Integer INTEGRATION_TYPE_IN_DELIVERY_TRIYACOM = 2;


    public static enum PbpOperators {

        OPERATOR_INDOSAT("IM3");

        private String operatorId;

        private PbpOperators(String i) {
            this.operatorId = i;
        }

        public String getOperatorId() {
            return this.operatorId;
        }

        public void setOperatorId(String operatorId) {
            this.operatorId = operatorId;
        }
    }

    //wap

    public static String SUFFIX_CAMPAIGN_MCS = "A";
    public static String SUFFIX_CAMPAIGN_INDOSAT = "B";
    public static String SUFFIX_CAMPAIGN_ADNETNOV20 = "C";
    public static String VALUE_DB_CAMPAIGN_MCS = "MCS";
    public static String VALUE_DB_CAMPAIGN_INDOSAT = "ISAT";
    public static String WITHOUT_TID = "without_tid";
    public static String WITH_TID = "with_tid";

    public  enum AttemptType {
        NORMAL, RETRY, RENEW
    }


    String MAGICEN1 = "MAGICEN1";
    String MAGICEN2 = "MAGICEN2";
    String MAGICEN3 = "MAGICEN3";
    String MAGICEN7 = "MAGICEN7";
    String MAGICEN30 = "MAGICEN30";
    String MAGICEN90 = "MAGICEN90";
    String JOBSDB = "JOBSDB";
    String JOBSDB1 = "JOBSDB1";
    String ME      = "ME";
    String ME1 = "ME1";
    String ME2 = "ME2";
    String ME_WAP      = "ME WAP";
    String HE1 = "HE1";
    String HE2 = "HE2";
    String ME_PRM= "ME PRM";
    String ME_PRM1 = "ME PRM1";
    String ME_PRM2 = "ME PRM2";
    String ME_PRM3 = "ME PRM3";


    public enum Channel {
        SMS,
        WAP,
        WEB,
        IVR,
        USSD,
        SAT,
        SIM,
        SISTINE,
        APP,
        APP2,
        WAP_STORE,
        OBD;

        private Channel() {
        }
    }


    public interface Keyword {

        String MAGICEN1 = "MAGICEN1";
        String MAGICEN2 = "MAGICEN2";
        String MAGICEN3 = "MAGICEN3";
        String MAGICEN7 = "MAGICEN7";
        String MAGICEN30 = "MAGICEN30";
        String MAGICEN90 = "MAGICEN90";
        String JOBSDB = "JOBSDB";
        String JOBSDB1 = "JOBSDB1";
        String ME      = "ME";
        String ME1 = "ME1";
        String ME2 = "ME2";
        String ME_WAP      = "ME WAP";
        String HE1 = "HE1";
        String HE2 = "HE2";
        String ME_PRM= "ME PRM";
        String ME_PRM1 = "ME PRM1";
        String ME_PRM2 = "ME PRM2";
        String ME_PRM3 = "ME PRM3";
    }

    public static String SHORTCODE_TRIYACOM = "93230";

}





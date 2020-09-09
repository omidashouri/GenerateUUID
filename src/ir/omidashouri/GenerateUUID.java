package ir.omidashouri;

public class GenerateUUID {

    public static void main(String[] args) {
        System.out.println(generatePublicId());
    }
    public static String generatePublicId(){
        PublicIdUtil publicIdUtil = new PublicIdUtil();
        return publicIdUtil.generateUniquePublicId();
    }
}

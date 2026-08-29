package week1.class_problems;

public class ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        StringBuilder sb = new StringBuilder();
        for (int i = customerName.length() - 1; i >= 0; i--) {
            sb.append(customerName.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String name = "Sunil";
        String reversed = reverseCustomerName(name);
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversed);
    }
}

package week1.assigment_problems;

public class WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        int maxQty = -1;
        String maxSection = "";
        int maxItemIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB +
                " | Status: " + status + " | Highest Quantity: " + maxQty +
                " (" + maxSection + ", Item " + maxItemIndex + ")");
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}

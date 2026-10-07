package week9.class_problems;

public class LibraryCatalogLookup {
    public static class Book {
        public final String isbn;
        public final String title;

        public Book(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    /**
     * Efficiently looks up a book title given its ISBN in a pre-sorted catalog.
     * Time Complexity: O(log n) via Binary Search.
     * Auxiliary Space Complexity: O(1).
     */
    public static String findBook(Book[] catalog, String targetIsbn) {
        if (catalog == null || catalog.length == 0 || targetIsbn == null) {
            return "Not Found";
        }

        int low = 0;
        int high = catalog.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = catalog[mid].isbn.compareTo(targetIsbn);

            if (cmp == 0) {
                return catalog[mid].title;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Book[] catalog = {
            new Book("0001112223", "Introduction to Algebra"),
            new Book("0002223334", "Beginning Python"),
            new Book("0003334445", "Classic Mythology"),
            new Book("0004445556", "Data and Society"),
            new Book("0005556667", "European History")
        };

        System.out.println("Example 1: " + findBook(catalog, "0003334445"));
        System.out.println("Example 2: " + findBook(catalog, "0009998887"));
    }
}

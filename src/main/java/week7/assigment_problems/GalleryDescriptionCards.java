package week7.assigment_problems;

public class GalleryDescriptionCards {
    public static abstract class ArtPiece {
        private static int counter = 0;
        private final int pieceId;
        protected String title;

        public ArtPiece(String title) {
            this.pieceId = ++counter;
            this.title = title;
        }

        public String getPieceId() {
            return "PIECE-" + pieceId;
        }

        public abstract String describe();
    }

    public static class Painting extends ArtPiece {
        public Painting(String title) {
            super(title);
        }

        @Override
        public String describe() {
            return "Painting: " + title + ", framed on canvas";
        }
    }

    public static class Sculpture extends ArtPiece {
        public Sculpture(String title) {
            super(title);
        }

        @Override
        public String describe() {
            return "Sculpture: " + title + ", carved from stone";
        }
    }

    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        System.out.println(p.describe());

        Sculpture s = new Sculpture("The Thinker II");
        System.out.println(s.describe());
    }
}

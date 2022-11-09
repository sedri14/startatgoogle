package Enums;

public enum Bird {

    HOUSE_SPARROW("Passer domesticus") {
        @Override
        public void sing() {
            System.out.println("I'm singing the House Sparrow way!");
        }
    },
    HYACINTH_MACAW("Anodorhynchus hyacinthinus") {
        @Override
        public void sing() {
            System.out.println("I'm singing the Hyacinth Macaw way!");
        }
    },
    INDIGO_BUNTING("Passerina cyanea") {
        @Override
        public void sing() {
            System.out.println("I'm singing the Indigo Bunting way!");

        }
    },
    LAUGHING_KOOKABURRA("Dacelo novaeguineae") {
        @Override
        public void sing() {
            System.out.println("I'm singing the Laughing Kookaburra way!");

        }
    };

    Bird(String scientificName) {
        this.scientificName = scientificName;
    }


    private final String scientificName;

    public abstract void sing();
}

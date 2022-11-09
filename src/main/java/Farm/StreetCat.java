package Farm;

 class StreetCat extends ForwardingCat{

      StreetCat(AbstractAnimal cat) {
         super();
     }

     void FindFoodInTrash() {
         System.out.println("looking for some food in the trash...");
     }
 }

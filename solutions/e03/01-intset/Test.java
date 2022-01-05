public class Test{

    public static void main(String[] args) {

        IntSet intSet = new IntSet();

        try{
            intSet.choose();
        }catch(EmptyException e){
            System.out.println("ok, founded empty exception");
        }

        intSet.addElement(3);
        intSet.addElement(5);
        intSet.addElement(7);
        intSet.addElement(8);

        System.out.println(intSet.toString());
        
        try{
            System.out.println(intSet.choose());
        }catch(Exception e){
            System.out.println("ERROR");
        }
        

    }
}
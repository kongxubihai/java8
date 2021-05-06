package demo1;

/**
 * 泛型方法
 */
public class GenericMethod {

    public static  <E> void print(E[] array){
        for ( E element : array ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1,2,3};
        String[] stringArray = {"xx", "oo", "xxoo"};

        print(intArray);
        print(stringArray);
    }
}

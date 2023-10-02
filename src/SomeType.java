import java.util.Collection;
import java.util.List;

public class SomeType <T>{


    public <E> void test(Collection<E> collection){
        for(E e: collection){
            System.out.println(e);
        }
    }

    public void test(List<Integer> integerList){
        for(Integer integer: integerList){

            // да, подтверждаю из ветки мастер, что мы инициируем конфликт
            System.out.println(integer);
        }
    }


}

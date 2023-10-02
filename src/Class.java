import javax.annotation.processing.Generated;
import java.io.*;
import java.util.Arrays;

public class Class implements Serializable {


    transient private final String name = "имя";

    private static String type;

    private int count;

    public Class(String type, int count) {
        this.count = count;
        Class.type = type;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        System.out.println("Сериализация");
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        System.out.println("Десериализация");
    }


    @Override
    public String toString() {
        return name + " " + type + " " + count;
    }

    public static void main(String[] args) {

        Class clazz = new Class("Тип", 35);


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        String fileName = "bytes for Class object";

        byte[] bytes;

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             byteArrayOutputStream);
             FileOutputStream fos = new FileOutputStream(fileName)) {
            oos.writeObject(clazz);
            bytes = byteArrayOutputStream.toByteArray();
            fos.write(bytes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Class deserializableClass = (Class) ois.readObject();
            System.out.println(deserializableClass);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
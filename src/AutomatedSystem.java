//package src;
//
//import java.lang.*;
//
//// ІП-21 Гордич О.Ю. Варіант 11
//
////-- Опис класу --
////Квітковий магазин:
////Ідентифікаційний номер,
////Найменування, Тип, Вид, Підвид, Ціна,
////Кількість.
////Конструктор, Методи доступу, Метод
////toString()
//
////-- Критерій для виведення інформації --
////1. Отримати список кімнатних рослин, що цвітуть, та їх ціну.
////2. Отримати список всіх підвидів заданої квітки та їх кількість.
//
//class Controller{
//    //ModelLayer md = new ModelLayer();
//    public static void execute(){
//        System.out.println("Enter command: ");
//    }
//}
//
//interface ModelLayer{
//    Flower getFlower();
//
//}
//
//class FileSystemLayer implements ModelLayer{
//
//    @Override
//    public Flower getFlower() {
//        return new Flower(1, "Daffodil",
//                "ee1",
//                "ee2",
//                "ee3",
//                80.00,
//                180,
//                true);
//    }
//}
//
//interface View{
//    void showFlower(Flower flower);
//}
//
//class ConsoleView implements View{
//
//    @Override
//    public void showFlower(Flower flower) {
//        System.out.println(flower);
//    }
//}
//
//public class AutomatedSystem {
//    public static void main(String[] args){
////        FlowerDAO dao = new FlowerDAO("flowers.csv");
////        List<Flower> list = dao.getAllFlowers();
////        System.out.println(list);
//
//    }
//}
//
//
//
//

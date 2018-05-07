# PATTERN Iterator!Interface Visitatore
Contiene 5 metodi per la visita dell'albero 
```javapublic interface Visitatore<T>{
    public boolean hasNextSx();
    public boolean hasNextDx();
    public T goSx();
    public T goDx();
    public T goRadice();
}```

## class newClass 
```java
  public class NewClass {
    public static void main(String[] args) {
        AlberoBin albero=new AlberoBin("prova.txt");
        Visitatore a=albero.getVisitatore();
        System.out.println(a.goRadice());
        System.out.println(a.goSx());
        System.out.println(a.goDx());
        System.out.println(a.goSx());
    }
}
```

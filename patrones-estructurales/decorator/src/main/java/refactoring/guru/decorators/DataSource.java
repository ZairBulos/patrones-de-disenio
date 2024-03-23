package refactoring.guru.decorators;

public interface DataSource {
    void writeData(String data);

    String readData();
}

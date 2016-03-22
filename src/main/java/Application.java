import ru.entity.Item;
import ru.handler.EntityHandler;
import ru.reader.AppReader;

import java.util.ArrayList;

public class Application {
    AppReader appreader;
    EntityHandler entityHandler;
    public Application(){
        init();
        ArrayList<Item> itemList = appreader.readFile();
        entityHandler.validate(itemList);
    }

    private void init() {
        appreader = new AppReader();
        entityHandler = new EntityHandler();
    }

    public static void main(String[] args){
        new Application();
    }
}

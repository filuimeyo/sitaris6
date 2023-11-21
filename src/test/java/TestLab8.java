import lab6sitaris.parser.Catalog;
import lab6sitaris.parser.Parser;
import lab6sitaris.parser.productfactory.ProductFactory;
import org.junit.Ignore;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestLab8 {

    private static Catalog actual;
    private static Catalog expected;
    private static Catalog nullCatalog;
    private static final ProductFactory factory = new ProductFactory();

    @BeforeAll
    static void loadResources(){
        nullCatalog = Parser.parseCatalog("D:\\sitaris\\lab6\\src\\main\\resources\\nullcatalog.xml");
        expected = Parser.parseCatalog("D:\\sitaris\\lab6\\src\\main\\resources\\products.xml");
        actual = new Catalog();
        actual.push(factory.createProduct(1, "Лёгкий успокаивающий крем с полынью Round Lab Mugwort Calming Cream 15 мл", "Abib", "Гидрофильное масло", 68.0));
        actual.push(factory.createProduct(2, "Гидрофильное масло Abib Pore Cleansing Oil Heartleaf Oil-Wash 210 мл", "Round Lab", "Крем для лица", 20.0));
        actual.push(factory.createProduct(3, "Палетка теней Romand Better Than Palette Light and Glitter Garden", "Romand", "Палетка теней", 91.5));

    }

    @Ignore
    @Test
    @Order(1)
    public void testProductsExist(){
        assertNotNull(expected.getProducts());
    }


    @Test
    @Order(2)
    public void testAvgPrice(){
        double expectedPrice = expected.average();
        double actualPrice = 0;
        for(double p : actual.getPrices()){
            actualPrice += p;
        }
        actualPrice /= actual.getPrices().size();
        assertEquals( expectedPrice, actualPrice,"средние цены не равны ");
    }

    @Test
    @Order(3)
    public void testEmptyFile() {
        assertNull(nullCatalog.getProducts(), "каталог должен быть пустым");
    }




}

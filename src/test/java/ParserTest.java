import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ParserTest {
    Parser p1, p2 ,p3, p4, p5;
    Parser p6;
//    public static void main(String[] args) {
//        Parser p = new Parser("/discover?query=İSTİKLAL+MAHKEMELERİ+ZABITLARI&rpp=10&filtertype_0=subject&filter_relational_operator_0=equals&filter_0=İstiklal+Mahkemeleri&filtertype=subject&filter_relational_operator=equals&filter=Tutanaklar");
//        System.out.println(p.printTokens());
//        System.out.println("Transaction: \t"+p.getTransactionType());
//        System.out.println("Query String: \t"+ p.getQueryString());
//    }
    @Before
    public void setUp(){
        p1 = new Parser("/discover?query=İSTİKLAL+MAHKEMELERİ+ZABITLARI&rpp=10&filtertype_0=subject&filter_relational_operator_0=equals&filter_0=İstiklal+Mahkemeleri&filtertype=subject&filter_relational_operator=equals&filter=Tutanaklar");
        p2 = new Parser("/discover?scope=11543/2113&query=Râşid+Aşkî&submit=Bul&filtertype_0=has_content_in_original_bundle&filter_relational_operator_0=contains&filter_0=&rpp=10");
        p3 = new Parser("/discover?query=Mehmet+Ali+yazicioglu&scope=/&filtertype=dateIssued&filter_relational_operator=equals&filter=[1900+TO+1999]");
        p4 = new Parser("/discover?scope=11543/1&query=Tefsiru+Molla+cami+++&submit=Bul");
        p5 = new Parser("/discover?rpp=100&etal=0&group_by=none&page=7&sort_by=score&order=desc&filtertype_0=subject&filter_relational_operator_0=equals&filter_0=Nadir+Eserler");
        p6 = new Parser("/discover?rpp=10&filtertype_0=subject&filtertype_1=subject&filter_relational_operator_1=equals&filter_relational_operator_0=equals&filter_1=Nadir+Eserler&filter_0=Türk+Edebiyatı&filtertype=subject&filter_relational_operator=equals&filter=Mizah");
    }

    @Test
    public void testTransactionText(){
        Assert.assertEquals("discover", p1.getTransactionType());
        Assert.assertEquals("discover", p2.getTransactionType());
        Assert.assertEquals("discover", p3.getTransactionType());
        Assert.assertEquals("discover", p4.getTransactionType());
    }

    @Test
    public void testQueryString(){
        Assert.assertArrayEquals(new String[]{"İSTİKLAL", "MAHKEMELERİ", "ZABITLARI"}, p1.getQueryString());
        Assert.assertArrayEquals(new String[]{"Râşid", "Aşkî"}, p2.getQueryString());
        Assert.assertArrayEquals(new String[]{"Mehmet", "Ali", "yazicioglu"}, p3.getQueryString());
        Assert.assertArrayEquals(new String[]{"Tefsiru", "Molla", "cami"}, p4.getQueryString());
    }

    @Test
    public void testEmptyQueryString(){
        Assert.assertArrayEquals(new String[]{""}, p5.getQueryString());
        Assert.assertArrayEquals(new String[]{""}, p6.getQueryString());
    }
}

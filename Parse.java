import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Parse {
    public ArrayList<String> BMW;


    public ArrayList<String> ParserFromWeb() throws IOException {
        String url = "https://auto.kufar.by/l/cars/bmw";
        Document page = Jsoup.parse(new URL(url), 3000);
        BMW = new ArrayList<>();
        Element all = page.select("div.styles_cards__iNIi9").first(); // выбираем нужную часть кода
        Elements bmw = all.select("div.styles_left__zNFFT"); // получаем данные о всех машинах

        // Марка и модель
        Elements names = bmw.select("h3[class=styles_title__A3M1R styles_ellipsis__xPYm_]");
        for (Element name : names) {
            String model = name.select("h3[class=styles_title__A3M1R styles_ellipsis__xPYm_]").text();
            BMW.add(model);
            /*System.out.print(model);
            System.out.println();*/
        }

        // Цена
        Elements prices = all.select("div.styles_price__PGuBm");
        for (Element price : prices) {
            String pric = price.select("div.styles_price__PGuBm").text();
            BMW.add(pric.substring(0, pric.length() - 1));
            /*System.out.print(pric.substring(0, pric.length() - 1));
            System.out.println();*/
        }

        // Регион
        Elements regions = bmw.select("p[class=styles_region__YbOS7]");
        for (Element region : regions) {
            String reg = region.select("p[class=styles_region__YbOS7]").text();
            BMW.add(reg);
            /*System.out.print(reg);
            System.out.println();*/
        }

        // Год и пробег
        Elements years = bmw.select("p[class=styles_params__f_CvZ styles_params--mobile__3TT80 styles_ellipsis__xPYm_]");
        for (Element year : years) {
            String ye = year.select("p[class=styles_params__f_CvZ styles_params--mobile__3TT80 styles_ellipsis__xPYm_]").text();
            BMW.add(ye);
            /*System.out.print(ye);
            System.out.println();*/
        }

        // КПП, объем двигателя, тип двигателя, кузов
        Elements options = bmw.select("p[class=styles_params__f_CvZ styles_ellipsis__xPYm_]");
        for (Element option : options) {
            String opt = option.select("p[class=styles_params__f_CvZ styles_ellipsis__xPYm_]").text();
            BMW.add(opt);
            /*System.out.print(opt);
            System.out.println();*/
        }
        return BMW;
    }
}

package org.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        }
        String json = jsonBuilder.toString();
        int[] numbers = Arrays.stream(json.substring(1, json.length() - 1).split(","))
                .mapToInt(Integer::parseInt)
                .filter(number -> number > 5)
                .toArray();
        int sum = IntStream.of(numbers).sum();
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(Integer.toString(sum));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String htmlContent = "<html>\n"
                + "<head>\n"
                + "<title>Holiday<3</title>\n"
                + "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1 style=\"text-transform: uppercase;\n" +
                "  background: linear-gradient(45deg, #FF1493,#FFC0CB 66%, #FFC0CB 33%);\n" +
                "  -webkit-background-clip: text;\n" +
                "  -webkit-text-fill-color: transparent;\n" +
                "  color: #FF1493;margin: 20px auto;\n" +
                "  text-align: center;\"> Мой любимый праздник </h1>\n"
                + "<img src=\"https://avatars.dzeninfra.ru/get-zen_doc/5231507/pub_61b28feb1448295fab2dd28f_61b2908c97207915ae2bc5b7/scale_1200\"\n" +
                "     style=\"width: 30%; float:left; margin: 20px 20px 20px 0\" >\n"
                + "<div style=\"color: hotpink\">\n" +
                "    <p> Мой любимый праздник отмечается 14 февраля.\n" +
                "        И это не день влюбленных, а день компьютерщика.\n" +
                "        Что это за праздник? 14 февраля 1946 года научному миру и всем заинтересованным был продемонстрирован первый реально\n" +
                "        работающий электронный компьютер ENIAC I (Electrical Numerical Integrator And Calculator).\n" +
                "        ENIAC I проработал до 23 часов 45 минут 2 октября 1955 года, а потом был разобран.\n" +
                "        Работы по разработке первой вычислительной машины спонсировались американской армией,\n" +
                "        которой компьютер был необходим для обсчета баллистических таблиц.\n" +
                "        В армии были отделы, занимающиеся обсчетом баллистических таблиц для нужд артиллерии и авиации.\n" +
                "        Работали в этих отделах люди на должности Армейского Калькулятора.\n" +
                "        Естественно, мощности и производительности этих «вычислительных ресурсов» армии не хватало.\n" +
                "        Поэтому кибернетики в начале 1943 года приступили к разработке концепции нового вычислительного\n" +
                "        устройства — компьютера ENIAC. Он стал первым реально работающим на практических задачах компьютером.\n" +
                "        Между прочим, именно от ENIACа современные компьютеры унаследовали двоичную систему счисления.\n" +
                "        Именно поэтому 14 февраля отмечается праздник — День компьютерщика.\n" +
                "    </p>\n" +
                "    <p> Почему именно он? </p>\n" +
                "    <ul>\n" +
                "        <li>Я считаю себя больше компьютерщиком, а не программистом, потому что включать компьютеры у меня получается лучше чем писать код</li>\n" +
                "        <li>Компьютерщик звучит круче чем программист</li>\n" +
                "        <li>Нужно же хоть что-то праздновать, пока все твои друзья проводят время со своими парами</li>\n" +
                "    </ul>\n" +
                "</div>\n"
                + "<div style=\"width: 100px; height: 80px\">\n" +
                "\n" +
                "</div>\n"
                + "<div style=\"color: hotpink\">\n" +
                "    <p> Теперь разберемся почему 14 февраля лучше отмечать день компьютерщика, а не день всех влюбленных.</p>\n" +
                "    <table cellspacing=\"5\" cellpadding=\"10\" border=\"2\">\n" +
                "        <caption style=\"color: deeppink\">Сравнение двух праздников</caption>\n" +
                "        <thead>\n" +
                "        <tr>\n" +
                "            <th>День компьютерщика</th>\n" +
                "            <th>День влюбленных</th>\n" +
                "        </tr>\n" +
                "        </thead>\n" +
                "        <tbody>\n" +
                "        <tr>\n" +
                "            <td>Компьютерами пользуются все</td>\n" +
                "            <td>Отношения есть не у всех</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>С компьютером нельзя поссориться</td>\n" +
                "            <td>С партнером можно поссориться</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Компьютер покупается один раз</td>\n" +
                "            <td>Отношения - постоянные вложения</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Мвидео пока не закрылся</td>\n" +
                "            <td>Tinder ушел из России, а значит пару найти сложнее</td>\n" +
                "        </tr>\n"
                + "</tbody>\n" +
                "    </table>\n" +
                "<p>Как показывает сравнение, компьютеры лучше, а значит свое предпочтение нужно отдать празднованию дня компьютерщика.Если у вас пока нет компьютера, вы можете выбрать любой понравившийся <a href=\"https://hyperpc.ru/gaming-pc\">здесь</a>.Если у вас нет пары, у меня нет советов.\n + Однако если у вас нет пары, но есть компьютер, не расстраивайтесь, ведь вы можете послушать классную музыку! + </p>\n" +
                "    <audio controls style=\"display: block;\n" +
                "  width: 100%;\n" +
                "  height: 81%;\n" +
                "  margin-top: 0.125rem;\n" +
                "  border: none;\n" +
                "  color: #0095dd;\n" +
                "  -moz-border-radius: 2px;\n" +
                "  -webkit-border-radius: 2px;\n" +
                "  border-radius: 2px;\">\n" +
                "        <source src=\"https://cdn.drivemusic.me/dl/online/xAL0WNrszD0EQ7NuTbV8FQ/1695003164/download_music/2022/08/saluki-ognejj.mp3\">\n" +
                "    </audio>\n" +
                "    <p> P.S.Данная страница является приколом</p>\n" +
                "\n" +
                "\n" +
                "</div>\n"
                + "</body>\n"
                + "</html>";
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(htmlContent);
    }
}

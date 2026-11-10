package com.webserver;

public class HttpResponse {

    public static String getHtmlContent(String studentName, String studentId) {
        return "<html>\r\n" +
                "<head>\r\n" +
                "    <meta charset=\"UTF-8\">\r\n" +
                "    <title>Java Web Sunucusu - OOP Ödevi</title>\r\n" +
                "    <style>\r\n" +
                "        body {\r\n" +
                "            background-color: #120d1a;\r\n" +
                "            color: #e0d6eb;\r\n" +
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\r\n" +
                "            text-align: center;\r\n" +
                "            padding-top: 50px;\r\n" +
                "        }\r\n" +
                "        .container {\r\n" +
                "            background-color: #1f162e;\r\n" +
                "            border: 2px solid #8a2be2;\r\n" +
                "            border-radius: 15px;\r\n" +
                "            display: inline-block;\r\n" +
                "            padding: 40px;\r\n" +
                "            box-shadow: 0 0 20px rgba(138, 43, 226, 0.5);\r\n" +
                "        }\r\n" +
                "        h1 { color: #da70d6; margin-bottom: 10px; }\r\n" +
                "        h2 { color: #ba55d3; font-size: 1.2em; margin-top: 0; }\r\n" +
                "        p { color: #d8bfd8; line-height: 1.6; max-width: 400px; margin: 20px auto 0; }\r\n" +
                "    </style>\r\n" +
                "</head>\r\n" +
                "<body>\r\n" +
                "    <div class=\"container\">\r\n" +
                "        <h1>" + studentName + "</h1>\r\n" +
                "        <h2>Öğrenci No: " + studentId + "</h2>\r\n" +
                "        <hr style=\"border: 0.5px solid #4b0082;\">\r\n" +
                "        <p>Merhaba! Ben Yazılım Mühendisliği öğrencisiyim. " +
                "Saf Java soket programlama kullanarak geliştirdiğim bu HTTP sunucusu üzerinden " +
                "nesne yönelimli programlama pratiklerimi sergiliyorum.</p>\r\n" +
                "    </div>\r\n" +
                "</body>\r\n" +
                "</html>\r\n";
    }
}
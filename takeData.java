import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

import java.io.*;

import java.net.URL;

import java.nio.charset.StandardCharsets;



public class takeData {

    public static void main(String[] args) throws IOException {

        String[] p_name = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        String[] pre_star_branch=new String[20];
        String[] p_star_branch = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        String[] p_main_contributors = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};

        String url = "https://github.com/trending/python?since=monthly&spoken_language_code=en";
        Document document = Jsoup.parse(new URL(url), 30000);
        Elements elements = document.getElementsByClass("h3 lh-condensed");
        Elements elements1 = document.getElementsByClass("muted-link d-inline-block mr-3");
        Elements elements2 = document.getElementsByClass("avatar mb-1 avatar-user");

        for (int i = 0; i < 10; i++) {
            p_name[i] = elements.get(i).text() + ",";
            p_name[i]=p_name[i].replaceAll(" ","");
            //System.out.println(p_name[i]);
        }


        for(int i=0;i<20;i++) {
             pre_star_branch[i] = elements1.get(i).text();
           pre_star_branch[i]=pre_star_branch[i].replaceAll(",","");
        }

        for (int i=0;i<10;i++){
            p_star_branch[i]="stargazer:"+pre_star_branch[i*2]+",";
        }

        for (int i=0;i<10;i++){
            p_star_branch[i]=p_star_branch[i]+"forks:"+pre_star_branch[i*2+1]+",";
        }

        for (int i = 0; i < 10; i++) {
            for (int j = i * 5, k = j + 5; j < k; j++) {
                p_main_contributors[i] = p_main_contributors[i] + elements2.get(j).attr("alt") + ",";
            }
        }

        File otfile = new File("src/main/resources/data.csv");      //data.csv文件生成路径

        FileOutputStream fos = null;
        fos = new FileOutputStream("data.csv");
        for (int i = 0; i < 10; i++) {
            byte[] array = p_name[i].getBytes(StandardCharsets.UTF_8);
            byte[] array1 = p_star_branch[i].getBytes(StandardCharsets.UTF_8);
            byte[] array2 = p_main_contributors[i].getBytes(StandardCharsets.UTF_8);
            fos.write(array);
            fos.write(array1);
            fos.write(array2);

            fos.write("\r\n".getBytes(StandardCharsets.UTF_8));   //换行
        }
        fos.close();

    }
}


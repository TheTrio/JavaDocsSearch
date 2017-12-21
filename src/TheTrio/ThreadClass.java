package TheTrio;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

public class ThreadClass extends Thread {

    private String url;
    private String search;

    public ThreadClass(String url, String search){
        this.url = url;
        this.search = search;
    }
    public void start(){
        try {
            System.out.println("Done");
            Document document = Jsoup.connect(url).get();
            Optional<Element> z = document.getElementsByTag("a").stream().filter(e->e.text().equalsIgnoreCase(search)).findFirst();
            if(z.isPresent()){
                java.awt.Desktop.getDesktop().browse(new URI("https://docs.oracle.com/javase/8/docs/api/" + z.get().attr("href")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

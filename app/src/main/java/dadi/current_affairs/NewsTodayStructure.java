package dadi.current_affairs;

/**
 * Created by Srinivas on 4/29/2017.
 */

public class NewsTodayStructure {
    String author,title,description,url,urlToImage,publishedAt;
    public NewsTodayStructure(String author, String title,String description,String url,String urlToImage,String publishedAt) {
        this.author = author;this.title=title;this.description=description;this.url=url;this.urlToImage = urlToImage;
        this.publishedAt=publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
}

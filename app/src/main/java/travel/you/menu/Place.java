package travel.you.menu;

import java.util.List;

public class Place{

    String name = null;
    int rate = 0;
    String price = null;
    List<String> tags = null;
    String pic = null;

    public Place(String name, int rate, String price, List<String> tags, String pic) {
        this.name = name;
        this.rate = rate;
        this.price = price;
        this.tags = tags;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
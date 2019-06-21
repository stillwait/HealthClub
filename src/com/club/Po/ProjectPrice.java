package com.club.Po;

import java.util.List;

/**
 * Created by Administrator on 2019-04-26.
 */
public class ProjectPrice extends Project {
    private List<Price> price;

    public ProjectPrice() {
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "price=" + price +
                '}';
    }

    public ProjectPrice(List<Price> price) {
        this.price = price;
    }

    public ProjectPrice(String proName, String proDescribe, String proDate, List<Price> price) {
        super(proName, proDescribe, proDate);
        this.price = price;
    }

    public ProjectPrice(int proId, String proName, String proDescribe, String proDate, List<Price> price) {
        super(proId, proName, proDescribe, proDate);
        this.price = price;
    }

    public List<Price> getPrice() {
        return price;
    }

    public void setPrice(List<Price> price) {
        this.price = price;
    }
}

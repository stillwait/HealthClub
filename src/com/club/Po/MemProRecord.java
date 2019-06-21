package com.club.Po;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019-04-25.
 */
public class MemProRecord extends MemProject {
    private List<Member> members;
    private Project project;
    private Price price;

    public MemProRecord() {
    }

    @Override
    public String toString() {
        return "MemProRecord{" +
                "id=" + super.getId() +
                ", memId=" + super.getMemId() +
                ", proId=" + super.getProId() +
                ", realMoney=" + super.getRealMoney() +
                ", priceId=" + super.getPriceId() +
                ", proDate=" + super.getProDate() +
                ", members=" + members +
                ", project=" + project +
                ", price=" + price +
                '}';
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
